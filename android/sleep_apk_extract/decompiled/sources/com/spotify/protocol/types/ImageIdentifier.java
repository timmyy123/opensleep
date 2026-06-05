package com.spotify.protocol.types;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.protocol.types.Image;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class ImageIdentifier implements Item {

    @JsonProperty(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    public final int height;

    @JsonProperty("id")
    public final String id;

    @JsonProperty(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    public final int width;

    public ImageIdentifier(String str, Image.Dimension dimension) {
        this.id = str;
        this.width = dimension.getValue();
        this.height = dimension.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageIdentifier)) {
            return false;
        }
        ImageIdentifier imageIdentifier = (ImageIdentifier) obj;
        String str = this.id;
        String str2 = imageIdentifier.id;
        if (str == null ? str2 == null : str.equals(str2)) {
            return this.height == imageIdentifier.height && this.width == imageIdentifier.width;
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.height) * 31) + this.width;
    }
}
