package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
final class TrendJSONImpl implements Trend, Serializable {
    private static final long serialVersionUID = -4353426776065521132L;
    private final String name;
    private String query;
    private int tweetVolume;
    private String url;

    public TrendJSONImpl(JSONObject jSONObject, boolean z) {
        this.url = null;
        this.query = null;
        this.tweetVolume = -1;
        this.name = ParseUtil.getRawString("name", jSONObject);
        this.url = ParseUtil.getRawString("url", jSONObject);
        this.query = ParseUtil.getRawString("query", jSONObject);
        this.tweetVolume = ParseUtil.getInt("tweet_volume", jSONObject);
        if (z) {
            TwitterObjectFactory.registerJSONObject(this, jSONObject);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trend)) {
            return false;
        }
        Trend trend = (Trend) obj;
        if (!this.name.equals(trend.getName())) {
            return false;
        }
        String str = this.query;
        if (str == null ? trend.getQuery() != null : !str.equals(trend.getQuery())) {
            return false;
        }
        String str2 = this.url;
        if (str2 == null ? trend.getURL() == null : str2.equals(trend.getURL())) {
            return this.tweetVolume == trend.getTweetVolume();
        }
        return false;
    }

    @Override // twitter4j.Trend
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.Trend
    public String getQuery() {
        return this.query;
    }

    @Override // twitter4j.Trend
    public int getTweetVolume() {
        return this.tweetVolume;
    }

    @Override // twitter4j.Trend
    public String getURL() {
        return this.url;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.query;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.tweetVolume;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrendJSONImpl{name='");
        sb.append(this.name);
        sb.append("', url='");
        sb.append(this.url);
        sb.append("', query='");
        sb.append(this.query);
        sb.append("', tweet_volume=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.tweetVolume, '}');
    }
}
