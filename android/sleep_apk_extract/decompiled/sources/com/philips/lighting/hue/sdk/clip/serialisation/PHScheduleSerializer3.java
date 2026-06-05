package com.philips.lighting.hue.sdk.clip.serialisation;

import com.facebook.internal.AnalyticsEvents;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.utilities.PHDateTimePattern;
import com.philips.lighting.hue.sdk.utilities.PHUtilities;
import com.philips.lighting.model.PHSchedule;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHScheduleSerializer3 extends PHScheduleSerializer2 {
    private static PHScheduleSerializer3 schedulesSerialisation3;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHScheduleSerializer3 m858getInstance() {
        try {
            if (schedulesSerialisation3 == null) {
                schedulesSerialisation3 = new PHScheduleSerializer3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return schedulesSerialisation3;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3) {
        String str4;
        JSONObject jSONObjectCreateSchedulePacket = super.createSchedulePacket(pHSchedule, str, str2, str3);
        PHSchedule.PHScheduleStatus status = pHSchedule.getStatus();
        if (status == PHSchedule.PHScheduleStatus.ENABLED) {
            jSONObjectCreateSchedulePacket.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "enabled");
        } else if (status == PHSchedule.PHScheduleStatus.DISABLED) {
            jSONObjectCreateSchedulePacket.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "disabled");
        }
        PHDateTimePattern pHDateTimePattern = new PHDateTimePattern();
        pHDateTimePattern.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        if (pHSchedule.getLocalTime() == null || !pHSchedule.getLocalTime().booleanValue()) {
            str4 = "time";
        } else {
            pHDateTimePattern.setTimeZone(DesugarTimeZone.getTimeZone(str3));
            str4 = "localtime";
        }
        if (pHSchedule.getRandomTime() != 0) {
            pHDateTimePattern.setRandomTime(Integer.valueOf(pHSchedule.getRandomTime()));
        }
        if (pHSchedule.getDate() != null) {
            pHDateTimePattern.setDate(pHSchedule.getDate());
            if (pHSchedule.getRecurringDays() != 0) {
                pHDateTimePattern.setRecurringDays(Integer.valueOf(pHSchedule.getRecurringDays()));
            }
        } else if (pHSchedule.getTimer() != 0) {
            pHDateTimePattern.setTimer(Integer.valueOf(pHSchedule.getTimer()));
            if ((pHSchedule.getRecurringTimerInterval() >= 1 && pHSchedule.getRecurringTimerInterval() <= 99) || pHSchedule.getRecurringTimerInterval() == -1) {
                pHDateTimePattern.setRecurringTimerInterval(Integer.valueOf(pHSchedule.getRecurringTimerInterval()));
            }
        }
        jSONObjectCreateSchedulePacket.remove("time");
        jSONObjectCreateSchedulePacket.putOpt(str4, pHDateTimePattern.patternAsString());
        return jSONObjectCreateSchedulePacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public List<PHSchedule> parseSchedules(JSONObject jSONObject, String str) {
        Date dateStringToDate;
        Date dateStringToDate2;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("schedules");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String strOptString = jSONArrayNames.optString(i);
                try {
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject2 != null) {
                        PHSchedule singleSchedule = parseSingleSchedule(strOptString, jSONObjectOptJSONObject2);
                        String strOptString2 = jSONObjectOptJSONObject2.optString("created");
                        if (strOptString2 != null && strOptString2.length() > 0 && (dateStringToDate2 = PHUtilities.stringToDate(strOptString2, "UTC")) != null) {
                            singleSchedule.setCreated(dateStringToDate2);
                        }
                        String strOptString3 = jSONObjectOptJSONObject2.optString("starttime");
                        if (strOptString3 != null && strOptString3.length() > 0 && (dateStringToDate = PHUtilities.stringToDate(strOptString3, "UTC")) != null) {
                            singleSchedule.setStartTime(dateStringToDate);
                        }
                        String strOptString4 = jSONObjectOptJSONObject2.optString("time");
                        if (strOptString4 != null && strOptString4.length() > 0) {
                            PHDateTimePattern pHDateTimePatternPatternWithTimeString = PHDateTimePattern.patternWithTimeString(strOptString4, DesugarTimeZone.getTimeZone("UTC"));
                            if (pHDateTimePatternPatternWithTimeString == null) {
                                throw new JSONException(PHHueResourcesConstants.TXT_INVALID_JSON);
                            }
                            singleSchedule.setDate(pHDateTimePatternPatternWithTimeString.getDate());
                            singleSchedule.setTimer(pHDateTimePatternPatternWithTimeString.getTimer() != null ? pHDateTimePatternPatternWithTimeString.getTimer().intValue() : 0);
                            singleSchedule.setRecurringTimerInterval(pHDateTimePatternPatternWithTimeString.getRecurringTimerInterval() != null ? pHDateTimePatternPatternWithTimeString.getRecurringTimerInterval().intValue() : 0);
                            singleSchedule.setRandomTime(pHDateTimePatternPatternWithTimeString.getRandomTime() != null ? pHDateTimePatternPatternWithTimeString.getRandomTime().intValue() : 0);
                            singleSchedule.setRecurringDays(pHDateTimePatternPatternWithTimeString.getRecurringDays().intValue());
                        }
                        String strOptString5 = jSONObjectOptJSONObject2.optString("localtime");
                        if (strOptString5 != null && strOptString5.length() > 0) {
                            if (str == null) {
                                str = "UTC";
                            }
                            PHDateTimePattern pHDateTimePatternPatternWithTimeString2 = PHDateTimePattern.patternWithTimeString(strOptString5, DesugarTimeZone.getTimeZone(str));
                            if (pHDateTimePatternPatternWithTimeString2 == null) {
                                throw new JSONException(PHHueResourcesConstants.TXT_INVALID_JSON);
                            }
                            singleSchedule.setLocalTime(Boolean.TRUE);
                            singleSchedule.setDate(pHDateTimePatternPatternWithTimeString2.getDate());
                            singleSchedule.setTimer(pHDateTimePatternPatternWithTimeString2.getTimer() != null ? pHDateTimePatternPatternWithTimeString2.getTimer().intValue() : 0);
                            singleSchedule.setRecurringTimerInterval(pHDateTimePatternPatternWithTimeString2.getRecurringTimerInterval() != null ? pHDateTimePatternPatternWithTimeString2.getRecurringTimerInterval().intValue() : 0);
                            singleSchedule.setRandomTime(pHDateTimePatternPatternWithTimeString2.getRandomTime() != null ? pHDateTimePatternPatternWithTimeString2.getRandomTime().intValue() : 0);
                            singleSchedule.setRecurringDays(pHDateTimePatternPatternWithTimeString2.getRecurringDays().intValue());
                        }
                        String strOptString6 = jSONObjectOptJSONObject2.optString("owner");
                        if (!strOptString6.isEmpty()) {
                            singleSchedule.setOwner(strOptString6);
                        }
                        String strOptString7 = jSONObjectOptJSONObject2.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                        if (strOptString7.equals("active") || strOptString7.equals("enabled")) {
                            singleSchedule.setStatus(PHSchedule.PHScheduleStatus.ENABLED);
                        } else if (strOptString7.equals("disabled")) {
                            singleSchedule.setStatus(PHSchedule.PHScheduleStatus.DISABLED);
                        } else if (strOptString7.toLowerCase().contains("resource") && strOptString7.toLowerCase().contains("deleted")) {
                            singleSchedule.setStatus(PHSchedule.PHScheduleStatus.RESOURCE_DELETED);
                        } else if (strOptString7.equals("error")) {
                            singleSchedule.setStatus(PHSchedule.PHScheduleStatus.ERROR);
                        } else {
                            singleSchedule.setStatus(PHSchedule.PHScheduleStatus.UNKNOWN);
                        }
                        arrayList.add(singleSchedule);
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                    reportParsingError(64, strOptString, "Schedule unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject(strOptString));
                }
            }
        }
        return arrayList;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2) {
        return updateSchedulePacket(pHSchedule, str, str2, "UTC");
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean validateAPI(PHSchedule pHSchedule) {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3) {
        return createSchedulePacket(pHSchedule, str, str2, str3);
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2) {
        return createSchedulePacket(pHSchedule, str, str2, "UTC");
    }
}
