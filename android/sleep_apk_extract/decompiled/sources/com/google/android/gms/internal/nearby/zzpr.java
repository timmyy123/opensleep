package com.google.android.gms.internal.nearby;

/* JADX INFO: loaded from: classes3.dex */
final class zzpr extends zzpp {
    private final zzpt zza;

    public zzpr(zzpt zzptVar, int i) {
        super(zzptVar.size(), i);
        this.zza = zzptVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzpp
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
