package com.urbandroid.sleep;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda9;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PowerManagerCompat;
import com.urbandroid.sleep.Instructions.Instructions;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.ads.AdMobController;
import com.urbandroid.sleep.ads.IAdsController;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.BedtimeReceiver;
import com.urbandroid.sleep.alarmclock.DigitalClock;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.RatingActivity;
import com.urbandroid.sleep.alarmclock.ToastMaster;
import com.urbandroid.sleep.alarmclock.directorypicker.DirectoryPicker;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordChangeListener;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.graph.GraphUpdateSleepRecordListener;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.SquigglyProgress;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.drawer.DrawerRecyclerViewAdapter;
import com.urbandroid.sleep.gui.drawer.EntryItem;
import com.urbandroid.sleep.hr.BluetoothHrService;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;
import com.urbandroid.sleep.media.lullaby.LullabyDialogFragment;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.mic.RecordingUpdate;
import com.urbandroid.sleep.service.FlashlightServiceAndroidM;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.NotificationHandler;
import com.urbandroid.sleep.share.util.CommentBuilderUtil;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.util.ActivityStateUtil;
import com.urbandroid.util.AirplaneModeUtil;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.FixButtonColorOnShowDialogListener;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.TtsService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class Sleep extends BaseActivity implements View.OnTouchListener, View.OnClickListener {
    public static int DIM_AFTER = 15;
    public static int DIM_AFTER_BOTTOM_SHEET = 120;
    private static boolean FLASHLIGHT_ON = false;
    public static boolean RUNNING = false;
    private IAdsController adMobController;
    private Alarm alarm;
    private Thread aliveLoggingThread;
    private Animation animFlyIn;
    private Animation animFlyOut;
    private Animation animPulse;
    private View batterySaveIndicator;
    private BottomSheetBehavior bottomSheetBehavior;
    private DigitalClock digitalClock;
    private EntryItem disableItem;
    private RecyclerView drawerList;
    private GestureDetector gestureDetector;
    private GraphView graph;
    private SleepRecordChangeListener graphChangeListener;
    private Handler handler;
    private Instructions instructions;
    private boolean manuallyStarted;
    private ViewGroup pauseIndicator;
    private TextView pauseIndicatorText;
    private MenuItem pauseMenuItem;
    private MenuItem pausePlus5MenuItem;
    private Dialog ratingDialog;
    private LinearProgressIndicator recordingBar;
    private ImageView recordingImg;
    private ViewGroup recordingParent;
    private SleepRestarter restarter;
    private ISleepService sleepService;
    private ViewGroup sleepTrackMain;
    private ViewGroup sleepTrackParent;
    private Long snoozeAlarmTime;
    public volatile int dimCounter = 0;
    private boolean doUpdates = false;
    private boolean alarmReceiverRegistered = false;
    boolean trackingPaused = false;
    private int progressMax = 27000;
    private boolean beeingStopped = false;
    private int dimSetting = 2;
    private boolean hasNavbar = false;
    private boolean wasInAirplaneMode = false;
    private boolean notifiedAboutBluetooth = false;
    private boolean withoutWatch = false;
    private BroadcastReceiver receiver = new AnonymousClass4();
    private BroadcastReceiver localReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.Sleep.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            if (action.equals("com.urbandroid.sleep.ACTION_PAIR_CONNECTION_STATUS_CHANGED")) {
                Sleep.this.instructions.updatePairTrackingStatus();
                return;
            }
            if (action.equals("com.urbandroid.sleep.ACTION_HR_UI_UPDATE") || action.equals("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE")) {
                float floatExtra = intent.getFloatExtra("extra_hr_update", -1.0f);
                if (floatExtra == -1.0f) {
                    floatExtra = intent.getFloatExtra("com.urbandroid.sleep.EXTRA_DATA_HR", -1.0f);
                }
                if (floatExtra > 0.0f) {
                    Sleep.this.handler.removeCallbacks(Sleep.this.hideHrRunnable);
                    if (Sleep.this.findViewById(R.id.hr_indicator).getVisibility() == 8) {
                        Sleep.this.findViewById(R.id.hr_indicator).setVisibility(0);
                        Sleep.this.findViewById(R.id.hr_indicator).clearAnimation();
                        Sleep.this.findViewById(R.id.hr_indicator).startAnimation(Sleep.this.animPulse);
                    }
                    ((TextView) Sleep.this.findViewById(R.id.hr_text)).setText(String.valueOf(Math.round(floatExtra)));
                    ((ImageView) Sleep.this.findViewById(R.id.hr_img)).setImageResource(R.drawable.ic_action_love_big_white);
                    Sleep.this.handler.postDelayed(Sleep.this.hideHrRunnable, 30000L);
                    ((TextView) Sleep.this.findViewById(R.id.hr_text2)).setText("");
                    return;
                }
                return;
            }
            if (action.equals("com.urbandroid.sleep.ACTION_BT_UI_START")) {
                Sleep.this.findViewById(R.id.hr_indicator).setVisibility(0);
                ((TextView) Sleep.this.findViewById(R.id.hr_text)).setText("");
                ((ImageView) Sleep.this.findViewById(R.id.hr_img)).setImageResource(R.drawable.ic_bluetooth_big_white);
                Sleep.this.findViewById(R.id.hr_indicator).clearAnimation();
                Sleep.this.findViewById(R.id.hr_indicator).startAnimation(Sleep.this.animPulse);
                ((TextView) Sleep.this.findViewById(R.id.hr_text2)).setText("");
                return;
            }
            if (action.equals("com.urbandroid.sleep.ACTION_BT_UI_DEVICE")) {
                ((TextView) Sleep.this.findViewById(R.id.hr_text2)).setText(intent.getStringExtra(DeviceRequestsHelper.DEVICE_INFO_DEVICE));
                return;
            }
            if (action.equals("com.urbandroid.sleep.ACTION_BT_UI_END")) {
                Sleep.this.findViewById(R.id.hr_indicator).clearAnimation();
                Sleep.this.findViewById(R.id.hr_indicator).setVisibility(8);
                ((TextView) Sleep.this.findViewById(R.id.hr_text)).setText("");
                ((TextView) Sleep.this.findViewById(R.id.hr_text2)).setText("");
                return;
            }
            if (action.equals("com.urbandroid.sleep.AWAKE")) {
                Sleep.this.instructions.awake(true);
            } else if (action.equals("com.urbandroid.sleep.NOT_AWAKE")) {
                Sleep.this.instructions.awake(false);
            }
        }
    };
    private final Runnable hideHrRunnable = new Sleep$$ExternalSyntheticLambda4(this, 0);
    private final BroadcastReceiver recordingUpdateReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.Sleep.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == null || !intent.getAction().equals(RecordingUpdate.ACTION_RECORDING_UPDATE) || Sleep.this.recordingBar == null) {
                return;
            }
            RecordingUpdate recordingUpdate = new RecordingUpdate(intent);
            Sleep.this.recordingBar.setMax(recordingUpdate.getMax());
            Sleep.this.recordingBar.setProgressCompat(recordingUpdate.getLevel(), true);
            Sleep.this.recordingBar.setSecondaryProgress(recordingUpdate.getThreshold());
            boolean zIsRecording = recordingUpdate.isRecording();
            Sleep sleep = Sleep.this;
            if (zIsRecording) {
                sleep.recordingImg.setImageDrawable(Sleep.this.getResources().getDrawable(R.drawable.rec_on));
            } else {
                sleep.recordingImg.setImageDrawable(Sleep.this.getResources().getDrawable(R.drawable.rec_off));
            }
        }
    };
    private Runnable instructionsUpdater = new Runnable() { // from class: com.urbandroid.sleep.Sleep.7
        @Override // java.lang.Runnable
        public void run() {
            if (Sleep.this.isDoUpdates()) {
                Sleep.this.notifyAboutBluetoothIfRequired();
                SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
                if (!Sleep.this.instructions.isAirplaneDone() && SharedApplicationContext.getSettings().isAirplaneModeOn()) {
                    Sleep.this.instructions.airplaneDone();
                }
                if (!Experiments.getInstance().isFreemiumExperiment()) {
                    Sleep sleep = Sleep.this;
                    if (record != null) {
                        sleep.instructions.trial(!TrialFilter.getInstance().isTrackingEnabledForRecord(record));
                    } else {
                        sleep.instructions.trial(false);
                    }
                }
                SleepLockManager lockManager = SharedApplicationContext.getInstance().getLockManager();
                if (lockManager != null && lockManager.isBatteryStatusKnown()) {
                    Sleep.this.instructions.charging(lockManager.isPluggedIn(), lockManager.getBatteryLevel());
                    Sleep.this.instructions.lowBattery(lockManager.isCannotLockBecauseBatteryStatus());
                }
                Sleep sleep2 = Sleep.this;
                if (sleep2.trackingPaused && !sleep2.dimmingDisabled) {
                    Sleep.this.dimCounter = 0;
                } else if (!Sleep.this.dimmingDisabled && record != null) {
                    Sleep.this.dimCounter++;
                    if (Sleep.this.dimCounter > (Sleep.this.bottomSheetBehavior.getState() == 4 ? Sleep.DIM_AFTER : Sleep.DIM_AFTER_BOTTOM_SHEET)) {
                        Sleep.this.dimCounter = 0;
                        if (!Sleep.this.isDimmed()) {
                            Sleep.this.dimm();
                            Sleep.this.instructions.ignoreAllIgnorable();
                        }
                    }
                }
                if (Sleep.this.sleepService != null) {
                    long remainingPauseMillis = Sleep.this.sleepService.getRemainingPauseMillis();
                    Sleep sleep3 = Sleep.this;
                    if (remainingPauseMillis > 0) {
                        TextView textView = (TextView) sleep3.findViewById(R.id.pause_indicator_add_time);
                        Sleep sleep4 = Sleep.this;
                        sleep4.updatePauseDialogAddTimeText(textView, sleep4.sleepService.isAwakePaused());
                        Sleep.this.pauseIndicatorText.setText(DateUtil.formatMinutes(Integer.valueOf((int) (Sleep.this.sleepService.getRemainingPauseMillis() / 1000))));
                        Sleep sleep5 = Sleep.this;
                        if (!sleep5.trackingPaused || sleep5.pauseIndicator.getVisibility() == 8) {
                            Sleep.this.indicatePauseTracking();
                            Sleep.this.trackingPaused = true;
                        }
                    } else {
                        sleep3.updateElapsedTime(CurrentSleepRecord.getInstance().getRecord());
                        Sleep sleep6 = Sleep.this;
                        if (sleep6.trackingPaused) {
                            sleep6.indicateResumeTracking();
                            Sleep.this.trackingPaused = false;
                        }
                    }
                    if (Sleep.this.sleepService.isDisabled() && Sleep.this.batterySaveIndicator.getVisibility() == 8) {
                        Sleep.this.batterySaveIndicator.setVisibility(0);
                    } else if (!Sleep.this.sleepService.isDisabled() && Sleep.this.batterySaveIndicator.getVisibility() == 0) {
                        Sleep.this.batterySaveIndicator.setVisibility(8);
                    }
                }
                Sleep.this.instructions.showDndWarning();
                Sleep.this.handler.postDelayed(this, 1000L);
            }
        }
    };
    Runnable updateGraphRunnable = new Runnable() { // from class: com.urbandroid.sleep.Sleep.8
        @Override // java.lang.Runnable
        public void run() {
            if (!Sleep.this.isDimmed()) {
                Sleep.this.graph.invalidate();
            }
            Sleep.this.handler.postDelayed(this, 100L);
        }
    };
    private Runnable instructionsUpdaterSlow = new Runnable() { // from class: com.urbandroid.sleep.Sleep.9
        @Override // java.lang.Runnable
        public void run() {
            if (Sleep.this.isDoUpdates()) {
                SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
                if (record != null) {
                    Sleep.this.instructions.alarm(Sleep.this.alarm, Sleep.this.snoozeAlarmTime);
                }
                Sleep.this.updateElapsedTime(record);
                Sleep.this.handler.postDelayed(this, 10000L);
            }
        }
    };
    private Runnable cheapUpdaterSlow = new Runnable() { // from class: com.urbandroid.sleep.Sleep.10
        @Override // java.lang.Runnable
        public void run() {
            if (Sleep.this.beeingStopped) {
                return;
            }
            if ((Sleep.this.dimSetting == 4 || Sleep.this.dimSetting == 5) && Sleep.this.digitalClock.getVisibility() == 0) {
                ActivityUtils.randomGravity(Sleep.this.digitalClock);
            }
            Sleep.this.handler.postDelayed(this, 10000L);
        }
    };
    private boolean dimmed = false;
    private boolean dimmingDisabled = false;
    private int currentBrightness = -1;
    private float currentBrightnessFloat = -1.0f;
    private boolean serviceIsBound = false;
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.urbandroid.sleep.Sleep.16
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Sleep.this.sleepService = ((SleepService.SleepServiceBinder) iBinder).getService();
            if (Sleep.this.sleepService != null) {
                Sleep.this.instructions.awake(Sleep.this.sleepService.isAwakePaused());
            }
            Sleep.this.updateBatteryDisabledIndicators();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Sleep.this.sleepService = null;
            Sleep.this.serviceIsBound = false;
            Sleep.this.finish();
        }
    };

    /* JADX INFO: renamed from: com.urbandroid.sleep.Sleep$1, reason: invalid class name */
    public class AnonymousClass1 extends BottomSheetBehavior.BottomSheetCallback {
        final /* synthetic */ ViewGroup val$stopAndSaveView;

        public AnonymousClass1(ViewGroup viewGroup) {
            this.val$stopAndSaveView = viewGroup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStateChanged$0(View view) {
            SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
            if (record == null || record.isTooShortToSave()) {
                Sleep.this.userConfirmedStopAndExit(false, record);
            } else {
                Sleep.this.userConfirmedStopAndExit(true, record);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStateChanged$1(View view) {
            Sleep.this.bottomSheetBehavior.setState(3);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
            ImageView imageView = (ImageView) Sleep.this.findViewById(R.id.stop_and_save);
            ViewGroup viewGroup = (ViewGroup) Sleep.this.findViewById(R.id.stop_and_save_parent);
            View viewFindViewById = Sleep.this.findViewById(R.id.gap);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            int iRound = Math.round(ActivityUtils.getDip(Sleep.this, 16) * f);
            imageView.setPadding(iRound, iRound, iRound, iRound);
            layoutParams2.setMargins(0, 0, 0, iRound / 2);
            layoutParams.setMargins(0, iRound * 7, 0, 0);
            viewGroup.setLayoutParams(layoutParams);
            imageView.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = iRound;
            viewFindViewById.setLayoutParams(layoutParams3);
            Sleep.this.findViewById(R.id.bottom_sheet).setBackgroundColor(ColorUtil.interpolate(f, Sleep.this.getResources().getColor(R.color.transparent), Sleep.this.getResources().getColor(R.color.bg_main_dark)));
            DrawerRecyclerViewAdapter drawerRecyclerViewAdapter = (DrawerRecyclerViewAdapter) Sleep.this.drawerList.getAdapter();
            if (f > 0.1f) {
                imageView.setImageResource(R.drawable.ic_action_cancel_white);
                imageView.setBackgroundResource(R.drawable.btn_circle_attention);
                if (drawerRecyclerViewAdapter.isShowCircle()) {
                    return;
                }
                drawerRecyclerViewAdapter.setShowCircle(true);
                drawerRecyclerViewAdapter.notifyDataSetChanged();
                return;
            }
            imageView.setImageResource(R.drawable.arrow_up_white);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams4.setMargins(0, ActivityUtils.getDip(Sleep.this, 40), 0, 0);
            viewGroup.setLayoutParams(layoutParams4);
            imageView.setLayoutParams(layoutParams2);
            imageView.setBackgroundResource(0);
            if (drawerRecyclerViewAdapter.isShowCircle()) {
                drawerRecyclerViewAdapter.setShowCircle(false);
                drawerRecyclerViewAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            try {
                if (i == 3) {
                    final int i2 = 0;
                    this.val$stopAndSaveView.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.Sleep$1$$ExternalSyntheticLambda0
                        public final /* synthetic */ Sleep.AnonymousClass1 f$0;

                        {
                            this.f$0 = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            int i3 = i2;
                            Sleep.AnonymousClass1 anonymousClass1 = this.f$0;
                            switch (i3) {
                                case 0:
                                    anonymousClass1.lambda$onStateChanged$0(view2);
                                    break;
                                default:
                                    anonymousClass1.lambda$onStateChanged$1(view2);
                                    break;
                            }
                        }
                    });
                    Sleep.this.getWindow().setNavigationBarColor(ColorUtil.i(Sleep.this, R.color.drawer_dark_dark));
                } else if (i == 4) {
                    final int i3 = 1;
                    this.val$stopAndSaveView.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.Sleep$1$$ExternalSyntheticLambda0
                        public final /* synthetic */ Sleep.AnonymousClass1 f$0;

                        {
                            this.f$0 = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            int i32 = i3;
                            Sleep.AnonymousClass1 anonymousClass1 = this.f$0;
                            switch (i32) {
                                case 0:
                                    anonymousClass1.lambda$onStateChanged$0(view2);
                                    break;
                                default:
                                    anonymousClass1.lambda$onStateChanged$1(view2);
                                    break;
                            }
                        }
                    });
                    Sleep.this.getWindow().setNavigationBarColor(ColorUtil.i(Sleep.this, R.color.black));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.Sleep$2, reason: invalid class name */
    public class AnonymousClass2 extends NotificationHandler {
        final /* synthetic */ boolean val$enableAirplane;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, boolean z) {
            super(context);
            this.val$enableAirplane = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFinished$0(boolean z) {
            if (z) {
                AirplaneModeUtil.enableAirplaneMode(Sleep.this, false);
            }
        }

        @Override // com.urbandroid.sleep.share.IHandler
        public void onFinished() {
            Handler handler = Sleep.this.handler;
            final boolean z = this.val$enableAirplane;
            handler.post(new Runnable() { // from class: com.urbandroid.sleep.Sleep$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFinished$0(z);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.Sleep$4, reason: invalid class name */
    public class AnonymousClass4 extends BroadcastReceiver {
        public AnonymousClass4() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            Logger.logInfo("Sleep: received ".concat(action));
            if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_ALERT")) {
                Logger.logInfo("Sleep: ALARM_ALERT");
                Sleep.this.removeGraphListener();
                if (Sleep.this.isDimmed()) {
                    Sleep.this.undimm();
                }
                Sleep.this.dimmingDisabled = true;
                Sleep sleep = Sleep.this;
                if (sleep.trackingPaused) {
                    sleep.resumeTracking();
                    return;
                }
                return;
            }
            if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE") || action.equals("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION")) {
                Sleep.this.initGraphListener();
                Sleep.this.dimmingDisabled = false;
                Logger.logInfo("Dim: ALARM_SNOOZE " + Sleep.this.dimCounter + " disabled " + Sleep.this.dimmingDisabled);
                return;
            }
            if (action.equals("com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STOPPED")) {
                Sleep.this.unbindSleepService();
                Sleep.this.handler.postDelayed(new Sleep$4$$ExternalSyntheticLambda0(), 60000L);
                Sleep.this.finish();
                return;
            }
            if (action.equals("com.urbandroid.sleep.ACTION_TRACKING_UPDATE_SMARTWATCH")) {
                Sleep.this.updateSmartwatchAlarm();
                return;
            }
            if (action.equals("recording_initialization_failed")) {
                if (Sleep.this.instructions != null) {
                    Sleep.this.instructions.showRecordingFailed();
                }
            } else if (action.equals("ultrasound_recording_initialization_failed")) {
                if (Sleep.this.instructions != null) {
                    Sleep.this.instructions.showSonarRecordingInitializationFailed();
                }
            } else if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                Sleep.this.instructions.updateSonarHeadset();
            }
        }
    }

    private void bindSleepService() {
        log("Binding sleep service.");
        this.serviceIsBound = bindService(new Intent(this, (Class<?>) SleepService.getServiceClass(this)), this.serviceConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dimm() {
        logDebug("Dimming screen. Current: " + this.dimmed);
        if (!isAnyDimmingModeEnabled() || isDimmed()) {
            return;
        }
        this.bottomSheetBehavior.setState(4);
        setDimmed(true);
        switchDim();
        stopUpdates();
    }

    private void explicitRecording() {
        if (this.sleepService != null) {
            Toast toastMakeText = Toast.makeText(this, R.string.speak_now, 1);
            ToastMaster.setToast(toastMakeText);
            toastMakeText.show();
            this.sleepService.doExplicitRecording();
        }
    }

    private String getEnableBatterySavingIntemText() {
        String string = getString(R.string.enable_battery_save);
        if (string == null) {
            return string;
        }
        try {
            return string.indexOf("(") > 0 ? string.substring(0, string.indexOf("(") - 1) : string;
        } catch (Exception unused) {
            return string;
        }
    }

    private String getTrackingTime(SleepRecord sleepRecord) {
        return sleepRecord != null ? DateUtil.formatHoursMinutesSeconds(((int) (System.currentTimeMillis() - sleepRecord.getFrom().getTime())) / 1000) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShowCase() {
        Logger.logInfo("Showcase: ? ");
        if (SharedApplicationContext.getSettings().isShowCaseShown("sc_tracking_2")) {
            return;
        }
        SharedApplicationContext.getSettings().addShowCaseShown("sc_tracking_2");
        Logger.logInfo("Showcase: TRUE ");
        try {
            new TapTargetSequence(this).targets(TapTarget.forView(findViewById(R.id.stopHint), getResources().getString(R.string.menu_stop_save), getResources().getString(R.string.tracking_in_progress_battery_warning_slide)).dimColor(R.color.transparent_black).outerCircleColor(R.color.tap_target_color_dark).tintTarget(false).cancelable(true).id(0).textColor(R.color.white), TapTarget.forView(this.pauseMenuItem.getActionView(), getString(R.string.awake) + "?", getString(R.string.menu_pause_tracking)).dimColor(R.color.transparent_black).outerCircleColor(R.color.tap_target_color_dark).tintTarget(false).id(1).cancelable(true).textColor(R.color.white)).listener(new TapTargetSequence.Listener() { // from class: com.urbandroid.sleep.Sleep.22
                @Override // com.getkeepsafe.taptargetview.TapTargetSequence.Listener
                public void onSequenceCanceled(TapTarget tapTarget) {
                }

                @Override // com.getkeepsafe.taptargetview.TapTargetSequence.Listener
                public void onSequenceFinish() {
                }

                @Override // com.getkeepsafe.taptargetview.TapTargetSequence.Listener
                public void onSequenceStep(TapTarget tapTarget, boolean z) {
                }
            }).start();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    private void hideHint() {
        findViewById(R.id.hint).setVisibility(8);
    }

    private void hideNavBar() {
        if (this.hasNavbar) {
            getWindow().getDecorView().setSystemUiVisibility(5126);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void indicatePauseTracking() {
        MenuItem menuItem = this.pauseMenuItem;
        if (menuItem != null) {
            menuItem.setIcon(R.drawable.ic_action_play_white);
            ((ImageView) this.pauseMenuItem.getActionView().findViewById(android.R.id.icon)).setImageResource(R.drawable.ic_action_play_white);
            ((ImageView) this.pauseMenuItem.getActionView().findViewById(android.R.id.icon)).setBackgroundResource(R.drawable.circle_positive);
            ((ImageView) this.pausePlus5MenuItem.getActionView().findViewById(android.R.id.icon)).setImageResource(R.drawable.ic_action_pause_plus_white);
            ((ImageView) this.pausePlus5MenuItem.getActionView().findViewById(android.R.id.icon)).setBackgroundResource(R.drawable.circle_negative);
            this.pausePlus5MenuItem.setVisible(true);
            this.pauseIndicatorText.setText(DateUtil.formatMinutes(Integer.valueOf((int) (this.sleepService.getRemainingPauseMillis() / 1000))));
            if (this.sleepService != null) {
                updatePauseDialogAddTimeText((TextView) findViewById(R.id.pause_indicator_add_time), this.sleepService.isAwakePaused());
            }
            this.pauseIndicator.setVisibility(0);
            this.pauseIndicator.startAnimation(this.animFlyIn);
            ((SquigglyProgress) ((ImageView) findViewById(R.id.squigllyProgress)).getDrawable()).setAnimate(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void indicateResumeTracking() {
        MenuItem menuItem = this.pauseMenuItem;
        if (menuItem != null) {
            menuItem.setIcon(R.drawable.ic_action_pause_white);
            this.pausePlus5MenuItem.setVisible(false);
            log("Pause indicator " + this.pauseIndicator);
            this.pauseIndicatorText.setText("0:00");
            this.pauseIndicator.startAnimation(this.animFlyOut);
            this.pauseIndicator.setVisibility(8);
            ((ImageView) this.pauseMenuItem.getActionView().findViewById(android.R.id.icon)).setImageResource(R.drawable.ic_action_pause_white);
            ((ImageView) this.pauseMenuItem.getActionView().findViewById(android.R.id.icon)).setBackgroundResource(R.drawable.empty);
            ((SquigglyProgress) ((ImageView) findViewById(R.id.squigllyProgress)).getDrawable()).setAnimate(true);
        }
    }

    private ArrayList<EntryItem> initDrawer() {
        ArrayList<EntryItem> arrayList = new ArrayList<>();
        EntryItem entryItem = new EntryItem("", R.drawable.empty_ab) { // from class: com.urbandroid.sleep.Sleep.17
            @Override // com.urbandroid.sleep.gui.drawer.EntryItem
            public void onClick() {
            }
        };
        arrayList.add(new EntryItem(getString(R.string.smartlight_peelight), R.drawable.ic_flashlight_white) { // from class: com.urbandroid.sleep.Sleep.18
            @Override // com.urbandroid.sleep.gui.drawer.EntryItem
            public void onClick() {
                Sleep.this.toggleSmartlight();
                SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
                boolean zIsPermissionGranted = sleepPermissionCompat.isPermissionGranted(Sleep.this.getApplicationContext(), "android.permission.CAMERA");
                Sleep sleep = Sleep.this;
                if (zIsPermissionGranted) {
                    sleep.toggleFlashlight();
                } else {
                    sleepPermissionCompat.requestPermission(sleep, "android.permission.CAMERA", 972);
                }
            }
        });
        arrayList.add(entryItem);
        arrayList.add(new EntryItem(getString(R.string.lullaby), R.drawable.ic_action_lullaby_white) { // from class: com.urbandroid.sleep.Sleep.19
            @Override // com.urbandroid.sleep.gui.drawer.EntryItem
            public void onClick() {
                LullabyActivity.startFromTracking(Sleep.this);
                Sleep.this.bottomSheetBehavior.setState(4);
            }
        });
        arrayList.add(new EntryItem(getString(R.string.tag), R.drawable.ic_pencil_white) { // from class: com.urbandroid.sleep.Sleep.20
            @Override // com.urbandroid.sleep.gui.drawer.EntryItem
            public void onClick() {
                if (CurrentSleepRecord.getInstance().getRecord() != null) {
                    EditActivity.showRatingInTracking(Sleep.this, CurrentSleepRecord.getInstance().getRecord());
                }
                Sleep.this.bottomSheetBehavior.setState(4);
            }
        });
        arrayList.add(entryItem);
        EntryItem entryItem2 = new EntryItem(getEnableBatterySavingIntemText(), R.drawable.ic_battery_60_white) { // from class: com.urbandroid.sleep.Sleep.21
            @Override // com.urbandroid.sleep.gui.drawer.EntryItem
            public void onClick() {
                if (Sleep.this.sleepService != null) {
                    Sleep.this.setBatterySavingMode(!Sleep.this.sleepService.isDisabled());
                } else {
                    Logger.logSevere("Cannot set disabled mode");
                }
                Sleep.this.bottomSheetBehavior.setState(4);
            }
        };
        this.disableItem = entryItem2;
        arrayList.add(entryItem2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGraphListener() {
        SleepRecord record;
        if (this.graphChangeListener != null || (record = CurrentSleepRecord.getInstance().getRecord()) == null) {
            return;
        }
        GraphUpdateSleepRecordListener graphUpdateSleepRecordListener = new GraphUpdateSleepRecordListener(this.graph, this);
        this.graphChangeListener = graphUpdateSleepRecordListener;
        record.addListener(graphUpdateSleepRecordListener);
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
        if (smartWatch != null) {
            smartWatch.setBatchSize(1);
        }
    }

    private boolean isAnyDimmingModeEnabled() {
        return this.dimSetting != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6() {
        View viewFindViewById = findViewById(R.id.hr_indicator);
        if (viewFindViewById == null || isFinishing()) {
            return;
        }
        viewFindViewById.clearAnimation();
        viewFindViewById.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyAboutBluetoothIfRequired$4(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.BLUETOOTH_SETTINGS");
            intent.addFlags(335544320);
            startActivity(intent);
        } catch (Exception e) {
            Logger.logSevere(e);
            Toast.makeText(this, R.string.general_unspecified_error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyAboutBluetoothIfRequired$5(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$10() {
        BluetoothHrService.INSTANCE.start(getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$11() {
        this.notifiedAboutBluetooth = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(String str) {
        if (SleepService.isRunning()) {
            LullabyDialogFragment.startPlayingLullaby(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.bottomSheetBehavior.setState(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        pauseTracking(300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$3(TextView textView, Animation animation) {
        textView.startAnimation(animation);
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateOptionsMenu$7(View view) {
        if (this.trackingPaused) {
            resumeTracking();
            this.trackingPaused = false;
        } else {
            pauseTracking(300000L);
            this.trackingPaused = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateOptionsMenu$8(View view) {
        pauseTracking(300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showHint$9(final View view) {
        if (view.getVisibility() == 0) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.Sleep.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            view.startAnimation(animationLoadAnimation);
        }
    }

    private boolean menuAction(int i) {
        this.bottomSheetBehavior.setState(4);
        switch (i) {
            case R.id.menu_item_pause /* 2131362533 */:
                if (this.trackingPaused) {
                    resumeTracking();
                    this.trackingPaused = false;
                } else {
                    pauseTracking(300000L);
                    this.trackingPaused = true;
                }
                return true;
            case R.id.menu_item_pause_plus /* 2131362534 */:
                pauseTracking(300000L);
                return true;
            case R.id.menu_item_stop /* 2131362539 */:
                Logger.persistBuffer();
                userRequestedStopAndExit();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAboutBluetoothIfRequired() {
        if (this.notifiedAboutBluetooth) {
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        ISleepService iSleepService = this.sleepService;
        if ((iSleepService == null || !iSleepService.isUsingSmartwatch()) && !SharedApplicationContext.getSettings().isHrBt()) {
            return;
        }
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            this.notifiedAboutBluetooth = true;
            try {
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 67);
            } catch (SecurityException e) {
                Logger.logSevere(e);
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
                materialAlertDialogBuilder.setMessage(R.string.enable_bluetooth_for_smartwatch);
                materialAlertDialogBuilder.setPositiveButton(R.string.turn_on, (DialogInterface.OnClickListener) new Sleep$$ExternalSyntheticLambda0(this, 0));
                materialAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new Sleep$$ExternalSyntheticLambda1());
                DialogUtil.fixButtonsAndDivider(materialAlertDialogBuilder.show(), R.color.white);
            }
        }
    }

    private void pauseTracking(long j) {
        log("Pausing tracking (" + j + ")");
        if (this.beeingStopped) {
            return;
        }
        ISleepService iSleepService = this.sleepService;
        if (iSleepService != null) {
            iSleepService.pauseTracking(j);
            indicatePauseTracking();
        } else {
            Logger.logWarning("Service not bound on pausing. Pause cannot be propagated!");
            ErrorReporter.getInstance().generateAssertionError(AssertionType.SERVICE_BIND, "Service not bound on pausing", 10);
        }
    }

    private void refreshGraph() {
        final SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null) {
            new SleepRecordFilterFilterAsyncTask(record) { // from class: com.urbandroid.sleep.Sleep.11
                @Override // android.os.AsyncTask
                public void onPostExecute(List<Float> list) {
                    if (list != null) {
                        Sleep.this.graph.setEquidistantValues(list, record.shouldUseExactFitView());
                        Sleep.this.graph.setXAxisLabels(new TimeAxisLabels(Sleep.this, record.getFrom(), new Date(), record.getTimezone(), list.size()));
                        Sleep.this.graph.setYAxisLabels(null);
                        Sleep.this.graph.setDrawYAxis(false);
                        Sleep.this.graph.setDrawXAxis(true);
                        Sleep.this.graph.setDoDrawGraphLine(true);
                        Sleep.this.graph.setSleepGraphColor(ColorUtil.i(Sleep.this, R.color.bg_track));
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGraphListener() {
        if (this.graphChangeListener != null) {
            SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
            if (record != null) {
                record.removeListener(this.graphChangeListener);
                this.graphChangeListener = null;
            }
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
            if (smartWatch != null) {
                smartWatch.setBatchSize(12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTracking() {
        log("Resuming tracking.");
        ISleepService iSleepService = this.sleepService;
        if (iSleepService == null) {
            Logger.logWarning("Service not bound on resuming. Resume cannot be propagated!");
            ErrorReporter.getInstance().generateAssertionError(AssertionType.SERVICE_BIND, "Service not bound on resuming", 10);
        } else {
            iSleepService.resumeTracking();
            this.sleepService.postponeAwake();
            indicateResumeTracking();
        }
    }

    private void setAwakeWhenPhoneUsed(Context context) {
        ISleepService iSleepService;
        if (!new Settings(context).isAwakeDetectionWhenUsingPhone() || (iSleepService = this.sleepService) == null || iSleepService.getAwakeDetector() == null) {
            return;
        }
        this.sleepService.getAwakeDetector().forceAwakeNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBatterySavingMode(boolean z) {
        this.sleepService.setDisabled(z);
        log("SleepService: Setting battery saving disabled mode " + z);
        updateBatteryDisabledIndicators();
    }

    private void showHint() {
        Logger.logInfo("Dim: showHint");
        View viewFindViewById = findViewById(R.id.hint);
        viewFindViewById.setVisibility(0);
        this.handler.postDelayed(new FacebookSdk$$ExternalSyntheticLambda9(this, viewFindViewById, 27), 3000L);
    }

    private void showNavBar() {
        if (this.hasNavbar) {
            getWindow().getDecorView().setSystemUiVisibility(1792);
        }
    }

    private void startForegroundService(boolean z) {
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null) {
            Intent intent = new Intent(this, (Class<?>) SleepService.getServiceClass(this));
            long trackingDelay = SharedApplicationContext.getSettings().getTrackingDelay();
            long jCurrentTimeMillis = System.currentTimeMillis() - record.getFrom().getTime();
            if (jCurrentTimeMillis < 0) {
                jCurrentTimeMillis = 0;
            }
            long j = trackingDelay - jCurrentTimeMillis;
            if (j > 0) {
                log("Putting pause delay " + j);
                intent.putExtra("initial_pause", j);
            }
            if (z) {
                intent.putExtra("start_in_battery_saving", true);
            }
            intent.putExtra("MANUALY_STARTED", this.manuallyStarted);
            intent.putExtra("track_without_smartwatch", this.withoutWatch);
            ContextExtKt.startForegroundServiceWithLog(getApplicationContext(), intent);
        }
    }

    private void startUpdates() {
        if (isDoUpdates() || this.beeingStopped) {
            return;
        }
        setDoUpdates(true);
        this.handler.post(this.instructionsUpdater);
        this.handler.post(this.instructionsUpdaterSlow);
        this.handler.post(this.updateGraphRunnable);
        ContextCompat.registerReceiver(this, this.recordingUpdateReceiver, new IntentFilter(RecordingUpdate.ACTION_RECORDING_UPDATE), 2);
        initGraphListener();
    }

    private void stopUpdates() {
        if (isDoUpdates()) {
            setDoUpdates(false);
            this.handler.removeCallbacks(this.instructionsUpdater);
            this.handler.removeCallbacks(this.instructionsUpdaterSlow);
            unregisterReceiver(this.recordingUpdateReceiver);
            removeGraphListener();
        }
    }

    private void switchDim() {
        if (isAnyDimmingModeEnabled()) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Logger.logInfo("Dim: is " + isDimmed());
            if (isDimmed()) {
                ISleepService iSleepService = this.sleepService;
                if (iSleepService != null) {
                    iSleepService.setDimStatus(true);
                }
                getWindow().addFlags(1024);
                getWindow().addFlags(1024);
                getWindow().clearFlags(2048);
                getSupportActionBar().hide();
                try {
                    WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView()).hide(WindowInsetsCompat.Type.systemBars());
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                this.sleepTrackParent.setVisibility(4);
                findViewById(R.id.squigllyProgress).setVisibility(4);
                findViewById(R.id.adsStub).setVisibility(8);
                this.currentBrightnessFloat = attributes.screenBrightness;
                log("Current pre dimm brightness " + this.currentBrightnessFloat);
                int i = this.dimSetting;
                if (i == 2) {
                    log("Dim 0.1");
                    attributes.screenBrightness = Experiments.getInstance().isDimAsLowAsPossible() ? 0.0f : 0.1f;
                } else if (i == 3) {
                    try {
                        log("Dim more 0");
                        this.currentBrightness = Settings.System.getInt(getContentResolver(), "screen_brightness");
                        log("Dim more Current pre brightness " + this.currentBrightness);
                        Settings.System.putInt(getContentResolver(), "screen_brightness", 0);
                    } catch (Settings.SettingNotFoundException e2) {
                        Logger.logSevere(e2);
                    } catch (SecurityException unused) {
                    }
                } else if (i == 4 || i == 5) {
                    attributes.screenBrightness = Experiments.getInstance().isDimAsLowAsPossible() ? 0.0f : 0.1f;
                    log("Showing digital clock");
                    this.digitalClock.setVisibility(0);
                }
                hideNavBar();
                showHint();
            } else {
                hideHint();
                ISleepService iSleepService2 = this.sleepService;
                if (iSleepService2 != null) {
                    iSleepService2.setDimStatus(false);
                }
                getWindow().addFlags(2048);
                getWindow().clearFlags(1024);
                getSupportActionBar().show();
                try {
                    WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView()).show(WindowInsetsCompat.Type.systemBars());
                } catch (Exception e3) {
                    Logger.logSevere(e3);
                }
                this.sleepTrackParent.setVisibility(0);
                findViewById(R.id.squigllyProgress).setVisibility(0);
                findViewById(R.id.adsStub).setVisibility(0);
                updateElapsedTime(CurrentSleepRecord.getInstance().getRecord());
                int i2 = this.dimSetting;
                if (i2 == 2) {
                    log("Current brightness set back " + this.currentBrightnessFloat);
                    attributes.screenBrightness = this.currentBrightnessFloat;
                } else if (i2 == 3) {
                    try {
                        if (this.currentBrightness > 0) {
                            log("Current brightness set back " + this.currentBrightness);
                            Settings.System.putInt(getContentResolver(), "screen_brightness", this.currentBrightness);
                        } else {
                            log("Current brightness set back to DEFAULT = 200");
                            Settings.System.putInt(getContentResolver(), "screen_brightness", 200);
                        }
                    } catch (SecurityException unused2) {
                    }
                } else if (i2 == 4 || i2 == 5) {
                    attributes.screenBrightness = this.currentBrightnessFloat;
                    this.digitalClock.setVisibility(8);
                }
                showNavBar();
            }
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleFlashlight() {
        if (FLASHLIGHT_ON) {
            new FlashlightServiceAndroidM(this).turnOff();
            FLASHLIGHT_ON = false;
        } else {
            new FlashlightServiceAndroidM(this).turnOn();
            FLASHLIGHT_ON = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleSmartlight() {
        ISleepService iSleepService = this.sleepService;
        if (iSleepService != null) {
            iSleepService.toggleSmartLight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindSleepService() {
        try {
            if (this.serviceIsBound) {
                this.serviceIsBound = false;
                log("Unbinding sleep service.");
                unbindService(this.serviceConnection);
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void undimm() {
        logDebug("Undimming screen. Current: " + this.dimmed);
        findViewById(R.id.sleep_track_main).setBackgroundColor(ColorUtil.i(this, R.color.black));
        if (isAnyDimmingModeEnabled() && isDimmed()) {
            this.dimCounter = 0;
            setDimmed(false);
            switchDim();
            startUpdates();
            refreshGraph();
        }
        this.dimmingDisabled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBatteryDisabledIndicators() {
        boolean zIsDisabled = this.sleepService.isDisabled();
        this.disableItem.title = zIsDisabled ? getString(R.string.disable_battery_save) : getEnableBatterySavingIntemText();
        this.batterySaveIndicator.setVisibility(zIsDisabled ? 0 : 8);
        this.drawerList.getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateElapsedTime(SleepRecord sleepRecord) {
        long jLongValue;
        if (sleepRecord != null) {
            try {
                if (sleepRecord.getFrom() == null || getSupportActionBar() == null) {
                    return;
                }
                getSupportActionBar().setTitle(getTrackingTime(sleepRecord) + " " + getString(R.string.settings_category_track));
                if (isDimmed()) {
                    ((ImageView) findViewById(R.id.squigllyProgress)).setVisibility(8);
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Alarm alarm = this.alarm;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                if (alarm != null) {
                    jLongValue = alarm.time;
                } else {
                    Long l = this.snoozeAlarmTime;
                    jLongValue = l != null ? l.longValue() : sleepRecord.getFromTime() + timeUnit.toMillis(SharedApplicationContext.getSettings().getIdealSleepMinutes());
                }
                if (jLongValue - jCurrentTimeMillis > 39600000) {
                    jLongValue = sleepRecord.getFromTime() + timeUnit.toMillis(SharedApplicationContext.getSettings().getIdealSleepMinutes());
                }
                ImageView imageView = (ImageView) findViewById(R.id.squigllyProgress);
                SquigglyProgress squigglyProgress = (SquigglyProgress) imageView.getDrawable();
                squigglyProgress.setLevel(((int) ((((int) (jCurrentTimeMillis - sleepRecord.getFrom().getTime())) / ((int) (jLongValue - sleepRecord.getFrom().getTime()))) * 9500.0f)) + 500);
                squigglyProgress.setStrokeWidth(ActivityUtils.getDip(this, 6));
                imageView.setVisibility(0);
            } catch (Throwable th) {
                Logger.logSevere(th);
            }
        }
    }

    private void updateOrientation(int i) {
        if (i == 2) {
            Logger.logInfo("Sleep: landscape");
            findViewById(R.id.timeDisplay).setPadding(0, 0, 0, 0);
            ((TextView) findViewById(R.id.timeDisplay)).setTextSize(2, 42.0f);
        } else {
            Logger.logInfo("Sleep: portrait");
            findViewById(R.id.clock_parent).setPadding(ActivityUtils.getDip(this, 8), ActivityUtils.getDip(this, 8), ActivityUtils.getDip(this, 8), ActivityUtils.getDip(this, 8));
            ((TextView) findViewById(R.id.timeDisplay)).setTextSize(2, 72.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePauseDialogAddTimeText(TextView textView, boolean z) {
        if (z && textView.getTag() == null) {
            textView.setText(getString(R.string.awake).toUpperCase());
            textView.setTag("awake");
        } else {
            if (z || textView.getTag() == null) {
                return;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setText(getString(R.string.button_tracking_add_time, "5 "));
            textView.setTag(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSmartwatchAlarm() {
        long snoozeTime;
        boolean zIsSnoozing = Alarms.isSnoozing(this);
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
        Alarm alarm = this.alarm;
        if ((alarm != null || zIsSnoozing) && smartWatch != null) {
            if (zIsSnoozing) {
                snoozeTime = Alarms.getSnoozeTime(this);
                Calendar.getInstance().setTimeInMillis(snoozeTime);
            } else {
                snoozeTime = alarm.time;
            }
            if (snoozeTime > -1) {
                smartWatch.updateAlarm(snoozeTime);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userConfirmedStopAndExit(boolean z, SleepRecord sleepRecord) {
        logDebug("User confirmed stop and exit: " + z + " Current record: " + sleepRecord);
        if (z) {
            if (sleepRecord != null) {
                ISleepService iSleepService = this.sleepService;
                if (iSleepService != null) {
                    iSleepService.saveAndInvalidateRecord(true);
                } else {
                    Logger.logSevere("Null service? Could that be??");
                }
            }
        } else if (sleepRecord != null) {
            ISleepService iSleepService2 = this.sleepService;
            if (iSleepService2 != null) {
                iSleepService2.saveAndInvalidateRecord(true);
            } else {
                Logger.logSevere("Null service? Could that be??");
            }
            if (sleepRecord.isTooShortToSave()) {
                SharedApplicationContext.getInstance().deleteRecord(sleepRecord, null);
            } else {
                UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.deleted), new SleepRecord(sleepRecord, false));
                SharedApplicationContext.getInstance().deleteRecord(sleepRecord, undoOperationGroup);
                SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
            }
        }
        SharedApplicationContext.getInstance().getSleepRestarter().disableRestarting();
        stopService(new Intent(this, (Class<?>) SleepService.getServiceClass(this)));
        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK"));
        CurrentSleepRecord.getInstance().invalidate();
        if (sleepRecord == null || !z) {
            finish();
            return;
        }
        RatingActivity.showRatingIfEnabled(this, sleepRecord);
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSleepRecord(this, sleepRecord);
        finish();
    }

    private void userRequestedStopAndExit() {
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record == null || record.isFinished()) {
            Logger.logSevere("Record is finished " + record);
            userConfirmedStopAndExit(false, record);
            return;
        }
        if (!record.isTooShortToSave()) {
            showDialog(31);
            return;
        }
        Logger.logSevere("Too short to save " + record);
        userConfirmedStopAndExit(false, record);
    }

    public synchronized boolean isDimmed() {
        return this.dimmed;
    }

    public boolean isDoUpdates() {
        return this.doUpdates;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        int i3 = 1;
        if (i == 312) {
            com.urbandroid.sleep.service.Settings settings = new com.urbandroid.sleep.service.Settings(this);
            if (PowerManagerCompat.isIgnoringBatteryOptimizations(this)) {
                Logger.logInfo("DOZE: opt-out from optimization granted");
                settings.setBatteryOptimized(true);
            } else {
                Logger.logInfo("DOZE: opt-out from optimization NOT granted");
                settings.setBatteryOptimized(false);
            }
            this.instructions.batteryOptimizationsDone();
            return;
        }
        if (intent != null && intent.hasExtra("SleepRecord")) {
            SleepRecord sleepRecord = (SleepRecord) intent.getParcelableExtra("SleepRecord");
            if (CurrentSleepRecord.getInstance().getRecord() != null) {
                CurrentSleepRecord.getInstance().getRecord().rateAndComment(sleepRecord.getComment(), sleepRecord.getRating());
                return;
            }
            return;
        }
        if (intent != null && Environment.isLollipopOrGreater() && i == 111 && i2 == -1) {
            Uri directoryPicked = DirectoryPicker.parseDirectoryPicked(getApplicationContext(), intent);
            SharedApplicationContext.getSettings().setNoiseDirUri(directoryPicked);
            NoiseDirectory.checkReadWriteAccessUri(getApplicationContext(), directoryPicked);
        } else if (i == 67 && i2 == -1) {
            if (SharedApplicationContext.getSettings().isHrBt() || SharedApplicationContext.getSettings().isOximeter()) {
                this.handler.postDelayed(new Sleep$$ExternalSyntheticLambda4(this, i3), 5000L);
            }
            this.handler.postDelayed(new Sleep$$ExternalSyntheticLambda4(this, 2), 5000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        explicitRecording();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean zIsEligibleForAds = IAdsController.isEligibleForAds(this);
        IAdsController iAdsController = this.adMobController;
        if (zIsEligibleForAds) {
            iAdsController.load("ca-app-pub-1970766161278534/4780277674", "ca-app-pub-1970766161278534/7004800541");
        } else {
            iAdsController.hide();
        }
        updateOrientation(configuration.orientation);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        getWindow().setStatusBarColor(ColorUtil.i(this, R.color.black));
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.black));
        GlobalInitializator.initializeIfRequired(this);
        Logger.logInfo("LOCALE " + Locale.getDefault() + " " + Locale.getDefault(Locale.Category.DISPLAY));
        this.handler = new Handler();
        this.animFlyIn = AnimationUtils.loadAnimation(this, R.anim.fly_in);
        this.animPulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        this.animFlyOut = AnimationUtils.loadAnimation(this, R.anim.fly_out);
        this.wasInAirplaneMode = SharedApplicationContext.getSettings().isAirplaneModeOn();
        boolean z2 = getIntent() != null && getIntent().hasExtra("INTENT_TIMESTAMP") && getIntent().getLongExtra("INTENT_TIMESTAMP", 0L) + 30000 < System.currentTimeMillis();
        boolean z3 = !z2 && (bundle == null || !bundle.getBoolean("EXTRA_SLEEP_TRACKING_SAVED_STATE")) && getIntent() != null && getIntent().hasExtra("NEW_RECORD");
        log("New record " + z3 + " Is stale: " + z2);
        if (getIntent() != null) {
            log("Has intent: " + getIntent().getAction());
            if (getIntent().getExtras() != null) {
                for (String str : getIntent().getExtras().keySet()) {
                    StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("INTENT BUNDLE. Key: ", str, " Value: ");
                    sbM5m.append(getIntent().getExtras().get(str));
                    log(sbM5m.toString());
                }
            }
        }
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                StringBuilder sbM5m2 = FileInsert$$ExternalSyntheticOutline0.m5m("BUNDLE. Key: ", str2, " Value: ");
                sbM5m2.append(bundle.get(str2));
                log(sbM5m2.toString());
            }
        }
        this.restarter = SharedApplicationContext.getInstance().getSleepRestarter();
        KeyguardUtil.disable(this);
        this.manuallyStarted = false;
        this.withoutWatch = false;
        if (getIntent() != null) {
            this.manuallyStarted = getIntent().getBooleanExtra("MANUALY_STARTED", false);
            this.withoutWatch = getIntent().getBooleanExtra("track_without_smartwatch", false);
            z = getIntent().hasExtra("START_AIRPLANE") || this.manuallyStarted;
            if (this.manuallyStarted && z3 && (SharedApplicationContext.getSettings().isAutoplayLullaby() || getIntent().hasExtra("START_LULLABY"))) {
                String stringExtra = getIntent().hasExtra("START_LULLABY") ? getIntent().getStringExtra("START_LULLABY") : SharedApplicationContext.getSettings().getAutoplayLullabyName();
                log("Auto starting lullaby " + stringExtra);
                if (stringExtra != null && !stringExtra.trim().isEmpty() && !stringExtra.equals(LullabyPlayer.Lullaby.NONE)) {
                    this.handler.postDelayed(new FacebookSdk$$ExternalSyntheticLambda9(this, stringExtra, 28), 4000L);
                }
            }
        } else {
            z = false;
        }
        log("Creating sleep tracking activity " + this.manuallyStarted + " " + z);
        setContentView(R.layout.activity_sleep_track);
        SquigglyProgress squigglyProgress = new SquigglyProgress();
        squigglyProgress.setLineAmplitude((float) ActivityUtils.getDip(this, 4));
        squigglyProgress.setTransitionEnabled(true);
        squigglyProgress.setPhaseSpeed(ActivityUtils.getDip(this, 16));
        int i = 3;
        squigglyProgress.setStrokeWidth(ActivityUtils.getDip(this, 3));
        squigglyProgress.setWaveLength(ActivityUtils.getDip(this, 64));
        squigglyProgress.setAnimate(true);
        squigglyProgress.setTint(ColorUtil.i(this, R.color.tint));
        ((ImageView) findViewById(R.id.squigllyProgress)).setImageDrawable(squigglyProgress);
        this.drawerList = (RecyclerView) findViewById(R.id.drawer_recycler);
        this.drawerList.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        TintUtil.tint(this, ColorUtil.i(this, R.color.bg_track), (ViewGroup) findViewById(R.id.drawer_main), false);
        ToolbarUtil.apply(this);
        EdgeToEdgeUtil.insetsTop(findViewById(R.id.toolbar));
        this.bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.stop_and_save_parent);
        viewGroup.setOnClickListener(new Sleep$$ExternalSyntheticLambda2(this, 2));
        this.bottomSheetBehavior.addBottomSheetCallback(new AnonymousClass1(viewGroup));
        ActionBar supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.setBackgroundDrawable(new ColorDrawable(ColorUtil.i(this, R.color.bg_track)));
        DrawerRecyclerViewAdapter drawerRecyclerViewAdapter = new DrawerRecyclerViewAdapter();
        drawerRecyclerViewAdapter.setItems(initDrawer());
        this.drawerList.setAdapter(drawerRecyclerViewAdapter);
        this.batterySaveIndicator = findViewById(R.id.battery_save_indicator);
        this.pauseIndicator = (ViewGroup) findViewById(R.id.pause_indicator);
        this.pauseIndicatorText = (TextView) findViewById(R.id.pause_indicator_text);
        ((TextView) findViewById(R.id.pause_indicator_add_time)).setText(getString(R.string.button_tracking_add_time, "5 "));
        this.pauseIndicator.setOnClickListener(new Sleep$$ExternalSyntheticLambda2(this, i));
        GraphView graphView = (GraphView) findViewById(R.id.graph);
        this.graph = graphView;
        graphView.setAxisPadding(36);
        this.graph.setOnTouchListener(this);
        this.graph.setDoTrimming(false);
        this.graph.setTextOutlineColor(ColorUtil.i(this, R.color.black));
        this.graph.setTextColor(ColorUtil.i(this, R.color.white_secondary));
        this.graph.setDoDrawAxisLine(false);
        this.graph.setDrawXAxisBars(false);
        this.graph.setForceXAxisOffset(true);
        this.graph.setxAxisOffsetDpi(112);
        this.graph.setDrawAverage(false);
        this.graph.setCardColor(ContextCompat.getColor(this, R.color.black));
        this.graph.setSleepGraphColor(ColorUtil.i(this, R.color.transparent));
        this.graph.setSleepGraphLineColor(ColorUtil.i(this, R.color.white_secondary));
        LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) findViewById(R.id.recording_bar);
        this.recordingBar = linearProgressIndicator;
        linearProgressIndicator.setIndeterminate(false);
        this.recordingBar.setMax(this.progressMax);
        this.recordingBar.setTrackColor(ColorUtil.i(this, R.color.shade));
        this.recordingBar.setIndicatorColor(ColorUtil.i(this, R.color.tint));
        this.digitalClock = (DigitalClock) findViewById(R.id.dimClock);
        ImageView imageView = (ImageView) findViewById(R.id.recording_img);
        this.recordingImg = imageView;
        imageView.setOnClickListener(this);
        findViewById(R.id.recording_text).setOnClickListener(this);
        findViewById(R.id.recording_bar).setOnClickListener(this);
        this.recordingParent = (ViewGroup) findViewById(R.id.recording_parent);
        this.sleepTrackParent = (ViewGroup) findViewById(R.id.sleep_track_parent);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.sleep_track_main);
        this.sleepTrackMain = viewGroup2;
        viewGroup2.setOnTouchListener(this);
        boolean z4 = SharedApplicationContext.getSettings().isAutoAirplaneMode() && z && z3;
        Logger.logInfo("WiFi enable " + z4 + " " + SharedApplicationContext.getSettings().isAutoAirplaneMode() + " " + z + " " + z3);
        if (z3 && SharedApplicationContext.getSettings().getAutoSharingMode() == 2) {
            log("Sharing status after tracking started...");
            SharedApplicationContext.getInstance().getShareService().publishStatus(this, CommentBuilderUtil.createAsleepComment(this), new AnonymousClass2(this, z4));
        } else if (z4) {
            AirplaneModeUtil.enableAirplaneMode(this, false);
        }
        if (this.instructions == null) {
            findViewById(R.id.step_airplane);
            SharedApplicationContext.getSettings().isAutoAirplaneMode();
            this.instructions = new Instructions(this);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        final int iMin = Math.min(defaultDisplay.getWidth(), defaultDisplay.getHeight()) / 4;
        this.gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.urbandroid.sleep.Sleep.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.sqrt(Math.pow(motionEvent.getY() - motionEvent2.getY(), 2.0d) + Math.pow(motionEvent.getX() - motionEvent2.getX(), 2.0d)) <= iMin) {
                    return false;
                }
                Sleep.this.dimCounter = 0;
                Sleep.this.logDebug("Gesture => undimm");
                Sleep.this.undimm();
                return true;
            }
        });
        SharedApplicationContext.getSettings().resetSnoozeRepeatIfNoSnoozeScheduled();
        if (z3) {
            SharedApplicationContext.getSettings().resetDeepSleepCounter();
        }
        if (Environment.isIcsOrGreater()) {
            boolean zHasPermanentMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
            boolean zDeviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (!zHasPermanentMenuKey && !zDeviceHasKey) {
                this.hasNavbar = true;
            }
        }
        if (this.manuallyStarted && z3) {
            new TtsService();
            TtsService.speak(this, R.string.good_night, 0.003f);
        }
        this.adMobController = new AdMobController(this, R.id.adsStub);
        if (Environment.isIcsOrGreater()) {
            TextView textView = (TextView) findViewById(R.id.good_night);
            textView.setVisibility(0);
            this.handler.postDelayed(new FacebookSdk$$ExternalSyntheticLambda9(textView, AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade), 29), 3000L);
        }
        this.handler.postDelayed(new Sleep$$ExternalSyntheticLambda4(this, i), 1000L);
        updateOrientation(getResources().getConfiguration().orientation);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        AlertDialog alertDialogShow = null;
        if (i == 31) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
            materialAlertDialogBuilder.setTitle(R.string.settings_category_track);
            materialAlertDialogBuilder.setMessage(R.string.graph_stop_exit_confirm);
            materialAlertDialogBuilder.setPositiveButton(R.string.graph_confirm_save, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Sleep.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Sleep.this.userConfirmedStopAndExit(true, CurrentSleepRecord.getInstance().getRecord());
                }
            });
            materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
            materialAlertDialogBuilder.setNeutralButton(R.string.graph_confirm_no_save, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Sleep.13
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Sleep.this.userConfirmedStopAndExit(false, CurrentSleepRecord.getInstance().getRecord());
                }
            });
            alertDialogShow = materialAlertDialogBuilder.show();
        } else if (i == 34) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder2 = new MaterialAlertDialogBuilder(this);
            materialAlertDialogBuilder2.setTitle(R.string.smartwatch);
            materialAlertDialogBuilder2.setMessage(R.string.enable_bluetooth_for_smartwatch);
            materialAlertDialogBuilder2.setPositiveButton(R.string.turn_on, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Sleep.14
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter.isEnabled()) {
                        return;
                    }
                    defaultAdapter.enable();
                }
            });
            materialAlertDialogBuilder2.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
            alertDialogShow = materialAlertDialogBuilder2.create();
            alertDialogShow.setOnShowListener(new FixButtonColorOnShowDialogListener(R.color.white));
        }
        DialogUtil.fixButtonsAndDivider(alertDialogShow, R.color.white);
        return alertDialogShow;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sleep_track_menu, menu);
        this.pauseMenuItem = menu.findItem(R.id.menu_item_pause);
        this.pausePlus5MenuItem = menu.findItem(R.id.menu_item_pause_plus);
        this.pauseMenuItem.getActionView().setOnClickListener(new Sleep$$ExternalSyntheticLambda2(this, 0));
        indicateResumeTracking();
        this.pausePlus5MenuItem.getActionView().setOnClickListener(new Sleep$$ExternalSyntheticLambda2(this, 1));
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Thread thread = this.aliveLoggingThread;
        if (thread != null) {
            thread.interrupt();
        }
        this.adMobController.destroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isDimmed()) {
            return super.onKeyDown(i, keyEvent);
        }
        logDebug("Key down => undimm");
        undimm();
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        log("New intent arrived");
        if (intent == null || !intent.getBooleanExtra("NOTIFICATION_STARTED", false)) {
            return;
        }
        log("Has extra " + intent.getBooleanExtra("NOTIFICATION_STARTED", false));
        CurrentSleepRecord.getInstance().getRecord();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return menuAction(menuItem.getItemId());
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        log("Pausing sleep tracking activity");
        removeGraphListener();
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_TRACKING_PAUSED");
        this.bottomSheetBehavior.setState(4);
        this.adMobController.pause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 972) {
            new com.urbandroid.sleep.service.Settings(this);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr[i2] != 0) {
                    toggleFlashlight();
                }
            }
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        log("Resuming sleep tracking activity");
        initGraphListener();
        updateElapsedTime(CurrentSleepRecord.getInstance().getRecord());
        if (SharedApplicationContext.getSettings().isRecordingRequiresStorage() && SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.RECORD_AUDIO") && !this.instructions.isRecordingFailed()) {
            this.recordingParent.setVisibility(0);
        }
        boolean zIsEligibleForAds = IAdsController.isEligibleForAds(this);
        IAdsController iAdsController = this.adMobController;
        if (zIsEligibleForAds) {
            iAdsController.load("ca-app-pub-1970766161278534/4780277674", "ca-app-pub-1970766161278534/7004800541");
            this.adMobController.resume();
        } else {
            iAdsController.hide();
        }
        updateSmartwatchAlarm();
        undimm();
        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_TRACKING_RESUMED"));
        refreshAlarm(Alarms.calculateNextAlertIncludingSnooze(this), Alarms.isSnoozing(this) ? Long.valueOf(Alarms.getSnoozeTime(this)) : null);
        notifyAboutBluetoothIfRequired();
        setAwakeWhenPhoneUsed(this);
        this.instructions.updatePairTrackingStatus();
        if (!isDimmed()) {
            this.bottomSheetBehavior.setState(4);
        }
        ISleepService iSleepService = this.sleepService;
        if (iSleepService != null) {
            this.instructions.awake(iSleepService.isAwakePaused());
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putBoolean("EXTRA_SLEEP_TRACKING_SAVED_STATE", true);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        String str;
        super.onStart();
        RUNNING = true;
        boolean z = false;
        this.beeingStopped = false;
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record == null) {
            Logger.logSevere("ERROR: no record active on sleep activity start!");
            this.receiver = null;
            this.localReceiver = null;
            finish();
            return;
        }
        bindSleepService();
        refreshGraph();
        if (record.getHistory().size() > 3) {
            this.instructions.ignoreAllIgnorable();
        }
        BedtimeReceiver.cancelRepeatNotification(getApplicationContext());
        initGraphListener();
        if (!record.isFinished()) {
            if (getIntent() != null && getIntent().hasExtra("START_IN_BATTERY_SAVING_MODE")) {
                z = true;
            }
            startForegroundService(z);
            this.dimSetting = SharedApplicationContext.getSettings().getDimMode();
            Logger.logInfo("Sleep: Dim mode " + this.dimSetting);
            this.snoozeAlarmTime = Alarms.isSnoozing(this) ? Long.valueOf(Alarms.getSnoozeTime(this)) : null;
            Alarm alarmCalculateNextAlertIncludingSnooze = Alarms.calculateNextAlertIncludingSnooze(this);
            this.alarm = alarmCalculateNextAlertIncludingSnooze;
            if (alarmCalculateNextAlertIncludingSnooze != null && (str = alarmCalculateNextAlertIncludingSnooze.label) != null && str.length() > 0 && CurrentSleepRecord.getInstance().getRecord() != null && CurrentSleepRecord.getInstance().getRecord().getHistory().size() <= 1 && ((CurrentSleepRecord.getInstance().getRecord().getComment() == null || "".equals(CurrentSleepRecord.getInstance().getRecord().getComment())) && this.alarm.time - System.currentTimeMillis() < 72000000)) {
                CurrentSleepRecord.getInstance().getRecord().rateAndComment(this.alarm.label, 0.0f);
                CurrentSleepRecord.getInstance().getRecord().updateLatestTo(new Date(this.alarm.time));
            }
            IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STOPPED");
            intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
            intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE");
            intentFilter.addAction("com.urbandroid.sleep.ACTION_TRACKING_UPDATE_SMARTWATCH");
            intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION");
            intentFilter.addAction("recording_initialization_failed");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
            ContextCompat.registerReceiver(this, this.receiver, intentFilter, 2);
            this.alarmReceiverRegistered = true;
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.urbandroid.sleep.ACTION_PAIR_CONNECTION_STATUS_CHANGED");
            intentFilter2.addAction("com.urbandroid.sleep.ACTION_HR_UI_UPDATE");
            intentFilter2.addAction("com.urbandroid.sleep.ACTION_BT_UI_START");
            intentFilter2.addAction("com.urbandroid.sleep.ACTION_BT_UI_END");
            intentFilter2.addAction("com.urbandroid.sleep.ACTION_BT_UI_DEVICE");
            intentFilter2.addAction("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
            intentFilter2.addAction("com.urbandroid.sleep.AWAKE");
            intentFilter2.addAction("com.urbandroid.sleep.NOT_AWAKE");
            LocalBroadcastManager.getInstance(this).registerReceiver(this.localReceiver, intentFilter2);
            startUpdates();
            this.handler.post(this.cheapUpdaterSlow);
        }
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_TRACKING_STARTED");
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.handler.removeCallbacks(this.cheapUpdaterSlow);
        this.beeingStopped = true;
        ActivityStateUtil.dismiss(this.ratingDialog);
        this.ratingDialog = null;
        unbindSleepService();
        stopUpdates();
        if (this.alarmReceiverRegistered) {
            unregisterReceiver(this.receiver);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.localReceiver);
            this.alarmReceiverRegistered = false;
        }
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_TRACKING_STOPPED");
        RUNNING = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public void refreshAlarm(Alarm alarm, Long l) {
        this.snoozeAlarmTime = l;
        this.alarm = alarm;
        this.instructions.alarm(alarm, l);
    }

    public synchronized void setDimmed(boolean z) {
        this.dimmed = z;
    }

    public void setDoUpdates(boolean z) {
        this.doUpdates = z;
    }
}
