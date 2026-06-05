package com.philips.lighting.hue.sdk.clip.serialisation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.philips.lighting.hue.sdk.clip.PHScheduleSerializer;
import com.philips.lighting.hue.sdk.exception.PHHueException;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.utilities.PHDateTimePattern;
import com.philips.lighting.model.PHLightState;
import com.philips.lighting.model.PHSchedule;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHScheduleSerializer1 extends PHCLIPParserBase implements PHScheduleSerializer {
    private static PHScheduleSerializer1 schedulesSerialisation1;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHScheduleSerializer1 m856getInstance() {
        try {
            if (schedulesSerialisation1 == null) {
                schedulesSerialisation1 = new PHScheduleSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return schedulesSerialisation1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean canCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean canDelete() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean canFetchAll() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean canRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean canUpdate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            jSONObject.putOpt(IntegrityManager.INTEGRITY_TYPE_ADDRESS, str);
        }
        if (str2 != null) {
            jSONObject.putOpt("method", str2);
        }
        if (pHSchedule.getLightState() != null) {
            jSONObject.putOpt(SDKConstants.PARAM_A2U_BODY, PHBridgeVersionManager.getInstance().getLightSerializer().createLightStatePacket(pHSchedule.getLightState()));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (pHSchedule.getName() != null) {
            jSONObject2.putOpt("name", pHSchedule.getName());
        }
        if (pHSchedule.getDescription() != null && pHSchedule.getDescription().length() != 0) {
            jSONObject2.putOpt("description", pHSchedule.getDescription());
        }
        jSONObject2.putOpt("command", jSONObject);
        Date date = pHSchedule.getDate();
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", new Locale("nl_NL"));
            if (str3 == null || str3.length() == 0) {
                str3 = "UTC";
            }
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(str3));
            jSONObject2.putOpt("time", simpleDateFormat.format(date));
        }
        return jSONObject2;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public List<PHSchedule> parseSchedules(JSONObject jSONObject, String str) {
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
                    arrayList.add(parseSingleSchedule(strOptString, jSONObject.optJSONObject(strOptString)));
                } catch (Exception e) {
                    reportParsingError(64, strOptString, "Schedule unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject(strOptString));
                }
            }
        }
        return arrayList;
    }

    public PHSchedule parseSingleSchedule(String str, JSONObject jSONObject) {
        PHDateTimePattern pHDateTimePatternPatternWithTimeString;
        String strOptString = jSONObject.optString("name");
        if (strOptString == null || strOptString.length() == 0) {
            throw new PHHueException("Schedule unparsable due to error: Name invalid");
        }
        PHSchedule pHSchedule = new PHSchedule(strOptString);
        pHSchedule.setIdentifier(str);
        pHSchedule.setDescription(jSONObject.optString("description"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("command");
        if (jSONObjectOptJSONObject != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            arrayList.add(SDKConstants.PARAM_A2U_BODY);
            arrayList.add("method");
            Iterator itKeys = jSONObjectOptJSONObject.keys();
            int i = 0;
            while (itKeys.hasNext()) {
                String str2 = (String) itKeys.next();
                if (arrayList.contains(str2)) {
                    arrayList.remove(str2);
                    i++;
                }
            }
            if (i != 3) {
                String strM = "";
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    strM = FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(strM), (String) arrayList.get(i2), ",");
                }
                throw new PHHueException(FileInsert$$ExternalSyntheticOutline0.m("JSON is missing key : command(", Fragment$$ExternalSyntheticOutline1.m(1, 0, strM), ")."));
            }
            String strOptString2 = jSONObjectOptJSONObject.optString(IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(SDKConstants.PARAM_A2U_BODY);
            String[] strArrSplit = strOptString2.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (strArrSplit.length > 4) {
                pHSchedule.setOwner(strArrSplit[2]);
                if (strArrSplit[3].equals("groups")) {
                    pHSchedule.setGroupIdentifier(strArrSplit[4]);
                } else if (strArrSplit[3].equals("lights")) {
                    pHSchedule.setLightIdentifier(strArrSplit[4]);
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString3 = jSONObjectOptJSONObject2.optString("scene");
                if (strOptString3 == null || strOptString3.length() == 0) {
                    PHLightState lightState = PHBridgeVersionManager.getInstance().getLightSerializer().parseLightState(jSONObjectOptJSONObject2);
                    if (lightState != null) {
                        pHSchedule.setLightState(lightState);
                    }
                } else {
                    pHSchedule.setSceneIdentifier(strOptString3);
                }
            }
        }
        String strOptString4 = jSONObject.optString("time");
        if (strOptString4 != null && (pHDateTimePatternPatternWithTimeString = PHDateTimePattern.patternWithTimeString(strOptString4, DesugarTimeZone.getTimeZone("UTC"))) != null) {
            pHSchedule.setDate(pHDateTimePatternPatternWithTimeString.getDate());
        }
        return pHSchedule;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2) {
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean validateAPI(PHSchedule pHSchedule) {
        return (pHSchedule.getLocalTime() == null || !pHSchedule.getLocalTime().booleanValue()) && pHSchedule.getRecurringDays() == PHSchedule.RecurringDay.RECURRING_NONE.getValue() && pHSchedule.getRandomTime() == 0;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3) {
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, boolean z) {
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3, boolean z) {
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2) {
        return createSchedulePacket(pHSchedule, str, str2, "UTC");
    }
}
