package com.urbandroid.util;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001a\u0010\u0019J+\u0010\u001f\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/urbandroid/util/VolumeUtil;", "", "<init>", "()V", "", "volume", "volMax", "", "getLogVolume", "(II)F", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "stream", "", "setStreamVolume", "(Landroid/content/Context;II)Z", "", "unmuteStream", "(Landroid/content/Context;I)V", "setStreamVolumeGrant", "(Landroid/content/Context;II)V", "doPermissionFallback", "cancelDndAll", "(Landroid/content/Context;Z)Z", "askForPermission", "(Landroid/content/Context;)V", "askStreamVolumePermission", "", "Landroid/media/AudioDeviceInfo;", "devices", "types", "hasDevice", "([Landroid/media/AudioDeviceInfo;[Ljava/lang/Integer;)Z", "getHeadsetState", "(Landroid/content/Context;)I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VolumeUtil {
    public static final VolumeUtil INSTANCE = new VolumeUtil();

    private VolumeUtil() {
    }

    private final void askForPermission(Context context) {
        if (Environment.isNOrGreater()) {
            Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            context.startActivity(intent);
        }
    }

    public static final void askStreamVolumePermission(Context context) {
        context.getClass();
        if (Environment.isNOrGreater()) {
            try {
                Object systemService = context.getSystemService("notification");
                systemService.getClass();
                int i = 0;
                if (!((NotificationManager) systemService).isNotificationPolicyAccessGranted()) {
                    if (context instanceof Activity) {
                        new MaterialAlertDialogBuilder(context).setMessage(R.string.permission_notification).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(context, i)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                    } else {
                        INSTANCE.askForPermission(context);
                    }
                }
                new Settings(context).setVolumePermissionNeeded(false);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askStreamVolumePermission$lambda$0(Context context, DialogInterface dialogInterface, int i) {
        INSTANCE.askForPermission(context);
    }

    public static final boolean cancelDndAll(Context context, boolean doPermissionFallback) {
        context.getClass();
        try {
            if (Environment.isMOrGreater()) {
                AudioManager audioManager = ContextExtKt.getAudioManager(context);
                int ringerMode = audioManager.getRingerMode();
                Object systemService = context.getSystemService("notification");
                systemService.getClass();
                NotificationManager notificationManager = (NotificationManager) systemService;
                if (notificationManager.getCurrentInterruptionFilter() == 3) {
                    if (!notificationManager.isNotificationPolicyAccessGranted()) {
                        ContextExtKt.getSettings(context).setVolumePermissionNeeded(true);
                        if (!doPermissionFallback) {
                            return false;
                        }
                        try {
                            Logger.logInfo("Volume: disable DND all using ringer mode normal", null);
                            if (ringerMode == 0) {
                                Logger.logInfo("Volume: Unmuting ringer, for alarm ", null);
                                audioManager.setRingerMode(2);
                            }
                            return true;
                        } catch (Exception unused) {
                            Logger.logInfo("Volume: Cannot set DND alarms", null);
                            return false;
                        }
                    }
                    Logger.logInfo("Volume: disable DND all", null);
                    notificationManager.setInterruptionFilter(Build.VERSION.SDK_INT >= 28 ? 1 : 4);
                }
            }
            return true;
        } catch (Exception e) {
            Logger.logSevere(e);
            return false;
        }
    }

    public static /* synthetic */ boolean cancelDndAll$default(Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return cancelDndAll(context, z);
    }

    public static final int getHeadsetState(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("audio");
        systemService.getClass();
        AudioDeviceInfo[] devices = ((AudioManager) systemService).getDevices(2);
        devices.getClass();
        if (hasDevice(devices, new Integer[]{22, 4, 3})) {
            return 1;
        }
        if (hasDevice(devices, new Integer[]{8})) {
            return 2;
        }
        hasDevice(devices, new Integer[]{22, 4, 3, 8});
        return 0;
    }

    public static final float getLogVolume(int volume, int volMax) {
        float fLog;
        double dLog;
        if (volume < 100) {
            double d = volMax;
            fLog = (float) Math.log(d - ((double) volume));
            dLog = Math.log(d);
        } else {
            if (volume <= 100) {
                return 1.0f;
            }
            double d2 = volMax;
            fLog = (float) Math.log(d2 - ((double) (volume - 100)));
            dLog = Math.log(d2);
        }
        return 1.0f - (fLog / ((float) dLog));
    }

    public static /* synthetic */ float getLogVolume$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 100;
        }
        return getLogVolume(i, i2);
    }

    public static final boolean hasDevice(AudioDeviceInfo[] devices, Integer[] types) {
        devices.getClass();
        types.getClass();
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (ArraysKt.contains(types, Integer.valueOf(audioDeviceInfo.getType()))) {
                return true;
            }
        }
        return false;
    }

    public static final boolean setStreamVolume(Context context, int stream, int volume) {
        context.getClass();
        try {
            AudioManager audioManager = ContextExtKt.getAudioManager(context);
            if (audioManager.getStreamVolume(stream) != volume) {
                audioManager.setStreamVolume(stream, volume, 0);
            }
            return true;
        } catch (SecurityException e) {
            Logger.logSevere(null, e);
            ContextExtKt.getSettings(context).setVolumePermissionNeeded(true);
            return false;
        }
    }

    public static final void setStreamVolumeGrant(Context context, int stream, int volume) {
        context.getClass();
        if (setStreamVolume(context, stream, volume)) {
            return;
        }
        askStreamVolumePermission(context);
    }

    public static final void unmuteStream(Context context, int stream) {
        context.getClass();
        try {
            AudioManager audioManager = ContextExtKt.getAudioManager(context);
            if (audioManager.isStreamMute(stream)) {
                Logger.logInfo("Volume: stream was mute unmuting", null);
                audioManager.adjustStreamVolume(stream, 100, 0);
            }
        } catch (Exception e) {
            Logger.logInfo("Volume: stream cannot unmute", null);
            Logger.logSevere(null, e);
        }
    }

    public static final float getLogVolume(int i) {
        return getLogVolume$default(i, 0, 2, null);
    }

    public static final boolean cancelDndAll(Context context) {
        context.getClass();
        return cancelDndAll$default(context, false, 2, null);
    }
}
