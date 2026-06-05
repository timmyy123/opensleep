package com.google.android.gms.ads.nonagon.signalgeneration;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbap;
import com.google.android.gms.internal.ads.zzbaq;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbjv;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzceq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcnj;
import com.google.android.gms.internal.ads.zzdca;
import com.google.android.gms.internal.ads.zzdiq;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdyu;
import com.google.android.gms.internal.ads.zzdzq;
import com.google.android.gms.internal.ads.zzfkx;
import com.google.android.gms.internal.ads.zzflc;
import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzfqg;
import com.google.android.gms.internal.ads.zzfqj;
import com.google.android.gms.internal.ads.zzfsc;
import com.google.android.gms.internal.ads.zzgta;
import com.google.android.gms.internal.ads.zzgua;
import com.google.android.gms.internal.ads.zzhbd;
import com.google.android.gms.internal.ads.zzhbe;
import com.google.android.gms.internal.ads.zzhbo;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.android.gms.internal.ads.zzhcg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzap extends zzcel {
    protected static final List zza = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List zzb = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List zzc = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List zzd = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    private final List zzB;
    private final List zzC;
    private final List zzD;
    private final List zzE;
    private final zzbjv zzI;
    private final zzj zzJ;
    private final zza zzK;
    private final zzcnj zzf;
    private Context zzg;
    private final zzbap zzh;
    private final zzflc zzi;
    private final zzflx zzj;
    private final zzhcg zzk;
    private final ScheduledExecutorService zzl;
    private zzbzt zzm;
    private final zzdzq zzp;
    private final zzfsc zzq;
    private final VersionInfoParcel zzy;
    private String zzz;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final AtomicInteger zzx = new AtomicInteger(0);
    private final AtomicBoolean zzF = new AtomicBoolean(false);
    private final AtomicBoolean zzG = new AtomicBoolean(false);
    private final AtomicInteger zzH = new AtomicInteger(0);
    private final boolean zzr = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzik)).booleanValue();
    private final boolean zzs = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzij)).booleanValue();
    private final boolean zzt = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzim)).booleanValue();
    private final boolean zzu = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzio)).booleanValue();
    private final String zzv = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzin);
    private final String zzw = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzip);
    private final String zzA = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziq);

    public zzap(zzcnj zzcnjVar, Context context, zzbap zzbapVar, zzflx zzflxVar, zzhcg zzhcgVar, ScheduledExecutorService scheduledExecutorService, zzdzq zzdzqVar, zzfsc zzfscVar, VersionInfoParcel versionInfoParcel, zzbjv zzbjvVar, zzflc zzflcVar, zzj zzjVar, zza zzaVar) {
        List listZzaa;
        this.zzf = zzcnjVar;
        this.zzg = context;
        this.zzh = zzbapVar;
        this.zzi = zzflcVar;
        this.zzj = zzflxVar;
        this.zzk = zzhcgVar;
        this.zzl = scheduledExecutorService;
        this.zzp = zzdzqVar;
        this.zzq = zzfscVar;
        this.zzy = versionInfoParcel;
        this.zzI = zzbjvVar;
        this.zzJ = zzjVar;
        this.zzK = zzaVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzir)).booleanValue()) {
            this.zzB = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzis));
            this.zzC = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzit));
            this.zzD = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziu));
            listZzaa = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziv));
        } else {
            this.zzB = zza;
            this.zzC = zzb;
            this.zzD = zzc;
            listZzaa = zzd;
        }
        this.zzE = listZzaa;
    }

    public static final /* synthetic */ Uri zzQ(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzZ(uri, "nas", str) : uri;
    }

    private final void zzR(final List list, final IObjectWrapper iObjectWrapper, zzbzq zzbzqVar, boolean z) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziA)).booleanValue()) {
            try {
                zzbzqVar.zzf("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
                return;
            }
        }
        zzhcg zzhcgVar = this.zzk;
        ListenableFuture listenableFutureZzc = zzhcgVar.zzc(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzad
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzo(list, iObjectWrapper);
            }
        });
        if (zzY()) {
            listenableFutureZzc = zzhbw.zzj(listenableFutureZzc, new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaf
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzp((ArrayList) obj);
                }
            }, zzhcgVar);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Asset view map is empty.");
        }
        zzhbw.zzr(listenableFutureZzc, new zzz(this, zzbzqVar, z), this.zzf.zzb());
    }

    private final void zzS(List list, final IObjectWrapper iObjectWrapper, zzbzq zzbzqVar, boolean z) {
        ListenableFuture listenableFutureZzc;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziA)).booleanValue()) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("The updating URL feature is not enabled.");
            try {
                zzbzqVar.zzf("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
                return;
            }
        }
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (zzd((Uri) it.next())) {
                i2++;
            }
        }
        if (i2 > 1) {
            String strValueOf = String.valueOf(list);
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Multiple google urls found: ".concat(strValueOf));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (zzd(uri)) {
                zzhcg zzhcgVar = this.zzk;
                listenableFutureZzc = zzhcgVar.zzc(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzag
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return this.zza.zzq(uri, iObjectWrapper);
                    }
                });
                if (zzY()) {
                    listenableFutureZzc = zzhbw.zzj(listenableFutureZzc, new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzah
                        @Override // com.google.android.gms.internal.ads.zzhbe
                        public final /* synthetic */ ListenableFuture zza(Object obj) {
                            return this.zza.zzr((Uri) obj);
                        }
                    }, zzhcgVar);
                } else {
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Asset view map is empty.");
                }
            } else {
                String strValueOf2 = String.valueOf(uri);
                int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Not a Google URL: ".concat(strValueOf2));
                listenableFutureZzc = zzhbw.zza(uri);
            }
            arrayList.add(listenableFutureZzc);
        }
        zzhbw.zzr(zzhbw.zzm(arrayList), new zzaa(this, zzbzqVar, z), this.zzf.zzb());
    }

    private final void zzT() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkX)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzla)).booleanValue()) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzle)).booleanValue() && this.zzF.getAndSet(true)) {
                return;
            }
            zzx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzU, reason: merged with bridge method [inline-methods] */
    public final void zzx() {
        zzap zzapVar;
        ListenableFuture listenableFutureZzc;
        if (((Boolean) zzbkv.zze.zze()).booleanValue()) {
            this.zzJ.zza();
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmy)).booleanValue()) {
            listenableFutureZzc = zzhbw.zzf(new zzhbd() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzai
                @Override // com.google.android.gms.internal.ads.zzhbd
                public final /* synthetic */ ListenableFuture zza() {
                    return this.zza.zzs();
                }
            }, zzcfr.zza);
            zzapVar = this;
        } else {
            try {
                zzapVar = this;
                try {
                    listenableFutureZzc = zzapVar.zzW(this.zzg, null, AdFormat.BANNER.name(), null, null, new Bundle()).zza();
                } catch (NullPointerException e) {
                    e = e;
                    listenableFutureZzc = zzhbw.zzc(e);
                }
            } catch (NullPointerException e2) {
                e = e2;
                zzapVar = this;
            }
        }
        zzhbw.zzr(listenableFutureZzc, new zzab(zzapVar), zzapVar.zzf.zzb());
    }

    private static boolean zzV(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzx zzW(Context context, String str, String str2, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, Bundle bundle) {
        zzfkx zzfkxVar = new zzfkx();
        if ("REWARDED".equals(str2)) {
            zzfkxVar.zzj().zza(2);
        } else if ("REWARDED_INTERSTITIAL".equals(str2)) {
            zzfkxVar.zzj().zza(3);
        }
        zzw zzwVarZzr = this.zzf.zzr();
        zzdca zzdcaVar = new zzdca();
        zzdcaVar.zza(context);
        if (str == null) {
            str = "adUnitId";
        }
        zzfkxVar.zzg(str);
        if (zzmVar == null) {
            zzmVar = new com.google.android.gms.ads.internal.client.zzn().zza();
        }
        zzfkxVar.zza(zzmVar);
        if (zzrVar == null) {
            switch (str2.hashCode()) {
                case -1999289321:
                    zzrVar = !str2.equals("NATIVE") ? new com.google.android.gms.ads.internal.client.zzr() : com.google.android.gms.ads.internal.client.zzr.zzb();
                    break;
                case -428325382:
                    if (str2.equals("APP_OPEN_AD")) {
                        zzrVar = com.google.android.gms.ads.internal.client.zzr.zzd();
                        break;
                    }
                    break;
                case 543046670:
                    if (str2.equals("REWARDED")) {
                        zzrVar = com.google.android.gms.ads.internal.client.zzr.zzc();
                        break;
                    }
                    break;
                case 1854800829:
                    if (str2.equals("REWARDED_INTERSTITIAL")) {
                    }
                    break;
                case 1951953708:
                    if (str2.equals("BANNER")) {
                        zzrVar = new com.google.android.gms.ads.internal.client.zzr(context, AdSize.BANNER);
                        break;
                    }
                    break;
            }
        }
        zzfkxVar.zzc(zzrVar);
        zzfkxVar.zzu(true);
        zzfkxVar.zzv(bundle);
        zzdcaVar.zzb(zzfkxVar.zzB());
        zzwVarZzr.zzc(zzdcaVar.zze());
        zzas zzasVar = new zzas();
        zzasVar.zza(str2);
        zzwVarZzr.zzb(new zzat(zzasVar, null));
        new zzdiq();
        return zzwVarZzr.zza();
    }

    private final ListenableFuture zzX(final String str) {
        final zzdux[] zzduxVarArr = new zzdux[1];
        ListenableFuture listenableFutureZzb = this.zzj.zzb();
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzan
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzu(zzduxVarArr, str, (zzdux) obj);
            }
        };
        zzhcg zzhcgVar = this.zzk;
        ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZzb, zzhbeVar, zzhcgVar);
        listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzae
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzv(zzduxVarArr);
            }
        }, zzhcgVar);
        return (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzi(zzhbo.zzw(listenableFutureZzj), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziB)).intValue(), TimeUnit.MILLISECONDS, this.zzl), zzal.zza, zzhcgVar), Exception.class, zzam.zza, zzhcgVar);
    }

    private final boolean zzY() {
        Map map;
        zzbzt zzbztVar = this.zzm;
        return (zzbztVar == null || (map = zzbztVar.zzb) == null || map.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri zzZ(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = iIndexOf + 1;
        StringBuilder sb = new StringBuilder(string.substring(0, i));
        FileInsert$$ExternalSyntheticOutline0.m(sb, str, "=", str2, "&");
        sb.append(string.substring(i));
        return Uri.parse(sb.toString());
    }

    private static final List zzaa(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzgua.zzc(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ zzfqg zzy(ListenableFuture listenableFuture, zzceq zzceqVar) {
        if (!zzfqj.zza() || !((Boolean) zzbkj.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfqg zzfqgVarZzb = ((zzx) zzhbw.zzs(listenableFuture)).zzb();
            zzfqgVarZzb.zzb(new ArrayList(Collections.singletonList(zzceqVar.zzb)));
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzceqVar.zzd;
            zzfqgVarZzb.zzc(zzmVar == null ? "" : zzmVar.zzp);
            zzfqgVarZzb.zzd(zzmVar.zzm);
            return zzfqgVarZzb;
        } catch (ExecutionException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    public final /* synthetic */ zzdzq zzA() {
        return this.zzp;
    }

    public final /* synthetic */ zzfsc zzB() {
        return this.zzq;
    }

    public final /* synthetic */ boolean zzC() {
        return this.zzr;
    }

    public final /* synthetic */ boolean zzD() {
        return this.zzs;
    }

    public final /* synthetic */ boolean zzE() {
        return this.zzt;
    }

    public final /* synthetic */ boolean zzF() {
        return this.zzu;
    }

    public final /* synthetic */ String zzG() {
        return this.zzv;
    }

    public final /* synthetic */ String zzH() {
        return this.zzw;
    }

    public final /* synthetic */ AtomicInteger zzI() {
        return this.zzx;
    }

    public final /* synthetic */ VersionInfoParcel zzJ() {
        return this.zzy;
    }

    public final /* synthetic */ String zzK() {
        return this.zzz;
    }

    public final /* synthetic */ void zzL(String str) {
        this.zzz = str;
    }

    public final /* synthetic */ String zzM() {
        return this.zzA;
    }

    public final /* synthetic */ AtomicBoolean zzN() {
        return this.zzG;
    }

    public final /* synthetic */ AtomicInteger zzO() {
        return this.zzH;
    }

    public final boolean zzc(Uri uri) {
        return zzV(uri, this.zzD, this.zzE);
    }

    public final boolean zzd(Uri uri) {
        return zzV(uri, this.zzB, this.zzC);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b6  */
    @Override // com.google.android.gms.internal.ads.zzcem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zze(IObjectWrapper iObjectWrapper, final zzceq zzceqVar, zzcej zzcejVar) {
        ListenableFuture listenableFutureZzc;
        ListenableFuture listenableFuture;
        zzap zzapVar;
        ListenableFuture listenableFutureZzc2;
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcN)).booleanValue()) {
            bundle.putLong(zzdyu.PUBLIC_API_CALL.zza(), zzceqVar.zzd.zzz);
            bundle.putLong(zzdyu.DYNAMITE_ENTER.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        this.zzg = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdi)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzay.zzc();
        }
        zzfpw zzfpwVarZzn = zzfpw.zzn(this.zzg, 22);
        zzfpwVarZzn.zza();
        if ("UNKNOWN".equals(zzceqVar.zzb)) {
            List arrayList = new ArrayList();
            zzbih zzbihVar = zzbiq.zziz;
            if (!((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).isEmpty()) {
                arrayList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).split(","));
            }
            if (arrayList.contains(zzv.zzc(zzceqVar.zzd))) {
                ListenableFuture listenableFutureZzc3 = zzhbw.zzc(new IllegalArgumentException("Unknown format is no longer supported."));
                zzapVar = this;
                listenableFuture = listenableFutureZzc3;
                listenableFutureZzc = zzhbw.zzc(new IllegalArgumentException("Unknown format is no longer supported."));
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmy)).booleanValue()) {
                    zzhcg zzhcgVar = zzcfr.zza;
                    ListenableFuture listenableFutureZzc4 = zzhcgVar.zzc(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzao
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            return this.zza.zzn(zzceqVar, bundle);
                        }
                    });
                    try {
                        listenableFutureZzc2 = zzhbw.zzj(listenableFutureZzc4, zzac.zza, zzhcgVar);
                    } catch (NullPointerException e) {
                        listenableFutureZzc2 = zzhbw.zzc(e);
                    }
                    zzapVar = this;
                    listenableFutureZzc = listenableFutureZzc2;
                    listenableFuture = listenableFutureZzc4;
                } else {
                    zzx zzxVarZzW = zzW(this.zzg, zzceqVar.zza, zzceqVar.zzb, zzceqVar.zzc, zzceqVar.zzd, bundle);
                    ListenableFuture listenableFutureZza = zzhbw.zza(zzxVarZzW);
                    try {
                        listenableFutureZzc = zzxVarZzW.zza();
                    } catch (NullPointerException e2) {
                        listenableFutureZzc = zzhbw.zzc(e2);
                    }
                    listenableFuture = listenableFutureZza;
                    zzapVar = this;
                }
            }
        }
        zzhbw.zzr(listenableFutureZzc, new zzy(zzapVar, listenableFuture, zzceqVar, zzcejVar, zzfpwVarZzn), zzapVar.zzf.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzf(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziA)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbzt zzbztVar = this.zzm;
            this.zzn = zzbs.zzh(motionEvent, zzbztVar == null ? null : zzbztVar.zza);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzn;
            motionEventObtain.setLocation(point.x, point.y);
            this.zzh.zzc(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        zzR(list, iObjectWrapper, zzbzqVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        zzS(list, iObjectWrapper, zzbzqVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzi(zzbzt zzbztVar) {
        this.zzm = zzbztVar;
        this.zzj.zza(1);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkW)).booleanValue()) {
            zzbih zzbihVar = zzbiq.zziy;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                zzT();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("The webView cannot be null.");
                return;
            }
            zza zzaVar = this.zzK;
            zze zzeVar = new zze(webView, zzaVar, zzcfr.zzf);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzp, this.zzq, this.zzi, this.zzJ, zzaVar, zzeVar), "gmaSdk");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlg)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzh().zzm();
            }
            if (((Boolean) zzbkv.zzc.zze()).booleanValue()) {
                zzaVar.zza(webView);
                if (((Boolean) zzbkv.zzd.zze()).booleanValue()) {
                    zzeVar.zza();
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                zzT();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        zzR(list, iObjectWrapper, zzbzqVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        zzS(list, iObjectWrapper, zzbzqVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final IObjectWrapper zzm(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlk)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        CustomTabsClient customTabsClient = (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2);
        CustomTabsCallback customTabsCallback = (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3);
        zzbjv zzbjvVar = this.zzI;
        zzbjvVar.zza(context, customTabsClient, str, customTabsCallback);
        if (((Boolean) zzbkv.zze.zze()).booleanValue()) {
            this.zzJ.zza();
        }
        if (((Boolean) zzbkv.zzc.zze()).booleanValue()) {
            this.zzK.zza(null);
        }
        return ObjectWrapper.wrap(zzbjvVar.zzb());
    }

    public final /* synthetic */ zzx zzn(zzceq zzceqVar, Bundle bundle) {
        return zzW(this.zzg, zzceqVar.zza, zzceqVar.zzb, zzceqVar.zzc, zzceqVar.zzd, bundle);
    }

    public final /* synthetic */ ArrayList zzo(List list, IObjectWrapper iObjectWrapper) throws Exception {
        zzbap zzbapVar = this.zzh;
        String strZzj = zzbapVar.zzb() != null ? zzbapVar.zzb().zzj(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : "";
        if (TextUtils.isEmpty(strZzj)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzc(uri)) {
                arrayList.add(zzZ(uri, "ms", strZzj));
            } else {
                String strValueOf = String.valueOf(uri);
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Not a Google URL: ".concat(strValueOf));
                arrayList.add(uri);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }

    public final /* synthetic */ ListenableFuture zzp(final ArrayList arrayList) {
        return zzhbw.zzk(zzX("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzgta() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaj
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzt(arrayList, (String) obj);
            }
        }, this.zzk);
    }

    public final /* synthetic */ Uri zzq(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzflc zzflcVar;
        try {
            uri = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznw)).booleanValue() || (zzflcVar = this.zzi) == null) ? this.zzh.zzd(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : zzflcVar.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzbaq e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    public final /* synthetic */ ListenableFuture zzr(final Uri uri) {
        return zzhbw.zzk(zzX("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzgta(this) { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzak
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return zzap.zzQ(uri, (String) obj);
            }
        }, this.zzk);
    }

    public final /* synthetic */ ListenableFuture zzs() {
        try {
            return zzW(this.zzg, null, AdFormat.BANNER.name(), null, null, new Bundle()).zza();
        } catch (NullPointerException e) {
            return zzhbw.zzc(e);
        }
    }

    public final /* synthetic */ ArrayList zzt(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzc(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzZ(uri, "nas", str));
            }
        }
        return arrayList;
    }

    public final /* synthetic */ ListenableFuture zzu(zzdux[] zzduxVarArr, String str, zzdux zzduxVar) throws JSONException {
        zzduxVarArr[0] = zzduxVar;
        Context context = this.zzg;
        zzbzt zzbztVar = this.zzm;
        Map map = zzbztVar.zzb;
        JSONObject jSONObjectZze = zzbs.zze(context, map, map, zzbztVar.zza, null);
        JSONObject jSONObjectZzb = zzbs.zzb(this.zzg, this.zzm.zza);
        JSONObject jSONObjectZzc = zzbs.zzc(this.zzm.zza);
        JSONObject jSONObjectZzd = zzbs.zzd(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", jSONObjectZze);
        jSONObject.put("ad_view_signal", jSONObjectZzb);
        jSONObject.put("scroll_view_signal", jSONObjectZzc);
        jSONObject.put("lock_screen_signal", jSONObjectZzd);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbs.zzf(null, this.zzg, this.zzo, this.zzn));
        }
        return zzduxVar.zzc(str, jSONObject);
    }

    public final /* synthetic */ void zzv(zzdux[] zzduxVarArr) {
        zzdux zzduxVar = zzduxVarArr[0];
        if (zzduxVar != null) {
            this.zzj.zzc(zzhbw.zza(zzduxVar));
        }
    }

    public final /* synthetic */ void zzw(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzd((Uri) it.next())) {
                this.zzx.getAndIncrement();
                return;
            }
        }
    }

    public final /* synthetic */ Context zzz() {
        return this.zzg;
    }
}
