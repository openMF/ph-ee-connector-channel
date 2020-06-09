/*
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 *
 *  https://mozilla.org/MPL/2.0/.
 */
package org.mifos.connector.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ContextUtil {

    private final static SimpleDateFormat LOCAL_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    private final static DecimalFormat AMOUNT_FORMAT = new DecimalFormat("#.####");
    private final static SimpleDateFormat DATE_HEADER_FORMATTER = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    public static LocalDateTime parseDate(String date) {
        if (date == null)
            return null;
        try {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(LOCAL_DATE_TIME_FORMAT.parse(date).getTime()), ZoneOffset.UTC);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static LocalDateTime parseMojaDate(String date) {
        if (date == null)
            return null;
        try {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(DATE_HEADER_FORMATTER.parse(date).getTime()), ZoneOffset.UTC);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String formatToDateHeader(long date) {
        DATE_HEADER_FORMATTER.setTimeZone(TimeZone.getTimeZone("GMT"));
        return DATE_HEADER_FORMATTER.format(Date.from(Instant.ofEpochMilli(date)));
    }

    public static String formatDate(LocalDateTime date) {
        return date == null ? null : LOCAL_DATE_TIME_FORMAT.format(Date.from(date.toInstant(ZoneOffset.UTC)));
    }

    public static BigDecimal parseAmount(String amount) {
        return amount == null ? null : new BigDecimal(amount);
    }

    public static String formatAmount(BigDecimal amount) {
        return amount == null ? null : AMOUNT_FORMAT.format(amount);
    }
}
