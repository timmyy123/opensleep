package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbyf extends zzbyg implements zzbpq {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcku zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbhx zzk;
    private float zzl;
    private int zzm;

    public zzbyf(zzcku zzckuVar, Context context, zzbhx zzbhxVar) {
        super(zzckuVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzckuVar;
        this.zzi = context;
        this.zzk = zzbhxVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectPut;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.client.zzay.zza();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = com.google.android.gms.ads.internal.util.client.zzf.zzC(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzay.zza();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = com.google.android.gms.ads.internal.util.client.zzf.zzC(displayMetrics2, displayMetrics2.heightPixels);
        zzcku zzckuVar = this.zzh;
        Activity activityZzj = zzckuVar.zzj();
        if (activityZzj == null || activityZzj.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            com.google.android.gms.ads.internal.zzt.zzc();
            int[] iArrZzV = com.google.android.gms.ads.internal.util.zzs.zzV(activityZzj);
            com.google.android.gms.ads.internal.client.zzay.zza();
            this.zzd = com.google.android.gms.ads.internal.util.client.zzf.zzC(this.zza, iArrZzV[0]);
            com.google.android.gms.ads.internal.client.zzay.zza();
            this.zze = com.google.android.gms.ads.internal.util.client.zzf.zzC(this.zza, iArrZzV[1]);
        }
        if (zzckuVar.zzN().zzg()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            zzckuVar.measure(0, 0);
        }
        zzl(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbye zzbyeVar = new zzbye();
        zzbhx zzbhxVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbyeVar.zzb(zzbhxVar.zzc(intent));
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbyeVar.zza(zzbhxVar.zzc(intent2));
        zzbyeVar.zzc(zzbhxVar.zzb());
        zzbyeVar.zzd(zzbhxVar.zza());
        zzbyeVar.zze(true);
        boolean zZzf = zzbyeVar.zzf();
        boolean zZzg = zzbyeVar.zzg();
        boolean zZzh = zzbyeVar.zzh();
        boolean zZzi = zzbyeVar.zzi();
        try {
            jSONObjectPut = new JSONObject().put("sms", zZzf).put("tel", zZzg).put("calendar", zZzh).put("storePicture", zZzi).put("inlineVideo", zzbyeVar.zzj());
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObjectPut = null;
        }
        zzckuVar.zzd("onDeviceFeaturesReceived", jSONObjectPut);
        int[] iArr = new int[2];
        zzckuVar.getLocationOnScreen(iArr);
        Context context = this.zzi;
        zzb(com.google.android.gms.ads.internal.client.zzay.zza().zza(context, iArr[0]), com.google.android.gms.ads.internal.client.zzay.zza().zza(context, iArr[1]));
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(2)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Dispatching Ready Event.");
        }
        zzh(zzckuVar.zzs().afmaVersion);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[PHI: r4
      0x0060: PHI (r4v2 int) = (r4v1 int), (r4v6 int) binds: [B:11:0x003f, B:17:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzb(int i, int i2) {
        int i3;
        Context context = this.zzi;
        int i4 = 0;
        if (context instanceof Activity) {
            com.google.android.gms.ads.internal.zzt.zzc();
            i3 = com.google.android.gms.ads.internal.util.zzs.zzW((Activity) context)[0];
        } else {
            i3 = 0;
        }
        zzcku zzckuVar = this.zzh;
        if (zzckuVar.zzN() == null || !zzckuVar.zzN().zzg()) {
            int width = zzckuVar.getWidth();
            int height = zzckuVar.getHeight();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzaE)).booleanValue()) {
                if (width == 0) {
                    width = zzckuVar.zzN() != null ? zzckuVar.zzN().zzb : 0;
                }
                if (height == 0) {
                    if (zzckuVar.zzN() != null) {
                        i4 = zzckuVar.zzN().zza;
                    }
                }
                this.zzf = com.google.android.gms.ads.internal.client.zzay.zza().zza(context, width);
                this.zzg = com.google.android.gms.ads.internal.client.zzay.zza().zza(context, i4);
            } else {
                i4 = height;
                this.zzf = com.google.android.gms.ads.internal.client.zzay.zza().zza(context, width);
                this.zzg = com.google.android.gms.ads.internal.client.zzay.zza().zza(context, i4);
            }
        }
        zzj(i, i2 - i3, this.zzf, this.zzg);
        zzckuVar.zzP().zzP(i, i2);
    }
}
