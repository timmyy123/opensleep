package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes3.dex */
public final class zziu extends IllegalStateException {
    public zziu(int i, int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21 + String.valueOf(i2).length() + 1);
        Fragment$$ExternalSyntheticOutline1.m(sb, "Buffer too small (", i, " < ", i2);
        sb.append(")");
        super(sb.toString());
    }
}
