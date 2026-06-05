package io.github.zeroone3010.yahueapi.v2.domain.event;

import io.github.zeroone3010.yahueapi.v2.Device;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class MotionEvent {
    private final UUID eventGroupId;
    private final String eventTime;
    private final boolean motion;
    private final boolean motionValid;
    private Device owner;

    public MotionEvent(String str, UUID uuid, Device device, boolean z, boolean z2) {
        this.eventTime = str;
        this.eventGroupId = uuid;
        this.owner = device;
        this.motion = z;
        this.motionValid = z2;
    }

    public UUID getEventGroupId() {
        return this.eventGroupId;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public Device getOwner() {
        return this.owner;
    }

    public boolean isMotion() {
        return this.motion;
    }

    public boolean isMotionValid() {
        return this.motionValid;
    }

    public String toString() {
        return "MotionEvent{eventTime='" + this.eventTime + "', eventGroupId=" + this.eventGroupId + ", motion=" + this.motion + ", motionValid=" + this.motionValid + ", owner=" + this.owner + '}';
    }
}
