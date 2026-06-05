package com.urbandroid.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.TimeType;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0088\u0001\u0002¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/common/Millis;", "Lcom/urbandroid/common/TimeType;", SDKConstants.PARAM_VALUE, "", "constructor-impl", "(J)J", "unit", "Ljava/util/concurrent/TimeUnit;", "getUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "getValue", "()J", "equals", "", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Millis implements TimeType {
    private final long value;

    private /* synthetic */ Millis(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Millis m972boximpl(long j) {
        return new Millis(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m973constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m974equalsimpl(long j, Object obj) {
        return (obj instanceof Millis) && j == ((Millis) obj).m980unboximpl();
    }

    /* JADX INFO: renamed from: getHours-impl, reason: not valid java name */
    public static long m975getHoursimpl(long j) {
        return m972boximpl(j).getHours();
    }

    /* JADX INFO: renamed from: getMinutes-impl, reason: not valid java name */
    public static long m976getMinutesimpl(long j) {
        return m972boximpl(j).getMinutes();
    }

    /* JADX INFO: renamed from: getUnit-impl, reason: not valid java name */
    public static TimeUnit m977getUnitimpl(long j) {
        return TimeUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m978hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m979toStringimpl(long j) {
        return "Millis(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m974equalsimpl(this.value, obj);
    }

    public long getHours() {
        return TimeType.DefaultImpls.getHours(this);
    }

    @Override // com.urbandroid.common.TimeType
    public long getMillis() {
        return TimeType.DefaultImpls.getMillis(this);
    }

    @Override // com.urbandroid.common.TimeType
    public long getMinutes() {
        return TimeType.DefaultImpls.getMinutes(this);
    }

    @Override // com.urbandroid.common.TimeType
    public TimeUnit getUnit() {
        return m977getUnitimpl(this.value);
    }

    @Override // com.urbandroid.common.TimeType
    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return m978hashCodeimpl(this.value);
    }

    public String toString() {
        return m979toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m980unboximpl() {
        return this.value;
    }
}
