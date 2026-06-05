package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\u0010\u0014\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B;\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u000e¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/LFSeries;", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;", "", "", "defaultValue", "initSize", "", "keys", "Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;", "values", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "<init>", "(FILcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;)V", "", "", "([J[F)V", "keysAsLongArray", "valuesAsFloatArray", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LFSeries extends AppendableSeries<Long, Float> {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ LFSeries(float f, int i, AscSortedAppendableArray ascSortedAppendableArray, AppendableArray appendableArray, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        f = (i2 & 1) != 0 ? 0.0f : f;
        i = (i2 & 2) != 0 ? 1024 : i;
        this(f, i, (i2 & 4) != 0 ? new LongAscSortedAppendableArray(null, i, 1, null) : ascSortedAppendableArray, (i2 & 8) != 0 ? new FloatAppendableArray(null, i, 1, 0 == true ? 1 : 0) : appendableArray);
    }

    public final long[] keysAsLongArray() {
        Object keys = getKeys();
        keys.getClass();
        return ((LongAppendableArray) keys).toPrimitiveArray();
    }

    public final float[] valuesAsFloatArray() {
        MyArray<Float> values = getValues();
        values.getClass();
        return ((FloatAppendableArray) values).toPrimitiveArray();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LFSeries(float f, int i, AscSortedAppendableArray<Long> ascSortedAppendableArray, AppendableArray<Float> appendableArray) {
        super(Float.valueOf(f), ascSortedAppendableArray, appendableArray);
        ascSortedAppendableArray.getClass();
        appendableArray.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LFSeries(long[] jArr, float[] fArr) {
        this(0.0f, 0, new LongAscSortedAppendableArray(jArr, 0, 2, null), new FloatAppendableArray(fArr, 0, 2, null), 3, null);
        jArr.getClass();
        fArr.getClass();
    }
}
