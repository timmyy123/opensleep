package com.google.android.gms.internal.serialization;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0013\u0010\n\u001a\u00020\u000e*\u00020\rH\u0002¢\u0006\u0004\b\n\u0010\u000fJ\u0013\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002¢\u0006\u0004\b\f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$Attributes$Companion;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/InternalSerializer;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$Attributes;", "serializable", "", "toJson", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$Attributes;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$Attributes;", "toProto", "proto", "fromProto", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;", "Lcom/google/protos/home/internal/traits/CloudSessionTrait$AuthState;", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;)Lcom/google/protos/home/internal/traits/CloudSessionTrait$AuthState;", "(Lcom/google/protos/home/internal/traits/CloudSessionTrait$AuthState;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;", "TRAIT_ID", "Ljava/lang/String;", "AUTH_STATE", "typeId", "getTypeId", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzsd implements zzsj {
    public /* synthetic */ zzsd(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final String zza() {
        return "home.internal.traits.CloudSessionTrait";
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzb(String str) {
        str.getClass();
        zzvs zzvsVarZza = zzvr.zza(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzvu.zzb(zzvsVarZza, new zzsc(linkedHashMap));
        Object obj = linkedHashMap.get("authState");
        obj.getClass();
        return new zzse((zzsf) obj);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzc(String str) {
        str.getClass();
        zzafi zzafiVarZzb = zzafi.zzb(zzvo.zza(str));
        zzafiVarZzb.getClass();
        zzafg zzafgVarZza = zzafiVarZzb.zza();
        zzafgVarZza.getClass();
        zzsf zzsfVar = zzsf.zza;
        int iOrdinal = zzafgVarZza.ordinal();
        return new zzse(iOrdinal != 0 ? iOrdinal != 1 ? zzsf.zzc : zzsf.zzb : zzsf.zza);
    }
}
