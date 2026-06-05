package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Effects {

    @JsonProperty("effect")
    private EffectType effect;

    public EffectType getEffect() {
        return this.effect;
    }

    public Effects setEffect(EffectType effectType) {
        this.effect = effectType;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
