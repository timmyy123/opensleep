package twitter4j;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ltwitter4j/V2ConfigurationContainer;", "", "()V", "v2ConfigurationMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ltwitter4j/conf/Configuration;", "Ltwitter4j/V2Configuration;", "getV2ConfigurationMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "twitter4j-v2-support"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class V2ConfigurationContainer {
    public static final V2ConfigurationContainer INSTANCE = new V2ConfigurationContainer();
    private static final ConcurrentHashMap<Configuration, V2Configuration> v2ConfigurationMap = new ConcurrentHashMap<>();

    private V2ConfigurationContainer() {
    }

    public final ConcurrentHashMap<Configuration, V2Configuration> getV2ConfigurationMap() {
        return v2ConfigurationMap;
    }
}
