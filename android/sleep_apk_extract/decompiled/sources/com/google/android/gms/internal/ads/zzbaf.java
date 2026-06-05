package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbaf implements zzfyw {
    final /* synthetic */ zzfxb zza;

    public zzbaf(zzbah zzbahVar, zzfxb zzfxbVar) {
        this.zza = zzfxbVar;
        Objects.requireNonNull(zzbahVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyw
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
