package com.urbandroid.sleep.gui.inflator;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/gui/inflator/InflatorUtil;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class InflatorUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/gui/inflator/InflatorUtil$Companion;", "", "<init>", "()V", "get", "Landroid/view/LayoutInflater;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LayoutInflater get(Context context) {
            context.getClass();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
            layoutInflaterFrom.getClass();
            return layoutInflaterFrom;
        }

        private Companion() {
        }
    }

    public static final LayoutInflater get(Context context) {
        return INSTANCE.get(context);
    }
}
