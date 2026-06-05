package androidx.appsearch.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class JetpackAppSearchEnvironment implements AppSearchEnvironment {
    @Override // androidx.appsearch.app.AppSearchEnvironment
    public ExecutorService createCachedThreadPoolExecutor() {
        return Executors.newCachedThreadPool();
    }
}
