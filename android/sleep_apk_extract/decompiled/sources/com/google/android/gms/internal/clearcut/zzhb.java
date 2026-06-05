package com.google.android.gms.internal.clearcut;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhb extends zzfu<zzhb> implements Cloneable {
    private static volatile zzhb[] zzbkd;

    public static zzhb[] zzge() {
        if (zzbkd == null) {
            synchronized (zzfy.zzrr) {
                try {
                    if (zzbkd == null) {
                        zzbkd = new zzhb[0];
                    }
                } finally {
                }
            }
        }
        return zzbkd;
    }
}
