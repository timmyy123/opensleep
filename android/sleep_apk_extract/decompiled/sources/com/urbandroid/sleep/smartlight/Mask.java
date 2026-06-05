package com.urbandroid.sleep.smartlight;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.hecz.android.FlexPlayer;
import com.hecz.android.HintParams;
import com.hecz.android.IFlexListener;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity;
import com.urbandroid.sleep.media.lullaby.LullabyService;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes5.dex */
public class Mask implements SmartLight {
    private Context context;
    private int duration;
    private float maxIntensity;

    public abstract class ExecuteTemplate {
        public ExecuteTemplate() {
        }

        public abstract void doExecute(FlexPlayer flexPlayer);

        public void execute() {
            Logger.logInfo("SmartLight: Mask Flex executor");
            final FlexPlayer flexPlayer = new FlexPlayer();
            flexPlayer.initPort(Mask.this.context, new IFlexListener() { // from class: com.urbandroid.sleep.smartlight.Mask.ExecuteTemplate.1
                @Override // com.hecz.android.IFlexListener
                public void onConnected() {
                    Logger.logInfo("SmartLight: Mask Flex connected mint or alarm");
                    ExecuteTemplate.this.doExecute(flexPlayer);
                }

                @Override // com.hecz.android.IFlexListener
                public void onDisconnect() {
                }
            });
        }
    }

    public abstract class StopLullabyTemplate {

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.Mask$StopLullabyTemplate$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContextCompat.registerReceiver(Mask.this.context, new BroadcastReceiver() { // from class: com.urbandroid.sleep.smartlight.Mask.StopLullabyTemplate.1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        try {
                            context.unregisterReceiver(this);
                        } catch (Exception unused) {
                        }
                        new ExecuteTemplate() { // from class: com.urbandroid.sleep.smartlight.Mask.StopLullabyTemplate.1.1.1
                            {
                                Mask mask = Mask.this;
                            }

                            @Override // com.urbandroid.sleep.smartlight.Mask.ExecuteTemplate
                            public void doExecute(FlexPlayer flexPlayer) {
                                StopLullabyTemplate.this.doExecute(flexPlayer);
                            }
                        }.execute();
                    }
                }, new IntentFilter("com.urbandroid.sleep.ACTION_LULLABY_STOPPED_PLAYBACK"), 2);
                zza$$ExternalSyntheticOutline0.m(Mask.this.context, "com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK");
            }
        }

        public StopLullabyTemplate() {
        }

        public abstract void doExecute(FlexPlayer flexPlayer);

        public void execute() {
            if (LullabyService.isRunning()) {
                new Handler().post(new AnonymousClass1());
            } else {
                new ExecuteTemplate() { // from class: com.urbandroid.sleep.smartlight.Mask.StopLullabyTemplate.2
                    {
                        Mask mask = Mask.this;
                    }

                    @Override // com.urbandroid.sleep.smartlight.Mask.ExecuteTemplate
                    public void doExecute(FlexPlayer flexPlayer) {
                        StopLullabyTemplate.this.doExecute(flexPlayer);
                    }
                }.execute();
            }
        }
    }

    public Mask(Context context) {
        this.duration = 60000;
        this.maxIntensity = 1.0f;
        this.context = context;
        this.maxIntensity = new Settings(context).getSmartlightMaxIntensity();
        this.duration = new Settings(context).getGradualVolumeIncreaseDuration();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void close() {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint(final int i) {
        Logger.logInfo("SmartLight: Mask Flex hint");
        if (new Settings(this.context).isLucidMaskReserved()) {
            Logger.logInfo("SmartLight: Mask Flex hint IGNORING reserved");
        } else {
            new StopLullabyTemplate() { // from class: com.urbandroid.sleep.smartlight.Mask.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.urbandroid.sleep.smartlight.Mask.StopLullabyTemplate
                public void doExecute(FlexPlayer flexPlayer) {
                    Logger.logInfo("SmartLight: Mask Hint executed");
                    flexPlayer.setRgb(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN);
                    flexPlayer.setIntensity(Math.round(Mask.this.maxIntensity * 150.0f));
                    double d = ((double) i) * 0.5d;
                    HintParams hintParams = new HintParams();
                    hintParams.setHintDuration((long) ((d * 9765.625d) - 128.0d));
                    hintParams.setHintPwm((short) 4754);
                    hintParams.setBlue(PHIpAddressSearchManager.END_IP_SCAN);
                    hintParams.setRed(PHIpAddressSearchManager.END_IP_SCAN);
                    hintParams.setGreen(PHIpAddressSearchManager.END_IP_SCAN);
                    hintParams.setPwm(200);
                    hintParams.setPwmStep((short) (r1 / 100.0d));
                    hintParams.setPwmWay(2);
                    flexPlayer.transition(hintParams);
                }
            }.execute();
        }
    }

    public boolean isConnected() {
        return SmartLightSettingsActivity.isSerialConnected(this.context);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public synchronized void nightLight(int i) {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public synchronized void off() {
        Logger.logInfo("SmartLight: turn off");
        if (!LullabyService.isRunning()) {
            new ExecuteTemplate() { // from class: com.urbandroid.sleep.smartlight.Mask.1
                @Override // com.urbandroid.sleep.smartlight.Mask.ExecuteTemplate
                public void doExecute(FlexPlayer flexPlayer) {
                    Logger.logInfo("SmartLight: flex.stop()");
                    flexPlayer.sendData("t");
                    flexPlayer.stop();
                }
            }.execute();
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void shortHint() {
        if (LullabyService.isRunning()) {
            return;
        }
        hint(1);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public synchronized void sunrise(int i, int i2) {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public synchronized void sunriseFull() {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public synchronized void sunriseStart() {
        new Settings(this.context).reserveLucidMask(125000L);
        Logger.logInfo("SmartLight: Mask Sunrise start");
        new StopLullabyTemplate() { // from class: com.urbandroid.sleep.smartlight.Mask.2
            @Override // com.urbandroid.sleep.smartlight.Mask.StopLullabyTemplate
            public void doExecute(FlexPlayer flexPlayer) {
                Logger.logInfo("SmartLight: Mask Sunrise executed");
                flexPlayer.setRgb(PHIpAddressSearchManager.END_IP_SCAN, 0, 0);
                flexPlayer.setIntensity(Math.round(Mask.this.maxIntensity * 150.0f));
                HintParams hintParams = new HintParams();
                hintParams.setHintDuration(1171875L);
                hintParams.setRed(PHIpAddressSearchManager.END_IP_SCAN);
                hintParams.setGreenWay(1);
                hintParams.setGreen(0);
                hintParams.setGreenStep((short) 4613);
                hintParams.setPwm(PHIpAddressSearchManager.END_IP_SCAN);
                hintParams.setPwmStep((short) 4631);
                hintParams.setPwmWay(2);
                flexPlayer.transition(hintParams);
            }
        }.execute();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public synchronized void off(boolean z) {
        off();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public synchronized void hint() {
        hint(3);
    }
}
