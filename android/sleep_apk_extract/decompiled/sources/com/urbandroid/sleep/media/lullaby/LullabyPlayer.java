package com.urbandroid.sleep.media.lullaby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import androidx.appfunctions.AppFunctionException;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.RandUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ResourceUtil;
import com.urbandroid.util.VolumeUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class LullabyPlayer {
    private AssetFileDescriptor backgroundSampleDescriptor;
    private IBinauralGenerator binauralGenerator;
    private Context context;
    private GaplessMediaPlayer gaplessMediaPlayer;
    private SampleOnLoadListener listener;
    private Lullaby lullaby;
    private PlayRunnable player;
    private SoundPool pool;
    private OnPlaybackStartListener startListener;
    private String[] remoteAssets = {"sp_bells_1_loop_priority", "sp_cat_1_loop_priority", "sp_cat_4_r2_l1_novol", "sp_frogs_1_loop_priority", "sp_frogs_3_r4_l3", "sp_night_1_loop_priority", "sp_night_2_r2_l3_midpitch", "sp_bells_2_r2_l2", "sp_chimes_1_loop_priority", "sp_march_1_loop_priority", "sp_night_3_r2_l3", "sp_bells_3_r3_l2", "sp_chimes_2_r4", "sp_march_2_r2_l2", "sp_om_1_loop_priority", "sp_bells_4_r4_l2", "sp_chimes_3_r4", "sp_march_3_r1", "sp_piano_1_loop_priority", "sp_flute_1_loop_priority", "sp_musicbox_1_loop_priority", "sp_train_1_loop_priority", "sp_cat_2_r3_l1_novol", "sp_musicbox_2_r2_l4_midpitch", "sp_train_2_r3_l1", "sp_cat_3_r3_l1_novol", "sp_frogs_2_r4_l2", "sp_train_3_r2_l4", "sp_baby_1_loop_priority", "sp_baby_2_loop", "sp_baby_3_r2_l1", "sp_baby_4_r2_l1", "sp_girl_1_loop_priority", "sp_horse_1_loop_priority", "sp_horse_2_r3_novol", "sp_horse_3_r3_novol", "sp_horse_4_r3_novol", "sp_sheep_1_loop_priority", "sp_sheep_2_r3", "sp_sheep_3_r3_l1", "sp_sheep_4_r3", "sp_sheep_5_r2", "sp_nord_1_loop_priority", "sp_nord_3_r2_l1", "sp_nord_2_r2_l2", "sp_nord_4_r3_l3", "sp_lava_1_loop_priority", "sp_lava_2_r3_midpitch", "sp_lava_3_r3_midpitch", "sp_lava_4_r3_midpitch", "sp_lava_5_r3_midpitch", "sp_native_1_loop_priority", "sp_native_2_r4_l3", "sp_native_3_r2_l2", "sp_native_4_r3_l4", "sp_native_5_r2_l2", "sp_native_6_r3_l2", "sp_sub_1_loop_priority", "sp_sub_2_r3_l2", "sp_sub_3_r3_l2", "sp_sub_4_r3_l4", "sp_sub_5_r2_l4", "sp_sub_6_r2_l2", "sp_sub_7_r2", "sp_brown_1_loop_priority"};
    private boolean paused = false;
    private String url = null;
    private Set<Sample> samples = Collections.synchronizedSet(new HashSet());
    private boolean gentleStop = false;
    private float targetVol = 0.0f;
    private int maxRandomVolume = 0;
    private Handler h = new Handler();

    public static abstract class OnPlaybackStartListener {
        public abstract void onPlaybackStart();
    }

    public class Sample {
        int id;
        int streamId;
        int priority = 1;
        int rand = 10;
        int lowpitch = 90;
        int highpitch = 120;
        boolean novolume = false;
        boolean maxvolume = false;
        int loop = 0;
        boolean large = false;

        public Sample() {
        }

        public boolean isLarge() {
            return this.large;
        }

        public boolean isLooping() {
            return this.loop == -1;
        }
    }

    public LullabyPlayer(Context context, Lullaby lullaby) {
        this.context = context;
        this.lullaby = lullaby;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustVolume(int i, int i2) {
        float volAdjust = getVolAdjust(this.context, i, i2);
        this.targetVol *= volAdjust;
        this.maxRandomVolume = Math.round(this.maxRandomVolume * volAdjust);
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "Lullaby: Sonar adjust lullaby volume ", " -> ", " adjust ");
        sbM.append(volAdjust);
        Logger.logInfo(sbM.toString());
        for (Sample sample : this.samples) {
            if (sample.isLooping()) {
                Logger.logInfo("Lullaby: Sonar setting volume=" + this.targetVol + " diff " + (i2 - i));
                SoundPool soundPool = this.pool;
                int i3 = sample.streamId;
                float f = this.targetVol;
                soundPool.setVolume(i3, f, f);
            }
        }
    }

    public static float getVolAdjust(Context context, int i, int i2) {
        float streamMaxVolume = ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(3);
        float logVolume = VolumeUtil.getLogVolume(Math.round((i2 / streamMaxVolume) * 100.0f));
        return (logVolume - (logVolume - VolumeUtil.getLogVolume(Math.round((i / streamMaxVolume) * 100.0f)))) / logVolume;
    }

    public synchronized void gentleStop() {
        this.gentleStop = true;
    }

    public synchronized boolean isGentleStop() {
        return this.gentleStop;
    }

    public void mute() {
        Logger.logInfo("LullabyPlayer: MUTE");
        this.paused = true;
        SoundPool soundPool = this.pool;
        if (soundPool != null) {
            try {
                soundPool.autoPause();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        GaplessMediaPlayer gaplessMediaPlayer = this.gaplessMediaPlayer;
        if (gaplessMediaPlayer != null) {
            try {
                gaplessMediaPlayer.pause();
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
        if (this.binauralGenerator == null || SharedApplicationContext.getSettings().getBinaural() <= 0) {
            return;
        }
        this.binauralGenerator.mute();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0177 A[LOOP:1: B:40:0x0171->B:42:0x0177, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void play() {
        Resources resources;
        Iterator it;
        final boolean z;
        final String str;
        this.pool = new SoundPool(6, 3, 0);
        ArrayList<String> arrayList = new ArrayList();
        Logger.logInfo("LullabyPlayer: Listener " + arrayList.size());
        SampleOnLoadListener sampleOnLoadListener = new SampleOnLoadListener(this, 0);
        this.listener = sampleOnLoadListener;
        this.pool.setOnLoadCompleteListener(sampleOnLoadListener);
        Resources resources2 = null;
        resources2 = null;
        Cursor cursorQuery = null;
        if (!this.lullaby.isLocalPackage()) {
            try {
                Resources resourcesForApplication = this.context.getPackageManager().getResourcesForApplication(this.lullaby.getPackageName());
                try {
                    Logger.logInfo("Lullaby: package " + this.lullaby.getPackageName());
                    for (String str2 : this.remoteAssets) {
                        if (str2.startsWith("sp_" + this.lullaby.getName() + "_")) {
                            arrayList.add(str2);
                        }
                    }
                    try {
                        cursorQuery = this.context.getContentResolver().query(Uri.parse("content://" + this.lullaby.packageName + "/lullaby"), null, this.lullaby.getName(), null, null);
                        if (cursorQuery != null) {
                            while (cursorQuery.moveToNext()) {
                                String string = cursorQuery.getString(0);
                                Logger.logInfo("LullabyPlayer: Retrieved from content provider " + string);
                                if (string.startsWith("sp_" + this.lullaby.getName() + "_")) {
                                    Logger.logInfo("LullabyPlayer: Adding " + string);
                                    arrayList.add(string);
                                }
                            }
                        }
                        resources = resourcesForApplication;
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    resources2 = resourcesForApplication;
                    Logger.logSevere(e);
                    resources = resources2;
                }
            } catch (Exception e2) {
                e = e2;
            }
            Collections.sort(arrayList);
            it = arrayList.iterator();
            while (it.hasNext()) {
                zza$$ExternalSyntheticOutline0.m("LullabyPlayer: Sample ", (String) it.next());
            }
            for (String str3 : arrayList) {
                final boolean zContains = str3.contains("loop");
                boolean zContains2 = str3.contains("large");
                final int i = str3.contains("priority") ? 2 : 1;
                final Sample sample = new Sample();
                if (this.lullaby.isLocalPackage()) {
                    final int resourceByName = ResourceUtil.getResourceByName(this.context, "raw", str3);
                    if (zContains) {
                        Logger.logInfo("LullabyPlayer: Looping ".concat(str3));
                        if (zContains2) {
                            this.backgroundSampleDescriptor = this.context.getResources().openRawResourceFd(resourceByName);
                        }
                    }
                    new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.media.lullaby.LullabyPlayer.1
                        @Override // android.os.AsyncTask
                        public Void doInBackground(Void... voidArr) {
                            sample.id = LullabyPlayer.this.pool.load(LullabyPlayer.this.context, resourceByName, i);
                            if (!zContains) {
                                return null;
                            }
                            zza$$ExternalSyntheticOutline0.m(new StringBuilder("LullabyPlayer: Waiting for sample "), sample.id);
                            LullabyPlayer.this.listener.getWaitForIds().add(Integer.valueOf(sample.id));
                            return null;
                        }
                    }.execute(new Void[0]);
                    z = zContains;
                    str = str3;
                } else {
                    try {
                        Logger.logDebug("LullabyPlayer: Opening " + str3);
                        if (resources != null && resources.getAssets() != null) {
                            Logger.logDebug("LullabyPlayer: remote " + this.remoteAssets);
                            final AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(resources.getIdentifier(str3, "raw", this.lullaby.getPackageName()));
                            if (zContains) {
                                this.backgroundSampleDescriptor = assetFileDescriptorOpenRawResourceFd;
                            }
                            z = zContains;
                            str = str3;
                            new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.media.lullaby.LullabyPlayer.2
                                @Override // android.os.AsyncTask
                                public Void doInBackground(Void... voidArr) {
                                    sample.id = LullabyPlayer.this.pool.load(assetFileDescriptorOpenRawResourceFd, i);
                                    Logger.logInfo("LullabyPlayer: pool load " + sample.id + " file " + str);
                                    if (!z) {
                                        return null;
                                    }
                                    zza$$ExternalSyntheticOutline0.m(new StringBuilder("LullabyPlayer: Waiting for sample "), sample.id);
                                    LullabyPlayer.this.listener.getWaitForIds().add(Integer.valueOf(sample.id));
                                    return null;
                                }
                            }.execute(new Void[0]);
                        }
                    } catch (Exception e3) {
                        Logger.logSevere(e3);
                    }
                }
                if (z) {
                    sample.loop = -1;
                } else if (SharedApplicationContext.getSettings().getLullabyRandomVolume() <= 1) {
                }
                if (zContains2) {
                    sample.large = true;
                }
                if (str.contains("l1")) {
                    sample.loop = 1;
                }
                if (str.contains("l2")) {
                    sample.loop = 2;
                }
                if (str.contains("l3")) {
                    sample.loop = 3;
                }
                if (str.contains("l4")) {
                    sample.loop = 4;
                }
                if (str.contains("r1")) {
                    sample.rand = 15;
                }
                if (str.contains("r2")) {
                    sample.rand = 25;
                }
                if (str.contains("r3")) {
                    sample.rand = 30;
                }
                if (str.contains("r4")) {
                    sample.rand = 60;
                }
                if (str.contains("pitch")) {
                    sample.lowpitch = 60;
                    sample.highpitch = 180;
                }
                if (str.contains("lowpitch")) {
                    sample.lowpitch = 50;
                    sample.highpitch = 100;
                }
                if (str.contains("highpitch")) {
                    sample.lowpitch = 100;
                    sample.highpitch = 200;
                }
                if (str.contains("midpitch")) {
                    sample.lowpitch = 75;
                    sample.highpitch = 150;
                }
                if (str.contains("nopitch")) {
                    sample.lowpitch = 95;
                    sample.highpitch = 105;
                }
                if (SharedApplicationContext.getSettings().isLullabyNoHighPitch()) {
                    sample.lowpitch = 50;
                    sample.highpitch = 80;
                }
                if (str.contains("novol")) {
                    sample.novolume = true;
                }
                if (str.contains("maxvol")) {
                    sample.maxvolume = true;
                }
                sample.priority = i;
                this.samples.add(sample);
            }
        }
        for (Field field : R.raw.class.getDeclaredFields()) {
            if (field.getName().startsWith("sp_" + this.lullaby.getName() + "_")) {
                arrayList.add(field.getName());
            }
        }
        resources = resources2;
        Collections.sort(arrayList);
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        while (r10.hasNext()) {
        }
    }

    public void setListener(OnPlaybackStartListener onPlaybackStartListener) {
        this.startListener = onPlaybackStartListener;
    }

    public void stop() {
        SampleOnLoadListener sampleOnLoadListener = this.listener;
        if (sampleOnLoadListener != null) {
            sampleOnLoadListener.setCancel(true);
        }
        PlayRunnable playRunnable = this.player;
        if (playRunnable != null) {
            playRunnable.stop();
            this.player = null;
        }
    }

    public void unmute() {
        Logger.logInfo("LullabyPlayer: UNMUTE");
        this.paused = false;
        SoundPool soundPool = this.pool;
        if (soundPool != null) {
            try {
                soundPool.autoResume();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        GaplessMediaPlayer gaplessMediaPlayer = this.gaplessMediaPlayer;
        if (gaplessMediaPlayer != null) {
            try {
                gaplessMediaPlayer.resume();
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
        if (this.binauralGenerator == null || SharedApplicationContext.getSettings().getBinaural() <= 0) {
            return;
        }
        this.binauralGenerator.unmute();
    }

    public enum Lullaby {
        NONE(IntegrityManager.INTEGRITY_TYPE_NONE, true),
        WHALE("whale", true),
        STORM("storm", true),
        STREAM("stream", true),
        WHITENOISE("whitenoise", true),
        CAVE("cave"),
        FIREPLACE("fireplace"),
        SEA("sea"),
        WIND("wind"),
        CLOCK("clock"),
        TIBET("tibet"),
        NIGHT("night", "com.urbandroid.sleep.addon.lullaby"),
        FROGS("frogs", "com.urbandroid.sleep.addon.lullaby"),
        NORD("nord", "com.urbandroid.sleep.addon.lullaby"),
        JUNGLE("jungle", "com.urbandroid.sleep.addon.lullaby"),
        LAVA("lava", "com.urbandroid.sleep.addon.lullaby"),
        HORSE("horse", "com.urbandroid.sleep.addon.lullaby"),
        SHEEP("sheep", "com.urbandroid.sleep.addon.lullaby"),
        CHIMES("chimes", "com.urbandroid.sleep.addon.lullaby"),
        OM("om", "com.urbandroid.sleep.addon.lullaby"),
        BELLS("bells", "com.urbandroid.sleep.addon.lullaby"),
        FLUTE("flute", "com.urbandroid.sleep.addon.lullaby"),
        TRIBAL(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "com.urbandroid.sleep.addon.lullaby"),
        PIANO("piano", "com.urbandroid.sleep.addon.lullaby"),
        CAT("cat", "com.urbandroid.sleep.addon.lullaby"),
        TRAIN("train", "com.urbandroid.sleep.addon.lullaby"),
        NASA("nasa", "com.urbandroid.sleep.addon.lullaby"),
        SUB(AuthenticationTokenClaims.JSON_KEY_SUB, "com.urbandroid.sleep.addon.lullaby"),
        MARCH("march", "com.urbandroid.sleep.addon.lullaby"),
        MUSICBOX("musicbox", "com.urbandroid.sleep.addon.lullaby"),
        BABY("baby", "com.urbandroid.sleep.addon.lullaby"),
        GIRL("girl", "com.urbandroid.sleep.addon.lullaby"),
        CHOR("chor", "com.urbandroid.sleep.addon.lullaby"),
        BREATH("breath", "com.urbandroid.sleep.addon.lullaby"),
        SCIFI("scifi", "com.urbandroid.sleep.addon.lullaby"),
        BROWN("brown", "com.urbandroid.sleep.addon.lullaby"),
        PINK("pink", "com.urbandroid.sleep.addon.lullaby"),
        FORREST("forrest", "com.urbandroid.sleep.addon.lullaby"),
        INUTERO("inutero", "com.urbandroid.sleep.addon.lullaby"),
        HEART("heart", "com.urbandroid.sleep.addon.lullaby"),
        CAR("car", "com.urbandroid.sleep.addon.lullaby"),
        FIREWORKS("fireworks", "com.urbandroid.sleep.addon.lullaby"),
        FAN("fan", "com.urbandroid.sleep.addon.lullaby"),
        HAIRDRYER("hairdryer", "com.urbandroid.sleep.addon.lullaby"),
        SHOWER("shower", "com.urbandroid.sleep.addon.lullaby"),
        SHUSH("shush", "com.urbandroid.sleep.addon.lullaby"),
        VACUUM("vacuum", "com.urbandroid.sleep.addon.lullaby"),
        WASHING("washing", "com.urbandroid.sleep.addon.lullaby"),
        RESTAURANT("restaurant", "com.urbandroid.sleep.addon.lullaby"),
        RAINDROP("raindrop", "com.urbandroid.sleep.addon.lullaby"),
        HUMMING("humming", "com.urbandroid.sleep.addon.lullaby"),
        ASMR_CANDY("asmr_candy", "com.urbandroid.sleep.addon.lullaby"),
        ASMR_READING("asmr_reading", "com.urbandroid.sleep.addon.lullaby"),
        BATH("bath", "com.urbandroid.sleep.addon.lullaby"),
        SCENIC("scenic", "com.urbandroid.sleep.addon.lullaby"),
        BUBBLEWRAP("bubblewrap", "com.urbandroid.sleep.addon.lullaby"),
        STRINGS("strings", "com.urbandroid.sleep.addon.lullaby"),
        MAGIC("magic", "com.urbandroid.sleep.addon.lullaby"),
        FANTASY("fantasy", "com.urbandroid.sleep.addon.lullaby"),
        MEGALITH("megalith", "com.urbandroid.sleep.addon.lullaby"),
        SOLFEGGIO("solfeggio", "com.urbandroid.sleep.addon.lullaby"),
        VIKING("viking", "com.urbandroid.sleep.addon.lullaby"),
        MEDIEVAL("medieval", "com.urbandroid.sleep.addon.lullaby"),
        MEDITATION("meditation", "com.urbandroid.sleep.addon.lullaby"),
        EXPLORATION("exploration", "com.urbandroid.sleep.addon.lullaby"),
        JACUZZI("jacuzzi", "com.urbandroid.sleep.addon.lullaby"),
        SAUNA("sauna", "com.urbandroid.sleep.addon.lullaby"),
        PIANOHUM("pianohum", "com.urbandroid.sleep.addon.lullaby"),
        PLANET("planet", "com.urbandroid.sleep.addon.lullaby"),
        SHAMAN("shaman", "com.urbandroid.sleep.addon.lullaby"),
        DIDGE("didge", "com.urbandroid.sleep.addon.lullaby"),
        SIREN("siren", "com.urbandroid.sleep.addon.lullaby"),
        RAINSTICK("rainstick", "com.urbandroid.sleep.addon.lullaby"),
        BULLROARER("bullroarer", "com.urbandroid.sleep.addon.lullaby"),
        CHANT("chant", "com.urbandroid.sleep.addon.lullaby"),
        DEEP("deep", "com.urbandroid.sleep.addon.lullaby"),
        GREGORIAN("gregorian", "com.urbandroid.sleep.addon.lullaby"),
        BAMBOO("bamboo", "com.urbandroid.sleep.addon.lullaby");

        private String name;
        private String packageName;
        private boolean trial;

        Lullaby(String str) {
            this.trial = false;
            this.packageName = "com.urbandroid.sleep";
            this.name = str;
        }

        public String attribution() {
            if (this == PIANOHUM) {
                return "by Valerie Vivegnis";
            }
            if (this == PIANO) {
                return "by Gustavo Alivera";
            }
            if (this == MEDITATION) {
                return "by Universfield";
            }
            if (this == DIDGE) {
                return "by NomadApe";
            }
            if (this == GREGORIAN) {
                return "by Paterm";
            }
            return null;
        }

        public String getDisplayName(Context context) {
            return context.getString(ResourceUtil.getResourceByName(context, "string", "lullaby_name_" + name()));
        }

        public Drawable getIcon(Context context) {
            try {
                return ContextCompat.getDrawable(context, ResourceUtil.getResourceByName(context, "drawable", "ic_lullaby_" + name().toLowerCase()));
            } catch (Exception unused) {
                return ContextCompat.getDrawable(context, R.drawable.ic_captcha_disabled);
            }
        }

        public String getName() {
            return this.name;
        }

        public String getPackageName() {
            return ("com.urbandroid.sleep.addon.lullaby".equals(this.packageName) && TrialFilter.getInstance().isAddonLullabyFree() && !TrialFilter.getInstance().isAddonLullaby()) ? "com.urbandroid.sleep.lullaby" : this.packageName;
        }

        public boolean isLocalPackage() {
            return this.packageName.equals("com.urbandroid.sleep");
        }

        public boolean isTrial() {
            return this.trial;
        }

        Lullaby(String str, boolean z) {
            this.packageName = "com.urbandroid.sleep";
            this.name = str;
            this.trial = z;
        }

        Lullaby(String str, String str2) {
            this.trial = false;
            this.name = str;
            this.packageName = str2;
        }
    }

    public class PlayRunnable implements Runnable {
        private volatile AtomicBoolean running;
        private BroadcastReceiver volumeReceiver;

        private PlayRunnable() {
            this.running = new AtomicBoolean(true);
            this.volumeReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.media.lullaby.LullabyPlayer.PlayRunnable.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    LullabyPlayer.this.adjustVolume(intent.getIntExtra("volume_current", -1), intent.getIntExtra("volume_target", -1));
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            if (LullabyPlayer.this.backgroundSampleDescriptor != null) {
                Logger.logInfo("LullabyPlayer: Looping sample with gapless fd: " + LullabyPlayer.this.backgroundSampleDescriptor);
                LullabyPlayer lullabyPlayer = LullabyPlayer.this;
                lullabyPlayer.gaplessMediaPlayer = new GaplessMediaPlayer(lullabyPlayer.context, LullabyPlayer.this.backgroundSampleDescriptor);
                LullabyPlayer.this.gaplessMediaPlayer.setVolume(0.0f);
            }
            if (LullabyPlayer.this.gaplessMediaPlayer != null) {
                LullabyPlayer.this.gaplessMediaPlayer.start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$stop$0() {
            LullabyPlayer.this.gaplessMediaPlayer.stop();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x010f  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            int i2;
            float f = 100.0f;
            LullabyPlayer.this.targetVol = Math.max(SharedApplicationContext.getSettings().getLullabyVolume(), 3) / 100.0f;
            LullabyPlayer.this.maxRandomVolume = Math.max(SharedApplicationContext.getSettings().getLullabyRandomVolume(), 3);
            if (SleepService.SONAR_INITIAL_VOLUME > 0) {
                Logger.logInfo("Lullaby: INIT Sonar adjust volume ");
                LullabyPlayer.this.adjustVolume(SleepService.SONAR_INITIAL_VOLUME, new Settings(LullabyPlayer.this.context).getSonarVolume(3));
            }
            float f2 = LullabyPlayer.this.targetVol / 20.0f;
            Logger.logDebug("LullabyPlayer: run() " + LullabyPlayer.this.targetVol + " " + f2 + " " + f2);
            LullabyPlayer.this.binauralGenerator = null;
            int i3 = 2;
            if (SharedApplicationContext.getSettings().getBinaural() > 0) {
                int binaural = SharedApplicationContext.getSettings().getBinaural();
                if (binaural == 2) {
                    i = 4;
                } else if (binaural != 3) {
                    i2 = 2;
                    int lullabyVolumeDownAfter = SharedApplicationContext.getSettings().getLullabyVolumeDownAfter();
                    if (!SharedApplicationContext.getSettings().isSmartlightMaskEnabled()) {
                        Logger.logInfo("LullabyPlayer: Mask enabled");
                        LullabyPlayer lullabyPlayer = LullabyPlayer.this;
                        Context context = SharedApplicationContext.getInstance().getContext();
                        int[] iArrGenerateProgram = Programs.getProgram(3).generateProgram();
                        if (lullabyVolumeDownAfter == -1) {
                            lullabyVolumeDownAfter = 900000;
                        }
                        lullabyPlayer.binauralGenerator = new BinauralGeneratorFlex(context, iArrGenerateProgram, lullabyVolumeDownAfter / 60000, 3, false);
                    } else if (VolumeUtil.getHeadsetState(LullabyPlayer.this.context) > 0) {
                        Logger.logInfo("LullabyPlayer: Have headphones starting binaural generator");
                        LullabyPlayer lullabyPlayer2 = LullabyPlayer.this;
                        if (lullabyVolumeDownAfter == -1) {
                            lullabyVolumeDownAfter = 900000;
                        }
                        lullabyPlayer2.binauralGenerator = new BinauralGenerator(20, i2, lullabyVolumeDownAfter / 60000, 3, false);
                    } else {
                        Logger.logInfo("LullabyPlayer: No headphone no binaural");
                    }
                    if (LullabyPlayer.this.binauralGenerator != null) {
                        Logger.logInfo("LullabyPlayer: binaural play");
                        LullabyPlayer.this.binauralGenerator.play();
                    }
                } else {
                    i = 42;
                }
                i2 = i;
                int lullabyVolumeDownAfter2 = SharedApplicationContext.getSettings().getLullabyVolumeDownAfter();
                if (!SharedApplicationContext.getSettings().isSmartlightMaskEnabled()) {
                }
                if (LullabyPlayer.this.binauralGenerator != null) {
                }
            }
            for (Sample sample : LullabyPlayer.this.samples) {
                if (sample.isLooping()) {
                    if (!sample.isLarge() || LullabyPlayer.this.backgroundSampleDescriptor == null) {
                        sample.streamId = LullabyPlayer.this.pool.play(sample.id, 0.0f, 0.0f, sample.priority, -1, 1.0f);
                        zza$$ExternalSyntheticOutline0.m(new StringBuilder("LullabyPlayer: play() sample "), sample.streamId);
                    } else {
                        LullabyPlayer.this.h.post(new LullabyPlayer$PlayRunnable$$ExternalSyntheticLambda0(this, 1));
                    }
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            LocalBroadcastManager.getInstance(LullabyPlayer.this.context).registerReceiver(this.volumeReceiver, new IntentFilter("com.urbandroid.sleep.LULLABY_VOLUME_ACTION"));
            float f3 = f2;
            int i4 = 0;
            long j = 0;
            while (this.running.get()) {
                if (!LullabyPlayer.this.paused) {
                    try {
                        long jCurrentTimeMillis2 = (System.currentTimeMillis() - jCurrentTimeMillis) + j;
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (i4 < jCurrentTimeMillis2) {
                            int iRange = RandUtil.range(AppFunctionException.ERROR_APP_UNKNOWN_ERROR, 30000);
                            if (!LullabyPlayer.this.isGentleStop()) {
                                Iterator it = LullabyPlayer.this.samples.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Sample sample2 = (Sample) it.next();
                                    if (sample2.isLooping() || RandUtil.range(0, 100) >= sample2.rand) {
                                        f = 100.0f;
                                    } else {
                                        float fRange = RandUtil.range(sample2.lowpitch, sample2.highpitch) / f;
                                        float volume = LullabyPlayer.this.maxRandomVolume;
                                        float volume2 = LullabyPlayer.this.maxRandomVolume;
                                        int i5 = sample2.priority;
                                        if (!sample2.maxvolume) {
                                            volume = SharedApplicationContext.getSettings().getVolume(RandUtil.range(i3, LullabyPlayer.this.maxRandomVolume));
                                            volume2 = SharedApplicationContext.getSettings().getVolume(RandUtil.range(i3, LullabyPlayer.this.maxRandomVolume));
                                        }
                                        float f4 = volume2;
                                        float f5 = sample2.novolume ? f4 : volume;
                                        int i6 = sample2.loop;
                                        sample2.streamId = LullabyPlayer.this.pool.play(sample2.id, f5, f4, i5, i6 > 0 ? RandUtil.range(0, i6) : 0, fRange);
                                    }
                                }
                            }
                            i4 = iRange;
                            j = 0;
                        } else {
                            j = jCurrentTimeMillis2;
                        }
                        if (!LullabyPlayer.this.isGentleStop() && f3 <= LullabyPlayer.this.targetVol) {
                            f3 += f2;
                            Logger.logDebug("Lullaby: Playlist volup " + f2 + " " + f3);
                            if (LullabyPlayer.this.gaplessMediaPlayer == null) {
                                for (Sample sample3 : LullabyPlayer.this.samples) {
                                    if (sample3.isLooping()) {
                                        Logger.logDebug("LullabyPlayer: Volume " + LullabyPlayer.this.targetVol + " " + f2 + " " + f3);
                                        LullabyPlayer.this.pool.setVolume(sample3.streamId, f3, f3);
                                    }
                                }
                            } else {
                                Logger.logDebug("LullabyPlayer: Volume " + LullabyPlayer.this.targetVol + " " + f2 + " " + f3);
                                LullabyPlayer.this.gaplessMediaPlayer.setCurrentVolume(f3);
                            }
                        }
                        if (LullabyPlayer.this.isGentleStop() && f3 > 0.0f) {
                            Logger.logDebug("Lullaby: Playlist voldown " + f2 + " " + f3);
                            f3 -= f2;
                            if (LullabyPlayer.this.gaplessMediaPlayer == null) {
                                for (Sample sample4 : LullabyPlayer.this.samples) {
                                    if (sample4.isLooping()) {
                                        Logger.logDebug("LullabyPlayer: Volume " + LullabyPlayer.this.targetVol + " " + f2 + " " + f3);
                                        LullabyPlayer.this.pool.setVolume(sample4.streamId, f3, f3);
                                    }
                                }
                            } else {
                                Logger.logDebug("LullabyPlayer: Volume " + LullabyPlayer.this.targetVol + " " + f2 + " " + f3);
                                LullabyPlayer.this.gaplessMediaPlayer.setCurrentVolume(f3);
                            }
                        }
                        Thread.sleep(1000L);
                        f = 100.0f;
                        i3 = 2;
                    } catch (InterruptedException unused) {
                        stop();
                        return;
                    }
                }
            }
        }

        public void stop() {
            int i = 0;
            this.running.set(false);
            LocalBroadcastManager.getInstance(LullabyPlayer.this.context).unregisterReceiver(this.volumeReceiver);
            if (LullabyPlayer.this.binauralGenerator != null) {
                Logger.logInfo("LullabyPlayer: binaural stop");
                LullabyPlayer.this.binauralGenerator.stop();
            }
            for (Sample sample : LullabyPlayer.this.samples) {
                zza$$ExternalSyntheticOutline0.m(new StringBuilder("LullabyPlayer: pool stop "), sample.streamId);
                LullabyPlayer.this.pool.autoPause();
                LullabyPlayer.this.pool.stop(sample.streamId);
            }
            for (Sample sample2 : LullabyPlayer.this.samples) {
                zza$$ExternalSyntheticOutline0.m(new StringBuilder("LullabyPlayer: pool unload "), sample2.streamId);
                LullabyPlayer.this.pool.unload(sample2.id);
            }
            LullabyPlayer.this.pool.release();
            if (LullabyPlayer.this.gaplessMediaPlayer != null) {
                LullabyPlayer.this.h.post(new LullabyPlayer$PlayRunnable$$ExternalSyntheticLambda0(this, i));
            }
        }

        public /* synthetic */ PlayRunnable(LullabyPlayer lullabyPlayer, int i) {
            this();
        }
    }

    public class SampleOnLoadListener implements SoundPool.OnLoadCompleteListener {
        private boolean cancel;
        private Set<Integer> loadedIds;
        private Set<Integer> waitForIds;

        private SampleOnLoadListener() {
            this.cancel = false;
            this.loadedIds = Collections.synchronizedSet(new HashSet());
            this.waitForIds = Collections.synchronizedSet(new HashSet());
        }

        public Set<Integer> getWaitForIds() {
            return this.waitForIds;
        }

        public synchronized boolean isCancel() {
            return this.cancel;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            zza$$ExternalSyntheticOutline0.m(i, "LullabyPlayer: Loaded sample ");
            this.loadedIds.add(Integer.valueOf(i));
            Iterator<Integer> it = this.waitForIds.iterator();
            int i3 = 0;
            int i4 = 0;
            while (it.hasNext()) {
                if (this.loadedIds.contains(it.next())) {
                    i4++;
                }
            }
            if (isCancel() || i4 < this.waitForIds.size() || LullabyPlayer.this.player != null) {
                return;
            }
            Logger.logDebug("LullabyPlayer: All loaded: Starting playback " + i4);
            LullabyPlayer lullabyPlayer = LullabyPlayer.this;
            lullabyPlayer.player = new PlayRunnable(lullabyPlayer, i3);
            new Thread(LullabyPlayer.this.player).start();
            if (LullabyPlayer.this.startListener != null) {
                LullabyPlayer.this.startListener.onPlaybackStart();
            }
        }

        public synchronized void setCancel(boolean z) {
            this.cancel = z;
        }

        public /* synthetic */ SampleOnLoadListener(LullabyPlayer lullabyPlayer, int i) {
            this();
        }
    }
}
