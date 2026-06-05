package twitter4j;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import java.io.Serializable;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
class RelationshipJSONImpl extends TwitterResponseImpl implements Relationship, Serializable {
    private static final long serialVersionUID = -2001484553401916448L;
    private final boolean sourceBlockingTarget;
    private final boolean sourceCanDm;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceFollowingTarget;
    private final boolean sourceMutingTarget;
    private final boolean sourceNotificationsEnabled;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private final long targetUserId;
    private final String targetUserScreenName;
    private boolean wantRetweets;

    public RelationshipJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("relationship");
            JSONObject jSONObject3 = jSONObject2.getJSONObject(ShareConstants.FEED_SOURCE_PARAM);
            JSONObject jSONObject4 = jSONObject2.getJSONObject("target");
            this.sourceUserId = ParseUtil.getLong("id", jSONObject3);
            this.targetUserId = ParseUtil.getLong("id", jSONObject4);
            this.sourceUserScreenName = ParseUtil.getUnescapedString("screen_name", jSONObject3);
            this.targetUserScreenName = ParseUtil.getUnescapedString("screen_name", jSONObject4);
            this.sourceBlockingTarget = ParseUtil.getBoolean("blocking", jSONObject3);
            this.sourceFollowingTarget = ParseUtil.getBoolean("following", jSONObject3);
            this.sourceFollowedByTarget = ParseUtil.getBoolean("followed_by", jSONObject3);
            this.sourceCanDm = ParseUtil.getBoolean("can_dm", jSONObject3);
            this.sourceMutingTarget = ParseUtil.getBoolean("muting", jSONObject3);
            this.sourceNotificationsEnabled = ParseUtil.getBoolean("notifications_enabled", jSONObject3);
            this.wantRetweets = ParseUtil.getBoolean("want_retweets", jSONObject3);
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + ":" + jSONObject.toString(), e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RelationshipJSONImpl relationshipJSONImpl = (RelationshipJSONImpl) obj;
        if (this.sourceBlockingTarget != relationshipJSONImpl.sourceBlockingTarget || this.sourceCanDm != relationshipJSONImpl.sourceCanDm || this.sourceFollowedByTarget != relationshipJSONImpl.sourceFollowedByTarget || this.sourceFollowingTarget != relationshipJSONImpl.sourceFollowingTarget || this.sourceMutingTarget != relationshipJSONImpl.sourceMutingTarget || this.sourceNotificationsEnabled != relationshipJSONImpl.sourceNotificationsEnabled || this.sourceUserId != relationshipJSONImpl.sourceUserId || this.targetUserId != relationshipJSONImpl.targetUserId || this.wantRetweets != relationshipJSONImpl.wantRetweets) {
            return false;
        }
        String str = this.sourceUserScreenName;
        String str2 = relationshipJSONImpl.sourceUserScreenName;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.targetUserScreenName;
        String str4 = relationshipJSONImpl.targetUserScreenName;
        return str3 == null ? str4 == null : str3.equals(str4);
    }

    public int hashCode() {
        long j = this.targetUserId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.targetUserScreenName;
        int iHashCode = (((((((((((((i + (str != null ? str.hashCode() : 0)) * 31) + (this.sourceBlockingTarget ? 1 : 0)) * 31) + (this.sourceNotificationsEnabled ? 1 : 0)) * 31) + (this.sourceFollowingTarget ? 1 : 0)) * 31) + (this.sourceFollowedByTarget ? 1 : 0)) * 31) + (this.sourceCanDm ? 1 : 0)) * 31) + (this.sourceMutingTarget ? 1 : 0)) * 31;
        long j2 = this.sourceUserId;
        int i2 = (iHashCode + ((int) ((j2 >>> 32) ^ j2))) * 31;
        String str2 = this.sourceUserScreenName;
        return ((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.wantRetweets ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RelationshipJSONImpl{targetUserId=");
        sb.append(this.targetUserId);
        sb.append(", targetUserScreenName='");
        sb.append(this.targetUserScreenName);
        sb.append("', sourceBlockingTarget=");
        sb.append(this.sourceBlockingTarget);
        sb.append(", sourceNotificationsEnabled=");
        sb.append(this.sourceNotificationsEnabled);
        sb.append(", sourceFollowingTarget=");
        sb.append(this.sourceFollowingTarget);
        sb.append(", sourceFollowedByTarget=");
        sb.append(this.sourceFollowedByTarget);
        sb.append(", sourceCanDm=");
        sb.append(this.sourceCanDm);
        sb.append(", sourceMutingTarget=");
        sb.append(this.sourceMutingTarget);
        sb.append(", sourceUserId=");
        sb.append(this.sourceUserId);
        sb.append(", sourceUserScreenName='");
        sb.append(this.sourceUserScreenName);
        sb.append("', wantRetweets=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.wantRetweets, '}');
    }

    public RelationshipJSONImpl(HttpResponse httpResponse, Configuration configuration) {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }
}
