package com.urbandroid.sleep.addon.stats;

import com.urbandroid.sleep.addon.stats.SleepScore;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\"\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"", "Lcom/urbandroid/sleep/addon/stats/SleepScore$ScoreMeasure;", "ALL_MEASURES", "Ljava/util/List;", "getALL_MEASURES", "()Ljava/util/List;", "", "SCORE_CARD_MEASURES", "getSCORE_CARD_MEASURES", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class StatsRepoLoaderKt {
    private static final List<SleepScore.ScoreMeasure> ALL_MEASURES;
    private static final List<SleepScore.ScoreMeasure> SCORE_CARD_MEASURES;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<SleepScore.ScoreMeasure> entries$0 = EnumEntriesKt.enumEntries(SleepScore.ScoreMeasure.values());
    }

    static {
        List<SleepScore.ScoreMeasure> mutableList = CollectionsKt.toMutableList((Collection) EntriesMappings.entries$0);
        mutableList.remove(SleepScore.ScoreMeasure.SCORE);
        ALL_MEASURES = mutableList;
        SCORE_CARD_MEASURES = CollectionsKt.listOf((Object[]) new SleepScore.ScoreMeasure[]{SleepScore.ScoreMeasure.DURATION, SleepScore.ScoreMeasure.IRREGULARITY, SleepScore.ScoreMeasure.DEEP_SLEEP, SleepScore.ScoreMeasure.EFFICIENCY, SleepScore.ScoreMeasure.SNORE, SleepScore.ScoreMeasure.RATING});
    }

    public static final List<SleepScore.ScoreMeasure> getALL_MEASURES() {
        return ALL_MEASURES;
    }
}
