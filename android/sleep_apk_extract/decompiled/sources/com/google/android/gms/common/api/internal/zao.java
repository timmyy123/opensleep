package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zao implements Runnable {
    final /* synthetic */ zap zaa;
    private final zam zab;

    public zao(zap zapVar, zam zamVar) {
        Objects.requireNonNull(zapVar);
        this.zaa = zapVar;
        this.zab = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zap zapVar = this.zaa;
        if (zapVar.zaa) {
            zam zamVar = this.zab;
            ConnectionResult connectionResultZab = zamVar.zab();
            int errorCode = connectionResultZab.getErrorCode();
            GoogleApiAvailability googleApiAvailability = zapVar.zac;
            if (!googleApiAvailability.zaj(errorCode)) {
                Log.w("BaseLifecycleHelper", "Not showing dialog since ConnectionResult is not user-facing: ".concat(String.valueOf(connectionResultZab)));
                zapVar.zah(connectionResultZab, zamVar.zaa());
                return;
            }
            if (connectionResultZab.hasResolution()) {
                zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(connectionResultZab.getResolution()), zamVar.zaa(), false), 1);
                return;
            }
            if (googleApiAvailability.getErrorResolutionIntent(zapVar.getActivity(), connectionResultZab.getErrorCode(), null) != null) {
                googleApiAvailability.zab(zapVar.getActivity(), zapVar.mLifecycleFragment, connectionResultZab.getErrorCode(), 2, zapVar);
                googleApiAvailability.zae(zapVar.getActivity().getApplicationContext(), connectionResultZab, true);
            } else {
                if (connectionResultZab.getErrorCode() != 18) {
                    zapVar.zah(connectionResultZab, zamVar.zaa());
                    return;
                }
                googleApiAvailability.zag(zapVar.getActivity().getApplicationContext(), new zan(this, googleApiAvailability.zaf(zapVar.getActivity(), zapVar)));
                googleApiAvailability.zae(zapVar.getActivity().getApplicationContext(), connectionResultZab, true);
            }
        }
    }
}
