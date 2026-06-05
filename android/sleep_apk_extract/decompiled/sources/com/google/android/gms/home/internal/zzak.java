package com.google.android.gms.home.internal;

import com.google.android.gms.internal.serialization.zzaej;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class zzak extends FunctionReferenceImpl implements Function2 {
    public zzak(Object obj) {
        super(2, obj, InternalInteractionClient.class, "sendCommandsSmall", "sendCommandsSmall(Lcom/google/protos/home/internal/interaction_api/SendCommandsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((InternalInteractionClient) this.receiver).zzK((zzaej) obj, (Continuation) obj2);
    }
}
