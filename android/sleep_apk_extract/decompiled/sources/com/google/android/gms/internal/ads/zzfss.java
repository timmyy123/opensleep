package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfss {
    private final Map zza;
    private final zzfuc zzb;
    private final zzftd zzc;
    private final Context zzd;
    private volatile ConnectivityManager zze;
    private final AtomicBoolean zzf = new AtomicBoolean(false);
    private final Clock zzg;
    private AtomicInteger zzh;
    private final zzfsn zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;

    public zzfss(zzfuc zzfucVar, zzftd zzftdVar, Context context, Clock clock, zzfsn zzfsnVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        HashMap map = new HashMap();
        this.zza = map;
        map.put(AdFormat.APP_OPEN_AD, new HashMap());
        map.put(AdFormat.INTERSTITIAL, new HashMap());
        map.put(AdFormat.REWARDED, new HashMap());
        this.zzb = zzfucVar;
        this.zzc = zzftdVar;
        this.zzd = context;
        this.zzg = clock;
        this.zzi = zzfsnVar;
        this.zzj = zzgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzl(boolean z) {
        ArrayList arrayList = new ArrayList();
        Map map = this.zza;
        synchronized (map) {
            try {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    arrayList.addAll(((Map) it.next()).values());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zzfub zzfubVar = (zzfub) arrayList.get(i);
            if (z) {
                zzfubVar.zzj();
            } else {
                zzfubVar.zzi();
            }
        }
    }

    private final Object zzn(Class cls, AdFormat adFormat, String str) {
        zzftd zzftdVar = this.zzc;
        Clock clock = this.zzg;
        zzftdVar.zze(clock.currentTimeMillis(), "2");
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return null;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                if (zzfubVar != null && adFormat.equals(zzfubVar.zzq())) {
                    zzftj zzftjVar = new zzftj(zzfubVar.zzr(), zzfubVar.zzq());
                    zzftjVar.zza(str);
                    zzftk zzftkVar = new zzftk(zzftjVar, null);
                    zzftdVar.zzf(clock.currentTimeMillis(), zzftkVar, zzfubVar.zzs(), zzfubVar.zzt(), "2");
                    try {
                        String strZzl = zzfubVar.zzl();
                        Object objZzg = zzfubVar.zzg();
                        Object objCast = objZzg == null ? null : cls.cast(objZzg);
                        if (objCast == null) {
                            return objCast;
                        }
                        zzftdVar.zzh(clock.currentTimeMillis(), zzfubVar.zzs(), zzfubVar.zzt(), strZzl, zzftkVar, "2");
                        return objCast;
                    } catch (ClassCastException e) {
                        com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "PreloadAdManager.pollAd");
                        com.google.android.gms.ads.internal.util.zze.zzb("Unable to cast ad to the requested type:".concat(cls.getName()), e);
                    }
                }
                return null;
            } finally {
            }
        }
    }

    private final boolean zzo(AdFormat adFormat) {
        Map map = this.zza;
        int size = map.containsKey(adFormat) ? ((Map) map.get(adFormat)).size() : 0;
        int iOrdinal = adFormat.ordinal();
        return size < (iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 5 ? 0 : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfv)).intValue(), 1) : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfu)).intValue(), 1) : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzft)).intValue(), 1));
    }

    public final boolean zza(String str, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        int iZzT;
        if (!this.zzf.getAndSet(true)) {
            if (this.zze == null) {
                synchronized (this) {
                    if (this.zze == null) {
                        try {
                            this.zze = (ConnectivityManager) this.zzd.getSystemService("connectivity");
                        } catch (ClassCastException e) {
                            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get connectivity manager", e);
                        }
                    }
                }
            }
            if (!PlatformVersion.isAtLeastO() || this.zze == null) {
                this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzH)).intValue());
            } else {
                try {
                    this.zze.registerDefaultNetworkCallback(new zzfsq(this));
                } catch (RuntimeException e2) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to register network callback", e2);
                    this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzH)).intValue());
                }
            }
            com.google.android.gms.ads.internal.zzt.zzg().zzb(new zzfsr(this));
        }
        AdFormat adFormat = AdFormat.getAdFormat(zzfpVar.zzb);
        if (adFormat == null) {
            return false;
        }
        Map map = this.zza;
        synchronized (map) {
            try {
                if (map.containsKey(adFormat)) {
                    if (!((Map) map.get(adFormat)).containsKey(str)) {
                        if (zzo(adFormat)) {
                            if (zzfpVar.zze) {
                                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzO)).booleanValue() && (iZzT = this.zzj.zzT()) > 0) {
                                    zzfpVar = zzfpVar.zza(iZzT);
                                }
                            }
                            zzfub zzfubVarZzb = this.zzb.zzb(str, zzfpVar, zzceVar);
                            if (zzfubVarZzb != null) {
                                AtomicInteger atomicInteger = this.zzh;
                                if (atomicInteger != null) {
                                    zzfubVarZzb.zzn(atomicInteger.get());
                                }
                                zzftd zzftdVar = this.zzc;
                                zzfubVarZzb.zzm(zzftdVar);
                                synchronized (map) {
                                    if (!((Map) map.get(adFormat)).containsKey(str) && zzo(adFormat)) {
                                        ((Map) map.get(adFormat)).put(str, zzfubVarZzb);
                                        zzfsn zzfsnVar = this.zzi;
                                        if (zzfsnVar != null) {
                                            zzfsnVar.zze(str, adFormat, zzfubVarZzb);
                                        } else {
                                            zzfubVarZzb.zzd();
                                        }
                                        zzftj zzftjVar = new zzftj(zzfpVar.zza, adFormat);
                                        zzftjVar.zza(str);
                                        zzftdVar.zza(zzfpVar.zzd, this.zzg.currentTimeMillis(), new zzftk(zzftjVar, null), "2");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            } finally {
            }
        }
        return false;
    }

    public final boolean zzb(AdFormat adFormat, String str) {
        zzftk zzftkVar;
        Clock clock = this.zzg;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return false;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                String strZzl = zzfubVar == null ? null : zzfubVar.zzl();
                boolean z = strZzl != null && adFormat.equals(zzfubVar.zzq());
                Long lValueOf = z ? Long.valueOf(clock.currentTimeMillis()) : null;
                if (zzfubVar == null) {
                    zzftkVar = null;
                } else {
                    zzftj zzftjVar = new zzftj(zzfubVar.zzr(), adFormat);
                    zzftjVar.zza(str);
                    zzftkVar = new zzftk(zzftjVar, null);
                }
                this.zzc.zzd(zzfubVar == null ? 0 : zzfubVar.zzs(), zzfubVar != null ? zzfubVar.zzt() : 0, jCurrentTimeMillis, lValueOf, strZzl, zzftkVar, "2");
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzcci zzc(String str) {
        return (zzcci) zzn(zzcci.class, AdFormat.REWARDED, str);
    }

    public final zzbgj zzd(String str) {
        return (zzbgj) zzn(zzbgj.class, AdFormat.APP_OPEN_AD, str);
    }

    public final com.google.android.gms.ads.internal.client.zzbu zze(String str) {
        return (com.google.android.gms.ads.internal.client.zzbu) zzn(com.google.android.gms.ads.internal.client.zzbu.class, AdFormat.INTERSTITIAL, str);
    }

    public final com.google.android.gms.ads.internal.client.zzfp zzf(AdFormat adFormat, String str) {
        Map map = this.zza;
        synchronized (map) {
            try {
                if (map.containsKey(adFormat)) {
                    zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                    this.zzc.zzo(this.zzg.currentTimeMillis(), str, zzfubVar == null ? null : zzfubVar.zzr(), adFormat, zzfubVar == null ? -1 : zzfubVar.zzs(), zzfubVar != null ? zzfubVar.zzt() : -1);
                    if (zzfubVar != null) {
                        return zzfubVar.zzo();
                    }
                }
            } finally {
            }
        }
        return null;
    }

    public final int zzg(AdFormat adFormat, String str) {
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return 0;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                int iZzt = zzfubVar != null ? zzfubVar.zzt() : 0;
                this.zzc.zzp(iZzt, this.zzg.currentTimeMillis(), str, zzfubVar == null ? null : zzfubVar.zzr(), adFormat, zzfubVar == null ? -1 : zzfubVar.zzs());
                return iZzt;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map zzh(int i) {
        HashMap map = new HashMap();
        Map map2 = this.zza;
        AdFormat adFormat = AdFormat.getAdFormat(i);
        synchronized (map2) {
            if (adFormat != null) {
                try {
                    if (map2.containsKey(adFormat)) {
                        for (zzfub zzfubVar : ((Map) map2.get(adFormat)).values()) {
                            map.put(zzfubVar.zzp(), zzfubVar.zzo());
                        }
                        this.zzc.zzn(adFormat, this.zzg.currentTimeMillis(), map.size());
                        return map;
                    }
                } finally {
                }
            }
            return map;
        }
    }

    public final boolean zzi(AdFormat adFormat, String str) {
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return false;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).remove(str);
                if (zzfubVar == null) {
                    return false;
                }
                zzfubVar.zzh();
                zzfsn zzfsnVar = this.zzi;
                if (zzfsnVar != null) {
                    zzfsnVar.zzf(zzfubVar);
                }
                int iZzt = zzfubVar.zzt();
                zzfubVar.zzv();
                this.zzc.zzm(this.zzg.currentTimeMillis(), str, zzfubVar.zzr(), adFormat, zzfubVar.zzs(), iZzt);
                return true;
            } finally {
            }
        }
    }

    public final void zzj(int i) {
        AdFormat adFormat = AdFormat.getAdFormat(i);
        if (adFormat == null) {
            return;
        }
        Map map = this.zza;
        synchronized (map) {
            try {
                if (map.containsKey(adFormat)) {
                    Map map2 = (Map) map.get(adFormat);
                    int size = map2.size();
                    if (size == 0) {
                        return;
                    }
                    zzgwm zzgwmVarZzq = zzgwm.zzq(map2.values());
                    map2.clear();
                    int size2 = zzgwmVarZzq.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        zzfub zzfubVar = (zzfub) zzgwmVarZzq.get(i2);
                        if (zzfubVar != null) {
                            zzfubVar.zzh();
                            zzfsn zzfsnVar = this.zzi;
                            if (zzfsnVar != null) {
                                zzfsnVar.zzf(zzfubVar);
                            }
                            zzfubVar.zzv();
                            String strValueOf = String.valueOf(zzfubVar.zzp());
                            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Destroyed ad preloader for preloadId: ".concat(strValueOf));
                        }
                    }
                    String strConcat = "Destroyed all ad preloaders for ad format: ".concat(adFormat.toString());
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh(strConcat);
                    this.zzc.zzl(this.zzg.currentTimeMillis(), adFormat, size);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzk(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzy)).booleanValue()) {
            zzl(z);
        }
    }
}
