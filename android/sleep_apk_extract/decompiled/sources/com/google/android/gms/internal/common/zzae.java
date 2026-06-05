package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes3.dex */
final class zzae extends zzz {
    private final zzah zza;

    public zzae(zzah zzahVar, int i) {
        super(zzahVar.size(), i);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
