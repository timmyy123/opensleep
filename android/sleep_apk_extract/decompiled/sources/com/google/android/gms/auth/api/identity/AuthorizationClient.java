package com.google.android.gms.auth.api.identity;

import android.content.Intent;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public interface AuthorizationClient {
    Task<AuthorizationResult> authorize(AuthorizationRequest authorizationRequest);

    AuthorizationResult getAuthorizationResultFromIntent(Intent intent);
}
