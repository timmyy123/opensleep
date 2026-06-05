package com.urbandroid.sleep.addon.stats.goal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.addon.stats.chart.ChartLoader;
import com.urbandroid.sleep.addon.stats.chart.GoalBarChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.GoalChartBuilder;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.gui.GraphListClickHandler$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.dialog.CustomLayoutMaterialDialog;
import com.urbandroid.sleep.gui.view.ProgressRingView;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0014J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J \u0010 \u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0010H\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020.X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalDetailActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "goal", "Lcom/urbandroid/sleep/domain/goal/Goal;", "animShow", "Landroid/view/animation/Animation;", "animHide", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "tabToId", "", "selected", "updateTabContent", "selectedId", "unselectedId", "onCreateDialog", "Landroid/app/Dialog;", "id", "showGiveUpDialog", "giveUpAfterConfirm", "progressStart", "progressEnd", "refund", "startNew", "", "retry", "manualRefund", "doNextGoal", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onDestroy", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoalDetailActivity extends BaseActivity implements CoroutineScope, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Animation animHide;
    private Animation animShow;
    private Goal goal;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final String tag = "Goal";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalDetailActivity$Companion;", "", "<init>", "()V", "EXTRA_GOAL_TYPE", "", "DIALOG_GIVE_UP", "", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "goalType", "Lcom/urbandroid/sleep/domain/goal/Goal$Type;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, Goal.Type type, int i, Object obj) {
            if ((i & 2) != 0) {
                type = null;
            }
            companion.start(context, type);
        }

        public final void start(Context context, Goal.Type goalType) {
            Intent intent;
            context.getClass();
            if (ContextExtKt.getSettings(context).getCurrentGoal() != null) {
                Intent intent2 = new Intent(context, (Class<?>) GoalDetailActivity.class);
                intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
                context.startActivity(intent2);
                return;
            }
            if (goalType == null) {
                intent = new Intent(context, (Class<?>) GoalSelectActivity.class);
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            } else {
                intent = new Intent(context, (Class<?>) GoalCreateActivity.class);
                intent.putExtra("extra_goal_type", goalType.name());
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            }
            context.startActivity(intent);
        }

        private Companion() {
        }

        public final void start(Context context) {
            context.getClass();
            start$default(this, context, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4", f = "GoalDetailActivity.kt", l = {159}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Goal $currentGoal;
        final /* synthetic */ Date $from;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4$4, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4$4", f = "GoalDetailActivity.kt", l = {217}, m = "invokeSuspend", v = 2)
        public static final class C00264 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ Goal $currentGoal;
            final /* synthetic */ List<StatRecord> $intervalStatRecords;
            int label;
            final /* synthetic */ GoalDetailActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00264(GoalDetailActivity goalDetailActivity, Context context, Goal goal, List<? extends StatRecord> list, Continuation<? super C00264> continuation) {
                super(2, continuation);
                this.this$0 = goalDetailActivity;
                this.$context = context;
                this.$currentGoal = goal;
                this.$intervalStatRecords = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final View invokeSuspend$lambda$0(Context context, Goal goal, List list, ChartLoader chartLoader, int i) {
                View viewCreateView = new GoalChartBuilder(context, goal).buildChart(context, list).createView(context);
                viewCreateView.getClass();
                return viewCreateView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00264(this.this$0, this.$context, this.$currentGoal, this.$intervalStatRecords, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00264) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GoalDetailActivity goalDetailActivity = this.this$0;
                    View viewFindViewById = goalDetailActivity.findViewById(R.id.chart);
                    viewFindViewById.getClass();
                    ViewGroup viewGroup = (ViewGroup) viewFindViewById;
                    View viewFindViewById2 = this.this$0.findViewById(R.id.progress);
                    viewFindViewById2.getClass();
                    ChartLoader chartLoader = new ChartLoader(goalDetailActivity, viewGroup, 1, (ProgressBar) viewFindViewById2, new GoalDetailActivity$onCreate$4$4$$ExternalSyntheticLambda0(this.$context, this.$currentGoal, this.$intervalStatRecords, 0));
                    this.label = 1;
                    if (chartLoader.load(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4$5, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4$5", f = "GoalDetailActivity.kt", l = {230}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ Goal $currentGoal;
            final /* synthetic */ List<StatRecord> $intervalStatRecords;
            int label;
            final /* synthetic */ GoalDetailActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass5(GoalDetailActivity goalDetailActivity, Context context, Goal goal, List<? extends StatRecord> list, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.this$0 = goalDetailActivity;
                this.$context = context;
                this.$currentGoal = goal;
                this.$intervalStatRecords = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final View invokeSuspend$lambda$0(Context context, Goal goal, List list, ChartLoader chartLoader, int i) {
                View viewCreateView = new GoalBarChartBuilder(context, goal).buildChart(context, list).createView(context);
                viewCreateView.getClass();
                return viewCreateView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.this$0, this.$context, this.$currentGoal, this.$intervalStatRecords, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                int i2 = 1;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GoalDetailActivity goalDetailActivity = this.this$0;
                    View viewFindViewById = goalDetailActivity.findViewById(R.id.chart_top);
                    viewFindViewById.getClass();
                    ViewGroup viewGroup = (ViewGroup) viewFindViewById;
                    View viewFindViewById2 = this.this$0.findViewById(R.id.progress);
                    viewFindViewById2.getClass();
                    ChartLoader chartLoader = new ChartLoader(goalDetailActivity, viewGroup, 1, (ProgressBar) viewFindViewById2, new GoalDetailActivity$onCreate$4$4$$ExternalSyntheticLambda0(this.$context, this.$currentGoal, this.$intervalStatRecords, i2));
                    this.label = 1;
                    if (chartLoader.load(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Goal goal, Date date, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$currentGoal = goal;
            this.$from = date;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$1$0(View view, MotionEvent motionEvent) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$2$0(View view, MotionEvent motionEvent) {
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = GoalDetailActivity.this.new AnonymousClass4(this.$currentGoal, this.$from, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objWithContext;
            Goal goal;
            Goal.Type type;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            final int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                GoalDetailActivity$onCreate$4$intervalStatRecords$1 goalDetailActivity$onCreate$4$intervalStatRecords$1 = new GoalDetailActivity$onCreate$4$intervalStatRecords$1(GoalDetailActivity.this, this.$from, this.$currentGoal, null);
                this.L$0 = coroutineScope;
                this.label = 1;
                objWithContext = BuildersKt.withContext(io2, goalDetailActivity$onCreate$4$intervalStatRecords$1, this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objWithContext = obj;
            }
            List<? extends StatRecord> list = (List) objWithContext;
            GoalDetailActivity goalDetailActivity = GoalDetailActivity.this;
            TextView textView = (TextView) goalDetailActivity.findViewById(R.id.hint);
            Goal goal2 = this.$currentGoal;
            if (goal2.status == Goal.Status.SUCCESS || goal2.completedPreliminarily() || (type = (goal = this.$currentGoal).type) == Goal.Type.IRREGULARITY || type == Goal.Type.FALL_ASLEEP_HOUR) {
                textView.setVisibility(8);
            } else {
                Goal.Companion companion = Goal.INSTANCE;
                goal.nextTarget = companion.getNextTarget(goalDetailActivity, goal, list);
                Goal goal3 = this.$currentGoal;
                textView.getClass();
                ViewExtKt.show(textView);
                textView.setText(companion.getNextTargetString(goalDetailActivity, goal3));
            }
            TextView textView2 = (TextView) GoalDetailActivity.this.findViewById(R.id.status);
            Goal.Companion companion2 = Goal.INSTANCE;
            textView2.setText(companion2.getGoalStateString(goalDetailActivity, this.$currentGoal));
            TextView textView3 = (TextView) GoalDetailActivity.this.findViewById(R.id.motivation);
            boolean zIsInApp = this.$currentGoal.isInApp();
            GoalDetailActivity goalDetailActivity2 = GoalDetailActivity.this;
            textView3.setText(zIsInApp ? ContextExtKt.getSettings(goalDetailActivity2).getCurrentGoalPrice() != null ? ContextExtKt.getSettings(GoalDetailActivity.this).getCurrentGoalPrice() : "$" : goalDetailActivity2.getString(R.string.free));
            ((TextView) GoalDetailActivity.this.findViewById(R.id.motivation)).setTextColor(this.$currentGoal.getProgressInt() >= this.$currentGoal.getTimeProgressInt() ? ColorUtil.i(goalDetailActivity, R.color.positive) : ColorUtil.i(goalDetailActivity, R.color.negative_light));
            ((ProgressRingView) GoalDetailActivity.this.findViewById(R.id.pie_progress)).setProgress(this.$currentGoal.getProgress() > 0.0d ? (float) RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(this.$currentGoal.getProgress(), 0.0d), 1.0d) : 0.0f);
            ((ProgressRingView) GoalDetailActivity.this.findViewById(R.id.pie_progress)).setProgressColor(this.$currentGoal.getProgressInt() >= this.$currentGoal.getTimeProgressInt() ? ColorUtil.i(goalDetailActivity, R.color.positive) : ColorUtil.i(goalDetailActivity, R.color.negative_light));
            final int i3 = 0;
            ((TextView) GoalDetailActivity.this.findViewById(R.id.pie_value)).setText(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(this.$currentGoal.getProgressInt(), 0), 100) + "%");
            ((TextView) GoalDetailActivity.this.findViewById(R.id.pie_desc)).setText(Goal.Companion.getProgressFormatted$default(companion2, goalDetailActivity, this.$currentGoal, false, 4, null));
            ((TextView) GoalDetailActivity.this.findViewById(R.id.startValue)).setText(Goal.Companion.getBaseFormatted$default(companion2, goalDetailActivity, this.$currentGoal, false, 4, null));
            ((TextView) GoalDetailActivity.this.findViewById(R.id.goalValue)).setText(Goal.Companion.getTargetFormatted$default(companion2, goalDetailActivity, this.$currentGoal, false, 4, null));
            ((ImageView) GoalDetailActivity.this.findViewById(R.id.goalFunnyImage)).setImageResource(companion2.getGoalIcon(this.$currentGoal.type));
            Slider slider = (Slider) GoalDetailActivity.this.findViewById(R.id.goal_progress_bar);
            if (slider != null) {
                slider.setValue(RangesKt___RangesKt.coerceAtMost(RangesKt.coerceAtLeast((float) this.$currentGoal.getProgress(), 0.0f), 1.0f));
                slider.setOnTouchListener(new View.OnTouchListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (i3) {
                            case 0:
                                return GoalDetailActivity.AnonymousClass4.invokeSuspend$lambda$1$0(view, motionEvent);
                            default:
                                return GoalDetailActivity.AnonymousClass4.invokeSuspend$lambda$2$0(view, motionEvent);
                        }
                    }
                });
                slider.setCustomThumbDrawable(R.drawable.ic_goal_progress_thumb);
            }
            Slider slider2 = (Slider) GoalDetailActivity.this.findViewById(R.id.goal_duration_progress_bar);
            if (slider2 != null) {
                slider2.setValue(RangesKt___RangesKt.coerceAtMost(RangesKt.coerceAtLeast((float) this.$currentGoal.getTimeProgress(), 0.0f), 1.0f));
                slider2.setOnTouchListener(new View.OnTouchListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (i2) {
                            case 0:
                                return GoalDetailActivity.AnonymousClass4.invokeSuspend$lambda$1$0(view, motionEvent);
                            default:
                                return GoalDetailActivity.AnonymousClass4.invokeSuspend$lambda$2$0(view, motionEvent);
                        }
                    }
                });
                slider2.setCustomThumbDrawable(R.drawable.ic_goal_progress_duration_thumb);
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00264(GoalDetailActivity.this, goalDetailActivity, this.$currentGoal, list, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass5(GoalDetailActivity.this, goalDetailActivity, this.$currentGoal, list, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$refund$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$refund$1", f = "GoalDetailActivity.kt", l = {358}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Goal $goal;
        final /* synthetic */ boolean $retry;
        final /* synthetic */ boolean $startNew;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, Goal goal, boolean z2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$startNew = z;
            this.$goal = goal;
            this.$retry = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalDetailActivity.this.new AnonymousClass1(this.$startNew, this.$goal, this.$retry, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GoalDetailActivity.this.progressStart();
                CoroutineDispatcher io2 = Dispatchers.getIO();
                GoalDetailActivity$refund$1$result$1 goalDetailActivity$refund$1$result$1 = new GoalDetailActivity$refund$1$result$1(this.$goal, null);
                this.label = 1;
                obj = BuildersKt.withContext(io2, goalDetailActivity$refund$1$result$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            GoalDetailActivity goalDetailActivity = GoalDetailActivity.this;
            String str = Logger.defaultTag;
            Logger.logInfo(str, goalDetailActivity.getTag() + ": " + ("refund, result: " + zBooleanValue), null);
            if (!zBooleanValue) {
                boolean z = this.$retry;
                GoalDetailActivity goalDetailActivity2 = GoalDetailActivity.this;
                if (z) {
                    goalDetailActivity2.doNextGoal();
                    GoalDetailActivity.this.manualRefund(this.$goal);
                } else {
                    Snackbar snackbarMake = Snackbar.make(goalDetailActivity2.findViewById(R.id.parent), R.string.goal_subscription_cancel_failed, -2);
                    final GoalDetailActivity goalDetailActivity3 = GoalDetailActivity.this;
                    final Goal goal = this.$goal;
                    final boolean z2 = this.$startNew;
                    snackbarMake.setAction(R.string.try_again, new View.OnClickListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$refund$1$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GoalDetailActivity.access$refund(goalDetailActivity3, goal, true, z2);
                        }
                    }).show();
                }
            } else if (this.$startNew) {
                Toast.makeText(GoalDetailActivity.this, R.string.goal_subscription_cancelled, 1).show();
                GoalDetailActivity.this.doNextGoal();
            } else {
                Goal goal2 = this.$goal;
                goal2.setSubscriptionId(null);
                goal2.setSubscriptionToken(null);
                goal2.setOrderId(null);
                Snackbar.make(GoalDetailActivity.this.findViewById(R.id.parent), R.string.goal_subscription_cancelled, -2).setAction(R.string.btn_ok, new AbstractGoalItem$$ExternalSyntheticLambda0(GoalDetailActivity.this, i2)).show();
            }
            GoalDetailActivity.this.progressEnd();
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ void access$doNextGoal(GoalDetailActivity goalDetailActivity) {
        goalDetailActivity.doNextGoal();
    }

    public static final /* synthetic */ void access$refund(GoalDetailActivity goalDetailActivity, Goal goal, boolean z, boolean z2) {
        goalDetailActivity.refund(goal, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doNextGoal() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": doNext()", null);
        new Settings(getApplicationContext()).setCurrentGoal(null);
        finish();
        Companion companion = INSTANCE;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        Companion.start$default(companion, applicationContext, null, 2, null);
    }

    private final void giveUpAfterConfirm(Goal goal) {
        if (goal.canRefund()) {
            refund(goal, true);
        } else {
            doNextGoal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void manualRefund(Goal goal) {
        if (goal.getOrderId() == null) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions")));
            return;
        }
        ViewIntent.sendTo(this, "support@urbandroid.org", FileInsert$$ExternalSyntheticOutline0.m("Refund my goal deposit ", goal.getOrderId()), "Refund my goal deposit " + goal.getOrderId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(GoalDetailActivity goalDetailActivity, Goal goal, DialogInterface dialogInterface, int i) {
        goalDetailActivity.giveUpAfterConfirm(goal);
        if (goal.status == Goal.Status.SUCCESS || goal.completedPreliminarily()) {
            ContextExtKt.getSettings(goalDetailActivity).addAchievement(Goal.INSTANCE.getAchievementMapping(goal.type), 1);
            Settings.setGoodTimeToRate(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void progressEnd() {
        View viewFindViewById = findViewById(R.id.progress);
        viewFindViewById.getClass();
        ViewExtKt.gone(viewFindViewById);
        View viewFindViewById2 = findViewById(R.id.chart);
        viewFindViewById2.getClass();
        ViewExtKt.show(viewFindViewById2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void progressStart() {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.getClass();
        ViewExtKt.show(progressBar);
        progressBar.setIndeterminate(true);
        findViewById(R.id.chart).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refund(Goal goal, boolean retry, boolean startNew) {
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("refund, retry: " + retry), null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(startNew, goal, retry, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGiveUpDialog() {
        showDialog(42);
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    public static /* synthetic */ void updateTabContent$default(GoalDetailActivity goalDetailActivity, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        goalDetailActivity.updateTabContent(i, i2);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(getApplicationContext());
        setContentView(R.layout.activity_goal_detail);
        ToolbarUtil.apply(this);
        EdgeToEdgeUtil.Companion companion = EdgeToEdgeUtil.INSTANCE;
        int i = 0;
        int i2 = 2;
        EdgeToEdgeUtil.Companion.insetsTop$default(companion, findViewById(R.id.toolbar), 0, 2, null);
        TintUtil.tint(this);
        Goal currentGoal = ContextExtKt.getSettings(this).getCurrentGoal();
        this.goal = currentGoal;
        if (currentGoal == null) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) GoalCreateActivity.class));
            finish();
            return;
        }
        this.animShow = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        this.animHide = AnimationUtils.loadAnimation(this, R.anim.fade_fast);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
            supportActionBar.setTitle(currentGoal.getGoalTitle(this));
        }
        if (currentGoal.didSucceedNow()) {
            CustomLayoutMaterialDialog.Companion companion2 = CustomLayoutMaterialDialog.INSTANCE;
            String string = getString(R.string.goal);
            String string2 = getString(R.string.sucess);
            string2.getClass();
            Locale locale = Locale.getDefault();
            locale.getClass();
            String lowerCase = string2.toLowerCase(locale);
            lowerCase.getClass();
            MaterialAlertDialogBuilder materialAlertDialogBuilderBuilder = companion2.builder(this, FileInsert$$ExternalSyntheticOutline0.m$1(string, " ", lowerCase), R.layout.dialog_success_anim, getString(R.string.you_did_it));
            materialAlertDialogBuilderBuilder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new GoalDetailActivity$$ExternalSyntheticLambda0(i));
            materialAlertDialogBuilderBuilder.show();
        }
        ContextExtKt.getSettings(this).setCurrentGoal(currentGoal);
        String str = "Goal !!!!! : " + currentGoal.status + " " + currentGoal.getProgressDays() + " " + currentGoal.getOrderId();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
        TextView textView = (TextView) findViewById(R.id.button_give_up);
        EdgeToEdgeUtil.Companion.insetsBottom$default(companion, findViewById(R.id.buttons), 0, false, 6, null);
        Goal.Status status = currentGoal.status;
        Goal.Status status2 = Goal.Status.SUCCESS;
        if (status == status2) {
            textView.setText(getResources().getString(R.string.sucess));
        } else if (status == Goal.Status.IN_PROGRESS && currentGoal.getProgressDays() <= 7) {
            textView.setText(getResources().getString(R.string.player_stop) + (currentGoal.getOrderId() != null ? FileInsert$$ExternalSyntheticOutline0.m(" & ", getResources().getString(R.string.refund)) : ""));
        } else if (currentGoal.completedPreliminarily()) {
            textView.setText(getResources().getString(R.string.player_stop));
        }
        if (status == Goal.Status.FAILED) {
            textView.setText(R.string.try_again);
        }
        if (status == status2 && currentGoal.hasMotivationFee()) {
            refund(currentGoal, false);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentGoal.startTime);
        calendar.add(5, -(currentGoal.getGoalDays() * 2));
        Date time = calendar.getTime();
        textView.setOnClickListener(new AbstractGoalItem$$ExternalSyntheticLambda0(this, i2));
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass4(currentGoal, time, null), 3, null);
        View viewFindViewById = findViewById(R.id.categories);
        viewFindViewById.getClass();
        final TabLayout tabLayout = (TabLayout) viewFindViewById;
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        int goalDetailsSelectedTab = ContextExtKt.getSettings(this).getGoalDetailsSelectedTab();
        ref$IntRef.element = goalDetailsSelectedTab;
        TabLayout.Tab tabAt = tabLayout.getTabAt(goalDetailsSelectedTab);
        updateTabContent$default(this, tabToId(ref$IntRef.element), 0, 2, null);
        tabLayout.selectTab(tabAt);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity.onCreate.5
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                ContextExtKt.getSettings(GoalDetailActivity.this).setGoalDetailsSelectedTab(tabLayout.getSelectedTabPosition());
                GoalDetailActivity.this.updateTabContent(GoalDetailActivity.this.tabToId(tabLayout.getSelectedTabPosition()), GoalDetailActivity.this.tabToId(ref$IntRef.element));
                ref$IntRef.element = tabLayout.getSelectedTabPosition();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int id) {
        if (id != 42) {
            Dialog dialogOnCreateDialog = super.onCreateDialog(id);
            dialogOnCreateDialog.getClass();
            return dialogOnCreateDialog;
        }
        Goal goal = this.goal;
        if (goal == null) {
            Dialog dialogOnCreateDialog2 = super.onCreateDialog(id);
            dialogOnCreateDialog2.getClass();
            return dialogOnCreateDialog2;
        }
        String str = "Goal can refund " + goal.canRefund();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
        String string = getResources().getString((goal.status == Goal.Status.SUCCESS || goal.completedPreliminarily()) ? R.string.time_for_another : R.string.give_up);
        string.getClass();
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(this).setTitle((CharSequence) string).setMessage(R.string.are_you_sure).setPositiveButton((CharSequence) string, (DialogInterface.OnClickListener) new GraphListClickHandler$$ExternalSyntheticLambda2(this, goal, 2)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.getClass();
        return alertDialogCreate;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        MenuUtil.INSTANCE.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return true;
        }
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/goals.html#goal-progress");
        return true;
    }

    public final int tabToId(int selected) {
        return selected != 1 ? selected != 2 ? R.id.chart_slider : R.id.chart : R.id.chart_top;
    }

    public final void updateTabContent(int selectedId, int unselectedId) {
        Integer[] numArr = {Integer.valueOf(R.id.chart_slider), Integer.valueOf(R.id.chart_top), Integer.valueOf(R.id.chart)};
        if (unselectedId > 0) {
            findViewById(unselectedId).startAnimation(this.animHide);
        }
        findViewById(selectedId).startAnimation(this.animShow);
        for (int i = 0; i < 3; i++) {
            findViewById(numArr[i].intValue()).setVisibility(8);
        }
        findViewById(selectedId).setVisibility(0);
    }

    public static final void start(Context context, Goal.Type type) {
        INSTANCE.start(context, type);
    }

    private final void refund(Goal goal, boolean startNew) {
        refund(goal, false, startNew);
    }
}
