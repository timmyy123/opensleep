package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzzx extends zzaaq implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzaam zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final int zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final boolean zzx;

    public zzzx(int i, zzbg zzbgVar, int i2, zzaam zzaamVar, int i3, boolean z, zzgtk zzgtkVar, int i4) {
        int i5;
        int iZzj;
        int iHashCode;
        int iZzj2;
        boolean z2;
        super(i, zzbgVar, i2);
        this.zzh = zzaamVar;
        int i6 = 1;
        int i7 = true != zzaamVar.zzT ? 16 : 24;
        this.zzg = zzaay.zzi(this.zzd.zzd);
        this.zzi = zznc.zzac(i3, false);
        int i8 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i8 >= zzaamVar.zzq.size()) {
                iZzj = 0;
                i8 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzaay.zzj(this.zzd, (String) zzaamVar.zzq.get(i8), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        this.zzk = i8;
        this.zzj = iZzj;
        this.zzl = zzaay.zzm(this.zzd.zzf, 0);
        this.zzm = zzaay.zzn(this.zzd, zzaamVar.zzr);
        zzv zzvVar = this.zzd;
        int i9 = zzvVar.zzf;
        this.zzn = i9 == 0 || (i9 & 1) != 0;
        this.zzq = 1 == (zzvVar.zze & 1);
        String str = zzvVar.zzp;
        this.zzx = str != null && ((iHashCode = str.hashCode()) == -2123537834 ? str.equals("audio/eac3-joc") : !(iHashCode == 187078297 ? !str.equals("audio/ac4") : !(iHashCode == 1504698186 && str.equals("audio/iamf"))));
        int i10 = zzvVar.zzH;
        this.zzr = i10;
        this.zzs = zzvVar.zzI;
        int i11 = zzvVar.zzj;
        this.zzt = i11;
        this.zzf = (i11 == -1 || i11 <= zzaamVar.zzu) && (i10 == -1 || i10 <= zzaamVar.zzt) && zzgtkVar.zza(zzvVar);
        String str2 = zzfl.zza;
        String[] strArrSplit = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
        for (int i12 = 0; i12 < strArrSplit.length; i12++) {
            strArrSplit[i12] = zzfl.zzi(strArrSplit[i12]);
        }
        int i13 = 0;
        while (true) {
            if (i13 >= strArrSplit.length) {
                iZzj2 = 0;
                i13 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj2 = zzaay.zzj(this.zzd, strArrSplit[i13], false);
                if (iZzj2 > 0) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        this.zzo = i13;
        this.zzp = iZzj2;
        int i14 = 0;
        while (true) {
            if (i14 >= zzaamVar.zzv.size()) {
                break;
            }
            String str3 = this.zzd.zzp;
            if (str3 != null && str3.equals(zzaamVar.zzv.get(i14))) {
                i5 = i14;
                break;
            }
            i14++;
        }
        this.zzu = i5;
        this.zzv = (i3 & 384) == 128;
        this.zzw = (i3 & 64) == 64;
        zzaam zzaamVar2 = this.zzh;
        if (zznc.zzac(i3, zzaamVar2.zzV) && ((z2 = this.zzf) || zzaamVar2.zzO)) {
            int i15 = zzaamVar2.zzw.zzb;
            if (zznc.zzac(i3, false) && z2 && this.zzd.zzj != -1 && ((zzaamVar2.zzX || !z) && (i7 & i3) != 0)) {
                i6 = 2;
            }
        } else {
            i6 = 0;
        }
        this.zze = i6;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzzx zzzxVar) {
        boolean z = this.zzf;
        zzgyg zzgygVarZza = (z && this.zzi) ? zzaay.zzc : zzaay.zzc.zza();
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(this.zzi, zzzxVar.zzi).zza(Integer.valueOf(this.zzk), Integer.valueOf(zzzxVar.zzk), zzgyg.zzb().zza()).zzb(this.zzj, zzzxVar.zzj).zzb(this.zzl, zzzxVar.zzl).zza(Integer.valueOf(this.zzm), Integer.valueOf(zzzxVar.zzm), zzgyg.zzb().zza()).zzd(this.zzq, zzzxVar.zzq).zzd(this.zzn, zzzxVar.zzn).zza(Integer.valueOf(this.zzo), Integer.valueOf(zzzxVar.zzo), zzgyg.zzb().zza()).zzb(this.zzp, zzzxVar.zzp).zzd(z, zzzxVar.zzf).zza(Integer.valueOf(this.zzu), Integer.valueOf(zzzxVar.zzu), zzgyg.zzb().zza());
        boolean z2 = this.zzh.zzF;
        zzgvz zzgvzVarZza2 = zzgvzVarZza.zzd(this.zzv, zzzxVar.zzv).zzd(this.zzw, zzzxVar.zzw).zzd(this.zzx, zzzxVar.zzx).zza(Integer.valueOf(this.zzr), Integer.valueOf(zzzxVar.zzr), zzgygVarZza).zza(Integer.valueOf(this.zzs), Integer.valueOf(zzzxVar.zzs), zzgygVarZza);
        if (Objects.equals(this.zzg, zzzxVar.zzg)) {
            zzgvzVarZza2 = zzgvzVarZza2.zza(Integer.valueOf(this.zzt), Integer.valueOf(zzzxVar.zzt), zzgygVarZza);
        }
        return zzgvzVarZza2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        String str;
        int i;
        zzzx zzzxVar = (zzzx) zzaaqVar;
        boolean z = this.zzh.zzR;
        zzv zzvVar = this.zzd;
        int i2 = zzvVar.zzH;
        if (i2 == -1) {
            return false;
        }
        zzv zzvVar2 = zzzxVar.zzd;
        return i2 == zzvVar2.zzH && (str = zzvVar.zzp) != null && TextUtils.equals(str, zzvVar2.zzp) && (i = zzvVar.zzI) != -1 && i == zzvVar2.zzI && this.zzv == zzzxVar.zzv && this.zzw == zzzxVar.zzw;
    }
}
