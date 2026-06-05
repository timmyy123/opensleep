package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdpo extends zzcxt {
    public static final zzgwm zzc = zzgwm.zzn("3010", "3008", "1005", "1009", "2011", "2007");
    private final List zzA;
    private final Executor zzd;
    private final zzdpt zze;
    private final zzdqb zzf;
    private final zzdqs zzg;
    private final zzdpy zzh;
    private final zzdqd zzi;
    private final zzimo zzj;
    private final zzimo zzk;
    private final zzimo zzl;
    private final zzimo zzm;
    private final zzimo zzn;
    private zzdrq zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private final zzcdw zzt;
    private final zzbap zzu;
    private final VersionInfoParcel zzv;
    private final Context zzw;
    private final zzdpq zzx;
    private final zzetf zzy;
    private final Map zzz;

    public zzdpo(zzcxs zzcxsVar, Executor executor, zzdpt zzdptVar, zzdqb zzdqbVar, zzdqs zzdqsVar, zzdpy zzdpyVar, zzdqd zzdqdVar, zzimo zzimoVar, zzimo zzimoVar2, zzimo zzimoVar3, zzimo zzimoVar4, zzimo zzimoVar5, zzcdw zzcdwVar, zzbap zzbapVar, VersionInfoParcel versionInfoParcel, Context context, zzdpq zzdpqVar, zzetf zzetfVar, zzbet zzbetVar) {
        super(zzcxsVar);
        this.zzd = executor;
        this.zze = zzdptVar;
        this.zzf = zzdqbVar;
        this.zzg = zzdqsVar;
        this.zzh = zzdpyVar;
        this.zzi = zzdqdVar;
        this.zzj = zzimoVar;
        this.zzk = zzimoVar2;
        this.zzl = zzimoVar3;
        this.zzm = zzimoVar4;
        this.zzn = zzimoVar5;
        this.zzt = zzcdwVar;
        this.zzu = zzbapVar;
        this.zzv = versionInfoParcel;
        this.zzw = context;
        this.zzx = zzdpqVar;
        this.zzy = zzetfVar;
        this.zzz = new HashMap();
        this.zzA = new ArrayList();
    }

    public static boolean zzI(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlZ)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point());
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        long jZzy = com.google.android.gms.ads.internal.util.zzs.zzy(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point())) {
            if (jZzy >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzma)).intValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzac, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzU(zzdrq zzdrqVar) {
        Iterator<String> itKeys;
        View view;
        zzbak zzbakVarZzb;
        try {
            if (!this.zzp) {
                this.zzo = zzdrqVar;
                this.zzg.zza(zzdrqVar);
                this.zzf.zza(zzdrqVar.zzdF(), zzdrqVar.zzj(), zzdrqVar.zzk(), zzdrqVar, zzdrqVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdz)).booleanValue() && (zzbakVarZzb = this.zzu.zzb()) != null) {
                    zzbakVarZzb.zzh(zzdrqVar.zzdF());
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcv)).booleanValue()) {
                    zzfkf zzfkfVar = this.zzb;
                    if (zzfkfVar.zzak && (itKeys = zzfkfVar.zzaj.keys()) != null) {
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            zzdrq zzdrqVar2 = this.zzo;
                            WeakReference weakReference = zzdrqVar2 == null ? null : (WeakReference) zzdrqVar2.zzi().get(next);
                            this.zzz.put(next, Boolean.FALSE);
                            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                                zzbes zzbesVar = new zzbes(this.zzw, view);
                                this.zzA.add(zzbesVar);
                                zzbesVar.zza(new zzdpd(this, next));
                            }
                        }
                    }
                }
                if (zzdrqVar.zzg() != null) {
                    zzdrqVar.zzg().zza(this.zzt);
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public final void zzV(zzdrq zzdrqVar) {
        this.zzf.zzb(zzdrqVar.zzdF(), zzdrqVar.zzi());
        if (zzdrqVar.zzdA() != null) {
            zzdrqVar.zzdA().setClickable(false);
            zzdrqVar.zzdA().removeAllViews();
        }
        if (zzdrqVar.zzg() != null) {
            zzdrqVar.zzg().zzb(this.zzt);
        }
        this.zzo = null;
    }

    private final synchronized void zzae(View view, Map map, Map map2) {
        this.zzg.zzc(this.zzo);
        this.zzf.zzw(view, map, map2, zzah());
        this.zzq = true;
    }

    private final synchronized void zzaf(View view, Map map, Map map2) {
        View viewZzag;
        if (!this.zzr && (viewZzag = zzag(map)) != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpd)).booleanValue()) {
                Rect rect = new Rect();
                if (viewZzag.getGlobalVisibleRect(rect, new Point()) && viewZzag.getHeight() == rect.height() && viewZzag.getWidth() == rect.width()) {
                    this.zzf.zzx(view, map, map2, zzah());
                    this.zzr = true;
                }
            } else if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpe)).booleanValue()) {
                zzbih zzbihVar = zzbiq.zzpf;
                if (((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).floatValue() > 0.0d) {
                    double dFloatValue = ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).floatValue();
                    if (viewZzag.getGlobalVisibleRect(new Rect(), new Point())) {
                        if (r1.height() * r1.width() >= ((double) (viewZzag.getHeight() * viewZzag.getWidth())) * (dFloatValue / 100.0d)) {
                            this.zzf.zzx(view, map, map2, zzah());
                            this.zzr = true;
                        }
                    }
                }
            } else if (zzI(viewZzag)) {
                this.zzf.zzx(view, map, map2, zzah());
                this.zzr = true;
            }
        }
    }

    private final synchronized View zzag(Map map) {
        if (map != null) {
            zzgwm zzgwmVar = zzc;
            int size = zzgwmVar.size();
            int i = 0;
            while (i < size) {
                WeakReference weakReference = (WeakReference) map.get((String) zzgwmVar.get(i));
                i++;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
            }
        }
        return null;
    }

    private final synchronized ImageView.ScaleType zzah() {
        zzdrq zzdrqVar = this.zzo;
        if (zzdrqVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper iObjectWrapperZzn = zzdrqVar.zzn();
        if (iObjectWrapperZzn != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzn);
        }
        return zzdqs.zza;
    }

    private final void zzai(String str, boolean z) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgr)).booleanValue()) {
            zzL("Google", true);
            return;
        }
        ListenableFuture listenableFutureZzX = this.zze.zzX();
        if (listenableFutureZzX == null) {
            return;
        }
        zzhbw.zzr(listenableFutureZzX, new zzdpe(this, "Google", true), this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaj, reason: merged with bridge method [inline-methods] */
    public final void zzY(View view, zzeln zzelnVar) {
        zzcku zzckuVarZzW = this.zze.zzW();
        if (!this.zzh.zzd() || zzelnVar == null || zzckuVarZzW == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzh(zzelnVar.zza(), view);
    }

    public final synchronized void zzA(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzf.zzr(zzdgVar);
    }

    public final synchronized void zzB(com.google.android.gms.ads.internal.client.zzdc zzdcVar) {
        this.zzf.zzs(zzdcVar);
    }

    public final synchronized void zzC() {
        this.zzf.zzg();
    }

    public final synchronized void zzD() {
        zzdrq zzdrqVar = this.zzo;
        if (zzdrqVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = zzdrqVar instanceof zzdqm;
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzW(z);
                }
            });
        }
    }

    public final synchronized void zzE(final View view, final int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmY)).booleanValue()) {
            zzdrq zzdrqVar = this.zzo;
            if (zzdrqVar == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z = zzdrqVar instanceof zzdqm;
                this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpk
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzX(view, z, i);
                    }
                });
            }
        }
    }

    public final synchronized boolean zzF() {
        return this.zzf.zzh();
    }

    public final synchronized int zzG() {
        return this.zzf.zzu();
    }

    public final synchronized boolean zzH() {
        return this.zzf.zzv();
    }

    public final boolean zzJ() {
        return this.zzh.zzc();
    }

    public final String zzK() {
        return this.zzh.zzf();
    }

    public final zzeln zzL(String str, boolean z) {
        boolean z2;
        String str2;
        zzelj zzeljVar;
        zzelk zzelkVar;
        zzdpy zzdpyVar = this.zzh;
        if (zzdpyVar.zzd() && !TextUtils.isEmpty(str)) {
            zzdpt zzdptVar = this.zze;
            zzcku zzckuVarZzW = zzdptVar.zzW();
            zzcku zzckuVarZzT = zzdptVar.zzT();
            if (zzckuVarZzW == null && zzckuVarZzT == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid display and video webview are null. Skipping initialization.");
                return null;
            }
            zzdpyVar.zzg();
            int iZzc = zzdpyVar.zzg().zzc();
            int i2 = iZzc - 1;
            boolean z3 = false;
            if (i2 != 0) {
                if (i2 != 1) {
                    String str3 = iZzc != 1 ? iZzc != 2 ? "UNKNOWN" : "DISPLAY" : ShareConstants.VIDEO_URL;
                    String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str3.length() + 49), "Unknown omid media type: ", str3, ". Not initializing Omid.");
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi(strM);
                    return null;
                }
                if (zzckuVarZzW == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid media type was display but there was no display webview.");
                    return null;
                }
                z2 = false;
                z3 = true;
            } else if (zzckuVarZzT != null) {
                z2 = true;
            } else {
                int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid media type was video but there was no video webview.");
            }
            if (z3) {
                str2 = null;
            } else if (z2) {
                str2 = "javascript";
                zzckuVarZzW = zzckuVarZzT;
            } else {
                zzckuVarZzW = null;
                str2 = null;
            }
            if (zzckuVarZzW == null) {
                int i6 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Webview is null in InternalNativeAd");
                return null;
            }
            if (!com.google.android.gms.ads.internal.zzt.zzu().zza(this.zzw)) {
                int i7 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to initialize omid in InternalNativeAd");
                return null;
            }
            VersionInfoParcel versionInfoParcel = this.zzv;
            int i8 = versionInfoParcel.buddyApkVersion;
            int i9 = versionInfoParcel.clientJarVersion;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(i8, 1) + String.valueOf(i9).length());
            sb.append(i8);
            sb.append(".");
            sb.append(i9);
            String string = sb.toString();
            if (z2) {
                zzeljVar = zzelj.VIDEO;
                zzelkVar = zzelk.DEFINED_BY_JAVASCRIPT;
            } else {
                zzeljVar = zzelj.NATIVE_DISPLAY;
                zzelkVar = zzdptVar.zzx() == 3 ? zzelk.UNSPECIFIED : zzelk.ONE_PIXEL;
            }
            zzeln zzelnVarZzd = com.google.android.gms.ads.internal.zzt.zzu().zzd(string, zzckuVarZzW.zzD(), "", "javascript", str2, str, zzelkVar, zzeljVar, this.zzb.zzal);
            if (zzelnVarZzd == null) {
                int i10 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to create omid session in InternalNativeAd");
                return null;
            }
            zzdptVar.zzq(zzelnVarZzd);
            zzckuVarZzW.zzak(zzelnVarZzd);
            if (z2) {
                zzfuk zzfukVarZza = zzelnVarZzd.zza();
                if (zzckuVarZzT != null) {
                    com.google.android.gms.ads.internal.zzt.zzu().zzh(zzfukVarZza, zzckuVarZzT.zzE());
                }
                this.zzs = true;
            }
            if (z) {
                com.google.android.gms.ads.internal.zzt.zzu().zze(zzelnVarZzd.zza());
                zzckuVarZzW.zze("onSdkLoaded", new ArrayMap());
            }
            return zzelnVarZzd;
        }
        return null;
    }

    public final boolean zzM() {
        return this.zzh.zzd();
    }

    public final void zzN(View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgr)).booleanValue()) {
            zzdpt zzdptVar = this.zze;
            if (zzdptVar.zzx() != 3) {
                zzcfw zzcfwVarZzY = zzdptVar.zzY();
                if (zzcfwVarZzY == null) {
                    return;
                }
                zzhbw.zzr(zzcfwVarZzY, new zzdpf(this, view), this.zzd);
                return;
            }
        }
        zzY(view, this.zze.zzZ());
    }

    public final void zzO(View view) {
        zzeln zzelnVarZzZ = this.zze.zzZ();
        if (!this.zzh.zzd() || zzelnVarZzZ == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzg(zzelnVarZzZ.zza(), view);
    }

    public final zzdpq zzP() {
        return this.zzx;
    }

    public final synchronized void zzQ(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzy.zza(zzdqVar);
    }

    public final void zzR(Bundle bundle) {
        final zzcku zzckuVarZzT = this.zze.zzT();
        if (zzckuVarZzT == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Video webview is null");
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                jSONObject.put(str, bundle.get(str));
            }
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzgwm zzgwmVar = zzdpo.zzc;
                    zzckuVarZzT.zzd("onVideoEvent", jSONObject);
                }
            });
        } catch (JSONException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error reading event signals", e);
        }
    }

    public final /* synthetic */ void zzS() {
        try {
            zzdpt zzdptVar = this.zze;
            int iZzx = zzdptVar.zzx();
            if (iZzx == 1) {
                zzbnc zzbncVarZza = this.zzi.zza();
                if (zzbncVarZza != null) {
                    zzai("Google", true);
                    zzbncVarZza.zze((zzbms) this.zzj.zzb());
                    return;
                }
                return;
            }
            if (iZzx == 2) {
                zzbmz zzbmzVarZzb = this.zzi.zzb();
                if (zzbmzVarZzb != null) {
                    zzai("Google", true);
                    zzbmzVarZzb.zze((zzbmq) this.zzk.zzb());
                    return;
                }
                return;
            }
            if (iZzx == 3) {
                zzbni zzbniVarZzf = this.zzi.zzf(zzdptVar.zzS());
                if (zzbniVarZzf != null) {
                    if (zzdptVar.zzT() != null) {
                        zzL("Google", true);
                    }
                    zzbniVarZzf.zze((zzbmv) this.zzn.zzb());
                    return;
                }
                return;
            }
            if (iZzx == 6) {
                zzbnp zzbnpVarZzc = this.zzi.zzc();
                if (zzbnpVarZzc != null) {
                    zzai("Google", true);
                    zzbnpVarZzc.zze((zzbnv) this.zzl.zzb());
                    return;
                }
                return;
            }
            if (iZzx != 7) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Wrong native template id!");
            } else {
                zzbsk zzbskVarZze = this.zzi.zze();
                if (zzbskVarZze != null) {
                    zzbskVarZze.zze((zzbse) this.zzm.zzb());
                }
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("RemoteException when notifyAdLoad is called", e);
        }
    }

    public final /* synthetic */ void zzT() {
        this.zzf.zzA();
        this.zze.zzae();
    }

    public final /* synthetic */ void zzW(boolean z) {
        zzdrq zzdrqVar = this.zzo;
        if (zzdrqVar != null) {
            this.zzf.zzf(null, zzdrqVar.zzdF(), this.zzo.zzi(), this.zzo.zzj(), z, zzah(), 0);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        }
    }

    public final /* synthetic */ void zzX(View view, boolean z, int i) {
        zzdrq zzdrqVar = this.zzo;
        if (zzdrqVar != null) {
            this.zzf.zzf(view, zzdrqVar.zzdF(), this.zzo.zzi(), this.zzo.zzj(), z, zzah(), i);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling performClickForCustomGesture()");
        }
    }

    public final /* synthetic */ zzdpt zzZ() {
        return this.zze;
    }

    public final synchronized void zza(String str) {
        this.zzf.zzd(str);
    }

    public final /* synthetic */ zzdrq zzaa() {
        return this.zzo;
    }

    public final /* synthetic */ Map zzab() {
        return this.zzz;
    }

    public final synchronized void zzb() {
        if (this.zzq) {
            return;
        }
        this.zzf.zzn();
    }

    public final synchronized void zzc(Bundle bundle) {
        this.zzf.zze(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final synchronized void zzd() {
        this.zzp = true;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzT();
            }
        });
        super.zzd();
    }

    public final synchronized boolean zze(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zZzz = this.zzf.zzz(bundle);
        this.zzq = zZzz;
        return zZzz;
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzf.zzk(bundle);
    }

    public final synchronized void zzg(final zzdrq zzdrqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzct)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdph
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzU(zzdrqVar);
                }
            });
        } else {
            zzU(zzdrqVar);
        }
    }

    public final synchronized void zzh(final zzdrq zzdrqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzct)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzV(zzdrqVar);
                }
            });
        } else {
            zzV(zzdrqVar);
        }
    }

    public final synchronized void zzi(View view, View view2, Map map, Map map2, boolean z) {
        zzcku zzckuVarZzT;
        this.zzg.zzb(this.zzo);
        this.zzf.zzc(view, view2, map, map2, z, zzah());
        if (this.zzs) {
            zzdpt zzdptVar = this.zze;
            if (zzdptVar.zzT() != null && (zzckuVarZzT = zzdptVar.zzT()) != null) {
                zzckuVarZzT.zze("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final void zzj() {
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzS();
            }
        };
        Executor executor = this.zzd;
        executor.execute(runnable);
        if (this.zze.zzx() != 7) {
            final zzdqb zzdqbVar = this.zzf;
            Objects.requireNonNull(zzdqbVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzdqbVar.zzy();
                }
            });
        }
        super.zzj();
    }

    public final synchronized void zzk(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzj(view, motionEvent, view2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: all -> 0x000a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[Catch: all -> 0x000a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzu(View view, Map map, Map map2, boolean z) {
        if (this.zzq) {
            zzaf(view, map, map2);
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcv)).booleanValue() && this.zzb.zzak) {
            Map map3 = this.zzz;
            Iterator it = map3.keySet().iterator();
            while (it.hasNext()) {
                if (!((Boolean) map3.get((String) it.next())).booleanValue()) {
                    break;
                }
            }
            if (!z) {
            }
        } else {
            if (!z) {
                zzae(view, map, map2);
                zzaf(view, map, map2);
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeM)).booleanValue() && map != null) {
                Iterator it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    View view2 = (View) ((WeakReference) ((Map.Entry) it2.next()).getValue()).get();
                    if (view2 != null && zzI(view2)) {
                        zzae(view, map, map2);
                        return;
                    }
                }
            }
        }
    }

    public final synchronized JSONObject zzv(View view, Map map, Map map2) {
        return this.zzf.zzl(view, map, map2, zzah());
    }

    public final synchronized JSONObject zzw(View view, Map map, Map map2) {
        return this.zzf.zzm(view, map, map2, zzah());
    }

    public final synchronized void zzx(View view) {
        this.zzf.zzo(view);
    }

    public final synchronized void zzy(zzbns zzbnsVar) {
        this.zzf.zzp(zzbnsVar);
    }

    public final synchronized void zzz() {
        this.zzf.zzq();
    }
}
