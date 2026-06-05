package com.urbandroid.sleep.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRecordDataFilter {
    private final FilterFunction filterFunction;
    private final int maxResultDataLength;

    public enum FilterType {
        ACCEL,
        WATCH,
        SONAR
    }

    public SleepRecordDataFilter(int i, FilterFunction filterFunction) {
        if (i < 10) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Minimal maxLength is 10.");
            throw null;
        }
        this.maxResultDataLength = i;
        this.filterFunction = filterFunction;
    }

    private float[] filterFunctionAlternative(float[] fArr, int i) {
        return this.filterFunction.filter(fArr, i, this.maxResultDataLength);
    }

    public static SleepRecordDataFilter getPresentationFilter(int i, FilterType filterType) {
        return new SleepRecordDataFilter(i, new PresentationFilterFunction(filterType == FilterType.WATCH || filterType == FilterType.SONAR));
    }

    public List<Float> filter(float[] fArr) {
        LinkedList linkedList = new LinkedList();
        int length = fArr.length;
        int i = this.maxResultDataLength;
        int i2 = 0;
        if (length <= i) {
            int length2 = fArr.length;
            while (i2 < length2) {
                linkedList.add(Float.valueOf(fArr[i2]));
                i2++;
            }
        } else {
            float[] fArrFilterFunctionAlternative = filterFunctionAlternative(fArr, (fArr.length / i) + 1);
            while (i2 < fArrFilterFunctionAlternative.length) {
                linkedList.add(Float.valueOf(fArrFilterFunctionAlternative[i2]));
                i2++;
            }
        }
        return linkedList;
    }

    public static SleepRecordDataFilter getPresentationFilter(int i, boolean z) {
        return getPresentationFilter(i, z ? FilterType.WATCH : FilterType.ACCEL);
    }

    public static SleepRecordDataFilter getPresentationFilter(int i) {
        return getPresentationFilter(i, false);
    }

    public List<Float> filter(List<Float> list) {
        if (list.size() <= this.maxResultDataLength) {
            return list;
        }
        float[] fArr = new float[list.size()];
        Iterator<Float> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            Float next = it.next();
            if (next != null) {
                fArr[i] = next.floatValue();
            }
        }
        return filter(fArr);
    }
}
