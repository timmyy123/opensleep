package com.urbandroid.sleep.graph;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.graph.GraphDetailsActivity;
import com.urbandroid.sleep.gui.ImageCreator;
import com.urbandroid.sleep.gui.view.PieView;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SleepGraphImageGenerator {
    public static byte[] generateSleepGraph(Context context, SleepRecord sleepRecord, boolean z) {
        View viewFindViewById;
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.activity_graph_details_share, null);
        Logger.logInfo("Root " + viewGroup.findViewById(R.id.stats_deep_caption));
        if (!sleepRecord.hasActigraph() && (viewFindViewById = viewGroup.findViewById(R.id.rating_graph)) != null) {
            viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.5f));
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(1024, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(768, 1073741824);
        GraphViewMap graphViewMap = new GraphViewMap();
        graphViewMap.add(R.id.hypnogram, (GraphView) viewGroup.findViewById(R.id.hypnogram));
        graphViewMap.add(R.id.noise_graph, (GraphView) viewGroup.findViewById(R.id.noise_graph));
        graphViewMap.add(R.id.sensor_graph, (GraphView) viewGroup.findViewById(R.id.sensor_graph));
        graphViewMap.add(R.id.graph, (GraphView) viewGroup.findViewById(R.id.graph));
        ((RatingBar) viewGroup.findViewById(R.id.sleep_rating_bar)).setRating(sleepRecord.getRating());
        new GraphDetailsActivity.GraphDetailViewInitializer(context).setDoDpi(false).setShowNoises(false).setDbUpdateAllowed(false).initialize((ViewGroup) viewGroup.findViewById(R.id.root), sleepRecord, graphViewMap);
        if (!z) {
            viewGroup.findViewById(R.id.graph_tag).setVisibility(8);
            viewGroup.findViewById(R.id.graph_comment).setVisibility(8);
        }
        if (sleepRecord.getRating() == 0.0f) {
            viewGroup.findViewById(R.id.sleep_rating_bar).setVisibility(8);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.major_measures);
        Iterator<PieView> it = PieView.INSTANCE.getViewsForSleepRecord(R.layout.view_pie_abs, viewGroup.getContext(), sleepRecord, Arrays.asList(sleepRecord), Arrays.asList(SleepScore.ScoreMeasure.DURATION, SleepScore.ScoreMeasure.DEEP_SLEEP, SleepScore.ScoreMeasure.IRREGULARITY, SleepScore.ScoreMeasure.EFFICIENCY, SleepScore.ScoreMeasure.SNORE), 6).iterator();
        while (it.hasNext()) {
            viewGroup2.addView(it.next());
        }
        viewGroup.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        viewGroup.layout(0, 0, viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
        return ImageCreator.convertBitmapIntoPNGBytes(ImageCreator.createBitmapWithLogo(viewGroup));
    }

    public static byte[] generateSleepGraph(Context context, View view, boolean z) {
        return ImageCreator.convertBitmapIntoPNGBytes(ImageCreator.createBitmapWithLogo(view));
    }
}
