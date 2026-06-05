package io.github.zeroone3010.yahueapi.v2.domain;

import com.facebook.internal.AnalyticsEvents;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.update.EffectType;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Effects {

    @JsonProperty("effect")
    private EffectType effect;

    @JsonProperty("effect_values")
    private List<EffectType> effectValues;

    @JsonProperty(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)
    private EffectType status;

    @JsonProperty("status_values")
    private List<EffectType> statusValues;

    public EffectType getEffect() {
        return this.effect;
    }

    public List<EffectType> getEffectValues() {
        return this.effectValues;
    }

    public EffectType getStatus() {
        return this.status;
    }

    public List<EffectType> getStatusValues() {
        return this.statusValues;
    }
}
