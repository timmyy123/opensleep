package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zau implements Runnable {
    final /* synthetic */ zax zaa;

    public zau(zax zaxVar) {
        Objects.requireNonNull(zaxVar);
        this.zaa = zaxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            zaxVar.zao();
        } finally {
            this.zaa.zay().unlock();
        }
    }
}
