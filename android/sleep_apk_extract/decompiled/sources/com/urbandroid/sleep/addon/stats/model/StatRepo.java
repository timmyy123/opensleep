package com.urbandroid.sleep.addon.stats.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.advice.CountrySleepRecordProvider;
import com.urbandroid.sleep.addon.stats.filter.AcceptAllFilter;
import com.urbandroid.sleep.addon.stats.model.Advice;
import com.urbandroid.sleep.addon.stats.model.aggregator.PeriodAggregators;
import com.urbandroid.sleep.addon.stats.model.collector.IAggregator;
import com.urbandroid.sleep.addon.stats.model.collector.SemanticCollector;
import com.urbandroid.sleep.addon.stats.model.collector.WeekdayCollector;
import com.urbandroid.sleep.addon.stats.model.extractor.IrregularityIndexChartExtractor;
import com.urbandroid.sleep.addon.stats.model.merger.SameDateMerger;
import com.urbandroid.sleep.addon.stats.model.merger.ShortGapMerger;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepRegularityIndexUtil2;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.Settings$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class StatRepo extends AbstractStatRepo {
    private Date beforeMonth;
    private Context context;
    private SemanticCollector cyclesCollector;
    private SemanticCollector efficiencyCollector;
    private SemanticCollector hrCollector;
    private SemanticCollector hrvCollector;
    private SemanticCollector hrvGainCollector;
    private PeriodAggregators lastMonthAggregates;
    private Date latestDate;
    private SemanticCollector lengthCollector;
    private Locale locale;
    private Date longBefore;
    private PeriodAggregators longPeriodAggregates;
    private SemanticCollector minHrCollector;
    private int primaryColor;
    private SemanticCollector qualityCollector;
    private SemanticCollector ratingCollector;
    private SemanticCollector rdiCollector;
    private WeekdayCollector regularityIndexCollector;
    private Date shortBefore;
    private PeriodAggregators shortPeriodAggregates;
    private float sleepIrregularity;
    private SemanticCollector snoringCollector;
    private Set<String> availableTags = new HashSet();
    private HashMap<String, Integer> availableTagCounts = new HashMap<>();
    private Map<DayMonth, List<SleepRecord>> recordMap = new HashMap();

    public static class DayMonth {
        private int day;
        private int month;
        private Calendar time;
        private int year;

        public DayMonth(int i, int i2, int i3, Calendar calendar) {
            this.day = i;
            this.month = i2;
            this.time = calendar;
            this.year = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DayMonth)) {
                return false;
            }
            DayMonth dayMonth = (DayMonth) obj;
            return this.day == dayMonth.day && this.month == dayMonth.month && this.year == dayMonth.year;
        }

        public int getDay() {
            return this.day;
        }

        public int getMonth() {
            return this.month;
        }

        public Calendar getTime() {
            return this.time;
        }

        public int getYear() {
            return this.year;
        }

        public int hashCode() {
            return (((this.day * 31) + this.month) * 31) + this.year;
        }

        public String toString() {
            return this.day + "." + this.month;
        }
    }

    public enum Mode {
        FULL,
        SCORE,
        STATS
    }

    private boolean addMeasureOverAdvice(Context context, List<Advice> list, IAggregator iAggregator, double d, String str, int i, int i2, int i3, Advice.Type type) {
        if (iAggregator.getMeasure() < d) {
            return false;
        }
        list.add(new Advice(type, context.getString(R.string.advice_text_measure_more, e(context.getString(i)), e(str)), context.getResources().getStringArray(i2), i3));
        return true;
    }

    private boolean addMeasureUnderAdvice(Context context, List<Advice> list, IAggregator iAggregator, double d, String str, int i, int i2, int i3) {
        if (iAggregator.getMeasure() <= 0.0d || iAggregator.getMeasure() > d) {
            return false;
        }
        list.add(new Advice(Advice.Type.CAUTION, context.getString(R.string.advice_text_measure_less, e(context.getString(i)), e(str)), context.getResources().getStringArray(i2), i3));
        return true;
    }

    private void addTagCount(String str) {
        Integer num = 0;
        Integer num2 = this.availableTagCounts.get(str);
        if (num2 == null) {
            this.availableTagCounts.put(str, num);
        } else {
            num = num2;
        }
        this.availableTagCounts.put(str, Integer.valueOf(num.intValue() + 1));
    }

    private float[] appendMinMax(List<Float> list) {
        float[] fArr = new float[list.size() + 2];
        float f = Float.POSITIVE_INFINITY;
        float f2 = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            float fFloatValue = list.get(i).floatValue();
            if (fFloatValue > f2) {
                f2 = fFloatValue;
            }
            if (fFloatValue < f) {
                f = fFloatValue;
            }
            fArr[i + 2] = fFloatValue;
        }
        fArr[0] = f;
        fArr[1] = f2;
        return fArr;
    }

    public static float calculateChronotype(Context context) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(2, -6);
            Date time = calendar.getTime();
            Date date = new Date();
            StatRepo statRepo = new StatRepo();
            statRepo.initialize(context, calendar.getTime());
            float chronotype = SocialJetlagStats.create(statRepo.getMergedStatRecords(time, date, new AcceptAllFilter()), context).getChronotype();
            new Settings(context).setChronotype(chronotype);
            return chronotype;
        } catch (NoRecordsException unused) {
            return -1.0f;
        }
    }

    private StatRecord createFullRawStatRecord(SleepRecord sleepRecord, StatRecord statRecord) {
        StatRecord statRecord2 = new StatRecord(statRecord.getFromDate(), statRecord.getToDate(), statRecord.getTimeZone(), statRecord.getFromHour(), statRecord.getToHour());
        statRecord2.setRating(statRecord.getRating());
        statRecord2.setQuality(statRecord.getQuality());
        statRecord2.setSnore(statRecord.getSnore());
        statRecord2.setSnooze(statRecord.getSnooze());
        statRecord2.setFallAsleepHour(statRecord.getFallAsleepHour());
        statRecord2.setFallAsleep(statRecord.getFallAsleep());
        statRecord2.setWakeUp(statRecord.getWakeUp());
        statRecord2.setWakeUpHour(statRecord.getWakeUpHour());
        statRecord2.getTags().addAll(statRecord.getTags());
        statRecord2.setLengthInHours(statRecord.getLengthInHours());
        statRecord2.setTrackLengthInHours(statRecord.getTrackLengthInHours());
        statRecord2.setHrv(statRecord.getHrv());
        statRecord2.setHrvAfter(statRecord.getHrvAfter());
        statRecord2.setHrvBefore(statRecord.getHrvBefore());
        statRecord2.setHrvGain(statRecord.getHrvGain());
        statRecord2.setRdi(statRecord.getRdi());
        statRecord2.setCycles(statRecord.getCycles());
        statRecord2.setNoiseLevel(statRecord.getNoiseLevel());
        statRecord2.setSmart(statRecord.getSmart());
        statRecord2.setIrregularity(statRecord.getIrregularityInMinutes());
        statRecord2.setIrregularityIndex(statRecord.getIrregularityIndex());
        List<Float> filteredHistory = sleepRecord.getFilteredHistory();
        if (filteredHistory != null && filteredHistory.size() > 5) {
            statRecord2.setData(appendMinMax(filteredHistory));
        }
        return statRecord2;
    }

    private String e(String str) {
        return (str == null || Locale.GERMAN.getLanguage().equals(this.locale.getLanguage())) ? str : str.toLowerCase();
    }

    public static List<StatRecord> filterRecords(List<StatRecord> list, Date date, Date date2) {
        ArrayList arrayList = new ArrayList();
        for (StatRecord statRecord : list) {
            if ((date.before(statRecord.getToDate()) && (date2 == null || date2.after(statRecord.getToDate()))) || statRecord.getFromDate().getTime() == date.getTime() || (date2 != null && statRecord.getToDate().getTime() == date2.getTime())) {
                arrayList.add(statRecord);
            }
        }
        return arrayList;
    }

    private String getDot() {
        return Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage()) ? "。" : ". ";
    }

    private void initCollector(Context context) {
        this.qualityCollector = new SemanticCollector(context, Measure.QUALITY, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.label_deep_sleep));
        this.rdiCollector = new SemanticCollector(context, Measure.RDI, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.label_deep_sleep));
        this.hrvGainCollector = new SemanticCollector(context, Measure.HRV_GAIN, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.label_deep_sleep));
        this.hrvCollector = new SemanticCollector(context, Measure.HRV, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.label_deep_sleep));
        this.hrCollector = new SemanticCollector(context, Measure.HR, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.label_deep_sleep));
        this.minHrCollector = new SemanticCollector(context, Measure.MIN_HR, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.label_deep_sleep));
        this.regularityIndexCollector = new WeekdayCollector(new IrregularityIndexChartExtractor(context), context.getResources().getString(R.string.weekday) + " " + context.getResources().getString(R.string.irregularity_index));
        this.ratingCollector = new SemanticCollector(context, Measure.RATING_PERCENT, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.axis_rating));
        this.lengthCollector = new SemanticCollector(context, Measure.LENGTH, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.stats_caption_sleep));
        this.snoringCollector = new SemanticCollector(context, Measure.SNORING, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.stats_caption_snore));
        this.cyclesCollector = new SemanticCollector(context, Measure.CYCLES, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.stats_caption_cycle));
        this.efficiencyCollector = new SemanticCollector(context, Measure.EFFICIENCY_PERCENTAGE, context.getResources().getString(R.string.weekday), context.getResources().getString(R.string.stats_caption_sleep), context.getResources().getString(R.string.fall_asleep), context.getResources().getString(R.string.sleep_efficiency));
    }

    private boolean isSignificant(double d, double d2, double d3) {
        if (d2 != 0.0d && Math.round(Math.abs(d - d2)) != 0) {
            StringBuilder sb = new StringBuilder("is significant ");
            sb.append(d);
            sb.append(" / ");
            sb.append(d2);
            sb.append(" = ");
            double d4 = (d / d2) - 1.0d;
            sb.append(d4);
            sb.append(" > ");
            sb.append(d3);
            Logger.logDebug(sb.toString());
            if (d4 > d3 && d4 < 20.0d && d4 > -20.0d) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$initialize$0(StatRecord statRecord, StatRecord statRecord2) {
        return statRecord.getToDate().compareTo(statRecord2.getToDate());
    }

    public synchronized void calculate(Context context, Date date, Date date2) {
        try {
            initCollector(context);
            this.availableTags.clear();
            this.availableTagCounts.clear();
            for (StatRecord statRecord : getMergedStatRecords(date, date2, SleepStats.FILTER_INSTANCE)) {
                this.rdiCollector.put(statRecord);
                this.hrCollector.put(statRecord);
                this.minHrCollector.put(statRecord);
                this.hrvCollector.put(statRecord);
                this.hrvGainCollector.put(statRecord);
                this.qualityCollector.put(statRecord);
                this.ratingCollector.put(statRecord);
                this.lengthCollector.put(statRecord);
                this.snoringCollector.put(statRecord);
                this.cyclesCollector.put(statRecord);
                this.efficiencyCollector.put(statRecord);
                this.regularityIndexCollector.put(statRecord);
                Set<String> tags = statRecord.getTags();
                this.availableTags.addAll(tags);
                addTagCount(tags);
            }
            this.qualityCollector.getDurationRegressionCollector().init();
            this.qualityCollector.getMidnightRegressionCollector().init();
            this.ratingCollector.getDurationRegressionCollector().init();
            this.ratingCollector.getMidnightRegressionCollector().init();
            this.efficiencyCollector.getDurationRegressionCollector().init();
            this.efficiencyCollector.getMidnightRegressionCollector().init();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0b59  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0bef  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0c10  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0c7f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0cfe  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0d82  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0dfd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0edf  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0f68  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0708  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0923  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0993  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0a05  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0a74  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0ad4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Advice> getAdvice(Context context) {
        Context context2;
        char c;
        double d;
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Context context3;
        int i4;
        String str3;
        int i5;
        Advice.Type type;
        Advice.Type type2;
        if (this.shortPeriodAggregates == null) {
            Logger.logSevere("Cannot get advice, no shortPeriodAggregates ");
            return new ArrayList();
        }
        int idealSleepMinutes = SharedApplicationContext.getSettings().getIdealSleepMinutes();
        float f = idealSleepMinutes / 60.0f;
        ArrayList arrayList = new ArrayList();
        if (this.shortPeriodAggregates.getLengthAggregator().getCount() < 2) {
            return arrayList;
        }
        Logger.logDebug("Short advice " + this.shortPeriodAggregates);
        Logger.logDebug("Long advice " + this.longPeriodAggregates);
        double measure = this.shortPeriodAggregates.getSleepIrregularityMeasureAggregator().getMeasure();
        double measure2 = this.longPeriodAggregates.getSleepIrregularityMeasureAggregator().getMeasure();
        if (measure >= 0.0d && measure2 >= 0.0d) {
            double d2 = measure - measure2;
            Logger.logInfo("Advice: Variance increase " + d2 + " = sp " + measure + " lt " + measure2);
            if (d2 > 20.0d) {
                arrayList.add(new Advice(Advice.Type.CAUTION, context.getString(R.string.advice_text_measure_lately_more, e(context.getString(R.string.sleep_irregularity)), e(DateUtil.formatMinutes(Integer.valueOf((int) Math.round(d2))))) + getDot() + context.getResources().getString(R.string.advice_text_variance), context.getResources().getStringArray(R.array.advice_issues_sleep_variance), 1, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html").addGoal(Goal.Type.REGULARITY));
            } else if (d2 < -20.0d) {
                arrayList.add(new Advice(Advice.Type.CONGRATS, context.getString(R.string.advice_text_measure_lately_less, e(context.getString(R.string.sleep_irregularity)), e(DateUtil.formatMinutes(Integer.valueOf((int) Math.round(d2))))), null, 3, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html#sleep-irregularity"));
            }
        }
        String str4 = " (" + context.getResources().getStringArray(R.array.period_array)[3].toLowerCase() + ")";
        if (measure2 >= 90.0d) {
            Advice.Type type3 = Advice.Type.CAUTION;
            StringBuilder sb = new StringBuilder();
            sb.append(context.getString(R.string.advice_text_measure_more, e(context.getString(R.string.sleep_irregularity) + str4), e(context.getString(R.string.minutes, "60"))));
            sb.append(getDot());
            sb.append(context.getResources().getString(R.string.advice_text_variance));
            arrayList.add(new Advice(type3, sb.toString(), context.getResources().getStringArray(R.array.advice_issues_sleep_variance), 2, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html#sleep-irregularity").addGoal(Goal.Type.REGULARITY));
        } else if (measure2 <= 30.0d) {
            arrayList.add(new Advice(Advice.Type.CONGRATS, context.getString(R.string.advice_text_measure_less, e(context.getString(R.string.sleep_irregularity) + str4), e(context.getString(R.string.minutes, "20"))), null, 2, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html#sleep-irregularity"));
        }
        double measure3 = this.shortPeriodAggregates.getSleepRegularityIndexMeasureAggregator().getMeasure() * 100.0d;
        double measure4 = this.longPeriodAggregates.getSleepRegularityIndexMeasureAggregator().getMeasure() * 100.0d;
        Logger.logInfo("Advice: SRI st=" + measure3 + " lt=" + measure4);
        if (measure3 <= 0.0d || measure4 <= 0.0d) {
            context2 = context;
        } else {
            double d3 = measure3 - measure4;
            Logger.logInfo("Advice: SRI " + d3 + " = sp " + measure3 + " lt " + measure4);
            if (d3 > 4.0d) {
                context2 = context;
                arrayList.add(new Advice(Advice.Type.CONGRATS, context2.getString(R.string.advice_text_measure_lately_more, e(context2.getString(R.string.irregularity_index)), "" + Math.round(d3)), null, 3, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html#sri"));
            } else {
                context2 = context;
                if (d3 < -4.0d) {
                    Advice.Type type4 = Advice.Type.CAUTION;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(context2.getString(R.string.advice_text_measure_lately_less, e(context2.getString(R.string.irregularity_index)), "" + Math.round(d3)));
                    sb2.append(getDot());
                    sb2.append(context2.getResources().getString(R.string.advice_text_variance));
                    arrayList.add(new Advice(type4, sb2.toString(), context2.getResources().getStringArray(R.array.advice_issues_sleep_variance), 1, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html#sri").addGoal(Goal.Type.REGULARITY));
                }
            }
        }
        if (measure4 >= 90.0d) {
            Advice.Type type5 = Advice.Type.CONGRATS;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(context2.getString(R.string.advice_text_measure_more, e(context2.getString(R.string.irregularity_index) + str4), " 80%"));
            sb3.append(getDot());
            arrayList.add(new Advice(type5, sb3.toString(), null, 3, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html#sri"));
        } else if (measure4 <= 70.0d) {
            Advice.Type type6 = Advice.Type.CAUTION;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(context2.getString(R.string.advice_text_measure_less, e(context2.getString(R.string.irregularity_index) + str4), " 60%"));
            sb4.append(getDot());
            sb4.append(context2.getResources().getString(R.string.advice_text_variance));
            arrayList.add(new Advice(type6, sb4.toString(), context2.getResources().getStringArray(R.array.advice_issues_sleep_variance), 1, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html#sri").addGoal(Goal.Type.REGULARITY));
        }
        double measure5 = this.longPeriodAggregates.getSocialjetLagAggregator().getMeasure();
        if (measure5 <= 1.0d) {
            if (measure5 < 0.33000001311302185d) {
                Advice.Type type7 = Advice.Type.CONGRATS;
                StringBuilder sb5 = new StringBuilder();
                c = 1132;
                sb5.append(context2.getString(R.string.advice_text_measure_less, e(context2.getString(R.string.social_jatlag) + str4), e(context2.getString(R.string.minutes, "60"))));
                sb5.append(getDot());
                sb5.append(context2.getResources().getString(R.string.advice_text_social_jetlag));
                arrayList.add(new Advice(type7, sb5.toString(), null, 3, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html"));
            }
            if (this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure() >= 0.75d) {
                d = 1.0d;
                str = "%";
                if (isSignificant(this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure(), this.longPeriodAggregates.getDeepSleepAggregator().getMeasure(), 0.1d)) {
                    Advice.Type type8 = Advice.Type.CONGRATS;
                    Object[] objArr = {e(context2.getString(R.string.label_deep_sleep)), e(FileInsert$$ExternalSyntheticOutline0.m(Math.round((this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure() - this.longPeriodAggregates.getDeepSleepAggregator().getMeasure()) * 100.0d), str, new StringBuilder()))};
                    i = R.string.advice_text_measure_lately_more;
                    arrayList.add(new Advice(type8, context2.getString(R.string.advice_text_measure_lately_more, objArr), null, 2, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions"));
                }
                int i6 = i;
                if (isSignificant(this.longPeriodAggregates.getDeepSleepAggregator().getMeasure(), this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure(), 0.1d)) {
                    arrayList.add(new Advice(Advice.Type.CAUTION, context2.getString(R.string.advice_text_measure_lately_less, e(context2.getString(R.string.label_deep_sleep)), e(FileInsert$$ExternalSyntheticOutline0.m(Math.round((this.longPeriodAggregates.getDeepSleepAggregator().getMeasure() - this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure()) * 100.0d), str, new StringBuilder()))), context2.getResources().getStringArray(R.array.advice_issues_deep_sleep_less), 1, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions").addGoal(Goal.Type.DEEP_SLEEP));
                }
                if (this.shortPeriodAggregates.getDeepSleepAggregator().getCount() > 2) {
                    IAggregator deepSleepAggregator = this.shortPeriodAggregates.getDeepSleepAggregator();
                    Advice.Type type9 = Advice.Type.INDIFFERENT;
                    str2 = str4;
                    i3 = R.string.label_deep_sleep;
                    i4 = i6;
                    i2 = 1;
                    addMeasureOverAdvice(context, arrayList, deepSleepAggregator, 0.75d, "75%", R.string.label_deep_sleep, R.array.advice_issues_deep_sleep_more, 2, type9);
                    boolean zAddMeasureUnderAdvice = addMeasureUnderAdvice(context, arrayList, this.shortPeriodAggregates.getDeepSleepAggregator(), 0.15d, "15%", R.string.label_deep_sleep, R.array.advice_issues_deep_sleep_less, 1);
                    context3 = context;
                    arrayList = arrayList;
                    if (zAddMeasureUnderAdvice) {
                        ((Advice) arrayList.get(arrayList.size() - 1)).addGoal(Goal.Type.DEEP_SLEEP);
                    }
                } else {
                    i2 = 1;
                    i3 = R.string.label_deep_sleep;
                    str2 = str4;
                    context3 = context2;
                    i4 = i6;
                }
                if (isSignificant(CountrySleepRecordProvider.getMeasureRecord(null).getQuality(), this.longPeriodAggregates.getDeepSleepAggregator().getMeasure(), 0.15d)) {
                    arrayList.add(new Advice(Advice.Type.INDIFFERENT, context3.getString(R.string.advice_text_measure_others_more, e(FileInsert$$ExternalSyntheticOutline0.m(Math.round((((double) CountrySleepRecordProvider.getMeasureRecord(null).getQuality()) - this.longPeriodAggregates.getDeepSleepAggregator().getMeasure()) * 100.0d), str, new StringBuilder())), e(context3.getString(i3))), context3.getResources().getStringArray(R.array.advice_issues_deep_sleep_less), 3, "https://sleep-cloud.appspot.com/SleepCloudPublic.html").addGoal(Goal.Type.DEEP_SLEEP));
                }
                if (this.shortPeriodAggregates.getLengthAggregator().getMeasure() <= 8.0d && isSignificant(this.shortPeriodAggregates.getLengthAggregator().getMeasure(), this.longPeriodAggregates.getLengthAggregator().getMeasure(), 0.03d)) {
                    arrayList.add(new Advice(Advice.Type.CONGRATS, context3.getString(i4, e(context3.getString(R.string.stats_caption_sleep)), e(context3.getString(R.string.minutes, Long.valueOf(Math.round((this.shortPeriodAggregates.getLengthAggregator().getMeasure() - this.longPeriodAggregates.getLengthAggregator().getMeasure()) * 60.0d))))), null, 2, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions"));
                }
                if (this.shortPeriodAggregates.getLengthAggregator().getMeasure() <= 8.0d) {
                    str3 = null;
                    if (isSignificant(this.longPeriodAggregates.getLengthAggregator().getMeasure(), this.shortPeriodAggregates.getLengthAggregator().getMeasure(), 0.03d)) {
                        arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_lately_less, e(context3.getString(R.string.stats_caption_sleep)), e(context3.getString(R.string.minutes, Long.valueOf(Math.round((this.longPeriodAggregates.getLengthAggregator().getMeasure() - this.shortPeriodAggregates.getLengthAggregator().getMeasure()) * 60.0d))))), context3.getResources().getStringArray(R.array.advice_issues_duration_less), 1, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions").addGoal(Goal.Type.DURATION));
                    }
                } else {
                    str3 = null;
                }
                if (isSignificant(this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure(), this.longPeriodAggregates.getHrvAfterAggregator().getMeasure(), 0.03d)) {
                    arrayList.add(new Advice(Advice.Type.CONGRATS, context3.getString(i4, context3.getString(R.string.hrv_after), Math.round(((this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure() / this.longPeriodAggregates.getHrvAfterAggregator().getMeasure()) - d) * 100.0d) + str), null, 2, "https://sleep.urbandroid.org/hrv-tracking/"));
                }
                if (isSignificant(this.longPeriodAggregates.getHrvAfterAggregator().getMeasure(), this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure(), 0.03d)) {
                    arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_lately_less, context3.getString(R.string.hrv_after), Math.round((d - (this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure() / this.longPeriodAggregates.getHrvAfterAggregator().getMeasure())) * 100.0d) + str), context3.getResources().getStringArray(R.array.advice_issues_hrv), 1, "https://sleep.urbandroid.org/hrv-tracking/"));
                }
                if (isSignificant(this.shortPeriodAggregates.getHrvAggregator().getMeasure(), this.longPeriodAggregates.getHrvAggregator().getMeasure(), 0.03d)) {
                    arrayList.add(new Advice(Advice.Type.CONGRATS, context3.getString(i4, context3.getString(R.string.hrv_total), Math.round(((this.shortPeriodAggregates.getHrvAggregator().getMeasure() / this.longPeriodAggregates.getHrvAggregator().getMeasure()) - d) * 100.0d) + str), null, 2, "https://sleep.urbandroid.org/hrv-tracking/"));
                }
                if (isSignificant(this.longPeriodAggregates.getHrvAggregator().getMeasure(), this.shortPeriodAggregates.getHrvAggregator().getMeasure(), 0.03d)) {
                    arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_lately_less, context3.getString(R.string.hrv_total), Math.round((d - (this.shortPeriodAggregates.getHrvAggregator().getMeasure() / this.longPeriodAggregates.getHrvAggregator().getMeasure())) * 100.0d) + str), context3.getResources().getStringArray(R.array.advice_issues_hrv), 1, "https://sleep.urbandroid.org/hrv-tracking/"));
                }
                if (isSignificant(this.shortPeriodAggregates.getHrAggregator().getMeasure(), this.longPeriodAggregates.getHrAggregator().getMeasure(), 5.0d)) {
                    arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_lately_less, context3.getString(R.string.hrv_after), Math.round((d - (this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure() / this.longPeriodAggregates.getHrvAfterAggregator().getMeasure())) * 100.0d) + str), context3.getResources().getStringArray(R.array.advice_issues_hr), 2, "https://sleep.urbandroid.org/docs//sleep/heart_rate.html"));
                }
                if (isSignificant(this.longPeriodAggregates.getHrAggregator().getMeasure(), this.shortPeriodAggregates.getHrAggregator().getMeasure(), 5.0d)) {
                    arrayList.add(new Advice(Advice.Type.CONGRATS, context3.getString(i4, context3.getString(R.string.hr_short), Math.round(((this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure() / this.longPeriodAggregates.getHrvAfterAggregator().getMeasure()) - d) * 100.0d) + str), null, 1, "https://sleep.urbandroid.org/docs//sleep/heart_rate.html"));
                }
                if (this.longPeriodAggregates.getHrAggregator().getMeasure() > 55.0d) {
                    arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_more, FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), e(context3.getString(R.string.social_jatlag)), str2), e(context3.getString(R.string.minutes, "60"))) + getDot(), context3.getResources().getStringArray(R.array.advice_issues_hr), 1, "https://sleep.urbandroid.org/docs//sleep/heart_rate.html"));
                }
                SleepScore sleepScore = new SleepScore(0, 0);
                sleepScore.setAge(new Settings(context3).getAge());
                double durationLimitFrom = sleepScore.getDurationLimitFrom();
                double durationLimitTo = sleepScore.getDurationLimitTo();
                if (this.shortPeriodAggregates.getLengthAggregator().getCount() > 2) {
                    IAggregator lengthAggregator = this.shortPeriodAggregates.getLengthAggregator();
                    double d4 = durationLimitTo / 60.0d;
                    double d5 = f;
                    double dMax = Math.max(d4, d5);
                    String string = d5 > d4 ? context3.getString(R.string.target_sleep_time_title) : DateUtil.formatMinutes(Integer.valueOf((int) durationLimitTo));
                    ArrayList arrayList2 = arrayList;
                    i5 = R.string.advice_text_measure_others_more;
                    if (addMeasureOverAdvice(context, arrayList2, lengthAggregator, dMax, string, R.string.stats_caption_sleep, R.array.advice_issues_duration_more, 2)) {
                        ((Advice) arrayList2.get(arrayList2.size() - 1)).addGoal(Goal.Type.DURATION);
                    }
                    double d6 = durationLimitFrom / 60.0d;
                    context3 = context;
                    arrayList = arrayList2;
                    if (addMeasureUnderAdvice(context, arrayList2, this.shortPeriodAggregates.getLengthAggregator(), Math.min(d6, d5), d5 < d6 ? context.getString(R.string.target_sleep_time_title) : DateUtil.formatMinutes(Integer.valueOf((int) durationLimitFrom)), R.string.stats_caption_sleep, R.array.advice_issues_duration_less, 2)) {
                        ((Advice) arrayList.get(arrayList.size() - 1)).addGoal(Goal.Type.DURATION);
                    }
                } else {
                    i5 = R.string.advice_text_measure_others_more;
                }
                if (isSignificant(CountrySleepRecordProvider.getMeasureRecord(str3).getLengthInHours(), this.longPeriodAggregates.getLengthAggregator().getMeasure(), 0.1d)) {
                    arrayList.add(new Advice(Advice.Type.INDIFFERENT, context3.getString(i5, e(context3.getString(R.string.minutes, Long.valueOf(Math.round((((double) CountrySleepRecordProvider.getMeasureRecord(str3).getLengthInHours()) - this.longPeriodAggregates.getLengthAggregator().getMeasure()) * 60.0d)))), e(context3.getString(R.string.stats_caption_sleep))), context3.getResources().getStringArray(R.array.advice_issues_duration_less), 3, "https://sleep-cloud.appspot.com/SleepCloudPublic.html").addGoal(Goal.Type.DURATION));
                }
                if (this.shortPeriodAggregates.getLengthAggregator().getCount() > 2 && this.shortPeriodAggregates.getLengthAggregator().getMeasure() <= 8.0d && ((double) idealSleepMinutes) - (this.shortPeriodAggregates.getLengthAggregator().getMeasure() * 60.0d) > 60.0d) {
                    arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_more, e(context3.getString(R.string.stats_caption_debt)), e(context3.getString(R.string.minutes, 60))), context3.getResources().getStringArray(R.array.advice_issues_duration_less), 2, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions").addGoal(Goal.Type.DURATION));
                }
                if (this.longPeriodAggregates.getSnoringAggregator().getMeasure() > 5.0d && isSignificant(this.shortPeriodAggregates.getSnoringAggregator().getMeasure(), this.longPeriodAggregates.getSnoringAggregator().getMeasure(), 0.2d)) {
                    arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(i4, e(context3.getString(R.string.stats_caption_snore)), e(context3.getString(R.string.minutes, Integer.valueOf((int) (this.shortPeriodAggregates.getSnoringAggregator().getMeasure() - this.longPeriodAggregates.getSnoringAggregator().getMeasure()))))), context3.getResources().getStringArray(R.array.advice_issues_snoring_more), 1, "https://sleep.urbandroid.org/docs//sleep/sound_recognition.html").addGoal(Goal.Type.SNORING));
                }
                if (this.longPeriodAggregates.getSnoringAggregator().getMeasure() > 5.0d && isSignificant(this.longPeriodAggregates.getSnoringAggregator().getMeasure(), this.shortPeriodAggregates.getSnoringAggregator().getMeasure(), 0.2d)) {
                    arrayList.add(new Advice(Advice.Type.CONGRATS, context3.getString(R.string.advice_text_measure_lately_less, e(context3.getString(R.string.stats_caption_snore)), e(context3.getString(R.string.minutes, Integer.valueOf((int) (this.longPeriodAggregates.getSnoringAggregator().getMeasure() - this.shortPeriodAggregates.getSnoringAggregator().getMeasure()))))), null, 2, "https://sleep.urbandroid.org/docs//sleep/sound_recognition.html"));
                }
                if (this.shortPeriodAggregates.getSnoringAggregator().getCount() > 2) {
                    if (this.shortPeriodAggregates.getSnoringAggregator().getMeasure() >= 60.0d) {
                        Advice adviceAddGoal = new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_more, e(context3.getString(R.string.stats_caption_snore)), e(context3.getResources().getString(R.string.minutes, "60"))), new String[]{context3.getResources().getString(R.string.advice_oximetry) + getDot() + context3.getResources().getString(R.string.apnea_category_summary) + getDot() + context3.getResources().getString(R.string.advice_sleep_lab) + getDot()}, i2).addGoal(Goal.Type.SNORING);
                        adviceAddGoal.setReadMoreLink("https://sleep.urbandroid.org/docs//sleep/sleep_apnea.html");
                        arrayList.add(adviceAddGoal);
                    } else {
                        ArrayList arrayList3 = arrayList;
                        context3 = context;
                        arrayList = arrayList3;
                        if (addMeasureOverAdvice(context, arrayList3, this.shortPeriodAggregates.getSnoringAggregator(), 30.0d, "0:30", R.string.stats_caption_snore, R.array.advice_issues_snoring_too_much, 1)) {
                            ((Advice) arrayList.get(arrayList.size() - 1)).addGoal(Goal.Type.SNORING);
                        }
                    }
                }
                if (isSignificant(this.longPeriodAggregates.getSnoringAggregator().getMeasure(), CountrySleepRecordProvider.getMeasureRecord(str3).getSnore(), 2.0d)) {
                    arrayList.add(new Advice(Advice.Type.INDIFFERENT, context3.getString(R.string.advice_text_measure_others_less, e(context3.getString(R.string.stats_caption_snore)), e(context3.getString(R.string.minutes, Integer.valueOf((int) Math.round(this.longPeriodAggregates.getSnoringAggregator().getMeasure() - ((double) CountrySleepRecordProvider.getMeasureRecord(str3).getSnore())))))), context3.getResources().getStringArray(R.array.advice_issues_snoring_more), 3, "https://sleep-cloud.appspot.com/SleepCloudPublic.html").addGoal(Goal.Type.SNORING));
                }
                Set<String> tags = this.longPeriodAggregates.getTagAggregator().getTags();
                Logger.logDebug(this.shortPeriodAggregates.getTagAggregator().toString());
                Logger.logDebug(this.longPeriodAggregates.getTagAggregator().toString());
                for (String str5 : tags) {
                    if (this.shortPeriodAggregates.getTagAggregator().getTags().contains(str5)) {
                        float relativeOccurrence = this.longPeriodAggregates.getTagAggregator().getRelativeOccurrence(str5);
                        float relativeOccurrence2 = this.shortPeriodAggregates.getTagAggregator().getRelativeOccurrence(str5);
                        float totalOccurrence = this.shortPeriodAggregates.getTagAggregator().getTotalOccurrence(str5);
                        float totalOccurrence2 = this.longPeriodAggregates.getTagAggregator().getTotalOccurrence(str5);
                        if (relativeOccurrence2 > 0.0f && relativeOccurrence > 0.0f) {
                            Advice.Type type10 = Advice.Type.INDIFFERENT;
                            Tag tagNullSafeParseTag = Tag.nullSafeParseTag(str5.toUpperCase());
                            if (tagNullSafeParseTag == null || (!tagNullSafeParseTag.isImplicit() && tagNullSafeParseTag != Tag.MENSES)) {
                                if (relativeOccurrence2 / relativeOccurrence > 1.5f && totalOccurrence > 1.0f) {
                                    if (tagNullSafeParseTag != null) {
                                        Advice.Type type11 = (tagNullSafeParseTag == Tag.LOVE || tagNullSafeParseTag == Tag.SPORT || tagNullSafeParseTag == Tag.LAUGH || tagNullSafeParseTag == Tag.DREAM) ? Advice.Type.CONGRATS : type10;
                                        if (tagNullSafeParseTag == Tag.ALCOHOL || tagNullSafeParseTag == Tag.STRESS || tagNullSafeParseTag == Tag.CAFFEINE || tagNullSafeParseTag == Tag.MED || tagNullSafeParseTag == Tag.WORK || tagNullSafeParseTag == Tag.SNORE) {
                                            type11 = Advice.Type.CAUTION;
                                        }
                                        type2 = type11;
                                    } else {
                                        type2 = type10;
                                    }
                                    arrayList.add(new Advice(type2, context3.getString(R.string.advice_text_tag_more, e("#".concat(str5))), null, type2 == type10 ? 3 : 2, "https://sleep.urbandroid.org/docs//sleep/tags.html"));
                                } else if (relativeOccurrence / relativeOccurrence2 > 1.5f && totalOccurrence2 > 1.0f) {
                                    if (tagNullSafeParseTag != null) {
                                        Advice.Type type12 = (tagNullSafeParseTag == Tag.LOVE || tagNullSafeParseTag == Tag.SPORT) ? Advice.Type.CAUTION : type10;
                                        if (tagNullSafeParseTag == Tag.ALCOHOL || tagNullSafeParseTag == Tag.CAFFEINE || tagNullSafeParseTag == Tag.STRESS || tagNullSafeParseTag == Tag.SNORE) {
                                            type12 = Advice.Type.CONGRATS;
                                        }
                                        type = type12;
                                    } else {
                                        type = type10;
                                    }
                                    arrayList.add(new Advice(type, context3.getString(R.string.advice_text_tag_less, e("#".concat(str5))), null, type == type10 ? 3 : 2, "https://sleep.urbandroid.org/docs//sleep/tags.html"));
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList, new Comparator<Advice>() { // from class: com.urbandroid.sleep.addon.stats.model.StatRepo.1
                    @Override // java.util.Comparator
                    public int compare(Advice advice, Advice advice2) {
                        return advice.getPriority() > advice2.getPriority() ? 1 : -1;
                    }
                });
                return arrayList;
            }
            d = 1.0d;
            str = "%";
            i = R.string.advice_text_measure_lately_more;
            int i62 = i;
            if (isSignificant(this.longPeriodAggregates.getDeepSleepAggregator().getMeasure(), this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure(), 0.1d)) {
            }
            if (this.shortPeriodAggregates.getDeepSleepAggregator().getCount() > 2) {
            }
            if (isSignificant(CountrySleepRecordProvider.getMeasureRecord(null).getQuality(), this.longPeriodAggregates.getDeepSleepAggregator().getMeasure(), 0.15d)) {
            }
            if (this.shortPeriodAggregates.getLengthAggregator().getMeasure() <= 8.0d) {
                arrayList.add(new Advice(Advice.Type.CONGRATS, context3.getString(i4, e(context3.getString(R.string.stats_caption_sleep)), e(context3.getString(R.string.minutes, Long.valueOf(Math.round((this.shortPeriodAggregates.getLengthAggregator().getMeasure() - this.longPeriodAggregates.getLengthAggregator().getMeasure()) * 60.0d))))), null, 2, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions"));
            }
            if (this.shortPeriodAggregates.getLengthAggregator().getMeasure() <= 8.0d) {
            }
            if (isSignificant(this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure(), this.longPeriodAggregates.getHrvAfterAggregator().getMeasure(), 0.03d)) {
            }
            if (isSignificant(this.longPeriodAggregates.getHrvAfterAggregator().getMeasure(), this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure(), 0.03d)) {
            }
            if (isSignificant(this.shortPeriodAggregates.getHrvAggregator().getMeasure(), this.longPeriodAggregates.getHrvAggregator().getMeasure(), 0.03d)) {
            }
            if (isSignificant(this.longPeriodAggregates.getHrvAggregator().getMeasure(), this.shortPeriodAggregates.getHrvAggregator().getMeasure(), 0.03d)) {
            }
            if (isSignificant(this.shortPeriodAggregates.getHrAggregator().getMeasure(), this.longPeriodAggregates.getHrAggregator().getMeasure(), 5.0d)) {
            }
            if (isSignificant(this.longPeriodAggregates.getHrAggregator().getMeasure(), this.shortPeriodAggregates.getHrAggregator().getMeasure(), 5.0d)) {
            }
            if (this.longPeriodAggregates.getHrAggregator().getMeasure() > 55.0d) {
            }
            SleepScore sleepScore2 = new SleepScore(0, 0);
            sleepScore2.setAge(new Settings(context3).getAge());
            double durationLimitFrom2 = sleepScore2.getDurationLimitFrom();
            double durationLimitTo2 = sleepScore2.getDurationLimitTo();
            if (this.shortPeriodAggregates.getLengthAggregator().getCount() > 2) {
            }
            if (isSignificant(CountrySleepRecordProvider.getMeasureRecord(str3).getLengthInHours(), this.longPeriodAggregates.getLengthAggregator().getMeasure(), 0.1d)) {
            }
            if (this.shortPeriodAggregates.getLengthAggregator().getCount() > 2) {
                arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(R.string.advice_text_measure_more, e(context3.getString(R.string.stats_caption_debt)), e(context3.getString(R.string.minutes, 60))), context3.getResources().getStringArray(R.array.advice_issues_duration_less), 2, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions").addGoal(Goal.Type.DURATION));
            }
            if (this.longPeriodAggregates.getSnoringAggregator().getMeasure() > 5.0d) {
                arrayList.add(new Advice(Advice.Type.CAUTION, context3.getString(i4, e(context3.getString(R.string.stats_caption_snore)), e(context3.getString(R.string.minutes, Integer.valueOf((int) (this.shortPeriodAggregates.getSnoringAggregator().getMeasure() - this.longPeriodAggregates.getSnoringAggregator().getMeasure()))))), context3.getResources().getStringArray(R.array.advice_issues_snoring_more), 1, "https://sleep.urbandroid.org/docs//sleep/sound_recognition.html").addGoal(Goal.Type.SNORING));
            }
            if (this.longPeriodAggregates.getSnoringAggregator().getMeasure() > 5.0d) {
                arrayList.add(new Advice(Advice.Type.CONGRATS, context3.getString(R.string.advice_text_measure_lately_less, e(context3.getString(R.string.stats_caption_snore)), e(context3.getString(R.string.minutes, Integer.valueOf((int) (this.longPeriodAggregates.getSnoringAggregator().getMeasure() - this.shortPeriodAggregates.getSnoringAggregator().getMeasure()))))), null, 2, "https://sleep.urbandroid.org/docs//sleep/sound_recognition.html"));
            }
            if (this.shortPeriodAggregates.getSnoringAggregator().getCount() > 2) {
            }
            if (isSignificant(this.longPeriodAggregates.getSnoringAggregator().getMeasure(), CountrySleepRecordProvider.getMeasureRecord(str3).getSnore(), 2.0d)) {
            }
            Set<String> tags2 = this.longPeriodAggregates.getTagAggregator().getTags();
            Logger.logDebug(this.shortPeriodAggregates.getTagAggregator().toString());
            Logger.logDebug(this.longPeriodAggregates.getTagAggregator().toString());
            while (r1.hasNext()) {
            }
            Collections.sort(arrayList, new Comparator<Advice>() { // from class: com.urbandroid.sleep.addon.stats.model.StatRepo.1
                @Override // java.util.Comparator
                public int compare(Advice advice, Advice advice2) {
                    return advice.getPriority() > advice2.getPriority() ? 1 : -1;
                }
            });
            return arrayList;
        }
        arrayList.add(new Advice(Advice.Type.CAUTION, context2.getString(R.string.advice_text_measure_more, FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), e(context2.getString(R.string.social_jatlag)), str4), e(context2.getString(R.string.minutes, "60"))) + getDot() + context2.getResources().getString(R.string.advice_text_social_jetlag), context2.getResources().getStringArray(R.array.advice_issues_social_jetlag), 2, "https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html").addGoal(Goal.Type.REGULARITY));
        c = 1132;
        if (this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure() >= 0.75d) {
        }
        i = R.string.advice_text_measure_lately_more;
        int i622 = i;
        if (isSignificant(this.longPeriodAggregates.getDeepSleepAggregator().getMeasure(), this.shortPeriodAggregates.getDeepSleepAggregator().getMeasure(), 0.1d)) {
        }
        if (this.shortPeriodAggregates.getDeepSleepAggregator().getCount() > 2) {
        }
        if (isSignificant(CountrySleepRecordProvider.getMeasureRecord(null).getQuality(), this.longPeriodAggregates.getDeepSleepAggregator().getMeasure(), 0.15d)) {
        }
        if (this.shortPeriodAggregates.getLengthAggregator().getMeasure() <= 8.0d) {
        }
        if (this.shortPeriodAggregates.getLengthAggregator().getMeasure() <= 8.0d) {
        }
        if (isSignificant(this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure(), this.longPeriodAggregates.getHrvAfterAggregator().getMeasure(), 0.03d)) {
        }
        if (isSignificant(this.longPeriodAggregates.getHrvAfterAggregator().getMeasure(), this.shortPeriodAggregates.getHrvAfterAggregator().getMeasure(), 0.03d)) {
        }
        if (isSignificant(this.shortPeriodAggregates.getHrvAggregator().getMeasure(), this.longPeriodAggregates.getHrvAggregator().getMeasure(), 0.03d)) {
        }
        if (isSignificant(this.longPeriodAggregates.getHrvAggregator().getMeasure(), this.shortPeriodAggregates.getHrvAggregator().getMeasure(), 0.03d)) {
        }
        if (isSignificant(this.shortPeriodAggregates.getHrAggregator().getMeasure(), this.longPeriodAggregates.getHrAggregator().getMeasure(), 5.0d)) {
        }
        if (isSignificant(this.longPeriodAggregates.getHrAggregator().getMeasure(), this.shortPeriodAggregates.getHrAggregator().getMeasure(), 5.0d)) {
        }
        if (this.longPeriodAggregates.getHrAggregator().getMeasure() > 55.0d) {
        }
        SleepScore sleepScore22 = new SleepScore(0, 0);
        sleepScore22.setAge(new Settings(context3).getAge());
        double durationLimitFrom22 = sleepScore22.getDurationLimitFrom();
        double durationLimitTo22 = sleepScore22.getDurationLimitTo();
        if (this.shortPeriodAggregates.getLengthAggregator().getCount() > 2) {
        }
        if (isSignificant(CountrySleepRecordProvider.getMeasureRecord(str3).getLengthInHours(), this.longPeriodAggregates.getLengthAggregator().getMeasure(), 0.1d)) {
        }
        if (this.shortPeriodAggregates.getLengthAggregator().getCount() > 2) {
        }
        if (this.longPeriodAggregates.getSnoringAggregator().getMeasure() > 5.0d) {
        }
        if (this.longPeriodAggregates.getSnoringAggregator().getMeasure() > 5.0d) {
        }
        if (this.shortPeriodAggregates.getSnoringAggregator().getCount() > 2) {
        }
        if (isSignificant(this.longPeriodAggregates.getSnoringAggregator().getMeasure(), CountrySleepRecordProvider.getMeasureRecord(str3).getSnore(), 2.0d)) {
        }
        Set<String> tags22 = this.longPeriodAggregates.getTagAggregator().getTags();
        Logger.logDebug(this.shortPeriodAggregates.getTagAggregator().toString());
        Logger.logDebug(this.longPeriodAggregates.getTagAggregator().toString());
        while (r1.hasNext()) {
        }
        Collections.sort(arrayList, new Comparator<Advice>() { // from class: com.urbandroid.sleep.addon.stats.model.StatRepo.1
            @Override // java.util.Comparator
            public int compare(Advice advice, Advice advice2) {
                return advice.getPriority() > advice2.getPriority() ? 1 : -1;
            }
        });
        return arrayList;
    }

    public HashMap<String, Integer> getAvailableTagCounts() {
        return this.availableTagCounts;
    }

    public List<String> getAvailableTags() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.availableTags);
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.urbandroid.sleep.addon.stats.model.StatRepo.2
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                if (((Integer) StatRepo.this.availableTagCounts.get(str)).equals(StatRepo.this.availableTagCounts.get(str2))) {
                    return 0;
                }
                if (StatRepo.this.availableTagCounts.get(str) == null) {
                    return 1;
                }
                return (StatRepo.this.availableTagCounts.get(str2) != null && ((Integer) StatRepo.this.availableTagCounts.get(str)).intValue() <= ((Integer) StatRepo.this.availableTagCounts.get(str2)).intValue()) ? 1 : -1;
            }
        });
        return arrayList;
    }

    public synchronized SemanticCollector getCyclesCollector() {
        return this.cyclesCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public synchronized SemanticCollector getEfficiencyCollector() {
        return this.efficiencyCollector;
    }

    public Date getFromDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = this.latestDate;
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.add(5, -(SleepStats.DAYS + 1));
        return calendar.getTime();
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public SemanticCollector getHrCollector() {
        return this.hrCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public SemanticCollector getHrvCollector() {
        return this.hrvCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public SemanticCollector getHrvGainCollector() {
        return this.hrvGainCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public synchronized SemanticCollector getLengthCollector() {
        return this.lengthCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public SemanticCollector getMinHrCollector() {
        return this.minHrCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public synchronized SemanticCollector getQualityCollector() {
        return this.qualityCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public synchronized SemanticCollector getRatingCollector() {
        return this.ratingCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public SemanticCollector getRdiCollector() {
        return this.rdiCollector;
    }

    public Map<DayMonth, List<SleepRecord>> getRecordMap() {
        return this.recordMap;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public WeekdayCollector getRegularityIndexCollector() {
        return this.regularityIndexCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRepo
    public synchronized SemanticCollector getSnoringCollector() {
        return this.snoringCollector;
    }

    public Date getToDate() {
        return this.latestDate;
    }

    public synchronized void initialize(Context context, Date date, Mode mode) {
        Date time;
        long j;
        int i;
        Iterator<SleepRecord> it;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.primaryColor = ColorUtil.i(context, R.color.primary);
            this.context = context;
            Locale locale = context.getResources().getConfiguration().locale;
            this.locale = locale;
            if (locale == null) {
                this.locale = Locale.ENGLISH;
            }
            if (date == null) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(1, -10);
                time = calendar.getTime();
            } else {
                time = date;
            }
            Calendar.getInstance().setTime(time);
            long jCurrentTimeMillis2 = ((System.currentTimeMillis() - time.getTime()) / 3600000) / 24;
            Logger.logInfo("Stats: initialize " + time + " mode " + mode);
            GlobalInitializator.initializeIfRequired(context);
            List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(time.getTime(), new Date().getTime(), true);
            if (sleepRecords.size() == 0) {
                Logger.logInfo("Stats: zero records");
                SleepRecord lastSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord();
                if (lastSleepRecord != null) {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(lastSleepRecord.getFrom());
                    calendar2.add(5, -((int) jCurrentTimeMillis2));
                    Date time2 = calendar2.getTime();
                    Logger.logInfo("Stats: fallback to last record, since " + time2.getTime());
                    sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(time2.getTime(), new Date().getTime(), true);
                }
            }
            if (sleepRecords != null) {
                Logger.logInfo("Stats: Records " + sleepRecords.size());
            }
            if (sleepRecords == null || sleepRecords.size() == 0) {
                Logger.logInfo("Stats: No records");
                throw new NoRecordsException();
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Settings settings = new Settings(context);
            int dayCutOffHour = settings.getDayCutOffHour();
            Calendar calendar3 = Calendar.getInstance();
            Iterator<SleepRecord> it2 = sleepRecords.iterator();
            while (it2.hasNext()) {
                SleepRecord next = it2.next();
                if (this.latestDate == null) {
                    this.latestDate = next.getTo();
                    j = jCurrentTimeMillis;
                } else {
                    j = jCurrentTimeMillis;
                    if (next.getTo().after(this.latestDate)) {
                        this.latestDate = next.getTo();
                    }
                }
                Date from = next.getFrom();
                Date to = next.getTo();
                if (from.after(to)) {
                    Logger.logWarning("Stats: SleepRecord FROM is after TO.." + next + " SKIPPING..");
                } else {
                    if (mode == Mode.STATS) {
                        if (next.getTimezone() != null) {
                            calendar3.setTimeZone(DesugarTimeZone.getTimeZone(next.getTimezone()));
                        }
                        calendar3.setTime(to);
                        if (dayCutOffHour > 0 && calendar3.get(11) > dayCutOffHour) {
                            calendar3.add(6, 1);
                        }
                        i = dayCutOffHour;
                        it = it2;
                        DayMonth dayMonth = new DayMonth(calendar3.get(5), calendar3.get(2) + 1, calendar3.get(1), (Calendar) calendar3.clone());
                        if (this.recordMap.get(dayMonth) == null) {
                            this.recordMap.put(dayMonth, new ArrayList());
                        }
                        this.recordMap.get(dayMonth).add(next);
                    } else {
                        i = dayCutOffHour;
                        it = it2;
                    }
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    StatRecord statRecordFromSleepRecord = StatRecord.fromSleepRecord(next);
                    long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
                    if (jCurrentTimeMillis4 > 100) {
                        Logger.logInfo("Stats: stat record took " + jCurrentTimeMillis4 + "ms");
                    }
                    Set<String> tags = statRecordFromSleepRecord.getTags();
                    this.availableTags.addAll(tags);
                    addTagCount(tags);
                    arrayList.add(statRecordFromSleepRecord);
                    if (mode == Mode.FULL) {
                        arrayList2.add(createFullRawStatRecord(next, statRecordFromSleepRecord));
                        updateRawStatRecords(arrayList2);
                    }
                    it2 = it;
                    dayCutOffHour = i;
                }
                jCurrentTimeMillis = j;
            }
            long j2 = jCurrentTimeMillis;
            List<StatRecord> listMerge = new SameDateMerger().merge(new ShortGapMerger().merge(arrayList));
            Collections.sort(listMerge, new Settings$$ExternalSyntheticLambda0(7));
            SocialJetlagStats socialJetlagStatsCreate = SocialJetlagStats.create(listMerge, context);
            this.sleepIrregularity = socialJetlagStatsCreate.getSleepIrregularity() * 60.0f;
            SleepRegularityIndexUtil2 sleepRegularityIndexUtil2 = new SleepRegularityIndexUtil2(sleepRecords);
            Iterator<StatRecord> it3 = listMerge.iterator();
            while (it3.hasNext()) {
                sleepRegularityIndexUtil2.fillSleepRegularityIndex(it3.next());
            }
            Calendar calendar4 = Calendar.getInstance();
            calendar4.set(11, 0);
            calendar4.set(12, 0);
            Date time3 = calendar4.getTime();
            calendar4.add(6, -7);
            this.shortBefore = calendar4.getTime();
            calendar4.add(6, -24);
            this.beforeMonth = calendar4.getTime();
            calendar4.add(6, -62);
            this.longBefore = calendar4.getTime();
            if (jCurrentTimeMillis2 > 10 && jCurrentTimeMillis2 < 20) {
                settings.setCurrentAvgMidSleep(socialJetlagStatsCreate.getAverageMidSleepHour());
                settings.setCurrentAvgSleepLength(socialJetlagStatsCreate.getAverageLengthHours());
                Logger.logInfo("Caching irregularity " + socialJetlagStatsCreate.getAverageLengthHours() + " " + socialJetlagStatsCreate.getAverageMidSleepHour() + " PERIOD " + jCurrentTimeMillis2);
            }
            updateMergedStatRecords(listMerge);
            Logger.logInfo("Stats: merged updated " + listMerge.size());
            if (mode == Mode.FULL) {
                this.shortPeriodAggregates = new PeriodAggregators(context, this.shortBefore, time3);
                this.longPeriodAggregates = new PeriodAggregators(context, this.longBefore, this.shortBefore);
                this.lastMonthAggregates = new PeriodAggregators(context, this.beforeMonth, time3);
                for (StatRecord statRecord : listMerge) {
                    this.shortPeriodAggregates.put(statRecord);
                    this.longPeriodAggregates.put(statRecord);
                    this.lastMonthAggregates.put(statRecord);
                }
                initCollector(context);
            }
            Logger.logInfo("Stats: init in " + (System.currentTimeMillis() - j2) + "ms");
        } catch (Throwable th) {
            throw th;
        }
    }

    private void addTagCount(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            addTagCount(it.next());
        }
    }

    private boolean addMeasureOverAdvice(Context context, List<Advice> list, IAggregator iAggregator, double d, String str, int i, int i2, int i3) {
        return addMeasureOverAdvice(context, list, iAggregator, d, str, i, i2, i3, Advice.Type.CAUTION);
    }

    public float calculateChronotype() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(2, -6);
            return SocialJetlagStats.create(getMergedStatRecords(calendar.getTime(), new Date(), new AcceptAllFilter()), this.context).getChronotype();
        } catch (NoRecordsException unused) {
            return -1.0f;
        }
    }

    public void calculate(Context context) {
        calculate(context, getFromDate(), getToDate());
    }

    public synchronized void initialize(Context context, int i, Mode mode) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -i);
        initialize(context, calendar.getTime(), mode);
    }

    public synchronized void initialize(Context context, Date date) {
        initialize(context, date, Mode.STATS);
    }

    public synchronized void initialize(Context context, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -i);
        initialize(context, calendar.getTime());
    }
}
