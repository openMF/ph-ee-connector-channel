/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.mifos.connector.common.ams.dto;

public class Customer {

  private String identifier;
  private LegalForm type;
  private String givenName;
  private String middleName;
  private String surname;
  private DateOfBirth dateOfBirth;
  private Boolean member;
  private String accountBeneficiary;
  private String referenceCustomer;
  private String assignedOffice;
  private String assignedEmployee;
  private Address address;
  private CustomerState currentState;
  private String applicationDate;
  private String createdBy;
  private String createdOn;
  private String lastModifiedBy;
  private String lastModifiedOn;

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public LegalForm getType() {
    return type;
  }

  public void setType(LegalForm type) {
    this.type = type;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public DateOfBirth getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Boolean getMember() {
    return member;
  }

  public void setMember(Boolean member) {
    this.member = member;
  }

  public String getAccountBeneficiary() {
    return accountBeneficiary;
  }

  public void setAccountBeneficiary(String accountBeneficiary) {
    this.accountBeneficiary = accountBeneficiary;
  }

  public String getReferenceCustomer() {
    return referenceCustomer;
  }

  public void setReferenceCustomer(String referenceCustomer) {
    this.referenceCustomer = referenceCustomer;
  }

  public String getAssignedOffice() {
    return assignedOffice;
  }

  public void setAssignedOffice(String assignedOffice) {
    this.assignedOffice = assignedOffice;
  }

  public String getAssignedEmployee() {
    return assignedEmployee;
  }

  public void setAssignedEmployee(String assignedEmployee) {
    this.assignedEmployee = assignedEmployee;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public CustomerState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(CustomerState currentState) {
    this.currentState = currentState;
  }

  public String getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(String applicationDate) {
    this.applicationDate = applicationDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public String getLastModifiedOn() {
    return lastModifiedOn;
  }

  public void setLastModifiedOn(String lastModifiedOn) {
    this.lastModifiedOn = lastModifiedOn;
  }
}
