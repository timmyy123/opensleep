package com.google.android.gms.internal.clearcut;

/* JADX INFO: loaded from: classes3.dex */
abstract /* synthetic */ class zzcc {
    static final /* synthetic */ int[] zzje;
    static final /* synthetic */ int[] zzjf;

    static {
        int[] iArr = new int[zzcq.values().length];
        zzjf = iArr;
        try {
            iArr[zzcq.zzle.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzjf[zzcq.zzlg.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzjf[zzcq.zzld.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[zzcd.values().length];
        zzje = iArr2;
        try {
            iArr2[zzcd.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzje[zzcd.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzje[zzcd.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
