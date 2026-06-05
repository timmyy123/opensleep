package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.appfunctions.AppFunctionException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbal implements zzbak {
    protected static volatile zzbbs zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzbbk zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    public zzbal(Context context) {
        try {
            zzazo.zza();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdG)).booleanValue()) {
                this.zzr = new zzbbk();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzo() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        LinkedList linkedList = this.zzc;
        if (linkedList.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            linkedList.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzp(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzbaj zzbajVarZzh;
        String str2;
        int i2;
        Exception exc;
        int i3;
        int i4;
        String strZzb;
        zzaxm zzaxmVarZza;
        int i5;
        int i6;
        int i7 = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdv)).booleanValue();
        zzaxm zzaxmVarZzb = null;
        if (zBooleanValue) {
            zzbajVarZzh = zza != null ? zza.zzh() : null;
            str2 = "be";
        } else {
            zzbajVarZzh = null;
            str2 = null;
        }
        try {
            if (i7 == 3) {
                zzaxmVarZzb = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i6 = 1002;
                } catch (Exception e) {
                    exc = e;
                    i2 = 3;
                    if (zBooleanValue) {
                        if (i7 != i2) {
                        }
                        i3 = i4;
                        zzbajVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                    }
                }
            } else {
                if (i7 == 2) {
                    zzaxmVarZza = zzc(context, view, activity);
                    i5 = 1008;
                } else {
                    zzaxmVarZza = zza(context, null);
                    i5 = 1000;
                }
                zzaxmVarZzb = zzaxmVarZza;
                i6 = i5;
            }
            if (!zBooleanValue || zzbajVarZzh == null) {
                i2 = 3;
            } else {
                i2 = 3;
                try {
                    zzbajVarZzh.zza(i6, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    if (zBooleanValue && zzbajVarZzh != null) {
                        if (i7 != i2) {
                            i4 = AppFunctionException.ERROR_FUNCTION_NOT_FOUND;
                        } else if (i7 == 2) {
                            i4 = 1009;
                        } else {
                            i3 = 1001;
                            i7 = 1;
                            zzbajVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                        }
                        i3 = i4;
                        zzbajVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 3;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (zzaxmVarZzb != null) {
            try {
                if (((zzaym) zzaxmVarZzb.zzbm()).zzbr() == 0) {
                    strZzb = Integer.toString(5);
                } else {
                    zzaym zzaymVar = (zzaym) zzaxmVarZzb.zzbm();
                    boolean z = zzazo.zza;
                    strZzb = zzazo.zzb(zzaymVar.zzaN(), str);
                    if (zBooleanValue && zzbajVarZzh != null) {
                        zzbaj zzbajVar = zzbajVarZzh;
                        String str3 = str2;
                        try {
                            zzbajVar.zza(i7 == i2 ? 1006 : i7 == 2 ? 1010 : 1004, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str3, null);
                        } catch (Exception e4) {
                            e = e4;
                            zzbajVarZzh = zzbajVar;
                            str2 = str3;
                            String string = Integer.toString(7);
                            if (zBooleanValue && zzbajVarZzh != null) {
                                zzbajVarZzh.zza(i7 == i2 ? 1007 : i7 == 2 ? 1011 : 1005, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, e);
                            }
                            return string;
                        }
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
        } else {
            strZzb = Integer.toString(5);
        }
        return strZzb;
    }

    public abstract zzaxm zza(Context context, zzawy zzawyVar);

    public abstract zzaxm zzb(Context context, View view, Activity activity);

    public abstract zzaxm zzc(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzbak
    public final synchronized void zzd(MotionEvent motionEvent) {
        Long l;
        try {
            if (this.zzu) {
                zzo();
                this.zzu = false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.zzk = 0.0d;
                this.zzs = motionEvent.getRawX();
                this.zzt = motionEvent.getRawY();
            } else if (action == 1 || action == 2) {
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d = rawX - this.zzs;
                double d2 = rawY - this.zzt;
                this.zzk += Math.sqrt((d2 * d2) + (d * d));
                this.zzs = rawX;
                this.zzt = rawY;
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                try {
                    if (action2 == 1) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        this.zzb = motionEventObtain;
                        LinkedList linkedList = this.zzc;
                        linkedList.add(motionEventObtain);
                        if (linkedList.size() > 6) {
                            ((MotionEvent) linkedList.remove()).recycle();
                        }
                        this.zzf++;
                        this.zzh = zzn(new Throwable().getStackTrace());
                    } else if (action2 == 2) {
                        this.zze += (long) (motionEvent.getHistorySize() + 1);
                        zzbbu zzbbuVarZzm = zzm(motionEvent);
                        Long l2 = zzbbuVarZzm.zzd;
                        if (l2 != null && zzbbuVarZzm.zzg != null) {
                            this.zzi = l2.longValue() + zzbbuVarZzm.zzg.longValue() + this.zzi;
                        }
                        if (this.zzq != null && (l = zzbbuVarZzm.zze) != null && zzbbuVarZzm.zzh != null) {
                            this.zzj = l.longValue() + zzbbuVarZzm.zzh.longValue() + this.zzj;
                        }
                    } else if (action2 == 3) {
                        this.zzg++;
                    }
                } catch (zzbbi unused) {
                }
            } else {
                this.zzl = motionEvent.getX();
                this.zzm = motionEvent.getY();
                this.zzn = motionEvent.getRawX();
                this.zzo = motionEvent.getRawY();
                this.zzd++;
            }
            this.zzp = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final synchronized void zze(int i, int i2, int i3) {
        try {
            if (this.zzb != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdt)).booleanValue()) {
                    zzo();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                float f = displayMetrics.density;
                this.zzb = MotionEvent.obtain(0L, i3, 1, i * f, i2 * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzf(Context context, String str, View view, Activity activity) {
        return zzp(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzg(Context context, String str, View view) {
        return zzp(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzi(StackTraceElement[] stackTraceElementArr) {
        zzbbk zzbbkVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdG)).booleanValue() || (zzbbkVar = this.zzr) == null) {
            return;
        }
        zzbbkVar.zza(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzj(Context context, View view, Activity activity) {
        return zzp(context, null, 2, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzk(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzl(Context context) {
        if (!zzbbv.zzd()) {
            return zzp(context, null, 1, null, null, null);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("The caller must not be called from the UI thread.");
        return null;
    }

    public abstract zzbbu zzm(MotionEvent motionEvent);

    public abstract long zzn(StackTraceElement[] stackTraceElementArr);
}
