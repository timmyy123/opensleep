package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption;
import com.airbnb.lottie.configurations.reducemotion.SystemReducedMotionOption;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.utils.LottieTrace;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class L {
    public static boolean DBG = false;
    private static LottieNetworkCacheProvider cacheProvider = null;
    private static boolean disablePathInterpolatorCache = false;
    private static LottieNetworkFetcher fetcher = null;
    private static ThreadLocal<LottieTrace> lottieTrace = null;
    private static volatile NetworkCache networkCache = null;
    private static boolean networkCacheEnabled = true;
    private static volatile NetworkFetcher networkFetcher = null;
    private static boolean traceEnabled = false;
    private static AsyncUpdates defaultAsyncUpdates = AsyncUpdates.AUTOMATIC;
    private static ReducedMotionOption reducedMotionOption = new SystemReducedMotionOption();

    public static void beginSection(String str) {
        if (traceEnabled) {
            getTrace().beginSection(str);
        }
    }

    public static float endSection(String str) {
        if (traceEnabled) {
            return getTrace().endSection(str);
        }
        return 0.0f;
    }

    public static AsyncUpdates getDefaultAsyncUpdates() {
        return defaultAsyncUpdates;
    }

    public static boolean getDisablePathInterpolatorCache() {
        return disablePathInterpolatorCache;
    }

    public static ReducedMotionOption getReducedMotionOption() {
        return reducedMotionOption;
    }

    private static LottieTrace getTrace() {
        LottieTrace lottieTrace2 = lottieTrace.get();
        if (lottieTrace2 != null) {
            return lottieTrace2;
        }
        LottieTrace lottieTrace3 = new LottieTrace();
        lottieTrace.set(lottieTrace3);
        return lottieTrace3;
    }

    public static boolean isTraceEnabled() {
        return traceEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ File lambda$networkCache$0(Context context) {
        return new File(context.getCacheDir(), "lottie_network_cache");
    }

    public static NetworkCache networkCache(Context context) {
        NetworkCache networkCache2;
        if (!networkCacheEnabled) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        NetworkCache networkCache3 = networkCache;
        if (networkCache3 != null) {
            return networkCache3;
        }
        synchronized (NetworkCache.class) {
            try {
                networkCache2 = networkCache;
                if (networkCache2 == null) {
                    LottieNetworkCacheProvider l$$ExternalSyntheticLambda0 = cacheProvider;
                    if (l$$ExternalSyntheticLambda0 == null) {
                        l$$ExternalSyntheticLambda0 = new L$$ExternalSyntheticLambda0(applicationContext);
                    }
                    networkCache2 = new NetworkCache(l$$ExternalSyntheticLambda0);
                    networkCache = networkCache2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return networkCache2;
    }

    public static NetworkFetcher networkFetcher(Context context) {
        NetworkFetcher networkFetcher2;
        NetworkFetcher networkFetcher3 = networkFetcher;
        if (networkFetcher3 != null) {
            return networkFetcher3;
        }
        synchronized (NetworkFetcher.class) {
            try {
                networkFetcher2 = networkFetcher;
                if (networkFetcher2 == null) {
                    NetworkCache networkCache2 = networkCache(context);
                    LottieNetworkFetcher defaultLottieNetworkFetcher = fetcher;
                    if (defaultLottieNetworkFetcher == null) {
                        defaultLottieNetworkFetcher = new DefaultLottieNetworkFetcher();
                    }
                    networkFetcher2 = new NetworkFetcher(networkCache2, defaultLottieNetworkFetcher);
                    networkFetcher = networkFetcher2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return networkFetcher2;
    }
}
