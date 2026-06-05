package com.philips.lighting.hue.sdk.clip.serialisation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
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
public class PHScheduleSerializer2 extends PHScheduleSerializer1 {
    private static PHScheduleSerializer2 schedulesSerialisation2;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHScheduleSerializer2 m857getInstance() {
        try {
            if (schedulesSerialisation2 == null) {
                schedulesSerialisation2 = new PHScheduleSerializer2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return schedulesSerialisation2;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean canUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3) {
        JSONObject jSONObjectCreateSchedulePacket = super.createSchedulePacket(pHSchedule, str, str2, str3);
        PHDateTimePattern pHDateTimePattern = new PHDateTimePattern();
        pHDateTimePattern.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
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
        if (pHSchedule.getLightState() == null && pHSchedule.getSceneIdentifier() != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("scene", pHSchedule.getSceneIdentifier());
            JSONObject jSONObjectOptJSONObject = jSONObjectCreateSchedulePacket.optJSONObject("command");
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.putOpt(SDKConstants.PARAM_A2U_BODY, jSONObject);
                jSONObjectCreateSchedulePacket.put("command", jSONObjectOptJSONObject);
            }
        }
        jSONObjectCreateSchedulePacket.remove("time");
        jSONObjectCreateSchedulePacket.putOpt("time", pHDateTimePattern.patternAsString());
        return jSONObjectCreateSchedulePacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public List<PHSchedule> parseSchedules(JSONObject jSONObject, String str) {
        Date dateStringToDate;
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
                        PHSchedule singleSchedule = super.parseSingleSchedule(strOptString, jSONObjectOptJSONObject2);
                        String strOptString2 = jSONObjectOptJSONObject2.optString("created");
                        if (strOptString2 != null && strOptString2.length() > 0 && (dateStringToDate = PHUtilities.stringToDate(strOptString2, "UTC")) != null) {
                            singleSchedule.setCreated(dateStringToDate);
                        }
                        String strOptString3 = jSONObjectOptJSONObject2.optString("time");
                        if (strOptString3 != null && strOptString3.length() > 0) {
                            PHDateTimePattern pHDateTimePatternPatternWithTimeString = PHDateTimePattern.patternWithTimeString(strOptString3, DesugarTimeZone.getTimeZone("UTC"));
                            if (pHDateTimePatternPatternWithTimeString == null) {
                                throw new JSONException(PHHueResourcesConstants.TXT_INVALID_JSON);
                            }
                            singleSchedule.setDate(pHDateTimePatternPatternWithTimeString.getDate());
                            singleSchedule.setTimer(pHDateTimePatternPatternWithTimeString.getTimer() != null ? pHDateTimePatternPatternWithTimeString.getTimer().intValue() : 0);
                            singleSchedule.setRecurringTimerInterval(pHDateTimePatternPatternWithTimeString.getRecurringTimerInterval() != null ? pHDateTimePatternPatternWithTimeString.getRecurringTimerInterval().intValue() : 0);
                            singleSchedule.setRandomTime(pHDateTimePatternPatternWithTimeString.getRandomTime() != null ? pHDateTimePatternPatternWithTimeString.getRandomTime().intValue() : 0);
                            singleSchedule.setRecurringDays(pHDateTimePatternPatternWithTimeString.getRecurringDays().intValue());
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

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2) {
        return updateSchedulePacket(pHSchedule, str, str2, "UTC");
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean validateAPI(PHSchedule pHSchedule) {
        if (pHSchedule.getRecurringDays() == PHSchedule.RecurringDay.RECURRING_NONE.getValue() && pHSchedule.getRandomTime() == 0) {
            return pHSchedule.getLocalTime() == null || !pHSchedule.getLocalTime().booleanValue();
        }
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3) {
        return createSchedulePacket(pHSchedule, str, str2, str3);
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2) {
        return createSchedulePacket(pHSchedule, str, str2, "UTC");
    }
}
