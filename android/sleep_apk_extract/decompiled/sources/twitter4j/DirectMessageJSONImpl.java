package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.share.internal.ShareConstants;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class DirectMessageJSONImpl extends TwitterResponseImpl implements DirectMessage, Serializable {
    private static final long serialVersionUID = 7092906238192790921L;
    private Date createdAt;
    private HashtagEntity[] hashtagEntities;
    private long id;
    private MediaEntity[] mediaEntities;
    private long recipientId;
    private long senderId;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private UserMentionEntity[] userMentionEntities;

    public DirectMessageJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject = httpResponse.asJSONObject().getJSONObject("event");
            init(jSONObject);
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
                TwitterObjectFactory.registerJSONObject(this, jSONObject);
            }
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            throw null;
        }
    }

    public static DirectMessageList createDirectMessageList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONArray jSONArrayAsJSONArray;
        DirectMessageListImpl directMessageListImpl;
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            try {
                JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
                jSONArrayAsJSONArray = jSONObjectAsJSONObject.getJSONArray("events");
                directMessageListImpl = new DirectMessageListImpl(jSONArrayAsJSONArray.length(), jSONObjectAsJSONObject, httpResponse);
            } catch (TwitterException e) {
                if (e.getCause() == null || !(e.getCause() instanceof JSONException)) {
                    throw e;
                }
                jSONArrayAsJSONArray = httpResponse.asJSONArray();
                directMessageListImpl = new DirectMessageListImpl(jSONArrayAsJSONArray.length(), httpResponse);
            }
            for (int i = 0; i < jSONArrayAsJSONArray.length(); i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                DirectMessageJSONImpl directMessageJSONImpl = new DirectMessageJSONImpl(jSONObject);
                directMessageListImpl.add(directMessageJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(directMessageJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(directMessageListImpl, jSONArrayAsJSONArray);
            }
            return directMessageListImpl;
        } catch (JSONException e2) {
            Types$$ExternalSyntheticBUOutline0.m(e2);
            return null;
        }
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.id = ParseUtil.getLong("id", jSONObject);
            if (jSONObject.isNull("created_timestamp")) {
                this.createdAt = ParseUtil.getDate("created_at", jSONObject);
                this.senderId = ParseUtil.getLong("sender_id", jSONObject);
                this.recipientId = ParseUtil.getLong("recipient_id", jSONObject);
            } else {
                this.createdAt = new Date(jSONObject.getLong("created_timestamp"));
                JSONObject jSONObject2 = jSONObject.getJSONObject("message_create");
                this.recipientId = ParseUtil.getLong("recipient_id", jSONObject2.getJSONObject("target"));
                this.senderId = ParseUtil.getLong("sender_id", jSONObject2);
                jSONObject = jSONObject2.getJSONObject("message_data");
            }
            if (!jSONObject.isNull("entities")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("entities");
                this.userMentionEntities = EntitiesParseUtil.getUserMentions(jSONObject3);
                this.urlEntities = EntitiesParseUtil.getUrls(jSONObject3);
                this.hashtagEntities = EntitiesParseUtil.getHashtags(jSONObject3);
                this.symbolEntities = EntitiesParseUtil.getSymbols(jSONObject3);
            }
            UserMentionEntity[] userMentionEntityArr = this.userMentionEntities;
            if (userMentionEntityArr == null) {
                userMentionEntityArr = new UserMentionEntity[0];
            }
            this.userMentionEntities = userMentionEntityArr;
            URLEntity[] uRLEntityArr = this.urlEntities;
            if (uRLEntityArr == null) {
                uRLEntityArr = new URLEntity[0];
            }
            this.urlEntities = uRLEntityArr;
            HashtagEntity[] hashtagEntityArr = this.hashtagEntities;
            if (hashtagEntityArr == null) {
                hashtagEntityArr = new HashtagEntity[0];
            }
            this.hashtagEntities = hashtagEntityArr;
            SymbolEntity[] symbolEntityArr = this.symbolEntities;
            if (symbolEntityArr == null) {
                symbolEntityArr = new SymbolEntity[0];
            }
            this.symbolEntities = symbolEntityArr;
            if (!jSONObject.isNull("attachment")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("attachment");
                if (!jSONObject4.isNull(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
                    this.mediaEntities = new MediaEntity[]{new MediaEntityJSONImpl(jSONObject4.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_MEDIA))};
                }
            }
            MediaEntity[] mediaEntityArr = this.mediaEntities;
            if (mediaEntityArr == null) {
                mediaEntityArr = new MediaEntity[0];
            }
            this.mediaEntities = mediaEntityArr;
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DirectMessageJSONImpl.class != obj.getClass()) {
            return false;
        }
        DirectMessageJSONImpl directMessageJSONImpl = (DirectMessageJSONImpl) obj;
        if (this.id != directMessageJSONImpl.id || this.senderId != directMessageJSONImpl.senderId || this.recipientId != directMessageJSONImpl.recipientId) {
            return false;
        }
        String str = this.text;
        String str2 = directMessageJSONImpl.text;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        Date date = this.createdAt;
        Date date2 = directMessageJSONImpl.createdAt;
        if (date == null ? date2 != null : !date.equals(date2)) {
            return false;
        }
        if (Arrays.equals(this.userMentionEntities, directMessageJSONImpl.userMentionEntities) && Arrays.equals(this.urlEntities, directMessageJSONImpl.urlEntities) && Arrays.equals(this.hashtagEntities, directMessageJSONImpl.hashtagEntities) && Arrays.equals(this.mediaEntities, directMessageJSONImpl.mediaEntities)) {
            return Arrays.equals(this.symbolEntities, directMessageJSONImpl.symbolEntities);
        }
        return false;
    }

    @Override // twitter4j.DirectMessage
    public long getRecipientId() {
        return this.recipientId;
    }

    @Override // twitter4j.DirectMessage
    public long getSenderId() {
        return this.senderId;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.text;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j2 = this.senderId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.recipientId;
        int i3 = (i2 + ((int) ((j3 >>> 32) ^ j3))) * 31;
        Date date = this.createdAt;
        return ((((((((((i3 + (date != null ? date.hashCode() : 0)) * 31) + Arrays.hashCode(this.userMentionEntities)) * 31) + Arrays.hashCode(this.urlEntities)) * 31) + Arrays.hashCode(this.hashtagEntities)) * 31) + Arrays.hashCode(this.mediaEntities)) * 31) + Arrays.hashCode(this.symbolEntities);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DirectMessageJSONImpl{id=");
        sb.append(this.id);
        sb.append(", text='");
        sb.append(this.text);
        sb.append("', senderId=");
        sb.append(this.senderId);
        sb.append(", recipientId=");
        sb.append(this.recipientId);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", userMentionEntities=");
        sb.append(Arrays.toString(this.userMentionEntities));
        sb.append(", urlEntities=");
        sb.append(Arrays.toString(this.urlEntities));
        sb.append(", hashtagEntities=");
        sb.append(Arrays.toString(this.hashtagEntities));
        sb.append(", mediaEntities=");
        sb.append(Arrays.toString(this.mediaEntities));
        sb.append(", symbolEntities=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, Arrays.toString(this.symbolEntities), '}');
    }

    public DirectMessageJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }
}
