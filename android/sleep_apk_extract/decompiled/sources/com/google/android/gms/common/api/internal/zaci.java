package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zaci implements Runnable {
    final /* synthetic */ zacl zaa;

    public zaci(zacl zaclVar) {
        Objects.requireNonNull(zaclVar);
        this.zaa = zaclVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zaf().zaa(new ConnectionResult(4));
    }
}
