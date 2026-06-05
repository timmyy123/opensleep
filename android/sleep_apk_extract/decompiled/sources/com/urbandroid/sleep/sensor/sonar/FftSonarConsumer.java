package com.urbandroid.sleep.sensor.sonar;

import android.content.Context;
import com.urbandroid.sleep.audio.transform.AudioTransformer;
import com.urbandroid.sleep.audio.transform.FftResult;
import com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;
import com.urbandroid.util.ScienceUtil;

/* JADX INFO: loaded from: classes4.dex */
public class FftSonarConsumer extends AbstractSonarConsumer {
    private float[] lastColumn;

    public FftSonarConsumer(Context context, SonarConfig.SonarMethod sonarMethod) {
        super(context, sonarMethod);
    }

    @Override // com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer
    public SonarProducer createSonarProducer(Context context, SonarConfig.SonarMethod sonarMethod, int i) {
        return new ChirpProducer(this.context, this.recorderContext.getSampleRate(), i, sonarMethod);
    }

    @Override // com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer
    public AbstractSonarConsumer.ConsumerResult processAndGetResult(float[] fArr) {
        FftResult fftResult = AudioTransformer.from(this.recorderContext.getSampleRate(), fArr).fftFactory(this.recorderContext.getFftFactory()).iirFilterFactory(this.recorderContext.getIirFilterFactory()).highPassButterworthUltrasound().fft().toFftResult();
        int binByFrequency = fftResult.getBinByFrequency(20000.0d);
        int binByFrequency2 = fftResult.getBinByFrequency(22000.0d);
        float[] fArr2 = new float[(binByFrequency2 - binByFrequency) + 1];
        double d = 0.0d;
        for (int i = binByFrequency; i < binByFrequency2; i++) {
            float energy = fftResult.getEnergy(i);
            d += (double) energy;
            fArr2[i - binByFrequency] = energy;
        }
        float[] fArr3 = this.lastColumn;
        float fDeltaSum = fArr3 != null ? ScienceUtil.deltaSum(fArr2, fArr3) : 0.0f;
        this.lastColumn = fArr2;
        return new AbstractSonarConsumer.ConsumerResult(d, fDeltaSum);
    }
}
