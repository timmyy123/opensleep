package com.urbandroid.sleep.bluetoothle;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001_B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0017\u0010\u0014J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0018\u0010\u0014J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u001e\u0010\u0014J(\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\"\u0010#J(\u0010&\u001a\u00020\n2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b&\u0010'J(\u0010(\u001a\u00020\n2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b(\u0010'J \u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b+\u0010,J(\u0010/\u001a\u00020\n2\u0006\u0010$\u001a\u00020\t2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b/\u00100J \u00101\u001a\u00020-2\u0006\u0010$\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b1\u00102J0\u00105\u001a\u00020\n2\u0006\u0010$\u001a\u00020\t2\u0006\u0010.\u001a\u00020-2\u0006\u00104\u001a\u0002032\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\n¢\u0006\u0004\b7\u0010\u0016J\r\u00108\u001a\u00020\n¢\u0006\u0004\b8\u0010\u0016J\u0019\u0010;\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\u0016J\u000f\u0010>\u001a\u00020\nH\u0002¢\u0006\u0004\b>\u0010\u0016J\u000f\u0010?\u001a\u00020\nH\u0002¢\u0006\u0004\b?\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010G\u001a\n F*\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u00060OR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010RR\u0016\u0010S\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u00198\u0002X\u0082D¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010VR\u0016\u0010X\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R&\u0010]\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006`"}, d2 = {"Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothDevice;", "btDevice", "<init>", "(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "Lkotlin/Function1;", "Landroid/bluetooth/BluetoothGattCharacteristic;", "", "listener", "addCharacteristicChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "isConnected", "()Z", "", "timeoutMillis", "connect", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectAsync", "()V", "disconnectSync", "setPreferredPhy2M", "", "mtu", "requestMTU", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbandroid/sleep/bluetoothle/GattServices;", "discoverServices", "Ljava/util/UUID;", "serviceId", "characteristicId", "getCharacteristic", "(Ljava/util/UUID;Ljava/util/UUID;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "characteristic", "enabled", "setIndicationEnabled", "(Landroid/bluetooth/BluetoothGattCharacteristic;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNotificationEnabled", "Landroid/bluetooth/BluetoothGattDescriptor;", "descriptor", "writeDescriptor", "(Landroid/bluetooth/BluetoothGattDescriptor;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "bytes", "write", "(Landroid/bluetooth/BluetoothGattCharacteristic;[BJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "(Landroid/bluetooth/BluetoothGattCharacteristic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbandroid/sleep/bluetoothle/DataConsumer;", "consumer", "writeAndCollectNotifications", "(Landroid/bluetooth/BluetoothGattCharacteristic;[BLcom/urbandroid/sleep/bluetoothle/DataConsumer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startLogFile", "endLogFile", "Landroid/bluetooth/BluetoothGatt;", "gatt", "doGattClose", "(Landroid/bluetooth/BluetoothGatt;)V", "reset", "handleReadWriteFailure", "generateErrorReportIfNecessary", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/bluetooth/BluetoothDevice;", "getBtDevice", "()Landroid/bluetooth/BluetoothDevice;", "kotlin.jvm.PlatformType", "CCC_DESCRIPTOR_ID", "Ljava/util/UUID;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lcom/urbandroid/sleep/bluetoothle/BLELogger;", "bleLogger", "Lcom/urbandroid/sleep/bluetoothle/BLELogger;", "Lcom/urbandroid/sleep/bluetoothle/BLEClient$GattCallback;", "gattCallback", "Lcom/urbandroid/sleep/bluetoothle/BLEClient$GattCallback;", "Landroid/bluetooth/BluetoothGatt;", "disconnectedFromCallback", "Z", "maxReadWriteFailures", "I", "numberOfFailuresSinceConnect", "maxFailuresCountReachedTime", "J", "gattServices", "Lcom/urbandroid/sleep/bluetoothle/GattServices;", "", "characteristicChangeListeners", "Ljava/util/List;", "GattCallback", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BLEClient {
    private final UUID CCC_DESCRIPTOR_ID;
    private final BLELogger bleLogger;
    private final BluetoothDevice btDevice;
    private final List<Function1<BluetoothGattCharacteristic, Unit>> characteristicChangeListeners;
    private final Context context;
    private volatile boolean disconnectedFromCallback;
    private volatile BluetoothGatt gatt;
    private final GattCallback gattCallback;
    private volatile GattServices gattServices;
    private volatile long maxFailuresCountReachedTime;
    private final int maxReadWriteFailures;
    private final Mutex mutex;
    private volatile int numberOfFailuresSinceConnect;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0012\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u000fJ)\u0010\u0016\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010 \u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\"\u0010\u000fJ)\u0010%\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b'\u0010\u000fJ)\u0010(\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010&J\u0017\u0010*\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010)¢\u0006\u0004\b*\u0010+J!\u0010,\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\t¢\u0006\u0004\b.\u0010/J+\u00104\u001a\u00020\t\"\u0004\b\u0000\u001002\u000e\u00102\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001012\u0006\u00103\u001a\u00028\u0000¢\u0006\u0004\b4\u00105R*\u00106\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010<\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R*\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00107\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R,\u0010B\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00107\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R*\u0010E\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u00107\u001a\u0004\bF\u00109\"\u0004\bG\u0010;R*\u0010H\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u00107\u001a\u0004\bI\u00109\"\u0004\bJ\u0010;R,\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u00107\u001a\u0004\bL\u00109\"\u0004\bM\u0010;R,\u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010N\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u00107\u001a\u0004\bP\u00109\"\u0004\bQ\u0010;R$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006_"}, d2 = {"Lcom/urbandroid/sleep/bluetoothle/BLEClient$GattCallback;", "Landroid/bluetooth/BluetoothGattCallback;", "<init>", "(Lcom/urbandroid/sleep/bluetoothle/BLEClient;)V", "Landroid/bluetooth/BluetoothGatt;", "gatt", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "newState", "", "onConnectionStateChange", "(Landroid/bluetooth/BluetoothGatt;II)V", "", "result", "resumeConnect", "(Z)V", "txPhy", "rxPhy", "onPhyUpdate", "(Landroid/bluetooth/BluetoothGatt;III)V", "resumeSetPreferredPhy", "mtu", "onMtuChanged", "resumeRequestMTU", "(I)V", "onServicesDiscovered", "(Landroid/bluetooth/BluetoothGatt;I)V", "Lcom/urbandroid/sleep/bluetoothle/GattServices;", "resumeServiceDiscovery", "(Lcom/urbandroid/sleep/bluetoothle/GattServices;)V", "Landroid/bluetooth/BluetoothGattDescriptor;", "descriptor", "onDescriptorWrite", "(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattDescriptor;I)V", "resumeWriteDescriptor", "Landroid/bluetooth/BluetoothGattCharacteristic;", "characteristic", "onCharacteristicWrite", "(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V", "resumeWrite", "onCharacteristicRead", "", "resumeRead", "([B)V", "onCharacteristicChanged", "(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;)V", "resumeExpectedNotifications", "()V", "T", "Lkotlin/coroutines/Continuation;", "cont", SDKConstants.PARAM_VALUE, "robustResume", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "connectContinuation", "Lkotlin/coroutines/Continuation;", "getConnectContinuation", "()Lkotlin/coroutines/Continuation;", "setConnectContinuation", "(Lkotlin/coroutines/Continuation;)V", "setPreferredPhyContinuation", "getSetPreferredPhyContinuation", "setSetPreferredPhyContinuation", "requestMtuContinuation", "getRequestMtuContinuation", "setRequestMtuContinuation", "serviceDiscoveryContinuation", "getServiceDiscoveryContinuation", "setServiceDiscoveryContinuation", "writeDescriptorContinuation", "getWriteDescriptorContinuation", "setWriteDescriptorContinuation", "writeContinuation", "getWriteContinuation", "setWriteContinuation", "readContinuation", "getReadContinuation", "setReadContinuation", "", "expectedNotificationsContinuation", "getExpectedNotificationsContinuation", "setExpectedNotificationsContinuation", "Lcom/urbandroid/sleep/bluetoothle/DataConsumer;", "expectedNotificationsConsumer", "Lcom/urbandroid/sleep/bluetoothle/DataConsumer;", "getExpectedNotificationsConsumer", "()Lcom/urbandroid/sleep/bluetoothle/DataConsumer;", "setExpectedNotificationsConsumer", "(Lcom/urbandroid/sleep/bluetoothle/DataConsumer;)V", "expectedNotificationsCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "getExpectedNotificationsCharacteristic", "()Landroid/bluetooth/BluetoothGattCharacteristic;", "setExpectedNotificationsCharacteristic", "(Landroid/bluetooth/BluetoothGattCharacteristic;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class GattCallback extends BluetoothGattCallback {
        private volatile Continuation<? super Boolean> connectContinuation;
        private volatile BluetoothGattCharacteristic expectedNotificationsCharacteristic;
        private volatile DataConsumer expectedNotificationsConsumer;
        private volatile Continuation expectedNotificationsContinuation;
        private volatile Continuation<? super byte[]> readContinuation;
        private volatile Continuation<? super Integer> requestMtuContinuation;
        private volatile Continuation<? super GattServices> serviceDiscoveryContinuation;
        private volatile Continuation<? super Boolean> setPreferredPhyContinuation;
        private volatile Continuation<? super Boolean> writeContinuation;
        private volatile Continuation<? super Boolean> writeDescriptorContinuation;

        public GattCallback() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            characteristic.getClass();
            if (!BLEClient.this.characteristicChangeListeners.isEmpty()) {
                BLELogger bLELogger = BLEClient.this.bleLogger;
                byte[] value = characteristic.getValue();
                value.getClass();
                bLELogger.minor("characteristic changed global", value);
                Iterator it = BLEClient.this.characteristicChangeListeners.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(characteristic);
                }
            }
            DataConsumer dataConsumer = this.expectedNotificationsConsumer;
            if (dataConsumer != null) {
                BLEClient bLEClient = BLEClient.this;
                BluetoothGattCharacteristic bluetoothGattCharacteristic = this.expectedNotificationsCharacteristic;
                if (bluetoothGattCharacteristic == null || !Intrinsics.areEqual(bluetoothGattCharacteristic.getUuid(), characteristic.getUuid())) {
                    return;
                }
                byte[] value2 = characteristic.getValue();
                BLELogger bLELogger2 = bLEClient.bleLogger;
                value2.getClass();
                bLELogger2.minor("characteristic changed local: ", value2);
                dataConsumer.consume(value2);
                if (dataConsumer.isDataComplete()) {
                    resumeExpectedNotifications();
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            characteristic.getClass();
            if (status != 0) {
                BLEClient.this.bleLogger.minor("read failed");
                resumeRead(null);
                return;
            }
            byte[] value = characteristic.getValue();
            BLELogger bLELogger = BLEClient.this.bleLogger;
            value.getClass();
            bLELogger.minor("read succeeded", value);
            resumeRead(value);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            characteristic.getClass();
            BLEClient bLEClient = BLEClient.this;
            if (status == 0) {
                bLEClient.bleLogger.minor("write succeeded");
                resumeWrite(true);
            } else {
                bLEClient.bleLogger.minor("write failed");
                resumeWrite(false);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == 0) {
                BLEClient.this.bleLogger.major("gatt disconnected");
                BLEClient.this.disconnectedFromCallback = true;
                resumeConnect(false);
                return;
            }
            BLEClient bLEClient = BLEClient.this;
            if (newState == 2) {
                bLEClient.bleLogger.major("gatt connected");
                resumeConnect(true);
                return;
            }
            bLEClient.bleLogger.major("unknown connection state: " + newState);
            BLEClient.this.disconnectedFromCallback = true;
            resumeConnect(false);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            BLEClient bLEClient = BLEClient.this;
            if (status == 0) {
                bLEClient.bleLogger.minor("descriptor write succeeded");
                resumeWriteDescriptor(true);
            } else {
                bLEClient.bleLogger.minor("descriptor write failed");
                resumeWriteDescriptor(false);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
            BLEClient.this.bleLogger.major("MTU changed: mtu=" + mtu + ", status=" + status);
            resumeRequestMTU(mtu);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
            BLELogger bLELogger = BLEClient.this.bleLogger;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(txPhy, rxPhy, "Phy update: txPhy=", ", rxPhy=", ", status=");
            sbM.append(status);
            bLELogger.major(sbM.toString());
            resumeSetPreferredPhy(status == 0);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            gatt.getClass();
            BLEClient bLEClient = BLEClient.this;
            if (status != 0) {
                bLEClient.bleLogger.minor("services discovery failed");
                resumeServiceDiscovery(null);
            } else {
                bLEClient.bleLogger.minor("services discovered");
                List<BluetoothGattService> services = gatt.getServices();
                services.getClass();
                resumeServiceDiscovery(new GattServices(services));
            }
        }

        public final void resumeConnect(boolean result) {
            robustResume(this.connectContinuation, Boolean.valueOf(result));
            this.connectContinuation = null;
        }

        public final void resumeExpectedNotifications() {
            robustResume(this.expectedNotificationsContinuation, null);
            this.expectedNotificationsContinuation = null;
            this.expectedNotificationsConsumer = null;
            this.expectedNotificationsCharacteristic = null;
        }

        public final void resumeRead(byte[] result) {
            robustResume(this.readContinuation, result);
            this.readContinuation = null;
        }

        public final void resumeRequestMTU(int result) {
            robustResume(this.requestMtuContinuation, Integer.valueOf(result));
            this.requestMtuContinuation = null;
        }

        public final void resumeServiceDiscovery(GattServices result) {
            robustResume(this.serviceDiscoveryContinuation, result);
            this.serviceDiscoveryContinuation = null;
        }

        public final void resumeSetPreferredPhy(boolean result) {
            robustResume(this.setPreferredPhyContinuation, Boolean.valueOf(result));
            this.setPreferredPhyContinuation = null;
        }

        public final void resumeWrite(boolean result) {
            robustResume(this.writeContinuation, Boolean.valueOf(result));
            this.writeContinuation = null;
        }

        public final void resumeWriteDescriptor(boolean result) {
            robustResume(this.writeDescriptorContinuation, Boolean.valueOf(result));
            this.writeDescriptorContinuation = null;
        }

        public final <T> void robustResume(Continuation<? super T> cont, T value) {
            if (cont != null) {
                try {
                    cont.resumeWith(Result.m2357constructorimpl(value));
                } catch (IllegalStateException e) {
                    BLEClient.this.bleLogger.major("", e);
                }
            }
        }

        public final void setConnectContinuation(Continuation<? super Boolean> continuation) {
            this.connectContinuation = continuation;
        }

        public final void setExpectedNotificationsCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            this.expectedNotificationsCharacteristic = bluetoothGattCharacteristic;
        }

        public final void setExpectedNotificationsConsumer(DataConsumer dataConsumer) {
            this.expectedNotificationsConsumer = dataConsumer;
        }

        public final void setExpectedNotificationsContinuation(Continuation continuation) {
            this.expectedNotificationsContinuation = continuation;
        }

        public final void setReadContinuation(Continuation<? super byte[]> continuation) {
            this.readContinuation = continuation;
        }

        public final void setRequestMtuContinuation(Continuation<? super Integer> continuation) {
            this.requestMtuContinuation = continuation;
        }

        public final void setServiceDiscoveryContinuation(Continuation<? super GattServices> continuation) {
            this.serviceDiscoveryContinuation = continuation;
        }

        public final void setSetPreferredPhyContinuation(Continuation<? super Boolean> continuation) {
            this.setPreferredPhyContinuation = continuation;
        }

        public final void setWriteContinuation(Continuation<? super Boolean> continuation) {
            this.writeContinuation = continuation;
        }

        public final void setWriteDescriptorContinuation(Continuation<? super Boolean> continuation) {
            this.writeDescriptorContinuation = continuation;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$connect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {557}, m = "connect", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.connect(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$disconnectSync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {557}, m = "disconnectSync", v = 2)
    public static final class C20871 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C20871(Continuation<? super C20871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.disconnectSync(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$discoverServices$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {562}, m = "discoverServices", v = 2)
    public static final class C20881 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C20881(Continuation<? super C20881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.discoverServices(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$getCharacteristic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {244}, m = "getCharacteristic", v = 2)
    public static final class C20891 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20891(Continuation<? super C20891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.getCharacteristic(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$read$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {561}, m = "read", v = 2)
    public static final class C20901 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C20901(Continuation<? super C20901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.read(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$requestMTU$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {562}, m = "requestMTU", v = 2)
    public static final class C20911 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C20911(Continuation<? super C20911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.requestMTU(0, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$setPreferredPhy2M$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {561}, m = "setPreferredPhy2M", v = 2)
    public static final class C20921 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C20921(Continuation<? super C20921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.setPreferredPhy2M(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$write$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {562}, m = "write", v = 2)
    public static final class C20931 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C20931(Continuation<? super C20931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.write(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$writeAndCollectNotifications$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {557}, m = "writeAndCollectNotifications", v = 2)
    public static final class C20941 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C20941(Continuation<? super C20941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.writeAndCollectNotifications(null, null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEClient$writeDescriptor$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient", f = "BLEClient.kt", l = {561}, m = "writeDescriptor", v = 2)
    public static final class C20951 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C20951(Continuation<? super C20951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEClient.this.writeDescriptor(null, 0L, this);
        }
    }

    public BLEClient(Context context, BluetoothDevice bluetoothDevice) {
        context.getClass();
        bluetoothDevice.getClass();
        this.context = context;
        this.btDevice = bluetoothDevice;
        this.CCC_DESCRIPTOR_ID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.bleLogger = new BLELogger();
        this.gattCallback = new GattCallback();
        this.maxReadWriteFailures = 5;
        this.maxFailuresCountReachedTime = -1L;
        this.characteristicChangeListeners = new CopyOnWriteArrayList();
    }

    private final void doGattClose(BluetoothGatt gatt) {
        if (gatt != null) {
            try {
                gatt.close();
            } catch (RuntimeException e) {
                this.bleLogger.minor("doGattClose", e);
            }
        }
    }

    private final void generateErrorReportIfNecessary() {
        if (this.maxFailuresCountReachedTime <= 0 || System.currentTimeMillis() - this.maxFailuresCountReachedTime <= AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED) {
            return;
        }
        this.maxFailuresCountReachedTime = -1L;
        ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "The strange SleepPhaser error. Assign this report to Jan Marek.", 5);
    }

    private final void handleReadWriteFailure() {
        this.numberOfFailuresSinceConnect++;
        if (this.numberOfFailuresSinceConnect == this.maxReadWriteFailures) {
            this.maxFailuresCountReachedTime = System.currentTimeMillis();
        }
    }

    private final void reset() {
        this.gatt = null;
        this.disconnectedFromCallback = false;
        this.numberOfFailuresSinceConnect = 0;
        this.gattServices = null;
    }

    public final void addCharacteristicChangeListener(Function1<? super BluetoothGattCharacteristic, Unit> listener) {
        listener.getClass();
        this.characteristicChangeListeners.add(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connect(long j, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objWithTimeout = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                if (isConnected()) {
                    return Unit.INSTANCE;
                }
                generateErrorReportIfNecessary();
                disconnectAsync();
                this.bleLogger.major("Connecting to gatt");
                BLEClient$connect$$inlined$suspendCoroutineWithTimeout$1 bLEClient$connect$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$connect$$inlined$suspendCoroutineWithTimeout$1(null, this);
                anonymousClass1.J$0 = j;
                anonymousClass1.J$1 = j;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$connect$$inlined$suspendCoroutineWithTimeout$1, anonymousClass1);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
            }
            if (!((Boolean) objWithTimeout).booleanValue()) {
                throw new BluetoothException("Connect failed");
            }
            this.bleLogger.major("Connected");
            return Unit.INSTANCE;
        } catch (TimeoutCancellationException unused) {
            disconnectAsync();
            Events$$ExternalSyntheticBUOutline0.m("Connect timed out");
            return null;
        } catch (RuntimeException e) {
            disconnectAsync();
            throw e;
        }
    }

    public final void disconnectAsync() {
        try {
            this.bleLogger.major("disconnectAsync");
            try {
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt != null) {
                    bluetoothGatt.disconnect();
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                doGattClose(this.gatt);
            }
        } finally {
            reset();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.urbandroid.sleep.bluetoothle.BLEClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.bluetooth.BluetoothGatt] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.bluetooth.BluetoothGatt] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object disconnectSync(long j, Continuation<? super Unit> continuation) {
        C20871 c20871;
        BluetoothGatt bluetoothGatt;
        BLEClient$disconnectSync$$inlined$suspendCoroutineWithTimeout$1 bLEClient$disconnectSync$$inlined$suspendCoroutineWithTimeout$1;
        ?? r9;
        if (continuation instanceof C20871) {
            c20871 = (C20871) continuation;
            int i = c20871.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20871.label = i - Integer.MIN_VALUE;
            } else {
                c20871 = new C20871(continuation);
            }
        }
        Object obj = c20871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20871.label;
        try {
            try {
                if (i2 != 0) {
                    if (i2 != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bluetoothGatt = (BluetoothGatt) c20871.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        j = bluetoothGatt;
                    } catch (TimeoutCancellationException unused) {
                        this.bleLogger.major("disconnectSync timeout");
                        Unit unit = Unit.INSTANCE;
                        j = bluetoothGatt;
                    }
                    r9 = j;
                    doGattClose(r9);
                    reset();
                    this.bleLogger.major("disconnectSync end");
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.bleLogger.major("disconnectSync start");
                BluetoothGatt bluetoothGatt2 = this.gatt;
                if (bluetoothGatt2 != null) {
                    try {
                        if (this.disconnectedFromCallback) {
                            bluetoothGatt2.disconnect();
                            r9 = bluetoothGatt2;
                            doGattClose(r9);
                        } else {
                            try {
                                bLEClient$disconnectSync$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$disconnectSync$$inlined$suspendCoroutineWithTimeout$1(null, this, bluetoothGatt2);
                                c20871.L$0 = bluetoothGatt2;
                                c20871.J$0 = j;
                                c20871.J$1 = j;
                                c20871.I$0 = 0;
                                c20871.label = 1;
                            } catch (TimeoutCancellationException unused2) {
                                bluetoothGatt = bluetoothGatt2;
                                this.bleLogger.major("disconnectSync timeout");
                                Unit unit2 = Unit.INSTANCE;
                                j = bluetoothGatt;
                            }
                            if (TimeoutKt.withTimeout(j, bLEClient$disconnectSync$$inlined$suspendCoroutineWithTimeout$1, c20871) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j = bluetoothGatt2;
                            r9 = j;
                            doGattClose(r9);
                        }
                    } catch (Throwable th) {
                        th = th;
                        j = bluetoothGatt2;
                        doGattClose(j);
                        throw th;
                    }
                }
                reset();
                this.bleLogger.major("disconnectSync end");
                return Unit.INSTANCE;
                this.bleLogger.major("disconnectSync timeout");
                Unit unit22 = Unit.INSTANCE;
                j = bluetoothGatt;
                r9 = j;
                doGattClose(r9);
                reset();
                this.bleLogger.major("disconnectSync end");
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            reset();
            this.bleLogger.major("disconnectSync end");
            throw th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object discoverServices(long j, Continuation<? super GattServices> continuation) {
        C20881 c20881;
        if (continuation instanceof C20881) {
            c20881 = (C20881) continuation;
            int i = c20881.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20881.label = i - Integer.MIN_VALUE;
            } else {
                c20881 = new C20881(continuation);
            }
        }
        Object objWithTimeout = c20881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20881.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                if (!isConnected()) {
                    Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
                    return null;
                }
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return null;
                }
                generateErrorReportIfNecessary();
                GattServices gattServices = this.gattServices;
                if (gattServices != null) {
                    return gattServices;
                }
                this.bleLogger.major("Discovering services");
                BLEClient$discoverServices$lambda$0$$inlined$suspendCoroutineWithTimeout$1 bLEClient$discoverServices$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$discoverServices$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, this, bluetoothGatt);
                c20881.L$0 = SpillingKt.nullOutSpilledVariable(this);
                c20881.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothGatt);
                c20881.L$2 = SpillingKt.nullOutSpilledVariable(c20881);
                c20881.J$0 = j;
                c20881.I$0 = 0;
                c20881.I$1 = 0;
                c20881.J$1 = j;
                c20881.I$2 = 0;
                c20881.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$discoverServices$lambda$0$$inlined$suspendCoroutineWithTimeout$1, c20881);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
            }
            GattServices gattServices2 = (GattServices) objWithTimeout;
            this.gattServices = gattServices2;
            if (gattServices2 != null) {
                return gattServices2;
            }
            throw new BluetoothException("Service discovery failed");
        } catch (BluetoothException e) {
            handleReadWriteFailure();
            throw e;
        } catch (TimeoutCancellationException unused) {
            handleReadWriteFailure();
            Events$$ExternalSyntheticBUOutline0.m("Service discovery timed out");
            return null;
        }
    }

    public final void endLogFile() {
        this.bleLogger.endLogFile();
    }

    public final BluetoothDevice getBtDevice() {
        return this.btDevice;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCharacteristic(UUID uuid, UUID uuid2, long j, Continuation<? super BluetoothGattCharacteristic> continuation) {
        C20891 c20891;
        if (continuation instanceof C20891) {
            c20891 = (C20891) continuation;
            int i = c20891.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20891.label = i - Integer.MIN_VALUE;
            } else {
                c20891 = new C20891(continuation);
            }
        }
        Object objDiscoverServices = c20891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20891.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objDiscoverServices);
            c20891.L$0 = uuid;
            c20891.L$1 = uuid2;
            c20891.J$0 = j;
            c20891.label = 1;
            objDiscoverServices = discoverServices(j, c20891);
            if (objDiscoverServices == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            uuid2 = (UUID) c20891.L$1;
            uuid = (UUID) c20891.L$0;
            ResultKt.throwOnFailure(objDiscoverServices);
        }
        BluetoothGattCharacteristic characteristic = ((GattServices) objDiscoverServices).getCharacteristic(uuid, uuid2);
        if (characteristic != null) {
            return characteristic;
        }
        throw new BluetoothException("Characteristic not found: " + uuid + ", " + uuid2);
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isConnected() {
        return (this.gatt == null || this.disconnectedFromCallback || this.numberOfFailuresSinceConnect >= this.maxReadWriteFailures) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object read(BluetoothGattCharacteristic bluetoothGattCharacteristic, long j, Continuation<? super byte[]> continuation) {
        C20901 c20901;
        if (continuation instanceof C20901) {
            c20901 = (C20901) continuation;
            int i = c20901.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20901.label = i - Integer.MIN_VALUE;
            } else {
                c20901 = new C20901(continuation);
            }
        }
        Object objWithTimeout = c20901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20901.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                if (!isConnected()) {
                    Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
                    return null;
                }
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return null;
                }
                generateErrorReportIfNecessary();
                this.bleLogger.minor("Reading");
                BLEClient$read$lambda$0$$inlined$suspendCoroutineWithTimeout$1 bLEClient$read$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$read$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, this, bluetoothGatt, bluetoothGattCharacteristic);
                c20901.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
                c20901.L$1 = SpillingKt.nullOutSpilledVariable(this);
                c20901.L$2 = SpillingKt.nullOutSpilledVariable(bluetoothGatt);
                c20901.L$3 = SpillingKt.nullOutSpilledVariable(c20901);
                c20901.J$0 = j;
                c20901.I$0 = 0;
                c20901.I$1 = 0;
                c20901.J$1 = j;
                c20901.I$2 = 0;
                c20901.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$read$lambda$0$$inlined$suspendCoroutineWithTimeout$1, c20901);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
            }
            byte[] bArr = (byte[]) objWithTimeout;
            if (bArr != null) {
                return bArr;
            }
            throw new BluetoothException("Read failed");
        } catch (BluetoothException e) {
            handleReadWriteFailure();
            throw e;
        } catch (TimeoutCancellationException unused) {
            handleReadWriteFailure();
            Events$$ExternalSyntheticBUOutline0.m("Read timed out");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestMTU(int i, long j, Continuation<? super Integer> continuation) {
        C20911 c20911;
        if (continuation instanceof C20911) {
            c20911 = (C20911) continuation;
            int i2 = c20911.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c20911.label = i2 - Integer.MIN_VALUE;
            } else {
                c20911 = new C20911(continuation);
            }
        }
        Object objWithTimeout = c20911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c20911.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                if (!isConnected()) {
                    Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
                    return null;
                }
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return null;
                }
                if (i <= 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(i, "Invalid MTU: "));
                    return null;
                }
                generateErrorReportIfNecessary();
                this.bleLogger.major("Requesting MTU: " + i);
                BLEClient$requestMTU$lambda$0$$inlined$suspendCoroutineWithTimeout$1 bLEClient$requestMTU$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$requestMTU$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, this, bluetoothGatt, i);
                c20911.L$0 = SpillingKt.nullOutSpilledVariable(this);
                c20911.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothGatt);
                c20911.L$2 = SpillingKt.nullOutSpilledVariable(c20911);
                c20911.I$0 = i;
                c20911.J$0 = j;
                c20911.I$1 = 0;
                c20911.I$2 = 0;
                c20911.J$1 = j;
                c20911.I$3 = 0;
                c20911.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$requestMTU$lambda$0$$inlined$suspendCoroutineWithTimeout$1, c20911);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
            }
            return Boxing.boxInt(((Number) objWithTimeout).intValue());
        } catch (TimeoutCancellationException unused) {
            Events$$ExternalSyntheticBUOutline0.m("Request MTU timed out");
            return null;
        }
    }

    public final Object setIndicationEnabled(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, long j, Continuation<? super Unit> continuation) {
        if (!isConnected()) {
            Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
            return null;
        }
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            Events$$ExternalSyntheticBUOutline0.m("setIndicationEnabled failed");
            return null;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(this.CCC_DESCRIPTOR_ID);
        descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        Object objWriteDescriptor = writeDescriptor(descriptor, j, continuation);
        return objWriteDescriptor == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteDescriptor : Unit.INSTANCE;
    }

    public final Object setNotificationEnabled(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, long j, Continuation<? super Unit> continuation) {
        if (!isConnected()) {
            Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
            return null;
        }
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            Events$$ExternalSyntheticBUOutline0.m("setNotificationEnabled failed");
            return null;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(this.CCC_DESCRIPTOR_ID);
        descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        Object objWriteDescriptor = writeDescriptor(descriptor, j, continuation);
        return objWriteDescriptor == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteDescriptor : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setPreferredPhy2M(long j, Continuation<? super Unit> continuation) {
        C20921 c20921;
        if (continuation instanceof C20921) {
            c20921 = (C20921) continuation;
            int i = c20921.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20921.label = i - Integer.MIN_VALUE;
            } else {
                c20921 = new C20921(continuation);
            }
        }
        Object objWithTimeout = c20921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20921.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                if (Build.VERSION.SDK_INT >= 26) {
                    if (!isConnected()) {
                        Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
                        return null;
                    }
                    BluetoothGatt bluetoothGatt = this.gatt;
                    if (bluetoothGatt == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    this.bleLogger.major("Setting preferred Phy");
                    BLEClient$setPreferredPhy2M$lambda$0$$inlined$suspendCoroutineWithTimeout$1 bLEClient$setPreferredPhy2M$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$setPreferredPhy2M$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, this, bluetoothGatt);
                    c20921.L$0 = SpillingKt.nullOutSpilledVariable(this);
                    c20921.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothGatt);
                    c20921.L$2 = SpillingKt.nullOutSpilledVariable(c20921);
                    c20921.J$0 = j;
                    c20921.I$0 = 0;
                    c20921.I$1 = 0;
                    c20921.J$1 = j;
                    c20921.I$2 = 0;
                    c20921.label = 1;
                    objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$setPreferredPhy2M$lambda$0$$inlined$suspendCoroutineWithTimeout$1, c20921);
                    if (objWithTimeout == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithTimeout);
            ((Boolean) objWithTimeout).getClass();
            return Unit.INSTANCE;
        } catch (TimeoutCancellationException unused) {
            Events$$ExternalSyntheticBUOutline0.m("Set preferred Phy timed out");
            return null;
        }
    }

    public final void startLogFile() {
        this.bleLogger.startLogFile();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object write(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, long j, Continuation<? super Unit> continuation) {
        C20931 c20931;
        if (continuation instanceof C20931) {
            c20931 = (C20931) continuation;
            int i = c20931.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20931.label = i - Integer.MIN_VALUE;
            } else {
                c20931 = new C20931(continuation);
            }
        }
        C20931 c209312 = c20931;
        Object objWithTimeout = c209312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c209312.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                if (!isConnected()) {
                    Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
                    return null;
                }
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return null;
                }
                if (bArr.length > 20) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(bArr.length, "Too long input (>20): "));
                    return null;
                }
                generateErrorReportIfNecessary();
                this.bleLogger.minor("Writing: ", bArr);
                BLEClient$write$lambda$0$$inlined$suspendCoroutineWithTimeout$1 bLEClient$write$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$write$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, this, bluetoothGattCharacteristic, bArr, bluetoothGatt);
                c209312.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
                c209312.L$1 = SpillingKt.nullOutSpilledVariable(bArr);
                c209312.L$2 = SpillingKt.nullOutSpilledVariable(this);
                c209312.L$3 = SpillingKt.nullOutSpilledVariable(bluetoothGatt);
                c209312.L$4 = SpillingKt.nullOutSpilledVariable(c209312);
                c209312.J$0 = j;
                c209312.I$0 = 0;
                c209312.I$1 = 0;
                c209312.J$1 = j;
                c209312.I$2 = 0;
                c209312.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$write$lambda$0$$inlined$suspendCoroutineWithTimeout$1, c209312);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
            }
            if (((Boolean) objWithTimeout).booleanValue()) {
                return Unit.INSTANCE;
            }
            throw new BluetoothException("Write failed");
        } catch (BluetoothException e) {
            handleReadWriteFailure();
            throw e;
        } catch (TimeoutCancellationException unused) {
            handleReadWriteFailure();
            Events$$ExternalSyntheticBUOutline0.m("Write timed out");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeAndCollectNotifications(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, DataConsumer dataConsumer, long j, Continuation<? super Unit> continuation) {
        C20941 c20941;
        DataConsumer dataConsumer2;
        Ref$BooleanRef ref$BooleanRef;
        DataConsumer dataConsumer3;
        if (continuation instanceof C20941) {
            c20941 = (C20941) continuation;
            int i = c20941.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20941.label = i - Integer.MIN_VALUE;
            } else {
                c20941 = new C20941(continuation);
            }
        }
        C20941 c209412 = c20941;
        Object objWithTimeout = c209412.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c209412.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithTimeout);
            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            try {
                this.bleLogger.minor("writeAndCollectNotifications");
                dataConsumer2 = dataConsumer;
            } catch (TimeoutCancellationException unused) {
                dataConsumer2 = dataConsumer;
            }
            try {
                BLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1 bLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1(null, this, dataConsumer2, bluetoothGattCharacteristic, ref$BooleanRef2, bArr, j);
                c209412.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
                c209412.L$1 = SpillingKt.nullOutSpilledVariable(bArr);
                dataConsumer2 = dataConsumer;
                c209412.L$2 = dataConsumer2;
                c209412.L$3 = ref$BooleanRef2;
                c209412.J$0 = j;
                c209412.J$1 = j;
                c209412.I$0 = 0;
                c209412.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1, c209412);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dataConsumer3 = dataConsumer2;
                ref$BooleanRef = ref$BooleanRef2;
            } catch (TimeoutCancellationException unused2) {
                ref$BooleanRef = ref$BooleanRef2;
                if (!ref$BooleanRef.element) {
                }
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$BooleanRef = (Ref$BooleanRef) c209412.L$3;
            dataConsumer3 = (DataConsumer) c209412.L$2;
            try {
                ResultKt.throwOnFailure(objWithTimeout);
            } catch (TimeoutCancellationException unused3) {
                dataConsumer2 = dataConsumer3;
                if (!ref$BooleanRef.element) {
                    throw new NotificationsNotReceivedException(FileInsert$$ExternalSyntheticOutline0.m("Expected notifications not received. ", dataConsumer2.getInfo()));
                }
                Events$$ExternalSyntheticBUOutline0.m("writeAndCollectNotifications timed out");
                return null;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, long j, Continuation<? super Unit> continuation) {
        C20951 c20951;
        if (continuation instanceof C20951) {
            c20951 = (C20951) continuation;
            int i = c20951.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20951.label = i - Integer.MIN_VALUE;
            } else {
                c20951 = new C20951(continuation);
            }
        }
        Object objWithTimeout = c20951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20951.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                if (!isConnected()) {
                    Events$$ExternalSyntheticBUOutline0.m("Disconnected.");
                    return null;
                }
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return null;
                }
                generateErrorReportIfNecessary();
                this.bleLogger.major("Writing descriptor");
                BLEClient$writeDescriptor$lambda$0$$inlined$suspendCoroutineWithTimeout$1 bLEClient$writeDescriptor$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new BLEClient$writeDescriptor$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, this, bluetoothGatt, bluetoothGattDescriptor);
                c20951.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattDescriptor);
                c20951.L$1 = SpillingKt.nullOutSpilledVariable(this);
                c20951.L$2 = SpillingKt.nullOutSpilledVariable(bluetoothGatt);
                c20951.L$3 = SpillingKt.nullOutSpilledVariable(c20951);
                c20951.J$0 = j;
                c20951.I$0 = 0;
                c20951.I$1 = 0;
                c20951.J$1 = j;
                c20951.I$2 = 0;
                c20951.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, bLEClient$writeDescriptor$lambda$0$$inlined$suspendCoroutineWithTimeout$1, c20951);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
            }
            if (((Boolean) objWithTimeout).booleanValue()) {
                return Unit.INSTANCE;
            }
            throw new BluetoothException("Write descriptor failed");
        } catch (BluetoothException e) {
            handleReadWriteFailure();
            throw e;
        } catch (TimeoutCancellationException unused) {
            handleReadWriteFailure();
            Events$$ExternalSyntheticBUOutline0.m("Write descriptor timed out");
            return null;
        }
    }
}
