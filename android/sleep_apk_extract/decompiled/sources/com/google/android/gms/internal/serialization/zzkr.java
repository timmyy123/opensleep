package com.google.android.gms.internal.serialization;

import com.google.home.platform.traits.Node;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.automation.serialization.AutomationConverter", f = "AutomationConverter.kt", l = {820, 823, 827, 830}, m = "fromStateReaderNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android")
final class zzkr extends ContinuationImpl {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzkt zzc;
    int zzd;
    Node zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkr(zzkt zzktVar, Continuation continuation) {
        super(continuation);
        this.zzc = zzktVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zzn(null, null, this);
    }
}
