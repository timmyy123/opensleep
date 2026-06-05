package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzas extends zzb implements zzat {
    public static zzat zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
        return iInterfaceQueryLocalInterface instanceof zzat ? (zzat) iInterfaceQueryLocalInterface : new zzar(iBinder);
    }
}
