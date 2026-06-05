package com.philips.lighting.hue.sdk.util;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueCountTimer {
    private PHHueCountTimerListener phHueCountListener;
    private long timeoutInMs;
    private Timer timer;
    private long lastTick = 0;
    private long currentTick = 0;
    private boolean isRunning = true;

    public class HueCountTimerTask extends TimerTask {
        public HueCountTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            long j = PHHueCountTimer.this.currentTick;
            long j2 = PHHueCountTimer.this.timeoutInMs;
            PHHueCountTimer pHHueCountTimer = PHHueCountTimer.this;
            if (j < j2) {
                pHHueCountTimer.lastTick = System.currentTimeMillis();
                PHHueCountTimer.this.phHueCountListener.onTick();
            } else {
                pHHueCountTimer.phHueCountListener.onFinish();
            }
            cancel();
        }
    }

    public PHHueCountTimer(long j, PHHueCountTimerListener pHHueCountTimerListener) {
        this.timeoutInMs = j;
        this.phHueCountListener = pHHueCountTimerListener;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void restart(long j) {
        this.currentTick = this.currentTick + (System.currentTimeMillis() - this.lastTick) + j;
        start(j);
    }

    public void start(long j) {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.schedule(new HueCountTimerTask(), j);
    }

    public void stop() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.isRunning = false;
    }
}
