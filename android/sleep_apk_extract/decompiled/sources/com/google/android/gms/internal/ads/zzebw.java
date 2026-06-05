package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzebw {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdxc zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdzw zzl;
    private final VersionInfoParcel zzm;
    private final zzdjx zzo;
    private final zzfqj zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzcfw zze = new zzcfw();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();

    public zzebw(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdxc zzdxcVar, ScheduledExecutorService scheduledExecutorService, zzdzw zzdzwVar, VersionInfoParcel versionInfoParcel, zzdjx zzdjxVar, zzfqj zzfqjVar) {
        this.zzh = zzdxcVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdzwVar;
        this.zzm = versionInfoParcel;
        this.zzo = zzdjxVar;
        this.zzp = zzfqjVar;
        zzm("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    private final synchronized ListenableFuture zzu() {
        String strZzd = com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzd();
        if (!TextUtils.isEmpty(strZzd)) {
            return zzhbw.zza(strZzd);
        }
        final zzcfw zzcfwVar = new zzcfw();
        com.google.android.gms.ads.internal.zzt.zzh().zzo().zzk(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebp
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzg(zzcfwVar);
            }
        });
        return zzcfwVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public final void zzm(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbrp(str, z, i, str2));
    }

    public final void zza() {
        this.zzq = false;
    }

    public final void zzb(final zzbrw zzbrwVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzbrwVar.zzb(this.zza.zzd());
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
                }
            }
        }, this.zzj);
    }

    public final void zzc() {
        if (!((Boolean) zzbkw.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcy)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.zza) {
                            return;
                        }
                        this.zzl.zze();
                        this.zzo.zze();
                        zzcfw zzcfwVar = this.zze;
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzebo
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzf();
                            }
                        };
                        Executor executor = this.zzi;
                        zzcfwVar.addListener(runnable, executor);
                        this.zza = true;
                        ListenableFuture listenableFutureZzu = zzu();
                        this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebq
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzh();
                            }
                        }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcA)).longValue(), TimeUnit.SECONDS);
                        zzhbw.zzr(listenableFutureZzu, new zzebm(this), executor);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzm("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(Boolean.FALSE);
        this.zza = true;
        this.zzb = true;
    }

    public final List zzd() {
        ArrayList arrayList = new ArrayList();
        Map map = this.zzn;
        for (String str : map.keySet()) {
            zzbrp zzbrpVar = (zzbrp) map.get(str);
            arrayList.add(new zzbrp(str, zzbrpVar.zzb, zzbrpVar.zzc, zzbrpVar.zzd));
        }
        return arrayList;
    }

    public final boolean zze() {
        return this.zzb;
    }

    public final /* synthetic */ void zzf() {
        this.zzl.zzf();
        this.zzo.zzf();
        this.zzb = true;
    }

    public final /* synthetic */ void zzg(final zzcfw zzcfwVar) {
        this.zzi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzebu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                String strZzd = com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzd();
                boolean zIsEmpty = TextUtils.isEmpty(strZzd);
                zzcfw zzcfwVar2 = zzcfwVar;
                if (zIsEmpty) {
                    zzcfwVar2.zzd(new Exception());
                } else {
                    zzcfwVar2.zzc(strZzd);
                }
            }
        });
    }

    public final /* synthetic */ void zzh() {
        synchronized (this) {
            try {
                if (this.zzc) {
                    return;
                }
                zzm("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - this.zzd));
                this.zzl.zzc("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzc("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zzd(new Exception());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzi(Object obj, zzcfw zzcfwVar, String str, long j, zzfpw zzfpwVar) {
        synchronized (obj) {
            try {
                if (!zzcfwVar.isDone()) {
                    zzm(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - j));
                    this.zzl.zzc(str, "timeout");
                    this.zzo.zzc(str, "timeout");
                    zzfqj zzfqjVar = this.zzp;
                    zzfpwVar.zzk("Timeout");
                    zzfpwVar.zzd(false);
                    zzfqjVar.zzb(zzfpwVar.zzm());
                    zzcfwVar.zzc(Boolean.FALSE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ Object zzj(zzfpw zzfpwVar) {
        this.zze.zzc(Boolean.TRUE);
        zzfpwVar.zzd(true);
        this.zzp.zzb(zzfpwVar.zzm());
        return null;
    }

    public final /* synthetic */ void zzk(String str, zzbrt zzbrtVar, zzflw zzflwVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzbrtVar.zze();
                    return;
                }
                Context context = (Context) this.zzg.get();
                if (context == null) {
                    context = this.zzf;
                }
                zzflwVar.zzA(context, zzbrtVar, list);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
            }
        } catch (RemoteException e2) {
            throw new zzguh(e2);
        } catch (zzflf unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Failed to initialize adapter. ");
            sb.append(str);
            sb.append(" does not implement the initialize() method.");
            zzbrtVar.zzf(sb.toString());
        }
    }

    public final /* synthetic */ void zzl(String str) {
        final zzebw zzebwVar = this;
        Context context = zzebwVar.zzf;
        int i = 5;
        final zzfpw zzfpwVarZzn = zzfpw.zzn(context, 5);
        zzfpwVarZzn.zza();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final zzfpw zzfpwVarZzn2 = zzfpw.zzn(context, i);
                zzfpwVarZzn2.zza();
                zzfpwVarZzn2.zzi(next);
                final Object obj = new Object();
                final zzcfw zzcfwVar = new zzcfw();
                ListenableFuture listenableFutureZzi = zzhbw.zzi(zzcfwVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcz)).longValue(), TimeUnit.SECONDS, zzebwVar.zzk);
                zzebwVar.zzl.zza(next);
                zzebwVar.zzo.zza(next);
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
                listenableFutureZzi.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebr
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzi(obj, zzcfwVar, next, jElapsedRealtime, zzfpwVarZzn2);
                    }
                }, zzebwVar.zzi);
                arrayList.add(listenableFutureZzi);
                try {
                    try {
                        final zzebn zzebnVar = new zzebn(this, obj, next, jElapsedRealtime, zzfpwVarZzn2, zzcfwVar);
                        zzebwVar = this;
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                        final ArrayList arrayList2 = new ArrayList();
                        if (jSONObjectOptJSONObject != null) {
                            try {
                                JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                                int i2 = 0;
                                while (i2 < jSONArray.length()) {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                    String strOptString = jSONObject2.optString("format", "");
                                    JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (jSONObjectOptJSONObject2 != null) {
                                        Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                        while (itKeys2.hasNext()) {
                                            String next2 = itKeys2.next();
                                            bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                            jSONArray = jSONArray;
                                        }
                                    }
                                    JSONArray jSONArray2 = jSONArray;
                                    arrayList2.add(new zzbrz(strOptString, bundle));
                                    i2++;
                                    jSONArray = jSONArray2;
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        zzebwVar.zzm(next, false, "", 0);
                        try {
                            final zzflw zzflwVarZza = zzebwVar.zzh.zza(next, new JSONObject());
                            zzebwVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebt
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzk(next, zzebnVar, zzflwVarZza, arrayList2);
                                }
                            });
                        } catch (zzflf e) {
                            try {
                                String string = "Failed to create Adapter.";
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoy)).booleanValue()) {
                                    String message = e.getMessage();
                                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 26);
                                    sb.append("Failed to create Adapter.");
                                    sb.append(" ");
                                    sb.append(message);
                                    string = sb.toString();
                                }
                                zzebnVar.zzf(string);
                            } catch (RemoteException e2) {
                                int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzg("", e2);
                            }
                        }
                        i = 5;
                    } catch (JSONException e3) {
                        e = e3;
                        zzebwVar = this;
                        com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e);
                        zzebwVar.zzo.zzd("MalformedJson");
                        zzebwVar.zzl.zzd("MalformedJson");
                        zzebwVar.zze.zzd(e);
                        com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdapterInitializer.updateAdapterStatus");
                        zzfqj zzfqjVar = zzebwVar.zzp;
                        zzfpwVarZzn.zzj(e);
                        zzfpwVarZzn.zzd(false);
                        zzfqjVar.zzb(zzfpwVarZzn.zzm());
                    }
                } catch (JSONException e4) {
                    e = e4;
                    zzebwVar = this;
                }
            }
            zzhbw.zzn(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzebs
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    this.zza.zzj(zzfpwVarZzn);
                    return null;
                }
            }, zzebwVar.zzi);
        } catch (JSONException e5) {
            e = e5;
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e);
            zzebwVar.zzo.zzd("MalformedJson");
            zzebwVar.zzl.zzd("MalformedJson");
            zzebwVar.zze.zzd(e);
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdapterInitializer.updateAdapterStatus");
            zzfqj zzfqjVar2 = zzebwVar.zzp;
            zzfpwVarZzn.zzj(e);
            zzfpwVarZzn.zzd(false);
            zzfqjVar2.zzb(zzfpwVarZzn.zzm());
        }
    }

    public final /* synthetic */ void zzn(boolean z) {
        this.zzc = true;
    }

    public final /* synthetic */ long zzo() {
        return this.zzd;
    }

    public final /* synthetic */ zzcfw zzp() {
        return this.zze;
    }

    public final /* synthetic */ Executor zzq() {
        return this.zzi;
    }

    public final /* synthetic */ zzdzw zzr() {
        return this.zzl;
    }

    public final /* synthetic */ zzdjx zzs() {
        return this.zzo;
    }

    public final /* synthetic */ zzfqj zzt() {
        return this.zzp;
    }
}
