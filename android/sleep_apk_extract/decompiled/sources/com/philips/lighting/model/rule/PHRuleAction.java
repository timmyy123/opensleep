package com.philips.lighting.model.rule;

/* JADX INFO: loaded from: classes4.dex */
public class PHRuleAction {
    private String address;
    private Object body;
    private String method;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHRuleAction pHRuleAction = (PHRuleAction) obj;
        String str = this.address;
        String str2 = pHRuleAction.address;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        Object obj2 = this.body;
        Object obj3 = pHRuleAction.body;
        if (obj2 == null) {
            if (obj3 != null) {
                return false;
            }
        } else if (!obj2.equals(obj3)) {
            return false;
        }
        String str3 = this.method;
        String str4 = pHRuleAction.method;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public String getAddress() {
        return this.address;
    }

    public Object getBody() {
        return this.body;
    }

    public String getMethod() {
        return this.method;
    }

    public int hashCode() {
        String str = this.address;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        Object obj = this.body;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        String str2 = this.method;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBody(Object obj) {
        this.body = obj;
    }

    public void setMethod(String str) {
        this.method = str;
    }
}
