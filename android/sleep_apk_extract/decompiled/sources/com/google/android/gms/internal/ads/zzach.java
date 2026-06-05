package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzach {
    private static final Comparator zza = zzacg.zza;
    private static final Comparator zzb = zzacf.zza;
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzace[] zzd = new zzace[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzach(int i) {
    }

    public final void zza() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }

    public final void zzb(int i, float f) {
        zzace zzaceVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzace[] zzaceVarArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzaceVar = zzaceVarArr[i3];
        } else {
            zzaceVar = new zzace(null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzaceVar.zza = i4;
        zzaceVar.zzb = i;
        zzaceVar.zzc = f;
        ArrayList arrayList = this.zzc;
        arrayList.add(zzaceVar);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            zzace zzaceVar2 = (zzace) arrayList.get(0);
            int i7 = zzaceVar2.zzb;
            if (i7 <= i6) {
                this.zzg -= i7;
                arrayList.remove(0);
                int i8 = this.zzh;
                if (i8 < 5) {
                    zzace[] zzaceVarArr2 = this.zzd;
                    this.zzh = i8 + 1;
                    zzaceVarArr2[i8] = zzaceVar2;
                }
            } else {
                zzaceVar2.zzb = i7 - i6;
                this.zzg -= i6;
            }
        }
    }

    public final float zzc(float f) {
        int i = 0;
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = this.zzg;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.zzc;
            if (i >= arrayList.size()) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((zzace) arrayList.get(arrayList.size() - 1)).zzc;
            }
            float f3 = 0.5f * f2;
            zzace zzaceVar = (zzace) arrayList.get(i);
            i2 += zzaceVar.zzb;
            if (i2 >= f3) {
                return zzaceVar.zzc;
            }
            i++;
        }
    }
}
