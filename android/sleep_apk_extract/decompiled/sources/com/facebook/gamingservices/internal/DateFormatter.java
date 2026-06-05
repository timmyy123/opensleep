package com.facebook.gamingservices.internal;

import android.os.Build;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/gamingservices/internal/DateFormatter;", "", "<init>", "()V", "", "isoDate", "j$/time/ZonedDateTime", "format$facebook_gamingservices_release", "(Ljava/lang/String;)Lj$/time/ZonedDateTime;", "format", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DateFormatter {
    public static final DateFormatter INSTANCE = new DateFormatter();

    private DateFormatter() {
    }

    public final ZonedDateTime format$facebook_gamingservices_release(String isoDate) {
        isoDate.getClass();
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        dateTimeFormatterOfPattern.getClass();
        return ZonedDateTime.parse(isoDate, dateTimeFormatterOfPattern);
    }
}
