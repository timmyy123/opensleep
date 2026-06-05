package com.urbandroid.sleep.graph;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u0015J\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000f¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010,¨\u00061"}, d2 = {"Lcom/urbandroid/sleep/graph/GraphElementToggleSection;", "", "Landroid/app/Activity;", "activity", "Lcom/urbandroid/sleep/domain/SleepRecord;", "displayedRecord", "Lcom/urbandroid/sleep/graph/GraphViewMap;", "graphs", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/graph/GraphViewMap;)V", "", "initialize", "()V", "Lcom/urbandroid/sleep/graph/GraphLegend;", "gl", "", "isGraphPresent", "(Lcom/urbandroid/sleep/graph/GraphLegend;)Z", "areAllGraphsHidden", "()Z", "initializeGraphChips", "(Lcom/urbandroid/sleep/graph/GraphLegend;)V", "Lcom/google/android/material/chip/Chip;", "chip", "syncViewStateToChipState", "(Lcom/urbandroid/sleep/graph/GraphLegend;Lcom/google/android/material/chip/Chip;)V", "toggleOffAllOtherGraphChips", "initializeEventLabelChips", "", "getUnselectViewState", "()I", "enable", "setMode", "(Z)V", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getDisplayedRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Lcom/urbandroid/sleep/graph/GraphViewMap;", "getGraphs", "()Lcom/urbandroid/sleep/graph/GraphViewMap;", "enabled", "Z", "Lcom/google/android/material/chip/ChipGroup;", "graphElementToggleChipGroup", "Lcom/google/android/material/chip/ChipGroup;", "graphChipsShouldBeExclusive", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GraphElementToggleSection {
    private final Activity activity;
    private final SleepRecord displayedRecord;
    private boolean enabled;
    private boolean graphChipsShouldBeExclusive;
    private ChipGroup graphElementToggleChipGroup;
    private final GraphViewMap graphs;

    public GraphElementToggleSection(Activity activity, SleepRecord sleepRecord, GraphViewMap graphViewMap) {
        activity.getClass();
        sleepRecord.getClass();
        graphViewMap.getClass();
        this.activity = activity;
        this.displayedRecord = sleepRecord;
        this.graphs = graphViewMap;
        this.graphChipsShouldBeExclusive = activity.findViewById(R.id.graph_toggle_chips_should_be_exclusive) != null;
        initialize();
    }

    private final boolean areAllGraphsHidden() {
        View rootView = this.graphs.getRootView();
        rootView.getClass();
        Iterator<GraphLegend> it = GraphLegend.INSTANCE.getTopLevelCharts().iterator();
        while (it.hasNext()) {
            Integer correspondingGraphViewResource = it.next().getCorrespondingGraphViewResource();
            correspondingGraphViewResource.getClass();
            if (rootView.findViewById(correspondingGraphViewResource.intValue()).getVisibility() == 0) {
                return false;
            }
        }
        return true;
    }

    private final void initialize() {
        this.graphElementToggleChipGroup = (ChipGroup) this.activity.findViewById(R.id.bottom_toggle_graphs_bar);
        for (GraphLegend graphLegend : GraphLegend.values()) {
            initializeEventLabelChips(graphLegend);
            initializeGraphChips(graphLegend);
        }
        ChipGroup chipGroup = this.graphElementToggleChipGroup;
        if (chipGroup != null) {
            chipGroup.invalidate();
        }
    }

    private final void initializeEventLabelChips(GraphLegend gl) {
        if (gl.getToggleable() && this.displayedRecord.getEvents().hasLabel(gl.getCorrespondingEventLabel())) {
            Chip materialChip = gl.toMaterialChip(this.activity);
            materialChip.setChecked(true);
            materialChip.setOnClickListener(new GraphElementToggleSection$$ExternalSyntheticLambda0(this, gl, materialChip));
            ChipGroup chipGroup = this.graphElementToggleChipGroup;
            if (chipGroup != null) {
                chipGroup.addView(materialChip);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeEventLabelChips$lambda$0(GraphElementToggleSection graphElementToggleSection, GraphLegend graphLegend, Chip chip, View view) {
        Iterator<GraphView> it = graphElementToggleSection.graphs.getAllGraphViews().iterator();
        while (it.hasNext()) {
            it.next().setGraphElementVisibility(graphLegend.eventLabelName(), Boolean.valueOf(chip.isChecked()));
        }
    }

    private final void initializeGraphChips(GraphLegend gl) {
        Chip materialChip = gl.toMaterialChip(this.activity);
        if (gl.getToggleable()) {
            GraphLegendType type = gl.getType();
            GraphLegendType graphLegendType = GraphLegendType.TOP_LEVEL_CHART;
            if (type == graphLegendType && isGraphPresent(gl)) {
                if (this.graphChipsShouldBeExclusive) {
                    GraphLegend graphLegend = GraphLegend.HYPNOGRAM;
                    if (isGraphPresent(graphLegend)) {
                        materialChip.setChecked(gl.getType() == graphLegendType && gl == graphLegend);
                    } else {
                        materialChip.setChecked(gl.getType() == graphLegendType && gl == GraphLegend.ACTIGRAPH);
                    }
                } else {
                    materialChip.setChecked(true);
                }
                materialChip.setOnClickListener(new GraphElementToggleSection$$ExternalSyntheticLambda0(this, materialChip, gl));
                ChipGroup chipGroup = this.graphElementToggleChipGroup;
                if (chipGroup != null) {
                    chipGroup.addView(materialChip);
                }
            }
        }
        if (gl.getType() == GraphLegendType.TOP_LEVEL_CHART) {
            syncViewStateToChipState(gl, materialChip);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeGraphChips$lambda$0(GraphElementToggleSection graphElementToggleSection, Chip chip, GraphLegend graphLegend, View view) {
        if (graphElementToggleSection.graphChipsShouldBeExclusive && !chip.isChecked()) {
            chip.setChecked(true);
            return;
        }
        if (graphElementToggleSection.graphChipsShouldBeExclusive && chip.isChecked()) {
            graphElementToggleSection.toggleOffAllOtherGraphChips(graphLegend);
        }
        graphElementToggleSection.syncViewStateToChipState(graphLegend, chip);
    }

    private final boolean isGraphPresent(GraphLegend gl) {
        if (gl.getType() != GraphLegendType.TOP_LEVEL_CHART) {
            return false;
        }
        View rootView = this.graphs.getRootView();
        Integer correspondingGraphViewResource = gl.getCorrespondingGraphViewResource();
        correspondingGraphViewResource.getClass();
        return rootView.findViewById(correspondingGraphViewResource.intValue()).getVisibility() == 0;
    }

    private final void syncViewStateToChipState(GraphLegend gl, Chip chip) {
        Logger.logDebug("syncViewStateToChipState GraphLegend: " + gl.name() + ": chip " + chip.isChecked());
        View rootView = this.graphs.getRootView();
        rootView.getClass();
        Integer encapsulatingGraphViewResource = gl.getEncapsulatingGraphViewResource();
        encapsulatingGraphViewResource.getClass();
        rootView.findViewById(encapsulatingGraphViewResource.intValue()).setVisibility(chip.isChecked() ? 0 : getUnselectViewState());
        Integer correspondingGraphViewResource = gl.getCorrespondingGraphViewResource();
        correspondingGraphViewResource.getClass();
        rootView.findViewById(correspondingGraphViewResource.intValue()).setVisibility(chip.isChecked() ? 0 : getUnselectViewState());
        EditText editText = (EditText) rootView.findViewById(R.id.sleep_rating_comment);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.expand_collapse);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(areAllGraphsHidden() ? 0 : 8);
        }
        if (editText != null && editText.getVisibility() == 0) {
            editText.setLayoutParams(new RelativeLayout.LayoutParams(editText.getLayoutParams().width, areAllGraphsHidden() ? -1 : -2));
        } else if (relativeLayout != null) {
            relativeLayout.setVisibility(areAllGraphsHidden() ? 0 : 8);
        }
    }

    private final void toggleOffAllOtherGraphChips(GraphLegend gl) {
        List<GraphLegend> topLevelCharts = GraphLegend.INSTANCE.getTopLevelCharts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(topLevelCharts, 10));
        for (GraphLegend graphLegend : topLevelCharts) {
            ChipGroup chipGroup = this.graphElementToggleChipGroup;
            Chip chip = chipGroup != null ? (Chip) chipGroup.findViewWithTag(graphLegend.name()) : null;
            if (chip != null) {
                chip.setChecked(graphLegend == gl);
            }
            if (chip != null) {
                syncViewStateToChipState(graphLegend, chip);
            }
            arrayList.add(Unit.INSTANCE);
        }
    }

    public final int getUnselectViewState() {
        return this.graphChipsShouldBeExclusive ? 4 : 8;
    }

    public final void setMode(boolean enable) {
        if (this.graphElementToggleChipGroup == null) {
            initialize();
        }
        this.enabled = enable;
        ChipGroup chipGroup = this.graphElementToggleChipGroup;
        if (chipGroup != null) {
            chipGroup.setVisibility(enable ? 0 : getUnselectViewState());
        }
        ChipGroup chipGroup2 = this.graphElementToggleChipGroup;
        if (chipGroup2 != null) {
            chipGroup2.invalidate();
        }
    }
}
