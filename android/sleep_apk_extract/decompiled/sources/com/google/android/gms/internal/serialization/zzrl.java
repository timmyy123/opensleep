package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Id;
import com.google.home.Structure;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/google/home/internal/impl/StructureImpl;", "Lcom/google/home/Structure;", "", "", "name", "Lcom/google/home/Id;", "id", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "", "supportedTraits", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "objectData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/home/internal/impl/HomeManagerImpl;Ljava/util/List;Lcom/google/nest/platform/mesh/serialization/ObjectData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getId-sJHuco4", "Lcom/google/home/internal/impl/HomeManagerImpl;", "getHomeManager$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/HomeManagerImpl;", "Ljava/util/List;", "getSupportedTraits$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Ljava/util/List;", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "getObjectData$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/nest/platform/mesh/serialization/ObjectData;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzrl implements Structure {
    private final /* synthetic */ HasAutomationsImpl zza;
    private final String zzb;
    private final String zzc;
    private final zzpu zzd;
    private final List zze;
    private final ObjectData zzf;

    public /* synthetic */ zzrl(String str, String str2, zzpu zzpuVar, List list, ObjectData objectData, DefaultConstructorMarker defaultConstructorMarker) {
        str.getClass();
        str2.getClass();
        zzpuVar.getClass();
        list.getClass();
        objectData.getClass();
        this.zza = new HasAutomationsImpl(zzpuVar.zzi(), str2, null);
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzpuVar;
        this.zze = list;
        this.zzf = objectData;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof zzrl) {
            zzrl zzrlVar = (zzrl) other;
            return Intrinsics.areEqual(this.zzb, zzrlVar.zzb) && Id.m443equalsimpl0(this.zzc, zzrlVar.zzc) && Intrinsics.areEqual(this.zzf, zzrlVar.zzf);
        }
        return false;
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }

    public final int hashCode() {
        int iM444hashCodeimpl = Id.m444hashCodeimpl(this.zzc) + (this.zzb.hashCode() * 31);
        return this.zzf.hashCode() + (iM444hashCodeimpl * 31);
    }

    public final String toString() {
        String strM445toStringimpl = Id.m445toStringimpl(this.zzc);
        String str = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + strM445toStringimpl.length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Structure(name=", str, ", id=", strM445toStringimpl);
        sb.append(")");
        return sb.toString();
    }
}
