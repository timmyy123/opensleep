package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabs {
    private static final zzabs zza = new zzabs(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzabs(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzabs zza() {
        return zza;
    }

    public static zzabs zzb() {
        return new zzabs();
    }

    public static zzabs zzc(zzabs zzabsVar, zzabs zzabsVar2) {
        int i = zzabsVar.zzb + zzabsVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzabsVar.zzc, i);
        System.arraycopy(zzabsVar2.zzc, 0, iArrCopyOf, zzabsVar.zzb, zzabsVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzabsVar.zzd, i);
        System.arraycopy(zzabsVar2.zzd, 0, objArrCopyOf, zzabsVar.zzb, zzabsVar2.zzb);
        return new zzabs(i, iArrCopyOf, objArrCopyOf, true);
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
        if (obj == null || !(obj instanceof zzabs)) {
            return false;
        }
        zzabs zzabsVar = (zzabs) obj;
        int i = this.zzb;
        if (i == zzabsVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzabsVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzabsVar.zzd;
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

    public final void zzf(zzach zzachVar) {
        for (int i = 0; i < this.zzb; i++) {
            zzachVar.zzv(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzg(zzach zzachVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzachVar.zzc(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzachVar.zzj(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzachVar.zzn(i4, (zzwr) obj);
                } else if (i3 == 3) {
                    zzachVar.zzt(i4);
                    ((zzabs) obj).zzg(zzachVar);
                    zzachVar.zzu(i4);
                } else {
                    if (i3 != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m((Throwable) new zzzu("Protocol message tag had invalid wire type."));
                        return;
                    }
                    zzachVar.zzk(i4, ((Integer) obj).intValue());
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
            zzwr zzwrVar = (zzwr) this.zzd[i2];
            int iZzD = zzxb.zzD(8);
            int iZzD2 = zzxb.zzD(i3) + zzxb.zzD(16);
            int iZzD3 = zzxb.zzD(24);
            int iZzc = zzwrVar.zzc();
            iM = FileInsert$$ExternalSyntheticOutline0.m(iZzD + iZzD, iZzD2, zza$$ExternalSyntheticOutline0.m$1(iZzc, iZzc, iZzD3), iM);
        }
        this.zze = iM;
        return iM;
    }

    public final int zzi() {
        int iZzD;
        int iZzE;
        int iZzD2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzD3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.zzd[i2]).getClass();
                    iZzD2 = zzxb.zzD(i4 << 3) + 8;
                } else if (i5 == 2) {
                    int i6 = i4 << 3;
                    zzwr zzwrVar = (zzwr) this.zzd[i2];
                    int iZzD4 = zzxb.zzD(i6);
                    int iZzc = zzwrVar.zzc();
                    iZzD3 = zzxb.zzD(iZzc) + iZzc + iZzD4 + iZzD3;
                } else if (i5 == 3) {
                    int iZzD5 = zzxb.zzD(i4 << 3);
                    iZzD = iZzD5 + iZzD5;
                    iZzE = ((zzabs) this.zzd[i2]).zzi();
                } else {
                    if (i5 != 5) {
                        Events$$ExternalSyntheticBUOutline0.m(new zzzu("Protocol message tag had invalid wire type."));
                        return 0;
                    }
                    ((Integer) this.zzd[i2]).getClass();
                    iZzD2 = zzxb.zzD(i4 << 3) + 4;
                }
                iZzD3 = iZzD2 + iZzD3;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzD = zzxb.zzD(i7);
                iZzE = zzxb.zzE(jLongValue);
            }
            iZzD3 = iZzE + iZzD + iZzD3;
        }
        this.zze = iZzD3;
        return iZzD3;
    }

    public final void zzj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzaas.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
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

    public final zzabs zzm(zzabs zzabsVar) {
        if (zzabsVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzabsVar.zzb;
        zzn(i);
        System.arraycopy(zzabsVar.zzc, 0, this.zzc, this.zzb, zzabsVar.zzb);
        System.arraycopy(zzabsVar.zzd, 0, this.zzd, this.zzb, zzabsVar.zzb);
        this.zzb = i;
        return this;
    }

    private zzabs() {
        this(0, new int[8], new Object[8], true);
    }
}
