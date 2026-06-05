package com.urbandroid.sleep.alarmclock.lockedboot;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.VolumeUtil;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class BackupAlarmService extends Service {
    private Handler h;
    private MediaPlayer mp;
    private BroadcastReceiver stopReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.lockedboot.BackupAlarmService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i("SleepAsAndroidDB", "STOP");
            BackupAlarmService.this.stopSelf();
            if (BackupAlarmService.this.nextAlarm != -1) {
                Log.i("SleepAsAndroidDB", "BackupAlarm: has next alarm " + BackupAlarmService.this.nextAlarm);
                Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context, BackupAlarmService.this.nextAlarm - 1);
                if (alarmCalculateNextAlert != null) {
                    Log.i("SleepAsAndroidDB", "BackupAlarm: marking alarm as current " + alarmCalculateNextAlert);
                    new Settings(context).setCurrentAlarm(alarmCalculateNextAlert.id, alarmCalculateNextAlert.time);
                }
            }
        }
    };
    private int volume = 0;
    private Runnable progressRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.lockedboot.BackupAlarmService.2
        @Override // java.lang.Runnable
        public void run() {
            Vibrator vibrator = (Vibrator) BackupAlarmService.this.getApplicationContext().getSystemService("vibrator");
            Log.i("SleepAsAndroidDB", "BackupAlarm: vibrate ");
            vibrator.vibrate(500L);
            BackupAlarmService backupAlarmService = BackupAlarmService.this;
            backupAlarmService.volume = Math.min(backupAlarmService.volume + 3, 100);
            float logVolume = VolumeUtil.getLogVolume(BackupAlarmService.this.volume);
            Log.i("SleepAsAndroidDB", "BackupAlarm: vol " + logVolume);
            BackupAlarmService.this.mp.setVolume(logVolume, logVolume);
            if (BackupAlarmService.this.h != null) {
                BackupAlarmService.this.h.postDelayed(BackupAlarmService.this.progressRunnable, 2000L);
            }
        }
    };
    private long nextAlarm = -1;

    public NotificationCompat.Builder getNotificationBuilder() {
        Intent intent = new Intent(this, (Class<?>) BackupAlarmActivity.class);
        intent.addFlags(131072);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        PendingIntent activity = PendingIntentBuilder.get(this, 666, intent, 134217728).getActivity();
        return new NotificationCompat.Builder(this, "alarmChannel").setContentIntent(activity).setColor(getResources().getColor(R.color.tint_notification)).setContentTitle(getString(R.string.default_label)).setFullScreenIntent(activity, true).setSmallIcon(R.drawable.ic_alarm_white).setVisibility(1).setCategory("alarm").setPriority(2).setLocalOnly(true).setContentText(getString(R.string.unlock_screen));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i("SleepAsAndroidDB", "DB: BackupAlarmService: onCreate()");
        startForeground(666, getNotificationBuilder().build());
        IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_PRESENT");
        intentFilter.addAction("stop");
        ContextCompat.registerReceiver(this, this.stopReceiver, intentFilter, 2);
        try {
            AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService("audio");
            audioManager.setStreamVolume(4, Math.max(1, audioManager.getStreamMaxVolume(4) - 1), 0);
        } catch (SecurityException e) {
            Log.e("SleepAsAndroidDB", "Cannot force volume", e);
        }
        VolumeUtil.cancelDndAll(this);
        play(getApplicationContext(), R.raw.classic);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.stopReceiver);
        stop();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        startForeground(666, getNotificationBuilder().build());
        if (intent == null) {
            return 1;
        }
        this.nextAlarm = intent.getLongExtra("next_alarm", -1L);
        Log.i("SleepAsAndroidDB", "BackupAlarm: next alarm to start " + this.nextAlarm);
        return 1;
    }

    public void play(Context context, int i) {
        stop();
        Handler handler = new Handler();
        this.h = handler;
        handler.postDelayed(this.progressRunnable, 2000L);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mp = mediaPlayer;
        mediaPlayer.setAudioStreamType(4);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = getResources().openRawResourceFd(i);
            this.mp.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
            assetFileDescriptorOpenRawResourceFd.close();
        } catch (IOException unused) {
            Log.e("SleepAsAndroidDB", "DB: BackupAlarmService: cannot set data source");
        }
        this.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.urbandroid.sleep.alarmclock.lockedboot.BackupAlarmService.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                BackupAlarmService.this.volume = 0;
                mediaPlayer2.setVolume(0.0f, 0.0f);
                mediaPlayer2.setLooping(true);
                mediaPlayer2.start();
            }
        });
        this.mp.prepareAsync();
    }

    public void stop() {
        try {
            try {
                MediaPlayer mediaPlayer = this.mp;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    this.mp.release();
                    this.mp = null;
                }
            } catch (IllegalStateException unused) {
                this.mp.release();
                this.mp = null;
            }
        } catch (Exception unused2) {
        }
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.progressRunnable);
            this.h = null;
        }
    }
}
