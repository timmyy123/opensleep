package com.urbandroid.sleep.apnea;

import android.content.Context;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.sleep.domain.Sensitivity;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ApneaAlarmDetector {
    private final float baselineAdjustment;
    private Context context;
    private final WeirdSpo2Guard weirdSpo2Guard;
    private List<Float> apneaAlarmList = new ArrayList();
    private long lastApneaAlarmTime = -1;
    private long firstApneaTime = 0;
    private long apneaCount = 0;

    /* JADX INFO: renamed from: com.urbandroid.sleep.apnea.ApneaAlarmDetector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$domain$Sensitivity;

        static {
            int[] iArr = new int[Sensitivity.values().length];
            $SwitchMap$com$urbandroid$sleep$domain$Sensitivity = iArr;
            try {
                iArr[Sensitivity.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$domain$Sensitivity[Sensitivity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$domain$Sensitivity[Sensitivity.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$domain$Sensitivity[Sensitivity.VERY_LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ApneaAlarmDetector(Context context, Sensitivity sensitivity) {
        this.context = context;
        this.weirdSpo2Guard = new WeirdSpo2Guard(sensitivity);
        this.baselineAdjustment = getBaselineAdjustment(sensitivity);
        Logger.addFilter(Filters.filter("ApneaAlarmDetector: weird input", 600));
    }

    private float getBaselineAdjustment(Sensitivity sensitivity) {
        int i = AnonymousClass1.$SwitchMap$com$urbandroid$sleep$domain$Sensitivity[sensitivity.ordinal()];
        if (i == 1) {
            return 0.97f;
        }
        if (i == 2) {
            return 0.96f;
        }
        if (i == 3) {
            return 0.93f;
        }
        if (i == 4) {
            return 0.89f;
        }
        Gson$$ExternalSyntheticBUOutline0.m("", sensitivity);
        return 0.0f;
    }

    public void add(float f) {
        this.apneaAlarmList.add(Float.valueOf(f));
        if (this.apneaAlarmList.size() > 300) {
            this.apneaAlarmList.remove(0);
            if (this.weirdSpo2Guard.process(f)) {
                Logger.logInfo("ApneaAlarmDetector: weird input");
                this.apneaCount = 0L;
                return;
            }
            Float[] fArr = (Float[]) this.apneaAlarmList.toArray(new Float[0]);
            float fPercentile = ScienceUtil.percentile(fArr, 95.0f);
            float f2 = 0.0f;
            float fFloatValue = 0.0f;
            for (Float f3 : fArr) {
                if (f3.floatValue() >= fPercentile) {
                    fFloatValue += f3.floatValue();
                    f2 += 1.0f;
                }
            }
            float f4 = f2 > 0.0f ? (fFloatValue / f2) * this.baselineAdjustment : 90.0f;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (f < f4) {
                long j = this.apneaCount + 1;
                this.apneaCount = j;
                if (j == 1) {
                    this.firstApneaTime = jCurrentTimeMillis;
                }
            } else {
                this.apneaCount = 0L;
            }
            if (this.apneaCount < 5 || jCurrentTimeMillis - this.firstApneaTime < 20000) {
                return;
            }
            long j2 = this.lastApneaAlarmTime;
            if (j2 == -1 || jCurrentTimeMillis - j2 > 300000) {
                Logger.logInfo("ApneaAlarmDetector: alarm BL: " + f4 + " V: " + f);
                StringBuilder sb = new StringBuilder();
                Iterator<Float> it = this.apneaAlarmList.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().intValue());
                    sb.append(" ");
                }
                Logger.logInfo("ApneaAlarm: W " + ((Object) sb));
                zza$$ExternalSyntheticOutline0.m(this.context, "com.urbandroid.sleep.ACTION_APNEA_ALARM");
                this.lastApneaAlarmTime = jCurrentTimeMillis;
                this.apneaCount = 0L;
            }
        }
    }
}
