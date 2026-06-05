package com.google.api.client.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class DateTime implements Serializable {
    private static final TimeZone GMT = DesugarTimeZone.getTimeZone("GMT");
    private static final Pattern RFC3339_PATTERN = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d{1,9})?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private static final long serialVersionUID = 1;
    private final boolean dateOnly;
    private final int tzShift;
    private final long value;

    public static class Rfc3339ParseResult implements Serializable {
        private final int nanos;
        private final long seconds;
        private final boolean timeGiven;
        private final Integer tzShift;

        private Rfc3339ParseResult(long j, int i, boolean z, Integer num) {
            this.seconds = j;
            this.nanos = i;
            this.timeGiven = z;
            this.tzShift = num;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DateTime toDateTime() {
            return new DateTime(!this.timeGiven, TimeUnit.SECONDS.toMillis(this.seconds) + (((long) this.nanos) / 1000000), this.tzShift);
        }
    }

    public DateTime(boolean z, long j, Integer num) {
        this.dateOnly = z;
        this.value = j;
        this.tzShift = z ? 0 : num == null ? TimeZone.getDefault().getOffset(j) / 60000 : num.intValue();
    }

    private static void appendInt(StringBuilder sb, int i, int i2) {
        if (i < 0) {
            sb.append('-');
            i = -i;
        }
        int i3 = i;
        while (i3 > 0) {
            i3 /= 10;
            i2--;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append('0');
        }
        if (i != 0) {
            sb.append(i);
        }
    }

    public static DateTime parseRfc3339(String str) {
        return parseRfc3339WithNanoSeconds(str).toDateTime();
    }

    private static Rfc3339ParseResult parseRfc3339WithNanoSeconds(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        Integer numValueOf;
        Matcher matcher = RFC3339_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new NumberFormatException(FileInsert$$ExternalSyntheticOutline0.m("Invalid date/time format: ", str));
        }
        int i5 = Integer.parseInt(matcher.group(1));
        int i6 = Integer.parseInt(matcher.group(2)) - 1;
        int i7 = Integer.parseInt(matcher.group(3));
        boolean z = matcher.group(4) != null;
        String strGroup = matcher.group(9);
        boolean z2 = strGroup != null;
        if (z2 && !z) {
            throw new NumberFormatException(FileInsert$$ExternalSyntheticOutline0.m("Invalid date/time format, cannot specify time zone shift without specifying time: ", str));
        }
        if (z) {
            int i8 = Integer.parseInt(matcher.group(5));
            int i9 = Integer.parseInt(matcher.group(6));
            int i10 = Integer.parseInt(matcher.group(7));
            if (matcher.group(8) != null) {
                i4 = Integer.parseInt(com.google.common.base.Strings.padEnd(matcher.group(8).substring(1), 9, '0'));
                i2 = i9;
                i3 = i10;
            } else {
                i2 = i9;
                i3 = i10;
                i4 = 0;
            }
            i = i8;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT);
        gregorianCalendar.clear();
        gregorianCalendar.set(i5, i6, i7, i, i2, i3);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (!z || !z2) {
            numValueOf = null;
        } else if (Character.toUpperCase(strGroup.charAt(0)) != 'Z') {
            int i11 = Integer.parseInt(matcher.group(12)) + (Integer.parseInt(matcher.group(11)) * 60);
            if (matcher.group(10).charAt(0) == '-') {
                i11 = -i11;
            }
            timeInMillis -= ((long) i11) * 60000;
            numValueOf = Integer.valueOf(i11);
        } else {
            numValueOf = 0;
        }
        return new Rfc3339ParseResult(timeInMillis / 1000, i4, z, numValueOf);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) obj;
        return this.dateOnly == dateTime.dateOnly && this.value == dateTime.value && this.tzShift == dateTime.tzShift;
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return Arrays.hashCode(new long[]{this.value, this.dateOnly ? 1L : 0L, this.tzShift});
    }

    public String toString() {
        return toStringRfc3339();
    }

    public String toStringRfc3339() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT);
        gregorianCalendar.setTimeInMillis((((long) this.tzShift) * 60000) + this.value);
        appendInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        appendInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        appendInt(sb, gregorianCalendar.get(5), 2);
        if (!this.dateOnly) {
            sb.append('T');
            appendInt(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            appendInt(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            appendInt(sb, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb.append('.');
                appendInt(sb, gregorianCalendar.get(14), 3);
            }
            int i = this.tzShift;
            if (i == 0) {
                sb.append('Z');
            } else {
                if (i > 0) {
                    sb.append('+');
                } else {
                    sb.append('-');
                    i = -i;
                }
                appendInt(sb, i / 60, 2);
                sb.append(':');
                appendInt(sb, i % 60, 2);
            }
        }
        return sb.toString();
    }

    public DateTime(long j, int i) {
        this(false, j, Integer.valueOf(i));
    }

    public DateTime(long j) {
        this(false, j, null);
    }
}
