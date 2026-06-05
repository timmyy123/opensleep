package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.HasHomeDevices;
import com.google.home.HasId;
import com.google.home.Id;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/internal/impl/RoomImpl;", "", "", "name", "Lcom/google/home/Id;", "id", "structureId", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/home/internal/impl/HomeManagerImpl;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "Ljava/lang/String;", "getId-sJHuco4", "Lcom/google/home/internal/impl/HomeManagerImpl;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzqv implements HasId, HasHomeDevices {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzpu zzd;

    public /* synthetic */ zzqv(String str, String str2, String str3, zzpu zzpuVar, DefaultConstructorMarker defaultConstructorMarker) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        zzpuVar.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzpuVar;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof zzqv) {
            zzqv zzqvVar = (zzqv) other;
            return Intrinsics.areEqual(this.zza, zzqvVar.zza) && Id.m443equalsimpl0(this.zzb, zzqvVar.zzb) && Id.m443equalsimpl0(this.zzc, zzqvVar.zzc);
        }
        return false;
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: from getter */
    public final String getId() {
        return this.zzb;
    }

    public final int hashCode() {
        int iM444hashCodeimpl = Id.m444hashCodeimpl(this.zzb) + (this.zza.hashCode() * 31);
        return Id.m444hashCodeimpl(this.zzc) + (iM444hashCodeimpl * 31);
    }

    public final String toString() {
        String str = this.zzc;
        String strM445toStringimpl = Id.m445toStringimpl(this.zzb);
        String strM445toStringimpl2 = Id.m445toStringimpl(str);
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(str2).length(), 17, strM445toStringimpl.length(), 14, strM445toStringimpl2.length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Room(name = ", str2, ", id=", strM445toStringimpl);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", structureId=", strM445toStringimpl2, ")");
    }
}
