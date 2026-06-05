package com.google.android.gms.internal.serialization;

import com.fasterxml.jackson.core.JsonFactory;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/SerializationMetadata$PayloadType;", "", "<init>", "(Ljava/lang/String;I)V", "java.com.google.nest.platform.mesh.serialization_serialization_objects_extensions-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzvk {
    public static final zzvk zza;
    public static final zzvk zzb;
    private static final /* synthetic */ zzvk[] zzc;

    static {
        zzvk zzvkVar = new zzvk(JsonFactory.FORMAT_NAME_JSON, 0);
        zza = zzvkVar;
        zzvk zzvkVar2 = new zzvk("PROTO", 1);
        zzb = zzvkVar2;
        zzvk[] zzvkVarArr = {zzvkVar, zzvkVar2};
        zzc = zzvkVarArr;
        EnumEntriesKt.enumEntries(zzvkVarArr);
    }

    private zzvk(String str, int i) {
    }

    public static zzvk[] values() {
        return (zzvk[]) zzc.clone();
    }
}
