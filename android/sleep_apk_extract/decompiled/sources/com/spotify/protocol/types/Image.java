package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Image implements Item {

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    @JsonProperty(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    public final int height;

    @SerializedName("image_data")
    @JsonProperty("image_data")
    public final byte[] imageData;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    @JsonProperty(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    public final int width;

    public enum Dimension {
        LARGE(720),
        MEDIUM(480),
        SMALL(360),
        X_SMALL(240),
        THUMBNAIL(144);

        private final int mValue;

        Dimension(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public Image(byte[] bArr, int i, int i2) {
        this.imageData = bArr;
        this.width = i;
        this.height = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Image)) {
            return false;
        }
        Image image = (Image) obj;
        if (this.width == image.width && this.height == image.height) {
            return Arrays.equals(this.imageData, image.imageData);
        }
        return false;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.imageData) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Image{imageData=");
        sb.append(Arrays.toString(this.imageData));
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.height, '}');
    }

    private Image() {
        this(null, 0, 0);
    }
}
