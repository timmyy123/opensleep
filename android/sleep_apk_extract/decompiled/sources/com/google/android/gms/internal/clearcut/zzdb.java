package com.google.android.gms.internal.clearcut;

/* JADX INFO: loaded from: classes3.dex */
final class zzdb extends zzcy {
    private zzdb() {
        super();
    }

    private static <E> zzcn<E> zzc(Object obj, long j) {
        return (zzcn) zzfd.zzo(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.clearcut.zzcn, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // com.google.android.gms.internal.clearcut.zzcy
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzcn zzcnVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzcnVarZzc.size();
        int size2 = Zzc.size();
        ?? r3 = zzcnVarZzc;
        r3 = zzcnVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZzu = zzcnVarZzc.zzu();
            ?? Zzi = zzcnVarZzc;
            if (!zZzu) {
                Zzi = zzcnVarZzc.zzi(size2 + size);
            }
            Zzi.addAll(Zzc);
            r3 = Zzi;
        }
        if (size > 0) {
            Zzc = r3;
        }
        zzfd.zza(obj, j, (Object) Zzc);
    }

    @Override // com.google.android.gms.internal.clearcut.zzcy
    public final void zza(Object obj, long j) {
        zzc(obj, j).zzv();
    }
}
