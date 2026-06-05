package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzsv extends AudioTrack$StreamEventCallback {
    final /* synthetic */ zzsx zza;

    public zzsv(zzsx zzsxVar) {
        Objects.requireNonNull(zzsxVar);
        this.zza = zzsxVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzsu.zza);
        zzefVarZzu.zzf();
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzss.zza);
        zzefVarZzu.zzf();
    }

    public final void onTearDown(AudioTrack audioTrack) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzst.zza);
        zzefVarZzu.zzf();
    }
}
