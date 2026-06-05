package com.urbandroid.util;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.urbandroid.util.EdgeToEdgeUtil;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda1 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda1(boolean z, int i) {
        this.$r8$classId = i;
        this.f$0 = z;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = this.$r8$classId;
        boolean z = this.f$0;
        switch (i) {
            case 0:
                return EdgeToEdgeUtil.Companion.insetsHorizontal$lambda$0$0(z, view, windowInsetsCompat);
            default:
                return EdgeToEdgeUtil.Companion.insetsVertical$lambda$0$0(z, view, windowInsetsCompat);
        }
    }
}
