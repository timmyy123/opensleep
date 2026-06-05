package androidx.appfunctions.internal;

import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionPackageMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionReader;", "", "searchAppFunctions", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "searchFunctionSpec", "Landroidx/appfunctions/AppFunctionSearchSpec;", "getAppFunctionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG, "", "packageName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppFunctionReader {
    Object getAppFunctionMetadata(String str, String str2, Continuation<? super AppFunctionMetadata> continuation);

    Flow<List<AppFunctionPackageMetadata>> searchAppFunctions(AppFunctionSearchSpec searchFunctionSpec);
}
