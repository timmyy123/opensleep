package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfgy implements zzfhw {
    private zzdbz zza;
    private final Executor zzb = zzhcn.zza();

    public final zzdbz zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzfhx zzfhxVar, zzfhv zzfhvVar, zzdbz zzdbzVar) {
        zzdby zzdbyVarZza = zzfhvVar.zza(zzfhxVar.zzb);
        zzdbyVarZza.zzj(new zzfia(true));
        zzdbz zzdbzVar2 = (zzdbz) zzdbyVarZza.zzh();
        this.zza = zzdbzVar2;
        final zzcyx zzcyxVarZza = zzdbzVar2.zza();
        final zzfmw zzfmwVar = new zzfmw();
        zzhbo zzhboVarZzw = zzhbo.zzw(zzcyxVarZza.zzb());
        zzhbe zzhbeVar = new zzhbe(this) { // from class: com.google.android.gms.internal.ads.zzfgx
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                zzfkq zzfkqVar = (zzfkq) obj;
                zzfmwVar.zzb = zzfkqVar;
                Iterator it = zzfkqVar.zzb.zza.iterator();
                boolean z = false;
                loop0: while (true) {
                    if (it.hasNext()) {
                        Iterator it2 = ((zzfkf) it.next()).zza.iterator();
                        while (it2.hasNext()) {
                            if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                                break loop0;
                            }
                            z = true;
                        }
                    } else if (z) {
                        return zzcyxVarZza.zzc(zzhbw.zza(zzfkqVar));
                    }
                }
                return zzhbw.zza(null);
            }
        };
        Executor executor = this.zzb;
        return (zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzj(zzhboVarZzw, zzhbeVar, executor), new zzgta() { // from class: com.google.android.gms.internal.ads.zzfgw
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                zzfmw zzfmwVar2 = zzfmwVar;
                zzfmwVar2.zzc = (zzcxt) obj;
                return zzfmwVar2;
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzfhw
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfhx zzfhxVar, zzfhv zzfhvVar, Object obj) {
        return zzb(zzfhxVar, zzfhvVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfhw
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
