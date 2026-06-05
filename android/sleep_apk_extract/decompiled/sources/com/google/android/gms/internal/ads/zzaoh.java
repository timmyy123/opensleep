package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
final class zzaoh {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzgww zze = zzgww.zzj("auto", IntegrityManager.INTEGRITY_TYPE_NONE);
    private static final zzgww zzf = zzgww.zzk("dot", "sesame", "circle");
    private static final zzgww zzg = zzgww.zzj("filled", "open");
    private static final zzgww zzh = zzgww.zzk("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaoh(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzaoh zza(String str) {
        int i;
        if (str == null) {
            return null;
        }
        String strZza = zzgss.zza(str.trim());
        if (strZza.isEmpty()) {
            return null;
        }
        zzgww zzgwwVarZzq = zzgww.zzq(TextUtils.split(strZza, zzd));
        String str2 = (String) zzgxa.zzb(zzgyw.zza(zzh, zzgwwVarZzq), "outside");
        int iHashCode = str2.hashCode();
        int i2 = 1;
        if (iHashCode != -1106037339) {
            i = (iHashCode == 92734940 && str2.equals("after")) ? 2 : 1;
        } else if (str2.equals("outside")) {
            i = -2;
        }
        zzgyv zzgyvVarZza = zzgyw.zza(zze, zzgwwVarZzq);
        int i3 = 0;
        if (zzgyvVarZza.isEmpty()) {
            zzgyv zzgyvVarZza2 = zzgyw.zza(zzg, zzgwwVarZzq);
            zzgyv zzgyvVarZza3 = zzgyw.zza(zzf, zzgwwVarZzq);
            if (!zzgyvVarZza2.isEmpty() || !zzgyvVarZza3.isEmpty()) {
                String str3 = (String) zzgxa.zzb(zzgyvVarZza2, "filled");
                i3 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzgxa.zzb(zzgyvVarZza3, "circle");
                int iHashCode2 = str4.hashCode();
                if (iHashCode2 != -905816648) {
                    if (iHashCode2 == 99657 && str4.equals("dot")) {
                        i2 = 2;
                    }
                } else if (str4.equals("sesame")) {
                    i2 = 3;
                }
            }
        } else {
            String str5 = (String) zzgyvVarZza.iterator().next();
            i2 = (str5.hashCode() == 3387192 && str5.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) ? 0 : -1;
        }
        return new zzaoh(i2, i3, i);
    }
}
