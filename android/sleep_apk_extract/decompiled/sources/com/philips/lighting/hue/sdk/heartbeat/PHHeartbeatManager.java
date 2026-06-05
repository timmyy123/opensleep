package com.philips.lighting.hue.sdk.heartbeat;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.clip.PHLightSerializer;
import com.philips.lighting.hue.sdk.clip.PHRuleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSceneSerializer;
import com.philips.lighting.hue.sdk.clip.PHScheduleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSensorSerializer;
import com.philips.lighting.hue.sdk.data.PHHueConstants;
import com.philips.lighting.hue.sdk.exception.PHHeartbeatException;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.heartbeat.PHHeartbeatProcessor;
import com.philips.lighting.hue.sdk.utilities.impl.PHHueHelper;
import com.philips.lighting.model.PHBridge;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHHeartbeatManager {
    private static PHHeartbeatManager hbManager;
    private static PHHeartbeatTimer hbTimer;

    private PHHeartbeatManager() {
    }

    private void checkAndStartMultiResourceHeartbeat(PHBridge pHBridge, long j, PHHeartbeatProcessor.PHHeartbeatType pHHeartbeatType) {
        if (pHBridge == null || pHBridge.getResourceCache() == null || pHBridge.getResourceCache().getBridgeConfiguration() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
        } else {
            PHHueHelper.getBridgeVersion(Integer.parseInt(pHBridge.getResourceCache().getBridgeConfiguration().getSoftwareVersion()));
            hbTimer.startHeartbeat(pHBridge, j, pHHeartbeatType);
        }
    }

    public static synchronized PHHeartbeatManager getInstance() {
        try {
            if (hbManager == null) {
                hbManager = new PHHeartbeatManager();
                hbTimer = new PHHeartbeatTimer();
            }
        } catch (Throwable th) {
            throw th;
        }
        return hbManager;
    }

    public static void removeTimer() {
        hbTimer.cancel();
        hbManager = null;
        hbTimer = null;
    }

    public void disableAllHeartbeats(PHBridge pHBridge) {
        hbTimer.stopAllHeartbeat(pHBridge);
    }

    public void disableConfigHeartbeat(PHBridge pHBridge) {
        hbTimer.stopHeartbeat(pHBridge, PHHeartbeatProcessor.PHHeartbeatType.CONFIG);
    }

    public void disableFullConfigHeartbeat(PHBridge pHBridge) {
        hbTimer.stopHeartbeat(pHBridge, PHHeartbeatProcessor.PHHeartbeatType.FULL_CONFIG);
    }

    public void disableLightsHeartbeat(PHBridge pHBridge) {
        hbTimer.stopHeartbeat(pHBridge, PHHeartbeatProcessor.PHHeartbeatType.LIGHTS);
    }

    public void disableRulesHeartbeat(PHBridge pHBridge) {
        hbTimer.stopHeartbeat(pHBridge, PHHeartbeatProcessor.PHHeartbeatType.RULES);
    }

    public void disableScenesHeartbeat(PHBridge pHBridge) {
        hbTimer.stopHeartbeat(pHBridge, PHHeartbeatProcessor.PHHeartbeatType.SCENES);
    }

    public void disableSchedulesHeartbeat(PHBridge pHBridge) {
        hbTimer.stopHeartbeat(pHBridge, PHHeartbeatProcessor.PHHeartbeatType.SCHEDULES);
    }

    public void disableSensorsHeartbeat(PHBridge pHBridge) {
        hbTimer.stopHeartbeat(pHBridge, PHHeartbeatProcessor.PHHeartbeatType.SENSORS);
    }

    public void enableConfigHeartbeat(PHBridge pHBridge, long j) {
        checkAndStartMultiResourceHeartbeat(pHBridge, j, PHHeartbeatProcessor.PHHeartbeatType.CONFIG);
    }

    public void enableFullConfigHeartbeat(PHBridge pHBridge, long j) {
        hbTimer.startHeartbeat(pHBridge, j, PHHeartbeatProcessor.PHHeartbeatType.FULL_CONFIG);
    }

    public void enableLightsHeartbeat(PHBridge pHBridge, long j) {
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canFetchAll()) {
            throw new PHHeartbeatException(PHHueConstants.TXT_MULTI_RESOURCE_HEARTBEAT_NOT_SUPPORTED);
        }
        checkAndStartMultiResourceHeartbeat(pHBridge, j, PHHeartbeatProcessor.PHHeartbeatType.LIGHTS);
    }

    public void enableRulesHeartbeat(PHBridge pHBridge, long j) {
        PHRuleSerializer rulesSerializer = PHBridgeVersionManager.getInstance().getRulesSerializer();
        if (rulesSerializer == null || !rulesSerializer.canFetchAll()) {
            throw new PHHeartbeatException(PHHueConstants.TXT_MULTI_RESOURCE_HEARTBEAT_NOT_SUPPORTED);
        }
        checkAndStartMultiResourceHeartbeat(pHBridge, j, PHHeartbeatProcessor.PHHeartbeatType.RULES);
    }

    public void enableScenesHeartbeat(PHBridge pHBridge, long j) {
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canFetchAll()) {
            throw new PHHeartbeatException(PHHueConstants.TXT_MULTI_RESOURCE_HEARTBEAT_NOT_SUPPORTED);
        }
        checkAndStartMultiResourceHeartbeat(pHBridge, j, PHHeartbeatProcessor.PHHeartbeatType.SCENES);
    }

    public void enableSchedulesHeartbeat(PHBridge pHBridge, long j) {
        PHScheduleSerializer schedulesSerializer = PHBridgeVersionManager.getInstance().getSchedulesSerializer();
        if (schedulesSerializer == null || !schedulesSerializer.canFetchAll()) {
            throw new PHHeartbeatException(PHHueConstants.TXT_MULTI_RESOURCE_HEARTBEAT_NOT_SUPPORTED);
        }
        checkAndStartMultiResourceHeartbeat(pHBridge, j, PHHeartbeatProcessor.PHHeartbeatType.SCHEDULES);
    }

    public void enableSensorsHeartbeat(PHBridge pHBridge, long j) {
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canFetchAll()) {
            throw new PHHeartbeatException(PHHueConstants.TXT_MULTI_RESOURCE_HEARTBEAT_NOT_SUPPORTED);
        }
        checkAndStartMultiResourceHeartbeat(pHBridge, j, PHHeartbeatProcessor.PHHeartbeatType.SENSORS);
    }

    public boolean isHeartBeating(PHBridge pHBridge) {
        return hbTimer.isHeartbeating(pHBridge);
    }
}
