package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgez implements zzgfa {
    private final zzifp zza;

    public zzgez(zzifp zzifpVar) {
        this.zza = zzifpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* synthetic */ void zza(Object obj, OutputStream outputStream) {
        ((zzifp) obj).zzaO(outputStream);
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* bridge */ /* synthetic */ Object zzb(InputStream inputStream) {
        try {
            return (zzifp) this.zza.zzbd().zza(inputStream, zzido.zza());
        } catch (zziet e) {
            throw new zzgew("Cannot read proto.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* synthetic */ Object zzc() {
        return this.zza;
    }
}
