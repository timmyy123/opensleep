package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HelloExtension {
    private ExtensionType type;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.HelloExtension$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType;

        static {
            int[] iArr = new int[ExtensionType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType = iArr;
            try {
                iArr[ExtensionType.ELLIPTIC_CURVES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.EC_POINT_FORMATS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.SIGNATURE_ALGORITHMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.CLIENT_CERT_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.SERVER_CERT_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.MAX_FRAGMENT_LENGTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.SERVER_NAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.CONNECTION_ID.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[ExtensionType.RECORD_SIZE_LIMIT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum ExtensionType {
        SERVER_NAME(0, "server_name"),
        MAX_FRAGMENT_LENGTH(1, "max_fragment_length"),
        CLIENT_CERTIFICATE_URL(2, "client_certificate_url"),
        TRUSTED_CA_KEYS(3, "trusted_ca_keys"),
        TRUNCATED_HMAC(4, "truncated_hmac"),
        STATUS_REQUEST(5, "status_request"),
        USER_MAPPING(6, "user_mapping"),
        CLIENT_AUTHZ(7, "client_authz"),
        SERVER_AUTHZ(8, "server_authz"),
        CERT_TYPE(9, "cert_type"),
        ELLIPTIC_CURVES(10, "elliptic_curves"),
        EC_POINT_FORMATS(11, "ec_point_formats"),
        SRP(12, "srp"),
        SIGNATURE_ALGORITHMS(13, "signature_algorithms"),
        USE_SRTP(14, "use_srtp"),
        HEARTBEAT(15, "heartbeat"),
        APPLICATION_LAYER_PROTOCOL_NEGOTIATION(16, "application_layer_protocol_negotiation"),
        STATUS_REQUEST_V2(17, "status_request_v2"),
        SIGNED_CERTIFICATE_TIMESTAMP(18, "signed_certificate_timestamp"),
        CLIENT_CERT_TYPE(19, "client_certificate_type"),
        SERVER_CERT_TYPE(20, "server_certificate_type"),
        ENCRYPT_THEN_MAC(22, "encrypt_then_mac"),
        SESSION_TICKET_TLS(35, "SessionTicket TLS"),
        CONNECTION_ID(53, "Connection ID"),
        RENEGOTIATION_INFO(65281, "renegotiation_info"),
        RECORD_SIZE_LIMIT(28, "record_size_limit");

        private int id;
        private String name;

        ExtensionType(int i, String str) {
            this.id = i;
            this.name = str;
        }

        public static ExtensionType getExtensionTypeById(int i) {
            for (ExtensionType extensionType : values()) {
                if (extensionType.getId() == i) {
                    return extensionType;
                }
            }
            return null;
        }

        public int getId() {
            return this.id;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public HelloExtension(ExtensionType extensionType) {
        if (extensionType != null) {
            this.type = extensionType;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("extension type must not be null!");
            throw null;
        }
    }

    public static HelloExtension fromExtensionDataReader(int i, DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        ExtensionType extensionTypeById = ExtensionType.getExtensionTypeById(i);
        if (extensionTypeById != null) {
            switch (AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$HelloExtension$ExtensionType[extensionTypeById.ordinal()]) {
                case 1:
                    return SupportedEllipticCurvesExtension.fromExtensionDataReader(datagramReader);
                case 2:
                    return SupportedPointFormatsExtension.fromExtensionDataReader(datagramReader);
                case 3:
                    return SignatureAlgorithmsExtension.fromExtensionDataReader(datagramReader);
                case 4:
                    return ClientCertificateTypeExtension.fromExtensionDataReaader(datagramReader);
                case 5:
                    return ServerCertificateTypeExtension.fromExtensionDataReader(datagramReader);
                case 6:
                    return MaxFragmentLengthExtension.fromExtensionDataReader(datagramReader, inetSocketAddress);
                case 7:
                    return ServerNameExtension.fromExtensionDataReader(datagramReader, inetSocketAddress);
                case 8:
                    return ConnectionIdExtension.fromExtensionDataReader(datagramReader, inetSocketAddress);
                case 9:
                    return RecordSizeLimitExtension.fromExtensionDataReader(datagramReader, inetSocketAddress);
            }
        }
        datagramReader.close();
        return null;
    }

    public abstract void addExtensionData(DatagramWriter datagramWriter);

    public abstract int getLength();

    public final ExtensionType getType() {
        return this.type;
    }

    public final byte[] toByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.type.getId(), 16);
        addExtensionData(datagramWriter);
        return datagramWriter.toByteArray();
    }

    public String toString() {
        return "\t\t\tExtension: " + this.type + " (" + this.type.getId() + ")\n";
    }
}
