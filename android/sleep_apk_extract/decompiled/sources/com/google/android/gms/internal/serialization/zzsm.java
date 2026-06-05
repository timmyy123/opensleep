package com.google.android.gms.internal.serialization;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterEndpointTraitSerialization$Attributes$Companion;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/InternalSerializer;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterEndpointTraitSerialization$Attributes;", "serializable", "", "toJson", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterEndpointTraitSerialization$Attributes;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterEndpointTraitSerialization$Attributes;", "toProto", "proto", "fromProto", "TRAIT_ID", "Ljava/lang/String;", "ENDPOINT_ID", "MATTER_NODE_OBJECT_ID", "typeId", "getTypeId", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzsm implements zzsj {
    public /* synthetic */ zzsm(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final String zza() {
        return "home.internal.traits.MatterEndpointTrait";
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzb(String str) {
        str.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzvu.zzb(zzvr.zza(str), new zzsl(linkedHashMap));
        if (!linkedHashMap.containsKey("endpointId") || !linkedHashMap.containsKey("matterNodeObjectId")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid data for home.internal.traits.MatterEndpointTrait");
            return null;
        }
        Object obj = linkedHashMap.get("endpointId");
        obj.getClass();
        int data2 = ((UInt) obj).getData();
        Object obj2 = linkedHashMap.get("matterNodeObjectId");
        obj2.getClass();
        return new zzsn(data2, (String) obj2, null);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzc(String str) {
        str.getClass();
        zzafm zzafmVarZzc = zzafm.zzc(zzvo.zza(str));
        zzafmVarZzc.getClass();
        int iM2389constructorimpl = UInt.m2389constructorimpl(zzafmVarZzc.zzb());
        String strZza = zzafmVarZzc.zza();
        strZza.getClass();
        return new zzsn(iM2389constructorimpl, strZza, null);
    }
}
