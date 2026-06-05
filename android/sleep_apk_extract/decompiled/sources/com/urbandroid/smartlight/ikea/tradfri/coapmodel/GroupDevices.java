package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/GroupDevices;", "", "deviceIds", "", "", "<init>", "(Ljava/util/List;)V", "getDeviceIds", "()Ljava/util/List;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroupDevices {

    @SerializedName("9003")
    private final List<Integer> deviceIds;

    public GroupDevices(List<Integer> list) {
        list.getClass();
        this.deviceIds = list;
    }

    public final List<Integer> getDeviceIds() {
        return this.deviceIds;
    }
}
