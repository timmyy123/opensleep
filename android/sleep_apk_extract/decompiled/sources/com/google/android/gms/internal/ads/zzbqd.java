package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbqd implements zzbpq {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdzl zzb;
    private final zzbya zzd;
    private final zzekg zze;
    private final zzctj zzf;
    private final zzdbs zzg;
    private com.google.android.gms.ads.internal.util.client.zzu zzc = null;
    private com.google.android.gms.ads.internal.overlay.zzaa zzh = null;
    private final zzhcg zzi = zzcfr.zzh;

    public zzbqd(com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, zzekg zzekgVar, zzdzl zzdzlVar, zzctj zzctjVar, zzdbs zzdbsVar) {
        this.zza = zzbVar;
        this.zzd = zzbyaVar;
        this.zze = zzekgVar;
        this.zzb = zzdzlVar;
        this.zzf = zzctjVar;
        this.zzg = zzdbsVar;
    }

    public static boolean zzb(Map map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    public static int zzc(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    public static Uri zzd(Context context, zzbap zzbapVar, Uri uri, View view, Activity activity, zzflc zzflcVar) {
        if (zzbapVar != null) {
            try {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznw)).booleanValue() || zzflcVar == null) {
                    if (zzbapVar.zze(uri)) {
                        return zzbapVar.zzd(uri, context, view, activity);
                    }
                } else if (zzbapVar.zze(uri)) {
                    return zzflcVar.zza(uri, context, view, activity);
                }
            } catch (zzbaq unused) {
            } catch (Exception e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            }
        }
        return uri;
    }

    public static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") == null) {
                return uri;
            }
            return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
        } catch (UnsupportedOperationException e) {
            String strValueOf = String.valueOf(uri.toString());
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error adding click uptime parameter to url: ".concat(strValueOf), e);
            return uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:132:0x036a  */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzf(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean zZzb;
        zzdbs zzdbsVar;
        zzcku zzckuVar = (zzcku) zzaVar;
        zzfkf zzfkfVarZzC = zzckuVar.zzC();
        zzfki zzfkiVarZzaC = zzckuVar.zzaC();
        boolean zZza = false;
        if (zzfkfVarZzC == null || zzfkiVarZzaC == null) {
            str3 = "";
            zZzb = false;
        } else {
            str3 = zzfkiVarZzaC.zzb;
            zZzb = zzfkfVarZzC.zzb();
        }
        boolean z = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmf)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) ? false : true;
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzok)).booleanValue() && map.containsKey("ig_cl") && ((String) map.get("ig_cl")).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzckuVar.zzW()) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzl(false);
                ((zzcmk) zzaVar).zzaI(zzb(map), zzc(map), z);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzl(false);
            boolean z3 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzns)).booleanValue() && Objects.equals(map.get("is_allowed_for_lock_screen"), AppEventsConstants.EVENT_PARAM_VALUE_YES);
            if (str != null) {
                ((zzcmk) zzaVar).zzaJ(zzb(map), zzc(map), str, z, z3);
                return;
            } else {
                ((zzcmk) zzaVar).zzaK(zzb(map), zzc(map), (String) map.get("html"), (String) map.get("baseurl"), z);
                return;
            }
        }
        Intent uri = null;
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            Context context = zzckuVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfG)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                zzg(10);
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfA)).booleanValue()) {
                    String packageName = CustomTabsClient.getPackageName(context, null);
                    if (packageName != null && !context.getPackageName().equals(packageName)) {
                        zZza = true;
                    }
                } else {
                    zZza = zzbjr.zza(context);
                }
                if (zZza) {
                    boolean z4 = z2;
                    boolean z5 = z;
                    String str4 = str3;
                    zzl(true);
                    if (TextUtils.isEmpty(str)) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot open browser with null or empty url");
                        zzg(7);
                        return;
                    }
                    Uri uriZze = zze(zzd(zzckuVar.getContext(), zzckuVar.zzS(), Uri.parse(str), zzckuVar.zzE(), zzckuVar.zzj(), zzckuVar.zzT()));
                    if (zZzb && this.zze != null && zzi(zzaVar, zzckuVar.getContext(), uriZze.toString(), str4)) {
                        return;
                    }
                    this.zzh = new zzbqa(this);
                    zzcmk zzcmkVar = (zzcmk) zzaVar;
                    String string = uriZze.toString();
                    com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzh;
                    Bundle bundle = new Bundle();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfF)).booleanValue()) {
                        if (map.containsKey("cct_init_h")) {
                            try {
                                bundle.putInt("h", Integer.parseInt((String) map.get("cct_init_h")));
                            } catch (NumberFormatException e) {
                                com.google.android.gms.ads.internal.util.zze.zzb("Invalid cct initial height parameter.", e);
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "OpenGmsgHandler.getChromeCustomTabConfigBundle");
                            }
                        }
                        if (map.containsKey("cct_bp")) {
                            try {
                                bundle.putInt("cbp", Integer.parseInt((String) map.get("cct_bp")));
                            } catch (NumberFormatException e2) {
                                com.google.android.gms.ads.internal.util.zze.zzb("Invalid cct close button position parameter.", e2);
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e2, "OpenGmsgHandler.getChromeCustomTabConfigBundle");
                            }
                        }
                    }
                    zzcmkVar.zzaH(new com.google.android.gms.ads.internal.overlay.zzc(null, string, null, null, null, null, null, null, ObjectWrapper.wrap(zzaaVar).asBinder(), true, bundle), z5, z4, str4);
                    return;
                }
                zzg(4);
            }
            map.put("use_first_package", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            map.put("use_running_process", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            zzk(zzaVar, map, zZzb, str3, z, z2);
            return;
        }
        boolean z6 = z2;
        boolean z7 = z;
        String str5 = str3;
        if ("app".equalsIgnoreCase(str2) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase((String) map.get("system_browser"))) {
            zzk(zzaVar, map, zZzb, str5, z7, z6);
            return;
        }
        boolean z8 = zZzb;
        com.google.android.gms.ads.internal.client.zza zzaVar2 = zzaVar;
        Map map2 = map;
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjy)).booleanValue()) {
                zzl(true);
                String str6 = (String) map2.get("p");
                if (str6 == null) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Package name missing from open app action.");
                    return;
                }
                if (z8 && this.zze != null && zzi(zzaVar2, zzckuVar.getContext(), str6, str5)) {
                    return;
                }
                PackageManager packageManager = zzckuVar.getContext().getPackageManager();
                if (packageManager == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot get package manager from open app action.");
                    return;
                } else {
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str6);
                    if (launchIntentForPackage != null) {
                        ((zzcmk) zzaVar2).zzaH(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzh), z7, z6, str5);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        zzl(true);
        String str7 = (String) map2.get("intent_url");
        if (!TextUtils.isEmpty(str7)) {
            try {
                uri = Intent.parseUri(str7, 0);
            } catch (URISyntaxException e3) {
                String strValueOf = String.valueOf(str7);
                int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error parsing the url: ".concat(strValueOf), e3);
            }
        }
        if (uri != null && uri.getData() != null) {
            Uri data2 = uri.getData();
            if (!Uri.EMPTY.equals(data2)) {
                Uri uriZze2 = zze(zzd(zzckuVar.getContext(), zzckuVar.zzS(), data2, zzckuVar.zzE(), zzckuVar.zzj(), zzckuVar.zzT()));
                if (!TextUtils.isEmpty(uri.getType())) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjz)).booleanValue()) {
                        uri.setDataAndType(uriZze2, uri.getType());
                    } else {
                        uri.setData(uriZze2);
                    }
                }
            }
        }
        boolean z9 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjU)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map2.containsKey("event_id");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzop)).booleanValue() && (zzdbsVar = this.zzg) != null) {
            zzdbsVar.zzl();
        }
        HashMap map3 = new HashMap();
        if (z9) {
            zzbqb zzbqbVar = new zzbqb(this, z7, zzaVar2, map3, map2);
            zzaVar2 = zzaVar2;
            map2 = map2;
            this.zzh = zzbqbVar;
        } else {
            zZza = z7;
        }
        if (uri != null) {
            if (!z8 || this.zze == null || !zzi(zzaVar2, zzckuVar.getContext(), uri.getData().toString(), str5)) {
                ((zzcmk) zzaVar2).zzaH(new com.google.android.gms.ads.internal.overlay.zzc(uri, this.zzh), zZza, z6, str5);
                return;
            } else {
                if (z9) {
                    map3.put((String) map2.get("event_id"), Boolean.TRUE);
                    ((zzbsm) zzaVar2).zze("openIntentAsync", map3);
                    return;
                }
                return;
            }
        }
        String string2 = !TextUtils.isEmpty(str) ? zze(zzd(zzckuVar.getContext(), zzckuVar.zzS(), Uri.parse(str), zzckuVar.zzE(), zzckuVar.zzj(), zzckuVar.zzT())).toString() : str;
        if (!z8 || this.zze == null || !zzi(zzaVar2, zzckuVar.getContext(), string2, str5)) {
            ((zzcmk) zzaVar2).zzaH(new com.google.android.gms.ads.internal.overlay.zzc((String) map2.get("i"), string2, (String) map2.get("m"), (String) map2.get("p"), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzh), zZza, z6, str5);
        } else if (z9) {
            map3.put((String) map2.get("event_id"), Boolean.TRUE);
            ((zzbsm) zzaVar2).zze("openIntentAsync", map3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(com.google.android.gms.internal.ads.zzbiq.zzjO)).booleanValue() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(com.google.android.gms.internal.ads.zzbiq.zzjJ)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(com.google.android.gms.internal.ads.zzbiq.zzjI)).booleanValue()) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzi(com.google.android.gms.ads.internal.client.zza zzaVar, Context context, String str, String str2) {
        zzbzh zzbzhVar;
        com.google.android.gms.ads.internal.util.client.zzw zzwVar;
        zzdzl zzdzlVar = this.zzb;
        if (zzdzlVar != null) {
            zzekr.zzd(context, zzdzlVar, this.zze, str2, "offline_open");
        }
        if (com.google.android.gms.ads.internal.zzt.zzh().zzs(context)) {
            if (this.zzc == null) {
                this.zzc = new com.google.android.gms.ads.internal.util.client.zzu(context.getApplicationContext(), null);
            }
            this.zze.zzc(this.zzc, str2);
            return false;
        }
        zzcku zzckuVar = (zzcku) zzaVar;
        zzfkf zzfkfVarZzC = zzckuVar.zzC();
        boolean z = (zzfkfVarZzC == null || (zzwVar = zzfkfVarZzC.zzay) == null || zzwVar.zzc()) ? false : true;
        boolean z2 = (zzfkfVarZzC == null || (zzbzhVar = zzfkfVarZzC.zzad) == null || !zzbzhVar.zza || zzbzhVar.zzb == null || !zzbzhVar.zzc) ? false : true;
        if (!z) {
            if (z2) {
            }
            com.google.android.gms.ads.internal.zzt.zzc();
            zzbo zzboVarZzC = com.google.android.gms.ads.internal.util.zzs.zzC(context);
            com.google.android.gms.ads.internal.zzt.zzc();
            boolean zAreNotificationsEnabled = NotificationManagerCompat.from(context).areNotificationsEnabled();
            boolean zZzh = com.google.android.gms.ads.internal.zzt.zzf().zzh(context, "offline_notification_channel");
            boolean z3 = zzckuVar.zzN().zzg() && zzckuVar.zzj() == null;
            if (!zAreNotificationsEnabled) {
                com.google.android.gms.ads.internal.zzt.zzc();
                if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                }
                zzj(context, str2, "notifications_disabled");
                return false;
            }
            if (zZzh) {
                zzj(context, str2, "notification_channel_disabled");
                return false;
            }
            if (zzboVarZzC == null) {
                zzj(context, str2, "work_manager_unavailable");
                return false;
            }
            if (z3) {
                zzj(context, str2, "ad_no_activity");
                return false;
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjG)).booleanValue()) {
                zzj(context, str2, "notification_flow_disabled");
                return false;
            }
            if (zzckuVar.zzL() == null || zzckuVar.zzj() == null) {
                ((zzcmk) zzaVar).zzaL(str2, str, 14);
            } else {
                zzeks zzeksVarZze = zzekt.zze();
                zzeksVarZze.zza(zzckuVar.zzj());
                zzeksVarZze.zzb(null);
                zzeksVarZze.zzc(str2);
                zzeksVarZze.zzd(str);
                try {
                    zzckuVar.zzL().zzG(zzeksVarZze.zze());
                } catch (Exception e) {
                    zzj(context, str2, e.getMessage());
                    return false;
                }
            }
            zzaVar.onAdClicked();
            return true;
        }
        zzdzl zzdzlVar2 = this.zzb;
        if (zzdzlVar2 != null) {
            zzekr.zzd(context, zzdzlVar2, this.zze, str2, "onfs");
        }
        return false;
    }

    private final void zzj(Context context, String str, String str2) {
        zzekg zzekgVar = this.zze;
        zzekgVar.zzd(str);
        zzdzl zzdzlVar = this.zzb;
        if (zzdzlVar != null) {
            zzekr.zzk(context, zzdzlVar, zzekgVar, str, "dialog_not_shown", zzgwp.zzb("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x014b, code lost:
    
        r15 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzk(com.google.android.gms.ads.internal.client.zza zzaVar, Map map, boolean z, String str, boolean z2, boolean z3) {
        zzcku zzckuVar;
        Intent intentZzd;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo resolveInfoZzb;
        zzl(true);
        zzcku zzckuVar2 = (zzcku) zzaVar;
        Context context = zzckuVar2.getContext();
        zzbap zzbapVarZzS = zzckuVar2.zzS();
        View viewZzE = zzckuVar2.zzE();
        zzflc zzflcVarZzT = zzckuVar2.zzT();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str2 = (String) map.get("u");
        if (TextUtils.isEmpty(str2)) {
            zzckuVar = zzckuVar2;
            intentZzd = null;
        } else {
            Uri uriZze = zze(zzd(context, zzbapVarZzS, Uri.parse(str2), viewZzE, null, zzflcVarZzT));
            boolean z4 = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean z5 = Boolean.parseBoolean((String) map.get("use_running_process"));
            if (!Boolean.parseBoolean((String) map.get("use_custom_tabs"))) {
                boolean z6 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfw)).booleanValue();
                Uri uriBuild = "http".equalsIgnoreCase(uriZze.getScheme()) ? uriZze.buildUpon().scheme(TournamentShareDialogURIBuilder.scheme).build() : TournamentShareDialogURIBuilder.scheme.equalsIgnoreCase(uriZze.getScheme()) ? uriZze.buildUpon().scheme("http").build() : null;
                ArrayList arrayList = new ArrayList();
                Intent intentZza = zzbqc.zza(uriZze, context, zzbapVarZzS, viewZzE, zzflcVarZzT);
                Intent intentZza2 = zzbqc.zza(uriBuild, context, zzbapVarZzS, viewZzE, zzflcVarZzT);
                if (z6) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    com.google.android.gms.ads.internal.util.zzs.zzq(context, intentZza);
                    com.google.android.gms.ads.internal.zzt.zzc();
                    com.google.android.gms.ads.internal.util.zzs.zzq(context, intentZza2);
                }
                ResolveInfo resolveInfoZzc = zzbqc.zzc(intentZza, arrayList, context, zzbapVarZzS, viewZzE, zzflcVarZzT);
                if (resolveInfoZzc != null) {
                    intentZzd = zzbqc.zzd(intentZza, resolveInfoZzc, context, zzbapVarZzS, viewZzE, zzflcVarZzT);
                } else {
                    if (intentZza2 != null && (resolveInfoZzb = zzbqc.zzb(intentZza2, context, zzbapVarZzS, viewZzE, zzflcVarZzT)) != null) {
                        intentZzd = zzbqc.zzd(intentZza, resolveInfoZzb, context, zzbapVarZzS, viewZzE, zzflcVarZzT);
                        if (zzbqc.zzb(intentZzd, context, zzbapVarZzS, viewZzE, zzflcVarZzT) == null) {
                        }
                    }
                    if (arrayList.isEmpty()) {
                        zzckuVar = zzckuVar2;
                    } else if (!z5 || activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                        zzckuVar = zzckuVar2;
                        if (!z4) {
                            intentZzd = zzbqc.zzd(intentZza, (ResolveInfo) arrayList.get(0), context, zzbapVarZzS, viewZzE, zzflcVarZzT);
                        }
                    } else {
                        int size = arrayList.size();
                        int i = 0;
                        loop0: while (i < size) {
                            ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                int i2 = i + 1;
                                if (it.hasNext()) {
                                    zzckuVar = zzckuVar2;
                                    if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                        intentZzd = zzbqc.zzd(intentZza, resolveInfo, context, zzbapVarZzS, viewZzE, zzflcVarZzT);
                                        break loop0;
                                    }
                                    zzckuVar2 = zzckuVar;
                                }
                            }
                        }
                        zzckuVar = zzckuVar2;
                        if (!z4) {
                        }
                    }
                    intentZzd = intentZza;
                }
                zzckuVar = zzckuVar2;
            }
        }
        if (!z || this.zze == null || intentZzd == null || !zzi(zzaVar, zzckuVar.getContext(), intentZzd.getData().toString(), str)) {
            try {
                ((zzcmk) zzaVar).zzaH(new com.google.android.gms.ads.internal.overlay.zzc(intentZzd, this.zzh), z2, z3, str);
            } catch (ActivityNotFoundException e) {
                String message = e.getMessage();
                int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(message);
            }
        }
    }

    private final void zzl(boolean z) {
        zzbya zzbyaVar = this.zzd;
        if (zzbyaVar != null) {
            zzbyaVar.zzb(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzg(int i) {
        zzdzl zzdzlVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfz)).booleanValue() || (zzdzlVar = this.zzb) == null) {
            return;
        }
        zzdzk zzdzkVarZza = zzdzlVar.zza();
        zzdzkVarZza.zzc("action", "cct_action");
        switch (i) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zzdzkVarZza.zzc("cct_open_status", str);
        zzdzkVarZza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzctj zzctjVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        Map map2 = new HashMap();
        zzcku zzckuVar = (zzcku) zzaVar;
        if (zzckuVar.zzC() != null) {
            map2 = zzckuVar.zzC().zzaw;
        }
        String strZza = zzceb.zza(str, zzckuVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzb()) {
            zzhbw.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlw)).booleanValue() && (zzctjVar = this.zzf) != null && zzctj.zzc(strZza)) ? zzctjVar.zzb(strZza, com.google.android.gms.ads.internal.client.zzay.zzh()) : zzhbw.zza(strZza), new zzbpz(this, map, zzaVar, str2), this.zzi);
        } else {
            zzbVar.zzc(strZza);
        }
    }
}
