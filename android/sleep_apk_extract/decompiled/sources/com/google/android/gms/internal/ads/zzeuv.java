package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.RoundedCorner;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeuv implements zzfck {
    private final zzfck zza;
    private final zzfky zzb;
    private final Context zzc;
    private final zzcfd zzd;

    public zzeuv(zzewy zzewyVar, zzfky zzfkyVar, Context context, zzcfd zzcfdVar) {
        this.zza = zzewyVar;
        this.zzb = zzfkyVar;
        this.zzc = context;
        this.zzd = zzcfdVar;
    }

    private static final int zzd(WindowInsets windowInsets, int i) {
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(i);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return 0;
    }

    private static final int zze(int i, float f) {
        if (f == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(i / f);
    }

    private static final Insets zzf(Insets insets, float f) {
        return f == 0.0f ? Insets.NONE : Insets.of((int) Math.ceil(insets.left / f), (int) Math.ceil(insets.top / f), (int) Math.ceil(insets.right / f), (int) Math.ceil(insets.bottom / f));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zzk(this.zza.zza(), new zzgta() { // from class: com.google.android.gms.internal.ads.zzeuu
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((zzfct) obj);
            }
        }, zzcfr.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01de, code lost:
    
        if (r0 <= r14) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0220 A[PHI: r2
      0x0220: PHI (r2v25 androidx.core.graphics.Insets) = 
      (r2v24 androidx.core.graphics.Insets)
      (r2v24 androidx.core.graphics.Insets)
      (r2v32 androidx.core.graphics.Insets)
      (r2v32 androidx.core.graphics.Insets)
      (r2v40 androidx.core.graphics.Insets)
     binds: [B:104:0x01eb, B:110:0x0234, B:112:0x0252, B:114:0x025a, B:107:0x0205] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ zzeuw zzc(zzfct zzfctVar) {
        String str;
        String str2;
        boolean z;
        int i;
        int iHeight;
        int iWidth;
        String strZzu;
        float f;
        int i2;
        String str3;
        com.google.android.gms.ads.internal.client.zzr zzrVar;
        boolean z2;
        Window window;
        View decorView;
        WindowInsetsCompat rootWindowInsets;
        Insets insetsZzf;
        zzeut zzeutVar;
        WindowManager windowManager;
        WindowManager windowManager2;
        WindowManager windowManager3;
        DisplayMetrics displayMetrics;
        int i3;
        WindowManager windowManager4;
        DisplayMetrics displayMetrics2;
        com.google.android.gms.ads.internal.client.zzr zzrVar2 = this.zzb.zzf;
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr = zzrVar2.zzg;
        if (zzrVarArr == null) {
            String str4 = zzrVar2.zza;
            str2 = null;
            z = zzrVar2.zzi;
            str = str4;
        } else {
            str = null;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            for (com.google.android.gms.ads.internal.client.zzr zzrVar3 : zzrVarArr) {
                boolean z6 = zzrVar3.zzi;
                if (!z6 && !z4) {
                    str = zzrVar3.zza;
                    z4 = true;
                }
                if (z6) {
                    if (!z5) {
                        z3 = true;
                    }
                    z5 = true;
                }
                if (z4 && z5) {
                    break;
                }
            }
            boolean z7 = z3;
            str2 = null;
            z = z7;
        }
        Context context = this.zzc;
        Resources resources = context.getResources();
        Activity activityZzd = com.google.android.gms.ads.internal.zzt.zzg().zzd();
        if (activityZzd != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoW)).booleanValue()) {
                try {
                    i = context.getPackageManager().getActivityInfo(activityZzd.getComponentName(), 0).screenOrientation;
                } catch (PackageManager.NameNotFoundException e) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdSizeParcelSignal.Source.readOrientationFromManifest");
                    i = -1;
                }
            } else {
                i = -1;
            }
        }
        if (resources == null || (displayMetrics2 = resources.getDisplayMetrics()) == null) {
            iHeight = 0;
            iWidth = 0;
            strZzu = str2;
            f = 0.0f;
        } else {
            zzcfd zzcfdVar = this.zzd;
            f = displayMetrics2.density;
            iWidth = displayMetrics2.widthPixels;
            iHeight = displayMetrics2.heightPixels;
            strZzu = zzcfdVar.zzo().zzu();
        }
        zzbih zzbihVar = zzbiq.zzoT;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() && (i3 = Build.VERSION.SDK_INT) <= 34 && i3 >= 28 && (windowManager4 = (WindowManager) this.zzc.getSystemService("window")) != null) {
            if (i3 >= 30) {
                WindowMetrics currentWindowMetrics = windowManager4.getCurrentWindowMetrics();
                iWidth = currentWindowMetrics.getBounds().width();
                iHeight = currentWindowMetrics.getBounds().height();
            } else {
                Point point = new Point();
                windowManager4.getDefaultDisplay().getRealSize(point);
                iWidth = point.x;
                iHeight = point.y;
            }
        }
        int i4 = iWidth;
        StringBuilder sb = new StringBuilder();
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr2 = zzrVar2.zzg;
        if (zzrVarArr2 != null) {
            int i5 = 0;
            boolean z8 = false;
            while (i5 < zzrVarArr2.length) {
                com.google.android.gms.ads.internal.client.zzr zzrVar4 = zzrVarArr2[i5];
                int i6 = i;
                if (zzrVar4.zzi) {
                    z8 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i7 = zzrVar4.zze;
                    if (i7 == -1) {
                        i7 = f != 0.0f ? (int) (zzrVar4.zzf / f) : -1;
                    }
                    sb.append(i7);
                    sb.append("x");
                    int i8 = zzrVar4.zzb;
                    if (i8 == -2) {
                        i8 = f != 0.0f ? (int) (zzrVar4.zzc / f) : -2;
                    }
                    sb.append(i8);
                }
                i5++;
                i = i6;
            }
            i2 = i;
            if (z8) {
                if (sb.length() != 0) {
                    sb.insert(0, "|");
                }
                sb.insert(0, "320x50");
            }
        } else {
            i2 = i;
        }
        String string = sb.toString();
        zzfky zzfkyVar = this.zzb;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 35) {
            zzbih zzbihVar2 = zzbiq.zzoN;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar2)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoO)).booleanValue()) {
                    str3 = string;
                    zzrVar = zzrVar2;
                } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoR)).booleanValue()) {
                    Context context2 = this.zzc;
                    WindowManager windowManager5 = (WindowManager) context2.getSystemService("window");
                    if (windowManager5 == null) {
                        str3 = string;
                    } else {
                        str3 = string;
                        if (i9 >= 30) {
                            WindowMetrics currentWindowMetrics2 = windowManager5.getCurrentWindowMetrics();
                            int iWidth2 = currentWindowMetrics2.getBounds().width();
                            int iHeight2 = currentWindowMetrics2.getBounds().height();
                            Resources resources2 = context2.getResources();
                            if (resources2 != null && (displayMetrics = resources2.getDisplayMetrics()) != null) {
                                zzrVar = zzrVar2;
                                int i10 = displayMetrics.widthPixels;
                                int i11 = displayMetrics.heightPixels;
                                if (iWidth2 <= i10) {
                                }
                            }
                            Context context3 = this.zzc;
                            Insets insetsOf = Insets.NONE;
                            windowManager2 = (WindowManager) context3.getSystemService("window");
                            if (windowManager2 == null) {
                                WindowInsets windowInsets = windowManager2.getCurrentWindowMetrics().getWindowInsets();
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar2)).booleanValue()) {
                                    insetsOf = Insets.toCompatInsets(windowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar()));
                                } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoO)).booleanValue()) {
                                    insetsOf = Insets.toCompatInsets(windowInsets.getInsets(WindowInsets.Type.displayCutout()));
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoP)).booleanValue() && (windowManager3 = (WindowManager) context3.getSystemService("window")) != null) {
                                        WindowInsets windowInsets2 = windowManager3.getCurrentWindowMetrics().getWindowInsets();
                                        int iZzd = zzd(windowInsets2, 0);
                                        int iZzd2 = zzd(windowInsets2, 1);
                                        z2 = z;
                                        int iZzd3 = zzd(windowInsets2, 3);
                                        int iZzd4 = zzd(windowInsets2, 2);
                                        insetsOf = iHeight >= i4 ? Insets.of(insetsOf.left, Math.max(insetsOf.top, Math.max(iZzd, iZzd2)), insetsOf.right, Math.max(insetsOf.bottom, Math.max(iZzd3, iZzd4))) : Insets.of(Math.max(insetsOf.left, Math.max(iZzd, iZzd3)), insetsOf.top, Math.max(insetsOf.right, Math.max(iZzd2, iZzd4)), insetsOf.bottom);
                                    }
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoQ)).booleanValue() && iHeight < i4) {
                                        int iMax = Math.max(insetsOf.left, insetsOf.right);
                                        insetsOf = Insets.of(iMax, insetsOf.top, iMax, insetsOf.bottom);
                                    }
                                    insetsZzf = zzf(insetsOf, f);
                                }
                                z2 = z;
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoQ)).booleanValue()) {
                                    int iMax2 = Math.max(insetsOf.left, insetsOf.right);
                                    insetsOf = Insets.of(iMax2, insetsOf.top, iMax2, insetsOf.bottom);
                                }
                                insetsZzf = zzf(insetsOf, f);
                            } else {
                                z2 = z;
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoQ)).booleanValue()) {
                                }
                                insetsZzf = zzf(insetsOf, f);
                            }
                        }
                    }
                    zzrVar = zzrVar2;
                    Context context32 = this.zzc;
                    Insets insetsOf2 = Insets.NONE;
                    windowManager2 = (WindowManager) context32.getSystemService("window");
                    if (windowManager2 == null) {
                    }
                }
                z2 = z;
                insetsZzf = null;
            }
        } else {
            str3 = string;
            zzrVar = zzrVar2;
            z2 = z;
            if (i9 > 34 || i9 < 28 || !((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                insetsZzf = null;
            } else {
                Insets insets = Insets.NONE;
                if (i9 >= 30) {
                    WindowManager windowManager6 = (WindowManager) this.zzc.getSystemService("window");
                    if (windowManager6 != null) {
                        insets = Insets.toCompatInsets(windowManager6.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar()));
                    }
                } else {
                    Activity activityZzd2 = com.google.android.gms.ads.internal.zzt.zzg().zzd();
                    if (activityZzd2 != null && (window = activityZzd2.getWindow()) != null && (decorView = window.getDecorView()) != null && (rootWindowInsets = ViewCompat.getRootWindowInsets(decorView)) != null) {
                        insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
                    }
                }
                insetsZzf = zzf(insets, f);
            }
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoS)).booleanValue() || i9 < 31 || f == 0.0f || (windowManager = (WindowManager) this.zzc.getSystemService("window")) == null) {
            zzeutVar = null;
        } else {
            WindowInsets windowInsets3 = windowManager.getCurrentWindowMetrics().getWindowInsets();
            zzeutVar = new zzeut(zze(zzd(windowInsets3, 0), f), zze(zzd(windowInsets3, 1), f), zze(zzd(windowInsets3, 3), f), zze(zzd(windowInsets3, 2), f));
        }
        return new zzeuw(zzrVar, str, z2, str3, f, i4, iHeight, strZzu, i2, zzfkyVar.zzr, insetsZzf, zzeutVar);
    }
}
