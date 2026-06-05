package com.google.android.gms.internal.serialization;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/DeviceTraitSerialization$Attributes$Companion;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/InternalSerializer;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/DeviceTraitSerialization$Attributes;", "serializable", "", "toJson", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/DeviceTraitSerialization$Attributes;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/DeviceTraitSerialization$Attributes;", "toProto", "proto", "fromProto", "TRAIT_ID", "Ljava/lang/String;", "NAME", "ROOM_OBJECT_ID", "STRUCTURE_OBJECT_ID", "DESCRIPTIVE_TYPE", "IS_SELF_DEVICE", "typeId", "getTypeId", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzsh implements zzsj {
    public /* synthetic */ zzsh(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final String zza() {
        return "home.internal.traits.DeviceTrait";
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzb(String str) {
        str.getClass();
        zzvs zzvsVarZza = zzvr.zza(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        zzvu.zzb(zzvsVarZza, new zzsg(linkedHashMap, ref$BooleanRef));
        Object obj = linkedHashMap.get("name");
        obj.getClass();
        String str2 = (String) obj;
        String str3 = (String) linkedHashMap.get("roomObjectId");
        String str4 = str3 == null ? "" : str3;
        String str5 = (String) linkedHashMap.get("structureObjectId");
        String str6 = str5 == null ? "" : str5;
        String str7 = (String) linkedHashMap.get("descriptiveType");
        return new zzsi(str2, str4, str6, str7 == null ? "" : str7, ref$BooleanRef.element);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzc(String str) {
        str.getClass();
        zzafk zzafkVarZzf = zzafk.zzf(zzvo.zza(str));
        zzafkVarZzf.getClass();
        String strZza = zzafkVarZzf.zza();
        strZza.getClass();
        String strZzc = zzafkVarZzf.zzc();
        strZzc.getClass();
        String strZzb = zzafkVarZzf.zzb();
        strZzb.getClass();
        String strZzd = zzafkVarZzf.zzd();
        strZzd.getClass();
        return new zzsi(strZza, strZzc, strZzb, strZzd, zzafkVarZzf.zze());
    }
}
