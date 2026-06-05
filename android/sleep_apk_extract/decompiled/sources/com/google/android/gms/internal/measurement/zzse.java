package com.google.android.gms.internal.measurement;

import com.google.common.collect.Iterables;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzse implements zzro {
    private OutputStream zza;
    private zzsm zzb;

    @Override // com.google.android.gms.internal.measurement.zzro
    public final void zza(List list) {
        OutputStream outputStream = (OutputStream) Iterables.getLast(list);
        if (outputStream instanceof zzsm) {
            this.zzb = (zzsm) outputStream;
            this.zza = (OutputStream) list.get(0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzro
    public final void zzb() throws IOException {
        zzc();
    }

    public final void zzc() throws IOException {
        if (this.zzb == null) {
            throw new zzsk("Cannot sync underlying stream");
        }
        this.zza.flush();
        this.zzb.zzb();
    }
}
