package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrossfadeState implements Item {

    @JsonProperty("duration")
    public int duration;

    @JsonProperty(IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED)
    public boolean isEnabled;

    public CrossfadeState(boolean z, int i) {
        this.isEnabled = z;
        this.duration = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CrossfadeState)) {
            return false;
        }
        CrossfadeState crossfadeState = (CrossfadeState) obj;
        return this.isEnabled == crossfadeState.isEnabled && this.duration == crossfadeState.duration;
    }

    public int hashCode() {
        return ((this.isEnabled ? 1 : 0) * 31) + this.duration;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CrossfadeState{isEnabled=");
        sb.append(this.isEnabled);
        sb.append(", duration=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.duration, '}');
    }
}
