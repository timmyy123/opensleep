package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzuv extends Handler {
    final /* synthetic */ zzux zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzuv(zzux zzuxVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zzuxVar);
        this.zza = zzuxVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zza.zzh(message);
    }
}
