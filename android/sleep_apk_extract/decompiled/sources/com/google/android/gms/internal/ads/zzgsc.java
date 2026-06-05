package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgsc implements ServiceConnection {
    final /* synthetic */ zzgsi zza;

    public /* synthetic */ zzgsc(zzgsi zzgsiVar, byte[] bArr) {
        Objects.requireNonNull(zzgsiVar);
        this.zza = zzgsiVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        zzgsi zzgsiVar = this.zza;
        zzgsiVar.zzi().zza("LmdServiceConnectionManager.onServiceConnected(%s)", componentName);
        zzgsiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgsb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                IInterface iInterfaceZzm;
                zzgqm zzgqmVarZzb = zzgql.zzb(iBinder);
                zzgsc zzgscVar = this.zza;
                zzgsi zzgsiVar2 = zzgscVar.zza;
                zzgsiVar2.zzn(zzgqmVarZzb);
                zzgsiVar2.zzi().zza("linkToDeath", new Object[0]);
                try {
                    iInterfaceZzm = zzgsiVar2.zzm();
                } catch (RemoteException e) {
                    zzgscVar.zza.zzi().zzd(e, "linkToDeath failed", new Object[0]);
                }
                if (iInterfaceZzm == null) {
                    throw null;
                }
                iInterfaceZzm.asBinder().linkToDeath(zzgsiVar2.zzl(), 0);
                zzgsi zzgsiVar3 = zzgscVar.zza;
                zzgsiVar3.zzk(false);
                synchronized (zzgsiVar3.zzj()) {
                    try {
                        Iterator it = zzgsiVar3.zzj().iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        zzgsiVar3.zzj().clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzgsi zzgsiVar = this.zza;
        zzgsiVar.zzi().zza("LmdServiceConnectionManager.onServiceDisconnected(%s)", componentName);
        zzgsiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgsa
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzgsi zzgsiVar2 = this.zza.zza;
                zzgsiVar2.zzi().zza("unlinkToDeath", new Object[0]);
                IInterface iInterfaceZzm = zzgsiVar2.zzm();
                iInterfaceZzm.getClass();
                iInterfaceZzm.asBinder().unlinkToDeath(zzgsiVar2.zzl(), 0);
                zzgsiVar2.zzn(null);
                zzgsiVar2.zzk(false);
            }
        });
    }
}
