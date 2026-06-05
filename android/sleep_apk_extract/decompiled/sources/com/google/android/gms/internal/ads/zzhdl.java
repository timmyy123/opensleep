package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhdl {
    private final OutputStream zza;

    private zzhdl(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzhdl zzb(OutputStream outputStream) {
        return new zzhdl(outputStream);
    }

    public final void zza(zzhsz zzhszVar) throws IOException {
        try {
            zzhszVar.zzaO(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
