package androidx.appfunctions.compiler.core;

import com.google.devtools.ksp.symbol.KSDeclaration;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSymbolResolver$resolveAllAnnotatedSerializableProxiesFromModule$$inlined$sortedBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        ((KSDeclaration) t).getQualifiedName();
        ((KSDeclaration) t2).getQualifiedName();
        return ComparisonsKt.compareValues(null, null);
    }
}
