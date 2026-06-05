package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class URLEntityJSONImpl extends EntityIndex implements URLEntity {
    private static final long serialVersionUID = 7333552738058031524L;
    private String displayURL;
    private String expandedURL;
    private String url;

    public URLEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull("url")) {
                this.url = jSONObject.getString("url");
            }
            if (jSONObject.isNull("expanded_url")) {
                this.expandedURL = this.url;
            } else {
                this.expandedURL = jSONObject.getString("expanded_url");
            }
            if (jSONObject.isNull("display_url")) {
                this.displayURL = this.url;
            } else {
                this.displayURL = jSONObject.getString("display_url");
            }
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || URLEntityJSONImpl.class != obj.getClass()) {
            return false;
        }
        URLEntityJSONImpl uRLEntityJSONImpl = (URLEntityJSONImpl) obj;
        String str = this.displayURL;
        String str2 = uRLEntityJSONImpl.displayURL;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.expandedURL;
        String str4 = uRLEntityJSONImpl.expandedURL;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        String str5 = this.url;
        String str6 = uRLEntityJSONImpl.url;
        return str5 == null ? str6 == null : str5.equals(str6);
    }

    @Override // twitter4j.EntityIndex
    public int getEnd() {
        return super.getEnd();
    }

    @Override // twitter4j.EntityIndex
    public int getStart() {
        return super.getStart();
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expandedURL;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.displayURL;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("URLEntityJSONImpl{url='");
        sb.append(this.url);
        sb.append("', expandedURL='");
        sb.append(this.expandedURL);
        sb.append("', displayURL='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.displayURL, "'}");
    }
}
