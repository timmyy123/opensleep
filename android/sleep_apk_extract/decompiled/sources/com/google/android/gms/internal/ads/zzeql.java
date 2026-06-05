package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeql implements zzely {
    private final Context zza;
    private final Executor zzb;
    private final zzdvr zzc;

    public zzeql(Context context, Executor executor, zzdvr zzdvrVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdvrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        try {
            ((zzflw) zzelvVar.zzb).zzl(zzfkqVar.zza.zza.zzd, zzfkfVar.zzv.toString());
        } catch (Exception e) {
            String str = zzelvVar.zza;
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        zzflw zzflwVar = (zzflw) zzelvVar.zzb;
        if (zzflwVar.zzn()) {
            zze(zzfkqVar, zzfkfVar, zzelvVar);
            return;
        }
        zzeqi zzeqiVar = new zzeqi(this, zzfkqVar, zzfkfVar, zzelvVar);
        zzdeb zzdebVar = zzelvVar.zzc;
        ((zzeni) zzdebVar).zzd(zzeqiVar);
        Context context = this.zza;
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        String string = zzfkfVar.zzv.toString();
        zzflwVar.zzk(context, zzfkyVar.zzd, null, (zzcca) zzdebVar, string);
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        zzdvn zzdvnVarZzf = this.zzc.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdvo(new zzeqj(this, zzelvVar, zzfkfVar)));
        zzdvnVarZzf.zza().zzq(new zzcsz((zzflw) zzelvVar.zzb), this.zzb);
        zzddy zzddyVarZzb = zzdvnVarZzf.zzb();
        zzdcp zzdcpVarZzc = zzdvnVarZzf.zzc();
        ((zzeni) zzelvVar.zzc).zzc(new zzeqk(this, zzdvnVarZzf.zzi(), zzdcpVarZzc, zzddyVarZzb, zzdvnVarZzf.zzk()));
        return zzdvnVarZzf.zzh();
    }

    public final /* synthetic */ Executor zzc() {
        return this.zzb;
    }
}
