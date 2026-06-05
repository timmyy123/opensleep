package twitter4j;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class TrendsJSONImpl extends TwitterResponseImpl implements Trends, Serializable {
    private static final long serialVersionUID = 2054973282133379835L;
    private Date asOf;
    private Location location;
    private Date trendAt;
    private Trend[] trends;

    public TrendsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        init(httpResponse.asString(), configuration.isJSONStoreEnabled());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asString());
        }
    }

    private static Location extractLocation(JSONObject jSONObject, boolean z) throws TwitterException {
        if (jSONObject.isNull("locations")) {
            return null;
        }
        try {
            ResponseList<Location> responseListCreateLocationList = LocationJSONImpl.createLocationList(jSONObject.getJSONArray("locations"), z);
            if (responseListCreateLocationList.size() != 0) {
                return responseListCreateLocationList.get(0);
            }
            return null;
        } catch (JSONException unused) {
            Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "locations can't be null");
            return null;
        }
    }

    private static Trend[] jsonArrayToTrendArray(JSONArray jSONArray, boolean z) {
        Trend[] trendArr = new Trend[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            trendArr[i] = new TrendJSONImpl(jSONArray.getJSONObject(i), z);
        }
        return trendArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(Trends trends) {
        return this.trendAt.compareTo(trends.getTrendAt());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trends)) {
            return false;
        }
        Trends trends = (Trends) obj;
        Date date = this.asOf;
        if (date == null ? trends.getAsOf() != null : !date.equals(trends.getAsOf())) {
            return false;
        }
        Date date2 = this.trendAt;
        if (date2 == null ? trends.getTrendAt() == null : date2.equals(trends.getTrendAt())) {
            return Arrays.equals(this.trends, trends.getTrends());
        }
        return false;
    }

    @Override // twitter4j.Trends
    public Date getAsOf() {
        return this.asOf;
    }

    @Override // twitter4j.Trends
    public Date getTrendAt() {
        return this.trendAt;
    }

    @Override // twitter4j.Trends
    public Trend[] getTrends() {
        return this.trends;
    }

    public int hashCode() {
        Date date = this.asOf;
        int iHashCode = (date != null ? date.hashCode() : 0) * 31;
        Date date2 = this.trendAt;
        int iHashCode2 = (iHashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        Trend[] trendArr = this.trends;
        return iHashCode2 + (trendArr != null ? Arrays.hashCode(trendArr) : 0);
    }

    public void init(String str, boolean z) throws TwitterException {
        JSONObject jSONObject;
        try {
            if (str.startsWith("[")) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    throw new TwitterException("No trends found on the specified woeid");
                }
                jSONObject = jSONArray.getJSONObject(0);
            } else {
                jSONObject = new JSONObject(str);
            }
            this.asOf = ParseUtil.parseTrendsDate(jSONObject.getString("as_of"));
            this.location = extractLocation(jSONObject, z);
            JSONArray jSONArray2 = jSONObject.getJSONArray("trends");
            this.trendAt = this.asOf;
            this.trends = jsonArrayToTrendArray(jSONArray2, z);
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage(), e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrendsJSONImpl{asOf=");
        sb.append(this.asOf);
        sb.append(", trendAt=");
        sb.append(this.trendAt);
        sb.append(", trends=");
        Trend[] trendArr = this.trends;
        return Fragment$$ExternalSyntheticOutline1.m(sb, trendArr == null ? null : Arrays.asList(trendArr), '}');
    }
}
