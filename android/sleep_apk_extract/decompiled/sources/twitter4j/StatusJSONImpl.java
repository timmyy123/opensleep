package twitter4j;

import com.facebook.share.internal.ShareConstants;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class StatusJSONImpl extends TwitterResponseImpl implements Status, Serializable {
    private static final Logger logger = Logger.getLogger(StatusJSONImpl.class);
    private static final long serialVersionUID = -6461195536943679985L;
    private long[] contributorsIDs;
    private Date createdAt;
    private long currentUserRetweetId;
    private int displayTextRangeEnd;
    private int displayTextRangeStart;
    private int favoriteCount;
    private GeoLocation geoLocation;
    private HashtagEntity[] hashtagEntities;
    private long id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isPossiblySensitive;
    private boolean isRetweeted;
    private boolean isTruncated;
    private String lang;
    private MediaEntity[] mediaEntities;
    private Place place;
    private Status quotedStatus;
    private long quotedStatusId;
    private URLEntity quotedStatusPermalink;
    private long retweetCount;
    private Status retweetedStatus;
    private Scopes scopes;
    private String source;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private User user;
    private UserMentionEntity[] userMentionEntities;
    private String[] withheldInCountries;

    public StatusJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        this.displayTextRangeStart = -1;
        this.displayTextRangeEnd = -1;
        this.geoLocation = null;
        this.place = null;
        this.currentUserRetweetId = -1L;
        this.user = null;
        this.withheldInCountries = null;
        this.quotedStatusId = -1L;
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    private void collectEntities(JSONObject jSONObject) {
        if (!jSONObject.isNull("entities")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("entities");
            this.userMentionEntities = EntitiesParseUtil.getUserMentions(jSONObject2);
            this.urlEntities = EntitiesParseUtil.getUrls(jSONObject2);
            this.hashtagEntities = EntitiesParseUtil.getHashtags(jSONObject2);
            this.symbolEntities = EntitiesParseUtil.getSymbols(jSONObject2);
            this.mediaEntities = EntitiesParseUtil.getMedia(jSONObject2);
        }
        if (!jSONObject.isNull("quoted_status")) {
            this.quotedStatus = new StatusJSONImpl(jSONObject.getJSONObject("quoted_status"));
        }
        if (!jSONObject.isNull("quoted_status_id")) {
            this.quotedStatusId = ParseUtil.getLong("quoted_status_id", jSONObject);
        }
        if (jSONObject.isNull("quoted_status_permalink")) {
            return;
        }
        this.quotedStatusPermalink = new QuotedStatusPermalinkJSONImpl(jSONObject.getJSONObject("quoted_status_permalink"));
    }

    public static ResponseList<Status> createStatusList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                StatusJSONImpl statusJSONImpl = new StatusJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(statusJSONImpl, jSONObject);
                }
                responseListImpl.add(statusJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArrayAsJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.id = ParseUtil.getLong("id", jSONObject);
        this.source = ParseUtil.getUnescapedString(ShareConstants.FEED_SOURCE_PARAM, jSONObject);
        this.createdAt = ParseUtil.getDate("created_at", jSONObject);
        this.isTruncated = ParseUtil.getBoolean("truncated", jSONObject);
        this.inReplyToStatusId = ParseUtil.getLong("in_reply_to_status_id", jSONObject);
        this.inReplyToUserId = ParseUtil.getLong("in_reply_to_user_id", jSONObject);
        this.isFavorited = ParseUtil.getBoolean("favorited", jSONObject);
        this.isRetweeted = ParseUtil.getBoolean("retweeted", jSONObject);
        this.inReplyToScreenName = ParseUtil.getUnescapedString("in_reply_to_screen_name", jSONObject);
        this.retweetCount = ParseUtil.getLong("retweet_count", jSONObject);
        this.favoriteCount = ParseUtil.getInt("favorite_count", jSONObject);
        this.isPossiblySensitive = ParseUtil.getBoolean("possibly_sensitive", jSONObject);
        try {
            if (!jSONObject.isNull("user")) {
                this.user = new UserJSONImpl(jSONObject.getJSONObject("user"));
            }
            this.geoLocation = JSONImplFactory.createGeoLocation(jSONObject);
            if (!jSONObject.isNull("place")) {
                this.place = new PlaceJSONImpl(jSONObject.getJSONObject("place"));
            }
            if (!jSONObject.isNull("retweeted_status")) {
                this.retweetedStatus = new StatusJSONImpl(jSONObject.getJSONObject("retweeted_status"));
            }
            if (jSONObject.isNull("contributors")) {
                this.contributorsIDs = new long[0];
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("contributors");
                this.contributorsIDs = new long[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.contributorsIDs[i] = Long.parseLong(jSONArray.getString(i));
                }
            }
            collectEntities(jSONObject);
            mergeExtendedEntities(jSONObject);
            if (!jSONObject.isNull("quoted_status")) {
                this.quotedStatus = new StatusJSONImpl(jSONObject.getJSONObject("quoted_status"));
            }
            if (!jSONObject.isNull("quoted_status_id")) {
                this.quotedStatusId = ParseUtil.getLong("quoted_status_id", jSONObject);
            }
            if (!jSONObject.isNull("display_text_range")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("display_text_range");
                this.displayTextRangeStart = jSONArray2.getInt(0);
                this.displayTextRangeEnd = jSONArray2.getInt(1);
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
            MediaEntity[] mediaEntityArr = this.mediaEntities;
            if (mediaEntityArr == null) {
                mediaEntityArr = new MediaEntity[0];
            }
            this.mediaEntities = mediaEntityArr;
            if (!jSONObject.isNull("text")) {
                this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
            }
            if (!jSONObject.isNull("full_text")) {
                this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("full_text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
            }
            if (!jSONObject.isNull("extended_tweet")) {
                mergeExtendedTweet(jSONObject.getJSONObject("extended_tweet"));
            }
            if (!jSONObject.isNull("current_user_retweet")) {
                this.currentUserRetweetId = jSONObject.getJSONObject("current_user_retweet").getLong("id");
            }
            if (!jSONObject.isNull("lang")) {
                this.lang = ParseUtil.getUnescapedString("lang", jSONObject);
            }
            if (!jSONObject.isNull("scopes")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("scopes");
                if (!jSONObject2.isNull("place_ids")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("place_ids");
                    int length = jSONArray3.length();
                    String[] strArr = new String[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        strArr[i2] = jSONArray3.getString(i2);
                    }
                    this.scopes = new ScopesImpl(strArr);
                }
            }
            if (jSONObject.isNull("withheld_in_countries")) {
                return;
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray("withheld_in_countries");
            int length2 = jSONArray4.length();
            this.withheldInCountries = new String[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                this.withheldInCountries[i3] = jSONArray4.getString(i3);
            }
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    private void mergeExtendedEntities(JSONObject jSONObject) {
        if (jSONObject.isNull("extended_entities")) {
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("extended_entities");
        if (jSONObject2.isNull(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            return;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA);
        int length = jSONArray.length();
        this.mediaEntities = new MediaEntity[length];
        for (int i = 0; i < length; i++) {
            this.mediaEntities[i] = new MediaEntityJSONImpl(jSONArray.getJSONObject(i));
        }
    }

    private void mergeExtendedTweet(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("display_text_range");
            this.displayTextRangeStart = jSONArray.getInt(0);
            this.displayTextRangeEnd = jSONArray.getInt(1);
            collectEntities(jSONObject);
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
            MediaEntity[] mediaEntityArr = this.mediaEntities;
            if (mediaEntityArr == null) {
                mediaEntityArr = new MediaEntity[0];
            }
            this.mediaEntities = mediaEntityArr;
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("full_text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Status status) {
        long id = this.id - status.getId();
        if (id < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (id > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Status) && ((Status) obj).getId() == this.id;
    }

    @Override // twitter4j.Status
    public long getId() {
        return this.id;
    }

    public int hashCode() {
        return (int) this.id;
    }

    public String toString() {
        return "StatusJSONImpl{createdAt=" + this.createdAt + ", id=" + this.id + ", text='" + this.text + "', source='" + this.source + "', isTruncated=" + this.isTruncated + ", inReplyToStatusId=" + this.inReplyToStatusId + ", inReplyToUserId=" + this.inReplyToUserId + ", isFavorited=" + this.isFavorited + ", isRetweeted=" + this.isRetweeted + ", favoriteCount=" + this.favoriteCount + ", inReplyToScreenName='" + this.inReplyToScreenName + "', geoLocation=" + this.geoLocation + ", place=" + this.place + ", retweetCount=" + this.retweetCount + ", isPossiblySensitive=" + this.isPossiblySensitive + ", lang='" + this.lang + "', contributorsIDs=" + Arrays.toString(this.contributorsIDs) + ", retweetedStatus=" + this.retweetedStatus + ", userMentionEntities=" + Arrays.toString(this.userMentionEntities) + ", urlEntities=" + Arrays.toString(this.urlEntities) + ", hashtagEntities=" + Arrays.toString(this.hashtagEntities) + ", mediaEntities=" + Arrays.toString(this.mediaEntities) + ", symbolEntities=" + Arrays.toString(this.symbolEntities) + ", currentUserRetweetId=" + this.currentUserRetweetId + ", user=" + this.user + ", withHeldInCountries=" + Arrays.toString(this.withheldInCountries) + ", quotedStatusId=" + this.quotedStatusId + ", quotedStatus=" + this.quotedStatus + '}';
    }

    public StatusJSONImpl(JSONObject jSONObject) throws TwitterException {
        this.displayTextRangeStart = -1;
        this.displayTextRangeEnd = -1;
        this.geoLocation = null;
        this.place = null;
        this.currentUserRetweetId = -1L;
        this.user = null;
        this.withheldInCountries = null;
        this.quotedStatusId = -1L;
        init(jSONObject);
    }
}
