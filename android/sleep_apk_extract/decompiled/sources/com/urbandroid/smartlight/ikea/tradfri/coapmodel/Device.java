package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0004'()*BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003J]\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006+"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device;", "", "id", "", "name", "", "type", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$Type;", "states", "", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;", "blinderStates", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$BlinderState;", "plugStates", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$PlugState;", "<init>", "(ILjava/lang/String;Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$Type;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getType", "()Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$Type;", "getStates", "()Ljava/util/List;", "getBlinderStates", "getPlugStates", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "Type", "State", "BlinderState", "PlugState", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class Device {

    @SerializedName("15015")
    private final List<BlinderState> blinderStates;

    @SerializedName("9003")
    private final int id;

    @SerializedName("9001")
    private final String name;

    @SerializedName("3312")
    private final List<PlugState> plugStates;

    @SerializedName("3311")
    private final List<State> states;

    @SerializedName("3")
    private final Type type;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$Type;", "", "manufacturer", "", "name", "version", "battery", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "getManufacturer", "()Ljava/lang/String;", "getName", "getVersion", "getBattery", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$Type;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Type {

        @SerializedName("9")
        private final Float battery;

        @SerializedName(AppEventsConstants.EVENT_PARAM_VALUE_NO)
        private final String manufacturer;

        @SerializedName(AppEventsConstants.EVENT_PARAM_VALUE_YES)
        private final String name;

        @SerializedName("3")
        private final String version;

        public Type(String str, String str2, String str3, Float f) {
            Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
            this.manufacturer = str;
            this.name = str2;
            this.version = str3;
            this.battery = f;
        }

        public static /* synthetic */ Type copy$default(Type type, String str, String str2, String str3, Float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = type.manufacturer;
            }
            if ((i & 2) != 0) {
                str2 = type.name;
            }
            if ((i & 4) != 0) {
                str3 = type.version;
            }
            if ((i & 8) != 0) {
                f = type.battery;
            }
            return type.copy(str, str2, str3, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getManufacturer() {
            return this.manufacturer;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Float getBattery() {
            return this.battery;
        }

        public final Type copy(String manufacturer, String name, String version, Float battery) {
            manufacturer.getClass();
            name.getClass();
            version.getClass();
            return new Type(manufacturer, name, version, battery);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Type)) {
                return false;
            }
            Type type = (Type) other;
            return Intrinsics.areEqual(this.manufacturer, type.manufacturer) && Intrinsics.areEqual(this.name, type.name) && Intrinsics.areEqual(this.version, type.version) && Intrinsics.areEqual((Object) this.battery, (Object) type.battery);
        }

        public final Float getBattery() {
            return this.battery;
        }

        public final String getManufacturer() {
            return this.manufacturer;
        }

        public final String getName() {
            return this.name;
        }

        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.manufacturer.hashCode() * 31, 31, this.name), 31, this.version);
            Float f = this.battery;
            return iM + (f == null ? 0 : f.hashCode());
        }

        public String toString() {
            return "Type(manufacturer=" + this.manufacturer + ", name=" + this.name + ", version=" + this.version + ", battery=" + this.battery + ')';
        }
    }

    public Device(int i, String str, Type type, List<State> list, List<BlinderState> list2, List<PlugState> list3) {
        str.getClass();
        type.getClass();
        this.id = i;
        this.name = str;
        this.type = type;
        this.states = list;
        this.blinderStates = list2;
        this.plugStates = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Device copy$default(Device device, int i, String str, Type type, List list, List list2, List list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = device.id;
        }
        if ((i2 & 2) != 0) {
            str = device.name;
        }
        if ((i2 & 4) != 0) {
            type = device.type;
        }
        if ((i2 & 8) != 0) {
            list = device.states;
        }
        if ((i2 & 16) != 0) {
            list2 = device.blinderStates;
        }
        if ((i2 & 32) != 0) {
            list3 = device.plugStates;
        }
        List list4 = list2;
        List list5 = list3;
        return device.copy(i, str, type, list, list4, list5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final List<State> component4() {
        return this.states;
    }

    public final List<BlinderState> component5() {
        return this.blinderStates;
    }

    public final List<PlugState> component6() {
        return this.plugStates;
    }

    public final Device copy(int id, String name, Type type, List<State> states, List<BlinderState> blinderStates, List<PlugState> plugStates) {
        name.getClass();
        type.getClass();
        return new Device(id, name, type, states, blinderStates, plugStates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Device)) {
            return false;
        }
        Device device = (Device) other;
        return this.id == device.id && Intrinsics.areEqual(this.name, device.name) && Intrinsics.areEqual(this.type, device.type) && Intrinsics.areEqual(this.states, device.states) && Intrinsics.areEqual(this.blinderStates, device.blinderStates) && Intrinsics.areEqual(this.plugStates, device.plugStates);
    }

    public final List<BlinderState> getBlinderStates() {
        return this.blinderStates;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PlugState> getPlugStates() {
        return this.plugStates;
    }

    public final List<State> getStates() {
        return this.states;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = (this.type.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(Integer.hashCode(this.id) * 31, 31, this.name)) * 31;
        List<State> list = this.states;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<BlinderState> list2 = this.blinderStates;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<PlugState> list3 = this.plugStates;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Device(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", states=");
        sb.append(this.states);
        sb.append(", blinderStates=");
        sb.append(this.blinderStates);
        sb.append(", plugStates=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.plugStates, ')');
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$BlinderState;", "", "position", "", "<init>", "(Ljava/lang/Float;)V", "getPosition", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "copy", "(Ljava/lang/Float;)Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$BlinderState;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class BlinderState {

        @SerializedName("5536")
        private final Float position;

        public /* synthetic */ BlinderState(Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : f);
        }

        public static /* synthetic */ BlinderState copy$default(BlinderState blinderState, Float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = blinderState.position;
            }
            return blinderState.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Float getPosition() {
            return this.position;
        }

        public final BlinderState copy(Float position) {
            return new BlinderState(position);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BlinderState) && Intrinsics.areEqual((Object) this.position, (Object) ((BlinderState) other).position);
        }

        public final Float getPosition() {
            return this.position;
        }

        public int hashCode() {
            Float f = this.position;
            if (f == null) {
                return 0;
            }
            return f.hashCode();
        }

        public String toString() {
            return "BlinderState(position=" + this.position + ')';
        }

        public BlinderState(Float f) {
            this.position = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BlinderState() {
            this(null, 1, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$PlugState;", "", "on", "", "brightness", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getOn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$PlugState;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PlugState {

        @SerializedName("5851")
        private final Integer brightness;

        @SerializedName("5850")
        private final Integer on;

        public /* synthetic */ PlugState(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
        }

        public static /* synthetic */ PlugState copy$default(PlugState plugState, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = plugState.on;
            }
            if ((i & 2) != 0) {
                num2 = plugState.brightness;
            }
            return plugState.copy(num, num2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getOn() {
            return this.on;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getBrightness() {
            return this.brightness;
        }

        public final PlugState copy(Integer on, Integer brightness) {
            return new PlugState(on, brightness);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlugState)) {
                return false;
            }
            PlugState plugState = (PlugState) other;
            return Intrinsics.areEqual(this.on, plugState.on) && Intrinsics.areEqual(this.brightness, plugState.brightness);
        }

        public final Integer getBrightness() {
            return this.brightness;
        }

        public final Integer getOn() {
            return this.on;
        }

        public int hashCode() {
            Integer num = this.on;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.brightness;
            return iHashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "PlugState(on=" + this.on + ", brightness=" + this.brightness + ')';
        }

        public PlugState(Integer num, Integer num2) {
            this.on = num;
            this.brightness = num2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PlugState() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\r¨\u0006$"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;", "", "on", "", "color", "", "colorX", "colorY", "brightness", "transitionInCentiSeconds", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getOn", "()Ljava/lang/Integer;", "setOn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getColor", "()Ljava/lang/String;", "getColorX", "getColorY", "getBrightness", "getTransitionInCentiSeconds", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class State {

        @SerializedName("5851")
        private final Integer brightness;

        @SerializedName("5706")
        private final String color;

        @SerializedName("5709")
        private final Integer colorX;

        @SerializedName("5710")
        private final Integer colorY;

        @SerializedName("5850")
        private Integer on;

        @SerializedName("5712")
        private final Integer transitionInCentiSeconds;

        public /* synthetic */ State(Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5);
        }

        public static /* synthetic */ State copy$default(State state, Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, int i, Object obj) {
            if ((i & 1) != 0) {
                num = state.on;
            }
            if ((i & 2) != 0) {
                str = state.color;
            }
            if ((i & 4) != 0) {
                num2 = state.colorX;
            }
            if ((i & 8) != 0) {
                num3 = state.colorY;
            }
            if ((i & 16) != 0) {
                num4 = state.brightness;
            }
            if ((i & 32) != 0) {
                num5 = state.transitionInCentiSeconds;
            }
            Integer num6 = num4;
            Integer num7 = num5;
            return state.copy(num, str, num2, num3, num6, num7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getOn() {
            return this.on;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getColorX() {
            return this.colorX;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getColorY() {
            return this.colorY;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getBrightness() {
            return this.brightness;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getTransitionInCentiSeconds() {
            return this.transitionInCentiSeconds;
        }

        public final State copy(Integer on, String color, Integer colorX, Integer colorY, Integer brightness, Integer transitionInCentiSeconds) {
            return new State(on, color, colorX, colorY, brightness, transitionInCentiSeconds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.on, state.on) && Intrinsics.areEqual(this.color, state.color) && Intrinsics.areEqual(this.colorX, state.colorX) && Intrinsics.areEqual(this.colorY, state.colorY) && Intrinsics.areEqual(this.brightness, state.brightness) && Intrinsics.areEqual(this.transitionInCentiSeconds, state.transitionInCentiSeconds);
        }

        public final Integer getBrightness() {
            return this.brightness;
        }

        public final String getColor() {
            return this.color;
        }

        public final Integer getColorX() {
            return this.colorX;
        }

        public final Integer getColorY() {
            return this.colorY;
        }

        public final Integer getOn() {
            return this.on;
        }

        public final Integer getTransitionInCentiSeconds() {
            return this.transitionInCentiSeconds;
        }

        public int hashCode() {
            Integer num = this.on;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.color;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.colorX;
            int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.colorY;
            int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.brightness;
            int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.transitionInCentiSeconds;
            return iHashCode5 + (num5 != null ? num5.hashCode() : 0);
        }

        public final void setOn(Integer num) {
            this.on = num;
        }

        public String toString() {
            return "State(on=" + this.on + ", color=" + this.color + ", colorX=" + this.colorX + ", colorY=" + this.colorY + ", brightness=" + this.brightness + ", transitionInCentiSeconds=" + this.transitionInCentiSeconds + ')';
        }

        public State(Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5) {
            this.on = num;
            this.color = str;
            this.colorX = num2;
            this.colorY = num3;
            this.brightness = num4;
            this.transitionInCentiSeconds = num5;
        }

        public State() {
            this(null, null, null, null, null, null, 63, null);
        }
    }
}
