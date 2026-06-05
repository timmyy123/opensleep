package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzxu {
    public final int zza;
    public final zzxk zzb;
    private final CopyOnWriteArrayList zzc;

    private zzxu(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzxk zzxkVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzxkVar;
    }

    public final zzxu zza(int i, zzxk zzxkVar) {
        return new zzxu(this.zzc, 0, zzxkVar);
    }

    public final void zzb(Handler handler, zzxv zzxvVar) {
        this.zzc.add(new zzxn(handler, zzxvVar));
    }

    public final void zzc(zzxv zzxvVar) {
        CopyOnWriteArrayList<zzxn> copyOnWriteArrayList = this.zzc;
        for (zzxn zzxnVar : copyOnWriteArrayList) {
            if (zzxnVar.zzb == zzxvVar) {
                copyOnWriteArrayList.remove(zzxnVar);
            }
        }
    }

    public final void zzd(final zzxb zzxbVar, final zzxg zzxgVar, final int i) {
        zzi(new zzdt() { // from class: com.google.android.gms.internal.ads.zzxt
            @Override // com.google.android.gms.internal.ads.zzdt
            public final /* synthetic */ void zza(Object obj) {
                ((zzxv) obj).zzai(0, this.zza.zzb, zzxbVar, zzxgVar, i);
            }
        });
    }

    public final void zze(final zzxb zzxbVar, final zzxg zzxgVar) {
        zzi(new zzdt() { // from class: com.google.android.gms.internal.ads.zzxo
            @Override // com.google.android.gms.internal.ads.zzdt
            public final /* synthetic */ void zza(Object obj) {
                ((zzxv) obj).zzaj(0, this.zza.zzb, zzxbVar, zzxgVar);
            }
        });
    }

    public final void zzf(final zzxb zzxbVar, final zzxg zzxgVar) {
        zzi(new zzdt() { // from class: com.google.android.gms.internal.ads.zzxp
            @Override // com.google.android.gms.internal.ads.zzdt
            public final /* synthetic */ void zza(Object obj) {
                ((zzxv) obj).zzak(0, this.zza.zzb, zzxbVar, zzxgVar);
            }
        });
    }

    public final void zzg(final zzxb zzxbVar, final zzxg zzxgVar, final IOException iOException, final boolean z) {
        zzi(new zzdt() { // from class: com.google.android.gms.internal.ads.zzxq
            @Override // com.google.android.gms.internal.ads.zzdt
            public final /* synthetic */ void zza(Object obj) {
                ((zzxv) obj).zzal(0, this.zza.zzb, zzxbVar, zzxgVar, iOException, z);
            }
        });
    }

    public final void zzh(final zzxg zzxgVar) {
        zzi(new zzdt() { // from class: com.google.android.gms.internal.ads.zzxr
            @Override // com.google.android.gms.internal.ads.zzdt
            public final /* synthetic */ void zza(Object obj) {
                ((zzxv) obj).zzam(0, this.zza.zzb, zzxgVar);
            }
        });
    }

    public final void zzi(final zzdt zzdtVar) {
        for (zzxn zzxnVar : this.zzc) {
            final zzxv zzxvVar = zzxnVar.zzb;
            zzfl.zze(zzxnVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzxs
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzdtVar.zza(zzxvVar);
                }
            });
        }
    }

    public zzxu() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
