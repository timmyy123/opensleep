package com.urbandroid.sleep.snoring.classifier.tfv3;

import com.urbandroid.sleep.snoring.record.MonoSample;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioBuffer;", "", "sampleRate", "", "maxLengthSeconds", "", "<init>", "(ID)V", "buffer", "", "maxLength", "add", "", "data", "getLatest", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "lengthSeconds", "getAll", "getLengthSeconds", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioBuffer {
    private float[] buffer = new float[0];
    private int maxLength;
    private final double maxLengthSeconds;
    private final int sampleRate;

    public AudioBuffer(int i, double d) {
        this.sampleRate = i;
        this.maxLengthSeconds = d;
        this.maxLength = (int) Math.rint(((double) i) * d);
    }

    public final void add(float[] data2) {
        data2.getClass();
        float[] fArrPlus = ArraysKt.plus(this.buffer, data2);
        this.buffer = fArrPlus;
        int length = fArrPlus.length;
        int i = this.maxLength;
        if (length > i) {
            this.buffer = ArraysKt.sliceArray(fArrPlus, RangesKt.until(fArrPlus.length - i, fArrPlus.length));
        }
    }

    public final MonoSample getAll() {
        return new MonoSample(this.buffer, this.sampleRate);
    }

    public final MonoSample getLatest(double lengthSeconds) {
        if (lengthSeconds > getLengthSeconds()) {
            return getAll();
        }
        int iRint = (int) Math.rint(lengthSeconds * ((double) this.sampleRate));
        float[] fArr = this.buffer;
        return new MonoSample(ArraysKt.sliceArray(fArr, RangesKt.until(fArr.length - iRint, fArr.length)), this.sampleRate);
    }

    public final double getLengthSeconds() {
        return ((double) this.buffer.length) / ((double) this.sampleRate);
    }
}
