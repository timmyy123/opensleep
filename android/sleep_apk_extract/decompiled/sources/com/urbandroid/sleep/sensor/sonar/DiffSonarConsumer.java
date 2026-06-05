package com.urbandroid.sleep.sensor.sonar;

import android.content.Context;
import com.urbandroid.sleep.audio.transform.AudioTransformer;
import com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class DiffSonarConsumer extends AbstractSonarConsumer {
    private float[] prevRecord;

    public DiffSonarConsumer(Context context, SonarConfig.SonarMethod sonarMethod) {
        super(context, sonarMethod);
        this.prevRecord = null;
    }

    private float[] abs(float[] fArr) {
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = Math.abs(fArr[i]);
        }
        return fArr2;
    }

    private float[] sub(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float[] fArr3 = new float[length];
        for (int i = 0; i < length; i++) {
            fArr3[i] = fArr[i] - fArr2[i];
        }
        return fArr3;
    }

    private float sum(float[] fArr) {
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    @Override // com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer
    public SonarProducer createSonarProducer(Context context, SonarConfig.SonarMethod sonarMethod, int i) {
        return new ChirpProducer(context, this.recorderContext.getSampleRate(), i, sonarMethod);
    }

    @Override // com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer
    public AbstractSonarConsumer.ConsumerResult processAndGetResult(float[] fArr) {
        System.currentTimeMillis();
        float[] data2 = AudioTransformer.from(this.recorderContext.getSampleRate(), fArr).iirFilterFactory(this.recorderContext.getIirFilterFactory()).highPassButterworthUltrasound().toData();
        float[] fArr2 = this.prevRecord;
        float fSum = fArr2 != null ? sum(abs(sub(data2, fArr2))) : 0.0f;
        float fSum2 = sum(abs(data2));
        this.prevRecord = Arrays.copyOf(data2, data2.length);
        AbstractSonarConsumer.ConsumerResult consumerResult = new AbstractSonarConsumer.ConsumerResult(fSum2, fSum);
        System.currentTimeMillis();
        return consumerResult;
    }
}
