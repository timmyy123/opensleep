package com.urbandroid.sleep.nearby.pairtracking;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J$\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u0018J\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0007H\u0016R\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/LongAppendableArray;", "Lcom/urbandroid/sleep/nearby/pairtracking/ArrayBase;", "", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "initValues", "", "initSize", "", "<init>", "([JI)V", SDKConstants.PARAM_VALUE, "size", "getSize", "()I", "values", "getValues", "()[J", "get", "i", "(I)Ljava/lang/Long;", "add", "", "x", InAppPurchaseConstants.METHOD_TO_STRING, "", "joinToString", "separator", "prefix", "postfix", "toArray", "", "()[Ljava/lang/Long;", "toPrimitiveArray", "copyOf", "tail", "from", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class LongAppendableArray extends ArrayBase<Long> implements AppendableArray<Long> {
    private int size;
    private long[] values;

    public LongAppendableArray(long[] jArr, int i) {
        jArr.getClass();
        if (jArr.length != 0) {
            this.values = jArr;
            this.size = jArr.length;
        } else {
            if (i < 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(String.valueOf(i));
                throw null;
            }
            this.values = new long[i];
            this.size = 0;
        }
    }

    public static /* synthetic */ String joinToString$default(LongAppendableArray longAppendableArray, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: joinToString");
            return null;
        }
        if ((i & 1) != 0) {
            str = ", ";
        }
        if ((i & 2) != 0) {
            str2 = "[";
        }
        if ((i & 4) != 0) {
            str3 = "]";
        }
        return longAppendableArray.joinToString(str, str2, str3);
    }

    public void add(long x) {
        int i = this.size;
        long[] jArr = this.values;
        if (i == jArr.length) {
            long[] jArr2 = new long[(int) (((double) (i + 1)) * 1.5d)];
            this.values = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        }
        long[] jArr3 = this.values;
        int i2 = this.size;
        jArr3[i2] = x;
        this.size = i2 + 1;
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.AppendableArray
    public AppendableArray<Long> copyOf() {
        return new LongAppendableArray(toPrimitiveArray(), 0, 2, null);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public Long get(int i) {
        if (i >= 0 && i < this.size) {
            return Long.valueOf(this.values[i]);
        }
        Events$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, this.size, "i: ", ", size: "));
        return null;
    }

    public final int getSize() {
        return this.size;
    }

    public final long[] getValues() {
        return this.values;
    }

    public final String joinToString(String separator, String prefix, String postfix) {
        separator.getClass();
        prefix.getClass();
        postfix.getClass();
        return ArraysKt___ArraysKt.joinToString$default(toPrimitiveArray(), (CharSequence) separator, (CharSequence) prefix, (CharSequence) postfix, 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public int size() {
        return this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public LongAppendableArray tail(int from) {
        int i = this.size;
        int i2 = 0;
        return from >= i ? new LongAppendableArray(null, i2, 3, 0 == true ? 1 : 0) : new LongAppendableArray(ArraysKt.copyOfRange(this.values, from, i), i2, 2, 0 == true ? 1 : 0);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public Long[] toArray() {
        return ArraysKt.toTypedArray(toPrimitiveArray());
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public long[] toPrimitiveArray() {
        return ArraysKt.sliceArray(this.values, RangesKt.until(0, this.size));
    }

    public String toString() {
        return joinToString$default(this, null, null, null, 7, null);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.AppendableArray
    public /* bridge */ /* synthetic */ void add(Long l) {
        add(l.longValue());
    }

    public /* synthetic */ LongAppendableArray(long[] jArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new long[0] : jArr, (i2 & 2) != 0 ? 1024 : i);
    }
}
