/*
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 *
 *  https://mozilla.org/MPL/2.0/.
 */
package org.mifos.connector.common.mojaloop.ilp;

import org.interledger.InterledgerAddress;
import org.interledger.codecs.CodecContext;
import org.interledger.codecs.oer.OerIA5StringCodec;
import org.interledger.codecs.oer.OerOctetStringCodec;
import org.interledger.codecs.packettypes.InterledgerPacketType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;


public class InterledgerPaymentOerCodec implements InterledgerPaymentCodec {
    public InterledgerPaymentOerCodec() {
    }

    public InterledgerPayment read(CodecContext context, InputStream inputStream) throws IOException {
        Objects.requireNonNull(context);
        Objects.requireNonNull(inputStream);
        String destinationAmount = context.read(OerIA5StringCodec.OerIA5String.class, inputStream).getValue();
        InterledgerAddress destinationAccount = context.read(InterledgerAddress.class, inputStream);
        byte[] data = context.read(OerOctetStringCodec.OerOctetString.class, inputStream).getValue();
        return InterledgerPayment.builder().destinationAmount(destinationAmount).destinationAccount(destinationAccount).data(data).build();
    }

    public void write(CodecContext context, InterledgerPayment instance, OutputStream outputStream) throws IOException {
        Objects.requireNonNull(context);
        Objects.requireNonNull(instance);
        Objects.requireNonNull(outputStream);
        context.write(InterledgerPacketType.class, this.getTypeId(), outputStream);
        context.write(OerIA5StringCodec.OerIA5String.class, new OerIA5StringCodec.OerIA5String(instance.getDestinationAmount()), outputStream);
        context.write(InterledgerAddress.class, instance.getDestinationAccount(), outputStream);
        context.write(OerOctetStringCodec.OerOctetString.class, new OerOctetStringCodec.OerOctetString(instance.getData()), outputStream);
    }
}
