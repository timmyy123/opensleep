package com.google.android.gms.internal.play_billing;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgp extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzgp(long j, long j2, int i, Throwable th) {
        Locale locale = Locale.US;
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Pos: ", ", limit: ", j);
        sbM.append(j2);
        sbM.append(", len: ");
        sbM.append(i);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbM.toString()), th);
    }

    public zzgp(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
