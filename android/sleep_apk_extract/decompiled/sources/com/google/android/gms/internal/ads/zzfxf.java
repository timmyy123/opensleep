package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzfxf implements Continuation {
    static final /* synthetic */ zzfxf zza = new zzfxf();

    private /* synthetic */ zzfxf() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        return new Boolean(task.isSuccessful());
    }
}
