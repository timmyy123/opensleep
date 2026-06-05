package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.HasId;
import com.google.home.Id;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzpz, reason: from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\f\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\r\u001a\u00020\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/google/home/internal/impl/MatterNodeImpl;", "Lcom/google/home/internal/impl/MatterNode;", "id", "Lcom/google/home/Id;", "endpoints", "", "Lcom/google/home/internal/impl/MatterEndpoint;", "vendorId", "Lkotlin/UInt;", "productId", "nodeLabel", "", "productLabel", "softwareVersion", "softwareVersionString", "homeManager", "Lcom/google/home/internal/impl/HomeManagerImpl;", "<init>", "(Ljava/lang/String;Ljava/util/Collection;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/google/home/internal/impl/HomeManagerImpl;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-sJHuco4", "()Ljava/lang/String;", "Ljava/lang/String;", "getVendorId-pVg5ArA", "()I", "I", "getProductId-pVg5ArA", "getNodeLabel", "getProductLabel", "getSoftwareVersion-pVg5ArA", "getSoftwareVersionString", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MatterNodeImpl implements HasId {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final String id;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final Collection endpoints;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final String zzh;

    public /* synthetic */ MatterNodeImpl(String str, Collection collection, int i, int i2, String str2, String str3, int i3, String str4, zzpu zzpuVar, DefaultConstructorMarker defaultConstructorMarker) {
        str.getClass();
        collection.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        zzpuVar.getClass();
        this.id = str;
        this.endpoints = collection;
        this.zzc = i;
        this.zzd = i2;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = i3;
        this.zzh = str4;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MatterNodeImpl) {
            MatterNodeImpl matterNodeImpl = (MatterNodeImpl) other;
            return Id.m443equalsimpl0(this.id, matterNodeImpl.id) && Intrinsics.areEqual(this.endpoints, matterNodeImpl.endpoints) && this.zzc == matterNodeImpl.zzc && this.zzd == matterNodeImpl.zzd && Intrinsics.areEqual(this.zze, matterNodeImpl.zze) && Intrinsics.areEqual(this.zzf, matterNodeImpl.zzf) && this.zzg == matterNodeImpl.zzg && Intrinsics.areEqual(this.zzh, matterNodeImpl.zzh);
        }
        return false;
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final int hashCode() {
        int iHashCode = this.endpoints.hashCode() + (Id.m444hashCodeimpl(this.id) * 31);
        int iM2391hashCodeimpl = UInt.m2391hashCodeimpl(this.zzc) + (iHashCode * 31);
        int iM2391hashCodeimpl2 = UInt.m2391hashCodeimpl(this.zzd) + (iM2391hashCodeimpl * 31);
        int iHashCode2 = this.zze.hashCode() + (iM2391hashCodeimpl2 * 31);
        int iHashCode3 = this.zzf.hashCode() + (iHashCode2 * 31);
        int iM2391hashCodeimpl3 = UInt.m2391hashCodeimpl(this.zzg);
        return this.zzh.hashCode() + ((iM2391hashCodeimpl3 + (iHashCode3 * 31)) * 31);
    }

    public final String toString() {
        String strM445toStringimpl = Id.m445toStringimpl(this.id);
        int length = strM445toStringimpl.length();
        Collection collection = this.endpoints;
        int i = this.zzg;
        int i2 = this.zzd;
        String strM2392toStringimpl = UInt.m2392toStringimpl(this.zzc);
        String strM2392toStringimpl2 = UInt.m2392toStringimpl(i2);
        String strM2392toStringimpl3 = UInt.m2392toStringimpl(i);
        int length2 = String.valueOf(collection).length();
        int length3 = String.valueOf(strM2392toStringimpl).length();
        int length4 = String.valueOf(strM2392toStringimpl2).length();
        String str = this.zze;
        int length5 = String.valueOf(str).length();
        String str2 = this.zzf;
        int length6 = String.valueOf(str2).length();
        int length7 = String.valueOf(strM2392toStringimpl3).length();
        String str3 = this.zzh;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 11 + length3 + 12 + length4 + 13 + length5 + 17 + length6 + 19 + length7 + 25 + String.valueOf(str3).length() + 2);
        sb.append("MatterNodeImpl(id=");
        sb.append(strM445toStringimpl);
        sb.append(", endpoints=");
        sb.append(collection);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", vendorId=", strM2392toStringimpl, ", productId=", strM2392toStringimpl2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", nodeLabel='", str, "', productLabel='", str2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "', softwareVersion=", strM2392toStringimpl3, ", softwareVersionString='", str3);
        sb.append("')");
        return sb.toString();
    }
}
