package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeii extends zzcap {
    private final Context zza;
    private final zzhcg zzb;
    private final zzeiq zzc;
    private final zzcrq zzd;
    private final ArrayDeque zze;
    private final zzfqj zzf;
    private final zzcbl zzg;

    public zzeii(Context context, zzhcg zzhcgVar, zzcbl zzcblVar, zzcrq zzcrqVar, zzeiq zzeiqVar, ArrayDeque arrayDeque, zzein zzeinVar, zzfqj zzfqjVar) {
        zzbiq.zza(context);
        this.zza = context;
        this.zzb = zzhcgVar;
        this.zzg = zzcblVar;
        this.zzc = zzeiqVar;
        this.zzd = zzcrqVar;
        this.zze = arrayDeque;
        this.zzf = zzfqjVar;
    }

    private static ListenableFuture zzm(final zzcbd zzcbdVar, zzfpk zzfpkVar, final zzfdm zzfdmVar) {
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzehw
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzfdmVar.zzc().zza(com.google.android.gms.ads.internal.client.zzay.zza().zzo((Bundle) obj), zzcbdVar.zzm);
            }
        };
        return zzfpkVar.zza(zzfpe.GMS_SIGNALS, zzhbw.zza(zzcbdVar.zza)).zzc(zzhbeVar).zzb(zzehx.zza).zzi();
    }

    private static ListenableFuture zzn(ListenableFuture listenableFuture, zzfpk zzfpkVar, zzbui zzbuiVar, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        zzbty zzbtyVarZza = zzbuiVar.zza("AFMA_getAdDictionary", zzbuf.zza, zzeic.zza);
        zzfqf.zzb(listenableFuture, zzfpwVar);
        zzfor zzforVarZzi = zzfpkVar.zza(zzfpe.BUILD_URL, listenableFuture).zzc(zzbtyVarZza).zzi();
        zzfqf.zzf(zzforVarZzi, zzfqgVar, zzfpwVar);
        return zzforVarZzi;
    }

    private final void zzo(ListenableFuture listenableFuture, zzcau zzcauVar, zzcbd zzcbdVar) {
        zzhbw.zzr(zzhbw.zzj(listenableFuture, new zzhbe(this) { // from class: com.google.android.gms.internal.ads.zzeia
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzhbw.zza(zzflz.zza((InputStream) obj));
            }
        }, zzcfr.zza), new zzeht(this, zzcbdVar, zzcauVar), zzcfr.zzh);
    }

    private final synchronized void zzp() {
        int iIntValue = ((Long) zzbkx.zzb.zze()).intValue();
        while (true) {
            ArrayDeque arrayDeque = this.zze;
            if (arrayDeque.size() >= iIntValue) {
                arrayDeque.removeFirst();
            }
        }
    }

    private final synchronized void zzq(zzeid zzeidVar) {
        zzp();
        this.zze.addLast(zzeidVar);
    }

    private final synchronized zzeid zzr(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzeid zzeidVar = (zzeid) it.next();
            if (zzeidVar.zzc.equals(str)) {
                it.remove();
                return zzeidVar;
            }
        }
        return null;
    }

    public final ListenableFuture zzb(final zzcbd zzcbdVar, int i) {
        zzeid zzeidVarZzr;
        zzfor zzforVarZzi;
        zzbtz zzbtzVarZzr = com.google.android.gms.ads.internal.zzt.zzr();
        Context context = this.zza;
        zzbui zzbuiVarZza = zzbtzVarZzr.zza(context, VersionInfoParcel.forPackage(), this.zzf);
        zzfdm zzfdmVarZzy = this.zzd.zzy(zzcbdVar, i);
        zzbty zzbtyVarZza = zzbuiVarZza.zza("google.afma.response.normalize", zzeif.zzd, zzbuf.zzb);
        if (((Boolean) zzbkx.zza.zze()).booleanValue()) {
            zzeidVarZzr = zzr(zzcbdVar.zzh);
            if (zzeidVarZzr == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzcbdVar.zzj;
            zzeidVarZzr = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzeid zzeidVar = zzeidVarZzr;
        zzfpw zzfpwVarZzn = zzeidVar == null ? zzfpw.zzn(context, 9) : zzeidVar.zzd;
        zzfqg zzfqgVarZzf = zzfdmVarZzy.zzf();
        zzfqgVarZzf.zzb(zzcbdVar.zza.getStringArrayList("ad_types"));
        zzeip zzeipVar = new zzeip(zzcbdVar.zzg, zzfqgVarZzf, zzfpwVarZzn);
        zzeim zzeimVar = new zzeim(context, zzcbdVar.zzb.afmaVersion, this.zzg, i, null);
        zzfpk zzfpkVarZze = zzfdmVarZzy.zze();
        zzfpw zzfpwVarZzn2 = zzfpw.zzn(context, 11);
        if (zzeidVar == null) {
            final ListenableFuture listenableFutureZzm = zzm(zzcbdVar, zzfpkVarZze, zzfdmVarZzy);
            final ListenableFuture listenableFutureZzn = zzn(listenableFutureZzm, zzfpkVarZze, zzbuiVarZza, zzfqgVarZzf, zzfpwVarZzn);
            zzfpw zzfpwVarZzn3 = zzfpw.zzn(context, 10);
            final zzfor zzforVarZzi2 = zzfpkVarZze.zzb(zzfpe.HTTP, listenableFutureZzn, listenableFutureZzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeib
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    Bundle bundle;
                    zzcbf zzcbfVar = (zzcbf) listenableFutureZzn.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcN)).booleanValue() && (bundle = zzcbdVar.zzm) != null) {
                        bundle.putLong(zzdyu.GET_AD_DICTIONARY_SDKCORE_START.zza(), zzcbfVar.zzj());
                        bundle.putLong(zzdyu.GET_AD_DICTIONARY_SDKCORE_END.zza(), zzcbfVar.zzk());
                    }
                    return new zzeio((JSONObject) listenableFutureZzm.get(), zzcbfVar);
                }
            }).zzb(zzeipVar).zzb(zzfqf.zzc(zzfpwVarZzn3)).zzb(zzeimVar).zzi();
            zzfqf.zzd(zzforVarZzi2, zzfqgVarZzf, zzfpwVarZzn3);
            zzfqf.zzb(zzforVarZzi2, zzfpwVarZzn2);
            zzforVarZzi = zzfpkVarZze.zzb(zzfpe.PRE_PROCESS, listenableFutureZzm, listenableFutureZzn, zzforVarZzi2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzehu
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    Bundle bundle;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcN)).booleanValue() && (bundle = zzcbdVar.zzm) != null) {
                        bundle.putLong(zzdyu.HTTP_RESPONSE_READY.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
                    }
                    return new zzeif((zzeil) zzforVarZzi2.get(), (JSONObject) listenableFutureZzm.get(), (zzcbf) listenableFutureZzn.get());
                }
            }).zzc(zzbtyVarZza).zzi();
        } else {
            zzeio zzeioVar = new zzeio(zzeidVar.zzb, zzeidVar.zza);
            zzfpw zzfpwVarZzn4 = zzfpw.zzn(context, 10);
            final zzfor zzforVarZzi3 = zzfpkVarZze.zza(zzfpe.HTTP, zzhbw.zza(zzeioVar)).zzb(zzeipVar).zzb(zzfqf.zzc(zzfpwVarZzn4)).zzb(zzeimVar).zzi();
            zzfqf.zzd(zzforVarZzi3, zzfqgVarZzf, zzfpwVarZzn4);
            final ListenableFuture listenableFutureZza = zzhbw.zza(zzeidVar);
            zzfqf.zzb(zzforVarZzi3, zzfpwVarZzn2);
            zzforVarZzi = zzfpkVarZze.zzb(zzfpe.PRE_PROCESS, zzforVarZzi3, listenableFutureZza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzehv
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    zzeil zzeilVar = (zzeil) zzforVarZzi3.get();
                    ListenableFuture listenableFuture = listenableFutureZza;
                    return new zzeif(zzeilVar, ((zzeid) listenableFuture.get()).zzb, ((zzeid) listenableFuture.get()).zza);
                }
            }).zzc(zzbtyVarZza).zzi();
        }
        zzfqf.zzd(zzforVarZzi, zzfqgVarZzf, zzfpwVarZzn2);
        return zzforVarZzi;
    }

    public final ListenableFuture zzc(final zzcbd zzcbdVar, int i) {
        if (!((Boolean) zzbkx.zza.zze()).booleanValue()) {
            return zzhbw.zzc(new Exception("Split request is disabled."));
        }
        zzfmu zzfmuVar = zzcbdVar.zzi;
        if (zzfmuVar == null) {
            return zzhbw.zzc(new Exception("Pool configuration missing from request."));
        }
        if (zzfmuVar.zzc == 0 || zzfmuVar.zzd == 0) {
            return zzhbw.zzc(new Exception("Caching is disabled."));
        }
        Context context = this.zza;
        zzbui zzbuiVarZza = com.google.android.gms.ads.internal.zzt.zzr().zza(context, VersionInfoParcel.forPackage(), this.zzf);
        zzfdm zzfdmVarZzy = this.zzd.zzy(zzcbdVar, i);
        zzfpk zzfpkVarZze = zzfdmVarZzy.zze();
        final ListenableFuture listenableFutureZzm = zzm(zzcbdVar, zzfpkVarZze, zzfdmVarZzy);
        zzfqg zzfqgVarZzf = zzfdmVarZzy.zzf();
        final zzfpw zzfpwVarZzn = zzfpw.zzn(context, 9);
        final ListenableFuture listenableFutureZzn = zzn(listenableFutureZzm, zzfpkVarZze, zzbuiVarZza, zzfqgVarZzf, zzfpwVarZzn);
        return zzfpkVarZze.zzb(zzfpe.GET_URL_AND_CACHE_KEY, listenableFutureZzm, listenableFutureZzn).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzehy
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzl(listenableFutureZzn, listenableFutureZzm, zzcbdVar, zzfpwVarZzn);
            }
        }).zzi();
    }

    public final ListenableFuture zzd(String str) {
        if (((Boolean) zzbkx.zza.zze()).booleanValue()) {
            return zzr(str) == null ? zzhbw.zzc(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzhbw.zza(new zzehs(this));
        }
        return zzhbw.zzc(new Exception("Split request is disabled."));
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zze(zzcbd zzcbdVar, zzcau zzcauVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcN)).booleanValue() && (bundle = zzcbdVar.zzm) != null) {
            bundle.putLong(zzdyu.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        ListenableFuture listenableFutureZzb = zzb(zzcbdVar, Binder.getCallingUid());
        zzo(listenableFutureZzb, zzcauVar, zzcbdVar);
        if (((Boolean) zzbkq.zzi.zze()).booleanValue()) {
            final zzeiq zzeiqVar = this.zzc;
            Objects.requireNonNull(zzeiqVar);
            listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeih
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzeiqVar.zza();
                }
            }, this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzf(zzcbd zzcbdVar, zzcau zzcauVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcN)).booleanValue() && (bundle = zzcbdVar.zzm) != null) {
            bundle.putLong(zzdyu.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        zzo(zzk(zzcbdVar, Binder.getCallingUid()), zzcauVar, zzcbdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzg(zzcbd zzcbdVar, zzcau zzcauVar) {
        zzo(zzc(zzcbdVar, Binder.getCallingUid()), zzcauVar, zzcbdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzh(String str, zzcau zzcauVar) {
        zzo(zzd(str), zzcauVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzi(String str) {
        int callingUid = Binder.getCallingUid();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpA)).booleanValue()) {
            String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpB);
            if (str2.isEmpty()) {
                return;
            }
            Iterable<String> iterableZzd = zzgty.zza(zzgsx.zzc(',')).zzd(str2);
            com.google.android.gms.ads.internal.util.zze.zza("AdRequestServiceImpl: Preconnecting");
            for (String str3 : iterableZzd) {
                Context context = this.zza;
                zzeim zzeimVar = new zzeim(context, str, this.zzg, callingUid, "HEAD");
                HashMap map = new HashMap();
                map.put("User-Agent", com.google.android.gms.ads.internal.zzt.zzc().zze(context, str));
                try {
                    zzeil zzeilVarZzb = zzeimVar.zza(new zzeik(str3, 30000, map, new byte[0], "", false));
                    if (zzeilVarZzb.zza != 200) {
                        int i = zzeilVarZzb.zza;
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 32);
                        sb.append("Unexpected preconnect response: ");
                        sb.append(i);
                        throw new RemoteException(sb.toString());
                    }
                } catch (Exception e) {
                    throw new RemoteException(e.getMessage());
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzj(zzcam zzcamVar, zzcav zzcavVar) {
        if (((Boolean) zzblf.zza.zze()).booleanValue()) {
            this.zzd.zzF();
            String str = zzcamVar.zza;
            zzhbw.zzr(zzhbw.zza(null), new zzehr(this, zzcavVar, zzcamVar), zzcfr.zzh);
        } else {
            try {
                zzcavVar.zze("", zzcamVar);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
            }
        }
    }

    public final ListenableFuture zzk(final zzcbd zzcbdVar, int i) {
        zzbtz zzbtzVarZzr = com.google.android.gms.ads.internal.zzt.zzr();
        Context context = this.zza;
        zzbui zzbuiVarZza = zzbtzVarZzr.zza(context, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbld.zza.zze()).booleanValue()) {
            return zzhbw.zzc(new Exception("Signal collection disabled."));
        }
        zzfdm zzfdmVarZzy = this.zzd.zzy(zzcbdVar, i);
        final zzfcn zzfcnVarZzd = zzfdmVarZzy.zzd();
        zzbty zzbtyVarZza = zzbuiVarZza.zza("google.afma.request.getSignals", zzbuf.zza, zzbuf.zzb);
        zzfpw zzfpwVarZzn = zzfpw.zzn(context, 22);
        zzfpk zzfpkVarZze = zzfdmVarZzy.zze();
        zzfpe zzfpeVar = zzfpe.GET_SIGNALS;
        Bundle bundle = zzcbdVar.zza;
        zzfor zzforVarZzi = zzfpkVarZze.zza(zzfpeVar, zzhbw.zza(bundle)).zzb(zzfqf.zzc(zzfpwVarZzn)).zzc(new zzhbe() { // from class: com.google.android.gms.internal.ads.zzehz
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) throws JSONException {
                return zzfcnVarZzd.zza(com.google.android.gms.ads.internal.client.zzay.zza().zzo((Bundle) obj), zzcbdVar.zzm);
            }
        }).zzj(zzfpe.JS_SIGNALS).zzc(zzbtyVarZza).zzi();
        zzfqg zzfqgVarZzf = zzfdmVarZzy.zzf();
        zzfqgVarZzf.zzb(bundle.getStringArrayList("ad_types"));
        zzfqgVarZzf.zzd(bundle.getBundle("extras"));
        zzfqf.zze(zzforVarZzi, zzfqgVarZzf, zzfpwVarZzn);
        if (((Boolean) zzbkq.zzj.zze()).booleanValue()) {
            final zzeiq zzeiqVar = this.zzc;
            Objects.requireNonNull(zzeiqVar);
            zzforVarZzi.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeig
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzeiqVar.zza();
                }
            }, this.zzb);
        }
        return zzforVarZzi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ InputStream zzl(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzcbd zzcbdVar, zzfpw zzfpwVar) {
        String strZzi = ((zzcbf) listenableFuture.get()).zzi();
        zzq(new zzeid((zzcbf) listenableFuture.get(), (JSONObject) listenableFuture2.get(), zzcbdVar.zzh, strZzi, zzfpwVar));
        return new ByteArrayInputStream(strZzi.getBytes(StandardCharsets.UTF_8));
    }
}
