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

import java.time.LocalDate;


public class ClientTimelineData {

    private LocalDate submittedOnDate;
    private String submittedByUsername;
    private String submittedByFirstname;
    private String submittedByLastname;

    private LocalDate activatedOnDate;
    private String activatedByUsername;
    private String activatedByFirstname;
    private String activatedByLastname;

    private LocalDate closedOnDate;
    private String closedByUsername;
    private String closedByFirstname;
    private String closedByLastname;

    public LocalDate getSubmittedOnDate() {
        return submittedOnDate;
    }

    public void setSubmittedOnDate(LocalDate submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }

    public String getSubmittedByUsername() {
        return submittedByUsername;
    }

    public void setSubmittedByUsername(String submittedByUsername) {
        this.submittedByUsername = submittedByUsername;
    }

    public String getSubmittedByFirstname() {
        return submittedByFirstname;
    }

    public void setSubmittedByFirstname(String submittedByFirstname) {
        this.submittedByFirstname = submittedByFirstname;
    }

    public String getSubmittedByLastname() {
        return submittedByLastname;
    }

    public void setSubmittedByLastname(String submittedByLastname) {
        this.submittedByLastname = submittedByLastname;
    }

    public LocalDate getActivatedOnDate() {
        return activatedOnDate;
    }

    public void setActivatedOnDate(LocalDate activatedOnDate) {
        this.activatedOnDate = activatedOnDate;
    }

    public String getActivatedByUsername() {
        return activatedByUsername;
    }

    public void setActivatedByUsername(String activatedByUsername) {
        this.activatedByUsername = activatedByUsername;
    }

    public String getActivatedByFirstname() {
        return activatedByFirstname;
    }

    public void setActivatedByFirstname(String activatedByFirstname) {
        this.activatedByFirstname = activatedByFirstname;
    }

    public String getActivatedByLastname() {
        return activatedByLastname;
    }

    public void setActivatedByLastname(String activatedByLastname) {
        this.activatedByLastname = activatedByLastname;
    }

    public LocalDate getClosedOnDate() {
        return closedOnDate;
    }

    public void setClosedOnDate(LocalDate closedOnDate) {
        this.closedOnDate = closedOnDate;
    }

    public String getClosedByUsername() {
        return closedByUsername;
    }

    public void setClosedByUsername(String closedByUsername) {
        this.closedByUsername = closedByUsername;
    }

    public String getClosedByFirstname() {
        return closedByFirstname;
    }

    public void setClosedByFirstname(String closedByFirstname) {
        this.closedByFirstname = closedByFirstname;
    }

    public String getClosedByLastname() {
        return closedByLastname;
    }

    public void setClosedByLastname(String closedByLastname) {
        this.closedByLastname = closedByLastname;
    }
}