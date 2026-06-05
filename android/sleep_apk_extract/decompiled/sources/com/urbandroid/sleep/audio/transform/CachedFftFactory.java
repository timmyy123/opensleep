package com.urbandroid.sleep.audio.transform;

import com.urbandroid.sleep.audio.transform.AudioTransformer;
import java.util.HashMap;
import java.util.Map;
import org.jtransforms.fft.FloatFFT_1D;

/* JADX INFO: loaded from: classes4.dex */
public class CachedFftFactory implements AudioTransformer.FftFactory {
    private final Map<Integer, FloatFFT_1D> cache = new HashMap();

    @Override // com.urbandroid.sleep.audio.transform.AudioTransformer.FftFactory
    public FloatFFT_1D create(int i) {
        FloatFFT_1D floatFFT_1D = this.cache.get(Integer.valueOf(i));
        if (floatFFT_1D != null) {
            return floatFFT_1D;
        }
        FloatFFT_1D floatFFT_1D2 = new FloatFFT_1D(i);
        this.cache.put(Integer.valueOf(i), floatFFT_1D2);
        return floatFFT_1D2;
    }
}
