package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgfm implements zzgfh, zzgfd, zzgfs {
    private static final zzihr zza;
    private final Context zzb;
    private final zzgel zzc;
    private final ExecutorService zzd;
    private final zzgee zze;
    private final boolean zzf;
    private final String zzg;
    private final long zzh;
    private final long zzi;
    private final double zzj;
    private final String zzk;
    private final long zzl;
    private final AtomicBoolean zzm = new AtomicBoolean(false);
    private final Object zzn = new Object();
    private final Object zzo = new Object();
    private final Object zzp = new Object();
    private final zzawp zzq = zzawq.zza();
    private final List zzr = new ArrayList();
    private boolean zzs = false;
    private final HashMap zzt = new HashMap();
    private final int zzu;

    static {
        zzihq zzihqVarZzc = zzihr.zzc();
        zzihqVarZzc.zza(17);
        zza = (zzihr) zzihqVarZzc.zzbm();
    }

    public zzgfm(Context context, zzgel zzgelVar, ExecutorService executorService, zzgee zzgeeVar, Random random, String str, long j, long j2, double d, String str2, int i, long j3) {
        this.zzb = context;
        this.zzc = zzgelVar;
        this.zzd = executorService;
        this.zze = zzgeeVar;
        this.zzg = str;
        this.zzh = j;
        this.zzi = j2;
        this.zzj = d;
        this.zzk = str2;
        this.zzu = i;
        this.zzl = j3;
        this.zzf = random.nextDouble() < d;
    }

    @Override // com.google.android.gms.internal.ads.zzgfd
    public final ListenableFuture zza() {
        return zzhbw.zze(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgfk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzg();
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgfh
    public final void zzb(int i, long j, Throwable th, String str) {
        long jLongValue;
        if (this.zzf) {
            synchronized (this.zzo) {
                try {
                    List list = this.zzr;
                    synchronized (this.zzp) {
                        try {
                            HashMap map = this.zzt;
                            Integer numValueOf = Integer.valueOf(i);
                            Long l = (Long) map.get(numValueOf);
                            if (l == null) {
                                l = 0L;
                            }
                            jLongValue = 1 + l.longValue();
                            map.put(numValueOf, Long.valueOf(jLongValue));
                        } finally {
                        }
                    }
                    list.add(new zzgfj(i, j, th, str, jLongValue));
                    if (!this.zzs) {
                        this.zzs = true;
                        this.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgfl
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zze();
                            }
                        }, this.zzi);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final void zzc(zzgfr zzgfrVar) {
        synchronized (this.zzn) {
            this.zzq.zzj(zzgfrVar.zza());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final void zzd(List list) {
        synchronized (this.zzn) {
            this.zzq.zzm(list);
        }
    }

    public final void zze() {
        zzawp zzawpVar;
        zzgwm zzgwmVarZzq;
        String string;
        synchronized (this.zzn) {
            zzawpVar = (zzawp) this.zzq.clone();
        }
        synchronized (this.zzo) {
            List list = this.zzr;
            zzgwmVarZzq = zzgwm.zzq(list);
            list.clear();
            this.zzs = false;
        }
        int size = zzgwmVarZzq.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            zzgfj zzgfjVar = (zzgfj) zzgwmVarZzq.get(i);
            if (i2 >= this.zzh) {
                zzf((zzawq) zzawpVar.zzbm());
                zzawpVar.zzb();
                i2 = 0;
            }
            zzaxh zzaxhVarZza = zzaxi.zza();
            zzaxhVarZza.zza(zzgfjVar.zza);
            zzaxhVarZza.zzb(zzgfjVar.zzb);
            zzaxhVarZza.zze(zzgfjVar.zze);
            String str = zzgfjVar.zzd;
            if (str != null) {
                zzaxhVarZza.zzf(str);
            }
            Throwable th = zzgfjVar.zzc;
            zzaxhVarZza.zzg(th == null ? 2 : 3);
            if (th != null) {
                zzaxhVarZza.zzc(th.getClass().getName());
                try {
                    StringWriter stringWriter = new StringWriter();
                    try {
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        try {
                            th.printStackTrace(printWriter);
                            string = stringWriter.toString();
                            printWriter.close();
                            stringWriter.close();
                        } catch (Throwable th2) {
                            try {
                                printWriter.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        try {
                            stringWriter.close();
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                        }
                        throw th4;
                    }
                } catch (IOException unused) {
                    string = "";
                }
                zzaxhVarZza.zzd(string);
            }
            zzawpVar.zza((zzaxi) zzaxhVarZza.zzbm());
            i++;
            i2++;
        }
        if (i2 > 0) {
            zzf((zzawq) zzawpVar.zzbm());
            zzawpVar.zzb();
        }
    }

    public final void zzf(zzawq zzawqVar) {
        try {
            zzbdp zzbdpVarZza = zzbdq.zza();
            zzbdpVarZza.zzb(zza);
            zzbdn zzbdnVarZza = zzbdo.zza();
            zzbdnVarZza.zza(zzawqVar);
            zzbdpVarZza.zza((zzbdo) zzbdnVarZza.zzbm());
            this.zze.zzb(this.zzg, ((zzbdq) zzbdpVarZza.zzbm()).zzaN(), "application/x-protobuf");
        } catch (RuntimeException unused) {
        }
    }

    public final /* synthetic */ void zzg() {
        int i;
        if (!this.zzf || this.zzm.getAndSet(true)) {
            return;
        }
        Context context = this.zzb;
        String str = this.zzk;
        int i2 = this.zzu;
        double d = this.zzj;
        long j = this.zzl;
        Locale locale = Locale.getDefault();
        int iZzb = zzbdv.zzb(zzgde.zza(i2));
        zzawp zzawpVarZza = zzawq.zza();
        zzawpVarZza.zzc(Build.VERSION.SDK_INT);
        zzawpVarZza.zzd(Build.MODEL);
        zzawpVarZza.zze(locale.getLanguage());
        zzawpVarZza.zzf(locale.getCountry());
        zzawpVarZza.zzi(str);
        zzawpVarZza.zzo(iZzb);
        zzawpVarZza.zzp(3);
        zzawpVarZza.zzg(context.getPackageName());
        zzawpVarZza.zzl(j);
        if (d > 0.0d) {
            zzawpVarZza.zzk((int) (1.0d / d));
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            zzawpVarZza.zzh(packageManager.getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                i = 5;
            } else if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
                i = 4;
            } else if (packageManager.hasSystemFeature("android.hardware.type.pc")) {
                i = 7;
            } else {
                UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
                i = (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) ? 2 : 6;
            }
            zzawpVarZza.zzn(i);
        } catch (RuntimeException unused2) {
        }
        zzawq zzawqVar = (zzawq) zzawpVarZza.zzbm();
        synchronized (this.zzn) {
            this.zzq.zzbo(zzawqVar);
        }
    }
}
