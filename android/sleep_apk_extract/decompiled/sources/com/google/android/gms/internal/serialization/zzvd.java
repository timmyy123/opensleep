package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/TraitSubscriber$SubscriptionStateChangeType;", "", "<init>", "(Ljava/lang/String;I)V", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzvd {
    public static final zzvd zza;
    public static final zzvd zzb;
    public static final zzvd zzc;
    public static final zzvd zzd;
    public static final zzvd zze;
    private static final /* synthetic */ zzvd[] zzf;

    static {
        zzvd zzvdVar = new zzvd("CHANGE_TYPE_UNSPECIFIED", 0);
        zza = zzvdVar;
        zzvd zzvdVar2 = new zzvd("CHANGE_TYPE_TRANSPORT_DISCONNECTED", 1);
        zzb = zzvdVar2;
        zzvd zzvdVar3 = new zzvd("CHANGE_TYPE_PERMISSIONS_UPDATED", 2);
        zzc = zzvdVar3;
        zzvd zzvdVar4 = new zzvd("CHANGE_TYPE_DATA_RECOMPUTATION_REQUIRED", 3);
        zzd = zzvdVar4;
        zzvd zzvdVar5 = new zzvd("CHANGE_TYPE_CONNECTIVITY_CHANGED", 4);
        zze = zzvdVar5;
        zzvd[] zzvdVarArr = {zzvdVar, zzvdVar2, zzvdVar3, zzvdVar4, zzvdVar5};
        zzf = zzvdVarArr;
        EnumEntriesKt.enumEntries(zzvdVarArr);
    }

    private zzvd(String str, int i) {
    }

    public static zzvd[] values() {
        return (zzvd[]) zzf.clone();
    }
}
