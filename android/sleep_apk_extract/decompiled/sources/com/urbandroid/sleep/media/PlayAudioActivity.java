package com.urbandroid.sleep.media;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.audiofx.LoudnessEnhancer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.Slider;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.directorypicker.DirectoryPicker;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.gui.SafeSliderWrapper;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.mic.VosRecordingWriter;
import com.urbandroid.sleep.service.DeleteObsoleteNoisesService;
import com.urbandroid.sleep.service.NoiseMediaStoreJob;
import com.urbandroid.sleep.service.NoiseUriAsyncTask;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.SnoringDetectionErrorDialogFragment;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.VolumeUtil;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class PlayAudioActivity extends BaseActivity implements View.OnTouchListener {
    private Noise currentNoise;
    private TextView durationText;
    private TextView elapsedText;
    private GraphView graph;
    private LoudnessEnhancer loudnessEnhancer;
    private MediaPlayer mediaPlayer;
    private MaterialButton pause;
    private SafeSliderWrapper progress;
    private EditText ratingComment;
    private MaterialButton star;
    private SafeSliderWrapper volumebar;
    private boolean playing = false;
    private Handler handler = new Handler();
    private List<Long> noiseIds = new ArrayList();
    private int pointer = 0;
    private int restoredPosition = 0;
    private int currentBoost = 0;
    private boolean showingDialog = false;
    private boolean needsSaving = false;
    private Runnable updateTimeTask = new Runnable() { // from class: com.urbandroid.sleep.media.PlayAudioActivity.6
        @Override // java.lang.Runnable
        public void run() {
            try {
                long duration = PlayAudioActivity.this.mediaPlayer.getDuration();
                long currentPosition = PlayAudioActivity.this.mediaPlayer.getCurrentPosition();
                PlayAudioActivity.this.durationText.setText(PlayAudioActivity.this.milliSecondsToTimer(duration));
                PlayAudioActivity.this.elapsedText.setText(PlayAudioActivity.this.milliSecondsToTimer(currentPosition));
                PlayAudioActivity.this.progress.setValue((int) currentPosition);
                PlayAudioActivity.this.graph.setSelectPoint2Percentage(currentPosition / duration);
                PlayAudioActivity.this.graph.setSelectPoint1(PlayAudioActivity.this.graph.getSelectPoint(PlayAudioActivity.this.graph.getSelectPoint2Percent()) - 4.0f);
                PlayAudioActivity.this.graph.invalidate();
                PlayAudioActivity.this.handler.postDelayed(this, 50L);
                if (PlayAudioActivity.this.loudnessEnhancer != null) {
                    try {
                        PlayAudioActivity.this.loudnessEnhancer.setTargetGain(PlayAudioActivity.this.currentBoost);
                        PlayAudioActivity.this.loudnessEnhancer.setEnabled(true);
                    } catch (Exception e) {
                        Logger.logSevere("PlayAudioActivity:", e);
                    }
                }
            } catch (Exception e2) {
                Logger.logSevere("PlayAudioActivity: ", e2);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        next();
        play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(MediaPlayer mediaPlayer) {
        this.handler.post(new PlayAudioActivity$$ExternalSyntheticLambda11(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(int i, Slider slider, float f, boolean z) {
        VolumeUtil.setStreamVolume(getApplicationContext(), 3, Math.min(Math.round(f), i));
        this.currentBoost = Math.max(0, Math.round(f - i)) * 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11() {
        try {
            this.mediaPlayer.start();
            int i = this.restoredPosition;
            if (i > 0) {
                this.mediaPlayer.seekTo(i);
                this.restoredPosition = 0;
            }
            LoudnessEnhancer loudnessEnhancer = this.loudnessEnhancer;
            if (loudnessEnhancer != null) {
                loudnessEnhancer.setEnabled(false);
                this.loudnessEnhancer.release();
                this.loudnessEnhancer = null;
            }
            try {
                LoudnessEnhancer loudnessEnhancer2 = new LoudnessEnhancer(this.mediaPlayer.getAudioSessionId());
                this.loudnessEnhancer = loudnessEnhancer2;
                loudnessEnhancer2.setTargetGain(this.currentBoost);
                this.loudnessEnhancer.setEnabled(true);
            } catch (Exception e) {
                Logger.logSevere("PlayAudioActivity: ", e);
            }
            Logger.logInfo("PlayAudioActivity: duration " + this.mediaPlayer.getDuration());
            this.progress.setValueTo((float) this.mediaPlayer.getDuration());
            this.progress.setValue(0.0f);
            updateProgressBar();
        } catch (IllegalStateException unused) {
            play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(MediaPlayer mediaPlayer) {
        this.handler.post(new PlayAudioActivity$$ExternalSyntheticLambda11(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$2(MediaPlayer mediaPlayer, int i, int i2) {
        zza$$ExternalSyntheticOutline0.m(i, i2, "PlayAudioActivity: ERROR ", " ");
        Toast.makeText(this, R.string.general_unspecified_error, 1).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$onCreate$3(float f) {
        return milliSecondsToTimer((int) f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        Noise noise = this.currentNoise;
        if (noise != null) {
            noise.setStarred(!noise.isStarred());
            setStar();
            this.needsSaving = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        try {
            next();
            play();
        } catch (IllegalStateException e) {
            Logger.logSevere("PlayAudioActivity: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        Toast.makeText(this, R.string.settings_dismiss_long_press_title, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$7(View view) {
        try {
            remove();
            play();
            return true;
        } catch (IllegalStateException e) {
            Logger.logSevere("PlayAudioActivity: ", e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        try {
            prev();
            play();
        } catch (IllegalStateException e) {
            Logger.logSevere("PlayAudioActivity: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        boolean z = this.playing;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (z) {
            mediaPlayer.pause();
            this.pause.setIconResource(R.drawable.ex_play);
            findViewById(R.id.playIndicator).setVisibility(8);
            this.pause.setChecked(true);
            this.playing = false;
            return;
        }
        mediaPlayer.start();
        this.pause.setIconResource(R.drawable.ex_pause);
        findViewById(R.id.playIndicator).setVisibility(0);
        this.pause.setChecked(false);
        this.playing = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void play() {
        this.needsSaving = false;
        Logger.logInfo("PlayAudioActivity: play() pointer: " + this.pointer);
        int i = this.pointer;
        if (i >= 0 && i < this.noiseIds.size()) {
            Long l = this.noiseIds.get(this.pointer);
            l.longValue();
            this.playing = true;
            this.pause.setIconResource(R.drawable.ex_pause);
            findViewById(R.id.playIndicator).setVisibility(0);
            this.pause.setChecked(false);
            final Noise noise = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoise(l);
            if (noise == null) {
                finish();
                return;
            }
            this.currentNoise = noise;
            if (playNoise(noise, noise.getUriFix(this))) {
                Logger.logInfo("PlayAudioActivity uri fix ok " + noise);
            } else {
                Logger.logInfo("PlayAudioActivity uri fix failed, trying async task " + noise);
                new NoiseUriAsyncTask(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity.3
                    @Override // android.os.AsyncTask
                    public void onPostExecute(String str) {
                        super.onPostExecute(str);
                        PlayAudioActivity.this.playNoise(noise, str, true);
                    }

                    @Override // android.os.AsyncTask
                    public void onPreExecute() {
                        super.onPreExecute();
                        Logger.logInfo("PlayAudioActivity NoiseUriAsyncTask onPreExecute " + System.currentTimeMillis());
                        PlayAudioActivity.this.findViewById(R.id.progress).setVisibility(0);
                    }
                }.execute(noise);
            }
        } else if (this.showingDialog) {
            this.showingDialog = false;
        } else {
            finish();
        }
    }

    private void releasePlayer() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.updateTimeTask);
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                try {
                    try {
                        mediaPlayer.stop();
                        this.mediaPlayer.release();
                    } catch (Exception e) {
                        Logger.logSevere("PlayAudioActivity: ", e);
                        this.mediaPlayer.release();
                    }
                } catch (Exception e2) {
                    Logger.logSevere("PlayAudioActivity: ", e2);
                }
            } catch (Throwable th) {
                try {
                    this.mediaPlayer.release();
                } catch (Exception e3) {
                    Logger.logSevere("PlayAudioActivity: ", e3);
                }
                throw th;
            }
        }
    }

    private boolean save() {
        boolean z;
        if (this.currentNoise == null) {
            return false;
        }
        if (this.ratingComment.getText() == null || this.ratingComment.getText().toString().equals(this.currentNoise.getComment())) {
            z = false;
        } else {
            String string = this.ratingComment.getText().toString();
            new SleepRecords().adjustSnoring(getApplicationContext(), this.currentNoise, string);
            Set<String> removedTags = Tag.getRemovedTags(this.currentNoise.getComment(), string);
            Set<String> removedTags2 = Tag.getRemovedTags(string, this.currentNoise.getComment());
            if (this.currentNoise.getLength() > 30000 && SharedApplicationContext.getSettings().isShareSnoringDetectionErrors() && (SnoringDetectionErrorDialogFragment.hasInterestingTag(removedTags) || SnoringDetectionErrorDialogFragment.hasInterestingTag(removedTags2))) {
                try {
                    SnoringDetectionErrorDialogFragment.newInstance(this.currentNoise.getId().longValue(), "Noise detection improvement V4b, removed: " + SnoringDetectionErrorDialogFragment.setToString(removedTags) + "added: " + SnoringDetectionErrorDialogFragment.setToString(removedTags2)).show(getSupportFragmentManager(), "snoring_error");
                    this.showingDialog = true;
                    z = true;
                } catch (Exception e) {
                    Logger.logSevere("PlayAudioActivity: ", e);
                    z = false;
                }
                this.currentNoise.setComment(string);
                this.needsSaving = true;
            } else {
                z = false;
                this.currentNoise.setComment(string);
                this.needsSaving = true;
            }
        }
        if (this.needsSaving) {
            SharedApplicationContext.getInstance().getSleepRecordRepository().updateNoise(this.currentNoise);
            if (this.currentNoise.isStarred() && !this.currentNoise.isSync() && SharedApplicationContext.getSettings().isMediaStoreAlbum()) {
                NoiseMediaStoreJob.start(this, this.currentNoise.getId().longValue());
            }
        }
        this.needsSaving = false;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStar() {
        boolean zIsStarred = this.currentNoise.isStarred();
        MaterialButton materialButton = this.star;
        if (zIsStarred) {
            materialButton.setIconResource(R.drawable.ic_star_color_24);
        } else {
            materialButton.setIconResource(R.drawable.ic_star_outline);
        }
    }

    public String milliSecondsToTimer(long j) {
        String str;
        int i = (int) (j / 3600000);
        long j2 = j % 3600000;
        int i2 = ((int) j2) / 60000;
        int i3 = (int) ((j2 % 60000) / 1000);
        if (i > 0) {
            str = i + ":";
        } else {
            str = "";
        }
        return str + i2 + ":" + (i3 < 10 ? FileInsert$$ExternalSyntheticOutline0.m(i3, AppEventsConstants.EVENT_PARAM_VALUE_NO) : FileInsert$$ExternalSyntheticOutline0.m(i3, ""));
    }

    public synchronized void next() {
        save();
        this.pointer++;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Settings settings = SharedApplicationContext.getSettings();
        if (Environment.isLollipopOrGreater() && i == 111 && i2 == -1) {
            Uri directoryPicked = DirectoryPicker.parseDirectoryPicked(SharedApplicationContext.getInstance().getContext(), intent);
            settings.setNoiseDirUri(directoryPicked);
            if (NoiseDirectory.checkReadWriteAccessUri(SharedApplicationContext.getInstance().getContext(), directoryPicked)) {
                Logger.logInfo("PlayAudioActivity: Noise record directory set to: " + directoryPicked);
            }
            play();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        getWindow().addFlags(128);
        if (getIntent() == null || !getIntent().hasExtra("noise_ids")) {
            finish();
            return;
        }
        final int i = 0;
        for (long j : getIntent().getLongArrayExtra("noise_ids")) {
            this.noiseIds.add(Long.valueOf(j));
        }
        setContentView(R.layout.activity_player);
        ToolbarUtil.apply(this);
        final int i2 = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        EdgeToEdgeUtil.insetsVertical(findViewById(R.id.root));
        if (bundle != null) {
            this.pointer = bundle.getInt("pointer");
            this.restoredPosition = bundle.getInt("pos");
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("PlayAudioActivity: restore() pointer: "), this.pointer);
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                this.f$0.lambda$onCreate$1(mediaPlayer2);
            }
        });
        this.mediaPlayer.setOnErrorListener(new OneTimePlayer$$ExternalSyntheticLambda1(this, i2));
        GraphView graphView = (GraphView) findViewById(R.id.graph);
        this.graph = graphView;
        graphView.setDoTrimming(false);
        this.graph.setDoMirrorGraph(true);
        this.graph.setForceXAxisOffset(false);
        this.graph.setDoDrawGraphLine(false);
        this.graph.setCardColor(ContextCompat.getColor(this, R.color.transparent));
        this.graph.setDrawXAxis(false);
        this.graph.setDrawYAxis(false);
        this.graph.setOnTouchListener(this);
        this.volumebar = new SafeSliderWrapper((Slider) findViewById(R.id.volumebar));
        this.elapsedText = (TextView) findViewById(R.id.elapsed);
        this.durationText = (TextView) findViewById(R.id.duration);
        SafeSliderWrapper safeSliderWrapper = new SafeSliderWrapper((Slider) findViewById(R.id.seek));
        this.progress = safeSliderWrapper;
        safeSliderWrapper.getSlider().setLabelFormatter(new MediaListActivity$$ExternalSyntheticLambda3(this));
        this.progress.getSlider().addOnSliderTouchListener(new BaseOnSliderTouchListener() { // from class: com.urbandroid.sleep.media.PlayAudioActivity.1
            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStartTrackingTouch(Slider slider) {
                PlayAudioActivity.this.handler.removeCallbacks(PlayAudioActivity.this.updateTimeTask);
            }

            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStopTrackingTouch(Slider slider) {
                PlayAudioActivity.this.handler.removeCallbacks(PlayAudioActivity.this.updateTimeTask);
                try {
                    float value = slider.getValue();
                    float duration = PlayAudioActivity.this.mediaPlayer.getDuration();
                    PlayAudioActivity playAudioActivity = PlayAudioActivity.this;
                    if (value >= duration) {
                        playAudioActivity.next();
                        PlayAudioActivity.this.play();
                    } else {
                        playAudioActivity.mediaPlayer.seekTo((int) slider.getValue());
                    }
                } catch (IllegalStateException e) {
                    Logger.logSevere(e);
                }
                PlayAudioActivity.this.updateProgressBar();
            }
        });
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.media_star);
        this.star = materialButton;
        materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ PlayAudioActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                PlayAudioActivity playAudioActivity = this.f$0;
                switch (i3) {
                    case 0:
                        playAudioActivity.lambda$onCreate$4(view);
                        break;
                    case 1:
                        playAudioActivity.lambda$onCreate$5(view);
                        break;
                    case 2:
                        playAudioActivity.lambda$onCreate$6(view);
                        break;
                    case 3:
                        playAudioActivity.lambda$onCreate$8(view);
                        break;
                    default:
                        playAudioActivity.lambda$onCreate$9(view);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.media_next)).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ PlayAudioActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                PlayAudioActivity playAudioActivity = this.f$0;
                switch (i3) {
                    case 0:
                        playAudioActivity.lambda$onCreate$4(view);
                        break;
                    case 1:
                        playAudioActivity.lambda$onCreate$5(view);
                        break;
                    case 2:
                        playAudioActivity.lambda$onCreate$6(view);
                        break;
                    case 3:
                        playAudioActivity.lambda$onCreate$8(view);
                        break;
                    default:
                        playAudioActivity.lambda$onCreate$9(view);
                        break;
                }
            }
        });
        MaterialButton materialButton2 = (MaterialButton) findViewById(R.id.media_delete);
        final int i3 = 2;
        materialButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ PlayAudioActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i3;
                PlayAudioActivity playAudioActivity = this.f$0;
                switch (i32) {
                    case 0:
                        playAudioActivity.lambda$onCreate$4(view);
                        break;
                    case 1:
                        playAudioActivity.lambda$onCreate$5(view);
                        break;
                    case 2:
                        playAudioActivity.lambda$onCreate$6(view);
                        break;
                    case 3:
                        playAudioActivity.lambda$onCreate$8(view);
                        break;
                    default:
                        playAudioActivity.lambda$onCreate$9(view);
                        break;
                }
            }
        });
        materialButton2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$onCreate$7(view);
            }
        });
        final int i4 = 3;
        ((Button) findViewById(R.id.media_prev)).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ PlayAudioActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i4;
                PlayAudioActivity playAudioActivity = this.f$0;
                switch (i32) {
                    case 0:
                        playAudioActivity.lambda$onCreate$4(view);
                        break;
                    case 1:
                        playAudioActivity.lambda$onCreate$5(view);
                        break;
                    case 2:
                        playAudioActivity.lambda$onCreate$6(view);
                        break;
                    case 3:
                        playAudioActivity.lambda$onCreate$8(view);
                        break;
                    default:
                        playAudioActivity.lambda$onCreate$9(view);
                        break;
                }
            }
        });
        MaterialButton materialButton3 = (MaterialButton) findViewById(R.id.media_pause);
        this.pause = materialButton3;
        final int i5 = 4;
        materialButton3.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ PlayAudioActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i5;
                PlayAudioActivity playAudioActivity = this.f$0;
                switch (i32) {
                    case 0:
                        playAudioActivity.lambda$onCreate$4(view);
                        break;
                    case 1:
                        playAudioActivity.lambda$onCreate$5(view);
                        break;
                    case 2:
                        playAudioActivity.lambda$onCreate$6(view);
                        break;
                    case 3:
                        playAudioActivity.lambda$onCreate$8(view);
                        break;
                    default:
                        playAudioActivity.lambda$onCreate$9(view);
                        break;
                }
            }
        });
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        final int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        Logger.logInfo("PlayAudioActivity: Volume: " + streamMaxVolume + " + 6");
        this.volumebar.getSlider().setCustomThumbDrawable(R.drawable.ic_progress_volume);
        this.volumebar.getSlider().setThumbRadius(ActivityUtils.getDip(this, 20));
        this.volumebar.setValueFrom(0.0f);
        this.volumebar.setValueTo(streamMaxVolume + 6);
        this.volumebar.setValue(streamVolume);
        this.volumebar.getSlider().addOnChangeListener(new Slider.OnChangeListener() { // from class: com.urbandroid.sleep.media.PlayAudioActivity$$ExternalSyntheticLambda10
            @Override // com.google.android.material.slider.Slider.OnChangeListener
            public final void onValueChange(Slider slider, float f, boolean z) {
                this.f$0.lambda$onCreate$10(streamMaxVolume, slider, f, z);
            }
        });
        this.mediaPlayer.setOnPreparedListener(new MediaListAdapter$$ExternalSyntheticLambda5(this, i2));
        this.ratingComment = (EditText) findViewById(R.id.comment);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tags);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.urbandroid.sleep.media.PlayAudioActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.logInfo("PlayAudioActivity: OnClick '" + ((Object) PlayAudioActivity.this.ratingComment.getText()) + "'");
                if (PlayAudioActivity.this.ratingComment.getText() == null || PlayAudioActivity.this.ratingComment.getText().toString() == null || PlayAudioActivity.this.ratingComment.getText().toString().trim().length() <= 0) {
                    Logger.logInfo("PlayAudioActivity: UnSet star");
                    PlayAudioActivity.this.currentNoise.setStarred(false);
                } else {
                    Logger.logInfo("PlayAudioActivity: Set star");
                    PlayAudioActivity.this.currentNoise.setStarred(true);
                }
                PlayAudioActivity.this.setStar();
            }
        };
        Tag.handleTag((Context) this, Tag.SNORE.getTagName(), this.ratingComment, viewGroup, false, onClickListener);
        Tag.handleTag((Context) this, Tag.TALK.getTagName(), this.ratingComment, viewGroup, false, onClickListener);
        Tag.handleTag((Context) this, Tag.LAUGH.getTagName(), this.ratingComment, viewGroup, false, onClickListener);
        Tag.handleTag((Context) this, Tag.SICK.getTagName(), this.ratingComment, viewGroup, false, onClickListener);
        Tag.handleTag((Context) this, Tag.BABY.getTagName(), this.ratingComment, viewGroup, false, onClickListener);
        Tag.handleTag((Context) this, Tag.NOTE.getTagName(), this.ratingComment, viewGroup, false, onClickListener);
        Logger.logInfo("PlayAudioActivity: play()?");
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_MEDIA_AUDIO")) {
            Logger.logInfo("PlayAudioActivity: needs AUDIO permisison");
            SleepPermissionCompat.INSTANCE.requestPermission(this, "android.permission.READ_MEDIA_AUDIO", 972);
        } else if (i6 >= 33 || PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
            play();
        } else {
            Logger.logInfo("PlayAudioActivity: needs STORAGE permisison");
            SleepPermissionCompat.INSTANCE.requestPermission(this, "android.permission.READ_EXTERNAL_STORAGE", 972);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.play_noise_menu, menu);
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releasePlayer();
        DeleteObsoleteNoisesService.start(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && save()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            save();
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_share) {
            if (this.currentNoise != null) {
                new NoiseUriAsyncTask(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity.4
                    @Override // android.os.AsyncTask
                    public void onPostExecute(String str) {
                        super.onPostExecute(str);
                        PlayAudioActivity.this.findViewById(R.id.progress).setVisibility(8);
                        Logger.logInfo("PlayAudioActivity: Sharing file uri - " + str);
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType("audio/*");
                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(str));
                        PlayAudioActivity playAudioActivity = PlayAudioActivity.this;
                        playAudioActivity.startActivity(Intent.createChooser(intent, playAudioActivity.getApplicationContext().getResources().getString(R.string.share_android)));
                    }

                    @Override // android.os.AsyncTask
                    public void onPreExecute() {
                        super.onPreExecute();
                        PlayAudioActivity.this.findViewById(R.id.progress).setVisibility(0);
                    }
                }.withFileToUriConvertion().execute(this.currentNoise);
            }
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_play_external) {
            try {
                if (this.currentNoise != null) {
                    new NoiseUriAsyncTask(this) { // from class: com.urbandroid.sleep.media.PlayAudioActivity.5
                        @Override // android.os.AsyncTask
                        public void onPostExecute(String str) {
                            super.onPostExecute(str);
                            PlayAudioActivity.this.findViewById(R.id.progress).setVisibility(8);
                            Logger.logInfo("PlayAudioActivity: Playing external - " + str);
                            String str2 = str.endsWith(VosRecordingWriter.EXTENSION) ? "audio/vorbis" : "audio/mp4a-latm";
                            try {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setDataAndType(Uri.parse(str), str2);
                                intent.addFlags(1);
                                PlayAudioActivity.this.startActivity(intent);
                            } catch (Exception e) {
                                Logger.logSevere("PlayAudioActivity: ", e);
                                Toast.makeText(PlayAudioActivity.this, R.string.general_unspecified_error, 1).show();
                            }
                        }

                        @Override // android.os.AsyncTask
                        public void onPreExecute() {
                            super.onPreExecute();
                            PlayAudioActivity.this.findViewById(R.id.progress).setVisibility(0);
                        }
                    }.withFileToUriConvertion().execute(this.currentNoise);
                }
            } catch (Exception e) {
                Logger.logSevere("PlayAudioActivity: ", e);
                Toast.makeText(this, R.string.player_error, 0).show();
            }
        }
        return false;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Logger.logInfo("PlayAudioActivity: onRequestPermissionsResult ");
        for (int i2 = 0; i2 < strArr.length; i2++) {
            zza$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m5m("PlayAudioActivity: onRequestPermissionsResult permission ", strArr[i2], " = "), iArr[i2]);
            int i3 = iArr[i2];
        }
        if (i != 972) {
            return;
        }
        if (iArr[0] == 0) {
            Logger.logInfo("PlayAudioActivity: Permissions: STORAGE Granted ");
        } else {
            Logger.logInfo("PlayAudioActivity: Permissions: STORAGE NOT Granted ");
        }
        play();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Logger.logInfo("Resume " + this.mediaPlayer.isPlaying());
        boolean z = this.playing;
        MaterialButton materialButton = this.pause;
        if (z) {
            materialButton.setIconResource(R.drawable.ex_pause);
            findViewById(R.id.playIndicator).setVisibility(0);
            this.pause.setChecked(false);
        } else {
            materialButton.setIconResource(R.drawable.ex_play);
            findViewById(R.id.playIndicator).setVisibility(8);
            this.pause.setChecked(true);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("pointer", this.pointer);
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("PlayAudioActivity: save() pointer: "), this.pointer);
        try {
            bundle.putInt("pos", this.mediaPlayer.getCurrentPosition());
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.graph.setSelectPoint2(motionEvent.getX());
            this.graph.setSelectPoint1(motionEvent.getX());
        } else if (motionEvent.getAction() == 1) {
            int iRound = Math.round((motionEvent.getX() * this.mediaPlayer.getDuration()) / this.graph.getWidth());
            if (iRound >= this.mediaPlayer.getDuration()) {
                next();
                play();
            } else {
                this.mediaPlayer.seekTo(iRound);
            }
        }
        return true;
    }

    public boolean playNoise(Noise noise, String str, boolean z) {
        Logger.logInfo("PlayAudioActivity: NoiseUriAsyncTask onPostExecute " + System.currentTimeMillis());
        findViewById(R.id.progress).setVisibility(8);
        long time = noise.getTo().getTime() - noise.getFrom().getTime();
        StringBuilder sb = new StringBuilder("PlayAudioActivity: Playing noise ");
        sb.append(noise.getUri());
        sb.append(" starred ");
        sb.append(noise.isStarred());
        sb.append(" from ");
        sb.append(noise.getFrom());
        sb.append(" to ");
        sb.append(noise.getTo());
        zzba$$ExternalSyntheticOutline0.m(sb, " duration ", time, " points ");
        sb.append(this.currentNoise.getData().length / time);
        Logger.logInfo(sb.toString());
        this.ratingComment.setText(this.currentNoise.getComment());
        setStar();
        getSupportActionBar().setTitle(DateUtil.getShortDateInstanceWithoutYearsWithTime(this, DesugarTimeZone.getTimeZone(noise.getTimezone())).format(noise.getFrom()));
        TextView textView = (TextView) findViewById(R.id.position);
        textView.setTextColor(ColorUtil.i(this, R.color.primary));
        textView.setText((this.pointer + 1) + " / " + this.noiseIds.size());
        this.graph.setVisibility(0);
        this.graph.setEquidistantValues(noise.getData(), false);
        this.graph.invalidate();
        try {
            Logger.logInfo("PlayAudioActivity: playing " + str);
            if (str != null) {
                playUri(str);
            }
            return true;
        } catch (Exception e) {
            Logger.logSevere("PlayAudioActivity: Could not open file " + str + " for playback.", e);
            if (z) {
                Toast.makeText(this, R.string.player_error, 0).show();
            }
            return false;
        }
    }

    public void playUri(String str) throws IOException {
        Logger.logInfo("PlayAudioActivity: Noise path '" + str + "'");
        this.mediaPlayer.reset();
        boolean zIsContentUri = NoiseDirectory.isContentUri(str);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (zIsContentUri) {
            try {
                mediaPlayer.setDataSource(getApplicationContext(), Uri.parse(str));
            } catch (Exception e) {
                Logger.logSevere("PlayAudioActivity: Could not open file " + str + " for playback.", e);
                if (Environment.isLollipopOrGreater()) {
                    DirectoryPicker.open(this, 111);
                }
                Toast.makeText(this, getString(R.string.storage_path) + ": " + getString(R.string.player_error), 1).show();
                return;
            }
        } else {
            mediaPlayer.setDataSource(str);
        }
        this.mediaPlayer.prepare();
    }

    public synchronized void prev() {
        save();
        int i = this.pointer;
        if (i > 0) {
            this.pointer = i - 1;
        }
    }

    public synchronized void remove() {
        if (this.currentNoise != null && this.pointer < this.noiseIds.size()) {
            Noise noise = this.currentNoise;
            Date date = DeleteObsoleteNoisesService.TO_BE_DELETED_DATE;
            noise.setFrom(date);
            this.currentNoise.setTo(date);
            this.currentNoise.setStarred(false);
            SharedApplicationContext.getInstance().getSleepRecordRepository().updateNoise(this.currentNoise);
            this.noiseIds.remove(this.pointer);
        }
    }

    public void updateProgressBar() {
        this.handler.postDelayed(this.updateTimeTask, 50L);
    }

    public boolean playNoise(Noise noise, String str) {
        return playNoise(noise, str, false);
    }
}
