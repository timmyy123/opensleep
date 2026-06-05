package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.os.Process;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzsu {
    private static final AtomicLong zza = new AtomicLong();

    public static Uri zza(Uri uri) {
        int iMyPid = Process.myPid();
        long id = Thread.currentThread().getId();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long andIncrement = zza.getAndIncrement();
        int length = String.valueOf(iMyPid).length();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length + 15 + String.valueOf(id).length(), 1, String.valueOf(jCurrentTimeMillis).length(), 1, String.valueOf(andIncrement).length()));
        sb.append(".mobstore_tmp-");
        sb.append(iMyPid);
        sb.append("-");
        sb.append(id);
        zzba$$ExternalSyntheticOutline0.m(sb, "-", jCurrentTimeMillis, "-");
        sb.append(andIncrement);
        return uri.buildUpon().path(String.valueOf(uri.getPath()).concat(sb.toString())).build();
    }
}
