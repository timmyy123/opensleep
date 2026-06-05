package com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection;

import com.facebook.internal.ServerProtocol;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.common.ble.BleUtils;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.mp4parser.boxes.iso14496.part12.FreeBox;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0003BCDB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J\u001f\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010!\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b!\u0010\u001fJ\u001d\u0010#\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0019¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b%\u0010\u001fJ\u0015\u0010&\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b&\u0010\u001fJ\u0015\u0010'\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b'\u0010\u001fJ\u0015\u0010(\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b(\u0010\u001fJ\u0015\u0010)\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b)\u0010\u001fJ\u0015\u0010*\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b*\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R(\u00101\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b1\u00102\u0012\u0004\b7\u00108\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?¨\u0006E"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler;", "", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionInterface;", "connectionInterface", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ScannerInterface;", "scannerInterface", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandlerObserver;", "observer", "<init>", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionInterface;Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ScannerInterface;Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandlerObserver;)V", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;", "bleDeviceSession", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerAction;", "action", "", "commandState", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerAction;)V", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerState;", "newState", "changeState", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerState;)V", "Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession$DeviceSessionState;", "updateSessionState", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;Lcom/polar/androidcommunications/api/ble/model/BleDeviceSession$DeviceSessionState;)V", "session", "", "containsRequiredUuids", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;)Z", FreeBox.TYPE, "connecting", "handleDisconnectDevice", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;)V", "handleDeviceDisconnected", "advertisementHeadReceived", "bluetoothEnabled", "connectDevice", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;Z)V", "disconnectDevice", "connectionInitialized", "phyUpdated", "servicesDiscovered", "mtuUpdated", "deviceDisconnected", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionInterface;", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ScannerInterface;", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandlerObserver;", "Lio/reactivex/rxjava3/core/Scheduler;", "guardTimerScheduler", "Lio/reactivex/rxjava3/core/Scheduler;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerState;", "getState", "()Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerState;", "setState", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerState;)V", "getState$annotations", "()V", "current", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceSessionImpl;", "automaticReconnection", "Z", "Lio/reactivex/rxjava3/disposables/Disposable;", "phySafeGuardDisposable", "Lio/reactivex/rxjava3/disposables/Disposable;", "mtuSafeGuardDisposable", "firstAttributeOperationDisposable", "Companion", "ConnectionHandlerAction", "ConnectionHandlerState", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConnectionHandler {
    private boolean automaticReconnection;
    private final ConnectionInterface connectionInterface;
    private BDDeviceSessionImpl current;
    private Disposable firstAttributeOperationDisposable;
    private Scheduler guardTimerScheduler;
    private Disposable mtuSafeGuardDisposable;
    private final ConnectionHandlerObserver observer;
    private Disposable phySafeGuardDisposable;
    private final ScannerInterface scannerInterface;
    private ConnectionHandlerState state;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerAction;", "", "(Ljava/lang/String;I)V", "ENTRY", "EXIT", "CONNECT_DEVICE", "ADVERTISEMENT_HEAD_RECEIVED", "DISCONNECT_DEVICE", "DEVICE_DISCONNECTED", "DEVICE_CONNECTION_INITIALIZED", "PHY_UPDATED", "SERVICES_DISCOVERED", "MTU_UPDATED", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConnectionHandlerAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConnectionHandlerAction[] $VALUES;
        public static final ConnectionHandlerAction ENTRY = new ConnectionHandlerAction("ENTRY", 0);
        public static final ConnectionHandlerAction EXIT = new ConnectionHandlerAction("EXIT", 1);
        public static final ConnectionHandlerAction CONNECT_DEVICE = new ConnectionHandlerAction("CONNECT_DEVICE", 2);
        public static final ConnectionHandlerAction ADVERTISEMENT_HEAD_RECEIVED = new ConnectionHandlerAction("ADVERTISEMENT_HEAD_RECEIVED", 3);
        public static final ConnectionHandlerAction DISCONNECT_DEVICE = new ConnectionHandlerAction("DISCONNECT_DEVICE", 4);
        public static final ConnectionHandlerAction DEVICE_DISCONNECTED = new ConnectionHandlerAction("DEVICE_DISCONNECTED", 5);
        public static final ConnectionHandlerAction DEVICE_CONNECTION_INITIALIZED = new ConnectionHandlerAction("DEVICE_CONNECTION_INITIALIZED", 6);
        public static final ConnectionHandlerAction PHY_UPDATED = new ConnectionHandlerAction("PHY_UPDATED", 7);
        public static final ConnectionHandlerAction SERVICES_DISCOVERED = new ConnectionHandlerAction("SERVICES_DISCOVERED", 8);
        public static final ConnectionHandlerAction MTU_UPDATED = new ConnectionHandlerAction("MTU_UPDATED", 9);

        private static final /* synthetic */ ConnectionHandlerAction[] $values() {
            return new ConnectionHandlerAction[]{ENTRY, EXIT, CONNECT_DEVICE, ADVERTISEMENT_HEAD_RECEIVED, DISCONNECT_DEVICE, DEVICE_DISCONNECTED, DEVICE_CONNECTION_INITIALIZED, PHY_UPDATED, SERVICES_DISCOVERED, MTU_UPDATED};
        }

        static {
            ConnectionHandlerAction[] connectionHandlerActionArr$values = $values();
            $VALUES = connectionHandlerActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(connectionHandlerActionArr$values);
        }

        private ConnectionHandlerAction(String str, int i) {
        }

        public static ConnectionHandlerAction valueOf(String str) {
            return (ConnectionHandlerAction) Enum.valueOf(ConnectionHandlerAction.class, str);
        }

        public static ConnectionHandlerAction[] values() {
            return (ConnectionHandlerAction[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler$ConnectionHandlerState;", "", "(Ljava/lang/String;I)V", "FREE", "CONNECTING", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConnectionHandlerState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConnectionHandlerState[] $VALUES;
        public static final ConnectionHandlerState FREE = new ConnectionHandlerState("FREE", 0);
        public static final ConnectionHandlerState CONNECTING = new ConnectionHandlerState("CONNECTING", 1);

        private static final /* synthetic */ ConnectionHandlerState[] $values() {
            return new ConnectionHandlerState[]{FREE, CONNECTING};
        }

        static {
            ConnectionHandlerState[] connectionHandlerStateArr$values = $values();
            $VALUES = connectionHandlerStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(connectionHandlerStateArr$values);
        }

        private ConnectionHandlerState(String str, int i) {
        }

        public static ConnectionHandlerState valueOf(String str) {
            return (ConnectionHandlerState) Enum.valueOf(ConnectionHandlerState.class, str);
        }

        public static ConnectionHandlerState[] values() {
            return (ConnectionHandlerState[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[BleDeviceSession.DeviceSessionState.values().length];
            try {
                iArr[BleDeviceSession.DeviceSessionState.SESSION_CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleDeviceSession.DeviceSessionState.SESSION_CLOSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleDeviceSession.DeviceSessionState.SESSION_OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleDeviceSession.DeviceSessionState.SESSION_OPENING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConnectionHandlerState.values().length];
            try {
                iArr2[ConnectionHandlerState.FREE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ConnectionHandlerState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ConnectionHandlerAction.values().length];
            try {
                iArr3[ConnectionHandlerAction.ENTRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ConnectionHandlerAction.EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ConnectionHandlerAction.DEVICE_CONNECTION_INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ConnectionHandlerAction.PHY_UPDATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ConnectionHandlerAction.SERVICES_DISCOVERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ConnectionHandlerAction.MTU_UPDATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ConnectionHandlerAction.CONNECT_DEVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[ConnectionHandlerAction.ADVERTISEMENT_HEAD_RECEIVED.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[ConnectionHandlerAction.DISCONNECT_DEVICE.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[ConnectionHandlerAction.DEVICE_DISCONNECTED.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public ConnectionHandler(ConnectionInterface connectionInterface, ScannerInterface scannerInterface, ConnectionHandlerObserver connectionHandlerObserver) {
        connectionInterface.getClass();
        scannerInterface.getClass();
        connectionHandlerObserver.getClass();
        this.connectionInterface = connectionInterface;
        this.scannerInterface = scannerInterface;
        this.observer = connectionHandlerObserver;
        Scheduler schedulerComputation = Schedulers.computation();
        schedulerComputation.getClass();
        this.guardTimerScheduler = schedulerComputation;
        this.state = ConnectionHandlerState.FREE;
        this.automaticReconnection = true;
    }

    private final void changeState(BDDeviceSessionImpl bleDeviceSession, ConnectionHandlerState newState) {
        commandState(bleDeviceSession, ConnectionHandlerAction.EXIT);
        this.state = newState;
        commandState(bleDeviceSession, ConnectionHandlerAction.ENTRY);
    }

    private final void commandState(BDDeviceSessionImpl bleDeviceSession, ConnectionHandlerAction action) {
        int i = WhenMappings.$EnumSwitchMapping$1[this.state.ordinal()];
        if (i == 1) {
            free(bleDeviceSession, action);
            return;
        }
        if (i != 2) {
            return;
        }
        BleLogger.INSTANCE.d("ConnectionHandler", "state: " + this.state + " action: " + action);
        connecting(bleDeviceSession, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void connecting(final BDDeviceSessionImpl session, ConnectionHandlerAction action) {
        int i = WhenMappings.$EnumSwitchMapping$2[action.ordinal()];
        Object[] objArr = 0;
        final int i2 = 1;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        switch (i) {
            case 1:
                this.scannerInterface.connectionHandlerRequestStopScanning();
                if (!this.connectionInterface.isPowered()) {
                    BleLogger.INSTANCE.w("ConnectionHandler", "ble not powered exiting connecting state");
                    changeState(session, ConnectionHandlerState.FREE);
                } else {
                    this.current = session;
                    updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPENING);
                    this.connectionInterface.connectDevice(session);
                }
                break;
            case 2:
                this.scannerInterface.connectionHandlerResumeScanning();
                break;
            case 3:
                this.connectionInterface.startServiceDiscovery(session);
                break;
            case 4:
                Completable completableTimer = Completable.timer(2000L, timeUnit, this.guardTimerScheduler);
                final Object[] objArr2 = objArr == true ? 1 : 0;
                this.mtuSafeGuardDisposable = completableTimer.subscribe(new Action(this) { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandler$$ExternalSyntheticLambda0
                    public final /* synthetic */ ConnectionHandler f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // io.reactivex.rxjava3.functions.Action
                    public final void run() {
                        int i3 = objArr2;
                        BDDeviceSessionImpl bDDeviceSessionImpl = session;
                        ConnectionHandler connectionHandler = this.f$0;
                        switch (i3) {
                            case 0:
                                ConnectionHandler.connecting$lambda$0(connectionHandler, bDDeviceSessionImpl);
                                break;
                            default:
                                ConnectionHandler.connecting$lambda$2(connectionHandler, bDDeviceSessionImpl);
                                break;
                        }
                    }
                });
                this.connectionInterface.setMtu(session);
                break;
            case 5:
                this.phySafeGuardDisposable = Completable.timer(2000L, timeUnit, this.guardTimerScheduler).subscribe(new Action(this) { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandler$$ExternalSyntheticLambda0
                    public final /* synthetic */ ConnectionHandler f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // io.reactivex.rxjava3.functions.Action
                    public final void run() {
                        int i3 = i2;
                        BDDeviceSessionImpl bDDeviceSessionImpl = session;
                        ConnectionHandler connectionHandler = this.f$0;
                        switch (i3) {
                            case 0:
                                ConnectionHandler.connecting$lambda$0(connectionHandler, bDDeviceSessionImpl);
                                break;
                            default:
                                ConnectionHandler.connecting$lambda$2(connectionHandler, bDDeviceSessionImpl);
                                break;
                        }
                    }
                });
                this.connectionInterface.setPhy(session);
                break;
            case 6:
                BleUtils.validate(this.current == session, "incorrect session object");
                Disposable disposable = this.firstAttributeOperationDisposable;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.firstAttributeOperationDisposable = Completable.timer(500L, timeUnit).subscribe(new LoginFragment$$ExternalSyntheticLambda0(session, 20));
                updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPEN);
                changeState(session, ConnectionHandlerState.FREE);
                break;
            case 7:
                if (session.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_CLOSED) {
                    updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK);
                }
                break;
            case 9:
                if (!Intrinsics.areEqual(session, this.current)) {
                    handleDisconnectDevice(session);
                } else {
                    this.connectionInterface.cancelDeviceConnection(session);
                    this.observer.deviceConnectionCancelled(session);
                    updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_CLOSED);
                    changeState(session, ConnectionHandlerState.FREE);
                }
                break;
            case 10:
                if (this.current != session) {
                    handleDeviceDisconnected(session);
                } else {
                    updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK);
                    changeState(session, ConnectionHandlerState.FREE);
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connecting$lambda$0(ConnectionHandler connectionHandler, BDDeviceSessionImpl bDDeviceSessionImpl) {
        connectionHandler.getClass();
        bDDeviceSessionImpl.getClass();
        connectionHandler.mtuUpdated(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connecting$lambda$1(BDDeviceSessionImpl bDDeviceSessionImpl) {
        bDDeviceSessionImpl.getClass();
        bDDeviceSessionImpl.processNextAttributeOperation(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connecting$lambda$2(ConnectionHandler connectionHandler, BDDeviceSessionImpl bDDeviceSessionImpl) {
        connectionHandler.getClass();
        bDDeviceSessionImpl.getClass();
        connectionHandler.phyUpdated(bDDeviceSessionImpl);
    }

    private final boolean containsRequiredUuids(BDDeviceSessionImpl session) {
        List<String> connectionUuids = session.getConnectionUuids();
        connectionUuids.getClass();
        if (connectionUuids.isEmpty()) {
            return true;
        }
        HashMap<BleUtils.AD_TYPE, byte[]> map = session.getAdvertisementContent().advertisementData;
        BleUtils.AD_TYPE ad_type = BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_MORE;
        if (map.containsKey(ad_type) || map.containsKey(BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_COMPLETE)) {
            if (!map.containsKey(ad_type)) {
                ad_type = BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_COMPLETE;
            }
            byte[] bArr = map.get(ad_type);
            int i = 0;
            while (true) {
                bArr.getClass();
                if (i >= bArr.length) {
                    break;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                if (session.getConnectionUuids().contains(String.format("%02X%02X", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i + 1]), Byte.valueOf(bArr[i])}, 2)))) {
                    return true;
                }
                i += 2;
            }
        }
        return false;
    }

    private final void free(BDDeviceSessionImpl session, ConnectionHandlerAction action) {
        switch (WhenMappings.$EnumSwitchMapping$2[action.ordinal()]) {
            case 3:
            case 4:
            case 5:
            case 6:
                BleLogger.INSTANCE.d("ConnectionHandler", "Action " + action + " in free state.");
                break;
            case 7:
                int i = WhenMappings.$EnumSwitchMapping$0[session.getSessionState().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK);
                        break;
                    } else if (i != 3) {
                        if (i == 4) {
                            updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPEN);
                            break;
                        }
                    }
                }
                if (session.isConnectableAdvertisement() && containsRequiredUuids(session)) {
                    changeState(session, ConnectionHandlerState.CONNECTING);
                } else {
                    updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK);
                }
                break;
            case 8:
                if (session.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK) {
                    if (session.isConnectableAdvertisement() && containsRequiredUuids(session)) {
                        changeState(session, ConnectionHandlerState.CONNECTING);
                    } else {
                        BleLogger.INSTANCE.d("ConnectionHandler", "Skipped connection attempt due to reason device is not in connectable advertisement or missing service");
                    }
                }
                break;
            case 9:
                handleDisconnectDevice(session);
                break;
            case 10:
                handleDeviceDisconnected(session);
                break;
        }
    }

    private final void handleDeviceDisconnected(BDDeviceSessionImpl session) {
        int i = WhenMappings.$EnumSwitchMapping$0[session.getSessionState().ordinal()];
        if (i == 2) {
            updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_CLOSED);
        } else {
            if (i != 4) {
                return;
            }
            if (this.automaticReconnection) {
                updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK);
            } else {
                updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_CLOSED);
            }
        }
    }

    private final void handleDisconnectDevice(BDDeviceSessionImpl session) {
        int i = WhenMappings.$EnumSwitchMapping$0[session.getSessionState().ordinal()];
        if (i == 3) {
            updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_CLOSED);
        } else {
            if (i != 4) {
                return;
            }
            updateSessionState(session, BleDeviceSession.DeviceSessionState.SESSION_CLOSING);
            this.connectionInterface.disconnectDevice(session);
        }
    }

    private final void updateSessionState(BDDeviceSessionImpl bleDeviceSession, BleDeviceSession.DeviceSessionState newState) {
        BleLogger.INSTANCE.d("ConnectionHandler", " Session update from: " + bleDeviceSession.getSessionState() + " to: " + newState);
        bleDeviceSession.setSessionState(newState);
        this.observer.deviceSessionStateChanged(bleDeviceSession);
    }

    public final void advertisementHeadReceived(BDDeviceSessionImpl bleDeviceSession) {
        bleDeviceSession.getClass();
        commandState(bleDeviceSession, ConnectionHandlerAction.ADVERTISEMENT_HEAD_RECEIVED);
    }

    public final void connectDevice(BDDeviceSessionImpl bleDeviceSession, boolean bluetoothEnabled) {
        bleDeviceSession.getClass();
        if (bluetoothEnabled) {
            commandState(bleDeviceSession, ConnectionHandlerAction.CONNECT_DEVICE);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[bleDeviceSession.getSessionState().ordinal()];
        if (i == 1 || i == 2) {
            updateSessionState(bleDeviceSession, BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK);
        }
    }

    public final void connectionInitialized(BDDeviceSessionImpl bleDeviceSession) {
        bleDeviceSession.getClass();
        commandState(bleDeviceSession, ConnectionHandlerAction.DEVICE_CONNECTION_INITIALIZED);
    }

    public final void deviceDisconnected(BDDeviceSessionImpl bleDeviceSession) {
        bleDeviceSession.getClass();
        this.observer.deviceDisconnected(bleDeviceSession);
        commandState(bleDeviceSession, ConnectionHandlerAction.DEVICE_DISCONNECTED);
    }

    public final void disconnectDevice(BDDeviceSessionImpl bleDeviceSession) {
        bleDeviceSession.getClass();
        commandState(bleDeviceSession, ConnectionHandlerAction.DISCONNECT_DEVICE);
    }

    public final void mtuUpdated(BDDeviceSessionImpl bleDeviceSession) {
        bleDeviceSession.getClass();
        Disposable disposable = this.mtuSafeGuardDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        commandState(bleDeviceSession, ConnectionHandlerAction.MTU_UPDATED);
    }

    public final void phyUpdated(BDDeviceSessionImpl bleDeviceSession) {
        bleDeviceSession.getClass();
        Disposable disposable = this.phySafeGuardDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        commandState(bleDeviceSession, ConnectionHandlerAction.PHY_UPDATED);
    }

    public final void servicesDiscovered(BDDeviceSessionImpl bleDeviceSession) {
        bleDeviceSession.getClass();
        commandState(bleDeviceSession, ConnectionHandlerAction.SERVICES_DISCOVERED);
    }
}
