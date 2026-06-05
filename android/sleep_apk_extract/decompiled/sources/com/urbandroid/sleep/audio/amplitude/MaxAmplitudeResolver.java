package com.urbandroid.sleep.audio.amplitude;

import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.transform.AudioTransformer;

/* JADX INFO: loaded from: classes4.dex */
public class MaxAmplitudeResolver {
    private boolean doLowPassFilter;
    private final AudioTransformer.IirFilterFactory iirFilterFactory;

    public MaxAmplitudeResolver(boolean z, AudioTransformer.IirFilterFactory iirFilterFactory) {
        this.doLowPassFilter = z;
        this.iirFilterFactory = iirFilterFactory;
    }

    public float getAmplitude(AudioReadBuffer audioReadBuffer, int i) {
        if (audioReadBuffer.length() == 0) {
            return 0.0f;
        }
        int length = audioReadBuffer.length() / 5;
        float[] lowPass5K = this.doLowPassFilter ? audioReadBuffer.toLowPass5K(i, this.iirFilterFactory) : audioReadBuffer.toFloat();
        int i2 = 0;
        float f = 0.0f;
        while (i2 < 5) {
            i2++;
            int iMin = Math.min(i2 * length, audioReadBuffer.length());
            float f2 = 0.0f;
            for (int i3 = i2 * length; i3 < iMin; i3++) {
                float fAbs = Math.abs(lowPass5K[i3]);
                if (fAbs > f2) {
                    f2 = fAbs;
                }
            }
            float f3 = f2 * 32767.0f;
            audioReadBuffer.addMaxAmplitude(f3);
            if (f3 > f) {
                f = f3;
            }
        }
        return f;
    }
}
