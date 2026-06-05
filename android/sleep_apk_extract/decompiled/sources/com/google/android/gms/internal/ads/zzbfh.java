package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbfh {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final boolean zza(zzbfg zzbfgVar) {
        synchronized (this.zzb) {
            try {
                return this.zzc.contains(zzbfgVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzb(zzbfg zzbfgVar) {
        synchronized (this.zzb) {
            try {
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    zzbfg zzbfgVar2 = (zzbfg) it.next();
                    if (com.google.android.gms.ads.internal.zzt.zzh().zzo().zzc()) {
                        if (!com.google.android.gms.ads.internal.zzt.zzh().zzo().zze() && !zzbfgVar.equals(zzbfgVar2) && zzbfgVar2.zzc().equals(zzbfgVar.zzc())) {
                            it.remove();
                            return true;
                        }
                    } else if (!zzbfgVar.equals(zzbfgVar2) && zzbfgVar2.zzb().equals(zzbfgVar.zzb())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(zzbfg zzbfgVar) {
        synchronized (this.zzb) {
            try {
                List list = this.zzc;
                if (list.size() >= 10) {
                    int size = list.size();
                    StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 30);
                    sb.append("Queue is full, current size = ");
                    sb.append(size);
                    String string = sb.toString();
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
                    list.remove(0);
                }
                int i2 = this.zza;
                this.zza = i2 + 1;
                zzbfgVar.zzk(i2);
                zzbfgVar.zzh();
                list.add(zzbfgVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
