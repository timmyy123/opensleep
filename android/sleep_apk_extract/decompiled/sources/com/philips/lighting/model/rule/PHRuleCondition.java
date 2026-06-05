package com.philips.lighting.model.rule;

/* JADX INFO: loaded from: classes4.dex */
public class PHRuleCondition {
    protected String address;
    protected PHRuleConditionOperator operator;
    protected Object value;

    public enum PHRuleConditionOperator {
        OPERATOR_EQ("eq"),
        OPERATOR_GT("gt"),
        OPERATOR_LT("lt"),
        OPERATOR_DX("dx"),
        OPERATOR_DT("dt"),
        OPERATOR_DDX("ddx");

        private String value;

        PHRuleConditionOperator(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHRuleConditionOperator[] valuesCustom() {
            PHRuleConditionOperator[] pHRuleConditionOperatorArrValuesCustom = values();
            int length = pHRuleConditionOperatorArrValuesCustom.length;
            PHRuleConditionOperator[] pHRuleConditionOperatorArr = new PHRuleConditionOperator[length];
            System.arraycopy(pHRuleConditionOperatorArrValuesCustom, 0, pHRuleConditionOperatorArr, 0, length);
            return pHRuleConditionOperatorArr;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static PHRuleConditionOperator getOperatorFromShortDesc(String str) {
        return PHRuleConditionOperator.valueOf("OPERATOR_" + str.toUpperCase());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHRuleCondition pHRuleCondition = (PHRuleCondition) obj;
        String str = this.address;
        String str2 = pHRuleCondition.address;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        if (this.operator != pHRuleCondition.operator) {
            return false;
        }
        Object obj2 = this.value;
        Object obj3 = pHRuleCondition.value;
        if (obj2 == null) {
            if (obj3 != null) {
                return false;
            }
        } else if (!obj2.equals(obj3)) {
            return false;
        }
        return true;
    }

    public String getAddress() {
        return this.address;
    }

    public PHRuleConditionOperator getOperator() {
        return this.operator;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.address;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        PHRuleConditionOperator pHRuleConditionOperator = this.operator;
        int iHashCode2 = (iHashCode + (pHRuleConditionOperator == null ? 0 : pHRuleConditionOperator.hashCode())) * 31;
        Object obj = this.value;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setOperator(PHRuleConditionOperator pHRuleConditionOperator) {
        this.operator = pHRuleConditionOperator;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
