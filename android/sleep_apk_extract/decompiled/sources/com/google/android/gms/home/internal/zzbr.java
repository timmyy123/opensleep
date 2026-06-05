package com.google.android.gms.home.internal;

import android.accounts.Account;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/google/android/gms/auth/api/identity/AuthorizationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.PermissionsUiManager$forceLaunchRequestOauthPermissions$2", f = "PermissionsUiManager.kt", l = {370}, m = "invokeSuspend")
final class zzbr extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ PermissionsUiManager zzb;
    final /* synthetic */ Ref$ObjectRef zzc;
    final /* synthetic */ Account zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbr(PermissionsUiManager permissionsUiManager, Ref$ObjectRef ref$ObjectRef, Account account, Continuation continuation) {
        super(2, continuation);
        this.zzb = permissionsUiManager;
        this.zzc = ref$ObjectRef;
        this.zzd = account;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new zzbr(this.zzb, this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbr) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i != 0) {
            return obj;
        }
        PermissionsUiManager permissionsUiManager = this.zzb;
        Ref$ObjectRef ref$ObjectRef = this.zzc;
        AuthorizationClient authorizationClient = permissionsUiManager.zzd;
        String accessToken = ((AuthorizationResult) ref$ObjectRef.element).getAccessToken();
        accessToken.getClass();
        authorizationClient.zzc(accessToken);
        PermissionsUiManager permissionsUiManager2 = this.zzb;
        Account account = this.zzd;
        this.zza = 1;
        Object objZzb = permissionsUiManager2.zzb(account, this);
        return objZzb == coroutine_suspended ? coroutine_suspended : objZzb;
    }
}
