package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaga {
    private static final zzaga zza = new zzaga(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze = -1;
    private boolean zzf;

    private zzaga(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaga zza() {
        return zza;
    }

    public static zzaga zzb() {
        return new zzaga(0, new int[8], new Object[8], true);
    }

    public static zzaga zzc(zzaga zzagaVar, zzaga zzagaVar2) {
        int i = zzagaVar.zzb + zzagaVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzagaVar.zzc, i);
        System.arraycopy(zzagaVar2.zzc, 0, iArrCopyOf, zzagaVar.zzb, zzagaVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzagaVar.zzd, i);
        System.arraycopy(zzagaVar2.zzd, 0, objArrCopyOf, zzagaVar.zzb, zzagaVar2.zzb);
        return new zzaga(i, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzm(int i) {
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
        if (obj == null || !(obj instanceof zzaga)) {
            return false;
        }
        zzaga zzagaVar = (zzaga) obj;
        int i = this.zzb;
        if (i == zzagaVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzagaVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzagaVar.zzd;
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

    public final void zzg(zzago zzagoVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzagoVar.zzc(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzagoVar.zzj(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzagoVar.zzn(i4, (zzacr) obj);
                } else if (i3 == 3) {
                    zzagoVar.zzt(i4);
                    ((zzaga) obj).zzg(zzagoVar);
                    zzagoVar.zzu(i4);
                } else {
                    if (i3 != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m((Throwable) new zzaeg("Protocol message tag had invalid wire type."));
                        return;
                    }
                    zzagoVar.zzk(i4, ((Integer) obj).intValue());
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
            zzacr zzacrVar = (zzacr) this.zzd[i2];
            int iZzE = zzada.zzE(8);
            int iZzE2 = zzada.zzE(i3) + zzada.zzE(16);
            int iZzE3 = zzada.zzE(24);
            int iZzb = zzacrVar.zzb();
            iM = FileInsert$$ExternalSyntheticOutline0.m(iZzE + iZzE, iZzE2, zza$$ExternalSyntheticOutline0.m$2(iZzb, iZzb, iZzE3), iM);
        }
        this.zze = iM;
        return iM;
    }

    public final int zzi() {
        int iZzE;
        int iZzF;
        int iZzE2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iM$2 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.zzd[i2]).getClass();
                    iZzE2 = zzada.zzE(i4 << 3) + 8;
                } else if (i5 == 2) {
                    int i6 = i4 << 3;
                    zzacr zzacrVar = (zzacr) this.zzd[i2];
                    int iZzE3 = zzada.zzE(i6);
                    int iZzb = zzacrVar.zzb();
                    iM$2 = zza$$ExternalSyntheticOutline0.m$2(iZzb, iZzb, iZzE3, iM$2);
                } else if (i5 == 3) {
                    int iZzE4 = zzada.zzE(i4 << 3);
                    iZzE = iZzE4 + iZzE4;
                    iZzF = ((zzaga) this.zzd[i2]).zzi();
                } else {
                    if (i5 != 5) {
                        Events$$ExternalSyntheticBUOutline0.m(new zzaeg("Protocol message tag had invalid wire type."));
                        return 0;
                    }
                    ((Integer) this.zzd[i2]).getClass();
                    iZzE2 = zzada.zzE(i4 << 3) + 4;
                }
                iM$2 = iZzE2 + iM$2;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzE = zzada.zzE(i7);
                iZzF = zzada.zzF(jLongValue);
            }
            iM$2 = iZzF + iZzE + iM$2;
        }
        this.zze = iM$2;
        return iM$2;
    }

    public final void zzj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzafe.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzk(int i, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final zzaga zzl(zzaga zzagaVar) {
        if (zzagaVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzagaVar.zzb;
        zzm(i);
        System.arraycopy(zzagaVar.zzc, 0, this.zzc, this.zzb, zzagaVar.zzb);
        System.arraycopy(zzagaVar.zzd, 0, this.zzd, this.zzb, zzagaVar.zzb);
        this.zzb = i;
        return this;
    }
}
