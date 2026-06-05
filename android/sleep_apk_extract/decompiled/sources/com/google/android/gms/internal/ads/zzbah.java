package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbah implements zzbak {
    private static zzbah zzb;
    private final Context zzc;
    private final zzfyq zzd;
    private final zzfyx zze;
    private final zzfyz zzf;
    private final zzbbm zzg;
    private final zzfxg zzh;
    private final Executor zzi;
    private final zzbds zzj;
    private final zzfyw zzk;
    private final zzbcb zzm;
    private final zzbbt zzn;
    private final zzbbk zzo;
    private volatile boolean zzq;
    private volatile boolean zzr;
    volatile long zza = 0;
    private final Object zzp = new Object();
    private final CountDownLatch zzl = new CountDownLatch(1);

    public zzbah(Context context, zzfxg zzfxgVar, zzfyq zzfyqVar, zzfyx zzfyxVar, zzfyz zzfyzVar, zzbbm zzbbmVar, Executor executor, zzfxb zzfxbVar, zzbds zzbdsVar, zzbcb zzbcbVar, zzbbt zzbbtVar, zzbbk zzbbkVar) {
        this.zzr = false;
        this.zzc = context;
        this.zzh = zzfxgVar;
        this.zzd = zzfyqVar;
        this.zze = zzfyxVar;
        this.zzf = zzfyzVar;
        this.zzg = zzbbmVar;
        this.zzi = executor;
        this.zzj = zzbdsVar;
        this.zzm = zzbcbVar;
        this.zzn = zzbbtVar;
        this.zzo = zzbbkVar;
        this.zzr = false;
        this.zzk = new zzbaf(this, zzfxbVar);
    }

    public static synchronized zzbah zza(Context context, zzawo zzawoVar, boolean z) {
        zzfxh zzfxhVarZzh;
        zzfxhVarZzh = zzfxi.zzh();
        zzfxhVarZzh.zza(zzawoVar.zza());
        zzfxhVarZzh.zzb(zzawoVar.zzb());
        return zzs(context, Executors.newCachedThreadPool(), zzfxhVarZzh.zzh(), z);
    }

    private static synchronized zzbah zzs(Context context, Executor executor, zzfxi zzfxiVar, boolean z) {
        try {
            if (zzb == null) {
                zzfxg zzfxgVarZza = zzfxg.zza(context, executor, z);
                zzbav zzbavVarZza = zzbav.zza(context);
                zzbcb zzbcbVarZza = zzbcb.zza(context, executor);
                zzbbt zzbbtVar = new zzbbt();
                zzbbk zzbbkVar = new zzbbk();
                zzfxw zzfxwVarZza = zzfxw.zza(context, executor, zzfxgVarZza, zzfxiVar);
                zzbbl zzbblVar = new zzbbl(context);
                zzbbm zzbbmVar = new zzbbm(zzfxiVar, zzfxwVarZza, new zzbbz(context, zzbblVar), zzbblVar, zzbavVarZza, zzbcbVarZza, zzbbtVar, zzbbkVar);
                zzbds zzbdsVarZzb = zzfyd.zzb(context, zzfxgVarZza);
                zzfxb zzfxbVar = new zzfxb();
                zzbah zzbahVar = new zzbah(context, zzfxgVarZza, new zzfyq(context, zzbdsVarZzb), new zzfyx(context, zzbdsVarZzb, new zzbae(zzfxgVarZza), ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdl)).booleanValue()), new zzfyz(context, zzbbmVar, zzfxgVarZza, zzfxbVar, false), zzbbmVar, executor, zzfxbVar, zzbdsVarZzb, zzbcbVarZza, zzbbtVar, zzbbkVar);
                zzb = zzbahVar;
                zzbahVar.zzc();
                zzb.zzm();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzb;
    }

    private final zzfyp zzt(int i) {
        if (zzfyd.zza(this.zzj)) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdj)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzb(1);
        }
        return null;
    }

    public final synchronized boolean zzb() {
        return this.zzr;
    }

    public final synchronized void zzc() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfyp zzfypVarZzt = zzt(1);
        if (zzfypVarZzt == null) {
            this.zzh.zzb(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zza(zzfypVarZzt)) {
            this.zzr = true;
            this.zzl.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzd(MotionEvent motionEvent) {
        zzfxj zzfxjVarZzb = this.zzf.zzb();
        if (zzfxjVarZzb != null) {
            try {
                zzfxjVarZzb.zzd(null, motionEvent);
            } catch (zzfyy e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zze(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznv)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f = i;
        float f2 = displayMetrics.density;
        float f3 = i2;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f * f2, f3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzd(motionEventObtain);
        motionEventObtain.recycle();
        float f4 = displayMetrics.density;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f * f4, f3 * f4, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzd(motionEventObtain2);
        motionEventObtain2.recycle();
        float f5 = displayMetrics.density;
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i3, 1, f * f5, f3 * f5, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzd(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzf(Context context, String str, View view, Activity activity) {
        this.zzm.zzb();
        this.zzn.zzc();
        zzm();
        zzfxj zzfxjVarZzb = this.zzf.zzb();
        if (zzfxjVarZzb == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzfxjVarZzb.zzc(context, null, str, view, activity);
        this.zzh.zzd(DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzg(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzh(View view) {
        this.zzg.zza(view);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzi(StackTraceElement[] stackTraceElementArr) {
        this.zzo.zza(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzj(Context context, View view, Activity activity) {
        this.zzm.zzb();
        this.zzn.zzb(context, view);
        zzm();
        zzfxj zzfxjVarZzb = this.zzf.zzb();
        if (zzfxjVarZzb == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzfxjVarZzb.zzb(context, null, view, activity);
        this.zzh.zzd(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzk(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzl(Context context) {
        this.zzm.zzb();
        this.zzn.zza();
        zzm();
        zzfxj zzfxjVarZzb = this.zzf.zzb();
        if (zzfxjVarZzb == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzfxjVarZzb.zza(context, null);
        this.zzh.zzd(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    public final void zzm() {
        if (this.zzq) {
            return;
        }
        synchronized (this.zzp) {
            try {
                if (!this.zzq) {
                    if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                        return;
                    }
                    zzfyp zzfypVarZzc = this.zzf.zzc();
                    if ((zzfypVarZzc == null || zzfypVarZzc.zze(3600L)) && zzfyd.zza(this.zzj)) {
                        this.zzi.execute(new zzbag(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzn() {
        String str;
        String strZzb;
        int length;
        zzfyp zzfypVarZzt;
        zzbeb zzbebVarZza;
        boolean zZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfyp zzfypVarZzt2 = zzt(1);
        if (zzfypVarZzt2 != null) {
            String strZza = zzfypVarZzt2.zza().zza();
            strZzb = zzfypVarZzt2.zza().zzb();
            str = strZza;
        } else {
            str = null;
            strZzb = null;
        }
        try {
            try {
                Context context = this.zzc;
                zzbds zzbdsVar = this.zzj;
                zzfxg zzfxgVar = this.zzh;
                zzfyu zzfyuVarZza = zzfxp.zza(context, 1, zzbdsVar, str, strZzb, AppEventsConstants.EVENT_PARAM_VALUE_YES, zzfxgVar);
                byte[] bArr = zzfyuVarZza.zzb;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzfxgVar.zzb(5009, System.currentTimeMillis() - jCurrentTimeMillis);
                } else {
                    try {
                        zzbdu zzbduVarZzd = zzbdu.zzd(zzida.zzt(bArr, 0, length), zzido.zza());
                        if (zzbduVarZzd.zza().zza().isEmpty() || zzbduVarZzd.zza().zzb().isEmpty() || zzbduVarZzd.zzc().zzA().length == 0 || ((zzfypVarZzt = zzt(1)) != null && (zzbebVarZza = zzfypVarZzt.zza()) != null && zzbduVarZzd.zza().zza().equals(zzbebVarZza.zza()) && zzbduVarZzd.zza().zzb().equals(zzbebVarZza.zzb()))) {
                            this.zzh.zzb(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                        } else {
                            zzfyw zzfywVar = this.zzk;
                            int i = zzfyuVarZza.zzc;
                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdj)).booleanValue()) {
                                zZza = this.zzd.zza(zzbduVarZzd, zzfywVar);
                            } else if (i == 3) {
                                zZza = this.zze.zzb(zzbduVarZzd);
                            } else {
                                if (i == 4) {
                                    zZza = this.zze.zza(zzbduVarZzd, zzfywVar);
                                }
                                this.zzh.zzb(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                            if (zZza) {
                                zzfyp zzfypVarZzt3 = zzt(1);
                                if (zzfypVarZzt3 != null) {
                                    if (this.zzf.zza(zzfypVarZzt3)) {
                                        this.zzr = true;
                                    }
                                    this.zza = System.currentTimeMillis() / 1000;
                                }
                            } else {
                                this.zzh.zzb(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                        }
                    } catch (NullPointerException unused) {
                        this.zzh.zzb(2030, System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
            } catch (zziet e) {
                this.zzh.zzc(4002, System.currentTimeMillis() - jCurrentTimeMillis, e);
            }
            this.zzl.countDown();
        } catch (Throwable th) {
            this.zzl.countDown();
            throw th;
        }
    }

    public final /* synthetic */ zzfxg zzo() {
        return this.zzh;
    }

    public final /* synthetic */ Object zzp() {
        return this.zzp;
    }

    public final /* synthetic */ boolean zzq() {
        return this.zzq;
    }

    public final /* synthetic */ void zzr(boolean z) {
        this.zzq = z;
    }
}
