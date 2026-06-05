package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import com.urbandroid.sleep.addon.stats.model.NoRecordsException;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"filterByGrossLength", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "records", "", "minLen", "", "maxLen", "getStatRecordsFromRepo", "lookbackDays", "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SleepStatsUtilKt {
    public static final List<StatRecord> filterByGrossLength(Collection<? extends StatRecord> collection, double d, double d2) {
        collection.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            double trackLengthInHours = ((StatRecord) obj).getTrackLengthInHours();
            if (d <= trackLengthInHours && trackLengthInHours <= d2) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    public static final List<StatRecord> getStatRecordsFromRepo(int i) {
        StatRepo statRepo = new StatRepo();
        try {
            statRepo.initialize(SharedApplicationContext.getInstance().getContext(), i, StatRepo.Mode.SCORE);
            List<StatRecord> mergedStatRecords = statRepo.getMergedStatRecords();
            mergedStatRecords.getClass();
            return mergedStatRecords;
        } catch (NoRecordsException unused) {
            return CollectionsKt.emptyList();
        }
    }
}
