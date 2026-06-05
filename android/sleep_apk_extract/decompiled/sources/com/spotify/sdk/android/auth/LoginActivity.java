package com.spotify.sdk.android.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class LoginActivity extends Activity implements AuthorizationClient.AuthorizationClientListener {
    private static final String TAG = "com.spotify.sdk.android.auth.LoginActivity";
    private final AuthorizationClient mAuthorizationClient = new AuthorizationClient(this);

    public static Intent getAuthIntent(Activity activity, AuthorizationRequest authorizationRequest) {
        if (activity == null || authorizationRequest == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Context activity or request can't be null");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", authorizationRequest);
        Intent intent = new Intent(activity, (Class<?>) LoginActivity.class);
        intent.putExtra("EXTRA_AUTH_REQUEST", bundle);
        return intent;
    }

    private AuthorizationRequest getRequestFromIntent() {
        Bundle bundleExtra = getIntent().getBundleExtra("EXTRA_AUTH_REQUEST");
        if (bundleExtra == null) {
            return null;
        }
        return (AuthorizationRequest) bundleExtra.getParcelable("request");
    }

    public static AuthorizationResponse getResponseFromIntent(Intent intent) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra("EXTRA_AUTH_RESPONSE")) == null) {
            return null;
        }
        return (AuthorizationResponse) bundleExtra.getParcelable("response");
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1138) {
            AuthorizationResponse.Builder builder = new AuthorizationResponse.Builder();
            if (i2 == -2) {
                builder.setType(AuthorizationResponse.Type.ERROR);
                String stringExtra = intent == null ? "Invalid message format" : intent.getStringExtra("ERROR");
                if (stringExtra == null) {
                    stringExtra = "Unknown error";
                }
                builder.setError(stringExtra);
            } else if (i2 == -1) {
                Bundle bundle = (Bundle) intent.getParcelableExtra("REPLY");
                if (bundle == null) {
                    builder.setType(AuthorizationResponse.Type.ERROR);
                    builder.setError("Missing response data");
                } else {
                    String string = bundle.getString("RESPONSE_TYPE", "unknown");
                    Log.d(TAG, "Response: " + string);
                    builder.setState(bundle.getString("STATE", null));
                    string.getClass();
                    if (string.equals("code")) {
                        String string2 = bundle.getString("AUTHORIZATION_CODE");
                        builder.setType(AuthorizationResponse.Type.CODE);
                        builder.setCode(string2);
                    } else if (string.equals("token")) {
                        String string3 = bundle.getString("ACCESS_TOKEN");
                        int i3 = bundle.getInt("EXPIRES_IN");
                        builder.setType(AuthorizationResponse.Type.TOKEN);
                        builder.setAccessToken(string3);
                        builder.setExpiresIn(i3);
                    } else {
                        builder.setType(AuthorizationResponse.Type.UNKNOWN);
                    }
                }
            } else {
                builder.setType(AuthorizationResponse.Type.EMPTY);
            }
            this.mAuthorizationClient.setOnCompleteListener(this);
            this.mAuthorizationClient.complete(builder.build());
        }
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationClient.AuthorizationClientListener
    public void onClientCancelled() {
        Log.w(TAG, "Spotify Auth cancelled due to LoginActivity being finished");
        setResult(0);
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationClient.AuthorizationClientListener
    public void onClientComplete(AuthorizationResponse authorizationResponse) {
        Intent intent = new Intent();
        Log.i(TAG, "Spotify auth completing. The response is in EXTRA with key 'response'");
        Bundle bundle = new Bundle();
        bundle.putParcelable("response", authorizationResponse);
        intent.putExtra("EXTRA_AUTH_RESPONSE", bundle);
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.com_spotify_sdk_login_activity);
        AuthorizationRequest requestFromIntent = getRequestFromIntent();
        this.mAuthorizationClient.setOnCompleteListener(this);
        if (getCallingActivity() == null) {
            Log.e(TAG, "Can't use LoginActivity with a null caller. Possible reasons: calling activity has a singleInstance mode or LoginActivity is in a singleInstance/singleTask mode");
            finish();
            return;
        }
        if (requestFromIntent == null) {
            Log.e(TAG, "No authorization request");
            setResult(0);
            finish();
        } else if (bundle == null) {
            Log.d(TAG, "Spotify Auth starting with the request [" + requestFromIntent.toUri().toString() + "]");
            this.mAuthorizationClient.authorize(requestFromIntent);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mAuthorizationClient.cancel();
        this.mAuthorizationClient.setOnCompleteListener(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mAuthorizationClient.complete(AuthorizationResponse.fromUri(intent.getData()));
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mAuthorizationClient.notifyInCaseUserCanceledAuth();
    }
}
