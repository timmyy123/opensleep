package twitter4j.auth;

import java.io.Serializable;
import twitter4j.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public interface Authorization extends Serializable {
    String getAuthorizationHeader(HttpRequest httpRequest);

    boolean isEnabled();
}
