package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.PHSchedule;
import java.util.List;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface PHScheduleSerializer extends PHSerializer {
    boolean canCreate();

    boolean canDelete();

    boolean canFetchAll();

    boolean canRead();

    boolean canUpdate();

    JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2);

    JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3);

    JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3, boolean z);

    JSONObject createSchedulePacket(PHSchedule pHSchedule, String str, String str2, boolean z);

    List<PHSchedule> parseSchedules(JSONObject jSONObject, String str);

    JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2);

    JSONObject updateSchedulePacket(PHSchedule pHSchedule, String str, String str2, String str3);

    boolean validateAPI(PHSchedule pHSchedule);
}
