package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new zzas();
    private zzbs zza;
    private zzaey zzb;
    private zzag zzc;

    public zzar(IBinder iBinder, byte[] bArr, zzag zzagVar) {
        zzbs zzbsVarZza = zzbr.zza(iBinder);
        try {
            zzaey zzaeyVar = (zzaey) zzaey.zzc().zzb(bArr);
            this.zza = zzbsVarZza;
            this.zzb = zzaeyVar;
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
        if (obj instanceof zzar) {
            zzar zzarVar = (zzar) obj;
            if (Objects.equal(this.zza, zzarVar.zza) && Objects.equal(this.zzb, zzarVar.zzb) && Objects.equal(this.zzc, zzarVar.zzc)) {
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
}
