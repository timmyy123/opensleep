package com.google.android.gms.internal.fitness;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzet extends zzem implements Set {
    private transient zzep zza;

    public static zzet zzf(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzk(5, obj, obj2, obj3, obj4, obj5);
    }

    public static int zzg(int i) {
        int iMax = Math.max(i, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
            return iHighestOneBit;
        }
        if (iMax < 1073741824) {
            return 1073741824;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("collection too large");
        return 0;
    }

    private static zzet zzk(int i, Object... objArr) {
        if (i == 0) {
            return zzfc.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzfe(obj);
        }
        int iZzg = zzg(i);
        Object[] objArr2 = new Object[iZzg];
        int i2 = iZzg - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzev.zza(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzel.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzfe(obj4);
        }
        if (zzg(i4) < iZzg / 2) {
            return zzk(i4, objArr);
        }
        if (i4 < 3) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzfc(objArr, i3, objArr2, i2, i4);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzet) && zzh() && ((zzet) obj).zzh() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public abstract int hashCode();

    public boolean zzh() {
        return false;
    }

    public final zzep zzi() {
        zzep zzepVar = this.zza;
        if (zzepVar != null) {
            return zzepVar;
        }
        zzep zzepVarZzj = zzj();
        this.zza = zzepVarZzj;
        return zzepVarZzj;
    }

    public zzep zzj() {
        Object[] array = toArray();
        int i = zzep.$r8$clinit;
        return zzep.zzh(array, array.length);
    }
}
