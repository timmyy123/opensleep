package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.HueEvent;
import io.github.zeroone3010.yahueapi.v2.domain.event.ButtonEvent;
import io.github.zeroone3010.yahueapi.v2.domain.event.MotionEvent;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface HueEventListener {
    default void connectionClosed() {
    }

    default void connectionOpened() {
    }

    default void receive(List<HueEvent> list) {
    }

    default void receiveButtonEvent(ButtonEvent buttonEvent) {
    }

    default void receiveMotionEvent(MotionEvent motionEvent) {
    }
}
