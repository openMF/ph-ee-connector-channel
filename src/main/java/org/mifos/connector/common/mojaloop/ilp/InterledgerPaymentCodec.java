/*
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 *
 *  https://mozilla.org/MPL/2.0/.
 */
package org.mifos.connector.common.mojaloop.ilp;


import org.interledger.codecs.InterledgerPacketCodec;
import org.interledger.codecs.packettypes.InterledgerPacketType;
import org.interledger.codecs.packettypes.PaymentPacketType;

public interface InterledgerPaymentCodec extends InterledgerPacketCodec<InterledgerPayment> {
    InterledgerPacketType TYPE = new PaymentPacketType();

    default InterledgerPacketType getTypeId() {
        return TYPE;
    }
}
