package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzahm {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhaf zzb = zzhaf.zzb(0, 2, 1);
    private static final zzhaf zzc = zzhaf.zzc(0, 2, 1, 3, 4);
    private static final zzhaf zzd = zzhaf.zzd(0, 2, 1, 5, 3, 4);
    private static final zzhaf zze = zzhaf.zze(0, 2, 1, 6, 5, 3, 4);
    private static final zzhaf zzf = zzhaf.zze(0, 2, 1, 7, 5, 6, 3, 4);

    public static zzhaf zza(int i) {
        if (i == 3) {
            return zzb;
        }
        if (i == 5) {
            return zzc;
        }
        if (i == 6) {
            return zzd;
        }
        if (i == 7) {
            return zze;
        }
        if (i != 8) {
            return null;
        }
        return zzf;
    }

    public static zzap zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String str2 = zzfl.zza;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                zzeg.zzc("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzajc.zzb(new zzet(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e) {
                    zzeg.zzd("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzajy(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzap(arrayList);
    }
}
