package com.urbandroid.sleep.snoring.tensorflow.model;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.util.ScienceUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001e¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "", "", "", "rows", "<init>", "([[F)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "size", "()I", "rowSize", "minTargetSize", "rightPadX", "(I)Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "start", "end", "sliceX", "(II)Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "t", "concatenateX", "(Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;)Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "flatten", "()[F", "concatenateZAndFlatten", "(Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;)[F", "normalize", "()Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "[[F", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Tensor2D {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float[][] rows;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D$Companion;", "", "<init>", "()V", "", "xSize", "ySize", "Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "zeros", "(II)Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "", "row", "count", "tileY", "([FI)Lcom/urbandroid/sleep/snoring/tensorflow/model/Tensor2D;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Tensor2D tileY(float[] row, int count) {
            row.getClass();
            int length = row.length;
            float[][] fArr = new float[length][];
            for (int i = 0; i < length; i++) {
                float[] fArr2 = new float[count];
                Arrays.fill(fArr2, row[i]);
                fArr[i] = fArr2;
            }
            return new Tensor2D(fArr);
        }

        public final Tensor2D zeros(int xSize, int ySize) {
            float[][] fArr = new float[xSize][];
            for (int i = 0; i < xSize; i++) {
                fArr[i] = new float[ySize];
            }
            return new Tensor2D(fArr);
        }

        private Companion() {
        }
    }

    public Tensor2D(float[][] fArr) {
        fArr.getClass();
        this.rows = fArr;
        if (fArr.length == 0) {
            return;
        }
        int length = fArr[0].length;
        for (float[] fArr2 : fArr) {
            if (fArr2.length != length) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(length, this.rows.length, "All rows must have the same size: ", ", "));
                throw null;
            }
        }
    }

    public final Tensor2D concatenateX(Tensor2D t) {
        t.getClass();
        if (rowSize() == t.rowSize()) {
            return new Tensor2D((float[][]) ArraysKt.plus(this.rows, t.rows));
        }
        Events$$ExternalSyntheticBUOutline0.m(rowSize(), t.rowSize(), " != ");
        return null;
    }

    public final float[] concatenateZAndFlatten(Tensor2D t) {
        t.getClass();
        if (rowSize() != t.rowSize()) {
            Events$$ExternalSyntheticBUOutline0.m(rowSize(), t.rowSize(), " != ");
            return null;
        }
        if (size() != t.size()) {
            Events$$ExternalSyntheticBUOutline0.m(size(), t.size(), " != ");
            return null;
        }
        int size = size();
        int iRowSize = rowSize();
        float[] fArr = new float[size * iRowSize * 2];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            for (int i3 = 0; i3 < iRowSize; i3++) {
                int i4 = i + 1;
                fArr[i] = this.rows[i2][i3];
                i += 2;
                fArr[i4] = t.rows[i2][i3];
            }
        }
        return fArr;
    }

    public final float[] flatten() {
        int size = size();
        int iRowSize = rowSize();
        float[] fArr = new float[size * iRowSize];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = 0;
            while (i3 < iRowSize) {
                fArr[i] = this.rows[i2][i3];
                i3++;
                i++;
            }
        }
        return fArr;
    }

    public final Tensor2D normalize() {
        float fAvg = ScienceUtil.avg(flatten());
        float fStddev = ScienceUtil.stddev(flatten()) + 0.001f;
        float[][] fArr = new float[size()][];
        int size = size();
        for (int i = 0; i < size; i++) {
            float[] fArr2 = this.rows[i];
            ArrayList arrayList = new ArrayList(fArr2.length);
            for (float f : fArr2) {
                arrayList.add(Float.valueOf((f - fAvg) / fStddev));
            }
            fArr[i] = CollectionsKt.toFloatArray(arrayList);
        }
        return new Tensor2D(fArr);
    }

    public final Tensor2D rightPadX(int minTargetSize) {
        return size() >= minTargetSize ? this : concatenateX(INSTANCE.zeros(minTargetSize - size(), rowSize()));
    }

    public final int rowSize() {
        float[][] fArr = this.rows;
        if (fArr.length == 0) {
            return 0;
        }
        return fArr[0].length;
    }

    public final int size() {
        return this.rows.length;
    }

    public final Tensor2D sliceX(int start, int end) {
        return new Tensor2D((float[][]) ArraysKt.copyOfRange(this.rows, start, end));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (float[] fArr : this.rows) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(ArraysKt.toList(fArr));
        }
        return "[" + ((Object) sb) + "]";
    }
}
