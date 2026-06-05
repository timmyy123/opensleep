package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\bJ$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/RoomTraitSerialization$Attributes;", "Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "", "name", "structureObjectId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/RoomTraitSerialization$Attributes;", "Ljava/lang/String;", "getName", "getStructureObjectId", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class zzta implements GhpSerializable {
    public static final zzsz zza = new zzsz(null);
    private final String zzb;
    private final String zzc;

    public zzta(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.zzb = str;
        this.zzc = str2;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzta)) {
            return false;
        }
        zzta zztaVar = (zzta) other;
        return Intrinsics.areEqual(this.zzb, zztaVar.zzb) && Intrinsics.areEqual(this.zzc, zztaVar.zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode() + (this.zzb.hashCode() * 31);
    }

    public final String toString() {
        String str = this.zzb;
        int length = String.valueOf(str).length();
        String str2 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 36 + String.valueOf(str2).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Attributes(name=", str, ", structureObjectId=", str2);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }
}
