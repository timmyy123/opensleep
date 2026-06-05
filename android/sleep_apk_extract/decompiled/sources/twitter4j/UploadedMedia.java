package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import java.io.Serializable;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadedMedia implements Serializable {
    private static final long serialVersionUID = 5393092535610604718L;
    private int imageHeight;
    private String imageType;
    private int imageWidth;
    private long mediaId;
    private int processingCheckAfterSecs;
    private String processingState;
    private int progressPercent;
    private long size;

    public UploadedMedia(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.mediaId = ParseUtil.getLong(SDKConstants.PARAM_A2U_MEDIA_ID, jSONObject);
        this.size = ParseUtil.getLong("size", jSONObject);
        try {
            if (!jSONObject.isNull("image")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("image");
                this.imageWidth = ParseUtil.getInt("w", jSONObject2);
                this.imageHeight = ParseUtil.getInt("h", jSONObject2);
                this.imageType = ParseUtil.getUnescapedString("image_type", jSONObject2);
            }
            if (jSONObject.isNull("processing_info")) {
                return;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("processing_info");
            this.processingState = ParseUtil.getUnescapedString(ServerProtocol.DIALOG_PARAM_STATE, jSONObject3);
            this.processingCheckAfterSecs = ParseUtil.getInt("check_after_secs", jSONObject3);
            this.progressPercent = ParseUtil.getInt("progress_percent", jSONObject3);
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UploadedMedia.class != obj.getClass()) {
            return false;
        }
        UploadedMedia uploadedMedia = (UploadedMedia) obj;
        return this.imageWidth == uploadedMedia.imageWidth && this.imageHeight == uploadedMedia.imageHeight && this.imageType == uploadedMedia.imageType && this.mediaId == uploadedMedia.mediaId && this.size == uploadedMedia.size;
    }

    public long getMediaId() {
        return this.mediaId;
    }

    public int getProcessingCheckAfterSecs() {
        return this.processingCheckAfterSecs;
    }

    public String getProcessingState() {
        return this.processingState;
    }

    public int getProgressPercent() {
        return this.progressPercent;
    }

    public int hashCode() {
        long j = this.mediaId;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + this.imageWidth) * 31) + this.imageHeight) * 31;
        String str = this.imageType;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j2 = this.size;
        return ((i + iHashCode) * 31) + ((int) ((j2 >>> 32) ^ j2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadedMedia{mediaId=");
        sb.append(this.mediaId);
        sb.append(", imageWidth=");
        sb.append(this.imageWidth);
        sb.append(", imageHeight=");
        sb.append(this.imageHeight);
        sb.append(", imageType='");
        sb.append(this.imageType);
        sb.append("', size=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.size, '}');
    }
}
