package com.urbandroid.sleep.service.google.home;

import com.urbandroid.sleep.service.google.home.GoogleHomeClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1$1", f = "GoogleHomeClient.kt", l = {266, 272, 275, 284}, m = "emit", v = 2)
public final class GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleHomeClient.C21661.C00461<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1(GoogleHomeClient.C21661.C00461<? super T> c00461, Continuation<? super GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c00461;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1 for r1v2 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        /*
            r1 = this;
            r1.result = r2
            int r2 = r1.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 | r0
            r1.label = r2
            com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1$1<T> r2 = r1.this$0
            r0 = 0
            java.lang.Object r1 = r2.emit(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
