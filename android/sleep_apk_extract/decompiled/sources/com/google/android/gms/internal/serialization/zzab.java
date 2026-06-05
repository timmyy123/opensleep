package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();
    private zzbj zza;
    private zzaej zzb;
    private zzag zzc;

    public zzab(IBinder iBinder, byte[] bArr, zzag zzagVar) {
        zzbj zzbjVarZza = zzbi.zza(iBinder);
        try {
            zzaej zzaejVar = (zzaej) zzaej.zzc().zzb(bArr);
            this.zza = zzbjVarZza;
            this.zzb = zzaejVar;
            this.zzc = zzagVar;
        } catch (zzzv e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzab) {
            zzab zzabVar = (zzab) obj;
            if (Objects.equal(this.zza, zzabVar.zza) && Objects.equal(this.zzb, zzabVar.zzb) && Objects.equal(this.zzc, zzabVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb.toByteArray(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final /* synthetic */ void zza(zzbj zzbjVar) {
        this.zza = zzbjVar;
    }

    public final /* synthetic */ void zzb(zzaej zzaejVar) {
        this.zzb = zzaejVar;
    }

    public final /* synthetic */ void zzc(zzag zzagVar) {
        this.zzc = zzagVar;
    }

    public /* synthetic */ zzab(byte[] bArr) {
    }
}
