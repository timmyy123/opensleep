package twitter4j;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u009f\u0001\u0010\u0018\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R#\u0010*\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Ltwitter4j/TwitterV2Impl;", "Ltwitter4j/TwitterV2;", "Ltwitter4j/Twitter;", "twitter", "<init>", "(Ltwitter4j/Twitter;)V", "", "directMessageDeepLink", "", "forSuperFollowersOnly", "placeId", "", "", "mediaIds", "taggedUserIds", "pollDurationMinutes", "pollOptions", "quoteTweetId", "excludeReplyUserIds", "inReplyToTweetId", "Ltwitter4j/ReplySettings;", "replySettings", "text", "Ltwitter4j/CreateTweetResponse;", "createTweet", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;[Ljava/lang/Long;[Ljava/lang/Long;Ljava/lang/Long;[Ljava/lang/String;Ljava/lang/Long;[Ljava/lang/Long;Ljava/lang/Long;Ltwitter4j/ReplySettings;Ljava/lang/String;)Ltwitter4j/CreateTweetResponse;", "url", "Ltwitter4j/JSONObject;", "json", "Ltwitter4j/HttpResponse;", "post", "(Ljava/lang/String;Ltwitter4j/JSONObject;)Ltwitter4j/HttpResponse;", "Ltwitter4j/HttpParameter;", NativeProtocol.WEB_DIALOG_PARAMS, "(Ljava/lang/String;[Ltwitter4j/HttpParameter;)Ltwitter4j/HttpResponse;", "Ltwitter4j/Twitter;", "Ltwitter4j/conf/Configuration;", "kotlin.jvm.PlatformType", "conf$delegate", "Lkotlin/Lazy;", "getConf", "()Ltwitter4j/conf/Configuration;", "conf", "twitter4j-v2-support"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TwitterV2Impl implements TwitterV2 {

    /* JADX INFO: renamed from: conf$delegate, reason: from kotlin metadata */
    private final Lazy conf;
    private final Twitter twitter;

    public TwitterV2Impl(Twitter twitter) {
        twitter.getClass();
        this.twitter = twitter;
        this.conf = LazyKt.lazy(new Function0<Configuration>() { // from class: twitter4j.TwitterV2Impl$conf$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Configuration invoke() {
                return this.this$0.twitter.getConfiguration();
            }
        });
    }

    private final Configuration getConf() {
        return (Configuration) this.conf.getValue();
    }

    private final HttpResponse post(String url, HttpParameter[] params) {
        Twitter twitter = this.twitter;
        if (!(twitter instanceof TwitterImpl)) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("invalid twitter4j impl");
            return null;
        }
        ((TwitterImpl) twitter).ensureAuthorizationEnabled();
        Twitter twitter2 = this.twitter;
        HttpResponse httpResponsePost = ((TwitterImpl) twitter2).http.post(url, params, ((TwitterImpl) twitter2).auth, (HttpResponseListener) twitter2);
        httpResponsePost.getClass();
        return httpResponsePost;
    }

    @Override // twitter4j.TwitterV2
    public CreateTweetResponse createTweet(String directMessageDeepLink, Boolean forSuperFollowersOnly, String placeId, Long[] mediaIds, Long[] taggedUserIds, Long pollDurationMinutes, String[] pollOptions, Long quoteTweetId, Long[] excludeReplyUserIds, Long inReplyToTweetId, ReplySettings replySettings, String text) {
        JSONObject jSONObject = new JSONObject();
        if (directMessageDeepLink != null) {
            jSONObject.put("direct_message_deep_link", directMessageDeepLink);
        }
        if (forSuperFollowersOnly != null) {
            jSONObject.put("for_super_followers_only", forSuperFollowersOnly.booleanValue());
        }
        if (placeId != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("place_id", placeId);
            Unit unit = Unit.INSTANCE;
            jSONObject.put("geo", jSONObject2);
        }
        if (mediaIds != null) {
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (Long l : mediaIds) {
                jSONArray.put(String.valueOf(l.longValue()));
            }
            Unit unit2 = Unit.INSTANCE;
            jSONObject3.put("media_ids", jSONArray);
            if (taggedUserIds != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Long l2 : taggedUserIds) {
                    jSONArray2.put(String.valueOf(l2.longValue()));
                }
                Unit unit3 = Unit.INSTANCE;
                jSONObject3.put("tagged_user_ids", jSONArray2);
            }
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MEDIA, jSONObject3);
        }
        if (pollDurationMinutes != null && pollOptions != null) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("duration_minutes", pollDurationMinutes.longValue());
            JSONArray jSONArray3 = new JSONArray();
            for (String str : pollOptions) {
                jSONArray3.put(str);
            }
            Unit unit4 = Unit.INSTANCE;
            jSONObject4.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, jSONArray3);
            jSONObject.put("poll", jSONObject4);
        }
        if (quoteTweetId != null) {
            jSONObject.put("quote_tweet_id", quoteTweetId.toString());
        }
        if (inReplyToTweetId != null) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("in_reply_to_tweet_id", inReplyToTweetId.toString());
            if (excludeReplyUserIds != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Long l3 : excludeReplyUserIds) {
                    jSONArray4.put(String.valueOf(l3.longValue()));
                }
                Unit unit5 = Unit.INSTANCE;
                jSONObject5.put("exclude_reply_user_ids", jSONArray4);
            }
            Unit unit6 = Unit.INSTANCE;
            jSONObject.put("reply", jSONObject5);
        }
        if (replySettings != null) {
            jSONObject.put("reply_settings", replySettings.getValue());
        }
        if (text != null) {
            jSONObject.put("text", text);
        }
        V2ResponseFactory v2ResponseFactory = new V2ResponseFactory();
        StringBuilder sb = new StringBuilder();
        Configuration conf = getConf();
        conf.getClass();
        sb.append(V2ConfigurationKt.getV2Configuration(conf).getBaseURL());
        sb.append("tweets");
        HttpResponse httpResponsePost = post(sb.toString(), jSONObject);
        Configuration conf2 = getConf();
        conf2.getClass();
        return v2ResponseFactory.createCreateTweetResponse(httpResponsePost, conf2);
    }

    private final HttpResponse post(String url, JSONObject json) {
        return post(url, new HttpParameter[]{new HttpParameter(json)});
    }
}
