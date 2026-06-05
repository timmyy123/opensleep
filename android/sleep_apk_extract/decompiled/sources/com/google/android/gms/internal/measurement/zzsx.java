package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface zzsx {
    String zzc();

    InputStream zzd(Uri uri);

    boolean zze(Uri uri);

    File zzg(Uri uri);

    OutputStream zzj(Uri uri);

    void zzk(Uri uri);

    void zzl(Uri uri, Uri uri2);
}
