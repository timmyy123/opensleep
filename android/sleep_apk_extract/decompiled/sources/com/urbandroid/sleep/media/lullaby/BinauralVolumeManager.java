package com.urbandroid.sleep.media.lullaby;

import android.media.AudioTrack;
import com.urbandroid.sleep.alarmclock.volume.IVolumeChangeListener;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes.dex */
public class BinauralVolumeManager implements IVolumeChangeListener {
    private AudioTrack audioTrack;
    private final float configurredVolume = SharedApplicationContext.getSettings().getBinauralVolume() / 100.0f;
    private boolean isMuted;
    private float lastVolume;

    public BinauralVolumeManager(AudioTrack audioTrack) {
        this.audioTrack = audioTrack;
    }

    public float getConfigurredVolume() {
        return this.configurredVolume;
    }

    public synchronized void mute() {
        AudioTrack audioTrack;
        if (!this.isMuted && (audioTrack = this.audioTrack) != null) {
            this.isMuted = true;
            audioTrack.setStereoVolume(0.0f, 0.0f);
        }
    }

    public synchronized void setVolume(float f) {
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            return;
        }
        this.lastVolume = f;
        if (!this.isMuted) {
            audioTrack.setStereoVolume(f, f);
        }
    }

    public synchronized void unmute() {
        try {
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack == null) {
                return;
            }
            if (this.isMuted) {
                float f = this.lastVolume;
                audioTrack.setStereoVolume(f, f);
            }
            this.isMuted = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeChangeListener
    public void volumeUpdated(float f) {
        setVolume(f * this.configurredVolume);
    }
}
