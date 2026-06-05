package com.facebook.gamingservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GamingPayload {
    private static final String KEY_APPLINK_DATA = "al_applink_data";
    private static final String KEY_CONTEXT_TOKEN_ID = "context_token_id";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_GAME_REQUEST_ID = "game_request_id";
    private static final String KEY_PAYLOAD = "payload";
    private static final String KEY_TOURNAMENT_ID = "tournament_id";
    private static final String TAG = "GamingPayload";
    private static Map<String, String> payloadData;

    private GamingPayload() {
    }

    public static String getGameRequestID() {
        Map<String, String> map = payloadData;
        if (map != null && map.containsKey(KEY_GAME_REQUEST_ID)) {
            return payloadData.get(KEY_GAME_REQUEST_ID);
        }
        return null;
    }

    public static String getPayload() {
        Map<String, String> map = payloadData;
        if (map != null && map.containsKey("payload")) {
            return payloadData.get("payload");
        }
        return null;
    }

    public static String getTournamentId() {
        Map<String, String> map = payloadData;
        if (map != null && map.containsKey("tournament_id")) {
            return payloadData.get("tournament_id");
        }
        return null;
    }

    public static void loadPayloadFromCloudGame(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            map.put(KEY_GAME_REQUEST_ID, jSONObject.optString(KEY_GAME_REQUEST_ID));
            map.put("payload", jSONObject.optString("payload"));
            map.put("tournament_id", jSONObject.optString("tournament_id"));
            payloadData = map;
        } catch (JSONException e) {
            Log.e(TAG, e.toString(), e);
        }
    }

    public static void loadPayloadFromIntent(Intent intent) {
        Bundle extras;
        Bundle bundle;
        HashMap map = new HashMap();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("al_applink_data") || (bundle = extras.getBundle("al_applink_data").getBundle("extras")) == null) {
            return;
        }
        String string = bundle.getString(KEY_GAME_REQUEST_ID);
        String string2 = bundle.getString("payload");
        String string3 = bundle.getString(KEY_CONTEXT_TOKEN_ID);
        String string4 = bundle.getString("tournament_id");
        if (string3 != null) {
            GamingContext.setCurrentGamingContext(new GamingContext(string3));
        }
        map.put(KEY_GAME_REQUEST_ID, string);
        map.put("payload", string2);
        map.put("tournament_id", string4);
        payloadData = map;
    }
}
