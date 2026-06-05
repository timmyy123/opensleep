package com.spotify.sdk.android.auth;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.spotify.sdk.android.auth.AuthorizationHandler;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.spotify.sdk.android.auth.app.SpotifyAuthHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AuthorizationClient {
    private AuthorizationClientListener mAuthorizationClientListener;
    private List<AuthorizationHandler> mAuthorizationHandlers;
    private boolean mAuthorizationPending;
    private AuthorizationHandler mCurrentHandler;
    private final Activity mLoginActivity;

    public interface AuthorizationClientListener {
        void onClientCancelled();

        void onClientComplete(AuthorizationResponse authorizationResponse);
    }

    public AuthorizationClient(Activity activity) {
        ArrayList arrayList = new ArrayList();
        this.mAuthorizationHandlers = arrayList;
        this.mLoginActivity = activity;
        arrayList.add(new SpotifyAuthHandler());
        this.mAuthorizationHandlers.add(new FallbackHandlerProvider().provideFallback());
    }

    private void closeAuthorizationHandler(AuthorizationHandler authorizationHandler) {
        if (authorizationHandler != null) {
            authorizationHandler.setOnCompleteListener(null);
            authorizationHandler.stop();
        }
    }

    public static Intent createLoginActivityIntent(Activity activity, AuthorizationRequest authorizationRequest) {
        Intent authIntent = LoginActivity.getAuthIntent(activity, authorizationRequest);
        authIntent.addFlags(67108864);
        return authIntent;
    }

    public static AuthorizationResponse getResponse(int i, Intent intent) {
        return (i != -1 || LoginActivity.getResponseFromIntent(intent) == null) ? new AuthorizationResponse.Builder().setType(AuthorizationResponse.Type.EMPTY).build() : LoginActivity.getResponseFromIntent(intent);
    }

    public static void openLoginActivity(Activity activity, int i, AuthorizationRequest authorizationRequest) {
        activity.startActivityForResult(createLoginActivityIntent(activity, authorizationRequest), i);
    }

    private void sendComplete(AuthorizationHandler authorizationHandler, AuthorizationResponse authorizationResponse) {
        this.mAuthorizationPending = false;
        closeAuthorizationHandler(authorizationHandler);
        AuthorizationClientListener authorizationClientListener = this.mAuthorizationClientListener;
        if (authorizationClientListener == null) {
            Log.w("Spotify Auth Client", "Can't deliver the Spotify Auth response. The listener is null");
        } else {
            authorizationClientListener.onClientComplete(authorizationResponse);
            this.mAuthorizationClientListener = null;
        }
    }

    private boolean tryAuthorizationHandler(final AuthorizationHandler authorizationHandler, AuthorizationRequest authorizationRequest) {
        authorizationHandler.setOnCompleteListener(new AuthorizationHandler.OnCompleteListener() { // from class: com.spotify.sdk.android.auth.AuthorizationClient.1
        });
        if (authorizationHandler.start(this.mLoginActivity, authorizationRequest)) {
            return true;
        }
        closeAuthorizationHandler(authorizationHandler);
        return false;
    }

    public void authorize(AuthorizationRequest authorizationRequest) {
        if (this.mAuthorizationPending) {
            return;
        }
        this.mAuthorizationPending = true;
        for (AuthorizationHandler authorizationHandler : this.mAuthorizationHandlers) {
            if (tryAuthorizationHandler(authorizationHandler, authorizationRequest)) {
                this.mCurrentHandler = authorizationHandler;
                return;
            }
        }
    }

    public void cancel() {
        if (this.mAuthorizationPending) {
            this.mAuthorizationPending = false;
            closeAuthorizationHandler(this.mCurrentHandler);
            AuthorizationClientListener authorizationClientListener = this.mAuthorizationClientListener;
            if (authorizationClientListener != null) {
                authorizationClientListener.onClientCancelled();
                this.mAuthorizationClientListener = null;
            }
        }
    }

    public void complete(AuthorizationResponse authorizationResponse) {
        sendComplete(this.mCurrentHandler, authorizationResponse);
    }

    public void notifyInCaseUserCanceledAuth() {
        AuthorizationHandler authorizationHandler = this.mCurrentHandler;
        if (authorizationHandler == null || !authorizationHandler.isAuthInProgress()) {
            return;
        }
        Log.i("Spotify Auth Client", "Spotify auth response: User cancelled");
        complete(new AuthorizationResponse.Builder().setType(AuthorizationResponse.Type.EMPTY).build());
    }

    public void setOnCompleteListener(AuthorizationClientListener authorizationClientListener) {
        this.mAuthorizationClientListener = authorizationClientListener;
    }
}
