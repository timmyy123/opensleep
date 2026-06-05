package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsd implements zzsx {
    public zzsd() {
        new zzsh();
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final String zzc() {
        return ShareInternalUtility.STAGING_PARAM;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final InputStream zzd(Uri uri) {
        return zzsl.zzb(zzsc.zza(uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final boolean zze(Uri uri) {
        return zzsc.zza(uri).exists();
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final File zzg(Uri uri) {
        return zzsc.zza(uri);
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final OutputStream zzj(Uri uri) throws IOException {
        File fileZza = zzsc.zza(uri);
        Files.createParentDirs(fileZza);
        return new zzsm(new FileOutputStream(fileZza), fileZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzk(Uri uri) throws IOException {
        File fileZza = zzsc.zza(uri);
        if (fileZza.isDirectory()) {
            throw new FileNotFoundException(String.format("%s is a directory", uri));
        }
        if (fileZza.delete()) {
            return;
        }
        if (!fileZza.exists()) {
            throw new FileNotFoundException(String.format("%s does not exist", uri));
        }
        throw new IOException(String.format("%s could not be deleted", uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzl(Uri uri, Uri uri2) throws IOException {
        File fileZza = zzsc.zza(uri);
        File fileZza2 = zzsc.zza(uri2);
        Files.createParentDirs(fileZza2);
        if (!fileZza.renameTo(fileZza2)) {
            throw new IOException(String.format("%s could not be renamed to %s", uri, uri2));
        }
    }

    public zzsd(zzsh zzshVar) {
    }
}
