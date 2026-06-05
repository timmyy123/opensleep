package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget mBiggest = null;
        int mBiggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i2;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.mBiggest = null;
            this.mBiggestDimension = 0;
            int i = this.mCount;
            for (int i2 = 0; i2 < i && this.mStartIndex + i2 < Flow.this.mDisplayedWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i2];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i3 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i3 = 0;
                    }
                    this.mWidth = width + i3 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i4 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.mHeight = widgetHeight2 + i4 + this.mHeight;
                    if (this.mBiggest == null || this.mBiggestDimension < widgetWidth) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i = this.mOrientation;
            Flow flow = Flow.this;
            if (i == 0) {
                int widgetWidth = flow.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth = widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0) + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = flow.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight = widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0) + this.mHeight;
                if (this.mBiggest == null || this.mBiggestDimension < widgetWidth2) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.mBiggestDimension = 0;
            this.mBiggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:86:0x0144 A[PHI: r3 r11
          0x0144: PHI (r3v43 int) = (r3v41 int), (r3v45 int) binds: [B:91:0x015d, B:85:0x0142] A[DONT_GENERATE, DONT_INLINE]
          0x0144: PHI (r11v55 float) = (r11v53 float), (r11v58 float) binds: [B:91:0x015d, B:85:0x0142] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void createConstraints(boolean z, int i, boolean z2) {
            ConstraintWidget constraintWidget;
            int i2;
            char c;
            int i3 = this.mCount;
            for (int i4 = 0; i4 < i3 && this.mStartIndex + i4 < Flow.this.mDisplayedWidgetsCount; i4++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i4];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i3 == 0 || this.mBiggest == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i5 = -1;
            int i6 = -1;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = z ? (i3 - 1) - i7 : i7;
                if (this.mStartIndex + i8 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget3 = Flow.this.mDisplayedWidgets[this.mStartIndex + i8];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                    if (i5 == -1) {
                        i5 = i7;
                    }
                    i6 = i7;
                }
            }
            int i9 = this.mOrientation;
            ConstraintWidget constraintWidget4 = this.mBiggest;
            ConstraintWidget constraintWidget5 = null;
            if (i9 != 0) {
                constraintWidget4.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i10 = this.mPaddingLeft;
                if (i > 0) {
                    i10 += Flow.this.mHorizontalGap;
                }
                if (z) {
                    constraintWidget4.mRight.connect(this.mRight, i10);
                    if (z2) {
                        constraintWidget4.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget4.mRight, 0);
                    }
                } else {
                    constraintWidget4.mLeft.connect(this.mLeft, i10);
                    if (z2) {
                        constraintWidget4.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget4.mLeft, 0);
                    }
                }
                for (int i11 = 0; i11 < i3 && this.mStartIndex + i11 < Flow.this.mDisplayedWidgetsCount; i11++) {
                    ConstraintWidget constraintWidget6 = Flow.this.mDisplayedWidgets[this.mStartIndex + i11];
                    if (constraintWidget6 != null) {
                        if (i11 == 0) {
                            constraintWidget6.connect(constraintWidget6.mTop, this.mTop, this.mPaddingTop);
                            int i12 = Flow.this.mVerticalStyle;
                            float f = Flow.this.mVerticalBias;
                            if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                                i12 = Flow.this.mFirstVerticalStyle;
                                f = Flow.this.mFirstVerticalBias;
                            } else if (z2 && Flow.this.mLastVerticalStyle != -1) {
                                i12 = Flow.this.mLastVerticalStyle;
                                f = Flow.this.mLastVerticalBias;
                            }
                            constraintWidget6.setVerticalChainStyle(i12);
                            constraintWidget6.setVerticalBiasPercent(f);
                        }
                        if (i11 == i3 - 1) {
                            constraintWidget6.connect(constraintWidget6.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (constraintWidget5 != null) {
                            constraintWidget6.mTop.connect(constraintWidget5.mBottom, Flow.this.mVerticalGap);
                            if (i11 == i5) {
                                constraintWidget6.mTop.setGoneMargin(this.mPaddingTop);
                            }
                            constraintWidget5.mBottom.connect(constraintWidget6.mTop, 0);
                            if (i11 == i6 + 1) {
                                constraintWidget5.mBottom.setGoneMargin(this.mPaddingBottom);
                            }
                        }
                        if (constraintWidget6 != constraintWidget4) {
                            Flow flow = Flow.this;
                            if (z) {
                                int i13 = flow.mHorizontalAlign;
                                if (i13 == 0) {
                                    constraintWidget6.mRight.connect(constraintWidget4.mRight, 0);
                                } else if (i13 == 1) {
                                    constraintWidget6.mLeft.connect(constraintWidget4.mLeft, 0);
                                } else if (i13 == 2) {
                                    constraintWidget6.mLeft.connect(constraintWidget4.mLeft, 0);
                                    constraintWidget6.mRight.connect(constraintWidget4.mRight, 0);
                                }
                                constraintWidget5 = constraintWidget6;
                            } else {
                                int i14 = flow.mHorizontalAlign;
                                if (i14 == 0) {
                                    constraintWidget6.mLeft.connect(constraintWidget4.mLeft, 0);
                                } else if (i14 == 1) {
                                    constraintWidget6.mRight.connect(constraintWidget4.mRight, 0);
                                } else if (i14 == 2) {
                                    ConstraintAnchor constraintAnchor = constraintWidget6.mLeft;
                                    if (z3) {
                                        constraintAnchor.connect(this.mLeft, this.mPaddingLeft);
                                        constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                                    } else {
                                        constraintAnchor.connect(constraintWidget4.mLeft, 0);
                                        constraintWidget6.mRight.connect(constraintWidget4.mRight, 0);
                                    }
                                }
                                constraintWidget5 = constraintWidget6;
                            }
                        } else {
                            constraintWidget5 = constraintWidget6;
                        }
                    }
                }
                return;
            }
            constraintWidget4.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i15 = this.mPaddingTop;
            if (i > 0) {
                i15 += Flow.this.mVerticalGap;
            }
            constraintWidget4.mTop.connect(this.mTop, i15);
            if (z2) {
                constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
            }
            char c2 = 3;
            if (Flow.this.mVerticalAlign != 3 || constraintWidget4.hasBaseline()) {
                constraintWidget = constraintWidget4;
            } else {
                for (int i16 = 0; i16 < i3; i16++) {
                    int i17 = z ? (i3 - 1) - i16 : i16;
                    if (this.mStartIndex + i17 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i17];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget4;
            }
            int i18 = 0;
            while (i18 < i3) {
                int i19 = z ? (i3 - 1) - i18 : i18;
                if (this.mStartIndex + i19 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget7 = Flow.this.mDisplayedWidgets[this.mStartIndex + i19];
                if (constraintWidget7 == null) {
                    constraintWidget7 = constraintWidget5;
                    c = c2;
                } else {
                    if (i18 == 0) {
                        i2 = 1;
                        constraintWidget7.connect(constraintWidget7.mLeft, this.mLeft, this.mPaddingLeft);
                    } else {
                        i2 = 1;
                    }
                    if (i19 == 0) {
                        int i20 = Flow.this.mHorizontalStyle;
                        float f2 = Flow.this.mHorizontalBias;
                        if (z) {
                            f2 = 1.0f - f2;
                        }
                        if (this.mStartIndex != 0 || Flow.this.mFirstHorizontalStyle == -1) {
                            if (z2 && Flow.this.mLastHorizontalStyle != -1) {
                                i20 = Flow.this.mLastHorizontalStyle;
                                f2 = Flow.this.mLastHorizontalBias;
                                if (z) {
                                    f2 = 1.0f - f2;
                                }
                            }
                            constraintWidget7.setHorizontalChainStyle(i20);
                            constraintWidget7.setHorizontalBiasPercent(f2);
                        } else {
                            i20 = Flow.this.mFirstHorizontalStyle;
                            f2 = Flow.this.mFirstHorizontalBias;
                            if (z) {
                            }
                            constraintWidget7.setHorizontalChainStyle(i20);
                            constraintWidget7.setHorizontalBiasPercent(f2);
                        }
                    }
                    if (i18 == i3 - 1) {
                        constraintWidget7.connect(constraintWidget7.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget5 != null) {
                        constraintWidget7.mLeft.connect(constraintWidget5.mRight, Flow.this.mHorizontalGap);
                        if (i18 == i5) {
                            constraintWidget7.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget5.mRight.connect(constraintWidget7.mLeft, 0);
                        if (i18 == i6 + 1) {
                            constraintWidget5.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget7 != constraintWidget4) {
                        c = 3;
                        if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget7 != constraintWidget && constraintWidget7.hasBaseline()) {
                            constraintWidget7.mBaseline.connect(constraintWidget.mBaseline, 0);
                        } else {
                            int i21 = Flow.this.mVerticalAlign;
                            if (i21 == 0) {
                                constraintWidget7.mTop.connect(constraintWidget4.mTop, 0);
                            } else if (i21 != i2) {
                                ConstraintAnchor constraintAnchor2 = constraintWidget7.mTop;
                                if (z3) {
                                    constraintAnchor2.connect(this.mTop, this.mPaddingTop);
                                    constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                } else {
                                    constraintAnchor2.connect(constraintWidget4.mTop, 0);
                                    constraintWidget7.mBottom.connect(constraintWidget4.mBottom, 0);
                                }
                            } else {
                                constraintWidget7.mBottom.connect(constraintWidget4.mBottom, 0);
                            }
                        }
                    } else {
                        c = 3;
                    }
                }
                i18++;
                c2 = c;
                constraintWidget5 = constraintWidget7;
            }
        }

        public int getHeight() {
            int i = this.mOrientation;
            int i2 = this.mHeight;
            return i == 1 ? i2 - Flow.this.mVerticalGap : i2;
        }

        public int getWidth() {
            int i = this.mOrientation;
            int i2 = this.mWidth;
            return i == 0 ? i2 - Flow.this.mHorizontalGap : i2;
        }

        public void measureMatchConstraints(int i) {
            int i2 = this.mNbMatchConstraintsWidgets;
            if (i2 == 0) {
                return;
            }
            int i3 = this.mCount;
            int i4 = i / i2;
            for (int i5 = 0; i5 < i3 && this.mStartIndex + i5 < Flow.this.mDisplayedWidgetsCount; i5++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i5];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i6 = i4;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i6);
                    i4 = i6;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
            this.mMax = i6;
        }
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        float f;
        int i;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mDisplayedWidgetsCount; i2++) {
            this.mDisplayedWidgets[i2].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i3 = iArr[0];
        int i4 = iArr[1];
        float f2 = this.mHorizontalBias;
        ConstraintWidget constraintWidget2 = null;
        int i5 = 0;
        while (i5 < i3) {
            if (z) {
                i = (i3 - i5) - 1;
                f = 1.0f - this.mHorizontalBias;
            } else {
                f = f2;
                i = i5;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i5 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f);
                }
                if (i5 == i3 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i5 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i5++;
            f2 = f;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i6];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i6 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i6 == i4 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i6 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = (i8 * i3) + i7;
                if (this.mOrientation == 1) {
                    i9 = (i7 * i4) + i8;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i9 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i9]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i7];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i8];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i3 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            }
            constraintWidget2 = constraintWidget;
            if (i2 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i2 == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i3 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i3;
            }
            constraintWidget2 = constraintWidget;
            if (i2 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i2 == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x010b -> B:40:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x010d -> B:40:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x0113 -> B:40:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0115 -> B:40:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureAligned(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int iCeil;
        ConstraintWidget constraintWidget;
        int iCeil2 = this.mMaxElementsWrap;
        if (i2 == 0) {
            if (iCeil2 <= 0) {
                iCeil2 = 0;
                int widgetWidth = 0;
                for (int i4 = 0; i4 < i; i4++) {
                    if (i4 > 0) {
                        widgetWidth += this.mHorizontalGap;
                    }
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i4];
                    if (constraintWidget2 != null) {
                        widgetWidth += getWidgetWidth(constraintWidget2, i3);
                        if (widgetWidth > i3) {
                            break;
                        } else {
                            iCeil2++;
                        }
                    }
                }
            }
            iCeil = iCeil2;
            iCeil2 = 0;
        } else {
            if (iCeil2 <= 0) {
                iCeil2 = 0;
                int widgetHeight = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    if (i5 > 0) {
                        widgetHeight += this.mVerticalGap;
                    }
                    ConstraintWidget constraintWidget3 = constraintWidgetArr[i5];
                    if (constraintWidget3 != null) {
                        widgetHeight += getWidgetHeight(constraintWidget3, i3);
                        if (widgetHeight > i3) {
                            break;
                        } else {
                            iCeil2++;
                        }
                    }
                }
            }
            iCeil = 0;
        }
        if (this.mAlignedDimensions == null) {
            this.mAlignedDimensions = new int[2];
        }
        boolean z = (iCeil2 == 0 && i2 == 1) || (iCeil == 0 && i2 == 0);
        while (!z) {
            if (i2 == 0) {
                iCeil2 = (int) Math.ceil(i / iCeil);
            } else {
                iCeil = (int) Math.ceil(i / iCeil2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mAlignedBiggestElementsInCols;
            if (constraintWidgetArr2 == null || constraintWidgetArr2.length < iCeil) {
                this.mAlignedBiggestElementsInCols = new ConstraintWidget[iCeil];
            } else {
                Arrays.fill(constraintWidgetArr2, (Object) null);
            }
            ConstraintWidget[] constraintWidgetArr3 = this.mAlignedBiggestElementsInRows;
            if (constraintWidgetArr3 == null || constraintWidgetArr3.length < iCeil2) {
                this.mAlignedBiggestElementsInRows = new ConstraintWidget[iCeil2];
            } else {
                Arrays.fill(constraintWidgetArr3, (Object) null);
            }
            for (int i6 = 0; i6 < iCeil; i6++) {
                for (int i7 = 0; i7 < iCeil2; i7++) {
                    int i8 = (i7 * iCeil) + i6;
                    if (i2 == 1) {
                        i8 = (i6 * iCeil2) + i7;
                    }
                    if (i8 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i8]) != null) {
                        int widgetWidth2 = getWidgetWidth(constraintWidget, i3);
                        ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInCols[i6];
                        if (constraintWidget4 == null || constraintWidget4.getWidth() < widgetWidth2) {
                            this.mAlignedBiggestElementsInCols[i6] = constraintWidget;
                        }
                        int widgetHeight2 = getWidgetHeight(constraintWidget, i3);
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInRows[i7];
                        if (constraintWidget5 == null || constraintWidget5.getHeight() < widgetHeight2) {
                            this.mAlignedBiggestElementsInRows[i7] = constraintWidget;
                        }
                    }
                }
            }
            int widgetWidth3 = 0;
            for (int i9 = 0; i9 < iCeil; i9++) {
                ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInCols[i9];
                if (constraintWidget6 != null) {
                    if (i9 > 0) {
                        widgetWidth3 += this.mHorizontalGap;
                    }
                    widgetWidth3 += getWidgetWidth(constraintWidget6, i3);
                }
            }
            int widgetHeight3 = 0;
            for (int i10 = 0; i10 < iCeil2; i10++) {
                ConstraintWidget constraintWidget7 = this.mAlignedBiggestElementsInRows[i10];
                if (constraintWidget7 != null) {
                    if (i10 > 0) {
                        widgetHeight3 += this.mVerticalGap;
                    }
                    widgetHeight3 += getWidgetHeight(constraintWidget7, i3);
                }
            }
            iArr[0] = widgetWidth3;
            iArr[1] = widgetHeight3;
            if (i2 != 0) {
                if (widgetHeight3 > i3 && iCeil2 > 1) {
                    iCeil2--;
                }
            } else if (widgetWidth3 > i3 && iCeil > 1) {
                iCeil--;
            }
            while (!z) {
            }
        }
        int[] iArr2 = this.mAlignedDimensions;
        iArr2[0] = iCeil;
        iArr2[1] = iCeil2;
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        Flow flow;
        int i5;
        ConstraintAnchor constraintAnchor;
        int i6;
        Flow flow2 = this;
        if (i == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i7 = i3;
        WidgetsList widgetsList = flow2.new WidgetsList(i2, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i7);
        flow2.mChainList.add(widgetsList);
        if (i2 == 0) {
            i4 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i9 < i) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i9];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i7);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i10 = i4;
                boolean z = (i8 == i7 || (flow2.mHorizontalGap + i8) + widgetWidth > i7) && widgetsList.mBiggest != null;
                if (!z && i9 > 0 && (i6 = flow2.mMaxElementsWrap) > 0 && i9 % i6 == 0) {
                    z = true;
                }
                if (z) {
                    widgetsList = flow2.new WidgetsList(i2, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i7);
                    widgetsList.setStartIndex(i9);
                    flow2.mChainList.add(widgetsList);
                } else {
                    if (i9 > 0) {
                        i8 = flow2.mHorizontalGap + widgetWidth + i8;
                    }
                    widgetsList.add(constraintWidget);
                    i9++;
                    i4 = i10;
                }
                i8 = widgetWidth;
                widgetsList.add(constraintWidget);
                i9++;
                i4 = i10;
            }
        } else {
            i4 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i12];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i7);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i13 = i4;
                boolean z2 = (i11 == i7 || (flow2.mVerticalGap + i11) + widgetHeight > i7) && widgetsList.mBiggest != null;
                if (!z2 && i12 > 0 && (i5 = flow2.mMaxElementsWrap) > 0 && i12 % i5 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = flow2.new WidgetsList(i2, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i7);
                    flow = flow2;
                    widgetsList.setStartIndex(i12);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i12 > 0) {
                        i11 = flow.mVerticalGap + widgetHeight + i11;
                    }
                    widgetsList.add(constraintWidget2);
                    i12++;
                    i7 = i3;
                    i4 = i13;
                    flow2 = flow;
                }
                i11 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i12++;
                i7 = i3;
                i4 = i13;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i4 > 0 && z3) {
            for (int i14 = 0; i14 < size; i14++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i14);
                if (i2 == 0) {
                    widgetsList2.measureMatchConstraints(i3 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i3 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int paddingBottom2 = paddingBottom;
        int i15 = 0;
        int paddingRight2 = paddingRight;
        int i16 = paddingTop;
        int i17 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i18 = 0;
        for (int i19 = 0; i19 < size; i19++) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i19);
            if (i2 == 0) {
                if (i19 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i19 + 1).mBiggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                int i20 = i18;
                widgetsList3.setup(i2, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i17, i16, paddingRight2, paddingBottom2, i3);
                int iMax = Math.max(i15, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i20;
                if (i19 > 0) {
                    height += flow3.mVerticalGap;
                }
                i18 = height;
                i15 = iMax;
                constraintAnchor9 = constraintAnchor10;
                i16 = 0;
            } else {
                int i21 = i15;
                int i22 = i18;
                if (i19 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i19 + 1).mBiggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i2, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i17, i16, paddingRight2, paddingBottom2, i3);
                int width = widgetsList3.getWidth() + i21;
                int iMax2 = Math.max(i22, widgetsList3.getHeight());
                if (i19 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i23 = width;
                i18 = iMax2;
                i15 = i23;
                i17 = 0;
                constraintAnchor6 = constraintAnchor11;
            }
        }
        iArr[0] = i15;
        iArr[1] = i18;
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        Flow flow;
        int i5;
        boolean z;
        ConstraintAnchor constraintAnchor;
        int i6;
        Flow flow2 = this;
        if (i == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i7 = i3;
        WidgetsList widgetsList = flow2.new WidgetsList(i2, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i7);
        flow2.mChainList.add(widgetsList);
        boolean z2 = true;
        if (i2 == 0) {
            int i8 = 0;
            i4 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i) {
                i8++;
                ConstraintWidget constraintWidget = constraintWidgetArr[i10];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i7);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i11 = i4;
                boolean z3 = (i9 == i7 || (flow2.mHorizontalGap + i9) + widgetWidth > i7) && widgetsList.mBiggest != null;
                if (!z3 && i10 > 0 && (i6 = flow2.mMaxElementsWrap) > 0 && i8 > i6) {
                    z3 = true;
                }
                if (z3) {
                    widgetsList = flow2.new WidgetsList(i2, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i7);
                    widgetsList.setStartIndex(i10);
                    flow2.mChainList.add(widgetsList);
                    i8 = 1;
                } else {
                    if (i10 > 0) {
                        i9 = flow2.mHorizontalGap + widgetWidth + i9;
                    }
                    widgetsList.add(constraintWidget);
                    i10++;
                    i4 = i11;
                }
                i9 = widgetWidth;
                widgetsList.add(constraintWidget);
                i10++;
                i4 = i11;
            }
        } else {
            int i12 = 0;
            i4 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i14 < i) {
                i12++;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i14];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i7);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i15 = i4;
                boolean z4 = (i13 == i7 || (flow2.mVerticalGap + i13) + widgetHeight > i7) && widgetsList.mBiggest != null;
                if (!z4 && i14 > 0 && (i5 = flow2.mMaxElementsWrap) > 0 && i12 > i5) {
                    z4 = true;
                }
                if (z4) {
                    widgetsList = flow2.new WidgetsList(i2, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i7);
                    flow = flow2;
                    widgetsList.setStartIndex(i14);
                    flow.mChainList.add(widgetsList);
                    i12 = 1;
                } else {
                    flow = flow2;
                    if (i14 > 0) {
                        i13 = flow.mVerticalGap + widgetHeight + i13;
                    }
                    widgetsList.add(constraintWidget2);
                    i14++;
                    i7 = i3;
                    i4 = i15;
                    flow2 = flow;
                }
                i13 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i14++;
                i7 = i3;
                i4 = i15;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z5 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i4 > 0 && z5) {
            for (int i16 = 0; i16 < size; i16++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i16);
                if (i2 == 0) {
                    widgetsList2.measureMatchConstraints(i3 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i3 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor3;
        int paddingBottom2 = paddingBottom;
        int i17 = 0;
        int i18 = 0;
        int paddingRight2 = paddingRight;
        int i19 = paddingTop;
        int i20 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor2;
        int i21 = 0;
        while (i18 < size) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i18);
            if (i2 == 0) {
                if (i18 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i18 + 1).mBiggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                z = z2;
                int i22 = i17;
                widgetsList3.setup(i2, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i20, i19, paddingRight2, paddingBottom2, i3);
                int iMax = Math.max(i21, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i22;
                if (i18 > 0) {
                    height += flow3.mVerticalGap;
                }
                i17 = height;
                i21 = iMax;
                constraintAnchor6 = constraintAnchor10;
                i19 = 0;
            } else {
                int i23 = i17;
                z = z2;
                int i24 = i21;
                if (i18 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i18 + 1).mBiggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i2, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i20, i19, paddingRight2, paddingBottom2, i3);
                int width = widgetsList3.getWidth() + i24;
                int iMax2 = Math.max(i23, widgetsList3.getHeight());
                if (i18 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i25 = width;
                i17 = iMax2;
                i21 = i25;
                i20 = 0;
                constraintAnchor9 = constraintAnchor11;
            }
            i18++;
            z2 = z;
        }
        iArr[0] = i21;
        iArr[z2 ? 1 : 0] = i17;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        if (i == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i3);
            widgetsList = widgetsList2;
        }
        for (int i4 = 0; i4 < i; i4++) {
            widgetsList.add(constraintWidgetArr[i4]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        boolean z2 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i2 = 0;
                while (i2 < size) {
                    this.mChainList.get(i2).createConstraints(z2, i2, i2 == size + (-1));
                    i2++;
                }
            } else if (i == 2) {
                createAlignedConstraints(z2);
            } else if (i == 3) {
                int size2 = this.mChainList.size();
                int i3 = 0;
                while (i3 < size2) {
                    this.mChainList.get(i3).createConstraints(z2, i3, i3 == size2 + (-1));
                    i3++;
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z2, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        int i5;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i6 = (i2 - paddingLeft) - paddingRight;
        int i7 = this.mOrientation;
        if (i7 == 1) {
            i6 = (i4 - paddingTop) - paddingBottom;
        }
        int i8 = i6;
        int i9 = this.mHorizontalStyle;
        if (i7 == 0) {
            if (i9 == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (i9 == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i5 = this.mWidgetsCount;
            if (i10 >= i5) {
                break;
            }
            if (this.mWidgets[i10].getVisibility() == 8) {
                i11++;
            }
            i10++;
        }
        if (i11 > 0) {
            constraintWidgetArr = new ConstraintWidget[i5 - i11];
            int i12 = 0;
            i5 = 0;
            while (i12 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget = this.mWidgets[i12];
                ConstraintWidget[] constraintWidgetArr2 = constraintWidgetArr;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr2[i5] = constraintWidget;
                    i5++;
                }
                i12++;
                constraintWidgetArr = constraintWidgetArr2;
            }
        }
        int i13 = i5;
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i13;
        int i14 = this.mWrapMode;
        if (i14 == 0) {
            measureNoWrap(constraintWidgetArr, i13, this.mOrientation, i8, iArr);
        } else if (i14 == 1) {
            measureChainWrap(constraintWidgetArr, i13, this.mOrientation, i8, iArr);
        } else if (i14 == 2) {
            measureAligned(constraintWidgetArr, i13, this.mOrientation, i8, iArr);
        } else if (i14 == 3) {
            measureChainWrap_new(constraintWidgetArr, i13, this.mOrientation, i8, iArr);
        }
        int iMin = iArr[0] + paddingLeft + paddingRight;
        int iMin2 = iArr[1] + paddingTop + paddingBottom;
        if (i == 1073741824) {
            iMin = i2;
        } else if (i == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i2);
        } else if (i != 0) {
            iMin = 0;
        }
        if (i3 == 1073741824) {
            iMin2 = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i4);
        } else if (i3 != 0) {
            iMin2 = 0;
        }
        setMeasure(iMin, iMin2);
        setWidth(iMin);
        setHeight(iMin2);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }
}
