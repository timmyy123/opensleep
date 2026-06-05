package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzdrv implements zzdqb, zzdht {
    private final zzbvr zza;
    private final zzddj zzb;
    private final zzdfk zzc;
    private final zzdcp zzd;
    private final zzdkw zze;
    private final Context zzf;
    private final zzfkf zzg;
    private final VersionInfoParcel zzh;
    private final zzfky zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = true;
    private final zzbvn zzm;
    private final zzbvo zzn;

    public zzdrv(zzbvn zzbvnVar, zzbvo zzbvoVar, zzbvr zzbvrVar, zzddj zzddjVar, zzdfk zzdfkVar, zzdcp zzdcpVar, zzdkw zzdkwVar, Context context, zzfkf zzfkfVar, VersionInfoParcel versionInfoParcel, zzfky zzfkyVar) {
        this.zzm = zzbvnVar;
        this.zzn = zzbvoVar;
        this.zza = zzbvrVar;
        this.zzb = zzddjVar;
        this.zzc = zzdfkVar;
        this.zzd = zzdcpVar;
        this.zze = zzdkwVar;
        this.zzf = context;
        this.zzg = zzfkfVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzfkyVar;
    }

    private static final HashMap zzB(Map map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map2;
    }

    private final void zzi(View view) {
        try {
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar != null && !zzbvrVar.zzu()) {
                zzbvrVar.zzw(ObjectWrapper.wrap(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmh)).booleanValue()) {
                    this.zze.zzdu();
                    return;
                }
                return;
            }
            zzbvn zzbvnVar = this.zzm;
            if (zzbvnVar != null && !zzbvnVar.zzq()) {
                zzbvnVar.zzn(ObjectWrapper.wrap(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmh)).booleanValue()) {
                    this.zze.zzdu();
                    return;
                }
                return;
            }
            zzbvo zzbvoVar = this.zzn;
            if (zzbvoVar == null || zzbvoVar.zzo()) {
                return;
            }
            zzbvoVar.zzl(ObjectWrapper.wrap(view));
            this.zzd.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmh)).booleanValue()) {
                this.zze.zzdu();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call handleClick", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzA() {
        try {
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar != null) {
                zzbvrVar.zzC();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call destroy", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc A[Catch: JSONException -> 0x0044, RemoteException -> 0x011e, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0044, blocks: (B:47:0x00b1, B:48:0x00c6, B:50:0x00cc), top: B:70:0x00b1 }] */
    @Override // com.google.android.gms.internal.ads.zzdqb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Object obj;
        Iterator it;
        IObjectWrapper iObjectWrapperZzq;
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzg.zzaj;
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzci)).booleanValue() && jSONObject.length() != 0) {
                Map map3 = map == null ? new HashMap() : map;
                Map map4 = map2 == null ? new HashMap() : map2;
                HashMap map5 = new HashMap();
                map5.putAll(map3);
                map5.putAll(map4);
                Iterator<String> itKeys = jSONObject.keys();
                loop0: while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                    if (jSONArrayOptJSONArray != null) {
                        WeakReference weakReference = (WeakReference) map5.get(next);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcj)).booleanValue() && next.equals("3010")) {
                                zzbvr zzbvrVar = this.zza;
                                Object objUnwrap = null;
                                if (zzbvrVar != null) {
                                    try {
                                        iObjectWrapperZzq = zzbvrVar.zzq();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzbvn zzbvnVar = this.zzm;
                                    if (zzbvnVar != null) {
                                        iObjectWrapperZzq = zzbvnVar.zzw();
                                    } else {
                                        zzbvo zzbvoVar = this.zzn;
                                        iObjectWrapperZzq = zzbvoVar != null ? zzbvoVar.zzu() : null;
                                    }
                                }
                                if (iObjectWrapperZzq != null) {
                                    objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzq);
                                }
                                if (objUnwrap != null) {
                                    cls = objUnwrap.getClass();
                                    ArrayList arrayList = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbp.zza(jSONArrayOptJSONArray, arrayList);
                                    com.google.android.gms.ads.internal.zzt.zzc();
                                    ClassLoader classLoader = this.zzf.getClassLoader();
                                    it = arrayList.iterator();
                                    while (it.hasNext()) {
                                    }
                                }
                            } else {
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbp.zza(jSONArrayOptJSONArray, arrayList2);
                                    com.google.android.gms.ads.internal.zzt.zzc();
                                    ClassLoader classLoader2 = this.zzf.getClassLoader();
                                    it = arrayList2.iterator();
                                    while (it.hasNext()) {
                                        if (Class.forName((String) it.next(), false, classLoader2).isAssignableFrom(cls)) {
                                            break;
                                        }
                                    }
                                } catch (JSONException unused2) {
                                    continue;
                                }
                            }
                        }
                        z = false;
                        break;
                    }
                }
            }
            this.zzl = z;
            HashMap mapZzB = zzB(map);
            HashMap mapZzB2 = zzB(map2);
            zzbvr zzbvrVar2 = this.zza;
            if (zzbvrVar2 != null) {
                zzbvrVar2.zzx(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzB), ObjectWrapper.wrap(mapZzB2));
                return;
            }
            zzbvn zzbvnVar2 = this.zzm;
            if (zzbvnVar2 != null) {
                zzbvnVar2.zzy(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzB), ObjectWrapper.wrap(mapZzB2));
                zzbvnVar2.zzo(iObjectWrapperWrap);
                return;
            }
            zzbvo zzbvoVar2 = this.zzn;
            if (zzbvoVar2 != null) {
                zzbvoVar2.zzw(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzB), ObjectWrapper.wrap(mapZzB2));
                zzbvoVar2.zzm(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzb(View view, Map map) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar != null) {
                zzbvrVar.zzy(iObjectWrapperWrap);
                return;
            }
            zzbvn zzbvnVar = this.zzm;
            if (zzbvnVar != null) {
                zzbvnVar.zzs(iObjectWrapperWrap);
                return;
            }
            zzbvo zzbvoVar = this.zzn;
            if (zzbvoVar != null) {
                zzbvoVar.zzq(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzc(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzk && this.zzg.zzL) {
            return;
        }
        zzi(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzd(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdH() {
        try {
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar == null || !zzbvrVar.zzt()) {
                return;
            }
            zzfkf zzfkfVar = this.zzg;
            if (zzfkfVar.zze == 4 || zzfkfVar.zzaD) {
                zzbvrVar.zzv();
                this.zzb.zza();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to report impression from an adapter", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdI() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zze(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzf(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzk) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzg.zzL) {
            zzi(view2);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzg() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final boolean zzh() {
        return this.zzg.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzj(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzk(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final JSONObject zzl(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final JSONObject zzm(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzn() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzo(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzp(zzbns zzbnsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzr(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzs(com.google.android.gms.ads.internal.client.zzdc zzdcVar) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzt() {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final int zzu() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final boolean zzv() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzw(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzj) {
                this.zzj = com.google.android.gms.ads.internal.zzt.zzo().zzg(this.zzf, this.zzh.afmaVersion, this.zzg.zzC.toString(), this.zzi.zzg);
            }
            if (this.zzl) {
                zzbvr zzbvrVar = this.zza;
                if (zzbvrVar == null) {
                    zzbvn zzbvnVar = this.zzm;
                    if (zzbvnVar != null && !zzbvnVar.zzp()) {
                        zzbvnVar.zzm();
                        this.zzb.zza();
                        return;
                    }
                    zzbvo zzbvoVar = this.zzn;
                    if (zzbvoVar == null || zzbvoVar.zzn()) {
                        return;
                    }
                    zzbvoVar.zzk();
                    this.zzb.zza();
                    return;
                }
                zzfkf zzfkfVar = this.zzg;
                if (zzfkfVar.zzaD) {
                    if (zzbvrVar.zzt()) {
                        return;
                    }
                    zzbvrVar.zzv();
                    this.zzb.zza();
                    return;
                }
                if (zzbvrVar.zzt() && zzfkfVar.zze == 4) {
                    this.zzc.zza();
                } else {
                    zzbvrVar.zzv();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzx(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzy() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final boolean zzz(Bundle bundle) {
        return false;
    }
}
