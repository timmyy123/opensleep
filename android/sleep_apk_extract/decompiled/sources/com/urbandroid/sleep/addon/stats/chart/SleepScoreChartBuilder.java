package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.work.Data$$ExternalSyntheticLambda0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.chart.ScoreRadarPieView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/SleepScoreChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/chart/IChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/SleepScore;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "getGraphTitle", "()Ljava/lang/String;", "Landroid/view/View;", "createView", "(Landroid/content/Context;)Landroid/view/View;", "", "records", "buildChart", "(Landroid/content/Context;Ljava/util/List;)Lcom/urbandroid/sleep/addon/stats/chart/IChartBuilder;", "getHelpUrl", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView$DataRecord;", "scoreData", "Ljava/util/concurrent/atomic/AtomicReference;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepScoreChartBuilder implements IChartBuilder<SleepScore> {
    private static final Set<SleepScore.ScoreMeasure> ORDERING = SetsKt.setOf((Object[]) new SleepScore.ScoreMeasure[]{SleepScore.ScoreMeasure.IRREGULARITY, SleepScore.ScoreMeasure.DEEP_SLEEP, SleepScore.ScoreMeasure.DURATION, SleepScore.ScoreMeasure.EFFICIENCY, SleepScore.ScoreMeasure.RATING, SleepScore.ScoreMeasure.SNORE, SleepScore.ScoreMeasure.HRV, SleepScore.ScoreMeasure.RDI});
    private final Context context;
    private AtomicReference<List<ScoreRadarPieView.DataRecord>> scoreData;

    public SleepScoreChartBuilder(Context context) {
        context.getClass();
        this.context = context;
        this.scoreData = new AtomicReference<>(CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScoreRadarPieView.DataRecord createView$lambda$0(ScoreRadarPieView.DataRecord dataRecord) {
        dataRecord.getClass();
        return ScoreRadarPieView.DataRecord.copy$default(dataRecord, null, Math.min(dataRecord.getValue(), 100) / 20, 0, 5, null);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public IChartBuilder<SleepScore> buildChart(Context context, List<SleepScore> records) {
        context.getClass();
        records.getClass();
        SleepScore sleepScore = (SleepScore) CollectionsKt.firstOrNull((List) records);
        if (sleepScore == null) {
            sleepScore = new SleepScore(0, 0);
        }
        Map<SleepScore.ScoreMeasure, SleepScore.ScoreResult> measureScoreMap = sleepScore.getMeasureScoreMap();
        measureScoreMap.getClass();
        SortedMap sortedMap = MapsKt.toSortedMap(measureScoreMap, new Comparator() { // from class: com.urbandroid.sleep.addon.stats.chart.SleepScoreChartBuilder$buildChart$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(CollectionsKt___CollectionsKt.indexOf(SleepScoreChartBuilder.ORDERING, (SleepScore.ScoreMeasure) t)), Integer.valueOf(CollectionsKt___CollectionsKt.indexOf(SleepScoreChartBuilder.ORDERING, (SleepScore.ScoreMeasure) t2)));
            }
        });
        for (Map.Entry entry : sortedMap.entrySet()) {
            Logger.logInfo("SleepScore: " + context.getString(((SleepScore.ScoreMeasure) entry.getKey()).getLabel()) + " - " + ((SleepScore.ScoreResult) entry.getValue()).progress + "%");
        }
        AtomicReference<List<ScoreRadarPieView.DataRecord>> atomicReference = this.scoreData;
        ArrayList arrayList = new ArrayList(sortedMap.size());
        for (Map.Entry entry2 : sortedMap.entrySet()) {
            int i = ((SleepScore.ScoreResult) entry2.getValue()).progress;
            String string = context.getString(((SleepScore.ScoreMeasure) entry2.getKey()).getLabel());
            string.getClass();
            arrayList.add(new ScoreRadarPieView.DataRecord(string, i, ((SleepScore.ScoreMeasure) entry2.getKey()).getColor()));
        }
        atomicReference.set(arrayList);
        return this;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public View createView(Context context) {
        context.getClass();
        List<ScoreRadarPieView.DataRecord> list = this.scoreData.get();
        list.getClass();
        return new ScoreRadarPieView(context, null, 5, SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence(list), new Data$$ExternalSyntheticLambda0(29))), 2, null);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        String string = this.context.getString(R.string.score);
        string.getClass();
        return string;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return null;
    }
}
