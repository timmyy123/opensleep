package com.urbandroid.sleep.service.health.session;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
public final class SegmentNormalizationKt$ordered$$inlined$sortedBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Long.valueOf(((HealthSessionSegment) t).getFromInMillis()), Long.valueOf(((HealthSessionSegment) t2).getFromInMillis()));
    }
}
