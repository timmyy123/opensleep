package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import android.content.Context;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecords;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.ClusteredChronoRecords;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.SleepLabel;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes4.dex */
public class SocialJetlagStats {
    private final ChronoRecords records;
    private final boolean useUTCforIrregularity;
    private final ValueCache valueCache = new ValueCache();

    public SocialJetlagStats(ChronoRecords chronoRecords, boolean z) {
        this.records = chronoRecords;
        this.useUTCforIrregularity = z;
    }

    public static SocialJetlagStats create(Collection<? extends StatRecord> collection, Context context) {
        List<StatRecord> listFilterByGrossLength = SleepStatsUtilKt.filterByGrossLength(collection, 2.0d, 16.0d);
        ArrayList arrayList = new ArrayList();
        Iterator<StatRecord> it = listFilterByGrossLength.iterator();
        while (it.hasNext()) {
            ChronoRecord chronoRecord = ChronoRecordKt.toChronoRecord(it.next());
            if (chronoRecord != null) {
                arrayList.add(chronoRecord);
            }
        }
        return new SocialJetlagStats(new ChronoRecords(arrayList), !new Settings(context).isUseLocalTimeForSleepIrregularity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean decideIfClusteringIsGood(ClusteredChronoRecords clusteredChronoRecords) {
        if (clusteredChronoRecords.getClusteringStrength() < 2.75d) {
            return false;
        }
        ChronoRecords labeledRecords = clusteredChronoRecords.getLabeledRecords(SleepLabel.FREE_DAY);
        ChronoRecords labeledRecords2 = clusteredChronoRecords.getLabeledRecords(SleepLabel.BUSY_DAY);
        if (labeledRecords.size() < 5 || ((double) labeledRecords.size()) / ((double) size()) < 0.1d) {
            return false;
        }
        return (ScienceUtil.avg(labeledRecords.getLengths()) - ScienceUtil.avg(labeledRecords2.getLengths())) / ScienceUtil.stddev(labeledRecords2.getLengths()) >= -0.5f;
    }

    private List<Pair<Date, Float>> getAggregatedHistoryDays(int i, int i2, ChronoRecords.RecordsToFloat recordsToFloat) {
        ArrayList arrayList = new ArrayList();
        for (ChronoRecords chronoRecords : this.records.splitByDays(i, i2)) {
            arrayList.add(Pair.create(chronoRecords.getTo(), Float.valueOf(recordsToFloat.apply(chronoRecords))));
        }
        return arrayList;
    }

    private List<Pair<Date, Float>> getAggregatedHistoryMonths(int i, int i2, ChronoRecords.RecordsToFloat recordsToFloat) {
        ArrayList arrayList = new ArrayList();
        for (ChronoRecords chronoRecords : this.records.splitByMonth(i, i2)) {
            arrayList.add(Pair.create(chronoRecords.getTo(), Float.valueOf(recordsToFloat.apply(chronoRecords))));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClusteredChronoRecords getClusteredRecords() {
        return (ClusteredChronoRecords) this.valueCache.computeIfAbsent("ClusteredRecords", new ValueCache.Supplier() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats.2
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache.Supplier
            public Object get() {
                return new ClusteredChronoRecords(SocialJetlagStats.this.records);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ float lambda$getChronotypeHistory$1(ChronoRecords chronoRecords) {
        return new SocialJetlagStats(chronoRecords, this.useUTCforIrregularity).getChronotype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getSleepIrregularity$0() {
        if (this.records.size() < 5) {
            return Float.valueOf(-1.0f);
        }
        boolean z = this.useUTCforIrregularity;
        ChronoRecords chronoRecords = this.records;
        return Float.valueOf((ScienceUtil.stddev(this.records.getLengths()) + CyclicFloatKt.stdev(z ? chronoRecords.getMidSleepUTC() : chronoRecords.getMidSleeps(), 24.0f)) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ float lambda$getSleepIrregularityHistory$2(ChronoRecords chronoRecords) {
        return new SocialJetlagStats(chronoRecords, this.useUTCforIrregularity).getSleepIrregularity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$weekendFilter$3(ChronoRecord chronoRecord) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(chronoRecord.getTo());
        return calendar.get(7) == 1 || calendar.get(7) == 7;
    }

    private void splitFreeAndBusyDays() {
        this.valueCache.computeIfAbsent("FreeAndBusyDays", new ValueCache.Supplier() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats.1
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache.Supplier
            public Object get() {
                ClusteredChronoRecords clusteredRecords = SocialJetlagStats.this.getClusteredRecords();
                boolean zDecideIfClusteringIsGood = SocialJetlagStats.this.decideIfClusteringIsGood(clusteredRecords);
                SocialJetlagStats.this.valueCache.put("GoodClustering", Boolean.valueOf(zDecideIfClusteringIsGood));
                SocialJetlagStats socialJetlagStats = SocialJetlagStats.this;
                if (zDecideIfClusteringIsGood) {
                    socialJetlagStats.valueCache.put("FreeDays", clusteredRecords.getLabeledRecords(SleepLabel.FREE_DAY));
                    SocialJetlagStats.this.valueCache.put("BusyDays", clusteredRecords.getLabeledRecords(SleepLabel.BUSY_DAY));
                    SocialJetlagStats.this.valueCache.put("UnclassifiedDays", clusteredRecords.getLabeledRecords(SleepLabel.OUTLIER));
                    return null;
                }
                Pair<ChronoRecords, ChronoRecords> pairSplit = socialJetlagStats.records.split(SocialJetlagStats.this.weekendFilter());
                SocialJetlagStats.this.valueCache.put("FreeDays", pairSplit.getFirst());
                SocialJetlagStats.this.valueCache.put("BusyDays", pairSplit.getSecond());
                SocialJetlagStats.this.valueCache.put("UnclassifiedDays", new ChronoRecords());
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChronoRecords.RecordToBool weekendFilter() {
        return new Home$$ExternalSyntheticBUOutline0(29);
    }

    public float getAverageLengthHours() {
        if (this.records.size() < 5) {
            return -1.0f;
        }
        return ScienceUtil.avg(this.records.getLengths());
    }

    public float getAverageMidSleepHour() {
        if (this.records.size() < 5) {
            return -1.0f;
        }
        boolean z = this.useUTCforIrregularity;
        ChronoRecords chronoRecords = this.records;
        return CyclicFloatKt.center(z ? chronoRecords.getMidSleepUTC() : chronoRecords.getMidSleeps(), 24.0f);
    }

    public ChronoRecords getBusyDays() {
        splitFreeAndBusyDays();
        return (ChronoRecords) this.valueCache.get("BusyDays");
    }

    public float getChronotype() {
        return ((Float) this.valueCache.computeIfAbsent("Chronotype", new ValueCache.Supplier() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats.6
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache.Supplier
            public Object get() {
                float midSleepFreeDays = SocialJetlagStats.this.getMidSleepFreeDays();
                if (Float.isNaN(midSleepFreeDays)) {
                    return Float.valueOf(-1.0f);
                }
                float chronotypeQuantile = PopulationChronoStats.getChronotypeQuantile(midSleepFreeDays);
                Logger.logDebug("SocialJetlagStats.chronotype: " + midSleepFreeDays + " " + chronotypeQuantile);
                return Float.valueOf(chronotypeQuantile);
            }
        })).floatValue();
    }

    public List<Pair<Date, Float>> getChronotypeHistory(int i, int i2) {
        return getAggregatedHistoryMonths(i, i2, new SocialJetlagStats$$ExternalSyntheticLambda0(this, 1));
    }

    public ChronoRecords getFreeDays() {
        splitFreeAndBusyDays();
        return (ChronoRecords) this.valueCache.get("FreeDays");
    }

    public float getMidSleepBusyDays() {
        return ((Float) this.valueCache.computeIfAbsent("MidSleepBusyDays", new ValueCache.Supplier() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats.4
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache.Supplier
            public Object get() {
                ChronoRecords busyDays = SocialJetlagStats.this.getBusyDays();
                return busyDays.size() < 5 ? Float.valueOf(Float.NaN) : Float.valueOf(CyclicFloatKt.center(busyDays.getMidSleeps(), 24.0f));
            }
        })).floatValue();
    }

    public float getMidSleepFreeDays() {
        return ((Float) this.valueCache.computeIfAbsent("MidSleepFreeDays", new ValueCache.Supplier() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats.3
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache.Supplier
            public Object get() {
                ChronoRecords freeDays = SocialJetlagStats.this.getFreeDays();
                return freeDays.size() < 5 ? Float.valueOf(Float.NaN) : Float.valueOf(CyclicFloatKt.center(freeDays.getMidSleeps(), 24.0f));
            }
        })).floatValue();
    }

    public float getSleepIrregularity() {
        return ((Float) this.valueCache.computeIfAbsent("SleepIrregularity", new SocialJetlagStats$$ExternalSyntheticLambda0(this, 0))).floatValue();
    }

    public List<Pair<Date, Float>> getSleepIrregularityHistory(int i, int i2) {
        return getAggregatedHistoryDays(i, i2, new SocialJetlagStats$$ExternalSyntheticLambda0(this, 2));
    }

    public float getSocialJetLag() {
        return ((Float) this.valueCache.computeIfAbsent("SocialJetLag", new ValueCache.Supplier() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats.5
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache.Supplier
            public Object get() {
                float midSleepBusyDays = SocialJetlagStats.this.getMidSleepBusyDays();
                float midSleepFreeDays = SocialJetlagStats.this.getMidSleepFreeDays();
                return (Float.isNaN(midSleepBusyDays) || Float.isNaN(midSleepFreeDays)) ? Float.valueOf(Float.NaN) : Float.valueOf(Math.abs(midSleepBusyDays - midSleepFreeDays));
            }
        })).floatValue();
    }

    public ChronoRecords getUnclassifiedDays() {
        splitFreeAndBusyDays();
        return (ChronoRecords) this.valueCache.get("UnclassifiedDays");
    }

    public SocialJetlagStats narrow(Date date, Date date2) {
        return new SocialJetlagStats(this.records.narrow(date, date2), this.useUTCforIrregularity);
    }

    public int size() {
        return this.records.size();
    }
}
