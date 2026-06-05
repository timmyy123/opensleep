package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbe extends zzb implements zzbf {
    public static zzbf zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoalsReadCallback");
        return iInterfaceQueryLocalInterface instanceof zzbf ? (zzbf) iInterfaceQueryLocalInterface : new zzbd(iBinder);
    }
}
