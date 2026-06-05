package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdux {
    private final com.google.android.gms.ads.internal.zza zzb;
    private final Context zzc;
    private final zzdzl zzd;
    private final Executor zze;
    private final zzbap zzf;
    private final VersionInfoParcel zzg;
    private final zzekg zzi;
    private final zzfsc zzj;
    private final zzekr zzk;
    private final zzflc zzl;
    private ListenableFuture zzm;
    private final zzdul zza = new zzdul();
    private final zzbqh zzh = new zzbqh();

    public zzdux(zzduv zzduvVar) {
        this.zzc = zzduvVar.zzb();
        this.zze = zzduvVar.zze();
        this.zzf = zzduvVar.zzf();
        this.zzg = zzduvVar.zzg();
        this.zzb = zzduvVar.zza();
        this.zzi = zzduvVar.zzd();
        this.zzj = zzduvVar.zzh();
        this.zzd = zzduvVar.zzc();
        this.zzk = zzduvVar.zzi();
        this.zzl = zzduvVar.zzj();
    }

    public final synchronized void zza() {
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeF);
        zzbap zzbapVar = this.zzf;
        com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        zzekr zzekrVar = this.zzk;
        ListenableFuture listenableFutureZzk = zzhbw.zzk(zzclk.zzb(this.zzc, this.zzg, str, zzbapVar, zzaVar, zzekrVar, this.zzl, this.zzd), new zzgta() { // from class: com.google.android.gms.internal.ads.zzduu
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                zzcku zzckuVar = (zzcku) obj;
                this.zza.zzi(zzckuVar);
                return zzckuVar;
            }
        }, this.zze);
        this.zzm = listenableFutureZzk;
        zzcfu.zza(listenableFutureZzk, "NativeJavascriptExecutor.initializeEngine", zzcfr.zzh);
    }

    public final synchronized void zzb() {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzhbw.zzr(listenableFuture, new zzdum(this), this.zze);
        this.zzm = null;
    }

    public final synchronized ListenableFuture zzc(final String str, final JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return zzhbw.zza(null);
        }
        return zzhbw.zzj(listenableFuture, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdut
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzj(str, jSONObject, (zzcku) obj);
            }
        }, this.zze);
    }

    public final synchronized void zzd(String str, zzbpq zzbpqVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzhbw.zzr(listenableFuture, new zzdun(this, str, zzbpqVar), this.zze);
    }

    public final synchronized void zze(String str, zzbpq zzbpqVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzhbw.zzr(listenableFuture, new zzduo(this, str, zzbpqVar), this.zze);
    }

    public final synchronized void zzf(String str, Map map) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzhbw.zzr(listenableFuture, new zzdup(this, "sendMessageToNativeJs", map), this.zze);
    }

    public final synchronized void zzg(zzfkf zzfkfVar, zzfki zzfkiVar, zzctj zzctjVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzhbw.zzr(listenableFuture, new zzduq(this, zzfkfVar, zzfkiVar, zzctjVar), this.zze);
    }

    public final void zzh(WeakReference weakReference, String str, zzbpq zzbpqVar) {
        zzd(str, new zzduw(this, weakReference, str, zzbpqVar, null));
    }

    public final /* synthetic */ zzcku zzi(zzcku zzckuVar) {
        zzckuVar.zzab("/result", this.zzh);
        zzcms zzcmsVarZzP = zzckuVar.zzP();
        com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzc, null, null);
        zzekg zzekgVar = this.zzi;
        zzfsc zzfscVar = this.zzj;
        zzdzl zzdzlVar = this.zzd;
        zzdul zzdulVar = this.zza;
        zzcmsVarZzP.zzab(null, zzdulVar, zzdulVar, zzdulVar, zzdulVar, false, null, zzbVar, null, null, zzekgVar, zzfscVar, zzdzlVar, null, null, null, null, null, null, null, null, null);
        return zzckuVar;
    }

    public final /* synthetic */ ListenableFuture zzj(String str, JSONObject jSONObject, zzcku zzckuVar) {
        return this.zzh.zzc(zzckuVar, str, jSONObject);
    }

    public final /* synthetic */ zzdul zzk() {
        return this.zza;
    }

    public final /* synthetic */ zzdzl zzl() {
        return this.zzd;
    }

    public final /* synthetic */ zzekg zzm() {
        return this.zzi;
    }

    public final /* synthetic */ zzfsc zzn() {
        return this.zzj;
    }
}
