package com.urbandroid.sleep.graph;

import android.content.Context;
import android.view.View;
import com.urbandroid.common.util.ActivityUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class GraphViewMap {
    private Context context;
    private Map<Integer, GraphView> graphs = new HashMap();
    private final float SNAP_TO_BORDER_MARGIN = 0.08f;
    private final int SNAP_TO_BORDER_MARGIN_DPI = 28;
    private final float SNAP_TO_HANDLE_MARGIN = 0.16f;
    private final int SNAP_TO_HANDLE_MARGIN_DPI = 42;

    public abstract class ApplyAllTemplate {
        private Collection<GraphView> graphs;

        public ApplyAllTemplate(Collection<GraphView> collection) {
            this.graphs = collection;
        }

        public abstract void apply(GraphView graphView);

        public void applyAll() {
            Iterator<GraphView> it = this.graphs.iterator();
            while (it.hasNext()) {
                apply(it.next());
            }
        }
    }

    public void add(int i, GraphView graphView) {
        this.graphs.put(Integer.valueOf(i), graphView);
        this.context = graphView.getContext();
    }

    public void clearSelect() {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.1
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.clearSelect();
            }
        }.applyAll();
    }

    public GraphView get(int i) {
        return this.graphs.get(Integer.valueOf(i));
    }

    public Collection<GraphView> getAllGraphViews() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.graphs.values());
        return linkedList;
    }

    public GraphView getFirstVisible() {
        for (GraphView graphView : getAllGraphViews()) {
            if (graphView.isVisible()) {
                return graphView;
            }
        }
        return null;
    }

    public View getRootView() {
        return this.graphs.entrySet().iterator().next().getValue().getRootView();
    }

    public void invalidate() {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.6
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.invalidate();
            }
        }.applyAll();
    }

    public boolean isSelection() {
        Iterator<GraphView> it = this.graphs.values().iterator();
        while (it.hasNext()) {
            if (it.next().isSelection()) {
                return true;
            }
        }
        return false;
    }

    public boolean isZoom() {
        Iterator<GraphView> it = this.graphs.values().iterator();
        while (it.hasNext()) {
            if (it.next().isZoom()) {
                return true;
            }
        }
        return false;
    }

    public void resetIntervals() {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.3
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.resetIntervals();
            }
        }.applyAll();
    }

    public void selectDown(final float f) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.12
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                float fAbs = Math.abs(f - graphView.getSelectPoint1());
                float fAbs2 = Math.abs(f - graphView.getSelectPoint2());
                float dip = ActivityUtils.getDip(GraphViewMap.this.context, 42);
                if (graphView.getSelectPoint1Percent() == -1.0f) {
                    graphView.setSelectPoint1(f);
                    graphView.setSelectPoint2(f);
                } else if (fAbs2 <= dip && (fAbs > dip || fAbs2 <= fAbs)) {
                    graphView.setSelectPoint2(f);
                } else if (fAbs > dip || (fAbs2 <= dip && fAbs > fAbs2)) {
                    graphView.setSelectPoint1(f);
                    graphView.setSelectPoint2(f);
                } else {
                    graphView.setSelectPoint1(f);
                }
                graphView.invalidate();
            }
        }.applyAll();
    }

    public void selectMove(final float f) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.13
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                float fAbs = Math.abs(f - graphView.getSelectPoint1());
                float fAbs2 = Math.abs(f - graphView.getSelectPoint2());
                float dip = ActivityUtils.getDip(GraphViewMap.this.context, 84);
                float dip2 = ActivityUtils.getDip(GraphViewMap.this.context, 28);
                if (fAbs < dip && (fAbs2 > dip || fAbs <= fAbs2)) {
                    graphView.setSelectPoint1(f);
                } else if (fAbs2 < dip && (fAbs > dip || fAbs2 <= fAbs)) {
                    graphView.setSelectPoint2(f);
                } else if (graphView.getSelectPoint1Percent() == -1.0f) {
                    graphView.setSelectPoint1(f);
                }
                float f2 = f;
                if (f2 < dip2) {
                    if (graphView.getSelectPoint1() < graphView.getSelectPoint2()) {
                        graphView.setSelectPoint1(0.0f);
                    } else {
                        graphView.setSelectPoint2(0.0f);
                    }
                } else if (f2 > graphView.getWidth() - dip2) {
                    if (graphView.getSelectPoint1() < graphView.getSelectPoint2()) {
                        graphView.setSelectPoint2(graphView.getWidth());
                    } else {
                        graphView.setSelectPoint1(graphView.getWidth());
                    }
                }
                graphView.invalidate();
            }
        }.applyAll();
    }

    public void setDoDpi(final boolean z) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.4
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.setDoDpi(z);
            }
        }.applyAll();
    }

    public void setOnTouchListener(final View.OnTouchListener onTouchListener) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.5
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.setOnTouchListener(onTouchListener);
            }
        }.applyAll();
    }

    public void setSelectionPoint1Percentage(final float f) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.10
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.setSelectPoint1Percentage(f);
            }
        }.applyAll();
    }

    public void setSelectionPoint2Percentage(final float f) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.11
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.setSelectPoint2Percentage(f);
            }
        }.applyAll();
    }

    public void setXAxisLabels(final IAxisLabels<Float> iAxisLabels) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.2
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                if (graphView.isDrawXAxis()) {
                    graphView.setXAxisLabels(iAxisLabels);
                }
            }
        }.applyAll();
    }

    public void setZoomPoint1(final float f) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.8
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.setZoomPoint1(f);
            }
        }.applyAll();
    }

    public void setZoomPoint2(final float f) {
        new ApplyAllTemplate(this.graphs.values()) { // from class: com.urbandroid.sleep.graph.GraphViewMap.9
            @Override // com.urbandroid.sleep.graph.GraphViewMap.ApplyAllTemplate
            public void apply(GraphView graphView) {
                graphView.setZoomPoint2(f);
            }
        }.applyAll();
    }
}
