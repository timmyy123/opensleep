package androidx.appsearch.app;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public interface AppSearchEnvironment {
    ExecutorService createCachedThreadPoolExecutor();
}
