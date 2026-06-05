package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001:\u0001*B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\rJ\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\rJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0010J\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\rJL\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b'\u0010\rR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b(\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b)\u0010\r¨\u0006+"}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterNodeTraitSerialization$Attributes;", "Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "Lkotlin/UInt;", "vendorId", "productId", "", "nodeLabel", "productLabel", "softwareVersion", "softwareVersionString", "<init>", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "component1-pVg5ArA", "component1", "component2-pVg5ArA", "component2", "component3", "component4", "component5-pVg5ArA", "component5", "component6", "copy-D3vF_XI", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/MatterNodeTraitSerialization$Attributes;", "copy", "I", "getVendorId-pVg5ArA", "getProductId-pVg5ArA", "Ljava/lang/String;", "getNodeLabel", "getProductLabel", "getSoftwareVersion-pVg5ArA", "getSoftwareVersionString", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class zzsu implements GhpSerializable {
    public static final zzst zza = new zzst(null);
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final String zze;
    private final int zzf;
    private final String zzg;

    public /* synthetic */ zzsu(int i, int i2, String str, String str2, int i3, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str2;
        this.zzf = i3;
        this.zzg = str3;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzsu)) {
            return false;
        }
        zzsu zzsuVar = (zzsu) other;
        return this.zzb == zzsuVar.zzb && this.zzc == zzsuVar.zzc && Intrinsics.areEqual(this.zzd, zzsuVar.zzd) && Intrinsics.areEqual(this.zze, zzsuVar.zze) && this.zzf == zzsuVar.zzf && Intrinsics.areEqual(this.zzg, zzsuVar.zzg);
    }

    public final int hashCode() {
        int iM2391hashCodeimpl = UInt.m2391hashCodeimpl(this.zzc) + (UInt.m2391hashCodeimpl(this.zzb) * 31);
        int iHashCode = this.zzd.hashCode() + (iM2391hashCodeimpl * 31);
        int iHashCode2 = this.zze.hashCode() + (iHashCode * 31);
        int iM2391hashCodeimpl2 = UInt.m2391hashCodeimpl(this.zzf);
        return this.zzg.hashCode() + ((iM2391hashCodeimpl2 + (iHashCode2 * 31)) * 31);
    }

    public final String toString() {
        int i = this.zzf;
        int i2 = this.zzc;
        String strM2392toStringimpl = UInt.m2392toStringimpl(this.zzb);
        String strM2392toStringimpl2 = UInt.m2392toStringimpl(i2);
        String strM2392toStringimpl3 = UInt.m2392toStringimpl(i);
        int length = String.valueOf(strM2392toStringimpl).length();
        int length2 = String.valueOf(strM2392toStringimpl2).length();
        String str = this.zzd;
        int length3 = String.valueOf(str).length();
        String str2 = this.zze;
        int length4 = String.valueOf(str2).length();
        int length5 = String.valueOf(strM2392toStringimpl3).length();
        String str3 = this.zzg;
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 12 + length3 + 15 + length4 + 18 + length5 + 24 + String.valueOf(str3).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Attributes(vendorId=", strM2392toStringimpl, ", productId=", strM2392toStringimpl2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", nodeLabel=", str, ", productLabel=", str2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", softwareVersion=", strM2392toStringimpl3, ", softwareVersionString=", str3);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final int getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final int getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final String getZzd() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: zzd, reason: from getter */
    public final String getZze() {
        return this.zze;
    }

    /* JADX INFO: renamed from: zze, reason: from getter */
    public final int getZzf() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: zzf, reason: from getter */
    public final String getZzg() {
        return this.zzg;
    }
}
