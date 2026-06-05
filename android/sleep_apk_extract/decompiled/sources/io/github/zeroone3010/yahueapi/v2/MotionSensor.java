package io.github.zeroone3010.yahueapi.v2;

import j$.time.ZonedDateTime;

/* JADX INFO: loaded from: classes5.dex */
public interface MotionSensor extends Device {
    ZonedDateTime getLastChanged();

    boolean isMotion();
}
