package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: loaded from: classes3.dex */
final class zzaoa {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzaoa(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzaoa zza(String str) {
        zzgtj.zza(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i >= length) {
                if (i3 == -1 || i4 == -1 || i6 == -1) {
                    return null;
                }
                return new zzaoa(i2, i3, i4, i5, i6, length);
            }
            String strZza = zzgss.zza(strArrSplit[i].trim());
            switch (strZza.hashCode()) {
                case 100571:
                    if (strZza.equals("end")) {
                        i4 = i;
                    }
                    break;
                case 3556653:
                    if (strZza.equals("text")) {
                        i6 = i;
                    }
                    break;
                case 102749521:
                    if (strZza.equals("layer")) {
                        i2 = i;
                    }
                    break;
                case 109757538:
                    if (strZza.equals("start")) {
                        i3 = i;
                    }
                    break;
                case 109780401:
                    if (strZza.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                        i5 = i;
                    }
                    break;
            }
            i++;
        }
    }
}
