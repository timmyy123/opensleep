package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes3.dex */
public final class zbs extends com.google.android.gms.internal.p000authapi.zba implements IInterface {
    public zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zbd(zbr zbrVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p000authapi.zbc.zbc(parcelZba, zbrVar);
        com.google.android.gms.internal.p000authapi.zbc.zbb(parcelZba, googleSignInOptions);
        zbb(102, parcelZba);
    }

    public final void zbe(zbr zbrVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p000authapi.zbc.zbc(parcelZba, zbrVar);
        com.google.android.gms.internal.p000authapi.zbc.zbb(parcelZba, googleSignInOptions);
        zbb(103, parcelZba);
    }
}
