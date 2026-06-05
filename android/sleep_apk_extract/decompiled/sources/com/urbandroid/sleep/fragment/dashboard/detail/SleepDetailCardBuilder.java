package com.urbandroid.sleep.fragment.dashboard.detail;

import android.app.Activity;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.Events;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.fragment.dashboard.CardBuilder;
import com.urbandroid.sleep.fragment.dashboard.card.AiCard;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.LastCard;
import com.urbandroid.sleep.fragment.dashboard.card.NoiseRecordCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailActigraphCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailAdviceRdiCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailHypnogramCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailMapCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailPhasesCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailScoreCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailSensorCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailTimelineCard;
import com.urbandroid.sleep.graph.GraphLegend;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R,\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0)8\u0006¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&R\u0014\u00103\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailCardBuilder;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/fragment/dashboard/CardBuilder;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "card", "", "findPosition", "(Landroid/app/Activity;Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;)Ljava/lang/Integer;", "", "buildCards", "(Landroid/app/Activity;)Ljava/util/List;", "Landroid/content/Context;", "", "loadData", "(Landroid/content/Context;)V", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "setSleepRecord", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "prevSleepRecord", "getPrevSleepRecord", "setPrevSleepRecord", "nextSleepRecord", "getNextSleepRecord", "setNextSleepRecord", "sleepRecords", "Ljava/util/List;", "getSleepRecords", "()Ljava/util/List;", "setSleepRecords", "(Ljava/util/List;)V", "", "cachedCards", "getCachedCards", "setCachedCards", "Lcom/urbandroid/sleep/domain/Noise;", "noises", "getNoises", "", "getTag", "()Ljava/lang/String;", "tag", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailCardBuilder implements FeatureLogger, CardBuilder {
    private List<DashboardCard<?>> cachedCards;
    private final CoroutineScope coroutineScope;
    private SleepRecord nextSleepRecord;
    private final List<Noise> noises;
    private SleepRecord prevSleepRecord;
    private SleepRecord sleepRecord;
    private List<? extends SleepRecord> sleepRecords;

    public SleepDetailCardBuilder(CoroutineScope coroutineScope) {
        coroutineScope.getClass();
        this.coroutineScope = coroutineScope;
        this.cachedCards = new ArrayList();
        this.noises = new ArrayList();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.CardBuilder
    public List<DashboardCard<?>> buildCards(Activity context) {
        Events events;
        context.getClass();
        Iterator<T> it = this.cachedCards.iterator();
        while (it.hasNext()) {
            ((DashboardCard) it.next()).onCardDestroyed();
        }
        this.cachedCards.clear();
        ArrayList arrayList = new ArrayList();
        SleepRecord sleepRecord = this.sleepRecord;
        if (sleepRecord != null) {
            arrayList.add(new SleepDetailScoreCard(context, sleepRecord, this.sleepRecords));
            arrayList.add(new SleepDetailCommentCard(context, sleepRecord));
            if (this.nextSleepRecord == null) {
                String string = context.getString(R.string.sleep_assistant_today);
                string.getClass();
                arrayList.add(new AiCard(context, string, "TodayAiPrompt"));
            }
            arrayList.add(new SleepDetailTimelineCard(context, this.sleepRecord));
            if (sleepRecord.hasHypnogram()) {
                arrayList.add(new SleepDetailHypnogramCard(context, sleepRecord));
                arrayList.add(new SleepDetailPhasesCard(context, sleepRecord));
            }
            if (sleepRecord.hasActigraph()) {
                arrayList.add(new SleepDetailActigraphCard(context, sleepRecord));
            }
            if (sleepRecord.getNoiseHistory().size() > 2) {
                arrayList.add(new NoiseRecordCard(context, sleepRecord, this.noises));
            }
            int measurementLength = (sleepRecord.getMeasurementLength() / 60) + 2;
            if (sleepRecord.getEvents().hasLabel(EventLabel.SPO2, measurementLength)) {
                arrayList.add(new SleepDetailSensorCard(context, sleepRecord, DashboardCard.Type.SLEEP_SENSOR_SPO2, GraphLegend.SPO2));
            }
            int iResolveRdi = sleepRecord.resolveRdi();
            if (iResolveRdi > 10 && (events = sleepRecord.getEvents()) != null && events.hasLabel(EventLabel.APNEA)) {
                arrayList.add(new SleepDetailAdviceRdiCard(context, sleepRecord, iResolveRdi));
            }
            if (sleepRecord.getEvents().hasLabel(EventLabel.HR, measurementLength)) {
                arrayList.add(new SleepDetailSensorCard(context, sleepRecord, DashboardCard.Type.SLEEP_SENSOR_HR, GraphLegend.HR));
            }
            if (sleepRecord.getEvents().hasLabel(EventLabel.SDNN, measurementLength)) {
                arrayList.add(new SleepDetailSensorCard(context, sleepRecord, DashboardCard.Type.SLEEP_SENSOR_HRV, GraphLegend.HRV));
            }
            if (sleepRecord.getEvents().hasLabel(EventLabel.RR, measurementLength)) {
                arrayList.add(new SleepDetailSensorCard(context, sleepRecord, DashboardCard.Type.SLEEP_SENSOR_RR, GraphLegend.RESPIRATORY_RATE));
            }
            if (sleepRecord.getEvents().hasLabel(EventLabel.LUX, measurementLength)) {
                arrayList.add(new SleepDetailSensorCard(context, sleepRecord, DashboardCard.Type.SLEEP_SENSOR_LIGHT, GraphLegend.LIGHT));
            }
            if (sleepRecord.getGeo() != null) {
                arrayList.add(new SleepDetailMapCard(context, sleepRecord));
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((DashboardCard) it2.next()).isPinned()) {
                    arrayList.add(0, new SleepDetailTimelineCard(context, this.sleepRecord));
                    break;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((DashboardCard) obj).isPinned()) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!((DashboardCard) obj2).isPinned()) {
                arrayList3.add(obj2);
            }
        }
        LastCard lastCard = new LastCard(context, CollectionsKt.toList(arrayList));
        List<DashboardCard<?>> list = this.cachedCards;
        list.addAll(arrayList2);
        list.addAll(arrayList3);
        list.add(lastCard);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (!((DashboardCard) obj3).isRemoved()) {
                arrayList4.add(obj3);
            }
        }
        List<DashboardCard<?>> mutableList = CollectionsKt.toMutableList((Collection) arrayList4);
        this.cachedCards = mutableList;
        List<DashboardCard<?>> list2 = mutableList;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it3 = list2.iterator();
        while (it3.hasNext()) {
            ((DashboardCard) it3.next()).setCardBuilder(this);
            arrayList5.add(Unit.INSTANCE);
        }
        return CollectionsKt.toList(this.cachedCards);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.CardBuilder
    public Integer findPosition(Activity context, DashboardCard<?> card) {
        Integer next;
        context.getClass();
        card.getClass();
        if (this.cachedCards.size() == 0) {
            buildCards(context);
        }
        Iterator<Integer> it = CollectionsKt.getIndices(this.cachedCards).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (this.cachedCards.get(next.intValue()).getType() == card.getType()) {
                break;
            }
        }
        return next;
    }

    public final SleepRecord getNextSleepRecord() {
        return this.nextSleepRecord;
    }

    public final SleepRecord getPrevSleepRecord() {
        return this.prevSleepRecord;
    }

    public final SleepRecord getSleepRecord() {
        return this.sleepRecord;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return "Detail";
    }

    public void loadData(Context context) {
        SleepRecord sleepRecord;
        SleepRecord sleepRecord2;
        SleepRecord sleepRecord3;
        context.getClass();
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        SleepRecord sleepRecord4 = this.sleepRecord;
        if (sleepRecord4 != null) {
            SleepRecord sleepRecordLoadFullRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().loadFullRecord(sleepRecord4.getFromTime());
            this.sleepRecord = sleepRecordLoadFullRecord;
            if (sleepRecordLoadFullRecord != null && !sleepRecordLoadFullRecord.isFinished() && (sleepRecord3 = this.sleepRecord) != null) {
                sleepRecord3.finish(new Date());
            }
            SleepRecord sleepRecord5 = this.sleepRecord;
            if (sleepRecord5 != null && !sleepRecord5.hasActigraph() && (sleepRecord = this.sleepRecord) != null && sleepRecord.hasHypnogram() && (sleepRecord2 = this.sleepRecord) != null) {
                sleepRecord2.computeAll();
            }
            SleepRecord sleepRecord6 = this.sleepRecord;
            if (sleepRecord6 != null && sleepRecord6.isFinished() && sleepRecord6.hasHypnogram() && sleepRecord6.getQuality() == -2.0f) {
                float quality = sleepRecord6.getQuality();
                sleepRecord6.computeAll();
                if (sleepRecord6.getQuality() != quality) {
                    SharedApplicationContext.getInstance().getSleepRecordRepository().recordDataUpdated(sleepRecord4, new SleepRecord(sleepRecord4, false), new UndoOperationGroup("IGNORE", null));
                }
            }
            this.sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getPrevNextSleepRecords(sleepRecord4);
            this.nextSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getNextRecord(sleepRecord4.getFromTime(), true);
            this.prevSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getPrevRecord(sleepRecord4.getFromTime(), true);
            this.noises.clear();
            List<Noise> list = this.noises;
            List<Noise> noises = sleepRecordRepository.getNoises(99, sleepRecord4.getFromTime(), sleepRecord4.getToTime());
            noises.getClass();
            list.addAll(noises);
        }
    }

    public final void setSleepRecord(SleepRecord sleepRecord) {
        this.sleepRecord = sleepRecord;
    }
}
