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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;", "", "", SDKConstants.PARAM_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzsf {
    public static final zzsf zza;
    public static final zzsf zzb;
    public static final zzsf zzc;
    private static final Map zze;
    private static final /* synthetic */ zzsf[] zzf;
    private final int zzd;

    static {
        zzsf zzsfVar = new zzsf("AUTH_STATE_UNSPECIFIED", 0, 0);
        zza = zzsfVar;
        zzsf zzsfVar2 = new zzsf("AUTH_STATE_AUTHENTICATED", 1, 1);
        zzb = zzsfVar2;
        zzsf zzsfVar3 = new zzsf("AUTH_STATE_UNAUTHENTICATED", 2, 2);
        zzc = zzsfVar3;
        zzsf[] zzsfVarArr = {zzsfVar, zzsfVar2, zzsfVar3};
        zzf = zzsfVarArr;
        EnumEntriesKt.enumEntries(zzsfVarArr);
        zzsf[] zzsfVarArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzsfVarArrValues.length), 16));
        for (zzsf zzsfVar4 : zzsfVarArrValues) {
            linkedHashMap.put(Integer.valueOf(zzsfVar4.zzd), zzsfVar4);
        }
        zzsf[] zzsfVarArrValues2 = values();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzsfVarArrValues2.length), 16));
        for (zzsf zzsfVar5 : zzsfVarArrValues2) {
            linkedHashMap2.put(zzsfVar5.name(), zzsfVar5);
        }
        zzsf[] zzsfVarArrValues3 = values();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(zzsfVarArrValues3.length), 16));
        for (zzsf zzsfVar6 : zzsfVarArrValues3) {
            linkedHashMap3.put(String.valueOf(zzsfVar6.zzd), zzsfVar6);
        }
        zze = MapsKt.plus(linkedHashMap2, linkedHashMap3);
    }

    private zzsf(String str, int i, int i2) {
        this.zzd = i2;
    }

    public static zzsf[] values() {
        return (zzsf[]) zzf.clone();
    }
}
