package com.philips.lighting.model.rule;

import com.philips.lighting.model.PHBridgeResource;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PHRule extends PHBridgeResource {
    private List<PHRuleAction> actions;
    private List<PHRuleCondition> conditions;
    private Date creationTime;
    private Date lastTriggered;
    private String owner;
    private PHRuleStatus status;
    private int timesTriggered;

    public enum PHRuleStatus {
        ENABLED,
        DISABLED,
        RESOURCE_DELETED,
        ERROR,
        UNKNOWN;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHRuleStatus[] valuesCustom() {
            PHRuleStatus[] pHRuleStatusArrValuesCustom = values();
            int length = pHRuleStatusArrValuesCustom.length;
            PHRuleStatus[] pHRuleStatusArr = new PHRuleStatus[length];
            System.arraycopy(pHRuleStatusArrValuesCustom, 0, pHRuleStatusArr, 0, length);
            return pHRuleStatusArr;
        }
    }

    public PHRule(String str, String str2) {
        super(str, str2);
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHRule pHRule = (PHRule) obj;
        List<PHRuleAction> list = this.actions;
        List<PHRuleAction> list2 = pHRule.actions;
        if (list == null) {
            if (list2 != null) {
                return false;
            }
        } else if (!list.equals(list2)) {
            return false;
        }
        List<PHRuleCondition> list3 = this.conditions;
        List<PHRuleCondition> list4 = pHRule.conditions;
        if (list3 == null) {
            if (list4 != null) {
                return false;
            }
        } else if (!list3.equals(list4)) {
            return false;
        }
        Date date = this.creationTime;
        Date date2 = pHRule.creationTime;
        if (date == null) {
            if (date2 != null) {
                return false;
            }
        } else if (!date.equals(date2)) {
            return false;
        }
        Date date3 = this.lastTriggered;
        Date date4 = pHRule.lastTriggered;
        if (date3 == null) {
            if (date4 != null) {
                return false;
            }
        } else if (!date3.equals(date4)) {
            return false;
        }
        String str = this.owner;
        String str2 = pHRule.owner;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        PHRuleStatus pHRuleStatus = this.status;
        PHRuleStatus pHRuleStatus2 = pHRule.status;
        if (pHRuleStatus == null) {
            if (pHRuleStatus2 != null) {
                return false;
            }
        } else if (!pHRuleStatus.equals(pHRuleStatus2)) {
            return false;
        }
        return this.timesTriggered == pHRule.timesTriggered;
    }

    public List<PHRuleAction> getActions() {
        return this.actions;
    }

    public List<PHRuleCondition> getConditions() {
        return this.conditions;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public Date getLastTriggered() {
        return this.lastTriggered;
    }

    public String getOwner() {
        return this.owner;
    }

    public PHRuleStatus getStatus() {
        return this.status;
    }

    public int getTimesTriggered() {
        return this.timesTriggered;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        List<PHRuleAction> list = this.actions;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<PHRuleCondition> list2 = this.conditions;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Date date = this.creationTime;
        int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.lastTriggered;
        int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
        String str = this.owner;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        PHRuleStatus pHRuleStatus = this.status;
        return ((iHashCode6 + (pHRuleStatus != null ? pHRuleStatus.hashCode() : 0)) * 31) + this.timesTriggered;
    }

    public void setActions(List<PHRuleAction> list) {
        this.actions = list;
    }

    public void setConditions(List<PHRuleCondition> list) {
        this.conditions = list;
    }

    public void setCreationTime(Date date) {
        this.creationTime = date;
    }

    public void setLastTriggered(Date date) {
        this.lastTriggered = date;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setStatus(PHRuleStatus pHRuleStatus) {
        this.status = pHRuleStatus;
    }

    public void setTimesTriggered(int i) {
        this.timesTriggered = i;
    }
}
