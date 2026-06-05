package twitter4j;

import kotlin.Metadata;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltwitter4j/V2ResponseFactory;", "", "<init>", "()V", "Ltwitter4j/HttpResponse;", "res", "Ltwitter4j/conf/Configuration;", "conf", "Ltwitter4j/CreateTweetResponse;", "createCreateTweetResponse", "(Ltwitter4j/HttpResponse;Ltwitter4j/conf/Configuration;)Ltwitter4j/CreateTweetResponse;", "twitter4j-v2-support"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class V2ResponseFactory {
    public final CreateTweetResponse createCreateTweetResponse(HttpResponse res, Configuration conf) throws TwitterException {
        res.getClass();
        conf.getClass();
        try {
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            return new CreateTweetResponse(res, conf.isJSONStoreEnabled());
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }
}
