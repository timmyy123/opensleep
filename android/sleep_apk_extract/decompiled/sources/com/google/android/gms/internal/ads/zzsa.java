package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsa extends Exception {
    public final boolean zza;

    public zzsa(int i, int i2, int i3, int i4, int i5, zzv zzvVar, boolean z, Exception exc) {
        String strValueOf = String.valueOf(zzvVar);
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(i3).length();
        int length3 = String.valueOf(i4).length();
        StringBuilder sb = new StringBuilder(length + 34 + length2 + 2 + length3 + 2 + String.valueOf(i5).length() + 2 + strValueOf.length());
        Fragment$$ExternalSyntheticOutline1.m(sb, "AudioTrack init failed 0 Config(", i2, ", ", i3);
        Fragment$$ExternalSyntheticOutline1.m(sb, ", ", i4, ", ", i5);
        super(Fragment$$ExternalSyntheticOutline1.m(sb, ") ", strValueOf, ""), exc);
        this.zza = false;
    }
}
