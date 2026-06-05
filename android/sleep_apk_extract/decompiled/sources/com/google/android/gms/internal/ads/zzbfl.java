package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbfl {
    private final Object zza = new Object();
    private zzbfj zzb = null;
    private boolean zzc = false;

    public final void zza(Context context) {
        synchronized (this.zza) {
            try {
                if (!this.zzc) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Can not cast Context to Application");
                    } else {
                        if (this.zzb == null) {
                            this.zzb = new zzbfj();
                        }
                        this.zzb.zza(application, context);
                        this.zzc = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(zzbfk zzbfkVar) {
        synchronized (this.zza) {
            try {
                if (this.zzb == null) {
                    this.zzb = new zzbfj();
                }
                this.zzb.zzb(zzbfkVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(zzbfk zzbfkVar) {
        synchronized (this.zza) {
            try {
                zzbfj zzbfjVar = this.zzb;
                if (zzbfjVar == null) {
                    return;
                }
                zzbfjVar.zzc(zzbfkVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Activity zzd() {
        synchronized (this.zza) {
            try {
                zzbfj zzbfjVar = this.zzb;
                if (zzbfjVar == null) {
                    return null;
                }
                return zzbfjVar.zzd();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Context zze() {
        synchronized (this.zza) {
            try {
                zzbfj zzbfjVar = this.zzb;
                if (zzbfjVar == null) {
                    return null;
                }
                return zzbfjVar.zze();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzf() {
        synchronized (this.zza) {
            try {
                zzbfj zzbfjVar = this.zzb;
                if (zzbfjVar == null) {
                    return false;
                }
                return zzbfjVar.zzg().get();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzg(zzdwu zzdwuVar) {
        synchronized (this.zza) {
            try {
                if (this.zzb == null) {
                    this.zzb = new zzbfj();
                }
                this.zzb.zzj(zzdwuVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
