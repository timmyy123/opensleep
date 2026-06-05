package com.urbandroid.sleep;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.preference.PreferenceManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt___StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u0015\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u001a\u001a\u00020\u000e*\u00020\u0019H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u000e*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 \u001a\u0011\u0010!\u001a\u00020\u000e*\u00020\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001d\u0010%\u001a\u00020\u0004*\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010&\u001a\u001d\u0010%\u001a\u00020\u0004*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010'\u001a\u0011\u0010)\u001a\u00020(*\u00020\u0000¢\u0006\u0004\b)\u0010*\u001a/\u00101\u001a\u00060/R\u000200*\u00020\u00002\u0006\u0010+\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020(¢\u0006\u0004\b1\u00102\u001a\u001d\u00104\u001a\u00020\u0006*\u00020\u00002\n\u00103\u001a\u00060/R\u000200¢\u0006\u0004\b4\u00105\u001a\u0011\u00106\u001a\u00020\u000e*\u00020\u0000¢\u0006\u0004\b6\u0010\u001d\u001a\u0013\u00107\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0004\b7\u00108\u001a\u0011\u0010:\u001a\u00020\u0004*\u000209¢\u0006\u0004\b:\u0010;\u001a>\u0010B\u001a\u00028\u0000\"\u0004\b\u0000\u0010<*\u00020\u00002\"\u0010A\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000?\u0012\u0006\u0012\u0004\u0018\u00010@0=H\u0086@¢\u0006\u0004\bB\u0010C\u001a\u001d\u0010E\u001a\u00020\u0004*\u0004\u0018\u00010\u00042\b\b\u0002\u0010D\u001a\u00020(¢\u0006\u0004\bE\u0010F\u001a\u001f\u0010G\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00042\b\b\u0002\u0010D\u001a\u00020(¢\u0006\u0004\bG\u0010F\"\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010I\"\u0015\u0010M\u001a\u00020J*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bK\u0010L\"\u0015\u0010P\u001a\u00020\u0019*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bN\u0010O\"\u0015\u0010T\u001a\u00020Q*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bR\u0010S\"\u0015\u0010X\u001a\u00020U*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bV\u0010W\"\u0015\u0010\\\u001a\u00020Y*\u00020\u00008G¢\u0006\u0006\u001a\u0004\bZ\u0010[\"\u0015\u0010`\u001a\u00020]*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b^\u0010_\"\u0015\u0010d\u001a\u00020a*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bb\u0010c\"\u0017\u0010h\u001a\u0004\u0018\u00010e*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006i"}, d2 = {"Landroid/content/Context;", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "", "", "packages", "", "sendExplicitBroadcast", "(Landroid/content/Context;Landroid/content/Intent;[Ljava/lang/String;)V", "Landroid/content/ComponentName;", "startForegroundServiceWithLog", "(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;", "startBindForegroundServiceWithLog", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "sendLocalBroadcast", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/IntentFilter;", "filter", "registerLocalReceiver", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V", "unregisterLocalReceiver", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V", "Landroid/app/AlarmManager;", "canScheduleExactAlarmsCompat", "(Landroid/app/AlarmManager;)Z", "hasConnectivity", "(Landroid/content/Context;)Z", "pkg", "copy", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "hasNoPackage", "(Landroid/content/Intent;)Z", "Landroid/os/Bundle;", "tabs", "stringify", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;", "", "accelSensorBatchingQueueSize", "(Landroid/content/Context;)I", "tag", "", "timeout", "lockType", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "lockAcquire", "(Landroid/content/Context;Ljava/lang/String;JI)Landroid/os/PowerManager$WakeLock;", "lock", "lockRelease", "(Landroid/content/Context;Landroid/os/PowerManager$WakeLock;)V", "isActivitySensorBatchingSupported", "sha1", "(Landroid/content/Context;)Ljava/lang/String;", "", "toHex", "([B)Ljava/lang/String;", "T", "Lkotlin/Function2;", "Lcom/urbandroid/sleep/JsonSharedPreferences;", "Lkotlin/coroutines/Continuation;", "", "block", "withJsonPrefs", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "len", "cut", "(Ljava/lang/String;I)Ljava/lang/String;", "cutFromEnd", "PACKAGES_TASKER", "[Ljava/lang/String;", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "getLocalBroadcastManager", "(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "localBroadcastManager", "getAlarmManager", "(Landroid/content/Context;)Landroid/app/AlarmManager;", "alarmManager", "Landroid/media/AudioManager;", "getAudioManager", "(Landroid/content/Context;)Landroid/media/AudioManager;", "audioManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "(Landroid/content/Context;)Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/app/job/JobScheduler;", "getJobScheduler", "(Landroid/content/Context;)Landroid/app/job/JobScheduler;", "jobScheduler", "Lcom/urbandroid/sleep/service/Settings;", "getSettings", "(Landroid/content/Context;)Lcom/urbandroid/sleep/service/Settings;", "settings", "Landroid/hardware/SensorManager;", "getSensorManager", "(Landroid/content/Context;)Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/Sensor;", "getLightSensor", "(Landroid/content/Context;)Landroid/hardware/Sensor;", "lightSensor", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ContextExtKt {
    public static final String[] PACKAGES_TASKER = {"net.dinglisch.android.taskerm", "ch.gridvision.ppam.androidautomagic", "com.llamalab.automate", "com.arlosoft.macrodroid", "es.raulguemes.rgahome", "com.arlosoft.macrodroid"};

    public static final int accelSensorBatchingQueueSize(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        Sensor defaultSensor = ((SensorManager) systemService).getDefaultSensor(1);
        if (defaultSensor != null) {
            return defaultSensor.getFifoMaxEventCount();
        }
        return 0;
    }

    public static final boolean canScheduleExactAlarmsCompat(AlarmManager alarmManager) {
        alarmManager.getClass();
        return Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms();
    }

    public static final Intent copy(Intent intent, String str) {
        intent.getClass();
        str.getClass();
        Intent intent2 = new Intent(intent);
        intent2.setPackage(str);
        return intent2;
    }

    public static final String cut(String str, int i) {
        String strSubstring = str != null ? str.substring(0, Math.min(str.length(), i)) : null;
        return strSubstring == null ? "" : strSubstring;
    }

    public static final String cutFromEnd(String str, int i) {
        String string;
        if (str == null || (string = StringsKt___StringsKt.reversed(str).toString()) == null) {
            return null;
        }
        return cut(string, i);
    }

    public static final AlarmManager getAlarmManager(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("alarm");
        systemService.getClass();
        return (AlarmManager) systemService;
    }

    public static final AudioManager getAudioManager(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("audio");
        systemService.getClass();
        return (AudioManager) systemService;
    }

    public static final ConnectivityManager getConnectivityManager(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("connectivity");
        systemService.getClass();
        return (ConnectivityManager) systemService;
    }

    public static final JobScheduler getJobScheduler(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("jobscheduler");
        systemService.getClass();
        return (JobScheduler) systemService;
    }

    public static final Sensor getLightSensor(Context context) {
        context.getClass();
        return getSensorManager(context).getDefaultSensor(5);
    }

    public static final LocalBroadcastManager getLocalBroadcastManager(Context context) {
        context.getClass();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.getClass();
        return localBroadcastManager;
    }

    public static final SensorManager getSensorManager(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        return (SensorManager) systemService;
    }

    public static final Settings getSettings(Context context) {
        context.getClass();
        return new Settings(context);
    }

    public static final boolean hasConnectivity(Context context) {
        context.getClass();
        return getConnectivityManager(context).getActiveNetworkInfo() != null;
    }

    public static final boolean hasNoPackage(Intent intent) {
        intent.getClass();
        return intent.getPackage() == null && intent.getComponent() == null;
    }

    public static final boolean isActivitySensorBatchingSupported(Context context) {
        context.getClass();
        return ((long) accelSensorBatchingQueueSize(context)) >= 500;
    }

    public static final PowerManager.WakeLock lockAcquire(Context context, String str, long j, int i) {
        context.getClass();
        str.getClass();
        Object systemService = context.getSystemService("power");
        systemService.getClass();
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(i, SleepLockManager.getWakeLockTag(context, str));
        wakeLockNewWakeLock.acquire(j);
        return wakeLockNewWakeLock;
    }

    public static /* synthetic */ PowerManager.WakeLock lockAcquire$default(Context context, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return lockAcquire(context, str, j, i);
    }

    public static final void lockRelease(Context context, PowerManager.WakeLock wakeLock) {
        context.getClass();
        wakeLock.getClass();
        if (wakeLock.isHeld()) {
            wakeLock.release();
        }
    }

    public static final void registerLocalReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        context.getClass();
        broadcastReceiver.getClass();
        intentFilter.getClass();
        getLocalBroadcastManager(context).registerReceiver(broadcastReceiver, intentFilter);
    }

    public static final void sendExplicitBroadcast(Context context, Intent intent, String... strArr) {
        context.getClass();
        intent.getClass();
        strArr.getClass();
        if (!hasNoPackage(intent)) {
            context.sendBroadcast(intent);
            return;
        }
        for (String str : strArr) {
            context.sendBroadcast(copy(intent, str));
        }
    }

    public static /* synthetic */ void sendExplicitBroadcast$default(Context context, Intent intent, String[] strArr, int i, Object obj) {
        if ((i & 2) != 0) {
            strArr = new String[]{context.getPackageName()};
        }
        sendExplicitBroadcast(context, intent, strArr);
    }

    public static final boolean sendLocalBroadcast(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        return getLocalBroadcastManager(context).sendBroadcast(intent);
    }

    public static final String sha1(Context context) {
        Signature signature;
        context.getClass();
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && (signature = (Signature) ArraysKt.firstOrNull(signatureArr)) != null) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(signature.toByteArray());
                byte[] bArrDigest = messageDigest.digest();
                bArrDigest.getClass();
                String upperCase = toHex(bArrDigest).toUpperCase(Locale.ROOT);
                upperCase.getClass();
                return upperCase;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final void startBindForegroundServiceWithLog(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        if (Logger.isInitialized()) {
            Logger.logInfo("startBindForegroundServiceWithLog: binding " + stringify$default(intent, null, 1, null), null);
        }
        context.bindService(intent, new ServiceConnection() { // from class: com.urbandroid.sleep.ContextExtKt.startBindForegroundServiceWithLog.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }
        }, 1);
        if (Logger.isInitialized()) {
            Logger.logInfo("startBindForegroundServiceWithLog: starting " + stringify$default(intent, null, 1, null), null);
        }
        context.startService(intent);
    }

    public static final ComponentName startForegroundServiceWithLog(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        if (Build.VERSION.SDK_INT < 26) {
            return context.startService(intent);
        }
        if (Logger.isInitialized()) {
            zza$$ExternalSyntheticOutline0.m("startForegroundService: ", stringify$default(intent, null, 1, null));
        }
        try {
            return context.startForegroundService(intent);
        } catch (Exception e) {
            Logger.logSevere(e);
            Logger.logInfo("startForegroundService: doing fallback");
            PendingIntent foregroundService = new PendingIntentBuilder(context, 0, intent, 134217728).getForegroundService();
            AlarmManager alarmManager = getAlarmManager(context);
            long jCurrentTimeMillis = System.currentTimeMillis() + 100;
            alarmManager.cancel(foregroundService);
            if (Build.VERSION.SDK_INT < 31) {
                alarmManager.setExactAndAllowWhileIdle(1, jCurrentTimeMillis, foregroundService);
                return null;
            }
            if (alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(1, jCurrentTimeMillis, foregroundService);
                return null;
            }
            Logger.logSevere("Cannot set EXACT alarms");
            alarmManager.setAndAllowWhileIdle(1, jCurrentTimeMillis, foregroundService);
            return null;
        }
    }

    public static final String stringify(Bundle bundle, String str) {
        String string;
        bundle.getClass();
        str.getClass();
        StringBuilder sb = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            sb.append(FileInsert$$ExternalSyntheticOutline0.m("\n", str, "\t\t", str2, "="));
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                if (((String) obj).length() > 0) {
                    sb.append("\"" + obj + "\" ");
                }
                Unit unit = Unit.INSTANCE;
            } else if (obj instanceof Boolean) {
                sb.append(((Boolean) obj).booleanValue());
            } else if (obj instanceof Number) {
                sb.append(obj);
            } else if (obj instanceof Intent) {
                stringify((Intent) obj, str + "\t\t\t");
            } else {
                if (obj == null || (string = obj.toString()) == null) {
                    string = "NULL";
                }
                int length = string.length();
                if (1 <= length && length < 100) {
                    Fragment$$ExternalSyntheticOutline1.m67m(sb, "(", string, ") ");
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String stringify$default(Intent intent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return stringify(intent, str);
    }

    public static final String toHex(byte[] bArr) {
        bArr.getClass();
        return ArraysKt___ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new ContextExtKt$$ExternalSyntheticLambda1(), 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHex$lambda$0(byte b) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
    }

    public static final void unregisterLocalReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        context.getClass();
        broadcastReceiver.getClass();
        getLocalBroadcastManager(context).unregisterReceiver(broadcastReceiver);
    }

    public static final <T> Object withJsonPrefs(Context context, Function2<? super JsonSharedPreferences, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.getClass();
        return function2.invoke(new JsonSharedPreferences(defaultSharedPreferences), continuation);
    }

    public static final void sendExplicitBroadcast(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        sendExplicitBroadcast$default(context, intent, null, 2, null);
    }

    public static final String stringify(Intent intent) {
        intent.getClass();
        return stringify$default(intent, null, 1, null);
    }

    public static final String stringify(Intent intent, String str) {
        intent.getClass();
        str.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + str + "I: ");
        if (intent.getAction() != null) {
            sb.append("action: " + intent.getAction() + " ");
        }
        if (intent.getComponent() != null) {
            ComponentName component = intent.getComponent();
            sb.append("class: " + (component != null ? component.getClassName() : null));
        }
        if (intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            sb.append(extras != null ? stringify(extras, str) : null);
        }
        return sb.toString();
    }
}
