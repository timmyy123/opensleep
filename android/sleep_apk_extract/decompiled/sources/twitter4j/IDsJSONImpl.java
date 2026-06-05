package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Arrays;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class IDsJSONImpl extends TwitterResponseImpl implements IDs {
    private static final long serialVersionUID = 6999637496007165672L;
    private long[] ids;
    private long nextCursor;
    private long previousCursor;

    public IDsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws Throwable {
        super(httpResponse);
        this.previousCursor = -1L;
        this.nextCursor = -1L;
        String strAsString = httpResponse.asString();
        init(strAsString);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, strAsString);
        }
    }

    private void init(String str) throws TwitterException {
        try {
            int i = 0;
            if (!str.startsWith("{")) {
                JSONArray jSONArray = new JSONArray(str);
                this.ids = new long[jSONArray.length()];
                while (i < jSONArray.length()) {
                    try {
                        this.ids[i] = Long.parseLong(jSONArray.getString(i));
                        i++;
                    } catch (NumberFormatException e) {
                        throw new TwitterException("Twitter API returned malformed response: " + jSONArray, e);
                    }
                }
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray2 = jSONObject.getJSONArray("ids");
            this.ids = new long[jSONArray2.length()];
            while (i < jSONArray2.length()) {
                try {
                    this.ids[i] = Long.parseLong(jSONArray2.getString(i));
                    i++;
                } catch (NumberFormatException e2) {
                    throw new TwitterException("Twitter API returned malformed response: " + jSONObject, e2);
                }
            }
            this.previousCursor = ParseUtil.getLong("previous_cursor", jSONObject);
            this.nextCursor = ParseUtil.getLong("next_cursor", jSONObject);
            return;
        } catch (JSONException e3) {
            Types$$ExternalSyntheticBUOutline0.m(e3);
        }
        Types$$ExternalSyntheticBUOutline0.m(e3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IDs) && Arrays.equals(this.ids, ((IDs) obj).getIDs());
    }

    @Override // twitter4j.IDs
    public long[] getIDs() {
        return this.ids;
    }

    public int hashCode() {
        long[] jArr = this.ids;
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IDsJSONImpl{ids=");
        sb.append(Arrays.toString(this.ids));
        sb.append(", previousCursor=");
        sb.append(this.previousCursor);
        sb.append(", nextCursor=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.nextCursor, '}');
    }
}
