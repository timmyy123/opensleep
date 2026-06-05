package com.google.android.gms.internal.vision;

/* JADX INFO: loaded from: classes4.dex */
final class zzmg extends IllegalArgumentException {
    public zzmg(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
