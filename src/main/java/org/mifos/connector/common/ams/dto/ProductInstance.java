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

import java.util.Set;

public class ProductInstance {

  private String customerIdentifier;
  private String productIdentifier;
  private String accountIdentifier;
  private String alternativeAccountNumber;
  private Set<String> beneficiaries;
  private String openedOn;
  private String lastTransactionDate;
  private String state;
  private Double balance;

  public String getCustomerIdentifier() {
    return customerIdentifier;
  }

  public void setCustomerIdentifier(String customerIdentifier) {
    this.customerIdentifier = customerIdentifier;
  }

  public String getProductIdentifier() {
    return productIdentifier;
  }

  public void setProductIdentifier(String productIdentifier) {
    this.productIdentifier = productIdentifier;
  }

  public String getAccountIdentifier() {
    return accountIdentifier;
  }

  public void setAccountIdentifier(String accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  public String getAlternativeAccountNumber() {
    return alternativeAccountNumber;
  }

  public void setAlternativeAccountNumber(String alternativeAccountNumber) {
    this.alternativeAccountNumber = alternativeAccountNumber;
  }

  public Set<String> getBeneficiaries() {
    return beneficiaries;
  }

  public void setBeneficiaries(Set<String> beneficiaries) {
    this.beneficiaries = beneficiaries;
  }

  public String getOpenedOn() {
    return openedOn;
  }

  public void setOpenedOn(String openedOn) {
    this.openedOn = openedOn;
  }

  public String getLastTransactionDate() {
    return lastTransactionDate;
  }

  public void setLastTransactionDate(String lastTransactionDate) {
    this.lastTransactionDate = lastTransactionDate;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }
}
