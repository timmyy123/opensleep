package com.urbandroid.sleep.media.spotify;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes4.dex */
public class SpotifyManager {
    private final Activity activity;

    public interface ResultListener {
        void fail(int i);

        void success(String str);
    }

    private SpotifyManager(Activity activity) {
        this.activity = activity;
    }

    public static SpotifyManager from(Activity activity) {
        return new SpotifyManager(activity);
    }

    public static boolean isPremium(String str) {
        Logger.logSevere("Spotify isPremium: " + str);
        if (str != null) {
            return "premium".equals(str) || "family".equals(str);
        }
        return false;
    }

    public void authenticate() {
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder("695f79131de248ee9f4e7f06f241b983", AuthorizationResponse.Type.TOKEN, "sleep-spotify-login://callback");
        builder.setScopes(new String[]{"user-read-private", "playlist-read-private", "user-library-read", "app-remote-control"});
        AuthorizationRequest authorizationRequestBuild = builder.build();
        Toast.makeText(this.activity.getApplicationContext(), R.string.connecting_spotify, 0).show();
        AuthorizationClient.openLoginActivity(this.activity, 1337, authorizationRequestBuild);
    }

    public boolean onAuthenticateResult(int i, int i2, Intent intent, ResultListener resultListener) {
        zza$$ExternalSyntheticOutline0.m(i, i2, "Spotify result - reqCode: ", " resCode: ");
        if (i != 1337) {
            resultListener.fail(1);
            return false;
        }
        if (i2 != -1) {
            resultListener.fail(2);
            return false;
        }
        AuthorizationResponse response = AuthorizationClient.getResponse(i2, intent);
        if (response.getType() == AuthorizationResponse.Type.TOKEN) {
            resultListener.success(response.getAccessToken());
            return true;
        }
        Logger.logSevere("Spotify failed response: " + response.getType() + ": " + response.getError());
        resultListener.fail(3);
        return true;
    }
}
