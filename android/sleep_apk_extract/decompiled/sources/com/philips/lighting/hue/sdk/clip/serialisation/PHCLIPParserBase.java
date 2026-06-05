package com.philips.lighting.hue.sdk.clip.serialisation;

import com.facebook.GraphResponse;
import com.facebook.appevents.integrity.IntegrityManager;
import com.philips.lighting.hue.sdk.clip.PHCLIPParser;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHHueParsingError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHCLIPParserBase implements PHCLIPParser {
    private static PHCLIPParserBase clipParserBase;
    private List<PHHueParsingError> parsingErrors = new ArrayList();

    public static synchronized PHCLIPParserBase getInstance() {
        try {
            if (clipParserBase == null) {
                clipParserBase = new PHCLIPParserBase();
            }
        } catch (Throwable th) {
            throw th;
        }
        return clipParserBase;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHCLIPParser
    public void clearErrors() {
        this.parsingErrors.clear();
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHCLIPParser
    public List<PHHueParsingError> getParsingErrors() {
        return this.parsingErrors;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHCLIPParser
    public List<PHHueError> parseError(String str) {
        JSONObject jSONObjectOptJSONObject;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("error")) != null) {
                    arrayList.add(new PHHueError(jSONObjectOptJSONObject.optInt("type"), jSONObjectOptJSONObject.optString("description"), jSONObjectOptJSONObject.optString(IntegrityManager.INTEGRITY_TYPE_ADDRESS)));
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHCLIPParser
    public boolean parseIsSuccess(String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONArray(str).optJSONObject(0);
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optString(GraphResponse.SUCCESS_KEY) != null;
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHCLIPParser
    public Map<String, String> parseSuccess(String str) {
        JSONObject jSONObjectOptJSONObject;
        HashMap map = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(GraphResponse.SUCCESS_KEY)) != null) {
                    Iterator itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String str2 = (String) itKeys.next();
                        map.put(str2, jSONObjectOptJSONObject.optString(str2));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return map;
    }

    public void reportParsingError(int i, String str, String str2, JSONObject jSONObject) {
        this.parsingErrors.add(new PHHueParsingError(i, str, str2, jSONObject));
    }
}
