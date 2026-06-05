package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.HasId;
import com.google.home.Id;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u00060\bj\u0002`\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/google/home/internal/impl/GhpCoreMetadataImpl;", "", "Lcom/google/home/Id;", "id", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;", "authState", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudConnectionStateTraitSerialization$ConnectionState;", "connectionState", "", "Lcom/google/nest/platform/mesh/serialization/ObjectId;", "oAuthTraitObjectId", "<init>", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudConnectionStateTraitSerialization$ConnectionState;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getId-sJHuco4", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;", "getAuthState$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudSessionTraitSerialization$AuthState;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudConnectionStateTraitSerialization$ConnectionState;", "getConnectionState$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/CloudConnectionStateTraitSerialization$ConnectionState;", "getOAuthTraitObjectId$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzox implements HasId {
    private final String zza;
    private final zzsf zzb;
    private final zzsb zzc;
    private final String zzd;

    public /* synthetic */ zzox(String str, zzsf zzsfVar, zzsb zzsbVar, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        str.getClass();
        zzsfVar.getClass();
        str2.getClass();
        this.zza = str;
        this.zzb = zzsfVar;
        this.zzc = zzsbVar;
        this.zzd = str2;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzox)) {
            return false;
        }
        zzox zzoxVar = (zzox) other;
        return Id.m443equalsimpl0(this.zza, zzoxVar.zza) && this.zzb == zzoxVar.zzb && this.zzc == zzoxVar.zzc && Intrinsics.areEqual(this.zzd, zzoxVar.zzd);
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: from getter */
    public final String getZzb() {
        return this.zza;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + (Id.m444hashCodeimpl(this.zza) * 31);
        zzsb zzsbVar = this.zzc;
        return this.zzd.hashCode() + zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, zzsbVar != null ? zzsbVar.hashCode() : 0, 31);
    }

    public final String toString() {
        String strName;
        String strM445toStringimpl = Id.m445toStringimpl(this.zza);
        String strName2 = this.zzb.name();
        zzsb zzsbVar = this.zzc;
        if (zzsbVar == null || (strName = zzsbVar.name()) == null) {
            strName = "null";
        }
        String str = this.zzd;
        StringBuilder sb = new StringBuilder(strName.length() + zzba$$ExternalSyntheticOutline0.m(strM445toStringimpl.length() + 34, 17, String.valueOf(strName2)) + 20 + String.valueOf(str).length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, "GhpCoreMetadataImpl(id=", strM445toStringimpl, ",authState=", strName2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ",connectionState=", strName, ",oAuthTraitObjectId=", str);
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final zzsf getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final zzsb getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final String getZzd() {
        return this.zzd;
    }
}
