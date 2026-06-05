package com.philips.lighting.model;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import java.util.Date;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHSchedule extends PHBridgeResource {
    public static final int INFINITY = -1;
    private Boolean autodelete;
    private Date created;
    private Date date;
    private String description;
    private String groupIdentifier;
    private Boolean hasLocalTime;
    private String lightIdentifier;
    private PHLightState lightState;
    private String owner;
    private int randomTime;
    private int recurringDays;
    private int recurringTimerInterval;
    private String sceneIdentifier;
    private Date startTime;
    private PHScheduleStatus status;
    private int timer;

    public enum PHScheduleStatus {
        ENABLED,
        DISABLED,
        RESOURCE_DELETED,
        ERROR,
        UNKNOWN;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHScheduleStatus[] valuesCustom() {
            PHScheduleStatus[] pHScheduleStatusArrValuesCustom = values();
            int length = pHScheduleStatusArrValuesCustom.length;
            PHScheduleStatus[] pHScheduleStatusArr = new PHScheduleStatus[length];
            System.arraycopy(pHScheduleStatusArrValuesCustom, 0, pHScheduleStatusArr, 0, length);
            return pHScheduleStatusArr;
        }
    }

    public enum RecurringDay {
        RECURRING_NONE(0),
        RECURRING_MONDAY(64),
        RECURRING_TUESDAY(32),
        RECURRING_WEDNESDAY(16),
        RECURRING_THURSDAY(8),
        RECURRING_FRIDAY(4),
        RECURRING_SATURDAY(2),
        RECURRING_SUNDAY(1),
        RECURRING_WEEKDAYS(124),
        RECURRING_WEEKEND(3),
        RECURRING_ALL_DAY(127);

        private int value;

        RecurringDay(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static RecurringDay[] valuesCustom() {
            RecurringDay[] recurringDayArrValuesCustom = values();
            int length = recurringDayArrValuesCustom.length;
            RecurringDay[] recurringDayArr = new RecurringDay[length];
            System.arraycopy(recurringDayArrValuesCustom, 0, recurringDayArr, 0, length);
            return recurringDayArr;
        }

        public int getValue() {
            return this.value;
        }
    }

    public PHSchedule(PHSchedule pHSchedule) {
        super(isNull(pHSchedule).getName(), isNull(pHSchedule).getIdentifier());
        this.description = "";
        this.hasLocalTime = null;
        this.autodelete = null;
        this.created = pHSchedule.created;
        this.date = pHSchedule.date;
        this.description = pHSchedule.description;
        this.groupIdentifier = pHSchedule.groupIdentifier;
        this.lightIdentifier = pHSchedule.lightIdentifier;
        this.lightState = pHSchedule.lightState;
        this.randomTime = pHSchedule.randomTime;
        this.recurringDays = pHSchedule.recurringDays;
        this.recurringTimerInterval = pHSchedule.recurringTimerInterval;
        this.sceneIdentifier = pHSchedule.sceneIdentifier;
        this.timer = pHSchedule.timer;
        this.hasLocalTime = pHSchedule.hasLocalTime;
        this.autodelete = pHSchedule.autodelete;
        this.owner = pHSchedule.owner;
        this.status = pHSchedule.status;
        this.startTime = pHSchedule.startTime;
    }

    private static PHBridgeResource isNull(PHSchedule pHSchedule) {
        if (pHSchedule != null) {
            return pHSchedule;
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
        PHSchedule pHSchedule = (PHSchedule) obj;
        Date date = this.created;
        Date date2 = pHSchedule.created;
        if (date == null) {
            if (date2 != null) {
                return false;
            }
        } else if (!date.equals(date2)) {
            return false;
        }
        Date date3 = this.date;
        Date date4 = pHSchedule.date;
        if (date3 == null) {
            if (date4 != null) {
                return false;
            }
        } else if (!date3.equals(date4)) {
            return false;
        }
        String str = this.description;
        String str2 = pHSchedule.description;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.groupIdentifier;
        String str4 = pHSchedule.groupIdentifier;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        Boolean bool = this.hasLocalTime;
        Boolean bool2 = pHSchedule.hasLocalTime;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        Boolean bool3 = this.autodelete;
        Boolean bool4 = pHSchedule.autodelete;
        if (bool3 == null) {
            if (bool4 != null) {
                return false;
            }
        } else if (!bool3.equals(bool4)) {
            return false;
        }
        String str5 = this.lightIdentifier;
        String str6 = pHSchedule.lightIdentifier;
        if (str5 == null) {
            if (str6 != null) {
                return false;
            }
        } else if (!str5.equals(str6)) {
            return false;
        }
        PHLightState pHLightState = this.lightState;
        PHLightState pHLightState2 = pHSchedule.lightState;
        if (pHLightState == null) {
            if (pHLightState2 != null) {
                return false;
            }
        } else if (!pHLightState.equals(pHLightState2)) {
            return false;
        }
        String str7 = this.owner;
        String str8 = pHSchedule.owner;
        if (str7 == null) {
            if (str8 != null) {
                return false;
            }
        } else if (!str7.equals(str8)) {
            return false;
        }
        if (this.randomTime != pHSchedule.randomTime || this.recurringDays != pHSchedule.recurringDays || this.recurringTimerInterval != pHSchedule.recurringTimerInterval) {
            return false;
        }
        String str9 = this.sceneIdentifier;
        String str10 = pHSchedule.sceneIdentifier;
        if (str9 == null) {
            if (str10 != null) {
                return false;
            }
        } else if (!str9.equals(str10)) {
            return false;
        }
        Date date5 = this.startTime;
        Date date6 = pHSchedule.startTime;
        if (date5 == null) {
            if (date6 != null) {
                return false;
            }
        } else if (!date5.equals(date6)) {
            return false;
        }
        return this.status == pHSchedule.status && this.timer == pHSchedule.timer;
    }

    public Boolean getAutoDelete() {
        Boolean bool = this.autodelete;
        return bool == null ? Boolean.TRUE : bool;
    }

    public Date getCreated() {
        return this.created;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupIdentifier() {
        return this.groupIdentifier;
    }

    public String getLightIdentifier() {
        return this.lightIdentifier;
    }

    public PHLightState getLightState() {
        return this.lightState;
    }

    public Boolean getLocalTime() {
        return this.hasLocalTime;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getRandomTime() {
        return this.randomTime;
    }

    public int getRecurringDays() {
        return this.recurringDays;
    }

    public int getRecurringTimerInterval() {
        return this.recurringTimerInterval;
    }

    public String getSceneIdentifier() {
        return this.sceneIdentifier;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public PHScheduleStatus getStatus() {
        return this.status;
    }

    public int getTimer() {
        return this.timer;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Date date = this.created;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.date;
        int iHashCode3 = (iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31;
        String str = this.description;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.groupIdentifier;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.hasLocalTime;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.autodelete;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.lightIdentifier;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        PHLightState pHLightState = this.lightState;
        int iHashCode9 = (iHashCode8 + (pHLightState == null ? 0 : pHLightState.hashCode())) * 31;
        String str4 = this.owner;
        int iHashCode10 = (((((((iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.randomTime) * 31) + this.recurringDays) * 31) + this.recurringTimerInterval) * 31;
        String str5 = this.sceneIdentifier;
        int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Date date3 = this.startTime;
        int iHashCode12 = (iHashCode11 + (date3 == null ? 0 : date3.hashCode())) * 31;
        PHScheduleStatus pHScheduleStatus = this.status;
        return ((iHashCode12 + (pHScheduleStatus != null ? pHScheduleStatus.hashCode() : 0)) * 31) + this.timer;
    }

    public void setAutoDelete(Boolean bool) {
        this.autodelete = bool;
    }

    public void setCreated(Date date) {
        this.created = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGroupIdentifier(String str) {
        this.groupIdentifier = str;
    }

    public void setLightIdentifier(String str) {
        this.lightIdentifier = str;
    }

    public void setLightState(PHLightState pHLightState) {
        this.lightState = pHLightState;
    }

    public void setLocalTime(Boolean bool) {
        this.hasLocalTime = bool;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setRandomTime(int i) {
        this.randomTime = i;
    }

    public void setRecurringDays(int i) {
        this.recurringDays = i;
    }

    public void setRecurringTimerInterval(int i) {
        this.recurringTimerInterval = i;
    }

    public void setSceneIdentifier(String str) {
        this.sceneIdentifier = str;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public void setStatus(PHScheduleStatus pHScheduleStatus) {
        this.status = pHScheduleStatus;
    }

    public void setTimer(int i) {
        this.timer = i;
    }

    public PHSchedule(String str, String str2) {
        super(str, str2);
        this.description = "";
        this.hasLocalTime = null;
        this.autodelete = null;
    }

    public PHSchedule(String str) {
        super(str, null);
        this.description = "";
        this.hasLocalTime = null;
        this.autodelete = null;
    }
}
