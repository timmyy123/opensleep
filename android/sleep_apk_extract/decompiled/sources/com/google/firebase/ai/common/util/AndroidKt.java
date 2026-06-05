package com.google.firebase.ai.common.util;

import android.media.AudioRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"minBufferSize", "", "Landroid/media/AudioRecord;", "getMinBufferSize", "(Landroid/media/AudioRecord;)I", "readAsFlow", "Lkotlinx/coroutines/flow/Flow;", "", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidKt {

    /* JADX INFO: renamed from: com.google.firebase.ai.common.util.AndroidKt$readAsFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.util.AndroidKt$readAsFlow$1", f = "android.kt", l = {43, 48, 52}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super byte[]>, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioRecord $this_readAsFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AudioRecord audioRecord, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_readAsFlow = audioRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_readAsFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super byte[]> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            r11 = r10.$this_readAsFlow.read(r1, 0, r1.length);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        
            if (r11 <= 0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
        
            r11 = java.util.Arrays.copyOf(r1, r11);
            r10.L$0 = r7;
            r10.L$1 = r1;
            r10.label = 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
        
            if (r7.emit(r11, r10) != r0) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007d -> B:13:0x0043). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            byte[] bArr;
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        bArr = (byte[]) this.L$1;
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = flowCollector;
                        this.L$1 = bArr;
                        this.label = 3;
                        if (DelayKt.delay(0L, this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                }
                bArr = (byte[]) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                bArr = new byte[AndroidKt.getMinBufferSize(this.$this_readAsFlow)];
                flowCollector = flowCollector2;
            }
            while (true) {
                if (this.$this_readAsFlow.getRecordingState() == 3) {
                    break;
                }
                this.L$0 = flowCollector;
                this.L$1 = bArr;
                this.label = 1;
                if (DelayKt.delay(0L, this) == coroutine_suspended) {
                    break;
                }
            }
            return coroutine_suspended;
        }
    }

    public static final int getMinBufferSize(AudioRecord audioRecord) {
        audioRecord.getClass();
        return AudioRecord.getMinBufferSize(audioRecord.getSampleRate(), audioRecord.getChannelConfiguration(), audioRecord.getAudioFormat());
    }

    public static final Flow<byte[]> readAsFlow(AudioRecord audioRecord) {
        audioRecord.getClass();
        return FlowKt.flow(new AnonymousClass1(audioRecord, null));
    }
}
