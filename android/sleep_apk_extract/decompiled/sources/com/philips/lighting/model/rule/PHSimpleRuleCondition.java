package com.philips.lighting.model.rule;

import com.philips.lighting.model.rule.PHRuleCondition;

/* JADX INFO: loaded from: classes4.dex */
public class PHSimpleRuleCondition extends PHRuleCondition {
    private PHSimpleRuleAttributeName attributeName;
    private String resourceIdentifier;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ATTRIBUTE_SENSOR_STATE_TEMPERATURE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class PHSimpleRuleAttributeName {
        public static final PHSimpleRuleAttributeName ATTRIBUTE_CONFIG_LOCALTIME;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_CONFIG_UTC;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_CONFIG_BATTERY;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_CONFIG_MOTIONSENSITIVITY;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_CONFIG_ON;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_CONFIG_RADIUS;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_CONFIG_REACHABLE;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_CONFIG_SUNRISEOFFSET;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_CONFIG_SUNSETOFFSET;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_BUTTONEVENT;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_DAYLIGHT;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_FLAG;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_HUMIDITY;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_LASTUPDATED;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_OPEN;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_PRESENCE;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_STATUS;
        public static final PHSimpleRuleAttributeName ATTRIBUTE_SENSOR_STATE_TEMPERATURE;
        private static final /* synthetic */ PHSimpleRuleAttributeName[] ENUM$VALUES;
        private String addressTemplate;
        private Class type;

        static {
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName = new PHSimpleRuleAttributeName("ATTRIBUTE_CONFIG_UTC", 0, "/config/UTC", String.class);
            ATTRIBUTE_CONFIG_UTC = pHSimpleRuleAttributeName;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName2 = new PHSimpleRuleAttributeName("ATTRIBUTE_CONFIG_LOCALTIME", 1, "/config/localtime", String.class);
            ATTRIBUTE_CONFIG_LOCALTIME = pHSimpleRuleAttributeName2;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName3 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_LASTUPDATED", 2, "/sensors/%s/state/lastupdated", String.class);
            ATTRIBUTE_SENSOR_STATE_LASTUPDATED = pHSimpleRuleAttributeName3;
            Class cls = Integer.TYPE;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName4 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_TEMPERATURE", 3, "/sensors/%s/state/temperature", cls);
            ATTRIBUTE_SENSOR_STATE_TEMPERATURE = pHSimpleRuleAttributeName4;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName5 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_HUMIDITY", 4, "/sensors/%s/state/humidity", cls);
            ATTRIBUTE_SENSOR_STATE_HUMIDITY = pHSimpleRuleAttributeName5;
            Class cls2 = Boolean.TYPE;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName6 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_DAYLIGHT", 5, "/sensors/%s/state/daylight", cls2);
            ATTRIBUTE_SENSOR_STATE_DAYLIGHT = pHSimpleRuleAttributeName6;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName7 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_PRESENCE", 6, "/sensors/%s/state/presence", cls2);
            ATTRIBUTE_SENSOR_STATE_PRESENCE = pHSimpleRuleAttributeName7;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName8 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_BUTTONEVENT", 7, "/sensors/%s/state/buttonevent", cls);
            ATTRIBUTE_SENSOR_STATE_BUTTONEVENT = pHSimpleRuleAttributeName8;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName9 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_OPEN", 8, "/sensors/%s/state/open", cls2);
            ATTRIBUTE_SENSOR_STATE_OPEN = pHSimpleRuleAttributeName9;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName10 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_FLAG", 9, "/sensors/%s/state/flag", cls2);
            ATTRIBUTE_SENSOR_STATE_FLAG = pHSimpleRuleAttributeName10;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName11 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_STATE_STATUS", 10, "/sensors/%s/state/status", cls);
            ATTRIBUTE_SENSOR_STATE_STATUS = pHSimpleRuleAttributeName11;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName12 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_CONFIG_BATTERY", 11, "/sensors/%s/config/battery", cls);
            ATTRIBUTE_SENSOR_CONFIG_BATTERY = pHSimpleRuleAttributeName12;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName13 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_CONFIG_REACHABLE", 12, "/sensors/%s/config/reachable", cls2);
            ATTRIBUTE_SENSOR_CONFIG_REACHABLE = pHSimpleRuleAttributeName13;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName14 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_CONFIG_ON", 13, "/sensors/%s/config/on", cls2);
            ATTRIBUTE_SENSOR_CONFIG_ON = pHSimpleRuleAttributeName14;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName15 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_CONFIG_SUNRISEOFFSET", 14, "/sensors/%s/config/sunriseoffset", cls);
            ATTRIBUTE_SENSOR_CONFIG_SUNRISEOFFSET = pHSimpleRuleAttributeName15;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName16 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_CONFIG_SUNSETOFFSET", 15, "/sensors/%s/config/sunsetoffset", cls);
            ATTRIBUTE_SENSOR_CONFIG_SUNSETOFFSET = pHSimpleRuleAttributeName16;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName17 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_CONFIG_MOTIONSENSITIVITY", 16, "/sensors/%s/config/motionsensitivity", cls);
            ATTRIBUTE_SENSOR_CONFIG_MOTIONSENSITIVITY = pHSimpleRuleAttributeName17;
            PHSimpleRuleAttributeName pHSimpleRuleAttributeName18 = new PHSimpleRuleAttributeName("ATTRIBUTE_SENSOR_CONFIG_RADIUS", 17, "/sensors/%s/config/radius", cls);
            ATTRIBUTE_SENSOR_CONFIG_RADIUS = pHSimpleRuleAttributeName18;
            ENUM$VALUES = new PHSimpleRuleAttributeName[]{pHSimpleRuleAttributeName, pHSimpleRuleAttributeName2, pHSimpleRuleAttributeName3, pHSimpleRuleAttributeName4, pHSimpleRuleAttributeName5, pHSimpleRuleAttributeName6, pHSimpleRuleAttributeName7, pHSimpleRuleAttributeName8, pHSimpleRuleAttributeName9, pHSimpleRuleAttributeName10, pHSimpleRuleAttributeName11, pHSimpleRuleAttributeName12, pHSimpleRuleAttributeName13, pHSimpleRuleAttributeName14, pHSimpleRuleAttributeName15, pHSimpleRuleAttributeName16, pHSimpleRuleAttributeName17, pHSimpleRuleAttributeName18};
        }

        private PHSimpleRuleAttributeName(String str, int i, String str2, Class cls) {
            this.addressTemplate = str2;
            this.type = cls;
        }

        public static PHSimpleRuleAttributeName getByAddressTemplate(String str) {
            for (PHSimpleRuleAttributeName pHSimpleRuleAttributeName : values()) {
                if (pHSimpleRuleAttributeName.getAddressTemplate().equals(str)) {
                    return pHSimpleRuleAttributeName;
                }
            }
            return null;
        }

        public static PHSimpleRuleAttributeName valueOf(String str) {
            return (PHSimpleRuleAttributeName) Enum.valueOf(PHSimpleRuleAttributeName.class, str);
        }

        public static PHSimpleRuleAttributeName[] values() {
            PHSimpleRuleAttributeName[] pHSimpleRuleAttributeNameArr = ENUM$VALUES;
            int length = pHSimpleRuleAttributeNameArr.length;
            PHSimpleRuleAttributeName[] pHSimpleRuleAttributeNameArr2 = new PHSimpleRuleAttributeName[length];
            System.arraycopy(pHSimpleRuleAttributeNameArr, 0, pHSimpleRuleAttributeNameArr2, 0, length);
            return pHSimpleRuleAttributeNameArr2;
        }

        public String getAddressTemplate() {
            return this.addressTemplate;
        }

        public Class getType() {
            return this.type;
        }

        public boolean isForBridgeConfiguration() {
            return equals(ATTRIBUTE_CONFIG_LOCALTIME) || equals(ATTRIBUTE_CONFIG_UTC);
        }
    }

    public PHSimpleRuleCondition(String str, PHSimpleRuleAttributeName pHSimpleRuleAttributeName, PHRuleCondition.PHRuleConditionOperator pHRuleConditionOperator, Object obj) {
        this.resourceIdentifier = null;
        this.attributeName = null;
        if (pHSimpleRuleAttributeName.isForBridgeConfiguration()) {
            this.address = pHSimpleRuleAttributeName.getAddressTemplate();
        } else {
            this.address = String.format(pHSimpleRuleAttributeName.getAddressTemplate(), str);
        }
        this.attributeName = pHSimpleRuleAttributeName;
        this.resourceIdentifier = str;
        this.operator = pHRuleConditionOperator;
        if (pHRuleConditionOperator != PHRuleCondition.PHRuleConditionOperator.OPERATOR_DX) {
            this.value = obj;
        }
    }

    @Override // com.philips.lighting.model.rule.PHRuleCondition
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHSimpleRuleCondition pHSimpleRuleCondition = (PHSimpleRuleCondition) obj;
        if (this.attributeName != pHSimpleRuleCondition.attributeName) {
            return false;
        }
        String str = this.resourceIdentifier;
        String str2 = pHSimpleRuleCondition.resourceIdentifier;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public PHSimpleRuleAttributeName getAttributeName() {
        return this.attributeName;
    }

    public String getResourceIdentifier() {
        return this.resourceIdentifier;
    }

    @Override // com.philips.lighting.model.rule.PHRuleCondition
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        PHSimpleRuleAttributeName pHSimpleRuleAttributeName = this.attributeName;
        int iHashCode2 = (iHashCode + (pHSimpleRuleAttributeName == null ? 0 : pHSimpleRuleAttributeName.hashCode())) * 31;
        String str = this.resourceIdentifier;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
