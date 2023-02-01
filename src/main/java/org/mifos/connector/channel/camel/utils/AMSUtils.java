package org.mifos.connector.channel.camel.utils;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class AMSUtils {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AMSProps amsProps;

    List<AMSProps.AMS> ams;

    public AMSUtils(){
    }

    @PostConstruct
    public List<AMSProps.AMS> postConstruct(){
       ams  =  amsProps.getGroups();
       return ams;
    }
    public String getAMSName(JSONObject body)
    {
        String primaryIdentifierName= body.getJSONObject("primaryIdentifier").getString("key");
        String secondaryIdentifierName = body.getJSONObject("secondaryIdentifier").getString("key");
        String primaryIdentifierVal = body.getJSONObject("primaryIdentifier").getString("value");
        String secondaryIdentifierVal = body.getJSONObject("primaryIdentifier").getString("value");
        String finalAmsVal="value";
        for ( AMSProps.AMS amsIdentifier : postConstruct()) {
            logger.info("KEY VALUE PAIR : " + amsIdentifier.getIdentifier() + " " + amsIdentifier.getValue());
            String identifier = amsIdentifier.getIdentifier();
            if (identifier.equalsIgnoreCase(secondaryIdentifierName)) {
                finalAmsVal = amsIdentifier.getValue();
                logger.info("Assigned from secondary" + finalAmsVal);
                break;
            }
            else if(identifier.equalsIgnoreCase(primaryIdentifierName)){
                finalAmsVal = amsIdentifier.getValue();
                String temp = primaryIdentifierVal;
                primaryIdentifierVal = secondaryIdentifierVal;
                secondaryIdentifierVal = temp;
                logger.info("Assigned from primary" + finalAmsVal);
                break;
            }
            else {
                if(identifier.equalsIgnoreCase("default")){
                    finalAmsVal = amsIdentifier.getDefaultValue();
                    logger.info("Assigned default from secondary" + finalAmsVal);
                }
            }
        }//end for loop
        logger.info("Identifier name and value {} : {} ",primaryIdentifierName,primaryIdentifierVal);
        return finalAmsVal;
    }

    public void mapTransactionId(String mpesaTransactionId, String transactionId) {

    }
}




