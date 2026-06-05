package com.urbandroid.sleep.media.spotify;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.media.spotify.SpotifyManager;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.service.Settings;
import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.UserPrivate;
import kotlin.Metadata;
import org.mp4parser.boxes.threegpp.ts26244.AuthorBox;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifyManagerAuthActivity;", "Lcom/urbandroid/common/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "failAndFinish", AuthorBox.TYPE, "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpotifyManagerAuthActivity extends BaseActivity {
    private final void auth() {
        Object systemService = getSystemService("connectivity");
        systemService.getClass();
        boolean z = ((ConnectivityManager) systemService).getActiveNetworkInfo() != null;
        zza$$ExternalSyntheticOutline0.m("SpotifyManagerAuthActivity: auth() ", z);
        if (!z) {
            Toast.makeText(this, R.string.no_connection, 0).show();
        } else {
            Logger.logInfo("SpotifyManagerAuthActivity: authenticate()");
            SpotifyManager.from(this).authenticate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failAndFinish() {
        this.h.post(new Endpoint$$ExternalSyntheticLambda0(this, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void failAndFinish$lambda$0(SpotifyManagerAuthActivity spotifyManagerAuthActivity) {
        Toast.makeText(spotifyManagerAuthActivity, R.string.general_unspecified_error, 0);
        spotifyManagerAuthActivity.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        super.onActivityResult(requestCode, resultCode, data2);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        final Settings settings = ContextExtKt.getSettings(applicationContext);
        zza$$ExternalSyntheticOutline0.m(resultCode, "SpotifyManagerAuthActivity: onActivityResult() ");
        if (requestCode == 1337) {
            SpotifyManager.from(this).onAuthenticateResult(requestCode, resultCode, data2, new SpotifyManager.ResultListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyManagerAuthActivity.onActivityResult.1
                @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
                public void fail(int reason) {
                    SpotifyManagerAuthActivity.this.failAndFinish();
                }

                @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
                public void success(String accessToken) {
                    accessToken.getClass();
                    SpotifyApi spotifyApi = new SpotifyApi();
                    spotifyApi.setAccessToken(accessToken);
                    SpotifyService service = spotifyApi.getService();
                    service.getClass();
                    SpotifyServiceExecutor spotifyServiceExecutor = new SpotifyServiceExecutor(service);
                    final SpotifyManagerAuthActivity spotifyManagerAuthActivity = SpotifyManagerAuthActivity.this;
                    final Settings settings2 = settings;
                    spotifyServiceExecutor.getUser(new SpotifyServiceExecutor.ResultListener<UserPrivate>() { // from class: com.urbandroid.sleep.media.spotify.SpotifyManagerAuthActivity$onActivityResult$1$success$1
                        @Override // com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor.ResultListener
                        public void success(UserPrivate result) {
                            if (result == null) {
                                Logger.logWarning("Spotify user is null", null);
                                spotifyManagerAuthActivity.failAndFinish();
                                return;
                            }
                            Settings settings3 = settings2;
                            SpotifyManagerAuthActivity spotifyManagerAuthActivity2 = spotifyManagerAuthActivity;
                            settings3.setSpotifyProduct(result.product);
                            settings3.setSpotifyPremium(SpotifyManager.isPremium(result.product));
                            settings3.setSpotifyAppRemoteScopeAllowed(true);
                            settings3.setSpotify(true);
                            spotifyManagerAuthActivity2.finish();
                        }
                    });
                }
            });
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        setTitle(R.string.spotify);
        Logger.logInfo("SpotifyManagerAuthActivity: onCreate()");
        auth();
    }
}
