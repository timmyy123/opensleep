package com.google.android.gms.auth.api;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zbc {
    protected Boolean zba;
    protected String zbb;

    public zbc(zbd zbdVar) {
        this.zba = Boolean.FALSE;
        this.zba = Boolean.valueOf(zbdVar.zbb());
        this.zbb = zbdVar.zbc();
    }

    public final zbc zba(String str) {
        this.zbb = str;
        return this;
    }

    public zbc() {
        this.zba = Boolean.FALSE;
    }
}
