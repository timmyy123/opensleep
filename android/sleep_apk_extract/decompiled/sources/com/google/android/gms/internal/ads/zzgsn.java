package com.google.android.gms.internal.ads;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzgsn extends FunctionReferenceImpl implements Function2 {
    public static final zzgsn zza = new zzgsn();

    public zzgsn() {
        super(2, zzgsp.class, "lockWithoutOwner", "lockWithoutOwner(Lkotlinx/coroutines/sync/Mutex;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        return zzgsp.zzd((Mutex) obj, (Continuation) obj2);
    }
}
