package com.urbandroid.sleep.addon.stats.model.collector;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\bN\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u000f\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010'\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010*R\"\u0010.\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010'\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010*R\"\u00101\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010'\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010*R\"\u00104\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00105\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u00108R\"\u0010<\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010*R\"\u0010?\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00105\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u00108R\"\u0010G\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010'\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010*R\"\u0010J\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010'\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010*R\"\u0010M\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010'\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010*R\"\u0010P\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010'\u001a\u0004\bQ\u0010\u000b\"\u0004\bR\u0010*R\"\u0010S\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010'\u001a\u0004\bT\u0010\u000b\"\u0004\bU\u0010*R\"\u0010V\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010'\u001a\u0004\bW\u0010\u000b\"\u0004\bX\u0010*R\"\u0010Y\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010'\u001a\u0004\bZ\u0010\u000b\"\u0004\b[\u0010*R\"\u0010\\\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010'\u001a\u0004\b]\u0010\u000b\"\u0004\b^\u0010*R\"\u0010_\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u00105\u001a\u0004\b`\u0010\u0011\"\u0004\ba\u00108¨\u0006b"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/collector/AverageStatRecord;", "Lcom/urbandroid/sleep/addon/stats/model/IMeasureRecord;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "records", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "", "getTrackLengthInHours", "()F", "getLengthInHours", "getQuality", "getRating", "", "getSnore", "()I", "getSmart", "getNoiseLevel", "", "getCycles", "()D", "getSnooze", "getHrvBefore", "getHrvAfter", "getHrv", "getHr", "getMinHr", "getIrregularityInMinutes", "getIrregularityIndex", "getRdi", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/util/List;", "getRecords", "()Ljava/util/List;", "trackLengthInHoursCache", "F", "getTrackLengthInHoursCache", "setTrackLengthInHoursCache", "(F)V", "lengthInHoursCache", "getLengthInHoursCache", "setLengthInHoursCache", "qualityCache", "getQualityCache", "setQualityCache", "ratingCache", "getRatingCache", "setRatingCache", "snoreCache", "I", "getSnoreCache", "setSnoreCache", "(I)V", "smartCache", "getSmartCache", "setSmartCache", "noiseLevelCache", "getNoiseLevelCache", "setNoiseLevelCache", "cyclesCache", "D", "getCyclesCache", "setCyclesCache", "(D)V", "snoozeCache", "getSnoozeCache", "setSnoozeCache", "hrvBeforeCache", "getHrvBeforeCache", "setHrvBeforeCache", "hrvAfterCache", "getHrvAfterCache", "setHrvAfterCache", "hrvGainCache", "getHrvGainCache", "setHrvGainCache", "hrvCache", "getHrvCache", "setHrvCache", "hrCache", "getHrCache", "setHrCache", "minHrCache", "getMinHrCache", "setMinHrCache", "irregularityInMinutesCache", "getIrregularityInMinutesCache", "setIrregularityInMinutesCache", "irregularityIndexCache", "getIrregularityIndexCache", "setIrregularityIndexCache", "rdiCache", "getRdiCache", "setRdiCache", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AverageStatRecord implements IMeasureRecord {
    private final Context context;
    private double cyclesCache;
    private float hrCache;
    private float hrvAfterCache;
    private float hrvBeforeCache;
    private float hrvCache;
    private float hrvGainCache;
    private float irregularityInMinutesCache;
    private float irregularityIndexCache;
    private float lengthInHoursCache;
    private float minHrCache;
    private float noiseLevelCache;
    private float qualityCache;
    private float ratingCache;
    private int rdiCache;
    private final List<StatRecord> records;
    private int smartCache;
    private int snoozeCache;
    private int snoreCache;
    private float trackLengthInHoursCache;

    /* JADX WARN: Multi-variable type inference failed */
    public AverageStatRecord(Context context, List<? extends StatRecord> list) {
        context.getClass();
        list.getClass();
        this.context = context;
        this.records = list;
        this.trackLengthInHoursCache = -1.0f;
        this.lengthInHoursCache = -1.0f;
        this.qualityCache = -1.0f;
        this.ratingCache = -1.0f;
        this.snoreCache = -1;
        this.smartCache = -1;
        this.noiseLevelCache = -1.0f;
        this.snoozeCache = -1;
        this.hrvBeforeCache = -1.0f;
        this.hrvAfterCache = -1.0f;
        this.hrvGainCache = -1.0E21f;
        this.hrvCache = -1.0f;
        this.hrCache = -1.0f;
        this.minHrCache = -1.0f;
        this.irregularityInMinutesCache = -1.0f;
        this.irregularityIndexCache = -1.0f;
        this.rdiCache = -1;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public double getCycles() {
        double d = this.cyclesCache;
        if (d != 0.0d) {
            return d;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getCycles() > 0.0d) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Double.valueOf(((StatRecord) it.next()).getCycles()));
        }
        double dAverageOfDouble = CollectionsKt___CollectionsKt.averageOfDouble(arrayList2);
        this.cyclesCache = dAverageOfDouble;
        return dAverageOfDouble;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHr() {
        float f = this.hrCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getHr() != -1.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getHr()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.hrCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrv() {
        float f = this.hrvCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getHrv() != -1.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getHrv()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.hrvCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrvAfter() {
        float f = this.hrvAfterCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getHrvAfter() != -1.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getHrvAfter()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.hrvAfterCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrvBefore() {
        float f = this.hrvBeforeCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getHrvBefore() != -1.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getHrvBefore()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.hrvBeforeCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getIrregularityInMinutes() {
        float f = this.irregularityInMinutesCache;
        if (f != -1.0f) {
            return f;
        }
        float sleepIrregularity = SocialJetlagStats.create(this.records, this.context).getSleepIrregularity() * 60.0f;
        this.irregularityInMinutesCache = sleepIrregularity;
        return sleepIrregularity;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getIrregularityIndex() {
        float f = this.irregularityIndexCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getIrregularityIndex() != -1.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getIrregularityIndex()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.irregularityIndexCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getLengthInHours() {
        float f = this.lengthInHoursCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((StatRecord) it.next()).getLengthInHours()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList);
        this.lengthInHoursCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getMinHr() {
        float f = this.minHrCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getMinHr() != -1.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getMinHr()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.minHrCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getNoiseLevel() {
        float f = this.noiseLevelCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getNoiseLevel() != -1.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getNoiseLevel()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.noiseLevelCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getQuality() {
        float f = this.qualityCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            StatRecord statRecord = (StatRecord) obj;
            if (statRecord.getQuality() != -1.0f && statRecord.getQuality() != -2.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getQuality()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.qualityCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getRating() {
        float f = this.ratingCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getRating() > 0.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((StatRecord) it.next()).getRating()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2);
        this.ratingCache = fAverageOfFloat;
        return fAverageOfFloat;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getRdi() {
        int i = this.rdiCache;
        if (i != -1) {
            return i;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getRdi() != -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((StatRecord) it.next()).getRdi()));
        }
        int iAverageOfInt = (int) CollectionsKt___CollectionsKt.averageOfInt(arrayList2);
        this.rdiCache = iAverageOfInt;
        return iAverageOfInt;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSmart() {
        int i = this.smartCache;
        if (i != -1) {
            return i;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getSmart() != -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((StatRecord) it.next()).getSmart()));
        }
        int iAverageOfInt = (int) CollectionsKt___CollectionsKt.averageOfInt(arrayList2);
        this.smartCache = iAverageOfInt;
        return iAverageOfInt;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSnooze() {
        int i = this.snoozeCache;
        if (i != -1) {
            return i;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getSnooze() != -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((StatRecord) it.next()).getSnooze()));
        }
        int iAverageOfInt = (int) CollectionsKt___CollectionsKt.averageOfInt(arrayList2);
        this.snoozeCache = iAverageOfInt;
        return iAverageOfInt;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSnore() {
        int i = this.snoreCache;
        if (i != -1) {
            return i;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((StatRecord) obj).getSnore() != -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((StatRecord) it.next()).getSnore()));
        }
        int iAverageOfInt = (int) CollectionsKt___CollectionsKt.averageOfInt(arrayList2);
        this.snoreCache = iAverageOfInt;
        return iAverageOfInt;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getTrackLengthInHours() {
        float f = this.trackLengthInHoursCache;
        if (f != -1.0f) {
            return f;
        }
        List<StatRecord> list = this.records;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((StatRecord) it.next()).getTrackLengthInHours()));
        }
        float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList);
        this.trackLengthInHoursCache = fAverageOfFloat;
        return fAverageOfFloat;
    }
}
