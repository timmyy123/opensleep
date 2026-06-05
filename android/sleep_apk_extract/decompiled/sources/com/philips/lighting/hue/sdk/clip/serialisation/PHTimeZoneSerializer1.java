package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.clip.PHTimeZoneSerializer;
import java.util.ArrayList;
import java.util.List;
import org.json.hue.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class PHTimeZoneSerializer1 extends PHCLIPParserBase implements PHTimeZoneSerializer {
    private static PHTimeZoneSerializer1 timeZoneSerializer1;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHTimeZoneSerializer1 m862getInstance() {
        try {
            if (timeZoneSerializer1 == null) {
                timeZoneSerializer1 = new PHTimeZoneSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return timeZoneSerializer1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHTimeZoneSerializer
    public List<String> parseTimeZones(String str) {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }
}
