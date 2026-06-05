package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzcdi implements zzcdn {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zziij zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzcdk zzi;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzcdi(Context context, VersionInfoParcel versionInfoParcel, zzcdk zzcdkVar, String str, zzcdj zzcdjVar) {
        Preconditions.checkNotNull(zzcdkVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzi = zzcdkVar;
        Iterator it = zzcdkVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zziij zziijVarZzg = zzikn.zzg();
        zziijVarZzg.zzn(9);
        if (str != null) {
            zziijVarZzg.zzb(str);
            zziijVarZzg.zzc(str);
        }
        zziik zziikVarZzc = zziil.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zziikVarZzc.zza(str2);
        }
        zziijVarZzg.zzd((zziil) zziikVarZzc.zzbm());
        zzijz zzijzVarZzc = zzika.zzc();
        zzijzVarZzc.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = versionInfoParcel.afmaVersion;
        if (str3 != null) {
            zzijzVarZzc.zza(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzijzVarZzc.zzb(apkVersion);
        }
        zziijVarZzg.zzk((zzika) zzijzVarZzc.zzbm());
        this.zzd = zziijVarZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final zzcdk zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzb(String str) {
        synchronized (this.zzj) {
            zziij zziijVar = this.zzd;
            try {
                if (str == null) {
                    zziijVar.zzi();
                } else {
                    zziijVar.zzh(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzc() {
        return this.zzi.zzc && !this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzd(View view) {
        Bitmap bitmapCreateBitmap;
        boolean zIsDrawingCacheEnabled;
        if (this.zzi.zzc && !this.zzl) {
            com.google.android.gms.ads.internal.zzt.zzc();
            final Bitmap bitmap = null;
            if (view != null) {
                try {
                    zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                } catch (RuntimeException e) {
                    e = e;
                    bitmapCreateBitmap = null;
                }
                try {
                    view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
                } catch (RuntimeException e2) {
                    e = e2;
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Fail to capture the web view", e);
                }
                if (bitmapCreateBitmap == null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width == 0 || height == 0) {
                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Width or height of view is zero");
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(bitmapCreateBitmap2);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap = bitmapCreateBitmap2;
                        }
                    } catch (RuntimeException e3) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Fail to capture the webview", e3);
                    }
                } else {
                    bitmap = bitmapCreateBitmap;
                }
            }
            if (bitmap == null) {
                zzcdm.zza("Failed to capture the webview bitmap.");
                return;
            }
            this.zzl = true;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzg(bitmap);
                }
            };
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                runnable.run();
            } else {
                zzcfr.zza.execute(runnable);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zze(String str, Map map, int i) {
        synchronized (this.zzj) {
            if (i == 3) {
                try {
                    this.zzm = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            LinkedHashMap linkedHashMap = this.zze;
            if (linkedHashMap.containsKey(str)) {
                if (i == 3) {
                    ((zzijx) linkedHashMap.get(str)).zze(4);
                }
                return;
            }
            zzijx zzijxVarZze = zzijy.zze();
            int iZza = zzijw.zza(i);
            if (iZza != 0) {
                zzijxVarZze.zze(iZza);
            }
            zzijxVarZze.zza(linkedHashMap.size());
            zzijxVarZze.zzb(str);
            zziiw zziiwVarZzc = zziiz.zzc();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zziiu zziiuVarZzc = zziiv.zzc();
                        zziiuVarZzc.zza(zzida.zzx(str2));
                        zziiuVarZzc.zzb(zzida.zzx(str3));
                        zziiwVarZzc.zza((zziiv) zziiuVarZzc.zzbm());
                    }
                }
            }
            zzijxVarZze.zzc((zziiz) zziiwVarZzc.zzbm());
            linkedHashMap.put(str, zzijxVarZze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
        synchronized (this.zzj) {
            this.zze.keySet();
            ListenableFuture listenableFutureZza = zzhbw.zza(Collections.EMPTY_MAP);
            zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzcde
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzh((Map) obj);
                }
            };
            zzhcg zzhcgVar = zzcfr.zzh;
            ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZza, zzhbeVar, zzhcgVar);
            ListenableFuture listenableFutureZzi = zzhbw.zzi(listenableFutureZzj, 10L, TimeUnit.SECONDS, zzcfr.zzd);
            zzhbw.zzr(listenableFutureZzj, new zzcdd(this, listenableFutureZzi), zzhcgVar);
            zzc.add(listenableFutureZzi);
        }
    }

    public final /* synthetic */ void zzg(Bitmap bitmap) {
        zzicz zziczVarZzC = zzida.zzC();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zziczVarZzC);
        synchronized (this.zzj) {
            zziij zziijVar = this.zzd;
            zzijr zzijrVarZzc = zzijt.zzc();
            zzijrVarZzc.zzb(zziczVarZzC.zza());
            zzijrVarZzc.zza("image/png");
            zzijrVarZzc.zzc(2);
            zziijVar.zzj((zzijt) zzijrVarZzc.zzbm());
        }
    }

    public final /* synthetic */ ListenableFuture zzh(Map map) {
        int length;
        zzijx zzijxVar;
        ListenableFuture listenableFutureZzk;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        Object obj = this.zzj;
                        synchronized (obj) {
                            try {
                                length = jSONArrayOptJSONArray.length();
                                synchronized (obj) {
                                    zzijxVar = (zzijx) this.zze.get(str);
                                }
                            } finally {
                            }
                        }
                        if (zzijxVar == null) {
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 50);
                            sb.append("Cannot find the corresponding resource object for ");
                            sb.append(str);
                            zzcdm.zza(sb.toString());
                        } else {
                            for (int i = 0; i < length; i++) {
                                zzijxVar.zzd(jSONArrayOptJSONArray.getJSONObject(i).getString("threat_type"));
                            }
                            this.zza = (length > 0) | this.zza;
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzbky.zza.zze()).booleanValue()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Failed to get SafeBrowsing metadata", e);
                }
                return zzhbw.zzc(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z = this.zza;
        if (!(z && this.zzi.zzg) && (!(this.zzm && this.zzi.zzf) && (z || !this.zzi.zzd))) {
            return zzhbw.zza(null);
        }
        synchronized (this.zzj) {
            try {
                Iterator it = this.zze.values().iterator();
                while (it.hasNext()) {
                    this.zzd.zzf((zzijy) ((zzijx) it.next()).zzbm());
                }
                zziij zziijVar = this.zzd;
                zziijVar.zzl(this.zzf);
                zziijVar.zzm(this.zzg);
                if (zzcdm.zzb()) {
                    String strZza = zziijVar.zza();
                    String strZzg = zziijVar.zzg();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strZza).length() + 38 + String.valueOf(strZzg).length() + 15);
                    sb2.append("Sending SB report\n  url: ");
                    sb2.append(strZza);
                    sb2.append("\n  clickUrl: ");
                    sb2.append(strZzg);
                    sb2.append("\n  resources: \n");
                    StringBuilder sb3 = new StringBuilder(sb2.toString());
                    for (zzijy zzijyVar : zziijVar.zze()) {
                        sb3.append("    [");
                        sb3.append(zzijyVar.zzd());
                        sb3.append("] ");
                        sb3.append(zzijyVar.zzc());
                    }
                    zzcdm.zza(sb3.toString());
                }
                ListenableFuture listenableFutureZzb = new com.google.android.gms.ads.internal.util.zzbl(this.zzh).zzb(1, this.zzi.zzb, null, ((zzikn) zziijVar.zzbm()).zzaN());
                if (zzcdm.zzb()) {
                    listenableFutureZzb.addListener(zzcdg.zza, zzcfr.zza);
                }
                listenableFutureZzk = zzhbw.zzk(listenableFutureZzb, zzcdf.zza, zzcfr.zzh);
            } finally {
            }
        }
        return listenableFutureZzk;
    }
}
