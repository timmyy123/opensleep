package com.urbandroid.sleep;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/ContextExtKt$contextScope$scope$1", "Lcom/urbandroid/sleep/ContextScope;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 176)
public final class ContextExtKt$contextScope$scope$1 implements ContextScope {
    final /* synthetic */ Context $context;

    public ContextExtKt$contextScope$scope$1(Context context) {
        this.$context = context;
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ int getArgb(int i) {
        return super.getArgb(i);
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ ColorStateList getAsColorStateList(int i) {
        return super.getAsColorStateList(i);
    }

    @Override // com.urbandroid.sleep.ContextScope
    /* JADX INFO: renamed from: getContext, reason: from getter */
    public Context get$context() {
        return this.$context;
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ String getValue(int i) {
        return super.getValue(i);
    }
}
