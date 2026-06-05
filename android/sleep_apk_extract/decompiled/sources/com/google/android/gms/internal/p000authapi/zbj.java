package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.ApiMetadata;

/* JADX INFO: loaded from: classes3.dex */
public final class zbj extends zba implements IInterface {
    public zbj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbi zbiVar, AuthorizationRequest authorizationRequest, ApiMetadata apiMetadata) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbiVar);
        zbc.zbb(parcelZba, authorizationRequest);
        zbc.zbb(parcelZba, apiMetadata);
        zbb(1, parcelZba);
    }
}
