package com.google.android.gms.internal.vision;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzil implements zzmr {
    private final zzii zza;

    private zzil(zzii zziiVar) {
        zzii zziiVar2 = (zzii) zzjf.zza(zziiVar, "output");
        this.zza = zziiVar2;
        zziiVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzf = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzf += zzii.zzf(list.get(i3).intValue());
        }
        this.zza.zzb(iZzf);
        while (i2 < list.size()) {
            this.zza.zza(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzb(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzi = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzi += zzii.zzi(list.get(i3).intValue());
        }
        this.zza.zzb(iZzi);
        while (i2 < list.size()) {
            this.zza.zzd(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzc(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzd = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzd += zzii.zzd(list.get(i3).longValue());
        }
        this.zza.zzb(iZzd);
        while (i2 < list.size()) {
            this.zza.zza(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzd(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZze = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZze += zzii.zze(list.get(i3).longValue());
        }
        this.zza.zzb(iZze);
        while (i2 < list.size()) {
            this.zza.zza(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zze(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzg += zzii.zzg(list.get(i3).longValue());
        }
        this.zza.zzb(iZzg);
        while (i2 < list.size()) {
            this.zza.zzc(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzf(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzii.zzb(list.get(i3).floatValue());
        }
        this.zza.zzb(iZzb);
        while (i2 < list.size()) {
            this.zza.zza(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzg(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzii.zzb(list.get(i3).doubleValue());
        }
        this.zza.zzb(iZzb);
        while (i2 < list.size()) {
            this.zza.zza(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzh(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzk = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzk += zzii.zzk(list.get(i3).intValue());
        }
        this.zza.zzb(iZzk);
        while (i2 < list.size()) {
            this.zza.zza(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzi(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zza(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzii.zzb(list.get(i3).booleanValue());
        }
        this.zza.zzb(iZzb);
        while (i2 < list.size()) {
            this.zza.zza(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzj(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzc(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzg += zzii.zzg(list.get(i3).intValue());
        }
        this.zza.zzb(iZzg);
        while (i2 < list.size()) {
            this.zza.zzb(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzk(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzj = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzj += zzii.zzj(list.get(i3).intValue());
        }
        this.zza.zzb(iZzj);
        while (i2 < list.size()) {
            this.zza.zzd(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzl(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzh = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzh += zzii.zzh(list.get(i3).longValue());
        }
        this.zza.zzb(iZzh);
        while (i2 < list.size()) {
            this.zza.zzc(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzm(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzh = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzh += zzii.zzh(list.get(i3).intValue());
        }
        this.zza.zzb(iZzh);
        while (i2 < list.size()) {
            this.zza.zzc(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzn(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzf = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzf += zzii.zzf(list.get(i3).longValue());
        }
        this.zza.zzb(iZzf);
        while (i2 < list.size()) {
            this.zza.zzb(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final int zza() {
        return zzmq.zza;
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzb(int i, int i2) {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzc(int i, int i2) {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzd(int i, int i2) {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zze(int i, long j) {
        this.zza.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzf(int i, int i2) {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, int i2) {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzc(int i, long j) {
        this.zza.zza(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzd(int i, long j) {
        this.zza.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zze(int i, int i2) {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzb(int i, Object obj, zzlc zzlcVar) {
        zzii zziiVar = this.zza;
        zziiVar.zza(i, 3);
        zzlcVar.zza((zzkk) obj, zziiVar.zza);
        zziiVar.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, long j) {
        this.zza.zza(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, float f) {
        this.zza.zza(i, f);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, double d) {
        this.zza.zza(i, d);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzb(int i) {
        this.zza.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, boolean z) {
        this.zza.zza(i, z);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzb(int i, long j) {
        this.zza.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, String str) {
        this.zza.zza(i, str);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, zzht zzhtVar) {
        this.zza.zza(i, zzhtVar);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzb(int i, List<zzht> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, Object obj, zzlc zzlcVar) {
        this.zza.zza(i, (zzkk) obj, zzlcVar);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i) {
        this.zza.zza(i, 3);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zzb(int i, List<?> list, zzlc zzlcVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzlcVar);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, Object obj) {
        boolean z = obj instanceof zzht;
        zzii zziiVar = this.zza;
        if (z) {
            zziiVar.zzb(i, (zzht) obj);
        } else {
            zziiVar.zza(i, (zzkk) obj);
        }
    }

    public static zzil zza(zzii zziiVar) {
        zzil zzilVar = zziiVar.zza;
        return zzilVar != null ? zzilVar : new zzil(zziiVar);
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            while (i2 < list.size()) {
                Object objZzb = zzjvVar.zzb(i2);
                boolean z = objZzb instanceof String;
                zzii zziiVar = this.zza;
                if (z) {
                    zziiVar.zza(i, (String) objZzb);
                } else {
                    zziiVar.zza(i, (zzht) objZzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final void zza(int i, List<?> list, zzlc zzlcVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzlcVar);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzmr
    public final <K, V> void zza(int i, zzkf<K, V> zzkfVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zza(i, 2);
            this.zza.zzb(zzkc.zza(zzkfVar, entry.getKey(), entry.getValue()));
            zzkc.zza(this.zza, zzkfVar, entry.getKey(), entry.getValue());
        }
    }
}
