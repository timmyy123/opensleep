package com.google.android.gms.internal.ads;

import android.content.Context;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzado implements zzbs {
    private final zzbq zza = new zzadn(false);

    public zzado(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final zzbu zza(Context context, zzi zziVar, zzl zzlVar, zzbt zzbtVar, Executor executor, long j, boolean z) {
        try {
            ((zzbs) Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(zzbq.class).newInstance(this.zza)).zza(context, zziVar, zzlVar, zzbtVar, executor, 0L, false);
            return null;
        } catch (Exception e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }
}
