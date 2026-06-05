package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
final class zzac extends ContentObserver {
    private final /* synthetic */ zzab zzdm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzab zzabVar, Handler handler) {
        super(null);
        this.zzdm = zzabVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zzdm.zzh();
        this.zzdm.zzj();
    }
}
