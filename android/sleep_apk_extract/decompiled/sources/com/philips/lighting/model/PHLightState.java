package com.philips.lighting.model;

import com.facebook.internal.NativeProtocol;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.model.PHLight;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightState {
    private static final int BRIGHTNESS_MAX = 254;
    private static final int BRIGHTNESS_MIN = 0;
    private static final int BRI_INC_MAX = 254;
    private static final int BRI_INC_MIN = -254;
    private static final int CT_INC_MAX = 65534;
    private static final int CT_INC_MIN = -65534;
    private static final int CT_MAX = 500;
    private static final int CT_MIN = 153;
    private static final int HUE_INC_MAX = 65534;
    private static final int HUE_INC_MIN = -65534;
    private static final int HUE_MAX = 65535;
    private static final int HUE_MIN = 0;
    private static final int SATURATION_MAX = 254;
    private static final int SATURATION_MIN = 0;
    private static final int SAT_INC_MAX = 254;
    private static final int SAT_INC_MIN = -254;
    private static final int TRANSITION_TIME_MAX = 65535;
    private static final int TRANSITION_TIME_MIN = 0;
    private static final float XY_INC_MAX = 0.5f;
    private static final float XY_INC_MIN = -0.5f;
    private static final float XY_MAX = 1.0f;
    private static final float XY_MIN = 0.0f;
    private PHLight.PHLightAlertMode alert;
    private Integer brightness;
    private PHLight.PHLightColorMode colormode;
    private Integer ct;
    private PHLight.PHLightEffectMode effect;
    private Integer hue;
    private Integer incrementBri;
    private Integer incrementCt;
    private Integer incrementHue;
    private Integer incrementSat;
    private Float incrementX;
    private Float incrementY;
    private Boolean isReachable;
    private Boolean on;
    private Integer saturation;
    private Integer transitionTime;
    private Float x;
    private Float y;

    public PHLightState(PHLightState pHLightState) {
        this.brightness = null;
        this.hue = null;
        this.saturation = null;
        this.ct = null;
        this.alert = PHLight.PHLightAlertMode.ALERT_UNKNOWN;
        this.effect = PHLight.PHLightEffectMode.EFFECT_UNKNOWN;
        this.transitionTime = null;
        this.x = null;
        this.y = null;
        this.colormode = PHLight.PHLightColorMode.COLORMODE_UNKNOWN;
        if (pHLightState == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            throw null;
        }
        this.alert = pHLightState.alert;
        this.brightness = pHLightState.brightness;
        this.colormode = pHLightState.colormode;
        this.ct = pHLightState.ct;
        this.effect = pHLightState.effect;
        this.hue = pHLightState.hue;
        this.on = pHLightState.on;
        this.saturation = pHLightState.saturation;
        this.transitionTime = pHLightState.transitionTime;
        this.x = pHLightState.x;
        this.y = pHLightState.y;
        this.isReachable = pHLightState.isReachable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHLightState pHLightState = (PHLightState) obj;
        if (this.alert != pHLightState.alert) {
            return false;
        }
        Integer num = this.brightness;
        Integer num2 = pHLightState.brightness;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        if (this.colormode != pHLightState.colormode) {
            return false;
        }
        Integer num3 = this.ct;
        Integer num4 = pHLightState.ct;
        if (num3 == null) {
            if (num4 != null) {
                return false;
            }
        } else if (!num3.equals(num4)) {
            return false;
        }
        if (this.effect != pHLightState.effect) {
            return false;
        }
        Integer num5 = this.hue;
        Integer num6 = pHLightState.hue;
        if (num5 == null) {
            if (num6 != null) {
                return false;
            }
        } else if (!num5.equals(num6)) {
            return false;
        }
        Integer num7 = this.incrementBri;
        Integer num8 = pHLightState.incrementBri;
        if (num7 == null) {
            if (num8 != null) {
                return false;
            }
        } else if (!num7.equals(num8)) {
            return false;
        }
        Integer num9 = this.incrementCt;
        Integer num10 = pHLightState.incrementCt;
        if (num9 == null) {
            if (num10 != null) {
                return false;
            }
        } else if (!num9.equals(num10)) {
            return false;
        }
        Integer num11 = this.incrementHue;
        Integer num12 = pHLightState.incrementHue;
        if (num11 == null) {
            if (num12 != null) {
                return false;
            }
        } else if (!num11.equals(num12)) {
            return false;
        }
        Integer num13 = this.incrementSat;
        Integer num14 = pHLightState.incrementSat;
        if (num13 == null) {
            if (num14 != null) {
                return false;
            }
        } else if (!num13.equals(num14)) {
            return false;
        }
        Float f = this.incrementX;
        Float f2 = pHLightState.incrementX;
        if (f == null) {
            if (f2 != null) {
                return false;
            }
        } else if (!f.equals(f2)) {
            return false;
        }
        Float f3 = this.incrementY;
        Float f4 = pHLightState.incrementY;
        if (f3 == null) {
            if (f4 != null) {
                return false;
            }
        } else if (!f3.equals(f4)) {
            return false;
        }
        Boolean bool = this.isReachable;
        Boolean bool2 = pHLightState.isReachable;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        Boolean bool3 = this.on;
        Boolean bool4 = pHLightState.on;
        if (bool3 == null) {
            if (bool4 != null) {
                return false;
            }
        } else if (!bool3.equals(bool4)) {
            return false;
        }
        Integer num15 = this.saturation;
        Integer num16 = pHLightState.saturation;
        if (num15 == null) {
            if (num16 != null) {
                return false;
            }
        } else if (!num15.equals(num16)) {
            return false;
        }
        Integer num17 = this.transitionTime;
        Integer num18 = pHLightState.transitionTime;
        if (num17 == null) {
            if (num18 != null) {
                return false;
            }
        } else if (!num17.equals(num18)) {
            return false;
        }
        Float f5 = this.x;
        Float f6 = pHLightState.x;
        if (f5 == null) {
            if (f6 != null) {
                return false;
            }
        } else if (!f5.equals(f6)) {
            return false;
        }
        Float f7 = this.y;
        Float f8 = pHLightState.y;
        if (f7 == null) {
            if (f8 != null) {
                return false;
            }
        } else if (!f7.equals(f8)) {
            return false;
        }
        return true;
    }

    public PHLight.PHLightAlertMode getAlertMode() {
        return this.alert;
    }

    public Integer getBrightness() {
        return this.brightness;
    }

    public PHLight.PHLightColorMode getColorMode() {
        return this.colormode;
    }

    public Integer getCt() {
        return this.ct;
    }

    public PHLight.PHLightEffectMode getEffectMode() {
        return this.effect;
    }

    public Integer getHue() {
        return this.hue;
    }

    public Integer getIncrementBri() {
        return this.incrementBri;
    }

    public Integer getIncrementCt() {
        return this.incrementCt;
    }

    public Integer getIncrementHue() {
        return this.incrementHue;
    }

    public Integer getIncrementSat() {
        return this.incrementSat;
    }

    public Float getIncrementX() {
        return this.incrementX;
    }

    public Float getIncrementY() {
        return this.incrementY;
    }

    public Integer getSaturation() {
        return this.saturation;
    }

    public Integer getTransitionTime() {
        return this.transitionTime;
    }

    public Float getX() {
        return this.x;
    }

    public Float getY() {
        return this.y;
    }

    public int hashCode() {
        PHLight.PHLightAlertMode pHLightAlertMode = this.alert;
        int iHashCode = ((pHLightAlertMode == null ? 0 : pHLightAlertMode.hashCode()) + 31) * 31;
        Integer num = this.brightness;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        PHLight.PHLightColorMode pHLightColorMode = this.colormode;
        int iHashCode3 = (iHashCode2 + (pHLightColorMode == null ? 0 : pHLightColorMode.hashCode())) * 31;
        Integer num2 = this.ct;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        PHLight.PHLightEffectMode pHLightEffectMode = this.effect;
        int iHashCode5 = (iHashCode4 + (pHLightEffectMode == null ? 0 : pHLightEffectMode.hashCode())) * 31;
        Integer num3 = this.hue;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.incrementBri;
        int iHashCode7 = (iHashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.incrementCt;
        int iHashCode8 = (iHashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.incrementHue;
        int iHashCode9 = (iHashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.incrementSat;
        int iHashCode10 = (iHashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Float f = this.incrementX;
        int iHashCode11 = (iHashCode10 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.incrementY;
        int iHashCode12 = (iHashCode11 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Boolean bool = this.on;
        int iHashCode13 = (iHashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num8 = this.saturation;
        int iHashCode14 = (iHashCode13 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.transitionTime;
        int iHashCode15 = (iHashCode14 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Float f3 = this.x;
        int iHashCode16 = (iHashCode15 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.y;
        int iHashCode17 = (iHashCode16 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Boolean bool2 = this.isReachable;
        return iHashCode17 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public Boolean isOn() {
        return this.on;
    }

    public Boolean isReachable() {
        return this.isReachable;
    }

    public void setAlertMode(PHLight.PHLightAlertMode pHLightAlertMode) {
        this.alert = pHLightAlertMode;
    }

    public void setBrightness(Integer num, boolean z) {
        if (z && num != null) {
            if (num.intValue() > 254) {
                num = 254;
            } else if (num.intValue() < 0) {
                num = 0;
            }
        }
        this.brightness = num;
    }

    public void setColorMode(PHLight.PHLightColorMode pHLightColorMode) {
        this.colormode = pHLightColorMode;
    }

    public void setCt(Integer num, boolean z) {
        if (z && num != null) {
            if (num.intValue() > CT_MAX) {
                num = Integer.valueOf(CT_MAX);
            } else if (num.intValue() < CT_MIN) {
                num = Integer.valueOf(CT_MIN);
            }
        }
        this.ct = num;
    }

    public void setEffectMode(PHLight.PHLightEffectMode pHLightEffectMode) {
        this.effect = pHLightEffectMode;
    }

    public void setHue(Integer num, boolean z) {
        if (z && num != null) {
            if (num.intValue() > 65535) {
                num = Integer.valueOf(num.intValue() - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            } else if (num.intValue() < 0) {
                num = Integer.valueOf(num.intValue() + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            }
        }
        this.hue = num;
    }

    public void setIncrementBri(Integer num) {
        this.incrementBri = num;
    }

    public void setIncrementCt(Integer num) {
        this.incrementCt = num;
    }

    public void setIncrementHue(Integer num) {
        this.incrementHue = num;
    }

    public void setIncrementSat(Integer num) {
        this.incrementSat = num;
    }

    public void setIncrementX(Float f) {
        this.incrementX = f;
    }

    public void setIncrementY(Float f) {
        this.incrementY = f;
    }

    public void setOn(Boolean bool) {
        this.on = bool;
    }

    public void setReachable(Boolean bool) {
        this.isReachable = bool;
    }

    public void setSaturation(Integer num, boolean z) {
        if (z && num != null && (num.intValue() > 254 || num.intValue() < 0)) {
            num = 254;
        }
        this.saturation = num;
    }

    public void setTransitionTime(Integer num) {
        this.transitionTime = num;
    }

    public void setX(Float f, boolean z) {
        if (z && this.ct != null) {
            if (f.floatValue() > XY_MAX) {
                f = Float.valueOf(XY_MAX);
            } else if (f.floatValue() < 0.0f) {
                f = Float.valueOf(0.0f);
            }
        }
        this.x = f;
    }

    public void setY(Float f, boolean z) {
        if (z && this.ct != null) {
            if (f.floatValue() > XY_MAX) {
                f = Float.valueOf(XY_MAX);
            } else if (f.floatValue() < 0.0f) {
                f = Float.valueOf(0.0f);
            }
        }
        this.y = f;
    }

    public String validateState() {
        Integer num = this.brightness;
        if (num != null && (num.intValue() < 0 || this.brightness.intValue() > 254)) {
            return "brightness should be a value between 0 and 254";
        }
        Integer num2 = this.hue;
        if (num2 != null && (num2.intValue() < 0 || this.hue.intValue() > 65535)) {
            return "hue should be a value between 0 and 65535";
        }
        Integer num3 = this.saturation;
        if (num3 != null && (num3.intValue() < 0 || this.saturation.intValue() > 254)) {
            return "saturation should be a value between 0 and 254";
        }
        Integer num4 = this.ct;
        if (num4 != null && (num4.intValue() < CT_MIN || this.ct.intValue() > CT_MAX)) {
            return "color temperature should be a value between 153 and 500";
        }
        Float f = this.x;
        if (f != null && this.y == null) {
            return "x and y need both to be set";
        }
        if (f == null && this.y != null) {
            return "x and y need both to be set";
        }
        if (f != null && this.y != null) {
            if (f.floatValue() < 0.0f || this.x.floatValue() > XY_MAX) {
                return "x should be a value between 0.0 and1.0";
            }
            if (this.y.floatValue() < 0.0f || this.y.floatValue() > XY_MAX) {
                return "y should be a value betwee n0.0 and1.0";
            }
        }
        PHLight.PHLightAlertMode pHLightAlertMode = this.alert;
        if (pHLightAlertMode != null && (pHLightAlertMode.ordinal() < PHLight.PHLightAlertMode.ALERT_UNKNOWN.ordinal() || this.alert.ordinal() > PHLight.PHLightAlertMode.ALERT_LSELECT.ordinal())) {
            return "alert mode is invalid";
        }
        PHLight.PHLightEffectMode pHLightEffectMode = this.effect;
        if (pHLightEffectMode != null && (pHLightEffectMode.ordinal() < PHLight.PHLightEffectMode.EFFECT_UNKNOWN.ordinal() || this.effect.ordinal() > PHLight.PHLightEffectMode.EFFECT_COLORLOOP.ordinal())) {
            return "effect mode is invalid";
        }
        Integer num5 = this.transitionTime;
        if (num5 != null && (num5.intValue() < 0 || this.transitionTime.intValue() > 65535)) {
            return "transition time should be a value between0 and65535";
        }
        Integer num6 = this.incrementBri;
        if (num6 != null && (num6.intValue() < -254 || this.incrementBri.intValue() > 254)) {
            return "bri_inc should be a value between  -254 and 254";
        }
        Integer num7 = this.incrementCt;
        if (num7 != null && (num7.intValue() < -65534 || this.incrementCt.intValue() > 65534)) {
            return "ct_inc should be a value between -65534 and 65534";
        }
        Integer num8 = this.incrementHue;
        if (num8 != null && (num8.intValue() < -65534 || this.incrementHue.intValue() > 65534)) {
            return "hue_inc should be a value between -65534 and 65534";
        }
        Integer num9 = this.incrementSat;
        if (num9 != null && (num9.intValue() < -254 || this.incrementSat.intValue() > 254)) {
            return "sat_inc should be a value between -254 and 254";
        }
        Float f2 = this.incrementX;
        if (f2 != null && (f2.floatValue() < XY_INC_MIN || this.incrementX.floatValue() > XY_INC_MAX)) {
            return "xy_inc should be a value between -0.5 and 0.5";
        }
        Float f3 = this.incrementY;
        if (f3 == null) {
            return null;
        }
        if (f3.floatValue() < XY_INC_MIN || this.incrementY.floatValue() > XY_INC_MAX) {
            return "xy_inc should be a value between -0.5 and 0.5";
        }
        return null;
    }

    public void setSaturation(Integer num) {
        this.saturation = num;
    }

    public void setBrightness(Integer num) {
        setBrightness(num, false);
    }

    public void setCt(Integer num) {
        setCt(num, false);
    }

    public void setX(Float f) {
        setX(f, false);
    }

    public void setY(Float f) {
        setY(f, false);
    }

    public void setHue(Integer num) {
        setHue(num, false);
    }

    public PHLightState() {
        this.brightness = null;
        this.hue = null;
        this.saturation = null;
        this.ct = null;
        this.alert = PHLight.PHLightAlertMode.ALERT_UNKNOWN;
        this.effect = PHLight.PHLightEffectMode.EFFECT_UNKNOWN;
        this.transitionTime = null;
        this.x = null;
        this.y = null;
        this.colormode = PHLight.PHLightColorMode.COLORMODE_UNKNOWN;
    }
}
