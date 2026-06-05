package androidx.appfunctions.service.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.functions.C$AppFunctions_AppFunctionInvoker;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: androidx.appfunctions.service.internal.$AggregatedAppFunctionInvoker_Impl, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/appfunctions/service/internal/$AggregatedAppFunctionInvoker_Impl", "Landroidx/appfunctions/service/internal/AggregatedAppFunctionInvoker;", "<init>", "()V", IntrospectionHelper.AggregatedAppFunctionInvokerClass.PROPERTY_INVOKERS_NAME, "", "Landroidx/appfunctions/service/internal/AppFunctionInvoker;", "getInvokers", "()Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class C$AggregatedAppFunctionInvoker_Impl extends AggregatedAppFunctionInvoker {
    private final List<AppFunctionInvoker> invokers = CollectionsKt.listOf(new C$AppFunctions_AppFunctionInvoker());

    @Override // androidx.appfunctions.service.internal.AggregatedAppFunctionInvoker
    public List<AppFunctionInvoker> getInvokers() {
        return this.invokers;
    }
}
