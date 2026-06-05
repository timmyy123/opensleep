package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.HelpResources;
import twitter4j.api.ListsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.SpamReportingResource;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.TimelinesResources;
import twitter4j.api.TrendsResources;
import twitter4j.api.TweetsResources;
import twitter4j.api.UsersResources;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
class TwitterImpl extends TwitterBaseImpl implements Twitter {
    private static final long serialVersionUID = 9170943084096085770L;
    private final String CHUNKED_APPEND;
    private final String CHUNKED_FINALIZE;
    private final String CHUNKED_INIT;
    private final String CHUNKED_STATUS;
    private final int CHUNK_SIZE;
    private final HttpParameter[] IMPLICIT_PARAMS;
    private final String IMPLICIT_PARAMS_STR;
    private final HttpParameter INCLUDE_MY_RETWEET;
    private final int MAX_VIDEO_SIZE;
    private final int MB;
    private long myId;
    private static final Logger logger = Logger.getLogger(TwitterBaseImpl.class);
    private static final ConcurrentHashMap<Configuration, HttpParameter[]> implicitParamsMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Configuration, String> implicitParamsStrMap = new ConcurrentHashMap<>();

    public TwitterImpl(Configuration configuration, Authorization authorization) {
        super(configuration, authorization);
        this.CHUNKED_INIT = "INIT";
        this.CHUNKED_APPEND = "APPEND";
        this.CHUNKED_FINALIZE = "FINALIZE";
        this.CHUNKED_STATUS = "STATUS";
        this.MB = 1048576;
        this.MAX_VIDEO_SIZE = 536870912;
        this.CHUNK_SIZE = 2097152;
        this.myId = -1L;
        this.INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", configuration.isIncludeMyRetweetEnabled());
        ConcurrentHashMap<Configuration, HttpParameter[]> concurrentHashMap = implicitParamsMap;
        if (concurrentHashMap.containsKey(configuration)) {
            this.IMPLICIT_PARAMS = concurrentHashMap.get(configuration);
            this.IMPLICIT_PARAMS_STR = implicitParamsStrMap.get(configuration);
            return;
        }
        String strConcat = configuration.isIncludeEntitiesEnabled() ? "include_entities=true" : "";
        boolean z = configuration.getContributingTo() != -1;
        if (z) {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m("".equals(strConcat) ? strConcat : strConcat.concat("&"), "contributingto=");
            sbM.append(configuration.getContributingTo());
            strConcat = sbM.toString();
        }
        if (configuration.isTweetModeExtended()) {
            strConcat = ("".equals(strConcat) ? strConcat : strConcat.concat("&")).concat("tweet_mode=extended");
        }
        ArrayList arrayList = new ArrayList(3);
        if (configuration.isIncludeEntitiesEnabled()) {
            arrayList.add(new HttpParameter("include_entities", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        }
        if (z) {
            arrayList.add(new HttpParameter("contributingto", configuration.getContributingTo()));
        }
        if (configuration.isTrimUserEnabled()) {
            arrayList.add(new HttpParameter("trim_user", AppEventsConstants.EVENT_PARAM_VALUE_YES));
        }
        if (configuration.isIncludeExtAltTextEnabled()) {
            arrayList.add(new HttpParameter("include_ext_alt_text", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        }
        if (configuration.isTweetModeExtended()) {
            arrayList.add(new HttpParameter("tweet_mode", "extended"));
        }
        HttpParameter[] httpParameterArr = (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
        implicitParamsStrMap.putIfAbsent(configuration, strConcat);
        concurrentHashMap.putIfAbsent(configuration, httpParameterArr);
        this.IMPLICIT_PARAMS = httpParameterArr;
        this.IMPLICIT_PARAMS_STR = strConcat;
    }

    private void addParameterToList(List<HttpParameter> list, String str, String str2) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void checkFileValidity(File file) throws TwitterException {
        if (!file.exists()) {
            throw new TwitterException(new FileNotFoundException(file + " is not found."));
        }
        if (file.isFile()) {
            return;
        }
        throw new TwitterException(new IOException(file + " is not a file."));
    }

    private static JSONObject createMessageCreateJsonObject(long j, String str, long j2) {
        String str2 = j2 == -1 ? null : ShareConstants.WEB_DIALOG_PARAM_MEDIA;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("recipient_id", j);
        jSONObject.put("target", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("text", str);
        if (str2 != null && j2 != -1) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", str2);
            if (str2.equals(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("id", j2);
                jSONObject4.put(ShareConstants.WEB_DIALOG_PARAM_MEDIA, jSONObject5);
            }
            jSONObject3.put("attachment", jSONObject4);
        }
        jSONObject.put("message_data", jSONObject3);
        return jSONObject;
    }

    private HttpResponse get(String str) {
        ensureAuthorizationEnabled();
        if (this.IMPLICIT_PARAMS_STR.length() > 0) {
            if (str.contains("?")) {
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, "&");
                sbM.append(this.IMPLICIT_PARAMS_STR);
                str = sbM.toString();
            } else {
                StringBuilder sbM2 = Fragment$$ExternalSyntheticOutline1.m(str, "?");
                sbM2.append(this.IMPLICIT_PARAMS_STR);
                str = sbM2.toString();
            }
        }
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, null, this.auth, this);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponse = this.http.get(str, null, this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponse));
            return httpResponse;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private boolean isOk(HttpResponse httpResponse) {
        return httpResponse != null && httpResponse.getStatusCode() < 300;
    }

    private HttpParameter[] mergeImplicitParams(HttpParameter... httpParameterArr) {
        return mergeParameters(httpParameterArr, this.IMPLICIT_PARAMS);
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter httpParameter) {
        if (httpParameterArr == null || httpParameter == null) {
            return (httpParameterArr == null && httpParameter == null) ? new HttpParameter[0] : httpParameterArr != null ? httpParameterArr : new HttpParameter[]{httpParameter};
        }
        int length = httpParameterArr.length;
        HttpParameter[] httpParameterArr2 = new HttpParameter[length + 1];
        System.arraycopy(httpParameterArr, 0, httpParameterArr2, 0, httpParameterArr.length);
        httpParameterArr2[length] = httpParameter;
        return httpParameterArr2;
    }

    private HttpResponse post(String str, JSONObject jSONObject) {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, new HttpParameter[]{new HttpParameter(jSONObject)}, this.auth, this);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponsePost = this.http.post(str, new HttpParameter[]{new HttpParameter(jSONObject)}, this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponsePost));
            return httpResponsePost;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private DirectMessageList removeDMsNotSentByMe(DirectMessageList directMessageList) {
        if (this.myId == -1) {
            this.myId = verifyCredentials().getId();
        }
        for (int size = directMessageList.size() - 1; size >= 0; size--) {
            if (directMessageList.get(size).getSenderId() != this.myId) {
                directMessageList.remove(size);
            }
        }
        return directMessageList;
    }

    private DirectMessageList removeDMsNotSentToMe(DirectMessageList directMessageList) {
        if (this.myId == -1) {
            this.myId = verifyCredentials().getId();
        }
        for (int size = directMessageList.size() - 1; size >= 0; size--) {
            if (directMessageList.get(size).getRecipientId() != this.myId) {
                directMessageList.remove(size);
            }
        }
        return directMessageList;
    }

    private UserList updateUserList(String str, boolean z, String str2, HttpParameter... httpParameterArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, httpParameterArr);
        if (str != null) {
            arrayList.add(new HttpParameter("name", str));
        }
        arrayList.add(new HttpParameter("mode", z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/update.json"), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    private void uploadMediaChunkedAppend(String str, InputStream inputStream, int i, long j) {
        post(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter("command", "APPEND"), new HttpParameter(SDKConstants.PARAM_A2U_MEDIA_ID, j), new HttpParameter("segment_index", i), new HttpParameter(ShareConstants.WEB_DIALOG_PARAM_MEDIA, str, inputStream));
    }

    private UploadedMedia uploadMediaChunkedFinalize(long j) throws TwitterException {
        int progressPercent;
        UploadedMedia uploadedMediaUploadMediaChunkedFinalize0 = uploadMediaChunkedFinalize0(j);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < 20) {
            if (i2 == i3) {
                i++;
            }
            String processingState = uploadedMediaUploadMediaChunkedFinalize0.getProcessingState();
            if (processingState.equals("failed")) {
                throw new TwitterException("Failed to finalize the chuncked upload.");
            }
            if (processingState.equals("pending") || processingState.equals("in_progress")) {
                progressPercent = uploadedMediaUploadMediaChunkedFinalize0.getProgressPercent();
                int iMax = Math.max(uploadedMediaUploadMediaChunkedFinalize0.getProcessingCheckAfterSecs(), 1);
                logger.debug("Chunked finalize, wait for:" + iMax + " sec");
                try {
                    Thread.sleep(iMax * 1000);
                } catch (InterruptedException e) {
                    throw new TwitterException("Failed to finalize the chuncked upload.", e);
                }
            } else {
                progressPercent = i3;
            }
            if (processingState.equals(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED)) {
                return uploadedMediaUploadMediaChunkedFinalize0;
            }
            uploadedMediaUploadMediaChunkedFinalize0 = uploadMediaChunkedStatus(j);
            i2 = i3;
            i3 = progressPercent;
        }
        throw new TwitterException(Fragment$$ExternalSyntheticOutline1.m(i, "Failed to finalize the chuncked upload, progress has stopped, tried ", "1 times."));
    }

    private UploadedMedia uploadMediaChunkedFinalize0(long j) {
        JSONObject jSONObjectAsJSONObject = post(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter("command", "FINALIZE"), new HttpParameter(SDKConstants.PARAM_A2U_MEDIA_ID, j)).asJSONObject();
        logger.debug("Finalize response:" + jSONObjectAsJSONObject);
        return new UploadedMedia(jSONObjectAsJSONObject);
    }

    private UploadedMedia uploadMediaChunkedInit(long j) {
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter("command", "INIT"), new HttpParameter("media_type", "video/mp4"), new HttpParameter("media_category", "tweet_video"), new HttpParameter("total_bytes", j)).asJSONObject());
    }

    private UploadedMedia uploadMediaChunkedStatus(long j) {
        JSONObject jSONObjectAsJSONObject = get(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter("command", "STATUS"), new HttpParameter(SDKConstants.PARAM_A2U_MEDIA_ID, j)).asJSONObject();
        logger.debug("Status response:" + jSONObjectAsJSONObject);
        return new UploadedMedia(jSONObjectAsJSONObject);
    }

    public User createBlock(String str) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "blocks/create.json"), new HttpParameter("screen_name", str)));
    }

    public Status createFavorite(long j) {
        return this.factory.createStatus(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/create.json?id=", j)));
    }

    public User createFriendship(String str, boolean z) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/create.json"), new HttpParameter("screen_name", str), new HttpParameter("follow", z)));
    }

    public User createMute(String str) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "mutes/users/create.json"), new HttpParameter("screen_name", str)));
    }

    public SavedSearch createSavedSearch(String str) {
        return this.factory.createSavedSearch(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "saved_searches/create.json"), new HttpParameter("query", str)));
    }

    public UserList createUserList(String str, boolean z, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpParameter("name", str));
        arrayList.add(new HttpParameter("mode", z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/create.json"), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public UserList createUserListMember(long j, String str, long j2) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create.json"), new HttpParameter("user_id", j2), new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public UserList createUserListMembers(long j, String str, long... jArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create_all.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    public UserList createUserListSubscription(long j, String str) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers/create.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public User destroyBlock(String str) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "blocks/destroy.json"), new HttpParameter("screen_name", str)));
    }

    public DirectMessage destroyDirectMessage(long j) {
        ensureAuthorizationEnabled();
        this.http.delete(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "direct_messages/events/destroy.json?id=", j), null, this.auth, null);
        return new DirectMessage() { // from class: twitter4j.TwitterImpl.1
            @Override // twitter4j.DirectMessage
            public long getRecipientId() {
                throw new UnsupportedOperationException("Since Twitter4J 4.0.7, you are no longer able to access the return value from destroyDirectMessage(id) due to the API changes.");
            }

            @Override // twitter4j.DirectMessage
            public long getSenderId() {
                throw new UnsupportedOperationException("Since Twitter4J 4.0.7, you are no longer able to access the return value from destroyDirectMessage(id) due to the API changes.");
            }
        };
    }

    public Status destroyFavorite(long j) {
        return this.factory.createStatus(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/destroy.json?id=", j)));
    }

    public User destroyFriendship(String str) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/destroy.json"), new HttpParameter("screen_name", str)));
    }

    public User destroyMute(String str) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "mutes/users/destroy.json"), new HttpParameter("screen_name", str)));
    }

    public SavedSearch destroySavedSearch(long j) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "saved_searches/destroy/", j);
        sb.append(".json");
        return objectFactory.createSavedSearch(post(sb.toString()));
    }

    public Status destroyStatus(long j) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "statuses/destroy/", j);
        sb.append(".json");
        return objectFactory.createStatus(post(sb.toString()));
    }

    public UserList destroyUserList(long j, String str) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/destroy.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public UserList destroyUserListMember(long j, String str, long j2) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/destroy.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("user_id", j2)));
    }

    public UserList destroyUserListMembers(String str, String str2, String[] strArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/destroy_all.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public UserList destroyUserListSubscription(long j, String str) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers/destroy.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public DirectMessagesResources directMessages() {
        return this;
    }

    public FavoritesResources favorites() {
        return this;
    }

    public FriendsFollowersResources friendsFollowers() {
        return this;
    }

    public TwitterAPIConfiguration getAPIConfiguration() {
        return this.factory.createTwitterAPIConfiguration(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "help/configuration.json")));
    }

    public AccountSettings getAccountSettings() {
        return this.factory.createAccountSettings(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/settings.json")));
    }

    public ResponseList<Location> getAvailableTrends() {
        return this.factory.createLocationList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "trends/available.json")));
    }

    public IDs getBlocksIDs() {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "blocks/ids.json")));
    }

    public PagableResponseList<User> getBlocksList(long j) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "blocks/list.json?cursor=", j)));
    }

    public ResponseList<Location> getClosestTrends(GeoLocation geoLocation) {
        return this.factory.createLocationList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "trends/closest.json"), new HttpParameter("lat", geoLocation.getLatitude()), new HttpParameter("long", geoLocation.getLongitude())));
    }

    public ResponseList<User> getContributees(String str) {
        return this.factory.createUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/contributees.json"), new HttpParameter("screen_name", str)));
    }

    public ResponseList<User> getContributors(String str) {
        return this.factory.createUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/contributors.json"), new HttpParameter("screen_name", str)));
    }

    public InputStream getDMImageAsStream(String str) {
        return get(str).asStream();
    }

    public DirectMessageList getDirectMessages(int i, String str) {
        return this.factory.createDirectMessageList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "direct_messages/events/list.json"), new HttpParameter("count", i), new HttpParameter("cursor", str)));
    }

    public ResponseList<Status> getFavorites(long j, Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/list.json"), mergeParameters(new HttpParameter[]{new HttpParameter("user_id", j)}, paging.asPostParameterArray())));
    }

    public IDs getFollowersIDs(String str, long j, int i) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "followers/ids.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public PagableResponseList<User> getFollowersList(String str, long j, int i, boolean z, boolean z2) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "followers/list.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i), new HttpParameter("skip_status", z), new HttpParameter("include_user_entities", z2)));
    }

    public IDs getFriendsIDs(String str, long j, int i) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friends/ids.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public PagableResponseList<User> getFriendsList(String str, long j, int i, boolean z, boolean z2) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friends/list.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i), new HttpParameter("skip_status", z), new HttpParameter("include_user_entities", z2)));
    }

    public Place getGeoDetails(String str) {
        return this.factory.createPlace(get(this.conf.getRestBaseURL() + "geo/id/" + str + ".json"));
    }

    public ResponseList<Status> getHomeTimeline(Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/home_timeline.json"), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{this.INCLUDE_MY_RETWEET})));
    }

    public IDs getIncomingFriendships(long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/incoming.json?cursor=", j)));
    }

    public ResponseList<Object> getLanguages() {
        return this.factory.createLanguageList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "help/languages.json")));
    }

    public ResponseList<User> getMemberSuggestions(String str) {
        try {
            return this.factory.createUserListFromJSONArray(get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(str, OAuth.ENCODING) + "/members.json"));
        } catch (UnsupportedEncodingException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public ResponseList<Status> getMentionsTimeline(Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/mentions_timeline.json"), paging.asPostParameterArray()));
    }

    public IDs getMutesIDs(long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "mutes/users/ids.json?cursor=", j)));
    }

    public PagableResponseList<User> getMutesList(long j) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "mutes/users/list.json?cursor=", j)));
    }

    public IDs getNoRetweetsFriendships() {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/no_retweets/ids.json")));
    }

    public OEmbed getOEmbed(OEmbedRequest oEmbedRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/oembed.json");
        throw null;
    }

    public IDs getOutgoingFriendships(long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/outgoing.json?cursor=", j)));
    }

    public Trends getPlaceTrends(int i) {
        return this.factory.createTrends(get(this.conf.getRestBaseURL() + "trends/place.json?id=" + i));
    }

    public String getPrivacyPolicy() throws TwitterException {
        try {
            return get(this.conf.getRestBaseURL() + "help/privacy.json").asJSONObject().getString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public Map<String, RateLimitStatus> getRateLimitStatus(String... strArr) {
        return this.factory.createRateLimitStatuses(get(this.conf.getRestBaseURL() + "application/rate_limit_status.json?resources=" + StringUtil.join(strArr)));
    }

    public IDs getRetweeterIds(long j, int i, long j2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "statuses/retweeters/ids.json?id=", j);
        zzba$$ExternalSyntheticOutline0.m(sb, "&cursor=", j2, "&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public ResponseList<Status> getRetweets(long j) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "statuses/retweets/", j);
        sb.append(".json?count=100");
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public ResponseList<Status> getRetweetsOfMe(Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/retweets_of_me.json"), paging.asPostParameterArray()));
    }

    public ResponseList<SavedSearch> getSavedSearches() {
        return this.factory.createSavedSearchList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "saved_searches/list.json")));
    }

    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) {
        return removeDMsNotSentByMe(getDirectMessages(paging.getCount()));
    }

    public ResponseList<Place> getSimilarPlaces(GeoLocation geoLocation, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new HttpParameter("lat", geoLocation.getLatitude()));
        arrayList.add(new HttpParameter("long", geoLocation.getLongitude()));
        arrayList.add(new HttpParameter("name", str));
        if (str2 != null) {
            arrayList.add(new HttpParameter("contained_within", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("attribute:street_address", str3));
        }
        return this.factory.createPlaceList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "geo/similar_places.json"), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public ResponseList<Object> getSuggestedUserCategories() {
        return this.factory.createCategoryList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/suggestions.json")));
    }

    public String getTermsOfService() throws TwitterException {
        try {
            return get(this.conf.getRestBaseURL() + "help/tos.json").asJSONObject().getString("tos");
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2, boolean z) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, int i, long j, boolean z) {
        return this.factory.createPagableUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/memberships.json"), new HttpParameter("screen_name", str), new HttpParameter("count", i), new HttpParameter("cursor", j), new HttpParameter("filter_to_owned_lists", z)));
    }

    public ResponseList<Status> getUserListStatuses(long j, String str, Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/statuses.json"), mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str)})));
    }

    public PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2, boolean z) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<UserList> getUserListSubscriptions(String str, int i, long j) {
        return this.factory.createPagableUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscriptions.json"), new HttpParameter("screen_name", str), new HttpParameter("count", i), new HttpParameter("cursor", j)));
    }

    public ResponseList<UserList> getUserLists(String str, boolean z) {
        return this.factory.createUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/list.json"), new HttpParameter("screen_name", str), new HttpParameter("reverse", z)));
    }

    public PagableResponseList<UserList> getUserListsOwnerships(String str, int i, long j) {
        return this.factory.createPagableUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/ownerships.json"), new HttpParameter("screen_name", str), new HttpParameter("count", i), new HttpParameter("cursor", j)));
    }

    public ResponseList<User> getUserSuggestions(String str) {
        try {
            return this.factory.createUserListFromJSONArray_Users(get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(str, OAuth.ENCODING) + ".json"));
        } catch (UnsupportedEncodingException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public ResponseList<Status> getUserTimeline(String str, Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/user_timeline.json"), mergeParameters(new HttpParameter[]{new HttpParameter("screen_name", str), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public HelpResources help() {
        return this;
    }

    public ListsResources list() {
        return this;
    }

    public ResponseList<Status> lookup(long... jArr) {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/lookup.json?id=" + StringUtil.join(jArr)));
    }

    public ResponseList<Object> lookupFriendships(long... jArr) {
        return this.factory.createFriendshipList(get(this.conf.getRestBaseURL() + "friendships/lookup.json?user_id=" + StringUtil.join(jArr)));
    }

    public ResponseList<User> lookupUsers(long... jArr) {
        return this.factory.createUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/lookup.json"), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    public PlacesGeoResources placesGeo() {
        return this;
    }

    public void removeProfileBanner() {
        post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/remove_profile_banner.json"));
    }

    public User reportSpam(String str) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/report_spam.json"), new HttpParameter("screen_name", str)));
    }

    public Status retweetStatus(long j) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "statuses/retweet/", j);
        sb.append(".json");
        return objectFactory.createStatus(post(sb.toString()));
    }

    public ResponseList<Place> reverseGeoCode(GeoQuery geoQuery) throws TwitterException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.conf.getRestBaseURL());
            sb.append("geo/reverse_geocode.json");
            throw null;
        } catch (TwitterException e) {
            if (e.getStatusCode() == 404) {
                return this.factory.createEmptyResponseList();
            }
            throw e;
        }
    }

    public SavedSearchesResources savedSearches() {
        return this;
    }

    public QueryResult search(Query query) {
        throw null;
    }

    public ResponseList<Place> searchPlaces(GeoQuery geoQuery) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("geo/search.json");
        throw null;
    }

    public ResponseList<User> searchUsers(String str, int i) {
        return this.factory.createUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/search.json"), new HttpParameter("q", str), new HttpParameter("per_page", 20), new HttpParameter("page", i)));
    }

    public DirectMessage sendDirectMessage(long j, String str, long j2) throws TwitterException {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "message_create");
            jSONObject2.put("message_create", createMessageCreateJsonObject(j, str, j2));
            jSONObject.put("event", jSONObject2);
            return this.factory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/events/new.json", jSONObject));
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public DirectMessage showDirectMessage(long j) {
        return this.factory.createDirectMessage(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "direct_messages/events/show.json?id=", j)));
    }

    public Relationship showFriendship(long j, long j2) {
        return this.factory.createRelationship(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/show.json"), new HttpParameter("source_id", j), new HttpParameter("target_id", j2)));
    }

    public SavedSearch showSavedSearch(long j) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "saved_searches/show/", j);
        sb.append(".json");
        return objectFactory.createSavedSearch(get(sb.toString()));
    }

    public Status showStatus(long j) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "statuses/show/", j);
        sb.append(".json");
        return objectFactory.createStatus(get(sb.toString(), this.INCLUDE_MY_RETWEET));
    }

    public User showUser(String str) {
        return this.factory.createUser(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/show.json"), new HttpParameter("screen_name", str)));
    }

    public UserList showUserList(String str, String str2) {
        return this.factory.createAUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/show.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public User showUserListMembership(String str, String str2, long j) {
        return this.factory.createUser(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/show.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("user_id", j)));
    }

    public User showUserListSubscription(String str, String str2, long j) {
        return this.factory.createUser(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers/show.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("user_id", j)));
    }

    public SpamReportingResource spamReporting() {
        return this;
    }

    public SuggestedUsersResources suggestedUsers() {
        return this;
    }

    public TimelinesResources timelines() {
        return this;
    }

    public String toString() {
        return "TwitterImpl{INCLUDE_MY_RETWEET=" + this.INCLUDE_MY_RETWEET + '}';
    }

    public TrendsResources trends() {
        return this;
    }

    public TweetsResources tweets() {
        return this;
    }

    public Status unRetweetStatus(long j) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "statuses/unretweet/", j);
        sb.append(".json");
        return objectFactory.createStatus(post(sb.toString()));
    }

    public AccountSettings updateAccountSettings(Integer num, Boolean bool, String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList(6);
        if (num != null) {
            arrayList.add(new HttpParameter("trend_location_woeid", num.intValue()));
        }
        if (bool != null) {
            arrayList.add(new HttpParameter("sleep_time_enabled", bool.toString()));
        }
        if (str != null) {
            arrayList.add(new HttpParameter("start_sleep_time", str));
        }
        if (str2 != null) {
            arrayList.add(new HttpParameter("end_sleep_time", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("time_zone", str3));
        }
        if (str4 != null) {
            arrayList.add(new HttpParameter("lang", str4));
        }
        return this.factory.createAccountSettings(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/settings.json"), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public AccountSettings updateAllowDmsFrom(String str) {
        return this.factory.createAccountSettings(post(this.conf.getRestBaseURL() + "account/settings.json?allow_dms_from=" + str));
    }

    public Relationship updateFriendship(long j, boolean z, boolean z2) {
        return this.factory.createRelationship(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/update.json"), new HttpParameter("user_id", j), new HttpParameter(DeviceRequestsHelper.DEVICE_INFO_DEVICE, z), new HttpParameter("retweets", z2)));
    }

    public User updateProfile(String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList(4);
        addParameterToList(arrayList, "name", str);
        addParameterToList(arrayList, "url", str2);
        addParameterToList(arrayList, "location", str3);
        addParameterToList(arrayList, "description", str4);
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/update_profile.json"), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public User updateProfileBackgroundImage(File file, boolean z) throws TwitterException {
        checkFileValidity(file);
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/update_profile_background_image.json"), new HttpParameter("image", file), new HttpParameter("tile", z)));
    }

    public void updateProfileBanner(File file) throws TwitterException {
        checkFileValidity(file);
        post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/update_profile_banner.json"), new HttpParameter("banner", file));
    }

    public User updateProfileColors(String str, String str2, String str3, String str4, String str5) {
        throw new UnsupportedOperationException("this API is no longer supported. https://twittercommunity.com/t/deprecation-of-account-update-profile-colors/28692");
    }

    public User updateProfileImage(File file) throws TwitterException {
        checkFileValidity(file);
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/update_profile_image.json"), new HttpParameter("image", file)));
    }

    public Status updateStatus(String str) {
        return this.factory.createStatus(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/update.json"), new HttpParameter(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, str)));
    }

    public UploadedMedia uploadMedia(File file) throws TwitterException {
        checkFileValidity(file);
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter(ShareConstants.WEB_DIALOG_PARAM_MEDIA, file)).asJSONObject());
    }

    public UploadedMedia uploadMediaChunked(String str, InputStream inputStream) throws TwitterException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(262144);
            byte[] bArr = new byte[32768];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length > 536870912) {
                Locale locale = Locale.US;
                throw new TwitterException("video file can't be longer than: 512 MBytes");
            }
            try {
                UploadedMedia uploadedMediaUploadMediaChunkedInit = uploadMediaChunkedInit(byteArray.length);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                byte[] bArr2 = new byte[2097152];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = byteArrayInputStream.read(bArr2);
                    if (i4 <= 0) {
                        return this.uploadMediaChunkedFinalize(uploadedMediaUploadMediaChunkedInit.getMediaId());
                    }
                    i2 += i4;
                    logger.debug("Chunked appened, segment index:" + i3 + " bytes:" + i2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + byteArray.length);
                    TwitterImpl twitterImpl = this;
                    String str2 = str;
                    twitterImpl.uploadMediaChunkedAppend(str2, new ByteArrayInputStream(bArr2, 0, i4), i3, uploadedMediaUploadMediaChunkedInit.getMediaId());
                    bArr2 = new byte[2097152];
                    i3++;
                    this = twitterImpl;
                    str = str2;
                }
            } catch (Exception e) {
                Types$$ExternalSyntheticBUOutline0.m(e);
                return null;
            }
        } catch (IOException e2) {
            throw new TwitterException("Failed to download the file.", e2);
        }
    }

    public UsersResources users() {
        return this;
    }

    public User verifyCredentials() {
        return super.fillInIDAndScreenName(new HttpParameter[]{new HttpParameter("include_email", this.conf.isIncludeEmailEnabled())});
    }

    public SearchResource search() {
        return this;
    }

    public ResponseList<DirectMessage> getSentDirectMessages() {
        return removeDMsNotSentByMe(getDirectMessages(100));
    }

    public IDs getBlocksIDs(long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "blocks/ids.json?cursor=", j)));
    }

    public PagableResponseList<User> getBlocksList() {
        return getBlocksList(-1L);
    }

    public ResponseList<Status> getMentionsTimeline() {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/mentions_timeline.json")));
    }

    public ResponseList<Status> getRetweetsOfMe() {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/retweets_of_me.json")));
    }

    public void updateProfileBanner(InputStream inputStream) {
        post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/update_profile_banner.json"), new HttpParameter("banner", "banner", inputStream));
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter[] httpParameterArr2) {
        if (httpParameterArr == null || httpParameterArr2 == null) {
            if (httpParameterArr == null && httpParameterArr2 == null) {
                return new HttpParameter[0];
            }
            return httpParameterArr != null ? httpParameterArr : httpParameterArr2;
        }
        HttpParameter[] httpParameterArr3 = new HttpParameter[httpParameterArr.length + httpParameterArr2.length];
        System.arraycopy(httpParameterArr, 0, httpParameterArr3, 0, httpParameterArr.length);
        System.arraycopy(httpParameterArr2, 0, httpParameterArr3, httpParameterArr.length, httpParameterArr2.length);
        return httpParameterArr3;
    }

    public User createBlock(long j) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "blocks/create.json?user_id=", j)));
    }

    public User createMute(long j) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "mutes/users/create.json?user_id=", j)));
    }

    public User destroyBlock(long j) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "blocks/destroy.json?user_id=", j)));
    }

    public User destroyFriendship(long j) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/destroy.json?user_id=", j)));
    }

    public User destroyMute(long j) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "mutes/users/destroy.json?user_id=", j)));
    }

    public ResponseList<User> getContributees(long j) {
        return this.factory.createUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/contributees.json?user_id=", j)));
    }

    public ResponseList<User> getContributors(long j) {
        return this.factory.createUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/contributors.json?user_id=", j)));
    }

    public User reportSpam(long j) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/report_spam.json?user_id=", j)));
    }

    public User showUser(long j) {
        return this.factory.createUser(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/show.json?user_id=", j)));
    }

    public Status updateStatus(StatusUpdate statusUpdate) {
        new StringBuilder().append(this.conf.getRestBaseURL());
        throw null;
    }

    public IDs getRetweeterIds(long j, long j2) {
        return getRetweeterIds(j, 100, j2);
    }

    public ResponseList<Status> getHomeTimeline() {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/home_timeline.json"), this.INCLUDE_MY_RETWEET));
    }

    public User updateProfileImage(InputStream inputStream) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/update_profile_image.json"), new HttpParameter("image", "image", inputStream)));
    }

    public ResponseList<User> lookupUsers(String... strArr) {
        return this.factory.createUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "users/lookup.json"), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public Map<String, RateLimitStatus> getRateLimitStatus() {
        return this.factory.createRateLimitStatuses(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "application/rate_limit_status.json")));
    }

    public ResponseList<Object> lookupFriendships(String... strArr) {
        return this.factory.createFriendshipList(get(this.conf.getRestBaseURL() + "friendships/lookup.json?screen_name=" + StringUtil.join(strArr)));
    }

    public User createFriendship(String str) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/create.json"), new HttpParameter("screen_name", str)));
    }

    public UserList createUserListSubscription(long j) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers/create.json"), new HttpParameter("list_id", j)));
    }

    public UserList destroyUserList(long j) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/destroy.json"), new HttpParameter("list_id", j)));
    }

    public UserList destroyUserListSubscription(long j) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers/destroy.json"), new HttpParameter("list_id", j)));
    }

    public ResponseList<DirectMessage> getDirectMessages(Paging paging) {
        return removeDMsNotSentToMe(getDirectMessages(paging.getCount()));
    }

    public ResponseList<UserList> getUserLists(String str) {
        return getUserLists(str, false);
    }

    public Relationship showFriendship(String str, String str2) {
        return this.factory.createRelationship(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/show.json"), HttpParameter.getParameterArray("source_screen_name", str, "target_screen_name", str2)));
    }

    public UserList showUserList(long j, String str) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "lists/show.json?owner_id=", j);
        return objectFactory.createAUserList(get(FileInsert$$ExternalSyntheticOutline0.m(sb, "&slug=", str)));
    }

    public DirectMessageList getDirectMessages(int i) {
        return this.factory.createDirectMessageList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "direct_messages/events/list.json"), new HttpParameter("count", i)));
    }

    public ResponseList<Status> getFavorites(long j) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/list.json?user_id=", j)));
    }

    public ResponseList<UserList> getUserLists(long j) {
        return getUserLists(j, false);
    }

    public ResponseList<UserList> getUserLists(long j, boolean z) {
        return this.factory.createUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/list.json"), new HttpParameter("user_id", j), new HttpParameter("reverse", z)));
    }

    public User createFriendship(long j, boolean z) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "friendships/create.json?user_id=", j);
        sb.append("&follow=");
        sb.append(z);
        return objectFactory.createUser(post(sb.toString()));
    }

    public UserList createUserListSubscription(String str, String str2) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers/create.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public UserList destroyUserList(String str, String str2) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/destroy.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public UserList destroyUserListSubscription(String str, String str2) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers/destroy.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public ResponseList<Status> getUserTimeline(long j, Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/user_timeline.json"), mergeParameters(new HttpParameter[]{new HttpParameter("user_id", j), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public User updateProfileBackgroundImage(InputStream inputStream, boolean z) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "account/update_profile_background_image.json"), new HttpParameter("image", "image", inputStream), new HttpParameter("tile", z)));
    }

    public ResponseList<DirectMessage> getDirectMessages() {
        return removeDMsNotSentToMe(getDirectMessages(100));
    }

    public ResponseList<Status> getFavorites(String str) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/list.json"), new HttpParameter("screen_name", str)));
    }

    public UserList showUserList(long j) {
        return this.factory.createAUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/show.json?list_id=", j)));
    }

    public User createFriendship(long j) {
        return this.factory.createUser(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/create.json?user_id=", j)));
    }

    public UserList createUserListMember(long j, long j2) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create.json"), new HttpParameter("user_id", j2), new HttpParameter("list_id", j)));
    }

    public UserList destroyUserListMember(long j, long j2) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/destroy.json"), new HttpParameter("list_id", j), new HttpParameter("user_id", j2)));
    }

    public ResponseList<Status> getFavorites(Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/list.json"), paging.asPostParameterArray()));
    }

    public IDs getFollowersIDs(long j, long j2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "followers/ids.json?user_id=", j);
        return objectFactory.createIDs(get(zzba$$ExternalSyntheticOutline0.m(j2, "&cursor=", sb)));
    }

    public IDs getFriendsIDs(long j, long j2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "friends/ids.json?user_id=", j);
        return objectFactory.createIDs(get(zzba$$ExternalSyntheticOutline0.m(j2, "&cursor=", sb)));
    }

    public PagableResponseList<UserList> getUserListSubscriptions(String str, long j) {
        return getUserListSubscriptions(str, 20, j);
    }

    public PagableResponseList<UserList> getUserListsOwnerships(String str, long j) {
        return getUserListsOwnerships(str, 20, j);
    }

    public User showUserListMembership(long j, String str, long j2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "lists/members/show.json?owner_id=", j);
        Fragment$$ExternalSyntheticOutline1.m67m(sb, "&slug=", str, "&user_id=");
        sb.append(j2);
        return objectFactory.createUser(get(sb.toString()));
    }

    public User showUserListSubscription(long j, String str, long j2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "lists/subscribers/show.json?owner_id=", j);
        Fragment$$ExternalSyntheticOutline1.m67m(sb, "&slug=", str, "&user_id=");
        sb.append(j2);
        return objectFactory.createUser(get(sb.toString()));
    }

    public Relationship updateFriendship(String str, boolean z, boolean z2) {
        return this.factory.createRelationship(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friendships/update.json"), new HttpParameter("screen_name", str), new HttpParameter(DeviceRequestsHelper.DEVICE_INFO_DEVICE, z), new HttpParameter("retweets", z2)));
    }

    public PagableResponseList<UserList> getUserListSubscriptions(long j, long j2) {
        return getUserListSubscriptions(j, 20, j2);
    }

    public PagableResponseList<UserList> getUserListsOwnerships(long j, long j2) {
        return getUserListsOwnerships(j, 20, j2);
    }

    public PagableResponseList<UserList> getUserListSubscriptions(long j, int i, long j2) {
        return this.factory.createPagableUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscriptions.json"), new HttpParameter("user_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2)));
    }

    public PagableResponseList<UserList> getUserListsOwnerships(long j, int i, long j2) {
        return this.factory.createPagableUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/ownerships.json"), new HttpParameter("user_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2)));
    }

    public ResponseList<Status> getUserTimeline(String str) {
        return getUserTimeline(str, new Paging());
    }

    public UploadedMedia uploadMedia(String str, InputStream inputStream) {
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter(ShareConstants.WEB_DIALOG_PARAM_MEDIA, str, inputStream)).asJSONObject());
    }

    public UserList createUserListMember(String str, String str2, long j) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create.json"), new HttpParameter("user_id", j), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public UserList destroyUserListMember(long j, String str) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/destroy.json"), new HttpParameter("list_id", j), new HttpParameter("screen_name", str)));
    }

    public ResponseList<Status> getFavorites() {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/list.json")));
    }

    public ResponseList<Status> getUserTimeline(long j) {
        return getUserTimeline(j, new Paging());
    }

    public UserList createUserListMembers(long j, long... jArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create_all.json"), new HttpParameter("list_id", j), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    public UserList destroyUserListMembers(long j, long[] jArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/destroy_all.json"), new HttpParameter("list_id", j), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    public ResponseList<Status> getUserTimeline() {
        return getUserTimeline(new Paging());
    }

    public IDs getFollowersIDs(long j, long j2, int i) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "followers/ids.json?user_id=", j);
        zzba$$ExternalSyntheticOutline0.m(sb, "&cursor=", j2, "&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFriendsIDs(long j, long j2, int i) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "friends/ids.json?user_id=", j);
        zzba$$ExternalSyntheticOutline0.m(sb, "&cursor=", j2, "&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public ResponseList<Status> getUserListStatuses(long j, Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/statuses.json"), mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter("list_id", j))));
    }

    public ResponseList<Status> getUserTimeline(Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "statuses/user_timeline.json"), mergeParameters(new HttpParameter[]{this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public User showUserListMembership(long j, long j2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "lists/members/show.json?list_id=", j);
        return objectFactory.createUser(get(zzba$$ExternalSyntheticOutline0.m(j2, "&user_id=", sb)));
    }

    public User showUserListSubscription(long j, long j2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "lists/subscribers/show.json?list_id=", j);
        return objectFactory.createUser(get(zzba$$ExternalSyntheticOutline0.m(j2, "&user_id=", sb)));
    }

    public UserList destroyUserListMember(String str, String str2, long j) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/destroy.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("user_id", j)));
    }

    public ResponseList<Status> getFavorites(String str, Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "favorites/list.json"), mergeParameters(new HttpParameter[]{new HttpParameter("screen_name", str)}, paging.asPostParameterArray())));
    }

    public PagableResponseList<UserList> getUserListMemberships(int i, long j) {
        return this.factory.createPagableUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/memberships.json"), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public UserList createUserListMembers(String str, String str2, long... jArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create_all.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    public UserList destroyUserListMembers(long j, String[] strArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/destroy_all.json"), new HttpParameter("list_id", j), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public IDs getFollowersIDs(String str, long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "followers/ids.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j)));
    }

    public IDs getFriendsIDs(String str, long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friends/ids.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j)));
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, long j) {
        return getUserListMemberships(str, j, false);
    }

    public ResponseList<Status> getUserListStatuses(String str, String str2, Paging paging) {
        return this.factory.createStatusList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/statuses.json"), mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)})));
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, int i, long j) {
        return getUserListMemberships(str, i, j, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, long j, boolean z) {
        return getUserListMemberships(str, 20, j, z);
    }

    public IDs getFollowersIDs(long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "followers/ids.json?cursor=", j)));
    }

    public IDs getFriendsIDs(long j) {
        return this.factory.createIDs(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friends/ids.json?cursor=", j)));
    }

    public PagableResponseList<UserList> getUserListMemberships(long j) {
        return getUserListMemberships(20, j);
    }

    public UserList createUserListMembers(long j, String... strArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create_all.json"), new HttpParameter("list_id", j), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public PagableResponseList<User> getFollowersList(String str, long j) {
        return getFollowersList(str, j, 20);
    }

    public PagableResponseList<User> getFriendsList(long j, long j2, int i) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "friends/list.json?user_id=", j);
        zzba$$ExternalSyntheticOutline0.m(sb, "&cursor=", j2, "&count=");
        sb.append(i);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListMembers(long j, int i, long j2) {
        return getUserListMembers(j, i, j2, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, long j2) {
        return getUserListMemberships(j, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, int i, long j2) {
        return getUserListSubscribers(j, i, j2, false);
    }

    public PagableResponseList<User> getFollowersList(long j, long j2, int i) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "followers/list.json?user_id=", j);
        zzba$$ExternalSyntheticOutline0.m(sb, "&cursor=", j2, "&count=");
        sb.append(i);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListMembers(long j, int i, long j2, boolean z) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members.json"), new HttpParameter("list_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2) {
        return getUserListMemberships(j, i, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, int i, long j2, boolean z) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers.json"), new HttpParameter("list_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, long j2, boolean z) {
        return getUserListMemberships(j, 20, j2, z);
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2, boolean z) {
        return this.factory.createPagableUserListList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/memberships.json"), new HttpParameter("user_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("filter_to_owned_lists", z)));
    }

    public PagableResponseList<User> getUserListMembers(long j, String str, long j2) {
        return getUserListMembers(j, str, 20, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, String str, long j2) {
        return getUserListSubscribers(j, str, 20, j2, false);
    }

    public UserList createUserListMembers(long j, String str, String... strArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create_all.json"), new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public PagableResponseList<User> getFriendsList(String str, long j) {
        return getFriendsList(str, j, 20);
    }

    public PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2) {
        return getUserListMembers(j, str, i, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2) {
        return getUserListSubscribers(j, str, i, j2, false);
    }

    public PagableResponseList<User> getFollowersList(String str, long j, int i) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "followers/list.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public PagableResponseList<User> getFriendsList(String str, long j, int i) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "friends/list.json"), new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public PagableResponseList<User> getUserListMembers(long j, long j2) {
        return getUserListMembers(j, 20, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, long j2) {
        return getUserListSubscribers(j, 20, j2, false);
    }

    public DirectMessage sendDirectMessage(long j, String str) {
        return sendDirectMessage(j, str, -1L);
    }

    public PagableResponseList<User> getUserListMembers(String str, String str2, long j) {
        return getUserListMembers(str, str2, 20, j, false);
    }

    public PagableResponseList<User> getUserListSubscribers(String str, String str2, long j) {
        return getUserListSubscribers(str, str2, 20, j, false);
    }

    public DirectMessage sendDirectMessage(String str, String str2) {
        return sendDirectMessage(showUser(str).getId(), str2);
    }

    public PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j) {
        return getUserListMembers(str, str2, i, j, false);
    }

    public PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j) {
        return getUserListSubscribers(str, str2, i, j, false);
    }

    public PagableResponseList<User> getFollowersList(long j, long j2, int i, boolean z, boolean z2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "followers/list.json?user_id=", j);
        zzba$$ExternalSyntheticOutline0.m(sb, "&cursor=", j2, "&count=");
        sb.append(i);
        sb.append("&skip_status=");
        sb.append(z);
        sb.append("&include_user_entities=");
        sb.append(z2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFriendsList(long j, long j2, int i, boolean z, boolean z2) {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        TwitterImpl$$ExternalSyntheticOutline0.m2688m(this.conf, sb, "friends/list.json?user_id=", j);
        zzba$$ExternalSyntheticOutline0.m(sb, "&cursor=", j2, "&count=");
        sb.append(i);
        sb.append("&skip_status=");
        sb.append(z);
        sb.append("&include_user_entities=");
        sb.append(z2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j, boolean z) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("count", i), new HttpParameter("cursor", j), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j, boolean z) {
        return this.factory.createPagableUserList(get(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/subscribers.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("count", i), new HttpParameter("cursor", j), new HttpParameter("skip_status", z)));
    }

    public UserList createUserListMembers(String str, String str2, String... strArr) {
        return this.factory.createAUserList(post(TwitterImpl$$ExternalSyntheticOutline0.m(this.conf, new StringBuilder(), "lists/members/create_all.json"), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public PagableResponseList<User> getFollowersList(long j, long j2) {
        return getFollowersList(j, j2, 20);
    }

    public PagableResponseList<User> getFriendsList(long j, long j2) {
        return getFriendsList(j, j2, 20);
    }

    public UserList updateUserList(long j, String str, String str2, boolean z, String str3) {
        return updateUserList(str2, z, str3, new HttpParameter("owner_id", j), new HttpParameter("slug", str));
    }

    private HttpResponse post(String str, HttpParameter... httpParameterArr) {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponsePost = this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponsePost));
            return httpResponsePost;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    public UserList updateUserList(String str, String str2, String str3, boolean z, String str4) {
        return updateUserList(str3, z, str4, new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2));
    }

    public UserList updateUserList(long j, String str, boolean z, String str2) {
        return updateUserList(str, z, str2, new HttpParameter("list_id", j));
    }

    private HttpResponse post(String str) {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponsePost = this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponsePost));
            return httpResponsePost;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }

    private HttpResponse get(String str, HttpParameter... httpParameterArr) {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponse = this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(httpResponse));
            return httpResponse;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - jCurrentTimeMillis, isOk(null));
            throw th;
        }
    }
}
