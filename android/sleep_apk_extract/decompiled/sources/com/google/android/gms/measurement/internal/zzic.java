package com.google.android.gms.measurement.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaif;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class zzic implements zzjg {
    private static volatile zzic zzc;
    private long zzA;
    private volatile Boolean zzB;
    private volatile boolean zzC;
    private int zzD;
    private int zzE;
    final long zza;
    final long zzb;
    private final Context zzd;
    private final boolean zze;
    private final zzae zzf;
    private final zzal zzg;
    private final zzhh zzh;
    private final zzgu zzi;
    private final zzhz zzj;
    private final zzoc zzk;
    private final zzpp zzl;
    private final zzgn zzm;
    private final Clock zzn;
    private final zzmb zzo;
    private final zzlj zzp;
    private final zzd zzq;
    private final zzlo zzr;
    private final String zzs;
    private zzgl zzt;
    private zznl zzu;
    private zzbb zzv;
    private zzgi zzw;
    private zzlq zzx;
    private Boolean zzz;
    private boolean zzy = false;
    private final AtomicInteger zzF = new AtomicInteger(0);

    public zzic(zzjs zzjsVar) {
        Preconditions.checkNotNull(zzjsVar);
        Context context = zzjsVar.zza;
        zzae zzaeVar = new zzae(context);
        this.zzf = zzaeVar;
        zzfr.zza = zzaeVar;
        this.zzd = context;
        this.zze = zzjsVar.zze;
        this.zzB = zzjsVar.zzb;
        this.zzs = zzjsVar.zzh;
        this.zzC = true;
        com.google.android.gms.internal.measurement.zzlw.zza(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzn = defaultClock;
        com.google.android.gms.internal.measurement.zzjx.zza(context).zza("com.google.android.gms.measurement#".concat(String.valueOf(context.getPackageName())), 0, new String[0], null);
        com.google.android.gms.internal.measurement.zzlk.zza(context);
        Long l = zzjsVar.zzf;
        this.zza = l != null ? l.longValue() : defaultClock.currentTimeMillis();
        Long l2 = zzjsVar.zzg;
        this.zzb = l2 != null ? l2.longValue() : defaultClock.elapsedRealtime();
        this.zzg = new zzal(this);
        zzhh zzhhVar = new zzhh(this);
        zzhhVar.zzx();
        this.zzh = zzhhVar;
        zzgu zzguVar = new zzgu(this);
        zzguVar.zzx();
        this.zzi = zzguVar;
        zzpp zzppVar = new zzpp(this);
        zzppVar.zzx();
        this.zzl = zzppVar;
        this.zzm = new zzgn(new zzjr(zzjsVar, this));
        this.zzq = new zzd(this);
        zzmb zzmbVar = new zzmb(this);
        zzmbVar.zzc();
        this.zzo = zzmbVar;
        zzlj zzljVar = new zzlj(this);
        zzljVar.zzc();
        this.zzp = zzljVar;
        zzoc zzocVar = new zzoc(this);
        zzocVar.zzc();
        this.zzk = zzocVar;
        zzlo zzloVar = new zzlo(this);
        zzloVar.zzx();
        this.zzr = zzloVar;
        zzhz zzhzVar = new zzhz(this);
        zzhzVar.zzx();
        this.zzj = zzhzVar;
        com.google.android.gms.internal.measurement.zzdb zzdbVar = zzjsVar.zzd;
        boolean z = zzdbVar == null || zzdbVar.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            zzO(zzljVar);
            if (zzljVar.zzu.zzd.getApplicationContext() instanceof Application) {
                Application application = (Application) zzljVar.zzu.zzd.getApplicationContext();
                if (zzljVar.zza == null) {
                    zzljVar.zza = new zzky(zzljVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzljVar.zza);
                    application.registerActivityLifecycleCallbacks(zzljVar.zza);
                    zzgu zzguVar2 = zzljVar.zzu.zzi;
                    zzP(zzguVar2);
                    zzguVar2.zzk().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzP(zzguVar);
            zzguVar.zze().zza("Application context is not an Application");
        }
        zzhzVar.zzj(new zzia(this, zzjsVar));
    }

    public static final void zzL() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzM(zzf zzfVar) {
        if (zzfVar != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Component not created");
    }

    private static final void zzN(zzje zzjeVar) {
        if (zzjeVar != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Component not created");
    }

    private static final void zzO(zzg zzgVar) {
        if (zzgVar == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Component not created");
        } else {
            if (zzgVar.zza()) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Component not initialized: ".concat(String.valueOf(zzgVar.getClass())));
        }
    }

    private static final void zzP(zzjf zzjfVar) {
        if (zzjfVar == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Component not created");
        } else {
            if (zzjfVar.zzv()) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Component not initialized: ".concat(String.valueOf(zzjfVar.getClass())));
        }
    }

    public static zzic zzy(Context context, com.google.android.gms.internal.measurement.zzdb zzdbVar, Long l, Long l2) {
        Bundle bundle;
        if (zzdbVar != null) {
            Bundle bundle2 = zzdbVar.zzd;
            zzdbVar = new com.google.android.gms.internal.measurement.zzdb(zzdbVar.zza, zzdbVar.zzb, zzdbVar.zzc, bundle2, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (zzic.class) {
                try {
                    if (zzc == null) {
                        zzc = new zzic(new zzjs(context, zzdbVar, l, l2));
                    }
                } finally {
                }
            }
        } else if (zzdbVar != null && (bundle = zzdbVar.zzd) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzc);
            zzc.zzB = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzc);
        return zzc;
    }

    public final boolean zzA() {
        return this.zzB != null && this.zzB.booleanValue();
    }

    public final boolean zzB() {
        return zzC() == 0;
    }

    public final int zzC() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzal zzalVar = this.zzg;
        if (zzalVar.zzt()) {
            return 1;
        }
        zzP(zzhzVar);
        zzhzVar.zzg();
        if (!this.zzC) {
            return 8;
        }
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        Boolean boolZzi = zzhhVar.zzi();
        if (boolZzi != null) {
            return boolZzi.booleanValue() ? 0 : 3;
        }
        zzae zzaeVar = zzalVar.zzu.zzf;
        Boolean boolZzr = zzalVar.zzr("firebase_analytics_collection_enabled");
        return boolZzr != null ? boolZzr.booleanValue() ? 0 : 4 : (this.zzB == null || this.zzB.booleanValue()) ? 0 : 7;
    }

    public final void zzD(boolean z) {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        this.zzC = z;
    }

    public final boolean zzE() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        return this.zzC;
    }

    public final void zzF() {
        this.zzD++;
    }

    public final void zzG() {
        this.zzF.incrementAndGet();
    }

    public final boolean zzH() {
        boolean z = false;
        if (!this.zzy) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("AppMeasurement is not initialized");
            return false;
        }
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        Boolean bool = this.zzz;
        if (bool == null || this.zzA == 0 || (!bool.booleanValue() && Math.abs(this.zzn.elapsedRealtime() - this.zzA) > 1000)) {
            this.zzA = this.zzn.elapsedRealtime();
            zzpp zzppVar = this.zzl;
            zzN(zzppVar);
            if (zzppVar.zzab("android.permission.INTERNET")) {
                zzN(zzppVar);
                if (zzppVar.zzab("android.permission.ACCESS_NETWORK_STATE")) {
                    Context context = this.zzd;
                    if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzg.zzE() || (zzpp.zzax(context) && zzpp.zzS(context, false))) {
                        z = true;
                    }
                }
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            this.zzz = boolValueOf;
            if (boolValueOf.booleanValue()) {
                zzN(zzppVar);
                this.zzz = Boolean.valueOf(zzppVar.zzC(zzv().zzk()));
            }
        }
        return this.zzz.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzI() {
        NetworkInfo activeNetworkInfo;
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzlo zzloVar = this.zzr;
        zzP(zzloVar);
        zzP(zzloVar);
        String strZzj = zzv().zzj();
        if (!this.zzg.zzu()) {
            zzgu zzguVar = this.zzi;
            zzP(zzguVar);
            zzguVar.zzk().zza("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        Pair pairZzb = zzhhVar.zzb(strZzj);
        if (((Boolean) pairZzb.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZzb.first)) {
            zzgu zzguVar2 = this.zzi;
            zzP(zzguVar2);
            zzguVar2.zzk().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        zzP(zzloVar);
        zzloVar.zzw();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzloVar.zzu.zzd.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
                activeNetworkInfo = null;
            }
        } else {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            zzgu zzguVar3 = this.zzi;
            zzP(zzguVar3);
            zzguVar3.zze().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        zznl zznlVarZzt = zzt();
        zznlVarZzt.zzg();
        zznlVarZzt.zzb();
        if (zznlVarZzt.zzK()) {
            zzpp zzppVar = zznlVarZzt.zzu.zzl;
            zzN(zzppVar);
            if (zzppVar.zzak() >= 234200) {
            }
        } else {
            zzlj zzljVar = this.zzp;
            zzO(zzljVar);
            zzic zzicVar = zzljVar.zzu;
            zzljVar.zzg();
            zzao zzaoVarZzz = zzicVar.zzt().zzz();
            Bundle bundle = zzaoVarZzz != null ? zzaoVarZzz.zza : null;
            if (bundle == null) {
                int i = this.zzE;
                this.zzE = i + 1;
                boolean z = i < 10;
                zzgu zzguVar4 = this.zzi;
                zzP(zzguVar4);
                zzguVar4.zzj().zzb(FileInsert$$ExternalSyntheticOutline0.m(Fragment$$ExternalSyntheticOutline1.m(69, "Failed to retrieve DMA consent from the service, "), i < 10 ? "Retrying." : "Skipping.", " retryCount"), Integer.valueOf(this.zzE));
                return z;
            }
            zzjl zzjlVarZze = zzjl.zze(bundle, 100);
            sb.append("&gcs=");
            sb.append(zzjlVarZze.zzk());
            zzba zzbaVarZzh = zzba.zzh(bundle, 100);
            sb.append("&dma=");
            sb.append(!Objects.equals(zzbaVarZzh.zzj(), Boolean.FALSE) ? 1 : 0);
            if (!TextUtils.isEmpty(zzbaVarZzh.zzk())) {
                sb.append("&dma_cps=");
                sb.append(zzbaVarZzh.zzk());
            }
            int i2 = !Objects.equals(zzba.zzi(bundle), Boolean.TRUE) ? 1 : 0;
            sb.append("&npa=");
            sb.append(i2);
            zzgu zzguVar5 = this.zzi;
            zzP(zzguVar5);
            zzguVar5.zzk().zzb("Consent query parameters to Bow", sb);
        }
        zzpp zzppVar2 = this.zzl;
        zzN(zzppVar2);
        zzv().zzu.zzg.zzi();
        String str = (String) pairZzb.first;
        zzN(this.zzh);
        URL urlZzaw = zzppVar2.zzaw(161000L, strZzj, str, r1.zzp.zza() - 1, sb.toString());
        if (urlZzaw != null) {
            zzlo zzloVar2 = this.zzr;
            zzP(zzloVar2);
            zzll zzllVar = new zzll() { // from class: com.google.android.gms.measurement.internal.zzib
                @Override // com.google.android.gms.measurement.internal.zzll
                public final /* synthetic */ void zza(String str2, int i3, Throwable th, byte[] bArr, Map map) {
                    this.zza.zzJ(str2, i3, th, bArr, map);
                }
            };
            zzloVar2.zzw();
            Preconditions.checkNotNull(urlZzaw);
            Preconditions.checkNotNull(zzllVar);
            zzhz zzhzVar2 = zzloVar2.zzu.zzj;
            zzP(zzhzVar2);
            zzhzVar2.zzm(new zzln(zzloVar2, strZzj, urlZzaw, null, null, zzllVar));
        }
        return false;
    }

    public final /* synthetic */ void zzJ(String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        if (i != 200 && i != 204) {
            i2 = 304;
            if (i != 304) {
                i2 = i;
            }
            zzgu zzguVar = this.zzi;
            zzP(zzguVar);
            zzguVar.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
        }
        i2 = i;
        if (th == null) {
            zzhh zzhhVar = this.zzh;
            zzN(zzhhVar);
            zzhhVar.zzo.zzb(true);
            if (bArr == null || bArr.length == 0) {
                zzgu zzguVar2 = this.zzi;
                zzP(zzguVar2);
                zzguVar2.zzj().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String strOptString = jSONObject.optString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "");
                if (TextUtils.isEmpty(strOptString)) {
                    zzgu zzguVar3 = this.zzi;
                    zzP(zzguVar3);
                    zzguVar3.zzj().zza("Deferred Deep Link is empty.");
                    return;
                }
                String strOptString2 = jSONObject.optString("gclid", "");
                String strOptString3 = jSONObject.optString("gbraid", "");
                String strOptString4 = jSONObject.optString("gad_source", "");
                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                Bundle bundle = new Bundle();
                zzpp zzppVar = this.zzl;
                zzN(zzppVar);
                zzic zzicVar = zzppVar.zzu;
                if (!TextUtils.isEmpty(strOptString)) {
                    Context context = zzicVar.zzd;
                    List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0);
                    if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(strOptString3)) {
                            bundle.putString("gbraid", strOptString3);
                        }
                        if (!TextUtils.isEmpty(strOptString4)) {
                            bundle.putString("gad_source", strOptString4);
                        }
                        bundle.putString("gclid", strOptString2);
                        bundle.putString("_cis", "ddp");
                        this.zzp.zzE("auto", "_cmp", bundle);
                        zzN(zzppVar);
                        if (TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor editorEdit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            editorEdit.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, strOptString);
                            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(dOptDouble));
                            if (editorEdit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = zzppVar.zzu.zzd;
                                if (Build.VERSION.SDK_INT < 34) {
                                    context2.sendBroadcast(intent);
                                    return;
                                } else {
                                    context2.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                    return;
                                }
                            }
                            return;
                        } catch (RuntimeException e) {
                            zzgu zzguVar4 = zzppVar.zzu.zzi;
                            zzP(zzguVar4);
                            zzguVar4.zzb().zzb("Failed to persist Deferred Deep Link. exception", e);
                            return;
                        }
                    }
                }
                zzgu zzguVar5 = this.zzi;
                zzP(zzguVar5);
                zzguVar5.zze().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                return;
            } catch (JSONException e2) {
                zzgu zzguVar6 = this.zzi;
                zzP(zzguVar6);
                zzguVar6.zzb().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzgu zzguVar7 = this.zzi;
        zzP(zzguVar7);
        zzguVar7.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    public final /* synthetic */ void zzK(zzjs zzjsVar) {
        Bundle bundle;
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzal zzalVar = this.zzg;
        zzalVar.zzb();
        zzbb zzbbVar = new zzbb(this);
        zzbbVar.zzx();
        this.zzv = zzbbVar;
        com.google.android.gms.internal.measurement.zzdb zzdbVar = zzjsVar.zzd;
        long j = zzdbVar == null ? 0L : zzdbVar.zza;
        String string = "";
        if (zzdbVar != null && (bundle = zzdbVar.zzd) != null) {
            string = bundle.getString("runtime_google_app_id", "");
        }
        zzgi zzgiVar = new zzgi(this, zzjsVar.zzc, j, string);
        zzgiVar.zzc();
        this.zzw = zzgiVar;
        zzgl zzglVar = new zzgl(this);
        zzglVar.zzc();
        this.zzt = zzglVar;
        zznl zznlVar = new zznl(this);
        zznlVar.zzc();
        this.zzu = zznlVar;
        zzpp zzppVar = this.zzl;
        zzppVar.zzy();
        this.zzh.zzy();
        this.zzw.zzd();
        zzlq zzlqVar = new zzlq(this);
        zzlqVar.zzc();
        this.zzx = zzlqVar;
        zzlqVar.zzd();
        zzgu zzguVar = this.zzi;
        zzP(zzguVar);
        zzgs zzgsVarZzi = zzguVar.zzi();
        zzalVar.zzi();
        zzgsVarZzi.zzb("App measurement initialized, version", 161000L);
        zzP(zzguVar);
        zzguVar.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzj = zzgiVar.zzj();
        zzN(zzppVar);
        if (zzppVar.zzad(strZzj, zzalVar.zzz())) {
            zzP(zzguVar);
            zzguVar.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        } else {
            zzP(zzguVar);
            zzguVar.zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strZzj)));
        }
        zzP(zzguVar);
        zzguVar.zzj().zza("Debug-level message logging enabled");
        int i = this.zzD;
        AtomicInteger atomicInteger = this.zzF;
        if (i != atomicInteger.get()) {
            zzP(zzguVar);
            zzguVar.zzb().zzc("Not all components initialized", Integer.valueOf(this.zzD), Integer.valueOf(atomicInteger.get()));
        }
        this.zzy = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdb zzdbVar) {
        zzjl zzjlVarZza;
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        com.google.android.gms.internal.measurement.zzin zzinVarZzj = zzx().zzj();
        com.google.android.gms.internal.measurement.zzin zzinVar = com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE;
        zzaif.zza();
        zzfx zzfxVar = zzfy.zzaP;
        zzal zzalVar = this.zzg;
        boolean zZzp = zzalVar.zzp(null, zzfxVar);
        boolean z = zzinVarZzj == zzinVar;
        if (zZzp) {
            zzpp zzppVar = this.zzl;
            zzN(zzppVar);
            if (zzppVar.zzU()) {
                zzpp zzppVar2 = this.zzl;
                zzN(zzppVar2);
                zzppVar2.zzg();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                zzw zzwVar = new zzw(zzppVar2.zzu);
                zzic zzicVar = zzppVar2.zzu;
                ContextCompat.registerReceiver(zzicVar.zzd, zzwVar, intentFilter, 2);
                zzgu zzguVar = zzicVar.zzi;
                zzP(zzguVar);
                zzguVar.zzj().zza("Registered app receiver");
                if (z) {
                }
            } else if (z) {
                z = true;
                zzpp zzppVar22 = this.zzl;
                zzN(zzppVar22);
                zzppVar22.zzg();
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                intentFilter2.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                zzw zzwVar2 = new zzw(zzppVar22.zzu);
                zzic zzicVar2 = zzppVar22.zzu;
                ContextCompat.registerReceiver(zzicVar2.zzd, zzwVar2, intentFilter2, 2);
                zzgu zzguVar2 = zzicVar2.zzi;
                zzP(zzguVar2);
                zzguVar2.zzj().zza("Registered app receiver");
                if (z) {
                    zzx().zzh(((Long) zzfy.zzB.zzb(null)).longValue());
                }
            }
        }
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        zzjl zzjlVarZzl = zzhhVar.zzl();
        int iZzb = zzjlVarZzl.zzb();
        zzji zzjiVarZzw = zzalVar.zzw("google_analytics_default_allow_ad_storage", false);
        zzji zzjiVarZzw2 = zzalVar.zzw("google_analytics_default_allow_analytics_storage", false);
        zzji zzjiVar = zzji.UNINITIALIZED;
        if (zzjiVarZzw != zzjiVar || zzjiVarZzw2 != zzjiVar) {
            zzN(zzhhVar);
            if (zzhhVar.zzk(-10)) {
                zzjlVarZza = zzjl.zza(zzjiVarZzw, zzjiVarZzw2, -10);
            } else {
                if (!TextUtils.isEmpty(zzv().zzk()) && (iZzb == 0 || iZzb == 30 || iZzb == 10 || iZzb == 40)) {
                    zzlj zzljVar = this.zzp;
                    zzO(zzljVar);
                    zzljVar.zzs(new zzjl(null, null, -10), false);
                }
                zzjlVarZza = null;
            }
        }
        if (zzjlVarZza != null) {
            zzlj zzljVar2 = this.zzp;
            zzO(zzljVar2);
            zzljVar2.zzs(zzjlVarZza, true);
            zzjlVarZzl = zzjlVarZza;
        }
        zzlj zzljVar3 = this.zzp;
        zzO(zzljVar3);
        zzljVar3.zzz(zzjlVarZzl);
        zzN(zzhhVar);
        int iZzb2 = zzhhVar.zzj().zzb();
        zzji zzjiVarZzw3 = zzalVar.zzw("google_analytics_default_allow_ad_personalization_signals", true);
        if (zzjiVarZzw3 != zzjiVar) {
            zzgu zzguVar3 = this.zzi;
            zzP(zzguVar3);
            zzguVar3.zzk().zzb("Default ad personalization consent from Manifest", zzjiVarZzw3);
        }
        zzji zzjiVarZzw4 = zzalVar.zzw("google_analytics_default_allow_ad_user_data", true);
        if (zzjiVarZzw4 != zzjiVar && zzjl.zzu(-10, iZzb2)) {
            zzO(zzljVar3);
            zzljVar3.zzq(zzba.zza(zzjiVarZzw4, -10), true);
        } else if (!TextUtils.isEmpty(zzv().zzk()) && (iZzb2 == 0 || iZzb2 == 30)) {
            zzO(zzljVar3);
            zzljVar3.zzq(new zzba((Boolean) null, -10, (Boolean) null, (String) null), true);
        }
        Boolean boolZzr = zzalVar.zzr("google_analytics_tcf_data_enabled");
        if (boolZzr == null || boolZzr.booleanValue()) {
            zzgu zzguVar4 = this.zzi;
            zzP(zzguVar4);
            zzguVar4.zzj().zza("TCF client enabled.");
            zzO(zzljVar3);
            zzljVar3.zzD();
            zzO(zzljVar3);
            zzljVar3.zzC();
        }
        zzN(zzhhVar);
        zzhe zzheVar = zzhhVar.zzc;
        if (zzheVar.zza() == 0) {
            zzgu zzguVar5 = this.zzi;
            zzP(zzguVar5);
            long j = this.zza;
            zzguVar5.zzk().zzb("Persisting first open", Long.valueOf(j));
            zzN(zzhhVar);
            zzheVar.zzb(j);
        }
        zzO(zzljVar3);
        zzljVar3.zzb.zzc();
        if (zzH()) {
            if (!TextUtils.isEmpty(zzv().zzk())) {
                zzpp zzppVar3 = this.zzl;
                zzN(zzppVar3);
                String strZzk = zzv().zzk();
                zzN(zzhhVar);
                zzhhVar.zzg();
                if (zzppVar3.zzD(strZzk, zzhhVar.zzd().getString("gmp_app_id", null))) {
                    zzgu zzguVar6 = this.zzi;
                    zzP(zzguVar6);
                    zzguVar6.zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzN(zzhhVar);
                    zzhhVar.zzg();
                    Boolean boolZzi = zzhhVar.zzi();
                    SharedPreferences.Editor editorEdit = zzhhVar.zzd().edit();
                    editorEdit.clear();
                    editorEdit.apply();
                    if (boolZzi != null) {
                        zzhhVar.zzh(boolZzi);
                    }
                    zzm().zzh();
                    this.zzu.zzM();
                    this.zzu.zzI();
                    zzN(zzhhVar);
                    zzheVar.zzb(this.zza);
                    zzN(zzhhVar);
                    zzhhVar.zze.zzb(null);
                }
                zzN(zzhhVar);
                String strZzk2 = zzv().zzk();
                zzhhVar.zzg();
                SharedPreferences.Editor editorEdit2 = zzhhVar.zzd().edit();
                editorEdit2.putString("gmp_app_id", strZzk2);
                editorEdit2.apply();
            }
            zzN(zzhhVar);
            if (!zzhhVar.zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
                zzN(zzhhVar);
                zzhhVar.zze.zzb(null);
            }
            zzO(zzljVar3);
            zzN(zzhhVar);
            zzljVar3.zzQ(zzhhVar.zze.zza());
            zzpp zzppVar4 = this.zzl;
            zzN(zzppVar4);
            try {
                zzppVar4.zzu.zzd.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            } catch (ClassNotFoundException unused) {
                zzhh zzhhVar2 = this.zzh;
                zzN(zzhhVar2);
                zzhg zzhgVar = zzhhVar2.zzq;
                if (!TextUtils.isEmpty(zzhgVar.zza())) {
                    zzgu zzguVar7 = this.zzi;
                    zzP(zzguVar7);
                    zzguVar7.zze().zza("Remote config removed with active feature rollouts");
                    zzN(zzhhVar2);
                    zzhgVar.zzb(null);
                }
            }
            if (!TextUtils.isEmpty(zzv().zzk())) {
                boolean zZzB = zzB();
                zzhh zzhhVar3 = this.zzh;
                zzN(zzhhVar3);
                if (!zzhhVar3.zzn() && !this.zzg.zzt()) {
                    zzN(zzhhVar3);
                    zzhhVar3.zzm(!zZzB);
                }
                if (zZzB) {
                    zzlj zzljVar4 = this.zzp;
                    zzO(zzljVar4);
                    zzljVar4.zzT();
                }
                zzoc zzocVar = this.zzk;
                zzO(zzocVar);
                zzocVar.zza.zza();
                zzt().zzC(new AtomicReference());
                zznl zznlVarZzt = zzt();
                zzN(zzhhVar3);
                zznlVarZzt.zzH(zzhhVar3.zzt.zza());
            }
        } else if (zzB()) {
            zzpp zzppVar5 = this.zzl;
            zzN(zzppVar5);
            if (!zzppVar5.zzab("android.permission.INTERNET")) {
                zzgu zzguVar8 = this.zzi;
                zzP(zzguVar8);
                zzguVar8.zzb().zza("App is missing INTERNET permission");
            }
            zzN(zzppVar5);
            if (!zzppVar5.zzab("android.permission.ACCESS_NETWORK_STATE")) {
                zzgu zzguVar9 = this.zzi;
                zzP(zzguVar9);
                zzguVar9.zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            Context context = this.zzd;
            if (!Wrappers.packageManager(context).isCallerInstantApp() && !this.zzg.zzE()) {
                if (!zzpp.zzax(context)) {
                    zzgu zzguVar10 = this.zzi;
                    zzP(zzguVar10);
                    zzguVar10.zzb().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzpp.zzS(context, false)) {
                    zzgu zzguVar11 = this.zzi;
                    zzP(zzguVar11);
                    zzguVar11.zzb().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzgu zzguVar12 = this.zzi;
            zzP(zzguVar12);
            zzguVar12.zzb().zza("Uploading is not possible. App measurement disabled");
        }
        zzaif.zza();
        if (this.zzg.zzp(null, zzfy.zzaP)) {
            zzpp zzppVar6 = this.zzl;
            zzN(zzppVar6);
            if (zzppVar6.zzU()) {
                long jMax = Math.max(500L, ((((long) ((Integer) zzfy.zzaw.zzb(null)).intValue()) * 1000) + ((long) new Random().nextInt(DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT))) - this.zzn.elapsedRealtime());
                if (jMax > 500) {
                    zzgu zzguVar13 = this.zzi;
                    zzP(zzguVar13);
                    zzguVar13.zzk().zzb("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(jMax));
                }
                zzlj zzljVar5 = this.zzp;
                zzO(zzljVar5);
                zzljVar5.zzu(jMax);
            }
        }
        zzhh zzhhVar4 = this.zzh;
        zzN(zzhhVar4);
        zzhhVar4.zzj.zzb(true);
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaV() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaW() {
        zzgu zzguVar = this.zzi;
        zzP(zzguVar);
        return zzguVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaX() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        return zzhzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaZ() {
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzba() {
        return this.zzn;
    }

    public final zzal zzc() {
        return this.zzg;
    }

    public final zzhh zzd() {
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        return zzhhVar;
    }

    public final zzgu zzf() {
        zzgu zzguVar = this.zzi;
        if (zzguVar == null || !zzguVar.zzv()) {
            return null;
        }
        return zzguVar;
    }

    public final zzoc zzh() {
        zzoc zzocVar = this.zzk;
        zzO(zzocVar);
        return zzocVar;
    }

    public final zzhz zzi() {
        return this.zzj;
    }

    public final zzlj zzj() {
        zzlj zzljVar = this.zzp;
        zzO(zzljVar);
        return zzljVar;
    }

    public final zzpp zzk() {
        zzpp zzppVar = this.zzl;
        zzN(zzppVar);
        return zzppVar;
    }

    public final zzgn zzl() {
        return this.zzm;
    }

    public final zzgl zzm() {
        zzO(this.zzt);
        return this.zzt;
    }

    public final zzlo zzn() {
        zzlo zzloVar = this.zzr;
        zzP(zzloVar);
        return zzloVar;
    }

    public final boolean zzp() {
        return this.zze;
    }

    public final String zzq() {
        return this.zzs;
    }

    public final zzmb zzs() {
        zzmb zzmbVar = this.zzo;
        zzO(zzmbVar);
        return zzmbVar;
    }

    public final zznl zzt() {
        zzO(this.zzu);
        return this.zzu;
    }

    public final zzbb zzu() {
        zzP(this.zzv);
        return this.zzv;
    }

    public final zzgi zzv() {
        zzO(this.zzw);
        return this.zzw;
    }

    public final zzd zzw() {
        zzd zzdVar = this.zzq;
        zzM(zzdVar);
        return zzdVar;
    }

    public final zzlq zzx() {
        zzM(this.zzx);
        return this.zzx;
    }

    public final void zzz(boolean z) {
        this.zzB = Boolean.valueOf(z);
    }
}
