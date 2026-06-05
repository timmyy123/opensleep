package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzigu {
    private static final zzigu zza = new zzigu(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzigu(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzigu zza() {
        return zza;
    }

    public static zzigu zzb() {
        return new zzigu();
    }

    public static zzigu zzc(zzigu zziguVar, zzigu zziguVar2) {
        int i = zziguVar.zzb + zziguVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zziguVar.zzc, i);
        System.arraycopy(zziguVar2.zzc, 0, iArrCopyOf, zziguVar.zzb, zziguVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zziguVar.zzd, i);
        System.arraycopy(zziguVar2.zzd, 0, objArrCopyOf, zziguVar.zzb, zziguVar2.zzb);
        return new zzigu(i, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzn(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzigu)) {
            return false;
        }
        zzigu zziguVar = (zzigu) obj;
        int i = this.zzb;
        if (i == zziguVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zziguVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zziguVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int iM = zzba$$ExternalSyntheticOutline0.m(i2, 31, i3, 31);
        Object[] objArr = this.zzd;
        int i5 = this.zzb;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode = (iHashCode * 31) + objArr[i6].hashCode();
        }
        return iM + iHashCode;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zze() {
        if (this.zzf) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m$1();
    }

    public final void zzg(zzihi zzihiVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzihiVar.zzc(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzihiVar.zzj(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzihiVar.zzn(i4, (zzida) obj);
                } else if (i3 == 3) {
                    zzihiVar.zzt(i4);
                    ((zzigu) obj).zzg(zzihiVar);
                    zzihiVar.zzu(i4);
                } else {
                    if (i3 != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m((Throwable) new zzies("Protocol message tag had invalid wire type."));
                        return;
                    }
                    zzihiVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iM = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzida zzidaVar = (zzida) this.zzd[i2];
            int iZzF = zzidj.zzF(8);
            int iZzF2 = zzidj.zzF(i3) + zzidj.zzF(16);
            int iZzF3 = zzidj.zzF(24);
            int iZzb = zzidaVar.zzb();
            iM = FileInsert$$ExternalSyntheticOutline0.m(iZzF + iZzF, iZzF2, zzba$$ExternalSyntheticOutline0.m(iZzb, iZzb, iZzF3), iM);
        }
        this.zze = iM;
        return iM;
    }

    public final int zzi() {
        int iZzF;
        int iZzG;
        int iZzF2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iM = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.zzd[i2]).getClass();
                    iZzF2 = zzidj.zzF(i4 << 3) + 8;
                } else if (i5 == 2) {
                    int i6 = i4 << 3;
                    zzida zzidaVar = (zzida) this.zzd[i2];
                    int iZzF3 = zzidj.zzF(i6);
                    int iZzb = zzidaVar.zzb();
                    iM = zza$$ExternalSyntheticOutline0.m(iZzb, iZzb, iZzF3, iM);
                } else if (i5 == 3) {
                    int iZzF4 = zzidj.zzF(i4 << 3);
                    iZzF = iZzF4 + iZzF4;
                    iZzG = ((zzigu) this.zzd[i2]).zzi();
                } else {
                    if (i5 != 5) {
                        Events$$ExternalSyntheticBUOutline0.m(new zzies("Protocol message tag had invalid wire type."));
                        return 0;
                    }
                    ((Integer) this.zzd[i2]).getClass();
                    iZzF2 = zzidj.zzF(i4 << 3) + 4;
                }
                iM = iZzF2 + iM;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzF = zzidj.zzF(i7);
                iZzG = zzidj.zzG(jLongValue);
            }
            iM = iZzG + iZzF + iM;
        }
        this.zze = iM;
        return iM;
    }

    public final void zzj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzifr.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzk(int i, Object obj) {
        zze();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final zzigu zzm(zzigu zziguVar) {
        if (zziguVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zziguVar.zzb;
        zzn(i);
        System.arraycopy(zziguVar.zzc, 0, this.zzc, this.zzb, zziguVar.zzb);
        System.arraycopy(zziguVar.zzd, 0, this.zzd, this.zzb, zziguVar.zzb);
        this.zzb = i;
        return this;
    }

    private zzigu() {
        this(0, new int[8], new Object[8], true);
    }
}
