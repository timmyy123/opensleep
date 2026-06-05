package kotlin.reflect.jvm.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionJvmDescriptor;", "", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "", "", "returnType", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getParameters", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/String;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FunctionJvmDescriptor {
    private final List<String> parameters;
    private final String returnType;

    public FunctionJvmDescriptor(List<String> list, String str) {
        list.getClass();
        str.getClass();
        this.parameters = list;
        this.returnType = str;
    }

    public final List<String> getParameters() {
        return this.parameters;
    }

    public final String getReturnType() {
        return this.returnType;
    }
}
