package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zbd implements Api.ApiOptions {
    public static final zbd zba = new zbd(new zbc());
    private final String zbb = null;
    private final boolean zbc;
    private final String zbd;

    public zbd(zbc zbcVar) {
        this.zbc = zbcVar.zba.booleanValue();
        this.zbd = zbcVar.zbb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zbd)) {
            return false;
        }
        zbd zbdVar = (zbd) obj;
        return Objects.equal(null, null) && this.zbc == zbdVar.zbc && Objects.equal(this.zbd, zbdVar.zbd);
    }

    public final int hashCode() {
        return Objects.hashCode(null, Boolean.valueOf(this.zbc), this.zbd);
    }

    public final Bundle zba() {
        Bundle bundleM = zzba$$ExternalSyntheticOutline0.m("consumer_package", (String) null);
        bundleM.putBoolean("force_save_dialog", this.zbc);
        bundleM.putString("log_session_id", this.zbd);
        return bundleM;
    }

    public final /* synthetic */ boolean zbb() {
        return this.zbc;
    }

    public final /* synthetic */ String zbc() {
        return this.zbd;
    }
}
