package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    private zzbg zza;
    private zzax zzb;
    private zzaef zzc;
    private zzag zzd;

    public zzs(IBinder iBinder, IBinder iBinder2, byte[] bArr, zzag zzagVar) {
        zzbg zzbgVarZza = zzbf.zza(iBinder);
        zzax zzaxVarZza = zzaw.zza(iBinder2);
        try {
            zzaef zzaefVar = (zzaef) zzaef.zzb().zzb(bArr);
            this.zza = zzbgVarZza;
            this.zzb = zzaxVarZza;
            this.zzc = zzaefVar;
            this.zzd = zzagVar;
        } catch (zzzv e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzs) {
            zzs zzsVar = (zzs) obj;
            if (Objects.equal(this.zza, zzsVar.zza) && Objects.equal(this.zzb, zzsVar.zzb) && Objects.equal(this.zzc, zzsVar.zzc) && Objects.equal(this.zzd, zzsVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc.toByteArray(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final /* synthetic */ void zza(zzbg zzbgVar) {
        this.zza = zzbgVar;
    }

    public final /* synthetic */ void zzb(zzax zzaxVar) {
        this.zzb = zzaxVar;
    }

    public final /* synthetic */ void zzc(zzaef zzaefVar) {
        this.zzc = zzaefVar;
    }

    public final /* synthetic */ void zzd(zzag zzagVar) {
        this.zzd = zzagVar;
    }

    public /* synthetic */ zzs(byte[] bArr) {
    }
}
