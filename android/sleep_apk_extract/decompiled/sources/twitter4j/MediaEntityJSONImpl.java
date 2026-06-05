package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.MediaEntity;

/* JADX INFO: loaded from: classes5.dex */
public class MediaEntityJSONImpl extends EntityIndex implements MediaEntity {
    private static final long serialVersionUID = 1571961225214439778L;
    private String displayURL;
    private String expandedURL;
    private String extAltText;
    protected long id;
    private String mediaURL;
    private String mediaURLHttps;
    private Map<Integer, MediaEntity.Size> sizes;
    protected String type;
    protected String url;
    private int videoAspectRatioHeight;
    private int videoAspectRatioWidth;
    private long videoDurationMillis;
    private Variant[] videoVariants;

    public static class Size implements MediaEntity.Size {
        private static final long serialVersionUID = -2515842281909325169L;
        int height;
        int resize;
        int width;

        public Size(JSONObject jSONObject) {
            this.width = jSONObject.getInt("w");
            this.height = jSONObject.getInt("h");
            this.resize = "fit".equals(jSONObject.getString("resize")) ? 100 : 101;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.height == size.height && this.resize == size.resize && this.width == size.width;
        }

        public int hashCode() {
            return (((this.width * 31) + this.height) * 31) + this.resize;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Size{width=");
            sb.append(this.width);
            sb.append(", height=");
            sb.append(this.height);
            sb.append(", resize=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.resize, '}');
        }
    }

    public static class Variant implements Serializable {
        private static final long serialVersionUID = 1027236588556797980L;
        int bitrate;
        String contentType;
        String url;

        public Variant(JSONObject jSONObject) {
            this.bitrate = jSONObject.has("bitrate") ? jSONObject.getInt("bitrate") : 0;
            this.contentType = jSONObject.getString("content_type");
            this.url = jSONObject.getString("url");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Variant)) {
                return false;
            }
            Variant variant = (Variant) obj;
            return this.bitrate == variant.bitrate && this.contentType.equals(variant.contentType) && this.url.equals(variant.url);
        }

        public int hashCode() {
            int i = this.bitrate * 31;
            String str = this.contentType;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.url;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Variant{bitrate=");
            sb.append(this.bitrate);
            sb.append(", contentType=");
            sb.append(this.contentType);
            sb.append(", url=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.url, '}');
        }
    }

    public MediaEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            this.id = ParseUtil.getLong("id", jSONObject);
            this.url = jSONObject.getString("url");
            this.expandedURL = jSONObject.getString("expanded_url");
            this.mediaURL = jSONObject.getString("media_url");
            this.mediaURLHttps = jSONObject.getString("media_url_https");
            this.displayURL = jSONObject.getString("display_url");
            JSONObject jSONObject2 = jSONObject.getJSONObject("sizes");
            HashMap map = new HashMap(4);
            this.sizes = map;
            addMediaEntitySizeIfNotNull(map, jSONObject2, MediaEntity.Size.LARGE, "large");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.MEDIUM, "medium");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.SMALL, "small");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.THUMB, "thumb");
            if (!jSONObject.isNull("type")) {
                this.type = jSONObject.getString("type");
            }
            if (jSONObject.has("video_info")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("video_info");
                JSONArray jSONArray2 = jSONObject3.getJSONArray("aspect_ratio");
                this.videoAspectRatioWidth = jSONArray2.getInt(0);
                this.videoAspectRatioHeight = jSONArray2.getInt(1);
                if (!jSONObject3.isNull("duration_millis")) {
                    this.videoDurationMillis = jSONObject3.getLong("duration_millis");
                }
                JSONArray jSONArray3 = jSONObject3.getJSONArray("variants");
                this.videoVariants = new Variant[jSONArray3.length()];
                for (int i = 0; i < jSONArray3.length(); i++) {
                    this.videoVariants[i] = new Variant(jSONArray3.getJSONObject(i));
                }
            } else {
                this.videoVariants = new Variant[0];
            }
            if (jSONObject.has("ext_alt_text")) {
                this.extAltText = jSONObject.getString("ext_alt_text");
            }
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            throw null;
        }
    }

    private void addMediaEntitySizeIfNotNull(Map<Integer, MediaEntity.Size> map, JSONObject jSONObject, Integer num, String str) {
        if (jSONObject.isNull(str)) {
            return;
        }
        map.put(num, new Size(jSONObject.getJSONObject(str)));
    }

    @Override // twitter4j.EntityIndex
    public /* bridge */ /* synthetic */ int compareTo(EntityIndex entityIndex) {
        return super.compareTo(entityIndex);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MediaEntityJSONImpl) && this.id == ((MediaEntityJSONImpl) obj).id;
    }

    @Override // twitter4j.EntityIndex
    public int getEnd() {
        return super.getEnd();
    }

    @Override // twitter4j.EntityIndex
    public int getStart() {
        return super.getStart();
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaEntityJSONImpl{id=");
        sb.append(this.id);
        sb.append(", url='");
        sb.append(this.url);
        sb.append("', mediaURL='");
        sb.append(this.mediaURL);
        sb.append("', mediaURLHttps='");
        sb.append(this.mediaURLHttps);
        sb.append("', expandedURL='");
        sb.append(this.expandedURL);
        sb.append("', displayURL='");
        sb.append(this.displayURL);
        sb.append("', sizes=");
        sb.append(this.sizes);
        sb.append(", type='");
        sb.append(this.type);
        sb.append("', videoAspectRatioWidth=");
        sb.append(this.videoAspectRatioWidth);
        sb.append(", videoAspectRatioHeight=");
        sb.append(this.videoAspectRatioHeight);
        sb.append(", videoDurationMillis=");
        sb.append(this.videoDurationMillis);
        sb.append(", videoVariants=");
        sb.append(this.videoVariants.length);
        sb.append(", extAltText='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.extAltText, "'}");
    }
}
