package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzenb implements zzely {
    private final Context zza;
    private final zzcwq zzb;
    private View zzc;
    private zzbvl zzd;

    public zzenb(Context context, zzcwq zzcwqVar) {
        this.zza = context;
        this.zzb = zzcwqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        try {
            zzbxb zzbxbVar = (zzbxb) zzelvVar.zzb;
            zzbxbVar.zzo(zzfkfVar.zzZ);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziZ)).booleanValue() && zzfkfVar.zzag) {
                String str = zzfkfVar.zzU;
                String string = zzfkfVar.zzv.toString();
                zzfky zzfkyVar = zzfkqVar.zza.zza;
                zzbxbVar.zzq(str, string, zzfkyVar.zzd, ObjectWrapper.wrap(this.zza), new zzena(this, zzelvVar, null), (zzbvi) zzelvVar.zzc, zzfkyVar.zzf);
                return;
            }
            String str2 = zzfkfVar.zzU;
            String string2 = zzfkfVar.zzv.toString();
            zzfky zzfkyVar2 = zzfkqVar.zza.zza;
            zzbxbVar.zzi(str2, string2, zzfkyVar2.zzd, ObjectWrapper.wrap(this.zza), new zzena(this, zzelvVar, null), (zzbvi) zzelvVar.zzc, zzfkyVar2.zzf);
        } catch (RemoteException e) {
            zzbuy$$ExternalSyntheticBUOutline0.m((Throwable) e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, final zzfkf zzfkfVar, final zzelv zzelvVar) throws zzflf {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziZ)).booleanValue() && zzfkfVar.zzag) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zZzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzflf(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) zzhbw.zzj(zzhbw.zza(null), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzemy
                            @Override // com.google.android.gms.internal.ads.zzhbe
                            public final /* synthetic */ ListenableFuture zza(Object obj) {
                                return this.zza.zzc(view, zzfkfVar, obj);
                            }
                        }, zzcfr.zzf).get();
                    } catch (InterruptedException | ExecutionException e) {
                        zzbuy$$ExternalSyntheticBUOutline0.m(e);
                        return null;
                    }
                }
            } catch (RemoteException e2) {
                zzbuy$$ExternalSyntheticBUOutline0.m((Throwable) e2);
                return null;
            }
        } else {
            view = this.zzc;
        }
        zzcvm zzcvmVarZzf = this.zzb.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzcvs(view, null, new zzcxr() { // from class: com.google.android.gms.internal.ads.zzemz
            @Override // com.google.android.gms.internal.ads.zzcxr
            public final /* synthetic */ com.google.android.gms.ads.internal.client.zzea zza() throws zzflf {
                try {
                    return ((zzbxb) zzelvVar.zzb).zzh();
                } catch (RemoteException e3) {
                    zzbuy$$ExternalSyntheticBUOutline0.m((Throwable) e3);
                    return null;
                }
            }
        }, (zzfkg) zzfkfVar.zzu.get(0)));
        zzcvmVarZzf.zzk().zza(view);
        ((zzenh) zzelvVar.zzc).zzc(zzcvmVarZzf.zzg());
        return zzcvmVarZzf.zzi();
    }

    public final /* synthetic */ ListenableFuture zzc(View view, zzfkf zzfkfVar, Object obj) {
        return zzhbw.zza(zzcxf.zza(this.zza, view, zzfkfVar));
    }

    public final /* synthetic */ void zzd(View view) {
        this.zzc = view;
    }

    public final /* synthetic */ void zze(zzbvl zzbvlVar) {
        this.zzd = zzbvlVar;
    }
}
