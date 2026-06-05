package com.urbandroid.smartlight.common.mapper;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Color;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import com.urbandroid.smartlight.common.model.StateKt;
import com.urbandroid.smartlight.ikea.tradfri.Client;
import com.urbandroid.smartlight.ikea.tradfri.DeviceType;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0001\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\t\u001a\n\u0010\f\u001a\u00020\r*\u00020\t\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0010\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0011*\u00020\u000f\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0015\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0016\u001a\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0014¨\u0006\u0018"}, d2 = {"toLight", "Lcom/urbandroid/smartlight/common/model/Light;", "Lcom/philips/lighting/model/PHLight;", "toHueLight", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device;", "toTradfriDevice", "toLightId", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$LightId;", "toHueState", "Lcom/philips/lighting/model/PHLightState;", "Lcom/urbandroid/smartlight/common/model/State;", "toState", "toLogString", "", "toNativeGateway", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "Lcom/urbandroid/smartlight/common/model/Gateway$Tradfri;", "toCommonGateway", "toAccessPoint", "Lcom/philips/lighting/hue/sdk/PHAccessPoint;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Hue;", "Lcom/urbandroid/smartlight/common/model/Gateway$Hue;", "toGateway", "smartlight_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MappersKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PHLight.PHLightType.valuesCustom().length];
            try {
                iArr[PHLight.PHLightType.COLOR_LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PHLight.PHLightType.CT_COLOR_LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PHLight.PHLightType.CT_LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PHLight.PHLightType.DIM_LIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PHLight.PHLightType.ON_OFF_LIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PHLight.PHLightType.UNKNOWN_LIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Light.Type.values().length];
            try {
                iArr2[Light.Type.COLOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Light.Type.CT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Light.Type.DIM.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[Light.Type.SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Light.Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final PHAccessPoint toAccessPoint(AuthenticatedGateway.Hue hue) {
        hue.getClass();
        PHAccessPoint pHAccessPoint = new PHAccessPoint(hue.getIp(), hue.getUserName(), hue.getMac());
        pHAccessPoint.setBridgeId(hue.getId());
        return pHAccessPoint;
    }

    public static final Gateway.Tradfri toCommonGateway(Tradfri.Gateway gateway) {
        gateway.getClass();
        return new Gateway.Tradfri(gateway.getName(), gateway.getIp(), gateway.getPort(), null, 8, null);
    }

    public static final Gateway.Hue toGateway(PHAccessPoint pHAccessPoint) {
        pHAccessPoint.getClass();
        String bridgeId = pHAccessPoint.getBridgeId();
        bridgeId.getClass();
        String macAddress = pHAccessPoint.getMacAddress();
        String ipAddress = pHAccessPoint.getIpAddress();
        ipAddress.getClass();
        Gateway.Hue hue = new Gateway.Hue(bridgeId, ipAddress, macAddress);
        Logger.logInfo("AccessPoint " + pHAccessPoint.getBridgeId() + ' ' + pHAccessPoint.getIpAddress() + ' ' + pHAccessPoint.getMacAddress(), null);
        return hue;
    }

    public static final PHLight toHueLight(Light light) {
        light.getClass();
        PHLight pHLight = new PHLight(light.getName(), light.getId(), light.getVersion(), light.getModel());
        int i = WhenMappings.$EnumSwitchMapping$1[light.getType().ordinal()];
        String str = null;
        if (i != 1) {
            if (i == 2) {
                str = "ct light";
            } else if (i == 3) {
                str = "dimmable light";
            } else if (i == 4) {
                str = "on/off light";
            } else if (i != 5) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
        }
        pHLight.setLightType(str);
        return pHLight;
    }

    public static final PHLightState toHueState(State state) {
        state.getClass();
        PHLightState pHLightState = new PHLightState();
        pHLightState.setTransitionTime(Integer.valueOf(state.getTransitionMs() / 100));
        if (state.getColor() != null) {
            Color color = state.getColor();
            if (color instanceof Color.Hsv) {
                pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION);
                Color.Hsv hsv = (Color.Hsv) state.getColor();
                pHLightState.setSaturation(Integer.valueOf(hsv.getSaturation()));
                pHLightState.setHue(Integer.valueOf(hsv.getHue()));
                pHLightState.setBrightness(Integer.valueOf(hsv.getValue()));
            } else if (color instanceof Color.Brightness) {
                pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION);
                pHLightState.setBrightness(Integer.valueOf(((Color.Brightness) state.getColor()).getBrightness()));
            } else if (color instanceof Color.Hsb) {
                pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION);
                Color.Hsb hsb = (Color.Hsb) state.getColor();
                pHLightState.setSaturation(Integer.valueOf(hsb.getSaturation()));
                pHLightState.setHue(Integer.valueOf(hsb.getHue()));
                pHLightState.setBrightness(Integer.valueOf(hsb.getBrightness()));
                pHLightState.setCt(Integer.valueOf(hsb.getCt()));
            } else {
                Color.D65 d65AsD65 = state.getColor().asD65();
                pHLightState.setX(Float.valueOf(d65AsD65.getX() / 65535.0f));
                pHLightState.setY(Float.valueOf(d65AsD65.getY() / 65535.0f));
                pHLightState.setBrightness(d65AsD65.getZ());
                pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_XY);
            }
        }
        pHLightState.setOn(StateKt.toBooleanOrNull(state.getSwitch()));
        return pHLightState;
    }

    public static final Light toLight(PHLight pHLight) {
        Light.Type type;
        pHLight.getClass();
        String identifier = pHLight.getIdentifier();
        identifier.getClass();
        String name = pHLight.getName();
        name.getClass();
        PHLight.PHLightType lightType = pHLight.getLightType();
        switch (lightType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lightType.ordinal()]) {
            case -1:
                type = Light.Type.UNKNOWN;
                break;
            case 0:
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            case 1:
                type = Light.Type.COLOR;
                break;
            case 2:
                type = Light.Type.COLOR;
                break;
            case 3:
                type = Light.Type.CT;
                break;
            case 4:
                type = Light.Type.DIM;
                break;
            case 5:
                type = Light.Type.SWITCH;
                break;
            case 6:
                type = Light.Type.UNKNOWN;
                break;
        }
        Light light = new Light(identifier, name, type);
        light.setModel(pHLight.getModelNumber());
        light.setVersion(pHLight.getVersionNumber());
        return light;
    }

    public static final Client.Authenticated.LightId toLightId(Light light) {
        light.getClass();
        return new Client.Authenticated.LightId(Integer.parseInt(light.getId()), light.getType());
    }

    public static final String toLogString(PHLightState pHLightState) {
        pHLightState.getClass();
        return "HueState H:" + pHLightState.getHue() + " S:" + pHLightState.getSaturation() + " V:" + pHLightState.getBrightness() + " CT:" + pHLightState.getCt() + " X:" + pHLightState.getX() + " Y:" + pHLightState.getY() + " MODE=" + pHLightState.getColorMode() + " TRANS=" + pHLightState.getTransitionTime() + " ON=" + pHLightState.isOn();
    }

    public static final Tradfri.Gateway toNativeGateway(AuthenticatedGateway.Tradfri tradfri) {
        tradfri.getClass();
        return new Tradfri.Gateway(tradfri.getId(), tradfri.getIp(), tradfri.getPort());
    }

    public static final State toState(PHLightState pHLightState) {
        pHLightState.getClass();
        Integer ct = (pHLightState.getCt() == null || pHLightState.getCt().intValue() <= 0) ? 500 : pHLightState.getCt();
        ct.getClass();
        int iIntValue = ct.intValue();
        Integer hue = pHLightState.getHue();
        hue.getClass();
        int iIntValue2 = hue.intValue();
        Integer saturation = pHLightState.getSaturation();
        saturation.getClass();
        int iIntValue3 = saturation.intValue();
        Integer brightness = pHLightState.getBrightness();
        brightness.getClass();
        Color.Hsb hsb = new Color.Hsb(iIntValue, iIntValue2, iIntValue3, brightness.intValue());
        Integer transitionTime = pHLightState.getTransitionTime();
        return new State(hsb, (transitionTime != null ? transitionTime.intValue() : 0) * 100, State.Switch.INSTANCE.of(pHLightState.isOn()), false, 8, null);
    }

    public static final Device toTradfriDevice(Light light) {
        light.getClass();
        int i = Integer.parseInt(light.getId());
        String name = light.getName();
        String model = light.getModel();
        if (model == null) {
            model = light.getName();
        }
        String version = light.getVersion();
        if (version == null) {
            version = "";
        }
        return new Device(i, name, new Device.Type("IKEA Tradfri", model, version, Float.valueOf(-1.0f)), null, null, null);
    }

    public static final Tradfri.Gateway toNativeGateway(Gateway.Tradfri tradfri) {
        tradfri.getClass();
        return new Tradfri.Gateway(tradfri.getId(), tradfri.getIp(), tradfri.getPort());
    }

    public static final PHAccessPoint toAccessPoint(Gateway.Hue hue) {
        hue.getClass();
        PHAccessPoint pHAccessPoint = new PHAccessPoint(hue.getIp(), null, hue.getMac());
        pHAccessPoint.setBridgeId(hue.getId());
        return pHAccessPoint;
    }

    public static final Light toLight(Device device) {
        Light.Type type;
        device.getClass();
        String strValueOf = String.valueOf(device.getId());
        String name = device.getName();
        String name2 = device.getType().getName();
        DeviceType deviceType = DeviceType.INSTANCE;
        if (deviceType.isColor(name2)) {
            type = Light.Type.COLOR;
        } else if (deviceType.isCt(name2)) {
            type = Light.Type.CT;
        } else if (deviceType.isDim(name2)) {
            type = Light.Type.DIM;
        } else {
            type = deviceType.isOutlet(name2) ? Light.Type.SWITCH : Light.Type.UNKNOWN;
        }
        Light light = new Light(strValueOf, name, type);
        light.setModel(device.getType().getName());
        light.setVersion(device.getType().getVersion());
        return light;
    }
}
