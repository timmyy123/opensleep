package com.google.android.gms.internal.serialization;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.annotation.CheckForNull;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzig {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzcy zzb = zzcy.zzb('.');
    private static final zzcy zzc = zzcy.zzb(':');

    static {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r6 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        if (r5 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r5 = r16.lastIndexOf(58) + 1;
        r12 = r16.substring(0, r5);
        r5 = zzb(r16.substring(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r5 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        r13 = java.lang.Integer.toHexString(((r5[0] & 255) << 8) | (r5[1] & 255));
        r5 = java.lang.Integer.toHexString((r5[3] & 255) | ((r5[2] & 255) << 8));
        r2 = androidx.fragment.app.Fragment$$ExternalSyntheticOutline1.m(new java.lang.StringBuilder(((java.lang.String.valueOf(r13).length() + r12.length()) + 1) + java.lang.String.valueOf(r5).length()), r12, r13, ":", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
    
        r2 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
    
        if (r4 == (-1)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        r1.zzb(r2.substring(r4 + 1));
        r2 = r2.substring(0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
    
        r4 = com.google.android.gms.internal.serialization.zzig.zzc.zzc(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
    
        if (r4 < 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
    
        if (r4 <= 8) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
    
        r4 = r4 + 1;
        r5 = 8 - r4;
        r6 = 0;
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bf, code lost:
    
        if (r6 >= (r2.length() - 1)) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c5, code lost:
    
        if (r2.charAt(r6) != ':') goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cd, code lost:
    
        if (r2.charAt(r6 + 1) != ':') goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
    
        if (r12 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:
    
        r12 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d4, code lost:
    
        if (r6 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d6, code lost:
    
        r12 = r5 + 2;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
    
        if (r6 != (r2.length() - 2)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e1, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
    
        r5 = r12;
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
    
        r6 = r6 + 1;
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00eb, code lost:
    
        if (r2.charAt(0) != ':') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f1, code lost:
    
        if (r2.charAt(1) == ':') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fd, code lost:
    
        if (r2.charAt(r2.length() - 1) != ':') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0109, code lost:
    
        if (r2.charAt(r2.length() - 2) == ':') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010c, code lost:
    
        if (r12 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010e, code lost:
    
        if (r5 > 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0111, code lost:
    
        if (r4 == 8) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0114, code lost:
    
        r4 = java.nio.ByteBuffer.allocate(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011c, code lost:
    
        if (r2.charAt(0) != ':') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011f, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0124, code lost:
    
        if (r11 >= r2.length()) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0126, code lost:
    
        r6 = r2.indexOf(58, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012a, code lost:
    
        if (r6 != (-1)) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012c, code lost:
    
        r6 = r2.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0134, code lost:
    
        if (r2.charAt(r11) != ':') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0136, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0137, code lost:
    
        if (r7 >= r5) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0139, code lost:
    
        r4.putShort(0);
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x013f, code lost:
    
        r7 = r6 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0141, code lost:
    
        if (r7 <= 0) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0144, code lost:
    
        if (r7 > 4) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0146, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0147, code lost:
    
        if (r11 >= r6) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0149, code lost:
    
        r7 = (r7 << 4) | java.lang.Character.digit(r2.charAt(r11), 16);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0157, code lost:
    
        r4.putShort((short) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x015b, code lost:
    
        r11 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0163, code lost:
    
        throw new java.lang.NumberFormatException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0164, code lost:
    
        r2 = r4.array();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0169, code lost:
    
        if (r5 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x016b, code lost:
    
        if (r4 == (-1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x016f, code lost:
    
        r2 = zzb(r16);
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress zza(String str) {
        String strSubstring = null;
        bArrZzb = null;
        byte[] bArrZzb = null;
        zzif zzifVar = new zzif(null);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i2 = 1;
            if (i >= str.length()) {
                i = -1;
                break;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt != '.') {
                if (cCharAt != ':') {
                    if (cCharAt == '%') {
                        break;
                    }
                    if (Character.digit(cCharAt, 16) == -1) {
                        break;
                    }
                } else {
                    if (z) {
                        break;
                    }
                    z = false;
                    z2 = true;
                }
            } else {
                z = true;
            }
            i++;
            z = z;
            z2 = z2;
        }
        if (bArrZzb != null) {
            return zzc(bArrZzb, zzifVar.zza());
        }
        throw zzd("'%s' is not an IP string literal.", str);
    }

    @CheckForNull
    private static byte[] zzb(String str) {
        if (zzb.zzc(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int iIndexOf = str.indexOf(46, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int i3 = iIndexOf - i;
            if (i3 <= 0 || i3 > 3) {
                throw new NumberFormatException();
            }
            if (i3 > 1) {
                try {
                    if (str.charAt(i) == '0') {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            int i4 = 0;
            while (i < iIndexOf) {
                int i5 = i4 * 10;
                int iDigit = Character.digit(str.charAt(i), 10);
                if (iDigit < 0) {
                    throw new NumberFormatException();
                }
                i4 = i5 + iDigit;
                i++;
            }
            if (i4 > 255) {
                throw new NumberFormatException();
            }
            bArr[i2] = (byte) i4;
            i = iIndexOf + 1;
        }
        return bArr;
    }

    private static InetAddress zzc(byte[] bArr, String str) {
        try {
            InetAddress byAddress = InetAddress.getByAddress(bArr);
            if (str == null) {
                return byAddress;
            }
            zzdf.zza(byAddress instanceof Inet6Address, "Unexpected state, scope should only appear for ipv6");
            Inet6Address inet6Address = (Inet6Address) byAddress;
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (i <= 214748364) {
                    int i3 = i * 10;
                    int iDigit = Character.digit(str.charAt(i2), 10);
                    if (iDigit >= 0) {
                        i = i3 + iDigit;
                    }
                }
                i = -1;
            }
            if (i != -1) {
                return Inet6Address.getByAddress(inet6Address.getHostAddress(), inet6Address.getAddress(), i);
            }
            try {
                NetworkInterface byName = NetworkInterface.getByName(str);
                if (byName != null) {
                    return Inet6Address.getByAddress(inet6Address.getHostAddress(), inet6Address.getAddress(), byName);
                }
                throw zzd("No such interface: '%s'", str);
            } catch (SocketException e) {
                e = e;
                StringBuilder sb = new StringBuilder(str.length() + 19);
                sb.append("No such interface: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString(), e);
            } catch (UnknownHostException e2) {
                e = e2;
                StringBuilder sb2 = new StringBuilder(str.length() + 19);
                sb2.append("No such interface: ");
                sb2.append(str);
                throw new IllegalArgumentException(sb2.toString(), e);
            }
        } catch (UnknownHostException e3) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e3);
            return null;
        }
    }

    private static IllegalArgumentException zzd(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }
}
