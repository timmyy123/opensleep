package com.urbandroid.sleep.ai;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.merger.SameDateMerger;
import com.urbandroid.sleep.addon.stats.model.merger.ShortGapMerger;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "kotlin.jvm.PlatformType", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.ai.TodayAiPrompt$doLoad$merged$1", f = "TodayAiPrompt.kt", l = {}, m = "invokeSuspend", v = 2)
public final class TodayAiPrompt$doLoad$merged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<StatRecord>>, Object> {
    final /* synthetic */ List<SleepRecord> $todaySleepRecords;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TodayAiPrompt$doLoad$merged$1(List<SleepRecord> list, Continuation<? super TodayAiPrompt$doLoad$merged$1> continuation) {
        super(2, continuation);
        this.$todaySleepRecords = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TodayAiPrompt$doLoad$merged$1(this.$todaySleepRecords, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<StatRecord>> continuation) {
        return ((TodayAiPrompt$doLoad$merged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ArrayList arrayList = null;
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List<SleepRecord> list = this.$todaySleepRecords;
        if (list != null) {
            List<SleepRecord> list2 = list;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(StatRecord.fromSleepRecord((SleepRecord) it.next()));
            }
        }
        return new SameDateMerger().merge(new ShortGapMerger().merge(arrayList));
    }
}
