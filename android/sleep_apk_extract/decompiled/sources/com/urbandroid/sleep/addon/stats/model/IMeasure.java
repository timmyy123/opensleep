package com.urbandroid.sleep.addon.stats.model;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;

/* JADX INFO: loaded from: classes4.dex */
public interface IMeasure {
    IValueExtractor getExtractor(Context context);

    IValueExtractor getSecondaryExtractor(Context context);

    boolean isWeighted();
}
