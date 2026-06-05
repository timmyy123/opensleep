package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes4.dex */
public final class zzbz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzca();
    final int zza;
    public final zzae zzb;
    public final Strategy zzc;
    public final zzr zzd;

    @Deprecated
    public final String zze;

    @Deprecated
    public final String zzf;

    @Deprecated
    public final boolean zzg;
    public final zzv zzh;

    @Deprecated
    public final boolean zzi;

    @Deprecated
    public final ClientAppContext zzj;
    public final int zzk;

    public zzbz(int i, zzae zzaeVar, Strategy strategy, IBinder iBinder, String str, String str2, boolean z, IBinder iBinder2, boolean z2, ClientAppContext clientAppContext, int i2) {
        zzr zzpVar;
        this.zza = i;
        this.zzb = zzaeVar;
        this.zzc = strategy;
        zzv zztVar = null;
        if (iBinder == null) {
            zzpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzpVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzp(iBinder);
        }
        this.zzd = zzpVar;
        this.zze = str;
        this.zzf = str2;
        this.zzg = z;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            zztVar = iInterfaceQueryLocalInterface2 instanceof zzv ? (zzv) iInterfaceQueryLocalInterface2 : new zzt(iBinder2);
        }
        this.zzh = zztVar;
        this.zzi = z2;
        this.zzj = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzk = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeIBinder(parcel, 4, this.zzd.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        zzv zzvVar = this.zzh;
        SafeParcelWriter.writeIBinder(parcel, 8, zzvVar == null ? null : zzvVar.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
