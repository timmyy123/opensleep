package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AppFunctionComponentRegistryGenerator;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSymbolResolver$filterAppFunctionComponent$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(((AppFunctionComponentRegistryGenerator.AppFunctionComponent) t).getQualifiedName(), ((AppFunctionComponentRegistryGenerator.AppFunctionComponent) t2).getQualifiedName());
    }
}
