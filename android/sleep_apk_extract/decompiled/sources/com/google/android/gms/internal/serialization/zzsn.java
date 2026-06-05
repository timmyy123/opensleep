package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\tJ$\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterEndpointTraitSerialization$Attributes;", "Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "Lkotlin/UInt;", "endpointId", "", "matterNodeObjectId", "<init>", "(ILjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "component1-pVg5ArA", "component1", "component2", "copy-qim9Vi0", "(ILjava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterEndpointTraitSerialization$Attributes;", "copy", "I", "getEndpointId-pVg5ArA", "Ljava/lang/String;", "getMatterNodeObjectId", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class zzsn implements GhpSerializable {
    public static final zzsm zza = new zzsm(null);
    private final int zzb;
    private final String zzc;

    public /* synthetic */ zzsn(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        str.getClass();
        this.zzb = i;
        this.zzc = str;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzsn)) {
            return false;
        }
        zzsn zzsnVar = (zzsn) other;
        return this.zzb == zzsnVar.zzb && Intrinsics.areEqual(this.zzc, zzsnVar.zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode() + (UInt.m2391hashCodeimpl(this.zzb) * 31);
    }

    public final String toString() {
        String strM2392toStringimpl = UInt.m2392toStringimpl(this.zzb);
        int length = String.valueOf(strM2392toStringimpl).length();
        String str = this.zzc;
        StringBuilder sb = new StringBuilder(length + 43 + String.valueOf(str).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Attributes(endpointId=", strM2392toStringimpl, ", matterNodeObjectId=", str);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final int getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }
}
