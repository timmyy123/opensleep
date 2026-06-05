package com.google.home.matter;

import com.google.home.matter.serialization.ScopedCommandId;
import com.google.home.matter.serialization.StructAdapter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JP\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH¦@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/MatterTraitClient;", "", "REQUEST", "RESPONSE", "Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Lcom/google/home/matter/serialization/StructAdapter;", "requestAdapter", "responseAdapter", "request", "", "useTimedCommand", "sendCommand", "(Lcom/google/home/matter/serialization/ScopedCommandId;Lcom/google/home/matter/serialization/StructAdapter;Lcom/google/home/matter/serialization/StructAdapter;Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "strictOperationValidation", "()Z", "Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "createObjectCommand", "(Lcom/google/home/matter/serialization/ScopedCommandId;Lcom/google/home/matter/serialization/StructAdapter;Ljava/lang/Object;Z)Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "java.com.google.home.matter_matter-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MatterTraitClient {
    <REQUEST, RESPONSE> Object sendCommand(ScopedCommandId scopedCommandId, StructAdapter<REQUEST> structAdapter, StructAdapter<RESPONSE> structAdapter2, REQUEST request, boolean z, Continuation<? super RESPONSE> continuation);

    boolean strictOperationValidation();
}
