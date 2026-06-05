package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHSchedule;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHScheduleSerializer5 extends PHScheduleSerializer4 {
    private static PHScheduleSerializer5 schedulesSerialisation5;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHScheduleSerializer5 m860getInstance() {
        try {
            if (schedulesSerialisation5 == null) {
                schedulesSerialisation5 = new PHScheduleSerializer5();
            }
        } catch (Throwable th) {
            throw th;
        }
        return schedulesSerialisation5;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3) {
        JSONObject jSONObjectCreateSchedulePacket = super.createSchedulePacket(pHSchedule, str, str2, str3);
        if (!pHSchedule.getAutoDelete().booleanValue()) {
            jSONObjectCreateSchedulePacket.put("autodelete", false);
        }
        return jSONObjectCreateSchedulePacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public List<PHSchedule> parseSchedules(JSONObject jSONObject, String str) {
        List<PHSchedule> schedules = super.parseSchedules(jSONObject, str);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("schedules");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                schedules.get(i).setAutoDelete(Boolean.valueOf(jSONObject.optJSONObject(jSONArrayNames.optString(i)).optBoolean("autodelete")));
            }
        }
        return schedules;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, boolean z) {
        JSONObject jSONObjectCreateSchedulePacket = super.createSchedulePacket(pHSchedule, str, str2);
        jSONObjectCreateSchedulePacket.put("autodelete", z);
        return jSONObjectCreateSchedulePacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3, boolean z) {
        JSONObject jSONObjectCreateSchedulePacket = super.createSchedulePacket(pHSchedule, str, str2, str3);
        jSONObjectCreateSchedulePacket.put("autodelete", z);
        return jSONObjectCreateSchedulePacket;
    }
}
