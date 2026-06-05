package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();
    private zzbg zza;
    private zzbp zzb;
    private zzaeh zzc;
    private zzag zzd;

    public zzv(IBinder iBinder, IBinder iBinder2, byte[] bArr, zzag zzagVar) {
        zzbg zzbgVarZza = zzbf.zza(iBinder);
        zzbp zzbpVarZza = zzbo.zza(iBinder2);
        try {
            zzaeh zzaehVar = (zzaeh) zzaeh.zzb().zzb(bArr);
            this.zza = zzbgVarZza;
            this.zzb = zzbpVarZza;
            this.zzc = zzaehVar;
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
        if (obj instanceof zzv) {
            zzv zzvVar = (zzv) obj;
            if (Objects.equal(this.zza, zzvVar.zza) && Objects.equal(this.zzb, zzvVar.zzb) && Objects.equal(this.zzc, zzvVar.zzc) && Objects.equal(this.zzd, zzvVar.zzd)) {
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

    public final /* synthetic */ void zzb(zzbp zzbpVar) {
        this.zzb = zzbpVar;
    }

    public final /* synthetic */ void zzc(zzaeh zzaehVar) {
        this.zzc = zzaehVar;
    }

    public final /* synthetic */ void zzd(zzag zzagVar) {
        this.zzd = zzagVar;
    }

    public /* synthetic */ zzv(byte[] bArr) {
    }
}
