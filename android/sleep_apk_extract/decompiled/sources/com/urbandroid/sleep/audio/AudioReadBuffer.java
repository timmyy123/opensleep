package com.urbandroid.sleep.audio;

import com.urbandroid.sleep.audio.transform.AudioTransformer;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AudioReadBuffer {
    private final byte[] buffer;
    private float[] floatValues;
    private final int length;
    private float[] lowPassData;
    private List<Float> maxAmplitudes = new LinkedList();
    private final long readTimestamp;

    public AudioReadBuffer(byte[] bArr, int i, long j) {
        if (i < 0 || i > bArr.length / 2) {
            Events$$ExternalSyntheticBUOutline0.m(i, bArr.length, " ");
            throw null;
        }
        this.buffer = bArr;
        this.length = i;
        this.readTimestamp = j;
    }

    private synchronized float[] toLowPass(int i, AudioTransformer.IirFilterFactory iirFilterFactory, float f, int i2) {
        try {
            toFloat();
            if (this.lowPassData == null) {
                this.lowPassData = AudioTransformer.from(i, this.floatValues).copyData().iirFilterFactory(iirFilterFactory).lowPassButterworth(f, i2).toData();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.lowPassData;
    }

    public synchronized void addMaxAmplitude(float f) {
        this.maxAmplitudes.add(Float.valueOf(f));
    }

    public synchronized List<Float> getMaxAmplitudes() {
        return this.maxAmplitudes;
    }

    @Deprecated
    public byte[] getRawData() {
        return this.buffer;
    }

    public long getReadTimestamp() {
        return this.readTimestamp;
    }

    public int length() {
        return this.length;
    }

    public synchronized float[] toFloat() {
        try {
            if (this.floatValues == null) {
                this.floatValues = new float[this.length];
                for (int i = 0; i < this.length; i++) {
                    float[] fArr = this.floatValues;
                    byte[] bArr = this.buffer;
                    int i2 = i * 2;
                    fArr[i] = ((short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8))) / 32767.0f;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.floatValues;
    }

    public synchronized float[] toLowPass14K(int i, AudioTransformer.IirFilterFactory iirFilterFactory) {
        return toLowPass(i, iirFilterFactory, 14000.0f, 8);
    }

    public synchronized float[] toLowPass5K(int i, AudioTransformer.IirFilterFactory iirFilterFactory) {
        return toLowPass(i, iirFilterFactory, 5000.0f, 8);
    }

    public synchronized float[] toLowPass6K(int i, AudioTransformer.IirFilterFactory iirFilterFactory) {
        return toLowPass(i, iirFilterFactory, 6000.0f, 8);
    }

    public short[] toShort() {
        short[] sArr = new short[this.length];
        for (int i = 0; i < this.length; i++) {
            byte[] bArr = this.buffer;
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8));
        }
        return sArr;
    }
}
