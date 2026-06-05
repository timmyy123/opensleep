package com.google.android.gms.internal.fitness;

/* JADX INFO: loaded from: classes3.dex */
final class zzen extends zzej {
    private final zzep zza;

    public zzen(zzep zzepVar, int i) {
        super(zzepVar.size(), i);
        this.zza = zzepVar;
    }

    @Override // com.google.android.gms.internal.fitness.zzej
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
