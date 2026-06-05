package com.urbandroid.sleep.gui.view;

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
@DebugMetadata(c = "com.urbandroid.sleep.gui.view.PieView$Companion$viewsForSleepRecord$merged$1", f = "PieView.kt", l = {}, m = "invokeSuspend", v = 2)
public final class PieView$Companion$viewsForSleepRecord$merged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<StatRecord>>, Object> {
    final /* synthetic */ List<SleepRecord> $records;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PieView$Companion$viewsForSleepRecord$merged$1(List<? extends SleepRecord> list, Continuation<? super PieView$Companion$viewsForSleepRecord$merged$1> continuation) {
        super(2, continuation);
        this.$records = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PieView$Companion$viewsForSleepRecord$merged$1(this.$records, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<StatRecord>> continuation) {
        return ((PieView$Companion$viewsForSleepRecord$merged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List<SleepRecord> list = this.$records;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(StatRecord.fromSleepRecord((SleepRecord) it.next()));
        }
        return new SameDateMerger().merge(new ShortGapMerger().merge(arrayList));
    }
}
