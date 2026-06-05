package com.urbandroid.sleep;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.SleepStarter;

/* JADX INFO: loaded from: classes4.dex */
public class SleepTrackTileService extends TileService {
    private long lastClicked = -1;

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        super.onClick();
        Logger.logInfo("Tile: onClick, last " + (System.currentTimeMillis() - this.lastClicked));
        GlobalInitializator.initializeIfRequired(getApplicationContext());
        if (this.lastClicked != -1 && System.currentTimeMillis() - this.lastClicked < 500) {
            this.lastClicked = -1L;
            Logger.logInfo("Tile: doubleClick");
            Intent intent = new Intent(getApplicationContext(), (Class<?>) SleepService.getServiceClass(getApplicationContext()));
            intent.putExtra("start_in_battery_saving", true);
            ContextExtKt.startForegroundServiceWithLog(getApplicationContext(), intent);
            return;
        }
        boolean zIsRunning = SleepService.isRunning();
        if (zIsRunning) {
            Logger.logInfo("Tile: singleClick STOP ");
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"));
            zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK");
        } else {
            Logger.logInfo("Tile: singleClick START ");
            new SleepStarter().startSleep(getApplicationContext());
            this.lastClicked = System.currentTimeMillis();
        }
        refresh(!zIsRunning);
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
        refresh(SleepService.isRunning());
    }

    public void refresh(boolean z) {
        GlobalInitializator.initializeIfRequired(getApplicationContext());
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setIcon(Icon.createWithResource(this, R.drawable.ic_action_track_white));
            qsTile.setState(z ? 2 : 1);
            qsTile.setContentDescription(getApplicationContext().getResources().getString(R.string.start_sleep_tracking) + ". Long press starts the alarm list and double tap tracking with battery saving.");
            qsTile.setLabel(getString(R.string.settings_category_track));
            try {
                qsTile.updateTile();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }
}
