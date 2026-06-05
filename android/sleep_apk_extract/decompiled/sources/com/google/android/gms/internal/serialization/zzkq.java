package com.google.android.gms.internal.serialization;

import com.google.home.platform.traits.Node;
import com.google.home.platform.traits.ValidationIssue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.automation.serialization.AutomationConverter", f = "AutomationConverter.kt", l = {391, 394, 398, ValidationIssue.TOO_MANY_NODES_FIELD_NUMBER}, m = "fromStarterNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android")
final class zzkq extends ContinuationImpl {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzkt zzc;
    int zzd;
    Node zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkq(zzkt zzktVar, Continuation continuation) {
        super(continuation);
        this.zzc = zzktVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zzh(null, null, this);
    }
}
