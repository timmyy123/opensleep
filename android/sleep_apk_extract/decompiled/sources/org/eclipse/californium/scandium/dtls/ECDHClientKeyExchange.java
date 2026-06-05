package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.util.Arrays;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class ECDHClientKeyExchange extends ClientKeyExchange {
    private final byte[] encodedPoint;

    public ECDHClientKeyExchange(byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        if (bArr != null) {
            this.encodedPoint = bArr;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("encoded point cannot be null");
            throw null;
        }
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        return new ECDHClientKeyExchange(readEncodedPoint(datagramReader), inetSocketAddress);
    }

    public static byte[] readEncodedPoint(DatagramReader datagramReader) {
        return datagramReader.readBytes(datagramReader.read(8));
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        writeFragment(datagramWriter);
        return datagramWriter.toByteArray();
    }

    public byte[] getEncodedPoint() {
        byte[] bArr = this.encodedPoint;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.encodedPoint.length + 1;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return super.toString() + "\t\tDiffie-Hellman public value: " + StringUtil.byteArray2HexString(this.encodedPoint) + StringUtil.lineSeparator();
    }

    public void writeFragment(DatagramWriter datagramWriter) {
        datagramWriter.write(this.encodedPoint.length, 8);
        datagramWriter.writeBytes(this.encodedPoint);
    }
}
