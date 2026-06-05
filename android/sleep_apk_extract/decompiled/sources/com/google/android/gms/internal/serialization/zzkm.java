package com.google.android.gms.internal.serialization;

import com.google.home.platform.traits.Node;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.automation.serialization.AutomationConverter", f = "AutomationConverter.kt", l = {370, 371, 372, 373, 374, 375, 376}, m = "fromNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android")
final class zzkm extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzkt zzb;
    int zzc;
    zzkt zzd;
    Node zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkm(zzkt zzktVar, Continuation continuation) {
        super(continuation);
        this.zzb = zzktVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzg(null, null, this);
    }
}
