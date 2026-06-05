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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!R$\u0010\n\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010\u000bR$\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00048\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u001c¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/FloatAppendableArray;", "Lcom/urbandroid/sleep/nearby/pairtracking/ArrayBase;", "", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "", "initValues", "", "initSize", "<init>", "([FI)V", "size", "()I", "i", "get", "(I)Ljava/lang/Float;", "x", "", "add", "(F)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "separator", "prefix", "postfix", "joinToString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "toPrimitiveArray", "()[F", "copyOf", "()Lcom/urbandroid/sleep/nearby/pairtracking/FloatAppendableArray;", "from", "tail", "(I)Lcom/urbandroid/sleep/nearby/pairtracking/FloatAppendableArray;", SDKConstants.PARAM_VALUE, "I", "getSize", "values", "[F", "getValues", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FloatAppendableArray extends ArrayBase<Float> implements AppendableArray<Float> {
    private int size;
    private float[] values;

    public FloatAppendableArray(float[] fArr, int i) {
        fArr.getClass();
        if (fArr.length != 0) {
            this.values = fArr;
            this.size = fArr.length;
        } else {
            if (i < 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(String.valueOf(i));
                throw null;
            }
            this.values = new float[i];
            this.size = 0;
        }
    }

    public static /* synthetic */ String joinToString$default(FloatAppendableArray floatAppendableArray, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        if ((i & 2) != 0) {
            str2 = "[";
        }
        if ((i & 4) != 0) {
            str3 = "]";
        }
        return floatAppendableArray.joinToString(str, str2, str3);
    }

    public void add(float x) {
        int i = this.size;
        float[] fArr = this.values;
        if (i == fArr.length) {
            float[] fArr2 = new float[(int) (((double) (i + 1)) * 1.5d)];
            this.values = fArr2;
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        }
        float[] fArr3 = this.values;
        int i2 = this.size;
        fArr3[i2] = x;
        this.size = i2 + 1;
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.AppendableArray
    public AppendableArray<Float> copyOf() {
        return new FloatAppendableArray(toPrimitiveArray(), 0, 2, null);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public Float get(int i) {
        if (i >= 0 && i < this.size) {
            return Float.valueOf(this.values[i]);
        }
        Events$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, this.size, "i: ", ", size: "));
        return null;
    }

    public final String joinToString(String separator, String prefix, String postfix) {
        separator.getClass();
        prefix.getClass();
        postfix.getClass();
        return ArraysKt___ArraysKt.joinToString$default(toPrimitiveArray(), separator, prefix, postfix, 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    /* JADX INFO: renamed from: size, reason: from getter */
    public int getSize() {
        return this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public FloatAppendableArray tail(int from) {
        int i = this.size;
        int i2 = 0;
        return from >= i ? new FloatAppendableArray(null, i2, 3, 0 == true ? 1 : 0) : new FloatAppendableArray(ArraysKt.copyOfRange(this.values, from, i), i2, 2, 0 == true ? 1 : 0);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public float[] toPrimitiveArray() {
        return ArraysKt.sliceArray(this.values, RangesKt.until(0, this.size));
    }

    public String toString() {
        return joinToString$default(this, null, null, null, 7, null);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.AppendableArray
    public /* bridge */ /* synthetic */ void add(Float f) {
        add(f.floatValue());
    }

    public /* synthetic */ FloatAppendableArray(float[] fArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new float[0] : fArr, (i2 & 2) != 0 ? 1024 : i);
    }
}
