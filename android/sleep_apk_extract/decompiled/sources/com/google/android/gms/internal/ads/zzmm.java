package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzmm implements zzxv, zzuj {
    final /* synthetic */ zzmr zza;
    private final zzmo zzb;

    public zzmm(zzmr zzmrVar, zzmo zzmoVar) {
        Objects.requireNonNull(zzmrVar);
        this.zza = zzmrVar;
        this.zzb = zzmoVar;
    }

    private final Pair zzf(int i, zzxk zzxkVar) {
        zzxk zzxkVarZza;
        zzxk zzxkVar2 = null;
        if (zzxkVar != null) {
            zzmo zzmoVar = this.zzb;
            int i2 = 0;
            while (true) {
                List list = zzmoVar.zzc;
                if (i2 >= list.size()) {
                    zzxkVarZza = null;
                    break;
                }
                if (((zzxk) list.get(i2)).zzd == zzxkVar.zzd) {
                    Object obj = zzxkVar.zza;
                    Object obj2 = zzmoVar.zzb;
                    int i3 = zzmy.$r8$clinit;
                    zzxkVarZza = zzxkVar.zza(Pair.create(obj2, obj));
                    break;
                }
                i2++;
            }
            if (zzxkVarZza == null) {
                return null;
            }
            zzxkVar2 = zzxkVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzxkVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzai(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar, final int i2) {
        final Pair pairZzf = zzf(0, zzxkVar);
        if (pairZzf != null) {
            zzmr zzmrVar = this.zza;
            zzmrVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzml
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzai(((Integer) pair.first).intValue(), (zzxk) pair.second, zzxbVar, zzxgVar, i2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzaj(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar) {
        final Pair pairZzf = zzf(0, zzxkVar);
        if (pairZzf != null) {
            zzmr zzmrVar = this.zza;
            zzmrVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzmh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzaj(((Integer) pair.first).intValue(), (zzxk) pair.second, zzxbVar, zzxgVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzak(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar) {
        final Pair pairZzf = zzf(0, zzxkVar);
        if (pairZzf != null) {
            zzmr zzmrVar = this.zza;
            zzmrVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzmi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzak(((Integer) pair.first).intValue(), (zzxk) pair.second, zzxbVar, zzxgVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzal(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar, final IOException iOException, final boolean z) {
        final Pair pairZzf = zzf(0, zzxkVar);
        if (pairZzf != null) {
            zzmr zzmrVar = this.zza;
            zzmrVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzmj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzal(((Integer) pair.first).intValue(), (zzxk) pair.second, zzxbVar, zzxgVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzam(int i, zzxk zzxkVar, final zzxg zzxgVar) {
        final Pair pairZzf = zzf(0, zzxkVar);
        if (pairZzf != null) {
            zzmr zzmrVar = this.zza;
            zzmrVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzmk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzam(((Integer) pair.first).intValue(), (zzxk) pair.second, zzxgVar);
                }
            });
        }
    }
}
