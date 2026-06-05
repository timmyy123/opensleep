package com.google.android.gms.internal.serialization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$Attributes$Companion;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/InternalSerializer;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$Attributes;", "serializable", "", "toJson", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$Attributes;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$Attributes;", "toProto", "proto", "fromProto", "TRAIT_ID", "Ljava/lang/String;", "SUPPORTED_OBJECT_TYPES", "SUPPORTED_TRAITS", "SUPPORTED_TRAIT_INFOS", "typeId", "getTypeId", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzti implements zzsj {
    public /* synthetic */ zzti(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final zztj zzg(String str) {
        zztk zztkVar;
        str.getClass();
        zzagd zzagdVarZzd = zzagd.zzd(zzvo.zza(str));
        zzagdVarZzd.getClass();
        List listZza = zzagdVarZzd.zza();
        listZza.getClass();
        List listZzb = zzagdVarZzd.zzb();
        listZzb.getClass();
        Map mapZzc = zzagdVarZzd.zzc();
        mapZzc.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapZzc.size()));
        for (Map.Entry entry : mapZzc.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            value.getClass();
            zzaga zzagaVar = (zzaga) value;
            zzagaVar.getClass();
            zzsk zzskVar = zzsk.zza;
            zzsk zzskVar2 = (zzsk) zzsk.zze.get(Integer.valueOf(zzagaVar.zza()));
            if (zzskVar2 == null) {
                zzskVar2 = zzsk.zza;
            }
            zztk zztkVar2 = zztk.zza;
            int iZzb = zzagaVar.zzb();
            zztk[] zztkVarArrValues = zztk.values();
            int length = zztkVarArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    zztkVar = null;
                    break;
                }
                zztkVar = zztkVarArrValues[i];
                if (zztkVar.getZze() == iZzb) {
                    break;
                }
                i++;
            }
            if (zztkVar == null) {
                zztkVar = zztk.zza;
            }
            String strZzc = zzagaVar.zzc();
            strZzc.getClass();
            linkedHashMap.put(key, new zztm(zzskVar2, zztkVar, strZzc));
        }
        return new zztj(listZza, listZzb, linkedHashMap);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final String zza() {
        return "home.internal.traits.SupportedTypesTrait";
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzb(String str) {
        str.getClass();
        zzvs zzvsVarZza = zzvr.zza(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzvu.zzb(zzvsVarZza, new zzth(arrayList2, arrayList, linkedHashMap));
        return new zztj(arrayList2, arrayList, linkedHashMap);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzc(String str) {
        return zzg(str);
    }
}
