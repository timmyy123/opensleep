package org.eclipse.californium.core.coap;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.StandardCharsets;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CoAP {
    public static final Charset UTF8_CHARSET = StandardCharsets.UTF_8;
    public static final InetAddress MULTICAST_IPV4 = new InetSocketAddress("224.0.1.187", 0).getAddress();
    public static final InetAddress MULTICAST_IPV6_LINKLOCAL = new InetSocketAddress("[FF02::FD]", 0).getAddress();
    public static final InetAddress MULTICAST_IPV6_SITELOCAL = new InetSocketAddress("[FF05::FD]", 0).getAddress();
    private static final Map<String, Code> codeMap = new HashMap();
    private static final Map<String, ResponseCode> responseCodeMap = new HashMap();

    public enum Code {
        GET(1),
        POST(2),
        PUT(3),
        DELETE(4),
        FETCH(5),
        PATCH(6),
        IPATCH(7),
        CUSTOM_30(30);

        public final String text;
        public final int value;

        Code(int i) {
            this.value = i;
            String code = CoAP.formatCode(CoAP.getCodeClass(i), CoAP.getCodeDetail(i));
            this.text = code;
            CoAP.codeMap.put(code, this);
        }

        public static Code valueOf(int i) {
            int codeClass = CoAP.getCodeClass(i);
            int codeDetail = CoAP.getCodeDetail(i);
            if (codeClass > 0) {
                throw new MessageFormatException(FileInsert$$ExternalSyntheticOutline0.m("Not a CoAP request code: ", CoAP.formatCode(codeClass, codeDetail)));
            }
            if (codeDetail == 30) {
                return CUSTOM_30;
            }
            switch (codeDetail) {
                case 1:
                    return GET;
                case 2:
                    return POST;
                case 3:
                    return PUT;
                case 4:
                    return DELETE;
                case 5:
                    return FETCH;
                case 6:
                    return PATCH;
                case 7:
                    return IPATCH;
                default:
                    throw new MessageFormatException(FileInsert$$ExternalSyntheticOutline0.m("Unknown CoAP request code: ", CoAP.formatCode(codeClass, codeDetail)));
            }
        }
    }

    public enum CodeClass {
        REQUEST(0),
        SUCCESS_RESPONSE(2),
        ERROR_RESPONSE(4),
        SERVER_ERROR_RESPONSE(5),
        SIGNAL(7);

        public final int value;

        CodeClass(int i) {
            this.value = i;
        }
    }

    public enum Type {
        CON(0),
        NON(1),
        ACK(2),
        RST(3);

        public final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type valueOf(int i) {
            if (i == 0) {
                return CON;
            }
            if (i == 1) {
                return NON;
            }
            if (i == 2) {
                return ACK;
            }
            if (i == 3) {
                return RST;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Unknown CoAP type "));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatCode(int i, int i2) {
        return String.format("%d.%02d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static int getCodeClass(int i) {
        return (i & 224) >> 5;
    }

    public static int getCodeDetail(int i) {
        return i & 31;
    }

    public static int getDefaultPort(String str) {
        if ("coap".equalsIgnoreCase(str)) {
            return 5683;
        }
        if ("coaps".equalsIgnoreCase(str)) {
            return TradfriKt.COAPS_PORT;
        }
        if ("coap+tcp".equalsIgnoreCase(str)) {
            return 5683;
        }
        if ("coaps+tcp".equalsIgnoreCase(str)) {
            return TradfriKt.COAPS_PORT;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("URI scheme '", str, "' is not supported!"));
        return 0;
    }

    public static String getSchemeForProtocol(String str) {
        if ("UDP".equalsIgnoreCase(str)) {
            return "coap";
        }
        if ("DTLS".equalsIgnoreCase(str)) {
            return "coaps";
        }
        if ("TCP".equalsIgnoreCase(str)) {
            return "coap+tcp";
        }
        if (SSLSocketFactoryFactory.DEFAULT_PROTOCOL.equalsIgnoreCase(str)) {
            return "coaps+tcp";
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Protocol ", str, " not supported!"));
        return null;
    }

    public static boolean isEmptyMessage(int i) {
        return i == 0;
    }

    public static boolean isRequest(int i) {
        return i >= 1 && i <= 31;
    }

    public static boolean isResponse(int i) {
        return i >= 64 && i <= 191;
    }

    public static boolean isSupportedScheme(String str) {
        return "coap".equalsIgnoreCase(str) || "coap+tcp".equalsIgnoreCase(str) || "coaps".equalsIgnoreCase(str) || "coaps+tcp".equalsIgnoreCase(str);
    }

    public static boolean isTcpProtocol(String str) {
        return "TCP".equalsIgnoreCase(str) || SSLSocketFactoryFactory.DEFAULT_PROTOCOL.equalsIgnoreCase(str);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field '_UNKNOWN_SUCCESS_CODE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class ResponseCode {
        private static final /* synthetic */ ResponseCode[] $VALUES;
        public static final ResponseCode BAD_GATEWAY;
        public static final ResponseCode BAD_OPTION;
        public static final ResponseCode BAD_REQUEST;
        public static final ResponseCode CHANGED;
        public static final ResponseCode CONFLICT;
        public static final ResponseCode CONTENT;
        public static final ResponseCode CONTINUE;
        public static final ResponseCode CREATED;
        public static final ResponseCode DELETED;
        public static final ResponseCode FORBIDDEN;
        public static final ResponseCode GATEWAY_TIMEOUT;
        public static final ResponseCode INTERNAL_SERVER_ERROR;
        public static final ResponseCode METHOD_NOT_ALLOWED;
        public static final ResponseCode NOT_ACCEPTABLE;
        public static final ResponseCode NOT_FOUND;
        public static final ResponseCode NOT_IMPLEMENTED;
        public static final ResponseCode PRECONDITION_FAILED;
        public static final ResponseCode PROXY_NOT_SUPPORTED;
        public static final ResponseCode REQUEST_ENTITY_INCOMPLETE;
        public static final ResponseCode REQUEST_ENTITY_TOO_LARGE;
        public static final ResponseCode SERVICE_UNAVAILABLE;
        public static final ResponseCode TOO_MANY_REQUESTS;
        public static final ResponseCode UNAUTHORIZED;
        public static final ResponseCode UNPROCESSABLE_ENTITY;
        public static final ResponseCode UNSUPPORTED_CONTENT_FORMAT;
        public static final ResponseCode VALID;
        public static final ResponseCode _UNKNOWN_SUCCESS_CODE;
        public final int codeClass;
        public final int codeDetail;
        public final String text;
        public final int value;

        static {
            CodeClass codeClass = CodeClass.SUCCESS_RESPONSE;
            ResponseCode responseCode = new ResponseCode("_UNKNOWN_SUCCESS_CODE", 0, codeClass, 0);
            _UNKNOWN_SUCCESS_CODE = responseCode;
            ResponseCode responseCode2 = new ResponseCode("CREATED", 1, codeClass, 1);
            CREATED = responseCode2;
            ResponseCode responseCode3 = new ResponseCode("DELETED", 2, codeClass, 2);
            DELETED = responseCode3;
            ResponseCode responseCode4 = new ResponseCode("VALID", 3, codeClass, 3);
            VALID = responseCode4;
            ResponseCode responseCode5 = new ResponseCode("CHANGED", 4, codeClass, 4);
            CHANGED = responseCode5;
            ResponseCode responseCode6 = new ResponseCode("CONTENT", 5, codeClass, 5);
            CONTENT = responseCode6;
            ResponseCode responseCode7 = new ResponseCode("CONTINUE", 6, codeClass, 31);
            CONTINUE = responseCode7;
            CodeClass codeClass2 = CodeClass.ERROR_RESPONSE;
            ResponseCode responseCode8 = new ResponseCode("BAD_REQUEST", 7, codeClass2, 0);
            BAD_REQUEST = responseCode8;
            ResponseCode responseCode9 = new ResponseCode("UNAUTHORIZED", 8, codeClass2, 1);
            UNAUTHORIZED = responseCode9;
            ResponseCode responseCode10 = new ResponseCode("BAD_OPTION", 9, codeClass2, 2);
            BAD_OPTION = responseCode10;
            ResponseCode responseCode11 = new ResponseCode("FORBIDDEN", 10, codeClass2, 3);
            FORBIDDEN = responseCode11;
            ResponseCode responseCode12 = new ResponseCode("NOT_FOUND", 11, codeClass2, 4);
            NOT_FOUND = responseCode12;
            ResponseCode responseCode13 = new ResponseCode("METHOD_NOT_ALLOWED", 12, codeClass2, 5);
            METHOD_NOT_ALLOWED = responseCode13;
            ResponseCode responseCode14 = new ResponseCode("NOT_ACCEPTABLE", 13, codeClass2, 6);
            NOT_ACCEPTABLE = responseCode14;
            ResponseCode responseCode15 = new ResponseCode("REQUEST_ENTITY_INCOMPLETE", 14, codeClass2, 8);
            REQUEST_ENTITY_INCOMPLETE = responseCode15;
            ResponseCode responseCode16 = new ResponseCode("CONFLICT", 15, codeClass2, 9);
            CONFLICT = responseCode16;
            ResponseCode responseCode17 = new ResponseCode("PRECONDITION_FAILED", 16, codeClass2, 12);
            PRECONDITION_FAILED = responseCode17;
            ResponseCode responseCode18 = new ResponseCode("REQUEST_ENTITY_TOO_LARGE", 17, codeClass2, 13);
            REQUEST_ENTITY_TOO_LARGE = responseCode18;
            ResponseCode responseCode19 = new ResponseCode("UNSUPPORTED_CONTENT_FORMAT", 18, codeClass2, 15);
            UNSUPPORTED_CONTENT_FORMAT = responseCode19;
            ResponseCode responseCode20 = new ResponseCode("UNPROCESSABLE_ENTITY", 19, codeClass2, 22);
            UNPROCESSABLE_ENTITY = responseCode20;
            ResponseCode responseCode21 = new ResponseCode("TOO_MANY_REQUESTS", 20, codeClass2, 29);
            TOO_MANY_REQUESTS = responseCode21;
            CodeClass codeClass3 = CodeClass.SERVER_ERROR_RESPONSE;
            ResponseCode responseCode22 = new ResponseCode("INTERNAL_SERVER_ERROR", 21, codeClass3, 0);
            INTERNAL_SERVER_ERROR = responseCode22;
            ResponseCode responseCode23 = new ResponseCode("NOT_IMPLEMENTED", 22, codeClass3, 1);
            NOT_IMPLEMENTED = responseCode23;
            ResponseCode responseCode24 = new ResponseCode("BAD_GATEWAY", 23, codeClass3, 2);
            BAD_GATEWAY = responseCode24;
            ResponseCode responseCode25 = new ResponseCode("SERVICE_UNAVAILABLE", 24, codeClass3, 3);
            SERVICE_UNAVAILABLE = responseCode25;
            ResponseCode responseCode26 = new ResponseCode("GATEWAY_TIMEOUT", 25, codeClass3, 4);
            GATEWAY_TIMEOUT = responseCode26;
            ResponseCode responseCode27 = new ResponseCode("PROXY_NOT_SUPPORTED", 26, codeClass3, 5);
            PROXY_NOT_SUPPORTED = responseCode27;
            $VALUES = new ResponseCode[]{responseCode, responseCode2, responseCode3, responseCode4, responseCode5, responseCode6, responseCode7, responseCode8, responseCode9, responseCode10, responseCode11, responseCode12, responseCode13, responseCode14, responseCode15, responseCode16, responseCode17, responseCode18, responseCode19, responseCode20, responseCode21, responseCode22, responseCode23, responseCode24, responseCode25, responseCode26, responseCode27};
        }

        private ResponseCode(String str, int i, CodeClass codeClass, int i2) {
            int i3 = codeClass.value;
            this.codeClass = i3;
            this.codeDetail = i2;
            this.value = (i3 << 5) | i2;
            String code = CoAP.formatCode(i3, i2);
            this.text = code;
            CoAP.responseCodeMap.put(code, this);
        }

        public static boolean isClientError(ResponseCode responseCode) {
            if (responseCode != null) {
                return responseCode.codeClass == CodeClass.ERROR_RESPONSE.value;
            }
            Types$$ExternalSyntheticBUOutline0.m$1("ResponseCode must not be null!");
            return false;
        }

        public static boolean isServerError(ResponseCode responseCode) {
            if (responseCode != null) {
                return responseCode.codeClass == CodeClass.SERVER_ERROR_RESPONSE.value;
            }
            Types$$ExternalSyntheticBUOutline0.m$1("ResponseCode must not be null!");
            return false;
        }

        public static boolean isSuccess(ResponseCode responseCode) {
            if (responseCode != null) {
                return responseCode.codeClass == CodeClass.SUCCESS_RESPONSE.value;
            }
            Types$$ExternalSyntheticBUOutline0.m$1("ResponseCode must not be null!");
            return false;
        }

        public static ResponseCode valueOf(int i) {
            int codeClass = CoAP.getCodeClass(i);
            int codeDetail = CoAP.getCodeDetail(i);
            if (codeClass == 2) {
                return valueOfSuccessCode(codeDetail);
            }
            if (codeClass == 4) {
                return valueOfClientErrorCode(codeDetail);
            }
            if (codeClass == 5) {
                return valueOfServerErrorCode(codeDetail);
            }
            throw new MessageFormatException(FileInsert$$ExternalSyntheticOutline0.m("Not a CoAP response code: ", CoAP.formatCode(codeClass, codeDetail)));
        }

        private static ResponseCode valueOfClientErrorCode(int i) {
            if (i == 8) {
                return REQUEST_ENTITY_INCOMPLETE;
            }
            if (i == 9) {
                return CONFLICT;
            }
            if (i == 12) {
                return PRECONDITION_FAILED;
            }
            if (i == 13) {
                return REQUEST_ENTITY_TOO_LARGE;
            }
            if (i == 15) {
                return UNSUPPORTED_CONTENT_FORMAT;
            }
            if (i == 22) {
                return UNPROCESSABLE_ENTITY;
            }
            if (i == 29) {
                return TOO_MANY_REQUESTS;
            }
            switch (i) {
                case 0:
                    return BAD_REQUEST;
                case 1:
                    return UNAUTHORIZED;
                case 2:
                    return BAD_OPTION;
                case 3:
                    return FORBIDDEN;
                case 4:
                    return NOT_FOUND;
                case 5:
                    return METHOD_NOT_ALLOWED;
                case 6:
                    return NOT_ACCEPTABLE;
                default:
                    return BAD_REQUEST;
            }
        }

        private static ResponseCode valueOfServerErrorCode(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? INTERNAL_SERVER_ERROR : PROXY_NOT_SUPPORTED : GATEWAY_TIMEOUT : SERVICE_UNAVAILABLE : BAD_GATEWAY : NOT_IMPLEMENTED : INTERNAL_SERVER_ERROR;
        }

        private static ResponseCode valueOfSuccessCode(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 31 ? _UNKNOWN_SUCCESS_CODE : CONTINUE : CONTENT : CHANGED : VALID : DELETED : CREATED;
        }

        public static ResponseCode[] values() {
            return (ResponseCode[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.text;
        }

        public static ResponseCode valueOf(String str) {
            return (ResponseCode) Enum.valueOf(ResponseCode.class, str);
        }
    }
}
