package com.google.android.gms.internal.identity;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzb;

/* JADX INFO: loaded from: classes3.dex */
public final class zzu extends zza implements zzv {
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzi(zzb zzbVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzbVar);
        zzc.zzb(parcelZza, pendingIntent);
        zzc.zzc(parcelZza, iStatusCallback);
        zzc(70, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzj(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, activityTransitionRequest);
        zzc.zzb(parcelZza, pendingIntent);
        zzc.zzc(parcelZza, iStatusCallback);
        zzc(72, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzk(PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, pendingIntent);
        zzc.zzc(parcelZza, iStatusCallback);
        zzc(73, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzl(PendingIntent pendingIntent) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, pendingIntent);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzm(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, pendingIntent);
        zzc.zzb(parcelZza, sleepSegmentRequest);
        zzc.zzc(parcelZza, iStatusCallback);
        zzc(79, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzn(PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, pendingIntent);
        zzc.zzc(parcelZza, iStatusCallback);
        zzc(69, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzq(LastLocationRequest lastLocationRequest, zzee zzeeVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, lastLocationRequest);
        zzc.zzb(parcelZza, zzeeVar);
        zzc(90, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, lastLocationRequest);
        zzc.zzc(parcelZza, zzzVar);
        zzc(82, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final Location zzs() {
        Parcel parcelZzb = zzb(7, zza());
        Location location = (Location) zzc.zza(parcelZzb, Location.CREATOR);
        parcelZzb.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzv(zzei zzeiVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzeiVar);
        zzc(59, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzw(zzee zzeeVar, LocationRequest locationRequest, IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzeeVar);
        zzc.zzb(parcelZza, locationRequest);
        zzc.zzc(parcelZza, iStatusCallback);
        zzc(88, parcelZza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzx(zzee zzeeVar, IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzeeVar);
        zzc.zzc(parcelZza, iStatusCallback);
        zzc(89, parcelZza);
    }
}
