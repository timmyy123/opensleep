package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzclk {
    public static final zzcku zza(final Context context, final zzcne zzcneVar, final String str, final boolean z, final boolean z2, final zzbap zzbapVar, final zzbjx zzbjxVar, final VersionInfoParcel versionInfoParcel, zzbjf zzbjfVar, final com.google.android.gms.ads.internal.zzn zznVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzbhp zzbhpVar, final zzfkf zzfkfVar, final zzfki zzfkiVar, final zzekr zzekrVar, final zzflc zzflcVar, final zzdzl zzdzlVar) throws zzclj {
        zzbiq.zza(context);
        try {
            final zzbjf zzbjfVar2 = null;
            zzgub zzgubVar = new zzgub(context, zzcneVar, str, z, z2, zzbapVar, zzbjxVar, versionInfoParcel, zzbjfVar2, zznVar, zzaVar, zzbhpVar, zzfkfVar, zzfkiVar, zzflcVar, zzdzlVar, zzekrVar) { // from class: com.google.android.gms.internal.ads.zzclg
                private final /* synthetic */ Context zza;
                private final /* synthetic */ zzcne zzb;
                private final /* synthetic */ String zzc;
                private final /* synthetic */ boolean zzd;
                private final /* synthetic */ boolean zze;
                private final /* synthetic */ zzbap zzf;
                private final /* synthetic */ zzbjx zzg;
                private final /* synthetic */ VersionInfoParcel zzh;
                private final /* synthetic */ com.google.android.gms.ads.internal.zzn zzi;
                private final /* synthetic */ com.google.android.gms.ads.internal.zza zzj;
                private final /* synthetic */ zzbhp zzk;
                private final /* synthetic */ zzfkf zzl;
                private final /* synthetic */ zzfki zzm;
                private final /* synthetic */ zzflc zzn;
                private final /* synthetic */ zzdzl zzo;
                private final /* synthetic */ zzekr zzp;

                {
                    this.zzi = zznVar;
                    this.zzj = zzaVar;
                    this.zzk = zzbhpVar;
                    this.zzl = zzfkfVar;
                    this.zzm = zzfkiVar;
                    this.zzn = zzflcVar;
                    this.zzo = zzdzlVar;
                    this.zzp = zzekrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzgub
                public final /* synthetic */ Object zza() {
                    zzcne zzcneVar2 = this.zzb;
                    String str2 = this.zzc;
                    boolean z3 = this.zzd;
                    boolean z4 = this.zze;
                    zzekr zzekrVar2 = this.zzp;
                    zzdzl zzdzlVar2 = this.zzo;
                    com.google.android.gms.ads.internal.zzn zznVar2 = this.zzi;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.zzj;
                    zzbhp zzbhpVar2 = this.zzk;
                    zzfkf zzfkfVar2 = this.zzl;
                    zzfki zzfkiVar2 = this.zzm;
                    zzflc zzflcVar2 = this.zzn;
                    zzbap zzbapVar2 = this.zzf;
                    zzbjx zzbjxVar2 = this.zzg;
                    VersionInfoParcel versionInfoParcel2 = this.zzh;
                    Context context2 = this.zza;
                    try {
                        TrafficStats.setThreadStatsTag(264);
                        int i = zzclx.$r8$clinit;
                        zzclq zzclqVar = new zzclq(new zzclx(new zzcmw(context2), zzcneVar2, str2, z3, z4, zzbapVar2, zzbjxVar2, versionInfoParcel2, null, zznVar2, zzaVar2, zzbhpVar2, zzfkfVar2, zzfkiVar2, zzflcVar2), zzdzlVar2);
                        zzclqVar.setWebViewClient(com.google.android.gms.ads.internal.zzt.zzf().zzb(zzclqVar, zzbhpVar2, z4, zzekrVar2));
                        zzclqVar.setWebChromeClient(new zzckt(zzclqVar));
                        return zzclqVar;
                    } finally {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            };
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                Object objZza = zzgubVar.zza();
                StrictMode.setThreadPolicy(threadPolicy);
                return (zzcku) objZza;
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        } catch (Throwable th2) {
            throw new zzclj("Webview initialization failed.", th2);
        }
    }

    public static final ListenableFuture zzb(final Context context, final VersionInfoParcel versionInfoParcel, final String str, final zzbap zzbapVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzekr zzekrVar, final zzflc zzflcVar, final zzdzl zzdzlVar) {
        return zzhbw.zzf(new zzhbd() { // from class: com.google.android.gms.internal.ads.zzcli
            @Override // com.google.android.gms.internal.ads.zzhbd
            public final /* synthetic */ ListenableFuture zza() throws zzclj {
                com.google.android.gms.ads.internal.zzt.zzd();
                Context context2 = context;
                zzcne zzcneVarZzb = zzcne.zzb();
                com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                zzbhp zzbhpVarZza = zzbhp.zza();
                zzekr zzekrVar2 = zzekrVar;
                zzflc zzflcVar2 = zzflcVar;
                zzdzl zzdzlVar2 = zzdzlVar;
                zzcku zzckuVarZza = zzclk.zza(context2, zzcneVarZzb, "", false, false, zzbapVar, null, versionInfoParcel, null, null, zzaVar2, zzbhpVarZza, null, null, zzekrVar2, zzflcVar2, zzdzlVar2);
                final zzcfv zzcfvVarZza = zzcfv.zza(zzckuVarZza);
                zzckuVarZza.zzP().zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzclh
                    @Override // com.google.android.gms.internal.ads.zzcmq
                    public final /* synthetic */ void zza(boolean z, int i, String str2, String str3) {
                        zzcfvVarZza.zzb();
                    }
                });
                zzckuVarZza.loadUrl(str);
                return zzcfvVarZza;
            }
        }, zzcfr.zzf);
    }
}
