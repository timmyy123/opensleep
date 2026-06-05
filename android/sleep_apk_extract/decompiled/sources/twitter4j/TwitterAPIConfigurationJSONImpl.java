package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.MediaEntity;
import twitter4j.MediaEntityJSONImpl;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
class TwitterAPIConfigurationJSONImpl extends TwitterResponseImpl implements TwitterAPIConfiguration {
    private static final long serialVersionUID = -3588904550808591686L;
    private int charactersReservedPerMedia;
    private int dmTextCharacterLimit;
    private int maxMediaPerUpload;
    private String[] nonUsernamePaths;
    private int photoSizeLimit;
    private Map<Integer, MediaEntity.Size> photoSizes;
    private int shortURLLength;
    private int shortURLLengthHttps;

    public TwitterAPIConfigurationJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
            this.photoSizeLimit = ParseUtil.getInt("photo_size_limit", jSONObjectAsJSONObject);
            this.shortURLLength = ParseUtil.getInt("short_url_length", jSONObjectAsJSONObject);
            this.shortURLLengthHttps = ParseUtil.getInt("short_url_length_https", jSONObjectAsJSONObject);
            this.charactersReservedPerMedia = ParseUtil.getInt("characters_reserved_per_media", jSONObjectAsJSONObject);
            this.dmTextCharacterLimit = ParseUtil.getInt("dm_text_character_limit", jSONObjectAsJSONObject);
            JSONObject jSONObject = jSONObjectAsJSONObject.getJSONObject("photo_sizes");
            HashMap map = new HashMap(4);
            this.photoSizes = map;
            map.put(MediaEntity.Size.LARGE, new MediaEntityJSONImpl.Size(jSONObject.getJSONObject("large")));
            this.photoSizes.put(MediaEntity.Size.MEDIUM, new MediaEntityJSONImpl.Size(jSONObject.isNull("med") ? jSONObject.getJSONObject("medium") : jSONObject.getJSONObject("med")));
            this.photoSizes.put(MediaEntity.Size.SMALL, new MediaEntityJSONImpl.Size(jSONObject.getJSONObject("small")));
            this.photoSizes.put(MediaEntity.Size.THUMB, new MediaEntityJSONImpl.Size(jSONObject.getJSONObject("thumb")));
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
                TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
            }
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("non_username_paths");
            this.nonUsernamePaths = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nonUsernamePaths[i] = jSONArray.getString(i);
            }
            this.maxMediaPerUpload = ParseUtil.getInt("max_media_per_upload", jSONObjectAsJSONObject);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterAPIConfigurationJSONImpl)) {
            return false;
        }
        TwitterAPIConfigurationJSONImpl twitterAPIConfigurationJSONImpl = (TwitterAPIConfigurationJSONImpl) obj;
        if (this.charactersReservedPerMedia != twitterAPIConfigurationJSONImpl.charactersReservedPerMedia || this.dmTextCharacterLimit != twitterAPIConfigurationJSONImpl.dmTextCharacterLimit || this.maxMediaPerUpload != twitterAPIConfigurationJSONImpl.maxMediaPerUpload || this.photoSizeLimit != twitterAPIConfigurationJSONImpl.photoSizeLimit || this.shortURLLength != twitterAPIConfigurationJSONImpl.shortURLLength || this.shortURLLengthHttps != twitterAPIConfigurationJSONImpl.shortURLLengthHttps || !Arrays.equals(this.nonUsernamePaths, twitterAPIConfigurationJSONImpl.nonUsernamePaths)) {
            return false;
        }
        Map<Integer, MediaEntity.Size> map = this.photoSizes;
        Map<Integer, MediaEntity.Size> map2 = twitterAPIConfigurationJSONImpl.photoSizes;
        return map == null ? map2 == null : map.equals(map2);
    }

    public int hashCode() {
        int i = ((((((((this.photoSizeLimit * 31) + this.shortURLLength) * 31) + this.shortURLLengthHttps) * 31) + this.charactersReservedPerMedia) * 32) + this.dmTextCharacterLimit) * 31;
        Map<Integer, MediaEntity.Size> map = this.photoSizes;
        int iHashCode = (i + (map != null ? map.hashCode() : 0)) * 31;
        String[] strArr = this.nonUsernamePaths;
        return ((iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31) + this.maxMediaPerUpload;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TwitterAPIConfigurationJSONImpl{photoSizeLimit=");
        sb.append(this.photoSizeLimit);
        sb.append(", shortURLLength=");
        sb.append(this.shortURLLength);
        sb.append(", shortURLLengthHttps=");
        sb.append(this.shortURLLengthHttps);
        sb.append(", charactersReservedPerMedia=");
        sb.append(this.charactersReservedPerMedia);
        sb.append(", dmTextCharacterLimit=");
        sb.append(this.dmTextCharacterLimit);
        sb.append(", photoSizes=");
        sb.append(this.photoSizes);
        sb.append(", nonUsernamePaths=");
        String[] strArr = this.nonUsernamePaths;
        sb.append(strArr == null ? null : Arrays.asList(strArr));
        sb.append(", maxMediaPerUpload=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.maxMediaPerUpload, '}');
    }
}
