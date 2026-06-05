package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/LocalConnectivityStateTraitSerialization$State;", "", "", SDKConstants.PARAM_VALUE, "<init>", "(Ljava/lang/String;II)V", "", "toJsonValue", "()Ljava/lang/String;", "I", "getValue", "()I", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzsk {
    public static final zzsk zza;
    public static final zzsk zzb;
    public static final zzsk zzc;
    private static final Map zze;
    private static final Map zzf;
    private static final /* synthetic */ zzsk[] zzg;
    private final int zzd;

    static {
        zzsk zzskVar = new zzsk("UNKNOWN", 0, 0);
        zza = zzskVar;
        zzsk zzskVar2 = new zzsk("ONLINE", 1, 1);
        zzb = zzskVar2;
        zzsk zzskVar3 = new zzsk("OFFLINE", 2, 2);
        zzc = zzskVar3;
        zzsk[] zzskVarArr = {zzskVar, zzskVar2, zzskVar3};
        zzg = zzskVarArr;
        EnumEntriesKt.enumEntries(zzskVarArr);
        zzsk[] zzskVarArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzskVarArrValues.length), 16));
        for (zzsk zzskVar4 : zzskVarArrValues) {
            linkedHashMap.put(Integer.valueOf(zzskVar4.zzd), zzskVar4);
        }
        zze = linkedHashMap;
        zzsk[] zzskVarArrValues2 = values();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzskVarArrValues2.length), 16));
        for (zzsk zzskVar5 : zzskVarArrValues2) {
            linkedHashMap2.put(zzskVar5.name(), zzskVar5);
        }
        zzsk[] zzskVarArrValues3 = values();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzskVarArrValues3.length), 16));
        for (zzsk zzskVar6 : zzskVarArrValues3) {
            linkedHashMap3.put(String.valueOf(zzskVar6.zzd), zzskVar6);
        }
        zzf = MapsKt.plus(linkedHashMap2, linkedHashMap3);
    }

    private zzsk(String str, int i, int i2) {
        this.zzd = i2;
    }

    public static zzsk[] values() {
        return (zzsk[]) zzg.clone();
    }
}
