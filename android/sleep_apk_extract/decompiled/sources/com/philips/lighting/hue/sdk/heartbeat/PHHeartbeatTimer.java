package com.philips.lighting.hue.sdk.heartbeat;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.heartbeat.PHHeartbeatProcessor;
import com.philips.lighting.model.PHBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHHeartbeatTimer extends Timer {
    private HashMap<PHBridge, ArrayList<PHHeartbeatProcessor>> heartbeatMap = new HashMap<>();

    private void scheduleTimerTask(PHHeartbeatProcessor pHHeartbeatProcessor, long j) {
        schedule(pHHeartbeatProcessor, 0L, j);
    }

    public boolean isHeartbeating(PHBridge pHBridge) {
        if (pHBridge != null) {
            return this.heartbeatMap.containsKey(pHBridge);
        }
        return false;
    }

    public void startHeartbeat(PHBridge pHBridge, long j, PHHeartbeatProcessor.PHHeartbeatType pHHeartbeatType) {
        if ((j < 100 && pHHeartbeatType != PHHeartbeatProcessor.PHHeartbeatType.FULL_CONFIG) || (j < 1000 && pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.FULL_CONFIG)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_HEARTBEAT_TIMER);
            return;
        }
        if (pHBridge == null || pHHeartbeatType == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHBridgeVersionManager pHBridgeVersionManager = PHBridgeVersionManager.getInstance();
        if (pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.CONFIG) {
            if (pHBridgeVersionManager.getBridgeConfigurationSerializer() == null) {
                Home$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
        } else if (pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.GROUPS) {
            if (pHBridgeVersionManager.getGroupSerializer() == null) {
                Home$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
        } else if (pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.LIGHTS) {
            if (pHBridgeVersionManager.getLightSerializer() == null) {
                Home$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
        } else if (pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.SCENES) {
            if (pHBridgeVersionManager.getScenesSerializer() == null) {
                Home$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
        } else if (pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.SCHEDULES) {
            if (pHBridgeVersionManager.getSchedulesSerializer() == null) {
                Home$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
        } else if (pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.SENSORS) {
            if (pHBridgeVersionManager.getSensorSerializer() == null) {
                Home$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
        } else if (pHHeartbeatType == PHHeartbeatProcessor.PHHeartbeatType.RULES && pHBridgeVersionManager.getRulesSerializer() == null) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        stopHeartbeat(pHBridge, pHHeartbeatType);
        ArrayList<PHHeartbeatProcessor> arrayList = this.heartbeatMap.get(pHBridge) != null ? this.heartbeatMap.get(pHBridge) : new ArrayList<>();
        PHHeartbeatProcessor pHHeartbeatProcessor = new PHHeartbeatProcessor(pHBridge, pHHeartbeatType);
        scheduleTimerTask(pHHeartbeatProcessor, j);
        arrayList.add(pHHeartbeatProcessor);
        this.heartbeatMap.put(pHBridge, arrayList);
    }

    public void stopAllHeartbeat(PHBridge pHBridge) {
        if (pHBridge != null) {
            for (PHHeartbeatProcessor.PHHeartbeatType pHHeartbeatType : PHHeartbeatProcessor.PHHeartbeatType.valuesCustom()) {
                stopHeartbeat(pHBridge, pHHeartbeatType);
            }
        }
    }

    public void stopHeartbeat(PHBridge pHBridge, PHHeartbeatProcessor.PHHeartbeatType pHHeartbeatType) {
        if (pHBridge == null && pHHeartbeatType == null) {
            return;
        }
        ArrayList<PHHeartbeatProcessor> arrayList = this.heartbeatMap.get(pHBridge);
        if (arrayList != null) {
            Iterator<PHHeartbeatProcessor> it = arrayList.iterator();
            while (it.hasNext()) {
                PHHeartbeatProcessor next = it.next();
                if (next.getType() == pHHeartbeatType) {
                    next.cancel();
                    it.remove();
                }
            }
        }
        if (this.heartbeatMap.get(pHBridge) == null || this.heartbeatMap.get(pHBridge).isEmpty()) {
            this.heartbeatMap.remove(pHBridge);
        }
    }
}
