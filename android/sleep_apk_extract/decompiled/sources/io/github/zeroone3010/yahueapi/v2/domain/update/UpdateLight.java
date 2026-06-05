package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateLight {

    @JsonProperty("alert")
    private Alert alert;

    @JsonProperty("color")
    private Color color;

    @JsonProperty("color_temperature")
    private ColorTemperature colorTemperature;

    @JsonProperty("color_temperature_delta")
    private ColorTemperatureDelta colorTemperatureDelta;

    @JsonProperty("dimming")
    private Dimming dimming;

    @JsonProperty("dimming_delta")
    private DimmingDelta dimmingDelta;

    @JsonProperty("dynamics")
    private Dynamics dynamics;

    @JsonProperty("effects")
    private Effects effects;

    @JsonProperty("gradient")
    private Gradient gradient;

    @JsonProperty("on")
    private On on;

    @JsonProperty("timed_effects")
    private TimedEffects timedEffects;

    public Alert getAlert() {
        return this.alert;
    }

    public Color getColor() {
        return this.color;
    }

    public ColorTemperature getColorTemperature() {
        return this.colorTemperature;
    }

    public ColorTemperatureDelta getColorTemperatureDelta() {
        return this.colorTemperatureDelta;
    }

    public Dimming getDimming() {
        return this.dimming;
    }

    public DimmingDelta getDimmingDelta() {
        return this.dimmingDelta;
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

    public On getOn() {
        return this.on;
    }

    public TimedEffects getTimedEffects() {
        return this.timedEffects;
    }

    public UpdateLight setAlert(Alert alert) {
        this.alert = alert;
        return this;
    }

    public UpdateLight setColor(Color color) {
        this.color = color;
        return this;
    }

    public UpdateLight setColorTemperature(ColorTemperature colorTemperature) {
        this.colorTemperature = colorTemperature;
        return this;
    }

    public void setColorTemperatureDelta(ColorTemperatureDelta colorTemperatureDelta) {
        this.colorTemperatureDelta = colorTemperatureDelta;
    }

    public UpdateLight setDimming(Dimming dimming) {
        this.dimming = dimming;
        return this;
    }

    public UpdateLight setDimmingDelta(DimmingDelta dimmingDelta) {
        this.dimmingDelta = dimmingDelta;
        return this;
    }

    public UpdateLight setDynamics(Dynamics dynamics) {
        this.dynamics = dynamics;
        return this;
    }

    public UpdateLight setEffects(Effects effects) {
        this.effects = effects;
        return this;
    }

    public UpdateLight setGradient(Gradient gradient) {
        this.gradient = gradient;
        return this;
    }

    public UpdateLight setOn(On on) {
        this.on = on;
        return this;
    }

    public UpdateLight setTimedEffects(TimedEffects timedEffects) {
        this.timedEffects = timedEffects;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
