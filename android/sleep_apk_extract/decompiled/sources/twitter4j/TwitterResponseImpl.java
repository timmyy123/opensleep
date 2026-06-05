package twitter4j;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
abstract class TwitterResponseImpl implements Serializable {
    private static final long serialVersionUID = 7422171124869859808L;
    private final transient int accessLevel;
    private transient RateLimitStatus rateLimitStatus;

    public TwitterResponseImpl(HttpResponse httpResponse) {
        this.rateLimitStatus = null;
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
        this.accessLevel = ParseUtil.toAccessLevel(httpResponse);
    }

    public TwitterResponseImpl() {
        this.rateLimitStatus = null;
        this.accessLevel = 0;
    }
}
