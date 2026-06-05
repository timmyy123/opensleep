package com.tbuonomo.viewpagerdotsindicator;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0007H\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/DotsIndicator;", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "dotsElevation", "", "dotsWidthFactor", "linearLayout", "Landroid/widget/LinearLayout;", "progressMode", "", SDKConstants.PARAM_VALUE, "selectedDotColor", "getSelectedDotColor", "()I", "setSelectedDotColor", "(I)V", "type", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "getType", "()Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "addDot", "", "index", "buildOnPageChangedListener", "Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "init", "refreshDotColor", "removeDot", "setSelectedPointColor", "color", "Companion", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DotsIndicator extends BaseDotsIndicator {
    private final ArgbEvaluator argbEvaluator;
    private float dotsElevation;
    private float dotsWidthFactor;
    private LinearLayout linearLayout;
    private boolean progressMode;
    private int selectedDotColor;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotsIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.argbEvaluator = new ArgbEvaluator();
        init(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addDot$lambda$0(DotsIndicator dotsIndicator, int i, View view) {
        dotsIndicator.getClass();
        if (dotsIndicator.getDotsClickable()) {
            BaseDotsIndicator.Pager pager = dotsIndicator.getPager();
            if (i < (pager != null ? pager.getCount() : 0)) {
                BaseDotsIndicator.Pager pager2 = dotsIndicator.getPager();
                pager2.getClass();
                pager2.setCurrentItem(i, true);
            }
        }
    }

    private final void init(AttributeSet attrs) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout linearLayout2 = this.linearLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
            linearLayout2 = null;
        }
        addView(linearLayout2, -2, -2);
        this.dotsWidthFactor = 2.5f;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$styleable.DotsIndicator);
            typedArrayObtainStyledAttributes.getClass();
            setSelectedDotColor(typedArrayObtainStyledAttributes.getColor(R$styleable.DotsIndicator_selectedDotColor, Color.CYAN));
            float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.DotsIndicator_dotsWidthFactor, 2.5f);
            this.dotsWidthFactor = f;
            if (f < 1.0f) {
                Log.w("DotsIndicator", "The dotsWidthFactor can't be set under 1.0f, please set an higher value");
                this.dotsWidthFactor = 1.0f;
            }
            this.progressMode = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DotsIndicator_progressMode, false);
            this.dotsElevation = typedArrayObtainStyledAttributes.getDimension(R$styleable.DotsIndicator_dotsElevation, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (isInEditMode()) {
            addDots(5);
            refreshDots();
        }
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void addDot(int index) {
        int i = 0;
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dot_layout, (ViewGroup) this, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.dot);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.getClass();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        viewInflate.setLayoutDirection(0);
        int dotsSize = (int) getDotsSize();
        layoutParams2.height = dotsSize;
        layoutParams2.width = dotsSize;
        layoutParams2.setMargins((int) getDotsSpacing(), 0, (int) getDotsSpacing(), 0);
        DotsGradientDrawable dotsGradientDrawable = new DotsGradientDrawable();
        dotsGradientDrawable.setCornerRadius(getDotsCornerRadius());
        if (isInEditMode()) {
            dotsGradientDrawable.setColor(index == 0 ? this.selectedDotColor : getDotsColor());
        } else {
            BaseDotsIndicator.Pager pager = getPager();
            pager.getClass();
            dotsGradientDrawable.setColor(pager.getCurrentItem() == index ? this.selectedDotColor : getDotsColor());
        }
        ExtensionsKt.setBackgroundCompat(imageView, dotsGradientDrawable);
        viewInflate.setOnClickListener(new DotsIndicator$$ExternalSyntheticLambda0(this, index, i));
        ExtensionsKt.setPaddingHorizontal(viewInflate, (int) (this.dotsElevation * 0.8f));
        ExtensionsKt.setPaddingVertical(viewInflate, (int) (this.dotsElevation * 2.0f));
        imageView.setElevation(this.dotsElevation);
        this.dots.add(imageView);
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
            linearLayout = null;
        }
        linearLayout.addView(viewInflate);
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public OnPageChangeListenerHelper buildOnPageChangedListener() {
        return new OnPageChangeListenerHelper() { // from class: com.tbuonomo.viewpagerdotsindicator.DotsIndicator.buildOnPageChangedListener.1
            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public int getPageCount$viewpagerdotsindicator_release() {
                return DotsIndicator.this.dots.size();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x00ee  */
            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onPageScrolled$viewpagerdotsindicator_release(int selectedPosition, int nextPosition, float positionOffset) {
                ImageView imageView = DotsIndicator.this.dots.get(selectedPosition);
                imageView.getClass();
                ImageView imageView2 = imageView;
                ExtensionsKt.setWidth(imageView2, (int) FileInsert$$ExternalSyntheticOutline0.m(1.0f, positionOffset, (DotsIndicator.this.dotsWidthFactor - 1.0f) * DotsIndicator.this.getDotsSize(), DotsIndicator.this.getDotsSize()));
                if (ExtensionsKt.isInBounds(DotsIndicator.this.dots, nextPosition)) {
                    ImageView imageView3 = DotsIndicator.this.dots.get(nextPosition);
                    imageView3.getClass();
                    ImageView imageView4 = imageView3;
                    ExtensionsKt.setWidth(imageView4, (int) (((DotsIndicator.this.dotsWidthFactor - 1.0f) * DotsIndicator.this.getDotsSize() * positionOffset) + DotsIndicator.this.getDotsSize()));
                    Drawable background = imageView2.getBackground();
                    background.getClass();
                    DotsGradientDrawable dotsGradientDrawable = (DotsGradientDrawable) background;
                    Drawable background2 = imageView4.getBackground();
                    background2.getClass();
                    DotsGradientDrawable dotsGradientDrawable2 = (DotsGradientDrawable) background2;
                    if (DotsIndicator.this.getSelectedDotColor() != DotsIndicator.this.getDotsColor()) {
                        Object objEvaluate = DotsIndicator.this.argbEvaluator.evaluate(positionOffset, Integer.valueOf(DotsIndicator.this.getSelectedDotColor()), Integer.valueOf(DotsIndicator.this.getDotsColor()));
                        objEvaluate.getClass();
                        int iIntValue = ((Integer) objEvaluate).intValue();
                        Object objEvaluate2 = DotsIndicator.this.argbEvaluator.evaluate(positionOffset, Integer.valueOf(DotsIndicator.this.getDotsColor()), Integer.valueOf(DotsIndicator.this.getSelectedDotColor()));
                        objEvaluate2.getClass();
                        dotsGradientDrawable2.setColor(((Integer) objEvaluate2).intValue());
                        if (DotsIndicator.this.progressMode) {
                            BaseDotsIndicator.Pager pager = DotsIndicator.this.getPager();
                            pager.getClass();
                            if (selectedPosition <= pager.getCurrentItem()) {
                                dotsGradientDrawable.setColor(DotsIndicator.this.getSelectedDotColor());
                            } else {
                                dotsGradientDrawable.setColor(iIntValue);
                            }
                        }
                    }
                }
                DotsIndicator.this.invalidate();
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public void resetPosition$viewpagerdotsindicator_release(int position) {
                ImageView imageView = DotsIndicator.this.dots.get(position);
                imageView.getClass();
                ExtensionsKt.setWidth(imageView, (int) DotsIndicator.this.getDotsSize());
                DotsIndicator.this.refreshDotColor(position);
            }
        };
    }

    public final int getSelectedDotColor() {
        return this.selectedDotColor;
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public BaseDotsIndicator.Type getType() {
        return BaseDotsIndicator.Type.DEFAULT;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void refreshDotColor(int index) {
        ImageView imageView = this.dots.get(index);
        imageView.getClass();
        ImageView imageView2 = imageView;
        Drawable background = imageView2.getBackground();
        DotsGradientDrawable dotsGradientDrawable = background instanceof DotsGradientDrawable ? (DotsGradientDrawable) background : null;
        if (dotsGradientDrawable != null) {
            BaseDotsIndicator.Pager pager = getPager();
            pager.getClass();
            if (index == pager.getCurrentItem()) {
                dotsGradientDrawable.setColor(this.selectedDotColor);
            } else {
                if (this.progressMode) {
                    BaseDotsIndicator.Pager pager2 = getPager();
                    pager2.getClass();
                    if (index < pager2.getCurrentItem()) {
                    }
                }
                dotsGradientDrawable.setColor(getDotsColor());
            }
        }
        ExtensionsKt.setBackgroundCompat(imageView2, dotsGradientDrawable);
        imageView2.invalidate();
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void removeDot() {
        LinearLayout linearLayout = this.linearLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
            linearLayout = null;
        }
        LinearLayout linearLayout3 = this.linearLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout.removeViewAt(linearLayout2.getChildCount() - 1);
        this.dots.remove(r4.size() - 1);
    }

    public final void setSelectedDotColor(int i) {
        this.selectedDotColor = i;
        refreshDotsColors();
    }

    public final void setSelectedPointColor(int color) {
        setSelectedDotColor(color);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DotsIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    public /* synthetic */ DotsIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DotsIndicator(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }
}
