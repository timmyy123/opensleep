package com.google.android.gms.common.internal;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zan implements Executor {
    private static volatile zan zaa;
    private static Context zab;

    private zan() {
    }

    public static zan zaa(Context context) {
        zan zanVar;
        zan zanVar2 = zaa;
        if (zanVar2 != null) {
            return zanVar2;
        }
        synchronized (zan.class) {
            try {
                zanVar = zaa;
                if (zanVar == null) {
                    zab = (Context) Preconditions.checkNotNull(context.getApplicationContext());
                    zanVar = new zan();
                    zaa = zanVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zanVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        zam.zaa.post(runnable);
    }
}
