package com.urbandroid.sleep.domain;

import android.content.Context;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.service.Settings;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRecordStringBuilder {
    private Context context;
    private Measure[] measures;
    private boolean noAmPm;
    private int limit = -1;
    private boolean appendWeekDay = false;
    private boolean appendWeekDayShort = false;
    private boolean appendRange = true;
    private boolean appendDay = true;
    private boolean appendLength = false;
    private boolean appendDuration = false;
    private boolean appendTimezone = false;
    private boolean prependSleep = false;
    private boolean isShort = false;
    private boolean appendSpaceAfterDuration = false;
    private boolean appendAppName = false;
    private boolean appendMeasures = false;
    private boolean appendSparkleTweet = false;
    private boolean appendComment = false;
    private boolean appendAppHashtag = false;
    private boolean appendYearIfOld = false;

    public SleepRecordStringBuilder(Context context) {
        this.noAmPm = true;
        this.context = context;
        if (new Settings(context).isShowAmPm()) {
            this.noAmPm = false;
        }
    }

    public static String getTitle(Context context, SleepRecord sleepRecord, boolean z, boolean z2) {
        Calendar calendar = Calendar.getInstance();
        int datestampNumber = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.add(5, -1);
        int datestampNumber2 = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.setTime(sleepRecord.getNotNullTo());
        int datestampNumber3 = DateUtil.getDatestampNumber(calendar.getTime());
        return datestampNumber3 == datestampNumber ? z2 ? "" : context.getString(R.string.today) : datestampNumber3 == datestampNumber2 ? z2 ? "" : context.getString(R.string.yesterday) : z ? new SleepRecordStringBuilder(context).setAppendDay(true).setAppendWeekDay(true).setAppendRange(false).build(sleepRecord) : new SleepRecordStringBuilder(context).setAppendWeekDay(true).setAppendRange(false).setAppendYearIfOld(true).setAppendDuration(false).build(sleepRecord);
    }

    private boolean recordHasNonDefaultTimeZone(SleepRecord sleepRecord) {
        return (TimeZone.getDefault() == null || sleepRecord.getTimezone() == null || TimeZone.getDefault().getID().equals(sleepRecord.getTimezone())) ? false : true;
    }

    public SleepRecordStringBuilder appendSpaceAfterDuration(boolean z) {
        this.appendSpaceAfterDuration = z;
        return this;
    }

    public String build(SleepRecord sleepRecord) {
        String asciiHypnogram;
        if (sleepRecord == null) {
            return "";
        }
        TimeZone timeZone = DateUtil.getTimeZone(sleepRecord.getTimezone());
        DateFormat shortDateInstanceWithoutYears = DateUtil.getShortDateInstanceWithoutYears(this.context, timeZone);
        StringBuilder sb = new StringBuilder();
        if (this.appendAppName) {
            if (this.appendAppHashtag) {
                sb.append("#Sleep_as_Android ");
            } else {
                sb.append(this.context.getString(R.string.app_name_long));
                sb.append(": ");
            }
        }
        if (this.prependSleep) {
            sb.append(this.context.getString(R.string.settings_category_sleep));
            sb.append(" ");
        }
        if (this.appendDay) {
            String strSubstring = shortDateInstanceWithoutYears.format(sleepRecord.getNotNullTo());
            if (strSubstring.startsWith("-") && strSubstring.length() > 1) {
                strSubstring = strSubstring.substring(1);
            }
            sb.append(strSubstring);
            sb.append(" ");
        }
        if (this.appendYearIfOld) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            calendar.setTime(sleepRecord.getNotNullTo());
            int i2 = calendar.get(1);
            if (i - i2 >= 1) {
                sb.append(i2);
                sb.append(" ");
            }
        }
        if (this.appendDuration) {
            sb.append("");
            sb.append(sleepRecord.getSleepLengthString());
            sb.append("  ");
        }
        if (this.appendWeekDay) {
            sb.append(DateUtil.getShortDateWeekOnlyInstanceWithoutYears(this.context, timeZone).format(sleepRecord.getNotNullTo()));
            sb.append(" ");
        } else if (this.appendWeekDayShort) {
            sb.append(DateUtil.getShortDateWeekShortOnlyInstanceWithoutYears(this.context, timeZone).format(sleepRecord.getNotNullTo()));
            sb.append(" ");
        }
        if (this.appendRange) {
            boolean zRecordHasNonDefaultTimeZone = recordHasNonDefaultTimeZone(sleepRecord);
            Context context = this.context;
            DateFormat hoursFormat = zRecordHasNonDefaultTimeZone ? DateUtil.getHoursFormat(context, timeZone) : DateUtil.getHoursFormat(context);
            String str = hoursFormat.format(sleepRecord.getFrom());
            if (sleepRecord.getTo() != null) {
                String str2 = hoursFormat.format(sleepRecord.getNotNullTo());
                if (str2.equals(str)) {
                    sb.append(str);
                    sb.append(" ");
                } else {
                    if (this.appendLength) {
                        sb.append(sleepRecord.getSleepLengthString());
                        sb.append(" ");
                        if (this.appendSpaceAfterDuration) {
                            sb.append("   ");
                        }
                    }
                    sb.append(str);
                    sb.append(" ");
                    if (sleepRecord.getNotNullTo().getTime() - sleepRecord.getFrom().getTime() > 60000) {
                        Fragment$$ExternalSyntheticOutline1.m67m(sb, "→ ", str2, " ");
                    }
                }
            } else {
                sb.append(str);
                sb.append(" ");
            }
        } else if (this.appendLength) {
            sb.append(sleepRecord.getSleepLengthString());
            sb.append(" ");
        }
        if (this.appendTimezone && recordHasNonDefaultTimeZone(sleepRecord)) {
            sb.append(sleepRecord.getTimezone());
            sb.append(" ");
        }
        if (this.appendMeasures) {
            try {
                StatRecord statRecordFromSleepRecord = StatRecord.fromSleepRecord(sleepRecord);
                for (Measure measure : this.measures) {
                    IValueExtractor extractor = measure.getExtractor(this.context);
                    if (extractor != null && extractor.getValue(statRecordFromSleepRecord) >= 0.009999999776482582d) {
                        IValueExtractor secondaryExtractor = measure.getSecondaryExtractor(this.context);
                        if (this.isShort) {
                            sb.append(extractor.getMeasureName().substring(0, 2));
                            sb.append(": ");
                            sb.append(extractor.getValuePresentation(extractor.getValue(statRecordFromSleepRecord)));
                            sb.append(" ");
                        } else {
                            sb.append(extractor.getMeasureName());
                            sb.append(": ");
                            sb.append(extractor.getValuePresentation(extractor.getValue(statRecordFromSleepRecord)));
                            sb.append(" ");
                        }
                        if (!this.isShort && secondaryExtractor != null) {
                            sb.append(" (");
                            sb.append(secondaryExtractor.getValuePresentation(secondaryExtractor.getValue(statRecordFromSleepRecord)));
                            sb.append(") ");
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (this.appendSparkleTweet && (asciiHypnogram = SleeprecordExtKt.toAsciiHypnogram(sleepRecord, 15)) != null) {
            Fragment$$ExternalSyntheticOutline1.m67m(sb, "\n", asciiHypnogram, " ");
        }
        if (!this.appendAppName && this.appendAppHashtag) {
            sb.append("#Sleep_as_Android ");
        }
        if (this.appendComment && sleepRecord.getComment() != null && sleepRecord.getComment().trim().length() > 0) {
            sb.append("\n");
            sb.append(sleepRecord.getComment());
            sb.append(" ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String string = sb.toString();
        if (this.limit <= -1) {
            return string;
        }
        int length = string.length();
        int i3 = this.limit;
        return length > i3 ? string.substring(0, i3 - 4).concat("...") : string;
    }

    public SleepRecordStringBuilder setAppendAppHashtag(boolean z) {
        this.appendAppHashtag = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendAppName(boolean z) {
        this.appendAppName = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendComment(boolean z) {
        this.appendComment = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendDay(boolean z) {
        this.appendDay = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendDuration(boolean z) {
        this.appendDuration = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendLength(boolean z) {
        this.appendLength = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendMeasures(boolean z, Measure[] measureArr) {
        this.appendMeasures = z;
        this.measures = measureArr;
        return this;
    }

    public SleepRecordStringBuilder setAppendRange(boolean z) {
        this.appendRange = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendSparkleTweet(boolean z) {
        this.appendSparkleTweet = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendWeekDay(boolean z) {
        this.appendWeekDay = z;
        return this;
    }

    public SleepRecordStringBuilder setAppendYearIfOld(boolean z) {
        this.appendYearIfOld = z;
        return this;
    }

    public SleepRecordStringBuilder setLimit(int i) {
        this.limit = i;
        return this;
    }

    public SleepRecordStringBuilder setPrependSleep(boolean z) {
        this.prependSleep = z;
        return this;
    }

    public SleepRecordStringBuilder setShort(boolean z) {
        this.isShort = z;
        return this;
    }

    public static String getTitle(Context context, SleepRecord sleepRecord, boolean z) {
        return getTitle(context, sleepRecord, false, false);
    }

    public static String getTitle(Context context, SleepRecord sleepRecord) {
        return getTitle(context, sleepRecord, false);
    }
}
