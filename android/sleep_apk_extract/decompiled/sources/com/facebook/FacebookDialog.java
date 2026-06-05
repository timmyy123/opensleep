package com.facebook;

import androidx.view.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H&J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/FacebookDialog;", "CONTENT", "RESULT", "", "canShow", "", "content", "(Ljava/lang/Object;)Z", "createActivityResultContractForShowingDialog", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "callbackManager", "Lcom/facebook/CallbackManager;", "registerCallback", "", "callback", "Lcom/facebook/FacebookCallback;", "requestCode", "", "show", "(Ljava/lang/Object;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FacebookDialog<CONTENT, RESULT> {
    boolean canShow(CONTENT content);

    ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager);

    void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback);

    void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback, int requestCode);

    void show(CONTENT content);
}
