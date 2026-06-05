package com.polar.sdk.impl;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.util.Pair;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.login.LoginManager$$ExternalSyntheticLambda1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.polar.androidcommunications.api.ble.BleDeviceListener;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.exceptions.BleDisconnected;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.api.ble.model.advertisement.BleAdvertisementContent;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleBattClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleDisClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleHrClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleHtsClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.HealthThermometer;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdMeasurementType;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdRecordingType;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdSetting;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.AccData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.PpiData;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpUtils;
import com.polar.androidcommunications.api.ble.model.polar.BlePolarDeviceCapabilitiesUtility;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.PolarBleApiCallbackProvider;
import com.polar.sdk.api.errors.PolarBleSdkInstanceException;
import com.polar.sdk.api.errors.PolarDeviceDisconnected;
import com.polar.sdk.api.errors.PolarDeviceNotFound;
import com.polar.sdk.api.errors.PolarInvalidArgument;
import com.polar.sdk.api.errors.PolarNotificationNotEnabled;
import com.polar.sdk.api.errors.PolarOperationNotSupported;
import com.polar.sdk.api.errors.PolarServiceNotAvailable;
import com.polar.sdk.api.model.LedConfig;
import com.polar.sdk.api.model.PolarAccelerometerData;
import com.polar.sdk.api.model.PolarDeviceInfo;
import com.polar.sdk.api.model.PolarHrData;
import com.polar.sdk.api.model.PolarPpiData;
import com.polar.sdk.api.model.PolarSensorSetting;
import com.polar.sdk.impl.utils.PolarDataUtils;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import j$.time.format.DateTimeFormatter;
import java.io.ByteArrayInputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.reactivestreams.Publisher;
import protocol.PftpError$PbPFtpError;
import protocol.PftpRequest$PbPFtpOperation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u008b\u00012\u00020\u00012\u00020\u0002:\u0002\u008b\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b%\u0010&J%\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0016H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u001b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b,\u0010&J\u0017\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b0\u0010/J\u0017\u00101\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b1\u0010/J\u0017\u00104\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J-\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;JQ\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\b\b\u0000\u0010=*\u00020<2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00107\u001a\u0002062\u0006\u0010>\u001a\u00020\u00162\u0018\u0010A\u001a\u0014\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0?H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u0004\u0018\u00010-2\u0006\u0010G\u001a\u00020\u0011H\u0002¢\u0006\u0004\bH\u0010/J\u0019\u0010J\u001a\u0004\u0018\u00010-2\u0006\u0010I\u001a\u00020\u0011H\u0002¢\u0006\u0004\bJ\u0010/J\u001f\u0010M\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NJ'\u0010P\u001a\u00020\n2\u0006\u0010D\u001a\u00020-2\u0006\u0010O\u001a\u00020@2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\n2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bR\u0010FJ-\u0010V\u001a\u00020!2\u0006\u0010D\u001a\u00020-2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010U\u001a\u00020\u0006H\u0002¢\u0006\u0004\bV\u0010WJ+\u0010X\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bX\u0010YJ+\u0010Z\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bZ\u0010YJ+\u0010[\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\b[\u0010YJ+\u0010\\\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\b\\\u0010YJ+\u0010]\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\b]\u0010YJ+\u0010^\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\b^\u0010YJ+\u0010_\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\b_\u0010YJ+\u0010`\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\b`\u0010YJ+\u0010a\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\ba\u0010YJ+\u0010b\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bb\u0010YJ+\u0010c\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bc\u0010YJ+\u0010d\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bd\u0010YJ+\u0010e\u001a\b\u0012\u0004\u0012\u0002020\u00152\f\u0010T\u001a\b\u0012\u0004\u0012\u00020K0S2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\be\u0010YJ\u0017\u0010f\u001a\u00020\n2\u0006\u0010D\u001a\u00020-H\u0002¢\u0006\u0004\bf\u0010FJ\u001b\u0010k\u001a\u00060ij\u0002`j2\u0006\u0010h\u001a\u00020gH\u0002¢\u0006\u0004\bk\u0010lJ\u0017\u0010n\u001a\u00020\n2\u0006\u0010m\u001a\u00020\u0011H\u0002¢\u0006\u0004\bn\u0010\u001aJ\u0017\u0010o\u001a\u00020\n2\u0006\u0010m\u001a\u00020\u0011H\u0002¢\u0006\u0004\bo\u0010\u001aR \u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR \u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010sR \u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010sR \u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010sR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010}\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010\u0082\u0001R\"\u0010\u0085\u0001\u001a\r \u0084\u0001*\u0005\u0018\u00010\u0083\u00010\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R/\u0010\u0089\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0006\u0012\u0004\u0018\u00010\u007f0\u0088\u00010\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/polar/sdk/impl/BDBleApiImpl;", "Lcom/polar/sdk/api/PolarBleApi;", "Lcom/polar/androidcommunications/api/ble/BleDeviceListener$BlePowerStateChangedCallback;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;", "features", "<init>", "(Landroid/content/Context;Ljava/util/Set;)V", "", "shutDown", "()V", "Lcom/polar/sdk/api/PolarBleApiCallbackProvider;", "callback", "setApiCallback", "(Lcom/polar/sdk/api/PolarBleApiCallbackProvider;)V", "", "identifier", "Lcom/polar/sdk/api/PolarBleApi$PolarDeviceDataType;", "feature", "Lio/reactivex/rxjava3/core/Single;", "Lcom/polar/sdk/api/model/PolarSensorSetting;", "requestStreamSettings", "(Ljava/lang/String;Lcom/polar/sdk/api/PolarBleApi$PolarDeviceDataType;)Lio/reactivex/rxjava3/core/Single;", "connectToDevice", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/sdk/api/model/PolarDeviceInfo;", "searchForDevice", "()Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/sdk/api/model/LedConfig;", "ledConfig", "Lio/reactivex/rxjava3/core/Completable;", "setLedConfig", "(Ljava/lang/String;Lcom/polar/sdk/api/model/LedConfig;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/polar/sdk/api/model/PolarHrData;", "startHrStreaming", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Flowable;", "sensorSetting", "Lcom/polar/sdk/api/model/PolarAccelerometerData;", "startAccStreaming", "(Ljava/lang/String;Lcom/polar/sdk/api/model/PolarSensorSetting;)Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/sdk/api/model/PolarPpiData;", "startPpiStreaming", "Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession;", "fetchSession", "(Ljava/lang/String;)Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession;", "sessionPmdClientReady", "sessionPsFtpClientReady", "", "power", "stateChanged", "(Z)V", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;", "type", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdRecordingType;", "recordingType", "querySettings", "(Ljava/lang/String;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdRecordingType;)Lio/reactivex/rxjava3/core/Single;", "", "T", "setting", "Lio/reactivex/rxjava3/functions/Function;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/BlePMDClient;", "observer", "startStreaming", "(Ljava/lang/String;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;Lcom/polar/sdk/api/model/PolarSensorSetting;Lio/reactivex/rxjava3/functions/Function;)Lio/reactivex/rxjava3/core/Flowable;", "session", "openConnection", "(Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "sessionByAddress", "deviceId", "sessionByDeviceId", "Ljava/util/UUID;", "service", "sessionServiceReady", "(Ljava/lang/String;Ljava/util/UUID;)Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession;", "client", "stopPmdStreaming", "(Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/BlePMDClient;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;)V", "setupDevice", "", "discoveredServices", "featurePolarOfflineRecording", "makeFeatureCallbackIfNeeded", "(Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession;Ljava/util/List;Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;)Lio/reactivex/rxjava3/core/Completable;", "isHealthThermometerFeatureAvailable", "(Ljava/util/List;Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession;)Lio/reactivex/rxjava3/core/Single;", "isPolarDeviceTimeFeatureAvailable", "isBatteryInfoFeatureAvailable", "isDeviceInfoFeatureAvailable", "isHeartRateFeatureAvailable", "isH10ExerciseFeatureAvailable", "isSdkModeFeatureAvailable", "isOnlineStreamingAvailable", "isPsftpServiceAvailable", "isOfflineRecordingAvailable", "isLedAnimationFeatureAvailable", "isPolarFirmwareUpdateFeatureAvailable", "isActivityDataFeatureAvailable", "tearDownDevice", "", "throwable", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleError", "(Ljava/lang/Throwable;)Ljava/lang/Exception;", "message", "log", "logError", "", "Lio/reactivex/rxjava3/disposables/Disposable;", "connectSubscriptions", "Ljava/util/Map;", "deviceDataMonitorDisposable", "deviceAvailableFeaturesDisposable", "stopPmdStreamingDisposable", "Lcom/polar/androidcommunications/api/ble/BleDeviceListener$BleSearchPreFilter;", "filter", "Lcom/polar/androidcommunications/api/ble/BleDeviceListener$BleSearchPreFilter;", "Lcom/polar/androidcommunications/api/ble/BleDeviceListener;", "listener", "Lcom/polar/androidcommunications/api/ble/BleDeviceListener;", "devicesStateMonitorDisposable", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession$DeviceSessionState;", "deviceSessionState", "Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession$DeviceSessionState;", "Lcom/polar/sdk/api/PolarBleApiCallbackProvider;", "j$/time/format/DateTimeFormatter", "kotlin.jvm.PlatformType", "dateFormatter", "Lj$/time/format/DateTimeFormatter;", "Lio/reactivex/rxjava3/functions/Consumer;", "Landroidx/core/util/Pair;", "deviceStateMonitorObserver", "Lio/reactivex/rxjava3/functions/Consumer;", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BDBleApiImpl extends PolarBleApi implements BleDeviceListener.BlePowerStateChangedCallback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static BDBleApiImpl instance;
    private PolarBleApiCallbackProvider callback;
    private final Map<String, Disposable> connectSubscriptions;
    private final DateTimeFormatter dateFormatter;
    private final Map<String, Disposable> deviceAvailableFeaturesDisposable;
    private final Map<String, Disposable> deviceDataMonitorDisposable;
    private BleDeviceSession.DeviceSessionState deviceSessionState;
    private final Consumer<Pair<BleDeviceSession, BleDeviceSession.DeviceSessionState>> deviceStateMonitorObserver;
    private Disposable devicesStateMonitorDisposable;
    private final BleDeviceListener.BleSearchPreFilter filter;
    private BleDeviceListener listener;
    private final Map<String, Disposable> stopPmdStreamingDisposable;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/polar/sdk/impl/BDBleApiImpl$Companion;", "", "()V", "TAG", "", "instance", "Lcom/polar/sdk/impl/BDBleApiImpl;", "clearInstance", "", "getInstance", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "features", "", "Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clearInstance() {
            BDBleApiImpl.instance = null;
        }

        public final BDBleApiImpl getInstance(Context context, Set<? extends PolarBleApi.PolarBleSdkFeature> features) throws PolarBleSdkInstanceException {
            context.getClass();
            features.getClass();
            BDBleApiImpl bDBleApiImpl = BDBleApiImpl.instance;
            if (bDBleApiImpl == null) {
                BDBleApiImpl.instance = new BDBleApiImpl(context, features, null);
                BDBleApiImpl bDBleApiImpl2 = BDBleApiImpl.instance;
                bDBleApiImpl2.getClass();
                return bDBleApiImpl2;
            }
            if (Intrinsics.areEqual(bDBleApiImpl.getFeatures(), features)) {
                return bDBleApiImpl;
            }
            BDBleApiImpl bDBleApiImpl3 = BDBleApiImpl.instance;
            bDBleApiImpl3.getClass();
            throw new PolarBleSdkInstanceException("Attempt to create Polar BLE API with features " + features + ". Instance with features " + bDBleApiImpl3.getFeatures() + " already exists");
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[PolarBleApi.PolarBleSdkFeature.values().length];
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_HR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_DEVICE_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_BATTERY_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_OFFLINE_RECORDING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_H10_EXERCISE_RECORDING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_DEVICE_TIME_SETUP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_SDK_MODE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_FILE_TRANSFER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_HTS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_LED_ANIMATION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_FIRMWARE_UPDATE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ACTIVITY_DATA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_SLEEP_DATA.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_TEMPERATURE_DATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PolarBleApi.PolarDeviceDataType.values().length];
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.ECG.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.ACC.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.PPG.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.GYRO.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.MAGNETOMETER.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.PRESSURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.LOCATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.TEMPERATURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.SKIN_TEMPERATURE.ordinal()] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.HR.ordinal()] = 10;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[PolarBleApi.PolarDeviceDataType.PPI.ordinal()] = 11;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BlePolarDeviceCapabilitiesUtility.FileSystemType.values().length];
            try {
                iArr3[BlePolarDeviceCapabilitiesUtility.FileSystemType.SAGRFC2_FILE_SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr3[BlePolarDeviceCapabilitiesUtility.FileSystemType.H10_FILE_SYSTEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr3[BlePolarDeviceCapabilitiesUtility.FileSystemType.UNKNOWN_FILE_SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[BleDeviceSession.DeviceSessionState.values().length];
            try {
                iArr4[BleDeviceSession.DeviceSessionState.SESSION_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr4[BleDeviceSession.DeviceSessionState.SESSION_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr4[BleDeviceSession.DeviceSessionState.SESSION_OPENING.ordinal()] = 3;
            } catch (NoSuchFieldError unused32) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private BDBleApiImpl(Context context, Set<? extends PolarBleApi.PolarBleSdkFeature> set) {
        super(set);
        this.connectSubscriptions = new LinkedHashMap();
        this.deviceDataMonitorDisposable = new LinkedHashMap();
        this.deviceAvailableFeaturesDisposable = new LinkedHashMap();
        this.stopPmdStreamingDisposable = new LinkedHashMap();
        int i = 0;
        this.filter = new BDBleApiImpl$$ExternalSyntheticLambda1(i);
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends PolarBleApi.PolarBleSdkFeature> it = set.iterator();
        while (it.hasNext()) {
            switch (WhenMappings.$EnumSwitchMapping$0[it.next().ordinal()]) {
                case 1:
                    linkedHashSet.add(BleHrClient.class);
                    break;
                case 2:
                    linkedHashSet.add(BleDisClient.class);
                    break;
                case 3:
                    linkedHashSet.add(BleBattClient.class);
                    break;
                case 4:
                    linkedHashSet.add(BleHrClient.class);
                    linkedHashSet.add(BlePMDClient.class);
                    break;
                case 5:
                    linkedHashSet.add(BlePMDClient.class);
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 6:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 7:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 8:
                    linkedHashSet.add(BlePMDClient.class);
                    break;
                case 9:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 10:
                    linkedHashSet.add(BleHtsClient.class);
                    break;
                case 11:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 12:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 13:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 14:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
                case 15:
                    linkedHashSet.add(BlePsFtpClient.class);
                    break;
            }
        }
        BDDeviceListenerImpl bDDeviceListenerImpl = new BDDeviceListenerImpl(context, linkedHashSet);
        bDDeviceListenerImpl.setScanPreFilter(this.filter);
        bDDeviceListenerImpl.setBlePowerStateCallback(this);
        this.listener = bDDeviceListenerImpl;
        BleLogger.INSTANCE.setLoggerInterface(new BleLogger.BleLoggerInterface() { // from class: com.polar.sdk.impl.BDBleApiImpl.1
            @Override // com.polar.androidcommunications.api.ble.BleLogger.BleLoggerInterface
            public void d(String tag, String msg) {
                tag.getClass();
                msg.getClass();
                BDBleApiImpl.this.log(tag + MqttTopic.TOPIC_LEVEL_SEPARATOR + msg);
            }

            @Override // com.polar.androidcommunications.api.ble.BleLogger.BleLoggerInterface
            public void e(String tag, String msg) {
                tag.getClass();
                msg.getClass();
                BDBleApiImpl.this.logError(tag + MqttTopic.TOPIC_LEVEL_SEPARATOR + msg);
            }

            @Override // com.polar.androidcommunications.api.ble.BleLogger.BleLoggerInterface
            public void w(String tag, String msg) {
                tag.getClass();
                msg.getClass();
                BDBleApiImpl.this.log(tag + MqttTopic.TOPIC_LEVEL_SEPARATOR + msg);
            }
        });
        RxJavaPlugins.setErrorHandler(new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl.2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Throwable th) {
                th.getClass();
                if (th.getCause() instanceof BleDisconnected) {
                    return;
                }
                BleLogger.INSTANCE.e("BDBleApiImpl", "Undeliverable exception received, not sure what to do " + th);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                }
            }
        });
        this.deviceStateMonitorObserver = new BDBleApiImpl$$ExternalSyntheticLambda2(this, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectToDevice$lambda$6$lambda$5(BDBleApiImpl bDBleApiImpl, String str) {
        bDBleApiImpl.getClass();
        str.getClass();
        bDBleApiImpl.log("connect search completed for " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void deviceStateMonitorObserver$lambda$82(BDBleApiImpl bDBleApiImpl, Pair pair) {
        final PolarBleApiCallbackProvider polarBleApiCallbackProvider;
        bDBleApiImpl.getClass();
        pair.getClass();
        BleDeviceSession bleDeviceSession = (BleDeviceSession) pair.first;
        BleDeviceSession.DeviceSessionState deviceSessionState = (BleDeviceSession.DeviceSessionState) pair.second;
        if (bleDeviceSession == null || deviceSessionState == null) {
            return;
        }
        bDBleApiImpl.deviceSessionState = deviceSessionState;
        String polarDeviceId = bleDeviceSession.getPolarDeviceId();
        if (polarDeviceId.length() == 0) {
            polarDeviceId = bleDeviceSession.getAddress();
        }
        String str = polarDeviceId;
        str.getClass();
        String address = bleDeviceSession.getAddress();
        address.getClass();
        int rssi = bleDeviceSession.getRssi();
        String name = bleDeviceSession.getName();
        name.getClass();
        final PolarDeviceInfo polarDeviceInfo = new PolarDeviceInfo(str, address, rssi, name, true, false, false, 96, null);
        int i = WhenMappings.$EnumSwitchMapping$3[deviceSessionState.ordinal()];
        final int i2 = 1;
        if (i == 1) {
            final PolarBleApiCallbackProvider polarBleApiCallbackProvider2 = bDBleApiImpl.callback;
            if (polarBleApiCallbackProvider2 != null) {
                final int i3 = 0;
                Completable.fromAction(new Action() { // from class: com.polar.sdk.impl.BDBleApiImpl$$ExternalSyntheticLambda5
                    @Override // io.reactivex.rxjava3.functions.Action
                    public final void run() {
                        int i4 = i3;
                        PolarDeviceInfo polarDeviceInfo2 = polarDeviceInfo;
                        PolarBleApiCallbackProvider polarBleApiCallbackProvider3 = polarBleApiCallbackProvider2;
                        switch (i4) {
                            case 0:
                                BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$77$lambda$76(polarBleApiCallbackProvider3, polarDeviceInfo2);
                                break;
                            case 1:
                                BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$79$lambda$78(polarBleApiCallbackProvider3, polarDeviceInfo2);
                                break;
                            default:
                                BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$81$lambda$80(polarBleApiCallbackProvider3, polarDeviceInfo2);
                                break;
                        }
                    }
                }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
            }
            bDBleApiImpl.setupDevice(bleDeviceSession);
            return;
        }
        final int i4 = 2;
        if (i != 2) {
            if (i == 3 && (polarBleApiCallbackProvider = bDBleApiImpl.callback) != null) {
                Completable.fromAction(new Action() { // from class: com.polar.sdk.impl.BDBleApiImpl$$ExternalSyntheticLambda5
                    @Override // io.reactivex.rxjava3.functions.Action
                    public final void run() {
                        int i42 = i4;
                        PolarDeviceInfo polarDeviceInfo2 = polarDeviceInfo;
                        PolarBleApiCallbackProvider polarBleApiCallbackProvider3 = polarBleApiCallbackProvider;
                        switch (i42) {
                            case 0:
                                BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$77$lambda$76(polarBleApiCallbackProvider3, polarDeviceInfo2);
                                break;
                            case 1:
                                BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$79$lambda$78(polarBleApiCallbackProvider3, polarDeviceInfo2);
                                break;
                            default:
                                BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$81$lambda$80(polarBleApiCallbackProvider3, polarDeviceInfo2);
                                break;
                        }
                    }
                }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
                return;
            }
            return;
        }
        final PolarBleApiCallbackProvider polarBleApiCallbackProvider3 = bDBleApiImpl.callback;
        if (polarBleApiCallbackProvider3 != null && (bleDeviceSession.getPreviousState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN || bleDeviceSession.getPreviousState() == BleDeviceSession.DeviceSessionState.SESSION_OPENING || bleDeviceSession.getPreviousState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK || bleDeviceSession.getPreviousState() == BleDeviceSession.DeviceSessionState.SESSION_CLOSING)) {
            Completable.fromAction(new Action() { // from class: com.polar.sdk.impl.BDBleApiImpl$$ExternalSyntheticLambda5
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    int i42 = i2;
                    PolarDeviceInfo polarDeviceInfo2 = polarDeviceInfo;
                    PolarBleApiCallbackProvider polarBleApiCallbackProvider32 = polarBleApiCallbackProvider3;
                    switch (i42) {
                        case 0:
                            BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$77$lambda$76(polarBleApiCallbackProvider32, polarDeviceInfo2);
                            break;
                        case 1:
                            BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$79$lambda$78(polarBleApiCallbackProvider32, polarDeviceInfo2);
                            break;
                        default:
                            BDBleApiImpl.deviceStateMonitorObserver$lambda$82$lambda$81$lambda$80(polarBleApiCallbackProvider32, polarDeviceInfo2);
                            break;
                    }
                }
            }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
        }
        bDBleApiImpl.tearDownDevice(bleDeviceSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deviceStateMonitorObserver$lambda$82$lambda$77$lambda$76(PolarBleApiCallbackProvider polarBleApiCallbackProvider, PolarDeviceInfo polarDeviceInfo) {
        polarBleApiCallbackProvider.getClass();
        polarDeviceInfo.getClass();
        polarBleApiCallbackProvider.deviceConnected(polarDeviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deviceStateMonitorObserver$lambda$82$lambda$79$lambda$78(PolarBleApiCallbackProvider polarBleApiCallbackProvider, PolarDeviceInfo polarDeviceInfo) {
        polarBleApiCallbackProvider.getClass();
        polarDeviceInfo.getClass();
        polarBleApiCallbackProvider.deviceDisconnected(polarDeviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deviceStateMonitorObserver$lambda$82$lambda$81$lambda$80(PolarBleApiCallbackProvider polarBleApiCallbackProvider, PolarDeviceInfo polarDeviceInfo) {
        polarBleApiCallbackProvider.getClass();
        polarDeviceInfo.getClass();
        polarBleApiCallbackProvider.deviceConnecting(polarDeviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filter$lambda$0(BleAdvertisementContent bleAdvertisementContent) {
        bleAdvertisementContent.getClass();
        return bleAdvertisementContent.getPolarDeviceId().length() > 0 && !Intrinsics.areEqual(bleAdvertisementContent.getPolarDeviceType(), "mobile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Exception handleError(Throwable throwable) {
        PftpError$PbPFtpError pftpError$PbPFtpErrorForNumber;
        return throwable instanceof BleDisconnected ? new PolarDeviceDisconnected() : (!(throwable instanceof BlePsFtpUtils.PftpResponseError) || (pftpError$PbPFtpErrorForNumber = PftpError$PbPFtpError.forNumber(((BlePsFtpUtils.PftpResponseError) throwable).getError())) == null) ? new Exception(throwable) : new Exception(pftpError$PbPFtpErrorForNumber.toString());
    }

    private final Single<Boolean> isActivityDataFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePsFtpUtils.RFC77_PFTP_SERVICE;
        if (discoveredServices.contains(uuid)) {
            BlePolarDeviceCapabilitiesUtility.Companion companion = BlePolarDeviceCapabilitiesUtility.INSTANCE;
            String polarDeviceType = session.getPolarDeviceType();
            polarDeviceType.getClass();
            if (companion.isActivityDataSupported(polarDeviceType)) {
                BlePsFtpClient blePsFtpClient = (BlePsFtpClient) session.fetchClient(uuid);
                if (blePsFtpClient == null) {
                    Single<Boolean> singleJust = Single.just(Boolean.FALSE);
                    singleJust.getClass();
                    return singleJust;
                }
                Single<Boolean> single = blePsFtpClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(8));
                single.getClass();
                return single;
            }
        }
        Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
        singleJust2.getClass();
        return singleJust2;
    }

    private final Single<Boolean> isBatteryInfoFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BleBattClient.BATTERY_SERVICE;
        if (!discoveredServices.contains(uuid)) {
            Single<Boolean> singleJust = Single.just(Boolean.FALSE);
            singleJust.getClass();
            return singleJust;
        }
        BleBattClient bleBattClient = (BleBattClient) session.fetchClient(uuid);
        if (bleBattClient == null) {
            Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
            singleJust2.getClass();
            return singleJust2;
        }
        Single<Boolean> single = bleBattClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(6));
        single.getClass();
        return single;
    }

    private final Single<Boolean> isDeviceInfoFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BleDisClient.DIS_SERVICE;
        if (!discoveredServices.contains(uuid)) {
            Single<Boolean> singleJust = Single.just(Boolean.FALSE);
            singleJust.getClass();
            return singleJust;
        }
        BleDisClient bleDisClient = (BleDisClient) session.fetchClient(uuid);
        if (bleDisClient == null) {
            Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
            singleJust2.getClass();
            return singleJust2;
        }
        Single<Boolean> single = bleDisClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(1));
        single.getClass();
        return single;
    }

    private final Single<Boolean> isH10ExerciseFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePsFtpUtils.RFC77_PFTP_SERVICE;
        if (discoveredServices.contains(uuid)) {
            BlePolarDeviceCapabilitiesUtility.Companion companion = BlePolarDeviceCapabilitiesUtility.INSTANCE;
            String polarDeviceType = session.getPolarDeviceType();
            polarDeviceType.getClass();
            if (companion.isRecordingSupported(polarDeviceType)) {
                BlePsFtpClient blePsFtpClient = (BlePsFtpClient) session.fetchClient(uuid);
                if (blePsFtpClient == null) {
                    Single<Boolean> singleJust = Single.just(Boolean.FALSE);
                    singleJust.getClass();
                    return singleJust;
                }
                Single<Boolean> single = blePsFtpClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(3));
                single.getClass();
                return single;
            }
        }
        Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
        singleJust2.getClass();
        return singleJust2;
    }

    private final Single<Boolean> isHealthThermometerFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        HealthThermometer.Companion companion = HealthThermometer.INSTANCE;
        if (!discoveredServices.contains(companion.getHTS_SERVICE())) {
            Single<Boolean> singleJust = Single.just(Boolean.FALSE);
            singleJust.getClass();
            return singleJust;
        }
        if (session.fetchClient(companion.getHTS_SERVICE()) != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
        singleJust2.getClass();
        return singleJust2;
    }

    private final Single<Boolean> isHeartRateFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        BleHrClient.Companion companion = BleHrClient.INSTANCE;
        if (!discoveredServices.contains(companion.getHR_SERVICE())) {
            Single<Boolean> singleJust = Single.just(Boolean.FALSE);
            singleJust.getClass();
            return singleJust;
        }
        BleHrClient bleHrClient = (BleHrClient) session.fetchClient(companion.getHR_SERVICE());
        if (bleHrClient == null) {
            Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
            singleJust2.getClass();
            return singleJust2;
        }
        Single<Boolean> single = bleHrClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(7));
        single.getClass();
        return single;
    }

    private final Single<Boolean> isLedAnimationFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePMDClient.PMD_SERVICE;
        if (discoveredServices.contains(uuid)) {
            UUID uuid2 = BlePsFtpUtils.RFC77_PFTP_SERVICE;
            if (discoveredServices.contains(uuid2)) {
                BlePMDClient blePMDClient = (BlePMDClient) session.fetchClient(uuid);
                if (blePMDClient == null) {
                    Single<Boolean> singleJust = Single.just(Boolean.FALSE);
                    singleJust.getClass();
                    return singleJust;
                }
                BlePsFtpClient blePsFtpClient = (BlePsFtpClient) session.fetchClient(uuid2);
                if (blePsFtpClient == null) {
                    Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
                    singleJust2.getClass();
                    return singleJust2;
                }
                Single<Boolean> singleAndThen = Completable.concatArray(blePMDClient.clientReady(true), blePsFtpClient.clientReady(true)).andThen(blePMDClient.readFeature(true).map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl.isLedAnimationFeatureAvailable.1
                    @Override // io.reactivex.rxjava3.functions.Function
                    public final Boolean apply(Set<? extends PmdMeasurementType> set) {
                        set.getClass();
                        return Boolean.valueOf(set.contains(PmdMeasurementType.SDK_MODE));
                    }
                }));
                singleAndThen.getClass();
                return singleAndThen;
            }
        }
        Single<Boolean> singleJust3 = Single.just(Boolean.FALSE);
        singleJust3.getClass();
        return singleJust3;
    }

    private final Single<Boolean> isOfflineRecordingAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePMDClient.PMD_SERVICE;
        if (discoveredServices.contains(uuid)) {
            UUID uuid2 = BlePsFtpUtils.RFC77_PFTP_SERVICE;
            if (discoveredServices.contains(uuid2)) {
                BlePMDClient blePMDClient = (BlePMDClient) session.fetchClient(uuid);
                if (blePMDClient == null) {
                    Single<Boolean> singleJust = Single.just(Boolean.FALSE);
                    singleJust.getClass();
                    return singleJust;
                }
                BlePsFtpClient blePsFtpClient = (BlePsFtpClient) session.fetchClient(uuid2);
                if (blePsFtpClient == null) {
                    Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
                    singleJust2.getClass();
                    return singleJust2;
                }
                Single<Boolean> singleAndThen = Completable.concatArray(blePMDClient.clientReady(true), blePsFtpClient.clientReady(true)).andThen(blePMDClient.readFeature(true).map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl.isOfflineRecordingAvailable.1
                    @Override // io.reactivex.rxjava3.functions.Function
                    public final Boolean apply(Set<? extends PmdMeasurementType> set) {
                        set.getClass();
                        return Boolean.valueOf(set.contains(PmdMeasurementType.OFFLINE_RECORDING));
                    }
                }));
                singleAndThen.getClass();
                return singleAndThen;
            }
        }
        Single<Boolean> singleJust3 = Single.just(Boolean.FALSE);
        singleJust3.getClass();
        return singleJust3;
    }

    private final Single<Boolean> isOnlineStreamingAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        Completable completableComplete;
        BleHrClient.Companion companion = BleHrClient.INSTANCE;
        if (discoveredServices.contains(companion.getHR_SERVICE())) {
            BleHrClient bleHrClient = (BleHrClient) session.fetchClient(companion.getHR_SERVICE());
            if (bleHrClient == null) {
                Single<Boolean> singleJust = Single.just(Boolean.FALSE);
                singleJust.getClass();
                return singleJust;
            }
            completableComplete = bleHrClient.clientReady(true);
        } else {
            completableComplete = Completable.complete();
        }
        UUID uuid = BlePMDClient.PMD_SERVICE;
        if (!discoveredServices.contains(uuid)) {
            Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
            singleJust2.getClass();
            return singleJust2;
        }
        BlePMDClient blePMDClient = (BlePMDClient) session.fetchClient(uuid);
        if (blePMDClient == null) {
            Single<Boolean> singleJust3 = Single.just(Boolean.FALSE);
            singleJust3.getClass();
            return singleJust3;
        }
        Single<Boolean> single = completableComplete.andThen(blePMDClient.clientReady(true)).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(4));
        single.getClass();
        return single;
    }

    private final Single<Boolean> isPolarDeviceTimeFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePsFtpUtils.RFC77_PFTP_SERVICE;
        if (!discoveredServices.contains(uuid)) {
            Single<Boolean> singleJust = Single.just(Boolean.FALSE);
            singleJust.getClass();
            return singleJust;
        }
        BlePsFtpClient blePsFtpClient = (BlePsFtpClient) session.fetchClient(uuid);
        if (blePsFtpClient == null) {
            Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
            singleJust2.getClass();
            return singleJust2;
        }
        Single<Boolean> single = blePsFtpClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(0));
        single.getClass();
        return single;
    }

    private final Single<Boolean> isPolarFirmwareUpdateFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePsFtpUtils.RFC77_PFTP_SERVICE;
        if (discoveredServices.contains(uuid)) {
            BlePolarDeviceCapabilitiesUtility.Companion companion = BlePolarDeviceCapabilitiesUtility.INSTANCE;
            String polarDeviceType = session.getPolarDeviceType();
            polarDeviceType.getClass();
            if (companion.isFirmwareUpdateSupported(polarDeviceType)) {
                BlePsFtpClient blePsFtpClient = (BlePsFtpClient) session.fetchClient(uuid);
                if (blePsFtpClient == null) {
                    Single<Boolean> singleJust = Single.just(Boolean.FALSE);
                    singleJust.getClass();
                    return singleJust;
                }
                Single<Boolean> single = blePsFtpClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(5));
                single.getClass();
                return single;
            }
        }
        Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
        singleJust2.getClass();
        return singleJust2;
    }

    private final Single<Boolean> isPsftpServiceAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePsFtpUtils.RFC77_PFTP_SERVICE;
        if (!discoveredServices.contains(uuid)) {
            Single<Boolean> singleJust = Single.just(Boolean.FALSE);
            singleJust.getClass();
            return singleJust;
        }
        BlePsFtpClient blePsFtpClient = (BlePsFtpClient) session.fetchClient(uuid);
        if (blePsFtpClient == null) {
            Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
            singleJust2.getClass();
            return singleJust2;
        }
        Single<Boolean> single = blePsFtpClient.clientReady(true).toSingle(new BDBleApiImpl$$ExternalSyntheticLambda12(2));
        single.getClass();
        return single;
    }

    private final Single<Boolean> isSdkModeFeatureAvailable(List<UUID> discoveredServices, BleDeviceSession session) {
        UUID uuid = BlePMDClient.PMD_SERVICE;
        if (!discoveredServices.contains(uuid)) {
            Single<Boolean> singleJust = Single.just(Boolean.FALSE);
            singleJust.getClass();
            return singleJust;
        }
        BlePMDClient blePMDClient = (BlePMDClient) session.fetchClient(uuid);
        if (blePMDClient == null) {
            Single<Boolean> singleJust2 = Single.just(Boolean.FALSE);
            singleJust2.getClass();
            return singleJust2;
        }
        Single<Boolean> singleAndThen = blePMDClient.clientReady(true).andThen(blePMDClient.readFeature(true).map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl.isSdkModeFeatureAvailable.1
            @Override // io.reactivex.rxjava3.functions.Function
            public final Boolean apply(Set<? extends PmdMeasurementType> set) {
                set.getClass();
                return Boolean.valueOf(set.contains(PmdMeasurementType.SDK_MODE));
            }
        }));
        singleAndThen.getClass();
        return singleAndThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String message) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logError(String message) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable makeFeatureCallbackIfNeeded(BleDeviceSession session, List<UUID> discoveredServices, PolarBleApi.PolarBleSdkFeature featurePolarOfflineRecording) {
        Single<Boolean> singleIsHeartRateFeatureAvailable;
        switch (WhenMappings.$EnumSwitchMapping$0[featurePolarOfflineRecording.ordinal()]) {
            case 1:
                singleIsHeartRateFeatureAvailable = isHeartRateFeatureAvailable(discoveredServices, session);
                break;
            case 2:
                singleIsHeartRateFeatureAvailable = isDeviceInfoFeatureAvailable(discoveredServices, session);
                break;
            case 3:
                singleIsHeartRateFeatureAvailable = isBatteryInfoFeatureAvailable(discoveredServices, session);
                break;
            case 4:
                singleIsHeartRateFeatureAvailable = isOnlineStreamingAvailable(discoveredServices, session);
                break;
            case 5:
                singleIsHeartRateFeatureAvailable = isOfflineRecordingAvailable(discoveredServices, session);
                break;
            case 6:
                singleIsHeartRateFeatureAvailable = isH10ExerciseFeatureAvailable(discoveredServices, session);
                break;
            case 7:
                singleIsHeartRateFeatureAvailable = isPolarDeviceTimeFeatureAvailable(discoveredServices, session);
                break;
            case 8:
                singleIsHeartRateFeatureAvailable = isSdkModeFeatureAvailable(discoveredServices, session);
                break;
            case 9:
                singleIsHeartRateFeatureAvailable = isPsftpServiceAvailable(discoveredServices, session);
                break;
            case 10:
                singleIsHeartRateFeatureAvailable = isHealthThermometerFeatureAvailable(discoveredServices, session);
                break;
            case 11:
                singleIsHeartRateFeatureAvailable = isLedAnimationFeatureAvailable(discoveredServices, session);
                break;
            case 12:
                singleIsHeartRateFeatureAvailable = isPolarFirmwareUpdateFeatureAvailable(discoveredServices, session);
                break;
            case 13:
                singleIsHeartRateFeatureAvailable = isActivityDataFeatureAvailable(discoveredServices, session);
                break;
            case 14:
                singleIsHeartRateFeatureAvailable = isActivityDataFeatureAvailable(discoveredServices, session);
                break;
            case 15:
                singleIsHeartRateFeatureAvailable = isActivityDataFeatureAvailable(discoveredServices, session);
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
        Completable completableFlatMapCompletable = singleIsHeartRateFeatureAvailable.flatMapCompletable(new C20751(session, featurePolarOfflineRecording));
        completableFlatMapCompletable.getClass();
        return completableFlatMapCompletable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openConnection(BleDeviceSession session) {
        BleDeviceListener bleDeviceListener = this.listener;
        if (bleDeviceListener != null) {
            Disposable disposable = this.devicesStateMonitorDisposable;
            if (disposable == null || (disposable != null && disposable.isDisposed())) {
                this.devicesStateMonitorDisposable = bleDeviceListener.monitorDeviceSessionState().subscribe(this.deviceStateMonitorObserver);
            }
            bleDeviceListener.openSessionDirect(session);
        }
    }

    private final Single<PolarSensorSetting> querySettings(String identifier, PmdMeasurementType type, PmdRecordingType recordingType) {
        try {
            BlePMDClient blePMDClient = (BlePMDClient) sessionPmdClientReady(identifier).fetchClient(BlePMDClient.PMD_SERVICE);
            Single singleError = blePMDClient == null ? Single.error(new PolarServiceNotAvailable()) : blePMDClient.querySettings(type, recordingType).map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl.querySettings.1
                @Override // io.reactivex.rxjava3.functions.Function
                public final PolarSensorSetting apply(PmdSetting pmdSetting) {
                    pmdSetting.getClass();
                    return PolarDataUtils.INSTANCE.mapPmdSettingsToPolarSettings(pmdSetting, false);
                }
            });
            singleError.getClass();
            return singleError;
        } catch (Throwable th) {
            Single<PolarSensorSetting> singleError2 = Single.error(th);
            singleError2.getClass();
            return singleError2;
        }
    }

    private final BleDeviceSession sessionByAddress(String address) {
        Set<BleDeviceSession> setDeviceSessions;
        BleDeviceListener bleDeviceListener = this.listener;
        if (bleDeviceListener == null || (setDeviceSessions = bleDeviceListener.deviceSessions()) == null) {
            return null;
        }
        for (BleDeviceSession bleDeviceSession : setDeviceSessions) {
            if (Intrinsics.areEqual(bleDeviceSession.getAddress(), address)) {
                return bleDeviceSession;
            }
        }
        return null;
    }

    private final BleDeviceSession sessionByDeviceId(String deviceId) {
        Set<BleDeviceSession> setDeviceSessions;
        BleDeviceListener bleDeviceListener = this.listener;
        if (bleDeviceListener == null || (setDeviceSessions = bleDeviceListener.deviceSessions()) == null) {
            return null;
        }
        for (BleDeviceSession bleDeviceSession : setDeviceSessions) {
            if (Intrinsics.areEqual(bleDeviceSession.getAdvertisementContent().getPolarDeviceId(), deviceId)) {
                return bleDeviceSession;
            }
        }
        return null;
    }

    private final BleDeviceSession sessionServiceReady(String identifier, UUID service) throws PolarDeviceDisconnected, PolarDeviceNotFound, PolarServiceNotAvailable, PolarInvalidArgument {
        BleDeviceSession bleDeviceSessionFetchSession = fetchSession(identifier);
        if (bleDeviceSessionFetchSession == null) {
            throw new PolarDeviceNotFound();
        }
        if (bleDeviceSessionFetchSession.getSessionState() != BleDeviceSession.DeviceSessionState.SESSION_OPEN) {
            throw new PolarDeviceDisconnected();
        }
        BleGattBase bleGattBaseFetchClient = bleDeviceSessionFetchSession.fetchClient(service);
        if (bleGattBaseFetchClient == null || !bleGattBaseFetchClient.isServiceDiscovered()) {
            throw new PolarServiceNotAvailable();
        }
        return bleDeviceSessionFetchSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLedConfig$lambda$17(BDBleApiImpl bDBleApiImpl, String str, LedConfig ledConfig, final CompletableEmitter completableEmitter) {
        bDBleApiImpl.getClass();
        str.getClass();
        ledConfig.getClass();
        completableEmitter.getClass();
        try {
            BlePsFtpClient blePsFtpClient = (BlePsFtpClient) bDBleApiImpl.sessionPsFtpClientReady(str).fetchClient(BlePsFtpUtils.RFC77_PFTP_SERVICE);
            if (blePsFtpClient == null) {
                throw new PolarServiceNotAvailable();
            }
            PftpRequest$PbPFtpOperation.Builder builderNewBuilder = PftpRequest$PbPFtpOperation.newBuilder();
            builderNewBuilder.setCommand(PftpRequest$PbPFtpOperation.Command.PUT);
            builderNewBuilder.setPath("/LEDCFG.BIN");
            blePsFtpClient.write(builderNewBuilder.build().toByteArray(), new ByteArrayInputStream(new byte[]{ledConfig.getSdkModeLedEnabled(), ledConfig.getPpiModeLedEnabled()})).doOnError(new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setLedConfig$1$1
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Throwable th) {
                    th.getClass();
                    completableEmitter.onError(th);
                }
            }).subscribe();
            completableEmitter.onComplete();
        } catch (Throwable th) {
            BleLogger.INSTANCE.e("BDBleApiImpl", "setLedConfig() error: " + th);
            completableEmitter.onError(th);
        }
    }

    private final void setupDevice(final BleDeviceSession session) {
        String polarDeviceId = session.getPolarDeviceId();
        if (polarDeviceId.length() == 0) {
            polarDeviceId = session.getAddress();
        }
        Disposable disposableSubscribe = session.monitorServicesDiscovered(true).flatMapCompletable(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposableAvailableFeatures$1
            @Override // io.reactivex.rxjava3.functions.Function
            public final CompletableSource apply(List<UUID> list) {
                list.getClass();
                ArrayList arrayList = new ArrayList();
                for (PolarBleApi.PolarBleSdkFeature polarBleSdkFeature : PolarBleApi.PolarBleSdkFeature.values()) {
                    if (this.this$0.getFeatures().contains(polarBleSdkFeature)) {
                        arrayList.add(this.this$0.makeFeatureCallbackIfNeeded(session, list, polarBleSdkFeature));
                    }
                }
                return Completable.concat(arrayList);
            }
        }).subscribe(new BDBleApiImpl$$ExternalSyntheticLambda2(this, 1), new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposableAvailableFeatures$3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Throwable th) {
                th.getClass();
                this.this$0.logError("Error while available features are checked: " + th);
            }
        });
        disposableSubscribe.getClass();
        Map<String, Disposable> map = this.deviceAvailableFeaturesDisposable;
        String address = session.getAddress();
        address.getClass();
        map.put(address, disposableSubscribe);
        Disposable disposableSubscribe2 = session.monitorServicesDiscovered(true).toFlowable().flatMapIterable(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$1
            @Override // io.reactivex.rxjava3.functions.Function
            public final Iterable<UUID> apply(List<UUID> list) {
                list.getClass();
                return list;
            }
        }).flatMap(new BDBleApiImpl$setupDevice$disposable$2(session, this, polarDeviceId)).subscribe(new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                obj.getClass();
            }
        }, new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Throwable th) {
                th.getClass();
                this.this$0.logError("Error while monitoring session services: " + th);
            }
        }, new BDBleApiImpl$$ExternalSyntheticLambda2(this, 2));
        disposableSubscribe2.getClass();
        Map<String, Disposable> map2 = this.deviceDataMonitorDisposable;
        String address2 = session.getAddress();
        address2.getClass();
        map2.put(address2, disposableSubscribe2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDevice$lambda$84(BDBleApiImpl bDBleApiImpl) {
        bDBleApiImpl.getClass();
        bDBleApiImpl.log("completed available features check ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDevice$lambda$85(BDBleApiImpl bDBleApiImpl) {
        bDBleApiImpl.getClass();
        bDBleApiImpl.log("complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flowable startAccStreaming$lambda$36(BlePMDClient blePMDClient) {
        blePMDClient.getClass();
        return blePMDClient.monitorAccNotifications$library_sdkRelease(true).map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl$startAccStreaming$1$1
            @Override // io.reactivex.rxjava3.functions.Function
            public final PolarAccelerometerData apply(AccData accData) {
                accData.getClass();
                return PolarDataUtils.INSTANCE.mapPmdClientAccDataToPolarAcc(accData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flowable startPpiStreaming$lambda$38(BlePMDClient blePMDClient) {
        blePMDClient.getClass();
        return blePMDClient.monitorPpiNotifications$library_sdkRelease(true).map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl$startPpiStreaming$1$1
            @Override // io.reactivex.rxjava3.functions.Function
            public final PolarPpiData apply(PpiData ppiData) {
                ppiData.getClass();
                return PolarDataUtils.INSTANCE.mapPMDClientPpiDataToPolarPpiData(ppiData);
            }
        });
    }

    private final <T> Flowable<T> startStreaming(String identifier, PmdMeasurementType type, PolarSensorSetting setting, Function<BlePMDClient, Flowable<T>> observer) {
        try {
            BleDeviceSession bleDeviceSessionSessionPmdClientReady = sessionPmdClientReady(identifier);
            BlePMDClient blePMDClient = (BlePMDClient) bleDeviceSessionSessionPmdClientReady.fetchClient(BlePMDClient.PMD_SERVICE);
            if (blePMDClient == null) {
                Flowable<T> flowableError = Flowable.error(new PolarServiceNotAvailable());
                flowableError.getClass();
                return flowableError;
            }
            Flowable<T> flowableAndThen = BlePMDClient.startMeasurement$default(blePMDClient, type, PolarDataUtils.INSTANCE.mapPolarSettingsToPmdSettings(setting), null, null, 12, null).andThen(observer.apply(blePMDClient).onErrorResumeNext(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl.startStreaming.1
                @Override // io.reactivex.rxjava3.functions.Function
                public final Publisher<? extends T> apply(Throwable th) {
                    th.getClass();
                    return Flowable.error(BDBleApiImpl.this.handleError(th));
                }
            }).doFinally(new LoginManager$$ExternalSyntheticLambda1(this, bleDeviceSessionSessionPmdClientReady, blePMDClient, type)));
            flowableAndThen.getClass();
            return flowableAndThen;
        } catch (Throwable th) {
            Flowable<T> flowableError2 = Flowable.error(th);
            flowableError2.getClass();
            return flowableError2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startStreaming$lambda$31(BDBleApiImpl bDBleApiImpl, BleDeviceSession bleDeviceSession, BlePMDClient blePMDClient, PmdMeasurementType pmdMeasurementType) {
        bDBleApiImpl.getClass();
        bleDeviceSession.getClass();
        blePMDClient.getClass();
        pmdMeasurementType.getClass();
        bDBleApiImpl.stopPmdStreaming(bleDeviceSession, blePMDClient, pmdMeasurementType);
    }

    private final void stopPmdStreaming(BleDeviceSession session, BlePMDClient client, PmdMeasurementType type) {
        if (session.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN) {
            Disposable disposableSubscribe = client.stopMeasurement(type).subscribe(new BDBleApiImpl$$ExternalSyntheticLambda1(3), new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$stopPmdStreaming$disposable$2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Throwable th) {
                    th.getClass();
                    this.this$0.logError("failed to stop pmd stream: " + th.getLocalizedMessage());
                }
            });
            disposableSubscribe.getClass();
            Map<String, Disposable> map = this.stopPmdStreamingDisposable;
            String address = session.getAddress();
            address.getClass();
            map.put(address, disposableSubscribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopPmdStreaming$lambda$74() {
    }

    private final void tearDownDevice(BleDeviceSession session) {
        String address = session.getAddress();
        if (this.deviceDataMonitorDisposable.containsKey(address)) {
            Disposable disposable = this.deviceDataMonitorDisposable.get(address);
            if (disposable != null) {
                disposable.dispose();
            }
            this.deviceDataMonitorDisposable.remove(address);
        }
        if (this.deviceAvailableFeaturesDisposable.containsKey(address)) {
            Disposable disposable2 = this.deviceAvailableFeaturesDisposable.get(address);
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.deviceAvailableFeaturesDisposable.remove(address);
        }
    }

    @Override // com.polar.sdk.api.PolarBleApi
    public void connectToDevice(final String identifier) throws PolarInvalidArgument {
        identifier.getClass();
        BleDeviceSession bleDeviceSessionFetchSession = fetchSession(identifier);
        if (bleDeviceSessionFetchSession == null || bleDeviceSessionFetchSession.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_CLOSED) {
            if (this.connectSubscriptions.containsKey(identifier)) {
                Disposable disposable = this.connectSubscriptions.get(identifier);
                if (disposable != null) {
                    disposable.dispose();
                }
                this.connectSubscriptions.remove(identifier);
            }
            if (bleDeviceSessionFetchSession != null) {
                openConnection(bleDeviceSessionFetchSession);
                return;
            }
            BleDeviceListener bleDeviceListener = this.listener;
            if (bleDeviceListener != null) {
                Map<String, Disposable> map = this.connectSubscriptions;
                Disposable disposableSubscribe = bleDeviceListener.search(false).filter(new Predicate() { // from class: com.polar.sdk.impl.BDBleApiImpl$connectToDevice$1$1
                    @Override // io.reactivex.rxjava3.functions.Predicate
                    public final boolean test(BleDeviceSession bleDeviceSession) {
                        bleDeviceSession.getClass();
                        return Intrinsics.areEqual(StringsKt.contains$default(identifier, ":") ? bleDeviceSession.getAddress() : bleDeviceSession.getPolarDeviceId(), identifier);
                    }
                }).take(1L).observeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$connectToDevice$1$2
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(BleDeviceSession bleDeviceSession) {
                        bleDeviceSession.getClass();
                        this.this$0.openConnection(bleDeviceSession);
                    }
                }, new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$connectToDevice$1$3
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Throwable th) {
                        th.getClass();
                        this.this$0.logError("connect search error with device: " + identifier + " error: " + th.getMessage());
                    }
                }, new BDBleApiImpl$$ExternalSyntheticLambda3(this, identifier, 0));
                disposableSubscribe.getClass();
                map.put(identifier, disposableSubscribe);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BleDeviceSession fetchSession(String identifier) throws PolarInvalidArgument {
        identifier.getClass();
        if (new Regex("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$").matches(identifier)) {
            return sessionByAddress(identifier);
        }
        if (new Regex("([0-9a-fA-F]){6,8}").matches(identifier)) {
            return sessionByDeviceId(identifier);
        }
        throw new PolarInvalidArgument(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.polar.sdk.api.PolarOnlineStreamingApi
    public Single<PolarSensorSetting> requestStreamSettings(String identifier, PolarBleApi.PolarDeviceDataType feature) {
        identifier.getClass();
        feature.getClass();
        BleLogger.INSTANCE.d("BDBleApiImpl", "Request online stream settings. Feature: " + feature + " Device: " + identifier);
        switch (WhenMappings.$EnumSwitchMapping$1[feature.ordinal()]) {
            case 1:
                return querySettings(identifier, PmdMeasurementType.ECG, PmdRecordingType.ONLINE);
            case 2:
                return querySettings(identifier, PmdMeasurementType.ACC, PmdRecordingType.ONLINE);
            case 3:
                return querySettings(identifier, PmdMeasurementType.PPG, PmdRecordingType.ONLINE);
            case 4:
                return querySettings(identifier, PmdMeasurementType.GYRO, PmdRecordingType.ONLINE);
            case 5:
                return querySettings(identifier, PmdMeasurementType.MAGNETOMETER, PmdRecordingType.ONLINE);
            case 6:
                return querySettings(identifier, PmdMeasurementType.PRESSURE, PmdRecordingType.ONLINE);
            case 7:
                return querySettings(identifier, PmdMeasurementType.LOCATION, PmdRecordingType.ONLINE);
            case 8:
                return querySettings(identifier, PmdMeasurementType.TEMPERATURE, PmdRecordingType.ONLINE);
            case 9:
                return querySettings(identifier, PmdMeasurementType.SKIN_TEMP, PmdRecordingType.ONLINE);
            case 10:
            case 11:
                Single<PolarSensorSetting> singleError = Single.error(new PolarOperationNotSupported());
                singleError.getClass();
                return singleError;
            default:
                Single<PolarSensorSetting> singleError2 = Single.error(new PolarOperationNotSupported());
                singleError2.getClass();
                return singleError2;
        }
    }

    @Override // com.polar.sdk.api.PolarBleApi
    public Flowable<PolarDeviceInfo> searchForDevice() {
        BleDeviceListener bleDeviceListener = this.listener;
        if (bleDeviceListener != null) {
            Flowable map = bleDeviceListener.search(false).distinct().map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl$searchForDevice$1$1
                @Override // io.reactivex.rxjava3.functions.Function
                public final PolarDeviceInfo apply(BleDeviceSession bleDeviceSession) {
                    bleDeviceSession.getClass();
                    String polarDeviceId = bleDeviceSession.getPolarDeviceId();
                    polarDeviceId.getClass();
                    String address = bleDeviceSession.getAddress();
                    address.getClass();
                    int rssi = bleDeviceSession.getRssi();
                    String name = bleDeviceSession.getName();
                    name.getClass();
                    return new PolarDeviceInfo(polarDeviceId, address, rssi, name, bleDeviceSession.isConnectableAdvertisement(), bleDeviceSession.getAdvertisementContent().containsService("180D"), bleDeviceSession.getAdvertisementContent().containsService("FEEE"));
                }
            });
            map.getClass();
            return map;
        }
        Flowable<PolarDeviceInfo> flowableError = Flowable.error(new PolarBleSdkInstanceException("PolarBleApi instance is shutdown"));
        flowableError.getClass();
        return flowableError;
    }

    public final BleDeviceSession sessionPmdClientReady(String identifier) throws PolarDeviceDisconnected, PolarDeviceNotFound, PolarNotificationNotEnabled, PolarServiceNotAvailable, PolarInvalidArgument {
        identifier.getClass();
        UUID uuid = BlePMDClient.PMD_SERVICE;
        BleDeviceSession bleDeviceSessionSessionServiceReady = sessionServiceReady(identifier, uuid);
        BlePMDClient blePMDClient = (BlePMDClient) bleDeviceSessionSessionServiceReady.fetchClient(uuid);
        if (blePMDClient == null) {
            throw new PolarServiceNotAvailable();
        }
        AtomicInteger notificationAtomicInteger = blePMDClient.getNotificationAtomicInteger(BlePMDClient.PMD_CP);
        AtomicInteger notificationAtomicInteger2 = blePMDClient.getNotificationAtomicInteger(BlePMDClient.PMD_DATA);
        if (notificationAtomicInteger == null || notificationAtomicInteger2 == null || notificationAtomicInteger.get() != 0 || notificationAtomicInteger2.get() != 0) {
            throw new PolarNotificationNotEnabled();
        }
        return bleDeviceSessionSessionServiceReady;
    }

    public final BleDeviceSession sessionPsFtpClientReady(String identifier) throws PolarDeviceDisconnected, PolarDeviceNotFound, PolarNotificationNotEnabled, PolarServiceNotAvailable, PolarInvalidArgument {
        identifier.getClass();
        UUID uuid = BlePsFtpUtils.RFC77_PFTP_SERVICE;
        uuid.getClass();
        BleDeviceSession bleDeviceSessionSessionServiceReady = sessionServiceReady(identifier, uuid);
        BlePsFtpClient blePsFtpClient = (BlePsFtpClient) bleDeviceSessionSessionServiceReady.fetchClient(uuid);
        if (blePsFtpClient == null) {
            throw new PolarServiceNotAvailable();
        }
        AtomicInteger notificationAtomicInteger = blePsFtpClient.getNotificationAtomicInteger(BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC);
        if (notificationAtomicInteger == null || notificationAtomicInteger.get() != 0) {
            throw new PolarNotificationNotEnabled();
        }
        return bleDeviceSessionSessionServiceReady;
    }

    @Override // com.polar.sdk.api.PolarBleApi
    public void setApiCallback(PolarBleApiCallbackProvider callback) {
        callback.getClass();
        this.callback = callback;
        BleDeviceListener bleDeviceListener = this.listener;
        if (bleDeviceListener != null) {
            callback.blePowerStateChanged(bleDeviceListener.bleActive());
        }
    }

    @Override // com.polar.sdk.api.PolarBleApi
    public Completable setLedConfig(String identifier, LedConfig ledConfig) {
        identifier.getClass();
        ledConfig.getClass();
        Completable completableCreate = Completable.create(new BDBleApiImpl$$ExternalSyntheticLambda0(this, identifier, ledConfig));
        completableCreate.getClass();
        return completableCreate;
    }

    @Override // com.polar.sdk.api.PolarBleApi
    public void shutDown() {
        for (Disposable disposable : this.deviceDataMonitorDisposable.values()) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        for (Disposable disposable2 : this.deviceAvailableFeaturesDisposable.values()) {
            if (!disposable2.isDisposed()) {
                disposable2.dispose();
            }
        }
        Disposable disposable3 = this.devicesStateMonitorDisposable;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.devicesStateMonitorDisposable = null;
        for (Disposable disposable4 : this.connectSubscriptions.values()) {
            if (!disposable4.isDisposed()) {
                disposable4.dispose();
            }
        }
        for (Disposable disposable5 : this.stopPmdStreamingDisposable.values()) {
            if (!disposable5.isDisposed()) {
                disposable5.dispose();
            }
        }
        BleDeviceListener bleDeviceListener = this.listener;
        if (bleDeviceListener != null) {
            bleDeviceListener.shutDown();
        }
        this.callback = null;
        this.listener = null;
        INSTANCE.clearInstance();
    }

    @Override // com.polar.sdk.api.PolarOnlineStreamingApi
    public Flowable<PolarAccelerometerData> startAccStreaming(String identifier, PolarSensorSetting sensorSetting) {
        identifier.getClass();
        sensorSetting.getClass();
        return startStreaming(identifier, PmdMeasurementType.ACC, sensorSetting, new BDBleApiImpl$$ExternalSyntheticLambda1(4));
    }

    @Override // com.polar.sdk.api.PolarOnlineStreamingApi
    public Flowable<PolarHrData> startHrStreaming(String identifier) {
        identifier.getClass();
        try {
            BleHrClient.Companion companion = BleHrClient.INSTANCE;
            BleHrClient bleHrClient = (BleHrClient) sessionServiceReady(identifier, companion.getHR_SERVICE()).fetchClient(companion.getHR_SERVICE());
            if (bleHrClient == null) {
                Flowable<PolarHrData> flowableError = Flowable.error(new PolarServiceNotAvailable());
                flowableError.getClass();
                return flowableError;
            }
            BleLogger.INSTANCE.d("BDBleApiImpl", "start Hr online streaming. Device: " + identifier);
            Flowable map = bleHrClient.observeHrNotifications(true).map(new Function() { // from class: com.polar.sdk.impl.BDBleApiImpl.startHrStreaming.1
                @Override // io.reactivex.rxjava3.functions.Function
                public final PolarHrData apply(BleHrClient.HrNotificationData hrNotificationData) {
                    hrNotificationData.getClass();
                    return new PolarHrData(CollectionsKt.listOf(new PolarHrData.PolarHrSample(hrNotificationData.getHrValue(), 0, 0, hrNotificationData.getRrsMs(), hrNotificationData.getRrPresent(), hrNotificationData.getSensorContact(), hrNotificationData.getSensorContactSupported())));
                }
            });
            map.getClass();
            return map;
        } catch (Exception e) {
            Flowable<PolarHrData> flowableError2 = Flowable.error(e);
            flowableError2.getClass();
            return flowableError2;
        }
    }

    @Override // com.polar.sdk.api.PolarOnlineStreamingApi
    public Flowable<PolarPpiData> startPpiStreaming(String identifier) {
        identifier.getClass();
        return startStreaming(identifier, PmdMeasurementType.PPI, new PolarSensorSetting((Map<PolarSensorSetting.SettingType, Integer>) MapsKt.emptyMap()), new BDBleApiImpl$$ExternalSyntheticLambda1(5));
    }

    @Override // com.polar.androidcommunications.api.ble.BleDeviceListener.BlePowerStateChangedCallback
    public void stateChanged(boolean power) {
        PolarBleApiCallbackProvider polarBleApiCallbackProvider = this.callback;
        if (polarBleApiCallbackProvider != null) {
            polarBleApiCallbackProvider.blePowerStateChanged(power);
        }
    }

    /* JADX INFO: renamed from: com.polar.sdk.impl.BDBleApiImpl$makeFeatureCallbackIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/rxjava3/core/CompletableSource;", "it", "", "apply"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class C20751<T, R> implements Function {
        final /* synthetic */ PolarBleApi.PolarBleSdkFeature $featurePolarOfflineRecording;
        final /* synthetic */ BleDeviceSession $session;

        public C20751(BleDeviceSession bleDeviceSession, PolarBleApi.PolarBleSdkFeature polarBleSdkFeature) {
            this.$session = bleDeviceSession;
            this.$featurePolarOfflineRecording = polarBleSdkFeature;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void apply$lambda$0(BDBleApiImpl bDBleApiImpl, BleDeviceSession bleDeviceSession, PolarBleApi.PolarBleSdkFeature polarBleSdkFeature) {
            bDBleApiImpl.getClass();
            bleDeviceSession.getClass();
            polarBleSdkFeature.getClass();
            PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl.callback;
            if (polarBleApiCallbackProvider != null) {
                String polarDeviceId = bleDeviceSession.getPolarDeviceId();
                polarDeviceId.getClass();
                polarBleApiCallbackProvider.bleSdkFeatureReady(polarDeviceId, polarBleSdkFeature);
            }
        }

        public final CompletableSource apply(boolean z) {
            return z ? Completable.fromAction(new BDBleApiImpl$$ExternalSyntheticLambda0(BDBleApiImpl.this, this.$session, this.$featurePolarOfflineRecording)) : Completable.complete();
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) {
            return apply(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ BDBleApiImpl(Context context, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, set);
    }
}
