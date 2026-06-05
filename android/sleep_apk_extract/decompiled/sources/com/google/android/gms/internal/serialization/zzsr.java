package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$B'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018J4\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b#\u0010\u0018¨\u0006%"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterMappingTraitSerialization$Attributes;", "Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "", "Lkotlin/UInt;", "endpointIds", "Lkotlin/ULong;", "fabricId", "nodeId", "<init>", "(Ljava/util/Collection;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "component1", "()Ljava/util/Collection;", "component2-s-VKNKU", "()J", "component2", "component3-s-VKNKU", "component3", "copy-ZFynlJw", "(Ljava/util/Collection;JJ)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterMappingTraitSerialization$Attributes;", "copy", "Ljava/util/Collection;", "getEndpointIds", "J", "getFabricId-s-VKNKU", "getNodeId-s-VKNKU", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class zzsr implements GhpSerializable {
    public static final zzsq zza = new zzsq(null);
    private final Collection zzb;
    private final long zzc;
    private final long zzd;

    public /* synthetic */ zzsr(Collection collection, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        collection.getClass();
        this.zzb = collection;
        this.zzc = j;
        this.zzd = j2;
        if (Long.compare(j2 ^ Long.MIN_VALUE, ULong.m2411constructorimpl(0L) ^ Long.MIN_VALUE) <= 0 || Long.compare(j2 ^ Long.MIN_VALUE, 9223371968135299071L) > 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Check failed.");
            throw null;
        }
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzsr)) {
            return false;
        }
        zzsr zzsrVar = (zzsr) other;
        return Intrinsics.areEqual(this.zzb, zzsrVar.zzb) && this.zzc == zzsrVar.zzc && this.zzd == zzsrVar.zzd;
    }

    public final int hashCode() {
        int iM2413hashCodeimpl = ULong.m2413hashCodeimpl(this.zzc) + (this.zzb.hashCode() * 31);
        return ULong.m2413hashCodeimpl(this.zzd) + (iM2413hashCodeimpl * 31);
    }

    public final String toString() {
        long j = this.zzd;
        String strM2414toStringimpl = ULong.m2414toStringimpl(this.zzc);
        String strM2414toStringimpl2 = ULong.m2414toStringimpl(j);
        Collection collection = this.zzb;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(collection).length(), 34, String.valueOf(strM2414toStringimpl).length(), 9, String.valueOf(strM2414toStringimpl2).length()) + 1);
        sb.append("Attributes(endpointIds=");
        sb.append(collection);
        sb.append(", fabricId=");
        sb.append(strM2414toStringimpl);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", nodeId=", strM2414toStringimpl2, ")");
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final long getZzd() {
        return this.zzd;
    }
}
