package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/* JADX INFO: loaded from: classes5.dex */
@JsonTypeName("light")
public class LightResource extends Resource {

    @JsonProperty("alert")
    private Alert alert;

    @JsonProperty("color")
    private Color color;

    @JsonProperty("color_temperature")
    private ColorTemperature colorTemperature;

    @JsonProperty("dimming")
    private Dimming dimming;

    @JsonProperty("dynamics")
    private Dynamics dynamics;

    @JsonProperty("effects")
    private Effects effects;

    @JsonProperty("gradient")
    private Gradient gradient;

    @JsonProperty("metadata")
    private Metadata metadata;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("on")
    private On on;

    @JsonProperty("owner")
    private ResourceIdentifier owner;

    public Alert getAlert() {
        return this.alert;
    }

    public Color getColor() {
        return this.color;
    }

    public ColorTemperature getColorTemperature() {
        return this.colorTemperature;
    }

    public Dimming getDimming() {
        return this.dimming;
    }

    public Dynamics getDynamics() {
        return this.dynamics;
    }

    public Effects getEffects() {
        return this.effects;
    }

    public Gradient getGradient() {
        return this.gradient;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public String getMode() {
        return this.mode;
    }

    public On getOn() {
        return this.on;
    }

    public ResourceIdentifier getOwner() {
        return this.owner;
    }
}
