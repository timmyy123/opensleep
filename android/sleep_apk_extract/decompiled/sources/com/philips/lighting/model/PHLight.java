package com.philips.lighting.model;

import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import java.util.Locale;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHLight extends PHBridgeResource {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType = null;
    private static final String STR_COLOR_LIGHT = "color light";
    private static final String STR_COLOR_TEMPERATURE = "color temperature light";
    private static final String STR_CT_COLOR = "ctcolor light";
    private static final String STR_CT_LIGHT = "ct light";
    private static final String STR_DIMABLE = "dimmable light";
    private static final String STR_DIMABLE_PLUGIN = "dimmable plug-in unit";
    private static final String STR_EXTENDED_COLOR = "extended color light";
    private static final String STR_ON_OFF = "on/off light";
    private static final String STR_ON_OFF_PLUGIN = "on/off plug-in unit";
    private PHLightState lastKnownLightState;
    private String luminaireUniqueId;
    private String manufacturerName;
    private String modelNumber;
    private PHLightType type;
    private String uniqueId;
    private String versionNumber;

    public enum PHLightAlertMode {
        ALERT_UNKNOWN(null),
        ALERT_NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
        ALERT_SELECT("select"),
        ALERT_LSELECT("lselect");

        private String value;

        PHLightAlertMode(String str) {
            this.value = str;
        }

        public static PHLightAlertMode fromString(String str) {
            PHLightAlertMode pHLightAlertMode = ALERT_SELECT;
            if (str.equals(pHLightAlertMode.getValue())) {
                return pHLightAlertMode;
            }
            PHLightAlertMode pHLightAlertMode2 = ALERT_LSELECT;
            if (str.equals(pHLightAlertMode2.getValue())) {
                return pHLightAlertMode2;
            }
            PHLightAlertMode pHLightAlertMode3 = ALERT_NONE;
            return str.equals(pHLightAlertMode3.getValue()) ? pHLightAlertMode3 : ALERT_UNKNOWN;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHLightAlertMode[] valuesCustom() {
            PHLightAlertMode[] pHLightAlertModeArrValuesCustom = values();
            int length = pHLightAlertModeArrValuesCustom.length;
            PHLightAlertMode[] pHLightAlertModeArr = new PHLightAlertMode[length];
            System.arraycopy(pHLightAlertModeArrValuesCustom, 0, pHLightAlertModeArr, 0, length);
            return pHLightAlertModeArr;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum PHLightColorMode {
        COLORMODE_UNKNOWN(null),
        COLORMODE_NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
        COLORMODE_CT(UserDataStore.CITY),
        COLORMODE_HUE_SATURATION("hs"),
        COLORMODE_XY("xy");

        private String value;

        PHLightColorMode(String str) {
            this.value = str;
        }

        public static PHLightColorMode fromString(String str) {
            PHLightColorMode pHLightColorMode = COLORMODE_CT;
            if (str.equals(pHLightColorMode.getValue())) {
                return pHLightColorMode;
            }
            PHLightColorMode pHLightColorMode2 = COLORMODE_HUE_SATURATION;
            if (str.equals(pHLightColorMode2.getValue())) {
                return pHLightColorMode2;
            }
            PHLightColorMode pHLightColorMode3 = COLORMODE_XY;
            if (str.equals(pHLightColorMode3.getValue())) {
                return pHLightColorMode3;
            }
            PHLightColorMode pHLightColorMode4 = COLORMODE_NONE;
            return str.equals(pHLightColorMode4.getValue()) ? pHLightColorMode4 : COLORMODE_UNKNOWN;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHLightColorMode[] valuesCustom() {
            PHLightColorMode[] pHLightColorModeArrValuesCustom = values();
            int length = pHLightColorModeArrValuesCustom.length;
            PHLightColorMode[] pHLightColorModeArr = new PHLightColorMode[length];
            System.arraycopy(pHLightColorModeArrValuesCustom, 0, pHLightColorModeArr, 0, length);
            return pHLightColorModeArr;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum PHLightEffectMode {
        EFFECT_UNKNOWN(null),
        EFFECT_NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
        EFFECT_COLORLOOP("colorloop");

        private String value;

        PHLightEffectMode(String str) {
            this.value = str;
        }

        public static PHLightEffectMode fromString(String str) {
            PHLightEffectMode pHLightEffectMode = EFFECT_COLORLOOP;
            if (str.equals(pHLightEffectMode.getValue())) {
                return pHLightEffectMode;
            }
            PHLightEffectMode pHLightEffectMode2 = EFFECT_NONE;
            return str.equals(pHLightEffectMode2.getValue()) ? pHLightEffectMode2 : EFFECT_UNKNOWN;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHLightEffectMode[] valuesCustom() {
            PHLightEffectMode[] pHLightEffectModeArrValuesCustom = values();
            int length = pHLightEffectModeArrValuesCustom.length;
            PHLightEffectMode[] pHLightEffectModeArr = new PHLightEffectMode[length];
            System.arraycopy(pHLightEffectModeArrValuesCustom, 0, pHLightEffectModeArr, 0, length);
            return pHLightEffectModeArr;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum PHLightType {
        UNKNOWN_LIGHT,
        CT_COLOR_LIGHT,
        COLOR_LIGHT,
        CT_LIGHT,
        DIM_LIGHT,
        ON_OFF_LIGHT;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHLightType[] valuesCustom() {
            PHLightType[] pHLightTypeArrValuesCustom = values();
            int length = pHLightTypeArrValuesCustom.length;
            PHLightType[] pHLightTypeArr = new PHLightType[length];
            System.arraycopy(pHLightTypeArrValuesCustom, 0, pHLightTypeArr, 0, length);
            return pHLightTypeArr;
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType() {
        int[] iArr = $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[PHLightType.valuesCustom().length];
        try {
            iArr2[PHLightType.COLOR_LIGHT.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[PHLightType.CT_COLOR_LIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[PHLightType.CT_LIGHT.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[PHLightType.DIM_LIGHT.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[PHLightType.ON_OFF_LIGHT.ordinal()] = 6;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[PHLightType.UNKNOWN_LIGHT.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType = iArr2;
        return iArr2;
    }

    public PHLight(PHLight pHLight) {
        super(isNull(pHLight).getName(), isNull(pHLight).getIdentifier());
        this.lastKnownLightState = null;
        this.lastKnownLightState = pHLight.lastKnownLightState;
        this.modelNumber = pHLight.modelNumber;
        this.type = pHLight.type;
        this.versionNumber = pHLight.versionNumber;
    }

    private static PHLight isNull(PHLight pHLight) {
        if (pHLight != null) {
            return pHLight;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
        return null;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHLight pHLight = (PHLight) obj;
        PHLightState pHLightState = this.lastKnownLightState;
        PHLightState pHLightState2 = pHLight.lastKnownLightState;
        if (pHLightState == null) {
            if (pHLightState2 != null) {
                return false;
            }
        } else if (!pHLightState.equals(pHLightState2)) {
            return false;
        }
        String str = this.modelNumber;
        String str2 = pHLight.modelNumber;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        if (this.type != pHLight.type) {
            return false;
        }
        String str3 = this.versionNumber;
        String str4 = pHLight.versionNumber;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public PHLightState getLastKnownLightState() {
        return this.lastKnownLightState;
    }

    public PHLightType getLightType() {
        return this.type;
    }

    public String getLuminaireUniqueId() {
        return this.luminaireUniqueId;
    }

    public String getManufacturerName() {
        return this.manufacturerName;
    }

    public String getModelNumber() {
        return this.modelNumber;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public String getVersionNumber() {
        return this.versionNumber;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        PHLightState pHLightState = this.lastKnownLightState;
        int iHashCode2 = (iHashCode + (pHLightState == null ? 0 : pHLightState.hashCode())) * 31;
        String str = this.modelNumber;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        PHLightType pHLightType = this.type;
        int iHashCode4 = (iHashCode3 + (pHLightType == null ? 0 : pHLightType.hashCode())) * 31;
        String str2 = this.versionNumber;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public void setLastKnownLightState(PHLightState pHLightState) {
        this.lastKnownLightState = pHLightState;
    }

    public void setLightType(String str) {
        if (str == null) {
            this.type = PHLightType.CT_COLOR_LIGHT;
            return;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.equals(STR_ON_OFF) || lowerCase.equals(STR_ON_OFF_PLUGIN)) {
            this.type = PHLightType.ON_OFF_LIGHT;
            return;
        }
        if (lowerCase.equals(STR_DIMABLE) || lowerCase.equals(STR_DIMABLE_PLUGIN)) {
            this.type = PHLightType.DIM_LIGHT;
            return;
        }
        if (lowerCase.equals(STR_COLOR_LIGHT)) {
            this.type = PHLightType.COLOR_LIGHT;
            return;
        }
        if (lowerCase.equals(STR_CT_COLOR) || lowerCase.equals(STR_EXTENDED_COLOR)) {
            this.type = PHLightType.CT_COLOR_LIGHT;
        } else if (lowerCase.equals(STR_CT_LIGHT) || lowerCase.equals(STR_COLOR_TEMPERATURE)) {
            this.type = PHLightType.CT_LIGHT;
        } else {
            this.type = PHLightType.ON_OFF_LIGHT;
        }
    }

    public void setLuminaireUniqueId(String str) {
        this.luminaireUniqueId = str;
    }

    public void setManufacturerName(String str) {
        this.manufacturerName = str;
    }

    public void setModelNumber(String str) {
        this.modelNumber = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public void setVersionNumber(String str) {
        this.versionNumber = str;
    }

    public boolean supportsBrightness() {
        return $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType()[this.type.ordinal()] != 6;
    }

    public boolean supportsCT() {
        int i = $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType()[this.type.ordinal()];
        return i == 2 || i == 4;
    }

    public boolean supportsColor() {
        int i = $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType()[this.type.ordinal()];
        return i == 2 || i == 3;
    }

    public String toString() {
        String str = ("Identifier: " + getIdentifier() + "\n") + "Name: " + getName() + "\n";
        int i = $SWITCH_TABLE$com$philips$lighting$model$PHLight$PHLightType()[this.type.ordinal()];
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? str.concat("type: UNKNOWN\n") : str.concat("type: ON_OFF_LIGHT\n") : str.concat("type: DIM_LIGHT\n") : str.concat("type: CT_LIGHT\n") : str.concat("type: COLOR_LIGHT\n") : str.concat("type: CT_COLOR_LIGHT\n");
    }

    public PHLight(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.lastKnownLightState = null;
        this.versionNumber = str3;
        this.modelNumber = str4;
    }
}
