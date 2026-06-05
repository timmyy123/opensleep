package com.urbandroid.sleep.snoring.newfftresult;

import com.urbandroid.sleep.audio.transform.CachedFftFactory;
import com.urbandroid.sleep.snoring.record.MonoSample;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FFT {
    private static CachedFftFactory fftFactory = new CachedFftFactory();

    public static FftResult fft(MonoSample monoSample) {
        int size = monoSample.size();
        float[] fArrCopyOf = Arrays.copyOf(monoSample.getSample(), size);
        fftFactory.create(size).realForward(fArrCopyOf);
        return new FftResultRaw(fArrCopyOf, monoSample.getSampleRate());
    }
}
