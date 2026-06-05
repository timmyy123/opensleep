package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class zzabc extends AbstractMap {
    private static final Comparator zza = new zzaaz();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd;
    private Integer zze;
    private String zzf;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzabc, java.util.AbstractMap] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.measurement.zzabc] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public zzabc(zzabc zzabcVar, zzabc zzabcVar2) {
        int i;
        Object objZza;
        Object[] objArr;
        ?? abstractMap = new AbstractMap();
        abstractMap.zzd = new zzabb(abstractMap, -1);
        abstractMap.zze = null;
        abstractMap.zzf = null;
        int size = zzabcVar2.size() + zzabcVar.size();
        int i2 = zzabcVar.zzc[zzabcVar.size()] + zzabcVar2.zzc[zzabcVar2.size()];
        int i3 = size + 1;
        Object[] objArr2 = new Object[i2];
        int[] iArr = new int[i3];
        int i4 = 0;
        iArr[0] = size;
        Map.Entry entryZzg = zzabcVar.zzg(0);
        Map.Entry entryZzg2 = zzabcVar2.zzg(0);
        int i5 = 0;
        int i6 = 0;
        int iZzd = size;
        int i7 = 0;
        while (true) {
            int i8 = 1;
            if (entryZzg == null && entryZzg2 == null) {
                break;
            }
            int i9 = i7 + 1;
            if (entryZzg != null) {
                if (entryZzg2 != null) {
                    int iCompareTo = ((String) entryZzg.getKey()).compareTo((String) entryZzg2.getKey());
                    if (iCompareTo == 0) {
                        int i10 = i5 + 1;
                        int i11 = i6 + 1;
                        objArr2[i7] = abstractMap.zzf((String) entryZzg.getKey(), i7);
                        zzabb zzabbVar = (zzabb) entryZzg.getValue();
                        zzabb zzabbVar2 = (zzabb) entryZzg2.getValue();
                        int i12 = 0;
                        int i13 = 0;
                        abstractMap = abstractMap;
                        while (true) {
                            if (i12 >= zzabbVar.zzc() - zzabbVar.zzb() && i13 >= zzabbVar2.zzc() - zzabbVar2.zzb()) {
                                break;
                            }
                            int iCompare = i12 == zzabbVar.zzc() - zzabbVar.zzb() ? i8 : i13 == zzabbVar2.zzc() - zzabbVar2.zzb() ? -1 : 0;
                            if (iCompare == 0) {
                                int i14 = zzabe.$r8$clinit;
                                iCompare = zzabe.zzb.compare(zzabbVar.zza(i12), zzabbVar2.zza(i13));
                            }
                            if (iCompare < 0) {
                                i = i12 + 1;
                                objZza = zzabbVar.zza(i12);
                            } else {
                                int i15 = i13 + 1;
                                Object objZza2 = zzabbVar2.zza(i13);
                                i13 = i15;
                                i = iCompare == 0 ? i12 + 1 : i12;
                                objZza = objZza2;
                            }
                            objArr2[iZzd] = objZza;
                            i12 = i;
                            iZzd++;
                            i8 = 1;
                            abstractMap = this;
                        }
                        iArr[i9] = iZzd;
                        entryZzg = zzabcVar.zzg(i11);
                        entryZzg2 = zzabcVar2.zzg(i10);
                        i6 = i11;
                        i5 = i10;
                        i7 = i9;
                        i4 = 0;
                    } else {
                        if (iCompareTo < 0) {
                        }
                        i7 = i9;
                        i4 = 0;
                        abstractMap = this;
                    }
                }
                i6++;
                iZzd = zzd(entryZzg, i7, iZzd, objArr2, iArr);
                entryZzg = zzabcVar.zzg(i6);
                i7 = i9;
                i4 = 0;
                abstractMap = this;
            }
            Map.Entry entry = entryZzg;
            i5++;
            int iZzd2 = zzd(entryZzg2, i7, iZzd, objArr2, iArr);
            entryZzg2 = zzabcVar2.zzg(i5);
            iZzd = iZzd2;
            entryZzg = entry;
            i7 = i9;
            i4 = 0;
            abstractMap = this;
        }
        int i16 = iArr[i4];
        int i17 = i16 - i7;
        if (i17 != 0) {
            for (int i18 = i4; i18 <= i7; i18++) {
                iArr[i18] = iArr[i18] - i17;
            }
            int i19 = iArr[i7];
            int i20 = i19 - i7;
            if (zze(i2, i19)) {
                objArr = new Object[i19];
                System.arraycopy(objArr2, i4, objArr, i4, i7);
            } else {
                objArr = objArr2;
            }
            System.arraycopy(objArr2, i16, objArr, i7, i20);
            objArr2 = objArr;
        }
        abstractMap.zzb = objArr2;
        int i21 = iArr[i4] + 1;
        abstractMap.zzc = zze(i3, i21) ? Arrays.copyOf(iArr, i21) : iArr;
    }

    private final int zzd(Map.Entry entry, int i, int i2, Object[] objArr, int[] iArr) {
        zzabb zzabbVar = (zzabb) entry.getValue();
        int iZzc = zzabbVar.zzc() - zzabbVar.zzb();
        System.arraycopy(zzabbVar.zzb.zzb, zzabbVar.zzb(), objArr, i2, iZzc);
        objArr[i] = zzf((String) entry.getKey(), i);
        int i3 = i2 + iZzc;
        iArr[i + 1] = i3;
        return i3;
    }

    private static boolean zze(int i, int i2) {
        return i > 16 && i * 9 > i2 * 10;
    }

    private final Map.Entry zzf(String str, int i) {
        return new AbstractMap.SimpleImmutableEntry(str, new zzabb(this, i));
    }

    private final Map.Entry zzg(int i) {
        if (i < this.zzc[0]) {
            return (Map.Entry) this.zzb[i];
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }

    public final /* synthetic */ Object[] zzb() {
        return this.zzb;
    }

    public final /* synthetic */ int[] zzc() {
        return this.zzc;
    }

    public zzabc(List list) {
        this.zzd = new zzabb(this, -1);
        this.zze = null;
        this.zzf = null;
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            int size = list.size();
            Object[] objArr = new Object[size];
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                int[] iArr = {0};
                this.zzb = zze(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
                this.zzc = iArr;
                return;
            }
            throw FileInsert$$ExternalSyntheticOutline0.m(it2);
        }
        throw FileInsert$$ExternalSyntheticOutline0.m(it);
    }
}
