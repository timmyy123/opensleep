package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class HueEventData {

    @JsonProperty("button")
    private ButtonSpecifics button;

    @JsonProperty("dimming")
    private Dimming dimming;

    @JsonProperty("id_v1")
    private String idV1;

    @JsonProperty("light")
    private LightLevel lightLevel;

    @JsonProperty("motion")
    private Motion motion;

    @JsonProperty("on")
    private On on;

    @JsonProperty("owner")
    private ResourceIdentifier owner;

    @JsonProperty("id")
    private UUID resourceId;

    @JsonProperty("temperature")
    private Temperature temperature;

    @JsonProperty("type")
    private String type;

    public Optional<ButtonSpecifics> getButton() {
        return Optional.ofNullable(this.button);
    }

    public Optional<Dimming> getDimming() {
        return Optional.ofNullable(this.dimming);
    }

    public String getIdV1() {
        return this.idV1;
    }

    public Optional<LightLevel> getLightLevel() {
        return Optional.ofNullable(this.lightLevel);
    }

    public Optional<Motion> getMotion() {
        return Optional.ofNullable(this.motion);
    }

    public Optional<On> getOn() {
        return Optional.ofNullable(this.on);
    }

    public ResourceIdentifier getOwner() {
        return this.owner;
    }

    public UUID getResourceId() {
        return this.resourceId;
    }

    public Optional<Temperature> getTemperature() {
        return Optional.ofNullable(this.temperature);
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "HueEventData{resourceId=" + this.resourceId + ", idV1='" + this.idV1 + "', owner=" + this.owner + ", type='" + this.type + "', button=" + this.button + ", lightLevel=" + this.lightLevel + ", on=" + this.on + ", dimming=" + this.dimming + ", motion=" + this.motion + ", temperature=" + this.temperature + '}';
    }
}
