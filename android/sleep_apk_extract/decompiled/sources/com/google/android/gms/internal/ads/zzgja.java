package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzgja extends zzgix {
    private final Map zza;
    private final zzght zzb;
    private final DisplayMetrics zzc;

    public zzgja(zzaxm zzaxmVar, zzght zzghtVar, Map map, DisplayMetrics displayMetrics, zzgqh zzgqhVar) {
        super("g8Hou5USbHgGLmPw1BkH9QPyVyp2SXRCRzY3yGPbL7sxfyxqHR6KXwoo/P2bI6wU", "utPmmlJBn3DsRsjWpEfYOH8JhF0hoTbnHHSBi5azvE0=", zzaxmVar, zzghtVar, zzgqhVar.zza(123));
        this.zzb = zzghtVar;
        this.zza = map;
        this.zzc = displayMetrics;
    }

    private static long zzb(double d, DisplayMetrics displayMetrics) {
        return Math.round(d / ((double) displayMetrics.density));
    }

    private static boolean zzc(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    public final void zza(Method method, zzaxm zzaxmVar) {
        Object[] objArr;
        Map map = this.zza;
        MotionEvent motionEvent = (MotionEvent) map.get("nv");
        DisplayMetrics displayMetrics = this.zzc;
        Object[] objArr2 = (Object[]) method.invoke("", motionEvent, displayMetrics);
        objArr2.getClass();
        zzayi zzayiVarZza = zzayj.zza();
        Object obj = objArr2[0];
        if (obj != null && objArr2[1] != null) {
            zzayiVarZza.zza(((Long) obj).longValue());
            zzayiVarZza.zzb(((Long) objArr2[1]).longValue());
        }
        Object obj2 = objArr2[2];
        if (obj2 != null) {
            zzayiVarZza.zzh(((Long) obj2).longValue());
        }
        Object obj3 = objArr2[3];
        if (obj3 != null) {
            zzayiVarZza.zzf(((Long) obj3).longValue());
        }
        Object obj4 = objArr2[4];
        if (obj4 != null) {
            zzayiVarZza.zzc(((Long) obj4).longValue());
        }
        Object obj5 = objArr2[5];
        if (obj5 != null) {
            zzayiVarZza.zzs(((Long) obj5).longValue() != 0 ? 2 : 1);
        }
        Object obj6 = objArr2[6];
        if (obj6 != null) {
            zzayiVarZza.zzj(((Long) obj6).longValue());
        }
        Object obj7 = objArr2[7];
        if (obj7 != null) {
            zzayiVarZza.zzi(((Long) obj7).longValue());
        }
        Object obj8 = objArr2[8];
        if (obj8 != null) {
            zzayiVarZza.zzt(((Long) obj8).longValue() != 0 ? 2 : 1);
        }
        synchronized (zzaxmVar) {
            try {
                Method methodZzc = this.zzb.zzc("RYti6RI2h2/Y2PXof3Gp1AbX+o/wefouwN7AnDg2eTa2HyxUpoBLBymHRKB/R/xV", "RPcTI+OBxtVdwgZKiN6UGH5Wjl+q93TfecmKmwPvnok=");
                if (methodZzc == null || (objArr = (Object[]) methodZzc.invoke("", (MotionEvent) map.get("nv"), displayMetrics)) == null) {
                    throw null;
                }
                Object obj9 = objArr[0];
                if (obj9 != null) {
                    zzaxmVar.zzh(((Long) obj9).longValue());
                }
                Object obj10 = objArr[1];
                if (obj10 != null) {
                    zzaxmVar.zzi(((Long) obj10).longValue());
                }
                Object obj11 = objArr[2];
                if (obj11 != null) {
                    zzaxmVar.zzj(((Long) obj11).longValue());
                }
                Object obj12 = objArr[3];
                if (obj12 != null) {
                    zzaxmVar.zzv(((Long) obj12).longValue());
                }
                Object obj13 = objArr[4];
                if (obj13 != null) {
                    zzaxmVar.zzw(((Long) obj13).longValue());
                }
                zzggn zzggnVar = (zzggn) map.get("oe");
                if (zzggnVar != null) {
                    long j = zzggnVar.zza;
                    if (j > 0) {
                        zzaxmVar.zzz(j);
                    }
                    long j2 = zzggnVar.zzb;
                    if (j2 > 0) {
                        zzaxmVar.zzy(j2);
                    }
                    long j3 = zzggnVar.zzc;
                    if (j3 > 0) {
                        zzaxmVar.zzx(j3);
                    }
                    long j4 = zzggnVar.zzd;
                    if (j4 > 0) {
                        zzaxmVar.zzA(j4);
                    }
                }
                zzggn zzggnVar2 = (zzggn) map.get("oe");
                if (zzggnVar2 != null && zzggnVar2.zza != 0 && zzc(displayMetrics)) {
                    double d = zzggnVar2.zze;
                    if (displayMetrics == null) {
                        throw null;
                    }
                    zzayiVarZza.zzl(zzb(d, displayMetrics));
                    zzayiVarZza.zzm(zzb(zzggnVar2.zzh - zzggnVar2.zzf, displayMetrics));
                    zzayiVarZza.zzn(zzb(zzggnVar2.zzi - zzggnVar2.zzg, displayMetrics));
                    zzayiVarZza.zzq(zzb(zzggnVar2.zzf, displayMetrics));
                    zzayiVarZza.zzr(zzb(zzggnVar2.zzg, displayMetrics));
                    if (((MotionEvent) map.get("nv")) != null) {
                        long jZzb = zzb(((zzggnVar2.zzf - zzggnVar2.zzh) + r4.getRawX()) - r4.getX(), displayMetrics);
                        if (jZzb != 0) {
                            zzayiVarZza.zzo(jZzb);
                        }
                        long jZzb2 = zzb(((zzggnVar2.zzg - zzggnVar2.zzi) + r4.getRawY()) - r4.getY(), displayMetrics);
                        if (jZzb2 != 0) {
                            zzayiVarZza.zzp(jZzb2);
                        }
                    }
                }
                zzaxmVar.zzJ(zzayiVarZza);
                zzggo[] zzggoVarArr = (zzggo[]) map.get("ro");
                if (zzggoVarArr != null && zzc(displayMetrics)) {
                    for (int i = 0; i <= zzggoVarArr.length - 2; i++) {
                        zzggo zzggoVar = zzggoVarArr[i];
                        zzayi zzayiVarZza2 = zzayj.zza();
                        double d2 = zzggoVar.zza;
                        if (displayMetrics == null) {
                            throw null;
                        }
                        zzayiVarZza2.zza(zzb(d2, displayMetrics));
                        zzayiVarZza2.zzb(zzb(zzggoVar.zzb, displayMetrics));
                        zzaxmVar.zzK((zzayj) zzayiVarZza2.zzbm());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
