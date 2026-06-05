package com.urbandroid.sleep.jetlag;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.timezone.ZoneInfoMapper;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartlight.FlashLight;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class JetLagService {
    public static String ACTION_JETLAG_START = "com.urbandroid.sleep.JETLAG_START";
    public static String ACTION_JETLAG_STOP = "com.urbandroid.sleep.JETLAG_STOP";
    public static int JETLAG_RATE = 10000;
    private Context context;
    private Location location;
    private SmartLight smartLight;
    private TimeZone timeZone;
    private int count = 0;
    private boolean started = false;
    private Runnable jetLagRunnable = new Runnable() { // from class: com.urbandroid.sleep.jetlag.JetLagService.1
        @Override // java.lang.Runnable
        public void run() {
            if (SunTimeUtil.isRemoteSunTime(JetLagService.this.timeZone, JetLagService.this.location)) {
                JetLagService jetLagService = JetLagService.this;
                jetLagService.smartLight = SmartLightProvider.getSmartLight(jetLagService.context);
                if (JetLagService.this.smartLight == null) {
                    JetLagService.this.smartLight = new FlashLight(SharedApplicationContext.getInstance().getFlashlightService(), new Handler());
                }
                JetLagService.this.smartLight.shortHint();
                JetLagService.this.count++;
                if (JetLagService.this.count % 60 == 0) {
                    Logger.logInfo("JetLag: blink");
                }
            }
            JetLagService.this.h.postDelayed(this, JetLagService.JETLAG_RATE);
        }
    };
    private Handler h = new Handler();

    public JetLagService(Context context) {
        this.context = context;
    }

    public void start(TimeZone timeZone) {
        Logger.logInfo("JetLag: start " + timeZone);
        this.location = new ZoneInfoMapper().getLocation(timeZone.getID());
        this.timeZone = timeZone;
        this.started = true;
        this.count = 0;
        this.h.removeCallbacks(this.jetLagRunnable);
        this.h.post(this.jetLagRunnable);
        Intent intent = new Intent(ACTION_JETLAG_START);
        intent.setPackage(this.context.getPackageName());
        this.context.sendBroadcast(intent);
    }

    public void stop() {
        Logger.logInfo("JetLag: stop");
        this.h.removeCallbacks(this.jetLagRunnable);
        this.started = false;
        Intent intent = new Intent(ACTION_JETLAG_STOP);
        intent.setPackage(this.context.getPackageName());
        this.context.sendBroadcast(intent);
    }
}
