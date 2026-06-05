package com.google.android.gms.internal.serialization;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterNodeTraitSerialization$Attributes$Companion;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/InternalSerializer;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterNodeTraitSerialization$Attributes;", "serializable", "", "toJson", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterNodeTraitSerialization$Attributes;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterNodeTraitSerialization$Attributes;", "toProto", "proto", "fromProto", "TRAIT_ID", "Ljava/lang/String;", "VENDOR_ID", "PRODUCT_ID", "NODE_LABEL", "PRODUCT_LABEL", "SOFTWARE_VERSION", "SOFTWARE_VERSION_STRING", "typeId", "getTypeId", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzst implements zzsj {
    public /* synthetic */ zzst(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final String zza() {
        return "home.internal.traits.MatterNodeTrait";
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzb(String str) {
        str.getClass();
        zzvs zzvsVarZza = zzvr.zza(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        zzvu.zzb(zzvsVarZza, new zzss(linkedHashMap, linkedHashMap2));
        Object obj = linkedHashMap.get("vendorId");
        obj.getClass();
        int data2 = ((UInt) obj).getData();
        Object obj2 = linkedHashMap.get("productId");
        obj2.getClass();
        int data3 = ((UInt) obj2).getData();
        Object obj3 = linkedHashMap2.get("nodeLabel");
        obj3.getClass();
        String str2 = (String) obj3;
        Object obj4 = linkedHashMap2.get("productLabel");
        obj4.getClass();
        String str3 = (String) obj4;
        Object obj5 = linkedHashMap.get("softwareVersion");
        obj5.getClass();
        int data4 = ((UInt) obj5).getData();
        Object obj6 = linkedHashMap2.get("softwareVersionString");
        obj6.getClass();
        return new zzsu(data2, data3, str2, str3, data4, (String) obj6, null);
    }

    @Override // com.google.android.gms.internal.serialization.zzsj
    public final /* bridge */ /* synthetic */ GhpSerializable zzc(String str) {
        str.getClass();
        zzafq zzafqVarZzg = zzafq.zzg(zzvo.zza(str));
        zzafqVarZzg.getClass();
        int iM2389constructorimpl = UInt.m2389constructorimpl(zzafqVarZzg.zza());
        int iM2389constructorimpl2 = UInt.m2389constructorimpl(zzafqVarZzg.zzb());
        String strZzc = zzafqVarZzg.zzc();
        strZzc.getClass();
        String strZzd = zzafqVarZzg.zzd();
        strZzd.getClass();
        int iM2389constructorimpl3 = UInt.m2389constructorimpl(zzafqVarZzg.zze());
        String strZzf = zzafqVarZzg.zzf();
        strZzf.getClass();
        return new zzsu(iM2389constructorimpl, iM2389constructorimpl2, strZzc, strZzd, iM2389constructorimpl3, strZzf, null);
    }
}
