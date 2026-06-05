package org.eclipse.californium.scandium.dtls;

import java.io.Serializable;
import java.net.InetSocketAddress;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class AlertMessage implements DTLSMessage, Serializable {
    private static final long serialVersionUID = 1;
    private final AlertDescription description;
    private final AlertLevel level;
    private final InetSocketAddress peerAddress;
    private final transient ProtocolVersion protocolVersion;

    public enum AlertDescription {
        CLOSE_NOTIFY(0, "close_notify"),
        UNEXPECTED_MESSAGE(10, "unexpected_message"),
        BAD_RECORD_MAC(20, "bad_record_mac"),
        DECRYPTION_FAILED_RESERVED(21, "decryption_failed"),
        RECORD_OVERFLOW(22, "record_overflow"),
        DECOMPRESSION_FAILURE(30, "decompression_failure"),
        HANDSHAKE_FAILURE(40, "handshake_failure"),
        NO_CERTIFICATE_RESERVED(41, "no_certificate"),
        BAD_CERTIFICATE(42, "bad_certificate"),
        UNSUPPORTED_CERTIFICATE(43, "unsupported_certificate"),
        CERTIFICATE_REVOKED(44, "certificate_revoked"),
        CERTIFICATE_EXPIRED(45, "certificate_expired"),
        CERTIFICATE_UNKNOWN(46, "certificate_unknown"),
        ILLEGAL_PARAMETER(47, "illegal_parameter"),
        UNKNOWN_CA(48, "unknown_ca"),
        ACCESS_DENIED(49, "access_denied"),
        DECODE_ERROR(50, "decode_error"),
        DECRYPT_ERROR(51, "decrypt_error"),
        EXPORT_RESTRICTION_RESERVED(60, "export_restriction"),
        PROTOCOL_VERSION(70, "protocol_version"),
        INSUFFICIENT_SECURITY(71, "insufficient_security"),
        INTERNAL_ERROR(80, "internal_error"),
        USER_CANCELED(90, "user_canceled"),
        NO_RENEGOTIATION(100, "no_negotiation"),
        UNSUPPORTED_EXTENSION(110, "unsupported_extension"),
        UNKNOWN_PSK_IDENTITY(115, "unknown_psk_identity");

        private byte code;
        private String description;

        AlertDescription(int i, String str) {
            this.code = (byte) i;
            this.description = str;
        }

        public static AlertDescription getDescriptionByCode(int i) {
            for (AlertDescription alertDescription : values()) {
                if (alertDescription.code == ((byte) i)) {
                    return alertDescription;
                }
            }
            return null;
        }

        public byte getCode() {
            return this.code;
        }
    }

    public enum AlertLevel {
        WARNING(1),
        FATAL(2);

        private byte code;

        AlertLevel(int i) {
            this.code = (byte) i;
        }

        public static AlertLevel getLevelByCode(int i) {
            if (i == 1) {
                return WARNING;
            }
            if (i != 2) {
                return null;
            }
            return FATAL;
        }

        public byte getCode() {
            return this.code;
        }
    }

    public AlertMessage(AlertLevel alertLevel, AlertDescription alertDescription, ProtocolVersion protocolVersion, InetSocketAddress inetSocketAddress) {
        if (alertLevel == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Level must not be null");
            throw null;
        }
        if (alertDescription == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Description must not be null");
            throw null;
        }
        if (inetSocketAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
            throw null;
        }
        if (protocolVersion != null && alertDescription != AlertDescription.PROTOCOL_VERSION) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Protocol version is only supported for that specific alert!");
            throw null;
        }
        this.peerAddress = inetSocketAddress;
        this.level = alertLevel;
        this.description = alertDescription;
        this.protocolVersion = protocolVersion;
    }

    public static AlertMessage fromByteArray(byte[] bArr, InetSocketAddress inetSocketAddress) throws HandshakeException {
        DatagramReader datagramReader = new DatagramReader(bArr);
        byte nextByte = datagramReader.readNextByte();
        byte nextByte2 = datagramReader.readNextByte();
        AlertLevel levelByCode = AlertLevel.getLevelByCode(nextByte);
        AlertDescription descriptionByCode = AlertDescription.getDescriptionByCode(nextByte2);
        if (levelByCode == null) {
            throw new HandshakeException(String.format("Unknown alert level code [%d]", Byte.valueOf(nextByte)), new AlertMessage(AlertLevel.FATAL, AlertDescription.DECODE_ERROR, inetSocketAddress));
        }
        if (descriptionByCode != null) {
            return new AlertMessage(levelByCode, descriptionByCode, inetSocketAddress);
        }
        throw new HandshakeException(String.format("Unknown alert description code [%d]", Byte.valueOf(nextByte2)), new AlertMessage(AlertLevel.FATAL, AlertDescription.DECODE_ERROR, inetSocketAddress));
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public ContentType getContentType() {
        return ContentType.ALERT;
    }

    public AlertDescription getDescription() {
        return this.description;
    }

    public AlertLevel getLevel() {
        return this.level;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public final InetSocketAddress getPeer() {
        return this.peerAddress;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public int size() {
        return 2;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public byte[] toByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.level.getCode(), 8);
        datagramWriter.write(this.description.getCode(), 8);
        return datagramWriter.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\tAlert Protocol");
        sb.append(StringUtil.lineSeparator());
        sb.append("\tLevel: ");
        sb.append(this.level);
        sb.append(StringUtil.lineSeparator());
        sb.append("\tDescription: ");
        sb.append(this.description);
        sb.append(StringUtil.lineSeparator());
        if (this.protocolVersion != null) {
            sb.append("\tProtocol Version: ");
            sb.append(this.protocolVersion);
            sb.append(StringUtil.lineSeparator());
        }
        return sb.toString();
    }

    public AlertMessage(AlertLevel alertLevel, AlertDescription alertDescription, InetSocketAddress inetSocketAddress) {
        this(alertLevel, alertDescription, null, inetSocketAddress);
    }
}
