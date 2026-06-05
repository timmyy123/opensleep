package com.urbandroid.sleep.nearby.core;

import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.gui.DefaultValueListPreference;
import com.urbandroid.sleep.gui.NextAlarmPreference;
import com.urbandroid.sleep.media.googlemusic.GoogleMusicPlayer;
import com.urbandroid.sleep.media.spotify.SpotifyManagerAuthActivity;
import com.urbandroid.sleep.shortcut.ShortcutActivity;
import com.urbandroid.sleep.smartlight.FlashLight;
import com.urbandroid.sleep.smartwatch.pebble.Pebble;
import com.urbandroid.sleep.smartwatch.pebble.RePebbleListenerService;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Endpoint$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Endpoint$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((Endpoint) obj).shutdown();
                break;
            case 1:
                ((DashboardCard) obj).lambda$removeForNow$2();
                break;
            case 2:
                DefaultValueListPreference.addDefaultValue$lambda$0((DefaultValueListPreference) obj);
                break;
            case 3:
                ((NextAlarmPreference) obj).setOffsetText();
                break;
            case 4:
                GoogleMusicPlayer.stop$lambda$0((GoogleMusicPlayer) obj);
                break;
            case 5:
                SpotifyManagerAuthActivity.failAndFinish$lambda$0((SpotifyManagerAuthActivity) obj);
                break;
            case 6:
                ShortcutActivity.onPostResume$lambda$0((ShortcutActivity) obj);
                break;
            case 7:
                FlashLight.shortHint$lambda$0((FlashLight) obj);
                break;
            case 8:
                ((Pebble) obj).lambda$startTracking$0();
                break;
            default:
                RePebbleListenerService.startAppRunnable$lambda$0((RePebbleListenerService) obj);
                break;
        }
    }
}
