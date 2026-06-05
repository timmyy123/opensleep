package io.github.zeroone3010.yahueapi.v2.domain;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class LightLevel {

    @JsonProperty("light_level")
    private int lightLevel;

    @JsonProperty("light_level_valid")
    private boolean lightLevelValid;

    public int getLightLevel() {
        return this.lightLevel;
    }

    public boolean isLightLevelValid() {
        return this.lightLevelValid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LightLevel{lightLevel=");
        sb.append(this.lightLevel);
        sb.append(", lightLevelValid=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.lightLevelValid, '}');
    }
}
