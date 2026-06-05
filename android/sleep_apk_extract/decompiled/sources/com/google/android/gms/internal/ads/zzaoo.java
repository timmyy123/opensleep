package com.google.android.gms.internal.ads;

import android.text.Layout;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzaoo {
    private String zza;
    private int zzb;
    private boolean zzc;
    private int zzd;
    private boolean zze;
    private float zzk;
    private String zzl;
    private Layout.Alignment zzo;
    private Layout.Alignment zzp;
    private zzaoh zzr;
    private String zzt;
    private String zzu;
    private int zzf = -1;
    private int zzg = -1;
    private int zzh = -1;
    private int zzi = -1;
    private int zzj = -1;
    private int zzm = -1;
    private int zzn = -1;
    private int zzq = -1;
    private float zzs = Float.MAX_VALUE;

    public final Layout.Alignment zzA() {
        return this.zzp;
    }

    public final zzaoo zzB(Layout.Alignment alignment) {
        this.zzp = alignment;
        return this;
    }

    public final boolean zzC() {
        return this.zzq == 1;
    }

    public final zzaoo zzD(boolean z) {
        this.zzq = z ? 1 : 0;
        return this;
    }

    public final zzaoh zzE() {
        return this.zzr;
    }

    public final zzaoo zzF(zzaoh zzaohVar) {
        this.zzr = zzaohVar;
        return this;
    }

    public final zzaoo zzG(float f) {
        this.zzk = f;
        return this;
    }

    public final zzaoo zzH(int i) {
        this.zzj = i;
        return this;
    }

    public final int zzI() {
        return this.zzj;
    }

    public final float zzJ() {
        return this.zzk;
    }

    public final zzaoo zzK(String str) {
        this.zzt = str;
        return this;
    }

    public final String zzL() {
        return this.zzt;
    }

    public final zzaoo zzM(String str) {
        this.zzu = str;
        return this;
    }

    public final String zzN() {
        return this.zzu;
    }

    public final int zza() {
        int i = this.zzh;
        if (i == -1 && this.zzi == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.zzi == 1 ? 2 : 0);
    }

    public final boolean zzb() {
        return this.zzf == 1;
    }

    public final zzaoo zzc(boolean z) {
        this.zzf = z ? 1 : 0;
        return this;
    }

    public final boolean zzd() {
        return this.zzg == 1;
    }

    public final zzaoo zze(boolean z) {
        this.zzg = z ? 1 : 0;
        return this;
    }

    public final zzaoo zzf(boolean z) {
        this.zzh = z ? 1 : 0;
        return this;
    }

    public final zzaoo zzg(boolean z) {
        this.zzi = z ? 1 : 0;
        return this;
    }

    public final String zzh() {
        return this.zza;
    }

    public final zzaoo zzi(String str) {
        this.zza = str;
        return this;
    }

    public final int zzj() {
        if (this.zzc) {
            return this.zzb;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Font color has not been defined.");
        return 0;
    }

    public final zzaoo zzk(int i) {
        this.zzb = i;
        this.zzc = true;
        return this;
    }

    public final boolean zzl() {
        return this.zzc;
    }

    public final int zzm() {
        if (this.zze) {
            return this.zzd;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Background color has not been defined.");
        return 0;
    }

    public final zzaoo zzn(int i) {
        this.zzd = i;
        this.zze = true;
        return this;
    }

    public final boolean zzo() {
        return this.zze;
    }

    public final zzaoo zzp(float f) {
        this.zzs = f;
        return this;
    }

    public final float zzq() {
        return this.zzs;
    }

    public final zzaoo zzr(zzaoo zzaooVar) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzaooVar != null) {
            if (!this.zzc && zzaooVar.zzc) {
                zzk(zzaooVar.zzb);
            }
            if (this.zzh == -1) {
                this.zzh = zzaooVar.zzh;
            }
            if (this.zzi == -1) {
                this.zzi = zzaooVar.zzi;
            }
            if (this.zza == null && (str = zzaooVar.zza) != null) {
                this.zza = str;
            }
            if (this.zzf == -1) {
                this.zzf = zzaooVar.zzf;
            }
            if (this.zzg == -1) {
                this.zzg = zzaooVar.zzg;
            }
            if (this.zzn == -1) {
                this.zzn = zzaooVar.zzn;
            }
            if (this.zzo == null && (alignment2 = zzaooVar.zzo) != null) {
                this.zzo = alignment2;
            }
            if (this.zzp == null && (alignment = zzaooVar.zzp) != null) {
                this.zzp = alignment;
            }
            if (this.zzq == -1) {
                this.zzq = zzaooVar.zzq;
            }
            if (this.zzj == -1) {
                this.zzj = zzaooVar.zzj;
                this.zzk = zzaooVar.zzk;
            }
            if (this.zzr == null) {
                this.zzr = zzaooVar.zzr;
            }
            if (this.zzs == Float.MAX_VALUE) {
                this.zzs = zzaooVar.zzs;
            }
            if (this.zzt == null) {
                this.zzt = zzaooVar.zzt;
            }
            if (this.zzu == null) {
                this.zzu = zzaooVar.zzu;
            }
            if (!this.zze && zzaooVar.zze) {
                zzn(zzaooVar.zzd);
            }
            if (this.zzm == -1 && (i = zzaooVar.zzm) != -1) {
                this.zzm = i;
            }
        }
        return this;
    }

    public final zzaoo zzs(String str) {
        this.zzl = str;
        return this;
    }

    public final String zzt() {
        return this.zzl;
    }

    public final zzaoo zzu(int i) {
        this.zzm = i;
        return this;
    }

    public final int zzv() {
        return this.zzm;
    }

    public final zzaoo zzw(int i) {
        this.zzn = i;
        return this;
    }

    public final int zzx() {
        return this.zzn;
    }

    public final Layout.Alignment zzy() {
        return this.zzo;
    }

    public final zzaoo zzz(Layout.Alignment alignment) {
        this.zzo = alignment;
        return this;
    }
}
