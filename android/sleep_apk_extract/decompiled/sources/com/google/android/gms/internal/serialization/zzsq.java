package com.google.android.gms.internal.serialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterMappingTraitSerialization$Attributes$Companion;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/InternalSerializer;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterMappingTraitSerialization$Attributes;", "serializable", "", "toJson", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterMappingTraitSerialization$Attributes;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterMappingTraitSerialization$Attributes;", "toProto", "proto", "fromProto", "TRAIT_ID", "Ljava/lang/String;", "ENDPOINT_IDS", "NODE_ID", "FABRIC_ID", "typeId", "getTypeId", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzsq implements zzsj {
    public /* synthetic */ zzsq(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final zzsr zzg(String str) {
        str.getClass();
        zzvs zzvsVarZza = zzvr.zza(str);
        ArrayList arrayList = new ArrayList();
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = 0L;
        Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = 0L;
        zzvu.zzb(zzvsVarZza, new zzsp(ref$LongRef, ref$LongRef2, arrayList));
        return new zzsr(CollectionsKt.toList(arrayList), ref$LongRef.element, ref$LongRef2.element, null);
    }

    public static final zzsr zzh(String str) {
        str.getClass();
        zzafo zzafoVarZzd = zzafo.zzd(zzvo.zza(str));
        zzafoVarZzd.getClass();
        List listZzb = zzafoVarZzd.zzb();
        listZzb.getClass();
        List<Integer> list = listZzb;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Integer num : list) {
            num.getClass();
            arrayList.add(UInt.m2388boximpl(UInt.m2389constructorimpl(num.intValue())));
        }
        return new zzsr(arrayList, ULong.m2411constructorimpl(zzafoVarZzd.zzc()), ULong.m2411constructorimpl(zzafoVarZzd.zza()), null);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final String zza() {
        return "home.internal.traits.MatterMappingTrait";
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzb(String str) {
        return zzg(str);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzc(String str) {
        return zzh(str);
    }
}
