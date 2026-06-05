package com.google.android.gms.internal.vision;

/* JADX INFO: loaded from: classes4.dex */
final class zzjz extends zzju {
    private zzjz() {
        super();
    }

    private static <E> zzjl<E> zzc(Object obj, long j) {
        return (zzjl) zzma.zzf(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.vision.zzjl, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // com.google.android.gms.internal.vision.zzju
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzjl zzjlVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzjlVarZzc.size();
        int size2 = Zzc.size();
        ?? r3 = zzjlVarZzc;
        r3 = zzjlVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZza = zzjlVarZzc.zza();
            ?? Zza = zzjlVarZzc;
            if (!zZza) {
                Zza = zzjlVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r3 = Zza;
        }
        if (size > 0) {
            Zzc = r3;
        }
        zzma.zza(obj, j, (Object) Zzc);
    }

    @Override // com.google.android.gms.internal.vision.zzju
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }
}
