package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000e¨\u0006\u001d"}, d2 = {"Ltwitter4j/CreateTweetResponse;", "", "Ltwitter4j/HttpResponse;", "res", "", "isJSONStoreEnabled", "<init>", "(Ltwitter4j/HttpResponse;Z)V", "Ltwitter4j/JSONObject;", "jsonObject", "parse", "(Ltwitter4j/JSONObject;Z)Ltwitter4j/JSONObject;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ltwitter4j/RateLimitStatus;", "rateLimitStatus", "Ltwitter4j/RateLimitStatus;", "", "accessLevel", "I", "", "id", "J", "getId", "()J", "text", "Ljava/lang/String;", "getText", "twitter4j-v2-support"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CreateTweetResponse implements Serializable {
    private transient int accessLevel;
    private final long id;
    private transient RateLimitStatus rateLimitStatus;
    private final String text;

    public CreateTweetResponse(HttpResponse httpResponse, boolean z) {
        httpResponse.getClass();
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
        this.accessLevel = ParseUtil.toAccessLevel(httpResponse);
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        jSONObjectAsJSONObject.getClass();
        JSONObject jSONObject = parse(jSONObjectAsJSONObject, z);
        this.id = jSONObject.getLong("id");
        String string = jSONObject.getString("text");
        string.getClass();
        this.text = string;
    }

    private final JSONObject parse(JSONObject jsonObject, boolean isJSONStoreEnabled) {
        if (isJSONStoreEnabled) {
            TwitterObjectFactory.registerJSONObject(this, jsonObject);
        }
        JSONObject jSONObject = jsonObject.getJSONObject("data");
        jSONObject.getClass();
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateTweetResponse(rateLimitStatus=");
        sb.append(this.rateLimitStatus);
        sb.append(", accessLevel=");
        sb.append(this.accessLevel);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", text='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.text, "')");
    }
}
