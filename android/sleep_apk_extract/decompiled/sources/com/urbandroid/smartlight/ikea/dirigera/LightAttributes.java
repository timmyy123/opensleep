package com.urbandroid.smartlight.ikea.dirigera;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/smartlight/ikea/dirigera/LightAttributes;", "", "name", "", "isOn", "", "brightness", "", "colorTemp", "<init>", "(Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "()Z", "getBrightness", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColorTemp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/urbandroid/smartlight/ikea/dirigera/LightAttributes;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class LightAttributes {

    @SerializedName("lightLevel")
    private final Integer brightness;

    @SerializedName("colorTemperature")
    private final Integer colorTemp;

    @SerializedName("isOn")
    private final boolean isOn;

    @SerializedName("friendlyName")
    private final String name;

    public LightAttributes(String str, boolean z, Integer num, Integer num2) {
        str.getClass();
        this.name = str;
        this.isOn = z;
        this.brightness = num;
        this.colorTemp = num2;
    }

    public static /* synthetic */ LightAttributes copy$default(LightAttributes lightAttributes, String str, boolean z, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lightAttributes.name;
        }
        if ((i & 2) != 0) {
            z = lightAttributes.isOn;
        }
        if ((i & 4) != 0) {
            num = lightAttributes.brightness;
        }
        if ((i & 8) != 0) {
            num2 = lightAttributes.colorTemp;
        }
        return lightAttributes.copy(str, z, num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsOn() {
        return this.isOn;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getBrightness() {
        return this.brightness;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getColorTemp() {
        return this.colorTemp;
    }

    public final LightAttributes copy(String name, boolean isOn, Integer brightness, Integer colorTemp) {
        name.getClass();
        return new LightAttributes(name, isOn, brightness, colorTemp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LightAttributes)) {
            return false;
        }
        LightAttributes lightAttributes = (LightAttributes) other;
        return Intrinsics.areEqual(this.name, lightAttributes.name) && this.isOn == lightAttributes.isOn && Intrinsics.areEqual(this.brightness, lightAttributes.brightness) && Intrinsics.areEqual(this.colorTemp, lightAttributes.colorTemp);
    }

    public final Integer getBrightness() {
        return this.brightness;
    }

    public final Integer getColorTemp() {
        return this.colorTemp;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(this.isOn, this.name.hashCode() * 31, 31);
        Integer num = this.brightness;
        int iHashCode = (iM + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.colorTemp;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public String toString() {
        return "LightAttributes(name=" + this.name + ", isOn=" + this.isOn + ", brightness=" + this.brightness + ", colorTemp=" + this.colorTemp + ')';
    }

    public /* synthetic */ LightAttributes(String str, boolean z, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }
}
