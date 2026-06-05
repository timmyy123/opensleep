package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeoj implements zzely {
    private final Context zza;
    private final zzdoc zzb;
    private zzbvr zzc;
    private final VersionInfoParcel zzd;

    public zzeoj(Context context, zzdoc zzdocVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdocVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        try {
            zzbxb zzbxbVar = (zzbxb) zzelvVar.zzb;
            zzbxbVar.zzo(zzfkfVar.zzZ);
            int i = this.zzd.clientJarVersion;
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcs)).intValue();
            String str = zzfkfVar.zzU;
            if (i < iIntValue) {
                zzbxbVar.zzn(str, zzfkfVar.zzv.toString(), zzfkqVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeoi(this, zzelvVar, null), (zzbvi) zzelvVar.zzc);
                return;
            }
            String string = zzfkfVar.zzv.toString();
            zzfky zzfkyVar = zzfkqVar.zza.zza;
            zzbxbVar.zzr(str, string, zzfkyVar.zzd, ObjectWrapper.wrap(this.zza), new zzeoi(this, zzelvVar, null), (zzbvi) zzelvVar.zzc, zzfkyVar.zzj);
        } catch (RemoteException e) {
            zzbuy$$ExternalSyntheticBUOutline0.m((Throwable) e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzeph {
        ArrayList arrayList = zzfkqVar.zza.zza.zzh;
        if (!arrayList.contains(Integer.toString(6))) {
            throw new zzeph(2, "Unified must be used for RTB.");
        }
        zzdpt zzdptVarZzaf = zzdpt.zzaf(this.zzc);
        if (!arrayList.contains(Integer.toString(zzdptVarZzaf.zzx()))) {
            throw new zzeph(1, "No corresponding native ad listener");
        }
        zzdpv zzdpvVarZze = this.zzb.zze(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdqe(zzdptVarZzaf), new zzdrx(null, null, this.zzc));
        ((zzenh) zzelvVar.zzc).zzc(zzdpvVarZze.zzg());
        return zzdpvVarZze.zzh();
    }

    public final /* synthetic */ void zzc(zzbvr zzbvrVar) {
        this.zzc = zzbvrVar;
    }
}
