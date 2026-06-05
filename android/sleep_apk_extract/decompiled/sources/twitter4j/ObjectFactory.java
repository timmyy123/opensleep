package twitter4j;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
interface ObjectFactory extends Serializable {
    UserList createAUserList(HttpResponse httpResponse);

    AccountSettings createAccountSettings(HttpResponse httpResponse);

    ResponseList<Object> createCategoryList(HttpResponse httpResponse);

    DirectMessage createDirectMessage(HttpResponse httpResponse);

    DirectMessageList createDirectMessageList(HttpResponse httpResponse);

    <T> ResponseList<T> createEmptyResponseList();

    ResponseList<Object> createFriendshipList(HttpResponse httpResponse);

    IDs createIDs(HttpResponse httpResponse);

    ResponseList<Object> createLanguageList(HttpResponse httpResponse);

    ResponseList<Location> createLocationList(HttpResponse httpResponse);

    PagableResponseList<User> createPagableUserList(HttpResponse httpResponse);

    PagableResponseList<UserList> createPagableUserListList(HttpResponse httpResponse);

    Place createPlace(HttpResponse httpResponse);

    ResponseList<Place> createPlaceList(HttpResponse httpResponse);

    Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse httpResponse);

    Relationship createRelationship(HttpResponse httpResponse);

    SavedSearch createSavedSearch(HttpResponse httpResponse);

    ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse);

    Status createStatus(HttpResponse httpResponse);

    ResponseList<Status> createStatusList(HttpResponse httpResponse);

    Trends createTrends(HttpResponse httpResponse);

    TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse httpResponse);

    User createUser(HttpResponse httpResponse);

    ResponseList<User> createUserList(HttpResponse httpResponse);

    ResponseList<User> createUserListFromJSONArray(HttpResponse httpResponse);

    ResponseList<User> createUserListFromJSONArray_Users(HttpResponse httpResponse);

    ResponseList<UserList> createUserListList(HttpResponse httpResponse);
}
