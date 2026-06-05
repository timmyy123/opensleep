package com.urbandroid.sleep.nearby.pairtracking;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.nearby.core.ConnectionStatus;
import com.urbandroid.sleep.nearby.core.Message;
import com.urbandroid.sleep.nearby.core.MyLogger;
import com.urbandroid.sleep.nearby.core.ReliableMessageQueue;
import com.urbandroid.sleep.nearby.core.ServiceNamesKt;
import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StringBufferPersister;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.io.Closeable;
import java.util.BitSet;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.sync.MutexImpl$$ExternalSyntheticLambda1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/PairTracking;", "Ljava/io/Closeable;", "ctx", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mainHandler", "Landroid/os/Handler;", "mq", "Lcom/urbandroid/sleep/nearby/core/ReliableMessageQueue;", "dataLog", "Lcom/urbandroid/util/StringBufferPersister;", "kotlin.jvm.PlatformType", "detailsLog", "minTimeDiff", "Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "consume", "", "m", "Lcom/urbandroid/sleep/nearby/core/Message;", "update", "Lcom/urbandroid/sleep/sensor/aggregator/IActivityAggregator$Result;", "activityRecord", "backfill", "values", "", "getLocalTime", "", "close", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PairTracking implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile ConnectionStatus connectionStatus = ConnectionStatus.DISCONNECTED;
    private static volatile RawPairData pairData = new RawPairData(null, null, null, 7, null);
    private final StringBufferPersister dataLog;
    private final StringBufferPersister detailsLog;
    private final Handler mainHandler;
    private final FloatFunction minTimeDiff;
    private final ReliableMessageQueue mq;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u000fH\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/PairTracking$Companion;", "", "<init>", "()V", "ACTION_PAIR_CONNECTION_STATUS_CHANGED", "", "connectionStatus", "Lcom/urbandroid/sleep/nearby/core/ConnectionStatus;", "pairData", "Lcom/urbandroid/sleep/nearby/pairtracking/RawPairData;", "getAggregatedActigraph", "", "excludedIndices", "Ljava/util/BitSet;", "hasSufficientDataForPairTracking", "", "getConnectionStatus", "logStatus", "", "clearData", "isPairTrackingSwitchedOn", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "shouldPairTrackingBeUsed", "checkPermission", "isPlayServicesAvailable", "isPairTrackingPermissionGranted", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isPairTrackingPermissionGranted(Context context) {
            boolean z;
            int i = Build.VERSION.SDK_INT;
            if (i >= 31) {
                return ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_SCAN") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADVERTISE") == 0;
            }
            if (i >= 29) {
                z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
                if (!z) {
                    Logger.logWarning("PairTracking: SDK_INT >= 29, ACCESS_FINE_LOCATION not granted.");
                }
                return z;
            }
            z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
            if (!z) {
                Logger.logWarning("PairTracking: SDK_INT < 29, ACCESS_COARSE_LOCATION not granted.");
            }
            return z;
        }

        private final boolean isPlayServicesAvailable(Context context) {
            int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            boolean z = iIsGooglePlayServicesAvailable == 0;
            if (!z) {
                Logger.logWarning("PairTracking: google play services not available: " + iIsGooglePlayServicesAvailable);
            }
            return z;
        }

        public static /* synthetic */ boolean shouldPairTrackingBeUsed$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return companion.shouldPairTrackingBeUsed(context, z);
        }

        public final void clearData() {
            PairTracking.pairData = new RawPairData(null, null, null, 7, null);
        }

        public final float[] getAggregatedActigraph(BitSet excludedIndices) {
            excludedIndices.getClass();
            return PairTracking.pairData.getAggregatedActigraph(excludedIndices, 30);
        }

        public final ConnectionStatus getConnectionStatus() {
            return PairTracking.connectionStatus;
        }

        public final boolean hasSufficientDataForPairTracking() {
            return PairTracking.pairData.hasSufficientDataForPairTracking();
        }

        public final boolean isPairTrackingSwitchedOn(Context context) {
            context.getClass();
            Settings settings = new Settings(context);
            return settings.isPairTracking() && settings.getPairTrackingToken() != null;
        }

        public final void logStatus() {
            PairTracking.pairData.logStatus();
        }

        public final boolean shouldPairTrackingBeUsed(Context context, boolean checkPermission) {
            context.getClass();
            if (isPairTrackingSwitchedOn(context) && isPlayServicesAvailable(context)) {
                return !checkPermission || isPairTrackingPermissionGranted(context);
            }
            return false;
        }

        private Companion() {
        }

        public final boolean shouldPairTrackingBeUsed(Context context) {
            context.getClass();
            return shouldPairTrackingBeUsed$default(this, context, false, 2, null);
        }
    }

    public PairTracking(Context context) {
        context.getClass();
        Handler handler = new Handler(context.getMainLooper());
        this.mainHandler = handler;
        int i = 1;
        this.dataLog = Experiments.getInstance().isDetailedPairLoggingExperiment() ? new StringBufferPersister("nearby_data", 100, true) : StringBufferPersister.newNullPersister();
        this.detailsLog = Experiments.getInstance().isDetailedPairLoggingExperiment() ? new StringBufferPersister("nearby_details", 1000, true) : StringBufferPersister.newNullPersister();
        this.minTimeDiff = Moving.min(15);
        String pairTrackingToken = new Settings(context).getPairTrackingToken();
        String serviceName = ServiceNamesKt.getServiceName(pairTrackingToken == null ? "FallbackToken" : pairTrackingToken);
        Logger.logInfo("PairTracking: serviceName=" + serviceName);
        this.mq = new ReliableMessageQueue(serviceName, context, new MyLogger(new MutexImpl$$ExternalSyntheticLambda1(this, i)), new CodecsKt$$ExternalSyntheticLambda2(this, 12), 0, 0L, new CodecsKt$$ExternalSyntheticLambda2(context, 13), 48, null);
        final long j = 60000;
        handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.nearby.pairtracking.PairTracking.3
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                if (PairTracking.this.mq.isClosed()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", PairTracking.this.getLocalTime());
                PairTracking.this.mq.sendUnreliable(jSONObject);
                PairTracking.this.mainHandler.postDelayed(this, j);
            }
        }, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(PairTracking pairTracking, int i, String str, Throwable th) {
        str.getClass();
        if (i > 1) {
            String strM$1 = th == null ? "" : FileInsert$$ExternalSyntheticOutline0.m$1(th.getClass().getSimpleName(), " ", th.getMessage());
            pairTracking.detailsLog.update(new Date() + " " + str + " " + strM$1 + "\n");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(PairTracking pairTracking, Message message) throws JSONException {
        message.getClass();
        pairTracking.consume(message);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(Context context, ConnectionStatus connectionStatus2) {
        connectionStatus2.getClass();
        connectionStatus = connectionStatus2;
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.urbandroid.sleep.ACTION_PAIR_CONNECTION_STATUS_CHANGED"));
        return Unit.INSTANCE;
    }

    private final void consume(Message m) throws JSONException {
        if (m.getSerialNo() < 0) {
            long j = m.getPayload().getLong("t");
            long localTime = getLocalTime();
            long jApply = (long) this.minTimeDiff.apply(localTime - j);
            StringBufferPersister stringBufferPersister = this.dataLog;
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("time,", ",", localTime);
            sbM.append(j);
            sbM.append(",");
            sbM.append(jApply);
            sbM.append("\n");
            stringBufferPersister.update(sbM.toString());
            pairData.addTimeDiff(localTime, jApply);
            return;
        }
        long serialNo = m.getSerialNo();
        long j2 = m.getPayload().getLong("t");
        double d = m.getPayload().getDouble("a");
        StringBufferPersister stringBufferPersister2 = this.dataLog;
        StringBuilder sbM2 = FileInsert$$ExternalSyntheticOutline0.m("remt,", ",", j2);
        sbM2.append(d);
        sbM2.append(",");
        sbM2.append(serialNo);
        sbM2.append("\n");
        stringBufferPersister2.update(sbM2.toString());
        pairData.addRemoteActivity(j2, (float) d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getLocalTime() {
        return System.currentTimeMillis();
    }

    public final void backfill(float[] values) {
        values.getClass();
        long localTime = getLocalTime();
        for (float f : values) {
            pairData.addLocalActivity(localTime, f);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mq.close();
        this.dataLog.flush();
        this.detailsLog.flush();
    }

    public final IActivityAggregator.Result update(IActivityAggregator.Result activityRecord) throws JSONException {
        activityRecord.getClass();
        long localTime = getLocalTime();
        float f = activityRecord.actigraph;
        if (activityRecord.hasNoData()) {
            pairData.addLocalActivity(localTime, activityRecord.rawActivity);
            return activityRecord;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", localTime);
        jSONObject.put("a", Float.valueOf(f));
        this.mq.sendReliable(jSONObject);
        this.dataLog.update("mine," + localTime + "," + f + "\n");
        pairData.addLocalActivity(localTime, f);
        return pairData.adjustRealtimeActivity(activityRecord);
    }
}
