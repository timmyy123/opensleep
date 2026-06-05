package com.google.android.gms.home.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.PermissionsUiManager", f = "PermissionsUiManager.kt", l = {209, 224, 228, 251, 267, 265, 281, 309}, m = "requestOauthPermissions$suspendImpl")
final class zzbs extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    /* synthetic */ Object zzd;
    final /* synthetic */ PermissionsUiManager zze;
    int zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbs(PermissionsUiManager permissionsUiManager, Continuation continuation) {
        super(continuation);
        this.zze = permissionsUiManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzd = obj;
        this.zzf |= Integer.MIN_VALUE;
        return PermissionsUiManager.zzd(this.zze, false, this);
    }
}
