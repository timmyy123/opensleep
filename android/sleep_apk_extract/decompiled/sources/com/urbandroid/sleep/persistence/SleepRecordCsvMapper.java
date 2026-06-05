package com.urbandroid.sleep.persistence;

import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.util.ScienceUtil;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SleepRecordCsvMapper {
    private static final Pattern valuesPattern = Pattern.compile("[-\\d\\.E]+");
    private static final Pattern splitPattern = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    private static final DecimalFormat csvLengthFormat = new DecimalFormat("0.000", new DecimalFormatSymbols(Locale.US));

    public static String cleanQuotes(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        if (str.charAt(0) == '\"') {
            str = str.substring(1);
        }
        int length = str.length() - 1;
        return str.charAt(length) == '\"' ? str.substring(0, length) : str;
    }

    public static void parseNoiseLineFromCsv(SleepRecord sleepRecord, String str) {
        String[] strArrSplit = str.split("\\,");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            String strTrim = cleanQuotes(str2).trim();
            if (strTrim.length() != 0) {
                arrayList.add(Float.valueOf(Float.parseFloat(strTrim)));
            }
        }
        if (arrayList.size() > 0) {
            sleepRecord.addNoiseRecord(ScienceUtil.toFloatArray(arrayList));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012f A[Catch: ParseException -> 0x00d7, TryCatch #3 {ParseException -> 0x00d7, blocks: (B:32:0x00b3, B:46:0x012f, B:48:0x0133, B:50:0x0146, B:52:0x0150, B:54:0x0156, B:55:0x0159, B:56:0x015b, B:57:0x0163, B:59:0x0166, B:77:0x01c1, B:70:0x01a3, B:74:0x01aa, B:76:0x01af, B:78:0x01c4, B:89:0x020a, B:90:0x020d, B:92:0x021d, B:94:0x0249, B:93:0x0228, B:88:0x01f4, B:43:0x0124, B:37:0x00db, B:25:0x0087, B:29:0x00ad, B:28:0x00a3, B:81:0x01c8, B:83:0x01e3, B:86:0x01f0, B:63:0x017b, B:68:0x0191, B:40:0x00f9), top: B:106:0x0087, inners: #1, #4, #5, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133 A[Catch: ParseException -> 0x00d7, TryCatch #3 {ParseException -> 0x00d7, blocks: (B:32:0x00b3, B:46:0x012f, B:48:0x0133, B:50:0x0146, B:52:0x0150, B:54:0x0156, B:55:0x0159, B:56:0x015b, B:57:0x0163, B:59:0x0166, B:77:0x01c1, B:70:0x01a3, B:74:0x01aa, B:76:0x01af, B:78:0x01c4, B:89:0x020a, B:90:0x020d, B:92:0x021d, B:94:0x0249, B:93:0x0228, B:88:0x01f4, B:43:0x0124, B:37:0x00db, B:25:0x0087, B:29:0x00ad, B:28:0x00a3, B:81:0x01c8, B:83:0x01e3, B:86:0x01f0, B:63:0x017b, B:68:0x0191, B:40:0x00f9), top: B:106:0x0087, inners: #1, #4, #5, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146 A[Catch: ParseException -> 0x00d7, TryCatch #3 {ParseException -> 0x00d7, blocks: (B:32:0x00b3, B:46:0x012f, B:48:0x0133, B:50:0x0146, B:52:0x0150, B:54:0x0156, B:55:0x0159, B:56:0x015b, B:57:0x0163, B:59:0x0166, B:77:0x01c1, B:70:0x01a3, B:74:0x01aa, B:76:0x01af, B:78:0x01c4, B:89:0x020a, B:90:0x020d, B:92:0x021d, B:94:0x0249, B:93:0x0228, B:88:0x01f4, B:43:0x0124, B:37:0x00db, B:25:0x0087, B:29:0x00ad, B:28:0x00a3, B:81:0x01c8, B:83:0x01e3, B:86:0x01f0, B:63:0x017b, B:68:0x0191, B:40:0x00f9), top: B:106:0x0087, inners: #1, #4, #5, #6, #8 }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:58:0x0164
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.processExcHandler(ExcHandlersRegionMaker.java:154)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:77)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.urbandroid.sleep.domain.SleepRecord parseSleepRecordFromCsv(java.text.DecimalFormat r20, java.text.DateFormat r21, java.text.DateFormat r22, boolean r23, boolean r24, boolean r25, boolean r26, java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbandroid.sleep.persistence.SleepRecordCsvMapper.parseSleepRecordFromCsv(java.text.DecimalFormat, java.text.DateFormat, java.text.DateFormat, boolean, boolean, boolean, boolean, java.lang.String):com.urbandroid.sleep.domain.SleepRecord");
    }

    public static String sleepRecordToCsv(SleepRecord sleepRecord, DateFormat dateFormat, DateFormat dateFormat2) {
        Calendar calendar = Calendar.getInstance();
        Date from = sleepRecord.getFrom();
        Date to = sleepRecord.getTo();
        double time = (to != null ? to.getTime() : 0L) - (from != null ? from.getTime() : sleepRecord.getLastestTo().getTime());
        float fRound = Math.round((time / 3600000.0d) * 100.0d) / 100.0f;
        if (fRound < 0.0f) {
            fRound = 0.0f;
        }
        double size = time / ((double) sleepRecord.getHistory().size());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        if (sleepRecord.getTimezone() != null) {
            TimeZone timeZone = TimeZone.getDefault();
            try {
                timeZone = DesugarTimeZone.getTimeZone(sleepRecord.getTimezone());
            } catch (Exception unused) {
            }
            dateFormat.setTimeZone(timeZone);
        }
        sb.append("Id,Tz,From,To,Sched,Hours,Rating,Comment,Framerate,Snore,Noise,Cycles,DeepSleep,LenAdjust,Geo");
        String strReplace = sleepRecord.getComment().replace("\r\n", " \\n ").replace("\n", " \\n ").replace("\"", "\"\"");
        StringBuilder sb4 = new StringBuilder("\"");
        sb4.append(sleepRecord.getFrom() == null ? "-1" : Long.valueOf(sleepRecord.getFrom().getTime()));
        sb4.append("\",\"");
        sb4.append(sleepRecord.getTimezone());
        sb4.append("\",\"");
        sb4.append(dateFormat.format(from));
        sb4.append("\",\"");
        sb4.append(to != null ? dateFormat.format(to) : dateFormat.format(from));
        sb4.append("\",\"");
        sb4.append(sleepRecord.getLastestTo() != null ? dateFormat.format(sleepRecord.getLastestTo()) : dateFormat.format(from));
        sb4.append("\",\"");
        sb4.append(csvLengthFormat.format(fRound));
        sb4.append("\",\"");
        sb4.append(sleepRecord.getRating());
        sb4.append("\",\"");
        sb4.append(strReplace);
        sb4.append("\",\"");
        sb4.append(sleepRecord.getVersion());
        sb4.append("\",\"");
        sb4.append(sleepRecord.getSnore());
        sb4.append("\",\"");
        sb4.append(sleepRecord.getNoiseLevel());
        sb4.append("\",\"");
        sb4.append(sleepRecord.getCycles());
        sb4.append("\",\"");
        sb4.append(sleepRecord.getQuality());
        sb4.append("\",\"");
        sb4.append(sleepRecord.getLenAdjust());
        sb4.append("\",\"");
        sb4.append(sleepRecord.getGeo() == null ? "" : sleepRecord.getGeo());
        sb4.append("\"");
        sb2.append(sb4.toString());
        int i = 1;
        for (Float f : sleepRecord.getFilteredHistory()) {
            calendar.setTime(from);
            double d = size;
            calendar.add(14, (int) Math.round(d * ((double) i)));
            sb.append(",\"" + dateFormat2.format(calendar.getTime()) + "\"");
            sb2.append(",\"" + f + "\"");
            i++;
            size = d;
        }
        for (Event event : sleepRecord.getEvents().getCopiedEvents()) {
            EventLabel label = event.getLabel() == null ? EventLabel.UNKNOWN : event.getLabel();
            String labelString = label == EventLabel.UNKNOWN ? event.getLabelString() : label.name();
            sb.append(",\"Event\"");
            sb2.append(",\"" + labelString + "-" + event.getTimestamp());
            if (event.getValue() > 0.0f) {
                sb2.append("-");
                sb2.append(String.valueOf(event.getValue()));
            }
            sb2.append("\"");
        }
        if (sleepRecord.getNoiseHistory().size() > 0) {
            sb3.append(",,,,,,,,,,,,");
            Iterator<Float> it = sleepRecord.getFilteredNoiseHistory().iterator();
            while (it.hasNext()) {
                sb3.append(",\"" + it.next() + "\"");
            }
        }
        sb.append("\n");
        sb.append(sb2.toString());
        sb.append("\n");
        if (sb3.length() > 0) {
            sb.append(sb3.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String sleepRecordToCsv(SleepRecord sleepRecord) {
        return sleepRecordToCsv(sleepRecord, new SimpleDateFormat("dd. MM. yyyy H:mm"), new SimpleDateFormat("H:mm"));
    }
}
