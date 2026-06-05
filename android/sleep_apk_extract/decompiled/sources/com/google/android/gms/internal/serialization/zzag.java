package com.google.android.gms.internal.serialization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    private String zza;
    private Boolean zzb;
    private zzabp zzc;

    public zzag(String str, Boolean bool, byte[] bArr) {
        try {
            zzabp zzabpVar = (zzabp) zzabp.zze().zzb(bArr);
            this.zza = str;
            this.zzb = bool;
            this.zzc = zzabpVar;
        } catch (zzzv e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzag) {
            zzag zzagVar = (zzag) obj;
            if (Objects.equal(this.zza, zzagVar.zza) && Objects.equal(this.zzb, zzagVar.zzb) && Objects.equal(this.zzc, zzagVar.zzc)) {
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
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeBooleanObject(parcel, 2, this.zzb, false);
        zzabp zzabpVar = this.zzc;
        SafeParcelWriter.writeByteArray(parcel, 3, zzabpVar == null ? null : zzabpVar.toByteArray(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final /* synthetic */ void zza(String str) {
        this.zza = str;
    }

    public final /* synthetic */ void zzb(Boolean bool) {
        this.zzb = bool;
    }

    public final /* synthetic */ void zzc(zzabp zzabpVar) {
        this.zzc = zzabpVar;
    }

    public /* synthetic */ zzag(byte[] bArr) {
    }
}
