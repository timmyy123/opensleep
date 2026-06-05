package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzimp {
    final LinkedHashMap zza;

    public zzimp(int i) {
        this.zza = zzimr.zzc(i);
    }

    public final zzimp zza(Object obj, zzind zzindVar) {
        zzinc.zza(obj, SDKConstants.PARAM_KEY);
        zzinc.zza(zzindVar, "provider");
        this.zza.put(obj, zzindVar);
        return this;
    }
}
