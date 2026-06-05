package com.urbandroid.common;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/common/TimeType;", "", "", "getValue", "()J", SDKConstants.PARAM_VALUE, "Ljava/util/concurrent/TimeUnit;", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "unit", "getMillis", "millis", "getMinutes", "minutes", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TimeType {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static long getHours(TimeType timeType) {
            return timeType.getUnit().toHours(timeType.getValue());
        }

        public static long getMillis(TimeType timeType) {
            return timeType.getUnit().toMillis(timeType.getValue());
        }

        public static long getMinutes(TimeType timeType) {
            return timeType.getUnit().toMinutes(timeType.getValue());
        }
    }

    long getMillis();

    long getMinutes();

    TimeUnit getUnit();

    long getValue();
}
