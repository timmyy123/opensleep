package com.google.android.gms.internal.measurement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.SyncFailedException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsm extends zzso implements zzsf {
    private final FileOutputStream zza;
    private final File zzb;

    public zzsm(FileOutputStream fileOutputStream, File file) {
        super(fileOutputStream);
        this.zza = fileOutputStream;
        this.zzb = file;
    }

    @Override // com.google.android.gms.internal.measurement.zzsf
    public final File zza() {
        return this.zzb;
    }

    public final void zzb() throws SyncFailedException {
        this.zza.getFD().sync();
    }
}
