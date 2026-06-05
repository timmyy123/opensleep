package com.philips.lighting.hue.sdk;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeResourcesCacheImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.connection.impl.PHBridgeInternal;
import com.philips.lighting.hue.sdk.data.BridgeHeader;
import com.philips.lighting.hue.sdk.data.PHHueConstants;
import com.philips.lighting.hue.sdk.exception.PHBridgeNotConnectedException;
import com.philips.lighting.hue.sdk.exception.PHHeartbeatException;
import com.philips.lighting.hue.sdk.exception.PHHueException;
import com.philips.lighting.hue.sdk.heartbeat.PHHeartbeatManager;
import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl;
import com.philips.lighting.hue.sdk.upnp.PHBridgeSearchManagerImpl;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.philips.lighting.model.PHSchedule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueSDK {
    public static final int HB_INTERVAL = 10000;
    public static final byte LOG = 2;
    private static final String SDK_VERSION = "1.22.0";
    public static final byte SEARCH_BRIDGE = 1;
    private static PHHueSDK instance;
    private String appName;
    private PHLightState currentLightState;
    private String deviceName;
    private PHBridgeInternal phBridgeInternal;
    private PHBridge selectedBridge;
    private List<PHAccessPoint> accessPointsFound = new ArrayList();
    private List<PHAccessPoint> disconnectedAccessPoint = new ArrayList();
    private Map<String, Long> lastHeartbeat = new HashMap();
    private List<PHBridge> bridgeObjects = new ArrayList();
    private PHHeartbeatManager heartbeatManager = PHHeartbeatManager.getInstance();
    private PHNotificationManager notificationManager = PHNotificationManager.getDefaultManager();

    private PHHueSDK() {
    }

    public static PHHueSDK create() {
        return getInstance();
    }

    public static PHHueSDK getInstance() {
        if (instance == null) {
            instance = new PHHueSDK();
        }
        return instance;
    }

    public static PHHueSDK getStoredSDKObject() {
        return instance;
    }

    public void addBridge(PHBridge pHBridge) {
        List<PHBridge> list = this.bridgeObjects;
        if (list == null || pHBridge == null) {
            return;
        }
        list.add(pHBridge);
    }

    public void connect(PHAccessPoint pHAccessPoint) {
        if (pHAccessPoint == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        this.phBridgeInternal = new PHBridgeInternal();
        for (int i = 0; i < this.bridgeObjects.size(); i++) {
            PHBridgeConfiguration bridgeConfiguration = ((PHBridgeResourcesCacheImpl) this.bridgeObjects.get(i).getResourceCache()).getBridgeConfiguration();
            if (bridgeConfiguration != null && bridgeConfiguration.getIpAddress().equals(pHAccessPoint.getIpAddress())) {
                throw new PHHueException(PHHueConstants.TXT_EXISTING_ACCESSPOINT);
            }
        }
        this.phBridgeInternal.connectToAccessPoint(pHAccessPoint);
    }

    public void destroySDK() {
        PHNotificationManagerImpl.cleanNotificationManager();
        if (this.heartbeatManager != null) {
            PHHeartbeatManager.removeTimer();
        }
        instance = null;
    }

    public void disableAllHeartbeat() {
        for (PHBridge pHBridge : this.bridgeObjects) {
            if (isHeartbeatEnabled(pHBridge)) {
                this.heartbeatManager.disableAllHeartbeats((PHBridgeImpl) pHBridge);
            }
        }
    }

    public void disableHeartbeat(PHBridge pHBridge) {
        if (pHBridge == null) {
            throw new PHBridgeNotConnectedException(PHHueResourcesConstants.TXT_INVALID_INPUT);
        }
        if (isHeartbeatEnabled(pHBridge)) {
            this.heartbeatManager.disableFullConfigHeartbeat((PHBridgeImpl) pHBridge);
        }
    }

    public boolean disconnect(PHBridge pHBridge) {
        if (isHeartbeatEnabled(pHBridge)) {
            throw new PHHeartbeatException(PHHueResourcesConstants.TXT_INVALID_DISCONNECT);
        }
        return removeBridge(pHBridge);
    }

    public void enableHeartbeat(PHBridge pHBridge, long j) {
        if (pHBridge == null) {
            throw new PHBridgeNotConnectedException(PHHueResourcesConstants.TXT_INVALID_INPUT);
        }
        if (isHeartbeatEnabled(pHBridge)) {
            return;
        }
        this.heartbeatManager.enableFullConfigHeartbeat((PHBridgeImpl) pHBridge, j);
    }

    public List<PHAccessPoint> getAccessPointsFound() {
        return this.accessPointsFound;
    }

    public List<PHBridge> getAllBridges() {
        return this.bridgeObjects;
    }

    public String getAppName() {
        String str = this.appName;
        return str != null ? str : "MyApplication";
    }

    public synchronized List<BridgeHeader> getBridgesForDisplay() {
        ArrayList arrayList;
        try {
            List<PHBridge> allBridges = getAllBridges();
            arrayList = new ArrayList();
            if (allBridges != null) {
                for (PHBridge pHBridge : allBridges) {
                    if (!isHeartbeatEnabled(pHBridge)) {
                        enableHeartbeat(pHBridge, 10000L);
                    }
                    PHBridgeResourcesCache resourceCache = pHBridge.getResourceCache();
                    BridgeHeader bridgeHeader = new BridgeHeader(resourceCache.getBridgeConfiguration().getIpAddress(), "Connected", this.lastHeartbeat.get(resourceCache.getBridgeConfiguration().getIpAddress()).longValue());
                    int i = 0;
                    while (true) {
                        if (i >= arrayList.size()) {
                            arrayList.add(bridgeHeader);
                            break;
                        }
                        BridgeHeader bridgeHeader2 = (BridgeHeader) arrayList.get(i);
                        if (bridgeHeader2.getIPAddress().equals(bridgeHeader.getIPAddress())) {
                            bridgeHeader2.setStatus(bridgeHeader.getStatus());
                            break;
                        }
                        i++;
                    }
                }
            }
            for (int i2 = 0; i2 < this.disconnectedAccessPoint.size(); i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        arrayList.add(new BridgeHeader(this.disconnectedAccessPoint.get(i2).getIpAddress(), "Disconnected", this.lastHeartbeat.get(this.disconnectedAccessPoint.get(i2).getIpAddress()).longValue()));
                        break;
                    }
                    if (((BridgeHeader) arrayList.get(i3)).getIPAddress().equals(this.disconnectedAccessPoint.get(i2).getIpAddress())) {
                        ((BridgeHeader) arrayList.get(i3)).setStatus("Disconnected");
                        break;
                    }
                    i3++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public PHLightState getCurrentLightState() {
        return this.currentLightState;
    }

    public String getDeviceName() {
        String str = this.deviceName;
        return str != null ? str : "MyDevice";
    }

    public List<PHAccessPoint> getDisconnectedAccessPoint() {
        return this.disconnectedAccessPoint;
    }

    public String[] getGroupNames(List<PHGroup> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i).getName();
        }
        return strArr;
    }

    public PHHeartbeatManager getHeartbeatManager() {
        return this.heartbeatManager;
    }

    public PHBridgeInternal getInternalObject() {
        return new PHBridgeInternal();
    }

    public Map<String, Long> getLastHeartbeat() {
        return this.lastHeartbeat;
    }

    public String[] getLightNames(List<PHLight> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i).getName();
        }
        return strArr;
    }

    public PHNotificationManager getNotificationManager() {
        return this.notificationManager;
    }

    public Object getSDKService(byte b) {
        if (b == 1) {
            return new PHBridgeSearchManagerImpl();
        }
        if (b != 2) {
            return null;
        }
        return new PHLog();
    }

    public String getSDKVersion() {
        return SDK_VERSION;
    }

    public String[] getScheduleNames(List<PHSchedule> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i).getName();
        }
        return strArr;
    }

    public PHBridge getSelectedBridge() {
        return this.selectedBridge;
    }

    public boolean isAccessPointConnected(PHAccessPoint pHAccessPoint) {
        if (this.bridgeObjects != null) {
            for (int i = 0; i < this.bridgeObjects.size(); i++) {
                PHBridgeConfiguration bridgeConfiguration = ((PHBridgeResourcesCacheImpl) this.bridgeObjects.get(i).getResourceCache()).getBridgeConfiguration();
                if (bridgeConfiguration != null && bridgeConfiguration.getIpAddress().equals(pHAccessPoint.getIpAddress())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isHeartbeatEnabled(PHBridge pHBridge) {
        if (pHBridge != null) {
            return this.heartbeatManager.isHeartBeating((PHBridgeImpl) pHBridge);
        }
        throw new PHBridgeNotConnectedException(PHHueResourcesConstants.TXT_INVALID_INPUT);
    }

    public boolean removeBridge(PHBridge pHBridge) {
        List<PHBridge> list = this.bridgeObjects;
        if (list != null) {
            return list.remove(pHBridge);
        }
        return false;
    }

    public void setAppName(String str) {
        if (str == null || str.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_APPNAME);
            return;
        }
        str.replaceAll("#", "");
        while (str.getBytes().length > 20) {
            str = Fragment$$ExternalSyntheticOutline1.m(1, 0, str);
        }
        this.appName = str;
    }

    public void setCurrentLightState(PHLightState pHLightState) {
        this.currentLightState = pHLightState;
    }

    public void setDeviceName(String str) {
        if (str == null || str.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DEVICENAME);
            return;
        }
        str.replaceAll("#", "");
        while (str.getBytes().length > 19) {
            str = Fragment$$ExternalSyntheticOutline1.m(1, 0, str);
        }
        this.deviceName = str;
    }

    public void setDisconnectedAccessPoint(List<PHAccessPoint> list) {
        this.disconnectedAccessPoint = list;
    }

    public void setLastHeartbeat(Map<String, Long> map) {
        this.lastHeartbeat = map;
    }

    public void setSelectedBridge(PHBridge pHBridge) {
        this.selectedBridge = pHBridge;
    }

    public void startPushlinkAuthentication(PHAccessPoint pHAccessPoint) {
        if (pHAccessPoint == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        stopPushlinkAuthentication();
        PHBridgeInternal pHBridgeInternal = new PHBridgeInternal();
        this.phBridgeInternal = pHBridgeInternal;
        pHBridgeInternal.startPushlinkTimer(pHAccessPoint);
    }

    public boolean stopPushlinkAuthentication() {
        PHBridgeInternal pHBridgeInternal = this.phBridgeInternal;
        if (pHBridgeInternal == null) {
            return false;
        }
        return pHBridgeInternal.stopPushLinkTimer();
    }
}
