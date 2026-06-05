package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class zzk implements Callable<SharedPreferences> {
    private final /* synthetic */ Context val$context;

    public zzk(Context context) {
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() {
        return this.val$context.getSharedPreferences("google_sdk_flags", 0);
    }
}
