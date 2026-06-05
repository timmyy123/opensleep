package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzsc {
    public static final File zza(Uri uri) throws zzsi {
        if (!uri.getScheme().equals(ShareInternalUtility.STAGING_PARAM)) {
            throw new zzsi("Scheme must be 'file'");
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new zzsi("Did not expect uri to have query");
        }
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return new File(uri.getPath());
        }
        throw new zzsi("Did not expect uri to have authority");
    }
}
