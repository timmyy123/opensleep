package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.hue.sdk.utilities.impl.PointD;
import com.philips.lighting.hue.sdk.utilities.impl.RectangleD;
import com.philips.lighting.model.sensor.PHSwitch;
import com.philips.lighting.model.sensor.PHSwitchConfiguration;
import com.philips.lighting.model.sensor.PHSwitchState;
import com.philips.lighting.model.sensor.metadata.PHSwitchButtonActionPair;
import com.philips.lighting.model.sensor.metadata.PHSwitchButtonInfo;
import com.philips.lighting.model.sensor.metadata.PHSwitchDeviceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHSwitchSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHSwitchConfiguration pHSwitchConfiguration) {
        if (pHSwitchConfiguration != null) {
            JSONObject jSONSensorConfigurationBase = PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHSwitchConfiguration);
            String string = jSONObject.getString("type");
            if (string.equals(PHSwitch.Type.ZLL.getValue()) || string.equals(PHSwitch.Type.ZGP.getValue())) {
                jSONSensorConfigurationBase.remove("battery");
            }
            jSONObject.put("config", jSONSensorConfigurationBase);
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHSwitchState pHSwitchState) {
        if (pHSwitchState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHSwitchState);
            String string = jSONObject.getString("type");
            if (!string.equals(PHSwitch.Type.ZLL.getValue()) && !string.equals(PHSwitch.Type.ZGP.getValue())) {
                jSONSensorStateBase.putOpt("buttonevent", pHSwitchState.getButtonEvent());
            }
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHSwitch createConfigurationFromJSON(JSONObject jSONObject, PHSwitch pHSwitch) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            pHSwitch.setConfiguration((PHSwitchConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHSwitchConfiguration(), jSONObjectOptJSONObject));
        }
        return pHSwitch;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0017 A[PHI: r2
      0x0017: PHI (r2v11 com.philips.lighting.model.sensor.PHSwitch$Type) = (r2v9 com.philips.lighting.model.sensor.PHSwitch$Type), (r2v10 com.philips.lighting.model.sensor.PHSwitch$Type) binds: [B:5:0x0015, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PHSwitch createFromJSON(JSONObject jSONObject, String str) {
        PHSwitch.Type type = PHSwitch.Type.CLIP;
        String strOptString = jSONObject.optString("type");
        if (strOptString != null) {
            PHSwitch.Type type2 = PHSwitch.Type.ZLL;
            if (strOptString.equals(type2.getValue())) {
                type = type2;
            } else {
                type2 = PHSwitch.Type.ZGP;
                if (strOptString.equals(type2.getValue())) {
                }
            }
        }
        PHSwitch pHSwitch = (PHSwitch) PHSensorSerializerBase1.fillBasicSensor(new PHSwitch("", str, type), jSONObject);
        if (pHSwitch.getTypeAsString().equals(PHSwitch.Type.ZGP.getValue())) {
            String strReplaceAll = pHSwitch.getUniqueId().split("-")[0].replaceAll(":", "");
            if (strReplaceAll.length() > 8) {
                strReplaceAll = strReplaceAll.substring(strReplaceAll.length() - 8, strReplaceAll.length());
            }
            long j = Long.parseLong(strReplaceAll, 16);
            for (PHSwitchDeviceInfo pHSwitchDeviceInfo : getKnowledgeBase()) {
                if (pHSwitchDeviceInfo.getSrcIdStart() != null) {
                    int i = 0;
                    while (true) {
                        if (i < pHSwitchDeviceInfo.getSrcIdStart().size()) {
                            if (pHSwitchDeviceInfo.getSrcIdStart().get(i).longValue() <= j && pHSwitchDeviceInfo.getSrcIdEnd().get(i).longValue() >= j) {
                                pHSwitch.setDeviceInfo(pHSwitchDeviceInfo);
                                pHSwitch.setModelId(pHSwitch.getDeviceInfo().getModelId());
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        } else if (pHSwitch.getTypeAsString().equals(PHSwitch.Type.ZLL.getValue())) {
            Iterator<PHSwitchDeviceInfo> it = getKnowledgeBase().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PHSwitchDeviceInfo next = it.next();
                if (next.getSrcIdStart() == null && next.getModelId().equals(pHSwitch.getModelId())) {
                    pHSwitch.setDeviceInfo(next);
                    break;
                }
            }
        }
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, pHSwitch));
    }

    private static PHSwitch createStateFromJSON(JSONObject jSONObject, PHSwitch pHSwitch) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHSwitchState pHSwitchState = (PHSwitchState) PHSensorSerializerBase1.fillBasicSensorState(new PHSwitchState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("buttonevent")) {
                pHSwitchState.setButtonEvent(Integer.valueOf(jSONObjectOptJSONObject.optInt("buttonevent")));
            } else {
                pHSwitchState.setButtonEvent(null);
            }
            pHSwitch.setState(pHSwitchState);
        }
        return pHSwitch;
    }

    public static JSONObject getConfigurationJSON(PHSwitch pHSwitch) {
        return getJSON(pHSwitch).getJSONObject("config");
    }

    public static JSONObject getJSON(PHSwitch pHSwitch) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHSwitch);
        jSONSensorBase.putOpt("type", pHSwitch.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHSwitch.getState()), pHSwitch.getConfiguration());
    }

    public static List<PHSwitchDeviceInfo> getKnowledgeBase() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(4194304L);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(4195327L);
        PHSwitchDeviceInfo pHSwitchDeviceInfo = new PHSwitchDeviceInfo("hue TAP dev", "SWT001-DEV", "Philips", arrayList2, arrayList3, "SWT001-housing");
        PHSwitchButtonInfo pHSwitchButtonInfo = new PHSwitchButtonInfo(AppEventsConstants.EVENT_PARAM_VALUE_YES, 11, "SWT001-btn01", new PointD(0.0d, 0.0d), new RectangleD(10.0d, 10.0d, 230.0d, 230.0d));
        PHSwitchButtonInfo pHSwitchButtonInfo2 = new PHSwitchButtonInfo("2", 15, "SWT001-btn02", new PointD(0.0d, 0.0d), new RectangleD(28.0d, 92.0d, 66.0d, 66.0d));
        PHSwitchButtonInfo pHSwitchButtonInfo3 = new PHSwitchButtonInfo("3", 20, "SWT001-btn03", new PointD(0.0d, 0.0d), new RectangleD(90.0d, 154.0d, 66.0d, 66.0d));
        PHSwitchButtonInfo pHSwitchButtonInfo4 = new PHSwitchButtonInfo("4", 25, "SWT001-btn04", new PointD(0.0d, 0.0d), new RectangleD(152.0d, 92.0d, 66.0d, 66.0d));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(pHSwitchButtonInfo);
        arrayList4.add(pHSwitchButtonInfo2);
        arrayList4.add(pHSwitchButtonInfo3);
        arrayList4.add(pHSwitchButtonInfo4);
        pHSwitchDeviceInfo.setButtons(arrayList4);
        PHSwitchButtonActionPair.PHSwitchButtonAction pHSwitchButtonAction = PHSwitchButtonActionPair.PHSwitchButtonAction.SHORT_PRESS;
        PHSwitchButtonActionPair pHSwitchButtonActionPair = new PHSwitchButtonActionPair(pHSwitchButtonInfo, pHSwitchButtonAction);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(pHSwitchButtonActionPair);
        PHSwitchButtonActionPair pHSwitchButtonActionPair2 = new PHSwitchButtonActionPair(pHSwitchButtonInfo2, pHSwitchButtonAction);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(pHSwitchButtonActionPair2);
        PHSwitchButtonActionPair pHSwitchButtonActionPair3 = new PHSwitchButtonActionPair(pHSwitchButtonInfo3, pHSwitchButtonAction);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(pHSwitchButtonActionPair3);
        PHSwitchButtonActionPair pHSwitchButtonActionPair4 = new PHSwitchButtonActionPair(pHSwitchButtonInfo4, pHSwitchButtonAction);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(pHSwitchButtonActionPair4);
        HashMap map = new HashMap();
        map.put(34, arrayList5);
        map.put(16, arrayList6);
        map.put(17, arrayList7);
        map.put(18, arrayList8);
        pHSwitchDeviceInfo.setEventButtonMapping(map);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(4195328L);
        arrayList9.add(4259840L);
        arrayList9.add(4325376L);
        arrayList9.add(4390912L);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(4259839L);
        arrayList10.add(4325375L);
        arrayList10.add(4390911L);
        arrayList10.add(4456447L);
        PHSwitchDeviceInfo pHSwitchDeviceInfo2 = new PHSwitchDeviceInfo("hue TAP", "SWT001", "Philips", arrayList9, arrayList10, "SWT001-housing");
        PHSwitchButtonInfo pHSwitchButtonInfo5 = new PHSwitchButtonInfo(AppEventsConstants.EVENT_PARAM_VALUE_YES, 11, "SWT001-btn01", new PointD(0.0d, 0.0d), new RectangleD(10.0d, 10.0d, 230.0d, 230.0d));
        PHSwitchButtonInfo pHSwitchButtonInfo6 = new PHSwitchButtonInfo("2", 15, "SWT001-btn02", new PointD(0.0d, 0.0d), new RectangleD(28.0d, 92.0d, 66.0d, 66.0d));
        PHSwitchButtonInfo pHSwitchButtonInfo7 = new PHSwitchButtonInfo("3", 20, "SWT001-btn03", new PointD(0.0d, 0.0d), new RectangleD(90.0d, 154.0d, 66.0d, 66.0d));
        PHSwitchButtonInfo pHSwitchButtonInfo8 = new PHSwitchButtonInfo("4", 25, "SWT001-btn04", new PointD(0.0d, 0.0d), new RectangleD(152.0d, 92.0d, 66.0d, 66.0d));
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(pHSwitchButtonInfo5);
        arrayList11.add(pHSwitchButtonInfo6);
        arrayList11.add(pHSwitchButtonInfo7);
        arrayList11.add(pHSwitchButtonInfo8);
        pHSwitchDeviceInfo2.setButtons(arrayList11);
        PHSwitchButtonActionPair pHSwitchButtonActionPair5 = new PHSwitchButtonActionPair(pHSwitchButtonInfo5, pHSwitchButtonAction);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(pHSwitchButtonActionPair5);
        PHSwitchButtonActionPair pHSwitchButtonActionPair6 = new PHSwitchButtonActionPair(pHSwitchButtonInfo6, pHSwitchButtonAction);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(pHSwitchButtonActionPair6);
        PHSwitchButtonActionPair pHSwitchButtonActionPair7 = new PHSwitchButtonActionPair(pHSwitchButtonInfo7, pHSwitchButtonAction);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(pHSwitchButtonActionPair7);
        PHSwitchButtonActionPair pHSwitchButtonActionPair8 = new PHSwitchButtonActionPair(pHSwitchButtonInfo8, pHSwitchButtonAction);
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(pHSwitchButtonActionPair8);
        HashMap map2 = new HashMap();
        map2.put(34, arrayList12);
        map2.put(16, arrayList13);
        map2.put(17, arrayList14);
        map2.put(18, arrayList15);
        pHSwitchDeviceInfo2.setEventButtonMapping(map2);
        arrayList.add(pHSwitchDeviceInfo);
        arrayList.add(pHSwitchDeviceInfo2);
        return arrayList;
    }

    public static JSONObject getStateJSON(PHSwitch pHSwitch) {
        return getJSON(pHSwitch).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
