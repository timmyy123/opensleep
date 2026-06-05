package com.philips.lighting.hue.sdk.fbp;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer;
import com.philips.lighting.hue.sdk.clip.PHGroupSerializer;
import com.philips.lighting.hue.sdk.clip.PHLightSerializer;
import com.philips.lighting.hue.sdk.clip.PHRuleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSceneSerializer;
import com.philips.lighting.hue.sdk.clip.PHScheduleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSensorSerializer;
import com.philips.lighting.hue.sdk.clip.PHSerializer;
import com.philips.lighting.hue.sdk.clip.PHTimeZoneSerializer;
import com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeVersionManager {
    private static final String BRIDGE_API_LEVEL = "api_level";
    private static final String BRIDGE_FEATURES = "features";
    private static final String BRIDGE_SOFTWARE = "swversion";
    private static final String SERIALIZER_PACKAGE_NAME = "com.philips.lighting.hue.sdk.clip.serialisation";
    private static final String TAG = "PHBridgeVersionManager";
    private static JSONArray bridgeList;
    private static PHBridgeVersionManager bvManager;
    private String currentAPILevel;
    private JSONObject currentBridge;
    private String currentBridgeVersion;
    private List<PHSerializer> serializers;
    private Comparator<String> versionComparator = new Comparator<String>() { // from class: com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            for (int i = 0; i < strArrSplit.length && i < strArrSplit2.length; i++) {
                int i2 = parseInt(strArrSplit[i]);
                int i3 = parseInt(strArrSplit2[i]);
                if (i2 != i3) {
                    return Integer.compare(i2, i3);
                }
            }
            return Integer.compare(strArrSplit.length, strArrSplit2.length);
        }

        public int parseInt(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
    };

    public static synchronized PHBridgeVersionManager getInstance() {
        try {
            if (bvManager == null) {
                PHBridgeVersionManager pHBridgeVersionManager = new PHBridgeVersionManager();
                bvManager = pHBridgeVersionManager;
                pHBridgeVersionManager.loadBridgeList();
                bvManager.setBridgeVersion("01003542", "1.0.0");
            }
        } catch (Throwable th) {
            throw th;
        }
        return bvManager;
    }

    private void loadBridgeList() {
        String strLoadConfiguration;
        try {
            strLoadConfiguration = loadConfiguration("/featureResources.json");
        } catch (IOException e) {
            e.printStackTrace();
            strLoadConfiguration = null;
        }
        bridgeList = new JSONObject(strLoadConfiguration).getJSONArray("bridgeversions");
    }

    public static String loadConfiguration(String str) throws IOException {
        InputStream resourceAsStream = PHBridgeVersionManager.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            PHLog.e(TAG, "Resource stream is null: " + str);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuilder sb = new StringBuilder();
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
                sb.append('\n');
            }
            bufferedReader.close();
            return sb.toString();
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
    }

    public String getApiLevel() {
        return this.currentAPILevel;
    }

    public PHBridgeConfigurationSerializer getBridgeConfigurationSerializer() {
        List<PHSerializer> list = this.serializers;
        if (list != null) {
            for (PHSerializer pHSerializer : list) {
                if (PHBridgeConfigurationSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                    return (PHBridgeConfigurationSerializer) pHSerializer;
                }
            }
        }
        return new PHBridgeConfigurationSerializer1();
    }

    public String getBridgeVersion() {
        return this.currentBridgeVersion;
    }

    public PHGroupSerializer getGroupSerializer() {
        for (PHSerializer pHSerializer : this.serializers) {
            if (PHGroupSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                return (PHGroupSerializer) pHSerializer;
            }
        }
        return null;
    }

    public PHLightSerializer getLightSerializer() {
        for (PHSerializer pHSerializer : this.serializers) {
            if (PHLightSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                return (PHLightSerializer) pHSerializer;
            }
        }
        return null;
    }

    public PHRuleSerializer getRulesSerializer() {
        for (PHSerializer pHSerializer : this.serializers) {
            if (PHRuleSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                return (PHRuleSerializer) pHSerializer;
            }
        }
        return null;
    }

    public PHSceneSerializer getScenesSerializer() {
        for (PHSerializer pHSerializer : this.serializers) {
            if (PHSceneSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                return (PHSceneSerializer) pHSerializer;
            }
        }
        return null;
    }

    public PHScheduleSerializer getSchedulesSerializer() {
        for (PHSerializer pHSerializer : this.serializers) {
            if (PHScheduleSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                return (PHScheduleSerializer) pHSerializer;
            }
        }
        return null;
    }

    public PHSensorSerializer getSensorSerializer() {
        for (PHSerializer pHSerializer : this.serializers) {
            if (PHSensorSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                return (PHSensorSerializer) pHSerializer;
            }
        }
        return null;
    }

    public PHTimeZoneSerializer getTimeZoneSerializer() {
        for (PHSerializer pHSerializer : this.serializers) {
            if (PHTimeZoneSerializer.class.isAssignableFrom(pHSerializer.getClass())) {
                return (PHTimeZoneSerializer) pHSerializer;
            }
        }
        return null;
    }

    public void setBridgeVersion(String str, String str2) {
        int i;
        boolean z;
        String str3;
        PHBridgeVersionManager pHBridgeVersionManager = this;
        PHLog.d(TAG, "Trying to match bridge version " + str + " and api version " + str2);
        String str4 = pHBridgeVersionManager.currentBridgeVersion;
        if (str4 == null || str == null || !str4.equals(str)) {
            String str5 = pHBridgeVersionManager.currentAPILevel;
            if (str5 == null || str2 == null || !str5.equals(str2) || (str3 = pHBridgeVersionManager.currentBridgeVersion) == null || str == null || !str3.equals(str)) {
                if (str != null) {
                    z = false;
                    for (int i2 = 0; i2 < bridgeList.length(); i2++) {
                        JSONObject jSONObject = bridgeList.getJSONObject(i2);
                        String strOptString = jSONObject.optString(BRIDGE_SOFTWARE);
                        if (strOptString != null && strOptString.equals(str)) {
                            pHBridgeVersionManager.currentBridge = jSONObject;
                            pHBridgeVersionManager.currentBridgeVersion = str;
                            pHBridgeVersionManager.currentAPILevel = jSONObject.optString(BRIDGE_API_LEVEL);
                            String str6 = TAG;
                            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Matched bridge version ", str, ", API level ");
                            sbM5m.append(pHBridgeVersionManager.currentAPILevel);
                            PHLog.d(str6, sbM5m.toString());
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArray = jSONObject.getJSONArray(BRIDGE_FEATURES);
                            int i3 = 0;
                            while (i3 < jSONArray.length()) {
                                String[] strArrSplit = jSONArray.getString(i3).split("API");
                                StringBuilder sb = new StringBuilder("com.philips.lighting.hue.sdk.clip.serialisation.PH");
                                JSONArray jSONArray2 = jSONArray;
                                sb.append(strArrSplit[0]);
                                sb.append("Serializer");
                                sb.append(strArrSplit[1]);
                                try {
                                    arrayList.add((PHSerializer) Class.forName(sb.toString()).newInstance());
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e2) {
                                    e2.printStackTrace();
                                } catch (InstantiationException e3) {
                                    e3.printStackTrace();
                                }
                                i3++;
                                jSONArray = jSONArray2;
                            }
                            pHBridgeVersionManager.serializers = arrayList;
                            z = true;
                        }
                    }
                    i = 0;
                } else {
                    i = 0;
                    z = false;
                }
                if (str2 != null && !z) {
                    int i4 = i;
                    while (i4 < bridgeList.length()) {
                        JSONObject jSONObject2 = bridgeList.getJSONObject(i4);
                        String strOptString2 = jSONObject2.optString(BRIDGE_API_LEVEL);
                        String strOptString3 = jSONObject2.optString(BRIDGE_SOFTWARE);
                        if ((strOptString3 == null || strOptString3.isEmpty()) && strOptString2.equals(str2)) {
                            pHBridgeVersionManager.currentBridge = jSONObject2;
                            if (str != null) {
                                strOptString3 = str;
                            }
                            pHBridgeVersionManager.currentBridgeVersion = strOptString3;
                            pHBridgeVersionManager.currentAPILevel = strOptString2;
                            String str7 = TAG;
                            StringBuilder sbM5m2 = FileInsert$$ExternalSyntheticOutline0.m5m("Matched bridge version ", str, ", API level ");
                            sbM5m2.append(pHBridgeVersionManager.currentAPILevel);
                            PHLog.d(str7, sbM5m2.toString());
                            ArrayList arrayList2 = new ArrayList();
                            JSONArray jSONArray3 = jSONObject2.getJSONArray(BRIDGE_FEATURES);
                            int i5 = i;
                            while (i5 < jSONArray3.length()) {
                                String[] strArrSplit2 = jSONArray3.getString(i5).split("API");
                                try {
                                    arrayList2.add((PHSerializer) Class.forName("com.philips.lighting.hue.sdk.clip.serialisation.PH" + strArrSplit2[i] + "Serializer" + strArrSplit2[1]).newInstance());
                                } catch (ClassNotFoundException e4) {
                                    e4.printStackTrace();
                                } catch (IllegalAccessException e5) {
                                    e5.printStackTrace();
                                } catch (InstantiationException e6) {
                                    e6.printStackTrace();
                                }
                                i5++;
                                pHBridgeVersionManager = this;
                            }
                            pHBridgeVersionManager.serializers = arrayList2;
                            z = true;
                        }
                        i4++;
                        pHBridgeVersionManager = this;
                    }
                }
                if (z) {
                    return;
                }
                PHLog.d(TAG, "Unsupported Bridge Software version sent: " + str);
                setFallbackBridgeVersion(str, str2);
            }
        }
    }

    public void setFallbackBridgeVersion(String str, String str2) {
        int i = 0;
        if (str2 == null) {
            PHLog.d(TAG, "Trying fallback with swversion");
            ArrayList arrayList = new ArrayList();
            while (i < bridgeList.length()) {
                String strOptString = bridgeList.getJSONObject(i).optString(BRIDGE_SOFTWARE);
                if (strOptString != null) {
                    arrayList.add(strOptString);
                }
                i++;
            }
            arrayList.add(str);
            Collections.sort(arrayList);
            int iIndexOf = arrayList.indexOf(str) - 1;
            if (iIndexOf < 0) {
                PHLog.d(TAG, "Fallback failed, taking core api 1.0.0");
                setBridgeVersion("01003542", "1.0.0");
                return;
            }
            String str3 = (String) arrayList.get(iIndexOf);
            PHLog.d(TAG, "Fallback swversion found: " + str3);
            setBridgeVersion(str3, null);
            return;
        }
        PHLog.d(TAG, "Trying fallback with api version");
        ArrayList arrayList2 = new ArrayList();
        while (i < bridgeList.length()) {
            String strOptString2 = bridgeList.getJSONObject(i).optString(BRIDGE_API_LEVEL);
            if (strOptString2 != null && !arrayList2.contains(strOptString2)) {
                arrayList2.add(strOptString2);
            }
            i++;
        }
        arrayList2.add(str2);
        Collections.sort(arrayList2, this.versionComparator);
        int iIndexOf2 = arrayList2.indexOf(str2) - 1;
        if (iIndexOf2 < 0) {
            PHLog.d(TAG, "Fallback with api version not found, retry with bridge version alone");
            setFallbackBridgeVersion(str, null);
            return;
        }
        String str4 = (String) arrayList2.get(iIndexOf2);
        PHLog.d(TAG, "Fallback api found: " + str4);
        setBridgeVersion(str, str4);
    }
}
