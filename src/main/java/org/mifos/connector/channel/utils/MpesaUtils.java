package org.mifos.connector.channel.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class MpesaUtils {

    public static String mpesaChannelRequestToChannelRequestConvertor(String channelRequest) {

        JSONObject mpesaChannelRequestJson = new JSONObject();

        JSONObject channelRequestJson = new JSONObject(channelRequest);

        JSONObject amountJson = channelRequestJson.getJSONObject("amount");
        JSONArray payerArray = channelRequestJson.getJSONArray("payer");

        // setting amount json
        mpesaChannelRequestJson.put("amount", amountJson);

        String payer;
        String payee;

        // payer payee conversion
        if( ((JSONObject) payerArray.get(0)).getString("key").equals("MSISDN") ) {
            // case when 0th index is MSISDN
            String msisdn = ((JSONObject) payerArray.get(0)).getString("value");
            String accountId = ((JSONObject) payerArray.get(1)).getString("value");

            payer = ((JSONObject) payerArray.get(0)).getString("key") + " " + msisdn;
            payee = ((JSONObject) payerArray.get(1)).getString("key") + " " + accountId;
        } else {
            // case when 0th index is ACCOUNTID
            String msisdn = ((JSONObject) payerArray.get(1)).getString("value");
            String accountId = ((JSONObject) payerArray.get(0)).getString("value");

            payer = ((JSONObject) payerArray.get(1)).getString("key") + " " + msisdn;
            payee = ((JSONObject) payerArray.get(0)).getString("key") + " " + accountId;
        }

        // setting payer and payee
        mpesaChannelRequestJson.put("payer", getPartyInfoJson(
                payer.split(" ")[0], payer.split(" ")[1]
        ));

        mpesaChannelRequestJson.put("payee", getPartyInfoJson(
                payee.split(" ")[0], payee.split(" ")[1]
        ));


        return mpesaChannelRequestJson.toString();
    }

    public static JSONObject getPartyInfoJson(String partyIdType, String partyIdentifier) {
        JSONObject partyIdInfo = new JSONObject();
        partyIdInfo.put("partyIdType", partyIdType);
        partyIdInfo.put("partyIdentifier", partyIdentifier);

        JSONObject party = new JSONObject();
        party.put("partyIdInfo", partyIdInfo);

        return party;
    }

}
