package com.google.android.play.core.install;

import android.content.Intent;
import com.google.android.play.core.appupdate.internal.zzm;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InstallState {
    public static InstallState zza(int i, long j, long j2, int i2, String str) {
        return new zza(i, j, j2, i2, str);
    }

    public static InstallState zzb(Intent intent, zzm zzmVar) {
        zzmVar.zza("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        zzmVar.zza("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        zzmVar.zza("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        return new zza(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
    }

    public abstract long bytesDownloaded();

    public abstract int installErrorCode();

    public abstract int installStatus();

    public abstract String packageName();

    public abstract long totalBytesToDownload();
}
