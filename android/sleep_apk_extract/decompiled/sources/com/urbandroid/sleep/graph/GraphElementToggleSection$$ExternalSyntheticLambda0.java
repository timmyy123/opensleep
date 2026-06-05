package com.urbandroid.sleep.graph;

import android.view.View;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GraphElementToggleSection$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ GraphElementToggleSection f$0;
    public final /* synthetic */ GraphLegend f$1;
    public final /* synthetic */ Chip f$2;

    public /* synthetic */ GraphElementToggleSection$$ExternalSyntheticLambda0(GraphElementToggleSection graphElementToggleSection, Chip chip, GraphLegend graphLegend) {
        this.f$0 = graphElementToggleSection;
        this.f$2 = chip;
        this.f$1 = graphLegend;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        GraphLegend graphLegend = this.f$1;
        Chip chip = this.f$2;
        GraphElementToggleSection graphElementToggleSection = this.f$0;
        switch (i) {
            case 0:
                GraphElementToggleSection.initializeEventLabelChips$lambda$0(graphElementToggleSection, graphLegend, chip, view);
                break;
            default:
                GraphElementToggleSection.initializeGraphChips$lambda$0(graphElementToggleSection, chip, graphLegend, view);
                break;
        }
    }

    public /* synthetic */ GraphElementToggleSection$$ExternalSyntheticLambda0(GraphElementToggleSection graphElementToggleSection, GraphLegend graphLegend, Chip chip) {
        this.f$0 = graphElementToggleSection;
        this.f$1 = graphLegend;
        this.f$2 = chip;
    }
}
