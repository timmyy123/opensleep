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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudConnectionStateTraitSerialization$ConnectionState;", "", "", SDKConstants.PARAM_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzsb {
    public static final zzsb zza;
    public static final zzsb zzb;
    public static final zzsb zzc;
    private static final Map zze;
    private static final /* synthetic */ zzsb[] zzf;
    private final int zzd;

    static {
        zzsb zzsbVar = new zzsb("UNKNOWN", 0, 0);
        zza = zzsbVar;
        zzsb zzsbVar2 = new zzsb("NOT_CONNECTED", 1, 1);
        zzb = zzsbVar2;
        zzsb zzsbVar3 = new zzsb("CONNECTED", 2, 2);
        zzc = zzsbVar3;
        zzsb[] zzsbVarArr = {zzsbVar, zzsbVar2, zzsbVar3};
        zzf = zzsbVarArr;
        EnumEntriesKt.enumEntries(zzsbVarArr);
        zzsb[] zzsbVarArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzsbVarArrValues.length), 16));
        for (zzsb zzsbVar4 : zzsbVarArrValues) {
            linkedHashMap.put(Integer.valueOf(zzsbVar4.zzd), zzsbVar4);
        }
        zzsb[] zzsbVarArrValues2 = values();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzsbVarArrValues2.length), 16));
        for (zzsb zzsbVar5 : zzsbVarArrValues2) {
            linkedHashMap2.put(zzsbVar5.name(), zzsbVar5);
        }
        zzsb[] zzsbVarArrValues3 = values();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzsbVarArrValues3.length), 16));
        for (zzsb zzsbVar6 : zzsbVarArrValues3) {
            linkedHashMap3.put(String.valueOf(zzsbVar6.zzd), zzsbVar6);
        }
        zze = MapsKt.plus(linkedHashMap2, linkedHashMap3);
    }

    private zzsb(String str, int i, int i2) {
        this.zzd = i2;
    }

    public static zzsb[] values() {
        return (zzsb[]) zzf.clone();
    }
}
