package com.urbandroid.sleep.fragment.dashboard.detail;

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
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.LazyFragment;
import com.urbandroid.sleep.fragment.dashboard.DashboardAdapter;
import com.urbandroid.sleep.fragment.dashboard.RecyclerViewClickListener;
import com.urbandroid.sleep.fragment.dashboard.RecyclerViewTouchListener;
import com.urbandroid.sleep.fragment.dashboard.SimpleItemTouchHelperCallback;
import com.urbandroid.sleep.graph.GraphEditActivity;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003J\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0003J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0003R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\bR\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010)R.\u00102\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001008\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailFragment;", "Lcom/urbandroid/sleep/fragment/LazyFragment;", "<init>", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "cardList", "", "initFab", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "eagerLoad", "()Z", "onSetVisible", "refreshOnDataUpdate", "reload", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "createBaseView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "populateBaseView", "(Landroid/view/View;Landroid/view/LayoutInflater;Landroid/os/Bundle;)V", "onPause", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardAdapter;", "adapter", "Lcom/urbandroid/sleep/fragment/dashboard/DashboardAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "getCardList", "()Landroidx/recyclerview/widget/RecyclerView;", "setCardList", "Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailCardBuilder;", "cardBuilder", "Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailCardBuilder;", "getCardBuilder", "()Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailCardBuilder;", "noKeyguard", "Z", "getNoKeyguard", "setNoKeyguard", "(Z)V", "floating", "Landroid/view/View;", "isPopulated", "Lcom/urbandroid/sleep/domain/SleepRecord;", SDKConstants.PARAM_VALUE, "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "setSleepRecord", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "loadDataDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "scrollAnimator", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailFragment extends LazyFragment {
    private DashboardAdapter adapter;
    private final SleepDetailCardBuilder cardBuilder = new SleepDetailCardBuilder(LifecycleOwnerKt.getLifecycleScope(this));
    private RecyclerView cardList;
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    private View floating;
    private boolean isPopulated;
    private final ExecutorCoroutineDispatcher loadDataDispatcher;
    private boolean noKeyguard;
    private ScrollAnimator scrollAnimator;
    private SleepRecord sleepRecord;

    public SleepDetailFragment() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executorServiceNewSingleThreadExecutor.getClass();
        this.loadDataDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.coroutineExceptionHandler = new SleepDetailFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initFab(RecyclerView cardList) {
        View viewFindViewById;
        FragmentActivity activity = getActivity();
        if (activity == null || (viewFindViewById = activity.findViewById(R.id.fab)) == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new SleepDetailFragment$$ExternalSyntheticLambda0(this, activity, 0));
        this.floating = viewFindViewById;
        if (cardList != null) {
            cardList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailFragment$initFab$1$2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    recyclerView.getClass();
                    if (this.this$0.scrollAnimator == null) {
                        SleepDetailFragment sleepDetailFragment = this.this$0;
                        FragmentActivity activity2 = sleepDetailFragment.getActivity();
                        sleepDetailFragment.scrollAnimator = activity2 != null ? new ScrollAnimator(activity2, this.this$0.floating, 0, false, 12, null) : null;
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
    public static final void initFab$lambda$0$0$0(SleepDetailFragment sleepDetailFragment, FragmentActivity fragmentActivity, View view) {
        SleepRecord sleepRecord = sleepDetailFragment.cardBuilder.getSleepRecord();
        if (sleepRecord != null) {
            GraphEditActivity.startForResult(fragmentActivity, sleepRecord, sleepDetailFragment.noKeyguard);
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

    public final SleepDetailCardBuilder getCardBuilder() {
        return this.cardBuilder;
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
            recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(activity, new RecyclerViewClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailFragment$populateBaseView$1$1$1
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
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.coroutineExceptionHandler, null, new SleepDetailFragment$reload$1$1(this, activity, null), 2, null);
        }
    }

    public final void setNoKeyguard(boolean z) {
        this.noKeyguard = z;
    }

    public final void setSleepRecord(SleepRecord sleepRecord) {
        this.sleepRecord = sleepRecord;
        this.cardBuilder.setSleepRecord(sleepRecord);
    }
}
