package com.google.android.gms.internal.measurement;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.DataFormatException;

/* JADX INFO: loaded from: classes3.dex */
final class zzmr extends InputStream {
    final /* synthetic */ zzmu zza;

    public zzmr(zzmu zzmuVar) {
        Objects.requireNonNull(zzmuVar);
        this.zza = zzmuVar;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            zzmu zzmuVar = this.zza;
            int iInflate = zzmuVar.zzd().inflate(bArr, i, i2);
            if (iInflate > 0) {
                return iInflate;
            }
            if (i2 != 0) {
                if (zzmuVar.zzd().getRemaining() == 0) {
                    return -1;
                }
                int remaining = this.zza.zzd().getRemaining();
                OggIO$$ExternalSyntheticBUOutline0.m(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i2).length() + 70 + String.valueOf(remaining).length()), i2, "Read no bytes (requested up to ", remaining, ") but did not reach end of stream, had "));
            }
            return 0;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0];
    }
}
