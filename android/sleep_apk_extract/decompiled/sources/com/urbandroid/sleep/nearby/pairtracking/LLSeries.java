package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/LLSeries;", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;", "", "defaultValue", "", "initSize", "Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;", "keys", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "values", "<init>", "(JILcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;)V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LLSeries extends AppendableSeries<Long, Long> {
    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LLSeries(long j, int i, AscSortedAppendableArray ascSortedAppendableArray, AppendableArray appendableArray, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i2 & 1) != 0 ? 0L : j;
        int i3 = (i2 & 2) != 0 ? 1024 : i;
        this(j2, i3, (i2 & 4) != 0 ? new LongAscSortedAppendableArray(null, i3, 1, null) : ascSortedAppendableArray, (i2 & 8) != 0 ? new LongAppendableArray(null, i3, 1, null) : appendableArray);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LLSeries(long j, int i, AscSortedAppendableArray<Long> ascSortedAppendableArray, AppendableArray<Long> appendableArray) {
        super(Long.valueOf(j), ascSortedAppendableArray, appendableArray);
        ascSortedAppendableArray.getClass();
        appendableArray.getClass();
    }
}
