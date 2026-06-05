package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.L;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzt<T> {
    private final Context zza;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private T zzh;
    private final Object zzb = new Object();
    private boolean zzf = false;
    private boolean zzg = false;

    public zzt(Context context, String str, String str2) {
        this.zza = context;
        this.zzc = str;
        String strValueOf = String.valueOf(str2);
        this.zzd = strValueOf.length() != 0 ? "com.google.android.gms.vision.dynamite.".concat(strValueOf) : new String("com.google.android.gms.vision.dynamite.");
        this.zze = str2;
    }

    public abstract T zza(DynamiteModule dynamiteModule, Context context);

    public abstract void zza();

    public final boolean zzb() {
        return zzd() != null;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            if (this.zzh == null) {
                return;
            }
            try {
                zza();
            } catch (RemoteException e) {
                Log.e(this.zzc, "Could not finalize native handle", e);
            }
        }
    }

    public final T zzd() {
        DynamiteModule dynamiteModuleLoad;
        synchronized (this.zzb) {
            T t = this.zzh;
            if (t != null) {
                return t;
            }
            try {
                dynamiteModuleLoad = DynamiteModule.load(this.zza, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, this.zzd);
            } catch (DynamiteModule.LoadingException unused) {
                String str = "com.google.android.gms.vision." + this.zze;
                L.d("Cannot load thick client module, fall back to load optional module %s", str);
                try {
                    dynamiteModuleLoad = DynamiteModule.load(this.zza, DynamiteModule.PREFER_REMOTE, str);
                } catch (DynamiteModule.LoadingException e) {
                    L.e(e, "Error loading optional module %s", str);
                    if (!this.zzf) {
                        L.d("Broadcasting download intent for dependency %s", this.zze);
                        String str2 = this.zze;
                        Intent intent = new Intent();
                        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
                        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str2);
                        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
                        this.zza.sendBroadcast(intent);
                        this.zzf = true;
                    }
                    dynamiteModuleLoad = null;
                }
            }
            if (dynamiteModuleLoad != null) {
                try {
                    this.zzh = zza(dynamiteModuleLoad, this.zza);
                } catch (RemoteException | DynamiteModule.LoadingException e2) {
                    Log.e(this.zzc, "Error creating remote native handle", e2);
                }
            }
            boolean z = this.zzg;
            if (!z && this.zzh == null) {
                Log.w(this.zzc, "Native handle not yet available. Reverting to no-op handle.");
                this.zzg = true;
            } else if (z && this.zzh != null) {
                Log.w(this.zzc, "Native handle is now available.");
            }
            return this.zzh;
        }
    }
}
