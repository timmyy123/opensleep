package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.AlertMessage;

/* JADX INFO: loaded from: classes5.dex */
public final class ChangeCipherSpecMessage extends AbstractMessage {
    private final CCSType CCSProtocolType;

    public enum CCSType {
        CHANGE_CIPHER_SPEC(1);

        private int code;

        CCSType(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public ChangeCipherSpecMessage(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.CCSProtocolType = CCSType.CHANGE_CIPHER_SPEC;
    }

    public static DTLSMessage fromByteArray(byte[] bArr, InetSocketAddress inetSocketAddress) throws HandshakeException {
        int i = new DatagramReader(bArr).read(8);
        if (i == CCSType.CHANGE_CIPHER_SPEC.getCode()) {
            return new ChangeCipherSpecMessage(inetSocketAddress);
        }
        throw new HandshakeException(FileInsert$$ExternalSyntheticOutline0.m(i, "Unknown Change Cipher Spec code received: "), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, inetSocketAddress));
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public ContentType getContentType() {
        return ContentType.CHANGE_CIPHER_SPEC;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public int size() {
        return 1;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public byte[] toByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.CCSProtocolType.getCode(), 8);
        return datagramWriter.toByteArray();
    }

    public String toString() {
        return "\tChange Cipher Spec Message\n";
    }
}
