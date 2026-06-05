package com.google.android.gms.fitness;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes3.dex */
public final class zzh implements Api.ApiOptions.HasGoogleSignInAccountOptions {
    private final GoogleSignInAccount zza;

    public zzh(Context context, GoogleSignInAccount googleSignInAccount) {
        if ("<<default account>>".equals(googleSignInAccount.getEmail()) && PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
            googleSignInAccount = null;
        }
        this.zza = googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzh) && Objects.equal(((zzh) obj).zza, this.zza);
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zza;
    }

    public final int hashCode() {
        GoogleSignInAccount googleSignInAccount = this.zza;
        if (googleSignInAccount != null) {
            return googleSignInAccount.hashCode();
        }
        return 0;
    }
}
