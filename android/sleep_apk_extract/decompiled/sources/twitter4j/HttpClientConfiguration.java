package twitter4j;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClientConfiguration {
    int getHttpConnectionTimeout();

    String getHttpProxyHost();

    String getHttpProxyPassword();

    int getHttpProxyPort();

    String getHttpProxyUser();

    int getHttpReadTimeout();

    int getHttpRetryCount();

    int getHttpRetryIntervalSeconds();

    boolean isGZIPEnabled();

    boolean isHttpProxySocks();

    boolean isPrettyDebugEnabled();
}
