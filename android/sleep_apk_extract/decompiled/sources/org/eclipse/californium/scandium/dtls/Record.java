package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Record {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) Record.class);
    private ConnectionId connectionId;
    private final int epoch;
    private final boolean followUpRecord;
    private DTLSMessage fragment;
    private byte[] fragmentBytes;
    private int padding;
    private final InetSocketAddress peerAddress;
    private final long receiveNanos;
    private final InetSocketAddress router;
    private final long sequenceNumber;
    private ContentType type;
    private final ProtocolVersion version;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.Record$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType;

        static {
            int[] iArr = new int[ContentType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType = iArr;
            try {
                iArr[ContentType.ALERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.APPLICATION_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.CHANGE_CIPHER_SPEC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.HANDSHAKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Record(ContentType contentType, int i, long j, DTLSMessage dTLSMessage, DTLSSession dTLSSession, boolean z, int i2) {
        this(ProtocolVersion.VERSION_DTLS_1_2, i, j, 0L, dTLSSession != null ? dTLSSession.getPeer() : null, dTLSSession != null ? dTLSSession.getRouter() : null, false);
        if (dTLSMessage == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Fragment must not be null");
            throw null;
        }
        if (dTLSSession == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Session must not be null");
            throw null;
        }
        if (dTLSSession.getPeer() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Session's peer address must not be null");
            throw null;
        }
        setType(contentType);
        if (z) {
            this.connectionId = dTLSSession.getWriteConnectionId();
            this.padding = i2;
        }
        setEncodedFragment(dTLSSession.getWriteState(i), dTLSMessage);
        if (this.fragmentBytes != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Fragment missing encoded bytes!");
        throw null;
    }

    private void decodeFragment(DTLSConnectionState dTLSConnectionState) throws GeneralSecurityException {
        ContentType contentType = this.type;
        byte[] bArrDecrypt = dTLSConnectionState.decrypt(this, this.fragmentBytes);
        if (ContentType.TLS12_CID == this.type) {
            int length = bArrDecrypt.length - 1;
            while (length >= 0 && bArrDecrypt[length] == 0) {
                length--;
            }
            if (length < 0) {
                zzbuy$$ExternalSyntheticBUOutline0.m("no inner type!");
                return;
            }
            byte b = bArrDecrypt[length];
            ContentType typeByValue = ContentType.getTypeByValue(b);
            if (typeByValue == null) {
                throw new GeneralSecurityException(FileInsert$$ExternalSyntheticOutline0.m(b, "unknown inner type! "));
            }
            bArrDecrypt = Arrays.copyOf(bArrDecrypt, length);
            contentType = typeByValue;
        }
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[contentType.ordinal()];
        if (i == 1) {
            this.fragment = AlertMessage.fromByteArray(bArrDecrypt, getPeerAddress());
        } else if (i == 2) {
            this.fragment = ApplicationMessage.fromByteArray(bArrDecrypt, getPeerAddress());
        } else if (i == 3) {
            this.fragment = ChangeCipherSpecMessage.fromByteArray(bArrDecrypt, getPeerAddress());
        } else if (i != 4) {
            LOGGER.debug("Cannot decrypt message of unsupported type [{}]", this.type);
        } else {
            this.fragment = HandshakeMessage.fromByteArray(bArrDecrypt, getPeerAddress());
        }
        this.type = contentType;
    }

    public static List<Record> fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ConnectionIdGenerator connectionIdGenerator, long j) {
        ConnectionId connectionId;
        if (datagramReader == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Reader must not be null");
            return null;
        }
        if (inetSocketAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
            return null;
        }
        int iBitsLeft = datagramReader.bitsLeft() / 8;
        ArrayList arrayList = new ArrayList();
        while (datagramReader.bytesAvailable()) {
            if (datagramReader.bitsLeft() < 104) {
                LOGGER.debug("Received truncated DTLS record(s). Discarding ...");
                return arrayList;
            }
            int i = datagramReader.read(8);
            ProtocolVersion protocolVersionValueOf = ProtocolVersion.valueOf(datagramReader.read(8), datagramReader.read(8));
            int i2 = datagramReader.read(16);
            long j2 = datagramReader.readLong(48);
            if (i != ContentType.TLS12_CID.getCode()) {
                connectionId = null;
            } else {
                if (connectionIdGenerator == null) {
                    LOGGER.debug("Received TLS_CID record, but cid is not supported. Discarding ...");
                    return arrayList;
                }
                if (!connectionIdGenerator.useConnectionId()) {
                    LOGGER.debug("Received TLS_CID record, but cid is not used. Discarding ...");
                    return arrayList;
                }
                try {
                    ConnectionId connectionId2 = connectionIdGenerator.read(datagramReader);
                    if (connectionId2 == null) {
                        LOGGER.debug("Received TLS_CID record, but cid is not matching. Discarding ...");
                        return arrayList;
                    }
                    connectionId = connectionId2;
                } catch (RuntimeException e) {
                    LOGGER.debug("Received TLS_CID record, failed to read cid. Discarding ...", (Throwable) e);
                    return arrayList;
                }
            }
            int i3 = datagramReader.read(16);
            int iBitsLeft2 = datagramReader.bitsLeft() / 8;
            if (iBitsLeft2 < i3) {
                LOGGER.debug("Received truncated DTLS record(s) ({} bytes, but only {} available). {} records, {} bytes. Discarding ...", Integer.valueOf(i3), Integer.valueOf(iBitsLeft2), Integer.valueOf(arrayList.size()), Integer.valueOf(iBitsLeft));
                return arrayList;
            }
            byte[] bytes = datagramReader.readBytes(i3);
            ContentType typeByValue = ContentType.getTypeByValue(i);
            if (typeByValue == null) {
                LOGGER.debug("Received DTLS record of unsupported type [{}]. Discarding ...", Integer.valueOf(i));
            } else {
                arrayList.add(new Record(typeByValue, protocolVersionValueOf, i2, j2, connectionId, bytes, inetSocketAddress, inetSocketAddress2, j, !arrayList.isEmpty()));
            }
        }
        return arrayList;
    }

    private void setEncodedFragment(DTLSConnectionState dTLSConnectionState, DTLSMessage dTLSMessage) {
        byte[] byteArray = dTLSMessage.toByteArray();
        if (byteArray == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("fragment must not return null");
            return;
        }
        if (useConnectionId()) {
            int length = byteArray.length;
            byteArray = Arrays.copyOf(byteArray, length + 1 + this.padding);
            byteArray[length] = (byte) this.type.getCode();
        }
        this.fragmentBytes = dTLSConnectionState.encrypt(this, byteArray);
        this.fragment = dTLSMessage;
    }

    private void setType(ContentType contentType) {
        if (contentType == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Type must not be null");
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[contentType.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            this.type = contentType;
        } else {
            Gson$$ExternalSyntheticBUOutline0.m("Not supported content type: ", contentType);
        }
    }

    public void applySession(DTLSSession dTLSSession) throws GeneralSecurityException {
        if (this.fragment == null) {
            decodeFragment(dTLSSession == null ? DTLSConnectionState.NULL : dTLSSession.getReadState());
        } else {
            LOGGER.error("session already applied!");
            Utf8$$ExternalSyntheticBUOutline0.m$2("session already applied!");
        }
    }

    public byte[] generateAdditionalData(int i) {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.epoch, 16);
        datagramWriter.writeLong(this.sequenceNumber, 48);
        if (useConnectionId()) {
            datagramWriter.write(ContentType.TLS12_CID.getCode(), 8);
        } else {
            datagramWriter.write(this.type.getCode(), 8);
        }
        datagramWriter.write(this.version.getMajor(), 8);
        datagramWriter.write(this.version.getMinor(), 8);
        if (useConnectionId()) {
            datagramWriter.writeBytes(this.connectionId.getBytes());
            datagramWriter.write(this.connectionId.length(), 8);
        }
        datagramWriter.write(i, 16);
        return datagramWriter.toByteArray();
    }

    public byte[] generateExplicitNonce() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.epoch, 16);
        datagramWriter.writeLong(this.sequenceNumber, 48);
        return datagramWriter.toByteArray();
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public int getEpoch() {
        return this.epoch;
    }

    public DTLSMessage getFragment() {
        DTLSMessage dTLSMessage = this.fragment;
        if (dTLSMessage != null) {
            return dTLSMessage;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("fragment not decoded!");
        return null;
    }

    public byte[] getFragmentBytes() {
        return this.fragmentBytes;
    }

    public int getFragmentLength() {
        return this.fragmentBytes.length;
    }

    public InetSocketAddress getPeerAddress() {
        return this.peerAddress;
    }

    public long getReceiveNanos() {
        return this.receiveNanos;
    }

    public InetSocketAddress getRouter() {
        return this.router;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public ContentType getType() {
        return this.type;
    }

    public boolean isDecoded() {
        return this.fragment != null;
    }

    public boolean isFollowUpRecord() {
        return this.followUpRecord;
    }

    public boolean isNewClientHello() {
        if (this.epoch <= 0 && this.type == ContentType.HANDSHAKE) {
            byte[] bArr = this.fragmentBytes;
            if (bArr.length != 0 && HandshakeType.getTypeByCode(bArr[0]) == HandshakeType.CLIENT_HELLO) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return getFragmentLength() + (useConnectionId() ? this.connectionId.length() : 0) + 13;
    }

    public byte[] toByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        if (useConnectionId()) {
            datagramWriter.write(ContentType.TLS12_CID.getCode(), 8);
        } else {
            datagramWriter.write(this.type.getCode(), 8);
        }
        datagramWriter.write(this.version.getMajor(), 8);
        datagramWriter.write(this.version.getMinor(), 8);
        datagramWriter.write(this.epoch, 16);
        datagramWriter.writeLong(this.sequenceNumber, 48);
        if (useConnectionId()) {
            datagramWriter.writeBytes(this.connectionId.getBytes());
        }
        datagramWriter.write(this.fragmentBytes.length, 16);
        datagramWriter.writeBytes(this.fragmentBytes);
        return datagramWriter.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("==[ DTLS Record ]==============================================");
        sb.append(StringUtil.lineSeparator());
        sb.append("Content Type: ");
        sb.append(this.type.toString());
        sb.append(StringUtil.lineSeparator());
        sb.append("Peer address: ");
        sb.append(getPeerAddress());
        sb.append(StringUtil.lineSeparator());
        sb.append("Version: ");
        sb.append(this.version.getMajor());
        sb.append(", ");
        sb.append(this.version.getMinor());
        sb.append(StringUtil.lineSeparator());
        sb.append("Epoch: ");
        sb.append(this.epoch);
        sb.append(StringUtil.lineSeparator());
        sb.append("Sequence Number: ");
        sb.append(this.sequenceNumber);
        if (this.connectionId != null) {
            sb.append(StringUtil.lineSeparator());
            sb.append("connection id: ");
            sb.append(this.connectionId.getAsString());
        }
        sb.append(StringUtil.lineSeparator());
        sb.append("Length: ");
        sb.append(this.fragmentBytes.length);
        sb.append(StringUtil.lineSeparator());
        sb.append("Fragment:");
        if (this.fragment != null) {
            sb.append(StringUtil.lineSeparator());
            sb.append(this.fragment);
        } else {
            sb.append(StringUtil.lineSeparator());
            sb.append("fragment is not decrypted yet");
        }
        sb.append(StringUtil.lineSeparator());
        sb.append("===============================================================");
        return sb.toString();
    }

    public boolean useConnectionId() {
        ConnectionId connectionId = this.connectionId;
        return (connectionId == null || connectionId.isEmpty()) ? false : true;
    }

    public Record(ContentType contentType, ProtocolVersion protocolVersion, int i, long j, ConnectionId connectionId, byte[] bArr, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, long j2, boolean z) {
        this(protocolVersion, i, j, j2, inetSocketAddress, inetSocketAddress2, z);
        if (contentType == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Type must not be null");
            throw null;
        }
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Fragment bytes must not be null");
            throw null;
        }
        if (inetSocketAddress != null) {
            this.type = contentType;
            this.connectionId = connectionId;
            this.fragmentBytes = bArr;
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
        throw null;
    }

    public Record(ContentType contentType, ProtocolVersion protocolVersion, long j, DTLSMessage dTLSMessage, InetSocketAddress inetSocketAddress) {
        this(protocolVersion, 0, j, 0L, inetSocketAddress, (InetSocketAddress) null, false);
        if (dTLSMessage == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Fragment must not be null");
            throw null;
        }
        if (inetSocketAddress != null) {
            setType(contentType);
            this.fragment = dTLSMessage;
            byte[] byteArray = dTLSMessage.toByteArray();
            this.fragmentBytes = byteArray;
            if (byteArray != null) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Fragment missing encoded bytes!");
            throw null;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
        throw null;
    }

    private Record(ProtocolVersion protocolVersion, int i, long j, long j2, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z) {
        if (j > 281474976710655L) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(j, "Sequence number must be 48 bits only! "));
            throw null;
        }
        if (j < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(j, "Sequence number must not be less than 0! "));
            throw null;
        }
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Epoch must not be less than 0! "));
            throw null;
        }
        if (protocolVersion != null) {
            this.version = protocolVersion;
            this.epoch = i;
            this.sequenceNumber = j;
            this.receiveNanos = j2;
            this.followUpRecord = z;
            this.peerAddress = inetSocketAddress;
            this.router = inetSocketAddress2;
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Version must not be null");
        throw null;
    }
}
