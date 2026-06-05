package com.google.home.matter;

import com.google.home.Trait;
import com.google.home.matter.serialization.ScopedCommandId;
import com.google.home.matter.serialization.StructAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJR\u0010\u0013\u001a\u00028\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J>\u0010\u0013\u001a\u00020\u0015\"\u0004\b\u0000\u0010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0016J;\u0010\u0018\u001a\u00020\u0017\"\u0004\b\u0000\u0010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/matter/MatterTrait;", "", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;)V", "REQUEST", "RESPONSE", "Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "request", "Lcom/google/home/matter/serialization/StructAdapter;", "requestAdapter", "responseAdapter", "", "useTimedCommand", "sendCommand", "(Lcom/google/home/matter/serialization/ScopedCommandId;Ljava/lang/Object;Lcom/google/home/matter/serialization/StructAdapter;Lcom/google/home/matter/serialization/StructAdapter;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lcom/google/home/matter/serialization/ScopedCommandId;Ljava/lang/Object;Lcom/google/home/matter/serialization/StructAdapter;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "createObjectCommand", "(Lcom/google/home/matter/serialization/ScopedCommandId;Ljava/lang/Object;Lcom/google/home/matter/serialization/StructAdapter;Z)Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/matter/MatterTraitClient;", "getClient", "()Lcom/google/home/matter/MatterTraitClient;", "java.com.google.home.matter_matter-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MatterTraitImpl implements MatterTrait {
    private final MatterTraitClient client;
    private final Trait.TraitMetadata metadata;

    /* JADX INFO: renamed from: com.google.home.matter.MatterTraitImpl$sendCommand$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.matter.MatterTraitImpl", f = "MatterTrait.kt", l = {72}, m = "sendCommand")
    public static final class AnonymousClass2<REQUEST> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MatterTraitImpl.this.sendCommand(null, null, null, false, this);
        }
    }

    public MatterTraitImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient) {
        traitMetadata.getClass();
        matterTraitClient.getClass();
        this.metadata = traitMetadata;
        this.client = matterTraitClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <REQUEST> Object sendCommand(ScopedCommandId scopedCommandId, REQUEST request, StructAdapter<REQUEST> structAdapter, boolean z, Continuation<? super Unit> continuation) {
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        }
        AnonymousClass2 anonymousClass22 = anonymousClass2;
        Object objSendCommand = anonymousClass22.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass22.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSendCommand);
            NoOpAdapter noOpAdapter = NoOpAdapter.INSTANCE;
            anonymousClass22.label = 1;
            objSendCommand = sendCommand(scopedCommandId, request, structAdapter, noOpAdapter, z, anonymousClass22);
            if (objSendCommand == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objSendCommand);
        }
        return Unit.INSTANCE;
    }

    public final <REQUEST, RESPONSE> Object sendCommand(ScopedCommandId scopedCommandId, REQUEST request, StructAdapter<REQUEST> structAdapter, StructAdapter<RESPONSE> structAdapter2, boolean z, Continuation<? super RESPONSE> continuation) {
        return this.client.sendCommand(scopedCommandId, structAdapter, structAdapter2, request, z, continuation);
    }
}
