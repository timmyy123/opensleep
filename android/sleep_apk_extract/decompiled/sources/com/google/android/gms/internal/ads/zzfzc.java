package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfzc {
    final zzfzf zza;
    final boolean zzb;

    private zzfzc(zzfzf zzfzfVar) {
        this.zza = zzfzfVar;
        this.zzb = zzfzfVar != null;
    }

    public static zzfzc zzb(Context context, String str, String str2) {
        zzfzf zzfzdVar;
        try {
            try {
                try {
                    IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderInstantiate == null) {
                        zzfzdVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfzdVar = iInterfaceQueryLocalInterface instanceof zzfzf ? (zzfzf) iInterfaceQueryLocalInterface : new zzfzd(iBinderInstantiate);
                    }
                    zzfzdVar.zzj(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfzc(zzfzdVar);
                } catch (Exception e) {
                    throw new zzfyf(e);
                }
            } catch (RemoteException | zzfyf | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfzc(new zzfzg());
            }
        } catch (Exception e2) {
            throw new zzfyf(e2);
        }
    }

    public static zzfzc zzc() {
        zzfzg zzfzgVar = new zzfzg();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfzc(zzfzgVar);
    }

    public final zzfzb zza(byte[] bArr) {
        return new zzfzb(this, bArr, null);
    }
}
