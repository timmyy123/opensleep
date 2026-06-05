package io.reactivex.rxjava3.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda2;
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Scheduler;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new FacebookSdk$$ExternalSyntheticLambda2(1));

    public static final class MainHolder {
        static final Scheduler DEFAULT = AndroidSchedulers.internalFrom(Looper.getMainLooper(), true);
    }

    public static Scheduler from(Looper looper, boolean z) {
        if (looper != null) {
            return internalFrom(looper, z);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("looper == null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Scheduler internalFrom(Looper looper, boolean z) {
        return new HandlerScheduler(new Handler(looper), z);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }

    public static Scheduler from(Looper looper) {
        return from(looper, true);
    }
}
