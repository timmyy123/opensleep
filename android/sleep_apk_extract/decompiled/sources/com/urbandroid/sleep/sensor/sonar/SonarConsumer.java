package com.urbandroid.sleep.sensor.sonar;

/* JADX INFO: loaded from: classes4.dex */
public interface SonarConsumer {
    double getSignalStrength();

    Boolean getUltrasoundSupported();

    float resetLastActivity();

    float resetLastMax();

    void resetSignalStrength();
}
