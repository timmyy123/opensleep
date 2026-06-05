package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UserRecoverableException extends Exception {
    private final Intent zza;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.zza = intent;
    }

    public Intent getIntent() {
        return new Intent(this.zza);
    }
}
