package org.eclipse.californium.elements.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StringUtil {
    public static final String CALIFORNIUM_VERSION;
    public static final boolean SUPPORT_HOST_STRING;
    private static final Pattern HOSTNAME_PATTERN = Pattern.compile("^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])$");
    public static final String lineSeparator = System.getProperty("line.separator");
    private static final char[] BIN_TO_HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static {
        String str = null;
        boolean z = false;
        try {
            if (InetSocketAddress.class.getMethod("getHostString", null) != null) {
                z = true;
            }
        } catch (NoSuchMethodException unused) {
        }
        SUPPORT_HOST_STRING = z;
        Package r1 = StringUtil.class.getPackage();
        if (r1 != null) {
            String implementationVersion = r1.getImplementationVersion();
            if (!"0.0".equals(implementationVersion)) {
                str = implementationVersion;
            }
        }
        CALIFORNIUM_VERSION = str;
    }

    public static String byteArray2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return bArr.length == 0 ? "" : byteArray2HexString(bArr, (char) 0, 0);
    }

    public static String byteArray2HexString(byte[] bArr, char c, int i) {
        if (bArr == null || bArr.length == 0) {
            return "--";
        }
        if (i == 0 || i > bArr.length) {
            i = bArr.length;
        }
        StringBuilder sb = new StringBuilder((c == 0 ? 2 : 3) * i);
        for (int i2 = 0; i2 < i; i2++) {
            byte b = bArr[i2];
            char[] cArr = BIN_TO_HEX_ARRAY;
            sb.append(cArr[(b & 255) >>> 4]);
            sb.append(cArr[b & 15]);
            if (c != 0 && i2 < i - 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String getConfiguration(String str) {
        String str2 = System.getenv(str);
        return (str2 == null || str2.isEmpty()) ? System.getProperty(str) : str2;
    }

    public static boolean getConfigurationBoolean(String str) {
        return Boolean.parseBoolean(getConfiguration(str));
    }

    public static String getUriHostname(InetAddress inetAddress) throws URISyntaxException {
        int iIndexOf;
        int i;
        if (inetAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("address must not be null!");
            return null;
        }
        String hostAddress = inetAddress.getHostAddress();
        if (inetAddress instanceof Inet6Address) {
            Inet6Address inet6Address = (Inet6Address) inetAddress;
            if ((inet6Address.getScopedInterface() != null || inet6Address.getScopeId() > 0) && (iIndexOf = hostAddress.indexOf(37)) > 0 && (i = iIndexOf + 1) < hostAddress.length()) {
                String strSubstring = hostAddress.substring(i);
                String strSubstring2 = hostAddress.substring(0, iIndexOf);
                String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(strSubstring2, "%25", strSubstring);
                try {
                    new URI(null, null, strM$1, -1, null, null, null);
                    return strM$1;
                } catch (URISyntaxException e) {
                    String strReplaceAll = strSubstring.replaceAll("[-._~]", "");
                    if (strReplaceAll.isEmpty()) {
                        return strSubstring2;
                    }
                    String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(strSubstring2, "%25", strReplaceAll);
                    try {
                        new URI(null, null, strM$12, -1, null, null, null);
                        return strM$12;
                    } catch (URISyntaxException unused) {
                        throw e;
                    }
                }
            }
        }
        return hostAddress;
    }

    public static boolean isValidHostName(String str) {
        if (str == null) {
            return false;
        }
        return HOSTNAME_PATTERN.matcher(str).matches();
    }

    public static String lineSeparator() {
        return lineSeparator;
    }

    public static String normalizeLoggingTag(String str) {
        return str == null ? "" : (str.isEmpty() || str.endsWith(" ")) ? str : str.concat(" ");
    }

    public static String toDisplayString(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            return null;
        }
        InetAddress address = inetSocketAddress.getAddress();
        if (address != null && address.isAnyLocalAddress()) {
            return "port " + inetSocketAddress.getPort();
        }
        String hostString = SUPPORT_HOST_STRING ? toHostString(inetSocketAddress) : "";
        String string = address != null ? toString(address) : "<unresolved>";
        String strConcat = hostString.equals(string) ? "" : hostString.concat(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (!(inetSocketAddress.getAddress() instanceof Inet6Address)) {
            return strConcat + string + ":" + inetSocketAddress.getPort();
        }
        return strConcat + "[" + string + "]:" + inetSocketAddress.getPort();
    }

    private static String toHostString(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.getHostString();
    }

    public static String toString(InetSocketAddress inetSocketAddress) {
        String string;
        if (inetSocketAddress == null) {
            return null;
        }
        if (SUPPORT_HOST_STRING) {
            string = toHostString(inetSocketAddress);
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            string = address != null ? toString(address) : "<unresolved>";
        }
        if (inetSocketAddress.getAddress() instanceof Inet6Address) {
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("[", string, "]:");
            sbM5m.append(inetSocketAddress.getPort());
            return sbM5m.toString();
        }
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(string, ":");
        sbM.append(inetSocketAddress.getPort());
        return sbM.toString();
    }

    public static String trunc(String str, int i) {
        return (str == null || i <= 0 || i >= str.length()) ? str : str.substring(0, i);
    }

    public static String byteArray2HexString(byte[] bArr) {
        return byteArray2HexString(bArr, (char) 0, 0);
    }

    public static String toString(InetAddress inetAddress) {
        if (inetAddress == null) {
            return null;
        }
        return inetAddress.getHostAddress();
    }
}
