package twitter4j;

import java.util.EventObject;

/* JADX INFO: loaded from: classes5.dex */
public final class RateLimitStatusEvent extends EventObject {
    private static final long serialVersionUID = 3749366911109722414L;
    private final boolean isAccountRateLimitStatus;
    private final RateLimitStatus rateLimitStatus;

    public RateLimitStatusEvent(Object obj, RateLimitStatus rateLimitStatus, boolean z) {
        super(obj);
        this.rateLimitStatus = rateLimitStatus;
        this.isAccountRateLimitStatus = z;
    }
}
