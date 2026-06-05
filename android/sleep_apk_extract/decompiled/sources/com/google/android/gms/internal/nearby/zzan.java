package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzan {
    private final Class zza;

    public zzan(GoogleApi googleApi, Api.ApiOptions apiOptions) {
        this.zza = googleApi.getClass();
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof zzan) && Objects.equal(this.zza, ((zzan) obj).zza) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null);
    }
}
