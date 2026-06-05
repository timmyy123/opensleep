package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdae implements zzdfx, zzdlk {
    private zzcaw zza;
    private final Context zzc;
    private final zzfqj zzd;
    private final VersionInfoParcel zze;
    private final Executor zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final AtomicBoolean zzb = new AtomicBoolean();

    public zzdae(Context context, zzfqj zzfqjVar, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zzc = context;
        this.zzd = zzfqjVar;
        this.zze = versionInfoParcel;
        this.zzf = executor;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc() {
        zzcaw zzcawVar;
        int i;
        int i2;
        zzbui zzbuiVarZzb;
        if (!this.zzb.getAndSet(true)) {
            if (((Boolean) zzbkq.zzo.zze()).booleanValue()) {
                i = 2;
                i2 = i - 1;
                if (i2 != 1) {
                    zzbuiVarZzb = com.google.android.gms.ads.internal.zzt.zzr().zzb(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
                } else if (i2 == 2) {
                    zzbuiVarZzb = com.google.android.gms.ads.internal.zzt.zzr().zza(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
                }
                zzbuc zzbucVar = zzbuf.zza;
                this.zza = new zzcaz(this.zzc, zzbuiVarZzb.zza("google.afma.sdkConstants.getSdkConstants", zzbucVar, zzbucVar), this.zze, this.zzf);
                this.zzg = true;
            } else {
                i = 3;
                if (!((Boolean) zzbkq.zzp.zze()).booleanValue()) {
                    if (((Boolean) zzbkq.zzn.zze()).booleanValue()) {
                        try {
                            String strOptString = new JSONObject(com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzd()).optString("local_flag_write");
                            if (TextUtils.equals(strOptString, "client")) {
                                i = 2;
                            } else if (!TextUtils.equals(strOptString, "service")) {
                            }
                        } catch (JSONException unused) {
                        }
                        i = 1;
                    } else {
                        i = 1;
                    }
                }
                i2 = i - 1;
                if (i2 != 1) {
                }
                zzbuc zzbucVar2 = zzbuf.zza;
                this.zza = new zzcaz(this.zzc, zzbuiVarZzb.zza("google.afma.sdkConstants.getSdkConstants", zzbucVar2, zzbucVar2), this.zze, this.zzf);
                this.zzg = true;
            }
        }
        if (this.zzg && (zzcawVar = this.zza) != null) {
            ListenableFuture listenableFutureZzb = zzcawVar.zzb();
            if (!this.zzh && ((Boolean) zzbki.zzi.zze()).booleanValue()) {
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdad
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzf();
                    }
                }, this.zzf);
            }
            zzcfu.zza(listenableFutureZzb, "persistFlagsClient", zzcfr.zzh);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zzd(com.google.android.gms.ads.nonagon.signalgeneration.zzbc zzbcVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zze(String str) {
        zzc();
    }

    public final /* synthetic */ void zzf() {
        zzbib.zze(this.zzc);
        this.zzh = true;
    }
}
