package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzps extends IOException {
    public zzps(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
