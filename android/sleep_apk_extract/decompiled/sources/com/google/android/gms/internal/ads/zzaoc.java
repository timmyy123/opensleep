package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
final class zzaoc {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;

    private zzaoc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = i7;
        this.zzh = i8;
        this.zzi = i9;
        this.zzj = i10;
        this.zzk = i11;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzaoc zza(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i >= length) {
                if (i2 != -1) {
                    return new zzaoc(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, length);
                }
                return null;
            }
            String strZza = zzgss.zza(strArrSplit[i].trim());
            switch (strZza.hashCode()) {
                case -1178781136:
                    if (strZza.equals("italic")) {
                        i8 = i;
                    }
                    break;
                case -1026963764:
                    if (strZza.equals("underline")) {
                        i9 = i;
                    }
                    break;
                case -192095652:
                    if (strZza.equals("strikeout")) {
                        i10 = i;
                    }
                    break;
                case -70925746:
                    if (strZza.equals("primarycolour")) {
                        i4 = i;
                    }
                    break;
                case 3029637:
                    if (strZza.equals("bold")) {
                        i7 = i;
                    }
                    break;
                case 3373707:
                    if (strZza.equals("name")) {
                        i2 = i;
                    }
                    break;
                case 366554320:
                    if (strZza.equals("fontsize")) {
                        i6 = i;
                    }
                    break;
                case 767321349:
                    if (strZza.equals("borderstyle")) {
                        i11 = i;
                    }
                    break;
                case 1767875043:
                    if (strZza.equals("alignment")) {
                        i3 = i;
                    }
                    break;
                case 1988365454:
                    if (strZza.equals("outlinecolour")) {
                        i5 = i;
                    }
                    break;
            }
            i++;
        }
    }
}
