package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcxt implements zzepe {
    protected final zzfkq zza;
    protected final zzfkf zzb;
    private final zzddq zzc;
    private final zzded zzd;
    private final zzfht zze;
    private final zzdck zzf;
    private final zzdhi zzg;
    private final zzdeh zzh;
    private final zzdkn zzi;
    private final zzdbn zzj;
    private final zzeao zzk;

    public zzcxt(zzcxs zzcxsVar) {
        this.zza = zzcxsVar.zza();
        this.zzb = zzcxsVar.zzb();
        this.zzc = zzcxsVar.zzc();
        this.zzd = zzcxsVar.zzd();
        this.zze = zzcxsVar.zze();
        this.zzf = zzcxsVar.zzf();
        this.zzg = zzcxsVar.zzg();
        this.zzh = zzcxsVar.zzh();
        this.zzi = zzcxsVar.zzi();
        this.zzj = zzcxsVar.zzj();
        this.zzk = zzcxsVar.zzk();
    }

    public void zzd() {
        this.zzc.zzc(null);
    }

    public void zzj() {
        this.zzd.zzg();
        this.zzh.zza(this);
    }

    public final zzddq zzl() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzepe
    public final void zzm() {
        this.zzi.zzi();
    }

    public final zzdck zzn() {
        return this.zzf;
    }

    public final zzdbn zzo() {
        return this.zzj;
    }

    public final zzfht zzp() {
        return this.zze;
    }

    public final zzdgh zzq() {
        return this.zzg.zzn();
    }

    public final zzfkq zzr() {
        return this.zza;
    }

    public final boolean zzs() {
        return this.zzb.zzaq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzt() {
        zzeao zzeaoVar;
        List list = this.zzb.zzaC;
        if (list == null || list.isEmpty() || (zzeaoVar = this.zzk) == null) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziL)).booleanValue() || list.isEmpty()) {
            return;
        }
        zzgzb zzgzbVarListIterator = ((zzgwm) list).listIterator(0);
        while (zzgzbVarListIterator.hasNext()) {
            zzeap zzeapVar = (zzeap) zzgzbVarListIterator.next();
            int[] iArr = zzeapVar.zzb;
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (iArr[i] == 1) {
                    zzeaoVar.zza(zzeapVar.zza, 1, com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
                    break;
                }
                i++;
            }
        }
    }
}
