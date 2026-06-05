package com.google.android.gms.home.internal;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.home.internal.zza, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/google/android/gms/home/internal/AuthorizationClientImpl;", "Lcom/google/android/gms/home/internal/AuthorizationClient;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "authorizationClient", "Lcom/google/android/gms/auth/api/identity/AuthorizationClient;", "<init>", "(Landroid/content/Context;Lcom/google/android/gms/auth/api/identity/AuthorizationClient;)V", "getAuthorizationClient$java_com_google_android_gmscore_integ_client_home_home", "()Lcom/google/android/gms/auth/api/identity/AuthorizationClient;", "authorize", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/identity/AuthorizationResult;", "request", "Lcom/google/android/gms/auth/api/identity/AuthorizationRequest;", "getAuthorizationResultFromIntent", "data", "Landroid/content/Intent;", "clearToken", "", "token", "", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuthorizationClientImpl implements AuthorizationClient {
    private final Context zza;
    private final com.google.android.gms.auth.api.identity.AuthorizationClient zzb;

    public AuthorizationClientImpl(Context context, com.google.android.gms.auth.api.identity.AuthorizationClient authorizationClient) {
        context.getClass();
        authorizationClient.getClass();
        this.zza = context;
        this.zzb = authorizationClient;
    }

    @Override // com.google.android.gms.home.internal.AuthorizationClient
    public final Task zza(AuthorizationRequest authorizationRequest) {
        authorizationRequest.getClass();
        Task<AuthorizationResult> taskAuthorize = this.zzb.authorize(authorizationRequest);
        taskAuthorize.getClass();
        return taskAuthorize;
    }

    @Override // com.google.android.gms.home.internal.AuthorizationClient
    public final AuthorizationResult zzb(Intent intent) {
        AuthorizationResult authorizationResultFromIntent = this.zzb.getAuthorizationResultFromIntent(intent);
        authorizationResultFromIntent.getClass();
        return authorizationResultFromIntent;
    }

    @Override // com.google.android.gms.home.internal.AuthorizationClient
    public final void zzc(String str) throws GoogleAuthException, IOException {
        str.getClass();
        GoogleAuthUtil.clearToken(this.zza, str);
    }
}
