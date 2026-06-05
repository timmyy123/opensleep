package com.urbandroid.sleep.fragment.dashboard.morning;

import android.app.Activity;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.Events;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.fragment.dashboard.CardBuilder;
import com.urbandroid.sleep.fragment.dashboard.card.AdviceCard;
import com.urbandroid.sleep.fragment.dashboard.card.AiCard;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.DismissNextAlarmCard;
import com.urbandroid.sleep.fragment.dashboard.card.InterestingNoiseCard;
import com.urbandroid.sleep.fragment.dashboard.card.LastCard;
import com.urbandroid.sleep.fragment.dashboard.card.NoiseRecordCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailActigraphCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailAdviceRdiCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailHypnogramCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailPhasesCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailScoreCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailSensorCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailTimelineCard;
import com.urbandroid.sleep.fragment.dashboard.card.WeatherCard;
import com.urbandroid.sleep.graph.GraphLegend;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R,\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001e\u001a\u0004\b2\u0010 \"\u0004\b3\u0010\"R\u001d\u00105\u001a\b\u0012\u0004\u0012\u000204008\u0006¢\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010 R(\u00107\u001a\b\u0012\u0004\u0012\u000204008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001e\u001a\u0004\b8\u0010 \"\u0004\b9\u0010\"R\u0014\u0010=\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningCardBuilder;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/fragment/dashboard/CardBuilder;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "card", "", "findPosition", "(Landroid/app/Activity;Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;)Ljava/lang/Integer;", "", "buildCards", "(Landroid/app/Activity;)Ljava/util/List;", "Landroid/content/Context;", "", "loadData", "(Landroid/content/Context;)V", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "setSleepRecord", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "sleepRecords", "Ljava/util/List;", "getSleepRecords", "()Ljava/util/List;", "setSleepRecords", "(Ljava/util/List;)V", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "alarm", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "getAlarm", "()Lcom/urbandroid/sleep/alarmclock/Alarm;", "setAlarm", "(Lcom/urbandroid/sleep/alarmclock/Alarm;)V", "", "isAlarmSnoozed", "Z", "()Z", "setAlarmSnoozed", "(Z)V", "", "cachedCards", "getCachedCards", "setCachedCards", "Lcom/urbandroid/sleep/domain/Noise;", "noises", "getNoises", "interestingNoises", "getInterestingNoises", "setInterestingNoises", "", "getTag", "()Ljava/lang/String;", "tag", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MorningCardBuilder implements FeatureLogger, CardBuilder {
    private Alarm alarm;
    private List<DashboardCard<?>> cachedCards;
    private final CoroutineScope coroutineScope;
    private List<Noise> interestingNoises;
    private boolean isAlarmSnoozed;
    private final List<Noise> noises;
    private SleepRecord sleepRecord;
    private List<? extends SleepRecord> sleepRecords;

    public MorningCardBuilder(CoroutineScope coroutineScope) {
        coroutineScope.getClass();
        this.coroutineScope = coroutineScope;
        this.cachedCards = new ArrayList();
        this.noises = new ArrayList();
        this.interestingNoises = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable loadData$lambda$0$1(Noise noise) {
        noise.getClass();
        return Boolean.valueOf(Tag.hasTag(noise.getComment(), Tag.SNORE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable loadData$lambda$0$2(Noise noise) {
        noise.getClass();
        return Long.valueOf(noise.getFromTime());
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.CardBuilder
    public List<DashboardCard<?>> buildCards(Activity context) {
        Alarm alarm;
        Events events;
        Alarm alarm2;
        context.getClass();
        Iterator<T> it = this.cachedCards.iterator();
        while (it.hasNext()) {
            ((DashboardCard) it.next()).onCardDestroyed();
        }
        this.cachedCards.clear();
        ArrayList arrayList = new ArrayList();
        SleepRecord sleepRecord = this.sleepRecord;
        if (sleepRecord != null) {
            if (!SharedApplicationContext.getSettings().isHideMorningStats() || sleepRecord.getRating() > 0.0f) {
                arrayList.add(new SleepDetailScoreCard(context, sleepRecord, this.sleepRecords));
            }
            arrayList.add(new SleepDetailCommentCard(context, sleepRecord));
            String string = context.getString(R.string.sleep_assistant_today);
            string.getClass();
            arrayList.add(new AiCard(context, string, "TodayAiPrompt"));
            boolean z = Alarms.isSnoozing(context) && Alarms.getSnoozeTime(context) > System.currentTimeMillis();
            this.isAlarmSnoozed = z;
            if ((z || ((alarm2 = this.alarm) != null && alarm2.enabled && alarm2.time < System.currentTimeMillis() + 14400000)) && (alarm = this.alarm) != null) {
                arrayList.add(new DismissNextAlarmCard(context, alarm, this.isAlarmSnoozed));
            }
            if (SharedApplicationContext.getSettings().isWeather()) {
                arrayList.add(new WeatherCard(context, sleepRecord));
            }
            if (!this.interestingNoises.isEmpty()) {
                arrayList.add(new InterestingNoiseCard(context, new ArrayList(this.interestingNoises)));
            }
            arrayList.add(new AdviceCard(context));
            arrayList.add(new SleepDetailTimelineCard(context, this.sleepRecord));
            if (sleepRecord.hasHypnogram()) {
                arrayList.add(new SleepDetailHypnogramCard(context, sleepRecord));
                arrayList.add(new SleepDetailPhasesCard(context, sleepRecord));
            } else if (sleepRecord.hasActigraph()) {
                arrayList.add(new SleepDetailActigraphCard(context, sleepRecord));
            }
            if (sleepRecord.getNoiseHistory().size() > 2) {
                arrayList.add(new NoiseRecordCard(context, sleepRecord, this.noises));
            }
            int measurementLength = (sleepRecord.getMeasurementLength() / 60) + 2;
            if (sleepRecord.getEvents().hasLabel(EventLabel.SPO2, measurementLength)) {
                arrayList.add(new SleepDetailSensorCard(context, sleepRecord, DashboardCard.Type.SLEEP_SENSOR_SPO2, GraphLegend.SPO2));
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
            int iResolveRdi = sleepRecord.resolveRdi();
            if (iResolveRdi > 10 && (events = sleepRecord.getEvents()) != null && events.hasLabel(EventLabel.APNEA)) {
                arrayList.add(new SleepDetailAdviceRdiCard(context, sleepRecord, iResolveRdi));
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

    public final SleepRecord getSleepRecord() {
        return this.sleepRecord;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return "Morning";
    }

    public void loadData(Context context) {
        SleepRecord sleepRecord;
        context.getClass();
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        SleepRecord sleepRecord2 = this.sleepRecord;
        if (sleepRecord2 != null) {
            this.sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getPrevNextSleepRecords(sleepRecord2);
            this.sleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().loadFullRecord(sleepRecord2.getFromTime());
            this.noises.clear();
            List<Noise> list = this.noises;
            List<Noise> noises = sleepRecordRepository.getNoises(99, sleepRecord2.getFromTime(), sleepRecord2.getToTime());
            noises.getClass();
            list.addAll(noises);
            this.interestingNoises.clear();
            List<Noise> list2 = this.interestingNoises;
            List<Noise> noisesWithComment = sleepRecordRepository.getNoisesWithComment(20, sleepRecord2.getFromTime(), sleepRecord2.getToTime());
            noisesWithComment.getClass();
            list2.addAll(noisesWithComment);
            List<Noise> list3 = this.interestingNoises;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list3) {
                Noise noise = (Noise) obj;
                if ((noise.getFromTime() - sleepRecord2.getFromTime()) / 1000 > 20 && (sleepRecord2.getToTime() - noise.getToTime()) / 1000 > 20) {
                    String comment = noise.getComment();
                    Tag[] interestingSoundTags = InterestingNoiseCard.INSTANCE.getInterestingSoundTags();
                    if (Tag.hasOneOfTags(comment, (Tag[]) Arrays.copyOf(interestingSoundTags, interestingSoundTags.length))) {
                        arrayList.add(obj);
                    }
                }
            }
            CollectionsKt.sortWith(this.interestingNoises, ComparisonsKt.compareBy(new AiPrompt$$ExternalSyntheticLambda0(13), new AiPrompt$$ExternalSyntheticLambda0(14)));
            SleepRecord sleepRecord3 = this.sleepRecord;
            if (sleepRecord3 != null && !sleepRecord3.isFinished() && (sleepRecord = this.sleepRecord) != null) {
                sleepRecord.finish(new Date());
            }
        }
        Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context);
        this.alarm = alarmCalculateNextAlert;
        Logger.logInfo("DismissNextAlarmCard load " + alarmCalculateNextAlert);
    }

    public final void setSleepRecord(SleepRecord sleepRecord) {
        this.sleepRecord = sleepRecord;
    }
}
