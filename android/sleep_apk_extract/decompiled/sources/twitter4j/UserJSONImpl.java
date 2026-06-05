package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.internal.AnalyticsEvents;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class UserJSONImpl extends TwitterResponseImpl implements User, Serializable {
    private static final long serialVersionUID = -5448266606847617015L;
    private Date createdAt;
    private String description;
    private URLEntity[] descriptionURLEntities;
    private String email;
    private int favouritesCount;
    private int followersCount;
    private int friendsCount;
    private long id;
    private boolean isContributorsEnabled;
    private boolean isDefaultProfile;
    private boolean isDefaultProfileImage;
    private boolean isFollowRequestSent;
    private boolean isGeoEnabled;
    private boolean isProtected;
    private boolean isVerified;
    private String lang;
    private int listedCount;
    private String location;
    private String name;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private boolean profileBackgroundTiled;
    private String profileBannerImageUrl;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private boolean profileUseBackgroundImage;
    private String screenName;
    private boolean showAllInlineMedia;
    private Status status;
    private int statusesCount;
    private String timeZone;
    private boolean translator;
    private String url;
    private URLEntity urlEntity;
    private int utcOffset;
    private String[] withheldInCountries;

    public UserJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    public static PagableResponseList<User> createPagableUserList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("users");
            int length = jSONArray.length();
            PagableResponseListImpl pagableResponseListImpl = new PagableResponseListImpl(length, jSONObjectAsJSONObject, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userJSONImpl, jSONObject);
                }
                pagableResponseListImpl.add(userJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(pagableResponseListImpl, jSONObjectAsJSONObject);
            }
            return pagableResponseListImpl;
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public static ResponseList<User> createUserList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                responseListImpl.add(userJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    private static URLEntity[] getURLEntitiesFromJSON(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull("entities")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("entities");
            if (!jSONObject2.isNull(str)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
                if (!jSONObject3.isNull("urls")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("urls");
                    int length = jSONArray.length();
                    URLEntity[] uRLEntityArr = new URLEntity[length];
                    for (int i = 0; i < length; i++) {
                        uRLEntityArr[i] = new URLEntityJSONImpl(jSONArray.getJSONObject(i));
                    }
                    return uRLEntityArr;
                }
            }
        }
        return new URLEntity[0];
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.id = ParseUtil.getLong("id", jSONObject);
            this.name = ParseUtil.getRawString("name", jSONObject);
            this.email = ParseUtil.getRawString(AuthenticationTokenClaims.JSON_KEY_EMAIL, jSONObject);
            this.screenName = ParseUtil.getRawString("screen_name", jSONObject);
            this.location = ParseUtil.getRawString("location", jSONObject);
            this.descriptionURLEntities = getURLEntitiesFromJSON(jSONObject, "description");
            URLEntity[] uRLEntitiesFromJSON = getURLEntitiesFromJSON(jSONObject, "url");
            if (uRLEntitiesFromJSON.length > 0) {
                this.urlEntity = uRLEntitiesFromJSON[0];
            }
            String rawString = ParseUtil.getRawString("description", jSONObject);
            this.description = rawString;
            if (rawString != null) {
                this.description = HTMLEntity.unescapeAndSlideEntityIncdices(rawString, null, this.descriptionURLEntities, null, null);
            }
            this.isContributorsEnabled = ParseUtil.getBoolean("contributors_enabled", jSONObject);
            this.profileImageUrl = ParseUtil.getRawString("profile_image_url", jSONObject);
            this.profileImageUrlHttps = ParseUtil.getRawString("profile_image_url_https", jSONObject);
            this.isDefaultProfileImage = ParseUtil.getBoolean("default_profile_image", jSONObject);
            this.url = ParseUtil.getRawString("url", jSONObject);
            this.isProtected = ParseUtil.getBoolean("protected", jSONObject);
            this.isGeoEnabled = ParseUtil.getBoolean("geo_enabled", jSONObject);
            this.isVerified = ParseUtil.getBoolean("verified", jSONObject);
            this.translator = ParseUtil.getBoolean("is_translator", jSONObject);
            this.followersCount = ParseUtil.getInt("followers_count", jSONObject);
            this.profileBackgroundColor = ParseUtil.getRawString("profile_background_color", jSONObject);
            this.profileTextColor = ParseUtil.getRawString("profile_text_color", jSONObject);
            this.profileLinkColor = ParseUtil.getRawString("profile_link_color", jSONObject);
            this.profileSidebarFillColor = ParseUtil.getRawString("profile_sidebar_fill_color", jSONObject);
            this.profileSidebarBorderColor = ParseUtil.getRawString("profile_sidebar_border_color", jSONObject);
            this.profileUseBackgroundImage = ParseUtil.getBoolean("profile_use_background_image", jSONObject);
            this.isDefaultProfile = ParseUtil.getBoolean("default_profile", jSONObject);
            this.showAllInlineMedia = ParseUtil.getBoolean("show_all_inline_media", jSONObject);
            this.friendsCount = ParseUtil.getInt("friends_count", jSONObject);
            this.createdAt = ParseUtil.getDate("created_at", jSONObject, "EEE MMM dd HH:mm:ss z yyyy");
            this.favouritesCount = ParseUtil.getInt("favourites_count", jSONObject);
            this.utcOffset = ParseUtil.getInt("utc_offset", jSONObject);
            this.timeZone = ParseUtil.getRawString("time_zone", jSONObject);
            this.profileBackgroundImageUrl = ParseUtil.getRawString("profile_background_image_url", jSONObject);
            this.profileBackgroundImageUrlHttps = ParseUtil.getRawString("profile_background_image_url_https", jSONObject);
            this.profileBannerImageUrl = ParseUtil.getRawString("profile_banner_url", jSONObject);
            this.profileBackgroundTiled = ParseUtil.getBoolean("profile_background_tile", jSONObject);
            this.lang = ParseUtil.getRawString("lang", jSONObject);
            this.statusesCount = ParseUtil.getInt("statuses_count", jSONObject);
            this.listedCount = ParseUtil.getInt("listed_count", jSONObject);
            this.isFollowRequestSent = ParseUtil.getBoolean("follow_request_sent", jSONObject);
            if (!jSONObject.isNull(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                this.status = new StatusJSONImpl(jSONObject.getJSONObject(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
            }
            if (jSONObject.isNull("withheld_in_countries")) {
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("withheld_in_countries");
            int length = jSONArray.length();
            this.withheldInCountries = new String[length];
            for (int i = 0; i < length; i++) {
                this.withheldInCountries[i] = jSONArray.getString(i);
            }
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + ":" + jSONObject.toString(), e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(User user) {
        return (int) (this.id - user.getId());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof User) && ((User) obj).getId() == this.id;
    }

    @Override // twitter4j.User
    public long getId() {
        return this.id;
    }

    @Override // twitter4j.User
    public String getScreenName() {
        return this.screenName;
    }

    public int hashCode() {
        return (int) this.id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserJSONImpl{id=");
        sb.append(this.id);
        sb.append(", name='");
        sb.append(this.name);
        sb.append("', email='");
        sb.append(this.email);
        sb.append("', screenName='");
        sb.append(this.screenName);
        sb.append("', location='");
        sb.append(this.location);
        sb.append("', description='");
        sb.append(this.description);
        sb.append("', isContributorsEnabled=");
        sb.append(this.isContributorsEnabled);
        sb.append(", profileImageUrl='");
        sb.append(this.profileImageUrl);
        sb.append("', profileImageUrlHttps='");
        sb.append(this.profileImageUrlHttps);
        sb.append("', isDefaultProfileImage=");
        sb.append(this.isDefaultProfileImage);
        sb.append(", url='");
        sb.append(this.url);
        sb.append("', isProtected=");
        sb.append(this.isProtected);
        sb.append(", followersCount=");
        sb.append(this.followersCount);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", profileBackgroundColor='");
        sb.append(this.profileBackgroundColor);
        sb.append("', profileTextColor='");
        sb.append(this.profileTextColor);
        sb.append("', profileLinkColor='");
        sb.append(this.profileLinkColor);
        sb.append("', profileSidebarFillColor='");
        sb.append(this.profileSidebarFillColor);
        sb.append("', profileSidebarBorderColor='");
        sb.append(this.profileSidebarBorderColor);
        sb.append("', profileUseBackgroundImage=");
        sb.append(this.profileUseBackgroundImage);
        sb.append(", isDefaultProfile=");
        sb.append(this.isDefaultProfile);
        sb.append(", showAllInlineMedia=");
        sb.append(this.showAllInlineMedia);
        sb.append(", friendsCount=");
        sb.append(this.friendsCount);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", favouritesCount=");
        sb.append(this.favouritesCount);
        sb.append(", utcOffset=");
        sb.append(this.utcOffset);
        sb.append(", timeZone='");
        sb.append(this.timeZone);
        sb.append("', profileBackgroundImageUrl='");
        sb.append(this.profileBackgroundImageUrl);
        sb.append("', profileBackgroundImageUrlHttps='");
        sb.append(this.profileBackgroundImageUrlHttps);
        sb.append("', profileBackgroundTiled=");
        sb.append(this.profileBackgroundTiled);
        sb.append(", lang='");
        sb.append(this.lang);
        sb.append("', statusesCount=");
        sb.append(this.statusesCount);
        sb.append(", isGeoEnabled=");
        sb.append(this.isGeoEnabled);
        sb.append(", isVerified=");
        sb.append(this.isVerified);
        sb.append(", translator=");
        sb.append(this.translator);
        sb.append(", listedCount=");
        sb.append(this.listedCount);
        sb.append(", isFollowRequestSent=");
        sb.append(this.isFollowRequestSent);
        sb.append(", withheldInCountries=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, Arrays.toString(this.withheldInCountries), '}');
    }

    public UserJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    public static ResponseList<User> createUserList(HttpResponse httpResponse, Configuration configuration) {
        return createUserList(httpResponse.asJSONArray(), httpResponse, configuration);
    }
}
