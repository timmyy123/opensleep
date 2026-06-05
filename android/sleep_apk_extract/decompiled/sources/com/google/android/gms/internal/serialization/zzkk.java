package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.automation.serialization.AutomationConverter", f = "AutomationConverter.kt", l = {302}, m = "fromAutomationTraits-chsYqT4")
final class zzkk extends ContinuationImpl {
    Object zza;
    Object zzb;
    /* synthetic */ Object zzc;
    final /* synthetic */ zzkt zzd;
    int zze;
    zzkt zzf;
    String zzg;
    zzpu zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkk(zzkt zzktVar, Continuation continuation) {
        super(continuation);
        this.zzd = zzktVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzc = obj;
        this.zze |= Integer.MIN_VALUE;
        return this.zzd.zze(null, null, null, null, this);
    }
}
