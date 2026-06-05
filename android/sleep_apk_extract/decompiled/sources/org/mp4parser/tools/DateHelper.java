package org.mp4parser.tools;

import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DateHelper {
    public static Date convert(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    public static long convert(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
