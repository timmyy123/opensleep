package com.google.android.gms.internal.serialization;

import com.google.home.platform.traits.Entity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.automation.serialization.AutomationConverter", f = "AutomationConverter.kt", l = {997, 1000}, m = "fromEntityProto")
final class zzkl extends ContinuationImpl {
    Object zza;
    boolean zzb;
    /* synthetic */ Object zzc;
    final /* synthetic */ zzkt zzd;
    int zze;
    Entity zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkl(zzkt zzktVar, Continuation continuation) {
        super(continuation);
        this.zzd = zzktVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzc = obj;
        this.zze |= Integer.MIN_VALUE;
        return this.zzd.zzB(null, null, this);
    }
}
