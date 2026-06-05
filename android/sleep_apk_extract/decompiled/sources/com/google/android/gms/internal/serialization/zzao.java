package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    private IStatusCallback zza;
    private zzbp zzb;
    private zzaeh zzc;
    private zzag zzd;

    public zzao(IBinder iBinder, IBinder iBinder2, byte[] bArr, zzag zzagVar) {
        IStatusCallback iStatusCallbackAsInterface = IStatusCallback.Stub.asInterface(iBinder);
        zzbp zzbpVarZza = zzbo.zza(iBinder2);
        try {
            zzaeh zzaehVar = (zzaeh) zzaeh.zzb().zzb(bArr);
            this.zza = iStatusCallbackAsInterface;
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
        if (obj instanceof zzao) {
            zzao zzaoVar = (zzao) obj;
            if (Objects.equal(this.zza, zzaoVar.zza) && Objects.equal(this.zzb, zzaoVar.zzb) && Objects.equal(this.zzc, zzaoVar.zzc) && Objects.equal(this.zzd, zzaoVar.zzd)) {
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
        IStatusCallback iStatusCallback = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, iStatusCallback == null ? null : iStatusCallback.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc.toByteArray(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final /* synthetic */ void zza(IStatusCallback iStatusCallback) {
        this.zza = iStatusCallback;
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

    public /* synthetic */ zzao(byte[] bArr) {
    }
}
