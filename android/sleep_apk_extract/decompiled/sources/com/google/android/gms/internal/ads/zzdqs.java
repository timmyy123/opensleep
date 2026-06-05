package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdqs {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzfky zzc;
    private final zzdpy zzd;
    private final zzdpt zze;
    private final zzdrg zzf;
    private final zzdro zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzblt zzj;
    private final zzdpq zzk;

    public zzdqs(com.google.android.gms.ads.internal.util.zzg zzgVar, zzfky zzfkyVar, zzdpy zzdpyVar, zzdpt zzdptVar, zzdrg zzdrgVar, zzdro zzdroVar, Executor executor, Executor executor2, zzdpq zzdpqVar) {
        this.zzb = zzgVar;
        this.zzc = zzfkyVar;
        this.zzj = zzfkyVar.zzj;
        this.zzd = zzdpyVar;
        this.zze = zzdptVar;
        this.zzf = zzdrgVar;
        this.zzg = zzdroVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdpqVar;
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        zzdpt zzdptVar = this.zze;
        View viewZzJ = z ? zzdptVar.zzJ() : zzdptVar.zzK();
        if (viewZzJ == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzJ.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzJ.getParent()).removeView(viewZzJ);
        }
        viewGroup.addView(viewZzJ, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeK)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    public final void zza(final zzdrq zzdrqVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf(zzdrqVar);
            }
        });
    }

    public final void zzb(zzdrq zzdrqVar) {
        zzdrg zzdrgVar;
        if (zzdrqVar == null || (zzdrgVar = this.zzf) == null || zzdrqVar.zzdA() == null || !this.zzd.zzb()) {
            return;
        }
        try {
            zzdrqVar.zzdA().addView(zzdrgVar.zza());
        } catch (zzclj e) {
            com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
        }
    }

    public final void zzc(zzdrq zzdrqVar) {
        if (zzdrqVar == null) {
            return;
        }
        Context context = zzdrqVar.zzdF().getContext();
        if (com.google.android.gms.ads.internal.util.zzbs.zzi(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Activity context is needed for policy validator.");
                return;
            }
            zzdro zzdroVar = this.zzg;
            if (zzdroVar == null || zzdrqVar.zzdA() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(zzdroVar.zza(zzdrqVar.zzdA(), windowManager), com.google.android.gms.ads.internal.util.zzbs.zzk());
            } catch (zzclj e) {
                com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final boolean zzd(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    public final boolean zze(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void zzf(zzdrq zzdrqVar) {
        ViewGroup viewGroup;
        View viewZzA;
        final ViewGroup viewGroup2;
        zzbmb zzbmbVarZza;
        Drawable drawable;
        zzdpy zzdpyVar = this.zzd;
        if (zzdpyVar.zze() || zzdpyVar.zzc()) {
            String[] strArr = {"1098", "3011"};
            for (int i = 0; i < 2; i++) {
                View viewZzl = zzdrqVar.zzl(strArr[i]);
                if (viewZzl instanceof ViewGroup) {
                    viewGroup = (ViewGroup) viewZzl;
                    break;
                }
            }
            viewGroup = null;
        } else {
            viewGroup = null;
        }
        Context context = zzdrqVar.zzdF().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdpt zzdptVar = this.zze;
        if (zzdptVar.zzA() != null) {
            viewZzA = zzdptVar.zzA();
            zzblt zzbltVar = this.zzj;
            if (zzbltVar != null && viewGroup == null) {
                zzh(layoutParams, zzbltVar.zze);
                viewZzA.setLayoutParams(layoutParams);
                viewGroup = null;
            }
        } else if (zzdptVar.zzz() instanceof zzblm) {
            zzblm zzblmVar = (zzblm) zzdptVar.zzz();
            if (viewGroup == null) {
                zzh(layoutParams, zzblmVar.zzi());
                viewGroup = null;
            }
            View zzblnVar = new zzbln(context, zzblmVar, layoutParams);
            zzblnVar.setContentDescription((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeI));
            viewZzA = zzblnVar;
        } else {
            viewZzA = null;
        }
        if (viewZzA != null) {
            if (viewZzA.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewZzA.getParent()).removeView(viewZzA);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(viewZzA);
            } else {
                com.google.android.gms.ads.formats.zza zzaVar = new com.google.android.gms.ads.formats.zza(zzdrqVar.zzdF().getContext());
                zzaVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zzaVar.addView(viewZzA);
                FrameLayout frameLayoutZzdA = zzdrqVar.zzdA();
                if (frameLayoutZzdA != null) {
                    frameLayoutZzdA.addView(zzaVar);
                }
            }
            zzdrqVar.zzh(zzdrqVar.zzm(), viewZzA, true);
        }
        zzgwm zzgwmVar = zzdqo.zza;
        int size = zzgwmVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View viewZzl2 = zzdrqVar.zzl((String) zzgwmVar.get(i2));
            i2++;
            if (viewZzl2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewZzl2;
                break;
            }
        }
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzg(viewGroup2);
            }
        });
        if (viewGroup2 == null) {
            return;
        }
        if (zzi(viewGroup2, true)) {
            if (zzdptVar.zzT() != null) {
                zzdptVar.zzT().zzaq(new zzdqp(zzdrqVar, viewGroup2));
                return;
            }
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlv)).booleanValue() && zzi(viewGroup2, false)) {
            if (zzdptVar.zzU() != null) {
                zzdptVar.zzU().zzaq(new zzdqp(zzdrqVar, viewGroup2));
                return;
            }
            return;
        }
        viewGroup2.removeAllViews();
        View viewZzdF = zzdrqVar.zzdF();
        Context context2 = viewZzdF != null ? viewZzdF.getContext() : null;
        if (context2 == null || (zzbmbVarZza = this.zzk.zza()) == null) {
            return;
        }
        try {
            IObjectWrapper iObjectWrapperZzg = zzbmbVarZza.zzg();
            if (iObjectWrapperZzg == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzg)) == null) {
                return;
            }
            ImageView imageView = new ImageView(context2);
            imageView.setImageDrawable(drawable);
            IObjectWrapper iObjectWrapperZzn = zzdrqVar.zzn();
            if (iObjectWrapperZzn != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhg)).booleanValue()) {
                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzn));
                } else {
                    imageView.setScaleType(zza);
                }
            }
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewGroup2.addView(imageView);
        } catch (RemoteException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not get main image drawable");
        }
    }

    public final /* synthetic */ void zzg(ViewGroup viewGroup) {
        zzdpt zzdptVar = this.zze;
        if (zzdptVar.zzJ() != null) {
            boolean z = viewGroup != null;
            if (zzdptVar.zzx() == 2 || zzdptVar.zzx() == 1) {
                this.zzb.zzr(this.zzc.zzg, String.valueOf(zzdptVar.zzx()), z);
            } else if (zzdptVar.zzx() == 6) {
                com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzb;
                String str = this.zzc.zzg;
                zzgVar.zzr(str, "2", z);
                zzgVar.zzr(str, AppEventsConstants.EVENT_PARAM_VALUE_YES, z);
            }
        }
    }
}
