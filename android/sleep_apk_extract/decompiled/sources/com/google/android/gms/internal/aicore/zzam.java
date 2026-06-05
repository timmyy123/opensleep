package com.google.android.gms.internal.aicore;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzam extends AbstractSafeParcelable implements SafeParcelable {
    public static final Parcelable.Creator<zzam> CREATOR = new zzan();
    private final ImmutableList zza;
    private final float zzb;
    private final int zzc;
    private final ImmutableList zzd;
    private final int zze;
    private final int zzf;
    private final zzab zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final String zzl;
    private final Bundle zzm;
    private final zzv zzn;

    public zzam(List list, float f, int i, List list2, int i2, int i3, IBinder iBinder, boolean z, int i4, IBinder iBinder2, int i5, int i6, String str, Bundle bundle) {
        zzab zzzVar;
        this.zza = ImmutableList.copyOf((Collection) list);
        this.zzb = f;
        this.zzc = i;
        this.zzd = ImmutableList.copyOf((Collection) list2);
        this.zze = i2;
        this.zzf = i3;
        zzv zzvVar = null;
        if (iBinder == null) {
            zzzVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.aicore.aidl.ILLMStreamingCallback");
            zzzVar = iInterfaceQueryLocalInterface instanceof zzab ? (zzab) iInterfaceQueryLocalInterface : new zzz(iBinder);
        }
        this.zzg = zzzVar;
        this.zzh = z;
        this.zzi = i4;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.apps.aicore.aidl.IImageEmbeddingCallback");
            zzvVar = iInterfaceQueryLocalInterface2 instanceof zzv ? (zzv) iInterfaceQueryLocalInterface2 : new zzv(iBinder2);
        }
        this.zzn = zzvVar;
        this.zzj = i5;
        this.zzk = i6;
        this.zzl = str;
        this.zzm = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ImmutableList immutableList = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, immutableList, false);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        zzab zzabVar = this.zzg;
        SafeParcelWriter.writeIBinder(parcel, 7, zzabVar == null ? null : zzabVar.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        zzv zzvVar = this.zzn;
        SafeParcelWriter.writeIBinder(parcel, 10, zzvVar != null ? zzvVar.asBinder() : null, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
