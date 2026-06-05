package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.util.Arrays;
import org.eclipse.californium.elements.util.StringUtil;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentedHandshakeMessage extends HandshakeMessage {
    private final int fragmentOffset;
    private final byte[] fragmentedBytes;
    private final int messageLength;
    private final HandshakeType type;

    public FragmentedHandshakeMessage(HandshakeType handshakeType, int i, int i2, int i3, byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.type = handshakeType;
        this.messageLength = i;
        this.fragmentedBytes = Arrays.copyOf(bArr, bArr.length);
        this.fragmentOffset = i3;
        setMessageSeq(i2);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        return this.fragmentedBytes;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getFragmentLength() {
        return this.fragmentedBytes.length;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getFragmentOffset() {
        return this.fragmentOffset;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.messageLength;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return this.type;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return "\tFragmented Handshake Protocol" + StringUtil.lineSeparator() + "\tType: " + getMessageType() + StringUtil.lineSeparator() + "\tPeer: " + getPeer() + StringUtil.lineSeparator() + "\tMessage Sequence No: " + getMessageSeq() + StringUtil.lineSeparator() + "\tFragment Offset: " + getFragmentOffset() + StringUtil.lineSeparator() + "\tFragment Length: " + getFragmentLength() + StringUtil.lineSeparator() + "\tLength: " + getMessageLength() + StringUtil.lineSeparator();
    }
}
