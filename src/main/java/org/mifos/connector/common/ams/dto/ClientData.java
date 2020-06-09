/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.mifos.connector.common.ams.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;


public class ClientData {

    private Long id;
    private String accountNo;
    private String externalId;
    private EnumOptionData status, legalForm;
    private CodeValueData subStatus;
    private Boolean active;
    private LocalDate activationDate;
    private String firstname;
    private String middlename;
    private String lastname;
    private String fullname;
    private String displayName;
    private String mobileNo;
    private String emailAddress;
    private LocalDate dateOfBirth;
    private CodeValueData gender;
    private CodeValueData clientType;
    private CodeValueData clientClassification;
    @JsonProperty(value="isStaff")
    private Boolean isStaff;
    private Long officeId;
    private String officeName;
    private Long transferToOfficeId;
    private String transferToOfficeName;
    private Long imageId;
    private Boolean imagePresent;
    private Long staffId;
    private String staffName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public EnumOptionData getStatus() {
        return status;
    }

    public void setStatus(EnumOptionData status) {
        this.status = status;
    }

    public EnumOptionData getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(EnumOptionData legalForm) {
        this.legalForm = legalForm;
    }

    public CodeValueData getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(CodeValueData subStatus) {
        this.subStatus = subStatus;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CodeValueData getGender() {
        return gender;
    }

    public void setGender(CodeValueData gender) {
        this.gender = gender;
    }

    public CodeValueData getClientType() {
        return clientType;
    }

    public void setClientType(CodeValueData clientType) {
        this.clientType = clientType;
    }

    public CodeValueData getClientClassification() {
        return clientClassification;
    }

    public void setClientClassification(CodeValueData clientClassification) {
        this.clientClassification = clientClassification;
    }

    public Boolean getStaff() {
        return isStaff;
    }

    public void setStaff(Boolean staff) {
        isStaff = staff;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Long getTransferToOfficeId() {
        return transferToOfficeId;
    }

    public void setTransferToOfficeId(Long transferToOfficeId) {
        this.transferToOfficeId = transferToOfficeId;
    }

    public String getTransferToOfficeName() {
        return transferToOfficeName;
    }

    public void setTransferToOfficeName(String transferToOfficeName) {
        this.transferToOfficeName = transferToOfficeName;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Boolean getImagePresent() {
        return imagePresent;
    }

    public void setImagePresent(Boolean imagePresent) {
        this.imagePresent = imagePresent;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}