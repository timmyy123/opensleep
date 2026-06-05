package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzaax extends zzaaq {
    private final boolean zze;
    private final zzaam zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final int zzv;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzaax(int i, zzbg zzbgVar, int i2, zzaam zzaamVar, int i3, String str, int i4, boolean z) {
        boolean z2;
        boolean z3;
        int i5;
        int iZzj;
        int i6;
        boolean z4;
        zzv zzvVar;
        int i7;
        int i8;
        int i9;
        zzv zzvVar2;
        int i10;
        int i11;
        int i12;
        super(i, zzbgVar, i2);
        this.zzf = zzaamVar;
        int i13 = 1;
        int i14 = true != zzaamVar.zzM ? 16 : 24;
        if (!z || (((i10 = (zzvVar2 = this.zzd).zzw) != -1 && i10 > zzaamVar.zza) || ((i11 = zzvVar2.zzx) != -1 && i11 > zzaamVar.zzb))) {
            z2 = false;
        } else {
            float f = zzvVar2.zzA;
            if ((f == -1.0f || f <= zzaamVar.zzc) && ((i12 = zzvVar2.zzj) == -1 || i12 <= zzaamVar.zzd)) {
                z2 = true;
            }
        }
        this.zze = z2;
        if (!z || (((i7 = (zzvVar = this.zzd).zzw) != -1 && i7 < 0) || ((i8 = zzvVar.zzx) != -1 && i8 < 0))) {
            z3 = false;
        } else {
            float f2 = zzvVar.zzA;
            if ((f2 == -1.0f || f2 >= 0.0f) && ((i9 = zzvVar.zzj) == -1 || i9 >= 0)) {
                z3 = true;
            }
        }
        this.zzg = z3;
        this.zzh = zznc.zzac(i3, false);
        zzv zzvVar3 = this.zzd;
        float f3 = zzvVar3.zzA;
        this.zzi = f3 != -1.0f && f3 >= 10.0f;
        this.zzj = zzvVar3.zzj;
        this.zzk = zzvVar3.zzc();
        int i15 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i15 >= zzaamVar.zzo.size()) {
                iZzj = 0;
                i15 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzaay.zzj(this.zzd, (String) zzaamVar.zzo.get(i15), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.zzm = i15;
        this.zzn = iZzj;
        this.zzo = zzaay.zzm(this.zzd.zzf, 0);
        int i16 = this.zzd.zzf;
        this.zzq = i16 == 0 || (i16 & 1) != 0;
        this.zzr = zzaay.zzj(this.zzd, str, zzaay.zzi(str) == null);
        int i17 = 0;
        while (true) {
            if (i17 >= zzaamVar.zzm.size()) {
                break;
            }
            String str2 = this.zzd.zzp;
            if (str2 != null && str2.equals(zzaamVar.zzm.get(i17))) {
                i5 = i17;
                break;
            }
            i17++;
        }
        this.zzl = i5;
        this.zzp = zzaay.zzn(this.zzd, zzaamVar.zzn);
        this.zzt = (i3 & 384) == 128;
        this.zzu = (i3 & 64) == 64;
        zzv zzvVar4 = this.zzd;
        String str3 = zzvVar4.zzp;
        if (str3 != null) {
            switch (str3.hashCode()) {
                case -1851077871:
                    i6 = !str3.equals("video/dolby-vision") ? 0 : 5;
                    break;
                case -1662735862:
                    i6 = !str3.equals("video/av01") ? 0 : 4;
                    break;
                case -1662541442:
                    i6 = !str3.equals("video/hevc") ? 0 : 3;
                    break;
                case 1331836730:
                    i6 = !str3.equals("video/avc") ? 0 : 1;
                    break;
                case 1599127257:
                    i6 = !str3.equals("video/x-vnd.on2.vp9") ? 0 : 2;
                    break;
                default:
                    i6 = 0;
                    break;
            }
        } else {
            i6 = 0;
        }
        this.zzv = i6;
        if ((zzvVar4.zzf & 16384) != 0) {
            i13 = 0;
        } else {
            zzaam zzaamVar2 = this.zzf;
            if (zznc.zzac(i3, zzaamVar2.zzV) && ((z4 = this.zze) || zzaamVar2.zzK)) {
                if (zznc.zzac(i3, false) && this.zzg && z4 && zzvVar4.zzj != -1 && (i14 & i3) != 0) {
                    i13 = 2;
                }
            }
        }
        this.zzs = i13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzi(zzaax zzaaxVar, zzaax zzaaxVar2) {
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(zzaaxVar.zzh, zzaaxVar2.zzh).zza(Integer.valueOf(zzaaxVar.zzm), Integer.valueOf(zzaaxVar2.zzm), zzgyg.zzb().zza()).zzb(zzaaxVar.zzn, zzaaxVar2.zzn).zzb(zzaaxVar.zzo, zzaaxVar2.zzo).zza(Integer.valueOf(zzaaxVar.zzp), Integer.valueOf(zzaaxVar2.zzp), zzgyg.zzb().zza()).zzd(zzaaxVar.zzq, zzaaxVar2.zzq).zzb(zzaaxVar.zzr, zzaaxVar2.zzr).zzd(zzaaxVar.zzi, zzaaxVar2.zzi).zzd(zzaaxVar.zze, zzaaxVar2.zze).zzd(zzaaxVar.zzg, zzaaxVar2.zzg).zza(Integer.valueOf(zzaaxVar.zzl), Integer.valueOf(zzaaxVar2.zzl), zzgyg.zzb().zza());
        boolean z = zzaaxVar.zzt;
        zzgvz zzgvzVarZzd = zzgvzVarZza.zzd(z, zzaaxVar2.zzt);
        boolean z2 = zzaaxVar.zzu;
        zzgvz zzgvzVarZzd2 = zzgvzVarZzd.zzd(z2, zzaaxVar2.zzu);
        if (z && z2) {
            zzgvzVarZzd2 = zzgvzVarZzd2.zzb(zzaaxVar.zzv, zzaaxVar2.zzv);
        }
        return zzgvzVarZzd2.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzj(zzaax zzaaxVar, zzaax zzaaxVar2) {
        zzgyg zzgygVarZza = (zzaaxVar.zze && zzaaxVar.zzh) ? zzaay.zzc : zzaay.zzc.zza();
        zzgvz zzgvzVarZzg = zzgvz.zzg();
        boolean z = zzaaxVar.zzf.zzF;
        return zzgvzVarZzg.zza(Integer.valueOf(zzaaxVar.zzk), Integer.valueOf(zzaaxVar2.zzk), zzgygVarZza).zza(Integer.valueOf(zzaaxVar.zzj), Integer.valueOf(zzaaxVar2.zzj), zzgygVarZza).zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        zzaax zzaaxVar = (zzaax) zzaaqVar;
        if (!Objects.equals(this.zzd.zzp, zzaaxVar.zzd.zzp)) {
            return false;
        }
        boolean z = this.zzf.zzN;
        return this.zzt == zzaaxVar.zzt && this.zzu == zzaaxVar.zzu;
    }
}
