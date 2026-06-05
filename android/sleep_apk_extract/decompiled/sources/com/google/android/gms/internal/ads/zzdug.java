package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdug extends zzbmu {
    private final Context zza;
    private final zzdpt zzb;
    private zzdqs zzc;
    private zzdpo zzd;

    public zzdug(Context context, zzdpt zzdptVar, zzdqs zzdqsVar, zzdpo zzdpoVar) {
        this.zza = context;
        this.zzb = zzdptVar;
        this.zzc = zzdqsVar;
        this.zzd = zzdpoVar;
    }

    public final /* synthetic */ zzdpo zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final String zze(String str) {
        return (String) this.zzb.zzad().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final zzbme zzf(String str) {
        return (zzbme) this.zzb.zzaa().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final List zzg() {
        try {
            zzdpt zzdptVar = this.zzb;
            SimpleArrayMap simpleArrayMapZzaa = zzdptVar.zzaa();
            SimpleArrayMap simpleArrayMapZzad = zzdptVar.zzad();
            String[] strArr = new String[simpleArrayMapZzaa.getSize() + simpleArrayMapZzad.getSize()];
            int i = 0;
            for (int i2 = 0; i2 < simpleArrayMapZzaa.getSize(); i2++) {
                strArr[i] = (String) simpleArrayMapZzaa.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < simpleArrayMapZzad.getSize(); i3++) {
                strArr[i] = (String) simpleArrayMapZzad.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final String zzh() {
        return this.zzb.zzS();
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzi(String str) {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null) {
            zzdpoVar.zza(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzj() {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null) {
            zzdpoVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final com.google.android.gms.ads.internal.client.zzea zzk() {
        return this.zzb.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzl() {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null) {
            zzdpoVar.zzd();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final IObjectWrapper zzm() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzn(IObjectWrapper iObjectWrapper) {
        zzdqs zzdqsVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdqsVar = this.zzc) == null || !zzdqsVar.zzd((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzT().zzaq(new zzduf(this, "_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzo() {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null && !zzdpoVar.zzM()) {
            return false;
        }
        zzdpt zzdptVar = this.zzb;
        return zzdptVar.zzW() != null && zzdptVar.zzT() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzp() {
        zzdpt zzdptVar = this.zzb;
        zzeln zzelnVarZzZ = zzdptVar.zzZ();
        if (zzelnVarZzZ == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Trying to start OMID session before creation.");
            return false;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zze(zzelnVarZzZ.zza());
        if (zzdptVar.zzW() == null) {
            return true;
        }
        zzdptVar.zzW().zze("onSdkLoaded", new ArrayMap());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzdpo zzdpoVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof View) || this.zzb.zzZ() == null || (zzdpoVar = this.zzd) == null) {
            return;
        }
        zzdpoVar.zzN((View) objUnwrap);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzr() {
        try {
            String strZzac = this.zzb.zzac();
            if (Objects.equals(strZzac, "Google")) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(strZzac)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdpo zzdpoVar = this.zzd;
                if (zzdpoVar != null) {
                    zzdpoVar.zzL(strZzac, false);
                }
            }
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final zzbmb zzs() {
        try {
            return this.zzd.zzP().zza();
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzt(IObjectWrapper iObjectWrapper) {
        zzdqs zzdqsVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdqsVar = this.zzc) == null || !zzdqsVar.zze((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzU().zzaq(new zzduf(this, "_videoMediaView"));
        return true;
    }
}
