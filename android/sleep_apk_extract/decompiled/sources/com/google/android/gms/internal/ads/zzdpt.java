package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdpt {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzea zzb;
    private zzblx zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzew zzg;
    private Bundle zzh;
    private zzcku zzi;
    private zzcku zzj;
    private zzcku zzk;
    private zzeln zzl;
    private ListenableFuture zzm;
    private zzcfw zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbme zzs;
    private zzbme zzt;
    private String zzu;
    private float zzx;
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.EMPTY_LIST;

    public static zzdpt zzaf(zzbvr zzbvrVar) {
        try {
            return zzak(zzam(zzbvrVar.zzn(), zzbvrVar), zzbvrVar.zzo(), (View) zzal(zzbvrVar.zzp()), zzbvrVar.zze(), zzbvrVar.zzf(), zzbvrVar.zzg(), zzbvrVar.zzs(), zzbvrVar.zzi(), (View) zzal(zzbvrVar.zzq()), zzbvrVar.zzr(), zzbvrVar.zzl(), zzbvrVar.zzm(), zzbvrVar.zzk(), zzbvrVar.zzh(), zzbvrVar.zzj(), zzbvrVar.zzz());
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzdpt zzag(zzbvo zzbvoVar) {
        try {
            zzdps zzdpsVarZzam = zzam(zzbvoVar.zzs(), null);
            zzblx zzblxVarZzt = zzbvoVar.zzt();
            View view = (View) zzal(zzbvoVar.zzr());
            String strZze = zzbvoVar.zze();
            List listZzf = zzbvoVar.zzf();
            String strZzg = zzbvoVar.zzg();
            Bundle bundleZzp = zzbvoVar.zzp();
            String strZzi = zzbvoVar.zzi();
            View view2 = (View) zzal(zzbvoVar.zzu());
            IObjectWrapper iObjectWrapperZzv = zzbvoVar.zzv();
            String strZzj = zzbvoVar.zzj();
            zzbme zzbmeVarZzh = zzbvoVar.zzh();
            zzdpt zzdptVar = new zzdpt();
            zzdptVar.zza = 1;
            zzdptVar.zzb = zzdpsVarZzam;
            zzdptVar.zzc = zzblxVarZzt;
            zzdptVar.zzd = view;
            zzdptVar.zzs("headline", strZze);
            zzdptVar.zze = listZzf;
            zzdptVar.zzs(SDKConstants.PARAM_A2U_BODY, strZzg);
            zzdptVar.zzh = bundleZzp;
            zzdptVar.zzs("call_to_action", strZzi);
            zzdptVar.zzo = view2;
            zzdptVar.zzq = iObjectWrapperZzv;
            zzdptVar.zzs("advertiser", strZzj);
            zzdptVar.zzt = zzbmeVarZzh;
            return zzdptVar;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdpt zzah(zzbvn zzbvnVar) {
        zzdpt zzdptVar;
        try {
            zzdps zzdpsVarZzam = zzam(zzbvnVar.zzt(), null);
            zzblx zzblxVarZzv = zzbvnVar.zzv();
            View view = (View) zzal(zzbvnVar.zzu());
            String strZze = zzbvnVar.zze();
            List listZzf = zzbvnVar.zzf();
            String strZzg = zzbvnVar.zzg();
            Bundle bundleZzr = zzbvnVar.zzr();
            String strZzi = zzbvnVar.zzi();
            View view2 = (View) zzal(zzbvnVar.zzw());
            IObjectWrapper iObjectWrapperZzx = zzbvnVar.zzx();
            String strZzk = zzbvnVar.zzk();
            String strZzl = zzbvnVar.zzl();
            double dZzj = zzbvnVar.zzj();
            zzbme zzbmeVarZzh = zzbvnVar.zzh();
            zzdptVar = null;
            try {
                zzdpt zzdptVar2 = new zzdpt();
                zzdptVar2.zza = 2;
                zzdptVar2.zzb = zzdpsVarZzam;
                zzdptVar2.zzc = zzblxVarZzv;
                zzdptVar2.zzd = view;
                zzdptVar2.zzs("headline", strZze);
                zzdptVar2.zze = listZzf;
                zzdptVar2.zzs(SDKConstants.PARAM_A2U_BODY, strZzg);
                zzdptVar2.zzh = bundleZzr;
                zzdptVar2.zzs("call_to_action", strZzi);
                zzdptVar2.zzo = view2;
                zzdptVar2.zzq = iObjectWrapperZzx;
                zzdptVar2.zzs("store", strZzk);
                zzdptVar2.zzs("price", strZzl);
                zzdptVar2.zzr = dZzj;
                zzdptVar2.zzs = zzbmeVarZzh;
                return zzdptVar2;
            } catch (RemoteException e) {
                e = e;
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad from app install ad mapper", e);
                return zzdptVar;
            }
        } catch (RemoteException e2) {
            e = e2;
            zzdptVar = null;
        }
    }

    public static zzdpt zzai(zzbvn zzbvnVar) {
        try {
            return zzak(zzam(zzbvnVar.zzt(), null), zzbvnVar.zzv(), (View) zzal(zzbvnVar.zzu()), zzbvnVar.zze(), zzbvnVar.zzf(), zzbvnVar.zzg(), zzbvnVar.zzr(), zzbvnVar.zzi(), (View) zzal(zzbvnVar.zzw()), zzbvnVar.zzx(), zzbvnVar.zzk(), zzbvnVar.zzl(), zzbvnVar.zzj(), zzbvnVar.zzh(), null, 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdpt zzaj(zzbvo zzbvoVar) {
        try {
            return zzak(zzam(zzbvoVar.zzs(), null), zzbvoVar.zzt(), (View) zzal(zzbvoVar.zzr()), zzbvoVar.zze(), zzbvoVar.zzf(), zzbvoVar.zzg(), zzbvoVar.zzp(), zzbvoVar.zzi(), (View) zzal(zzbvoVar.zzu()), zzbvoVar.zzv(), null, null, -1.0d, zzbvoVar.zzh(), zzbvoVar.zzj(), 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdpt zzak(com.google.android.gms.ads.internal.client.zzea zzeaVar, zzblx zzblxVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbme zzbmeVar, String str6, float f) {
        zzdpt zzdptVar = new zzdpt();
        zzdptVar.zza = 6;
        zzdptVar.zzb = zzeaVar;
        zzdptVar.zzc = zzblxVar;
        zzdptVar.zzd = view;
        zzdptVar.zzs("headline", str);
        zzdptVar.zze = list;
        zzdptVar.zzs(SDKConstants.PARAM_A2U_BODY, str2);
        zzdptVar.zzh = bundle;
        zzdptVar.zzs("call_to_action", str3);
        zzdptVar.zzo = view2;
        zzdptVar.zzq = iObjectWrapper;
        zzdptVar.zzs("store", str4);
        zzdptVar.zzs("price", str5);
        zzdptVar.zzr = d;
        zzdptVar.zzs = zzbmeVar;
        zzdptVar.zzs("advertiser", str6);
        zzdptVar.zzu(f);
        return zzdptVar;
    }

    private static Object zzal(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    private static zzdps zzam(com.google.android.gms.ads.internal.client.zzea zzeaVar, zzbvr zzbvrVar) {
        if (zzeaVar == null) {
            return null;
        }
        return new zzdps(zzeaVar, zzbvrVar);
    }

    public final synchronized View zzA() {
        return this.zzd;
    }

    public final synchronized String zzB() {
        return zzw("headline");
    }

    public final synchronized List zzC() {
        return this.zze;
    }

    public final zzbme zzD() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbmd.zzh((IBinder) obj);
        }
        return null;
    }

    public final synchronized List zzE() {
        return this.zzf;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzew zzF() {
        return this.zzg;
    }

    public final synchronized String zzG() {
        return zzw(SDKConstants.PARAM_A2U_BODY);
    }

    public final synchronized Bundle zzH() {
        try {
            if (this.zzh == null) {
                this.zzh = new Bundle();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzh;
    }

    public final synchronized String zzI() {
        return zzw("call_to_action");
    }

    public final synchronized View zzJ() {
        return this.zzo;
    }

    public final synchronized View zzK() {
        return this.zzp;
    }

    public final synchronized IObjectWrapper zzL() {
        return this.zzq;
    }

    public final synchronized String zzM() {
        return zzw("store");
    }

    public final synchronized String zzN() {
        return zzw("price");
    }

    public final synchronized double zzO() {
        return this.zzr;
    }

    public final synchronized zzbme zzP() {
        return this.zzs;
    }

    public final synchronized String zzQ() {
        return zzw("advertiser");
    }

    public final synchronized zzbme zzR() {
        return this.zzt;
    }

    public final synchronized String zzS() {
        return this.zzu;
    }

    public final synchronized zzcku zzT() {
        return this.zzi;
    }

    public final synchronized zzcku zzU() {
        return this.zzj;
    }

    public final synchronized boolean zzV() {
        return this.zzj != null;
    }

    public final synchronized zzcku zzW() {
        return this.zzk;
    }

    public final synchronized ListenableFuture zzX() {
        return this.zzm;
    }

    public final synchronized zzcfw zzY() {
        return this.zzn;
    }

    public final synchronized zzeln zzZ() {
        return this.zzl;
    }

    public final synchronized void zza(int i) {
        this.zza = i;
    }

    public final synchronized SimpleArrayMap zzaa() {
        return this.zzv;
    }

    public final synchronized float zzab() {
        return this.zzx;
    }

    public final synchronized String zzac() {
        return this.zzy;
    }

    public final synchronized SimpleArrayMap zzad() {
        return this.zzw;
    }

    public final synchronized void zzae() {
        try {
            zzcku zzckuVar = this.zzi;
            if (zzckuVar != null) {
                zzckuVar.destroy();
                this.zzi = null;
            }
            zzcku zzckuVar2 = this.zzj;
            if (zzckuVar2 != null) {
                zzckuVar2.destroy();
                this.zzj = null;
            }
            zzcku zzckuVar3 = this.zzk;
            if (zzckuVar3 != null) {
                zzckuVar3.destroy();
                this.zzk = null;
            }
            ListenableFuture listenableFuture = this.zzm;
            if (listenableFuture != null) {
                listenableFuture.cancel(false);
                this.zzm = null;
            }
            zzcfw zzcfwVar = this.zzn;
            if (zzcfwVar != null) {
                zzcfwVar.cancel(false);
                this.zzn = null;
            }
            this.zzl = null;
            this.zzv.clear();
            this.zzw.clear();
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzh = null;
            this.zzo = null;
            this.zzp = null;
            this.zzq = null;
            this.zzs = null;
            this.zzt = null;
            this.zzu = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zzb = zzeaVar;
    }

    public final synchronized void zzc(zzblx zzblxVar) {
        this.zzc = zzblxVar;
    }

    public final synchronized void zzd(List list) {
        this.zze = list;
    }

    public final synchronized void zze(List list) {
        this.zzf = list;
    }

    public final synchronized void zzf(com.google.android.gms.ads.internal.client.zzew zzewVar) {
        this.zzg = zzewVar;
    }

    public final synchronized void zzg(View view) {
        this.zzo = view;
    }

    public final synchronized void zzh(View view) {
        this.zzp = view;
    }

    public final synchronized void zzi(double d) {
        this.zzr = d;
    }

    public final synchronized void zzj(zzbme zzbmeVar) {
        this.zzs = zzbmeVar;
    }

    public final synchronized void zzk(zzbme zzbmeVar) {
        this.zzt = zzbmeVar;
    }

    public final synchronized void zzl(String str) {
        this.zzu = str;
    }

    public final synchronized void zzm(zzcku zzckuVar) {
        this.zzi = zzckuVar;
    }

    public final synchronized void zzn(zzcku zzckuVar) {
        this.zzj = zzckuVar;
    }

    public final synchronized void zzo(zzcku zzckuVar) {
        this.zzk = zzckuVar;
    }

    public final synchronized void zzp(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzq(zzeln zzelnVar) {
        this.zzl = zzelnVar;
    }

    public final synchronized void zzr(zzcfw zzcfwVar) {
        this.zzn = zzcfwVar;
    }

    public final synchronized void zzs(String str, String str2) {
        SimpleArrayMap simpleArrayMap = this.zzw;
        if (str2 == null) {
            simpleArrayMap.remove(str);
        } else {
            simpleArrayMap.put(str, str2);
        }
    }

    public final synchronized void zzt(String str, zzblp zzblpVar) {
        SimpleArrayMap simpleArrayMap = this.zzv;
        if (zzblpVar == null) {
            simpleArrayMap.remove(str);
        } else {
            simpleArrayMap.put(str, zzblpVar);
        }
    }

    public final synchronized void zzu(float f) {
        this.zzx = f;
    }

    public final synchronized void zzv(String str) {
        this.zzy = str;
    }

    public final synchronized String zzw(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized int zzx() {
        return this.zza;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzea zzy() {
        return this.zzb;
    }

    public final synchronized zzblx zzz() {
        return this.zzc;
    }
}
