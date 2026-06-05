package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcku;

/* JADX INFO: loaded from: classes3.dex */
public final class zzj {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzj(zzcku zzckuVar) throws zzh {
        this.zzb = zzckuVar.getLayoutParams();
        ViewParent parent = zzckuVar.getParent();
        this.zzd = zzckuVar.zzK();
        if (!(parent instanceof ViewGroup)) {
            throw new zzh("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzckuVar.zzE());
        viewGroup.removeView(zzckuVar.zzE());
        zzckuVar.zzag(true);
    }
}
