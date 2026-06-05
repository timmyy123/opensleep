package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzan {
    public static final zzan zza = new zzan(new zzam());
    public final Integer zzA;
    public final zzgwm zzB;
    public final CharSequence zzb;
    public final CharSequence zzc;
    public final CharSequence zzd;
    public final CharSequence zze;
    public final CharSequence zzf;
    public final byte[] zzg;
    public final Integer zzh;
    public final Integer zzi;
    public final Integer zzj;

    @Deprecated
    public final Integer zzk;
    public final Boolean zzl;

    @Deprecated
    public final Integer zzm;
    public final Integer zzn;
    public final Integer zzo;
    public final Integer zzp;
    public final Integer zzq;
    public final Integer zzr;
    public final Integer zzs;
    public final CharSequence zzt;
    public final CharSequence zzu;
    public final CharSequence zzv;
    public final Integer zzw;
    public final Integer zzx;
    public final CharSequence zzy;
    public final CharSequence zzz;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
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
        Integer.toString(1000, 36);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzan(zzam zzamVar) {
        Boolean boolZzH = zzamVar.zzH();
        Integer numZzV = zzamVar.zzV();
        Integer numZzG = zzamVar.zzG();
        int i = 1;
        int i2 = 0;
        if (boolZzH != null) {
            if (!boolZzH.booleanValue()) {
                numZzG = -1;
            } else if (numZzG == null || numZzG.intValue() == -1) {
                if (numZzV != null) {
                    switch (numZzV.intValue()) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        case 20:
                        default:
                            i = 0;
                            break;
                        case 21:
                            i = 2;
                            break;
                        case 22:
                            i = 3;
                            break;
                        case 23:
                            i = 4;
                            break;
                        case 24:
                            i = 5;
                            break;
                        case 25:
                            i = 6;
                            break;
                    }
                    numZzG = Integer.valueOf(i);
                }
            }
        } else if (numZzG != null) {
            boolean z = numZzG.intValue() != -1;
            boolZzH = Boolean.valueOf(z);
            if (z && numZzV == null) {
                switch (numZzG.intValue()) {
                    case 1:
                        break;
                    case 2:
                        i2 = 21;
                        break;
                    case 3:
                        i2 = 22;
                        break;
                    case 4:
                        i2 = 23;
                        break;
                    case 5:
                        i2 = 24;
                        break;
                    case 6:
                        i2 = 25;
                        break;
                    default:
                        i2 = 20;
                        break;
                }
                numZzV = Integer.valueOf(i2);
            }
        } else {
            numZzG = null;
        }
        this.zzb = zzamVar.zzx();
        this.zzc = zzamVar.zzy();
        this.zzd = zzamVar.zzz();
        this.zze = zzamVar.zzA();
        this.zzf = zzamVar.zzB();
        this.zzg = zzamVar.zzC();
        this.zzh = zzamVar.zzD();
        this.zzi = zzamVar.zzE();
        this.zzj = zzamVar.zzF();
        this.zzk = numZzG;
        this.zzl = boolZzH;
        this.zzm = zzamVar.zzI();
        this.zzn = zzamVar.zzI();
        this.zzo = zzamVar.zzJ();
        this.zzp = zzamVar.zzK();
        this.zzq = zzamVar.zzL();
        this.zzr = zzamVar.zzM();
        this.zzs = zzamVar.zzN();
        this.zzt = zzamVar.zzO();
        this.zzu = zzamVar.zzP();
        this.zzv = zzamVar.zzQ();
        this.zzw = zzamVar.zzR();
        this.zzx = zzamVar.zzS();
        this.zzy = zzamVar.zzT();
        this.zzz = zzamVar.zzU();
        this.zzA = numZzV;
        this.zzB = zzamVar.zzW();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzan.class == obj.getClass()) {
            zzan zzanVar = (zzan) obj;
            if (TextUtils.equals(this.zzb, zzanVar.zzb) && TextUtils.equals(this.zzc, zzanVar.zzc) && TextUtils.equals(this.zzd, zzanVar.zzd) && TextUtils.equals(this.zze, zzanVar.zze) && TextUtils.equals(null, null) && TextUtils.equals(null, null) && TextUtils.equals(this.zzf, zzanVar.zzf) && Arrays.equals(this.zzg, zzanVar.zzg) && Objects.equals(this.zzh, zzanVar.zzh) && Objects.equals(this.zzi, zzanVar.zzi) && Objects.equals(this.zzj, zzanVar.zzj) && Objects.equals(this.zzk, zzanVar.zzk) && Objects.equals(this.zzl, zzanVar.zzl) && Objects.equals(this.zzn, zzanVar.zzn) && Objects.equals(this.zzo, zzanVar.zzo) && Objects.equals(this.zzp, zzanVar.zzp) && Objects.equals(this.zzq, zzanVar.zzq) && Objects.equals(this.zzr, zzanVar.zzr) && Objects.equals(this.zzs, zzanVar.zzs) && TextUtils.equals(this.zzt, zzanVar.zzt) && TextUtils.equals(this.zzu, zzanVar.zzu) && TextUtils.equals(this.zzv, zzanVar.zzv) && Objects.equals(this.zzw, zzanVar.zzw) && Objects.equals(this.zzx, zzanVar.zzx) && TextUtils.equals(this.zzy, zzanVar.zzy) && TextUtils.equals(null, null) && TextUtils.equals(this.zzz, zzanVar.zzz) && Objects.equals(this.zzA, zzanVar.zzA) && Objects.equals(this.zzB, zzanVar.zzB)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zzb, this.zzc, this.zzd, this.zze, null, null, this.zzf, null, null, null, Integer.valueOf(Arrays.hashCode(this.zzg)), this.zzh, null, this.zzi, this.zzj, this.zzk, this.zzl, null, this.zzn, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx, this.zzy, null, this.zzz, this.zzA, Boolean.TRUE, this.zzB);
    }

    public final zzam zza() {
        return new zzam(this, null);
    }

    public /* synthetic */ zzan(zzam zzamVar, byte[] bArr) {
        this(zzamVar);
    }
}
