package io.github.zeroone3010.yahueapi.v2.domain;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes5.dex */
@JsonSubTypes({@JsonSubTypes.Type(name = "button", value = ButtonResource.class), @JsonSubTypes.Type(name = DeviceRequestsHelper.DEVICE_INFO_DEVICE, value = DeviceResource.class), @JsonSubTypes.Type(name = "light", value = LightResource.class), @JsonSubTypes.Type(name = "room", value = RoomResource.class), @JsonSubTypes.Type(name = "zone", value = ZoneResource.class), @JsonSubTypes.Type(name = "grouped_light", value = GroupedLightResource.class), @JsonSubTypes.Type(name = "scene", value = SceneResource.class), @JsonSubTypes.Type(name = "motion", value = MotionResource.class), @JsonSubTypes.Type(name = "temperature", value = TemperatureResource.class), @JsonSubTypes.Type(name = "bridge", value = BridgeResource.class)})
@JsonTypeInfo(defaultImpl = Resource.class, include = JsonTypeInfo.As.PROPERTY, property = "type", use = JsonTypeInfo.Id.NAME, visible = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Resource {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("id_v1")
    private String idV1;

    @JsonProperty("type")
    private ResourceType type;

    public UUID getId() {
        return this.id;
    }

    public String getIdV1() {
        return this.idV1;
    }

    public ResourceType getType() {
        return this.type;
    }

    public ResourceIdentifier identifier() {
        ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
        resourceIdentifier.setResourceId(this.id);
        resourceIdentifier.setResourceType(this.type);
        return resourceIdentifier;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
