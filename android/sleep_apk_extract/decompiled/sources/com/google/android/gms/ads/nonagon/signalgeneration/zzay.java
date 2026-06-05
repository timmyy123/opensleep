package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdbx;
import com.google.android.gms.internal.ads.zzdln;
import com.google.android.gms.internal.ads.zzfor;
import com.google.android.gms.internal.ads.zzfpe;
import com.google.android.gms.internal.ads.zzfpk;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzay implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;

    private zzay(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
    }

    public static zzay zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzay(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfpk zzfpkVar = (zzfpk) this.zza.zzb();
        zzba zzbaVarZzb = ((zzbb) this.zzb).zzb();
        zzdbw zzdbwVarZzb = ((zzdbx) this.zzc).zzb();
        zzdln zzdlnVar = (zzdln) this.zzd.zzb();
        zzfor zzforVarZzi = zzfpkVar.zza(zzfpe.GENERATE_SIGNALS, zzdbwVarZzb.zzb()).zzc(zzbaVarZzb).zzh(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS).zzi();
        zzhbw.zzr(zzforVarZzi, new zzar(zzdlnVar), zzcfr.zza);
        return zzforVarZzi;
    }
}
