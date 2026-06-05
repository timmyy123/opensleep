package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.internal.ServerProtocol;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class QuotedStatusPermalinkJSONImpl extends EntityIndex implements URLEntity {
    private static final long serialVersionUID = -9029983811168784541L;
    private String displayURL;
    private String expandedURL;
    private String url;

    public QuotedStatusPermalinkJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            if (!jSONObject.isNull("url")) {
                this.url = jSONObject.getString("url");
            }
            if (jSONObject.isNull("expanded")) {
                this.expandedURL = this.url;
            } else {
                this.expandedURL = jSONObject.getString("expanded");
            }
            if (jSONObject.isNull(ServerProtocol.DIALOG_PARAM_DISPLAY)) {
                this.displayURL = this.url;
            } else {
                this.displayURL = jSONObject.getString(ServerProtocol.DIALOG_PARAM_DISPLAY);
            }
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && QuotedStatusPermalinkJSONImpl.class == obj.getClass()) {
            QuotedStatusPermalinkJSONImpl quotedStatusPermalinkJSONImpl = (QuotedStatusPermalinkJSONImpl) obj;
            String str = this.url;
            String str2 = quotedStatusPermalinkJSONImpl.url;
            if (str == null ? str2 != null : !str.equals(str2)) {
                return false;
            }
            String str3 = this.expandedURL;
            String str4 = quotedStatusPermalinkJSONImpl.expandedURL;
            if (str3 == null ? str4 != null : !str3.equals(str4)) {
                return false;
            }
            String str5 = this.displayURL;
            String str6 = quotedStatusPermalinkJSONImpl.displayURL;
            if (str5 != null) {
                return str5.equals(str6);
            }
            if (str6 == null) {
                return true;
            }
        }
        return false;
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
        StringBuilder sb = new StringBuilder("QuotedStatusPermalinkJSONImpl{url='");
        sb.append(this.url);
        sb.append("', expandedURL='");
        sb.append(this.expandedURL);
        sb.append("', displayURL='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.displayURL, "'}");
    }
}
