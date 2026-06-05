package com.urbandroid.sleep.sensor.sonar;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;

/* JADX INFO: loaded from: classes4.dex */
public class SonarConsumerFactory {
    private Context context;

    public SonarConsumerFactory(Context context) {
        this.context = context;
    }

    public SonarConsumer createSonarConsumer(SonarConfig.SonarMethod sonarMethod) {
        Logger.logInfo("Sonar: method " + sonarMethod);
        boolean zIsMonoFreq = sonarMethod.isMonoFreq();
        Context context = this.context;
        return zIsMonoFreq ? new DiffSonarConsumer(context, sonarMethod) : new FftSonarConsumer(context, sonarMethod);
    }
}
