package com.urbandroid.sleep.ai;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoader;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepRegularityIndexUtil2;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/ai/TodayAiPrompt;", "Lcom/urbandroid/sleep/ai/AiPrompt;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "doLoad", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TodayAiPrompt extends AiPrompt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.ai.TodayAiPrompt$doLoad$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.ai.TodayAiPrompt", f = "TodayAiPrompt.kt", l = {58, 80}, m = "doLoad", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TodayAiPrompt.this.doLoad(this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TodayAiPrompt(Context context) {
        String strM = zza$$ExternalSyntheticOutline0.m(context, R.string.today);
        String string = context.getString(R.string.sleep_assistant_today);
        string.getClass();
        super(context, strM, string);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.urbandroid.sleep.ai.AiPrompt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doLoad(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        TodayAiPrompt todayAiPrompt;
        List list;
        Settings settings;
        StringBuilder sb;
        Map map;
        SleepRecord sleepRecord;
        List list2;
        DbSleepRecordRepository dbSleepRecordRepository;
        List<SleepRecord> list3;
        int i;
        Interval interval;
        SleepScore sleepScore;
        int i2;
        Settings settings2;
        StatRepo statRepo;
        SleepScore sleepScore2;
        List<StatRecord> mergedStatRecords;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
                todayAiPrompt = this;
            } else {
                todayAiPrompt = this;
                anonymousClass1 = todayAiPrompt.new AnonymousClass1(continuation);
            }
        }
        Object objLoad = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = anonymousClass1.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(objLoad);
            DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
            SleepRecord lastSleepRecord = sleepRecordRepository.getLastSleepRecord();
            List<SleepRecord> sleepRecords = sleepRecordRepository.getSleepRecords(0, 10, false);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            Settings settings3 = new Settings(todayAiPrompt.getContext());
            int dayCutOffHour = settings3.getDayCutOffHour();
            StringBuilder sb2 = new StringBuilder();
            SleepScore sleepScore3 = new SleepScore();
            for (SleepRecord sleepRecord2 : sleepRecords) {
                Interval cutOffInterval = DateUtil.getCutOffInterval(sleepRecord2.getTo(), dayCutOffHour);
                if (arrayList.contains(cutOffInterval)) {
                    List list4 = (List) linkedHashMap.get(cutOffInterval);
                    if (list4 != null) {
                        Boxing.boxBoolean(list4.add(sleepRecord2));
                    }
                } else {
                    cutOffInterval.getClass();
                    arrayList.add(cutOffInterval);
                    linkedHashMap.put(cutOffInterval, CollectionsKt.mutableListOf(sleepRecord2));
                }
            }
            if (arrayList.size() == 0) {
                return "Sorry, there are no data.";
            }
            Interval interval2 = (Interval) arrayList.get(0);
            List list5 = (List) linkedHashMap.get(interval2);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
            TodayAiPrompt$doLoad$merged$1 todayAiPrompt$doLoad$merged$1 = new TodayAiPrompt$doLoad$merged$1(list5, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(sleepRecordRepository);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(lastSleepRecord);
            anonymousClass1.L$2 = sleepRecords;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(arrayList);
            anonymousClass1.L$5 = settings3;
            anonymousClass1.L$6 = sb2;
            anonymousClass1.L$7 = sleepScore3;
            anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(interval2);
            anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(list5);
            anonymousClass1.I$0 = dayCutOffHour;
            anonymousClass1.label = 1;
            Object objWithContext = BuildersKt.withContext(coroutineDispatcher, todayAiPrompt$doLoad$merged$1, anonymousClass1);
            if (objWithContext != coroutine_suspended) {
                list = arrayList;
                settings = settings3;
                objLoad = objWithContext;
                sb = sb2;
                map = linkedHashMap;
                sleepRecord = lastSleepRecord;
                list2 = list5;
                dbSleepRecordRepository = sleepRecordRepository;
                list3 = sleepRecords;
                i = dayCutOffHour;
                interval = interval2;
                sleepScore = sleepScore3;
            }
            return coroutine_suspended;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            StringBuilder sb3 = (StringBuilder) anonymousClass1.L$6;
            settings2 = (Settings) anonymousClass1.L$5;
            ResultKt.throwOnFailure(objLoad);
            sb = sb3;
            statRepo = (StatRepo) objLoad;
            sleepScore2 = new SleepScore();
            sleepScore2.setAge(settings2.getAge());
            if (statRepo != null && (mergedStatRecords = statRepo.getMergedStatRecords()) != null) {
                AiPrompt.buildPromptFromRecords$default(this, getContext(), mergedStatRecords, sleepScore2, sb, (String) null, 16, (Object) null);
            }
            return sb.toString();
        }
        int i5 = anonymousClass1.I$0;
        List list6 = (List) anonymousClass1.L$9;
        Interval interval3 = (Interval) anonymousClass1.L$8;
        SleepScore sleepScore4 = (SleepScore) anonymousClass1.L$7;
        StringBuilder sb4 = (StringBuilder) anonymousClass1.L$6;
        Settings settings4 = (Settings) anonymousClass1.L$5;
        List list7 = (List) anonymousClass1.L$4;
        Map map2 = (Map) anonymousClass1.L$3;
        List<SleepRecord> list8 = (List) anonymousClass1.L$2;
        SleepRecord sleepRecord3 = (SleepRecord) anonymousClass1.L$1;
        DbSleepRecordRepository dbSleepRecordRepository2 = (DbSleepRecordRepository) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objLoad);
        list = list7;
        settings = settings4;
        sb = sb4;
        map = map2;
        list3 = list8;
        sleepRecord = sleepRecord3;
        list2 = list6;
        interval = interval3;
        sleepScore = sleepScore4;
        dbSleepRecordRepository = dbSleepRecordRepository2;
        i = i5;
        List list9 = (List) objLoad;
        list9.getClass();
        if (!list9.isEmpty()) {
            list3.getClass();
            if (list3.isEmpty()) {
                i2 = 0;
            } else {
                SleepRegularityIndexUtil2 sleepRegularityIndexUtil2 = new SleepRegularityIndexUtil2(list3);
                i2 = 0;
                Object obj = list9.get(0);
                obj.getClass();
                sleepRegularityIndexUtil2.fillSleepRegularityIndex((StatRecord) obj);
            }
            sb.append("Below are my detailed measured sleep parameters measured in my last night's sleep. ");
            Context context = getContext();
            Object obj2 = list9.get(i2);
            obj2.getClass();
            List<SleepRecord> list10 = list3;
            AiPrompt.buildPromptFromRecords$default(this, context, (IMeasureRecord) obj2, sleepScore, sb, (String) null, 16, (Object) null);
            sb.append("Can you please summarize in " + Locale.getDefault().getDisplayLanguage(Locale.ENGLISH) + " language what was good and what can be improved and how I did in general last night. ");
            sb.append("Also please tell if any of the measured parameters from my today's sleep did significantly diverge from my 14 days average sleep statistic which are below.");
            StatsRepoLoader statsRepoLoader = StatsRepoLoader.INSTANCE;
            Context context2 = getContext();
            StatRepo.Mode mode = StatRepo.Mode.SCORE;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(dbSleepRecordRepository);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(sleepRecord);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(list10);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(map);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(list);
            anonymousClass1.L$5 = settings;
            anonymousClass1.L$6 = sb;
            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(sleepScore);
            anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(interval);
            anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(list2);
            anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(list9);
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 2;
            objLoad = statsRepoLoader.load(context2, 14, mode, anonymousClass1);
            if (objLoad != coroutine_suspended) {
                settings2 = settings;
                statRepo = (StatRepo) objLoad;
                sleepScore2 = new SleepScore();
                sleepScore2.setAge(settings2.getAge());
                if (statRepo != null) {
                    AiPrompt.buildPromptFromRecords$default(this, getContext(), mergedStatRecords, sleepScore2, sb, (String) null, 16, (Object) null);
                }
            }
            return coroutine_suspended;
        }
        return sb.toString();
    }
}
