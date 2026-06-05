package io.github.zeroone3010.yahueapi.v2.domain.event;

import io.github.zeroone3010.yahueapi.v2.Button;
import io.github.zeroone3010.yahueapi.v2.ButtonEventType;
import io.github.zeroone3010.yahueapi.v2.Switch;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class ButtonEvent {
    private Button button;
    private UUID eventGroupId;
    private String eventTime;
    private ButtonEventType eventType;
    private Switch theSwitch;

    public ButtonEvent(String str, Switch r2, Button button, ButtonEventType buttonEventType, UUID uuid) {
        this.eventTime = str;
        this.theSwitch = r2;
        this.button = button;
        this.eventType = buttonEventType;
        this.eventGroupId = uuid;
    }

    public Button getButton() {
        return this.button;
    }

    public UUID getEventGroupId() {
        return this.eventGroupId;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public ButtonEventType getEventType() {
        return this.eventType;
    }

    public Switch getSwitch() {
        return this.theSwitch;
    }

    public String toString() {
        return "SwitchEvent{eventTime='" + this.eventTime + "', switch=" + this.theSwitch + ", button=" + this.button + ", eventType=" + this.eventType + ", eventGroupId=" + this.eventGroupId + '}';
    }
}
