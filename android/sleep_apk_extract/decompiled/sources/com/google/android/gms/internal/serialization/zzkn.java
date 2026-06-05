package com.google.android.gms.internal.serialization;

import com.google.home.platform.traits.Node;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.automation.serialization.AutomationConverter", f = "AutomationConverter.kt", l = {939}, m = "fromParallelFlowNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android")
final class zzkn extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    Object zzd;
    /* synthetic */ Object zze;
    final /* synthetic */ zzkt zzf;
    int zzg;
    zzkt zzh;
    Node zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkn(zzkt zzktVar, Continuation continuation) {
        super(continuation);
        this.zzf = zzktVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zze = obj;
        this.zzg |= Integer.MIN_VALUE;
        return this.zzf.zzq(null, null, this);
    }
}
