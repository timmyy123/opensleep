package com.google.home.matter.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/serialization/Bitmap;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-s-VKNKU", "()J", "J", "get", "", "flag", "get-VKZWuLQ", "(J)Z", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Bitmap {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/google/home/matter/serialization/Bitmap$Companion;", "Lcom/google/home/matter/serialization/FieldAdapter;", "Lkotlin/ULong;", "Lcom/google/home/matter/serialization/Bitmap;", "<init>", "()V", "toRaw", SDKConstants.PARAM_VALUE, "toRaw-I7RO_PI", "(Lcom/google/home/matter/serialization/Bitmap;)J", "toRuntime", "toRuntime-VKZWuLQ", "(J)Lcom/google/home/matter/serialization/Bitmap;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements FieldAdapter<ULong, Bitmap> {
        private Companion() {
        }

        @Override // com.google.home.matter.serialization.FieldAdapter
        public /* bridge */ /* synthetic */ ULong toRaw(Bitmap bitmap) {
            return ULong.m2410boximpl(m527toRawI7RO_PI(bitmap));
        }

        /* JADX INFO: renamed from: toRaw-I7RO_PI, reason: not valid java name */
        public long m527toRawI7RO_PI(Bitmap value) {
            value.getClass();
            return value.getValue();
        }

        @Override // com.google.home.matter.serialization.FieldAdapter
        public /* bridge */ /* synthetic */ Bitmap toRuntime(ULong uLong) {
            return m528toRuntimeVKZWuLQ(uLong.getData());
        }

        /* JADX INFO: renamed from: toRuntime-VKZWuLQ, reason: not valid java name */
        public Bitmap m528toRuntimeVKZWuLQ(long value) {
            return new Bitmap(value, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Bitmap(long j) {
        this.value = j;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Bitmap) && getValue() == ((Bitmap) other).getValue();
    }

    /* JADX INFO: renamed from: get-VKZWuLQ, reason: not valid java name */
    public final boolean m525getVKZWuLQ(long flag) {
        return ULong.m2411constructorimpl(getValue() & flag) == flag;
    }

    /* JADX INFO: renamed from: getValue-s-VKNKU, reason: not valid java name and from getter */
    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return ULong.m2413hashCodeimpl(getValue());
    }

    public String toString() {
        String strM2414toStringimpl = ULong.m2414toStringimpl(getValue());
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(strM2414toStringimpl).length() + 14), "Bitmap(value=", strM2414toStringimpl, ")");
    }

    public /* synthetic */ Bitmap(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
