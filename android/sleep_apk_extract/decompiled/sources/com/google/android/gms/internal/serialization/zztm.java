package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000bJ.\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010\u000b¨\u0006)"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$SupportedTraitInfo;", "", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/LocalConnectivityStateTraitSerialization$State;", "connectivityState", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$LocalityType;", "dataSourceLocality", "", "owningDeviceId", "<init>", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/LocalConnectivityStateTraitSerialization$State;Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$LocalityType;Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;", "writer", "", "writeTo", "(Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;)V", "Lcom/google/protos/home/internal/traits/SupportedTraitInfo;", "toProto", "()Lcom/google/protos/home/internal/traits/SupportedTraitInfo;", "component1", "()Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/LocalConnectivityStateTraitSerialization$State;", "component2", "()Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$LocalityType;", "component3", "copy", "(Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/LocalConnectivityStateTraitSerialization$State;Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$LocalityType;Ljava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$SupportedTraitInfo;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/LocalConnectivityStateTraitSerialization$State;", "getConnectivityState", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$LocalityType;", "getDataSourceLocality", "Ljava/lang/String;", "getOwningDeviceId", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class zztm {
    private final zzsk zza;
    private final zztk zzb;
    private final String zzc;

    public zztm(zzsk zzskVar, zztk zztkVar, String str) {
        zzskVar.getClass();
        zztkVar.getClass();
        str.getClass();
        this.zza = zzskVar;
        this.zzb = zztkVar;
        this.zzc = str;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zztm)) {
            return false;
        }
        zztm zztmVar = (zztm) other;
        return this.zza == zztmVar.zza && this.zzb == zztmVar.zzb && Intrinsics.areEqual(this.zzc, zztmVar.zzc);
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + (this.zza.hashCode() * 31);
        return this.zzc.hashCode() + (iHashCode * 31);
    }

    public final String toString() {
        zzsk zzskVar = this.zza;
        int length = String.valueOf(zzskVar).length();
        zztk zztkVar = this.zzb;
        int length2 = String.valueOf(zztkVar).length();
        String str = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 58, length2, 17, String.valueOf(str).length()) + 1);
        sb.append("SupportedTraitInfo(connectivityState=");
        sb.append(zzskVar);
        sb.append(", dataSourceLocality=");
        sb.append(zztkVar);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", owningDeviceId=", str, ")");
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final zzsk getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final zztk getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }
}
