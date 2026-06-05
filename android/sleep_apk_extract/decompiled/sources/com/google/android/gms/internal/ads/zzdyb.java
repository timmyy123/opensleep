package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv$zza;
import com.google.android.gms.internal.ads.zzbhv$zzi;
import com.google.android.gms.internal.ads.zzbhv$zzt;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdyb implements zzdfx, zzdef, zzdcu, zzddl, com.google.android.gms.ads.internal.client.zza, zzdii {
    private final zzbhp zza;
    private boolean zzb = false;

    public zzdyb(zzbhp zzbhpVar, @Nullable zzfia zzfiaVar) {
        this.zza = zzbhpVar;
        zzbhpVar.zzc(2);
        if (zzfiaVar != null) {
            zzbhpVar.zzc(1101);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        boolean z = this.zzb;
        zzbhp zzbhpVar = this.zza;
        if (z) {
            zzbhpVar.zzc(8);
        } else {
            zzbhpVar.zzc(7);
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        switch (zzeVar.zza) {
            case 1:
                this.zza.zzc(101);
                break;
            case 2:
                this.zza.zzc(102);
                break;
            case 3:
                this.zza.zzc(5);
                break;
            case 4:
                this.zza.zzc(103);
                break;
            case 5:
                this.zza.zzc(104);
                break;
            case 6:
                this.zza.zzc(105);
                break;
            case 7:
                this.zza.zzc(106);
                break;
            default:
                this.zza.zzc(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(final zzfkq zzfkqVar) {
        this.zza.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzdya
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv$zzt.zza zzaVar) {
                zzbhv$zza.zzb zzbVarZzbp = zzaVar.zzY().zzbp();
                zzbhv$zzi.zza zzaVarZzbp = zzaVar.zzY().zzp().zzbp();
                zzaVarZzbp.zzd(zzfkqVar.zzb.zzb.zzb);
                zzbVarZzbp.zzr(zzaVarZzbp);
                zzaVar.zzaa(zzbVarZzbp);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final synchronized void zzdr() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        this.zza.zzc(3);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzj(final zzbhv$zzb zzbhv_zzb) {
        zzbho zzbhoVar = new zzbho() { // from class: com.google.android.gms.internal.ads.zzdxx
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv$zzt.zza zzaVar) {
                zzaVar.zzar(zzbhv_zzb);
            }
        };
        zzbhp zzbhpVar = this.zza;
        zzbhpVar.zzb(zzbhoVar);
        zzbhpVar.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzk(final zzbhv$zzb zzbhv_zzb) {
        zzbho zzbhoVar = new zzbho() { // from class: com.google.android.gms.internal.ads.zzdxy
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv$zzt.zza zzaVar) {
                zzaVar.zzar(zzbhv_zzb);
            }
        };
        zzbhp zzbhpVar = this.zza;
        zzbhpVar.zzb(zzbhoVar);
        zzbhpVar.zzc(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzl(final zzbhv$zzb zzbhv_zzb) {
        zzbho zzbhoVar = new zzbho() { // from class: com.google.android.gms.internal.ads.zzdxz
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv$zzt.zza zzaVar) {
                zzaVar.zzar(zzbhv_zzb);
            }
        };
        zzbhp zzbhpVar = this.zza;
        zzbhpVar.zzb(zzbhoVar);
        zzbhpVar.zzc(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzm(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzo() {
        this.zza.zzc(1109);
    }
}
