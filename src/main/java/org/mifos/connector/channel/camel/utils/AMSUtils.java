package org.mifos.connector.channel.camel.utils;


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


}




