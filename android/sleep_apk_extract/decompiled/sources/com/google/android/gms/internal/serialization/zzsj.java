package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.HomeException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\r\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\nJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00028\u0000\"\b\b\u0001\u0010\u0011*\u00028\u0000*\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/InternalSerializer;", "Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "T", "", "serializable", "", "toJson", "(Lcom/google/nest/platform/mesh/serialization/GhpSerializable;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "toProto", "proto", "fromProto", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "encode", "(Lcom/google/nest/platform/mesh/serialization/GhpSerializable;)Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "U", "decode", "(Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;)Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "objectData", "decodeFromObject", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;)Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "decodeAssertedFromObject", "getTypeId", "()Ljava/lang/String;", "typeId", "getTypeUrl", "typeUrl", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface zzsj {
    String zza();

    GhpSerializable zzb(String str);

    GhpSerializable zzc(String str);

    default GhpSerializable zzd(TraitElementPayload traitElementPayload) throws HomeException {
        traitElementPayload.getClass();
        if (!Intrinsics.areEqual(traitElementPayload.getZzb(), zza())) {
            String zzb = traitElementPayload.getZzb();
            String strZza = zza();
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strZza.length() + String.valueOf(zzb).length() + 29), "Invalid id, found ", zzb, ", expected ", strZza));
            return null;
        }
        try {
            zzvk zzvkVarZza = SerializationMetadata.zza();
            zzvk zzvkVar = zzvk.zza;
            int iOrdinal = zzvkVarZza.ordinal();
            if (iOrdinal == 0) {
                return zzb(traitElementPayload.getZzd());
            }
            if (iOrdinal == 1) {
                return zzc(traitElementPayload.getZzd());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            HomeException.Companion companion = HomeException.INSTANCE;
            String zzb2 = traitElementPayload.getZzb();
            String message = e.getMessage();
            if (message == null) {
                message = e.toString();
            }
            throw companion.internal(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(zzb2).length() + 20 + String.valueOf(message).length()), "Failed to decode ", zzb2, " : ", message));
        }
    }

    default GhpSerializable zze(ObjectData objectData) {
        objectData.getClass();
        TraitElementPayload traitElementPayload = (TraitElementPayload) objectData.getContents().get(zza());
        if (traitElementPayload == null) {
            return null;
        }
        return zzd(traitElementPayload);
    }

    default GhpSerializable zzf(ObjectData objectData) {
        objectData.getClass();
        Object obj = objectData.getContents().get(zza());
        String id = objectData.getId();
        int length = String.valueOf(id).length();
        String strZza = zza();
        StringBuilder sb = new StringBuilder(strZza.length() + 19 + length + 10);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Trait data for ", strZza, " on ", id);
        sb.append(" not found");
        String string = sb.toString();
        if (obj == null) {
            zzrq.zza().zzd().zza("Requirement unmet: ".concat(string), new Object[0]);
        }
        TraitElementPayload traitElementPayload = (TraitElementPayload) obj;
        if (traitElementPayload != null) {
            try {
                return zzd(traitElementPayload);
            } catch (HomeException unused) {
                int i = zzrq.$r8$clinit;
                zzrt zzrtVarZzd = zzrq.zza().zzd();
                String strZza2 = this.zza();
                String id2 = objectData.getId();
                StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(strZza2.length() + 19, id2) + 11);
                FileInsert$$ExternalSyntheticOutline0.m(sb2, "Trait data for ", strZza2, " on ", id2);
                sb2.append(" is invalid");
                zzrtVarZzd.zza(sb2.toString(), new Object[0]);
            }
        }
        return null;
    }
}
