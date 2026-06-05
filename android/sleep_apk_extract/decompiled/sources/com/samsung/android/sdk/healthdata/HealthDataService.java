package com.samsung.android.sdk.healthdata;

import android.content.Context;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class HealthDataService {
    static boolean a;

    public final void initialize(Context context) {
        if (context == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("context is invalid.");
            return;
        }
        try {
            context.getApplicationContext();
            a = true;
        } catch (Exception unused) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("context is invalid.");
        }
    }
}
