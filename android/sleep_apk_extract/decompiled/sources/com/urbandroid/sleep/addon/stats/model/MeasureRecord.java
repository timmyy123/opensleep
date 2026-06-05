package com.urbandroid.sleep.addon.stats.model;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureRecord implements IMeasureRecord {
    private double cycles;
    private int evidence;
    private float hr;
    private float hrv;
    private float hrvAfter;
    private float hrvBefore;
    private float hrvGain;
    private float irregularity;
    private float irregularityIndex;
    private float lengthInHours;
    private float minHr;
    private float noiseLevel;
    private float quality;
    private float rating;
    private int rdi;
    private int smart;
    private int snooze;
    private int snore;
    private float trackLengthInHours;

    public MeasureRecord(float f, float f2, float f3, float f4, int i, float f5, double d, int i2, int i3, int i4, float f6, float f7, float f8, float f9, int i5, float f10) {
        this.lengthInHours = f;
        this.trackLengthInHours = f2;
        this.rating = f3;
        this.quality = f4;
        this.snore = i;
        this.noiseLevel = f5;
        this.cycles = d;
        this.snooze = i2;
        this.smart = i3;
        this.evidence = i4;
        this.hrvAfter = f6;
        this.hrvBefore = f7;
        this.hrvGain = f8;
        this.hrv = f9;
        this.rdi = i5;
        this.irregularity = f10;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public double getCycles() {
        return this.cycles;
    }

    public int getEvidence() {
        return this.evidence;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHr() {
        return this.hr;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrv() {
        return this.hrv;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrvAfter() {
        return this.hrvAfter;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrvBefore() {
        return this.hrvBefore;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getIrregularityInMinutes() {
        return this.irregularity;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getIrregularityIndex() {
        return this.irregularityIndex;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getLengthInHours() {
        return this.lengthInHours;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getMinHr() {
        return this.minHr;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getNoiseLevel() {
        return this.noiseLevel;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getQuality() {
        return this.quality;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getRating() {
        return this.rating;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getRdi() {
        return this.rdi;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSmart() {
        return this.smart;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSnooze() {
        return this.snooze;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSnore() {
        return this.snore;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getTrackLengthInHours() {
        return this.trackLengthInHours;
    }
}
