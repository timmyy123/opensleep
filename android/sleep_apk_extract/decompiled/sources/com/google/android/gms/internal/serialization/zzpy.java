package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.home.Id;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/google/home/internal/impl/MatterEndpointImpl;", "Lcom/google/home/internal/impl/Component;", "Lcom/google/home/internal/impl/MatterEndpoint;", "Lcom/google/home/internal/impl/ComponentImpl;", "node", "Lcom/google/home/Id;", "endpointId", "Lkotlin/UInt;", "component", "<init>", "(Ljava/lang/String;ILcom/google/home/internal/impl/ComponentImpl;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getNode-sJHuco4", "()Ljava/lang/String;", "Ljava/lang/String;", "getEndpointId-pVg5ArA", "()I", "I", "getComponent$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/ComponentImpl;", "Lcom/google/home/internal/impl/MatterNode;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Lcom/google/home/HomeDevice;", InAppPurchaseConstants.METHOD_TO_STRING, "", "equals", "", "other", "", "hashCode", "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzpy extends zznq implements zzmu {
    private final String zza;
    private final int zzb;
    private final zznq zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzpy(String str, int i, zznq zznqVar, DefaultConstructorMarker defaultConstructorMarker) {
        super(zznqVar);
        str.getClass();
        zznqVar.getClass();
        this.zza = str;
        this.zzb = i;
        this.zzc = zznqVar;
    }

    @Override // com.google.android.gms.internal.serialization.zznq
    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzpy)) {
            return false;
        }
        zzpy zzpyVar = (zzpy) other;
        return Id.m443equalsimpl0(this.zza, zzpyVar.zza) && this.zzb == zzpyVar.zzb && super.equals(other);
    }

    @Override // com.google.android.gms.internal.serialization.zznq
    public final int hashCode() {
        int iM444hashCodeimpl = Id.m444hashCodeimpl(this.zza) + (Id.m444hashCodeimpl(getZza()) * 31);
        int iM2391hashCodeimpl = UInt.m2391hashCodeimpl(this.zzb);
        return this.zzc.hashCode() + ((iM2391hashCodeimpl + (iM444hashCodeimpl * 31)) * 31);
    }

    @Override // com.google.android.gms.internal.serialization.zznq
    public final String toString() {
        String strM445toStringimpl = Id.m445toStringimpl(getZza());
        int length = strM445toStringimpl.length();
        String strM445toStringimpl2 = Id.m445toStringimpl(this.zza);
        int length2 = strM445toStringimpl2.length();
        String strM2392toStringimpl = UInt.m2392toStringimpl(this.zzb);
        String string = super.toString();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 25, length2, 13, String.valueOf(strM2392toStringimpl).length(), 18, string.length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "MatterEndpoint(id=", strM445toStringimpl, ", node=", strM445toStringimpl2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", endpointId=", strM2392toStringimpl, ", super.component=", string);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zzh, reason: from getter */
    public final String getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: zzi, reason: from getter */
    public final int getZzb() {
        return this.zzb;
    }
}
