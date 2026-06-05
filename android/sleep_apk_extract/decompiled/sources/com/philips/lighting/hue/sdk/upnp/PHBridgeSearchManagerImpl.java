package com.philips.lighting.hue.sdk.upnp;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHBridgeSearchManager;
import com.philips.lighting.hue.sdk.PHMessageType;
import com.philips.lighting.hue.sdk.data.PHHueConstants;
import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl;
import com.philips.lighting.hue.sdk.utilities.impl.PHHueHelper;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeSearchManagerImpl implements PHBridgeSearchManager {
    private static final String BRIDGE_ID = "hue-bridgeid:";
    private static final String COLON = ":";
    private static final String IPBRIDGE = "IpBridge";
    private static final String LINE = "-";
    private static final String LOCATION_TEXT = "LOCATION: http://";
    private static final String TAG = "PHBridgeSerachManagerImpl";
    private static final String USN = "USN: uuid:";
    private String portalAddress = null;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean verifyDuplicateMac(ArrayList<PHAccessPoint> arrayList, PHAccessPoint pHAccessPoint) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (pHAccessPoint != null && pHAccessPoint.getMacAddress() != null && arrayList.get(i) != null && arrayList.get(i).getMacAddress() != null && arrayList.get(i).getMacAddress().equals(pHAccessPoint.getMacAddress())) {
                return true;
            }
        }
        return false;
    }

    public PHIpAddressSearchManager getIpAddressSearchManager() {
        return new PHIpAddressSearchManager();
    }

    @Override // com.philips.lighting.hue.sdk.PHBridgeSearchManager
    public String getPortalAddress() {
        return this.portalAddress;
    }

    public PHPortalSearchManager getPortalSearchManager() {
        PHPortalSearchManager pHPortalSearchManager = new PHPortalSearchManager();
        String str = this.portalAddress;
        if (str != null) {
            pHPortalSearchManager.setPortalAddress(str);
        }
        return pHPortalSearchManager;
    }

    public PHUpnpManager getUpnpManager() {
        return new PHUpnpManager();
    }

    @Override // com.philips.lighting.hue.sdk.PHBridgeSearchManager
    public void ipAddressSearch() {
        search(false, false, true);
    }

    @Override // com.philips.lighting.hue.sdk.PHBridgeSearchManager
    public void portalSearch() {
        search(false, true, false);
    }

    @Override // com.philips.lighting.hue.sdk.PHBridgeSearchManager
    public void search(final boolean z, final boolean z2, final boolean z3) {
        new Thread() { // from class: com.philips.lighting.hue.sdk.upnp.PHBridgeSearchManagerImpl.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                List<PHAccessPoint> listStartIpAddressSearch;
                List<PHAccessPoint> listSearchPortal;
                ArrayList arrayList = new ArrayList();
                PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
                if (z) {
                    PHUpnpManager upnpManager = PHBridgeSearchManagerImpl.this.getUpnpManager();
                    PHLog.d(PHBridgeSearchManagerImpl.TAG, "Discovering Devices ...");
                    for (String str : upnpManager.startSearch()) {
                        if (str.indexOf(PHBridgeSearchManagerImpl.IPBRIDGE) >= 0) {
                            if (str.length() > str.indexOf(PHBridgeSearchManagerImpl.LOCATION_TEXT) + 32) {
                                Matcher matcher = Pattern.compile("http:\\/\\/([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})").matcher(str);
                                PHAccessPoint pHAccessPoint = null;
                                String strGroup = matcher.find() ? matcher.group(1) : null;
                                Matcher matcher2 = Pattern.compile("USN: uuid:.+-([0-9a-zA-Z]{12})").matcher(str);
                                String strGroup2 = matcher2.find() ? matcher2.group(1) : null;
                                Matcher matcher3 = Pattern.compile("hue-bridgeid:\\s*([0-9a-zA-Z]*)").matcher(str);
                                String strGroup3 = matcher3.find() ? matcher3.group(1) : null;
                                if (strGroup2 != null) {
                                    if (strGroup2.length() >= 12) {
                                        if (strGroup2.length() > 12) {
                                            strGroup2 = strGroup2.substring(0, 12);
                                        }
                                        pHAccessPoint = new PHAccessPoint();
                                        pHAccessPoint.setMacAddress(PHHueHelper.formatMacAddress(strGroup2.trim()));
                                        pHAccessPoint.setIpAddress(strGroup.trim());
                                        pHAccessPoint.setBridgeId(strGroup3);
                                    }
                                }
                                if (!arrayList.contains(pHAccessPoint) && pHAccessPoint != null) {
                                    arrayList.add(pHAccessPoint);
                                }
                            }
                        }
                    }
                }
                if (z2 && (listSearchPortal = PHBridgeSearchManagerImpl.this.getPortalSearchManager().searchPortal()) != null && listSearchPortal.size() > 0) {
                    for (PHAccessPoint pHAccessPoint2 : listSearchPortal) {
                        if (!PHBridgeSearchManagerImpl.this.verifyDuplicateMac(arrayList, pHAccessPoint2) && !arrayList.contains(pHAccessPoint2)) {
                            arrayList.add(pHAccessPoint2);
                        }
                    }
                }
                if (z3 && (listStartIpAddressSearch = PHBridgeSearchManagerImpl.this.getIpAddressSearchManager().startIpAddressSearch()) != null && !listStartIpAddressSearch.isEmpty()) {
                    for (PHAccessPoint pHAccessPoint3 : listStartIpAddressSearch) {
                        if (!PHBridgeSearchManagerImpl.this.verifyDuplicateMac(arrayList, pHAccessPoint3) && !arrayList.contains(pHAccessPoint3)) {
                            arrayList.add(pHAccessPoint3);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    if (notificationManager != null) {
                        notificationManager.notifySDKError(PHMessageType.BRIDGE_NOT_FOUND, PHHueConstants.TXT_NO_BRIDGE_FOUND);
                    }
                } else if (notificationManager != null) {
                    notificationManager.notifyBridgeSearchResult(arrayList);
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.PHBridgeSearchManager
    public void setPortalAddress(String str) {
        this.portalAddress = str;
    }

    @Override // com.philips.lighting.hue.sdk.PHBridgeSearchManager
    public void upnpSearch() {
        search(true, false, false);
    }

    @Override // com.philips.lighting.hue.sdk.PHBridgeSearchManager
    public void search(boolean z, boolean z2) {
        search(z, z2, false);
    }
}
