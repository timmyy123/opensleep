package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonValue;

/* JADX INFO: loaded from: classes5.dex */
public enum ResourceType {
    DEVICE,
    BRIDGE_HOME,
    ROOM,
    ZONE,
    LIGHT,
    BUTTON,
    TEMPERATURE,
    LIGHT_LEVEL,
    MOTION,
    ENTERTAINMENT,
    GROUPED_LIGHT,
    DEVICE_POWER,
    ZIGBEE_BRIDGE_CONNECTIVITY,
    ZIGBEE_CONNECTIVITY,
    ZGP_CONNECTIVITY,
    BRIDGE,
    HOMEKIT,
    SCENE,
    ENTERTAINMENT_CONFIGURATION,
    PUBLIC_IMAGE,
    AUTH_V1,
    BEHAVIOR_SCRIPT,
    BEHAVIOR_INSTANCE,
    GEOFENCE,
    GEOFENCE_CLIENT,
    GEOLOCATION,
    UNKNOWN;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
