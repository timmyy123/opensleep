package com.urbandroid.sleep.sensor.sonar;

/* JADX INFO: loaded from: classes4.dex */
public interface SonarProducer {

    public interface SoundStartListener {
        void onSoundStarted();
    }

    void play();

    void setSoundStartListener(SoundStartListener soundStartListener);

    void stop();
}
