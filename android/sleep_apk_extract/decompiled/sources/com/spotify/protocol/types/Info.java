package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Info implements Item {

    @SerializedName(IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY)
    @JsonProperty(IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY)
    public final String category;

    @SerializedName("default_image_height")
    @JsonProperty("default_image_height")
    public final int defaultImageHeight;

    @SerializedName("default_image_width")
    @JsonProperty("default_image_width")
    public final int defaultImageWidth;

    @SerializedName("default_thumbnail_image_height")
    @JsonProperty("default_thumbnail_image_height")
    public final int defaultThumbnailImageHeight;

    @SerializedName("default_thumbnail_image_width")
    @JsonProperty("default_thumbnail_image_width")
    public final int defaultThumbnailImageWidth;

    @SerializedName("id")
    @JsonProperty("id")
    public final String id;

    @SerializedName("image_type")
    @JsonProperty("image_type")
    public final String imageType;

    @SerializedName(DeviceRequestsHelper.DEVICE_INFO_MODEL)
    @JsonProperty(DeviceRequestsHelper.DEVICE_INFO_MODEL)
    public final String model;

    @SerializedName("name")
    @JsonProperty("name")
    public final String name;

    @SerializedName("protocol_version")
    @JsonProperty("protocol_version")
    public final int protocolVersion;

    @SerializedName("required_features")
    @JsonProperty("required_features")
    public final List<String> requiredFeatures;

    @SerializedName("version")
    @JsonProperty("version")
    public final String version;

    public Info(int i, List<String> list, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, int i5) {
        this.protocolVersion = i;
        this.id = str;
        this.name = str2;
        this.model = str3;
        this.category = str4;
        this.version = str5;
        this.imageType = str6;
        this.requiredFeatures = list;
        this.defaultImageHeight = i3;
        this.defaultImageWidth = i2;
        this.defaultThumbnailImageHeight = i5;
        this.defaultThumbnailImageWidth = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Info)) {
            return false;
        }
        Info info = (Info) obj;
        if (this.protocolVersion != info.protocolVersion || this.defaultImageHeight != info.defaultImageHeight || this.defaultImageWidth != info.defaultImageWidth || this.defaultThumbnailImageHeight != info.defaultThumbnailImageHeight || this.defaultThumbnailImageWidth != info.defaultThumbnailImageWidth) {
            return false;
        }
        String str = this.id;
        String str2 = info.id;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.name;
        String str4 = info.name;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        String str5 = this.model;
        String str6 = info.model;
        if (str5 == null ? str6 != null : !str5.equals(str6)) {
            return false;
        }
        String str7 = this.category;
        String str8 = info.category;
        if (str7 == null ? str8 != null : !str7.equals(str8)) {
            return false;
        }
        String str9 = this.version;
        String str10 = info.version;
        if (str9 == null ? str10 != null : !str9.equals(str10)) {
            return false;
        }
        String str11 = this.imageType;
        String str12 = info.imageType;
        if (str11 == null ? str12 != null : !str11.equals(str12)) {
            return false;
        }
        List<String> list = this.requiredFeatures;
        List<String> list2 = info.requiredFeatures;
        return list == null ? list2 == null : list.equals(list2);
    }

    public int hashCode() {
        int i = this.protocolVersion * 31;
        String str = this.id;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.model;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.category;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.version;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageType;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<String> list = this.requiredFeatures;
        return ((((((((iHashCode6 + (list != null ? list.hashCode() : 0)) * 31) + this.defaultImageHeight) * 31) + this.defaultImageWidth) * 31) + this.defaultThumbnailImageHeight) * 31) + this.defaultThumbnailImageWidth;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Info{protocolVersion=");
        sb.append(this.protocolVersion);
        sb.append(", id='");
        sb.append(this.id);
        sb.append("', name='");
        sb.append(this.name);
        sb.append("', model='");
        sb.append(this.model);
        sb.append("', category='");
        sb.append(this.category);
        sb.append("', version='");
        sb.append(this.version);
        sb.append("', imageType='");
        sb.append(this.imageType);
        sb.append("', requiredFeatures=");
        sb.append(this.requiredFeatures);
        sb.append(", defaultImageHeight=");
        sb.append(this.defaultImageHeight);
        sb.append(", defaultImageWidth=");
        sb.append(this.defaultImageWidth);
        sb.append(", defaultThumbnailImageHeight=");
        sb.append(this.defaultThumbnailImageHeight);
        sb.append(", defaultThumbnailImageWidth=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.defaultThumbnailImageWidth, '}');
    }

    private Info() {
        this(0, null, null, null, null, null, null, null, 0, 0, 0, 0);
    }
}
