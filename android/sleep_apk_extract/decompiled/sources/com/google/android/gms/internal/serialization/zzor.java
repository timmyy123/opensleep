package com.google.android.gms.internal.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/google/home/internal/impl/GhpCoreMetadataImpl;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.internal.impl.GhpCoreMetadataController$permissionsSharedFlow$3", f = "GhpCoreMetadataController.kt", l = {78, 88}, m = "invokeSuspend")
final class zzor extends SuspendLambda implements Function2 {
    int zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzrn zzc;
    final /* synthetic */ zzpu zzd;
    final /* synthetic */ zzow zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzor(zzrn zzrnVar, zzpu zzpuVar, zzow zzowVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzrnVar;
        this.zzd = zzpuVar;
        this.zze = zzowVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        zzor zzorVar = new zzor(this.zzc, this.zzd, this.zze, continuation);
        zzorVar.zzb = obj;
        return zzorVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzor) create((zzox) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0090, code lost:
    
        if (r7 == r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        zzox zzoxVar;
        List listEmptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zzoxVar = (zzox) this.zzb;
            if (zzoxVar.getZzb() == zzsf.zzc) {
                zzpv.zza().zzb().zza("Attempting to fetch a refreshed OAuth token.", new Object[0]);
                zzrn zzrnVar = this.zzc;
                this.zzb = zzoxVar;
                this.zza = 1;
                obj = zzrnVar.refreshToken(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        Object obj2 = this.zzb;
        if (i != 1) {
            ResultKt.throwOnFailure(obj);
            listEmptyList = (List) obj;
            if (!listEmptyList.isEmpty()) {
                zzpv.zza().zzb().zza("Refresh Token Successfully sent to LocalIAM.", new Object[0]);
            }
            return Unit.INSTANCE;
        }
        zzoxVar = (zzox) obj2;
        ResultKt.throwOnFailure(obj);
        String str = (String) obj;
        if (str.length() == 0) {
            zzpv.zza().zzb().zza("Failed to fetch a refreshed OAuth token.", new Object[0]);
            return Unit.INSTANCE;
        }
        zzpv.zza().zzb().zza("Successfully fetched a refreshed OAuthToken.", new Object[0]);
        InteractionClient interactionClient = (InteractionClient) this.zzd.getZza().getValue();
        if (interactionClient == null) {
            listEmptyList = CollectionsKt.emptyList();
            if (!listEmptyList.isEmpty()) {
            }
            return Unit.INSTANCE;
        }
        zzow zzowVar = this.zze;
        List listZzf = zzow.zzf(zzoxVar.getZzd(), str);
        this.zzb = str;
        this.zza = 2;
        obj = interactionClient.zzi(listZzf, this);
    }
}
