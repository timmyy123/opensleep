package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzez {
    private static volatile zzez zzc;
    protected final ExecutorService zzb;
    private final AppMeasurementSdk zze;
    private final List zzf;
    private int zzg;
    private boolean zzh;
    private final String zzi;
    private volatile zzcp zzj;
    private volatile long zzk;
    private final String zzd = "FA";
    protected final Clock zza = DefaultClock.getInstance();

    public zzez(Context context, Bundle bundle) {
        zzck.zza();
        zzeb zzebVar = new zzeb(this);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzebVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (com.google.android.gms.measurement.internal.zzlt.zza(context, "google_app_id", com.google.android.gms.measurement.internal.zzhu.zza(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzez.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.zzi = null;
                    this.zzh = true;
                    Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        this.zzi = "fa";
        zzM(new zzdp(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzey(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
    public final void zzM(zzeo zzeoVar) {
        this.zzb.execute(zzeoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzW, reason: merged with bridge method [inline-methods] */
    public final void zzN(Exception exc, boolean z, boolean z2) {
        zzez zzezVar;
        Exception exc2;
        this.zzh |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzezVar = this;
            exc2 = exc;
            zzezVar.zzD(5, "Error with data collection. Data lost.", exc2, null, null);
        } else {
            zzezVar = this;
            exc2 = exc;
        }
        Log.w(zzezVar.zzd, "Error with data collection. Data lost.", exc2);
    }

    private final void zzX(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l, Long l2) {
        zzM(new zzen(this, l, l2, str, str2, bundle, z, z2));
    }

    public static zzez zza(Context context, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzez.class) {
                try {
                    if (zzc == null) {
                        zzc = new zzez(context, bundle == null ? new Bundle() : new Bundle(bundle));
                    }
                } finally {
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdx(this, zzcmVar));
        return zzcmVar.zzc(500L);
    }

    public final String zzB() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdy(this, zzcmVar));
        return zzcmVar.zzc(500L);
    }

    public final Map zzC(String str, String str2, boolean z) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdz(this, str, str2, z, zzcmVar));
        Bundle bundleZze = zzcmVar.zze(5000L);
        if (bundleZze == null || bundleZze.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleZze.size());
        for (String str3 : bundleZze.keySet()) {
            Object obj = bundleZze.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final void zzD(int i, String str, Object obj, Object obj2, Object obj3) {
        zzM(new zzea(this, false, 5, str, obj, null, null));
    }

    public final int zzF(String str) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzed(this, str, zzcmVar));
        Integer num = (Integer) zzcm.zzf(zzcmVar.zze(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final /* synthetic */ boolean zzO() {
        return this.zzk >= 169;
    }

    public final /* synthetic */ String zzQ() {
        return this.zzd;
    }

    public final /* synthetic */ boolean zzR() {
        return this.zzh;
    }

    public final /* synthetic */ zzcp zzS() {
        return this.zzj;
    }

    public final /* synthetic */ void zzT(zzcp zzcpVar) {
        this.zzj = zzcpVar;
    }

    public final /* synthetic */ void zzU(long j) {
        this.zzk = j;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final zzcp zzc(Context context, boolean z) {
        try {
            return zzco.asInterface(DynamiteModule.load(context, z ? DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION : DynamiteModule.PREFER_LOCAL, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            this.zzN(e, true, false);
            return null;
        }
    }

    public final void zzh(String str, Bundle bundle) {
        zzX(null, str, bundle, false, true, null, null);
    }

    public final void zzi(String str, String str2, Bundle bundle) {
        zzX(str, str2, bundle, true, true, null, null);
    }

    public final void zzl(Bundle bundle) {
        zzM(new zzdg(this, bundle));
    }

    public final void zzm(String str, String str2, Bundle bundle) {
        zzM(new zzdh(this, str, str2, bundle));
    }

    public final List zzn(String str, String str2) {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdi(this, str, str2, zzcmVar));
        List list = (List) zzcm.zzf(zzcmVar.zze(5000L), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final void zzp(zzdd zzddVar, String str, String str2) {
        zzM(new zzdk(this, zzddVar, str, str2));
    }

    public final void zzq(Boolean bool) {
        zzM(new zzdl(this, bool));
    }

    public final void zzu(String str) {
        zzM(new zzdq(this, str));
    }

    public final void zzv(String str) {
        zzM(new zzdr(this, str));
    }

    public final void zzw(Runnable runnable) {
        zzM(new zzdt(this, runnable));
    }

    public final String zzx() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdu(this, zzcmVar));
        return zzcmVar.zzc(500L);
    }

    public final String zzy() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdv(this, zzcmVar));
        return zzcmVar.zzc(50L);
    }

    public final long zzz() {
        zzcm zzcmVar = new zzcm();
        zzM(new zzdw(this, zzcmVar));
        Long lZzd = zzcmVar.zzd(500L);
        if (lZzd != null) {
            return lZzd.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return jNextLong + ((long) i);
    }
}
