package com.google.home.matter.serialization.codec.factory;

import com.google.android.gms.internal.serialization.SerializationMetadata;
import com.google.android.gms.internal.serialization.TraitElementPayload;
import com.google.android.gms.internal.serialization.zzvk;
import com.google.android.gms.internal.serialization.zzvo;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.codec.json.JsonClusterReader;
import com.google.home.matter.serialization.codec.json.JsonClusterWriter;
import com.google.home.matter.serialization.codec.proto.ProtoClusterReader;
import com.google.home.matter.serialization.codec.proto.ProtoClusterWriter;
import com.google.home.matter.serialization.codec.proto.ProtoPayload;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/google/home/matter/serialization/codec/factory/SerializationCodecFactory;", "", "<init>", "()V", "createReader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "payload", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "strictOperationValidation", "", "createWriter", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "java.com.google.home.matter.serialization.codec.factory_factory-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SerializationCodecFactory {
    public static final SerializationCodecFactory INSTANCE = new SerializationCodecFactory();

    private SerializationCodecFactory() {
    }

    public final ClusterPayloadReader createReader(TraitElementPayload traitElementPayload, boolean z) {
        traitElementPayload.getClass();
        zzvk zzvkVarZzb = SerializationMetadata.zzb();
        zzvk zzvkVar = zzvk.zza;
        int iOrdinal = zzvkVarZzb.ordinal();
        if (iOrdinal == 0) {
            String zzd = traitElementPayload.getZzd();
            if (zzd.length() == 0) {
                zzd = "{}";
            }
            return new JsonClusterReader(zzd, null, z, 2, null);
        }
        if (iOrdinal != 1) {
            Home$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        ProtoClusterReader protoClusterReader = new ProtoClusterReader(z);
        protoClusterReader.init(new ProtoPayload(zzvo.zza(traitElementPayload.getZzd())));
        return protoClusterReader;
    }

    public final ClusterPayloadWriter createWriter(boolean strictOperationValidation) {
        zzvk zzvkVarZzb = SerializationMetadata.zzb();
        zzvk zzvkVar = zzvk.zza;
        int iOrdinal = zzvkVarZzb.ordinal();
        if (iOrdinal == 0) {
            return new JsonClusterWriter(null, strictOperationValidation, 1, null);
        }
        if (iOrdinal == 1) {
            return new ProtoClusterWriter(strictOperationValidation);
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
