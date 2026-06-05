package com.urbandroid.sleep.fragment.dashboard.morning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.view.LifecycleOwnerKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.LazyFragment;
import com.urbandroid.sleep.fragment.dashboard.DashboardAdapter;
import com.urbandroid.sleep.fragment.dashboard.RecyclerViewClickListener;
import com.urbandroid.sleep.fragment.dashboard.RecyclerViewTouchListener;
import com.urbandroid.sleep.fragment.dashboard.SimpleItemTouchHelperCallback;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\bR\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R.\u0010-\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningFragment;", "Lcom/urbandroid/sleep/fragment/LazyFragment;", "<init>", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "cardList", "", "initFab", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "eagerLoad", "()Z", "onResume", "onPause", "onSetVisible", "refreshOnDataUpdate", "reload", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "createBaseView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "populateBaseView", "(Landroid/view/View;Landroid/view/LayoutInflater;Landroid/os/Bundle;)V", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardAdapter;", "adapter", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "getCardList", "()Landroidx/recyclerview/widget/RecyclerView;", "setCardList", "Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningCardBuilder;", "cardBuilder", "Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningCardBuilder;", "floating", "Landroid/view/View;", "isPopulated", "Z", "Lcom/urbandroid/sleep/domain/SleepRecord;", SDKConstants.PARAM_VALUE, "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "setSleepRecord", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "loadDataDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "scrollAnimator", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MorningFragment extends LazyFragment {
    private DashboardAdapter adapter;
    private final MorningCardBuilder cardBuilder = new MorningCardBuilder(LifecycleOwnerKt.getLifecycleScope(this));
    private RecyclerView cardList;
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    private View floating;
    private boolean isPopulated;
    private final ExecutorCoroutineDispatcher loadDataDispatcher;
    private ScrollAnimator scrollAnimator;
    private SleepRecord sleepRecord;

    public MorningFragment() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executorServiceNewSingleThreadExecutor.getClass();
        this.loadDataDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.coroutineExceptionHandler = new MorningFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initFab(RecyclerView cardList) {
        View viewFindViewById;
        FragmentActivity activity = getActivity();
        if (activity == null || (viewFindViewById = activity.findViewById(R.id.fab)) == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, activity, 18));
        this.floating = viewFindViewById;
        if (cardList != null) {
            cardList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.dashboard.morning.MorningFragment$initFab$1$2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    recyclerView.getClass();
                    if (this.this$0.scrollAnimator == null) {
                        MorningFragment morningFragment = this.this$0;
                        FragmentActivity activity2 = morningFragment.getActivity();
                        morningFragment.scrollAnimator = activity2 != null ? new ScrollAnimator(activity2, this.this$0.floating, 0, false, 12, null) : null;
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
    public static final void initFab$lambda$0$0$0(MorningFragment morningFragment, FragmentActivity fragmentActivity, View view) {
        if (morningFragment.cardBuilder.getSleepRecord() != null) {
            fragmentActivity.finish();
        }
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

    public final RecyclerView getCardList() {
        return this.cardList;
    }

    public final SleepRecord getSleepRecord() {
        return this.sleepRecord;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DashboardAdapter dashboardAdapter = this.adapter;
        if (dashboardAdapter != null) {
            dashboardAdapter.saveCards();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        reload();
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
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            boolean z = getResources().getBoolean(R.bool.tablet);
            boolean z2 = (getResources().getConfiguration().screenLayout & 15) >= 2;
            boolean z3 = getResources().getConfiguration().orientation == 2;
            RecyclerView.LayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.card_list);
            if (z || (z2 && z3)) {
                linearLayoutManager = staggeredGridLayoutManager;
            }
            recyclerView.setLayoutManager(linearLayoutManager);
            final DashboardAdapter dashboardAdapter = new DashboardAdapter(activity);
            dashboardAdapter.setRecyclerView(recyclerView);
            this.adapter = dashboardAdapter;
            recyclerView.setAdapter(dashboardAdapter);
            new ItemTouchHelper(new SimpleItemTouchHelperCallback(dashboardAdapter)).attachToRecyclerView(recyclerView);
            recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(activity, new RecyclerViewClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.morning.MorningFragment$populateBaseView$1$1$1
                @Override // com.urbandroid.sleep.fragment.dashboard.RecyclerViewClickListener
                public void onClick(View view2, int position) {
                    view2.getClass();
                    if (position >= 0 && position < dashboardAdapter.getCards().size()) {
                        dashboardAdapter.getCards().get(position).onCardClicked(view2);
                        return;
                    }
                    Logger.logWarning("Detail: clicked outside items " + position, null);
                }
            }));
            this.cardList = recyclerView;
            this.isPopulated = true;
        }
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public void refreshOnDataUpdate() {
        reload();
    }

    public final void reload() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.coroutineExceptionHandler, null, new MorningFragment$reload$1$1(this, activity, null), 2, null);
        }
    }

    public final void setSleepRecord(SleepRecord sleepRecord) {
        this.sleepRecord = sleepRecord;
        this.cardBuilder.setSleepRecord(sleepRecord);
    }
}
