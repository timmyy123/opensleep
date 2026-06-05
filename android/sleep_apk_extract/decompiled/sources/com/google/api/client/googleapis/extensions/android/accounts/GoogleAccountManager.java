package com.google.api.client.googleapis.extensions.android.accounts;

import android.accounts.AccountManager;
import android.content.Context;
import com.google.api.client.util.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class GoogleAccountManager {
    private final AccountManager manager;

    public GoogleAccountManager(AccountManager accountManager) {
        this.manager = (AccountManager) Preconditions.checkNotNull(accountManager);
    }

    public GoogleAccountManager(Context context) {
        this(AccountManager.get(context));
    }
}
