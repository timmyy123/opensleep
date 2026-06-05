package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kaaes.spotify.webapi.android.SpotifyService;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class RateLimitStatusJSONImpl implements RateLimitStatus, Serializable {
    private static final long serialVersionUID = 7790337632915862445L;
    private int limit;
    private int remaining;
    private int resetTimeInSeconds;
    private int secondsUntilReset;

    private RateLimitStatusJSONImpl(int i, int i2, int i3) {
        this.limit = i;
        this.remaining = i2;
        this.resetTimeInSeconds = i3;
        this.secondsUntilReset = (int) (((((long) i3) * 1000) - System.currentTimeMillis()) / 1000);
    }

    public static RateLimitStatus createFromResponseHeader(HttpResponse httpResponse) {
        String responseHeader;
        if (httpResponse == null || (responseHeader = httpResponse.getResponseHeader("X-Rate-Limit-Limit")) == null) {
            return null;
        }
        int i = Integer.parseInt(responseHeader);
        String responseHeader2 = httpResponse.getResponseHeader("X-Rate-Limit-Remaining");
        if (responseHeader2 == null) {
            return null;
        }
        int i2 = Integer.parseInt(responseHeader2);
        String responseHeader3 = httpResponse.getResponseHeader("X-Rate-Limit-Reset");
        if (responseHeader3 != null) {
            return new RateLimitStatusJSONImpl(i, i2, (int) Long.parseLong(responseHeader3));
        }
        return null;
    }

    public static Map<String, RateLimitStatus> createRateLimitStatuses(JSONObject jSONObject) throws TwitterException {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("resources");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(itKeys.next());
                Iterator<String> itKeys2 = jSONObject3.keys();
                while (itKeys2.hasNext()) {
                    String next = itKeys2.next();
                    map.put(next, new RateLimitStatusJSONImpl(jSONObject3.getJSONObject(next)));
                }
            }
            return Collections.unmodifiableMap(map);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RateLimitStatusJSONImpl.class != obj.getClass()) {
            return false;
        }
        RateLimitStatusJSONImpl rateLimitStatusJSONImpl = (RateLimitStatusJSONImpl) obj;
        return this.limit == rateLimitStatusJSONImpl.limit && this.remaining == rateLimitStatusJSONImpl.remaining && this.resetTimeInSeconds == rateLimitStatusJSONImpl.resetTimeInSeconds && this.secondsUntilReset == rateLimitStatusJSONImpl.secondsUntilReset;
    }

    @Override // twitter4j.RateLimitStatus
    public int getSecondsUntilReset() {
        return this.secondsUntilReset;
    }

    public int hashCode() {
        return (((((this.remaining * 31) + this.limit) * 31) + this.resetTimeInSeconds) * 31) + this.secondsUntilReset;
    }

    public void init(JSONObject jSONObject) {
        this.limit = ParseUtil.getInt(SpotifyService.LIMIT, jSONObject);
        this.remaining = ParseUtil.getInt("remaining", jSONObject);
        int i = ParseUtil.getInt("reset", jSONObject);
        this.resetTimeInSeconds = i;
        this.secondsUntilReset = (int) (((((long) i) * 1000) - System.currentTimeMillis()) / 1000);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RateLimitStatusJSONImpl{remaining=");
        sb.append(this.remaining);
        sb.append(", limit=");
        sb.append(this.limit);
        sb.append(", resetTimeInSeconds=");
        sb.append(this.resetTimeInSeconds);
        sb.append(", secondsUntilReset=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.secondsUntilReset, '}');
    }

    public RateLimitStatusJSONImpl(JSONObject jSONObject) {
        init(jSONObject);
    }

    public static Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        Map<String, RateLimitStatus> mapCreateRateLimitStatuses = createRateLimitStatuses(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(mapCreateRateLimitStatuses, jSONObjectAsJSONObject);
        }
        return mapCreateRateLimitStatuses;
    }
}
