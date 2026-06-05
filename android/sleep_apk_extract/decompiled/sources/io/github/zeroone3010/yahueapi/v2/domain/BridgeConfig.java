package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes5.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class BridgeConfig {

    @JsonProperty("mac")
    private String mac;

    @JsonProperty("modelid")
    private String modelid;

    @JsonProperty("name")
    private String name;

    public String getMac() {
        return this.mac;
    }

    public String getModelid() {
        return this.modelid;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
