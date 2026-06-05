package twitter4j;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"v2", "Ltwitter4j/TwitterV2;", "Ltwitter4j/Twitter;", "getV2", "(Ltwitter4j/Twitter;)Ltwitter4j/TwitterV2;", "twitter4j-v2-support"}, k = 2, mv = {1, 7, 1}, xi = 48)
public abstract class TwitterV2ExKt {
    public static final TwitterV2 getV2(Twitter twitter) {
        twitter.getClass();
        return new TwitterV2Impl(twitter);
    }
}
