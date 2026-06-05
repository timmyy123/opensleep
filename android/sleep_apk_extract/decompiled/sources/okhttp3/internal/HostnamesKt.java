package okhttp3.internal;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.integrity.IntegrityManager;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, d2 = {"decodeIpv4Suffix", "", "input", "", "pos", "", SpotifyService.LIMIT, IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 48)
public abstract class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0 || StringsKt__StringsKt.indexOf$default(" #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (Intrinsics.compare((int) cCharAt, 48) < 0 || Intrinsics.compare((int) cCharAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        if (r4 == 16) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        if (r5 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
    
        r10 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r10, r10);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final InetAddress decodeIpv6(String str, int i, int i2) {
        int i3;
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i >= i2) {
                break;
            }
            if (i4 == 16) {
                return null;
            }
            int i7 = i + 2;
            if (i7 <= i2 && StringsKt__StringsJVMKt.startsWith$default(str, "::", i, false, 4, null)) {
                if (i5 != -1) {
                    return null;
                }
                i4 += 2;
                i5 = i4;
                if (i7 == i2) {
                    break;
                }
                i6 = i7;
                int i8 = 0;
                i = i6;
                while (i < i2) {
                }
                i3 = i - i6;
                return i3 == 0 ? null : null;
            }
            if (i4 != 0) {
                if (StringsKt__StringsJVMKt.startsWith$default(str, ":", i, false, 4, null)) {
                    i++;
                } else {
                    if (!StringsKt__StringsJVMKt.startsWith$default(str, ".", i, false, 4, null) || !decodeIpv4Suffix(str, i6, i2, bArr, i4 - 2)) {
                        return null;
                    }
                    i4 += 2;
                }
            }
            i6 = i;
            int i82 = 0;
            i = i6;
            while (i < i2) {
                int hexDigit = Util.parseHexDigit(str.charAt(i));
                if (hexDigit == -1) {
                    break;
                }
                i82 = (i82 << 4) + hexDigit;
                i++;
            }
            i3 = i - i6;
            if (i3 == 0 && i3 <= 4) {
                int i9 = i4 + 1;
                bArr[i4] = (byte) ((i82 >>> 8) & PHIpAddressSearchManager.END_IP_SCAN);
                i4 += 2;
                bArr[i9] = (byte) (i82 & PHIpAddressSearchManager.END_IP_SCAN);
            }
        }
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < bArr.length) {
            if (i2 == i) {
                buffer.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i2], PHIpAddressSearchManager.END_IP_SCAN) << 8) | Util.and(bArr[i2 + 1], PHIpAddressSearchManager.END_IP_SCAN));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static final String toCanonicalHost(String str) {
        str.getClass();
        if (StringsKt.contains$default(str, ":")) {
            InetAddress inetAddressDecodeIpv6 = (StringsKt.startsWith$default(str, "[") && StringsKt__StringsJVMKt.endsWith$default(str, "]", false, 2, null)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
            if (inetAddressDecodeIpv6 != null) {
                byte[] address = inetAddressDecodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                if (address.length == 4) {
                    return inetAddressDecodeIpv6.getHostAddress();
                }
                Utf8$$ExternalSyntheticBUOutline0.m$1((Object) Fragment$$ExternalSyntheticOutline1.m('\'', "Invalid IPv6 address: '", str));
                return null;
            }
        } else {
            try {
                String ascii = IDN.toASCII(str);
                ascii.getClass();
                Locale locale = Locale.US;
                locale.getClass();
                String lowerCase = ascii.toLowerCase(locale);
                lowerCase.getClass();
                if (lowerCase.length() != 0) {
                    if (!containsInvalidHostnameAsciiCodes(lowerCase)) {
                        return lowerCase;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
