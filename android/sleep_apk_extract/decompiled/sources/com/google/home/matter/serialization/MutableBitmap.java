package com.google.home.matter.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/google/home/matter/serialization/MutableBitmap;", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-s-VKNKU", "()J", "setValue-VKZWuLQ", "(J)V", "J", "set", "", "flag", "", "set-4PLdz1A", "(JZ)V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableBitmap extends Bitmap {
    private long value;

    public /* synthetic */ MutableBitmap(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(1 == (i & 1) ? 0L : j, null);
    }

    @Override // com.google.home.matter.serialization.Bitmap
    /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
    public long getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: set-4PLdz1A, reason: not valid java name */
    public final void m564set4PLdz1A(long flag, boolean value) {
        long value2 = getValue();
        if (value) {
            m565setValueVKZWuLQ(ULong.m2411constructorimpl(flag | value2));
        } else {
            m565setValueVKZWuLQ(ULong.m2411constructorimpl(ULong.m2411constructorimpl(~flag) & value2));
        }
    }

    /* JADX INFO: renamed from: setValue-VKZWuLQ, reason: not valid java name */
    public void m565setValueVKZWuLQ(long j) {
        this.value = j;
    }

    private MutableBitmap(long j) {
        super(j, null);
        this.value = j;
    }

    public /* synthetic */ MutableBitmap(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
