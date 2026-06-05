package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfth {
    private final zzfuc zzc;
    private final zzftd zzd;
    private final Context zze;
    private volatile ConnectivityManager zzf;
    private final Clock zzh;
    private AtomicInteger zzi;
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final ConcurrentMap zzb = new ConcurrentHashMap();

    public zzfth(zzfuc zzfucVar, zzftd zzftdVar, Context context, Clock clock) {
        this.zzc = zzfucVar;
        this.zzd = zzftdVar;
        this.zze = context;
        this.zzh = clock;
    }

    public static String zzh(String str, AdFormat adFormat) {
        String strName = adFormat == null ? "NULL" : adFormat.name();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(strName).length()), str, "#", strName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzi(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzy)).booleanValue()) {
            zzj(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzj(boolean z) {
        ConcurrentMap concurrentMap = this.zza;
        try {
            if (z) {
                Iterator it = concurrentMap.values().iterator();
                while (it.hasNext()) {
                    ((zzfub) it.next()).zzj();
                }
            } else {
                Iterator it2 = concurrentMap.values().iterator();
                while (it2.hasNext()) {
                    ((zzfub) it2.next()).zzi();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0015, B:8:0x0034, B:10:0x003a, B:13:0x0049, B:14:0x004f, B:16:0x0057, B:18:0x0063, B:19:0x0072, B:20:0x0076, B:21:0x007a, B:22:0x0084, B:24:0x008a, B:26:0x009c, B:27:0x00b1, B:28:0x00bb, B:30:0x00c1, B:32:0x00e2, B:35:0x00f7, B:37:0x00fd, B:34:0x00f4), top: B:43:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized List zzm(List list) {
        ArrayList arrayList;
        try {
            HashSet hashSet = new HashSet();
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.ads.internal.client.zzfp zzfpVar = (com.google.android.gms.ads.internal.client.zzfp) it.next();
                String strZzh = zzh(zzfpVar.zza, AdFormat.getAdFormat(zzfpVar.zzb));
                hashSet.add(strZzh);
                ConcurrentMap concurrentMap = this.zza;
                zzfub zzfubVar = (zzfub) concurrentMap.get(strZzh);
                if (zzfubVar == null) {
                    ConcurrentMap concurrentMap2 = this.zzb;
                    if (concurrentMap2.containsKey(strZzh)) {
                        zzfub zzfubVar2 = (zzfub) concurrentMap2.get(strZzh);
                        if (zzfubVar2.zzk(zzfpVar)) {
                            zzfubVar2.zzA(zzfpVar.zzd);
                            zzfubVar2.zzj();
                            concurrentMap.put(strZzh, zzfubVar2);
                            concurrentMap2.remove(strZzh);
                        } else {
                            arrayList.add(zzfpVar);
                        }
                    } else {
                        arrayList.add(zzfpVar);
                    }
                } else if (zzfubVar.zzk(zzfpVar)) {
                    zzfubVar.zzA(zzfpVar.zzd);
                } else {
                    this.zzb.put(strZzh, zzfubVar);
                    concurrentMap.remove(strZzh);
                    arrayList.add(zzfpVar);
                }
            }
            Iterator it2 = this.zza.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet.contains((String) entry.getKey())) {
                    this.zzb.put((String) entry.getKey(), (zzfub) entry.getValue());
                    it2.remove();
                }
            }
            Iterator it3 = this.zzb.entrySet().iterator();
            while (it3.hasNext()) {
                zzfub zzfubVar3 = (zzfub) ((Map.Entry) it3.next()).getValue();
                zzfubVar3.zzh();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzA)).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzB)).booleanValue()) {
                        zzfubVar3.zzv();
                    }
                }
                if (!zzfubVar3.zzf()) {
                    it3.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    private final synchronized void zzn(String str, zzfub zzfubVar) {
        zzfubVar.zzd();
        this.zza.put(str, zzfubVar);
    }

    private final synchronized boolean zzo(String str, AdFormat adFormat) {
        boolean z;
        try {
            Clock clock = this.zzh;
            long jCurrentTimeMillis = clock.currentTimeMillis();
            zzfub zzfubVarZzq = zzq(str, adFormat);
            int iZzt = 0;
            z = zzfubVarZzq != null && zzfubVarZzq.zzf();
            Long lValueOf = z ? Long.valueOf(clock.currentTimeMillis()) : null;
            zzftk zzftkVar = new zzftk(new zzftj(str, adFormat), null);
            zzftd zzftdVar = this.zzd;
            int iZzs = zzfubVarZzq == null ? 0 : zzfubVarZzq.zzs();
            if (zzfubVarZzq != null) {
                iZzt = zzfubVarZzq.zzt();
            }
            zzftdVar.zzd(iZzs, iZzt, jCurrentTimeMillis, lValueOf, zzfubVarZzq != null ? zzfubVarZzq.zzl() : null, zzftkVar, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    private final synchronized Object zzp(Class cls, String str, AdFormat adFormat) {
        zzftk zzftkVar = new zzftk(new zzftj(str, adFormat), null);
        zzftd zzftdVar = this.zzd;
        Clock clock = this.zzh;
        zzftdVar.zzf(clock.currentTimeMillis(), zzftkVar, -1, -1, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zzfub zzfubVarZzq = zzq(str, adFormat);
        if (zzfubVarZzq == null) {
            return null;
        }
        try {
            String strZzl = zzfubVarZzq.zzl();
            Object objZzg = zzfubVarZzq.zzg();
            Object objCast = objZzg == null ? null : cls.cast(objZzg);
            if (objCast != null) {
                zzftdVar.zzh(clock.currentTimeMillis(), zzfubVarZzq.zzs(), zzfubVarZzq.zzt(), strZzl, zzftkVar, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            return objCast;
        } catch (ClassCastException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "PreloadAdManager.pollAd");
            com.google.android.gms.ads.internal.util.zze.zzb("Unable to cast ad to the requested type:".concat(cls.getName()), e);
            return null;
        }
    }

    private final synchronized zzfub zzq(String str, AdFormat adFormat) {
        return (zzfub) this.zza.get(zzh(str, adFormat));
    }

    public final synchronized void zza(List list, com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        try {
            if (!this.zzg.getAndSet(true)) {
                if (this.zzf == null) {
                    synchronized (this) {
                        if (this.zzf == null) {
                            try {
                                this.zzf = (ConnectivityManager) this.zze.getSystemService("connectivity");
                            } catch (ClassCastException e) {
                                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get connectivity manager", e);
                            }
                        }
                    }
                }
                if (!PlatformVersion.isAtLeastO() || this.zzf == null) {
                    this.zzi = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzH)).intValue());
                } else {
                    try {
                        this.zzf.registerDefaultNetworkCallback(new zzftg(this));
                    } catch (RuntimeException e2) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to register network callback", e2);
                        this.zzi = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzH)).intValue());
                    }
                }
                com.google.android.gms.ads.internal.zzt.zzg().zzb(new zzftf(this));
            }
            List<com.google.android.gms.ads.internal.client.zzfp> listZzm = zzm(list);
            EnumMap enumMap = new EnumMap(AdFormat.class);
            for (com.google.android.gms.ads.internal.client.zzfp zzfpVar : listZzm) {
                String str = zzfpVar.zza;
                AdFormat adFormat = AdFormat.getAdFormat(zzfpVar.zzb);
                zzfub zzfubVarZza = this.zzc.zza(zzfpVar, zzcbVar);
                if (adFormat != null && zzfubVarZza != null) {
                    AtomicInteger atomicInteger = this.zzi;
                    if (atomicInteger != null) {
                        zzfubVarZza.zzn(atomicInteger.get());
                    }
                    zzftd zzftdVar = this.zzd;
                    zzfubVarZza.zzm(zzftdVar);
                    zzn(zzh(str, adFormat), zzfubVarZza);
                    enumMap.put(adFormat, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(enumMap, adFormat, 0)).intValue() + 1));
                    zzftdVar.zza(zzfpVar.zzd, this.zzh.currentTimeMillis(), new zzftk(new zzftj(str, adFormat), null), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
            }
            this.zzd.zzb(enumMap, this.zzh.currentTimeMillis(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzb(String str) {
        return zzo(str, AdFormat.REWARDED);
    }

    public final synchronized zzcci zzc(String str) {
        return (zzcci) zzp(zzcci.class, str, AdFormat.REWARDED);
    }

    public final synchronized boolean zzd(String str) {
        return zzo(str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized zzbgj zze(String str) {
        return (zzbgj) zzp(zzbgj.class, str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized boolean zzf(String str) {
        return zzo(str, AdFormat.INTERSTITIAL);
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbu zzg(String str) {
        return (com.google.android.gms.ads.internal.client.zzbu) zzp(com.google.android.gms.ads.internal.client.zzbu.class, str, AdFormat.INTERSTITIAL);
    }
}
