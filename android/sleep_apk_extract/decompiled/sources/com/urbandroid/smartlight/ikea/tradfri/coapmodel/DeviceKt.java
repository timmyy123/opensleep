package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0002\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"deviceType", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/DeviceType;", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device;", "getDeviceType", "(Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device;)Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/DeviceType;", "isLight", "", "isPlug", "isBlinder", "smartlight_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DeviceKt {
    public static final DeviceType getDeviceType(Device device) {
        device.getClass();
        if (device.getStates() != null) {
            return DeviceType.Light;
        }
        if (device.getBlinderStates() != null) {
            return DeviceType.Blinder;
        }
        if (device.getPlugStates() != null) {
            return DeviceType.Plug;
        }
        return null;
    }

    public static final boolean isBlinder(Device device) {
        device.getClass();
        return getDeviceType(device) == DeviceType.Blinder;
    }

    public static final boolean isLight(Device device) {
        device.getClass();
        return getDeviceType(device) == DeviceType.Light;
    }

    public static final boolean isPlug(Device device) {
        device.getClass();
        return getDeviceType(device) == DeviceType.Plug;
    }
}
