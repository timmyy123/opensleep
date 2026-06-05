package com.google.android.gms.home.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.PermissionsUiManager", f = "PermissionsUiManager.kt", l = {351, 349, 360, 368, 399, 543, 443}, m = "forceLaunchRequestOauthPermissions$suspendImpl")
final class zzbq extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    Object zzd;
    Object zze;
    /* synthetic */ Object zzf;
    final /* synthetic */ PermissionsUiManager zzg;
    int zzh;
    Ref$ObjectRef zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbq(PermissionsUiManager permissionsUiManager, Continuation continuation) {
        super(continuation);
        this.zzg = permissionsUiManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzf = obj;
        this.zzh |= Integer.MIN_VALUE;
        return PermissionsUiManager.zze(this.zzg, this);
    }
}
