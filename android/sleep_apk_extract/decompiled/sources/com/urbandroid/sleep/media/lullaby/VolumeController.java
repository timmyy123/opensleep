package com.urbandroid.sleep.media.lullaby;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.VolumeUtil;

/* JADX INFO: loaded from: classes.dex */
public class VolumeController {
    private long currentTime;
    private float currentVolume;
    private String id;
    private boolean increasing;
    private long lastTime = System.currentTimeMillis();
    private long startVolume;
    private long stepTime;
    private float stepVolume;
    private long targetVolume;

    public VolumeController(String str, int i, int i2, long j, long j2) {
        this.increasing = true;
        this.id = str;
        this.targetVolume = i2;
        this.stepTime = j2;
        this.currentVolume = i;
        this.startVolume = i;
        float fMax = Math.max((j / j2) - 1.0f, 1.0f);
        long jAbs = Math.abs(i2 - i);
        this.stepVolume = Math.max(jAbs / fMax, 1.0f);
        Logger.logInfo(str + " VOL INIT steps " + fMax + " path " + jAbs + " stepVol " + this.stepVolume);
        this.increasing = i < i2;
    }

    public float getVolume() {
        Logger.logInfo(this.id + " VOL " + this.currentVolume);
        return VolumeUtil.getLogVolume(Math.round(this.currentVolume));
    }

    public boolean isIncreasing() {
        return this.increasing;
    }

    public void revert() {
        this.increasing = !this.increasing;
        long j = this.startVolume;
        this.startVolume = this.targetVolume;
        this.targetVolume = j;
        this.lastTime = System.currentTimeMillis();
        this.currentTime = 0L;
    }

    public boolean update() {
        boolean z = this.increasing;
        if ((z && this.currentVolume >= this.targetVolume) || (!z && this.currentVolume <= this.targetVolume)) {
            return false;
        }
        this.currentTime = (System.currentTimeMillis() + this.currentTime) - this.lastTime;
        this.lastTime = System.currentTimeMillis();
        long j = this.currentTime;
        long j2 = this.stepTime;
        if (j <= j2) {
            return false;
        }
        this.currentTime = j - j2;
        boolean z2 = this.increasing;
        float f = this.currentVolume;
        if (z2) {
            this.currentVolume = Math.min(f + this.stepVolume, this.targetVolume);
            return true;
        }
        this.currentVolume = Math.max(f - this.stepVolume, this.targetVolume);
        return true;
    }
}
