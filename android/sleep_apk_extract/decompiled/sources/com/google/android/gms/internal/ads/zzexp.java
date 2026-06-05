package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzexp implements zzimu {
    public static zzexp zza() {
        return zzexo.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        List arrayList = new ArrayList();
        zzbih zzbihVar = zzbiq.zznj;
        if (!((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).isEmpty()) {
            arrayList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).split(","));
        }
        zzinc.zzb(arrayList);
        return arrayList;
    }
}
