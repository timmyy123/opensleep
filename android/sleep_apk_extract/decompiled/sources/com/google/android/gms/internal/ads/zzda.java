package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.Spanned;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzda {
    private static final String zza;
    private static final String zzb;
    private static final String zzc;
    private static final String zzd;
    private static final String zze;

    static {
        String str = zzfl.zza;
        zza = Integer.toString(0, 36);
        zzb = Integer.toString(1, 36);
        zzc = Integer.toString(2, 36);
        zzd = Integer.toString(3, 36);
        zze = Integer.toString(4, 36);
    }

    public static ArrayList zza(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (zzdc zzdcVar : (zzdc[]) spanned.getSpans(0, spanned.length(), zzdc.class)) {
            arrayList.add(zzb(spanned, zzdcVar, 1, zzdcVar.zza()));
        }
        for (zzde zzdeVar : (zzde[]) spanned.getSpans(0, spanned.length(), zzde.class)) {
            arrayList.add(zzb(spanned, zzdeVar, 2, zzdeVar.zza()));
        }
        for (zzdb zzdbVar : (zzdb[]) spanned.getSpans(0, spanned.length(), zzdb.class)) {
            arrayList.add(zzb(spanned, zzdbVar, 3, null));
        }
        for (zzdf zzdfVar : (zzdf[]) spanned.getSpans(0, spanned.length(), zzdf.class)) {
            arrayList.add(zzb(spanned, zzdfVar, 4, zzdfVar.zza()));
        }
        return arrayList;
    }

    private static Bundle zzb(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(zza, spanned.getSpanStart(obj));
        bundle2.putInt(zzb, spanned.getSpanEnd(obj));
        bundle2.putInt(zzc, spanned.getSpanFlags(obj));
        bundle2.putInt(zzd, i);
        if (bundle != null) {
            bundle2.putBundle(zze, bundle);
        }
        return bundle2;
    }
}
