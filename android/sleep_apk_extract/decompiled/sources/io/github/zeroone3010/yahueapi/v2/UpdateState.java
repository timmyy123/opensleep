package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.XAndYAndBrightness;
import io.github.zeroone3010.yahueapi.v2.domain.Xy;
import io.github.zeroone3010.yahueapi.v2.domain.update.Alert;
import io.github.zeroone3010.yahueapi.v2.domain.update.AlertType;
import io.github.zeroone3010.yahueapi.v2.domain.update.Color;
import io.github.zeroone3010.yahueapi.v2.domain.update.Dimming;
import io.github.zeroone3010.yahueapi.v2.domain.update.EffectType;
import io.github.zeroone3010.yahueapi.v2.domain.update.Effects;
import io.github.zeroone3010.yahueapi.v2.domain.update.Gradient;
import io.github.zeroone3010.yahueapi.v2.domain.update.GradientPoint;
import io.github.zeroone3010.yahueapi.v2.domain.update.On;
import io.github.zeroone3010.yahueapi.v2.domain.update.TimedEffectType;
import io.github.zeroone3010.yahueapi.v2.domain.update.TimedEffects;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateLight;
import j$.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes5.dex */
public class UpdateState {
    public static final int LOWEST_POSSIBLE_BRIGHTNESS = 0;
    public static final int MAX_BRIGHTNESS = 100;
    private final UpdateLight updateLight = new UpdateLight();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Color lambda$gradient$0(io.github.zeroone3010.yahueapi.Color color) {
        XAndYAndBrightness xAndYAndBrightnessRgbToXy = XAndYAndBrightness.rgbToXy(color);
        return new Color().setXy(new Xy().setX(xAndYAndBrightnessRgbToXy.getX()).setY(xAndYAndBrightnessRgbToXy.getY()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ GradientPoint lambda$gradient$1(Color color) {
        return new GradientPoint().setColor(color);
    }

    public UpdateState alert() {
        this.updateLight.setAlert(new Alert().setAction(AlertType.BREATHE));
        return this;
    }

    public UpdateState brightness(int i) {
        this.updateLight.setDimming(new Dimming().setBrightness(Math.min(Math.max(i, 0), 100)));
        return this;
    }

    public UpdateState clearTimedEffect() {
        timedEffect(TimedEffectType.NO_EFFECT, null);
        return this;
    }

    public UpdateState color(io.github.zeroone3010.yahueapi.Color color) {
        XAndYAndBrightness xAndYAndBrightnessRgbToXy = XAndYAndBrightness.rgbToXy(color);
        this.updateLight.setColor(new Color().setXy(new Xy().setX(xAndYAndBrightnessRgbToXy.getX()).setY(xAndYAndBrightnessRgbToXy.getY()))).setDimming(new Dimming().setBrightness(xAndYAndBrightnessRgbToXy.getBrightnessMax100()));
        return this;
    }

    public UpdateState effect(EffectType effectType) {
        this.updateLight.setEffects(new Effects().setEffect(effectType));
        return this;
    }

    public UpdateLight getUpdateLight() {
        return this.updateLight;
    }

    public UpdateState gradient(List<io.github.zeroone3010.yahueapi.Color> list) {
        this.updateLight.setGradient(new Gradient().setPoints((List) list.stream().map(new Hue$$ExternalSyntheticLambda4(23)).map(new Hue$$ExternalSyntheticLambda4(24)).collect(Collectors.toList())));
        return this;
    }

    public UpdateState off() {
        this.updateLight.setOn(On.OFF);
        return this;
    }

    public UpdateState on(boolean z) {
        this.updateLight.setOn(z ? On.ON : On.OFF);
        return this;
    }

    public UpdateState sunrise(Duration duration) {
        timedEffect(TimedEffectType.SUNRISE, duration);
        return this;
    }

    public UpdateState timedEffect(TimedEffectType timedEffectType, Duration duration) {
        this.updateLight.setTimedEffects(new TimedEffects().setDuration(duration).setEffect(timedEffectType));
        return this;
    }

    public UpdateState xy(float f, float f2) {
        this.updateLight.setColor(new Color().setXy(new Xy().setX(f).setY(f2)));
        return this;
    }

    public UpdateState on() {
        this.updateLight.setOn(On.ON);
        return this;
    }
}
