package com.urbandroid.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u0015\u0010\n\u001a\u00020\b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0003\"\u0015\u0010\r\u001a\u00020\u000b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0003\"\u0015\u0010\u0012\u001a\u00020\u000f*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "Lcom/urbandroid/common/Days;", "getDays", "(I)J", "Days", "Lcom/urbandroid/common/Hours;", "getHours", "Hours", "Lcom/urbandroid/common/Minutes;", "getMinutes", "Minutes", "Lcom/urbandroid/common/Seconds;", "getSeconds", "Seconds", "", "Lcom/urbandroid/common/Millis;", "getMillis", "(J)J", "Millis", "common_release"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "com/urbandroid/common/Utils")
abstract /* synthetic */ class Utils__TimetypesKt {
    public static final long getDays(int i) {
        return Days.m957constructorimpl(i);
    }

    public static final long getHours(int i) {
        return Hours.m965constructorimpl(i);
    }

    public static final long getMillis(long j) {
        return Millis.m973constructorimpl(j);
    }

    public static final long getMinutes(int i) {
        return Minutes.m982constructorimpl(i);
    }

    public static final long getSeconds(int i) {
        return Seconds.m990constructorimpl(i);
    }
}
