package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
class UserMentionEntityJSONImpl extends EntityIndex implements UserMentionEntity {
    private static final long serialVersionUID = 6060510953676673013L;
    private long id;
    private String name;
    private String screenName;

    public UserMentionEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull("name")) {
                this.name = jSONObject.getString("name");
            }
            if (!jSONObject.isNull("screen_name")) {
                this.screenName = jSONObject.getString("screen_name");
            }
            this.id = ParseUtil.getLong("id", jSONObject);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserMentionEntityJSONImpl userMentionEntityJSONImpl = (UserMentionEntityJSONImpl) obj;
        if (this.id != userMentionEntityJSONImpl.id) {
            return false;
        }
        String str = this.name;
        String str2 = userMentionEntityJSONImpl.name;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.screenName;
        String str4 = userMentionEntityJSONImpl.screenName;
        return str3 == null ? str4 == null : str3.equals(str4);
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
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.screenName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.id;
        return iHashCode2 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserMentionEntityJSONImpl{name='");
        sb.append(this.name);
        sb.append("', screenName='");
        sb.append(this.screenName);
        sb.append("', id=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.id, '}');
    }
}
