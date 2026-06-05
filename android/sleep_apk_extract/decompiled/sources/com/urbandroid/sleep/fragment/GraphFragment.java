package com.urbandroid.sleep.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.gui.GraphListCursorAdapter;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GraphFragment extends LazyFragment implements View.OnClickListener, View.OnLayoutChangeListener {
    private Activity activity;
    private IFilterListAdapter adapter;
    private EditText filterEdit;
    private View floating;
    private Handler handler;
    private TextView header;
    private ListView listView;
    private ScrollAnimator scrollAnimator = null;
    private Parcelable mListState = null;

    private void initializeGraphListAdapter(View view, ListView listView) {
        Logger.logInfo("Fragment: Lazy initializeGraphListAdapter ".concat(getClass().getSimpleName()));
        GraphListCursorAdapter graphListCursorAdapter = new GraphListCursorAdapter(this.activity, SharedApplicationContext.getInstance().getSleepRecordRepository(), (ViewGroup) view.findViewById(R.id.tab_history_inflated));
        this.adapter = graphListCursorAdapter;
        listView.setAdapter((ListAdapter) graphListCursorAdapter);
        listView.setOnItemClickListener(this.adapter);
        listView.setOnItemLongClickListener(this.adapter);
        listView.addOnLayoutChangeListener(this);
        listView.setNestedScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollTo$0() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.listView.scrollBy(0, -ActivityUtils.getDip(getActivity(), 4));
    }

    private void notifyChanged() {
        if (isAlreadyLoaded()) {
            this.adapter.notifyChanged();
            ListView listView = this.listView;
            if (listView != null) {
                listView.invalidate();
            }
        }
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public View createBaseView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Logger.logInfo("FragmentL: Lazy createBaseView ".concat(getClass().getSimpleName()));
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_graphs_inflated, viewGroup, false);
        StatsFragmentNew.showNoRecords(getActivity(), viewGroup2);
        return viewGroup2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.handler = new Handler();
        if (bundle != null) {
            this.mListState = bundle.getParcelable("listState");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.filterEdit)) {
            Logger.logDebug("Filter clicked.");
            this.filterEdit.setText("");
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.listView == null || this.mListState == null) {
            return;
        }
        this.handler.post(new Runnable() { // from class: com.urbandroid.sleep.fragment.GraphFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (GraphFragment.this.listView != null && GraphFragment.this.mListState != null) {
                    try {
                        GraphFragment.this.listView.onRestoreInstanceState(GraphFragment.this.mListState);
                    } catch (Exception unused) {
                    }
                }
                GraphFragment.this.mListState = null;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setDataUpdated();
        if (getActivity() != null) {
            this.floating = getActivity().findViewById(R.id.fab);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ListView listView = this.listView;
        if (listView != null) {
            Parcelable parcelableOnSaveInstanceState = listView.onSaveInstanceState();
            this.mListState = parcelableOnSaveInstanceState;
            bundle.putParcelable("listState", parcelableOnSaveInstanceState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (isAlreadyLoaded()) {
            this.adapter.pause();
        }
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void populateBaseView(View view, LayoutInflater layoutInflater, Bundle bundle) {
        Logger.logInfo("Lazy populateBaseView ".concat(getClass().getSimpleName()));
        this.listView = (ListView) view.findViewById(R.id.history_list);
        this.header = (TextView) view.findViewById(R.id.history_list_text);
        this.listView.setVerticalFadingEdgeEnabled(false);
        initializeGraphListAdapter(view, this.listView);
        this.floating = getActivity().findViewById(R.id.fab);
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.GraphFragment.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GraphFragment.this.isFramentVisible()) {
                    if (GraphFragment.this.scrollAnimator == null) {
                        GraphFragment.this.scrollAnimator = new ScrollAnimator(GraphFragment.this.getActivity(), GraphFragment.this.floating);
                    }
                    GraphFragment.this.scrollAnimator.scroll(i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View currentFocus;
                if (1 != i || GraphFragment.this.getActivity() == null || (currentFocus = GraphFragment.this.getActivity().getCurrentFocus()) == null) {
                    return;
                }
                currentFocus.clearFocus();
            }
        });
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public void refreshOnDataUpdate() {
        super.refreshOnDataUpdate();
        notifyChanged();
    }

    public void scrollTo(long j, int i) {
        List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(j, System.currentTimeMillis() + 60000, false);
        if (sleepRecords == null || sleepRecords.size() <= 0) {
            return;
        }
        this.listView.setSelection((sleepRecords.size() - 1) + i);
        this.handler.postDelayed(new GraphFragment$$ExternalSyntheticLambda0(this, 0), 1L);
    }
}
