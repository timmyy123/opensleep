package com.tbuonomo.viewpagerdotsindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import com.tbuonomo.viewpagerdotsindicator.attacher.ViewPagerAttacher;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 _2\u00020\u0001:\u0003_`aB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0004¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\nH&¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u0014J\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J7\u0010-\u001a\u00020\n2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0014¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010/H\u0014¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\nH\u0002¢\u0006\u0004\b3\u0010\fJ\u0017\u00104\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0014J\u000f\u00105\u001a\u00020\nH\u0002¢\u0006\u0004\b5\u0010\fJ\u000f\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\b6\u0010\fR$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`98\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010<\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010\u0014R\"\u0010H\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010N\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR\"\u0010Q\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bQ\u0010I\u001a\u0004\bR\u0010K\"\u0004\bS\u0010MR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020[8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]¨\u0006b"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "onAttachedToWindow", "()V", "refreshDotsColors", "", "dp", "dpToPxF", "(F)F", "count", "addDots", "(I)V", "refreshDots", "index", "refreshDotColor", "addDot", "removeDot", "Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "buildOnPageChangedListener", "()Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "color", "setPointsColor", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "setViewPager2", "(Landroidx/viewpager2/widget/ViewPager2;)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/os/Parcelable;", ServerProtocol.DIALOG_PARAM_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "refreshDotsCount", "removeDots", "refreshOnPageChangedListener", "refreshDotsSize", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "dots", "Ljava/util/ArrayList;", "dotsClickable", "Z", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", SDKConstants.PARAM_VALUE, "dotsColor", "I", "getDotsColor", "()I", "setDotsColor", "dotsSize", "F", "getDotsSize", "()F", "setDotsSize", "(F)V", "dotsCornerRadius", "getDotsCornerRadius", "setDotsCornerRadius", "dotsSpacing", "getDotsSpacing", "setDotsSpacing", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "pager", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "getPager", "()Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "setPager", "(Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;)V", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "getType", "()Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "type", "Companion", "Pager", "Type", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseDotsIndicator extends FrameLayout {
    protected final ArrayList<ImageView> dots;
    private boolean dotsClickable;
    private int dotsColor;
    private float dotsCornerRadius;
    private float dotsSize;
    private float dotsSpacing;
    private Pager pager;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "", "", "item", "", "smoothScroll", "", "setCurrentItem", "(IZ)V", "removeOnPageChangeListener", "()V", "Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "onPageChangeListenerHelper", "addOnPageChangeListener", "(Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;)V", "isNotEmpty", "()Z", "getCurrentItem", "()I", "currentItem", "getCount", "count", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Pager {
        void addOnPageChangeListener(OnPageChangeListenerHelper onPageChangeListenerHelper);

        int getCount();

        int getCurrentItem();

        boolean isNotEmpty();

        void removeOnPageChangeListener();

        void setCurrentItem(int item, boolean smoothScroll);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BS\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\b\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b\u0012\b\b\u0001\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "", "defaultSize", "", "defaultSpacing", "styleableId", "", "dotsColorId", "", "dotsSizeId", "dotsSpacingId", "dotsCornerRadiusId", "dotsClickableId", "(Ljava/lang/String;IFF[IIIIII)V", "getDefaultSize", "()F", "getDefaultSpacing", "getDotsClickableId", "()I", "getDotsColorId", "getDotsCornerRadiusId", "getDotsSizeId", "getDotsSpacingId", "getStyleableId", "()[I", "DEFAULT", "SPRING", "WORM", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type DEFAULT;
        public static final Type SPRING;
        public static final Type WORM;
        private final float defaultSize;
        private final float defaultSpacing;
        private final int dotsClickableId;
        private final int dotsColorId;
        private final int dotsCornerRadiusId;
        private final int dotsSizeId;
        private final int dotsSpacingId;
        private final int[] styleableId;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DEFAULT, SPRING, WORM};
        }

        static {
            int[] iArr = R$styleable.DotsIndicator;
            iArr.getClass();
            DEFAULT = new Type("DEFAULT", 0, 16.0f, 8.0f, iArr, R$styleable.DotsIndicator_dotsColor, R$styleable.DotsIndicator_dotsSize, R$styleable.DotsIndicator_dotsSpacing, R$styleable.DotsIndicator_dotsCornerRadius, R$styleable.DotsIndicator_dotsClickable);
            int[] iArr2 = R$styleable.SpringDotsIndicator;
            iArr2.getClass();
            SPRING = new Type("SPRING", 1, 16.0f, 4.0f, iArr2, R$styleable.SpringDotsIndicator_dotsColor, R$styleable.SpringDotsIndicator_dotsSize, R$styleable.SpringDotsIndicator_dotsSpacing, R$styleable.SpringDotsIndicator_dotsCornerRadius, R$styleable.SpringDotsIndicator_dotsClickable);
            int[] iArr3 = R$styleable.WormDotsIndicator;
            iArr3.getClass();
            WORM = new Type("WORM", 2, 16.0f, 4.0f, iArr3, R$styleable.WormDotsIndicator_dotsColor, R$styleable.WormDotsIndicator_dotsSize, R$styleable.WormDotsIndicator_dotsSpacing, R$styleable.WormDotsIndicator_dotsCornerRadius, R$styleable.WormDotsIndicator_dotsClickable);
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i, float f, float f2, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
            this.defaultSize = f;
            this.defaultSpacing = f2;
            this.styleableId = iArr;
            this.dotsColorId = i2;
            this.dotsSizeId = i3;
            this.dotsSpacingId = i4;
            this.dotsCornerRadiusId = i5;
            this.dotsClickableId = i6;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final float getDefaultSize() {
            return this.defaultSize;
        }

        public final float getDefaultSpacing() {
            return this.defaultSpacing;
        }

        public final int getDotsClickableId() {
            return this.dotsClickableId;
        }

        public final int getDotsColorId() {
            return this.dotsColorId;
        }

        public final int getDotsCornerRadiusId() {
            return this.dotsCornerRadiusId;
        }

        public final int getDotsSizeId() {
            return this.dotsSizeId;
        }

        public final int getDotsSpacingId() {
            return this.dotsSpacingId;
        }

        public final int[] getStyleableId() {
            return this.styleableId;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDotsIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.dots = new ArrayList<>();
        this.dotsClickable = true;
        this.dotsColor = Color.CYAN;
        float fDpToPxF = dpToPxF(getType().getDefaultSize());
        this.dotsSize = fDpToPxF;
        this.dotsCornerRadius = fDpToPxF / 2.0f;
        this.dotsSpacing = dpToPxF(getType().getDefaultSpacing());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, getType().getStyleableId());
            typedArrayObtainStyledAttributes.getClass();
            setDotsColor(typedArrayObtainStyledAttributes.getColor(getType().getDotsColorId(), Color.CYAN));
            this.dotsSize = typedArrayObtainStyledAttributes.getDimension(getType().getDotsSizeId(), this.dotsSize);
            this.dotsCornerRadius = typedArrayObtainStyledAttributes.getDimension(getType().getDotsCornerRadiusId(), this.dotsCornerRadius);
            this.dotsSpacing = typedArrayObtainStyledAttributes.getDimension(getType().getDotsSpacingId(), this.dotsSpacing);
            this.dotsClickable = typedArrayObtainStyledAttributes.getBoolean(getType().getDotsClickableId(), true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToWindow$lambda$0(BaseDotsIndicator baseDotsIndicator) {
        baseDotsIndicator.getClass();
        baseDotsIndicator.refreshDots();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRestoreInstanceState$lambda$3(BaseDotsIndicator baseDotsIndicator) {
        baseDotsIndicator.getClass();
        baseDotsIndicator.refreshDots();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshDots$lambda$1(BaseDotsIndicator baseDotsIndicator) {
        baseDotsIndicator.getClass();
        baseDotsIndicator.refreshDotsCount();
        baseDotsIndicator.refreshDotsColors();
        baseDotsIndicator.refreshDotsSize();
        baseDotsIndicator.refreshOnPageChangedListener();
    }

    private final void refreshDotsCount() {
        int size = this.dots.size();
        Pager pager = this.pager;
        pager.getClass();
        if (size < pager.getCount()) {
            Pager pager2 = this.pager;
            pager2.getClass();
            addDots(pager2.getCount() - this.dots.size());
            return;
        }
        int size2 = this.dots.size();
        Pager pager3 = this.pager;
        pager3.getClass();
        if (size2 > pager3.getCount()) {
            int size3 = this.dots.size();
            Pager pager4 = this.pager;
            pager4.getClass();
            removeDots(size3 - pager4.getCount());
        }
    }

    private final void refreshDotsSize() {
        Iterator<T> it = this.dots.iterator();
        while (it.hasNext()) {
            ExtensionsKt.setWidth((ImageView) it.next(), (int) this.dotsSize);
        }
    }

    private final void refreshOnPageChangedListener() {
        Pager pager = this.pager;
        pager.getClass();
        if (pager.isNotEmpty()) {
            Pager pager2 = this.pager;
            pager2.getClass();
            pager2.removeOnPageChangeListener();
            OnPageChangeListenerHelper onPageChangeListenerHelperBuildOnPageChangedListener = buildOnPageChangedListener();
            Pager pager3 = this.pager;
            pager3.getClass();
            pager3.addOnPageChangeListener(onPageChangeListenerHelperBuildOnPageChangedListener);
            Pager pager4 = this.pager;
            pager4.getClass();
            onPageChangeListenerHelperBuildOnPageChangedListener.onPageScrolled(pager4.getCurrentItem(), 0.0f);
        }
    }

    private final void removeDots(int count) {
        for (int i = 0; i < count; i++) {
            removeDot();
        }
    }

    public abstract void addDot(int index);

    public final void addDots(int count) {
        for (int i = 0; i < count; i++) {
            addDot(i);
        }
    }

    public abstract OnPageChangeListenerHelper buildOnPageChangedListener();

    public final float dpToPxF(float dp) {
        return getContext().getResources().getDisplayMetrics().density * dp;
    }

    public final boolean getDotsClickable() {
        return this.dotsClickable;
    }

    public final int getDotsColor() {
        return this.dotsColor;
    }

    public final float getDotsCornerRadius() {
        return this.dotsCornerRadius;
    }

    public final float getDotsSize() {
        return this.dotsSize;
    }

    public final float getDotsSpacing() {
        return this.dotsSpacing;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public abstract Type getType();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new BaseDotsIndicator$$ExternalSyntheticLambda0(this, 0));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (getLayoutDirection() == 1) {
            setLayoutDirection(0);
            setRotation(180.0f);
            requestLayout();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        post(new BaseDotsIndicator$$ExternalSyntheticLambda0(this, 2));
    }

    public abstract void refreshDotColor(int index);

    public final void refreshDots() {
        if (this.pager == null) {
            return;
        }
        post(new BaseDotsIndicator$$ExternalSyntheticLambda0(this, 1));
    }

    public final void refreshDotsColors() {
        int size = this.dots.size();
        for (int i = 0; i < size; i++) {
            refreshDotColor(i);
        }
    }

    public abstract void removeDot();

    public final void setDotsClickable(boolean z) {
        this.dotsClickable = z;
    }

    public final void setDotsColor(int i) {
        this.dotsColor = i;
        refreshDotsColors();
    }

    public final void setDotsCornerRadius(float f) {
        this.dotsCornerRadius = f;
    }

    public final void setDotsSize(float f) {
        this.dotsSize = f;
    }

    public final void setDotsSpacing(float f) {
        this.dotsSpacing = f;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setPointsColor(int color) {
        setDotsColor(color);
        refreshDotsColors();
    }

    public final void setViewPager(ViewPager viewPager) {
        viewPager.getClass();
        new ViewPagerAttacher().setup(this, viewPager);
    }

    public final void setViewPager2(ViewPager2 viewPager2) {
        throw null;
    }
}
