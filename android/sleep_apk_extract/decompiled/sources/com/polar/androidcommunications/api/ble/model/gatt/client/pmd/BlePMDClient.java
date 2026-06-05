package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.work.ListenableFutureKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.exceptions.BleCharacteristicNotificationNotEnabled;
import com.polar.androidcommunications.api.ble.exceptions.BleControlPointCommandError;
import com.polar.androidcommunications.api.ble.exceptions.BleControlPointResponseError;
import com.polar.androidcommunications.api.ble.exceptions.BleDisconnected;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdControlPointResponse;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdSetting;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.errors.BleOnlineStreamClosed;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.AccData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.EcgData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.GnssLocationData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.GyrData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.MagData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.PpgData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.PpiData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.PressureData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.SkinTemperatureData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.TemperatureData;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.BleUtils;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.polar.androidcommunications.common.ble.TypeUtils;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0084\u00012\u00020\u0001:\u0004\u0084\u0001\u0085\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b$\u0010%J!\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0'0\"2\u0006\u0010&\u001a\u00020\u0017¢\u0006\u0004\b(\u0010)J3\u0010.\u001a\u00020-2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010*\u001a\u00020#2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020-2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u001d\u00106\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010&\u001a\u00020\u0017H\u0000¢\u0006\u0004\b4\u00105J\u001d\u00109\u001a\b\u0012\u0004\u0012\u000207022\u0006\u0010&\u001a\u00020\u0017H\u0000¢\u0006\u0004\b8\u00105J\u0017\u0010:\u001a\u00020-2\u0006\u0010&\u001a\u00020\u0017H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\u00132\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020J2\u0006\u0010I\u001a\u00020\u0013H\u0002¢\u0006\u0004\bK\u0010LJ%\u0010O\u001a\b\u0012\u0004\u0012\u00020J0\"2\u0006\u0010F\u001a\u00020M2\u0006\u0010N\u001a\u00020EH\u0002¢\u0006\u0004\bO\u0010PJ'\u0010O\u001a\b\u0012\u0004\u0012\u00020J0\"2\u0006\u0010F\u001a\u00020M2\b\b\u0002\u0010Q\u001a\u00020\u0013H\u0002¢\u0006\u0004\bO\u0010RJ\u0017\u0010U\u001a\u00020\u00062\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VR2\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150X0W8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bY\u0010Z\u0012\u0004\b]\u0010\b\u001a\u0004\b[\u0010\\R\"\u0010a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020`0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u0002030_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010bR\"\u0010e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020d0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010bR\"\u0010g\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020f0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010bR\"\u0010i\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020h0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010bR\"\u0010j\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u0002070_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010bR\"\u0010l\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020k0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010bR\"\u0010n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020m0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010bR\"\u0010p\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020o0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010bR\"\u0010r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020q0_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010bR\u0018\u0010s\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010wR0\u0010z\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0X\u0012\u0004\u0012\u00020\r0y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R,\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0y8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b|\u0010{\u0012\u0004\b\u007f\u0010\b\u001a\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0082\u0001\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0086\u0001"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/BlePMDClient;", "Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattBase;", "Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattTxInterface;", "txInterface", "<init>", "(Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattTxInterface;)V", "", "reset", "()V", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;", "type", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;", "frameType", "Lkotlin/ULong;", "getPreviousFrameTimeStamp-ZIaKswc", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;)J", "getPreviousFrameTimeStamp", "Ljava/util/UUID;", "characteristic", "", "data", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "notifying", "processServiceData", "(Ljava/util/UUID;[BIZ)V", "processServiceDataWritten", "(Ljava/util/UUID;I)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdRecordingType;", "recordingType", "Lio/reactivex/rxjava3/core/Single;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting;", "querySettings", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdRecordingType;)Lio/reactivex/rxjava3/core/Single;", "checkConnection", "", "readFeature", "(Z)Lio/reactivex/rxjava3/core/Single;", "setting", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSecret;", "secret", "Lio/reactivex/rxjava3/core/Completable;", "startMeasurement", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdRecordingType;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSecret;)Lio/reactivex/rxjava3/core/Completable;", "stopMeasurement", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData;", "monitorAccNotifications$library_sdkRelease", "(Z)Lio/reactivex/rxjava3/core/Flowable;", "monitorAccNotifications", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData;", "monitorPpiNotifications$library_sdkRelease", "monitorPpiNotifications", "clientReady", "(Z)Lio/reactivex/rxjava3/core/Completable;", "", "getFactor", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;)F", "getSampleRate", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;)I", "processPmdCpCommand", "([BI)V", "processPmdData", "([B)V", "", "command", "receiveControlPointPacket", "(B)[B", "packet", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse;", "sendPmdCommand", "([B)Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandClientToService;", SDKConstants.PARAM_VALUE, "sendControlPointCommand", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandClientToService;B)Lio/reactivex/rxjava3/core/Single;", NativeProtocol.WEB_DIALOG_PARAMS, "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandClientToService;[B)Lio/reactivex/rxjava3/core/Single;", "", "throwable", "clearStreamObservers", "(Ljava/lang/Throwable;)V", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lkotlin/Pair;", "pmdCpResponseQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "getPmdCpResponseQueue", "()Ljava/util/concurrent/LinkedBlockingQueue;", "getPmdCpResponseQueue$annotations", "Lcom/polar/androidcommunications/common/ble/AtomicSet;", "Lio/reactivex/rxjava3/core/FlowableEmitter;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgData;", "ecgObservers", "Lcom/polar/androidcommunications/common/ble/AtomicSet;", "accObservers", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GyrData;", "gyroObservers", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData;", "magnetometerObservers", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData;", "ppgObservers", "ppiObservers", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PressureData;", "pressureObservers", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData;", "locationObservers", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/TemperatureData;", "temperatureObservers", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/SkinTemperatureData;", "skinTemperatureObservers", "pmdFeatureData", "[B", "Ljava/lang/Object;", "controlPointMutex", "Ljava/lang/Object;", "mutexFeature", "", "previousTimeStampMap", "Ljava/util/Map;", "currentSettings", "getCurrentSettings", "()Ljava/util/Map;", "getCurrentSettings$annotations", "Ljava/util/concurrent/atomic/AtomicInteger;", "pmdCpEnabled", "Ljava/util/concurrent/atomic/AtomicInteger;", "pmdDataEnabled", "Companion", "PmdDataFieldEncoding", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BlePMDClient extends BleGattBase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final UUID PMD_CP;
    public static final UUID PMD_DATA;
    public static final UUID PMD_SERVICE;
    private final AtomicSet<FlowableEmitter<? super AccData>> accObservers;
    private final Object controlPointMutex;
    private final Map<PmdMeasurementType, PmdSetting> currentSettings;
    private final AtomicSet<FlowableEmitter<? super EcgData>> ecgObservers;
    private final AtomicSet<FlowableEmitter<? super GyrData>> gyroObservers;
    private final AtomicSet<FlowableEmitter<? super GnssLocationData>> locationObservers;
    private final AtomicSet<FlowableEmitter<? super MagData>> magnetometerObservers;
    private final Object mutexFeature;
    private final AtomicInteger pmdCpEnabled;
    private final LinkedBlockingQueue<Pair<byte[], Integer>> pmdCpResponseQueue;
    private final AtomicInteger pmdDataEnabled;
    private byte[] pmdFeatureData;
    private final AtomicSet<FlowableEmitter<? super PpgData>> ppgObservers;
    private final AtomicSet<FlowableEmitter<? super PpiData>> ppiObservers;
    private final AtomicSet<FlowableEmitter<? super PressureData>> pressureObservers;
    private Map<Pair<PmdMeasurementType, PmdDataFrame.PmdDataFrameType>, ULong> previousTimeStampMap;
    private final AtomicSet<FlowableEmitter<? super SkinTemperatureData>> skinTemperatureObservers;
    private final AtomicSet<FlowableEmitter<? super TemperatureData>> temperatureObservers;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J2\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\n2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/BlePMDClient$Companion;", "", "()V", "PMD_CP", "Ljava/util/UUID;", "PMD_DATA", "PMD_SERVICE", "TAG", "", "parseDeltaFrame", "", "", "bytes", "", "channels", "bitWidth", "totalBitLength", "parseDeltaFrameRefSamples", "resolution", "type", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/BlePMDClient$PmdDataFieldEncoding;", "parseDeltaFramesAll", SDKConstants.PARAM_VALUE, "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<List<Integer>> parseDeltaFrame(byte[] bytes, int channels, int bitWidth, int totalBitLength) {
            ArrayList arrayList = new ArrayList();
            for (byte b : bytes) {
                for (int i = 0; i < 8; i++) {
                    boolean z = true;
                    if (((1 << i) & b) == 0) {
                        z = false;
                    }
                    arrayList.add(Boolean.valueOf(z));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int i2 = Integer.MAX_VALUE << (bitWidth - 1);
            int i3 = 0;
            while (i3 < totalBitLength) {
                ArrayList arrayList3 = new ArrayList();
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < channels) {
                        int i6 = i3 + bitWidth;
                        List listSubList = arrayList.subList(i3, i6);
                        int size = listSubList.size();
                        int i7 = 0;
                        for (int i8 = 0; i8 < size; i8++) {
                            i7 |= (((Boolean) listSubList.get(i8)).booleanValue() ? 1 : 0) << i8;
                        }
                        if ((i7 & i2) != 0) {
                            i7 |= i2;
                        }
                        arrayList3.add(Integer.valueOf(i7));
                        i3 = i6;
                        i4 = i5;
                    }
                }
                arrayList2.add(arrayList3);
            }
            return arrayList2;
        }

        public final List<Integer> parseDeltaFrameRefSamples(byte[] bytes, int channels, int resolution, PmdDataFieldEncoding type) {
            int iM897convertArrayToUnsignedInt_W1zjd8;
            bytes.getClass();
            type.getClass();
            ArrayList arrayList = new ArrayList();
            int i = (-1) << (resolution - 1);
            int iCeil = (int) Math.ceil(((double) resolution) / 8.0d);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= channels) {
                    return arrayList;
                }
                if (type == PmdDataFieldEncoding.SIGNED_INT) {
                    iM897convertArrayToUnsignedInt_W1zjd8 = TypeUtils.INSTANCE.convertArrayToSignedInt(bytes, i3, iCeil);
                    if ((iM897convertArrayToUnsignedInt_W1zjd8 & i) != 0) {
                        iM897convertArrayToUnsignedInt_W1zjd8 |= i;
                    }
                } else {
                    iM897convertArrayToUnsignedInt_W1zjd8 = TypeUtils.INSTANCE.m897convertArrayToUnsignedInt_W1zjd8(bytes, i3, iCeil);
                }
                i3 += iCeil;
                arrayList.add(Integer.valueOf(iM897convertArrayToUnsignedInt_W1zjd8));
                i2 = i4;
            }
        }

        public final List<List<Integer>> parseDeltaFramesAll(byte[] value, int channels, int resolution, PmdDataFieldEncoding type) {
            value.getClass();
            type.getClass();
            List<Integer> deltaFrameRefSamples = parseDeltaFrameRefSamples(value, channels, resolution, type);
            int iCeil = (int) (Math.ceil(((double) resolution) / 8.0d) * ((double) channels));
            ArrayList arrayList = new ArrayList(SetsKt.setOf(deltaFrameRefSamples));
            BleUtils.validate(deltaFrameRefSamples.size() == channels, "incorrect number of ref channels");
            while (iCeil < value.length) {
                int i = iCeil + 1;
                int i2 = value[iCeil] & PHIpAddressSearchManager.END_IP_SCAN;
                int i3 = iCeil + 2;
                int i4 = (value[i] & PHIpAddressSearchManager.END_IP_SCAN) * i2 * channels;
                int iCeil2 = (int) Math.ceil(((double) i4) / 8.0d);
                byte[] bArr = new byte[iCeil2];
                System.arraycopy(value, i3, bArr, 0, iCeil2);
                for (List<Integer> list : parseDeltaFrame(bArr, channels, i2, i4)) {
                    BleUtils.validate(list.size() == channels, "incorrect number of delta channels");
                    List list2 = (List) arrayList.get(arrayList.size() - 1);
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < channels; i5++) {
                        arrayList2.add(Integer.valueOf(list.get(i5).intValue() + ((Number) list2.get(i5)).intValue()));
                    }
                    arrayList.addAll(SetsKt.setOf(arrayList2));
                }
                iCeil = i3 + iCeil2;
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/BlePMDClient$PmdDataFieldEncoding;", "", "(Ljava/lang/String;I)V", "FLOAT_IEEE754", "DOUBLE_IEEE754", "SIGNED_INT", "UNSIGNED_BYTE", "UNSIGNED_INT", "UNSIGNED_LONG", "BOOLEAN", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PmdDataFieldEncoding {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PmdDataFieldEncoding[] $VALUES;
        public static final PmdDataFieldEncoding FLOAT_IEEE754 = new PmdDataFieldEncoding("FLOAT_IEEE754", 0);
        public static final PmdDataFieldEncoding DOUBLE_IEEE754 = new PmdDataFieldEncoding("DOUBLE_IEEE754", 1);
        public static final PmdDataFieldEncoding SIGNED_INT = new PmdDataFieldEncoding("SIGNED_INT", 2);
        public static final PmdDataFieldEncoding UNSIGNED_BYTE = new PmdDataFieldEncoding("UNSIGNED_BYTE", 3);
        public static final PmdDataFieldEncoding UNSIGNED_INT = new PmdDataFieldEncoding("UNSIGNED_INT", 4);
        public static final PmdDataFieldEncoding UNSIGNED_LONG = new PmdDataFieldEncoding("UNSIGNED_LONG", 5);
        public static final PmdDataFieldEncoding BOOLEAN = new PmdDataFieldEncoding("BOOLEAN", 6);

        private static final /* synthetic */ PmdDataFieldEncoding[] $values() {
            return new PmdDataFieldEncoding[]{FLOAT_IEEE754, DOUBLE_IEEE754, SIGNED_INT, UNSIGNED_BYTE, UNSIGNED_INT, UNSIGNED_LONG, BOOLEAN};
        }

        static {
            PmdDataFieldEncoding[] pmdDataFieldEncodingArr$values = $values();
            $VALUES = pmdDataFieldEncodingArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pmdDataFieldEncodingArr$values);
        }

        private PmdDataFieldEncoding(String str, int i) {
        }

        public static PmdDataFieldEncoding valueOf(String str) {
            return (PmdDataFieldEncoding) Enum.valueOf(PmdDataFieldEncoding.class, str);
        }

        public static PmdDataFieldEncoding[] values() {
            return (PmdDataFieldEncoding[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PmdMeasurementType.values().length];
            try {
                iArr[PmdMeasurementType.ECG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PmdMeasurementType.PPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PmdMeasurementType.ACC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PmdMeasurementType.PPI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PmdMeasurementType.GYRO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PmdMeasurementType.MAGNETOMETER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PmdMeasurementType.LOCATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PmdMeasurementType.PRESSURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PmdMeasurementType.TEMPERATURE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PmdMeasurementType.SKIN_TEMP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PmdControlPointCommandServiceToClient.values().length];
            try {
                iArr2[PmdControlPointCommandServiceToClient.ONLINE_MEASUREMENT_STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("FB005C82-02E7-F387-1CAD-8ACD2D8DF0C8");
        uuidFromString.getClass();
        PMD_DATA = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("FB005C81-02E7-F387-1CAD-8ACD2D8DF0C8");
        uuidFromString2.getClass();
        PMD_CP = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("FB005C80-02E7-F387-1CAD-8ACD2D8DF0C8");
        uuidFromString3.getClass();
        PMD_SERVICE = uuidFromString3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlePMDClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, PMD_SERVICE);
        bleGattTxInterface.getClass();
        this.pmdCpResponseQueue = new LinkedBlockingQueue<>();
        this.ecgObservers = new AtomicSet<>();
        this.accObservers = new AtomicSet<>();
        this.gyroObservers = new AtomicSet<>();
        this.magnetometerObservers = new AtomicSet<>();
        this.ppgObservers = new AtomicSet<>();
        this.ppiObservers = new AtomicSet<>();
        this.pressureObservers = new AtomicSet<>();
        this.locationObservers = new AtomicSet<>();
        this.temperatureObservers = new AtomicSet<>();
        this.skinTemperatureObservers = new AtomicSet<>();
        this.controlPointMutex = new Object();
        this.mutexFeature = new Object();
        this.previousTimeStampMap = new LinkedHashMap();
        this.currentSettings = new LinkedHashMap();
        UUID uuid = PMD_CP;
        addCharacteristicNotification(uuid);
        addCharacteristicRead(uuid);
        UUID uuid2 = PMD_DATA;
        addCharacteristicNotification(uuid2);
        AtomicInteger notificationAtomicInteger = getNotificationAtomicInteger(uuid);
        notificationAtomicInteger.getClass();
        this.pmdCpEnabled = notificationAtomicInteger;
        AtomicInteger notificationAtomicInteger2 = getNotificationAtomicInteger(uuid2);
        notificationAtomicInteger2.getClass();
        this.pmdDataEnabled = notificationAtomicInteger2;
    }

    private final void clearStreamObservers(Throwable throwable) {
        RxUtils.postExceptionAndClearList(this.ecgObservers, throwable);
        RxUtils.postExceptionAndClearList(this.accObservers, throwable);
        RxUtils.postExceptionAndClearList(this.ppgObservers, throwable);
        RxUtils.postExceptionAndClearList(this.ppiObservers, throwable);
        RxUtils.postExceptionAndClearList(this.gyroObservers, throwable);
        RxUtils.postExceptionAndClearList(this.magnetometerObservers, throwable);
        RxUtils.postExceptionAndClearList(this.pressureObservers, throwable);
        RxUtils.postExceptionAndClearList(this.locationObservers, throwable);
        RxUtils.postExceptionAndClearList(this.temperatureObservers, throwable);
        RxUtils.postExceptionAndClearList(this.skinTemperatureObservers, throwable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getFactor(PmdMeasurementType type) {
        Map<PmdSetting.PmdSettingType, Integer> selected;
        Integer num;
        PmdSetting pmdSetting = this.currentSettings.get(type);
        if (pmdSetting != null && (selected = pmdSetting.getSelected()) != null && (num = selected.get(PmdSetting.PmdSettingType.FACTOR)) != null) {
            return Float.intBitsToFloat(num.intValue());
        }
        BleLogger.INSTANCE.w("BlePMDClient", "No factor found for type: " + type);
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSampleRate(PmdMeasurementType type) {
        Map<PmdSetting.PmdSettingType, Integer> selected;
        Integer num;
        PmdSetting pmdSetting = this.currentSettings.get(type);
        if (pmdSetting == null || (selected = pmdSetting.getSelected()) == null || (num = selected.get(PmdSetting.PmdSettingType.SAMPLE_RATE)) == null) {
            return 0;
        }
        return num.intValue();
    }

    private final void processPmdCpCommand(byte[] data2, int status) {
        byte b;
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d_hex("BlePMDClient", Fragment$$ExternalSyntheticOutline1.m(status, "pmd command. Status: ", ". Data: "), data2);
        if (data2.length == 0 || (b = data2[0]) == -16) {
            this.pmdCpResponseQueue.add(new Pair<>(data2, Integer.valueOf(status)));
            return;
        }
        PmdControlPointCommandServiceToClient pmdControlPointCommandServiceToClientFromByte = PmdControlPointCommandServiceToClient.INSTANCE.fromByte(b);
        int i = pmdControlPointCommandServiceToClientFromByte == null ? -1 : WhenMappings.$EnumSwitchMapping$1[pmdControlPointCommandServiceToClientFromByte.ordinal()];
        if (i == -1) {
            companion.e("BlePMDClient", "PMD CP, not supported CP command from server. Command " + ((int) data2[0]) + " ");
            return;
        }
        if (i != 1) {
            return;
        }
        Iterator it = ArraysKt___ArraysKt.drop(data2, 1).iterator();
        while (it.hasNext()) {
            byte bByteValue = ((Number) it.next()).byteValue();
            switch (WhenMappings.$EnumSwitchMapping$0[PmdMeasurementType.INSTANCE.fromId(bByteValue).ordinal()]) {
                case 1:
                    RxUtils.postError(this.ecgObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 2:
                    RxUtils.postError(this.ppgObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 3:
                    RxUtils.postError(this.accObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 4:
                    RxUtils.postError(this.ppiObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 5:
                    RxUtils.postError(this.gyroObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 6:
                    RxUtils.postError(this.magnetometerObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 7:
                    RxUtils.postError(this.locationObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 8:
                    RxUtils.postError(this.pressureObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 9:
                    RxUtils.postError(this.temperatureObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                case 10:
                    RxUtils.postError(this.skinTemperatureObservers, new BleOnlineStreamClosed("Stop command from device"));
                    break;
                default:
                    BleLogger.INSTANCE.e("BlePMDClient", "PMD CP, not supported PmdMeasurementType for Measurement stop. Measurement type value " + ((int) bByteValue) + " ");
                    break;
            }
        }
    }

    private final void processPmdData(byte[] data2) {
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d_hex("BlePMDClient", "pmd data: ", data2);
        final PmdDataFrame pmdDataFrame = new PmdDataFrame(data2, new BlePMDClient$processPmdData$frame$1(this), new BlePMDClient$processPmdData$frame$2(this), new BlePMDClient$processPmdData$frame$3(this));
        this.previousTimeStampMap.put(new Pair<>(pmdDataFrame.getMeasurementType(), pmdDataFrame.getFrameType()), ULong.m2410boximpl(pmdDataFrame.getTimeStamp()));
        switch (WhenMappings.$EnumSwitchMapping$0[pmdDataFrame.getMeasurementType().ordinal()]) {
            case 1:
                final int i = 0;
                RxUtils.emitNext(this.ecgObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i2 = i;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i2) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 2:
                final int i2 = 3;
                RxUtils.emitNext(this.ppgObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i2;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 3:
                final int i3 = 4;
                RxUtils.emitNext(this.accObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i3;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 4:
                final int i4 = 5;
                RxUtils.emitNext(this.ppiObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i4;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 5:
                final int i5 = 6;
                RxUtils.emitNext(this.gyroObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i5;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 6:
                final int i6 = 7;
                RxUtils.emitNext(this.magnetometerObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i6;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 7:
                final int i7 = 9;
                RxUtils.emitNext(this.locationObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i7;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 8:
                final int i8 = 8;
                RxUtils.emitNext(this.pressureObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i8;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 9:
                final int i9 = 1;
                RxUtils.emitNext(this.temperatureObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i9;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            case 10:
                final int i10 = 2;
                RxUtils.emitNext(this.skinTemperatureObservers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda2
                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i10;
                        PmdDataFrame pmdDataFrame2 = pmdDataFrame;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BlePMDClient.processPmdData$lambda$4(pmdDataFrame2, flowableEmitter);
                                break;
                            case 1:
                                BlePMDClient.processPmdData$lambda$12(pmdDataFrame2, flowableEmitter);
                                break;
                            case 2:
                                BlePMDClient.processPmdData$lambda$13(pmdDataFrame2, flowableEmitter);
                                break;
                            case 3:
                                BlePMDClient.processPmdData$lambda$5(pmdDataFrame2, flowableEmitter);
                                break;
                            case 4:
                                BlePMDClient.processPmdData$lambda$6(pmdDataFrame2, flowableEmitter);
                                break;
                            case 5:
                                BlePMDClient.processPmdData$lambda$7(pmdDataFrame2, flowableEmitter);
                                break;
                            case 6:
                                BlePMDClient.processPmdData$lambda$8(pmdDataFrame2, flowableEmitter);
                                break;
                            case 7:
                                BlePMDClient.processPmdData$lambda$9(pmdDataFrame2, flowableEmitter);
                                break;
                            case 8:
                                BlePMDClient.processPmdData$lambda$10(pmdDataFrame2, flowableEmitter);
                                break;
                            default:
                                BlePMDClient.processPmdData$lambda$11(pmdDataFrame2, flowableEmitter);
                                break;
                        }
                    }
                });
                break;
            default:
                companion.w("BlePMDClient", "Unknown or not supported PMD type " + pmdDataFrame.getMeasurementType() + " received");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$10(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(PressureData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$11(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(GnssLocationData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$12(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(TemperatureData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$13(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(SkinTemperatureData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$4(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(EcgData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$5(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(PpgData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$6(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(AccData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$7(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(PpiData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$8(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(GyrData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processPmdData$lambda$9(PmdDataFrame pmdDataFrame, FlowableEmitter flowableEmitter) {
        pmdDataFrame.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(MagData.INSTANCE.parseDataFromDataFrame(pmdDataFrame));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readFeature$lambda$18(boolean z, BlePMDClient blePMDClient, SingleEmitter singleEmitter) {
        blePMDClient.getClass();
        singleEmitter.getClass();
        if (z) {
            try {
                if (!blePMDClient.txInterface.isConnected()) {
                    throw new BleDisconnected();
                }
            } catch (Exception e) {
                if (singleEmitter.isDisposed()) {
                    return;
                }
                singleEmitter.tryOnError(e);
                return;
            }
        }
        synchronized (blePMDClient.mutexFeature) {
            try {
                if (blePMDClient.pmdFeatureData == null) {
                    blePMDClient.mutexFeature.wait();
                }
                byte[] bArr = blePMDClient.pmdFeatureData;
                if (bArr == null) {
                    if (!blePMDClient.txInterface.isConnected()) {
                        throw new BleDisconnected();
                    }
                    throw new Exception("Undefined device error");
                }
                singleEmitter.onSuccess(PmdMeasurementType.INSTANCE.fromByteArray(bArr));
            } finally {
            }
        }
    }

    private final byte[] receiveControlPointPacket(byte command) throws Exception {
        Pair<byte[], Integer> pair = null;
        boolean z = false;
        do {
            Pair<byte[], Integer> pairPoll = this.pmdCpResponseQueue.poll(30L, TimeUnit.SECONDS);
            if (pairPoll == null) {
                z = true;
            } else if (pairPoll.getSecond().intValue() != 0) {
                BleLogger.INSTANCE.e("BlePMDClient", "Received PMD CP packet with nonzero status " + pairPoll.getSecond());
            } else if (pairPoll.getFirst().length < 2) {
                BleLogger.INSTANCE.e("BlePMDClient", "Received PMD CP packet with unexpected byte array size " + pairPoll.getFirst().length);
            } else if (pairPoll.getFirst()[1] != command) {
                BleLogger.INSTANCE.e("BlePMDClient", Fragment$$ExternalSyntheticOutline1.m(pairPoll.getFirst()[1], command, "Received PMD CP packet with unexpected command byte ", ", expected "));
            } else {
                pair = pairPoll;
                z = true;
            }
        } while (!z);
        if (pair != null) {
            return pair.getFirst();
        }
        throw new Exception("Pmd response failed to receive in timeline");
    }

    private final Single<PmdControlPointResponse> sendControlPointCommand(PmdControlPointCommandClientToService command, byte[] params) {
        Single<PmdControlPointResponse> singleSubscribeOn = Single.create(new ListenableFutureKt$$ExternalSyntheticLambda0(this, params, command, 5)).subscribeOn(Schedulers.io());
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendControlPointCommand$lambda$15(BlePMDClient blePMDClient, byte[] bArr, PmdControlPointCommandClientToService pmdControlPointCommandClientToService, SingleEmitter singleEmitter) {
        blePMDClient.getClass();
        bArr.getClass();
        pmdControlPointCommandClientToService.getClass();
        singleEmitter.getClass();
        synchronized (blePMDClient.controlPointMutex) {
            try {
                if (blePMDClient.pmdCpEnabled.get() != 0 || blePMDClient.pmdDataEnabled.get() != 0) {
                    throw new BleCharacteristicNotificationNotEnabled();
                }
                boolean z = true;
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 1);
                byteBufferAllocate.put(new byte[]{(byte) pmdControlPointCommandClientToService.getCode()});
                if (bArr.length != 0) {
                    z = false;
                }
                if (!z) {
                    byteBufferAllocate.put(bArr);
                }
                BleLogger.Companion companion = BleLogger.INSTANCE;
                companion.d("BlePMDClient", "Send control point command " + pmdControlPointCommandClientToService);
                byte[] bArrArray = byteBufferAllocate.array();
                bArrArray.getClass();
                PmdControlPointResponse pmdControlPointResponseSendPmdCommand = blePMDClient.sendPmdCommand(bArrArray);
                companion.d("BlePMDClient", "Response of control point command " + pmdControlPointCommandClientToService + " with status " + pmdControlPointResponseSendPmdCommand.getStatus() + " ");
                if (pmdControlPointResponseSendPmdCommand.getStatus() != PmdControlPointResponse.PmdControlPointResponseCode.SUCCESS) {
                    throw new BleControlPointCommandError("pmd cp command " + pmdControlPointCommandClientToService + " error:", pmdControlPointResponseSendPmdCommand.getStatus());
                }
                singleEmitter.onSuccess(pmdControlPointResponseSendPmdCommand);
            } catch (Throwable th) {
                try {
                    if (!singleEmitter.isDisposed()) {
                        singleEmitter.tryOnError(th);
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
        }
    }

    private final PmdControlPointResponse sendPmdCommand(byte[] packet) throws Exception {
        this.txInterface.transmitMessage(PMD_SERVICE, PMD_CP, packet, true);
        byte b = packet[0];
        PmdControlPointResponse pmdControlPointResponse = new PmdControlPointResponse(receiveControlPointPacket(b));
        boolean more = pmdControlPointResponse.getMore();
        while (more) {
            byte[] bArrReceiveControlPointPacket = receiveControlPointPacket(b);
            boolean more2 = new PmdControlPointResponse(bArrReceiveControlPointPacket).getMore();
            byte[] parameters = pmdControlPointResponse.getParameters();
            pmdControlPointResponse.setParameters(ArraysKt.plus(Arrays.copyOf(parameters, parameters.length), ArraysKt.copyOfRange(bArrReceiveControlPointPacket, 5, bArrReceiveControlPointPacket.length)));
            more = more2;
        }
        return pmdControlPointResponse;
    }

    public static /* synthetic */ Completable startMeasurement$default(BlePMDClient blePMDClient, PmdMeasurementType pmdMeasurementType, PmdSetting pmdSetting, PmdRecordingType pmdRecordingType, PmdSecret pmdSecret, int i, Object obj) {
        if ((i & 4) != 0) {
            pmdRecordingType = PmdRecordingType.ONLINE;
        }
        if ((i & 8) != 0) {
            pmdSecret = null;
        }
        return blePMDClient.startMeasurement(pmdMeasurementType, pmdSetting, pmdRecordingType, pmdSecret);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopMeasurement$lambda$21(BlePMDClient blePMDClient) {
        blePMDClient.getClass();
        blePMDClient.previousTimeStampMap = new LinkedHashMap();
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public Completable clientReady(boolean checkConnection) {
        Completable completableConcatArray = Completable.concatArray(waitNotificationEnabled(PMD_CP, checkConnection), waitNotificationEnabled(PMD_DATA, checkConnection));
        completableConcatArray.getClass();
        return completableConcatArray;
    }

    public final Map<PmdMeasurementType, PmdSetting> getCurrentSettings() {
        return this.currentSettings;
    }

    /* JADX INFO: renamed from: getPreviousFrameTimeStamp-ZIaKswc, reason: not valid java name */
    public final long m876getPreviousFrameTimeStampZIaKswc(PmdMeasurementType type, PmdDataFrame.PmdDataFrameType frameType) {
        type.getClass();
        frameType.getClass();
        ULong uLong = this.previousTimeStampMap.get(new Pair(type, frameType));
        if (uLong != null) {
            return uLong.getData();
        }
        return 0L;
    }

    public final Flowable<AccData> monitorAccNotifications$library_sdkRelease(boolean checkConnection) {
        Flowable<AccData> flowableMonitorNotifications = RxUtils.monitorNotifications(this.accObservers, this.txInterface, checkConnection);
        flowableMonitorNotifications.getClass();
        return flowableMonitorNotifications;
    }

    public final Flowable<PpiData> monitorPpiNotifications$library_sdkRelease(boolean checkConnection) {
        Flowable<PpiData> flowableMonitorNotifications = RxUtils.monitorNotifications(this.ppiObservers, this.txInterface, checkConnection);
        flowableMonitorNotifications.getClass();
        return flowableMonitorNotifications;
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID characteristic, byte[] data2, int status, boolean notifying) {
        characteristic.getClass();
        data2.getClass();
        if (!Intrinsics.areEqual(characteristic, PMD_CP)) {
            if (Intrinsics.areEqual(characteristic, PMD_DATA)) {
                if (status == 0) {
                    processPmdData(data2);
                    return;
                } else {
                    BleLogger.INSTANCE.e("BlePMDClient", "pmd data attribute error");
                    return;
                }
            }
            return;
        }
        if (notifying) {
            processPmdCpCommand(data2, status);
            return;
        }
        if (status == 0) {
            synchronized (this.mutexFeature) {
                this.pmdFeatureData = data2;
                this.mutexFeature.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        BleLogger.INSTANCE.w("BlePMDClient", "Process service data with status " + status + ", skipped");
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID characteristic, int status) {
        characteristic.getClass();
    }

    public final Single<PmdSetting> querySettings(PmdMeasurementType type, PmdRecordingType recordingType) {
        type.getClass();
        recordingType.getClass();
        Single map = sendControlPointCommand(PmdControlPointCommandClientToService.GET_MEASUREMENT_SETTINGS, UByte.m2367constructorimpl((byte) (type.getNumVal() | recordingType.m884asBitFieldw2LRezQ()))).map(new Function() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient.querySettings.1
            @Override // io.reactivex.rxjava3.functions.Function
            public final PmdSetting apply(PmdControlPointResponse pmdControlPointResponse) {
                pmdControlPointResponse.getClass();
                return new PmdSetting(pmdControlPointResponse.getParameters());
            }
        });
        map.getClass();
        return map;
    }

    public final Single<Set<PmdMeasurementType>> readFeature(final boolean checkConnection) {
        Single<Set<PmdMeasurementType>> singleSubscribeOn = Single.create(new SingleOnSubscribe() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                BlePMDClient.readFeature$lambda$18(checkConnection, this, singleEmitter);
            }
        }).subscribeOn(Schedulers.io());
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        clearStreamObservers(new BleDisconnected());
        synchronized (this.mutexFeature) {
            this.pmdFeatureData = null;
            this.mutexFeature.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        this.previousTimeStampMap = new LinkedHashMap();
    }

    public final Completable startMeasurement(final PmdMeasurementType type, PmdSetting setting, PmdRecordingType recordingType, PmdSecret secret) {
        type.getClass();
        setting.getClass();
        recordingType.getClass();
        byte bM2367constructorimpl = UByte.m2367constructorimpl((byte) (type.getNumVal() | recordingType.m884asBitFieldw2LRezQ()));
        byte[] bArrPlus = ArraysKt.plus(setting.serializeSelected(), new byte[0]);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrPlus.length + 1);
        byteBufferAllocate.put(bM2367constructorimpl);
        byteBufferAllocate.put(bArrPlus);
        this.currentSettings.put(type, setting);
        BleLogger.INSTANCE.d("BlePMDClient", "start measurement. Measurement type: " + type + " Recording type: " + recordingType + " Secret provided: false");
        PmdControlPointCommandClientToService pmdControlPointCommandClientToService = PmdControlPointCommandClientToService.REQUEST_MEASUREMENT_START;
        byte[] bArrArray = byteBufferAllocate.array();
        bArrArray.getClass();
        Completable completableIgnoreElements = sendControlPointCommand(pmdControlPointCommandClientToService, bArrArray).doOnSuccess(new Consumer() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient.startMeasurement.1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(PmdControlPointResponse pmdControlPointResponse) throws BleControlPointResponseError {
                pmdControlPointResponse.getClass();
                try {
                    PmdSetting pmdSetting = BlePMDClient.this.getCurrentSettings().get(type);
                    pmdSetting.getClass();
                    pmdSetting.updateSelectedFromStartResponse(pmdControlPointResponse.getParameters());
                } catch (Exception e) {
                    throw new BleControlPointResponseError("Failed to parse PMD control point response from device. Measurement type: " + type + ". Exception: " + e + " \n Response: " + pmdControlPointResponse);
                }
            }
        }).toObservable().ignoreElements();
        completableIgnoreElements.getClass();
        return completableIgnoreElements;
    }

    public final Completable stopMeasurement(PmdMeasurementType type) {
        type.getClass();
        Completable completableIgnoreElements = sendControlPointCommand(PmdControlPointCommandClientToService.STOP_MEASUREMENT, new byte[]{type.getNumVal()}).toObservable().doOnComplete(new LoginFragment$$ExternalSyntheticLambda0(this, 19)).ignoreElements();
        completableIgnoreElements.getClass();
        return completableIgnoreElements;
    }

    public String toString() {
        return "PMD Client";
    }

    private final Single<PmdControlPointResponse> sendControlPointCommand(PmdControlPointCommandClientToService command, byte value) {
        return sendControlPointCommand(command, new byte[]{value});
    }
}
