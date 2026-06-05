package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class zzaoe {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzaoe(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0117 A[Catch: RuntimeException -> 0x00ba, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00ba, blocks: (B:33:0x00c0, B:35:0x00c6, B:39:0x00d6, B:41:0x00da, B:45:0x00e9, B:47:0x00ed, B:51:0x00fe, B:53:0x0102, B:57:0x0113, B:59:0x0117, B:60:0x011f, B:68:0x013d, B:66:0x0130, B:28:0x00a1, B:23:0x008d), top: B:73:0x008d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzaoe zza(String str, zzaoc zzaocVar) {
        zzaoe zzaoeVar;
        float f;
        int i;
        boolean z;
        int i2;
        int i3;
        zzgtj.zza(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i4 = zzaocVar.zzk;
        if (length != i4) {
            String str2 = zzfl.zza;
            Locale locale = Locale.US;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i4, length, "Skipping malformed 'Style:' line (expected ", " values, found ", "): '");
            sbM.append(str);
            sbM.append("'");
            zzeg.zzc("SsaStyle", sbM.toString());
            return null;
        }
        try {
            String strTrim = strArrSplit[zzaocVar.zza].trim();
            int i5 = zzaocVar.zzb;
            int iZzd = i5 != -1 ? zzd(strArrSplit[i5].trim()) : -1;
            int i6 = zzaocVar.zzc;
            Integer numZzb = i6 != -1 ? zzb(strArrSplit[i6].trim()) : null;
            int i7 = zzaocVar.zzd;
            Integer numZzb2 = i7 != -1 ? zzb(strArrSplit[i7].trim()) : null;
            int i8 = zzaocVar.zze;
            if (i8 != -1) {
                String strTrim2 = strArrSplit[i8].trim();
                try {
                    try {
                        f = Float.parseFloat(strTrim2);
                        zzaoeVar = null;
                    } catch (NumberFormatException e) {
                        zzaoeVar = null;
                        StringBuilder sb = new StringBuilder(String.valueOf(strTrim2).length() + 29);
                        sb.append("Failed to parse font size: '");
                        sb.append(strTrim2);
                        sb.append("'");
                        zzeg.zzd("SsaStyle", sb.toString(), e);
                        f = -3.4028235E38f;
                    }
                    i = zzaocVar.zzf;
                    boolean z2 = false;
                    if (i == -1 && zze(strArrSplit[i].trim())) {
                        z = false;
                        z2 = true;
                    } else {
                        z = false;
                    }
                    int i9 = zzaocVar.zzg;
                    boolean z3 = (i9 == -1 && zze(strArrSplit[i9].trim())) ? true : z;
                    int i10 = zzaocVar.zzh;
                    boolean z4 = i10 == -1 && zze(strArrSplit[i10].trim());
                    int i11 = zzaocVar.zzi;
                    boolean z5 = i11 == -1 && zze(strArrSplit[i11].trim());
                    i2 = zzaocVar.zzj;
                    if (i2 == -1) {
                        String strTrim3 = strArrSplit[i2].trim();
                        try {
                            int i12 = Integer.parseInt(strTrim3.trim());
                            if (i12 == 1 || i12 == 3) {
                                i3 = i12;
                            }
                        } catch (NumberFormatException unused) {
                        }
                        zzeg.zzc("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(strTrim3)));
                        i3 = -1;
                    } else {
                        i3 = -1;
                    }
                    return new zzaoe(strTrim, iZzd, numZzb, numZzb2, f, z2, z3, z4, z5, i3);
                } catch (RuntimeException e2) {
                    e = e2;
                    zzeg.zzd("SsaStyle", Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str.length() + 36), "Skipping malformed 'Style:' line: '", str, "'"), e);
                    return zzaoeVar;
                }
            }
            zzaoeVar = null;
            f = -3.4028235E38f;
            i = zzaocVar.zzf;
            boolean z22 = false;
            if (i == -1) {
                z = false;
            }
            int i92 = zzaocVar.zzg;
            if (i92 == -1) {
            }
            int i102 = zzaocVar.zzh;
            if (i102 == -1) {
            }
            int i112 = zzaocVar.zzi;
            if (i112 == -1) {
            }
            i2 = zzaocVar.zzj;
            if (i2 == -1) {
            }
            return new zzaoe(strTrim, iZzd, numZzb, numZzb2, f, z22, z3, z4, z5, i3);
        } catch (RuntimeException e3) {
            e = e3;
            zzaoeVar = null;
        }
    }

    public static Integer zzb(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzgtj.zza(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzhah.zza(((j >> 24) & 255) ^ 255), zzhah.zza(j & 255), zzhah.zza((j >> 8) & 255), zzhah.zza((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzeg.zzd("SsaStyle", Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 36), "Failed to parse color expression: '", str, "'"), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        int i;
        try {
            i = Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return i;
            default:
                zzba$$ExternalSyntheticOutline0.m(str, "Ignoring unknown alignment: ", "SsaStyle");
                return -1;
        }
    }

    private static boolean zze(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            zzeg.zzd("SsaStyle", Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 33), "Failed to parse boolean value: '", str, "'"), e);
            return false;
        }
    }
}
