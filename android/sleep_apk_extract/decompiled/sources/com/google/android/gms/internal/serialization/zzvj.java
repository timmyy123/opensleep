package com.google.android.gms.internal.serialization;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\u001a\n\u0010\u0004\u001a\u00020\n*\u00020\u000b\u001a\u0012\u0010\u0007\u001a\u00020\u000b*\u00020\f2\u0006\u0010\t\u001a\u00020\n¨\u0006\r"}, d2 = {"getExpectedPayloadType", "Lcom/google/nest/platform/mesh/serialization/SerializationMetadata$PayloadType;", "typeId", "", "toProto", "Lcom/google/protos/home/internal/interaction_api/TraitElementPayload;", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "fromProto", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload$Companion;", "proto", "Lcom/google/protos/home/internal/interaction_api/ObjectData;", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "Lcom/google/nest/platform/mesh/serialization/ObjectData$Companion;", "java.com.google.nest.platform.mesh.serialization_serialization_objects_extensions-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzvj {
    public static final zzaep zza(TraitElementPayload traitElementPayload) {
        traitElementPayload.getClass();
        zzvk zzvkVarZze = zze(traitElementPayload.getZzb());
        zzvk zzvkVar = zzvk.zza;
        int iOrdinal = zzvkVarZze.ordinal();
        if (iOrdinal == 0) {
            zzaer zzaerVarZza = zzaeq.zza(zzaep.zzf());
            zzaerVarZza.zzb(traitElementPayload.getZzb());
            zzaerVarZza.zzc(traitElementPayload.getZzd());
            return zzaerVarZza.zza();
        }
        if (iOrdinal != 1) {
            Home$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        zzaer zzaerVarZza2 = zzaeq.zza(zzaep.zzf());
        zzaerVarZza2.zzb(traitElementPayload.getZzb());
        zzwd zzwdVarZzc = zzwe.zzc();
        zzwdVarZzc.getClass();
        zzwf.zza(traitElementPayload.getZzc(), zzwdVarZzc);
        byte[] bArrZza = zzvo.zza(traitElementPayload.getZzd());
        zzwr zzwrVar = zzwr.zzb;
        zzwf.zzb(zzwr.zzl(bArrZza, 0, bArrZza.length), zzwdVarZzc);
        zzzg zzzgVarBuild = zzwdVarZzc.build();
        zzzgVarBuild.getClass();
        zzaerVarZza2.zze((zzwe) zzzgVarBuild);
        if (traitElementPayload.getGlobalVersion() != null) {
            zzaerVarZza2.zzd(traitElementPayload.getGlobalVersion().getData());
        }
        return zzaerVarZza2.zza();
    }

    public static final TraitElementPayload zzb(zzvm zzvmVar, zzaep zzaepVar) {
        zzvmVar.getClass();
        zzaepVar.getClass();
        String strZza = zzaepVar.zza();
        strZza.getClass();
        zzvk zzvkVarZze = zze(strZza);
        zzvk zzvkVar = zzvk.zza;
        int iOrdinal = zzvkVarZze.ordinal();
        if (iOrdinal == 0) {
            String strZza2 = zzaepVar.zza();
            strZza2.getClass();
            String strZzb = zzaepVar.zzb();
            strZzb.getClass();
            return new TraitElementPayload(strZza2, "", strZzb, null, null);
        }
        if (iOrdinal != 1) {
            Home$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        String strZza3 = zzaepVar.zza();
        strZza3.getClass();
        String strZza4 = zzaepVar.zze().zza();
        strZza4.getClass();
        byte[] bArrZzn = zzaepVar.zze().zzb().zzn();
        bArrZzn.getClass();
        return new TraitElementPayload(strZza3, strZza4, zzvo.zzb(bArrZzn), zzaepVar.zzc() ? ULong.m2410boximpl(ULong.m2411constructorimpl(zzaepVar.zzd())) : null, null);
    }

    public static final ObjectData zzd(zzvh zzvhVar, zzadv zzadvVar) {
        zzvhVar.getClass();
        zzadvVar.getClass();
        String strZza = zzadvVar.zza();
        strZza.getClass();
        List listZzb = zzadvVar.zzb();
        listZzb.getClass();
        List<zzaep> list = listZzb;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (zzaep zzaepVar : list) {
            arrayList.add(TuplesKt.to(zzaepVar.zza(), zzb(TraitElementPayload.zza, zzaepVar)));
        }
        return new ObjectData(strZza, MapsKt.toMutableMap(MapsKt.toMap(arrayList)), zzadvVar.zzc());
    }

    private static final zzvk zze(String str) {
        return StringsKt.startsWith$default(str, "home.internal.traits.") ? SerializationMetadata.zza() : StringsKt.startsWith$default(str, "home.platform.traits.") ? zzvk.zzb : SerializationMetadata.zzb();
    }
}
