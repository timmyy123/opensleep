package com.urbandroid.sleep.media.lullaby;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.RemoteViews;
import android.widget.Toast;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.wifi.WifiContext;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.media.player.PlaybackListener;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.VolumeUtil;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes.dex */
public class LullabyService extends ForegroundService {
    public static String LULLABY_NAME = null;
    private static boolean running = false;
    private LullabyAudioFocusChangeListener audioFocusChangeListener;
    private AudioFocusRequest audioFocusRequest;
    private AudioManager audioManager;
    private Runnable autoStopRunnable;
    private Handler handler;
    private boolean headset;
    private boolean isMeditation;
    private boolean isSonar;
    private boolean isStopping;
    private MediaSessionCompat mediaSession;
    private MediaPlayer mp;
    private int offset;
    private boolean paused;
    private Runnable playNextGentleRunnable;
    private Runnable playNextRunnable;
    private Runnable playNextStopRunnable;
    private LullabyPlayer player;
    private boolean playing;
    private BroadcastReceiver receiver;
    private ISpotifyPlayer spotifyPlayer;
    private long startAfter;
    private float targetVolume;
    private BroadcastReceiver volumeReceiver;
    private AtomicReference<WifiContext> wifiContext;

    public LullabyService() {
        super("lullabyChannel", 485042985, R.drawable.ic_action_lullaby_white);
        this.paused = false;
        this.isStopping = false;
        this.isMeditation = false;
        this.playing = false;
        this.targetVolume = 0.0f;
        this.isSonar = false;
        this.offset = -1;
        this.wifiContext = new AtomicReference<>();
        this.headset = false;
        this.startAfter = 0L;
        this.handler = null;
        this.autoStopRunnable = new Runnable() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.logInfo("LullabyVolumeDown: autoStop()");
                LullabyService.this.autoStop();
            }
        };
        this.playNextGentleRunnable = new LullabyService$$ExternalSyntheticLambda1(this, 0);
        this.playNextStopRunnable = new LullabyService$$ExternalSyntheticLambda1(this, 1);
        this.playNextRunnable = new LullabyService$$ExternalSyntheticLambda1(this, 2);
        this.volumeReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("volume_current", -1);
                int intExtra2 = intent.getIntExtra("volume_target", -1);
                float volAdjust = LullabyPlayer.getVolAdjust(context, intExtra, intExtra2);
                float f = intExtra2 * volAdjust;
                Logger.logInfo("Lullaby: MP Sonar adjust volume " + volAdjust);
                if (LullabyService.this.mp != null) {
                    LullabyService.this.mp.setVolume(f, f);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoStop() {
        if (this.player != null) {
            Logger.logInfo("LullabyVolumeDown: gentleStop()");
            this.player.gentleStop();
            this.handler.postDelayed(new LullabyService$$ExternalSyntheticLambda1(this, 3), 20000L);
        } else {
            lambda$autoStop$1();
        }
        if (new Settings(this).isLullabyTurnOffWiFi()) {
            WifiEnabler.getInstance().setWifi(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: finishLullaby, reason: merged with bridge method [inline-methods] */
    public void lambda$autoStop$1() {
        try {
            Logger.logInfo("LullabyVolumeDown: finishLullaby()");
            setRunning(false);
            this.playing = false;
            if (this.isStopping) {
                stopForegroundSelf();
                WifiContext wifiContext = this.wifiContext.get();
                if (wifiContext != null) {
                    wifiContext.disable();
                    return;
                }
                return;
            }
            this.isStopping = true;
            unregisterReceiver();
            stopPlayer();
            sendResumeRecording();
            Logger.logInfo("Lullaby: Playlist removing callbacks ");
            this.handler.removeCallbacks(this.playNextGentleRunnable);
            this.handler.removeCallbacks(this.playNextStopRunnable);
            this.handler.removeCallbacks(this.playNextRunnable);
            if (this.isMeditation) {
                Logger.logInfo("Meditation: stop session ");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.urbandroid.lis10", "com.urbandroid.lis10.service.SessionService"));
                intent.setAction("com.urbandroid.lis10.STOP");
                ContextCompat.startForegroundService(this, intent);
            }
            LullabyAudioFocusChangeListener lullabyAudioFocusChangeListener = this.audioFocusChangeListener;
            if (lullabyAudioFocusChangeListener != null) {
                this.audioManager.abandonAudioFocus(lullabyAudioFocusChangeListener);
            }
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_LULLABY_STOPPED_PLAYBACK"));
            stopForegroundSelf();
            WifiContext wifiContext2 = this.wifiContext.get();
            if (wifiContext2 != null) {
                wifiContext2.disable();
            }
        } catch (Throwable th) {
            stopForegroundSelf();
            WifiContext wifiContext3 = this.wifiContext.get();
            if (wifiContext3 != null) {
                wifiContext3.disable();
            }
            throw th;
        }
    }

    private PendingIntentBuilder getStopPendingIntent() {
        return PendingIntentBuilder.get(getApplicationContext(), 123, new Intent("com.urbandroid.sleep.ACTION_LULLABY_AUTO_STOP_PLAYBACK"), 134217728);
    }

    public static synchronized boolean isRunning() {
        return running;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4() {
        playNext(this.offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDestroy$6(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onStartCommand$5(int i) {
        if (i == -1) {
            Logger.logInfo("Media Session Audio focus LOSS");
        } else {
            if (i != 1) {
                return;
            }
            Logger.logInfo("Media Session Audio focus GAIN");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopPlayer$0(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    public static Bitmap overlay(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), null);
        Paint paint = new Paint();
        paint.setAlpha(160);
        canvas.drawBitmap(bitmap2, 0.0f, -((bitmap.getWidth() - bitmap.getHeight()) / 2.0f), paint);
        bitmap.recycle();
        bitmap2.recycle();
        return bitmapCreateBitmap;
    }

    public static final void pause(Context context) {
        zza$$ExternalSyntheticOutline0.m(context, "com.urbandroid.sleep.ACTION_LULLABY_PAUSE_PLAYBACK");
    }

    private void playNext(int i) {
        LullabyPlayer.Lullaby[] lullabyByUsed = SharedApplicationContext.getSettings().getLullabyByUsed();
        int lullabyAutoPlaylistSize = i % SharedApplicationContext.getSettings().getLullabyAutoPlaylistSize();
        if (i == -1) {
            i = 1;
            lullabyAutoPlaylistSize = 1;
        }
        zza$$ExternalSyntheticOutline0.m(i, lullabyAutoPlaylistSize, "Lullaby: Playlist play next offset ", " lullaby order ");
        for (int i2 = 1; i2 < lullabyByUsed.length; i2++) {
            if (lullabyAutoPlaylistSize + 1 == i2) {
                Logger.logInfo("Lullaby: Playlist start " + lullabyByUsed[i2].getName());
                start(getApplicationContext(), lullabyByUsed[i2], i + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: playNextGentleStop, reason: merged with bridge method [inline-methods] */
    public void lambda$new$2() {
        Logger.logInfo("Lullaby: Playlist gentle stop ");
        LullabyPlayer lullabyPlayer = this.player;
        if (lullabyPlayer != null) {
            if (this.paused) {
                this.handler.removeCallbacks(this.playNextGentleRunnable);
                this.handler.postDelayed(this.playNextGentleRunnable, 20000L);
            } else {
                lullabyPlayer.gentleStop();
                this.handler.removeCallbacks(this.playNextStopRunnable);
                this.handler.postDelayed(this.playNextStopRunnable, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: playNextStop, reason: merged with bridge method [inline-methods] */
    public void lambda$new$3() {
        Logger.logInfo("Lullaby: Playlist stop ");
        lambda$autoStop$1();
        Logger.logInfo("Lullaby: Playlist schedule next 200");
        this.handler.removeCallbacks(this.playNextRunnable);
        this.handler.removeCallbacks(this.playNextStopRunnable);
        this.handler.removeCallbacks(this.playNextGentleRunnable);
        this.handler.postDelayed(this.playNextRunnable, 200L);
        Intent intent = new Intent(this, (Class<?>) LullabyService.class);
        intent.setPackage(getPackageName());
        stopService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playOnlineSource(String str) {
        ISpotifyPlayer.Companion companion = ISpotifyPlayer.INSTANCE;
        if (companion.isSpotifyUri(str)) {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Lullaby_started_spotify");
            this.spotifyPlayer = companion.getSpotifyPlayer(getApplicationContext(), new PlaybackListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.6
                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void fail(int i) {
                    Toast.makeText(LullabyService.this.getApplicationContext(), R.string.player_error, 1).show();
                    Logger.logDebug("Play spotify failed :-(");
                }

                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void playbackStarted() {
                    Intent intent = new Intent("com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK");
                    intent.putExtra("extra_lullaby_offset", LullabyService.this.offset);
                    ContextExtKt.sendExplicitBroadcast(LullabyService.this.getApplicationContext(), intent);
                }
            }).setMode(ISpotifyPlayer.PlayerMode.LULLABY);
            if (new Settings(getApplicationContext()).isUltrasonicTracking()) {
                this.spotifyPlayer.setForcePlay();
            }
            this.spotifyPlayer.play(str);
            return;
        }
        if (str != null) {
            try {
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Lullaby_started_radio");
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mp = mediaPlayer;
                mediaPlayer.setDataSource(getApplicationContext(), Uri.parse(str));
                this.mp.setAudioStreamType(3);
                this.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.7
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        Intent intent = new Intent("com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK");
                        intent.putExtra("extra_lullaby_offset", LullabyService.this.offset);
                        ContextExtKt.sendExplicitBroadcast(LullabyService.this.getApplicationContext(), intent);
                        mediaPlayer2.start();
                    }
                });
                this.mp.prepareAsync();
                this.targetVolume = Math.max(SharedApplicationContext.getSettings().getLullabyVolume(), 3) / 100.0f;
                int i = SleepService.SONAR_INITIAL_VOLUME;
                if (i > 0) {
                    float volAdjust = LullabyPlayer.getVolAdjust(this, i, new Settings(this).getSonarVolume(3));
                    Logger.logInfo("Lullaby: INIT MP Sonar adjust volume " + volAdjust);
                    this.targetVolume = this.targetVolume * volAdjust;
                }
                MediaPlayer mediaPlayer2 = this.mp;
                float f = this.targetVolume;
                mediaPlayer2.setVolume(f, f);
            } catch (IOException e) {
                Logger.logSevere(e);
            }
            LocalBroadcastManager.getInstance(this).registerReceiver(this.volumeReceiver, new IntentFilter("com.urbandroid.sleep.LULLABY_VOLUME_ACTION"));
        }
    }

    public static final void resume(Context context) {
        zza$$ExternalSyntheticOutline0.m(context, "com.urbandroid.sleep.ACTION_LULLABY_RESUME_PLAYBACK");
    }

    private void sendPauseRecording() {
        if (this.startAfter > 0) {
            Logger.logInfo("LullabyService: Pause recording");
            Intent intent = new Intent("com.urbandroid.sleep.ACTION_PAUSE_RECORDING");
            intent.putExtra("extra_pause_reason", AudioRecorder.PauseReason.LULLABY);
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), intent);
        }
    }

    private void sendResumeRecording() {
        if (this.startAfter > 0) {
            Logger.logInfo("LullabyService: Resume recording");
            Intent intent = new Intent("com.urbandroid.sleep.ACTION_RESUME_RECORDING");
            intent.putExtra("extra_pause_reason", AudioRecorder.PauseReason.LULLABY);
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSessionState(boolean z) {
        MediaSessionCompat mediaSessionCompat = this.mediaSession;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setPlaybackState(new PlaybackStateCompat.Builder().addCustomAction("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK", getString(R.string.player_stop), R.drawable.ic_action_stop).addCustomAction("rate", getString(R.string.rate), R.drawable.ic_star_outline).setActions(7L).setState(z ? 3 : 2, -1L, 1.0f).build());
            this.mediaSession.setActive(z);
        }
    }

    public static synchronized void setRunning(boolean z) {
        running = z;
    }

    public static void start(Context context, LullabyPlayer.Lullaby lullaby, int i) {
        Intent intent = new Intent(context, (Class<?>) LullabyService.class);
        intent.putExtra("extra_lullaby_name", lullaby.getDisplayName(context));
        intent.putExtra("extra_lullaby", lullaby.name());
        intent.putExtra("extra_lullaby_offset", i);
        Logger.logInfo("Lullaby: Playlist start next with offset " + i);
        ContextExtKt.startForegroundServiceWithLog(context, intent);
    }

    /* JADX WARN: Type inference failed for: r11v9, types: [androidx.media.app.NotificationCompat$MediaStyle] */
    private void startForeground(LullabyPlayer.Lullaby lullaby, String str) {
        PendingIntent broadcast = PendingIntentBuilder.get(this, 0, new Intent("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK"), 0).getBroadcast();
        Intent intent = new Intent(this, (Class<?>) LullabyActivity.class);
        intent.setFlags(603979776);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "lullabyChannel").setContentIntent(PendingIntentBuilder.get(this, 0, intent, 134217728).getActivity()).setColor(ColorUtil.i(this, R.color.tint_notification)).setContentTitle(str).addAction(R.drawable.ic_action_stop, getResources().getString(R.string.player_stop), broadcast).setContentText(getString(R.string.app_name_long));
        if (SharedApplicationContext.getSettings().isMeditationLullaby()) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.urbandroid.lis10"));
            intent2.setFlags(ClientDefaults.MAX_MSG_SIZE);
            contentText.addAction(R.drawable.ic_star_outline, getResources().getString(R.string.rate), PendingIntentBuilder.get(this, 121, intent2, 134217728).getActivity());
        } else if (lullaby != null && !lullaby.isLocalPackage()) {
            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + lullaby.getPackageName()));
            intent3.setFlags(ClientDefaults.MAX_MSG_SIZE);
            contentText.addAction(R.drawable.ic_star_outline, getResources().getString(R.string.rate), PendingIntentBuilder.get(this, 121, intent3, 134217728).getActivity());
        }
        contentText.setSmallIcon(R.drawable.ic_action_lullaby_white);
        if (this.mediaSession != null) {
            contentText.setStyle(new NotificationCompat.Style() { // from class: androidx.media.app.NotificationCompat$MediaStyle
                int mDeviceIcon;
                PendingIntent mDeviceIntent;
                CharSequence mDeviceName;
                MediaSessionCompat.Token mToken;
                int[] mActionsToShowInCompact = null;
                boolean mShowRemotePlaybackInfo = false;

                @Override // androidx.core.app.NotificationCompat.Style
                public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        NotificationCompat$Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), NotificationCompat$Api21Impl.fillInMediaStyle(NotificationCompat$Api34Impl.setRemotePlaybackInfo(NotificationCompat$Api21Impl.createMediaStyle(), this.mDeviceName, this.mDeviceIcon, this.mDeviceIntent, Boolean.valueOf(this.mShowRemotePlaybackInfo)), this.mActionsToShowInCompact, this.mToken));
                    } else {
                        NotificationCompat$Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), NotificationCompat$Api21Impl.fillInMediaStyle(NotificationCompat$Api21Impl.createMediaStyle(), this.mActionsToShowInCompact, this.mToken));
                    }
                }

                @Override // androidx.core.app.NotificationCompat.Style
                public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
                    return null;
                }

                @Override // androidx.core.app.NotificationCompat.Style
                public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
                    return null;
                }

                public NotificationCompat$MediaStyle setMediaSession(MediaSessionCompat.Token token) {
                    this.mToken = token;
                    return this;
                }

                public NotificationCompat$MediaStyle setShowActionsInCompactView(int... iArr) {
                    this.mActionsToShowInCompact = iArr;
                    return this;
                }
            }.setMediaSession(this.mediaSession.getSessionToken()).setShowActionsInCompactView(0));
        }
        startForegroundOnce(contentText.build(), true);
    }

    public static final void stop(Context context) {
        zza$$ExternalSyntheticOutline0.m(context, "com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK");
    }

    private void stopPlayer() {
        LullabyPlayer lullabyPlayer = this.player;
        if (lullabyPlayer != null) {
            lullabyPlayer.stop();
            this.player = null;
        }
        ISpotifyPlayer iSpotifyPlayer = this.spotifyPlayer;
        if (iSpotifyPlayer != null) {
            iSpotifyPlayer.stop();
            this.spotifyPlayer = null;
        }
        try {
            if (this.mp != null) {
                LocalBroadcastManager.getInstance(this).unregisterReceiver(this.volumeReceiver);
                this.mp.setOnPreparedListener(new LullabyService$$ExternalSyntheticLambda6());
                this.mp.stop();
                this.mp.release();
                this.mp = null;
            }
        } catch (IllegalStateException e) {
            Logger.logSevere(e);
        }
    }

    private void unregisterReceiver() {
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.receiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeadset() {
        if (this.headset) {
            Logger.logInfo("LullabyService: Resume recording");
            sendResumeRecording();
        } else {
            Logger.logInfo("LullabyService: Pause recording");
            sendPauseRecording();
        }
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.common.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
        GlobalInitializator.initializeIfRequired(this);
        this.audioManager = (AudioManager) getApplicationContext().getSystemService("audio");
        this.audioFocusChangeListener = new LullabyAudioFocusChangeListener(this, 0 == true ? 1 : 0);
        this.handler = new Handler();
        if (VolumeUtil.getHeadsetState(this) == 1) {
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("LullabyService: Headset "), this.headset);
            this.headset = true;
        }
        Settings settings = new Settings(this);
        this.isMeditation = settings.isMeditationLullaby();
        if (settings.isMeditationOneTime() != -1) {
            this.isMeditation = settings.isMeditationOneTime() == 1;
            settings.setMeditationOneTime(-1);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_AUTO_STOP_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_PAUSE_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_RESUME_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_RECORDING_RESUMED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null && LullabyService.this.playing) {
                    if ("com.urbandroid.sleep.ACTION_LULLABY_AUTO_STOP_PLAYBACK".equals(intent.getAction())) {
                        Logger.logInfo("LullabyService: AUTO Stopping lullaby service");
                        LullabyService.this.autoStop();
                        return;
                    }
                    if ("com.urbandroid.sleep.ACTION_LULLABY_PAUSE_PLAYBACK".equals(intent.getAction())) {
                        Logger.logInfo("LullabyService: pause");
                        LullabyService.this.paused = true;
                        if (LullabyService.this.mp != null) {
                            try {
                                if (LullabyService.this.mp.isPlaying()) {
                                    LullabyService.this.mp.pause();
                                }
                            } catch (IllegalStateException e) {
                                Logger.logSevere(e);
                            }
                        }
                        if (LullabyService.this.player != null) {
                            LullabyService.this.player.mute();
                        }
                        if (LullabyService.this.spotifyPlayer != null) {
                            LullabyService.this.spotifyPlayer.stop();
                        }
                        if (LullabyService.this.isMeditation) {
                            Intent intent2 = new Intent();
                            intent2.setComponent(new ComponentName("com.urbandroid.lis10", "com.urbandroid.lis10.service.SessionService"));
                            intent2.setAction("com.urbandroid.lis10.PAUSE");
                            ContextCompat.startForegroundService(LullabyService.this, intent2);
                        }
                        LullabyService.this.setMediaSessionState(false);
                        return;
                    }
                    if (!"com.urbandroid.sleep.ACTION_LULLABY_RESUME_PLAYBACK".equals(intent.getAction())) {
                        if ("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK".equals(intent.getAction())) {
                            Logger.logInfo("LullabyService: Stopping lullaby service");
                            LullabyService.this.lambda$autoStop$1();
                            return;
                        } else {
                            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                                boolean z = VolumeUtil.getHeadsetState(context) == 1;
                                if (LullabyService.this.headset != z) {
                                    Logger.logInfo("LullabyService: Headset update " + LullabyService.this.headset);
                                    LullabyService.this.headset = z;
                                    LullabyService.this.updateHeadset();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    Logger.logInfo("LullabyService: resume");
                    LullabyService.this.paused = false;
                    if (LullabyService.this.mp != null) {
                        try {
                            if (!LullabyService.this.mp.isPlaying()) {
                                LullabyService.this.mp.start();
                            }
                        } catch (IllegalStateException e2) {
                            Logger.logSevere(e2);
                        }
                    }
                    if (LullabyService.this.player != null) {
                        LullabyService.this.player.unmute();
                    }
                    if (LullabyService.this.spotifyPlayer != null) {
                        LullabyService.this.spotifyPlayer.play(null);
                    }
                    if (LullabyService.this.isMeditation) {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName("com.urbandroid.lis10", "com.urbandroid.lis10.service.SessionService"));
                        intent3.setAction("com.urbandroid.lis10.RESUME");
                        ContextCompat.startForegroundService(LullabyService.this, intent3);
                    }
                    LullabyService.this.setMediaSessionState(true);
                }
            }
        };
        this.receiver = broadcastReceiver;
        ContextCompat.registerReceiver(this, broadcastReceiver, intentFilter, 2);
    }

    @Override // com.urbandroid.common.ForegroundService, com.urbandroid.common.LoggingService, android.app.Service
    public void onDestroy() {
        unregisterReceiver();
        stopPlayer();
        sendResumeRecording();
        try {
            MediaSessionCompat mediaSessionCompat = this.mediaSession;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.release();
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        try {
            AudioManager audioManager = this.audioManager;
            if (audioManager != null) {
                AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
                if (audioFocusRequest == null || Build.VERSION.SDK_INT < 26) {
                    audioManager.abandonAudioFocus(new LullabyService$$ExternalSyntheticLambda0(1));
                } else {
                    audioManager.requestAudioFocus(audioFocusRequest);
                }
            }
        } catch (Exception e2) {
            Logger.logSevere(e2);
        }
        super.onDestroy();
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        int i3;
        LullabyPlayer.Lullaby lullabyValueOf;
        String str2;
        Logger.logInfo("LullabyService: Lullaby " + intent);
        if (intent == null || !intent.hasExtra("extra_lullaby") || intent.getStringExtra("extra_lullaby") == null) {
            lambda$autoStop$1();
            return 2;
        }
        Logger.logInfo("LullabyService: Lullaby " + intent.getStringExtra("extra_lullaby"));
        LullabyAudioFocusChangeListener lullabyAudioFocusChangeListener = this.audioFocusChangeListener;
        if (lullabyAudioFocusChangeListener != null) {
            this.audioManager.abandonAudioFocus(lullabyAudioFocusChangeListener);
        }
        String stringExtra = intent.getStringExtra("extra_lullaby");
        String stringExtra2 = intent.getStringExtra("extra_lullaby_name");
        this.offset = intent.getIntExtra("extra_lullaby_offset", -1);
        Logger.logInfo("Lullaby: Playlist offset at start " + this.offset);
        this.startAfter = (long) SharedApplicationContext.getSettings().getLullabyVolumeDownAfter();
        boolean zIsUltrasonicTracking = SharedApplicationContext.getSettings().isUltrasonicTracking();
        getStopPendingIntent().cancelAlarmBroadcast();
        if (this.startAfter > 0) {
            long jRound = Math.round(((long) (zIsUltrasonicTracking ? 2 : 3)) * r7);
            int lullabyAutoPlaylist = (SharedApplicationContext.getSettings().getLullabyAutoPlaylist() + 20000) * this.offset;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = (jCurrentTimeMillis + jRound) - ((long) lullabyAutoPlaylist);
            StringBuilder sb = new StringBuilder("LullabyVolumeDown: timeToStop  ");
            str = stringExtra;
            i3 = 2;
            sb.append(j - jCurrentTimeMillis);
            Logger.logInfo(sb.toString());
            if (j < jCurrentTimeMillis) {
                autoStop();
                return 2;
            }
            this.handler.removeCallbacks(this.autoStopRunnable);
            this.handler.postDelayed(this.autoStopRunnable, jRound);
            ((AlarmManager) getApplicationContext().getSystemService("alarm")).setAndAllowWhileIdle(1, j, getStopPendingIntent().getExplicitBroadcast());
            Logger.logInfo("LullabyVolumeDown: schedule stop  " + new Date(j));
        } else {
            str = stringExtra;
            i3 = 2;
        }
        Logger.logInfo("Lullaby: radio name " + stringExtra2);
        final String stringExtra3 = intent.getStringExtra("extra_online_radio_url");
        Settings settings = new Settings(this);
        String strName = str;
        if ("play_last".equals(strName)) {
            lullabyValueOf = settings.getLullabyByUsed()[1];
            strName = lullabyValueOf.name();
        } else {
            lullabyValueOf = null;
        }
        if ("online_radio".equals(strName) || "spotify".equals(strName)) {
            String stringExtra4 = intent.getStringExtra("extra_lullaby_name");
            LULLABY_NAME = stringExtra4;
            if (stringExtra4 == null) {
                LULLABY_NAME = "online_radio".equals(strName) ? getString(R.string.online_radio) : getString(R.string.spotify);
            }
        } else {
            lullabyValueOf = LullabyPlayer.Lullaby.valueOf(strName);
            LULLABY_NAME = lullabyValueOf.getDisplayName(this);
        }
        if (stringExtra3 == null && (lullabyValueOf == null || lullabyValueOf == LullabyPlayer.Lullaby.NONE || (TrialFilter.getInstance().isTrial() && !lullabyValueOf.isTrial() && !TrialFilter.getInstance().isAddonLullaby()))) {
            lambda$autoStop$1();
            return i3;
        }
        int i4 = 0;
        boolean z = this.spotifyPlayer != null;
        stopPlayer();
        if (!ISpotifyPlayer.INSTANCE.isSpotifyUri(stringExtra3) && !z) {
            int iRequestAudioFocus = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1);
            Logger.logDebug("LullabyService: Lullaby audio focus permission: " + iRequestAudioFocus);
            if (iRequestAudioFocus != 1) {
                lambda$autoStop$1();
                return i3;
            }
        }
        this.playing = true;
        String string = stringExtra2 != null ? stringExtra2 : getString(R.string.online_radio);
        if (lullabyValueOf != null) {
            try {
                string = lullabyValueOf.getDisplayName(this);
                str2 = string;
            } catch (Exception unused) {
                str2 = stringExtra2;
            }
        } else {
            str2 = string;
        }
        if (!ISpotifyPlayer.INSTANCE.isSpotifyUri(stringExtra3)) {
            try {
                if (this.audioManager != null) {
                    AudioManager audioManager = (AudioManager) getSystemService("audio");
                    this.audioManager = audioManager;
                    LullabyService$$ExternalSyntheticLambda0 lullabyService$$ExternalSyntheticLambda0 = new LullabyService$$ExternalSyntheticLambda0(i4);
                    if (Build.VERSION.SDK_INT >= 26) {
                        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(i3).build()).setOnAudioFocusChangeListener(lullabyService$$ExternalSyntheticLambda0).build();
                        this.audioFocusRequest = audioFocusRequestBuild;
                        this.audioManager.requestAudioFocus(audioFocusRequestBuild);
                    } else {
                        audioManager.requestAudioFocus(lullabyService$$ExternalSyntheticLambda0, 3, 1);
                    }
                }
                if (this.mediaSession == null) {
                    this.mediaSession = new MediaSessionCompat(this, "sleep");
                    Intent intent2 = new Intent(this, (Class<?>) LullabyActivity.class);
                    intent2.setFlags(603979776);
                    this.mediaSession.setSessionActivity(PendingIntentBuilder.get(this, 0, intent2, 134217728).getActivity());
                }
                this.mediaSession.setCallback(new MediaSessionCompat.Callback() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.3
                    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                    public void onCommand(String str3, Bundle bundle, ResultReceiver resultReceiver) {
                        zza$$ExternalSyntheticOutline0.m("Media Session: ", str3);
                        super.onCommand(str3, bundle, resultReceiver);
                    }

                    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                    public void onCustomAction(String str3, Bundle bundle) {
                        super.onCustomAction(str3, bundle);
                        if ("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK".equals(str3)) {
                            LullabyService.this.lambda$autoStop$1();
                            return;
                        }
                        if ("rate".equals(str3)) {
                            if (LullabyService.this.isMeditation) {
                                ViewIntent.market(LullabyService.this, "com.urbandroid.lis10");
                                return;
                            }
                            boolean zIsAddonLullaby = TrialFilter.getInstance().isAddonLullaby();
                            LullabyService lullabyService = LullabyService.this;
                            if (zIsAddonLullaby) {
                                ViewIntent.market(lullabyService, "com.urbandroid.sleep.addon.lullaby");
                            } else {
                                ViewIntent.market(lullabyService, "com.urbandroid.sleep");
                            }
                        }
                    }

                    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                    public boolean onMediaButtonEvent(Intent intent3) {
                        Logger.logInfo("Media Session button: " + intent3.getAction());
                        return super.onMediaButtonEvent(intent3);
                    }

                    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                    public void onPause() {
                        super.onPause();
                        Logger.logInfo("Media Session PAUSE");
                        LullabyService.pause(LullabyService.this);
                    }

                    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                    public void onPlay() {
                        super.onPlay();
                        LullabyService.resume(LullabyService.this);
                    }

                    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                    public void onStop() {
                        super.onStop();
                        Logger.logInfo("Media Session STOP");
                        LullabyService.this.lambda$autoStop$1();
                    }
                });
                setMediaSessionState(true);
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.lullaby_bg);
                try {
                    Drawable icon = lullabyValueOf != null ? lullabyValueOf.getIcon(this) : getDrawable(R.drawable.ic_lullaby_radio);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeResource.getWidth(), bitmapDecodeResource.getWidth(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    icon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    icon.draw(canvas);
                    bitmapDecodeResource = overlay(bitmapDecodeResource, bitmapCreateBitmap);
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                MediaSessionCompat mediaSessionCompat = this.mediaSession;
                MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
                if (lullabyValueOf != null) {
                    stringExtra2 = lullabyValueOf.getDisplayName(this);
                } else if (stringExtra3 == null) {
                    stringExtra2 = getString(R.string.lullaby);
                } else if (stringExtra2 == null) {
                    stringExtra2 = getString(R.string.online_radio);
                }
                mediaSessionCompat.setMetadata(builder.putString("android.media.metadata.TITLE", stringExtra2).putString("android.media.metadata.ALBUM", getResources().getString(R.string.app_name_long)).putBitmap("android.media.metadata.ALBUM_ART", bitmapDecodeResource).build());
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
        startForeground(lullabyValueOf, str2);
        if (!this.headset) {
            sendPauseRecording();
        }
        try {
            if (this.audioManager.getStreamVolume(3) == 0) {
                VolumeUtil.setStreamVolume(getApplicationContext(), 3, 1);
            }
        } catch (Exception e3) {
            Logger.logSevere(e3);
        }
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Lullaby_started");
        if (stringExtra3 == null) {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Lullaby_started_nature");
            LullabyPlayer lullabyPlayer = new LullabyPlayer(getApplicationContext(), lullabyValueOf);
            this.player = lullabyPlayer;
            lullabyPlayer.setListener(new LullabyPlayer.OnPlaybackStartListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.4
                @Override // com.urbandroid.sleep.media.lullaby.LullabyPlayer.OnPlaybackStartListener
                public void onPlaybackStart() {
                    Intent intent3 = new Intent("com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK");
                    intent3.putExtra("extra_lullaby_offset", LullabyService.this.offset);
                    ContextExtKt.sendExplicitBroadcast(LullabyService.this.getApplicationContext(), intent3);
                }
            });
            this.player.play();
            Logger.logInfo("Lullaby: Playlist " + settings.isLullabyAutoPlaylist());
            if (settings.isLullabyAutoPlaylist()) {
                int lullabyAutoPlaylist2 = settings.getLullabyAutoPlaylist();
                zza$$ExternalSyntheticOutline0.m(lullabyAutoPlaylist2, "Lullaby: Playlist schedule callbacks ");
                this.handler.removeCallbacks(this.playNextGentleRunnable);
                this.handler.removeCallbacks(this.playNextStopRunnable);
                this.handler.removeCallbacks(this.playNextRunnable);
                this.handler.postDelayed(this.playNextGentleRunnable, lullabyAutoPlaylist2);
            }
        } else if (!WifiEnabler.getInstance().isAnyNetworkConnected() || (WifiEnabler.getInstance().isAnyNetworkConnected() && WifiEnabler.getInstance().isWifiConnected())) {
            this.wifiContext.set(WifiEnabler.getInstance().enable(getClass(), new WifiEnabler.OnConnectListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyService.5
                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void connected(WifiContext wifiContext) {
                    LullabyService.this.playOnlineSource(stringExtra3);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void failed() {
                    LullabyService.this.playOnlineSource(stringExtra3);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void timeouted() {
                    LullabyService.this.playOnlineSource(stringExtra3);
                }
            }));
        } else {
            playOnlineSource(stringExtra3);
        }
        if (this.isMeditation) {
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.urbandroid.lis10", "com.urbandroid.lis10.service.SessionService"));
            intent3.setAction("com.urbandroid.lis10.START");
            if (settings.getMeditationSessionId().longValue() == -1) {
                Logger.logInfo("Meditation: starting session DEAFULT");
                intent3.putExtra("session", "{\n  \"groups\": [\n    {\n      \"order\": 0,\n      \"name\": \"Default\",\n      \"active\": true\n    }\n  ],\n  \"id\": 1,\n  \"lang\": \"en\",\n  \"name\": \"Meditation Fall Asleep\",\n  \"reads\": [\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 2,\n      \"text\": \"Lay down in your bed\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 2,\n      \"text\": \"Get yourself comfortable\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 20,\n      \"text\": \"Whatever you need to do, do it now, so that you do not need to move much over the course of the session\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"Eyes are open, looking forward, not staring at a particular spot, just being aware of the space around\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 1,\n      \"text\": \"Take a couple of deep breaths\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 6,\n      \"text\": \"Breathing in through the nose and out through the mouth\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"As you breath in focus on chest expanding, your body filling with air\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"As you breath out your body softens and feels heavier and more relaxed\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 30,\n      \"text\": \"Repeat the deep breaths four to five times\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 5,\n      \"text\": \"Next time you breath out, close your eyes and feel how you sink down into your mattress\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 1,\n      \"text\": \"With eyes closed, focus your attention on the contact of your body with the bed\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"Do not think about it, just be aware of it\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 10,\n      \"text\": \"Feel the weight of your hands and arms resting\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 10,\n      \"text\": \"Feel the pressure of the entire body toward the mattress\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"Take a moment to notice any sounds\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"Just get aware of the sound, do not judge them, do not think about them\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"Just keep the sounds passing in and out through your awareness\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"Now bring the attention to the body\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 4,\n      \"text\": \"Bring your attention to how you are feeling today physically in general\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 6,\n      \"text\": \"Are you feeling light or heavy? Calm or excited?\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 1,\n      \"text\": \"Now take the next few moment to scan through your body.\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 2,\n      \"text\": \"Start at the top of your head, and continue top down to your toes\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 30,\n      \"text\": \"As you go through your body, do not get stuck at any particular point of discomfort, just get aware such places and continue down the body\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 30,\n      \"text\": \"Try to build a picture of how the body feels today\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 2,\n      \"text\": \"Slowly start to realize the emotional state of your mind. Any moods or feelings.\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 10,\n      \"text\": \"Do not judge or resist, just notice how you feel emotionally\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 3,\n      \"text\": \"Just a reminder, meditation is about stepping back. Whenever you mind travels. Don't try to stop it or force it.\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 3,\n      \"text\": \"Instead gently let it go and slowly focus back on your breath.\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 10,\n      \"text\": \"Let's become aware of your breath. The rising and falling sensation\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 60,\n      \"text\": \"Notice the rhythm of your breath\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 3,\n      \"text\": \"Slowly, you may start counting the breaths\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 3,\n      \"text\": \"One for in breath, one for out breath\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 10,\n      \"text\": \"When you count to 10 you may start over\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 60,\n      \"text\": \"You may notice how each breath is slightly different from the other\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 3,\n      \"text\": \"Try not to manipulate your breath in any way\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 3,\n      \"text\": \"Just breathe naturally\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 10,\n      \"text\": \"The body knows how to breath\"\n    },\n    {\n      \"group\": 0,\n      \"pauseSeconds\": 1200,\n      \"text\": \"Just be present with the rising and falling sensation\"\n    }\n  ]\n}");
            } else {
                Logger.logInfo("Meditation: starting session " + settings.getMeditationSessionId());
                intent3.putExtra(SDKAnalyticsEvents.PARAMETER_SESSION_ID, settings.getMeditationSessionId());
            }
            intent3.putExtra("env", "your");
            intent3.putExtra("pro", true);
            ContextCompat.startForegroundService(this, intent3);
        }
        setRunning(true);
        return 2;
    }

    public class LullabyAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
        private int volume;
        private boolean wasDucked;

        private LullabyAudioFocusChangeListener() {
            this.volume = 0;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            GlobalInitializator.initializeIfRequired(LullabyService.this.getApplicationContext());
            Logger.logInfo("LullabyService: Lullaby AudioFocus changed to: " + i);
            if (LullabyService.this.playing) {
                if (i == -3) {
                    if (this.wasDucked) {
                        return;
                    }
                    if (LullabyService.this.player == null && LullabyService.this.mp == null) {
                        return;
                    }
                    this.volume = LullabyService.this.audioManager.getStreamVolume(3);
                    VolumeUtil.setStreamVolume(LullabyService.this.getApplicationContext(), 3, 1);
                    this.wasDucked = true;
                    return;
                }
                if (i == -2) {
                    if (LullabyService.this.player != null) {
                        LullabyService.this.player.mute();
                        this.wasDucked = false;
                    }
                    if (LullabyService.this.mp != null) {
                        try {
                            LullabyService.this.mp.pause();
                            return;
                        } catch (IllegalStateException e) {
                            Logger.logWarning("Can't pause media player", e);
                            return;
                        }
                    }
                    return;
                }
                if (i != 1) {
                    return;
                }
                boolean z = this.wasDucked;
                LullabyService lullabyService = LullabyService.this;
                if (z) {
                    VolumeUtil.setStreamVolume(lullabyService.getApplicationContext(), 3, this.volume);
                    this.wasDucked = false;
                    return;
                }
                if (lullabyService.player != null) {
                    LullabyService.this.player.unmute();
                }
                if (LullabyService.this.mp != null) {
                    LullabyService.this.mp.start();
                }
            }
        }

        public /* synthetic */ LullabyAudioFocusChangeListener(LullabyService lullabyService, int i) {
            this();
        }
    }
}
