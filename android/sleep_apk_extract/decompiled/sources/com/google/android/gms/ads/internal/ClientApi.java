package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzch;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzcy;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzai;
import com.google.android.gms.ads.internal.overlay.zzaj;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcem;
import com.google.android.gms.internal.ads.zzcnj;
import com.google.android.gms.internal.ads.zzdqm;
import com.google.android.gms.internal.ads.zzdqo;
import com.google.android.gms.internal.ads.zzebc;
import com.google.android.gms.internal.ads.zzesd;
import com.google.android.gms.internal.ads.zzffg;
import com.google.android.gms.internal.ads.zzfgu;
import com.google.android.gms.internal.ads.zzfik;
import com.google.android.gms.internal.ads.zzfjy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ClientApi extends zzcn {
    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu zzb(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbvc zzbvcVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfgu zzfguVarZzj = zzcnj.zza(context, zzbvcVar, i).zzj();
        zzfguVarZzj.zzd(context);
        zzfguVarZzj.zzb(zzrVar);
        zzfguVarZzj.zzc(str);
        return zzfguVarZzj.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbvc zzbvcVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfik zzfikVarZzn = zzcnj.zza(context, zzbvcVar, i).zzn();
        zzfikVarZzn.zzd(context);
        zzfikVarZzn.zzb(zzrVar);
        zzfikVarZzn.zzc(str);
        return zzfikVarZzn.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbq zzd(IObjectWrapper iObjectWrapper, String str, zzbvc zzbvcVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzesd(zzcnj.zza(context, zzbvcVar, i), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbmi zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdqo((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcbs zzf(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfjy zzfjyVarZzq = zzcnj.zza(context, zzbvcVar, i).zzq();
        zzfjyVarZzq.zzc(context);
        return zzfjyVarZzq.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbzb zzg(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (adOverlayInfoParcelZza == null) {
            return new zzw(activity);
        }
        int i = adOverlayInfoParcelZza.zzk;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new zzw(activity) : new zzag(activity) : new zzac(activity, adOverlayInfoParcelZza) : new zzaj(activity) : new zzai(activity) : new zzv(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzch zzh(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i) {
        return zzcnj.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvcVar, i).zzf();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcy zzi(IObjectWrapper iObjectWrapper, int i) {
        return zzcnj.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i).zze();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    @Deprecated
    public final zzbu zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzrVar, str, new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbmn zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdqm((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcci zzl(IObjectWrapper iObjectWrapper, String str, zzbvc zzbvcVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfjy zzfjyVarZzq = zzcnj.zza(context, zzbvcVar, i).zzq();
        zzfjyVarZzq.zzc(context);
        zzfjyVarZzq.zzb(str);
        return zzfjyVarZzq.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu zzm(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbvc zzbvcVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzffg zzffgVarZzl = zzcnj.zza(context, zzbvcVar, i).zzl();
        zzffgVarZzl.zzb(str);
        zzffgVarZzl.zzc(context);
        return zzffgVarZzl.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcem zzn(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i) {
        return zzcnj.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvcVar, i).zzs();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbyu zzo(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i) {
        return zzcnj.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvcVar, i).zzu();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbqt zzp(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i, zzbqq zzbqqVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzebc zzebcVarZzA = zzcnj.zza(context, zzbvcVar, i).zzA();
        zzebcVarZzA.zzc(context);
        zzebcVarZzA.zzb(zzbqqVar);
        return zzebcVarZzA.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzdt zzq(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i) {
        return zzcnj.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvcVar, i).zzC();
    }
}
