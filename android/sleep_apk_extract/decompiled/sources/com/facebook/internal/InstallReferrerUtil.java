package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/InstallReferrerUtil;", "", "()V", "IS_REFERRER_UPDATED", "", "REFERRER_FETCH_TIMEOUT", "", "isUpdated", "", "()Z", "tryConnectReferrerInfo", "", "callback", "Lcom/facebook/internal/InstallReferrerUtil$Callback;", "latch", "Ljava/util/concurrent/CountDownLatch;", "tryUpdateReferrerInfo", "tryUpdateReferrerInfoBlocking", "updateReferrer", "Callback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InstallReferrerUtil {
    public static final InstallReferrerUtil INSTANCE = new InstallReferrerUtil();
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";
    private static final long REFERRER_FETCH_TIMEOUT = 5;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/InstallReferrerUtil$Callback;", "", "onReceiveReferrerUrl", "", "s", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Callback {
        void onReceiveReferrerUrl(String s);
    }

    private InstallReferrerUtil() {
    }

    private final boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }

    private final void tryConnectReferrerInfo(final Callback callback, final CountDownLatch latch) {
        final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
        try {
            installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    CountDownLatch countDownLatch = latch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }

                /* JADX WARN: Finally extract failed */
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int responseCode) {
                    CountDownLatch countDownLatch;
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        try {
                            if (responseCode == 0) {
                                try {
                                    ReferrerDetails installReferrer = installReferrerClientBuild.getInstallReferrer();
                                    installReferrer.getClass();
                                    String installReferrer2 = installReferrer.getInstallReferrer();
                                    if (installReferrer2 != null && (StringsKt.contains$default(installReferrer2, "fb") || StringsKt.contains$default(installReferrer2, AccessToken.DEFAULT_GRAPH_DOMAIN))) {
                                        callback.onReceiveReferrerUrl(installReferrer2);
                                    }
                                    InstallReferrerUtil.INSTANCE.updateReferrer();
                                } catch (RemoteException unused) {
                                    countDownLatch = latch;
                                    if (countDownLatch == null) {
                                        return;
                                    }
                                }
                            } else if (responseCode == 2) {
                                InstallReferrerUtil.INSTANCE.updateReferrer();
                            }
                            try {
                                installReferrerClientBuild.endConnection();
                            } catch (Exception unused2) {
                            }
                            countDownLatch = latch;
                            if (countDownLatch == null) {
                                return;
                            }
                            countDownLatch.countDown();
                        } catch (Throwable th) {
                            CountDownLatch countDownLatch2 = latch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            });
        } catch (Exception unused) {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    public static /* synthetic */ void tryConnectReferrerInfo$default(InstallReferrerUtil installReferrerUtil, Callback callback, CountDownLatch countDownLatch, int i, Object obj) {
        if ((i & 2) != 0) {
            countDownLatch = null;
        }
        installReferrerUtil.tryConnectReferrerInfo(callback, countDownLatch);
    }

    public static final void tryUpdateReferrerInfo(Callback callback) {
        callback.getClass();
        InstallReferrerUtil installReferrerUtil = INSTANCE;
        if (installReferrerUtil.isUpdated()) {
            return;
        }
        tryConnectReferrerInfo$default(installReferrerUtil, callback, null, 2, null);
    }

    public static final void tryUpdateReferrerInfoBlocking(Callback callback) {
        callback.getClass();
        InstallReferrerUtil installReferrerUtil = INSTANCE;
        if (installReferrerUtil.isUpdated()) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        installReferrerUtil.tryConnectReferrerInfo(callback, countDownLatch);
        try {
            countDownLatch.await(REFERRER_FETCH_TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }
}
