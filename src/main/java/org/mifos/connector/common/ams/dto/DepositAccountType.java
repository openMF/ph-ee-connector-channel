/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.mifos.connector.common.ams.dto;

public enum DepositAccountType {

    INVALID(0, "depositAccountType.invalid"), //
    SAVINGS_DEPOSIT(100, "depositAccountType.savingsDeposit"), //
    FIXED_DEPOSIT(200, "depositAccountType.fixedDeposit"), //
    RECURRING_DEPOSIT(300, "depositAccountType.recurringDeposit"), //
    CURRENT_DEPOSIT(400, "depositAccountType.currentDeposit");

    private final Integer value;
    private final String code;

    DepositAccountType(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }
}