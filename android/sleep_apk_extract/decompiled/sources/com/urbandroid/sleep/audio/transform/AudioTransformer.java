package com.urbandroid.sleep.audio.transform;

import biz.source_code.dsp.filter.FilterPassType;
import biz.source_code.dsp.filter.IirFilter;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.snoring.record.MonoSample;
import java.util.Arrays;
import org.jtransforms.fft.FloatFFT_1D;

/* JADX INFO: loaded from: classes4.dex */
public class AudioTransformer {
    private final AudioReadBuffer buffer;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private float[] f63data;
    private boolean dataChanged;
    private FftFactory fftFactory;
    private IirFilterFactory iirFilterFactory;
    private int sampleRate;

    public interface FftFactory {
        FloatFFT_1D create(int i);
    }

    public interface IirFilterFactory {
        IirFilter create(FilterPassType filterPassType, int i, float f, int i2);
    }

    private AudioTransformer(AudioReadBuffer audioReadBuffer, int i) {
        this.dataChanged = false;
        this.fftFactory = new FftFactory() { // from class: com.urbandroid.sleep.audio.transform.AudioTransformer.1
            @Override // com.urbandroid.sleep.audio.transform.AudioTransformer.FftFactory
            public FloatFFT_1D create(int i2) {
                return new FloatFFT_1D(i2);
            }
        };
        this.buffer = audioReadBuffer;
        this.sampleRate = i;
        this.f63data = audioReadBuffer.toFloat();
    }

    public static AudioTransformer from(int i, AudioReadBuffer audioReadBuffer) {
        return new AudioTransformer(audioReadBuffer, i);
    }

    public AudioTransformer copyData() {
        float[] fArr = this.f63data;
        this.f63data = Arrays.copyOf(fArr, fArr.length);
        return this;
    }

    public AudioTransformer decimate(int i) {
        if (i == 1) {
            return this;
        }
        int length = this.f63data.length / i;
        float[] fArr = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2] = this.f63data[i2 * i];
        }
        this.f63data = fArr;
        this.sampleRate /= i;
        this.dataChanged = true;
        return this;
    }

    public AudioTransformer fft(int i) {
        this.fftFactory.create(i).realForward(this.f63data);
        this.dataChanged = true;
        return this;
    }

    public AudioTransformer fftFactory(FftFactory fftFactory) {
        this.fftFactory = fftFactory;
        return this;
    }

    public AudioTransformer highPassButterworth(float f, int i) {
        if (this.iirFilterFactory == null) {
            this.iirFilterFactory = new BaseIirFilterFactory();
        }
        return passButterworth(this.iirFilterFactory.create(FilterPassType.highpass, this.sampleRate, f, i));
    }

    public AudioTransformer highPassButterworthUltrasound() {
        return highPassButterworth(17000.0f, 18);
    }

    public AudioTransformer iirFilterFactory(IirFilterFactory iirFilterFactory) {
        this.iirFilterFactory = iirFilterFactory;
        return this;
    }

    public AudioTransformer lowPass14K() {
        this.f63data = this.buffer.toLowPass14K(this.sampleRate, this.iirFilterFactory);
        this.dataChanged = true;
        return this;
    }

    public AudioTransformer lowPass5K() {
        this.f63data = this.buffer.toLowPass5K(this.sampleRate, this.iirFilterFactory);
        this.dataChanged = true;
        return this;
    }

    public AudioTransformer lowPass6K() {
        this.f63data = this.buffer.toLowPass6K(this.sampleRate, this.iirFilterFactory);
        this.dataChanged = true;
        return this;
    }

    public AudioTransformer lowPassButterworth(float f, int i) {
        if (this.iirFilterFactory == null) {
            this.iirFilterFactory = new BaseIirFilterFactory();
        }
        return passButterworth(this.iirFilterFactory.create(FilterPassType.lowpass, this.sampleRate, f, i));
    }

    public AudioTransformer passButterworth(IirFilter iirFilter) {
        int i = 0;
        while (true) {
            float[] fArr = this.f63data;
            if (i >= fArr.length) {
                this.dataChanged = true;
                return this;
            }
            fArr[i] = (float) iirFilter.step(fArr[i]);
            i++;
        }
    }

    public AudioTransformer resampleIP(int i) {
        int i2 = this.sampleRate;
        if (i2 == i) {
            return this;
        }
        this.f63data = new MonoSample(this.f63data, i2).reSampleIP(i).getSample();
        this.sampleRate = i;
        this.dataChanged = true;
        return this;
    }

    public float[] toData() {
        return this.f63data;
    }

    public FftResult toFftResult() {
        return new FftResult(this.f63data, this.sampleRate);
    }

    public static AudioTransformer from(int i, float[] fArr) {
        return new AudioTransformer(fArr, i);
    }

    public AudioTransformer fft() {
        return fft(this.f63data.length);
    }

    private AudioTransformer(float[] fArr, int i) {
        this.dataChanged = false;
        this.fftFactory = new FftFactory() { // from class: com.urbandroid.sleep.audio.transform.AudioTransformer.1
            @Override // com.urbandroid.sleep.audio.transform.AudioTransformer.FftFactory
            public FloatFFT_1D create(int i2) {
                return new FloatFFT_1D(i2);
            }
        };
        this.f63data = fArr;
        this.sampleRate = i;
        this.buffer = null;
    }
}
