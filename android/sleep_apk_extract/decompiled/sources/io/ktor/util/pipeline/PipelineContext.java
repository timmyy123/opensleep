package io.ktor.util.pipeline;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000H¦@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000H @¢\u0006\u0004\b\u000e\u0010\nR\u0017\u0010\u0005\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "TSubject", "TContext", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Ljava/lang/Object;)V", "subject", "proceedWith", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initial", "execute$ktor_utils", "execute", "Ljava/lang/Object;", "getContext", "()Ljava/lang/Object;", "getSubject", "setSubject", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PipelineContext<TSubject, TContext> implements CoroutineScope {
    private final TContext context;

    public PipelineContext(TContext tcontext) {
        tcontext.getClass();
        this.context = tcontext;
    }

    public abstract Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation);

    public final TContext getContext() {
        return this.context;
    }

    public abstract TSubject getSubject();

    public abstract Object proceed(Continuation<? super TSubject> continuation);

    public abstract Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation);
}
