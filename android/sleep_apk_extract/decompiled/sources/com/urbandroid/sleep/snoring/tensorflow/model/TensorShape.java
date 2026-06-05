package com.urbandroid.sleep.snoring.tensorflow.model;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/model/TensorShape;", "", "", "", "sizes", "<init>", "([I)V", "getTotalSize", "()I", "[I", "getSizes", "()[I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TensorShape {
    private final int[] sizes;

    public TensorShape(int... iArr) {
        iArr.getClass();
        this.sizes = iArr;
    }

    public final int getTotalSize() {
        int[] iArr = this.sizes;
        if (iArr.length == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m("Empty array can't be reduced.");
            return 0;
        }
        int i = iArr[0];
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                i *= iArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }
}
