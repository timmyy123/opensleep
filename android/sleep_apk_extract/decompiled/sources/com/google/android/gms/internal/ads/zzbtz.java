package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbtz {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbui zzc;
    private zzbui zzd;

    private static final Context zzd(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static final boolean zze(Context context) {
        if (((Boolean) zzbkw.zzc.zze()).booleanValue()) {
            return false;
        }
        return com.google.android.gms.ads.internal.util.zzs.zzk(zzd(context)).zza().toLowerCase(Locale.ROOT).equals("ru");
    }

    public final zzbui zza(Context context, VersionInfoParcel versionInfoParcel, zzfqj zzfqjVar) {
        zzbui zzbuiVar;
        String str;
        synchronized (this.zzb) {
            try {
                if (this.zzd == null) {
                    Context contextZzd = zzd(context);
                    if (zze(context)) {
                        str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzc);
                    } else {
                        str = (String) zzbla.zza.zze();
                    }
                    this.zzd = new zzbui(contextZzd, versionInfoParcel, str, zzfqjVar);
                }
                zzbuiVar = this.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbuiVar;
    }

    public final zzbui zzb(Context context, VersionInfoParcel versionInfoParcel, zzfqj zzfqjVar) {
        zzbui zzbuiVar;
        String str;
        synchronized (this.zza) {
            try {
                if (this.zzc == null) {
                    if (zze(context)) {
                        str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzc);
                    } else if (((Boolean) zzbkw.zzg.zze()).booleanValue()) {
                        str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zza);
                    } else {
                        str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzb);
                    }
                    this.zzc = new zzbui(zzd(context), versionInfoParcel, str, zzfqjVar);
                }
                zzbuiVar = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbuiVar;
    }

    public final void zzc() {
        synchronized (this.zza) {
            try {
                zzbui zzbuiVar = this.zzc;
                if (zzbuiVar != null) {
                    zzbuiVar.zzc();
                    this.zzc = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
