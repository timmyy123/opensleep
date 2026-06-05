package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FlowLayout extends ViewGroup {
    private final LayoutConfiguration config;
    List<LineDefinition> lines;

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lines = new ArrayList();
        this.config = new LayoutConfiguration(context, attributeSet);
    }

    private void applyGravityToLine(LineDefinition lineDefinition) {
        List<View> views = lineDefinition.getViews();
        int size = views.size();
        if (size <= 0) {
            return;
        }
        float weight = 0.0f;
        for (int i = 0; i < size; i++) {
            weight += getWeight((LayoutParams) views.get(i).getLayoutParams());
        }
        LayoutParams layoutParams = (LayoutParams) views.get(size - 1).getLayoutParams();
        int lineLength = lineDefinition.getLineLength() - (layoutParams.getInlineStartLength() + (layoutParams.getSpacingLength() + layoutParams.getLength()));
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            LayoutParams layoutParams2 = (LayoutParams) views.get(i3).getLayoutParams();
            float weight2 = getWeight(layoutParams2);
            int gravity = getGravity(layoutParams2);
            int iRound = weight == 0.0f ? lineLength / size : Math.round((lineLength * weight2) / weight);
            int spacingLength = layoutParams2.getSpacingLength() + layoutParams2.getLength();
            int spacingThickness = layoutParams2.getSpacingThickness() + layoutParams2.getThickness();
            Rect rect = new Rect();
            rect.top = 0;
            rect.left = i2;
            rect.right = spacingLength + iRound + i2;
            rect.bottom = lineDefinition.getLineThickness();
            Rect rect2 = new Rect();
            Gravity.apply(gravity, spacingLength, spacingThickness, rect, rect2);
            i2 += iRound;
            layoutParams2.setInlineStartLength(layoutParams2.getInlineStartLength() + rect2.left);
            layoutParams2.setInlineStartThickness(rect2.top);
            layoutParams2.setLength(rect2.width() - layoutParams2.getSpacingLength());
            layoutParams2.setThickness(rect2.height() - layoutParams2.getSpacingThickness());
        }
    }

    private void applyGravityToLines(List<LineDefinition> list, int i, int i2) {
        int size = list.size();
        if (size <= 0) {
            return;
        }
        LineDefinition lineDefinition = list.get(size - 1);
        int lineThickness = i2 - (lineDefinition.getLineThickness() + lineDefinition.getLineStartThickness());
        if (lineThickness < 0) {
            lineThickness = 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            LineDefinition lineDefinition2 = list.get(i4);
            int gravity = getGravity(null);
            int iRound = Math.round(lineThickness / size);
            int lineLength = lineDefinition2.getLineLength();
            int lineThickness2 = lineDefinition2.getLineThickness();
            Rect rect = new Rect();
            rect.top = i3;
            rect.left = 0;
            rect.right = i;
            rect.bottom = lineThickness2 + iRound + i3;
            Rect rect2 = new Rect();
            Gravity.apply(gravity, lineLength, lineThickness2, rect, rect2);
            i3 += iRound;
            lineDefinition2.setLineStartLength(lineDefinition2.getLineStartLength() + rect2.left);
            lineDefinition2.setLineStartThickness(lineDefinition2.getLineStartThickness() + rect2.top);
            lineDefinition2.setLength(rect2.width());
            lineDefinition2.setThickness(rect2.height());
        }
    }

    private void applyPositionsToViews(LineDefinition lineDefinition) {
        List<View> views = lineDefinition.getViews();
        int size = views.size();
        for (int i = 0; i < size; i++) {
            View view = views.get(i);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.config.getOrientation() == 0) {
                layoutParams.setPosition(layoutParams.getInlineStartLength() + getPaddingLeft() + lineDefinition.getLineStartLength(), layoutParams.getInlineStartThickness() + getPaddingTop() + lineDefinition.getLineStartThickness());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.getLength(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.getThickness(), 1073741824));
            } else {
                layoutParams.setPosition(layoutParams.getInlineStartThickness() + getPaddingLeft() + lineDefinition.getLineStartThickness(), layoutParams.getInlineStartLength() + getPaddingTop() + lineDefinition.getLineStartLength());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.getThickness(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.getLength(), 1073741824));
            }
        }
    }

    private void calculateLinesAndChildPosition(List<LineDefinition> list) {
        int size = list.size();
        int lineThickness = 0;
        for (int i = 0; i < size; i++) {
            LineDefinition lineDefinition = list.get(i);
            lineDefinition.setLineStartThickness(lineThickness);
            lineThickness += lineDefinition.getLineThickness();
            List<View> views = lineDefinition.getViews();
            int size2 = views.size();
            int spacingLength = 0;
            for (int i2 = 0; i2 < size2; i2++) {
                LayoutParams layoutParams = (LayoutParams) views.get(i2).getLayoutParams();
                layoutParams.setInlineStartLength(spacingLength);
                spacingLength += layoutParams.getSpacingLength() + layoutParams.getLength();
            }
        }
    }

    private Paint createPaint(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    private boolean debugDraw() {
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("debugDraw", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private void drawDebugInfo(Canvas canvas, View view) {
        if (isDebugDraw()) {
            Paint paintCreatePaint = createPaint(Color.YELLOW);
            Paint paintCreatePaint2 = createPaint(Color.RED);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin > 0) {
                float right = view.getRight();
                float height = (view.getHeight() / 2.0f) + view.getTop();
                canvas.drawLine(right, height, right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, height, paintCreatePaint);
                int i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                canvas.drawLine((i + right) - 4.0f, height - 4.0f, right + i, height, paintCreatePaint);
                int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                canvas.drawLine((i2 + right) - 4.0f, height + 4.0f, right + i2, height, paintCreatePaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin > 0) {
                float left = view.getLeft();
                float height2 = (view.getHeight() / 2.0f) + view.getTop();
                canvas.drawLine(left, height2, left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, height2, paintCreatePaint);
                int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                canvas.drawLine((left - i3) + 4.0f, height2 - 4.0f, left - i3, height2, paintCreatePaint);
                int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                canvas.drawLine((left - i4) + 4.0f, height2 + 4.0f, left - i4, height2, paintCreatePaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin > 0) {
                float width = (view.getWidth() / 2.0f) + view.getLeft();
                float bottom = view.getBottom();
                canvas.drawLine(width, bottom, width, bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, paintCreatePaint);
                int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                canvas.drawLine(width - 4.0f, (i5 + bottom) - 4.0f, width, bottom + i5, paintCreatePaint);
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                canvas.drawLine(width + 4.0f, (i6 + bottom) - 4.0f, width, bottom + i6, paintCreatePaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).topMargin > 0) {
                float width2 = (view.getWidth() / 2.0f) + view.getLeft();
                float top = view.getTop();
                canvas.drawLine(width2, top, width2, top - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, paintCreatePaint);
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                canvas.drawLine(width2 - 4.0f, (top - i7) + 4.0f, width2, top - i7, paintCreatePaint);
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                canvas.drawLine(width2 + 4.0f, (top - i8) + 4.0f, width2, top - i8, paintCreatePaint);
            }
            if (layoutParams.isNewLine()) {
                if (this.config.getOrientation() == 0) {
                    float left2 = view.getLeft();
                    float height3 = (view.getHeight() / 2.0f) + view.getTop();
                    canvas.drawLine(left2, height3 - 6.0f, left2, height3 + 6.0f, paintCreatePaint2);
                    return;
                }
                float width3 = (view.getWidth() / 2.0f) + view.getLeft();
                float top2 = view.getTop();
                canvas.drawLine(width3 - 6.0f, top2, width3 + 6.0f, top2, paintCreatePaint2);
            }
        }
    }

    private int findSize(int i, int i2, int i3) {
        return i != Integer.MIN_VALUE ? i != 1073741824 ? i3 : i2 : Math.min(i3, i2);
    }

    private int getGravity(LayoutParams layoutParams) {
        int gravity = this.config.getGravity();
        int gravityFromRelative = getGravityFromRelative((layoutParams == null || !layoutParams.gravitySpecified()) ? gravity : layoutParams.getGravity());
        int gravityFromRelative2 = getGravityFromRelative(gravity);
        if ((gravityFromRelative & 7) == 0) {
            gravityFromRelative |= gravityFromRelative2 & 7;
        }
        if ((gravityFromRelative & 112) == 0) {
            gravityFromRelative |= gravityFromRelative2 & 112;
        }
        if ((gravityFromRelative & 7) == 0) {
            gravityFromRelative |= 3;
        }
        return (gravityFromRelative & 112) == 0 ? gravityFromRelative | 48 : gravityFromRelative;
    }

    private int getGravityFromRelative(int i) {
        if (this.config.getOrientation() == 1 && (i & 8388608) == 0) {
            i = ((i & 112) >> 4) | ((i & 7) << 4);
        }
        if (this.config.getLayoutDirection() != 1 || (i & 8388608) == 0) {
            return i;
        }
        return ((i & 3) == 3 ? 5 : 0) | ((i & 5) == 5 ? 3 : 0);
    }

    private float getWeight(LayoutParams layoutParams) {
        return layoutParams.weightSpecified() ? layoutParams.getWeight() : this.config.getWeightDefault();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        drawDebugInfo(canvas, view);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View, android.view.ViewParent
    public int getLayoutDirection() {
        LayoutConfiguration layoutConfiguration = this.config;
        if (layoutConfiguration == null) {
            return 0;
        }
        return layoutConfiguration.getLayoutDirection();
    }

    public int getOrientation() {
        return this.config.getOrientation();
    }

    public float getWeightDefault() {
        return this.config.getWeightDefault();
    }

    public boolean isDebugDraw() {
        return this.config.isDebugDraw() || debugDraw();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.x + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutParams.y + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + layoutParams.x + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, childAt.getMeasuredHeight() + layoutParams.y + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = this.config.getOrientation() == 0 ? size : size2;
        if (this.config.getOrientation() == 0) {
            size = size2;
        }
        if (this.config.getOrientation() != 0) {
            mode = mode2;
        }
        this.config.getOrientation();
        this.lines.clear();
        LineDefinition lineDefinition = new LineDefinition(i5);
        this.lines.add(lineDefinition);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
                layoutParams.orientation = this.config.getOrientation();
                if (this.config.getOrientation() == 0) {
                    layoutParams.setLength(childAt.getMeasuredWidth());
                    layoutParams.setThickness(childAt.getMeasuredHeight());
                } else {
                    layoutParams.setLength(childAt.getMeasuredHeight());
                    layoutParams.setThickness(childAt.getMeasuredWidth());
                }
                if (layoutParams.isNewLine() || (mode != 0 && !lineDefinition.canFit(childAt))) {
                    lineDefinition = new LineDefinition(i5);
                    if (this.config.getOrientation() == 1 && this.config.getLayoutDirection() == 1) {
                        this.lines.add(0, lineDefinition);
                    } else {
                        this.lines.add(lineDefinition);
                    }
                }
                if (this.config.getOrientation() == 0 && this.config.getLayoutDirection() == 1) {
                    lineDefinition.addView(0, childAt);
                } else {
                    lineDefinition.addView(childAt);
                }
            }
        }
        calculateLinesAndChildPosition(this.lines);
        int size3 = this.lines.size();
        int iMax = 0;
        for (int i7 = 0; i7 < size3; i7++) {
            iMax = Math.max(iMax, this.lines.get(i7).getLineLength());
        }
        int lineStartThickness = lineDefinition.getLineStartThickness() + lineDefinition.getLineThickness();
        applyGravityToLines(this.lines, findSize(mode, i5, iMax), findSize(mode2, size, lineStartThickness));
        for (int i8 = 0; i8 < size3; i8++) {
            LineDefinition lineDefinition2 = this.lines.get(i8);
            applyGravityToLine(lineDefinition2);
            applyPositionsToViews(lineDefinition2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.config.getOrientation() == 0) {
            i3 = paddingRight + iMax;
            i4 = paddingTop + lineStartThickness;
        } else {
            i3 = paddingRight + lineStartThickness;
            i4 = paddingTop + iMax;
        }
        setMeasuredDimension(View.resolveSize(i3, i), View.resolveSize(i4, i2));
    }

    public void setDebugDraw(boolean z) {
        this.config.setDebugDraw(z);
        invalidate();
    }

    public void setGravity(int i) {
        this.config.setGravity(i);
        requestLayout();
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        this.config.setLayoutDirection(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        this.config.setOrientation(i);
        requestLayout();
    }

    public void setWeightDefault(float f) {
        this.config.setWeightDefault(f);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private int gravity;
        private int inlineStartLength;
        private int inlineStartThickness;
        private int length;

        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 48, to = "TOP"), @ViewDebug.IntToString(from = 80, to = "BOTTOM"), @ViewDebug.IntToString(from = 3, to = "LEFT"), @ViewDebug.IntToString(from = 5, to = "RIGHT"), @ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug.IntToString(from = 17, to = "CENTER"), @ViewDebug.IntToString(from = 119, to = "FILL")})
        private boolean newLine;
        private int orientation;
        private int thickness;
        private float weight;
        private int x;
        private int y;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.newLine = false;
            this.gravity = 0;
            this.weight = -1.0f;
            readStyleParameters(context, attributeSet);
        }

        private void readStyleParameters(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout_LayoutParams);
            try {
                this.newLine = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlowLayout_LayoutParams_layout_newLine, false);
                this.gravity = typedArrayObtainStyledAttributes.getInt(R$styleable.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.weight = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlowLayout_LayoutParams_layout_weight, -1.0f);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        public int getGravity() {
            return this.gravity;
        }

        public int getInlineStartLength() {
            return this.inlineStartLength;
        }

        public int getInlineStartThickness() {
            return this.inlineStartThickness;
        }

        public int getLength() {
            return this.length;
        }

        public int getSpacingLength() {
            int i;
            int i2;
            if (this.orientation == 0) {
                i = ((ViewGroup.MarginLayoutParams) this).leftMargin;
                i2 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            } else {
                i = ((ViewGroup.MarginLayoutParams) this).topMargin;
                i2 = ((ViewGroup.MarginLayoutParams) this).bottomMargin;
            }
            return i + i2;
        }

        public int getSpacingThickness() {
            int i;
            int i2;
            if (this.orientation == 0) {
                i = ((ViewGroup.MarginLayoutParams) this).topMargin;
                i2 = ((ViewGroup.MarginLayoutParams) this).bottomMargin;
            } else {
                i = ((ViewGroup.MarginLayoutParams) this).leftMargin;
                i2 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            }
            return i + i2;
        }

        public int getThickness() {
            return this.thickness;
        }

        public float getWeight() {
            return this.weight;
        }

        public boolean gravitySpecified() {
            return this.gravity != 0;
        }

        public boolean isNewLine() {
            return this.newLine;
        }

        public void setInlineStartLength(int i) {
            this.inlineStartLength = i;
        }

        public void setInlineStartThickness(int i) {
            this.inlineStartThickness = i;
        }

        public void setLength(int i) {
            this.length = i;
        }

        public void setPosition(int i, int i2) {
            this.x = i;
            this.y = i2;
        }

        public void setThickness(int i) {
            this.thickness = i;
        }

        public boolean weightSpecified() {
            return this.weight >= 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.newLine = false;
            this.gravity = 0;
            this.weight = -1.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.newLine = false;
            this.gravity = 0;
            this.weight = -1.0f;
        }
    }

    public int getGravity() {
        return this.config.getGravity();
    }
}
