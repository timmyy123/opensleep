package com.urbandroid.smartlight.ikea.dirigera;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/smartlight/ikea/dirigera/DirigeraDevice;", "", "id", "", "type", "attributes", "Lcom/urbandroid/smartlight/ikea/dirigera/LightAttributes;", "capabilities", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbandroid/smartlight/ikea/dirigera/LightAttributes;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getType", "getAttributes", "()Lcom/urbandroid/smartlight/ikea/dirigera/LightAttributes;", "getCapabilities", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DirigeraDevice {
    private final LightAttributes attributes;
    private final Map<String, Object> capabilities;
    private final String id;
    private final String type;

    public DirigeraDevice(String str, String str2, LightAttributes lightAttributes, Map<String, ? extends Object> map) {
        str.getClass();
        str2.getClass();
        lightAttributes.getClass();
        this.id = str;
        this.type = str2;
        this.attributes = lightAttributes;
        this.capabilities = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DirigeraDevice copy$default(DirigeraDevice dirigeraDevice, String str, String str2, LightAttributes lightAttributes, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dirigeraDevice.id;
        }
        if ((i & 2) != 0) {
            str2 = dirigeraDevice.type;
        }
        if ((i & 4) != 0) {
            lightAttributes = dirigeraDevice.attributes;
        }
        if ((i & 8) != 0) {
            map = dirigeraDevice.capabilities;
        }
        return dirigeraDevice.copy(str, str2, lightAttributes, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LightAttributes getAttributes() {
        return this.attributes;
    }

    public final Map<String, Object> component4() {
        return this.capabilities;
    }

    public final DirigeraDevice copy(String id, String type, LightAttributes attributes, Map<String, ? extends Object> capabilities) {
        id.getClass();
        type.getClass();
        attributes.getClass();
        return new DirigeraDevice(id, type, attributes, capabilities);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirigeraDevice)) {
            return false;
        }
        DirigeraDevice dirigeraDevice = (DirigeraDevice) other;
        return Intrinsics.areEqual(this.id, dirigeraDevice.id) && Intrinsics.areEqual(this.type, dirigeraDevice.type) && Intrinsics.areEqual(this.attributes, dirigeraDevice.attributes) && Intrinsics.areEqual(this.capabilities, dirigeraDevice.capabilities);
    }

    public final LightAttributes getAttributes() {
        return this.attributes;
    }

    public final Map<String, Object> getCapabilities() {
        return this.capabilities;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = (this.attributes.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.type)) * 31;
        Map<String, Object> map = this.capabilities;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "DirigeraDevice(id=" + this.id + ", type=" + this.type + ", attributes=" + this.attributes + ", capabilities=" + this.capabilities + ')';
    }

    public /* synthetic */ DirigeraDevice(String str, String str2, LightAttributes lightAttributes, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, lightAttributes, (i & 8) != 0 ? null : map);
    }
}
