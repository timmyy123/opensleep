package com.urbandroid.sleep.fragment.dashboard.detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GraphActivity;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.DashboardAdapter;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailFragment$reload$1$1", f = "SleepDetailFragment.kt", l = {58}, m = "invokeSuspend", v = 2)
public final class SleepDetailFragment$reload$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    int label;
    final /* synthetic */ SleepDetailFragment this$0;

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailFragment$reload$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailFragment$reload$1$1$1", f = "SleepDetailFragment.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        int label;
        final /* synthetic */ SleepDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SleepDetailFragment sleepDetailFragment, FragmentActivity fragmentActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = sleepDetailFragment;
            this.$activity = fragmentActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            SleepDetailCardBuilder cardBuilder = this.this$0.getCardBuilder();
            Context applicationContext = this.$activity.getApplicationContext();
            applicationContext.getClass();
            cardBuilder.loadData(applicationContext);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepDetailFragment$reload$1$1(SleepDetailFragment sleepDetailFragment, FragmentActivity fragmentActivity, Continuation<? super SleepDetailFragment$reload$1$1> continuation) {
        super(2, continuation);
        this.this$0 = sleepDetailFragment;
        this.$activity = fragmentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(SleepDetailFragment sleepDetailFragment, FragmentActivity fragmentActivity, View view) {
        Intent startIntent$default = SleepDetailActivity.Companion.getStartIntent$default(SleepDetailActivity.INSTANCE, sleepDetailFragment.getContext(), sleepDetailFragment.getCardBuilder().getPrevSleepRecord(), false, 4, null);
        startIntent$default.putExtra("prev", true);
        startIntent$default.putExtra("keyguard", true);
        fragmentActivity.startActivity(startIntent$default);
        fragmentActivity.overridePendingTransition(R.anim.prev_enter, R.anim.prev_exit);
        fragmentActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(SleepDetailFragment sleepDetailFragment, FragmentActivity fragmentActivity, View view) {
        Intent intent = new Intent(sleepDetailFragment.getContext(), (Class<?>) GraphActivity.class);
        SleepRecord sleepRecord = sleepDetailFragment.getSleepRecord();
        intent.putExtra("date", sleepRecord != null ? Long.valueOf(sleepRecord.getFromTime()) : null);
        intent.addFlags(603979776);
        fragmentActivity.startActivity(intent);
        fragmentActivity.overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(SleepDetailFragment sleepDetailFragment, FragmentActivity fragmentActivity, View view) {
        Intent startIntent$default = SleepDetailActivity.Companion.getStartIntent$default(SleepDetailActivity.INSTANCE, sleepDetailFragment.getContext(), sleepDetailFragment.getCardBuilder().getNextSleepRecord(), false, 4, null);
        startIntent$default.putExtra("next", true);
        startIntent$default.putExtra("keyguard", true);
        fragmentActivity.startActivity(startIntent$default);
        fragmentActivity.overridePendingTransition(R.anim.next_enter, R.anim.next_exit);
        fragmentActivity.finish();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SleepDetailFragment$reload$1$1(this.this$0, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SleepDetailFragment$reload$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ExecutorCoroutineDispatcher executorCoroutineDispatcher = this.this$0.loadDataDispatcher;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$activity, null);
            this.label = 1;
            if (BuildersKt.withContext(executorCoroutineDispatcher, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        SleepRecord prevSleepRecord = this.this$0.getCardBuilder().getPrevSleepRecord();
        FragmentActivity fragmentActivity = this.$activity;
        if (prevSleepRecord != null) {
            fragmentActivity.findViewById(R.id.prev).setEnabled(true);
            this.$activity.findViewById(R.id.prev).setOnClickListener(new SleepDetailFragment$$ExternalSyntheticLambda0(this.this$0, this.$activity, i2));
        } else {
            fragmentActivity.findViewById(R.id.prev).setEnabled(false);
        }
        this.$activity.findViewById(R.id.title).setOnClickListener(new SleepDetailFragment$$ExternalSyntheticLambda0(this.this$0, this.$activity, 2));
        SleepRecord nextSleepRecord = this.this$0.getCardBuilder().getNextSleepRecord();
        FragmentActivity fragmentActivity2 = this.$activity;
        if (nextSleepRecord != null) {
            fragmentActivity2.findViewById(R.id.next).setEnabled(true);
            this.$activity.findViewById(R.id.next).setOnClickListener(new SleepDetailFragment$$ExternalSyntheticLambda0(this.this$0, this.$activity, 3));
        } else {
            fragmentActivity2.findViewById(R.id.next).setEnabled(false);
        }
        SleepDetailFragment sleepDetailFragment = this.this$0;
        sleepDetailFragment.initFab(sleepDetailFragment.getCardList());
        DashboardAdapter dashboardAdapter = this.this$0.adapter;
        if (dashboardAdapter != null) {
            dashboardAdapter.refreshCards(this.this$0.getCardBuilder().buildCards(this.$activity));
        }
        return Unit.INSTANCE;
    }
}
