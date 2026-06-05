package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzerb implements zzels {
    private final Context zza;
    private final zzcwq zzb;
    private final zzbjl zzc;
    private final zzhcg zzd;
    private final zzfpk zze;

    public zzerb(Context context, zzcwq zzcwqVar, zzfpk zzfpkVar, zzhcg zzhcgVar, zzbjl zzbjlVar) {
        this.zza = context;
        this.zzb = zzcwqVar;
        this.zze = zzfpkVar;
        this.zzd = zzhcgVar;
        this.zzc = zzbjlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        zzfkk zzfkkVar;
        return (this.zzc == null || (zzfkkVar = zzfkfVar.zzs) == null || zzfkkVar.zza == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        zzeqx zzeqxVar = new zzeqx(this, new View(this.zza), null, zzeqz.zza, (zzfkg) zzfkfVar.zzu.get(0));
        zzcvm zzcvmVarZzf = this.zzb.zzf(new zzcyj(zzfkqVar, zzfkfVar, null), zzeqxVar);
        zzera zzeraVarZzl = zzcvmVarZzf.zzl();
        zzfkk zzfkkVar = zzfkfVar.zzs;
        final zzbjg zzbjgVar = new zzbjg(zzeraVarZzl, zzfkkVar.zzb, zzfkkVar.zza);
        zzfpe zzfpeVar = zzfpe.CUSTOM_RENDER_SYN;
        zzfpk zzfpkVar = this.zze;
        Objects.requireNonNull(zzfpkVar);
        return zzfov.zzd(new zzfoq() { // from class: com.google.android.gms.internal.ads.zzeqy
            @Override // com.google.android.gms.internal.ads.zzfoq
            public final /* synthetic */ void zza() {
                this.zza.zzc(zzbjgVar);
            }
        }, this.zzd, zzfpeVar, zzfpkVar).zzj(zzfpe.CUSTOM_RENDER_ACK).zze(zzhbw.zza(zzcvmVarZzf.zzi())).zzi();
    }

    public final /* synthetic */ void zzc(zzbjg zzbjgVar) {
        this.zzc.zze(zzbjgVar);
    }
}
