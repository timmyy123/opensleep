package com.google.firebase.ai.common.util;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.FlowCollector;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class KotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1<T> implements FlowCollector {
    final /* synthetic */ FlowCollector $$this$flow$inlined;
    final /* synthetic */ Ref$ObjectRef $accumulator;
    final /* synthetic */ int $minSize$inlined;

    /* JADX INFO: renamed from: com.google.firebase.ai.common.util.KotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.util.KotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1", f = "kotlin.kt", l = {46}, m = "emit")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1.this.emit(null, this);
        }
    }

    public KotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1(Ref$ObjectRef ref$ObjectRef, int i, FlowCollector flowCollector) {
        this.$accumulator = ref$ObjectRef;
        this.$minSize$inlined = i;
        this.$$this$flow$inlined = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        ByteArrayOutputStream byteArrayOutputStream;
        Object obj;
        ByteArrayOutputStream byteArrayOutputStream2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            ref$ObjectRef = this.$accumulator;
            byte[] bArr = (byte[]) t;
            ByteArrayOutputStream byteArrayOutputStream3 = (T) ((ByteArrayOutputStream) ref$ObjectRef.element);
            byteArrayOutputStream3.write(bArr, 0, bArr.length);
            int size = byteArrayOutputStream3.size();
            obj = byteArrayOutputStream3;
            if (size >= this.$minSize$inlined) {
                FlowCollector flowCollector = this.$$this$flow$inlined;
                byte[] byteArray = byteArrayOutputStream3.toByteArray();
                byteArray.getClass();
                anonymousClass1.L$0 = ref$ObjectRef;
                anonymousClass1.L$1 = byteArrayOutputStream3;
                anonymousClass1.L$2 = byteArrayOutputStream3;
                anonymousClass1.label = 1;
                if (flowCollector.emit(byteArray, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$ObjectRef2 = ref$ObjectRef;
                ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream3;
                byteArrayOutputStream = byteArrayOutputStream4;
                byteArrayOutputStream2 = byteArrayOutputStream4;
            }
            ref$ObjectRef.element = (T) obj;
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream5 = (ByteArrayOutputStream) anonymousClass1.L$2;
        ByteArrayOutputStream byteArrayOutputStream6 = (ByteArrayOutputStream) anonymousClass1.L$1;
        ref$ObjectRef2 = (Ref$ObjectRef) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj2);
        byteArrayOutputStream2 = byteArrayOutputStream5;
        byteArrayOutputStream = byteArrayOutputStream6;
        byteArrayOutputStream2.reset();
        ref$ObjectRef = ref$ObjectRef2;
        obj = (T) byteArrayOutputStream;
        ref$ObjectRef.element = (T) obj;
        return Unit.INSTANCE;
    }
}
