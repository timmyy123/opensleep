package com.urbandroid.sleep.domain;

import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.util.Md5Util;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRecordMd5Builder {
    private boolean doEventLabels = false;
    private boolean doData = false;
    private boolean doTimes = true;
    private boolean doMeasures = false;
    private boolean doComment = false;

    private String getMD5SourceString(SleepRecord sleepRecord) {
        StringBuilder sb = new StringBuilder();
        nullSafeAppend(sb, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (this.doTimes) {
            nullSafeDateAppend(sb, sleepRecord.getFrom());
            nullSafeDateAppend(sb, sleepRecord.getTo());
        }
        if (this.doComment) {
            nullSafeAppend(sb, sleepRecord.getComment());
        }
        if (this.doMeasures) {
            nullSafeAppend(sb, Integer.valueOf(sleepRecord.getLenAdjust()));
            nullSafeAppend(sb, Float.valueOf(sleepRecord.getRating()));
            nullSafeAppend(sb, sleepRecord.getTimezone());
            nullSafeAppend(sb, Double.valueOf(Math.ceil(sleepRecord.getQuality() * 100.0f)));
            nullSafeAppend(sb, Double.valueOf(Math.ceil(sleepRecord.getSnore() * 100)));
            nullSafeAppend(sb, Double.valueOf(Math.ceil(sleepRecord.getCycles() * 100)));
            nullSafeAppend(sb, Double.valueOf(Math.ceil(sleepRecord.getNoiseLevel() * 100.0f)));
            if (sleepRecord.getGeo() != null && sleepRecord.getGeo().length() > 0) {
                sb.append(sleepRecord.getGeo());
            }
        }
        if (this.doData) {
            List<Float> history = sleepRecord.getHistory();
            List<Float> filteredHistory = sleepRecord.getFilteredHistory();
            if ((history == null || history.size() == 0) && filteredHistory != null && filteredHistory.size() > 0) {
                history = sleepRecord.getHistory();
            }
            float fFloatValue = 0.0f;
            if (history != null) {
                Iterator<Float> it = history.iterator();
                while (it.hasNext()) {
                    fFloatValue += it.next().floatValue();
                }
            }
            sb.append(Math.ceil(fFloatValue));
            sb.append(history == null ? 0 : history.size());
            List<Float> noiseHistory = sleepRecord.getNoiseHistory();
            if (noiseHistory != null) {
                Iterator<Float> it2 = noiseHistory.iterator();
                while (it2.hasNext()) {
                    it2.next().floatValue();
                }
            }
        }
        if (this.doEventLabels) {
            List<Event> copiedEvents = sleepRecord.getEvents().getCopiedEvents();
            if (!copiedEvents.isEmpty()) {
                Collections.sort(copiedEvents, new Comparator<Event>() { // from class: com.urbandroid.sleep.domain.SleepRecordMd5Builder.1
                    @Override // java.util.Comparator
                    public int compare(Event event, Event event2) {
                        return Long.valueOf(event.getTimestamp()).compareTo(Long.valueOf(event2.getTimestamp()));
                    }
                });
                for (Event event : copiedEvents) {
                    if (event.getLabel() != null) {
                        sb.append(event.getLabelOrLabelString());
                        sb.append(event.getTimestamp());
                    } else {
                        sb.append(EventLabel.UNKNOWN.name());
                        sb.append(event.getTimestamp());
                    }
                }
            }
        }
        return sb.toString();
    }

    private <T> void nullSafeAppend(StringBuilder sb, T t) {
        if (t == null) {
            sb.append("NULL");
        } else {
            sb.append(t);
        }
    }

    private void nullSafeDateAppend(StringBuilder sb, Date date) {
        if (date == null) {
            sb.append("NULL");
        } else {
            sb.append(date.getTime());
        }
    }

    public String getMD5(SleepRecord sleepRecord) {
        return Md5Util.md5(getMD5SourceString(sleepRecord));
    }

    public SleepRecordMd5Builder setDoEventLabels(boolean z) {
        this.doEventLabels = z;
        return this;
    }

    public SleepRecordMd5Builder setDoTimes(boolean z) {
        this.doTimes = z;
        return this;
    }
}
