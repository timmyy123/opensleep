package com.philips.lighting.hue.sdk.upnp;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.connection.impl.PHHueHttpConnection;
import com.philips.lighting.hue.sdk.utilities.PHUtilities;
import java.util.concurrent.Callable;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class IPAddressScanner implements Callable<PHAccessPoint> {
    private PHHueHttpConnection connection;
    private String ipAddress;

    public IPAddressScanner(String str) {
        this.ipAddress = str;
        PHHueHttpConnection pHHueHttpConnection = new PHHueHttpConnection();
        this.connection = pHHueHttpConnection;
        pHHueHttpConnection.setTimeoutConnection(2000);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PHAccessPoint call() throws Throwable {
        PHAccessPoint pHAccessPoint = new PHAccessPoint();
        String str = this.ipAddress;
        if (str != null && !str.isEmpty()) {
            String data2 = this.connection.getData(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("http://"), this.ipAddress, "/api/config"));
            if (data2 != null && !data2.equals("") && PHUtilities.isJSONValid(data2)) {
                JSONObject jSONObject = new JSONObject(data2);
                if (jSONObject.has("name") && jSONObject.has("mac") && jSONObject.has("swversion")) {
                    String strOptString = jSONObject.optString("mac");
                    String strOptString2 = jSONObject.optString("bridgeid");
                    if (!strOptString2.isEmpty() || strOptString == null) {
                        pHAccessPoint.setBridgeId(strOptString2);
                    } else {
                        String strReplace = strOptString.replace(":", "");
                        if (strReplace.length() != 12) {
                            pHAccessPoint.setBridgeId(strReplace);
                        } else {
                            pHAccessPoint.setBridgeId(strReplace.substring(0, 6) + "fffe" + strReplace.substring(6));
                        }
                    }
                    pHAccessPoint.setIpAddress(this.ipAddress);
                    pHAccessPoint.setMacAddress(strOptString);
                    return pHAccessPoint;
                }
            }
        }
        return null;
    }

    public IPAddressScanner(String str, PHHueHttpConnection pHHueHttpConnection) {
        this.ipAddress = str;
        this.connection = pHHueHttpConnection;
    }
}
