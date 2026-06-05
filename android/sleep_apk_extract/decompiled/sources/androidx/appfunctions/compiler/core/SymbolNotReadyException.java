package androidx.appfunctions.compiler.core;

import com.google.devtools.ksp.symbol.KSNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/appfunctions/compiler/core/SymbolNotReadyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "node", "Lcom/google/devtools/ksp/symbol/KSNode;", "<init>", "(Ljava/lang/String;Lcom/google/devtools/ksp/symbol/KSNode;)V", "getNode", "()Lcom/google/devtools/ksp/symbol/KSNode;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SymbolNotReadyException extends Exception {
    private final KSNode node;

    public /* synthetic */ SymbolNotReadyException(String str, KSNode kSNode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : kSNode);
    }

    public final KSNode getNode() {
        return this.node;
    }

    public SymbolNotReadyException(String str, KSNode kSNode) {
        super(str);
        this.node = kSNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SymbolNotReadyException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
