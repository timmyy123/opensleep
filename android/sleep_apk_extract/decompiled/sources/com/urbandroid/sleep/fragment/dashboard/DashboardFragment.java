package com.urbandroid.sleep.fragment.dashboard;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.view.LifecycleOwnerKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.button.MaterialButton;
import com.google.home.platform.traits.ValidationIssue;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmActivity;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.fragment.LazyFragment;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u0003J\u001d\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0003J\u0019\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0012H\u0002¢\u0006\u0004\b)\u0010!R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010H¨\u0006K"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/DashboardFragment;", "Lcom/urbandroid/sleep/fragment/LazyFragment;", "<init>", "()V", "", "eagerLoad", "()Z", "", "onResume", "onPause", "onSetVisible", "refreshOnDataUpdate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "createBaseView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "populateBaseView", "(Landroid/view/View;Landroid/view/LayoutInflater;Landroid/os/Bundle;)V", "Landroid/app/Activity;", "activity", "showShowcase", "(Landroid/app/Activity;)V", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "showTutorialStartTrackShowcase", "hideShowCase", "trackView", "showShowcaseTrack", "(Landroid/app/Activity;Landroid/view/View;)V", "refreshTrial", "reload", "Landroidx/recyclerview/widget/RecyclerView;", "cardList", "initFab", "(Landroidx/recyclerview/widget/RecyclerView;)V", "alarmView", "showShowcaseAlarm", "Landroid/view/animation/Animation;", "fadeIn", "Landroid/view/animation/Animation;", "fadeOut", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardAdapter;", "adapter", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardCardBuilder;", "cardBuilder", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardCardBuilder;", "floating", "Landroid/view/View;", "isPopulated", "Z", "showShowcaseIfPopulated", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "loadDataDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/BroadcastReceiver;", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "scrollAnimator", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "Lcom/getkeepsafe/taptargetview/TapTargetView;", "alarmTapTarget", "Lcom/getkeepsafe/taptargetview/TapTargetView;", "trackTapTarget", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DashboardFragment extends LazyFragment {
    private DashboardAdapter adapter;
    private TapTargetView alarmTapTarget;
    private final DashboardCardBuilder cardBuilder = new DashboardCardBuilder(LifecycleOwnerKt.getLifecycleScope(this));
    private RecyclerView cardList;
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    private Animation fadeIn;
    private Animation fadeOut;
    private View floating;
    private boolean isPopulated;
    private final ExecutorCoroutineDispatcher loadDataDispatcher;
    private final BroadcastReceiver receiver;
    private ScrollAnimator scrollAnimator;
    private boolean showShowcaseIfPopulated;
    private TapTargetView trackTapTarget;

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.dashboard.DashboardFragment$showShowcase$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.DashboardFragment$showShowcase$1", f = "DashboardFragment.kt", l = {ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DashboardFragment.this.new AnonymousClass1(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TextView alarmListHint;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.logInfo("Show showcase launch");
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger.logInfo("Show showcase delay " + DashboardFragment.this.adapter);
            DashboardAdapter dashboardAdapter = DashboardFragment.this.adapter;
            if (dashboardAdapter != null) {
                Activity activity = this.$activity;
                DashboardFragment dashboardFragment = DashboardFragment.this;
                List<DashboardCard<?>> cards = dashboardAdapter.getCards();
                cards.getClass();
                NextAlarmCard nextAlarmCard = (NextAlarmCard) CollectionsKt.firstOrNull(CollectionsKt.filterIsInstance(cards, NextAlarmCard.class));
                if (nextAlarmCard == null || (alarmListHint = nextAlarmCard.getAlarmListHint()) == null) {
                    return Unit.INSTANCE;
                }
                Logger.logInfo("Show showcase delay " + alarmListHint);
                alarmListHint.setText(alarmListHint.getText());
                alarmListHint.refreshDrawableState();
                try {
                    if (!activity.isFinishing()) {
                        dashboardFragment.showShowcaseAlarm(activity, alarmListHint);
                    }
                } catch (Exception e) {
                    Logger.logSevere(null, e);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public DashboardFragment() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executorServiceNewSingleThreadExecutor.getClass();
        this.loadDataDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.coroutineExceptionHandler = new DashboardFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.receiver = new DashboardFragment$receiver$1(this);
    }

    private final void initFab(RecyclerView cardList) {
        View viewFindViewById;
        FragmentActivity activity = getActivity();
        if (activity == null || (viewFindViewById = activity.findViewById(R.id.fab)) == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(viewFindViewById, 11));
        this.floating = viewFindViewById;
        if (cardList != null) {
            cardList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.dashboard.DashboardFragment$initFab$1$2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    recyclerView.getClass();
                    if (this.this$0.scrollAnimator == null) {
                        DashboardFragment dashboardFragment = this.this$0;
                        FragmentActivity activity2 = dashboardFragment.getActivity();
                        dashboardFragment.scrollAnimator = activity2 != null ? new ScrollAnimator(activity2, this.this$0.floating, 0, false, 12, null) : null;
                    }
                    ScrollAnimator scrollAnimator = this.this$0.scrollAnimator;
                    if (scrollAnimator != null) {
                        scrollAnimator.scrollDelta(dy);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFab$lambda$0$0$0(View view, View view2) {
        new SleepStarter().startSleep(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reload() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            initFab(this.cardList);
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.coroutineExceptionHandler, null, new DashboardFragment$reload$1$1(this, activity, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showShowcaseAlarm(final Activity context, View alarmView) {
        if ((context instanceof AlarmClock) && ((AlarmClock) context).unlockFlow != null) {
            Logger.logInfo("Dynamic link NOT showing show case - unlock flow is active");
            return;
        }
        Logger.logInfo("Dynamic link showing show case ");
        try {
            this.alarmTapTarget = TapTargetView.showFor(context, TapTarget.forView(alarmView, getResources().getString(R.string.set_alarm), getResources().getString(R.string.non_deep_sleep_window_title) + " - " + getResources().getString(R.string.non_deep_sleep_window_summary)).dimColor(R.color.tap_target_shade).outerCircleColor(R.color.tap_target_color).textColor(R.color.primary).targetCircleColor(R.color.black).tintTarget(false), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.fragment.dashboard.DashboardFragment.showShowcaseAlarm.1
                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetClick(TapTargetView view) {
                    view.getClass();
                    super.onTargetClick(view);
                    Logger.logInfo("Show show case click");
                    if (context.isFinishing()) {
                        return;
                    }
                    context.startActivity(new Intent(context, (Class<?>) AlarmActivity.class));
                }

                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
                    view.getClass();
                    super.onTargetDismissed(view, userInitiated);
                    Logger.logInfo("Show show case dismiss");
                    if (context.isFinishing() || ContextExtKt.getSettings(context).isShowCaseShown("sc_dashboard_track") || !ContextExtKt.getSettings(context).isShowCaseShown("sc_dashboard") || !TrialFilter.getInstance().daysUsed(0, 5)) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.coroutineExceptionHandler, null, new DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1(this, context, null), 2, null);
                }
            });
        } catch (Exception e) {
            Logger.logSevere(null, e);
        }
        Logger.logInfo("After Show show case");
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public View createBaseView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater.getClass();
        View viewInflate = inflater.inflate(R.layout.fragment_dashboard, container, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public boolean eagerLoad() {
        return true;
    }

    public final void hideShowCase() {
        TapTargetView tapTargetView = this.alarmTapTarget;
        if (tapTargetView != null) {
            if (tapTargetView != null) {
                tapTargetView.dismiss(false);
            }
            TapTargetView tapTargetView2 = this.trackTapTarget;
            if (tapTargetView2 != null) {
                tapTargetView2.dismiss(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DashboardAdapter dashboardAdapter = this.adapter;
        if (dashboardAdapter != null) {
            dashboardAdapter.saveCards();
        }
        Context context = getContext();
        if (context != null) {
            context.unregisterReceiver(this.receiver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        String string;
        super.onResume();
        reload();
        Context context = getContext();
        if (context != null) {
            BroadcastReceiver broadcastReceiver = this.receiver;
            IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.alarmclock.ALARM_ALERT_DISMISS");
            intentFilter.addAction("com.urbandroid.sleep.alarmclock.IMPORT_DONE");
            intentFilter.addAction("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
            intentFilter.addAction("com.urbandroid.sleep.ACTION_DASHBOARD_REFRESH");
            intentFilter.addAction("com.urbandroid.sleep.ACTION_DASHBOARD_SCROLL_DOWN");
            Unit unit = Unit.INSTANCE;
            ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, 2);
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        MaterialButton materialButton = null;
        Logger.logInfo("FAB UPDATE " + SleepService.isRunningTimely(), null);
        MaterialButton materialButton2 = (MaterialButton) activity.findViewById(R.id.fab);
        if (materialButton2 != null) {
            boolean zIsRunningTimely = SleepService.isRunningTimely();
            if (zIsRunningTimely) {
                String string2 = getString(R.string.settings_category_track);
                String string3 = getString(R.string.in_progress);
                string3.getClass();
                String lowerCase = string3.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                string = FileInsert$$ExternalSyntheticOutline0.m$1(string2, " ", new Regex("…").replace(lowerCase, ""));
            } else {
                string = getString(R.string.start_sleep_tracking);
            }
            materialButton2.setText(string);
            materialButton2.setIconResource(zIsRunningTimely ? R.drawable.ic_tab_graph_anim_ongoing : R.drawable.ic_action_track_white);
            if (zIsRunningTimely) {
                try {
                    Drawable icon = materialButton2.getIcon();
                    icon.getClass();
                    ((AnimationDrawable) icon).start();
                } catch (Exception e) {
                    Logger.logSevere(null, e);
                }
            }
            materialButton = materialButton2;
        }
        this.floating = materialButton;
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public void onSetVisible() {
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void populateBaseView(View view, LayoutInflater inflater, Bundle savedInstanceState) {
        view.getClass();
        inflater.getClass();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.floating = activity.findViewById(R.id.fab);
            this.fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.show);
            this.fadeOut = AnimationUtils.loadAnimation(getContext(), R.anim.hide);
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            boolean z = getResources().getBoolean(R.bool.tablet);
            boolean z2 = (getResources().getConfiguration().screenLayout & 15) >= 2;
            boolean z3 = getResources().getConfiguration().orientation == 2;
            RecyclerView.LayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.card_list);
            recyclerView.setItemViewCacheSize(DashboardCard.Type.values().length);
            if (z || (z2 && z3)) {
                linearLayoutManager = staggeredGridLayoutManager;
            }
            recyclerView.setLayoutManager(linearLayoutManager);
            final DashboardAdapter dashboardAdapter = new DashboardAdapter(activity);
            dashboardAdapter.setRecyclerView(recyclerView);
            this.adapter = dashboardAdapter;
            recyclerView.setAdapter(dashboardAdapter);
            new ItemTouchHelper(new SimpleItemTouchHelperCallback(dashboardAdapter)).attachToRecyclerView(recyclerView);
            recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(activity, new RecyclerViewClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.DashboardFragment$populateBaseView$1$1$1
                @Override // com.urbandroid.sleep.fragment.dashboard.RecyclerViewClickListener
                public void onClick(View view2, int position) {
                    view2.getClass();
                    if (position >= 0 && position < dashboardAdapter.getCards().size()) {
                        dashboardAdapter.getCards().get(position).onCardClicked(view2);
                        return;
                    }
                    Logger.logWarning("Dashboard: clicked outside items " + position, null);
                }
            }));
            if (this.showShowcaseIfPopulated) {
                showShowcase(activity);
            }
            this.cardList = recyclerView;
            this.isPopulated = true;
        }
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public void refreshOnDataUpdate() {
        reload();
    }

    public final void refreshTrial() {
        DashboardAdapter dashboardAdapter;
        Logger.logInfo("INAPP: DashboardFragment.refreshtrial() ", null);
        FragmentActivity activity = getActivity();
        if (activity == null || (dashboardAdapter = this.adapter) == null) {
            return;
        }
        dashboardAdapter.refreshCards(this.cardBuilder.buildCards(activity));
    }

    public final void showShowcase(Activity activity) {
        activity.getClass();
        Logger.logInfo("Show showcase " + this.isPopulated + " " + this.showShowcaseIfPopulated);
        if (TrialFilter.getInstance().daysUsed(0, 5) && ContextExtKt.getSettings(activity).getNextAlarm() == null && ContextExtKt.getSettings(activity).showShowCaseIfNotShown("sc_dashboard")) {
            boolean z = this.isPopulated;
            if (!z) {
                this.showShowcaseIfPopulated = true;
                return;
            }
            Logger.logInfo("Show showcase NOW " + z + " " + this.showShowcaseIfPopulated);
            LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new AnonymousClass1(activity, null));
        }
    }

    public final void showShowcaseTrack(Activity context, View trackView) {
        context.getClass();
        trackView.getClass();
        if (TrialFilter.getInstance().daysUsed(0, 5) && ContextExtKt.getSettings(context).isShowCaseShown("sc_dashboard")) {
            try {
                this.trackTapTarget = TapTargetView.showFor(context, TapTarget.forView(trackView, context.getResources().getString(R.string.start_sleep_tracking), context.getResources().getString(R.string.test_sleep_tracking)).dimColor(R.color.tap_target_shade).outerCircleColor(R.color.tap_target_color).cancelable(true).icon(getResources().getDrawable(R.drawable.ic_action_track_white)).textColor(R.color.primary).tintTarget(false), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.fragment.dashboard.DashboardFragment.showShowcaseTrack.1
                    @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                    public void onTargetClick(TapTargetView view) {
                        view.getClass();
                        super.onTargetClick(view);
                        new SleepStarter().startSleep(DashboardFragment.this.getActivity());
                    }
                });
            } catch (Exception e) {
                Logger.logSevere(null, e);
            }
        }
    }

    public final void showTutorialStartTrackShowcase(final Activity context) {
        context.getClass();
        TapTargetView.showFor(context, TapTarget.forView(context.findViewById(R.id.fab), context.getResources().getString(R.string.start_sleep_tracking), context.getResources().getString(R.string.test_sleep_tracking)).dimColor(R.color.tap_target_shade).outerCircleColor(R.color.tap_target_color).targetCircleColor(R.color.black).cancelable(true).tintTarget(false).icon(getResources().getDrawable(R.drawable.ic_action_track_white)).textColor(R.color.primary), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.fragment.dashboard.DashboardFragment.showTutorialStartTrackShowcase.1
            @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
            public void onTargetClick(TapTargetView view) {
                view.getClass();
                super.onTargetClick(view);
                if (context.isFinishing() || context.isDestroyed()) {
                    return;
                }
                new SleepStarter().startSleep(context);
            }
        });
    }
}
