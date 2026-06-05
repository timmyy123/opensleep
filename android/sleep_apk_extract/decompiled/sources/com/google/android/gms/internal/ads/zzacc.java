package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzacc extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzacc(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String strConcat = th.getMessage() != null ? ": ".concat(String.valueOf(th.getMessage())) : "";
        super(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strConcat.length() + simpleName.length() + 11), "Unexpected ", simpleName, strConcat), th);
    }
}
