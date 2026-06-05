package com.urbandroid.sleep.snoring.record;

import com.urbandroid.util.ScienceUtil;

/* JADX INFO: loaded from: classes5.dex */
public class DownsampleAndMovingMax implements Function {
    private final int decimateFactor;
    private final double movingMaxIntervalSecs;
    private final String targetKey;

    public DownsampleAndMovingMax(String str, int i, double d) {
        this.targetKey = str;
        this.decimateFactor = i;
        this.movingMaxIntervalSecs = d;
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record record) {
        MonoSample monoSampleDownSample = ((MonoSample) record.get("SAMPLE")).downSample(this.decimateFactor);
        ScienceUtil.inPlaceMovingMax(monoSampleDownSample.getSample(), (int) (((double) monoSampleDownSample.getSampleRate()) * this.movingMaxIntervalSecs));
        record.set(this.targetKey, monoSampleDownSample);
        return record;
    }
}
