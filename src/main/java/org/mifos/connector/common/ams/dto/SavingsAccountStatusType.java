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

public enum SavingsAccountStatusType {

    INVALID(0, "savingsAccountStatusType.invalid"), //
    SUBMITTED_AND_PENDING_APPROVAL(100, "savingsAccountStatusType.submitted.and.pending.approval"), //
    APPROVED(200, "savingsAccountStatusType.approved"), //
    ACTIVE(300, "savingsAccountStatusType.active"), //
    TRANSFER_IN_PROGRESS(303, "savingsAccountStatusType.transfer.in.progress"), //
    TRANSFER_ON_HOLD(304, "savingsAccountStatusType.transfer.on.hold"), //
    WITHDRAWN_BY_APPLICANT(400, "savingsAccountStatusType.withdrawn.by.applicant"), //
    REJECTED(500, "savingsAccountStatusType.rejected"), //
    CLOSED(600, "savingsAccountStatusType.closed"), PRE_MATURE_CLOSURE(700, "savingsAccountStatusType.pre.mature.closure"), MATURED(800,
            "savingsAccountStatusType.matured");

    private final Integer value;
    private final String code;

    SavingsAccountStatusType(final Integer value, final String code) {
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