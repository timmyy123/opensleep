package com.urbandroid.sleep.mic;

import android.content.Context;
import android.net.Uri;
import android.os.Vibrator;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.lucid.LucidPlayer;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;

/* JADX INFO: loaded from: classes4.dex */
public class AntiSnorer {
    private int antisnoreCounter = 0;
    private boolean antisnoreLastOver = false;
    private final Context context;
    private final boolean doAntiSnore;
    private Vibrator vibrator;

    public AntiSnorer(Context context, boolean z) {
        this.context = context;
        this.doAntiSnore = z;
    }

    private void responseClick(int i) {
        LucidPlayer lucidPlayer = new LucidPlayer();
        String antisnoringRingtone = SharedApplicationContext.getSettings().getAntisnoringRingtone();
        lucidPlayer.play(this.context, !SharedApplicationContext.getSettings().isHintHeadphonesOnly() ? 4 : 3, SharedApplicationContext.getSettings().getAntisnoringVolume(), Uri.parse(antisnoringRingtone), i);
        Logger.logDebug("Antisnore played: " + antisnoringRingtone);
    }

    private void responseVibrate(int i) {
        if (this.vibrator == null) {
            this.vibrator = (Vibrator) this.context.getSystemService("vibrator");
        }
        int i2 = i * 2;
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3 += 2) {
            jArr[i3] = 500;
            jArr[i3 + 1] = 250;
        }
        Logger.logInfo("AntiSnorer: vibrate()");
        this.vibrator.vibrate(jArr, -1);
    }

    public void performResponse() {
        int recordingAntisnoreResponse = SharedApplicationContext.getSettings().getRecordingAntisnoreResponse();
        int antiSnoringLoop = SharedApplicationContext.getSettings().getAntiSnoringLoop();
        if (recordingAntisnoreResponse == 3 || recordingAntisnoreResponse == 2) {
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this.context);
            if (smartWatch != null) {
                smartWatch.hint(antiSnoringLoop);
            } else {
                responseVibrate(antiSnoringLoop);
            }
        }
        if (recordingAntisnoreResponse == 3 || recordingAntisnoreResponse == 1) {
            responseClick(antiSnoringLoop);
        }
    }

    public void reset() {
        this.antisnoreLastOver = false;
        this.antisnoreCounter = 0;
    }

    public void update(boolean z) {
        if (this.doAntiSnore) {
            boolean z2 = this.antisnoreLastOver;
            if (z) {
                if (!z2) {
                    this.antisnoreCounter++;
                    this.antisnoreLastOver = true;
                }
            } else if (z2) {
                this.antisnoreCounter++;
                this.antisnoreLastOver = false;
            }
            if (this.antisnoreCounter > 20) {
                performResponse();
                this.antisnoreCounter = 0;
            }
        }
    }
}
