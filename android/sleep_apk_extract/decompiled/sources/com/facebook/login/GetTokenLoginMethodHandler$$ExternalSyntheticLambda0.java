package com.facebook.login;

import android.os.Bundle;
import android.util.Pair;
import androidx.view.result.ActivityResultCallback;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GetTokenLoginMethodHandler$$ExternalSyntheticLambda0 implements ActivityResultCallback, PlatformServiceClient.CompletedListener {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ GetTokenLoginMethodHandler$$ExternalSyntheticLambda0(Object obj, Object obj2) {
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        GetTokenLoginMethodHandler.tryAuthorize$lambda$1((GetTokenLoginMethodHandler) this.f$0, (LoginClient.Request) this.f$1, bundle);
    }

    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.startActivityForResult$lambda$0((LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate) this.f$0, (LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder) this.f$1, (Pair) obj);
    }
}
