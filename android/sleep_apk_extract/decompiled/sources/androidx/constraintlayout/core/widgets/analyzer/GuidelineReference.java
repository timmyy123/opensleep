package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.mHorizontalRun.clear();
        constraintWidget.mVerticalRun.clear();
        this.orientation = ((Guideline) constraintWidget).getOrientation();
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.mDependencies.add(dependencyNode);
        dependencyNode.mTargets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        Guideline guideline = (Guideline) this.mWidget;
        int relativeBegin = guideline.getRelativeBegin();
        int relativeEnd = guideline.getRelativeEnd();
        guideline.getRelativePercent();
        if (guideline.getOrientation() == 1) {
            if (relativeBegin != -1) {
                this.start.mTargets.add(this.mWidget.mParent.mHorizontalRun.start);
                this.mWidget.mParent.mHorizontalRun.start.mDependencies.add(this.start);
                this.start.mMargin = relativeBegin;
            } else {
                DependencyNode dependencyNode = this.start;
                if (relativeEnd != -1) {
                    dependencyNode.mTargets.add(this.mWidget.mParent.mHorizontalRun.end);
                    this.mWidget.mParent.mHorizontalRun.end.mDependencies.add(this.start);
                    this.start.mMargin = -relativeEnd;
                } else {
                    dependencyNode.delegateToWidgetRun = true;
                    dependencyNode.mTargets.add(this.mWidget.mParent.mHorizontalRun.end);
                    this.mWidget.mParent.mHorizontalRun.end.mDependencies.add(this.start);
                }
            }
            addDependency(this.mWidget.mHorizontalRun.start);
            addDependency(this.mWidget.mHorizontalRun.end);
            return;
        }
        if (relativeBegin != -1) {
            this.start.mTargets.add(this.mWidget.mParent.mVerticalRun.start);
            this.mWidget.mParent.mVerticalRun.start.mDependencies.add(this.start);
            this.start.mMargin = relativeBegin;
        } else {
            DependencyNode dependencyNode2 = this.start;
            if (relativeEnd != -1) {
                dependencyNode2.mTargets.add(this.mWidget.mParent.mVerticalRun.end);
                this.mWidget.mParent.mVerticalRun.end.mDependencies.add(this.start);
                this.start.mMargin = -relativeEnd;
            } else {
                dependencyNode2.delegateToWidgetRun = true;
                dependencyNode2.mTargets.add(this.mWidget.mParent.mVerticalRun.end);
                this.mWidget.mParent.mVerticalRun.end.mDependencies.add(this.start);
            }
        }
        addDependency(this.mWidget.mVerticalRun.start);
        addDependency(this.mWidget.mVerticalRun.end);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int orientation = ((Guideline) this.mWidget).getOrientation();
        ConstraintWidget constraintWidget = this.mWidget;
        if (orientation == 1) {
            constraintWidget.setX(this.start.value);
        } else {
            constraintWidget.setY(this.start.value);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve && !dependencyNode.resolved) {
            DependencyNode dependencyNode2 = dependencyNode.mTargets.get(0);
            this.start.resolve((int) ((((Guideline) this.mWidget).getRelativePercent() * dependencyNode2.value) + 0.5f));
        }
    }
}
