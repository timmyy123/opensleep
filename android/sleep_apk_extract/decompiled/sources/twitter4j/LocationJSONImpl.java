package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class LocationJSONImpl implements Location {
    private static final long serialVersionUID = -1312752311160422264L;
    private final String countryCode;
    private final String countryName;
    private final String name;
    private final int placeCode;
    private final String placeName;
    private final String url;
    private final int woeid;

    public LocationJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            this.woeid = ParseUtil.getInt("woeid", jSONObject);
            this.countryName = ParseUtil.getUnescapedString("country", jSONObject);
            this.countryCode = ParseUtil.getRawString("countryCode", jSONObject);
            if (jSONObject.isNull("placeType")) {
                this.placeName = null;
                this.placeCode = -1;
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("placeType");
                this.placeName = ParseUtil.getUnescapedString("name", jSONObject2);
                this.placeCode = ParseUtil.getInt("code", jSONObject2);
            }
            this.name = ParseUtil.getUnescapedString("name", jSONObject);
            this.url = ParseUtil.getUnescapedString("url", jSONObject);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            throw null;
        }
    }

    public static ResponseList<Location> createLocationList(JSONArray jSONArray, boolean z) throws TwitterException {
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, null);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                LocationJSONImpl locationJSONImpl = new LocationJSONImpl(jSONObject);
                responseListImpl.add(locationJSONImpl);
                if (z) {
                    TwitterObjectFactory.registerJSONObject(locationJSONImpl, jSONObject);
                }
            }
            if (z) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocationJSONImpl) && this.woeid == ((LocationJSONImpl) obj).woeid;
    }

    public int hashCode() {
        return this.woeid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocationJSONImpl{woeid=");
        sb.append(this.woeid);
        sb.append(", countryName='");
        sb.append(this.countryName);
        sb.append("', countryCode='");
        sb.append(this.countryCode);
        sb.append("', placeName='");
        sb.append(this.placeName);
        sb.append("', placeCode='");
        sb.append(this.placeCode);
        sb.append("', name='");
        sb.append(this.name);
        sb.append("', url='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.url, "'}");
    }

    public static ResponseList<Location> createLocationList(HttpResponse httpResponse, Configuration configuration) {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        return createLocationList(httpResponse.asJSONArray(), configuration.isJSONStoreEnabled());
    }
}
