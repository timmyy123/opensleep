package twitter4j;

/* JADX INFO: loaded from: classes5.dex */
final class StdOutLoggerFactory extends LoggerFactory {
    private static final Logger SINGLETON = new StdOutLogger();

    @Override // twitter4j.LoggerFactory
    public Logger getLogger(Class<?> cls) {
        return SINGLETON;
    }
}
