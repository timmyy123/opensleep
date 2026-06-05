package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzabp extends zzabn {
    private static final String zza;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (SecurityException unused) {
        }
        if (!property.matches("\\n|\\r(?:\\n)?")) {
            property = "\n";
        }
        zza = property;
    }

    public static int zze(String str, int i) {
        while (i < str.length()) {
            int i2 = i + 1;
            if (str.charAt(i) != '%') {
                i = i2;
            } else {
                if (i2 >= str.length()) {
                    throw zzabo.zzc("trailing unquoted '%' character", str, i);
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt != '%' && cCharAt != 'n') {
                    return i;
                }
                i += 2;
            }
        }
        return -1;
    }

    public abstract int zzb(zzabm zzabmVar, int i, String str, int i2, int i3, int i4);

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
    
        r0 = r14;
        r4 = zze(r3, r0.zzb(r15, r2, r3, r4, r5, r6));
        r14 = r0;
        r1 = r2;
        r0 = r9;
     */
    @Override // com.google.android.gms.internal.measurement.zzabn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(zzabm zzabmVar) {
        int i;
        int i2;
        int i3;
        int i4;
        String strZzi = zzabmVar.zzi();
        int iZze = zze(strZzi, 0);
        int i5 = 0;
        int i6 = -1;
        while (iZze >= 0) {
            int i7 = iZze + 1;
            int i8 = i7;
            int i9 = 0;
            while (i8 < strZzi.length()) {
                int i10 = i8 + 1;
                char cCharAt = strZzi.charAt(i8);
                char c = (char) (cCharAt - '0');
                if (c >= '\n') {
                    if (cCharAt == '$') {
                        if (i8 - i7 == 0) {
                            throw zzabo.zza("missing index", strZzi, iZze, i10);
                        }
                        if (strZzi.charAt(i7) == '0') {
                            throw zzabo.zza("index has leading zero", strZzi, iZze, i10);
                        }
                        int i11 = i9 - 1;
                        if (i10 == strZzi.length()) {
                            throw zzabo.zzc("unterminated parameter", strZzi, iZze);
                        }
                        strZzi.charAt(i10);
                        i4 = i5;
                        i3 = i8 + 2;
                        i = i10;
                        i2 = i11;
                    } else if (cCharAt != '<') {
                        int i12 = i5 + 1;
                        i = i7;
                        i2 = i5;
                        i3 = i10;
                        i4 = i12;
                    } else {
                        if (i6 == -1) {
                            throw zzabo.zza("invalid relative parameter", strZzi, iZze, i10);
                        }
                        if (i10 == strZzi.length()) {
                            throw zzabo.zzc("unterminated parameter", strZzi, iZze);
                        }
                        strZzi.charAt(i10);
                        i4 = i5;
                        i3 = i8 + 2;
                        i = i10;
                        i2 = i6;
                    }
                    int i13 = i3 - 1;
                    while (i13 < strZzi.length()) {
                        if (((char) ((strZzi.charAt(i13) & (-33)) - 65)) < 26) {
                            break;
                        } else {
                            i13++;
                        }
                    }
                    throw zzabo.zzc("unterminated parameter", strZzi, iZze);
                }
                i9 = (i9 * 10) + c;
                if (i9 >= 1000000) {
                    throw zzabo.zza("index too large", strZzi, iZze, i10);
                }
                i8 = i10;
            }
            throw zzabo.zzc("unterminated parameter", strZzi, iZze);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzabn
    public final void zzd(StringBuilder sb, String str, int i, int i2) {
        int i3 = i;
        while (i < i2) {
            int i4 = i + 1;
            if (str.charAt(i) == '%') {
                if (i4 == i2) {
                    break;
                }
                char cCharAt = str.charAt(i4);
                if (cCharAt == '%') {
                    sb.append((CharSequence) str, i3, i4);
                } else if (cCharAt == 'n') {
                    sb.append((CharSequence) str, i3, i);
                    sb.append(zza);
                }
                i3 = i + 2;
                i = i3;
            }
            i = i4;
        }
        if (i3 < i2) {
            sb.append((CharSequence) str, i3, i2);
        }
    }
}
