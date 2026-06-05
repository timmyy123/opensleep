package com.urbandroid.sleep.smartwatch.fitbit;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.SmartWatchActivity;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.smartwatch.generic.GenericWatch;
import com.urbandroid.util.ColorUtil;
import fi.iki.elonen.NanoHTTPD;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u00019\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0005*\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J)\u0010\"\u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J%\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b(\u0010)R\u001a\u0010.\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/urbandroid/sleep/smartwatch/fitbit/FitbitHttpServerService;", "Lcom/urbandroid/common/ForegroundService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "", "text", "Landroid/app/Notification;", "getNotification", "(Ljava/lang/String;)Landroid/app/Notification;", "", "updateNotification", "(Ljava/lang/String;)V", "data", "Landroid/os/Handler;", "handler", "handleFromWatchMulti", "(Ljava/lang/String;Landroid/os/Handler;)V", "", "isFitbitTrackingRunningOnPhone", "()Z", "toMessage", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onCreate", "startForeground", "onDestroy", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "command", "handleFromWatch", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Handler;)V", "action", "handleFromPhone", "(Ljava/lang/String;Ljava/lang/String;)V", "tag$1", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lfi/iki/elonen/NanoHTTPD;", "server", "Lfi/iki/elonen/NanoHTTPD;", "", "lastWatchMessageTimestamp", "J", "", "Lcom/urbandroid/sleep/smartwatch/fitbit/FitbitMessage;", "messageQueue", "Ljava/util/List;", "com/urbandroid/sleep/smartwatch/fitbit/FitbitHttpServerService$receiver$1", "receiver", "Lcom/urbandroid/sleep/smartwatch/fitbit/FitbitHttpServerService$receiver$1;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FitbitHttpServerService extends ForegroundService implements FeatureLogger {
    private static boolean running;
    private long lastWatchMessageTimestamp;
    private final List<FitbitMessage> messageQueue;
    private FitbitHttpServerService$receiver$1 receiver;
    private NanoHTTPD server;

    /* JADX INFO: renamed from: tag$1, reason: from kotlin metadata */
    private final String tag;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String tag = "fitbit";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/fitbit/FitbitHttpServerService$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "running", "", "getRunning", "()Z", "setRunning", "(Z)V", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "stop", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getRunning() {
            return FitbitHttpServerService.running;
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return FitbitHttpServerService.tag;
        }

        public final void setRunning(boolean z) {
            FitbitHttpServerService.running = z;
        }

        public final void start(Context context) {
            context.getClass();
            setRunning(true);
            ContextExtKt.startForegroundServiceWithLog(context, new Intent(context, (Class<?>) FitbitHttpServerService.class));
        }

        public final void stop(Context context) {
            context.getClass();
            setRunning(false);
            Intent intent = new Intent(context, (Class<?>) FitbitHttpServerService.class);
            intent.setAction("com.urbandroid.sleep.fitbit.STOP_SERVICE");
            ContextCompat.startForegroundService(context, intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/urbandroid/sleep/smartwatch/fitbit/FitbitHttpServerService$onCreate$1", "Lfi/iki/elonen/NanoHTTPD;", "serve", "Lfi/iki/elonen/NanoHTTPD$Response;", "kotlin.jvm.PlatformType", "session", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends NanoHTTPD {
        final /* synthetic */ Handler $h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Handler handler) {
            super(1764);
            this.$h = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence serve$lambda$1(FitbitMessage fitbitMessage) {
            fitbitMessage.getClass();
            return fitbitMessage.toJson();
        }

        @Override // fi.iki.elonen.NanoHTTPD
        public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession session) {
            NanoHTTPD.Response responseNewFixedLengthResponse;
            try {
                try {
                    FitbitHttpServerService.this.lastWatchMessageTimestamp = System.currentTimeMillis();
                    if (session != null) {
                        FitbitHttpServerService fitbitHttpServerService = FitbitHttpServerService.this;
                        Handler handler = this.$h;
                        String uri = session.getUri();
                        uri.getClass();
                        String strSubstring = uri.substring(1);
                        String str = session.getParms().get("data");
                        if (str == null) {
                            str = "";
                        }
                        fitbitHttpServerService.handleFromWatch(strSubstring, str, handler);
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.toList(FitbitHttpServerService.this.messageQueue), ",", "[", "]", new URLUtilsKt$$ExternalSyntheticLambda0(4), 24);
                    if (!strJoinToString$default.equals("[]")) {
                        FitbitHttpServerService fitbitHttpServerService2 = FitbitHttpServerService.this;
                        String strConcat = "toWatch ".concat(strJoinToString$default);
                        Logger.logDebug(Logger.defaultTag, fitbitHttpServerService2.getTag() + ": " + strConcat, null);
                    }
                    responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(strJoinToString$default);
                } catch (Exception e) {
                    FitbitHttpServerService fitbitHttpServerService3 = FitbitHttpServerService.this;
                    Logger.logSevere(Logger.defaultTag, fitbitHttpServerService3.getTag() + ": Fitbit server err: ", e);
                    responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.INTERNAL_ERROR, "text/plain", "Error");
                }
                FitbitHttpServerService.this.messageQueue.clear();
                return responseNewFixedLengthResponse;
            } catch (Throwable th) {
                FitbitHttpServerService.this.messageQueue.clear();
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService$receiver$1] */
    public FitbitHttpServerService() {
        super("sleepTrackingChannel", 2323, R.drawable.ic_action_watch_white);
        this.tag = "fitbit";
        this.lastWatchMessageTimestamp = -1L;
        this.messageQueue = new ArrayList();
        this.receiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService$receiver$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action;
                if (intent == null || (action = intent.getAction()) == null) {
                    return;
                }
                FitbitHttpServerService fitbitHttpServerService = this.this$0;
                switch (action.hashCode()) {
                    case -1934775263:
                        if (action.equals("com.urbandroid.sleep.watch.START_TRACKING")) {
                            Bundle extras = intent.getExtras();
                            fitbitHttpServerService.handleFromPhone(action, String.valueOf(extras != null ? extras.get("DO_HR_MONITORING") : null));
                            fitbitHttpServerService.messageQueue.add(new FitbitMessage("set_multi", ""));
                            return;
                        }
                        break;
                    case -1021645561:
                        if (action.equals("com.urbandroid.sleep.watch.START_ALARM")) {
                            Bundle extras2 = intent.getExtras();
                            fitbitHttpServerService.handleFromPhone(action, String.valueOf(extras2 != null ? extras2.get("DELAY") : null));
                            return;
                        }
                        break;
                    case -291818132:
                        if (action.equals("com.urbandroid.sleep.watch.SET_PAUSE")) {
                            Bundle extras3 = intent.getExtras();
                            fitbitHttpServerService.handleFromPhone(action, String.valueOf(extras3 != null ? extras3.get("TIMESTAMP") : null));
                            return;
                        }
                        break;
                    case -52158809:
                        if (action.equals("com.urbandroid.sleep.watch.STOP_TRACKING")) {
                            String string = fitbitHttpServerService.getString(R.string.fitbit_standby);
                            string.getClass();
                            fitbitHttpServerService.updateNotification(string);
                            fitbitHttpServerService.handleFromPhone(action, "");
                            return;
                        }
                        break;
                    case 463493168:
                        if (action.equals("com.urbandroid.sleep.watch.SET_BATCH_SIZE")) {
                            Bundle extras4 = intent.getExtras();
                            fitbitHttpServerService.handleFromPhone(action, String.valueOf(extras4 != null ? extras4.get("SIZE") : null));
                            return;
                        }
                        break;
                    case 865944712:
                        if (action.equals("com.urbandroid.sleep.watch.UPDATE_ALARM")) {
                            Bundle extras5 = intent.getExtras();
                            Object obj = extras5 != null ? extras5.get("HOUR") : null;
                            Bundle extras6 = intent.getExtras();
                            Object obj2 = extras6 != null ? extras6.get("MINUTE") : null;
                            Bundle extras7 = intent.getExtras();
                            fitbitHttpServerService.handleFromPhone(action, obj + ":" + obj2 + ":" + (extras7 != null ? extras7.get("TIMESTAMP") : null));
                            return;
                        }
                        break;
                }
                fitbitHttpServerService.handleFromPhone(action, "");
            }
        };
    }

    private final Notification getNotification(String text) {
        PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) SmartWatchActivity.class);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        Unit unit = Unit.INSTANCE;
        PendingIntent activity = companion.get(this, 3232, intent, 134217728).getActivity();
        Intent intent2 = new Intent(getApplicationContext(), (Class<?>) FitbitHttpServerService.class);
        intent2.setAction("com.urbandroid.sleep.fitbit.STOP_SERVICE");
        PendingIntent foregroundService = companion.get(this, 4242, intent2, 134217728).getForegroundService();
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "sleepTrackingChannel").setSmallIcon(R.drawable.ic_action_watch_white).setColor(ColorUtil.i(this, R.color.tint_notification)).setContentIntent(foregroundService).addAction(R.drawable.ic_action_stop, getString(R.string.player_stop), foregroundService).setShowWhen(false).setContentIntent(activity).setContentText(text);
        contentText.getClass();
        Notification notificationBuild = contentText.build();
        notificationBuild.getClass();
        return notificationBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleFromWatch$lambda$0(FitbitMessage fitbitMessage) {
        fitbitMessage.getClass();
        return Intrinsics.areEqual(fitbitMessage.getName(), "stop");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleFromWatch$lambda$1(FitbitHttpServerService fitbitHttpServerService) {
        ContextExtKt.sendExplicitBroadcast$default(fitbitHttpServerService, new Intent("com.urbandroid.sleep.watch.STARTED_ON_WATCH"), null, 2, null);
    }

    private final void handleFromWatchMulti(String data2, Handler handler) {
        Iterator it = StringsKt.split$default(data2, new String[]{","}, 0, 6).iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((String) it.next(), new String[]{"#"}, 0, 6);
            String str = (String) listSplit$default.get(0);
            String str2 = listSplit$default.size() > 1 ? (String) listSplit$default.get(1) : "";
            if (str == "multi") {
                return;
            } else {
                handleFromWatch(str, str2, handler);
            }
        }
    }

    private final boolean isFitbitTrackingRunningOnPhone() {
        if (!SleepService.isRunning() || !(SmartWatchProvider.getSmartWatch(this) instanceof GenericWatch)) {
            return false;
        }
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        return ContextExtKt.getSettings(applicationContext).isWearableSelected(Wearable.FITBIT);
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    public static final void stop(Context context) {
        INSTANCE.stop(context);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final String toMessage(String str) {
        switch (str.hashCode()) {
            case -2054624687:
                if (str.equals("com.urbandroid.sleep.watch.SET_SUSPENDED")) {
                    return "suspend";
                }
                break;
            case -1934775263:
                if (str.equals("com.urbandroid.sleep.watch.START_TRACKING")) {
                    return "start";
                }
                break;
            case -1921058751:
                if (str.equals("com.urbandroid.sleep.watch.STOP_ALARM")) {
                    return "alarm_stop";
                }
                break;
            case -1854596123:
                if (str.equals("com.urbandroid.sleep.watch.CHECK_CONNECTED")) {
                    return "ping";
                }
                break;
            case -1021645561:
                if (str.equals("com.urbandroid.sleep.watch.START_ALARM")) {
                    return "alarm_start";
                }
                break;
            case -291818132:
                if (str.equals("com.urbandroid.sleep.watch.SET_PAUSE")) {
                    return "pause_time";
                }
                break;
            case -52158809:
                if (str.equals("com.urbandroid.sleep.watch.STOP_TRACKING")) {
                    return "stop";
                }
                break;
            case -34004780:
                if (str.equals("com.urbandroid.sleep.watch.HINT")) {
                    return ViewHierarchyConstants.HINT_KEY;
                }
                break;
            case 463493168:
                if (str.equals("com.urbandroid.sleep.watch.SET_BATCH_SIZE")) {
                    return "batch_size";
                }
                break;
            case 865944712:
                if (str.equals("com.urbandroid.sleep.watch.UPDATE_ALARM")) {
                    return "alarm_time";
                }
                break;
        }
        return StringsKt.startsWith$default(str, "com.urbandroid.sleep.watch.") ? str.substring(27) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNotification(String text) {
        NotificationsKt.notify(this, 2323, getNotification(text));
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void handleFromPhone(String action, String data2) {
        action.getClass();
        data2.getClass();
        this.messageQueue.add(new FitbitMessage(toMessage(action), data2));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void handleFromWatch(String command, String data2, Handler handler) {
        command.getClass();
        data2.getClass();
        handler.getClass();
        if (!command.equals("poll")) {
            String strM = Fragment$$ExternalSyntheticOutline1.m("fromWatch ", command, ": ", data2);
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM, null);
        }
        final int i = 1;
        final int i2 = 0;
        switch (command.hashCode()) {
            case -1423461252:
                if (command.equals("acceld")) {
                    Intent intent = new Intent("com.urbandroid.sleep.watch.DATA_UPDATE");
                    List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.split$default(data2, new String[]{";"}, 0, 6).get(0), new String[]{":"}, 0, 6);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                    Iterator it = listSplit$default.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Float.valueOf(Float.parseFloat((String) it.next())));
                    }
                    intent.putExtra("MAX_DATA", CollectionsKt.toFloatArray(arrayList));
                    List listSplit$default2 = StringsKt.split$default((CharSequence) StringsKt.split$default(data2, new String[]{";"}, 0, 6).get(1), new String[]{":"}, 0, 6);
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
                    Iterator it2 = listSplit$default2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(Float.valueOf(Float.parseFloat((String) it2.next())));
                    }
                    intent.putExtra("MAX_RAW_DATA", CollectionsKt.toFloatArray(arrayList2));
                    ContextExtKt.sendExplicitBroadcast$default(this, intent, null, 2, null);
                    break;
                }
                break;
            case -934426579:
                if (command.equals("resume")) {
                    ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.ACTION_RESUME_TRACKING"), null, 2, null);
                    break;
                }
                break;
            case -579210487:
                if (command.equals("connected")) {
                    ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.watch.CONFIRM_CONNECTED"), null, 2, null);
                    break;
                }
                break;
            case -481693028:
                if (command.equals("alarm_dismiss")) {
                    ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA"), null, 2, null);
                    break;
                }
                break;
            case -135789676:
                if (command.equals("alarm_snooze")) {
                    ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE"), null, 2, null);
                    break;
                }
                break;
            case 103578:
                if (command.equals("hrd")) {
                    Intent intent2 = new Intent("com.urbandroid.sleep.watch.HR_DATA_UPDATE");
                    List listSplit$default3 = StringsKt.split$default((CharSequence) StringsKt.split$default(data2, new String[]{";"}, 0, 6).get(0), new String[]{":"}, 0, 6);
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default3, 10));
                    Iterator it3 = listSplit$default3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(Float.valueOf(Float.parseFloat((String) it3.next())));
                    }
                    intent2.putExtra("DATA", CollectionsKt.toFloatArray(arrayList3));
                    ContextExtKt.sendExplicitBroadcast$default(this, intent2, null, 2, null);
                    break;
                }
                break;
            case 3540994:
                if (command.equals("stop")) {
                    String string = getString(R.string.fitbit_standby);
                    string.getClass();
                    updateNotification(string);
                    ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"), null, 2, null);
                    handler.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService$$ExternalSyntheticLambda1
                        public final /* synthetic */ FitbitHttpServerService f$0;

                        {
                            this.f$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = i;
                            FitbitHttpServerService fitbitHttpServerService = this.f$0;
                            switch (i3) {
                                case 0:
                                    FitbitHttpServerService.handleFromWatch$lambda$1(fitbitHttpServerService);
                                    break;
                                default:
                                    fitbitHttpServerService.stopSelf();
                                    break;
                            }
                        }
                    }, 10000L);
                    break;
                }
                break;
            case 104256825:
                if (command.equals("multi")) {
                    handleFromWatchMulti(data2, handler);
                }
                break;
            case 106440182:
                if (command.equals("pause")) {
                    ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.ACTION_PAUSE_TRACKING"), null, 2, null);
                    break;
                }
                break;
            case 109757538:
                if (command.equals("start")) {
                    CollectionsKt__MutableCollectionsKt.removeAll(this.messageQueue, new URLUtilsKt$$ExternalSyntheticLambda0(3));
                    updateNotification(FileInsert$$ExternalSyntheticOutline0.m("Fitbit: ", getString(R.string.settings_category_track)));
                    handler.post(new Runnable(this) { // from class: com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService$$ExternalSyntheticLambda1
                        public final /* synthetic */ FitbitHttpServerService f$0;

                        {
                            this.f$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = i2;
                            FitbitHttpServerService fitbitHttpServerService = this.f$0;
                            switch (i3) {
                                case 0:
                                    FitbitHttpServerService.handleFromWatch$lambda$1(fitbitHttpServerService);
                                    break;
                                default:
                                    fitbitHttpServerService.stopSelf();
                                    break;
                            }
                        }
                    });
                    break;
                }
                break;
        }
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public IBinder onBind(Intent intent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // com.urbandroid.common.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
        running = true;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(new Handler());
        this.server = anonymousClass1;
        anonymousClass1.start();
        FitbitHttpServerService$receiver$1 fitbitHttpServerService$receiver$1 = this.receiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.urbandroid.sleep.watch.START_TRACKING");
        intentFilter.addAction("com.urbandroid.sleep.watch.START_ALARM");
        intentFilter.addAction("com.urbandroid.sleep.watch.SET_PAUSE");
        intentFilter.addAction("com.urbandroid.sleep.watch.SET_BATCH_SIZE");
        intentFilter.addAction("com.urbandroid.sleep.watch.UPDATE_ALARM");
        intentFilter.addAction("com.urbandroid.sleep.watch.STOP_ALARM");
        intentFilter.addAction("com.urbandroid.sleep.watch.STOP_TRACKING");
        intentFilter.addAction("com.urbandroid.sleep.watch.HINT");
        intentFilter.addAction("com.urbandroid.sleep.watch.SET_SUSPENDED");
        intentFilter.addAction("com.urbandroid.sleep.watch.CHECK_CONNECTED");
        Unit unit = Unit.INSTANCE;
        ContextCompat.registerReceiver(this, fitbitHttpServerService$receiver$1, intentFilter, 2);
    }

    @Override // com.urbandroid.common.ForegroundService, com.urbandroid.common.LoggingService, android.app.Service
    public void onDestroy() {
        running = false;
        super.onDestroy();
        NanoHTTPD nanoHTTPD = this.server;
        if (nanoHTTPD == null) {
            Intrinsics.throwUninitializedPropertyAccessException("server");
            nanoHTTPD = null;
        }
        nanoHTTPD.stop();
        Logger.logDebug(Logger.defaultTag, getTag() + ": Stopping Fitbit server", null);
        unregisterReceiver(this.receiver);
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground();
        NanoHTTPD nanoHTTPD = null;
        if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, "com.urbandroid.sleep.fitbit.STOP_SERVICE")) {
            return 1;
        }
        NanoHTTPD nanoHTTPD2 = this.server;
        if (nanoHTTPD2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("server");
        } else {
            nanoHTTPD = nanoHTTPD2;
        }
        nanoHTTPD.stop();
        running = false;
        stopSelf();
        return 2;
    }

    public final void startForeground() {
        String string;
        Logger.logDebug(Logger.defaultTag, getTag() + ": Starting Fitbit Server", null);
        if (isFitbitTrackingRunningOnPhone()) {
            string = FileInsert$$ExternalSyntheticOutline0.m("Fitbit: ", getString(R.string.settings_category_track));
        } else {
            string = getString(R.string.fitbit_standby);
            string.getClass();
        }
        ForegroundService.startForegroundOnce$default(this, getNotification(string), false, 2, null);
    }
}
