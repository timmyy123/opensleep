package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda4;
import java.util.Objects;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public enum ButtonEventType {
    UNKNOWN(null),
    INITIAL_PRESS("initial_press"),
    HOLD("repeat"),
    LONG_PRESS("long_press"),
    SHORT_RELEASED("short_release"),
    LONG_RELEASED("long_release"),
    DOUBLE_SHORT_RELEASED("double_short_release");

    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ButtonEventType.class);
    private final String eventType;

    ButtonEventType(String str) {
        this.eventType = str;
    }

    private String getEventType() {
        return this.eventType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseFromButtonEventType$0(String str, ButtonEventType buttonEventType) {
        return Objects.equals(buttonEventType.getEventType(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ButtonEventType lambda$parseFromButtonEventType$1(String str) {
        logger.info("Unknown button event type '{}'", str);
        return UNKNOWN;
    }

    public static ButtonEventType parseFromButtonEventType(String str) {
        int i = 1;
        return (ButtonEventType) Stream.of((Object[]) values()).filter(new Hue$$ExternalSyntheticLambda31(str, i)).findFirst().orElseGet(new Color$$ExternalSyntheticLambda4(str, i));
    }
}
