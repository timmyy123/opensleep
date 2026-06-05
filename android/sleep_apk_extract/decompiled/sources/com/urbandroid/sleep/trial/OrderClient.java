package com.urbandroid.sleep.trial;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/trial/OrderClient;", "", "<init>", "()V", "", "productId", "orderId", "token", "action", "", "doAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "refundInApp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "revokeSubscription", "(Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OrderClient {
    private final boolean doAction(String productId, String orderId, String token, String action) {
        URL url;
        try {
            if (orderId != null) {
                url = new URL("https://1-dot-sleep-cloud.appspot.com/goal/order/" + action + "?token=" + token + "&orderId=" + orderId + "&productId=" + productId);
            } else {
                url = new URL("https://1-dot-sleep-cloud.appspot.com/goal/subscription/" + action + "?token=" + token + "&subscriptionId=" + productId);
            }
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.getClass();
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            Logger.logInfo("OrderClient: revoke response " + responseCode + ", " + url);
            return responseCode == 200;
        } catch (Exception e) {
            Logger.logSevere("OrderClient: error", e);
            return false;
        }
    }

    public final boolean refundInApp(String productId, String orderId, String token) {
        Fragment$$ExternalSyntheticOutline1.m(productId, orderId, token);
        return doAction(productId, orderId, token, "revoke");
    }

    public final boolean revokeSubscription(String productId, String token) {
        productId.getClass();
        token.getClass();
        return doAction(productId, null, token, "revoke");
    }
}
