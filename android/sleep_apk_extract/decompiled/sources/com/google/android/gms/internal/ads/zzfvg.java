package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfvg implements zzfvj {
    private static final zzfvg zza = new zzfvg(new zzfvk());
    private Date zzb;
    private boolean zzc;
    private final zzfvk zzd;
    private boolean zze;

    private zzfvg(zzfvk zzfvkVar) {
        this.zzd = zzfvkVar;
    }

    public static zzfvg zza() {
        return zza;
    }

    public final Date zzb() {
        Date date = this.zzb;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public final void zzc(Context context) {
        if (this.zzc) {
            return;
        }
        zzfvk zzfvkVar = this.zzd;
        zzfvkVar.zzd(context);
        zzfvkVar.zzg(this);
        zzfvkVar.zze();
        this.zze = zzfvkVar.zza;
        this.zzc = true;
    }

    @Override // com.google.android.gms.internal.ads.zzfvj
    public final void zzd(boolean z) {
        if (!this.zze && z) {
            Date date = new Date();
            Date date2 = this.zzb;
            if (date2 == null || date.after(date2)) {
                this.zzb = date;
                if (this.zzc) {
                    Iterator it = zzfvi.zza().zzf().iterator();
                    while (it.hasNext()) {
                        ((zzfuo) it.next()).zzg().zzn(zzb());
                    }
                }
            }
        }
        this.zze = z;
    }
}
