package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public class zzbl {
    public final boolean zzB;
    public final zzgwp zzH;
    public final zzgww zzI;
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zzi;
    public final int zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final zzgwm zzm;
    public final zzgwm zzn;
    public final zzgwm zzo;
    public final zzgwm zzq;
    public final zzgwm zzr;
    public final int zzt;
    public final int zzu;
    public final zzgwm zzv;
    public final zzbj zzw;
    public final zzgwm zzy;
    public final zzgwm zzz;
    public final int zze = 0;
    public final int zzf = 0;
    public final int zzg = 0;
    public final int zzh = 0;
    public final int zzp = 0;
    public final int zzs = 0;
    public final boolean zzx = false;
    public final int zzA = 0;
    public final int zzC = 0;
    public final boolean zzD = false;
    public final boolean zzE = false;
    public final boolean zzF = false;
    public final boolean zzG = false;

    static {
        new zzbl(new zzbk());
        String str = zzfl.zza;
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
        Integer.toString(35, 36);
        Integer.toString(36, 36);
        Integer.toString(37, 36);
        Integer.toString(38, 36);
    }

    public zzbl(zzbk zzbkVar) {
        this.zza = zzbkVar.zzb();
        this.zzb = zzbkVar.zzc();
        this.zzc = zzbkVar.zzd();
        this.zzd = zzbkVar.zze();
        this.zzi = zzbkVar.zzf();
        this.zzj = zzbkVar.zzg();
        this.zzk = zzbkVar.zzh();
        this.zzl = zzbkVar.zzi();
        this.zzm = zzbkVar.zzj();
        this.zzn = zzbkVar.zzk();
        this.zzo = zzbkVar.zzl();
        this.zzq = zzbkVar.zzm();
        this.zzt = zzbkVar.zzo();
        this.zzr = zzbkVar.zzn();
        this.zzu = zzbkVar.zzp();
        this.zzv = zzbkVar.zzq();
        this.zzw = zzbkVar.zzr();
        this.zzy = zzbkVar.zzs();
        this.zzB = zzbkVar.zzt();
        this.zzz = zzbkVar.zzu();
        this.zzH = zzgwp.zzc(zzbkVar.zzv());
        this.zzI = zzgww.zzp(zzbkVar.zzw());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbl zzblVar = (zzbl) obj;
            if (this.zza == zzblVar.zza && this.zzb == zzblVar.zzb && this.zzc == zzblVar.zzc && this.zzd == zzblVar.zzd && this.zzl == zzblVar.zzl && this.zzi == zzblVar.zzi && this.zzj == zzblVar.zzj && this.zzk == zzblVar.zzk && this.zzm.equals(zzblVar.zzm) && this.zzn.equals(zzblVar.zzn) && this.zzo.equals(zzblVar.zzo) && this.zzq.equals(zzblVar.zzq) && this.zzt == zzblVar.zzt && this.zzr.equals(zzblVar.zzr) && this.zzu == zzblVar.zzu && this.zzv.equals(zzblVar.zzv) && this.zzw.equals(zzblVar.zzw) && this.zzz.equals(zzblVar.zzz) && this.zzy.equals(zzblVar.zzy) && this.zzB == zzblVar.zzB && this.zzH.equals(zzblVar.zzH) && this.zzI.equals(zzblVar.zzI)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((((((this.zza + 31) * 31) + this.zzb) * 31) + this.zzc) * 31) + this.zzd;
        zzgwm zzgwmVar = this.zzm;
        int iHashCode = zzgwmVar.hashCode() + (((((((((i * 28629151) + (this.zzl ? 1 : 0)) * 31) + this.zzi) * 31) + this.zzj) * 31) + (this.zzk ? 1 : 0)) * 31);
        int iHashCode2 = this.zzn.hashCode() + (iHashCode * 31);
        int iHashCode3 = this.zzo.hashCode() + (iHashCode2 * 31);
        int iHashCode4 = this.zzq.hashCode() + (iHashCode3 * 961);
        zzgwm zzgwmVar2 = this.zzr;
        int iHashCode5 = zzgwmVar2.hashCode() + (((iHashCode4 * 961) + this.zzt) * 31);
        zzgwm zzgwmVar3 = this.zzv;
        int iHashCode6 = (zzgwmVar3.hashCode() + (((iHashCode5 * 31) + this.zzu) * 31)) * 31;
        int iHashCode7 = this.zzy.hashCode() + ((iHashCode6 + 29791) * 961);
        zzgwm zzgwmVar4 = this.zzz;
        int iHashCode8 = zzgwmVar4.hashCode() + (((iHashCode7 * 961) + (this.zzB ? 1 : 0)) * 31);
        int iHashCode9 = this.zzH.hashCode();
        return this.zzI.hashCode() + ((iHashCode9 + (iHashCode8 * 887503681)) * 31);
    }
}
