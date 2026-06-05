package com.urbandroid.util;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.GattCallback;
import com.urbandroid.util.EdgeToEdgeUtil;
import io.reactivex.rxjava3.core.SingleEmitter;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda2 implements RxUtils.Emitter, OnApplyWindowInsetsListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int f$0;

    public /* synthetic */ EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda2(int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = i;
    }

    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
    public void item(Object obj) {
        GattCallback.onReadRemoteRssi$lambda$6(this.f$0, (SingleEmitter) obj);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = this.$r8$classId;
        int i2 = this.f$0;
        switch (i) {
            case 0:
                return EdgeToEdgeUtil.Companion.insetsTop$lambda$0$0(i2, view, windowInsetsCompat);
            default:
                return EdgeToEdgeUtil.Companion.insetsHeight$lambda$0$0(i2, view, windowInsetsCompat);
        }
    }
}
