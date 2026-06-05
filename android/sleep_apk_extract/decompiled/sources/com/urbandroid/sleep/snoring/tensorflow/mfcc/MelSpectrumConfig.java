package com.urbandroid.sleep.snoring.tensorflow.mfcc;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/mfcc/MelSpectrumConfig;", "", "", "frameSize", "sampleRate", "noMelBands", "", "minFreq", "maxFreq", "<init>", "(IIIFF)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFrameSize", "getSampleRate", "getNoMelBands", "F", "getMinFreq", "()F", "getMaxFreq", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MelSpectrumConfig {
    private final int frameSize;
    private final float maxFreq;
    private final float minFreq;
    private final int noMelBands;
    private final int sampleRate;

    public MelSpectrumConfig(int i, int i2, int i3, float f, float f2) {
        this.frameSize = i;
        this.sampleRate = i2;
        this.noMelBands = i3;
        this.minFreq = f;
        this.maxFreq = f2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MelSpectrumConfig)) {
            return false;
        }
        MelSpectrumConfig melSpectrumConfig = (MelSpectrumConfig) other;
        return this.frameSize == melSpectrumConfig.frameSize && this.sampleRate == melSpectrumConfig.sampleRate && this.noMelBands == melSpectrumConfig.noMelBands && Float.compare(this.minFreq, melSpectrumConfig.minFreq) == 0 && Float.compare(this.maxFreq, melSpectrumConfig.maxFreq) == 0;
    }

    public final int getFrameSize() {
        return this.frameSize;
    }

    public final float getMaxFreq() {
        return this.maxFreq;
    }

    public final float getMinFreq() {
        return this.minFreq;
    }

    public final int getNoMelBands() {
        return this.noMelBands;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return Float.hashCode(this.maxFreq) + Fragment$$ExternalSyntheticOutline1.m(this.minFreq, FileInsert$$ExternalSyntheticOutline0.m(this.noMelBands, FileInsert$$ExternalSyntheticOutline0.m(this.sampleRate, Integer.hashCode(this.frameSize) * 31, 31), 31), 31);
    }

    public String toString() {
        int i = this.frameSize;
        int i2 = this.sampleRate;
        int i3 = this.noMelBands;
        float f = this.minFreq;
        float f2 = this.maxFreq;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "MelSpectrumConfig(frameSize=", ", sampleRate=", ", noMelBands=");
        sbM.append(i3);
        sbM.append(", minFreq=");
        sbM.append(f);
        sbM.append(", maxFreq=");
        sbM.append(f2);
        sbM.append(")");
        return sbM.toString();
    }
}
