package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfmu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfmu> CREATOR = new zzfmv();

    @Nullable
    public final Context zza;
    public final zzfmr zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfmr[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    private zzfmu(@Nullable Context context, zzfmr zzfmrVar, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzh = zzfmr.values();
        this.zzl = zzfms.zza();
        this.zzm = zzfmt.zza();
        this.zza = context;
        this.zzi = zzfmrVar.ordinal();
        this.zzb = zzfmrVar;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        int i4 = "oldest".equals(str2) ? 1 : (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        this.zzg = i4;
        this.zzj = i4 - 1;
        this.zzk = 0;
    }

    @Nullable
    public static zzfmu zza(zzfmr zzfmrVar, Context context) {
        if (zzfmrVar == zzfmr.Rewarded) {
            return new zzfmu(context, zzfmrVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzho)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhu)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhw)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhy), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhq), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhs));
        }
        if (zzfmrVar == zzfmr.Interstitial) {
            return new zzfmu(context, zzfmrVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhp)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhv)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhx)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhz), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhr), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzht));
        }
        if (zzfmrVar != zzfmr.AppOpen) {
            return null;
        }
        return new zzfmu(context, zzfmrVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhC)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhE)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhF)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhA), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhB), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhD));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzfmu(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfmr[] zzfmrVarArrValues = zzfmr.values();
        this.zzh = zzfmrVarArrValues;
        int[] iArrZza = zzfms.zza();
        this.zzl = iArrZza;
        int[] iArrZza2 = zzfmt.zza();
        this.zzm = iArrZza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = zzfmrVarArrValues[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = iArrZza[i5];
        this.zzk = i6;
        int i7 = iArrZza2[i6];
    }
}
