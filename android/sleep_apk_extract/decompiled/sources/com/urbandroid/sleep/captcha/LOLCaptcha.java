package com.urbandroid.sleep.captcha;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.audio.consumer.NullAudioConsumer;
import com.urbandroid.sleep.audio.event.SoundEvent;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.WaveDrawable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0014J-\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\"2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0002J\r\u0010(\u001a\u00020\fH\u0016¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0017H\u0014J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0017H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/urbandroid/sleep/captcha/LOLCaptcha;", "Lcom/urbandroid/sleep/captcha/AbstractCaptchaActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "countText", "Landroid/widget/TextView;", "countStart", "", "count", "lastUpdateReceived", "", "lolView", "Lcom/urbandroid/sleep/captcha/LOLView;", "laughterThread", "Lcom/urbandroid/sleep/captcha/LOLCaptcha$LaughterThread;", "waveDrawable", "Lcom/urbandroid/util/WaveDrawable;", "onSaveInstanceState", "", "outState", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onResume", "onStart", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "getProgressText", "startCount", "onRetainCustomNonConfigurationInstance", "()Ljava/lang/Double;", "onStop", "displayWarning", "resourceKey", "createNewAudioRecorder", "Lcom/urbandroid/sleep/audio/AudioRecorder;", "consumer", "Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;", "markSolved", "LaughterThread", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LOLCaptcha extends AbstractCaptchaActivity implements FeatureLogger {
    private volatile double count;
    private volatile double countStart;
    private volatile TextView countText;
    private volatile LaughterThread laughterThread;
    private volatile LOLView lolView;
    private WaveDrawable waveDrawable;
    private final String tag = "LOLCaptcha";
    private volatile long lastUpdateReceived = Long.MIN_VALUE;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/captcha/LOLCaptcha$LaughterThread;", "Ljava/lang/Thread;", "<init>", "(Lcom/urbandroid/sleep/captcha/LOLCaptcha;)V", "run", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class LaughterThread extends Thread {
        public LaughterThread() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(LOLCaptcha lOLCaptcha) {
            TextView textView = lOLCaptcha.countText;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("countText");
                textView = null;
            }
            textView.setText(Html.fromHtml(lOLCaptcha.getProgressText(lOLCaptcha.count, lOLCaptcha.countStart)));
            LOLView lOLView = lOLCaptcha.lolView;
            if (lOLView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lolView");
                lOLView = null;
            }
            lOLView.setStatus(1.0f - ((float) (lOLCaptcha.count / lOLCaptcha.countStart)));
            lOLView.invalidate();
            float f = (float) (1.0d - (lOLCaptcha.count / ((double) ((float) lOLCaptcha.countStart))));
            TextView textView3 = lOLCaptcha.countText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("countText");
            } else {
                textView2 = textView3;
            }
            textView2.setText(Html.fromHtml(lOLCaptcha.getProgressText(lOLCaptcha.count, lOLCaptcha.countStart)));
            WaveDrawable waveDrawable = lOLCaptcha.waveDrawable;
            waveDrawable.getClass();
            waveDrawable.setWaterLevel(0, f);
            WaveDrawable waveDrawable2 = lOLCaptcha.waveDrawable;
            waveDrawable2.getClass();
            waveDrawable2.setWaterLevel(1, f * 0.8f);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AudioRecorder.Consumer nullAudioConsumer;
            Pair pair;
            LOLCaptcha lOLCaptcha = LOLCaptcha.this;
            Logger.logInfo(Logger.defaultTag, lOLCaptcha.getTag() + ": LaughterThread: start", null);
            LOLCaptcha.this.lastUpdateReceived = System.currentTimeMillis();
            Experiments experiments = Experiments.getInstance();
            if (experiments.isTensorflowV3()) {
                Context applicationContext = LOLCaptcha.this.getApplicationContext();
                applicationContext.getClass();
                nullAudioConsumer = new LaughterDetectorV3(applicationContext);
            } else {
                boolean zIsTensorflowV4 = experiments.isTensorflowV4();
                LOLCaptcha lOLCaptcha2 = LOLCaptcha.this;
                if (zIsTensorflowV4) {
                    Context applicationContext2 = lOLCaptcha2.getApplicationContext();
                    applicationContext2.getClass();
                    nullAudioConsumer = new LaughterDetectorV4(applicationContext2);
                } else {
                    nullAudioConsumer = new NullAudioConsumer(lOLCaptcha2.getApplicationContext());
                }
            }
            boolean zIsInProcessTracking = CurrentSleepRecord.getInstance().isInProcessTracking();
            LOLCaptcha lOLCaptcha3 = LOLCaptcha.this;
            if (zIsInProcessTracking) {
                Logger.logInfo(Logger.defaultTag, lOLCaptcha3.getTag() + ": LaughterThread: sleep tracking is running", null);
                AudioRecorder audioRecorder = SleepService.getAudioRecorder();
                LOLCaptcha lOLCaptcha4 = LOLCaptcha.this;
                if (audioRecorder == null) {
                    Logger.logInfo(Logger.defaultTag, lOLCaptcha4.getTag() + ": LaughterThread: audio recorder not found, creating a new one.", null);
                    pair = new Pair(LOLCaptcha.this.createNewAudioRecorder(nullAudioConsumer), Boolean.TRUE);
                } else {
                    Logger.logInfo(Logger.defaultTag, lOLCaptcha4.getTag() + ": LaughterThread: audio recorder found, registering a new consumer.", null);
                    AudioRecorder.addAndOpenConsumerIfPossible$default(audioRecorder, nullAudioConsumer, 0, 2, null);
                    pair = new Pair(audioRecorder, Boolean.FALSE);
                }
            } else {
                Logger.logInfo(Logger.defaultTag, lOLCaptcha3.getTag() + ": LaughterThread: sleep tracking is not running, creating a new audio recorder.", null);
                pair = new Pair(LOLCaptcha.this.createNewAudioRecorder(nullAudioConsumer), Boolean.TRUE);
            }
            AudioRecorder audioRecorder2 = (AudioRecorder) pair.component1();
            boolean zBooleanValue = ((Boolean) pair.component2()).booleanValue();
            Context applicationContext3 = LOLCaptcha.this.getApplicationContext();
            applicationContext3.getClass();
            ContextExtKt.sendExplicitBroadcast$default(applicationContext3, new Intent("com.urbandroid.sleep.alarmclock.ALARM_SUSPEND"), null, 2, null);
            final LOLCaptcha lOLCaptcha5 = LOLCaptcha.this;
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.captcha.LOLCaptcha$LaughterThread$run$eventReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    context.getClass();
                    lOLCaptcha5.lastUpdateReceived = System.currentTimeMillis();
                    if (intent == null) {
                        return;
                    }
                    SoundEvent soundEventFromIntent = SoundEvent.fromIntent(intent);
                    soundEventFromIntent.getClass();
                    if (soundEventFromIntent.getSoundClass() == SoundClass.LAUGH) {
                        double weight = soundEventFromIntent.getWeight();
                        lOLCaptcha5.count -= weight;
                        LOLCaptcha lOLCaptcha6 = lOLCaptcha5;
                        String str = weight + " " + lOLCaptcha6.count;
                        Logger.logInfo(Logger.defaultTag, lOLCaptcha6.getTag() + ": " + str, null);
                    }
                }
            };
            LocalBroadcastManager.getInstance(LOLCaptcha.this.getApplicationContext()).registerReceiver(broadcastReceiver, new IntentFilter("action_sound_event_raw"));
            try {
                LOLCaptcha lOLCaptcha6 = LOLCaptcha.this;
                Logger.logInfo(Logger.defaultTag, lOLCaptcha6.getTag() + ": LaughterThread: try", null);
                double d = LOLCaptcha.this.count;
                while (true) {
                    try {
                        Thread.sleep(500L);
                        if (LOLCaptcha.this.count < d) {
                            LOLCaptcha.this.alive();
                        }
                        d = LOLCaptcha.this.count;
                        if (LOLCaptcha.this.count <= 0.0d) {
                            LOLCaptcha lOLCaptcha7 = LOLCaptcha.this;
                            Logger.logInfo(Logger.defaultTag, lOLCaptcha7.getTag() + ": solved successfully", null);
                            LOLCaptcha.this.markSolved();
                            LOLCaptcha lOLCaptcha8 = LOLCaptcha.this;
                            String str = Logger.defaultTag;
                            Logger.logInfo(str, lOLCaptcha8.getTag() + ": " + ("finally block start, audioRecorderNewlyCreated=" + zBooleanValue), null);
                            LocalBroadcastManager.getInstance(LOLCaptcha.this.getApplicationContext()).unregisterReceiver(broadcastReceiver);
                            if (zBooleanValue) {
                                audioRecorder2.pause(AudioRecorder.PauseReason.TERMINATING);
                                audioRecorder2.stop();
                            } else {
                                audioRecorder2.removeAndCloseConsumerIfPossible(nullAudioConsumer);
                            }
                            LOLCaptcha lOLCaptcha9 = LOLCaptcha.this;
                            Logger.logInfo(Logger.defaultTag, lOLCaptcha9.getTag() + ": finally block end", null);
                            return;
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis() - LOLCaptcha.this.lastUpdateReceived;
                        LOLCaptcha lOLCaptcha10 = LOLCaptcha.this;
                        if (jCurrentTimeMillis > 10000) {
                            Logger.logInfo(Logger.defaultTag, lOLCaptcha10.getTag() + ": no updates received for a long time, marking the captcha solved", null);
                            LOLCaptcha.this.markSolved();
                            LOLCaptcha.this.displayWarning(R.string.general_unspecified_error);
                            LOLCaptcha lOLCaptcha11 = LOLCaptcha.this;
                            String str2 = Logger.defaultTag;
                            Logger.logInfo(str2, lOLCaptcha11.getTag() + ": " + ("finally block start, audioRecorderNewlyCreated=" + zBooleanValue), null);
                            LocalBroadcastManager.getInstance(LOLCaptcha.this.getApplicationContext()).unregisterReceiver(broadcastReceiver);
                            if (zBooleanValue) {
                                audioRecorder2.pause(AudioRecorder.PauseReason.TERMINATING);
                                audioRecorder2.stop();
                            } else {
                                audioRecorder2.removeAndCloseConsumerIfPossible(nullAudioConsumer);
                            }
                            LOLCaptcha lOLCaptcha12 = LOLCaptcha.this;
                            Logger.logInfo(Logger.defaultTag, lOLCaptcha12.getTag() + ": finally block end", null);
                            return;
                        }
                        lOLCaptcha10.runOnUiThread(new LOLCaptcha$$ExternalSyntheticLambda1(lOLCaptcha10, 1));
                    } catch (InterruptedException unused) {
                        LOLCaptcha lOLCaptcha13 = LOLCaptcha.this;
                        String str3 = Logger.defaultTag;
                        Logger.logInfo(str3, lOLCaptcha13.getTag() + ": " + ("finally block start, audioRecorderNewlyCreated=" + zBooleanValue), null);
                        LocalBroadcastManager.getInstance(LOLCaptcha.this.getApplicationContext()).unregisterReceiver(broadcastReceiver);
                        if (zBooleanValue) {
                            audioRecorder2.pause(AudioRecorder.PauseReason.TERMINATING);
                            audioRecorder2.stop();
                        } else {
                            audioRecorder2.removeAndCloseConsumerIfPossible(nullAudioConsumer);
                        }
                        LOLCaptcha lOLCaptcha14 = LOLCaptcha.this;
                        Logger.logInfo(Logger.defaultTag, lOLCaptcha14.getTag() + ": finally block end", null);
                        return;
                    }
                }
            } catch (Throwable th) {
                LOLCaptcha lOLCaptcha15 = LOLCaptcha.this;
                String str4 = Logger.defaultTag;
                Logger.logInfo(str4, lOLCaptcha15.getTag() + ": " + ("finally block start, audioRecorderNewlyCreated=" + zBooleanValue), null);
                LocalBroadcastManager.getInstance(LOLCaptcha.this.getApplicationContext()).unregisterReceiver(broadcastReceiver);
                if (zBooleanValue) {
                    audioRecorder2.pause(AudioRecorder.PauseReason.TERMINATING);
                    audioRecorder2.stop();
                } else {
                    audioRecorder2.removeAndCloseConsumerIfPossible(nullAudioConsumer);
                }
                LOLCaptcha lOLCaptcha16 = LOLCaptcha.this;
                Logger.logInfo(Logger.defaultTag, lOLCaptcha16.getTag() + ": finally block end", null);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AudioRecorder createNewAudioRecorder(AudioRecorder.Consumer consumer) {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        AudioRecorder audioRecorder = new AudioRecorder(applicationContext);
        AudioRecorder.addConsumer$default(audioRecorder, consumer, 0, 2, null);
        audioRecorder.explicitRecording();
        new Thread(audioRecorder).start();
        return audioRecorder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayWarning(int resourceKey) {
        runOnUiThread(new LOLCaptcha$$ExternalSyntheticLambda2(this, resourceKey, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayWarning$lambda$0(LOLCaptcha lOLCaptcha, int i) {
        Toast.makeText(lOLCaptcha.getApplicationContext(), i, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProgressText(double count, double startCount) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return String.format("%d<small>%%</small>", Arrays.copyOf(new Object[]{Long.valueOf(Math.round((1.0d - (count / startCount)) * 100.0d))}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markSolved() {
        runOnUiThread(new LOLCaptcha$$ExternalSyntheticLambda1(this, 0));
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        double difficulty;
        super.onCreate(savedInstanceState);
        Logger.logInfo(Logger.defaultTag, getTag() + ": onCreate start", null);
        setContentView(R.layout.captcha_lol);
        int i = 0;
        if (getResources().getBoolean(R.bool.tablet)) {
            setRequestedOrientation(0);
            setRequestedOrientation(14);
        } else {
            setRequestedOrientation(1);
            setRequestedOrientation(14);
        }
        if (getLastCustomNonConfigurationInstance() == null || !(getLastCustomNonConfigurationInstance() instanceof Double)) {
            difficulty = ((double) getDifficulty()) * 3.0d;
        } else {
            Object lastCustomNonConfigurationInstance = getLastCustomNonConfigurationInstance();
            lastCustomNonConfigurationInstance.getClass();
            difficulty = ((Double) lastCustomNonConfigurationInstance).doubleValue();
        }
        this.count = difficulty;
        if (savedInstanceState != null) {
            this.count = savedInstanceState.getDouble("count", this.count);
        }
        this.countStart = this.count;
        View viewFindViewById = findViewById(R.id.captcha_si_count);
        TextView textView = (TextView) viewFindViewById;
        textView.setText(Html.fromHtml(getProgressText(this.count, this.countStart)));
        viewFindViewById.getClass();
        this.countText = textView;
        setTitle(R.string.captcha_lol_title);
        View viewFindViewById2 = findViewById(R.id.captcha_si);
        LOLView lOLView = (LOLView) viewFindViewById2;
        lOLView.setOnClickListener(new LOLCaptcha$$ExternalSyntheticLambda0(this, i));
        viewFindViewById2.getClass();
        this.lolView = lOLView;
        Logger.logInfo(Logger.defaultTag, getTag() + ": onCreate end", null);
        WaveDrawable waveDrawable = new WaveDrawable();
        this.waveDrawable = waveDrawable;
        waveDrawable.setInterval(20);
        WaveDrawable waveDrawable2 = this.waveDrawable;
        waveDrawable2.getClass();
        waveDrawable2.setFastMode(true);
        WaveDrawable waveDrawable3 = this.waveDrawable;
        waveDrawable3.getClass();
        waveDrawable3.addWave(60, 1, ColorUtil.i(this, R.color.tint), 1.8f, 0.02f, 0.7f);
        WaveDrawable waveDrawable4 = this.waveDrawable;
        waveDrawable4.getClass();
        waveDrawable4.addWave(40, 18, ColorUtil.i(this, R.color.tint_background), 2.4f, 0.0016f, 0.9f);
        WaveDrawable waveDrawable5 = this.waveDrawable;
        waveDrawable5.getClass();
        waveDrawable5.setAlpha(150);
        View viewFindViewById3 = findViewById(R.id.wave);
        viewFindViewById3.getClass();
        ((ViewGroup) viewFindViewById3).setBackgroundDrawable(this.waveDrawable);
        WaveDrawable waveDrawable6 = this.waveDrawable;
        waveDrawable6.getClass();
        waveDrawable6.start();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        permissions.getClass();
        grantResults.getClass();
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        String str = "onRequestPermissionsResult: " + requestCode + ", " + ArraysKt.toList(permissions) + ", " + ArraysKt.toList(grantResults);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
        if (requestCode == 972) {
            if (!(permissions.length == 0) && Intrinsics.areEqual(permissions[0], "android.permission.RECORD_AUDIO")) {
                if (!(grantResults.length == 0) && grantResults[0] == 0 && this.laughterThread == null) {
                    LaughterThread laughterThread = new LaughterThread();
                    laughterThread.start();
                    this.laughterThread = laughterThread;
                    return;
                }
            }
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": Permissions: RECORD_AUDIO not granted, marking the captcha solved", null);
        markSolved();
        displayWarning(R.string.captcha_lol_no_permission);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WaveDrawable waveDrawable = this.waveDrawable;
        waveDrawable.getClass();
        waveDrawable.start();
    }

    @Override // androidx.view.ComponentActivity
    public Double onRetainCustomNonConfigurationInstance() {
        return Double.valueOf(this.count);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        outState.putDouble("count", this.count);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Logger.logInfo(Logger.defaultTag, getTag() + ": onStart start", null);
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        if (sleepPermissionCompat.isPermissionGranted(applicationContext, "android.permission.RECORD_AUDIO")) {
            LaughterThread laughterThread = new LaughterThread();
            laughterThread.start();
            this.laughterThread = laughterThread;
        } else {
            Logger.logInfo(Logger.defaultTag, getTag() + ": Permissions: RECORD_AUDIO Request", null);
            sleepPermissionCompat.requestPermission(this, "android.permission.RECORD_AUDIO", 972);
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": onStart end", null);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Logger.logInfo(Logger.defaultTag, getTag() + ": onStop start", null);
        LaughterThread laughterThread = this.laughterThread;
        if (laughterThread != null) {
            laughterThread.interrupt();
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": onStop end", null);
    }
}
