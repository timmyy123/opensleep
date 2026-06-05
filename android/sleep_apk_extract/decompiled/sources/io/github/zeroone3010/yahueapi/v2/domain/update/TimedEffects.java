package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.Hue$$ExternalSyntheticLambda4;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;
import j$.time.Duration;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimedEffects {
    private static final long MAX_DURATION_MILLISECONDS = 21600000;

    @JsonProperty("duration")
    private long duration;

    @JsonProperty("effect")
    private TimedEffectType effect;

    public long getDuration() {
        return this.duration;
    }

    public TimedEffectType getEffect() {
        return this.effect;
    }

    public TimedEffects setDuration(Duration duration) {
        this.duration = Math.min(((Long) Optional.ofNullable(duration).map(new Hue$$ExternalSyntheticLambda4(25)).orElse(0L)).longValue(), MAX_DURATION_MILLISECONDS);
        return this;
    }

    public TimedEffects setEffect(TimedEffectType timedEffectType) {
        this.effect = timedEffectType;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
