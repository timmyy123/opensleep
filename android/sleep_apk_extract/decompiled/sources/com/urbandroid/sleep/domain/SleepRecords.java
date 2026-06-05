package com.urbandroid.sleep.domain;

import android.content.Context;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRecords {
    public static SleepRecord getLongestRecord(List<SleepRecord> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.stream().max(Comparator.comparingInt(new SleepRecords$$ExternalSyntheticLambda0())).get();
    }

    private boolean isTimeInRecord(Date date, SleepRecord sleepRecord) {
        return date.getTime() >= sleepRecord.getFrom().getTime() && date.getTime() <= sleepRecord.getTo().getTime();
    }

    public static void updateHideSleepAnalysis(SleepRecord sleepRecord) {
        if (sleepRecord.isHideSleepAnalysis() && TrialFilter.getInstance().isInitialized() && !TrialFilter.getInstance().isTrial()) {
            sleepRecord.setHideSleepAnalysis(false);
        }
    }

    public int adjustSnoring(Context context, Noise noise, String str) {
        Tag tag = Tag.SNORE;
        boolean z = Tag.hasTag(str, tag) && !Tag.hasTag(noise.getComment(), tag);
        boolean z2 = !Tag.hasTag(str, tag) && Tag.hasTag(noise.getComment(), tag);
        Logger.logInfo("Adjust " + noise.getComment() + " " + str + " ");
        if (z || z2) {
            Iterator<SleepRecord> it = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(noise.getFrom().getTime(), TimeChart.DAY + noise.getFrom().getTime(), true).iterator();
            if (it.hasNext()) {
                SleepRecord next = it.next();
                Logger.logInfo("Adjust Record " + next);
                if (!isTimeInRecord(noise.getFrom(), next) || !isTimeInRecord(noise.getTo(), next)) {
                    return z ? 1 : -1;
                }
                int time = (int) ((noise.getTo().getTime() - noise.getFrom().getTime()) / 1000);
                StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(time, "Adjust Record ", " events ");
                sbM65m.append(next.getEvents().getCopiedEvents().size());
                Logger.logInfo(sbM65m.toString());
                SleepRecord sleepRecordLoadFullRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().loadFullRecord(next.getFrom().getTime());
                Logger.logInfo("Adjust events " + sleepRecordLoadFullRecord.getEvents().getCopiedEvents().size());
                SleepRecord sleepRecord = new SleepRecord(sleepRecordLoadFullRecord, false);
                int i = z ? time : -time;
                sleepRecord.addSnore(i);
                if (sleepRecord.getSnore() <= 0) {
                    sleepRecord.setSnore(0);
                }
                if (z) {
                    sleepRecordLoadFullRecord.getEvents().addEvent((noise.getToTime() / 2) + noise.getFromTime(), EventLabel.SNORING);
                } else {
                    sleepRecordLoadFullRecord.getEvents().clearLabels(noise.getFromTime(), noise.getToTime(), EventLabel.SNORING);
                }
                if (time > 0) {
                    UndoOperationGroup undoOperationGroup = new UndoOperationGroup(context.getString(R.string.stats_caption_snore), sleepRecordLoadFullRecord);
                    SharedApplicationContext.getInstance().getSleepRecordRepository().updateSnore(sleepRecord);
                    SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
                }
                StringBuilder sbM65m2 = Fragment$$ExternalSyntheticOutline1.m65m(i, "Adjust Record after ", " events ");
                sbM65m2.append(sleepRecordLoadFullRecord.getEvents().getCopiedEvents().size());
                sbM65m2.append(" new ");
                sbM65m2.append(sleepRecord.getEvents().getCopiedEvents().size());
                Logger.logInfo(sbM65m2.toString());
                Logger.logInfo("Adjust events " + SharedApplicationContext.getInstance().getSleepRecordRepository().loadFullRecord(sleepRecordLoadFullRecord.getFrom().getTime()).getEvents().getCopiedEvents().size() + " new " + sleepRecord.getEvents().getCopiedEvents().size());
                return i;
            }
        }
        Logger.logInfo("NOT Adjusted ");
        return 0;
    }

    public int calculateLastDaysAverageDeficit() {
        Date cutOffDate = DateUtil.getCutOffDate(new Date(), SharedApplicationContext.getSettings().getDayCutOffHour());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cutOffDate);
        calendar.add(5, 1);
        Date time = calendar.getTime();
        calendar.add(5, -6);
        Date time2 = calendar.getTime();
        HashSet hashSet = new HashSet();
        List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(time2.getTime(), time.getTime(), false);
        int sleepLengthMinutes = 0;
        if (sleepRecords == null || sleepRecords.size() == 0) {
            return 0;
        }
        for (SleepRecord sleepRecord : sleepRecords) {
            if (sleepRecord.getTo() != null) {
                calendar.setTime(sleepRecord.getTo());
                calendar.setTimeZone(sleepRecord.getTimeZone());
                hashSet.add(Integer.valueOf(calendar.get(5)));
                sleepLengthMinutes += sleepRecord.getSleepLengthMinutes();
            }
        }
        Logger.logInfo("Deficit from " + time + " to " + time2 + " " + sleepRecords.size() + " " + hashSet.size() + " total " + sleepLengthMinutes);
        double idealSleepMinutes = ((double) SharedApplicationContext.getSettings().getIdealSleepMinutes()) - ((double) (sleepLengthMinutes / (hashSet.size() != 0 ? hashSet.size() : 1)));
        Logger.logInfo("Avg deficit " + idealSleepMinutes);
        return (int) Math.round(idealSleepMinutes);
    }

    public boolean isOverlap(SleepRecord sleepRecord, SleepRecord sleepRecord2) {
        return isTimeInRecord(sleepRecord.getFrom(), sleepRecord2) || isTimeInRecord(sleepRecord.getTo(), sleepRecord2) || isTimeInRecord(sleepRecord2.getFrom(), sleepRecord) || isTimeInRecord(sleepRecord2.getTo(), sleepRecord);
    }
}
