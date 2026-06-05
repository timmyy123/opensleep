package com.google.android.gms.internal.ads;

import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes5.dex */
final class zzasi extends zzasj {
    private final byte[] zza;

    public zzasi(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.zza = bArr;
    }

    @Override // java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.zza;
    }
}
