package com.urbandroid.smartlight.hue;

import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHHueParsingError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Blinder;
import com.urbandroid.smartlight.common.model.BlinderState;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.NamedThreadFactory;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002IJB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ8\u0010 \u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!*\u00020\"2\u001c\u0010#\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0%\u0012\u0006\u0012\u0004\u0018\u00010\"0$H\u0082@¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010,J4\u0010'\u001a\u00020-*\b\u0012\u0004\u0012\u00020)0.2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020+02\"\u00020+H\u0082@¢\u0006\u0002\u00103J\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020)0.H\u0096@¢\u0006\u0002\u00105J$\u00106\u001a\u00020-2\f\u00107\u001a\b\u0012\u0004\u0012\u00020)0.2\u0006\u0010*\u001a\u000208H\u0096@¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u0004\u0018\u0001082\u0006\u0010;\u001a\u00020)H\u0096@¢\u0006\u0002\u0010<J,\u0010=\u001a\u00020-2\f\u00107\u001a\b\u0012\u0004\u0012\u00020)0.2\u0006\u0010*\u001a\u0002082\u0006\u0010>\u001a\u000200H\u0096@¢\u0006\u0002\u0010?J\u000e\u0010@\u001a\u00020-H\u0096@¢\u0006\u0002\u00105J\u0018\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020DH\u0096@¢\u0006\u0002\u0010EJ$\u0010F\u001a\u00020-2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020D0.2\u0006\u0010*\u001a\u00020BH\u0096@¢\u0006\u0002\u0010HR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/urbandroid/smartlight/hue/HueController;", "Lcom/urbandroid/smartlight/common/controller/Controller;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "gateway", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Hue;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Hue;)V", "getContext", "()Landroid/content/Context;", "getGateway", "()Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Hue;", "tag", "", "getTag", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", ServerProtocol.DIALOG_PARAM_SDK_VERSION, "Lcom/philips/lighting/hue/sdk/PHHueSDK;", "hueListener", "Lcom/urbandroid/smartlight/hue/HueController$ExtendedHueListener;", "connect", "T", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "", "Lcom/urbandroid/smartlight/common/model/Light;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/philips/lighting/model/PHLightState;", "(Lcom/urbandroid/smartlight/common/model/Light;Lcom/philips/lighting/model/PHLightState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "timeoutInSec", "", "states", "", "(Ljava/util/List;I[Lcom/philips/lighting/model/PHLightState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLights", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setState", "lights", "Lcom/urbandroid/smartlight/common/model/State;", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getState", "light", "(Lcom/urbandroid/smartlight/common/model/Light;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "blink", "repeat", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "getBlinderState", "Lcom/urbandroid/smartlight/common/model/BlinderState;", "blinder", "Lcom/urbandroid/smartlight/common/model/Blinder;", "(Lcom/urbandroid/smartlight/common/model/Blinder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBlinderState", "blinders", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/BlinderState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "HueLightListener", "ExtendedHueListener", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HueController implements Controller, FeatureLogger, CoroutineScope {
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final ScheduledExecutorService executor;
    private final AuthenticatedGateway.Hue gateway;
    private final ExtendedHueListener hueListener;
    private final CompletableJob job;
    private final PHHueSDK sdk;
    private final String tag;

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u0011\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\u001eJ!\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010(\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u000eH\u0016¢\u0006\u0004\b(\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u00198\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R&\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/urbandroid/smartlight/hue/HueController$ExtendedHueListener;", "Lcom/philips/lighting/hue/sdk/PHSDKListener;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/philips/lighting/hue/sdk/PHHueSDK;", ServerProtocol.DIALOG_PARAM_SDK_VERSION, "<init>", "(Lcom/philips/lighting/hue/sdk/PHHueSDK;)V", "Lkotlin/Function1;", "", "", "listener", "addListener", "(Lkotlin/jvm/functions/Function1;)V", "removeListener", "", "Lcom/philips/lighting/hue/sdk/PHAccessPoint;", "accessPoint", "onAccessPointsFound", "(Ljava/util/List;)V", "", "arg0", "Lcom/philips/lighting/model/PHBridge;", "bridge", "onCacheUpdated", "(Ljava/util/List;Lcom/philips/lighting/model/PHBridge;)V", "", "username", "onBridgeConnected", "(Lcom/philips/lighting/model/PHBridge;Ljava/lang/String;)V", "onAuthenticationRequired", "(Lcom/philips/lighting/hue/sdk/PHAccessPoint;)V", "onConnectionResumed", "(Lcom/philips/lighting/model/PHBridge;)V", "onConnectionLost", "code", "message", "onError", "(ILjava/lang/String;)V", "Lcom/philips/lighting/model/PHHueParsingError;", "parsingErrorsList", "onParsingErrors", "Lcom/philips/lighting/hue/sdk/PHHueSDK;", "getSdk", "()Lcom/philips/lighting/hue/sdk/PHHueSDK;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "listeners", "Ljava/util/List;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExtendedHueListener implements PHSDKListener, FeatureLogger {
        private final List<Function1<Boolean, Unit>> listeners;
        private final PHHueSDK sdk;
        private final String tag;

        public ExtendedHueListener(PHHueSDK pHHueSDK) {
            pHHueSDK.getClass();
            this.sdk = pHHueSDK;
            this.tag = Common_smartlightKt.TAG;
            this.listeners = new ArrayList();
        }

        public final void addListener(Function1<? super Boolean, Unit> listener) {
            listener.getClass();
            this.listeners.add(listener);
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
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onAuthenticationRequired(PHAccessPoint accessPoint) {
            accessPoint.getClass();
            Logger.logWarning(Logger.defaultTag, getTag() + ": Authentication Required.", null);
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(Boolean.FALSE);
            }
            this.listeners.clear();
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onBridgeConnected(PHBridge bridge, String username) {
            bridge.getClass();
            username.getClass();
            PHHueSDK pHHueSDK = this.sdk;
            pHHueSDK.setSelectedBridge(bridge);
            pHHueSDK.enableHeartbeat(bridge, 10000L);
            Map<String, Long> lastHeartbeat = pHHueSDK.getLastHeartbeat();
            lastHeartbeat.getClass();
            lastHeartbeat.put(bridge.getResourceCache().getBridgeConfiguration().getIpAddress(), Long.valueOf(System.currentTimeMillis()));
            Logger.logInfo(Logger.defaultTag, getTag() + ": onBridgeConnected", null);
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(Boolean.TRUE);
            }
            this.listeners.clear();
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
            PHHueSDK pHHueSDK = this.sdk;
            if (pHHueSDK.getDisconnectedAccessPoint().contains(accessPoint)) {
                return;
            }
            pHHueSDK.getDisconnectedAccessPoint().add(accessPoint);
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onConnectionResumed(PHBridge bridge) {
            bridge.getClass();
            String ipAddress = bridge.getResourceCache().getBridgeConfiguration().getIpAddress();
            PHHueSDK pHHueSDK = this.sdk;
            Map<String, Long> lastHeartbeat = pHHueSDK.getLastHeartbeat();
            lastHeartbeat.getClass();
            lastHeartbeat.put(ipAddress, Long.valueOf(System.currentTimeMillis()));
            List<PHAccessPoint> disconnectedAccessPoint = pHHueSDK.getDisconnectedAccessPoint();
            disconnectedAccessPoint.getClass();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : disconnectedAccessPoint) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Integer numValueOf = Intrinsics.areEqual(((PHAccessPoint) obj).getIpAddress(), ipAddress) ? Integer.valueOf(i) : null;
                if (numValueOf != null) {
                    arrayList.add(numValueOf);
                }
                i = i2;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                pHHueSDK.getDisconnectedAccessPoint().remove(((Number) it.next()).intValue());
            }
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onError(int code, String message) {
            try {
                String str = Logger.defaultTag;
                Logger.logSevere(str, getTag() + ": " + ((Object) ("SmartLight:on Error Called : " + code + ':' + message)), null);
                if (code != 1 && code != 22) {
                    if (code == 27) {
                        Logger.logWarning(Logger.defaultTag, getTag() + ": Bridge Already connected", null);
                        Iterator<T> it = this.listeners.iterator();
                        while (it.hasNext()) {
                            ((Function1) it.next()).invoke(Boolean.TRUE);
                        }
                        this.listeners.clear();
                        return;
                    }
                    if (code != 46) {
                        if (code == 1157) {
                            Logger.logWarning(Logger.defaultTag, getTag() + ": Bridge Not found", null);
                            return;
                        }
                        if (code != 1158) {
                            String str2 = Logger.defaultTag;
                            Logger.logWarning(str2, getTag() + ": " + ((Object) ("Unkdnown code " + code)), null);
                            return;
                        }
                    }
                }
                Logger.logWarning(Logger.defaultTag, getTag() + ": Bridge Connection error", null);
                Iterator<T> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    ((Function1) it2.next()).invoke(Boolean.FALSE);
                }
                this.listeners.clear();
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, getTag(), e);
            }
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onParsingErrors(List<? extends PHHueParsingError> parsingErrorsList) {
            parsingErrorsList.getClass();
            for (PHHueParsingError pHHueParsingError : parsingErrorsList) {
            }
        }

        public final void removeListener(Function1<? super Boolean, Unit> listener) {
            listener.getClass();
            this.listeners.remove(listener);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J.\u0010\u0012\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015H\u0016J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/smartlight/hue/HueController$HueLightListener;", "Lcom/philips/lighting/hue/listener/PHLightListener;", "Lcom/urbandroid/common/FeatureLogger;", "continuation", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/coroutines/Continuation;)V", "tag", "", "getTag", "()Ljava/lang/String;", "onSuccess", "", "onReceivingLightDetails", "p0", "Lcom/philips/lighting/model/PHLight;", "onSearchComplete", "onStateUpdate", "", "p1", "", "Lcom/philips/lighting/model/PHHueError;", "onReceivingLights", "Lcom/philips/lighting/model/PHBridgeResource;", "onError", "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HueLightListener implements PHLightListener, FeatureLogger {
        private final Continuation<Boolean> continuation;
        private final String tag;

        /* JADX WARN: Multi-variable type inference failed */
        public HueLightListener(Continuation<? super Boolean> continuation) {
            continuation.getClass();
            this.continuation = continuation;
            this.tag = "SmartLight:HueLightListener";
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return this.tag;
        }

        @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
        public void onError(int p0, String p1) {
            Continuation<Boolean> continuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m2357constructorimpl(Boolean.FALSE));
        }

        @Override // com.philips.lighting.hue.listener.PHLightListener
        public void onReceivingLightDetails(PHLight p0) {
        }

        @Override // com.philips.lighting.hue.listener.PHLightListener
        public void onReceivingLights(List<PHBridgeResource> p0) {
        }

        @Override // com.philips.lighting.hue.listener.PHLightListener
        public void onSearchComplete() {
        }

        @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
        public void onStateUpdate(Map<String, String> p0, List<PHHueError> p1) {
        }

        @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
        public void onSuccess() {
            Continuation<Boolean> continuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m2357constructorimpl(Boolean.TRUE));
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$blink$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController", f = "HueController.kt", l = {216, 223, 225}, m = "blink")
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HueController.this.blink((List<Light>) null, (State) null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$blink$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$blink$2", f = "HueController.kt", l = {217}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Light> $lights;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<Light> list, State state, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$lights = list;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HueController.this.new AnonymousClass2(this.$lights, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HueController hueController = HueController.this;
                List<Light> list = this.$lights;
                PHLightState hueState = MappersKt.toHueState(this.$state);
                PHLightState pHLightState = new PHLightState();
                pHLightState.setAlertMode(PHLight.PHLightAlertMode.ALERT_LSELECT);
                Unit unit = Unit.INSTANCE;
                this.label = 1;
                if (hueController.execute(list, 20, new PHLightState[]{hueState, pHLightState}, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$blink$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$blink$3", f = "HueController.kt", l = {226}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Light> $lights;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(List<Light> list, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$lights = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HueController.this.new AnonymousClass3(this.$lights, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HueController hueController = HueController.this;
                List<Light> list = this.$lights;
                PHLightState pHLightState = new PHLightState();
                pHLightState.setAlertMode(PHLight.PHLightAlertMode.ALERT_NONE);
                pHLightState.setOn(Boxing.boxBoolean(false));
                Unit unit = Unit.INSTANCE;
                this.label = 1;
                if (hueController.execute(list, 20, new PHLightState[]{pHLightState}, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$close$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$close$2", f = "HueController.kt", l = {}, m = "invokeSuspend")
    public static final class C22272 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$close$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$close$2$1", f = "HueController.kt", l = {345}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HueController this$0;

            /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$close$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$close$2$1$1", f = "HueController.kt", l = {}, m = "invokeSuspend")
            public static final class C00651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ HueController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00651(HueController hueController, Continuation<? super C00651> continuation) {
                    super(2, continuation);
                    this.this$0 = hueController;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00651(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    HueController hueController = this.this$0;
                    Logger.logInfo(Logger.defaultTag, hueController.getTag() + ": SDK destroy BEFORE", null);
                    try {
                        this.this$0.sdk.getNotificationManager().unregisterSDKListener(this.this$0.hueListener);
                    } catch (Exception e) {
                        Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e);
                    }
                    try {
                        this.this$0.sdk.disableAllHeartbeat();
                    } catch (Exception e2) {
                        Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e2);
                    }
                    try {
                        if (this.this$0.sdk.isAccessPointConnected(MappersKt.toAccessPoint(this.this$0.getGateway())) && this.this$0.sdk.getSelectedBridge() != null) {
                            this.this$0.sdk.disconnect(this.this$0.sdk.getSelectedBridge());
                        }
                    } catch (Exception e3) {
                        Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e3);
                    }
                    try {
                        this.this$0.sdk.destroySDK();
                    } catch (Exception e4) {
                        Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e4);
                    }
                    HueController hueController2 = this.this$0;
                    Logger.logInfo(Logger.defaultTag, hueController2.getTag() + ": SDK destroy AFTER", null);
                    Job.cancel$default(this.this$0.job, null, 1, null);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(HueController hueController, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = hueController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    C00651 c00651 = new C00651(this.this$0, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c00651, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        public C22272(Continuation<? super C22272> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22272 c22272 = HueController.this.new C22272(continuation);
            c22272.L$0 = obj;
            return c22272;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C22272) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(HueController.this, null), 3, null);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$connect$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$connect$2", f = "HueController.kt", l = {100, 390, 131}, m = "invokeSuspend")
    public static final class C22282<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C22282(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super C22282> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HueController.this.new C22282(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C22282) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
        
            if (r11 == r0) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zIsAccessPointConnected;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean zBooleanValue = false;
            try {
            } catch (TimeoutCancellationException e) {
                HueController hueController = HueController.this;
                Logger.logSevere(Logger.defaultTag, hueController.getTag() + ": SmartLight: failed to connect timeout", e);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PHAccessPoint accessPoint = MappersKt.toAccessPoint(HueController.this.getGateway());
                try {
                    zIsAccessPointConnected = HueController.this.sdk.isAccessPointConnected(accessPoint);
                } catch (Exception e2) {
                    HueController hueController2 = HueController.this;
                    Logger.logWarning(Logger.defaultTag, hueController2.getTag() + ": Cannot connect to access point..", e2);
                    zIsAccessPointConnected = false;
                }
                if (zIsAccessPointConnected) {
                    Function1<Continuation<? super T>, Object> function1 = this.$block;
                    this.label = 1;
                    Object objInvoke = function1.invoke(this);
                    if (objInvoke != coroutine_suspended) {
                        return objInvoke;
                    }
                } else {
                    HueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 hueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new HueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, HueController.this, accessPoint);
                    this.label = 2;
                    obj = TimeoutKt.withTimeout(10000L, hueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
                    if (obj == coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i != 2) {
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            zBooleanValue = ((Boolean) obj).booleanValue();
            if (!zBooleanValue) {
                return null;
            }
            Function1<Continuation<? super T>, Object> function12 = this.$block;
            this.label = 3;
            obj = function12.invoke(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$execute$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$execute$4", f = "HueController.kt", l = {156}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PHLightState[] $states;
        final /* synthetic */ List<Light> $this_execute;
        int label;
        final /* synthetic */ HueController this$0;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$execute$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$execute$4$1", f = "HueController.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PHLightState[] $states;
            final /* synthetic */ List<Light> $this_execute;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ HueController this$0;

            /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$execute$4$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$execute$4$1$1", f = "HueController.kt", l = {158}, m = "invokeSuspend")
            public static final class C00661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Light $light;
                final /* synthetic */ PHLightState[] $states;
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                final /* synthetic */ HueController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00661(PHLightState[] pHLightStateArr, HueController hueController, Light light, Continuation<? super C00661> continuation) {
                    super(2, continuation);
                    this.$states = pHLightStateArr;
                    this.this$0 = hueController;
                    this.$light = light;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00661(this.$states, this.this$0, this.$light, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004b -> B:13:0x004e). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    HueController hueController;
                    int length;
                    Light light;
                    int i;
                    PHLightState[] pHLightStateArr;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        PHLightState[] pHLightStateArr2 = this.$states;
                        HueController hueController2 = this.this$0;
                        Light light2 = this.$light;
                        hueController = hueController2;
                        length = pHLightStateArr2.length;
                        light = light2;
                        i = 0;
                        pHLightStateArr = pHLightStateArr2;
                        if (i < length) {
                        }
                    } else {
                        if (i2 != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        length = this.I$1;
                        i = this.I$0;
                        light = (Light) this.L$2;
                        hueController = (HueController) this.L$1;
                        pHLightStateArr = (PHLightState[]) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i++;
                        if (i < length) {
                            PHLightState pHLightState = pHLightStateArr[i];
                            this.L$0 = pHLightStateArr;
                            this.L$1 = hueController;
                            this.L$2 = light;
                            this.I$0 = i;
                            this.I$1 = length;
                            this.label = 1;
                            if (hueController.execute(light, pHLightState, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i++;
                            if (i < length) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List<Light> list, PHLightState[] pHLightStateArr, HueController hueController, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_execute = list;
                this.$states = pHLightStateArr;
                this.this$0 = hueController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_execute, this.$states, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Iterator<Light> it = this.$this_execute.iterator();
                while (it.hasNext()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00661(this.$states, this.this$0, it.next(), null), 3, null);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(List<Light> list, PHLightState[] pHLightStateArr, HueController hueController, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$this_execute = list;
            this.$states = pHLightStateArr;
            this.this$0 = hueController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$this_execute, this.$states, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_execute, this.$states, this.this$0, null);
                this.label = 1;
                if (SupervisorKt.supervisorScope(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$getLights$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController", f = "HueController.kt", l = {164}, m = "getLights")
    public static final class C22291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C22291(Continuation<? super C22291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HueController.this.getLights(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$getLights$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/smartlight/common/model/Light;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$getLights$2", f = "HueController.kt", l = {}, m = "invokeSuspend")
    public static final class C22302 extends SuspendLambda implements Function1<Continuation<? super List<? extends Light>>, Object> {
        int label;

        public C22302(Continuation<? super C22302> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HueController.this.new C22302(continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super List<Light>> continuation) {
            return ((C22302) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            List<PHLight> allLights = HueController.this.sdk.getSelectedBridge().getResourceCache().getAllLights();
            allLights.getClass();
            List<PHLight> list = allLights;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PHLight pHLight : list) {
                pHLight.getClass();
                arrayList.add(MappersKt.toLight(pHLight));
            }
            return arrayList;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends Light>> continuation) {
            return invoke2((Continuation<? super List<Light>>) continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$getState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/smartlight/common/model/State;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$getState$2", f = "HueController.kt", l = {389}, m = "invokeSuspend")
    public static final class C22312 extends SuspendLambda implements Function1<Continuation<? super State>, Object> {
        final /* synthetic */ Light $light;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22312(Light light, Continuation<? super C22312> continuation) {
            super(1, continuation);
            this.$light = light;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HueController.this.new C22312(this.$light, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super State> continuation) {
            return ((C22312) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            HueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 hueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new HueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, HueController.this, this.$light);
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(10000L, hueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.HueController$setState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$setState$2", f = "HueController.kt", l = {168}, m = "invokeSuspend")
    public static final class C22322 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Light> $lights;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22322(List<Light> list, State state, Continuation<? super C22322> continuation) {
            super(1, continuation);
            this.$lights = list;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HueController.this.new C22322(this.$lights, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22322) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HueController hueController = HueController.this;
                List<Light> list = this.$lights;
                PHLightState[] pHLightStateArr = {MappersKt.toHueState(this.$state)};
                this.label = 1;
                if (hueController.execute(list, 20, pHLightStateArr, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HueController(Context context, AuthenticatedGateway.Hue hue) {
        String packageName;
        context.getClass();
        hue.getClass();
        this.context = context;
        this.gateway = hue;
        this.tag = Common_smartlightKt.TAG;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new HueController$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("io"));
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.getClass();
        this.executor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        PHHueSDK pHHueSDKCreate = PHHueSDK.create();
        Logger.logInfo(Logger.defaultTag, getTag() + ": SDK init BEFORE", null);
        String packageName2 = context.getPackageName();
        if (packageName2 == null) {
            packageName = context.getPackageName();
        } else {
            int iHashCode = packageName2.hashCode();
            if (iHashCode != -920550783) {
                if (iHashCode != -920546920) {
                    if (iHashCode == 123854368 && packageName2.equals("com.urbandroid.sleep")) {
                        packageName = "SleepAsAndroid";
                    }
                } else if (packageName2.equals("com.urbandroid.lux")) {
                    packageName = "Twilight";
                }
            } else if (packageName2.equals("com.urbandroid.hue")) {
                packageName = "Huemanic";
            }
        }
        pHHueSDKCreate.setAppName(packageName);
        pHHueSDKCreate.setDeviceName(Build.MODEL);
        this.sdk = pHHueSDKCreate;
        ExtendedHueListener extendedHueListener = new ExtendedHueListener(pHHueSDKCreate);
        extendedHueListener.getSdk().getNotificationManager().registerSDKListener(extendedHueListener);
        Logger.logInfo(Logger.defaultTag, getTag() + ": SDK init AFTER", null);
        this.hueListener = extendedHueListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object connect(Object obj, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return BuildersKt.withContext(ExecutorsKt.from((ExecutorService) this.executor), new C22282(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object execute(Light light, PHLightState pHLightState, Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        PHLight hueLight = MappersKt.toHueLight(light);
        if (pHLightState.getCt() != null) {
            if (light.getType() == Light.Type.CT) {
                pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_CT);
                pHLightState.setHue(null);
                pHLightState.setSaturation(null);
            } else {
                pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION);
                pHLightState.setCt(null);
            }
        }
        this.sdk.getSelectedBridge().updateLightState(hueLight, pHLightState, new HueLightListener(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbandroid.smartlight.common.controller.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object blink(List<Light> list, State state, int i, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        HueController hueController;
        List<Light> list2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(list, state, null);
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = list;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            if (connect(this, anonymousClass2, anonymousClass1) != coroutine_suspended) {
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            list2 = (List) anonymousClass1.L$1;
            HueController hueController2 = (HueController) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            hueController = hueController2;
            AnonymousClass3 anonymousClass3 = hueController.new AnonymousClass3(list2, null);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            Object objConnect = hueController.connect(hueController, anonymousClass3, anonymousClass1);
            return objConnect != coroutine_suspended ? coroutine_suspended : objConnect;
        }
        i = anonymousClass1.I$0;
        list = (List) anonymousClass1.L$1;
        this = (HueController) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = list;
        anonymousClass1.label = 2;
        if (DelayKt.delay(((long) i) * 1000, anonymousClass1) != coroutine_suspended) {
            List<Light> list3 = list;
            hueController = this;
            list2 = list3;
            AnonymousClass3 anonymousClass32 = hueController.new AnonymousClass3(list2, null);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            Object objConnect2 = hueController.connect(hueController, anonymousClass32, anonymousClass1);
            if (objConnect2 != coroutine_suspended) {
            }
        }
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object close(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(ExecutorsKt.from((ExecutorService) this.executor), new C22272(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getBlinderState(Blinder blinder, Continuation<? super BlinderState> continuation) {
        String str = Logger.defaultTag;
        Logger.logWarning(str, getTag() + ": " + ((Object) ("getBlinderState not implemented - " + blinder)), null);
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final ScheduledExecutorService getExecutor() {
        return this.executor;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbandroid.smartlight.common.controller.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getLights(Continuation<? super List<Light>> continuation) {
        C22291 c22291;
        if (continuation instanceof C22291) {
            c22291 = (C22291) continuation;
            int i = c22291.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22291.label = i - Integer.MIN_VALUE;
            } else {
                c22291 = new C22291(continuation);
            }
        }
        Object objConnect = c22291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22291.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objConnect);
            C22302 c22302 = new C22302(null);
            c22291.label = 1;
            objConnect = connect(this, c22302, c22291);
            if (objConnect == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objConnect);
        }
        List list = (List) objConnect;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getState(Light light, Continuation<? super State> continuation) {
        return connect(this, new C22312(light, null), continuation);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(List<Blinder> list, BlinderState blinderState, Continuation<? super Unit> continuation) {
        String str = Logger.defaultTag;
        Logger.logWarning(str, getTag() + ": " + ((Object) ("setBlinderState not implemented - " + list)), null);
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setState(List<Light> list, State state, Continuation<? super Unit> continuation) {
        return connect(this, new C22322(list, state, null), continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public AuthenticatedGateway.Hue getGateway() {
        return this.gateway;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setState(Light light, State state, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.setState(this, light, state, continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(Blinder blinder, BlinderState blinderState, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.setBlinderState(this, blinder, blinderState, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object execute(List<Light> list, int i, PHLightState[] pHLightStateArr, Continuation<? super Unit> continuation) {
        Object objWithTimeout = TimeoutKt.withTimeout(Utils.getSecondsInMillis(i), new AnonymousClass4(list, pHLightStateArr, this, null), continuation);
        return objWithTimeout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithTimeout : Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object blink(Light light, State state, int i, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.blink(this, light, state, i, continuation);
    }
}
