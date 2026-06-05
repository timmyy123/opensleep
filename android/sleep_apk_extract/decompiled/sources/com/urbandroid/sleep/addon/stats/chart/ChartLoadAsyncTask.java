package com.urbandroid.sleep.addon.stats.chart;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.urbandroid.common.util.ActivityUtils;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.GraphicalView;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ChartLoadAsyncTask extends AsyncTask<Void, Integer, List<View>> {
    private ViewGroup chartView;
    private List<View> charts;
    private Activity context;
    private ProgressBar progressBar;
    private int viewCount = 10;

    public ChartLoadAsyncTask(ViewGroup viewGroup, Activity activity, ProgressBar progressBar) {
        this.chartView = viewGroup;
        this.context = activity;
        this.progressBar = progressBar;
    }

    public void addView(View view) {
        List<View> list = this.charts;
        if (list == null) {
            Types$$ExternalSyntheticBUOutline0.m$2("Charts list not initialized yet, this method should be called only from createViews()");
        } else {
            list.add(view);
            publishProgress(Integer.valueOf(this.charts.size()));
        }
    }

    public abstract void createViews(List<View> list);

    @Override // android.os.AsyncTask
    public List<View> doInBackground(Void... voidArr) {
        ArrayList arrayList = new ArrayList();
        this.charts = arrayList;
        createViews(arrayList);
        publishProgress(Integer.valueOf(this.viewCount));
        return this.charts;
    }

    public Activity getContext() {
        return this.context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.AsyncTask
    public void onPostExecute(List<View> list) {
        super.onPostExecute(list);
        if (getContext() == null) {
            return;
        }
        this.chartView.removeAllViews();
        Display defaultDisplay = getContext().getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int i = -2;
        if (list.size() > 1) {
            ScrollView scrollView = new ScrollView(getContext());
            scrollView.setVerticalFadingEdgeEnabled(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            for (View view : list) {
                if (view != null) {
                    if (view instanceof GraphicalView) {
                        view.setMinimumWidth(width);
                        view.setMinimumHeight((height * 5) / 8);
                    }
                    LinearLayout linearLayout2 = new LinearLayout(getContext());
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
                    layoutParams2.setMargins(ActivityUtils.getDip(this.context, 8), ActivityUtils.getDip(this.context, 8), ActivityUtils.getDip(this.context, 8), ActivityUtils.getDip(this.context, 8));
                    linearLayout2.addView(view, layoutParams2);
                    linearLayout.addView(linearLayout2);
                    i = -2;
                }
            }
            scrollView.addView(linearLayout, layoutParams);
            this.chartView.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        } else if (list.size() == 1) {
            LinearLayout linearLayout3 = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(ActivityUtils.getDip(this.context, 8), ActivityUtils.getDip(this.context, 8), ActivityUtils.getDip(this.context, 8), ActivityUtils.getDip(this.context, 8));
            linearLayout3.addView(list.get(0), layoutParams3);
            this.chartView.addView(linearLayout3);
        }
        this.progressBar.setVisibility(8);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.progressBar.setVisibility(0);
        this.progressBar.setProgress(0);
        this.progressBar.setIndeterminate(true);
        this.progressBar.setMax(this.viewCount);
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
        this.progressBar.setIndeterminate(false);
        this.progressBar.setProgress(numArr[0].intValue());
    }

    public ChartLoadAsyncTask setViewCount(int i) {
        this.progressBar.setMax(i);
        this.viewCount = i;
        return this;
    }
}
