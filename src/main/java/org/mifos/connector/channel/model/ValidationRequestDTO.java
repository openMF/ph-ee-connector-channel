package org.mifos.connector.channel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ValidationRequestDTO {
        @JsonProperty("primaryIdentifier")
        public PrimaryIdentifier getPrimaryIdentifier() {
            return this.primaryIdentifier; }
        public void setPrimaryIdentifier(PrimaryIdentifier primaryIdentifier) {
            this.primaryIdentifier = primaryIdentifier; }
        PrimaryIdentifier primaryIdentifier;
        @JsonProperty("secondaryIdentifier")
        public SecondaryIdentifier getSecondaryIdentifier() {
            return this.secondaryIdentifier; }
        public void setSecondaryIdentifier(SecondaryIdentifier secondaryIdentifier) {
            this.secondaryIdentifier = secondaryIdentifier; }
        SecondaryIdentifier secondaryIdentifier;
        @JsonProperty("customData")
        public ArrayList<CustomData> getCustomData() {
            return this.customData; }
        public void setCustomData(ArrayList<CustomData> customData) {
            this.customData = customData; }
        ArrayList<CustomData> customData;

    public static class CustomData{
        @JsonProperty("key")
        public String getKey() {
            return this.key; }
        public void setKey(String key) {
            this.key = key; }
        String key;
        @JsonProperty("value")
        public String getValue() {
            return this.value; }
        public void setValue(String value) {
            this.value = value; }
        String value;
    }

    public static class PrimaryIdentifier{
        @JsonProperty("key")
        public String getKey() {
            return this.key; }
        public void setKey(String key) {
            this.key = key; }
        String key;
        @JsonProperty("value")
        public String getValue() {
            return this.value; }
        public void setValue(String value) {
            this.value = value; }
        String value;
    }

    public static class SecondaryIdentifier{
        @JsonProperty("key")
        public String getKey() {
            return this.key; }
        public void setKey(String key) {
            this.key = key; }
        String key;
        @JsonProperty("value")
        public String getValue() {
            return this.value; }
        public void setValue(String value) {
            this.value = value; }
        String value;
    }


}
