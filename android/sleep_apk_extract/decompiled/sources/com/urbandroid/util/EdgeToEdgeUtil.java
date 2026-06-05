package com.urbandroid.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.urbandroid.util.EdgeToEdgeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/util/EdgeToEdgeUtil;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class EdgeToEdgeUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J&\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J&\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/util/EdgeToEdgeUtil$Companion;", "", "<init>", "()V", "insetsBottom", "", "v", "Landroid/view/View;", "additionalMargin", "", "consume", "", "insetsHorizontal", "insetsVertical", "insetsHeight", "insetsTop", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void insetsBottom$default(Companion companion, View view, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            companion.insetsBottom(view, i, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WindowInsetsCompat insetsBottom$lambda$0$0(boolean z, int i, View view, WindowInsetsCompat windowInsetsCompat) {
            view.getClass();
            windowInsetsCompat.getClass();
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            insets.getClass();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                return null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = insets.left;
            if (i2 > 0) {
                marginLayoutParams.leftMargin = i2;
            }
            int i3 = insets.right;
            if (i3 > 0) {
                marginLayoutParams.rightMargin = i3;
            }
            marginLayoutParams.bottomMargin = insets.bottom + i;
            view.setLayoutParams(marginLayoutParams);
            if (z) {
                WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.CONSUMED;
            }
            return new WindowInsetsCompat.Builder().build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WindowInsetsCompat insetsHeight$lambda$0$0(int i, View view, WindowInsetsCompat windowInsetsCompat) {
            view.getClass();
            windowInsetsCompat.getClass();
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            insets.getClass();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                return null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = insets.left;
            if (i2 > 0) {
                marginLayoutParams.leftMargin = i2;
            }
            int i3 = insets.right;
            if (i3 > 0) {
                marginLayoutParams.rightMargin = i3;
            }
            marginLayoutParams.height = insets.top + i;
            view.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }

        public static /* synthetic */ void insetsHorizontal$default(Companion companion, View view, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            companion.insetsHorizontal(view, i, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WindowInsetsCompat insetsHorizontal$lambda$0$0(boolean z, View view, WindowInsetsCompat windowInsetsCompat) {
            view.getClass();
            windowInsetsCompat.getClass();
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            insets.getClass();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                return null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i = insets.left;
            if (i > 0) {
                marginLayoutParams.leftMargin = i;
            }
            int i2 = insets.right;
            if (i2 > 0) {
                marginLayoutParams.rightMargin = i2;
            }
            view.setLayoutParams(marginLayoutParams);
            if (z) {
                WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.CONSUMED;
            }
            return new WindowInsetsCompat.Builder().build();
        }

        public static /* synthetic */ void insetsTop$default(Companion companion, View view, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            companion.insetsTop(view, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WindowInsetsCompat insetsTop$lambda$0$0(int i, View view, WindowInsetsCompat windowInsetsCompat) {
            view.getClass();
            windowInsetsCompat.getClass();
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            insets.getClass();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                return null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = insets.left;
            if (i2 > 0) {
                marginLayoutParams.leftMargin = i2;
            }
            int i3 = insets.right;
            if (i3 > 0) {
                marginLayoutParams.rightMargin = i3;
            }
            marginLayoutParams.topMargin = insets.top + i;
            view.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }

        public static /* synthetic */ void insetsVertical$default(Companion companion, View view, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            companion.insetsVertical(view, i, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WindowInsetsCompat insetsVertical$lambda$0$0(boolean z, View view, WindowInsetsCompat windowInsetsCompat) {
            view.getClass();
            windowInsetsCompat.getClass();
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            insets.getClass();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                return null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i = insets.top;
            if (i > 0) {
                marginLayoutParams.topMargin = i;
            }
            int i2 = insets.bottom;
            if (i2 > 0) {
                marginLayoutParams.bottomMargin = i2;
            }
            view.setLayoutParams(marginLayoutParams);
            if (z) {
                WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.CONSUMED;
            }
            return new WindowInsetsCompat.Builder().build();
        }

        public final void insetsBottom(View v, final int additionalMargin, final boolean consume) {
            if (v != null) {
                ViewCompat.setOnApplyWindowInsetsListener(v, new OnApplyWindowInsetsListener() { // from class: com.urbandroid.util.EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda0
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return EdgeToEdgeUtil.Companion.insetsBottom$lambda$0$0(consume, additionalMargin, view, windowInsetsCompat);
                    }
                });
            }
        }

        public final void insetsHeight(View v, int additionalMargin) {
            if (v != null) {
                ViewCompat.setOnApplyWindowInsetsListener(v, new EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda2(additionalMargin, 2));
            }
        }

        public final void insetsHorizontal(View v, int additionalMargin, boolean consume) {
            if (v != null) {
                ViewCompat.setOnApplyWindowInsetsListener(v, new EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda1(consume, 0));
            }
        }

        public final void insetsTop(View v, int additionalMargin) {
            if (v != null) {
                ViewCompat.setOnApplyWindowInsetsListener(v, new EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda2(additionalMargin, 0));
            }
        }

        public final void insetsVertical(View v, int additionalMargin, boolean consume) {
            if (v != null) {
                ViewCompat.setOnApplyWindowInsetsListener(v, new EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda1(consume, 1));
            }
        }

        private Companion() {
        }

        public final void insetsBottom(View view, int i) {
            insetsBottom$default(this, view, i, false, 4, null);
        }

        public final void insetsBottom(View view) {
            insetsBottom$default(this, view, 0, false, 6, null);
        }

        public final void insetsHorizontal(View view) {
            insetsHorizontal$default(this, view, 0, false, 6, null);
        }

        public final void insetsTop(View view) {
            insetsTop$default(this, view, 0, 2, null);
        }

        public final void insetsVertical(View view) {
            insetsVertical$default(this, view, 0, false, 6, null);
        }
    }

    public static final void insetsBottom(View view) {
        INSTANCE.insetsBottom(view);
    }

    public static final void insetsHeight(View view, int i) {
        INSTANCE.insetsHeight(view, i);
    }

    public static final void insetsHorizontal(View view) {
        INSTANCE.insetsHorizontal(view);
    }

    public static final void insetsTop(View view) {
        INSTANCE.insetsTop(view);
    }

    public static final void insetsVertical(View view) {
        INSTANCE.insetsVertical(view);
    }

    public static final void insetsBottom(View view, int i) {
        INSTANCE.insetsBottom(view, i);
    }
}
