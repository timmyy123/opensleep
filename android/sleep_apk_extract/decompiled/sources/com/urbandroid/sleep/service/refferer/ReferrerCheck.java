package com.urbandroid.sleep.service.refferer;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.work.ListenableFutureKt$$ExternalSyntheticLambda0;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.eu.LocationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/refferer/ReferrerCheck;", "", "<init>", "()V", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "checkReferrer", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReferrerCheck {
    private InstallReferrerClient referrerClient;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkReferrer$lambda$0(final ReferrerCheck referrerCheck, final Context context, final Settings settings, String str) {
        try {
            InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(context).build();
            installReferrerClientBuild.getClass();
            referrerCheck.referrerClient = installReferrerClientBuild;
            if (installReferrerClientBuild == null) {
                Intrinsics.throwUninitializedPropertyAccessException("referrerClient");
                installReferrerClientBuild = null;
            }
            installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: com.urbandroid.sleep.service.refferer.ReferrerCheck$checkReferrer$1$1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    Logger.logInfo("Referrer: disconnect");
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int responseCode) {
                    if (responseCode != 0) {
                        if (responseCode == 1) {
                            Logger.logInfo("Referrer: SERVICE_UNAVAILABLE");
                            settings.setPlayStoreReferrer("<SERVICE_UNAVAILABLE>");
                            return;
                        } else {
                            if (responseCode != 2) {
                                return;
                            }
                            Logger.logInfo("Referrer: FEATURE_NOT_SUPPORTED");
                            settings.setPlayStoreReferrer("<FEATURE_NOT_SUPPORTED>");
                            return;
                        }
                    }
                    try {
                        InstallReferrerClient installReferrerClient = this.this$0.referrerClient;
                        if (installReferrerClient == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("referrerClient");
                            installReferrerClient = null;
                        }
                        ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                        installReferrer.getClass();
                        String installReferrer2 = installReferrer.getInstallReferrer();
                        installReferrer2.getClass();
                        long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                        long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                        Logger.logInfo("Referrer: URL " + installReferrer2);
                        settings.setPlayStoreReferrer(installReferrer2);
                        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventReferrer(context, installReferrer2, referrerClickTimestampSeconds, installBeginTimestampSeconds);
                        Logger.logInfo("Referrer: install time " + installBeginTimestampSeconds);
                        settings.setPlayStoreReferrerInstallTime(installBeginTimestampSeconds);
                    } catch (Exception e) {
                        Logger.logSevere("Referrer: error", e);
                    }
                }
            });
        } catch (Exception e) {
            Logger.logSevere("Referrer: error", e);
        }
    }

    public final void checkReferrer(Context context) {
        context.getClass();
        Settings settings = new Settings(context);
        Logger.logInfo("Referrer: '" + settings.getPlayStoreReferrer() + "'");
        if (settings.hasPlayStoreReferrer()) {
            return;
        }
        Logger.logInfo("Referrer: get info");
        LocationUtils.updateCountryAsyncCallback(context, new ListenableFutureKt$$ExternalSyntheticLambda0(this, context, settings, 8));
    }
}
