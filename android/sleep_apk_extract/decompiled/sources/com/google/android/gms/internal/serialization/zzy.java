package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    private zzbm zza;
    private zzaej zzb;
    private zzag zzc;

    public zzy(IBinder iBinder, byte[] bArr, zzag zzagVar) {
        zzbm zzbmVarZza = zzbl.zza(iBinder);
        try {
            zzaej zzaejVar = (zzaej) zzaej.zzc().zzb(bArr);
            this.zza = zzbmVarZza;
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
        if (obj instanceof zzy) {
            zzy zzyVar = (zzy) obj;
            if (Objects.equal(this.zza, zzyVar.zza) && Objects.equal(this.zzb, zzyVar.zzb) && Objects.equal(this.zzc, zzyVar.zzc)) {
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

    public final /* synthetic */ void zza(zzbm zzbmVar) {
        this.zza = zzbmVar;
    }

    public final /* synthetic */ void zzb(zzaej zzaejVar) {
        this.zzb = zzaejVar;
    }

    public final /* synthetic */ void zzc(zzag zzagVar) {
        this.zzc = zzagVar;
    }

    public /* synthetic */ zzy(byte[] bArr) {
    }
}
