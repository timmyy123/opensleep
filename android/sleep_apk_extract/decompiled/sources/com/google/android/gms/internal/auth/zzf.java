package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface zzf extends IInterface {
    Bundle zzd(String str, Bundle bundle);

    @Nullable
    Bundle zze(Account account, String str, Bundle bundle);
}
