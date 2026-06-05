package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/DeviceUpdater;", "", "states", "", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;", "<init>", "(Ljava/util/List;)V", "getStates", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DeviceUpdater {

    @SerializedName("3311")
    private final List<Device.State> states;

    public DeviceUpdater(List<Device.State> list) {
        list.getClass();
        this.states = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceUpdater copy$default(DeviceUpdater deviceUpdater, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deviceUpdater.states;
        }
        return deviceUpdater.copy(list);
    }

    public final List<Device.State> component1() {
        return this.states;
    }

    public final DeviceUpdater copy(List<Device.State> states) {
        states.getClass();
        return new DeviceUpdater(states);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeviceUpdater) && Intrinsics.areEqual(this.states, ((DeviceUpdater) other).states);
    }

    public final List<Device.State> getStates() {
        return this.states;
    }

    public int hashCode() {
        return this.states.hashCode();
    }

    public String toString() {
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder("DeviceUpdater(states="), (List) this.states, ')');
    }
}
