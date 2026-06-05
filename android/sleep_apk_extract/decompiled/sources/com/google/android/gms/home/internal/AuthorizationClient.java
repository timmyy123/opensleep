package com.google.android.gms.home.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/google/android/gms/home/internal/AuthorizationClient;", "", "authorize", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/identity/AuthorizationResult;", "request", "Lcom/google/android/gms/auth/api/identity/AuthorizationRequest;", "getAuthorizationResultFromIntent", "data", "Landroid/content/Intent;", "clearToken", "", "token", "", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AuthorizationClient {
    Task zza(AuthorizationRequest authorizationRequest);

    AuthorizationResult zzb(Intent intent);

    void zzc(String str);
}
