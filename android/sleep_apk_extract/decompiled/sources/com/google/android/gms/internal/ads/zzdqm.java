package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzdqm extends zzbmm implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdrq {
    private final WeakReference zza;
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzdpo zze;
    private zzbes zzf;

    public zzdqm(View view, HashMap map, HashMap map2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        com.google.android.gms.ads.internal.zzt.zzC();
        zzcge.zza(view, this);
        com.google.android.gms.ads.internal.zzt.zzC();
        zzcge.zzb(view, this);
        this.zza = new WeakReference(view);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.zzb.put(str, new WeakReference(view2));
                if (!"1098".equals(str) && !"3011".equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzd.putAll(this.zzb);
        for (Map.Entry entry2 : map2.entrySet()) {
            View view3 = (View) entry2.getValue();
            if (view3 != null) {
                this.zzc.put((String) entry2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzd.putAll(this.zzc);
        this.zzf = new zzbes(view.getContext(), view);
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzdpo zzdpoVar = this.zze;
        if (zzdpoVar != null) {
            zzdpoVar.zzi(view, zzdF(), zzi(), zzj(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdpo zzdpoVar = this.zze;
        if (zzdpoVar != null) {
            zzdpoVar.zzu(zzdF(), zzi(), zzj(), zzdpo.zzI(zzdF()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdpo zzdpoVar = this.zze;
        if (zzdpoVar != null) {
            zzdpoVar.zzu(zzdF(), zzi(), zzj(), zzdpo.zzI(zzdF()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdpo zzdpoVar = this.zze;
        if (zzdpoVar != null) {
            zzdpoVar.zzk(view, motionEvent, zzdF());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbmn
    public final synchronized void zzb(IObjectWrapper iObjectWrapper) {
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof zzdpo)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzdpo zzdpoVar = this.zze;
        if (zzdpoVar != null) {
            zzdpoVar.zzh(this);
        }
        zzdpo zzdpoVar2 = (zzdpo) objUnwrap;
        if (!zzdpoVar2.zzJ()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
        } else {
            this.zze = zzdpoVar2;
            zzdpoVar2.zzg(this);
            this.zze.zzN(zzdF());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmn
    public final synchronized void zzc() {
        zzdpo zzdpoVar = this.zze;
        if (zzdpoVar != null) {
            zzdpoVar.zzh(this);
            this.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmn
    public final synchronized void zzd(IObjectWrapper iObjectWrapper) {
        try {
            if (this.zze != null) {
                Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (!(objUnwrap instanceof View)) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
                }
                this.zze.zzx((View) objUnwrap);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final FrameLayout zzdA() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final View zzdF() {
        return (View) this.zza.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final zzbes zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized void zzh(String str, View view, boolean z) {
        this.zzd.put(str, new WeakReference(view));
        if (!"1098".equals(str) && !"3011".equals(str)) {
            this.zzb.put(str, new WeakReference(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized Map zzi() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized Map zzj() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized Map zzk() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized View zzl(String str) {
        WeakReference weakReference = (WeakReference) this.zzd.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized String zzm() {
        return "1007";
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized IObjectWrapper zzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized JSONObject zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized JSONObject zzp() {
        zzdpo zzdpoVar = this.zze;
        if (zzdpoVar == null) {
            return null;
        }
        return zzdpoVar.zzw(zzdF(), zzi(), zzj());
    }
}
