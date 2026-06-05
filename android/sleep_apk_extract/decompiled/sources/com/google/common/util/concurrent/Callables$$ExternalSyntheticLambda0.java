package com.google.common.util.concurrent;

import androidx.webkit.internal.JavaScriptReplyProxyImpl;
import com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBufferVX;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Callables$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Callables$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return Callables.lambda$returning$0(obj);
            case 1:
                return JavaScriptReplyProxyImpl.lambda$forInvocationHandler$0((JsReplyProxyBoundaryInterface) obj);
            default:
                return ActivityDataBufferVX.getDelegate$lambda$0((ActivityDataBufferVX) obj);
        }
    }
}
