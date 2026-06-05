package twitter4j;

import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes5.dex */
abstract class EntitiesParseUtil {
    public static HashtagEntity[] getHashtags(JSONObject jSONObject) {
        if (jSONObject.isNull("hashtags")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("hashtags");
        int length = jSONArray.length();
        HashtagEntity[] hashtagEntityArr = new HashtagEntity[length];
        for (int i = 0; i < length; i++) {
            hashtagEntityArr[i] = new HashtagEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return hashtagEntityArr;
    }

    public static MediaEntity[] getMedia(JSONObject jSONObject) {
        if (jSONObject.isNull(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA);
        int length = jSONArray.length();
        MediaEntity[] mediaEntityArr = new MediaEntity[length];
        for (int i = 0; i < length; i++) {
            mediaEntityArr[i] = new MediaEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return mediaEntityArr;
    }

    public static SymbolEntity[] getSymbols(JSONObject jSONObject) {
        if (jSONObject.isNull("symbols")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("symbols");
        int length = jSONArray.length();
        SymbolEntity[] symbolEntityArr = new SymbolEntity[length];
        for (int i = 0; i < length; i++) {
            symbolEntityArr[i] = new HashtagEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return symbolEntityArr;
    }

    public static URLEntity[] getUrls(JSONObject jSONObject) {
        if (jSONObject.isNull("urls")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("urls");
        int length = jSONArray.length();
        URLEntity[] uRLEntityArr = new URLEntity[length];
        for (int i = 0; i < length; i++) {
            uRLEntityArr[i] = new URLEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return uRLEntityArr;
    }

    public static UserMentionEntity[] getUserMentions(JSONObject jSONObject) {
        if (jSONObject.isNull("user_mentions")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("user_mentions");
        int length = jSONArray.length();
        UserMentionEntity[] userMentionEntityArr = new UserMentionEntity[length];
        for (int i = 0; i < length; i++) {
            userMentionEntityArr[i] = new UserMentionEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return userMentionEntityArr;
    }
}
