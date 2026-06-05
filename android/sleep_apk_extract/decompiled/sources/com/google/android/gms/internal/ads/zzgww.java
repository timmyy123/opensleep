package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgww<E> extends zzgwi<E> implements Set<E> {
    private transient zzgwm zza;

    public static zzgww zzh() {
        return zzgyn.zza;
    }

    public static zzgww zzi(Object obj) {
        return new zzgyx(obj);
    }

    public static zzgww zzj(Object obj, Object obj2) {
        return zzw(2, obj, obj2);
    }

    public static zzgww zzk(Object obj, Object obj2, Object obj3) {
        return zzw(3, obj, obj2, obj3);
    }

    public static zzgww zzl(Object obj, Object obj2, Object obj3, Object obj4) {
        return zzw(4, obj, obj2, obj3, obj4);
    }

    public static zzgww zzm(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzw(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzgww zzn(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        int i = length + 6;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return zzw(i, objArr2);
    }

    public static int zzo(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzgtj.zzb(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzgww zzp(Collection collection) {
        if ((collection instanceof zzgww) && !(collection instanceof SortedSet)) {
            zzgww zzgwwVar = (zzgww) collection;
            if (!zzgwwVar.zzf()) {
                return zzgwwVar;
            }
        }
        Object[] array = collection.toArray();
        return zzw(array.length, array);
    }

    public static zzgww zzq(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? zzw(length, (Object[]) objArr.clone()) : new zzgyx(objArr[0]) : zzgyn.zza;
    }

    public static zzgwv zzt(int i) {
        zzgvi.zzb(i, "expectedSize");
        return new zzgwv(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgww zzw(int i, Object... objArr) {
        if (i == 0) {
            return zzgyn.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzgyx(obj);
        }
        int iZzo = zzo(i);
        Object[] objArr2 = new Object[iZzo];
        int i2 = iZzo - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzgyf.zzb(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzgwf.zza(iHashCode);
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
            return new zzgyx(obj4);
        }
        if (zzo(i4) < iZzo / 2) {
            return zzw(i4, objArr);
        }
        if (zzx(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzgyn(objArr, i3, objArr2, i2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzx(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgww) && zzr() && ((zzgww) obj).zzr() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzgyw.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgyw.zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    public abstract zzgza zza();

    @Override // com.google.android.gms.internal.ads.zzgwi
    public zzgwm zze() {
        zzgwm zzgwmVar = this.zza;
        if (zzgwmVar != null) {
            return zzgwmVar;
        }
        zzgwm zzgwmVarZzs = zzs();
        this.zza = zzgwmVarZzs;
        return zzgwmVarZzs;
    }

    public boolean zzr() {
        return false;
    }

    public zzgwm zzs() {
        Object[] array = toArray();
        int i = zzgwm.$r8$clinit;
        return zzgwm.zzt(array, array.length);
    }
}
