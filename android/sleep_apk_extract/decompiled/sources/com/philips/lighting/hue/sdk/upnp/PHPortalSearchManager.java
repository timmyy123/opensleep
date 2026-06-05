package com.philips.lighting.hue.sdk.upnp;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.connection.impl.PHHueHttpConnection;
import com.philips.lighting.hue.sdk.util.PHDnsChecker;
import com.philips.lighting.hue.sdk.utilities.impl.PHHueHelper;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import java.util.ArrayList;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHPortalSearchManager {
    static final String PORTAL_NUPNP = "/api/nupnp";
    private static final String TAG = "PHPortalSearchManager";
    private String portalAddress = "https://www.meethue.com";
    private int reachabilityTimeout = 2000;

    private boolean isPortalReachable() {
        PHDnsChecker pHDnsChecker = new PHDnsChecker(this.portalAddress.replaceFirst("https://", ""));
        Thread thread = new Thread(pHDnsChecker);
        thread.start();
        try {
            thread.join(this.reachabilityTimeout);
            return pHDnsChecker.get() != null;
        } catch (InterruptedException e) {
            PHLog.e(TAG, "isPortalReachable Exception: " + e.getMessage());
            return false;
        }
    }

    public PHHueHttpConnection getHttpConnection() {
        return new PHHueHttpConnection();
    }

    public String getPortalAddress() {
        return this.portalAddress;
    }

    public int getPortalReachabilityTimeout() {
        return this.reachabilityTimeout;
    }

    public List<PHAccessPoint> searchPortal() {
        ArrayList arrayList = new ArrayList();
        if (isPortalReachable()) {
            try {
                String data2 = getHttpConnection().getData(String.valueOf(this.portalAddress).concat(PORTAL_NUPNP));
                if (data2 != null && data2.length() > 0) {
                    JSONArray jSONArray = new JSONArray(data2);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("id");
                            String strOptString2 = jSONObjectOptJSONObject.optString("internalipaddress");
                            if (strOptString != null && strOptString2 != null) {
                                String strReplace = strOptString.replace(":", "");
                                if (strReplace.length() != 0 && strOptString2.length() != 0) {
                                    PHAccessPoint pHAccessPoint = new PHAccessPoint();
                                    pHAccessPoint.setIpAddress(strOptString2);
                                    pHAccessPoint.setMacAddress(PHHueHelper.macAddressFromBridgeId(strReplace.trim()));
                                    pHAccessPoint.setBridgeId(strReplace);
                                    if (!arrayList.contains(pHAccessPoint)) {
                                        arrayList.add(pHAccessPoint);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (JSONException | Exception unused) {
            }
        }
        return arrayList;
    }

    public void setPortalAddress(String str) {
        this.portalAddress = str;
    }

    public void setPortalReachabilityTimeout(int i) {
        this.reachabilityTimeout = i;
    }
}
