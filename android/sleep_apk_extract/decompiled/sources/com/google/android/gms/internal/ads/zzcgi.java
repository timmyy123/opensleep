package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcgi implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcgr zzb;

    public zzcgi(zzcgr zzcgrVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        Objects.requireNonNull(zzcgrVar);
        this.zzb = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zzb;
        zzcgrVar.zzs(this.zza);
        if (zzcgrVar.zzt() != null) {
            zzcgrVar.zzt().zzb();
        }
    }
}
