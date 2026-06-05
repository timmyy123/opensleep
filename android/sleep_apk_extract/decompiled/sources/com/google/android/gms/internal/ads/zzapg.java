package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzapg implements zzang {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzapg(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i = 0; i < list.size(); i++) {
            zzaow zzaowVar = (zzaow) list.get(i);
            long[] jArr = this.zzb;
            int i2 = i + i;
            jArr[i2] = zzaowVar.zzb;
            jArr[i2 + 1] = zzaowVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final long zzb(int i) {
        zzgtj.zza(i >= 0);
        long[] jArr = this.zzc;
        zzgtj.zza(i < jArr.length);
        return jArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            List list = this.zza;
            if (i >= list.size()) {
                break;
            }
            long[] jArr = this.zzb;
            int i2 = i + i;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                zzaow zzaowVar = (zzaow) list.get(i);
                zzcx zzcxVar = zzaowVar.zza;
                if (zzcxVar.zze == -3.4028235E38f) {
                    arrayList2.add(zzaowVar);
                } else {
                    arrayList.add(zzcxVar);
                }
            }
            i++;
        }
        Collections.sort(arrayList2, zzapf.zza);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            zzcw zzcwVarZza = ((zzaow) arrayList2.get(i3)).zza.zza();
            zzcwVarZza.zzf((-1) - i3, 1);
            arrayList.add(zzcwVarZza.zzr());
        }
        return arrayList;
    }
}
