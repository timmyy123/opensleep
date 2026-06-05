package com.google.firebase.ai.common.util;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0000\u001a&\u0010\u0003\u001a\n \u0005*\u0004\u0018\u0001H\u0004H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006*\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u000e\u0010\u0010\u001a\u00020\u0011H\u0080H¢\u0006\u0002\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"removeLast", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getAnnotation", "T", "kotlin.jvm.PlatformType", "", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)Ljava/lang/annotation/Annotation;", "accumulateUntil", "Lkotlinx/coroutines/flow/Flow;", "", SDKConstants.PARAM_CONTEXT_MIN_SIZE, "", "emitLeftOvers", "", "childJob", "Lkotlinx/coroutines/CompletableJob;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CancelledCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCancelledCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KotlinKt {
    private static final CoroutineScope CancelledCoroutineScope;

    /* JADX INFO: renamed from: com.google.firebase.ai.common.util.KotlinKt$accumulateUntil$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.util.KotlinKt$accumulateUntil$1", f = "kotlin.kt", l = {106, 83}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super byte[]>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $emitLeftOvers;
        final /* synthetic */ int $minSize;
        final /* synthetic */ Flow<byte[]> $this_accumulateUntil;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow<byte[]> flow, boolean z, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_accumulateUntil = flow;
            this.$emitLeftOvers = z;
            this.$minSize = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_accumulateUntil, this.$emitLeftOvers, this.$minSize, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super byte[]> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
        
            if (r4.emit(r9, r8) == r0) goto L20;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, java.io.ByteArrayOutputStream] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Ref$ObjectRef ref$ObjectRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                Flow<byte[]> flow = this.$this_accumulateUntil;
                ?? byteArrayOutputStream = new ByteArrayOutputStream();
                int i2 = this.$minSize;
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                ref$ObjectRef2.element = byteArrayOutputStream;
                KotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1 kotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1 = new KotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1(ref$ObjectRef2, i2, flowCollector2);
                this.L$0 = flowCollector2;
                this.L$1 = ref$ObjectRef2;
                this.label = 1;
                if (flow.collect(kotlinKt$accumulateUntil$1$invokeSuspend$$inlined$fold$1, this) != coroutine_suspended) {
                    flowCollector = flowCollector2;
                    ref$ObjectRef = ref$ObjectRef2;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$ObjectRef = (Ref$ObjectRef) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) ref$ObjectRef.element;
            if (this.$emitLeftOvers && byteArrayOutputStream2.size() > 0) {
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                byteArray.getClass();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE);
        CoroutineScopeKt.cancel$default(CoroutineScope, null, 1, null);
        CancelledCoroutineScope = CoroutineScope;
    }

    public static final Flow<byte[]> accumulateUntil(Flow<byte[]> flow, int i, boolean z) {
        flow.getClass();
        return FlowKt.flow(new AnonymousClass1(flow, z, i, null));
    }

    public static /* synthetic */ Flow accumulateUntil$default(Flow flow, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return accumulateUntil(flow, i, z);
    }

    public static final Object childJob(Continuation<? super CompletableJob> continuation) {
        Job jobJob$default = (Job) continuation.getContext().get(Job.INSTANCE);
        if (jobJob$default == null) {
            jobJob$default = JobKt__JobKt.Job$default(null, 1, null);
        }
        return JobKt.Job(jobJob$default);
    }

    private static final Object childJob$$forInline(Continuation<? super CompletableJob> continuation) {
        InlineMarker.mark(3);
        throw null;
    }

    public static final /* synthetic */ <T extends Annotation> T getAnnotation(Field field) {
        field.getClass();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) field.getAnnotation(Annotation.class);
    }

    public static final CoroutineScope getCancelledCoroutineScope() {
        return CancelledCoroutineScope;
    }

    public static final StringBuilder removeLast(StringBuilder sb) {
        sb.getClass();
        if (sb.length() == 0) {
            Events$$ExternalSyntheticBUOutline0.m$2("StringBuilder is empty.");
            return null;
        }
        StringBuilder sbDeleteCharAt = sb.deleteCharAt(sb.length() - 1);
        sbDeleteCharAt.getClass();
        return sbDeleteCharAt;
    }
}
