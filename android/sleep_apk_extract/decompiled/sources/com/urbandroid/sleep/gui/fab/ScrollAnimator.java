package com.urbandroid.sleep.gui.fab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.gui.SquigglyProgress$$ExternalSyntheticLambda0;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u000f\u0018\u0000 D2\u00020\u0001:\u0001DB3\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0011J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u000eJ\u001d\u0010\u0017\u001a\u00020\f2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u0010\u0011R(\u00107\u001a\b\u0012\u0004\u0012\u00020\u0004068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00102R\"\u0010>\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00102\u001a\u0004\b?\u00104\"\u0004\b@\u0010\u0011R\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u00102\u001a\u0004\bB\u00104\"\u0004\bC\u0010\u0011¨\u0006E"}, d2 = {"Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "collapsedDip", "", "hideMode", "<init>", "(Landroid/app/Activity;Landroid/view/View;IZ)V", "", "initAnim", "()V", "position", "scroll", "(I)V", "delta", "scrollDelta", "expand", "Lkotlin/Function0;", "doAfter", "collapse", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Z", "getHideMode", "()Z", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "Landroid/animation/ValueAnimator;", "showAnim", "Landroid/animation/ValueAnimator;", "getShowAnim", "()Landroid/animation/ValueAnimator;", "setShowAnim", "(Landroid/animation/ValueAnimator;)V", "hideAnim", "getHideAnim", "setHideAnim", "hiddenWidth", "I", "getHiddenWidth", "()I", "setHiddenWidth", "", "elevationViews", "Ljava/util/List;", "getElevationViews", "()Ljava/util/List;", "setElevationViews", "(Ljava/util/List;)V", "elevationSize", "viewWidth", "getViewWidth", "setViewWidth", "lastItem", "getLastItem", "setLastItem", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScrollAnimator {
    private final Activity context;
    private int elevationSize;
    private List<View> elevationViews;
    private final Handler handler;
    private int hiddenWidth;
    private ValueAnimator hideAnim;
    private final boolean hideMode;
    private int lastItem;
    private ValueAnimator showAnim;
    private final View view;
    private int viewWidth;

    public ScrollAnimator(Activity activity, View view, int i, boolean z) {
        this.context = activity;
        this.view = view;
        this.hideMode = z;
        this.handler = new Handler();
        this.elevationViews = new ArrayList();
        this.hiddenWidth = ActivityUtils.getDip(activity, i);
        initAnim();
        this.elevationSize = ActivityUtils.getDip(activity, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void collapse$default(ScrollAnimator scrollAnimator, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new HttpClientConfig$$ExternalSyntheticLambda4(4);
        }
        scrollAnimator.collapse(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnim$lambda$0$0(View view, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        view.getLayoutParams().width = ((Integer) animatedValue).intValue();
        view.requestLayout();
    }

    public final void collapse(final Function0<Unit> doAfter) {
        doAfter.getClass();
        View view = this.view;
        if (view == null || view.getTag() != null) {
            return;
        }
        initAnim();
        ValueAnimator valueAnimator = this.hideAnim;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        ValueAnimator valueAnimator2 = this.hideAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(new Animator.AnimatorListener() { // from class: com.urbandroid.sleep.gui.fab.ScrollAnimator$collapse$2$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    animation.getClass();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    animation.getClass();
                    doAfter.invoke();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    animation.getClass();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    animation.getClass();
                }
            });
        }
        view.setTag("hidden");
    }

    public final void expand() {
        View view = this.view;
        if (view == null || !Intrinsics.areEqual(view.getTag(), "hidden")) {
            return;
        }
        ValueAnimator valueAnimator = this.showAnim;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        ValueAnimator valueAnimator2 = this.showAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(new Animator.AnimatorListener() { // from class: com.urbandroid.sleep.gui.fab.ScrollAnimator$expand$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    animation.getClass();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    animation.getClass();
                    this.this$0.getView().getLayoutParams().width = -2;
                    this.this$0.getView().requestLayout();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    animation.getClass();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    animation.getClass();
                }
            });
        }
        view.setTag(null);
    }

    public final View getView() {
        return this.view;
    }

    public final void initAnim() {
        View view = this.view;
        if (view != null) {
            view.getLayoutParams().width = -2;
            view.requestLayout();
            int width = view.getWidth();
            this.viewWidth = width;
            this.showAnim = ValueAnimator.ofInt(this.hiddenWidth, width).setDuration(160L);
            this.hideAnim = ValueAnimator.ofInt(this.view.getWidth(), this.hiddenWidth).setDuration(160L);
            SquigglyProgress$$ExternalSyntheticLambda0 squigglyProgress$$ExternalSyntheticLambda0 = new SquigglyProgress$$ExternalSyntheticLambda0(view, 3);
            ValueAnimator valueAnimator = this.showAnim;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
            }
            ValueAnimator valueAnimator2 = this.hideAnim;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
            }
            ValueAnimator valueAnimator3 = this.showAnim;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(squigglyProgress$$ExternalSyntheticLambda0);
            }
            ValueAnimator valueAnimator4 = this.hideAnim;
            if (valueAnimator4 != null) {
                valueAnimator4.addUpdateListener(squigglyProgress$$ExternalSyntheticLambda0);
            }
        }
    }

    public final void position(int position) {
        for (View view : this.elevationViews) {
            boolean z = this.hideMode;
            if (position <= 0) {
                if (z) {
                    view.setVisibility(0);
                } else {
                    ViewCompat.setElevation(view, 0.0f);
                }
            } else if (z) {
                view.setVisibility(4);
            } else {
                ViewCompat.setElevation(view, this.elevationSize);
            }
        }
    }

    public final void scroll(int position) {
        int i = this.lastItem;
        if (position > i) {
            collapse$default(this, null, 1, null);
        } else if (position < i || position == 0) {
            expand();
        }
        this.lastItem = position;
        position(position);
    }

    public final void scrollDelta(int delta) {
        if (delta > 0) {
            collapse$default(this, null, 1, null);
        } else if (delta <= 0) {
            expand();
        }
    }

    public ScrollAnimator(Activity activity, View view) {
        this(activity, view, 0, false, 12, null);
    }

    public ScrollAnimator(Activity activity) {
        this(activity, null, 0, false, 14, null);
    }

    public /* synthetic */ ScrollAnimator(Activity activity, View view, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i2 & 2) != 0 ? null : view, (i2 & 4) != 0 ? Build.VERSION.SDK_INT >= 31 ? 56 : 54 : i, (i2 & 8) != 0 ? false : z);
    }
}
