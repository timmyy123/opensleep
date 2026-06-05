package com.google.android.gms.internal.identity;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzb;

/* JADX INFO: loaded from: classes3.dex */
public interface zzv extends IInterface {
    void zzi(zzb zzbVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzj(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzk(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzl(PendingIntent pendingIntent);

    void zzm(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback);

    void zzn(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzq(LastLocationRequest lastLocationRequest, zzee zzeeVar);

    @Deprecated
    void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar);

    @Deprecated
    Location zzs();

    @Deprecated
    void zzv(zzei zzeiVar);

    void zzw(zzee zzeeVar, LocationRequest locationRequest, IStatusCallback iStatusCallback);

    void zzx(zzee zzeeVar, IStatusCallback iStatusCallback);
}
