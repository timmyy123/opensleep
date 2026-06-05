package twitter4j;

import java.util.Map;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
class JSONImplFactory implements ObjectFactory {
    private static final long serialVersionUID = -1853541456182663343L;
    private final Configuration conf;

    public JSONImplFactory(Configuration configuration) {
        this.conf = configuration;
    }

    public static GeoLocation[][] coordinatesAsGeoLocationArray(JSONArray jSONArray) throws TwitterException {
        try {
            GeoLocation[][] geoLocationArr = new GeoLocation[jSONArray.length()][];
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                geoLocationArr[i] = new GeoLocation[jSONArray2.length()];
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                    geoLocationArr[i][i2] = new GeoLocation(jSONArray3.getDouble(1), jSONArray3.getDouble(0));
                }
            }
            return geoLocationArr;
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public static GeoLocation createGeoLocation(JSONObject jSONObject) throws TwitterException {
        try {
            if (jSONObject.isNull("coordinates")) {
                return null;
            }
            String string = jSONObject.getJSONObject("coordinates").getString("coordinates");
            String[] strArrSplit = string.substring(1, string.length() - 1).split(",");
            return new GeoLocation(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public static RateLimitStatus createRateLimitStatusFromResponseHeader(HttpResponse httpResponse) {
        return RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
    }

    @Override // twitter4j.ObjectFactory
    public UserList createAUserList(HttpResponse httpResponse) {
        return new UserListJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public AccountSettings createAccountSettings(HttpResponse httpResponse) {
        return new AccountSettingsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<Object> createCategoryList(HttpResponse httpResponse) {
        return CategoryJSONImpl.createCategoriesList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public DirectMessage createDirectMessage(HttpResponse httpResponse) {
        return new DirectMessageJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public DirectMessageList createDirectMessageList(HttpResponse httpResponse) {
        return DirectMessageJSONImpl.createDirectMessageList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public <T> ResponseList<T> createEmptyResponseList() {
        return new ResponseListImpl(0, null);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<Object> createFriendshipList(HttpResponse httpResponse) {
        return FriendshipJSONImpl.createFriendshipList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public IDs createIDs(HttpResponse httpResponse) {
        return new IDsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<Object> createLanguageList(HttpResponse httpResponse) {
        return LanguageJSONImpl.createLanguageList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<Location> createLocationList(HttpResponse httpResponse) {
        return LocationJSONImpl.createLocationList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public PagableResponseList<User> createPagableUserList(HttpResponse httpResponse) {
        return UserJSONImpl.createPagableUserList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public PagableResponseList<UserList> createPagableUserListList(HttpResponse httpResponse) {
        return UserListJSONImpl.createPagableUserListList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public Place createPlace(HttpResponse httpResponse) {
        return new PlaceJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<Place> createPlaceList(HttpResponse httpResponse) throws TwitterException {
        try {
            return PlaceJSONImpl.createPlaceList(httpResponse, this.conf);
        } catch (TwitterException e) {
            if (e.getStatusCode() == 404) {
                return new ResponseListImpl(0, null);
            }
            throw e;
        }
    }

    @Override // twitter4j.ObjectFactory
    public Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse httpResponse) {
        return RateLimitStatusJSONImpl.createRateLimitStatuses(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public Relationship createRelationship(HttpResponse httpResponse) {
        return new RelationshipJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public SavedSearch createSavedSearch(HttpResponse httpResponse) {
        return new SavedSearchJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse) {
        return SavedSearchJSONImpl.createSavedSearchList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public Status createStatus(HttpResponse httpResponse) {
        return new StatusJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<Status> createStatusList(HttpResponse httpResponse) {
        return StatusJSONImpl.createStatusList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public Trends createTrends(HttpResponse httpResponse) {
        return new TrendsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse httpResponse) {
        return new TwitterAPIConfigurationJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public User createUser(HttpResponse httpResponse) {
        return new UserJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<User> createUserList(HttpResponse httpResponse) {
        return UserJSONImpl.createUserList(httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<User> createUserListFromJSONArray(HttpResponse httpResponse) {
        return UserJSONImpl.createUserList(httpResponse.asJSONArray(), httpResponse, this.conf);
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<User> createUserListFromJSONArray_Users(HttpResponse httpResponse) throws TwitterException {
        try {
            return UserJSONImpl.createUserList(httpResponse.asJSONObject().getJSONArray("users"), httpResponse, this.conf);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    @Override // twitter4j.ObjectFactory
    public ResponseList<UserList> createUserListList(HttpResponse httpResponse) {
        return UserListJSONImpl.createUserListList(httpResponse, this.conf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JSONImplFactory)) {
            return false;
        }
        Configuration configuration = this.conf;
        Configuration configuration2 = ((JSONImplFactory) obj).conf;
        return configuration == null ? configuration2 == null : configuration.equals(configuration2);
    }

    public int hashCode() {
        Configuration configuration = this.conf;
        if (configuration != null) {
            return configuration.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "JSONImplFactory{conf=" + this.conf + '}';
    }
}
