package twitter4j;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ltwitter4j/ReplySettings;", "", SDKConstants.PARAM_VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MentionedUsers", "Following", "twitter4j-v2-support"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum ReplySettings {
    MentionedUsers("mentionedUsers"),
    Following("following");

    private final String value;

    ReplySettings(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
