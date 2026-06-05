package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Group;", "", "id", "", "name", "", "groupDevicesFirstLevel", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/GroupDevicesFirstLevel;", "on", "brightness", "<init>", "(ILjava/lang/String;Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/GroupDevicesFirstLevel;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getGroupDevicesFirstLevel", "()Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/GroupDevicesFirstLevel;", "getOn", "()Ljava/lang/Integer;", "setOn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBrightness", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Group {

    @SerializedName("5851")
    private final Integer brightness;

    @SerializedName("9018")
    private final GroupDevicesFirstLevel groupDevicesFirstLevel;

    @SerializedName("9003")
    private final int id;

    @SerializedName("9001")
    private final String name;

    @SerializedName("5850")
    private Integer on;

    public Group(int i, String str, GroupDevicesFirstLevel groupDevicesFirstLevel, Integer num, Integer num2) {
        str.getClass();
        groupDevicesFirstLevel.getClass();
        this.id = i;
        this.name = str;
        this.groupDevicesFirstLevel = groupDevicesFirstLevel;
        this.on = num;
        this.brightness = num2;
    }

    public final Integer getBrightness() {
        return this.brightness;
    }

    public final GroupDevicesFirstLevel getGroupDevicesFirstLevel() {
        return this.groupDevicesFirstLevel;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOn() {
        return this.on;
    }

    public final void setOn(Integer num) {
        this.on = num;
    }

    public /* synthetic */ Group(int i, String str, GroupDevicesFirstLevel groupDevicesFirstLevel, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, groupDevicesFirstLevel, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : num2);
    }
}
