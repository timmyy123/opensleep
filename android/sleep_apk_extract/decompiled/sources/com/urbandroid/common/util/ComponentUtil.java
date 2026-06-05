package com.urbandroid.common.util;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/urbandroid/common/util/ComponentUtil;", "", "<init>", "()V", "setEnabled", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "receiverClass", "Ljava/lang/Class;", "Landroid/content/BroadcastReceiver;", "enable", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComponentUtil {
    public static final ComponentUtil INSTANCE = new ComponentUtil();

    private ComponentUtil() {
    }

    public static final void setEnabled(Context context, Class<? extends BroadcastReceiver> receiverClass, boolean enable) {
        context.getClass();
        receiverClass.getClass();
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, receiverClass), enable ? 1 : 2, 1);
        } catch (Exception e) {
            String str = "component " + receiverClass.getSimpleName() + " setEnabled(" + enable + ") failure";
            Logger.logSevere(str, e);
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, str + ": " + e.getMessage());
        }
    }
}
