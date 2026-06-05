package androidx.appfunctions.compiler.core;

import com.google.devtools.ksp.symbol.KSNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/compiler/core/ProcessingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "symbol", "Lcom/google/devtools/ksp/symbol/KSNode;", "throwable", "", "<init>", "(Ljava/lang/String;Lcom/google/devtools/ksp/symbol/KSNode;Ljava/lang/Throwable;)V", "getSymbol", "()Lcom/google/devtools/ksp/symbol/KSNode;", "getThrowable", "()Ljava/lang/Throwable;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProcessingException extends Exception {
    private final KSNode symbol;
    private final Throwable throwable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessingException(String str, KSNode kSNode, Throwable th) {
        super(str, th);
        str.getClass();
        this.symbol = kSNode;
        this.throwable = th;
    }

    public final KSNode getSymbol() {
        return this.symbol;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public /* synthetic */ ProcessingException(String str, KSNode kSNode, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, kSNode, (i & 4) != 0 ? null : th);
    }
}
