package androidx.constraintlayout.core.widgets;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static float DEFAULT_BIAS = 0.5f;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    protected ArrayList<ConstraintAnchor> mAnchors;
    private boolean mAnimated;
    int mBaselineDistance;
    public ConstraintAnchor mCenter;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    boolean mHorizontalWrapVisited;
    private boolean mInPlaceholder;
    private boolean[] mIsInBarrier;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public boolean measured = false;
    public WidgetRun[] run = new WidgetRun[2];
    public HorizontalWidgetRun mHorizontalRun = null;
    public VerticalWidgetRun mVerticalRun = null;
    public boolean[] isTerminalWidget = {true, true};
    boolean mResolvedHasRatio = false;
    private boolean mMeasureRequested = true;
    private boolean mOptimizeWrapO = false;
    private boolean mOptimizeWrapOnResolved = true;
    private int mWidthOverride = -1;
    private int mHeightOverride = -1;
    public WidgetFrame frame = new WidgetFrame(this);
    private boolean mResolvedHorizontal = false;
    private boolean mResolvedVertical = false;
    private boolean mHorizontalSolvingPass = false;
    private boolean mVerticalSolvingPass = false;
    public int mHorizontalResolution = -1;
    public int mVerticalResolution = -1;
    private int mWrapBehaviorInParent = 0;
    public int mMatchConstraintDefaultWidth = 0;
    public int mMatchConstraintDefaultHeight = 0;
    public int[] mResolvedMatchConstraintDefault = new int[2];
    public int mMatchConstraintMinWidth = 0;
    public int mMatchConstraintMaxWidth = 0;
    public float mMatchConstraintPercentWidth = 1.0f;
    public int mMatchConstraintMinHeight = 0;
    public int mMatchConstraintMaxHeight = 0;
    public float mMatchConstraintPercentHeight = 1.0f;
    int mResolvedDimensionRatioSide = -1;
    float mResolvedDimensionRatio = 1.0f;
    private int[] mMaxDimension = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float mCircleConstraintAngle = Float.NaN;
    private boolean mHasBaseline = false;
    private boolean mInVirtualLayout = false;
    private int mLastHorizontalMeasureSpec = 0;
    private int mLastVerticalMeasureSpec = 0;
    public ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:362:0x0582  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        boolean z12;
        int iMin;
        boolean z13;
        int i9;
        int i10;
        SolverVariable solverVariable3;
        int i11;
        SolverVariable solverVariable4;
        boolean z14;
        boolean z15;
        int i12;
        int i13;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariableCreateObjectVariable2;
        SolverVariable solverVariable5;
        int i14;
        char c;
        char c2;
        ConstraintAnchor constraintAnchor3;
        boolean z16;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        boolean z17;
        boolean z18;
        int i15;
        int i16;
        int i17;
        boolean z19;
        boolean z20;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        boolean z21;
        int i18;
        boolean z22;
        int iMin2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z23;
        boolean z24;
        ConstraintWidget constraintWidget4;
        int i26;
        ConstraintWidget constraintWidget5;
        LinearSystem linearSystem2 = linearSystem;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem2.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem2.createObjectVariable(constraintAnchor2.getTarget());
        LinearSystem.getMetrics();
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i27 = zIsConnected2 ? (zIsConnected ? 1 : 0) + 1 : zIsConnected ? 1 : 0;
        if (zIsConnected3) {
            i27++;
        }
        int i28 = z6 ? 3 : i5;
        int iOrdinal = dimensionBehaviour.ordinal();
        boolean z25 = (iOrdinal == 0 || iOrdinal == 1 || iOrdinal != 2 || i28 == 4) ? false : true;
        int i29 = this.mWidthOverride;
        if (i29 != -1 && z) {
            this.mWidthOverride = -1;
            i2 = i29;
            z25 = false;
        }
        int i30 = this.mHeightOverride;
        if (i30 == -1 || z) {
            i30 = i2;
        } else {
            this.mHeightOverride = -1;
            z25 = false;
        }
        int i31 = i30;
        if (this.mVisibility == 8) {
            iMin = 0;
            z12 = false;
        } else {
            z12 = z25;
            iMin = i31;
        }
        if (z11) {
            if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                linearSystem2.addEquality(solverVariableCreateObjectVariable3, i);
            } else if (zIsConnected && !zIsConnected2) {
                z13 = z12;
                i9 = 8;
                linearSystem2.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
            }
            z13 = z12;
            i9 = 8;
        } else {
            z13 = z12;
            i9 = 8;
        }
        if (!z13) {
            if (z5) {
                linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
                if (i3 > 0) {
                    linearSystem2.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i3, 8);
                }
                if (i4 < Integer.MAX_VALUE) {
                    linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i4, 8);
                }
            } else {
                linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, i9);
            }
            i13 = i8;
            solverVariable3 = solverVariableCreateObjectVariable4;
            i11 = i27;
            solverVariable4 = solverVariableCreateObjectVariable6;
            z14 = z13;
            z15 = z4;
            i12 = i7;
        } else if (i27 == 2 || z6 || !(i28 == 1 || i28 == 0)) {
            int i32 = i7 == -2 ? iMin : i7;
            int i33 = i8 == -2 ? iMin : i8;
            if (iMin > 0 && i28 != 1) {
                iMin = 0;
            }
            if (i32 > 0) {
                linearSystem2.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i32, 8);
                iMin = Math.max(iMin, i32);
            }
            if (i33 > 0) {
                if (!z2 || i28 != 1) {
                    linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i33, 8);
                }
                iMin = Math.min(iMin, i33);
            }
            if (i28 == 1) {
                if (z2) {
                    linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else if (z8) {
                    linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else {
                    linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                }
                solverVariable3 = solverVariableCreateObjectVariable4;
                solverVariable4 = solverVariableCreateObjectVariable6;
                z14 = z13;
                z15 = z4;
                i12 = i32;
                i13 = i33;
                i11 = i27;
            } else {
                if (i28 == 2) {
                    ConstraintAnchor.Type type = constraintAnchor.getType();
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                    if (type == type2 || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                        solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(this.mParent.getAnchor(type2));
                        solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                    } else {
                        solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                        solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                    }
                    SolverVariable solverVariable12 = solverVariableCreateObjectVariable2;
                    solverVariable3 = solverVariableCreateObjectVariable4;
                    i10 = i33;
                    i11 = i27;
                    solverVariable4 = solverVariableCreateObjectVariable6;
                    linearSystem2.addConstraint(linearSystem2.createRow().createRowDimensionRatio(solverVariable3, solverVariableCreateObjectVariable3, solverVariable12, solverVariableCreateObjectVariable, f2));
                    if (z2) {
                        z13 = false;
                    }
                    z15 = z4;
                    z14 = z13;
                } else {
                    i10 = i33;
                    solverVariable3 = solverVariableCreateObjectVariable4;
                    i11 = i27;
                    solverVariable4 = solverVariableCreateObjectVariable6;
                    z14 = z13;
                    z15 = true;
                }
                i12 = i32;
                i13 = i10;
            }
        } else {
            int iMax = Math.max(i7, iMin);
            if (i8 > 0) {
                iMax = Math.min(i8, iMax);
            }
            linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMax, 8);
            i12 = i7;
            i13 = i8;
            solverVariable3 = solverVariableCreateObjectVariable4;
            i11 = i27;
            solverVariable4 = solverVariableCreateObjectVariable6;
            z14 = false;
            z15 = z4;
        }
        if (!z11) {
            solverVariable5 = solverVariable2;
            i14 = 8;
            c = 1;
            c2 = 2;
        } else {
            if (!z8) {
                if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                    solverVariable10 = solverVariable4;
                    i20 = 5;
                    z22 = z2;
                    i26 = i20;
                } else if (!zIsConnected || zIsConnected2) {
                    if (!zIsConnected && zIsConnected2) {
                        linearSystem2.addEquality(solverVariable3, solverVariable4, -constraintAnchor2.getMargin(), 8);
                        if (z2) {
                            if (this.mOptimizeWrapO && solverVariableCreateObjectVariable3.isFinalValue && (constraintWidget4 = this.mParent) != null) {
                                ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget4;
                                if (z) {
                                    constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                                } else {
                                    constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                                }
                            } else {
                                i20 = 5;
                                linearSystem2.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 5);
                                solverVariable10 = solverVariable4;
                                z22 = z2;
                                i26 = i20;
                            }
                        }
                    } else if (zIsConnected && zIsConnected2) {
                        ConstraintWidget constraintWidget6 = constraintAnchor.mTarget.mOwner;
                        ConstraintWidget constraintWidget7 = constraintAnchor2.mTarget.mOwner;
                        ConstraintWidget parent = getParent();
                        int i34 = 6;
                        if (z14) {
                            if (i28 == 0) {
                                if (i13 != 0 || i12 != 0) {
                                    i24 = 5;
                                    i25 = 5;
                                    z23 = true;
                                    z24 = false;
                                    z17 = true;
                                } else if (solverVariableCreateObjectVariable5.isFinalValue && solverVariable4.isFinalValue) {
                                    linearSystem2.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                                    linearSystem2.addEquality(solverVariable3, solverVariable4, -constraintAnchor2.getMargin(), 8);
                                    return;
                                } else {
                                    i24 = 8;
                                    i25 = 8;
                                    z23 = false;
                                    z24 = true;
                                    z17 = false;
                                }
                                if ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                    SolverVariable solverVariable13 = solverVariable4;
                                    solverVariable6 = solverVariableCreateObjectVariable3;
                                    solverVariable7 = solverVariable13;
                                    z18 = z23;
                                    z19 = z24;
                                    z16 = true;
                                    i17 = 4;
                                } else {
                                    SolverVariable solverVariable14 = solverVariable4;
                                    solverVariable6 = solverVariableCreateObjectVariable3;
                                    solverVariable7 = solverVariable14;
                                    i17 = i25;
                                    z18 = z23;
                                    z19 = z24;
                                    z16 = true;
                                }
                                i16 = i24;
                                solverVariable8 = solverVariableCreateObjectVariable5;
                                i15 = 6;
                            } else {
                                if (i28 == 2) {
                                    if ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                        SolverVariable solverVariable15 = solverVariable4;
                                        solverVariable6 = solverVariableCreateObjectVariable3;
                                        solverVariable7 = solverVariable15;
                                        solverVariable8 = solverVariableCreateObjectVariable5;
                                        i15 = 6;
                                        z16 = true;
                                        i17 = 4;
                                    } else {
                                        SolverVariable solverVariable16 = solverVariable4;
                                        solverVariable6 = solverVariableCreateObjectVariable3;
                                        solverVariable7 = solverVariable16;
                                        solverVariable8 = solverVariableCreateObjectVariable5;
                                        i15 = 6;
                                        z16 = true;
                                        i17 = 5;
                                    }
                                    i16 = 5;
                                } else if (i28 == 1) {
                                    SolverVariable solverVariable17 = solverVariable4;
                                    solverVariable6 = solverVariableCreateObjectVariable3;
                                    solverVariable7 = solverVariable17;
                                    solverVariable8 = solverVariableCreateObjectVariable5;
                                    i15 = 6;
                                    z16 = true;
                                    i17 = 4;
                                    i16 = 8;
                                } else if (i28 != 3) {
                                    z16 = true;
                                    SolverVariable solverVariable18 = solverVariable4;
                                    solverVariable6 = solverVariableCreateObjectVariable3;
                                    solverVariable7 = solverVariable18;
                                    linearSystem2 = linearSystem;
                                    solverVariable8 = solverVariableCreateObjectVariable5;
                                    i15 = 6;
                                    i17 = 4;
                                    i16 = 5;
                                    z17 = false;
                                    z18 = false;
                                    z19 = false;
                                } else if (this.mResolvedDimensionRatioSide == -1) {
                                    if (z9) {
                                        SolverVariable solverVariable19 = solverVariable4;
                                        solverVariable6 = solverVariableCreateObjectVariable3;
                                        solverVariable7 = solverVariable19;
                                        linearSystem2 = linearSystem;
                                        solverVariable8 = solverVariableCreateObjectVariable5;
                                        z16 = true;
                                        i15 = z2 ? 5 : 4;
                                    } else {
                                        SolverVariable solverVariable20 = solverVariable4;
                                        solverVariable6 = solverVariableCreateObjectVariable3;
                                        solverVariable7 = solverVariable20;
                                        linearSystem2 = linearSystem;
                                        solverVariable8 = solverVariableCreateObjectVariable5;
                                        z16 = true;
                                        i15 = 8;
                                    }
                                    i17 = 5;
                                    i16 = 8;
                                    z17 = true;
                                    z18 = true;
                                    z19 = true;
                                } else {
                                    if (z6) {
                                        if (i6 != 2) {
                                            z16 = true;
                                            if (i6 != 1) {
                                                i22 = 8;
                                                i23 = 5;
                                            }
                                            SolverVariable solverVariable21 = solverVariable4;
                                            solverVariable6 = solverVariableCreateObjectVariable3;
                                            solverVariable7 = solverVariable21;
                                            i16 = i22;
                                            i17 = i23;
                                            z17 = z16;
                                            z18 = z17;
                                            z19 = z18;
                                            solverVariable8 = solverVariableCreateObjectVariable5;
                                            i15 = 6;
                                        } else {
                                            z16 = true;
                                        }
                                        i22 = 5;
                                        i23 = 4;
                                        SolverVariable solverVariable212 = solverVariable4;
                                        solverVariable6 = solverVariableCreateObjectVariable3;
                                        solverVariable7 = solverVariable212;
                                        i16 = i22;
                                        i17 = i23;
                                        z17 = z16;
                                        z18 = z17;
                                        z19 = z18;
                                        solverVariable8 = solverVariableCreateObjectVariable5;
                                        i15 = 6;
                                    } else {
                                        z16 = true;
                                        if (i13 > 0) {
                                            SolverVariable solverVariable22 = solverVariable4;
                                            solverVariable6 = solverVariableCreateObjectVariable3;
                                            solverVariable7 = solverVariable22;
                                            linearSystem2 = linearSystem;
                                            z17 = true;
                                            z18 = true;
                                            z19 = true;
                                            solverVariable8 = solverVariableCreateObjectVariable5;
                                            i15 = 6;
                                            i17 = 5;
                                        } else if (i13 != 0 || i12 != 0) {
                                            SolverVariable solverVariable23 = solverVariable4;
                                            solverVariable6 = solverVariableCreateObjectVariable3;
                                            solverVariable7 = solverVariable23;
                                            linearSystem2 = linearSystem;
                                            z17 = true;
                                            z18 = true;
                                            z19 = true;
                                            solverVariable8 = solverVariableCreateObjectVariable5;
                                            i15 = 6;
                                            i17 = 4;
                                        } else if (z9) {
                                            SolverVariable solverVariable24 = solverVariable4;
                                            solverVariable6 = solverVariableCreateObjectVariable3;
                                            solverVariable7 = solverVariable24;
                                            i16 = (constraintWidget6 == parent || constraintWidget7 == parent) ? 5 : 4;
                                            z17 = true;
                                            z18 = true;
                                            z19 = true;
                                            solverVariable8 = solverVariableCreateObjectVariable5;
                                            i15 = 6;
                                            i17 = 4;
                                        } else {
                                            SolverVariable solverVariable25 = solverVariable4;
                                            solverVariable6 = solverVariableCreateObjectVariable3;
                                            solverVariable7 = solverVariable25;
                                            linearSystem2 = linearSystem;
                                            z17 = true;
                                            z18 = true;
                                            z19 = true;
                                            solverVariable8 = solverVariableCreateObjectVariable5;
                                            i15 = 6;
                                            i17 = 8;
                                        }
                                        i16 = 5;
                                    }
                                    linearSystem2 = linearSystem;
                                }
                                z17 = true;
                                z18 = true;
                                z19 = false;
                            }
                            solverVariable9 = solverVariable2;
                        } else {
                            z16 = true;
                            if (solverVariableCreateObjectVariable5.isFinalValue && solverVariable4.isFinalValue) {
                                SolverVariable solverVariable26 = solverVariable4;
                                linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), f, solverVariable26, solverVariable3, constraintAnchor2.getMargin(), 8);
                                if (z2 && z15) {
                                    int margin = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                                    if (solverVariable26 != solverVariable2) {
                                        linearSystem.addGreaterThan(solverVariable2, solverVariable3, margin, 5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            SolverVariable solverVariable27 = solverVariable4;
                            solverVariable6 = solverVariableCreateObjectVariable3;
                            solverVariable7 = solverVariable27;
                            linearSystem2 = linearSystem;
                            solverVariable8 = solverVariableCreateObjectVariable5;
                            solverVariable9 = solverVariable2;
                            z17 = true;
                            z18 = true;
                            i15 = 6;
                            i16 = 5;
                            i17 = 4;
                            z19 = false;
                        }
                        if (z17 && solverVariable8 == solverVariable7 && constraintWidget6 != parent) {
                            z17 = false;
                            z20 = false;
                        } else {
                            z20 = z16;
                        }
                        if (z18) {
                            if (z14 || z7 || z9 || solverVariable8 != solverVariable || solverVariable7 != solverVariable9) {
                                z21 = z16;
                                i21 = i15;
                                z22 = z2;
                            } else {
                                z21 = z16;
                                i21 = 8;
                                z22 = false;
                                i16 = 8;
                                z20 = false;
                            }
                            SolverVariable solverVariable28 = solverVariable6;
                            constraintWidget = constraintWidget6;
                            constraintWidget2 = constraintWidget7;
                            constraintWidget3 = parent;
                            i18 = 8;
                            SolverVariable solverVariable29 = solverVariable3;
                            linearSystem2.addCentering(solverVariable28, solverVariable8, constraintAnchor.getMargin(), f, solverVariable7, solverVariable29, constraintAnchor2.getMargin(), i21);
                            SolverVariable solverVariable30 = solverVariable7;
                            solverVariable11 = solverVariable28;
                            solverVariable10 = solverVariable30;
                            solverVariable3 = solverVariable29;
                        } else {
                            SolverVariable solverVariable31 = solverVariable6;
                            constraintWidget = constraintWidget6;
                            solverVariable10 = solverVariable7;
                            solverVariable11 = solverVariable31;
                            constraintWidget2 = constraintWidget7;
                            constraintWidget3 = parent;
                            z21 = z16;
                            i18 = 8;
                            z22 = z2;
                        }
                        if (this.mVisibility == i18 && !constraintAnchor2.hasDependents()) {
                            return;
                        }
                        if (z17) {
                            int i35 = (!z22 || solverVariable8 == solverVariable10 || z14 || !((constraintWidget instanceof Barrier) || (constraintWidget2 instanceof Barrier))) ? i16 : 6;
                            linearSystem2.addGreaterThan(solverVariable11, solverVariable8, constraintAnchor.getMargin(), i35);
                            linearSystem2.addLowerThan(solverVariable3, solverVariable10, -constraintAnchor2.getMargin(), i35);
                            i16 = i35;
                        }
                        if (!z22 || !z10 || (constraintWidget instanceof Barrier) || (constraintWidget2 instanceof Barrier) || constraintWidget2 == constraintWidget3) {
                            iMin2 = i17;
                            i19 = i16;
                            z21 = z20;
                        } else {
                            iMin2 = 6;
                            i19 = 6;
                        }
                        if (z21) {
                            if (z19 && (!z9 || z3)) {
                                if (constraintWidget != constraintWidget3 && constraintWidget2 != constraintWidget3) {
                                    i34 = iMin2;
                                }
                                if ((constraintWidget instanceof Guideline) || (constraintWidget2 instanceof Guideline)) {
                                    i34 = 5;
                                }
                                if ((constraintWidget instanceof Barrier) || (constraintWidget2 instanceof Barrier)) {
                                    i34 = 5;
                                }
                                iMin2 = Math.max(z9 ? 5 : i34, iMin2);
                            }
                            if (z22) {
                                iMin2 = Math.min(i19, iMin2);
                                if (z6 && !z9 && (constraintWidget == constraintWidget3 || constraintWidget2 == constraintWidget3)) {
                                    iMin2 = 4;
                                }
                            }
                            linearSystem2.addEquality(solverVariable11, solverVariable8, constraintAnchor.getMargin(), iMin2);
                            linearSystem2.addEquality(solverVariable3, solverVariable10, -constraintAnchor2.getMargin(), iMin2);
                        }
                        if (z22) {
                            int margin2 = solverVariable == solverVariable8 ? constraintAnchor.getMargin() : 0;
                            if (solverVariable8 != solverVariable) {
                                linearSystem2.addGreaterThan(solverVariable11, solverVariable, margin2, 5);
                            }
                        }
                        if (!z22 || !z14 || i3 != 0 || i12 != 0) {
                            i20 = 5;
                            i26 = i20;
                        } else if (z14 && i28 == 3) {
                            linearSystem2.addGreaterThan(solverVariable3, solverVariable11, 0, i18);
                            i20 = 5;
                            i26 = i20;
                        } else {
                            i20 = 5;
                            linearSystem2.addGreaterThan(solverVariable3, solverVariable11, 0, 5);
                            i26 = i20;
                        }
                    }
                    solverVariable10 = solverVariable4;
                    i20 = 5;
                    z22 = z2;
                    i26 = i20;
                } else {
                    i26 = (z2 && (constraintAnchor.mTarget.mOwner instanceof Barrier)) ? 8 : 5;
                    z22 = z2;
                    solverVariable10 = solverVariable4;
                }
                if (z22 && z15) {
                    int margin3 = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                    if (solverVariable10 != solverVariable2) {
                        if (!this.mOptimizeWrapO || !solverVariable3.isFinalValue || (constraintWidget5 = this.mParent) == null) {
                            linearSystem2.addGreaterThan(solverVariable2, solverVariable3, margin3, i26);
                            return;
                        }
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget5;
                        if (z) {
                            constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor2);
                            return;
                        } else {
                            constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor2);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            solverVariable5 = solverVariable2;
            c2 = 2;
            i14 = 8;
            c = 1;
        }
        if (i11 < c2 && z2 && z15) {
            linearSystem2.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, i14);
            char c3 = (z || this.mBaseline.mTarget == null) ? c : (char) 0;
            if (!z && (constraintAnchor3 = this.mBaseline.mTarget) != null) {
                ConstraintWidget constraintWidget8 = constraintAnchor3.mOwner;
                if (constraintWidget8.mDimensionRatio != 0.0f) {
                    DimensionBehaviour[] dimensionBehaviourArr = constraintWidget8.mListDimensionBehaviors;
                    DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                    DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                    c3 = (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[c] == dimensionBehaviour3) ? c : (char) 0;
                }
            }
            if (c3 != 0) {
                linearSystem2.addGreaterThan(solverVariable5, solverVariable3, 0, i14);
            }
        }
    }

    private boolean isChainHead(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return (constraintAnchor4 == null || constraintAnchor4.mTarget == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i2 + 1]).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) ? false : true;
    }

    private void serializeAttribute(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    private void serializeDimensionRatio(StringBuilder sb, String str, float f, int i) {
        if (f == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f);
        sb.append(",");
        sb.append(i);
        sb.append("");
        sb.append("],\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x056b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z4;
        boolean z5;
        int i;
        SolverVariable solverVariable;
        int i2;
        int i3;
        boolean z6;
        int i4;
        DimensionBehaviour dimensionBehaviour;
        SolverVariable solverVariable2;
        boolean z7;
        DimensionBehaviour dimensionBehaviour2;
        boolean z8;
        DimensionBehaviour dimensionBehaviour3;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i5;
        boolean z9;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        int i6;
        int i7;
        char c;
        int i8;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        LinearSystem linearSystem2;
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int i9;
        int i10;
        boolean zIsInHorizontalChain;
        boolean zIsInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun2;
        LinearSystem linearSystem3 = linearSystem;
        SolverVariable solverVariableCreateObjectVariable = linearSystem3.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem3.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem3.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem3.createObjectVariable(this.mBottom);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem3.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget4 = this.mParent;
        if (constraintWidget4 == null) {
            z2 = false;
            z3 = false;
        } else {
            z3 = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            z2 = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            int i11 = this.mWrapBehaviorInParent;
            if (i11 == 1) {
                z2 = false;
            } else if (i11 == 2) {
                z3 = false;
            } else if (i11 == 3) {
            }
        }
        if (this.mVisibility == 8 && !this.mAnimated && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z10 = this.mResolvedHorizontal;
        if (z10 || this.mResolvedVertical) {
            if (z10) {
                linearSystem3.addEquality(solverVariableCreateObjectVariable, this.mX);
                linearSystem3.addEquality(solverVariableCreateObjectVariable2, this.mX + this.mWidth);
                if (z3 && (constraintWidget2 = this.mParent) != null) {
                    if (this.mOptimizeWrapOnResolved) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addHorizontalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget2.mRight), solverVariableCreateObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.mResolvedVertical) {
                linearSystem3.addEquality(solverVariableCreateObjectVariable3, this.mY);
                linearSystem3.addEquality(solverVariableCreateObjectVariable4, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem3.addEquality(solverVariableCreateObjectVariable5, this.mY + this.mBaselineDistance);
                }
                if (z2 && (constraintWidget = this.mParent) != null) {
                    if (this.mOptimizeWrapOnResolved) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget.mBottom), solverVariableCreateObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.mResolvedHorizontal && this.mResolvedVertical) {
                this.mResolvedHorizontal = false;
                this.mResolvedVertical = false;
                return;
            }
        }
        if (z && (horizontalWidgetRun2 = this.mHorizontalRun) != null && (verticalWidgetRun2 = this.mVerticalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun2.start;
            if (dependencyNode.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun2.start.resolved && verticalWidgetRun2.end.resolved) {
                linearSystem3.addEquality(solverVariableCreateObjectVariable, dependencyNode.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable2, this.mHorizontalRun.end.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable3, this.mVerticalRun.start.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable4, this.mVerticalRun.end.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable5, this.mVerticalRun.baseline.value);
                if (this.mParent != null) {
                    if (z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 8);
                    }
                    if (z2 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 8);
                    }
                }
                this.mResolvedHorizontal = false;
                this.mResolvedVertical = false;
                return;
            }
        }
        if (this.mParent != null) {
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (!zIsInHorizontalChain && z3 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 1);
            }
            if (!zIsInVerticalChain && z2 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 1);
            }
            z4 = zIsInHorizontalChain;
            z5 = zIsInVerticalChain;
        } else {
            z4 = false;
            z5 = false;
        }
        int i12 = this.mWidth;
        int i13 = this.mMinWidth;
        if (i12 >= i13) {
            i13 = i12;
        }
        int i14 = this.mHeight;
        int i15 = this.mMinHeight;
        if (i14 >= i15) {
            i15 = i14;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour5 = DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = dimensionBehaviour4 != dimensionBehaviour5;
        DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
        boolean z12 = dimensionBehaviour6 != dimensionBehaviour5;
        int i16 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i16;
        int i17 = i13;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i18 = this.mMatchConstraintDefaultWidth;
        int i19 = this.mMatchConstraintDefaultHeight;
        if (f > 0.0f) {
            i = i15;
            if (this.mVisibility != 8) {
                i2 = (dimensionBehaviour4 == dimensionBehaviour5 && i18 == 0) ? 3 : i18;
                int i20 = (dimensionBehaviour6 == dimensionBehaviour5 && i19 == 0) ? 3 : i19;
                if (dimensionBehaviour4 == dimensionBehaviour5 && dimensionBehaviour6 == dimensionBehaviour5) {
                    solverVariable = solverVariableCreateObjectVariable2;
                    i10 = 3;
                    if (i2 == 3 && i20 == 3) {
                        setupDimensionRatio(z3, z2, z11, z12);
                    }
                    i3 = i20;
                    z6 = true;
                    int[] iArr = this.mResolvedMatchConstraintDefault;
                    iArr[0] = i2;
                    iArr[1] = i3;
                    this.mResolvedHasRatio = z6;
                    if (z6) {
                        int i21 = this.mResolvedDimensionRatioSide;
                        i4 = -1;
                        boolean z13 = i21 == 0 || i21 == -1;
                        boolean z14 = !z6 && ((i9 = this.mResolvedDimensionRatioSide) == 1 || i9 == i4);
                        DimensionBehaviour dimensionBehaviour7 = this.mListDimensionBehaviors[0];
                        dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                        boolean z15 = dimensionBehaviour7 != dimensionBehaviour && (this instanceof ConstraintWidgetContainer);
                        int i22 = !z15 ? 0 : i17;
                        boolean z16 = !this.mCenter.isConnected();
                        boolean[] zArr2 = this.mIsInBarrier;
                        boolean z17 = zArr2[0];
                        boolean z18 = zArr2[1];
                        if (this.mHorizontalResolution != 2 || this.mResolvedHorizontal) {
                            solverVariable2 = solverVariableCreateObjectVariable;
                            z7 = z6;
                            dimensionBehaviour2 = dimensionBehaviour;
                            z8 = z2;
                            i5 = i2;
                            z9 = z3;
                            dimensionBehaviour3 = dimensionBehaviour5;
                            solverVariable5 = solverVariableCreateObjectVariable3;
                            solverVariable4 = solverVariableCreateObjectVariable4;
                            solverVariable3 = solverVariableCreateObjectVariable5;
                        } else {
                            if (z && (horizontalWidgetRun = this.mHorizontalRun) != null) {
                                DependencyNode dependencyNode2 = horizontalWidgetRun.start;
                                if (dependencyNode2.resolved && horizontalWidgetRun.end.resolved) {
                                    if (z) {
                                        linearSystem3.addEquality(solverVariableCreateObjectVariable, dependencyNode2.value);
                                        SolverVariable solverVariable11 = solverVariable;
                                        linearSystem3.addEquality(solverVariable11, this.mHorizontalRun.end.value);
                                        if (this.mParent != null && z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                            linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariable11, 0, 8);
                                        }
                                        solverVariable2 = solverVariableCreateObjectVariable;
                                        z7 = z6;
                                        dimensionBehaviour2 = dimensionBehaviour;
                                        z8 = z2;
                                        solverVariable = solverVariable11;
                                    }
                                    i5 = i2;
                                    z9 = z3;
                                    dimensionBehaviour3 = dimensionBehaviour5;
                                    solverVariable5 = solverVariableCreateObjectVariable3;
                                    solverVariable4 = solverVariableCreateObjectVariable4;
                                    solverVariable3 = solverVariableCreateObjectVariable5;
                                }
                            }
                            SolverVariable solverVariable12 = solverVariable;
                            ConstraintWidget constraintWidget5 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable6 = constraintWidget5 != null ? linearSystem3.createObjectVariable(constraintWidget5.mRight) : null;
                            ConstraintWidget constraintWidget6 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable7 = constraintWidget6 != null ? linearSystem3.createObjectVariable(constraintWidget6.mLeft) : null;
                            boolean z19 = this.isTerminalWidget[0];
                            DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                            solverVariable = solverVariable12;
                            DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr2[0];
                            ConstraintAnchor constraintAnchor = this.mLeft;
                            SolverVariable solverVariable13 = solverVariableCreateObjectVariable7;
                            ConstraintAnchor constraintAnchor2 = this.mRight;
                            z7 = z6;
                            z9 = z3;
                            int i23 = this.mX;
                            int i24 = this.mMinWidth;
                            int i25 = this.mMaxDimension[0];
                            float f2 = this.mHorizontalBiasPercent;
                            boolean z20 = dimensionBehaviourArr2[1] == dimensionBehaviour5;
                            solverVariable2 = solverVariableCreateObjectVariable;
                            boolean z21 = z2;
                            SolverVariable solverVariable14 = solverVariableCreateObjectVariable6;
                            z8 = z21;
                            i5 = i2;
                            dimensionBehaviour3 = dimensionBehaviour5;
                            solverVariable5 = solverVariableCreateObjectVariable3;
                            solverVariable4 = solverVariableCreateObjectVariable4;
                            solverVariable3 = solverVariableCreateObjectVariable5;
                            dimensionBehaviour2 = dimensionBehaviour;
                            linearSystem3 = linearSystem;
                            applyConstraints(linearSystem3, true, z9, z8, z19, solverVariable13, solverVariable14, dimensionBehaviour8, z15, constraintAnchor, constraintAnchor2, i23, i22, i24, i25, f2, z13, z20, z4, z5, z17, i5, i3, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z16);
                        }
                        if (z || (verticalWidgetRun = this.mVerticalRun) == null) {
                            solverVariable6 = solverVariable5;
                            solverVariable7 = solverVariable4;
                            solverVariable8 = solverVariable3;
                            i6 = 0;
                            i7 = 8;
                            c = 1;
                            i8 = 1;
                        } else {
                            DependencyNode dependencyNode3 = verticalWidgetRun.start;
                            if (dependencyNode3.resolved && verticalWidgetRun.end.resolved) {
                                int i26 = dependencyNode3.value;
                                solverVariable6 = solverVariable5;
                                linearSystem3.addEquality(solverVariable6, i26);
                                solverVariable7 = solverVariable4;
                                linearSystem3.addEquality(solverVariable7, this.mVerticalRun.end.value);
                                solverVariable8 = solverVariable3;
                                linearSystem3.addEquality(solverVariable8, this.mVerticalRun.baseline.value);
                                ConstraintWidget constraintWidget7 = this.mParent;
                                if (constraintWidget7 == null || z5 || !z8) {
                                    i6 = 0;
                                    i7 = 8;
                                    c = 1;
                                } else {
                                    c = 1;
                                    if (this.isTerminalWidget[1]) {
                                        i6 = 0;
                                        i7 = 8;
                                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget7.mBottom), solverVariable7, 0, 8);
                                    } else {
                                        i6 = 0;
                                        i7 = 8;
                                    }
                                }
                                i8 = i6;
                            }
                        }
                        if ((this.mVerticalResolution != 2 ? i6 : i8) != 0 || this.mResolvedVertical) {
                            constraintWidget3 = this;
                            solverVariable9 = solverVariable6;
                            solverVariable10 = solverVariable7;
                        } else {
                            boolean z22 = (this.mListDimensionBehaviors[c] == dimensionBehaviour2 && (this instanceof ConstraintWidgetContainer)) ? c : i6;
                            int i27 = z22 != 0 ? i6 : i;
                            ConstraintWidget constraintWidget8 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable8 = constraintWidget8 != null ? linearSystem3.createObjectVariable(constraintWidget8.mBottom) : null;
                            ConstraintWidget constraintWidget9 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable9 = constraintWidget9 != null ? linearSystem3.createObjectVariable(constraintWidget9.mTop) : null;
                            if (this.mBaselineDistance <= 0) {
                                boolean z23 = z16;
                                if (this.mVisibility == i7) {
                                    ConstraintAnchor constraintAnchor3 = this.mBaseline;
                                    if (constraintAnchor3.mTarget != null) {
                                        linearSystem3.addEquality(solverVariable8, solverVariable6, getBaselineDistance(), i7);
                                        linearSystem3.addEquality(solverVariable8, linearSystem3.createObjectVariable(this.mBaseline.mTarget), this.mBaseline.getMargin(), i7);
                                        if (z8) {
                                            linearSystem3.addGreaterThan(solverVariableCreateObjectVariable8, linearSystem3.createObjectVariable(this.mBottom), i6, 5);
                                        }
                                        z23 = i6;
                                    } else if (this.mVisibility == i7) {
                                        linearSystem3.addEquality(solverVariable8, solverVariable6, constraintAnchor3.getMargin(), i7);
                                        z23 = z16;
                                    } else {
                                        linearSystem3.addEquality(solverVariable8, solverVariable6, getBaselineDistance(), i7);
                                        z23 = z16;
                                    }
                                }
                                boolean z24 = this.isTerminalWidget[c];
                                DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                                int i28 = i6;
                                solverVariable9 = solverVariable6;
                                solverVariable10 = solverVariable7;
                                applyConstraints(linearSystem, false, z8, z9, z24, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr3[c], z22, this.mTop, this.mBottom, this.mY, i27, this.mMinHeight, this.mMaxDimension[c], this.mVerticalBiasPercent, z14, dimensionBehaviourArr3[i28] == dimensionBehaviour3 ? c : i28, z5, z4, z18, i3, i5, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z23);
                                constraintWidget3 = this;
                            }
                        }
                        if (z7) {
                            linearSystem2 = linearSystem;
                        } else {
                            int i29 = constraintWidget3.mResolvedDimensionRatioSide;
                            float f3 = constraintWidget3.mResolvedDimensionRatio;
                            if (i29 == 1) {
                                linearSystem.addRatio(solverVariable10, solverVariable9, solverVariable, solverVariable2, f3, 8);
                                linearSystem2 = linearSystem;
                            } else {
                                linearSystem.addRatio(solverVariable, solverVariable2, solverVariable10, solverVariable9, f3, 8);
                                linearSystem2 = linearSystem;
                            }
                        }
                        if (constraintWidget3.mCenter.isConnected()) {
                            linearSystem2.addCenterPoint(constraintWidget3, constraintWidget3.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget3.mCircleConstraintAngle + 90.0f), constraintWidget3.mCenter.getMargin());
                        }
                        constraintWidget3.mResolvedHorizontal = false;
                        constraintWidget3.mResolvedVertical = false;
                    }
                    i4 = -1;
                    if (z6) {
                    }
                    DimensionBehaviour dimensionBehaviour72 = this.mListDimensionBehaviors[0];
                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour72 != dimensionBehaviour) {
                    }
                    if (!z15) {
                    }
                    boolean z162 = !this.mCenter.isConnected();
                    boolean[] zArr22 = this.mIsInBarrier;
                    boolean z172 = zArr22[0];
                    boolean z182 = zArr22[1];
                    if (this.mHorizontalResolution != 2) {
                        solverVariable2 = solverVariableCreateObjectVariable;
                        z7 = z6;
                        dimensionBehaviour2 = dimensionBehaviour;
                        z8 = z2;
                        i5 = i2;
                        z9 = z3;
                        dimensionBehaviour3 = dimensionBehaviour5;
                        solverVariable5 = solverVariableCreateObjectVariable3;
                        solverVariable4 = solverVariableCreateObjectVariable4;
                        solverVariable3 = solverVariableCreateObjectVariable5;
                    }
                    if (z) {
                        solverVariable6 = solverVariable5;
                        solverVariable7 = solverVariable4;
                        solverVariable8 = solverVariable3;
                        i6 = 0;
                        i7 = 8;
                        c = 1;
                        i8 = 1;
                    }
                    if ((this.mVerticalResolution != 2 ? i6 : i8) != 0) {
                        constraintWidget3 = this;
                        solverVariable9 = solverVariable6;
                        solverVariable10 = solverVariable7;
                    }
                    if (z7) {
                    }
                    if (constraintWidget3.mCenter.isConnected()) {
                    }
                    constraintWidget3.mResolvedHorizontal = false;
                    constraintWidget3.mResolvedVertical = false;
                }
                solverVariable = solverVariableCreateObjectVariable2;
                i10 = 3;
                if (dimensionBehaviour4 != dimensionBehaviour5 || i2 != i10) {
                    if (dimensionBehaviour6 == dimensionBehaviour5 && i20 == i10) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (i16 == -1) {
                            this.mResolvedDimensionRatio = 1.0f / f;
                        }
                        i = (int) (this.mResolvedDimensionRatio * i12);
                        if (dimensionBehaviour4 != dimensionBehaviour5) {
                            i3 = 4;
                        }
                    }
                    i3 = i20;
                    z6 = true;
                    int[] iArr2 = this.mResolvedMatchConstraintDefault;
                    iArr2[0] = i2;
                    iArr2[1] = i3;
                    this.mResolvedHasRatio = z6;
                    if (z6) {
                    }
                    if (z6) {
                    }
                    DimensionBehaviour dimensionBehaviour722 = this.mListDimensionBehaviors[0];
                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour722 != dimensionBehaviour) {
                    }
                    if (!z15) {
                    }
                    boolean z1622 = !this.mCenter.isConnected();
                    boolean[] zArr222 = this.mIsInBarrier;
                    boolean z1722 = zArr222[0];
                    boolean z1822 = zArr222[1];
                    if (this.mHorizontalResolution != 2) {
                    }
                    if (z) {
                    }
                    if ((this.mVerticalResolution != 2 ? i6 : i8) != 0) {
                    }
                    if (z7) {
                    }
                    if (constraintWidget3.mCenter.isConnected()) {
                    }
                    constraintWidget3.mResolvedHorizontal = false;
                    constraintWidget3.mResolvedVertical = false;
                }
                this.mResolvedDimensionRatioSide = 0;
                i17 = (int) (i14 * f);
                if (dimensionBehaviour6 == dimensionBehaviour5) {
                    i3 = i20;
                    z6 = true;
                    int[] iArr22 = this.mResolvedMatchConstraintDefault;
                    iArr22[0] = i2;
                    iArr22[1] = i3;
                    this.mResolvedHasRatio = z6;
                    if (z6) {
                    }
                    if (z6) {
                    }
                    DimensionBehaviour dimensionBehaviour7222 = this.mListDimensionBehaviors[0];
                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour7222 != dimensionBehaviour) {
                    }
                    if (!z15) {
                    }
                    boolean z16222 = !this.mCenter.isConnected();
                    boolean[] zArr2222 = this.mIsInBarrier;
                    boolean z17222 = zArr2222[0];
                    boolean z18222 = zArr2222[1];
                    if (this.mHorizontalResolution != 2) {
                    }
                    if (z) {
                    }
                    if ((this.mVerticalResolution != 2 ? i6 : i8) != 0) {
                    }
                    if (z7) {
                    }
                    if (constraintWidget3.mCenter.isConnected()) {
                    }
                    constraintWidget3.mResolvedHorizontal = false;
                    constraintWidget3.mResolvedVertical = false;
                }
                i2 = 4;
                i3 = i20;
            }
            z6 = false;
            int[] iArr222 = this.mResolvedMatchConstraintDefault;
            iArr222[0] = i2;
            iArr222[1] = i3;
            this.mResolvedHasRatio = z6;
            if (z6) {
            }
            if (z6) {
            }
            DimensionBehaviour dimensionBehaviour72222 = this.mListDimensionBehaviors[0];
            dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour72222 != dimensionBehaviour) {
            }
            if (!z15) {
            }
            boolean z162222 = !this.mCenter.isConnected();
            boolean[] zArr22222 = this.mIsInBarrier;
            boolean z172222 = zArr22222[0];
            boolean z182222 = zArr22222[1];
            if (this.mHorizontalResolution != 2) {
            }
            if (z) {
            }
            if ((this.mVerticalResolution != 2 ? i6 : i8) != 0) {
            }
            if (z7) {
            }
            if (constraintWidget3.mCenter.isConnected()) {
            }
            constraintWidget3.mResolvedHorizontal = false;
            constraintWidget3.mResolvedVertical = false;
        }
        i = i15;
        solverVariable = solverVariableCreateObjectVariable2;
        i2 = i18;
        i3 = i19;
        z6 = false;
        int[] iArr2222 = this.mResolvedMatchConstraintDefault;
        iArr2222[0] = i2;
        iArr2222[1] = i3;
        this.mResolvedHasRatio = z6;
        if (z6) {
        }
        if (z6) {
        }
        DimensionBehaviour dimensionBehaviour722222 = this.mListDimensionBehaviors[0];
        dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour722222 != dimensionBehaviour) {
        }
        if (!z15) {
        }
        boolean z1622222 = !this.mCenter.isConnected();
        boolean[] zArr222222 = this.mIsInBarrier;
        boolean z1722222 = zArr222222[0];
        boolean z1822222 = zArr222222[1];
        if (this.mHorizontalResolution != 2) {
        }
        if (z) {
        }
        if ((this.mVerticalResolution != 2 ? i6 : i8) != 0) {
        }
        if (z7) {
        }
        if (constraintWidget3.mCenter.isConnected()) {
        }
        constraintWidget3.mResolvedHorizontal = false;
        constraintWidget3.mResolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == ConstraintAnchor.Type.RIGHT) {
                    connect(type6, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type7, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor anchor = getAnchor(type8);
            ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor anchor2 = getAnchor(type9);
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor anchor3 = getAnchor(type10);
            ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor anchor4 = getAnchor(type11);
            boolean z2 = true;
            if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                connect(type8, constraintWidget, type8, 0);
                connect(type9, constraintWidget, type9, 0);
                z = true;
            } else {
                z = false;
            }
            if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                connect(type10, constraintWidget, type10, 0);
                connect(type11, constraintWidget, type11, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                return;
            }
            if (z) {
                ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_X;
                getAnchor(type12).connect(constraintWidget.getAnchor(type12), 0);
                return;
            } else {
                if (z2) {
                    ConstraintAnchor.Type type13 = ConstraintAnchor.Type.CENTER_Y;
                    getAnchor(type13).connect(constraintWidget.getAnchor(type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(type4);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type14).connect(anchor6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(type15).connect(anchor8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            getAnchor(type16).connect(constraintWidget.getAnchor(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            getAnchor(type14).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor anchor13 = getAnchor(type20);
                if (anchor13 != null) {
                    anchor13.reset();
                }
                ConstraintAnchor anchor14 = getAnchor(type5);
                if (anchor14.getTarget() != anchor10) {
                    anchor14.reset();
                }
                ConstraintAnchor opposite = getAnchor(type).getOpposite();
                ConstraintAnchor anchor15 = getAnchor(type15);
                if (anchor15.isConnected()) {
                    opposite.reset();
                    anchor15.reset();
                }
            } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor anchor16 = getAnchor(type5);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(type14);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureWidgetRuns() {
        if (this.mHorizontalRun == null) {
            this.mHorizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.mVerticalRun == null) {
            this.mVerticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$1((Object) type.name());
            case 9:
                return null;
        }
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = constraintAnchor != null ? constraintAnchor.mMargin : 0;
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.mHorizontalRun;
        }
        if (i == 1) {
            return this.mVerticalRun;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb) {
        sb.append("  " + this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.mWidth);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.mHeight);
        sb.append("\n");
        sb.append("    actualLeft:" + this.mX);
        sb.append("\n");
        sb.append("    actualTop:" + this.mY);
        sb.append("\n");
        getSceneString(sb, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.mLeft);
        getSceneString(sb, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.mTop);
        getSceneString(sb, "right", this.mRight);
        getSceneString(sb, "bottom", this.mBottom);
        getSceneString(sb, "baseline", this.mBaseline);
        getSceneString(sb, "centerX", this.mCenterX);
        getSceneString(sb, "centerY", this.mCenterY);
        getSceneString(sb, "    width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mListDimensionBehaviors[0], this.mWeight[0]);
        getSceneString(sb, "    height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mListDimensionBehaviors[1], this.mWeight[1]);
        serializeDimensionRatio(sb, "    dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb, "    horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "    verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "    horizontalChainStyle", this.mHorizontalChainStyle, 0);
        serializeAttribute(sb, "    verticalChainStyle", this.mVerticalChainStyle, 0);
        sb.append("  }");
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i = this.mLeft != null ? this.mTop.mMargin : 0;
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mX : ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mY : ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.mHasBaseline;
    }

    public boolean hasDanglingDimension(int i) {
        if (i == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            if (this.mAnchors.get(i).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        return (this.mWidthOverride == -1 && this.mHeightOverride == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i, int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 != null && constraintAnchor3.hasFinalValue() && (constraintAnchor2 = this.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) {
                return (this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.getMargin() + this.mLeft.mTarget.getFinalValue()) >= i2;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.hasFinalValue() && (constraintAnchor = this.mBottom.mTarget) != null && constraintAnchor.hasFinalValue()) {
                if ((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.getMargin() + this.mTop.mTarget.getFinalValue()) >= i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.mHorizontalSolvingPass;
    }

    public boolean isInBarrier(int i) {
        return this.mIsInBarrier[i];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.mInPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        if (this.mResolvedHorizontal) {
            return true;
        }
        return this.mLeft.hasFinalValue() && this.mRight.hasFinalValue();
    }

    public boolean isResolvedVertically() {
        if (this.mResolvedVertical) {
            return true;
        }
        return this.mTop.hasFinalValue() && this.mBottom.hasFinalValue();
    }

    public boolean isVerticalSolvingPassDone() {
        return this.mVerticalSolvingPass;
    }

    public void markHorizontalSolvingPassDone() {
        this.mHorizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.mVerticalSolvingPass = true;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = Float.NaN;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetFinalResolution() {
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.mHasBaseline = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDimensionRatio(String str) {
        float fAbs;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i2 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            i2 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            i = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
            String strSubstring2 = str.substring(i);
            fAbs = strSubstring2.length() > 0 ? Float.parseFloat(strSubstring2) : i;
        } else {
            String strSubstring3 = str.substring(i, iIndexOf2);
            String strSubstring4 = str.substring(iIndexOf2 + 1);
            if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                float f = Float.parseFloat(strSubstring3);
                float f2 = Float.parseFloat(strSubstring4);
                if (f > 0.0f && f2 > 0.0f) {
                    fAbs = i2 == 1 ? Math.abs(f2 / f) : Math.abs(f / f2);
                }
            }
        }
        i = (fAbs > i ? 1 : (fAbs == i ? 0 : -1));
        if (i > 0) {
            this.mDimensionRatio = fAbs;
            this.mDimensionRatioSide = i2;
        }
    }

    public void setFinalBaseline(int i) {
        if (this.mHasBaseline) {
            int i2 = i - this.mBaselineDistance;
            int i3 = this.mHeight + i2;
            this.mY = i2;
            this.mTop.setFinalValue(i2);
            this.mBottom.setFinalValue(i3);
            this.mBaseline.setFinalValue(i);
            this.mResolvedVertical = true;
        }
    }

    public void setFinalHorizontal(int i, int i2) {
        if (this.mResolvedHorizontal) {
            return;
        }
        this.mLeft.setFinalValue(i);
        this.mRight.setFinalValue(i2);
        this.mX = i;
        this.mWidth = i2 - i;
        this.mResolvedHorizontal = true;
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.mX = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.mY = i;
    }

    public void setFinalVertical(int i, int i2) {
        if (this.mResolvedVertical) {
            return;
        }
        this.mTop.setFinalValue(i);
        this.mBottom.setFinalValue(i2);
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.mHasBaseline) {
            this.mBaseline.setFinalValue(i + this.mBaselineDistance);
        }
        this.mResolvedVertical = true;
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.mWidth = i10;
        }
        int i11 = this.mMatchConstraintMaxWidth;
        if (i11 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mWidth = Math.min(this.mWidth, i11);
        }
        int i12 = this.mMatchConstraintMaxHeight;
        if (i12 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mHeight = Math.min(this.mHeight, i12);
        }
        int i13 = this.mWidth;
        if (i7 != i13) {
            this.mWidthOverride = i13;
        }
        int i14 = this.mHeight;
        if (i8 != i14) {
            this.mHeightOverride = i14;
        }
    }

    public void setHasBaseline(boolean z) {
        this.mHasBaseline = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void setInPlaceholder(boolean z) {
        this.mInPlaceholder = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtualLayout = z;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.mLastHorizontalMeasureSpec = i;
        this.mLastVerticalMeasureSpec = i2;
        setMeasureRequested(false);
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMeasureRequested(boolean z) {
        this.mMeasureRequested = z;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setWrapBehaviorInParent(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mWrapBehaviorInParent = i;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else {
                if (i != 0 || this.mMatchConstraintMinHeight <= 0) {
                    return;
                }
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mType != null ? FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("type: "), this.mType, " ") : "");
        sb.append(this.mDebugName != null ? FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("id: "), this.mDebugName, " ") : "");
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        return FileInsert$$ExternalSyntheticOutline0.m(this.mHeight, ")", sb);
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean zIsResolved = z & this.mHorizontalRun.isResolved();
        boolean zIsResolved2 = z2 & this.mVerticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.mHorizontalRun;
        int i3 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.mVerticalRun;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (zIsResolved) {
            this.mX = i3;
        }
        if (zIsResolved2) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (zIsResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (zIsResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.mHorizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z && (verticalWidgetRun = this.mVerticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    private void serializeAttribute(StringBuilder sb, String str, int i, int i2) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    private void serializeAttribute(StringBuilder sb, String str, String str2, String str3) {
        if (str3.equals(str2)) {
            return;
        }
        FileInsert$$ExternalSyntheticOutline0.m(sb, str, " :   ", str2, ",\n");
    }

    private void getSceneString(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, int i6, float f, DimensionBehaviour dimensionBehaviour, float f2) {
        sb.append(str);
        sb.append(" :  {\n");
        serializeAttribute(sb, "      behavior", dimensionBehaviour.toString(), DimensionBehaviour.FIXED.toString());
        serializeAttribute(sb, "      size", i, 0);
        serializeAttribute(sb, "      min", i2, 0);
        serializeAttribute(sb, "      max", i3, Integer.MAX_VALUE);
        serializeAttribute(sb, "      matchMin", i5, 0);
        serializeAttribute(sb, "      matchDef", i6, 0);
        serializeAttribute(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    private void getSceneString(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        Fragment$$ExternalSyntheticOutline1.m67m(sb, "    ", str, " : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("'");
        if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE || constraintAnchor.mMargin != 0) {
            sb.append(",");
            sb.append(constraintAnchor.mMargin);
            if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.mGoneMargin);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }
}
