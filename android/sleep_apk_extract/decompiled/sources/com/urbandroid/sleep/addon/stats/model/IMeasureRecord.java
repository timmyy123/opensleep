package com.urbandroid.sleep.addon.stats.model;

/* JADX INFO: loaded from: classes4.dex */
public interface IMeasureRecord {
    double getCycles();

    float getHr();

    float getHrv();

    float getHrvAfter();

    float getHrvBefore();

    float getIrregularityInMinutes();

    float getIrregularityIndex();

    float getLengthInHours();

    float getMinHr();

    float getNoiseLevel();

    float getQuality();

    float getRating();

    int getRdi();

    int getSmart();

    int getSnooze();

    int getSnore();

    float getTrackLengthInHours();
}
