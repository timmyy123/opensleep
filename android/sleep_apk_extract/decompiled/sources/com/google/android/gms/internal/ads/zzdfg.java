package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdfg extends zzdip implements zzddl, zzdeq {
    private final zzfkf zzb;
    private final AtomicBoolean zzc;
    private final zzfkq zzd;

    public zzdfg(Set set, zzfkf zzfkfVar, zzfkq zzfkqVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzfkfVar;
        this.zzd = zzfkqVar;
    }

    private final void zzb() {
        final com.google.android.gms.ads.internal.client.zzt zztVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziX)).booleanValue() && this.zzc.compareAndSet(false, true) && (zztVar = this.zzb.zzae) != null && zztVar.zza == 3) {
            zzs(new zzdio() { // from class: com.google.android.gms.internal.ads.zzdff
                @Override // com.google.android.gms.internal.ads.zzdio
                public final /* synthetic */ void zza(Object obj) {
                    ((zzdfi) obj).zzm(zztVar);
                }
            });
        }
    }

    public final void zza(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        if (com.google.android.gms.ads.nonagon.signalgeneration.zzv.zza(this.zzd) && this.zzb.zzaB) {
            zzs(new zzdio() { // from class: com.google.android.gms.internal.ads.zzdfe
                @Override // com.google.android.gms.internal.ads.zzdio
                public final /* synthetic */ void zza(Object obj) {
                    ((zzdfi) obj).zzm(zztVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzl() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }
}
