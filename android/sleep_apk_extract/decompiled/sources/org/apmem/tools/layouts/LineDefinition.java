package org.apmem.tools.layouts;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout;

/* JADX INFO: loaded from: classes.dex */
class LineDefinition {
    private int lineLength;
    private int lineThickness;
    private final int maxLength;
    private final List<View> views = new ArrayList();
    private int lineStartThickness = 0;
    private int lineStartLength = 0;

    public LineDefinition(int i) {
        this.maxLength = i;
    }

    public void addView(int i, View view) {
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams) view.getLayoutParams();
        this.views.add(i, view);
        this.lineLength = layoutParams.getSpacingLength() + layoutParams.getLength() + this.lineLength;
        this.lineThickness = Math.max(this.lineThickness, layoutParams.getSpacingThickness() + layoutParams.getThickness());
    }

    public boolean canFit(View view) {
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.getSpacingLength() + (layoutParams.getLength() + this.lineLength) <= this.maxLength;
    }

    public int getLineLength() {
        return this.lineLength;
    }

    public int getLineStartLength() {
        return this.lineStartLength;
    }

    public int getLineStartThickness() {
        return this.lineStartThickness;
    }

    public int getLineThickness() {
        return this.lineThickness;
    }

    public List<View> getViews() {
        return this.views;
    }

    public void setLength(int i) {
        this.lineLength = i;
    }

    public void setLineStartLength(int i) {
        this.lineStartLength = i;
    }

    public void setLineStartThickness(int i) {
        this.lineStartThickness = i;
    }

    public void setThickness(int i) {
        this.lineThickness = i;
    }

    public void addView(View view) {
        addView(this.views.size(), view);
    }
}
