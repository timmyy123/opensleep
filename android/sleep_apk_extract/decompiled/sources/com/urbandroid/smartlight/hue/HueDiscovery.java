package com.urbandroid.smartlight.hue;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHBridgeSearchManager;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHHueParsingError;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Gateway;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001#B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016J\u001e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/urbandroid/smartlight/hue/HueDiscovery;", "Lcom/urbandroid/smartlight/common/discovery/Discovery;", "Lcom/urbandroid/smartlight/common/model/Gateway$Hue;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "tag", "", "getTag", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "fallbackSearch", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", ServerProtocol.DIALOG_PARAM_SDK_VERSION, "Lcom/philips/lighting/hue/sdk/PHHueSDK;", "hueListener", "Lcom/urbandroid/smartlight/hue/HueDiscovery$ExtendedHueListener;", "discover", "", "listener", "Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "authenticate", "gateway", "Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "close", "ExtendedHueListener", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HueDiscovery implements Discovery<Gateway.Hue>, FeatureLogger, CoroutineScope {
    private final Context context;
    private final CoroutineContext coroutineContext;
    private boolean fallbackSearch;
    private ExtendedHueListener hueListener;
    private final CompletableJob job;
    private final PHHueSDK sdk;
    private final String tag;

    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0014\u0010#\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0014\u0010&\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0%J\u0014\u0010'\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0%J\u0006\u0010(\u001a\u00020!J\u0016\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\u001e\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u000204002\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020!2\u0006\u00108\u001a\u0002062\u0006\u00109\u001a\u00020\u0013H\u0016J\u0010\u0010:\u001a\u00020!2\u0006\u0010/\u001a\u000201H\u0016J\u0010\u0010;\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010<\u001a\u00020!2\u0006\u0010/\u001a\u000201H\u0016J\u001a\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u0002042\b\u0010?\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010@\u001a\u00020!2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B00H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0%0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006C"}, d2 = {"Lcom/urbandroid/smartlight/hue/HueDiscovery$ExtendedHueListener;", "Lcom/philips/lighting/hue/sdk/PHSDKListener;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", ServerProtocol.DIALOG_PARAM_SDK_VERSION, "Lcom/philips/lighting/hue/sdk/PHHueSDK;", "discovery", "Lcom/urbandroid/smartlight/hue/HueDiscovery;", "<init>", "(Landroid/content/Context;Lcom/philips/lighting/hue/sdk/PHHueSDK;Lcom/urbandroid/smartlight/hue/HueDiscovery;)V", "getContext", "()Landroid/content/Context;", "getSdk", "()Lcom/philips/lighting/hue/sdk/PHHueSDK;", "getDiscovery", "()Lcom/urbandroid/smartlight/hue/HueDiscovery;", "tag", "", "getTag", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "listeners", "", "Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "Lcom/urbandroid/smartlight/common/model/Gateway$Hue;", "addListener", "", "listener", "removeListener", "authListeners", "Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "addAuthListener", "removeAuthListener", "clearListeners", "gateway", "getGateway", "()Lcom/urbandroid/smartlight/common/model/Gateway$Hue;", "setGateway", "(Lcom/urbandroid/smartlight/common/model/Gateway$Hue;)V", "onAccessPointsFound", "accessPoint", "", "Lcom/philips/lighting/hue/sdk/PHAccessPoint;", "onCacheUpdated", "arg0", "", "bridge", "Lcom/philips/lighting/model/PHBridge;", "onBridgeConnected", "b", "username", "onAuthenticationRequired", "onConnectionResumed", "onConnectionLost", "onError", "code", "message", "onParsingErrors", "parsingErrorsList", "Lcom/philips/lighting/model/PHHueParsingError;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExtendedHueListener implements PHSDKListener, FeatureLogger, CoroutineScope {
        private final List<Discovery.AuthListener<Gateway.Hue>> authListeners;
        private final Context context;
        private final CoroutineContext coroutineContext;
        private final HueDiscovery discovery;
        private Gateway.Hue gateway;
        private final CompletableJob job;
        private final List<Discovery.Listener<Gateway.Hue>> listeners;
        private final PHHueSDK sdk;
        private final String tag;

        public ExtendedHueListener(Context context, PHHueSDK pHHueSDK, HueDiscovery hueDiscovery) {
            context.getClass();
            pHHueSDK.getClass();
            hueDiscovery.getClass();
            this.context = context;
            this.sdk = pHHueSDK;
            this.discovery = hueDiscovery;
            this.tag = Common_smartlightKt.TAG;
            CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
            this.job = completableJobSupervisorJob$default;
            this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default);
            this.listeners = new ArrayList();
            this.authListeners = new ArrayList();
        }

        public final void addAuthListener(Discovery.AuthListener<Gateway.Hue> listener) {
            listener.getClass();
            this.authListeners.add(listener);
        }

        public final void addListener(Discovery.Listener<Gateway.Hue> listener) {
            listener.getClass();
            this.listeners.add(listener);
        }

        public final void clearListeners() {
            this.authListeners.clear();
            this.listeners.clear();
        }

        public final Context getContext() {
            return this.context;
        }

        @Override // kotlinx.coroutines.CoroutineScope
        public CoroutineContext getCoroutineContext() {
            return this.coroutineContext;
        }

        public final HueDiscovery getDiscovery() {
            return this.discovery;
        }

        public final Gateway.Hue getGateway() {
            return this.gateway;
        }

        public final PHHueSDK getSdk() {
            return this.sdk;
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return this.tag;
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onAccessPointsFound(List<? extends PHAccessPoint> accessPoint) {
            accessPoint.getClass();
            if (accessPoint.isEmpty()) {
                return;
            }
            String str = "Access Points Found. " + accessPoint.size();
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + ((Object) str), null);
            this.sdk.getAccessPointsFound().clear();
            this.sdk.getAccessPointsFound().addAll(accessPoint);
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HueDiscovery$ExtendedHueListener$onAccessPointsFound$1(accessPoint, this, null), 3, null);
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onAuthenticationRequired(PHAccessPoint accessPoint) {
            ExtendedHueListener extendedHueListener;
            accessPoint.getClass();
            Logger.logWarning(Logger.defaultTag, getTag() + ": Authentication Required.", null);
            this.sdk.startPushlinkAuthentication(accessPoint);
            Iterator<T> it = this.authListeners.iterator();
            while (it.hasNext()) {
                Discovery.AuthListener authListener = (Discovery.AuthListener) it.next();
                Gateway.Hue hue = this.gateway;
                if (hue != null) {
                    extendedHueListener = this;
                    BuildersKt__Builders_commonKt.launch$default(extendedHueListener, null, null, new HueDiscovery$ExtendedHueListener$onAuthenticationRequired$1$1$1(authListener, hue, null), 3, null);
                } else {
                    extendedHueListener = this;
                }
                this = extendedHueListener;
            }
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onBridgeConnected(PHBridge b, String username) {
            b.getClass();
            username.getClass();
            PHHueSDK pHHueSDK = this.sdk;
            pHHueSDK.setSelectedBridge(b);
            pHHueSDK.enableHeartbeat(b, 10000L);
            Map<String, Long> lastHeartbeat = pHHueSDK.getLastHeartbeat();
            lastHeartbeat.getClass();
            lastHeartbeat.put(b.getResourceCache().getBridgeConfiguration().getIpAddress(), Long.valueOf(System.currentTimeMillis()));
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HueDiscovery$ExtendedHueListener$onBridgeConnected$2(this, username, null), 3, null);
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onCacheUpdated(List<Integer> arg0, PHBridge bridge) {
            arg0.getClass();
            bridge.getClass();
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onConnectionLost(PHAccessPoint accessPoint) {
            accessPoint.getClass();
            String str = "SmartLight:onConnectionLost : " + accessPoint.getIpAddress();
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + ((Object) str), null);
            List<PHAccessPoint> disconnectedAccessPoint = this.sdk.getDisconnectedAccessPoint();
            if (disconnectedAccessPoint.contains(accessPoint)) {
                return;
            }
            disconnectedAccessPoint.add(accessPoint);
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onConnectionResumed(PHBridge bridge) {
            bridge.getClass();
            String ipAddress = bridge.getResourceCache().getBridgeConfiguration().getIpAddress();
            String strM = FileInsert$$ExternalSyntheticOutline0.m("SmartLight:onConnectionResumed ", ipAddress);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + ((Object) strM), null);
            Map<String, Long> lastHeartbeat = this.sdk.getLastHeartbeat();
            lastHeartbeat.getClass();
            lastHeartbeat.put(ipAddress, Long.valueOf(System.currentTimeMillis()));
            List<PHAccessPoint> disconnectedAccessPoint = this.sdk.getDisconnectedAccessPoint();
            int size = disconnectedAccessPoint.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(disconnectedAccessPoint.get(i).getIpAddress(), ipAddress)) {
                    disconnectedAccessPoint.remove(i);
                }
            }
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onError(int code, String message) {
            ExtendedHueListener extendedHueListener;
            Exception exc;
            try {
                String str = Logger.defaultTag;
                Logger.logSevere(str, getTag() + ": " + ((Object) ("Hue error " + code + ':' + message)), null);
                try {
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                extendedHueListener = this;
            }
            if (code != 1) {
                if (code == 22) {
                    Logger.logWarning(Logger.defaultTag, getTag() + ": On No Connection", null);
                    return;
                }
                if (code == 46) {
                    Logger.logWarning(Logger.defaultTag, getTag() + ": Bridge Not Responding . . . ", null);
                    return;
                }
                if (code != 1157) {
                    if (code != 1158) {
                        return;
                    }
                } else if (this.discovery.fallbackSearch) {
                    try {
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HueDiscovery$ExtendedHueListener$onError$2(this, null), 3, null);
                        return;
                    } catch (Exception e3) {
                        e = e3;
                        extendedHueListener = this;
                    }
                } else {
                    try {
                        Object sDKService = this.sdk.getSDKService((byte) 1);
                        sDKService.getClass();
                        Logger.logInfo(Logger.defaultTag, getTag() + ": hue search 2", null);
                        ((PHBridgeSearchManager) sDKService).search(false, false, true);
                        this.discovery.fallbackSearch = true;
                        return;
                    } catch (Exception e4) {
                        exc = e4;
                        extendedHueListener = this;
                    }
                }
                exc = e;
                Logger.logSevere(Logger.defaultTag, extendedHueListener.getTag(), exc);
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HueDiscovery$ExtendedHueListener$onError$1(this, null), 3, null);
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onParsingErrors(List<? extends PHHueParsingError> parsingErrorsList) {
            parsingErrorsList.getClass();
            Iterator<? extends PHHueParsingError> it = parsingErrorsList.iterator();
            while (it.hasNext()) {
                String str = "ParsingError : " + it.next().getMessage();
                Logger.logSevere(Logger.defaultTag, getTag() + ": " + ((Object) str), null);
            }
        }

        public final void removeAuthListener(Discovery.AuthListener<Gateway.Hue> listener) {
            listener.getClass();
            this.authListeners.remove(listener);
        }

        public final void removeListener(Discovery.Listener<Gateway.Hue> listener) {
            listener.getClass();
            this.listeners.remove(listener);
        }

        public final void setGateway(Gateway.Hue hue) {
            this.gateway = hue;
        }
    }

    public HueDiscovery(Context context) {
        context.getClass();
        this.context = context;
        this.tag = Common_smartlightKt.TAG;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new HueDiscovery$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
        PHHueSDK pHHueSDKCreate = PHHueSDK.create();
        pHHueSDKCreate.setAppName("SleepAsAndroid");
        pHHueSDKCreate.setDeviceName(Build.MODEL);
        this.sdk = pHHueSDKCreate;
        ExtendedHueListener extendedHueListener = new ExtendedHueListener(context, pHHueSDKCreate, this);
        extendedHueListener.getSdk().getNotificationManager().registerSDKListener(extendedHueListener);
        this.hueListener = extendedHueListener;
    }

    public void authenticate(Gateway.Hue gateway, Discovery.AuthListener<Gateway.Hue> listener) {
        gateway.getClass();
        listener.getClass();
        ExtendedHueListener extendedHueListener = this.hueListener;
        if (extendedHueListener != null) {
            extendedHueListener.setGateway(gateway);
        }
        PHAccessPoint accessPoint = MappersKt.toAccessPoint(gateway);
        if (!this.sdk.isAccessPointConnected(accessPoint)) {
            ExtendedHueListener extendedHueListener2 = this.hueListener;
            if (extendedHueListener2 != null) {
                extendedHueListener2.addAuthListener(listener);
            }
            try {
                this.sdk.connect(accessPoint);
                return;
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, getTag(), e);
                listener.failed(gateway);
                return;
            }
        }
        AuthenticatedGateway authenticatedGatewayLoad = AuthenticatedGateway.INSTANCE.load(this.context);
        if (authenticatedGatewayLoad != null && Intrinsics.areEqual(authenticatedGatewayLoad.getIp(), accessPoint.getIpAddress())) {
            listener.success(authenticatedGatewayLoad);
            return;
        }
        try {
            if (this.sdk.getSelectedBridge() != null) {
                PHHueSDK pHHueSDK = this.sdk;
                pHHueSDK.disconnect(pHHueSDK.getSelectedBridge());
            }
        } catch (Exception e2) {
            Logger.logSevere(Logger.defaultTag, getTag(), e2);
        }
        ExtendedHueListener extendedHueListener3 = this.hueListener;
        if (extendedHueListener3 != null) {
            extendedHueListener3.addAuthListener(listener);
        }
        try {
            this.sdk.connect(accessPoint);
        } catch (Exception e3) {
            String message = e3.getMessage();
            if (message != null && !StringsKt.contains$default(message, "already connected")) {
                Logger.logSevere(Logger.defaultTag, getTag(), e3);
                listener.failed(gateway);
                return;
            }
            Logger.logSevere(Logger.defaultTag, getTag() + ": Already connected at auth()", e3);
            try {
                if (this.sdk.getSelectedBridge() != null) {
                    PHHueSDK pHHueSDK2 = this.sdk;
                    pHHueSDK2.disconnect(pHHueSDK2.getSelectedBridge());
                }
                this.sdk.connect(accessPoint);
            } catch (Exception e4) {
                Logger.logSevere(Logger.defaultTag, getTag() + ": Connected disconnect and reconnect ", e4);
                listener.failed(gateway);
            }
        }
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void close() {
        Gateway.Hue gateway;
        Job.cancel$default(this.job, null, 1, null);
        try {
            ExtendedHueListener extendedHueListener = this.hueListener;
            if (extendedHueListener != null) {
                this.sdk.getNotificationManager().unregisterSDKListener(extendedHueListener);
            }
            this.sdk.disableAllHeartbeat();
            ExtendedHueListener extendedHueListener2 = this.hueListener;
            if (extendedHueListener2 != null && (gateway = extendedHueListener2.getGateway()) != null) {
                if (this.sdk.isAccessPointConnected(MappersKt.toAccessPoint(gateway)) && this.sdk.getSelectedBridge() != null) {
                    PHHueSDK pHHueSDK = this.sdk;
                    pHHueSDK.disconnect(pHHueSDK.getSelectedBridge());
                }
            }
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, getTag(), e);
        }
        try {
            this.sdk.destroySDK();
        } catch (Exception e2) {
            Logger.logSevere(Logger.defaultTag, getTag(), e2);
        }
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void discover(Discovery.Listener<Gateway.Hue> listener) {
        listener.getClass();
        Object sDKService = this.sdk.getSDKService((byte) 1);
        sDKService.getClass();
        PHBridgeSearchManager pHBridgeSearchManager = (PHBridgeSearchManager) sDKService;
        ExtendedHueListener extendedHueListener = this.hueListener;
        if (extendedHueListener != null) {
            extendedHueListener.addListener(listener);
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": hue search 1", null);
        this.fallbackSearch = false;
        pHBridgeSearchManager.search(true, true);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public /* bridge */ /* synthetic */ void authenticate(Gateway gateway, Discovery.AuthListener authListener) {
        authenticate((Gateway.Hue) gateway, (Discovery.AuthListener<Gateway.Hue>) authListener);
    }
}
