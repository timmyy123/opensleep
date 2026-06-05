package androidx.appsearch.app;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppSearchEnvironmentFactory {
    private static volatile AppSearchEnvironment sAppSearchEnvironment;

    public static AppSearchEnvironment getEnvironmentInstance() {
        AppSearchEnvironment jetpackAppSearchEnvironment;
        AppSearchEnvironment appSearchEnvironment = sAppSearchEnvironment;
        if (appSearchEnvironment != null) {
            return appSearchEnvironment;
        }
        synchronized (AppSearchEnvironmentFactory.class) {
            try {
                jetpackAppSearchEnvironment = sAppSearchEnvironment;
                if (jetpackAppSearchEnvironment == null) {
                    jetpackAppSearchEnvironment = new JetpackAppSearchEnvironment();
                    sAppSearchEnvironment = jetpackAppSearchEnvironment;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jetpackAppSearchEnvironment;
    }
}
