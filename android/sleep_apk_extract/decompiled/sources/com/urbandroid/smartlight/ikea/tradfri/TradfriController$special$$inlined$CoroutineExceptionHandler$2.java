package com.urbandroid.smartlight.ikea.tradfri;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/urbandroid/smartlight/ikea/tradfri/TradfriController$special$$inlined$CoroutineExceptionHandler$2", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "exception", "", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TradfriController$special$$inlined$CoroutineExceptionHandler$2 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ TradfriController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TradfriController$special$$inlined$CoroutineExceptionHandler$2(CoroutineExceptionHandler.Companion companion, TradfriController tradfriController) {
        super(companion);
        this.this$0 = tradfriController;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        TradfriController tradfriController = this.this$0;
        String str = "offStateCheckScope " + exception;
        Logger.logSevere(Logger.defaultTag, tradfriController.getTag() + ": " + ((Object) str), null);
    }
}
