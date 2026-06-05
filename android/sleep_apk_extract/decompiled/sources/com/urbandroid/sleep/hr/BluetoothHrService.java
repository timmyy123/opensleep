package com.urbandroid.sleep.hr;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.hr.BluetoothHrService;
import com.urbandroid.sleep.hr.Capabilities;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.sensor.extra.RRIntervalsDataProducer;
import com.urbandroid.sleep.sensor.extra.Spo2DataProducer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/BluetoothHrService;", "Lcom/urbandroid/common/FeatureLogger;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BluetoothHrService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static AutoDetectClient hrClient;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/hr/BluetoothHrService$Companion;", "", "<init>", "()V", "ACTION_BT_UI_START", "", "ACTION_BT_UI_END", "ACTION_BT_UI_DEVICE", "EXTRA_DEVICE", "hrClient", "Lcom/urbandroid/sleep/hr/AutoDetectClient;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "stop", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit start$lambda$0(Context context, float f, long j) {
            HrDataProducer.INSTANCE.produce(context, f, j);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit start$lambda$1(Context context, float f, long j) {
            RRIntervalsDataProducer.INSTANCE.produce(context, f, j);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit start$lambda$2(Context context, float f, long j) {
            Spo2DataProducer.INSTANCE.produce(context, f, j);
            return Unit.INSTANCE;
        }

        public final synchronized void start(final Context context) {
            context.getClass();
            if (BluetoothHrService.hrClient != null) {
                Logger.logInfo("Already started.", null);
                return;
            }
            Settings settings = SharedApplicationContext.getSettings();
            if (Environment.isJellyBean43OrGreater() && (settings.isHrBt() || settings.isOximeter())) {
                String bleHrDeviceAddress = settings.getBleHrDeviceAddress();
                if (bleHrDeviceAddress != null && bleHrDeviceAddress.length() != 0) {
                    if (settings.isDirectBleWearableSelectedForTracking() && Intrinsics.areEqual(bleHrDeviceAddress, settings.getBleTrackingDeviceAddress())) {
                        Logger.logInfo("The BLE same device is selected for sleep tracking. BluetoothHrService will not be started, HR tracking will be performed in BleSmartWatch.", null);
                        return;
                    }
                    Logger.logInfo("start", null);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.urbandroid.sleep.ACTION_BT_UI_START"));
                    BluetoothHrService.hrClient = new AutoDetectClient(context, bleHrDeviceAddress);
                    AutoDetectClient autoDetectClient = BluetoothHrService.hrClient;
                    autoDetectClient.getClass();
                    Capabilities.Companion companion = Capabilities.INSTANCE;
                    final int i = 0;
                    autoDetectClient.subscribe(companion.getHR(), new Function2() { // from class: com.urbandroid.sleep.hr.BluetoothHrService$Companion$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            int i2 = i;
                            float fFloatValue = ((Float) obj).floatValue();
                            Long l = (Long) obj2;
                            switch (i2) {
                                case 0:
                                    return BluetoothHrService.Companion.start$lambda$0(context, fFloatValue, l.longValue());
                                case 1:
                                    return BluetoothHrService.Companion.start$lambda$1(context, fFloatValue, l.longValue());
                                default:
                                    return BluetoothHrService.Companion.start$lambda$2(context, fFloatValue, l.longValue());
                            }
                        }
                    });
                    if (settings.isDirectBleWearableSelectedForTracking()) {
                        Logger.logInfo("Another BLE device is selected for sleep tracking. Disabling RR stream in BluetoothHrService.", null);
                    } else {
                        AutoDetectClient autoDetectClient2 = BluetoothHrService.hrClient;
                        autoDetectClient2.getClass();
                        final int i2 = 1;
                        autoDetectClient2.subscribe(companion.getRR(), new Function2() { // from class: com.urbandroid.sleep.hr.BluetoothHrService$Companion$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                int i22 = i2;
                                float fFloatValue = ((Float) obj).floatValue();
                                Long l = (Long) obj2;
                                switch (i22) {
                                    case 0:
                                        return BluetoothHrService.Companion.start$lambda$0(context, fFloatValue, l.longValue());
                                    case 1:
                                        return BluetoothHrService.Companion.start$lambda$1(context, fFloatValue, l.longValue());
                                    default:
                                        return BluetoothHrService.Companion.start$lambda$2(context, fFloatValue, l.longValue());
                                }
                            }
                        });
                    }
                    AutoDetectClient autoDetectClient3 = BluetoothHrService.hrClient;
                    autoDetectClient3.getClass();
                    SPO2Capability spo2 = companion.getSPO2();
                    final int i3 = 2;
                    autoDetectClient3.subscribe(spo2, new Function2() { // from class: com.urbandroid.sleep.hr.BluetoothHrService$Companion$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            int i22 = i3;
                            float fFloatValue = ((Float) obj).floatValue();
                            Long l = (Long) obj2;
                            switch (i22) {
                                case 0:
                                    return BluetoothHrService.Companion.start$lambda$0(context, fFloatValue, l.longValue());
                                case 1:
                                    return BluetoothHrService.Companion.start$lambda$1(context, fFloatValue, l.longValue());
                                default:
                                    return BluetoothHrService.Companion.start$lambda$2(context, fFloatValue, l.longValue());
                            }
                        }
                    });
                }
                Logger.logSevere("HR or oximeter tracking is turned on, but no device is stored in the settings. HR tracking will not be started.", null);
            }
        }

        public final synchronized void stop(Context context) {
            try {
                context.getClass();
                Logger.logInfo("stop", null);
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.urbandroid.sleep.ACTION_BT_UI_END"));
                AutoDetectClient autoDetectClient = BluetoothHrService.hrClient;
                if (autoDetectClient != null) {
                    autoDetectClient.stop();
                }
                BluetoothHrService.hrClient = null;
            } catch (Throwable th) {
                throw th;
            }
        }

        private Companion() {
        }
    }
}
