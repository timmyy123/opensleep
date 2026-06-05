package com.urbandroid.sleep.snoring.tensorflow.mfcc;

import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.newfftresult.FftResultEnergyOnly;
import com.urbandroid.sleep.snoring.newfftresult.FftResultRaw;
import com.urbandroid.sleep.snoring.record.MonoSample;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import org.jtransforms.fft.FloatFFT_1D;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\f\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelSpectrum;", "", "Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelSpectrumConfig;", "config", "<init>", "(Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelSpectrumConfig;)V", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "sample", "", "process", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)[F", "Lcom/urbandroid/sleep/snoring/newfftresult/FftResultRaw;", "fft", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Lcom/urbandroid/sleep/snoring/newfftresult/FftResultRaw;", "Lcom/urbandroid/sleep/snoring/newfftresult/FftResult;", "energySpectrum", "", "sampleRate", "Lcom/urbandroid/sleep/snoring/newfftresult/FftResultEnergyOnly;", "getPowerSpectrum", "(Lcom/urbandroid/sleep/snoring/newfftresult/FftResult;I)Lcom/urbandroid/sleep/snoring/newfftresult/FftResultEnergyOnly;", "mels", "logMels", "([F)[F", "", "f", "robustLog", "(F)F", "Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelSpectrumConfig;", "getConfig", "()Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelSpectrumConfig;", "Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/HammingWindow;", "hamming", "Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/HammingWindow;", "getHamming", "()Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/HammingWindow;", "Lorg/jtransforms/fft/FloatFFT_1D;", "Lorg/jtransforms/fft/FloatFFT_1D;", "getFft", "()Lorg/jtransforms/fft/FloatFFT_1D;", "Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelFilterbank;", "melFilterbank", "Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelFilterbank;", "getMelFilterbank", "()Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelFilterbank;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelSpectrum {
    private final MelSpectrumConfig config;
    private final FloatFFT_1D fft;
    private final HammingWindow hamming;
    private final MelFilterbank melFilterbank;

    public MelSpectrum(MelSpectrumConfig melSpectrumConfig) {
        melSpectrumConfig.getClass();
        this.config = melSpectrumConfig;
        this.hamming = new HammingWindow(melSpectrumConfig.getFrameSize());
        this.fft = new FloatFFT_1D(melSpectrumConfig.getFrameSize());
        this.melFilterbank = new MelFilterbank(melSpectrumConfig.getNoMelBands(), melSpectrumConfig.getFrameSize() / 2, melSpectrumConfig.getSampleRate(), melSpectrumConfig.getMinFreq(), melSpectrumConfig.getMaxFreq());
    }

    public final FftResultRaw fft(MonoSample sample) {
        sample.getClass();
        float[] sample2 = sample.getSample();
        this.fft.realForward(sample2);
        return new FftResultRaw(sample2, sample.getSampleRate());
    }

    public final FftResultEnergyOnly getPowerSpectrum(FftResult energySpectrum, int sampleRate) {
        energySpectrum.getClass();
        float[] energies = energySpectrum.getEnergies();
        int length = energies.length;
        for (int i = 0; i < length; i++) {
            float f = energies[i];
            energies[i] = (f * f) / length;
        }
        return new FftResultEnergyOnly(energies, sampleRate);
    }

    public final float[] logMels(float[] mels) {
        mels.getClass();
        float[] fArr = new float[mels.length];
        int length = mels.length;
        for (int i = 0; i < length; i++) {
            fArr[i] = robustLog(mels[i]);
        }
        return fArr;
    }

    public final float[] process(MonoSample sample) {
        sample.getClass();
        if (sample.getSampleRate() != this.config.getSampleRate()) {
            Events$$ExternalSyntheticBUOutline0.m(sample.getSampleRate(), this.config.getSampleRate(), " != ");
            return null;
        }
        if (sample.size() != this.config.getFrameSize()) {
            Events$$ExternalSyntheticBUOutline0.m(sample.size(), this.config.getFrameSize(), " != ");
            return null;
        }
        float[] fArrProcess = this.melFilterbank.process(getPowerSpectrum(fft(new MonoSample(this.hamming.process(sample.getSample()), sample.getSampleRate())), sample.getSampleRate()));
        fArrProcess.getClass();
        return logMels(fArrProcess);
    }

    public final float robustLog(float f) {
        if (f == 0.0f) {
            return -30.0f;
        }
        return Math.max((float) Math.log(f), -30.0f);
    }
}
