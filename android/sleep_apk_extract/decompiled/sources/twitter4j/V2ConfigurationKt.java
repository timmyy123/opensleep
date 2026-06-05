package twitter4j;

import kotlin.Metadata;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"v2Configuration", "Ltwitter4j/V2Configuration;", "Ltwitter4j/conf/Configuration;", "getV2Configuration", "(Ltwitter4j/conf/Configuration;)Ltwitter4j/V2Configuration;", "twitter4j-v2-support"}, k = 2, mv = {1, 7, 1}, xi = 48)
public abstract class V2ConfigurationKt {
    public static final V2Configuration getV2Configuration(Configuration configuration) {
        configuration.getClass();
        V2ConfigurationContainer v2ConfigurationContainer = V2ConfigurationContainer.INSTANCE;
        if (!v2ConfigurationContainer.getV2ConfigurationMap().containsKey(configuration)) {
            V2Configuration v2Configuration = new V2Configuration(null, 1, null);
            v2ConfigurationContainer.getV2ConfigurationMap().putIfAbsent(configuration, v2Configuration);
            return v2Configuration;
        }
        V2Configuration v2Configuration2 = v2ConfigurationContainer.getV2ConfigurationMap().get(configuration);
        v2Configuration2.getClass();
        v2Configuration2.getClass();
        return v2Configuration2;
    }
}
