package com.urbandroid.sleep.media.spotify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.view.KeyEvent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.wifi.WifiContext;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.media.player.MusicActivityController;
import com.urbandroid.sleep.media.player.PlaybackListener;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.service.Settings;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes.dex */
public class SpotifyIntentPlayer implements ISpotifyPlayer {
    private AudioManager audioManager;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private final PlaybackListener playbackListener;
    private final Settings settings;
    private String uri;
    private boolean shouldForcePlay = false;
    private ISpotifyPlayer.PlayerMode currentPlayerMode = ISpotifyPlayer.PlayerMode.ALARM;
    private final AtomicBoolean isStopped = new AtomicBoolean(false);
    private final AtomicReference<WifiContext> wifiContext = new AtomicReference<>();
    private String playerName = getClass().getSimpleName();
    private final Handler handler = new Handler();

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpotifyIntentPlayer.this.isStopped.get()) {
                return;
            }
            SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.NEXT");
            new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 5L, 50L, new PlaybackListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.4.1
                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void fail(int i) {
                    Logger.logInfo("Spotify failed: " + i + " let's do it again send NEXT");
                    SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.NEXT");
                    new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 5L, 50L, new PlaybackListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.4.1.1
                        @Override // com.urbandroid.sleep.media.player.PlaybackListener
                        public void fail(int i2) {
                            SpotifyIntentPlayer spotifyIntentPlayer = SpotifyIntentPlayer.this;
                            spotifyIntentPlayer.playRandomDefaultAlbum(spotifyIntentPlayer.currentPlayerMode);
                            new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 10L, 50L, SpotifyIntentPlayer.this.playbackListener, SpotifyIntentPlayer.this.handler).start();
                        }

                        @Override // com.urbandroid.sleep.media.player.PlaybackListener
                        public void playbackStarted() {
                            SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                        }
                    }, SpotifyIntentPlayer.this.handler).start();
                }

                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void playbackStarted() {
                    SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                }
            }, SpotifyIntentPlayer.this.handler).start();
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer$6, reason: invalid class name */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ String val$uri;

        public AnonymousClass6(String str) {
            this.val$uri = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpotifyIntentPlayer.this.isStopped.get()) {
                return;
            }
            if (!SpotifyIntentPlayer.this.playInternal(this.val$uri)) {
                SpotifyIntentPlayer.this.playbackListener.fail(6);
                return;
            }
            Logger.logInfo("Spotify FIND " + this.val$uri);
            SpotifyIntentPlayer.this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.6.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.logInfo("Spotify PLAY " + AnonymousClass6.this.val$uri);
                    SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                    new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 20L, 50L, new PlaybackListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.6.1.1
                        @Override // com.urbandroid.sleep.media.player.PlaybackListener
                        public void fail(int i) {
                            Logger.logInfo("Spotify album failed with reason: " + i + " - We will try to play just NEXT song");
                            StringBuilder sb = new StringBuilder("Spotify SECOND PLAY ");
                            sb.append(AnonymousClass6.this.val$uri);
                            Logger.logInfo(sb.toString());
                            SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                            new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 10L, 50L, SpotifyIntentPlayer.this.playbackListener, SpotifyIntentPlayer.this.handler).start();
                        }

                        @Override // com.urbandroid.sleep.media.player.PlaybackListener
                        public void playbackStarted() {
                            SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                        }
                    }, SpotifyIntentPlayer.this.handler).start();
                }
            }, 10000L);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer$7, reason: invalid class name */
    public class AnonymousClass7 implements Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpotifyIntentPlayer.this.isStopped.get()) {
                return;
            }
            SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
            new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 5L, 50L, new PlaybackListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.7.1
                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void fail(int i) {
                    Logger.logInfo("Spotify failed: " + i + " let's do it again send NEXT");
                    SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.NEXT");
                    new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 5L, 50L, new PlaybackListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.7.1.1
                        @Override // com.urbandroid.sleep.media.player.PlaybackListener
                        public void fail(int i2) {
                            SpotifyIntentPlayer spotifyIntentPlayer = SpotifyIntentPlayer.this;
                            spotifyIntentPlayer.playRandomDefaultAlbum(spotifyIntentPlayer.currentPlayerMode);
                            SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                            new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 10L, 50L, SpotifyIntentPlayer.this.playbackListener, SpotifyIntentPlayer.this.handler).start();
                        }

                        @Override // com.urbandroid.sleep.media.player.PlaybackListener
                        public void playbackStarted() {
                            SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                        }
                    }, SpotifyIntentPlayer.this.handler).start();
                }

                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void playbackStarted() {
                    SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                }
            }, SpotifyIntentPlayer.this.handler).start();
        }
    }

    public SpotifyIntentPlayer(Context context, PlaybackListener playbackListener) {
        this.context = context;
        this.playbackListener = playbackListener;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.settings = new Settings(context);
    }

    private void command4_4below(int i) {
        boolean zIsMusicActive = this.audioManager.isMusicActive();
        Logger.logDebug("Spotify Is Playing: " + zIsMusicActive);
        if (i == 1) {
            if (zIsMusicActive) {
                sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.logDebug("Spotify Is Playing: " + SpotifyIntentPlayer.this.audioManager.isMusicActive());
                        boolean zIsMusicActive2 = SpotifyIntentPlayer.this.audioManager.isMusicActive();
                        SpotifyIntentPlayer spotifyIntentPlayer = SpotifyIntentPlayer.this;
                        if (zIsMusicActive2) {
                            spotifyIntentPlayer.playbackListener.playbackStarted();
                        } else {
                            spotifyIntentPlayer.sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                            SpotifyIntentPlayer.this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Logger.logDebug("Spotify Is Playing: " + SpotifyIntentPlayer.this.audioManager.isMusicActive());
                                    boolean zIsMusicActive3 = SpotifyIntentPlayer.this.audioManager.isMusicActive();
                                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                    if (zIsMusicActive3) {
                                        SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                                    } else {
                                        SpotifyIntentPlayer.this.playbackListener.fail(4);
                                    }
                                }
                            }, 500L);
                        }
                    }
                }, 500L);
            } else {
                sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.10
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z = SpotifyIntentPlayer.this.isStopped.get();
                        SpotifyIntentPlayer spotifyIntentPlayer = SpotifyIntentPlayer.this;
                        if (z) {
                            Logger.logDebug("Spotify Is Playing: " + spotifyIntentPlayer.audioManager.isMusicActive() + " already stopped");
                            return;
                        }
                        Logger.logDebug("Spotify Is Playing: " + spotifyIntentPlayer.audioManager.isMusicActive());
                        boolean zIsMusicActive2 = SpotifyIntentPlayer.this.audioManager.isMusicActive();
                        SpotifyIntentPlayer spotifyIntentPlayer2 = SpotifyIntentPlayer.this;
                        if (zIsMusicActive2) {
                            spotifyIntentPlayer2.playbackListener.playbackStarted();
                        } else {
                            spotifyIntentPlayer2.sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                            SpotifyIntentPlayer.this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SpotifyIntentPlayer.this.isStopped.get()) {
                                        return;
                                    }
                                    Logger.logDebug("Spotify Is Playing: " + SpotifyIntentPlayer.this.audioManager.isMusicActive());
                                    boolean zIsMusicActive3 = SpotifyIntentPlayer.this.audioManager.isMusicActive();
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    if (zIsMusicActive3) {
                                        SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                                    } else {
                                        SpotifyIntentPlayer.this.playbackListener.fail(4);
                                    }
                                }
                            }, 500L);
                        }
                    }
                }, 5000L);
            }
        }
        if (i == 0) {
            if (zIsMusicActive) {
                sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
            }
            this.isStopped.set(true);
        }
    }

    private void command4_4plus(int i, final String str) {
        boolean zIsMusicActive = this.audioManager.isMusicActive();
        Logger.logDebug("Spotify Is Playing: " + zIsMusicActive);
        if (i == 1) {
            if (!this.shouldForcePlay && zIsMusicActive) {
                this.playbackListener.playbackStarted();
                return;
            }
            Logger.logInfo("Spotify auth: " + this.settings.isSpotify() + " premium: " + this.settings.isSpotifyPremium() + " product: " + this.settings.getSpotifyProduct() + " uri: " + str);
            if (!this.settings.isSpotify() || str == null || str.contains("spotify-play-last-song")) {
                if (!launchSpotify()) {
                    this.playbackListener.fail(6);
                    return;
                }
                this.handler.postDelayed(new AnonymousClass4(), 10000L);
            } else {
                if (!launchSpotify()) {
                    this.playbackListener.fail(6);
                    return;
                }
                this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpotifyIntentPlayer.this.isStopped.get()) {
                            return;
                        }
                        boolean zPlayInternal = SpotifyIntentPlayer.this.playInternal(str);
                        SpotifyIntentPlayer spotifyIntentPlayer = SpotifyIntentPlayer.this;
                        if (zPlayInternal) {
                            new MusicActivityController(spotifyIntentPlayer.context, SpotifyIntentPlayer.this.playerName, 10L, 50L, new PlaybackListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.3.1
                                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                                public void fail(int i2) {
                                    Logger.logInfo("Spotify album failed with reason: " + i2 + " - We will try to play just NEXT song");
                                    SpotifyIntentPlayer.this.sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                                    new MusicActivityController(SpotifyIntentPlayer.this.context, SpotifyIntentPlayer.this.playerName, 10L, 50L, SpotifyIntentPlayer.this.playbackListener, SpotifyIntentPlayer.this.handler).start();
                                }

                                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                                public void playbackStarted() {
                                    SpotifyIntentPlayer.this.playbackListener.playbackStarted();
                                }
                            }, SpotifyIntentPlayer.this.handler).start();
                        } else {
                            spotifyIntentPlayer.playbackListener.fail(6);
                        }
                    }
                }, 10000L);
            }
        }
        if (i == 0) {
            if (zIsMusicActive) {
                Logger.logInfo("Spotify STOP");
                if (isSpotifyVersionAtLeast(49027455)) {
                    sendMediaButton(this.context, "com.spotify.mobile.android.ui.widget.STOP");
                } else if (isSpotifyVersionAtLeast(41948207)) {
                    AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
                    audioManager.requestAudioFocus(null, 3, 2);
                    if (!isSpotifyVersionAtLeast(42996327)) {
                        audioManager.abandonAudioFocus(null);
                    }
                } else {
                    sendSpotifyAction("com.spotify.mobile.android.ui.widget.PLAY");
                }
                this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpotifyIntentPlayer.this.audioManager.isMusicActive()) {
                            Logger.logInfo("Spotify still playing after stop - sending another stop");
                            ((AudioManager) SpotifyIntentPlayer.this.context.getSystemService("audio")).requestAudioFocus(null, 3, 2);
                        }
                    }
                }, 2000L);
            }
            this.isStopped.set(true);
        }
    }

    private void command8_5plus(int i, String str) {
        boolean zIsMusicActive = this.audioManager.isMusicActive();
        Logger.logDebug("Spotify Is Playing: " + zIsMusicActive);
        if (i == 1) {
            if (!this.shouldForcePlay && zIsMusicActive) {
                this.playbackListener.playbackStarted();
                return;
            }
            Logger.logInfo("Spotify auth: " + this.settings.isSpotify() + " premium: " + this.settings.isSpotifyPremium() + " product: " + this.settings.getSpotifyProduct() + " uri: " + str);
            if (str == null || str.contains("spotify-play-last-song")) {
                Logger.logInfo("Spotify DISABLED");
                if (!launchSpotify()) {
                    this.playbackListener.fail(6);
                    return;
                }
                this.handler.postDelayed(new AnonymousClass7(), 10000L);
            } else {
                Logger.logInfo("Spotify ENABLED");
                if (!launchSpotify()) {
                    this.playbackListener.fail(6);
                    return;
                } else {
                    sendSpotifyAction("com.spotify.mobile.android.ui.widget.STOP");
                    Logger.logInfo("Spotify STOP");
                    this.handler.postDelayed(new AnonymousClass6(str), 10000L);
                }
            }
        }
        if (i == 0) {
            if (zIsMusicActive) {
                Logger.logInfo("Spotify STOP");
                sendMediaButton(this.context, "com.spotify.mobile.android.ui.widget.STOP");
                this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.8
                    @Override // java.lang.Runnable
                    public void run() {
                        SpotifyIntentPlayer spotifyIntentPlayer = SpotifyIntentPlayer.this;
                        spotifyIntentPlayer.sendMediaButton(spotifyIntentPlayer.context, "com.spotify.mobile.android.ui.widget.STOP");
                        SpotifyIntentPlayer.this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SpotifyIntentPlayer spotifyIntentPlayer2 = SpotifyIntentPlayer.this;
                                spotifyIntentPlayer2.sendMediaButton(spotifyIntentPlayer2.context, "com.spotify.mobile.android.ui.widget.STOP");
                                if (SpotifyIntentPlayer.this.audioManager.isMusicActive()) {
                                    Logger.logInfo("Spotify still playing after stop - sending another stop");
                                    ((AudioManager) SpotifyIntentPlayer.this.context.getSystemService("audio")).requestAudioFocus(null, 3, 2);
                                }
                            }
                        }, 2000L);
                    }
                }, 2000L);
            }
            this.isStopped.set(true);
        }
    }

    private synchronized void doStop() {
        Logger.logDebug("Spotify stop ...");
        if (this.isStopped.get()) {
            Logger.logDebug("Spotify already stopped");
            return;
        }
        if (this.wifiContext.get() != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    WifiContext wifiContext = (WifiContext) SpotifyIntentPlayer.this.wifiContext.get();
                    if (wifiContext != null) {
                        wifiContext.disable();
                    }
                }
            }, 15000L);
        }
        command(0, null);
    }

    private boolean launchSpotify() {
        Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.spotify.music");
        if (launchIntentForPackage == null) {
            Logger.logSevere("Spotify app not found/available");
            return false;
        }
        launchIntentForPackage.addFlags(ClientDefaults.MAX_MSG_SIZE);
        this.context.startActivity(launchIntentForPackage);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean playInternal(String str) {
        String strConcat = str.endsWith(":play") ? "" : str.concat(":play");
        Intent intent = new Intent("android.media.action.MEDIA_PLAY_FROM_SEARCH");
        if (isSpotifyVersionAtLeast(49027455)) {
            intent.setAction("android.intent.action.VIEW");
        }
        intent.setPackage("com.spotify.music");
        intent.setData(Uri.parse(strConcat));
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        Logger.logInfo("Spotify PLAY internal: ".concat(strConcat));
        try {
            this.context.startActivity(intent);
            return true;
        } catch (Exception e) {
            Logger.logSevere(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playRandomDefaultAlbum(ISpotifyPlayer.PlayerMode playerMode) {
        String[] strArr = {"spotify:album:4YmNhD0y0D0jMa926HRizV", "spotify:album:3Qyb1wZtLSMJRYzyvLTe4W", "spotify:album:2hstKFT7GOo34ZyFbMTXWN", "spotify:album:2YaOLFTueNlOlR5DdhP9Ne", "spotify:album:71P81ODnpkKeDQOVlnAAEd", "spotify:album:3nKaL2gpdF60hvUKfMBOBZ", "spotify:album:7HLdLhjRUrMnCIsRffndmr", "spotify:album:6fLmqqsaPVwdQCczq0qk5P"};
        String[] strArr2 = {"spotify:album:7ig8uxZ0hx1UOfBfXaYa4L", "spotify:album:3hNJ4NaSlUrqhazZQSKJK5", "spotify:album:1OFDYruGaToCZKojqbI2CM", "spotify:album:5VegsXlLaNVU7cFHSA6MAq", "spotify:album:0VCZHRn3tbWofe9SwVJMs4", "spotify:album:0ThFCnS9cyUYBdgGkR5hQQ", "spotify:album:48plkkEdUxOZtMyMDzqDvi", "spotify:album:6gJitO2jkPMAyDiJ07qSXg", "spotify:album:6jHBXhQSoOp7o7C6sdrIUb", "spotify:album:5nSmfYSrKOG4Kts9H20xBP", "spotify:album:6Yl951bwCSY70QjvLm1AEG"};
        if (playerMode.equals(ISpotifyPlayer.PlayerMode.LULLABY)) {
            playInternal(strArr[new Random().nextInt(8)]);
        } else {
            playInternal(strArr2[new Random().nextInt(11)]);
        }
    }

    private synchronized void playSynchronized(final String str) {
        if (str != null) {
            try {
                this.uri = str;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.isStopped.set(false);
        if (ConnectivityChangeReceiver.isConnected(this.connectivityManager)) {
            start(str);
        } else {
            this.wifiContext.set(WifiEnabler.getInstance().enable(getClass(), 15, new WifiEnabler.OnConnectListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifyIntentPlayer.1
                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void connected(WifiContext wifiContext) {
                    Logger.logDebug("Spotify - wifi connected");
                    SpotifyIntentPlayer.this.start(str);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void failed() {
                    Logger.logDebug("Spotify - wifi failure");
                    SpotifyIntentPlayer.this.start(str);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void timeouted() {
                    Logger.logDebug("Spotify - wifi timeout");
                    SpotifyIntentPlayer.this.start(str);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSpotifyAction(String str) {
        Logger.logDebug("Spotify " + str + " intent action sending ...");
        if (isSpotifyVersionAtLeast(49027455)) {
            sendMediaButton(this.context, str);
            return;
        }
        Intent intent = new Intent(str);
        intent.setPackage("com.spotify.music");
        ContextExtKt.sendExplicitBroadcast(this.context, intent);
        Logger.logDebug("Spotify play intent sent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(String str) {
        if (this.isStopped.get()) {
            return;
        }
        command(1, str);
    }

    public synchronized void command(int i, String str) {
        try {
            if (isSpotifyVersionAtLeast(49027455)) {
                command8_5plus(i, str);
            } else if (isSpotify4_4plus()) {
                command4_4plus(i, str);
            } else {
                command4_4below(i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean isSpotify4_4plus() {
        PackageInfo spotifyPackageInfo = TrialFilter.getInstance().getSpotifyPackageInfo();
        if (spotifyPackageInfo != null) {
            Logger.logDebug("Spotify version: " + spotifyPackageInfo.versionName + " code: " + spotifyPackageInfo.versionCode);
            if (spotifyPackageInfo.versionCode >= 9702353) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpotifyVersionAtLeast(int i) {
        PackageInfo spotifyPackageInfo = TrialFilter.getInstance().getSpotifyPackageInfo();
        return spotifyPackageInfo != null && spotifyPackageInfo.versionCode >= i;
    }

    public void sendMediaButton(Context context, String str) {
        int i;
        str.getClass();
        i = -1;
        switch (str) {
            case "com.spotify.mobile.android.ui.widget.NEXT":
                i = 87;
                break;
            case "com.spotify.mobile.android.ui.widget.PLAY":
                i = 126;
                break;
            case "com.spotify.mobile.android.ui.widget.STOP":
                i = 86;
                break;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i));
        intent.setPackage("com.spotify.music");
        ContextExtKt.sendExplicitBroadcast(context, intent, "com.spotify.music");
        Logger.logInfo("Spotify: Media button " + intent.toUri(0) + " extra " + str);
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public ISpotifyPlayer setForcePlay() {
        this.shouldForcePlay = true;
        return this;
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public ISpotifyPlayer setMode(ISpotifyPlayer.PlayerMode playerMode) {
        this.currentPlayerMode = playerMode;
        return this;
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public ISpotifyPlayer stop() {
        doStop();
        return this;
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public SpotifyIntentPlayer play(String str) {
        playSynchronized(str);
        return this;
    }
}
