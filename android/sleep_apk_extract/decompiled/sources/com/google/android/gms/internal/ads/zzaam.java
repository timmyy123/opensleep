package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.appfunctions.AppFunctionException;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaam extends zzbl {
    public static final zzaam zzJ = new zzaam(new zzaal());
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final boolean zzV;
    public final boolean zzW;
    public final boolean zzX;
    public final boolean zzY;
    private final SparseArray zzZ;
    private final SparseBooleanArray zzaa;

    static {
        String str = zzfl.zza;
        Integer.toString(1000, 36);
        Integer.toString(1001, 36);
        Integer.toString(1002, 36);
        Integer.toString(AppFunctionException.ERROR_FUNCTION_NOT_FOUND, 36);
        Integer.toString(1004, 36);
        Integer.toString(1005, 36);
        Integer.toString(1006, 36);
        Integer.toString(1007, 36);
        Integer.toString(1008, 36);
        Integer.toString(1009, 36);
        Integer.toString(1010, 36);
        Integer.toString(1011, 36);
        Integer.toString(1012, 36);
        Integer.toString(1013, 36);
        Integer.toString(1014, 36);
        Integer.toString(1015, 36);
        Integer.toString(1016, 36);
        Integer.toString(1017, 36);
        Integer.toString(1018, 36);
    }

    private zzaam(zzaal zzaalVar) {
        super(zzaalVar);
        this.zzK = zzaalVar.zzz();
        this.zzL = false;
        this.zzM = zzaalVar.zzA();
        this.zzN = false;
        this.zzO = zzaalVar.zzB();
        this.zzP = false;
        this.zzQ = false;
        this.zzR = false;
        this.zzS = false;
        this.zzT = zzaalVar.zzC();
        this.zzU = zzaalVar.zzD();
        this.zzV = zzaalVar.zzE();
        this.zzW = false;
        this.zzX = zzaalVar.zzF();
        this.zzY = false;
        this.zzZ = zzaalVar.zzG();
        this.zzaa = zzaalVar.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaam.class == obj.getClass()) {
            zzaam zzaamVar = (zzaam) obj;
            if (super.equals(zzaamVar) && this.zzK == zzaamVar.zzK && this.zzM == zzaamVar.zzM && this.zzO == zzaamVar.zzO && this.zzT == zzaamVar.zzT && this.zzU == zzaamVar.zzU && this.zzV == zzaamVar.zzV && this.zzX == zzaamVar.zzX) {
                SparseBooleanArray sparseBooleanArray = this.zzaa;
                SparseBooleanArray sparseBooleanArray2 = zzaamVar.zzaa;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray sparseArray = this.zzZ;
                            SparseArray sparseArray2 = zzaamVar.zzZ;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (iIndexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(iIndexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzzn zzznVar = (zzzn) entry.getKey();
                                                if (!map2.containsKey(zzznVar) || !Objects.equals(entry.getValue(), map2.get(zzznVar))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.zzK ? 1 : 0)) * 961) + (this.zzM ? 1 : 0)) * 961) + (this.zzO ? 1 : 0)) * 28629151) + (this.zzT ? 1 : 0)) * 31) + (this.zzU ? 1 : 0)) * 31) + (this.zzV ? 1 : 0)) * 961) + (this.zzX ? 1 : 0)) * 31;
    }

    public final boolean zza(int i) {
        return this.zzaa.get(i);
    }

    @Deprecated
    public final boolean zzb(int i, zzzn zzznVar) {
        Map map = (Map) this.zzZ.get(i);
        return map != null && map.containsKey(zzznVar);
    }

    @Deprecated
    public final zzaan zzc(int i, zzzn zzznVar) {
        Map map = (Map) this.zzZ.get(i);
        if (map != null && map.get(zzznVar) != null) {
            Events$$ExternalSyntheticBUOutline0.m();
        }
        return null;
    }

    public final zzaal zzd() {
        return new zzaal(this, null);
    }

    public final /* synthetic */ SparseArray zze() {
        return this.zzZ;
    }

    public final /* synthetic */ SparseBooleanArray zzf() {
        return this.zzaa;
    }

    public /* synthetic */ zzaam(zzaal zzaalVar, byte[] bArr) {
        this(zzaalVar);
    }
}
