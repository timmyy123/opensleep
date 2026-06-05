package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class zzhq extends IOException {
    public final int zza;

    public zzhq(int i) {
        this.zza = i;
    }

    public zzhq(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzhq(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzhq(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}
