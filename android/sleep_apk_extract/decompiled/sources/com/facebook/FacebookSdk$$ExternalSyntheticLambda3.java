package com.facebook;

import androidx.view.result.ActivityResultCallback;
import com.facebook.CallbackManager;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.login.widget.LoginButton;
import java.nio.file.Path;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FacebookSdk$$ExternalSyntheticLambda3 implements FeatureManager.Callback, InstallReferrerUtil.Callback, ActivityResultCallback {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FacebookSdk$$ExternalSyntheticLambda3(int i) {
        this.$r8$classId = i;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return Path.class;
    }

    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        LoginButton.onAttachedToWindow$lambda$0((CallbackManager.ActivityResultParameters) obj);
    }

    @Override // com.facebook.internal.FeatureManager.Callback
    public void onCompleted(boolean z) {
        switch (this.$r8$classId) {
            case 0:
                FacebookSdk.sdkInitialize$lambda$4(z);
                break;
            case 1:
                FacebookSdk.sdkInitialize$lambda$5(z);
                break;
            case 2:
                FacebookSdk.sdkInitialize$lambda$6(z);
                break;
            case 3:
                FacebookSdk.sdkInitialize$lambda$7(z);
                break;
            case 4:
                FacebookSdk.sdkInitialize$lambda$8(z);
                break;
            case 5:
            default:
                InstrumentManager.start$lambda$2(z);
                break;
            case 6:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$0(z);
                break;
            case 7:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$4(z);
                break;
            case 8:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$5(z);
                break;
            case 9:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$6(z);
                break;
            case 10:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$7(z);
                break;
            case 11:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$8(z);
                break;
            case 12:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$9(z);
                break;
            case 13:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$10(z);
                break;
            case 14:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$11(z);
                break;
            case 15:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$12(z);
                break;
            case 16:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$13(z);
                break;
            case 17:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$14(z);
                break;
            case 18:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$15(z);
                break;
            case 19:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$1(z);
                break;
            case 20:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$2(z);
                break;
            case 21:
                AppEventsManager.AnonymousClass1.onSuccess$lambda$3(z);
                break;
            case 22:
                ActivityLifecycleTracker.startTracking$lambda$0(z);
                break;
            case 23:
                InstrumentManager.start$lambda$0(z);
                break;
            case 24:
                InstrumentManager.start$lambda$1(z);
                break;
        }
    }

    @Override // com.facebook.internal.InstallReferrerUtil.Callback
    public void onReceiveReferrerUrl(String str) {
        AppEventsLoggerImpl.installReferrerCallback$lambda$0(str);
    }

    public static /* bridge */ /* synthetic */ Path m(Object obj) {
        return (Path) obj;
    }
}
