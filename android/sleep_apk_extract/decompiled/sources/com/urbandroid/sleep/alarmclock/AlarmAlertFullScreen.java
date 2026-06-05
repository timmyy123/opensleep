package com.urbandroid.sleep.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.CaptchaAntiCheatingAccessibilityService;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.captcha.NFCCaptcha;
import com.urbandroid.sleep.captcha.NFCScannerHelper;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.ViewUtil;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda3;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ActivityStateUtil;
import com.urbandroid.util.ArrayUtil;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmAlertFullScreen extends BaseActivity implements SurfaceHolder.Callback {
    public static boolean CAPTCHA_IN_PROGRESS = false;
    public static boolean RESTART_ME = false;
    public static boolean SHOWN = false;
    public static Class currentClass;
    protected Alarm alarm;
    private Handler h;
    private InterstitialAd interstitialAd;
    private int maxSnooze;
    private Runnable restartRunnable;
    private Settings settings;
    private AlertDialog snoozeDialog;
    private int volumeBehavior;
    private ImageView volumeIcon;
    private ProgressBar volumeProgress;
    private boolean captchaInProgress = false;
    private boolean captchaPassed = false;
    private boolean dismissClicked = false;
    private boolean snoozeClicked = false;
    private boolean doGradualVolumeUp = false;
    private NFCScannerHelper nfcScannerHelper = null;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.urbandroid.sleep.alarmclock.alarm_killed".equals(intent.getAction())) {
                Logger.logDebug("AlarmAlertFullScreen FINISH ALARM_KILLED");
                AlarmAlertFullScreen.this.finishAndCancelRestarting();
                return;
            }
            if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_NOTIF_SNOOZE")) {
                Logger.logDebug("AlarmAlertFullScreen FINISH ALARM_NOTIFICATION_SNOOZE_ACTION");
                zza$$ExternalSyntheticOutline0.m(AlarmAlertFullScreen.this.getApplicationContext(), "com.urbandroid.sleep.ACTION_FINISH_CAPTCHA");
                AlarmAlertFullScreen.this.finishAndCancelRestarting();
                return;
            }
            if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION")) {
                Logger.logDebug("AlarmAlertFullScreen FINISH received snooze preformed ALARM_SNOOZE_CLICKED_ACTION");
                AlarmAlertFullScreen.this.finishAndCancelRestarting();
                return;
            }
            if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA")) {
                Logger.logDebug("AlarmAlertFullScreen FINISH: Received alarm dismiss with captcha intent");
                AlarmAlertFullScreen.this.finishAndCancelRestarting();
                return;
            }
            boolean z = false;
            if (action.equals("com.urbandroid.sleep.SCREENLIGHT_ACTION")) {
                int intExtra = intent.getIntExtra("com.urbandroid.sleep.SCREENLIGHT_PROGRESS_EXTRA", -1);
                View viewFindViewById = AlarmAlertFullScreen.this.findViewById(R.id.main);
                TextView textView = (TextView) AlarmAlertFullScreen.this.findViewById(R.id.alertTitle);
                TextView textView2 = (TextView) AlarmAlertFullScreen.this.findViewById(R.id.timeDisplay);
                TextView textView3 = (TextView) AlarmAlertFullScreen.this.findViewById(R.id.am_pm);
                textView.setTag(null);
                if (viewFindViewById == null || intExtra <= -1) {
                    return;
                }
                int iMin = Math.min(Math.max((intExtra * PHIpAddressSearchManager.END_IP_SCAN) / 100, 0), PHIpAddressSearchManager.END_IP_SCAN);
                viewFindViewById.setBackgroundColor(Color.argb(iMin, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN));
                Logger.logInfo("Screenlight " + intExtra + " " + viewFindViewById);
                try {
                    Window window = AlarmAlertFullScreen.this.getWindow();
                    if (window != null) {
                        window.setNavigationBarColor(Color.rgb(iMin, iMin, iMin));
                    }
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                if (intExtra <= 35 || textView.getTag() != null) {
                    return;
                }
                textView.setTextColor(com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK);
                textView.setTag("Inverted");
                textView2.setTextColor(com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK);
                textView3.setTextColor(com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK);
                WindowManager.LayoutParams attributes = AlarmAlertFullScreen.this.getWindow().getAttributes();
                attributes.screenBrightness = 1.0f;
                AlarmAlertFullScreen.this.getWindow().setAttributes(attributes);
                return;
            }
            if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_DISMISS")) {
                Logger.logDebug("AlarmAlertFullScreen: Received alarm dismiss notification");
                AlarmAlertFullScreen.this.settings.resetAutoSnoozeRepeat();
                AlarmAlertFullScreen.this.dismiss(false, CurrentSleepRecord.getInstance().getRecord());
                return;
            }
            if (action.equals("android.intent.action.TIME_TICK")) {
                int iMaxSnoozeMinutes = Alarm.maxSnoozeMinutes(AlarmAlertFullScreen.this.alarm);
                if (iMaxSnoozeMinutes < 0 || iMaxSnoozeMinutes == Integer.MAX_VALUE) {
                    return;
                }
                if (AlarmAlertFullScreen.this.snoozeDialog != null && AlarmAlertFullScreen.this.snoozeDialog.isShowing()) {
                    ActivityStateUtil.dismiss(AlarmAlertFullScreen.this.snoozeDialog);
                    AlarmAlertFullScreen.this.snoozeDialog = null;
                    z = true;
                }
                AlarmAlertFullScreen.this.maxSnooze = iMaxSnoozeMinutes;
                AlarmAlertFullScreen.this.updateLayout();
                if (z) {
                    AlarmAlertFullScreen.this.showSnoozeChooser();
                    return;
                }
                return;
            }
            if (!action.equals("com.urbandroid.sleep.ACTION_VOLUME_UPDATE")) {
                Logger.logInfo("AlarmAlertFullScreen: Ignoring unknown action: ".concat(action));
                return;
            }
            if (AlarmAlertFullScreen.this.volumeProgress != null) {
                int intExtra2 = intent.getIntExtra("EXTRA_VOLUME", 0);
                int iMax = Math.max(2, intExtra2);
                AlarmAlertFullScreen alarmAlertFullScreen = AlarmAlertFullScreen.this;
                if (intExtra2 == -1) {
                    alarmAlertFullScreen.volumeIcon.setImageResource(R.drawable.ic_volume_off_small_trans_white);
                    AlarmAlertFullScreen.this.volumeProgress.setIndeterminate(false);
                    AlarmAlertFullScreen.this.volumeProgress.setProgress(0);
                } else {
                    if (alarmAlertFullScreen.volumeProgress.isIndeterminate()) {
                        AlarmAlertFullScreen.this.volumeIcon.setImageResource(R.drawable.ic_volume_high_small_trans_white);
                        AlarmAlertFullScreen.this.volumeProgress.setIndeterminate(false);
                    }
                    AlarmAlertFullScreen.this.volumeProgress.setProgress(iMax);
                }
            }
        }
    };
    private boolean lockOrientation = false;
    private boolean isAdMode = false;
    private boolean cancelRestart = false;
    private Runnable turnScreenOff = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.9
        @Override // java.lang.Runnable
        public void run() {
            if (AlarmAlertFullScreen.this.isDestroyed() || AlarmAlertFullScreen.this.isFinishing()) {
                return;
            }
            AlarmAlertFullScreen.this.finish();
        }
    };

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen$7, reason: invalid class name */
    public class AnonymousClass7 implements View.OnClickListener {
        final /* synthetic */ boolean val$dismissLongPress;

        public AnonymousClass7(boolean z) {
            this.val$dismissLongPress = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() {
            ((TextView) AlarmAlertFullScreen.this.findViewById(R.id.dismiss_text)).setText(R.string.alarm_alert_dismiss_text);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = this.val$dismissLongPress;
            AlarmAlertFullScreen alarmAlertFullScreen = AlarmAlertFullScreen.this;
            if (!z) {
                alarmAlertFullScreen.dismissClicked = true;
                Logger.logDebug("AlarmAlertFullScreen: Alarm dismiss request fired due to button click");
                AlarmAlertFullScreen.this.dismissOrStartCaptcha();
            } else {
                Toast.makeText(alarmAlertFullScreen, R.string.settings_dismiss_long_press_title, 1).show();
                ((TextView) AlarmAlertFullScreen.this.findViewById(R.id.dismiss_text)).setText(R.string.settings_dismiss_long_press_title);
                ((TextView) AlarmAlertFullScreen.this.findViewById(R.id.dismiss_text)).startAnimation(AnimationUtils.loadAnimation(AlarmAlertFullScreen.this, R.anim.alpha_pulse));
                AlarmAlertFullScreen.this.h.postDelayed(new AlarmActivity$$ExternalSyntheticLambda0(this, 1), 3500L);
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface AdLoadedListener {
        void onClose();
    }

    private void cancelRestarting() {
        if (this.restartRunnable != null) {
            log("Restarting onStart() cancel");
            new Handler().removeCallbacks(this.restartRunnable);
            this.restartRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss(boolean z, SleepRecord sleepRecord) {
        Alarm.performDismiss(this, this.alarm, sleepRecord, z);
        cancelRestarting();
        if (TrialFilter.getInstance().isTimeToShowInterstitialAds()) {
            showAd();
        } else {
            Logger.logInfo("AlarmAlertFullScreen FINISH: no ads");
            finish();
        }
        this.captchaPassed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAndCancelRestarting() {
        cancelRestarting();
        finish();
    }

    private Object[] getAllowedSnoozeValues() {
        long j;
        final int snoozeMinutes = Alarm.getSnoozeMinutes(this.alarm, false);
        final long jCalculateCurrentRemainingSnoozeTime = Alarm.calculateCurrentRemainingSnoozeTime(this.alarm);
        Logger.logInfo("AlarmAlertFullScreen: remainingMaxSnoozeTimeInMinutes " + jCalculateCurrentRemainingSnoozeTime);
        Map map = ArrayUtil.toMap(ArrayUtil.getSubarray(getResources().getStringArray(R.array.snooze_duration_entries), 2), ArrayUtil.getSubarray(getResources().getStringArray(R.array.snooze_duration_values), 2), new ArrayUtil.MapFilter<String, String>() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.4
            @Override // com.urbandroid.util.ArrayUtil.MapFilter
            public boolean apply(String str, String str2) {
                int i = Integer.parseInt(str2);
                return ((long) i) <= jCalculateCurrentRemainingSnoozeTime && i != snoozeMinutes;
            }
        });
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        String[] strArr2 = (String[]) map.values().toArray(new String[0]);
        for (int i = 0; i < Math.min(strArr2.length, strArr.length); i++) {
            strArr[i] = strArr2[i] + " " + getString(R.string.bed_time_min);
        }
        boolean zIsHalveSnooze = SharedApplicationContext.getSettings().isHalveSnooze();
        int snoozeRepeat = SharedApplicationContext.getSettings().getSnoozeRepeat();
        if (!zIsHalveSnooze || snoozeRepeat <= 0 || jCalculateCurrentRemainingSnoozeTime <= 0) {
            j = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            j = 0;
            while (i2 < strArr2.length) {
                int iMax = Math.max(Integer.parseInt(strArr2[i2]) / (snoozeRepeat * 2), 1);
                long j2 = jCalculateCurrentRemainingSnoozeTime;
                if (!arrayList2.contains("" + iMax) && j2 >= iMax && iMax > 0) {
                    arrayList2.add(iMax + "");
                    arrayList.add(iMax + " " + getString(R.string.bed_time_min));
                }
                i2++;
                jCalculateCurrentRemainingSnoozeTime = j2;
            }
            if (arrayList2.size() < 1) {
                return null;
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
            strArr2 = (String[]) arrayList2.toArray(new String[0]);
        }
        int i3 = this.maxSnooze;
        if (i3 <= 0) {
            return null;
        }
        if (i3 < Integer.MAX_VALUE) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i4 = 0; i4 < strArr2.length; i4++) {
                if (Integer.parseInt(strArr2[i4]) <= this.maxSnooze) {
                    arrayList4.add(strArr2[i4]);
                    arrayList3.add(strArr2[i4] + " " + getString(R.string.bed_time_min));
                }
            }
            int i5 = this.maxSnooze;
            if (i5 > 0 && i5 <= 60 && !arrayList4.contains(String.valueOf(i5))) {
                arrayList4.add(this.maxSnooze + "");
                arrayList3.add(this.maxSnooze + " " + getString(R.string.bed_time_min));
            }
            if (arrayList4.size() < 1) {
                return null;
            }
            strArr = (String[]) arrayList3.toArray(new String[0]);
            strArr2 = (String[]) arrayList4.toArray(new String[0]);
        }
        long currentRecordAlarmTime = Alarm.getCurrentRecordAlarmTime(this.alarm);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (snoozeRepeat == 0 && currentRecordAlarmTime != j && jCurrentTimeMillis < currentRecordAlarmTime - 180000 && currentRecordAlarmTime - jCurrentTimeMillis < 3600000) {
            Logger.logInfo("AlarmAlertFullScreen: Adding snooze till");
            ArrayList arrayList5 = new ArrayList(Arrays.asList(strArr));
            ArrayList arrayList6 = new ArrayList(Arrays.asList(strArr2));
            arrayList5.add(0, DateUtil.formatTime(this, currentRecordAlarmTime));
            arrayList6.add(0, String.valueOf(-39837));
            String[] strArr3 = (String[]) arrayList5.toArray(new String[0]);
            strArr2 = (String[]) arrayList6.toArray(new String[0]);
            strArr = strArr3;
        }
        return new Object[]{strArr, strArr2};
    }

    private void handleCaptchaProvenDismissClick() {
        Logger.logDebug("AlarmAlertFullscreen: Captcha dismiss proven. Release notification with id: " + this.alarm);
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null) {
            record.addEventLabel(EventLabel.ALARM_DISMISS, System.currentTimeMillis());
        }
        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CLICKED_ACTION"));
        Settings settings = SharedApplicationContext.getSettings();
        Logger.logInfo("captcha-support: reset captcha solved time");
        settings.setLastCaptchaSolvedTimestampNow();
        dismiss(false, record);
    }

    private void handleStartExtra(Intent intent) {
        if (intent.hasExtra("dissmis_or_captcha_extra")) {
            hideNotification(34377266);
            showNotification(34377266);
            dismissOrStartCaptcha();
        }
        if (!intent.hasExtra("headsup_notif_clicked") || this.alarm == null) {
            return;
        }
        Logger.logInfo("AlarmAlertFullScreen: Resuming alarm notification after heads up clicked.");
        showNotification(34377266);
    }

    private void hideNotification(int i) {
        Logger.logInfo("AlarmAlertFullScreen: Hiding notification.");
        NotificationManagerCompat.from(this).cancel(i);
    }

    private boolean isNfcAlarm() {
        CaptchaInfo captchaInfo;
        return (this.alarm == null || (captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(this.alarm)) == null || !NFCCaptcha.class.getName().equals(captchaInfo.getActivityName())) ? false : true;
    }

    private boolean isRestarting(Alarm alarm) {
        if (alarm == null || isFinishing() || this.cancelRestart || !AlarmKlaxon.isRunning()) {
            return false;
        }
        return Experiments.getInstance().isRestartingAlarmDialogExperiment2() || ISpotifyPlayer.INSTANCE.isSpotifyUri(Alarms.resolveAlarmAlert(alarm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshSnoozeOptions$0(String str, ViewGroup viewGroup, View view) {
        int i = Integer.parseInt(str);
        zza$$ExternalSyntheticOutline0.m(i, "AlarmAlertFullScreen: snooze option clicked ");
        if (i >= 1 || i == -39837) {
            performSnooze(i, false);
            return;
        }
        Logger.logInfo("AlarmAlertFullScreen: snooze option clicked " + i);
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSnoozeChooser$2(String[] strArr, DialogInterface dialogInterface, int i) {
        Logger.logInfo("AlarmAlertFullScreen: snooze option clicked");
        int i2 = Integer.parseInt(strArr[i]);
        if (i2 > 0) {
            performSnooze(i2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$updateLayout$1(View view) {
        this.dismissClicked = true;
        Logger.logDebug("AlarmAlertFullScreen: Alarm dismiss request fired due to button long press");
        dismissOrStartCaptcha();
        return true;
    }

    private void lockOrientation() {
        Logger.logInfo("AlarmAlertFullScreen: lock orientation:");
        if ((getResources().getConfiguration().screenLayout & 15) < 3 || getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
    }

    private void nfcCaptchaSolved() {
        Logger.logDebug("NFC captcha solved");
        handleCaptchaProvenDismissClick();
    }

    private void performSnooze(int i, boolean z) {
        Logger.logInfo("AlarmAlertFullScreen FINISH: perform snooze: " + i + " autokill: " + z);
        Alarm.performSnooze(this, this.alarm, i, z);
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_FINISH_CAPTCHA");
        finishAndCancelRestarting();
    }

    private void refreshSnoozeOptions() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.snooze_options);
        viewGroup.removeAllViews();
        Object[] allowedSnoozeValues = getAllowedSnoozeValues();
        if (allowedSnoozeValues == null) {
            return;
        }
        String[] strArr = (String[]) allowedSnoozeValues[0];
        String[] strArr2 = (String[]) allowedSnoozeValues[1];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr2[i];
            String str2 = strArr[i];
            ViewGroup viewGroup2 = (ViewGroup) getLayoutInflater().inflate(R.layout.dialog_alarm_alert_new_snooze_button, (ViewGroup) null);
            ((TextView) viewGroup2.findViewById(R.id.snooze_option_text)).setText(str2);
            viewGroup2.findViewById(R.id.snooze_option).setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda3(this, str, viewGroup2));
            viewGroup.addView(viewGroup2);
        }
    }

    private void requestNewInterstitial(final AdLoadedListener adLoadedListener) {
        InterstitialAd interstitialAd = new InterstitialAd(this, "544515103067093_544516879733582");
        this.interstitialAd = interstitialAd;
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(new InterstitialAdListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.3
            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
                Logger.logSevere("ADMOB FAN MOPUB: clicked ");
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Logger.logSevere("ADMOB FAN MOPUB: loaded ");
            }

            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                Logger.logSevere("ADMOB FAN: error " + adError.getErrorMessage() + " " + adError.getErrorCode());
            }

            @Override // com.facebook.ads.InterstitialAdListener
            public void onInterstitialDismissed(Ad ad) {
                Logger.logSevere("ADMOB FAN: close ");
                adLoadedListener.onClose();
            }

            @Override // com.facebook.ads.InterstitialAdListener
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
            }
        }).build());
    }

    public static void restart(Context context, Alarm alarm) {
        if (alarm == null || context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AlarmAlertFullScreen.class);
        intent.putExtra("CREATION_SOURCE", "AlarmAlertFullScreen-Restarting");
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent.putExtra("klaxon_restart", true);
        intent.setFlags(872415232);
        context.startActivity(intent);
    }

    private void setTitle() {
        Alarm alarm = this.alarm;
        String labelOrDefault = alarm != null ? alarm.getLabelOrDefault(this) : getResources().getString(R.string.default_label);
        TextView textView = (TextView) findViewById(R.id.alertTitle);
        if (textView != null) {
            textView.setText(labelOrDefault);
        }
    }

    private void showAd() {
        boolean zIsKeyguard = KeyguardUtil.isKeyguard(this);
        Logger.logInfo("MOPUB ADMOB: show");
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null || !interstitialAd.isAdLoaded() || this.interstitialAd.isAdInvalidated() || isFinishing() || zIsKeyguard) {
            Logger.logInfo("AlarmAlertFullScreen FINISH: No ads to show");
            finish();
        } else {
            Logger.logInfo("AlarmAlertFullScreen FINISH ADMOB: loaded, showing interstitial ");
            this.interstitialAd.show();
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAdShown(3, this.interstitialAd.getPlacementId());
            finish();
        }
    }

    private void showNotification(int i) {
        if (this.alarm != null) {
            Logger.logInfo("AlarmAlertFullScreen: Showing alarm notification.");
            NotificationsKt.notify(this, i, AlarmKlaxon.prepareStandardNotification(this, this.alarm, getClass()));
        }
    }

    private void showNotificationHeadups(int i) {
        if (this.alarm != null) {
            Logger.logInfo("AlarmAlertFullScreen: Showing alarm head-ups notification.");
            NotificationsKt.notify(this, i, AlarmKlaxon.prepareHeadsUpNotification(this, this.alarm, getClass(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSnoozeChooser() {
        Object[] allowedSnoozeValues = getAllowedSnoozeValues();
        if (allowedSnoozeValues == null) {
            return;
        }
        String[] strArr = (String[]) allowedSnoozeValues[0];
        String[] strArr2 = (String[]) allowedSnoozeValues[1];
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setItems((CharSequence[]) strArr, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda21(this, strArr2, 2));
        materialAlertDialogBuilder.setCancelable(false);
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        this.snoozeDialog = alertDialogCreate;
        alertDialogCreate.setTitle(getResources().getString(R.string.snooze_duration_title));
        this.snoozeDialog.setOwnerActivity(this);
        this.snoozeDialog.setCancelable(true);
        this.snoozeDialog.show();
        DialogUtil.fixDivider(this.snoozeDialog);
    }

    private void showWarning(String str, String str2) {
        findViewById(R.id.warning_box).setVisibility(0);
        ((TextView) findViewById(R.id.warning_title)).setText(str);
        ((TextView) findViewById(R.id.warning_desc)).setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void snooze() {
        Logger.logDebug("AlarmAlertFullScreen snooze");
        if (findViewById(R.id.snooze) != null && (findViewById(R.id.snooze).getVisibility() != 0 || !findViewById(R.id.snooze).isEnabled())) {
            Logger.logInfo("AlarmAlertFullScreen: Ignoring disabled snooze");
            return;
        }
        int snoozeMinutes = Alarm.getSnoozeMinutes(this.alarm, false);
        if (snoozeMinutes > 0 && Alarm.isSnoozeEnabled(this.alarm)) {
            performSnooze(snoozeMinutes, false);
        } else if (findViewById(R.id.snooze) != null) {
            findViewById(R.id.snooze).setElevation(0.0f);
            findViewById(R.id.snooze).setEnabled(false);
            ((TextView) findViewById(R.id.snooze_text)).setText(R.string.snooze_limit_title);
            findViewById(R.id.snooze_text_desc).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void snoozeLongClick() {
        Logger.logDebug("AlarmAlertFullScreen snooze long clicked");
        if (!findViewById(R.id.snooze).isEnabled()) {
            Logger.logInfo("AlarmAlertFullScreen: Killing alarm on snooze.. snooze not enabled");
            dismiss(false, CurrentSleepRecord.getInstance().getRecord());
        } else if (SharedApplicationContext.getSettings().isAllowSnoozeTimeChange()) {
            showSnoozeChooser();
        }
    }

    private void unlockOrientation() {
        Logger.logInfo("AlarmAlertFullScreen: unlock orientation:");
        setRequestedOrientation(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        Logger.logDebug("AlarmAlertFullScreen: AlarmAlertFullScreen updateLayout");
        setContentView(R.layout.dialog_alarm_alert_new);
        ToolbarUtil.apply(this);
        this.volumeIcon = (ImageView) findViewById(R.id.volume_icon);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.volume_progress);
        this.volumeProgress = progressBar;
        progressBar.setMax(100);
        findViewById(R.id.volume_indicator).setVisibility(this.doGradualVolumeUp ? 0 : 8);
        if (Environment.isHoneycombOrGreater()) {
            ActivityUtils.setFinishOnTouchOutside(this, false);
        }
        int snoozeMinutes = Alarm.getSnoozeMinutes(this.alarm, false);
        View viewFindViewById = findViewById(R.id.snooze);
        boolean z = true;
        viewFindViewById.setLongClickable(true);
        ((TextView) findViewById(R.id.snooze_text)).setText(getString(R.string.alarm_alert_snooze_text));
        ((TextView) findViewById(R.id.snooze_text_desc)).setText(snoozeMinutes + " " + getString(R.string.bed_time_min));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.logInfo("AlarmAlertFullScreen: Snooze button clicked");
                AlarmAlertFullScreen.this.snoozeClicked = true;
                AlarmAlertFullScreen.this.snooze();
            }
        });
        viewFindViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AlarmAlertFullScreen.this.snoozeLongClick();
                return true;
            }
        });
        boolean zIsDismissLongPress = SharedApplicationContext.getSettings().isDismissLongPress();
        if (Alarm.isSnoozeEnabled(this.alarm) && snoozeMinutes > 0) {
            z = false;
        }
        if (z) {
            Logger.logInfo("AlarmAlertFullScreen: SNOOZE disabled ");
            findViewById(R.id.snooze).setElevation(0.0f);
            ((CardView) findViewById(R.id.snooze)).setCardBackgroundColor(ColorUtil.i(this, R.color.bg_main_dark));
            findViewById(R.id.snooze).setOnClickListener(null);
            findViewById(R.id.snooze).setOnLongClickListener(null);
            ((TextView) findViewById(R.id.snooze_text)).setText(Alarm.getSnoozeDisableReason(this, this.alarm));
            ((TextView) findViewById(R.id.snooze_text)).setTextColor(getResources().getColor(R.color.white_tertiary));
            findViewById(R.id.snooze_text_desc).setVisibility(8);
            findViewById(R.id.snooze_text_parent).setPadding(ActivityUtils.getDip(this, 16), ActivityUtils.getDip(this, 16), ActivityUtils.getDip(this, 16), ActivityUtils.getDip(this, 16));
            findViewById(R.id.snooze_options).setVisibility(8);
        }
        Logger.logInfo("AlamrAlertFullScreen: refresh snooze, disabled: " + z + " " + findViewById(R.id.snooze).isEnabled() + " " + SharedApplicationContext.getSettings().isAllowSnoozeTimeChange());
        if (SharedApplicationContext.getSettings().isAllowSnoozeTimeChange() && findViewById(R.id.snooze).isEnabled() && !z) {
            findViewById(R.id.snooze_options).setVisibility(0);
            refreshSnoozeOptions();
        }
        View viewFindViewById2 = findViewById(R.id.dismiss);
        viewFindViewById2.setOnClickListener(new AnonymousClass7(zIsDismissLongPress));
        viewFindViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$updateLayout$1(view);
            }
        });
        setTitle();
    }

    public void dismissOrStartCaptcha() {
        this.cancelRestart = true;
        CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(this.alarm);
        if (captchaInfo == null || this.captchaPassed) {
            Logger.logDebug("AlarmAlertFullScreen: No captcha required");
            this.settings.cleanLastNonSnoozeAlarm();
            handleCaptchaProvenDismissClick();
            return;
        }
        Logger.logInfo("AlarmAlertFullScreen: Starting captcha -> " + captchaInfo);
        SharedApplicationContext.getCaptchaManager().getLauncher(this.alarm).addFlags(131072).start(captchaInfo);
        Alarms.trackCaptchaAchievement(captchaInfo);
        this.captchaInProgress = true;
        CAPTCHA_IN_PROGRESS = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = keyEvent.getAction() == 1;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 24 && keyCode != 25 && keyCode != 27 && keyCode != 80) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (z) {
            int i = this.volumeBehavior;
            if (i == 1) {
                snooze();
            } else if (i == 2) {
                Logger.logDebug("Sending alarm dismiss due to key action");
                dismissOrStartCaptcha();
            }
        }
        return true;
    }

    public boolean isCaptchaInProgress() {
        return this.captchaInProgress;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Logger.logDebug("Back not allowed");
    }

    public void onCaptchaResult(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra("captcha_result_left") || intent.hasExtra("captcha_result_success")) {
                this.captchaInProgress = false;
                CAPTCHA_IN_PROGRESS = false;
                if (!intent.hasExtra("captcha_result_success")) {
                    Logger.logDebug("AlarmAlertFullScreen: Captcha result failed");
                    this.cancelRestart = false;
                    ContextExtKt.sendExplicitBroadcast(this, new Intent("com.urbandroid.sleep.alarmclock.ALARM_RESUME"));
                } else {
                    Logger.logDebug("AlarmAlertFullScreen: Captcha result success");
                    this.captchaPassed = true;
                    this.settings.cleanLastNonSnoozeAlarm();
                    handleCaptchaProvenDismissClick();
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Logger.logInfo("AlarmAlertFullScreen: onConfigurationChanged orientation " + configuration.orientation);
        if ((getResources().getConfiguration().screenLayout & 15) >= 3) {
            return;
        }
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("AlarmAlertFullScreen: asjust screen for orientation "), configuration.orientation);
        int i = configuration.orientation;
        if (i == 2) {
            View viewFindViewById = findViewById(R.id.snooze_layout);
            if (viewFindViewById != null) {
                ViewUtil.setMargins(viewFindViewById, 0, -24, 0, 0);
            }
            View viewFindViewById2 = findViewById(R.id.dismiss_layout);
            if (viewFindViewById2 != null) {
                ViewUtil.setMargins(viewFindViewById2, 0, 0, 0, -28);
            }
            View viewFindViewById3 = findViewById(R.id.alertTitle);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(8);
            }
            View viewFindViewById4 = findViewById(R.id.volume_indicator);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(8);
            }
            View viewFindViewById5 = findViewById(R.id.timeDisplay);
            if (viewFindViewById5 != null) {
                ((TextView) viewFindViewById5).setTextSize(32.0f);
                return;
            }
            return;
        }
        if (i == 1) {
            View viewFindViewById6 = findViewById(R.id.snooze_layout);
            if (viewFindViewById6 != null) {
                ViewUtil.setMargins(viewFindViewById6, 0, 0, 0, 0);
            }
            View viewFindViewById7 = findViewById(R.id.dismiss_layout);
            if (viewFindViewById7 != null) {
                ViewUtil.setMargins(viewFindViewById7, 0, 0, 0, 0);
            }
            View viewFindViewById8 = findViewById(R.id.alertTitle);
            if (viewFindViewById8 != null) {
                viewFindViewById8.setVisibility(0);
            }
            View viewFindViewById9 = findViewById(R.id.volume_indicator);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
            View viewFindViewById10 = findViewById(R.id.timeDisplay);
            if (viewFindViewById10 != null) {
                ((TextView) viewFindViewById10).setTextSize(62.0f);
            }
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = new Handler();
        Settings settings = new Settings(this);
        this.settings = settings;
        this.lockOrientation = settings.isDisableScreenRotate();
        Window window = getWindow();
        if (!this.settings.isScreenLight()) {
            Logger.logInfo("AlarmAlertFullScreen: remove screen on flag");
            window.clearFlags(128);
        } else if (!getIntent().getBooleanExtra("screen_off", false)) {
            window.addFlags(2097280);
        }
        KeyguardUtil.disable(this);
        if (getResources().getBoolean(R.bool.portrait_only) && this.lockOrientation) {
            setRequestedOrientation(1);
        }
        if (getIntent() != null && getIntent().hasExtra("klaxon_restart")) {
            long j = AlarmKlaxon.LAST_FINISHED_TIME;
            if (j != 0 && j > System.currentTimeMillis() - 15000) {
                Logger.logInfo("AlarmAlertFullScreen FINISH: Ignoring restart of AlarmAlertFullScreen from klaxon. Alarm finished very recently");
                this.mReceiver = null;
                finishAndCancelRestarting();
                return;
            }
        }
        try {
            getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.black));
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        GlobalInitializator.initializeIfRequired(this);
        currentClass = getClass();
        Logger.logDebug("AlarmAlertFullScreen: onCreate() ");
        if (getIntent() != null) {
            Logger.logDebug("AlarmAlertFullScreen: onCreate() " + getIntent().getStringExtra("CREATION_SOURCE"));
        }
        if (this.lockOrientation) {
            Logger.logDebug("AlarmAlertFullScreen: lock orientation ");
            lockOrientation();
        }
        Alarm fromIntent = Alarm.parseFromIntent(getIntent());
        this.alarm = fromIntent;
        if (fromIntent == null && bundle != null) {
            this.alarm = Alarm.parseFromBundle(bundle);
        }
        Logger.logInfo("AlarmAlertFullScreen: alarm " + Alarm.toDebugString(this.alarm));
        if (this.alarm == null) {
            this.alarm = AlarmKlaxon.currentAlarm;
            Logger.logInfo("AlarmAlertFullScreen: restoring alarm from service " + Alarm.toDebugString(this.alarm));
        }
        if (bundle != null && bundle.getBoolean("ad", false)) {
            Logger.logInfo("AlarmAlertFullScreen: create after ADMOB ");
            this.isAdMode = true;
        }
        Logger.logInfo("AlarmAlertFullScreen: Alarm " + this.alarm);
        Alarm alarm = this.alarm;
        if (alarm == null) {
            this.doGradualVolumeUp = false;
            Logger.logWarning("AlarmAlertFullScreen: Alarm null in AAFS");
            try {
                ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Alarm null", 5);
            } catch (Exception unused) {
            }
        } else {
            this.doGradualVolumeUp = alarm.isGradualVolumeIncrease(this);
        }
        this.volumeBehavior = this.settings.getVolumeButtonBehavior();
        this.maxSnooze = Alarm.maxSnoozeMinutes(this.alarm);
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("AlarmAlertFullScreen: max snooze "), this.maxSnooze);
        updateLayout();
        Logger.logInfo("AlarmAlertFullScreen: Registering AAFS receiver");
        IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.alarmclock.alarm_killed");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_DISMISS");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA");
        intentFilter.addAction("com.urbandroid.sleep.ACCEL_GESTURE_FLIP_ACTION");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_VOLUME_UPDATE");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_NOTIF_SNOOZE");
        intentFilter.addAction("com.urbandroid.sleep.SCREENLIGHT_ACTION");
        ContextCompat.registerReceiver(this, this.mReceiver, intentFilter, 2);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mReceiver, intentFilter);
        if (bundle == null) {
            handleStartExtra(getIntent());
        }
        onCaptchaResult(getIntent());
        if (TrialFilter.getInstance().isTimeToShowInterstitialAds() && getIntent() != null && !getIntent().hasExtra("captcha_result_left") && !getIntent().hasExtra("captcha_result_success")) {
            Logger.logInfo("MOPUB ADMOB: request");
            requestNewInterstitial(new AdLoadedListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.2
                @Override // com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.AdLoadedListener
                public void onClose() {
                    Logger.logInfo("AlarmAlertFullScreen ADMOB: FINISH closed ");
                    Intent intent = new Intent(AlarmAlertFullScreen.this, (Class<?>) AlarmClock.class);
                    intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
                    intent.putExtra("after_interstitial_ad", true);
                    AlarmAlertFullScreen.this.startActivity(intent);
                    try {
                        AlarmAlertFullScreen.this.finish();
                    } catch (Exception e2) {
                        Logger.logSevere(e2);
                    }
                }
            });
        }
        onConfigurationChanged(getResources().getConfiguration());
        if (this.settings.isWakeUpCheck() && this.alarm != null && this.settings.getWakeUpCheckScheduledAlarmId() == this.alarm.id) {
            showWarning(getString(R.string.settings_wake_up_check), getString(R.string.wake_up_check_expl_more) + " " + getString(R.string.settings_wake_up_check_after_alarm) + " " + (this.settings.getWakeUpCheckAfterAlarm() / 60000) + " " + getString(R.string.bed_time_min) + ".");
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lockOrientation) {
            unlockOrientation();
        }
        Logger.logDebug("AlarmAlertFullScreen destroy: " + this + " Klaxon still running: " + AlarmKlaxon.isRunning());
        Logger.logInfo("AlarmAlertFullScreen: Unregistering AAFS receiver");
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
                LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mReceiver);
            } catch (Exception unused) {
            }
        }
        if (!AlarmKlaxon.isRunning()) {
            hideNotification(34377266);
        }
        currentClass = null;
        hideNotification(6305);
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        SHOWN = false;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Alarm fromIntent = Alarm.parseFromIntent(intent);
        if (fromIntent != null) {
            Logger.logInfo("AlarmAlertFullScreen: alarm " + Alarm.toDebugString(fromIntent));
            this.alarm = fromIntent;
            setTitle();
        }
        if (!isNfcAlarm() || !NFCScannerHelper.isNfcIntent(intent)) {
            this.maxSnooze = Alarm.maxSnoozeMinutes(this.alarm);
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("AlarmAlertFullScreen: max snooze "), this.maxSnooze);
            updateLayout();
            handleStartExtra(intent);
            onCaptchaResult(intent);
            return;
        }
        Logger.logInfo("AlarmAlertFullScreen:Handling NFC intent");
        NFCCaptcha.TagStringRepresentation scannedValue = NFCScannerHelper.parseScannedValue(intent);
        String[] nFCCaptcha = SharedApplicationContext.getSettings().getNFCCaptcha();
        if (scannedValue == null || nFCCaptcha == null) {
            return;
        }
        for (String str : nFCCaptcha) {
            if (NFCScannerHelper.isValueEqual(scannedValue, str)) {
                Logger.logInfo("AlarmAlertFullScreen::NFC captcha solved");
                nfcCaptchaSolved();
                return;
            }
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.turnScreenOff);
        NFCScannerHelper nFCScannerHelper = this.nfcScannerHelper;
        if (nFCScannerHelper != null) {
            nFCScannerHelper.terminateScan();
            this.nfcScannerHelper = null;
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        CaptchaInfo captchaInfo;
        super.onResume();
        Logger.logDebug("AlarmAlertFullScreen: onResume()");
        if (this.alarm == null || Alarms.getAlarm(getContentResolver(), this.alarm.id) == null) {
            if (findViewById(R.id.snooze) != null) {
                findViewById(R.id.snooze).setVisibility(8);
            }
            if (findViewById(R.id.snooze_options) != null) {
                findViewById(R.id.snooze_options).setVisibility(8);
            }
        }
        if (this.alarm == null || (captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(this.alarm)) == null || !NFCCaptcha.class.getName().equals(captchaInfo.getActivityName())) {
            return;
        }
        NFCScannerHelper nFCScannerHelper = new NFCScannerHelper(this);
        this.nfcScannerHelper = nFCScannerHelper;
        nFCScannerHelper.initiateReadTag();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Alarm alarm = this.alarm;
        if (alarm != null) {
            bundle.putByteArray("intent.extra.alarm_raw", alarm.serializeToArray());
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        RESTART_ME = false;
        SHOWN = true;
        cancelRestarting();
        if (this.cancelRestart || !Experiments.getInstance().isHeadupsWhenLeavingAlarmScreen()) {
            return;
        }
        hideNotification(6305);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        SHOWN = false;
        if (!this.snoozeClicked && !this.dismissClicked) {
            RESTART_ME = true;
        }
        ActivityStateUtil.dismiss(this.snoozeDialog);
        this.snoozeDialog = null;
        if (isRestarting(this.alarm)) {
            this.restartRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen.8
                @Override // java.lang.Runnable
                public void run() {
                    AlarmAlertFullScreen.this.log("Restarting onStop() performed");
                    AlarmAlertFullScreen.restart(AlarmAlertFullScreen.this.getApplicationContext(), AlarmAlertFullScreen.this.alarm);
                }
            };
            new Handler().postDelayed(this.restartRunnable, 300L);
            log("Restarting onStop() scheduled");
        }
        if (RESTART_ME && AlarmKlaxon.isRunning() && !this.cancelRestart && Experiments.getInstance().isHeadupsWhenLeavingAlarmScreen() && !isFinishing() && (!this.settings.isCaptchaNoEscape() || CaptchaAntiCheatingAccessibilityService.getInstance() == null)) {
            showNotificationHeadups(6305);
        }
        this.h.removeCallbacks(this.turnScreenOff);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Logger.logDebug("Flashlight: Creating surface holder.");
        SharedApplicationContext.getInstance().getFlashlightService().surfaceCreated(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Logger.logDebug("Flashlight: Destroying surface holder.");
        SharedApplicationContext.getInstance().getFlashlightService().surfaceDestroyed();
    }
}
