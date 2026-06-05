package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\fJ\u0010\u0010\u0018\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JB\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\b\u0010\u0019¨\u0006#"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/DeviceTraitSerialization$Attributes;", "Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "", "name", "roomObjectId", "structureObjectId", "descriptiveType", "", "isSelfDevice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "component1", "component2", "component3", "component4", "component5", "()Z", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/DeviceTraitSerialization$Attributes;", "Ljava/lang/String;", "getName", "getRoomObjectId", "getStructureObjectId", "getDescriptiveType", "Z", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class zzsi implements GhpSerializable {
    public static final zzsh zza = new zzsh(null);
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final boolean zzf;

    public zzsi(String str, String str2, String str3, String str4, boolean z) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = z;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzsi)) {
            return false;
        }
        zzsi zzsiVar = (zzsi) other;
        return Intrinsics.areEqual(this.zzb, zzsiVar.zzb) && Intrinsics.areEqual(this.zzc, zzsiVar.zzc) && Intrinsics.areEqual(this.zzd, zzsiVar.zzd) && Intrinsics.areEqual(this.zze, zzsiVar.zze) && this.zzf == zzsiVar.zzf;
    }

    public final int hashCode() {
        int iHashCode = this.zzc.hashCode() + (this.zzb.hashCode() * 31);
        int iHashCode2 = this.zzd.hashCode() + (iHashCode * 31);
        int iHashCode3 = this.zze.hashCode();
        return Boolean.hashCode(this.zzf) + ((iHashCode3 + (iHashCode2 * 31)) * 31);
    }

    public final String toString() {
        String str = this.zzb;
        int length = String.valueOf(str).length();
        String str2 = this.zzc;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzd;
        int length3 = String.valueOf(str3).length();
        String str4 = this.zze;
        int length4 = String.valueOf(str4).length();
        boolean z = this.zzf;
        StringBuilder sb = new StringBuilder(length + 31 + length2 + 20 + length3 + 18 + length4 + 15 + String.valueOf(z).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Attributes(name=", str, ", roomObjectId=", str2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", structureObjectId=", str3, ", descriptiveType=", str4);
        sb.append(", isSelfDevice=");
        sb.append(z);
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

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final String getZzd() {
        return this.zzd;
    }
}
