package com.urbandroid.sleep.alarmclock.settings;

import android.preference.CheckBoxPreference;
import com.facebook.GraphResponse;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.spotify.SpotifyManager;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.service.Settings;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kaaes.spotify.webapi.android.models.UserPrivate;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/alarmclock/settings/ServicesSettingsActivity$onActivityResult$4$success$1", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$ResultListener;", "Lkaaes/spotify/webapi/android/models/UserPrivate;", GraphResponse.SUCCESS_KEY, "", "result", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ServicesSettingsActivity$onActivityResult$4$success$1 implements SpotifyServiceExecutor.ResultListener<UserPrivate> {
    final /* synthetic */ SpotifyServiceExecutor $serviceExecutor;
    final /* synthetic */ Settings $settings;
    final /* synthetic */ CheckBoxPreference $spotifyPreference;
    final /* synthetic */ ServicesSettingsActivity this$0;

    public ServicesSettingsActivity$onActivityResult$4$success$1(ServicesSettingsActivity servicesSettingsActivity, CheckBoxPreference checkBoxPreference, Settings settings, SpotifyServiceExecutor spotifyServiceExecutor) {
        this.this$0 = servicesSettingsActivity;
        this.$spotifyPreference = checkBoxPreference;
        this.$settings = settings;
        this.$serviceExecutor = spotifyServiceExecutor;
    }

    @Override // com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor.ResultListener
    public void success(UserPrivate result) {
        if (result == null) {
            ServicesSettingsActivity servicesSettingsActivity = this.this$0;
            Logger.logWarning(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Spotify user is null", null);
            this.$spotifyPreference.setChecked(false);
            this.$settings.setSpotify(false);
            return;
        }
        Settings settings = this.$settings;
        CheckBoxPreference checkBoxPreference = this.$spotifyPreference;
        settings.setSpotifyProduct(result.product);
        settings.setSpotifyPremium(SpotifyManager.isPremium(result.product));
        checkBoxPreference.setChecked(true);
        settings.setSpotifyAppRemoteScopeAllowed(true);
        settings.setSpotify(true);
        MediaListActivity.loadAlbums(this.$serviceExecutor, new Events$$ExternalSyntheticBUOutline0(1));
    }
}
