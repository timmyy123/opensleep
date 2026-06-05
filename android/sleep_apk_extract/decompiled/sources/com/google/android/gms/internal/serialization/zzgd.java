package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgd {
    private static final zzgg zza = new zzgb();
    private static final zzgf zzb = new zzgc();
    private final zzgg zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzgf zzf = null;

    public final zzgd zza(zzgf zzgfVar) {
        this.zzf = zzgfVar;
        return this;
    }

    public final void zzb(zzfc zzfcVar) {
        zzhy.zza(zzfcVar, SDKConstants.PARAM_KEY);
        if (!zzfcVar.zzf()) {
            zzgg zzggVar = zza;
            zzhy.zza(zzfcVar, SDKConstants.PARAM_KEY);
            this.zzd.remove(zzfcVar);
            this.zzc.put(zzfcVar, zzggVar);
            return;
        }
        zzgf zzgfVar = zzb;
        zzhy.zza(zzfcVar, SDKConstants.PARAM_KEY);
        zzhy.zzb(zzfcVar.zzf(), "key must be repeating");
        this.zzc.remove(zzfcVar);
        this.zzd.put(zzfcVar, zzgfVar);
    }

    public final zzgh zzc() {
        return new zzge(this, null);
    }

    public final /* synthetic */ Map zzd() {
        return this.zzc;
    }

    public final /* synthetic */ Map zze() {
        return this.zzd;
    }

    public final /* synthetic */ zzgg zzf() {
        return this.zze;
    }

    public final /* synthetic */ zzgf zzg() {
        return this.zzf;
    }
}
