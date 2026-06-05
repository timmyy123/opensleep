package com.philips.lighting.model;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHGroup extends PHBridgeResource {
    private PHGroupClass groupClass;
    private List<String> lightIdentifiers;
    private String modelId;
    private String type;
    private String uniqueId;

    public enum PHGroupClass {
        CLASS_LIVING_ROOM("Living room"),
        CLASS_KITCHEN("Kitchen"),
        CLASS_DINING("Dining"),
        CLASS_BEDROOM("Bedroom"),
        CLASS_KIDS_BEDROOM("Kids bedroom"),
        CLASS_BATHROOM("Bathroom"),
        CLASS_NURSERY("Nursery"),
        CLASS_RECREATION("Recreation"),
        CLASS_OFFICE("Office"),
        CLASS_GYM("Gym"),
        CLASS_HALLWAY("Hallway"),
        CLASS_TOILET("Toilet"),
        CLASS_FRONT_DOOR("Front door"),
        CLASS_GARAGE("Garage"),
        CLASS_TERRACE("Terrace"),
        CLASS_GARDEN("Garden"),
        CLASS_DRIVEWAY("Driveway"),
        CLASS_CARPORT("Carport"),
        CLASS_OTHER("Other");

        private String value;

        PHGroupClass(String str) {
            this.value = str;
        }

        public static PHGroupClass fromString(String str) {
            PHGroupClass pHGroupClass = CLASS_BATHROOM;
            if (str.equals(pHGroupClass.getValue())) {
                return pHGroupClass;
            }
            PHGroupClass pHGroupClass2 = CLASS_BEDROOM;
            if (str.equals(pHGroupClass2.getValue())) {
                return pHGroupClass2;
            }
            PHGroupClass pHGroupClass3 = CLASS_CARPORT;
            if (str.equals(pHGroupClass3.getValue())) {
                return pHGroupClass3;
            }
            PHGroupClass pHGroupClass4 = CLASS_DINING;
            if (str.equals(pHGroupClass4.getValue())) {
                return pHGroupClass4;
            }
            PHGroupClass pHGroupClass5 = CLASS_DRIVEWAY;
            if (str.equals(pHGroupClass5.getValue())) {
                return pHGroupClass5;
            }
            PHGroupClass pHGroupClass6 = CLASS_FRONT_DOOR;
            if (str.equals(pHGroupClass6.getValue())) {
                return pHGroupClass6;
            }
            PHGroupClass pHGroupClass7 = CLASS_GARAGE;
            if (str.equals(pHGroupClass7.getValue())) {
                return pHGroupClass7;
            }
            PHGroupClass pHGroupClass8 = CLASS_GARDEN;
            if (str.equals(pHGroupClass8.getValue())) {
                return pHGroupClass8;
            }
            PHGroupClass pHGroupClass9 = CLASS_GYM;
            if (str.equals(pHGroupClass9.getValue())) {
                return pHGroupClass9;
            }
            PHGroupClass pHGroupClass10 = CLASS_HALLWAY;
            if (str.equals(pHGroupClass10.getValue())) {
                return pHGroupClass10;
            }
            PHGroupClass pHGroupClass11 = CLASS_KIDS_BEDROOM;
            if (str.equals(pHGroupClass11.getValue())) {
                return pHGroupClass11;
            }
            PHGroupClass pHGroupClass12 = CLASS_KITCHEN;
            if (str.equals(pHGroupClass12.getValue())) {
                return pHGroupClass12;
            }
            PHGroupClass pHGroupClass13 = CLASS_LIVING_ROOM;
            if (str.equals(pHGroupClass13.getValue())) {
                return pHGroupClass13;
            }
            PHGroupClass pHGroupClass14 = CLASS_NURSERY;
            if (str.equals(pHGroupClass14.getValue())) {
                return pHGroupClass14;
            }
            PHGroupClass pHGroupClass15 = CLASS_OFFICE;
            if (str.equals(pHGroupClass15.getValue())) {
                return pHGroupClass15;
            }
            PHGroupClass pHGroupClass16 = CLASS_OTHER;
            if (!str.equals(pHGroupClass16.getValue())) {
                PHGroupClass pHGroupClass17 = CLASS_RECREATION;
                if (str.equals(pHGroupClass17.getValue())) {
                    return pHGroupClass17;
                }
                PHGroupClass pHGroupClass18 = CLASS_TERRACE;
                if (str.equals(pHGroupClass18.getValue())) {
                    return pHGroupClass18;
                }
                PHGroupClass pHGroupClass19 = CLASS_TOILET;
                if (str.equals(pHGroupClass19.getValue())) {
                    return pHGroupClass19;
                }
            }
            return pHGroupClass16;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHGroupClass[] valuesCustom() {
            PHGroupClass[] pHGroupClassArrValuesCustom = values();
            int length = pHGroupClassArrValuesCustom.length;
            PHGroupClass[] pHGroupClassArr = new PHGroupClass[length];
            System.arraycopy(pHGroupClassArrValuesCustom, 0, pHGroupClassArr, 0, length);
            return pHGroupClassArr;
        }

        public String getValue() {
            return this.value;
        }
    }

    public PHGroup(PHGroup pHGroup) {
        super(isNull(pHGroup).getName(), isNull(pHGroup).getIdentifier());
        this.lightIdentifiers = pHGroup.lightIdentifiers;
    }

    private static PHGroup isNull(PHGroup pHGroup) {
        if (pHGroup != null) {
            return pHGroup;
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
        PHGroup pHGroup = (PHGroup) obj;
        List<String> list = this.lightIdentifiers;
        List<String> list2 = pHGroup.lightIdentifiers;
        if (list == null) {
            if (list2 != null) {
                return false;
            }
        } else if (!list.equals(list2)) {
            return false;
        }
        String str = this.modelId;
        String str2 = pHGroup.modelId;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.type;
        String str4 = pHGroup.type;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public PHGroupClass getGroupClass() {
        return this.groupClass;
    }

    public List<String> getLightIdentifiers() {
        return this.lightIdentifiers;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getType() {
        return this.type;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        List<String> list = this.lightIdentifiers;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.modelId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.type;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public void setGroupClass(PHGroupClass pHGroupClass) {
        this.groupClass = pHGroupClass;
    }

    public void setLightIdentifiers(List<String> list) {
        this.lightIdentifiers = list;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public PHGroup(String str, String str2) {
        super(str, str2);
    }

    public PHGroup() {
        super("", "");
    }
}
