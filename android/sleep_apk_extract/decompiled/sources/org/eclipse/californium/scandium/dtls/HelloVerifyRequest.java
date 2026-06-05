package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.util.Arrays;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;

/* JADX INFO: loaded from: classes5.dex */
public final class HelloVerifyRequest extends HandshakeMessage {
    private final byte[] cookie;
    private final ProtocolVersion serverVersion;

    public HelloVerifyRequest(ProtocolVersion protocolVersion, byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.serverVersion = protocolVersion;
        this.cookie = Arrays.copyOf(bArr, bArr.length);
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        return new HelloVerifyRequest(ProtocolVersion.valueOf(datagramReader.read(8), datagramReader.read(8)), datagramReader.readBytes(datagramReader.read(8)), inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.serverVersion.getMajor(), 8);
        datagramWriter.write(this.serverVersion.getMinor(), 8);
        datagramWriter.write(this.cookie.length, 8);
        datagramWriter.writeBytes(this.cookie);
        return datagramWriter.toByteArray();
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.cookie.length + 3;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.HELLO_VERIFY_REQUEST;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return super.toString() + "\t\tServer Version: " + this.serverVersion + StringUtil.lineSeparator() + "\t\tCookie Length: " + this.cookie.length + StringUtil.lineSeparator() + "\t\tCookie: " + StringUtil.byteArray2HexString(this.cookie) + StringUtil.lineSeparator();
    }
}
