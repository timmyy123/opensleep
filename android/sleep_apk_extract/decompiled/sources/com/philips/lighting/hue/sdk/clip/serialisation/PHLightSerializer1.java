package com.philips.lighting.hue.sdk.clip.serialisation;

import com.facebook.appevents.UserDataStore;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.hue.sdk.clip.PHLightSerializer;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightSerializer1 extends PHCLIPParserBase implements PHLightSerializer {
    private static final String TAG = "PHLightSerializer1";
    private static PHLightSerializer1 lightSerialisation1;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHLightSerializer1 m844getInstance() {
        try {
            if (lightSerialisation1 == null) {
                lightSerialisation1 = new PHLightSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return lightSerialisation1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canCreate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canDelete() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canFetchAll() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightConfigurationCreate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightConfigurationDelete() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightConfigurationRead() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightConfigurationUpdate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightStateCreate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightStateDelete() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightStateRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightStateUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public JSONObject createFindLightWithSerialsPacket(List<String> list) {
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public JSONObject createLightStatePacket(PHLightState pHLightState) {
        String value;
        String value2;
        JSONObject jSONObject = new JSONObject();
        if (pHLightState.getHue() != null) {
            jSONObject.putOpt("hue", pHLightState.getHue());
        }
        if (pHLightState.isOn() != null) {
            jSONObject.putOpt("on", pHLightState.isOn());
        }
        if (pHLightState.getBrightness() != null) {
            jSONObject.putOpt("bri", pHLightState.getBrightness());
        }
        if (pHLightState.getSaturation() != null) {
            jSONObject.putOpt("sat", pHLightState.getSaturation());
        }
        if (pHLightState.getTransitionTime() != null) {
            jSONObject.putOpt("transitiontime", pHLightState.getTransitionTime());
        }
        if (pHLightState.getCt() != null) {
            jSONObject.putOpt(UserDataStore.CITY, pHLightState.getCt());
        }
        if (pHLightState.isReachable() != null) {
            jSONObject.putOpt("reachable", pHLightState.isReachable());
        }
        if (pHLightState.getX() != null && pHLightState.getY() != null) {
            JSONArray jSONArray = new JSONArray();
            Locale locale = Locale.ENGLISH;
            JSONObject jSONObject2 = new JSONObject(String.format(locale, "{\"tempX\": %.4f}", pHLightState.getX()));
            JSONObject jSONObject3 = new JSONObject(String.format(locale, "{\"tempY\": %.4f}", pHLightState.getY()));
            jSONArray.put(jSONObject2.get("tempX"));
            jSONArray.put(jSONObject3.get("tempY"));
            jSONObject.putOpt("xy", jSONArray);
        }
        if (pHLightState.getAlertMode() != null && (value2 = pHLightState.getAlertMode().getValue()) != null) {
            jSONObject.putOpt("alert", value2);
        }
        if (pHLightState.getEffectMode() != null && (value = pHLightState.getEffectMode().getValue()) != null) {
            jSONObject.putOpt("effect", value);
        }
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public List<PHBridgeResource> parseGetAllLightHeaders(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayNames = jSONObject.names();
            arrayList.clear();
            if (jSONArrayNames != null) {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String strOptString = jSONArrayNames.optString(i);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new PHBridgeResource(jSONObjectOptJSONObject.optString("name"), strOptString));
                    }
                }
            }
            return arrayList;
        } catch (JSONException e) {
            if (!PHLog.isLoggable()) {
                return null;
            }
            PHLog.e(TAG, "JSONException: " + e);
            return null;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public PHLight parseLightDetails(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("name");
            String strOptString2 = jSONObject.optString("type");
            PHLight pHLight = new PHLight(strOptString, str2, jSONObject.optString("swversion"), jSONObject.optString("modelid"));
            pHLight.setLightType(strOptString2);
            return pHLight;
        } catch (JSONException e) {
            if (!PHLog.isLoggable()) {
                return null;
            }
            PHLog.e(TAG, "JSONException: " + e);
            return null;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public PHLightState parseLightState(JSONObject jSONObject) {
        Float fValueOf;
        Float fValueOf2;
        Integer num;
        Integer num2;
        Float fValueOf3;
        Float fValueOf4;
        JSONArray jSONArrayOptJSONArray;
        PHLightState pHLightState = new PHLightState();
        Boolean boolValueOf = jSONObject.isNull("on") ? null : Boolean.valueOf(jSONObject.optBoolean("on"));
        Integer numValueOf = jSONObject.has("bri") ? Integer.valueOf(jSONObject.optInt("bri")) : null;
        Integer numValueOf2 = jSONObject.has("hue") ? Integer.valueOf(jSONObject.optInt("hue")) : null;
        Integer numValueOf3 = jSONObject.has("sat") ? Integer.valueOf(jSONObject.optInt("sat")) : null;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.has("xy") ? jSONObject.optJSONArray("xy") : null;
        if (jSONArrayOptJSONArray2 != null) {
            fValueOf2 = Float.valueOf((float) jSONArrayOptJSONArray2.optDouble(0));
            fValueOf = Float.valueOf((float) jSONArrayOptJSONArray2.optDouble(1));
        } else {
            fValueOf = null;
            fValueOf2 = null;
        }
        Integer numValueOf4 = jSONObject.has(UserDataStore.CITY) ? Integer.valueOf(jSONObject.optInt(UserDataStore.CITY)) : null;
        Boolean boolValueOf2 = jSONObject.isNull("reachable") ? null : Boolean.valueOf(jSONObject.optBoolean("reachable"));
        Integer numValueOf5 = jSONObject.has("bri_inc") ? Integer.valueOf(jSONObject.optInt("bri_inc")) : null;
        Integer numValueOf6 = jSONObject.has("ct_inc") ? Integer.valueOf(jSONObject.optInt("ct_inc")) : null;
        Integer numValueOf7 = jSONObject.has("hue_inc") ? Integer.valueOf(jSONObject.optInt("hue_inc")) : null;
        Integer numValueOf8 = jSONObject.has("sat_inc") ? Integer.valueOf(jSONObject.optInt("sat_inc")) : null;
        if (!jSONObject.has("xy_inc") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("xy_inc")) == null) {
            num = numValueOf6;
            num2 = numValueOf7;
            fValueOf3 = null;
            fValueOf4 = null;
        } else {
            num = numValueOf6;
            num2 = numValueOf7;
            fValueOf4 = Float.valueOf((float) jSONArrayOptJSONArray.optDouble(0));
            fValueOf3 = Float.valueOf((float) jSONArrayOptJSONArray.optDouble(1));
        }
        String strOptString = jSONObject.optString("alert");
        String strOptString2 = jSONObject.optString("effect");
        String strOptString3 = jSONObject.optString("colormode");
        pHLightState.setOn(boolValueOf);
        pHLightState.setBrightness(numValueOf);
        pHLightState.setHue(numValueOf2);
        pHLightState.setSaturation(numValueOf3);
        pHLightState.setX(fValueOf2);
        pHLightState.setY(fValueOf);
        pHLightState.setCt(numValueOf4);
        pHLightState.setReachable(boolValueOf2);
        pHLightState.setAlertMode(PHLight.PHLightAlertMode.fromString(strOptString));
        pHLightState.setEffectMode(PHLight.PHLightEffectMode.fromString(strOptString2));
        pHLightState.setColorMode(PHLight.PHLightColorMode.fromString(strOptString3));
        pHLightState.setIncrementBri(numValueOf5);
        pHLightState.setIncrementCt(num);
        pHLightState.setIncrementHue(num2);
        pHLightState.setIncrementSat(numValueOf8);
        pHLightState.setIncrementX(fValueOf4);
        pHLightState.setIncrementY(fValueOf3);
        return pHLightState;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public List<PHLight> parseLights(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("lights");
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
                        String strOptString2 = jSONObjectOptJSONObject2.optString("type");
                        String strOptString3 = jSONObjectOptJSONObject2.optString("name");
                        String strOptString4 = jSONObjectOptJSONObject2.optString("modelid");
                        String strOptString5 = jSONObjectOptJSONObject2.optString("swversion");
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
                        PHLight pHLight = new PHLight(strOptString3, strOptString, strOptString5, strOptString4);
                        pHLight.setLightType(strOptString2);
                        if (jSONObjectOptJSONObject3 != null) {
                            PHLightState lightState = parseLightState(jSONObjectOptJSONObject3);
                            if (lightState != null) {
                                pHLight.setLastKnownLightState(lightState);
                            }
                        } else {
                            pHLight.setLastKnownLightState(null);
                        }
                        arrayList.add(pHLight);
                    }
                } catch (Exception e) {
                    reportParsingError(61, strOptString, "Light unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject(strOptString));
                }
            }
        }
        return arrayList;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public JSONObject updateLightPacket(PHLight pHLight) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("name", pHLight.getName());
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public JSONObject updateLightStatePacket(PHLightState pHLightState) {
        JSONObject jSONObjectCreateLightStatePacket = createLightStatePacket(pHLightState);
        if (jSONObjectCreateLightStatePacket != null) {
            return jSONObjectCreateLightStatePacket;
        }
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean validateAPI(PHLight pHLight) {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean validateAPI(PHLightState pHLightState) {
        return true;
    }
}
