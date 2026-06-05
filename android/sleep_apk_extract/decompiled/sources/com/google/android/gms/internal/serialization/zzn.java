package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();
    private zzbd zza;
    private zzadz zzb;
    private zzag zzc;

    public zzn(IBinder iBinder, byte[] bArr, zzag zzagVar) {
        zzbd zzbdVarZza = zzbc.zza(iBinder);
        try {
            zzadz zzadzVar = (zzadz) zzadz.zzb().zzb(bArr);
            this.zza = zzbdVarZza;
            this.zzb = zzadzVar;
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
        if (obj instanceof zzn) {
            zzn zznVar = (zzn) obj;
            if (Objects.equal(this.zza, zznVar.zza) && Objects.equal(this.zzb, zznVar.zzb) && Objects.equal(this.zzc, zznVar.zzc)) {
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

    public final /* synthetic */ void zza(zzbd zzbdVar) {
        this.zza = zzbdVar;
    }

    public final /* synthetic */ void zzb(zzadz zzadzVar) {
        this.zzb = zzadzVar;
    }

    public final /* synthetic */ void zzc(zzag zzagVar) {
        this.zzc = zzagVar;
    }

    public /* synthetic */ zzn(byte[] bArr) {
    }
}
