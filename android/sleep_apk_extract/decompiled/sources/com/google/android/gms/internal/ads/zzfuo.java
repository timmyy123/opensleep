package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfuo extends zzfuk {
    private final zzfum zza;
    private zzfwz zzc;
    private zzfvy zzd;
    private final String zzg;
    private final zzfvm zzb = new zzfvm();
    private boolean zze = false;
    private boolean zzf = false;

    public zzfuo(zzful zzfulVar, zzfum zzfumVar, String str) {
        this.zza = zzfumVar;
        this.zzg = str;
        zzk(null);
        if (zzfumVar.zzi() == zzfun.HTML || zzfumVar.zzi() == zzfun.JAVASCRIPT) {
            this.zzd = new zzfvz(str, zzfumVar.zzf());
        } else {
            this.zzd = new zzfwc(str, zzfumVar.zze(), null);
        }
        this.zzd.zza();
        zzfvi.zza().zzb(this);
        this.zzd.zzj(zzfulVar);
    }

    private final void zzk(View view) {
        this.zzc = new zzfwz(view);
    }

    @Override // com.google.android.gms.internal.ads.zzfuk
    public final void zza() {
        if (this.zze || this.zzd == null) {
            return;
        }
        this.zze = true;
        zzfvi.zza().zzc(this);
        this.zzd.zzo(zzfvq.zza().zzg());
        this.zzd.zzn(zzfvg.zza().zzb());
        this.zzd.zzk(this, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfuk
    public final void zzb(View view) {
        if (this.zzf || zzi() == view) {
            return;
        }
        zzk(view);
        this.zzd.zzp();
        Collection<zzfuo> collectionZze = zzfvi.zza().zze();
        if (collectionZze == null || collectionZze.isEmpty()) {
            return;
        }
        for (zzfuo zzfuoVar : collectionZze) {
            if (zzfuoVar != this && zzfuoVar.zzi() == view) {
                zzfuoVar.zzc.clear();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfuk
    public final void zzc() {
        if (this.zzf) {
            return;
        }
        this.zzc.clear();
        if (!this.zzf) {
            this.zzb.zzc();
        }
        this.zzf = true;
        this.zzd.zzm();
        zzfvi.zza().zzd(this);
        this.zzd.zzb();
        this.zzd = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuk
    public final void zzd(View view, zzfur zzfurVar, String str) {
        if (this.zzf) {
            return;
        }
        this.zzb.zzb(view, zzfurVar, "Ad overlay");
    }

    public final List zzf() {
        return this.zzb.zza();
    }

    public final zzfvy zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zzi() {
        return (View) this.zzc.get();
    }

    public final boolean zzj() {
        return this.zze && !this.zzf;
    }
}
