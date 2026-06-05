package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpp extends zzjf {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final String[] zzb = {"firebase_", "google_", "ga_"};
    private static final String[] zzc = {"_err"};
    private SecureRandom zzd;
    private final AtomicLong zze;
    private int zzf;
    private MeasurementManagerFutures zzg;
    private Boolean zzh;
    private Integer zzi;

    public zzpp(zzic zzicVar) {
        super(zzicVar);
        this.zzi = null;
        this.zze = new AtomicLong(0L);
    }

    public static MessageDigest zzQ() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static long zzR(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (((long) bArr[i2]) & 255) << i;
            i += 8;
        }
        return j;
    }

    public static boolean zzS(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzT(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public static boolean zzT(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static final boolean zzaA(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    private final Object zzaB(int i, Object obj, boolean z, boolean z2, String str) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zzE(obj.toString(), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleZzae = zzae((Bundle) parcelable, null);
                if (!bundleZzae.isEmpty()) {
                    arrayList.add(bundleZzae);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final int zzaC(String str) {
        if ("_ldl".equals(str)) {
            this.zzu.zzc();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.zzu.zzc();
            return 256;
        }
        boolean zEquals = "_lgclid".equals(str);
        zzic zzicVar = this.zzu;
        if (zEquals) {
            zzicVar.zzc();
            return 100;
        }
        zzicVar.zzc();
        return 36;
    }

    private static boolean zzaD(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzaE(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("*") || Arrays.asList(str.split(",")).contains(str2);
    }

    public static boolean zzac(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean zzai(String str) {
        return !zzc[0].equals(str);
    }

    public static ArrayList zzav(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzah zzahVar = (zzah) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzahVar.zza);
            bundle.putString("origin", zzahVar.zzb);
            bundle.putLong("creation_timestamp", zzahVar.zzd);
            bundle.putString("name", zzahVar.zzc.zzb);
            zzjh.zza(bundle, Preconditions.checkNotNull(zzahVar.zzc.zza()));
            bundle.putBoolean("active", zzahVar.zze);
            String str = zzahVar.zzf;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzbh zzbhVar = zzahVar.zzg;
            if (zzbhVar != null) {
                bundle.putString("timed_out_event_name", zzbhVar.zza);
                zzbf zzbfVar = zzbhVar.zzb;
                if (zzbfVar != null) {
                    bundle.putBundle("timed_out_event_params", zzbfVar.zzf());
                }
            }
            bundle.putLong("trigger_timeout", zzahVar.zzh);
            zzbh zzbhVar2 = zzahVar.zzi;
            if (zzbhVar2 != null) {
                bundle.putString("triggered_event_name", zzbhVar2.zza);
                zzbf zzbfVar2 = zzbhVar2.zzb;
                if (zzbfVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzbfVar2.zzf());
                }
            }
            bundle.putLong("triggered_timestamp", zzahVar.zzc.zzc);
            bundle.putLong("time_to_live", zzahVar.zzj);
            zzbh zzbhVar3 = zzahVar.zzk;
            if (zzbhVar3 != null) {
                bundle.putString("expired_event_name", zzbhVar3.zza);
                zzbf zzbfVar3 = zzbhVar3.zzb;
                if (zzbfVar3 != null) {
                    bundle.putBundle("expired_event_params", zzbfVar3.zzf());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean zzax(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void zzay(zzlu zzluVar, Bundle bundle, boolean z) {
        if (bundle != null && zzluVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzluVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzluVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzluVar.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zzluVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public final boolean zzA(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i) {
                this.zzu.zzaW().zzh().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final void zzB(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int iZzt;
        int iZzF;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        zzic zzicVar = this.zzu;
        int i = true != zzicVar.zzc().zzu.zzk().zzaj(231100000, true) ? 0 : 35;
        int i2 = 0;
        boolean z2 = false;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str4)) {
                iZzt = !z ? zzt(str4) : 0;
                if (iZzt == 0) {
                    iZzt = zzu(str4);
                }
            } else {
                iZzt = 0;
            }
            if (iZzt != 0) {
                zzL(bundle, iZzt, str4, iZzt == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (zzz(bundle.get(str4))) {
                    zzicVar.zzaW().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    iZzF = 22;
                } else {
                    iZzF = zzF(str, str2, str4, bundle.get(str4), bundle, list2, z, false);
                }
                if (iZzF != 0 && !"_ev".equals(str4)) {
                    zzL(bundle, iZzF, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zzh(str4) && !zzaD(str4, zzjn.zzd)) {
                    i2++;
                    if (!zzaj(231100000, true)) {
                        zzicVar.zzaW().zzd().zzc("Item array not supported on client's version of Google Play Services (Android Only)", zzicVar.zzl().zza(str2), zzicVar.zzl().zze(bundle));
                        zzaA(bundle, 23);
                        bundle.remove(str4);
                    } else if (i2 > i) {
                        if (!z2) {
                            zzicVar.zzaW().zzd().zzc(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 55), "Item can't contain more than ", i, " item-scoped custom params"), zzicVar.zzl().zza(str2), zzicVar.zzl().zze(bundle));
                        }
                        zzaA(bundle, 28);
                        bundle.remove(str4);
                        list2 = list;
                        z2 = true;
                    }
                }
            }
            list2 = list;
        }
    }

    public final boolean zzC(String str) {
        if (TextUtils.isEmpty(str)) {
            this.zzu.zzaW().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        this.zzu.zzaW().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgu.zzl(str));
        return false;
    }

    public final boolean zzD(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final String zzE(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return str.substring(0, str.offsetByCodePoints(0, i)).concat("...");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzF(String str, String str2, String str3, Object obj, Bundle bundle, List list, boolean z, boolean z2) {
        int i;
        int size;
        zzg();
        if (!zzz(obj)) {
            i = 0;
        } else {
            if (!z2) {
                return 21;
            }
            if (!zzaD(str3, zzjn.zzc)) {
                return 20;
            }
            zznl zznlVarZzt = this.zzu.zzt();
            zznlVarZzt.zzg();
            zznlVarZzt.zzb();
            if (zznlVarZzt.zzK() && zznlVarZzt.zzu.zzk().zzak() < 200900) {
                return 25;
            }
            zzic zzicVar = this.zzu;
            zzicVar.zzc();
            boolean z3 = obj instanceof Parcelable[];
            if (z3) {
                size = ((Parcelable[]) obj).length;
            } else {
                if (obj instanceof ArrayList) {
                    size = ((ArrayList) obj).size();
                }
                i = 0;
            }
            if (size > 200) {
                zzicVar.zzaW().zzh().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                zzicVar.zzc();
                if (z3) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i = 17;
            }
        }
        if (!zzA("param", str3, (zzac(str2) || zzac(str3)) ? this.zzu.zzc().zzf(null, false) : this.zzu.zzc().zze(null, false), obj)) {
            if (!z2) {
                return 4;
            }
            if (obj instanceof Bundle) {
                zzB(str, str2, str3, (Bundle) obj, list, z);
                return i;
            }
            if (obj instanceof Parcelable[]) {
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (!(parcelable instanceof Bundle)) {
                        this.zzu.zzaW().zzh().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                        return 4;
                    }
                    zzB(str, str2, str3, (Bundle) parcelable, list, z);
                }
            } else {
                if (!(obj instanceof ArrayList)) {
                    return 4;
                }
                ArrayList arrayList2 = (ArrayList) obj;
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Object obj2 = arrayList2.get(i2);
                    if (!(obj2 instanceof Bundle)) {
                        this.zzu.zzaW().zzh().zzc("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : "null", str3);
                        return 4;
                    }
                    zzB(str, str2, str3, (Bundle) obj2, list, z);
                }
            }
        }
        return i;
    }

    public final Object zzG(String str, Object obj) {
        if ("_ev".equals(str)) {
            return zzaB(this.zzu.zzc().zzf(null, false), obj, true, true, null);
        }
        boolean zZzac = zzac(str);
        zzic zzicVar = this.zzu;
        return zzaB(zZzac ? zzicVar.zzc().zzf(null, false) : zzicVar.zzc().zze(null, false), obj, false, true, null);
    }

    public final Bundle zzH(String str, String str2, Bundle bundle, List list, boolean z) {
        int iZzt;
        List list2 = list;
        boolean zZzaD = zzaD(str2, zzjm.zzg);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        zzic zzicVar = this.zzu;
        int iZzc = zzicVar.zzc().zzc();
        int i = 0;
        boolean z2 = false;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str3)) {
                iZzt = !z ? zzt(str3) : 0;
                if (iZzt == 0) {
                    iZzt = zzu(str3);
                }
            } else {
                iZzt = 0;
            }
            if (iZzt != 0) {
                zzL(bundle2, iZzt, str3, iZzt == 3 ? str3 : null);
                bundle2.remove(str3);
            } else {
                int iZzF = zzF(str, str2, str3, bundle.get(str3), bundle2, list2, z, zZzaD);
                if (iZzF == 17) {
                    zzL(bundle2, 17, str3, Boolean.FALSE);
                } else if (iZzF != 0 && !"_ev".equals(str3)) {
                    zzL(bundle2, iZzF, iZzF == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (zzh(str3) && (i = i + 1) > iZzc) {
                    if (!z2) {
                        zzicVar.zzaW().zzd().zzc(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzc).length() + 37), "Event can't contain more than ", iZzc, " params"), zzicVar.zzl().zza(str2), zzicVar.zzl().zze(bundle));
                    }
                    zzaA(bundle2, 5);
                    bundle2.remove(str3);
                    z2 = true;
                }
            }
            list2 = list;
        }
        return bundle2;
    }

    public final void zzI(zzgv zzgvVar, int i) {
        Bundle bundle = zzgvVar.zze;
        int i2 = 0;
        boolean z = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (zzh(str) && (i2 = i2 + 1) > i) {
                if (!z) {
                    String strM = zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 37), "Event can't contain more than ", i, " params");
                    zzic zzicVar = this.zzu;
                    zzicVar.zzaW().zzd().zzc(strM, zzicVar.zzl().zza(zzgvVar.zza), zzicVar.zzl().zze(bundle));
                    zzaA(bundle, 5);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    public final void zzJ(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i2 = 0;
            boolean z = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzh(str) && !zzaD(str, zzjn.zzd) && (i2 = i2 + 1) > i) {
                    if (!z) {
                        zzic zzicVar = this.zzu;
                        zzicVar.zzaW().zzd().zzc(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 60), "Param can't contain more than ", i, " item-scoped custom parameters"), zzicVar.zzl().zzb(str), zzicVar.zzl().zze(bundle));
                    }
                    zzaA(bundle, 28);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    public final void zzK(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.zzu.zzk().zzO(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void zzL(Bundle bundle, int i, String str, Object obj) {
        if (zzaA(bundle, i)) {
            this.zzu.zzc();
            bundle.putString("_ev", zzE(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final int zzM(String str, Object obj) {
        return "_ldl".equals(str) ? zzA("user property referrer", str, zzaC(str), obj) : zzA("user property", str, zzaC(str), obj) ? 0 : 7;
    }

    public final Object zzN(String str, Object obj) {
        return "_ldl".equals(str) ? zzaB(zzaC(str), obj, true, false, null) : zzaB(zzaC(str), obj, false, false, null);
    }

    public final void zzO(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzh().zzc("Not putting event parameter. Invalid value type. name, type", zzicVar.zzl().zzb(str), simpleName);
        }
    }

    public final void zzP(zzpo zzpoVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzaA(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzpoVar.zza(str, "_err", bundle);
    }

    public final boolean zzU() {
        zzg();
        return zzX() == 1;
    }

    public final MeasurementManagerFutures zzV() {
        if (this.zzg == null) {
            this.zzg = MeasurementManagerFutures.from(this.zzu.zzaZ());
        }
        return this.zzg;
    }

    public final int zzW() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public final long zzX() {
        long j;
        zzg();
        if (!zzZ(this.zzu.zzv().zzj())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j = 8;
        } else {
            zzic zzicVar = this.zzu;
            int iZzW = zzW();
            zzicVar.zzc();
            j = iZzW < ((Integer) zzfy.zzak.zzb(null)).intValue() ? 16L : 0L;
        }
        if (!zzab("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0 && !zzY()) {
            j = 64;
        }
        if (j == 0) {
            return 1L;
        }
        return j;
    }

    public final boolean zzY() {
        Object e;
        Integer num;
        if (this.zzh == null) {
            MeasurementManagerFutures measurementManagerFuturesZzV = zzV();
            boolean z = false;
            if (measurementManagerFuturesZzV == null) {
                return false;
            }
            try {
                num = measurementManagerFuturesZzV.getMeasurementApiStatusAsync().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z = true;
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                    } catch (CancellationException e3) {
                        e = e3;
                        this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                    } catch (ExecutionException e4) {
                        e = e4;
                        this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                    } catch (TimeoutException e5) {
                        e = e5;
                        this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                    }
                }
                this.zzh = Boolean.valueOf(z);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e6) {
                e = e6;
                num = null;
            }
            this.zzu.zzaW().zzk().zzb("Measurement manager api status result", num);
        }
        return this.zzh.booleanValue();
    }

    public final boolean zzZ(String str) {
        return zzaE((String) zzfy.zzaq.zzb(null), str);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final boolean zza() {
        return true;
    }

    public final boolean zzaa(String str) {
        return zzaE((String) zzfy.zzbg.zzb(null), str) || zzaE((String) zzfy.zzbh.zzb(null), str) || zzaE((String) zzfy.zzbi.zzb(null), str);
    }

    public final boolean zzab(String str) {
        zzg();
        zzic zzicVar = this.zzu;
        if (Wrappers.packageManager(zzicVar.zzaZ()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzicVar.zzaW().zzj().zzb("Permission not granted", str);
        return false;
    }

    public final boolean zzad(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        zzic zzicVar = this.zzu;
        String strZzA = zzicVar.zzc().zzA();
        zzicVar.zzaV();
        return strZzA.equals(str);
    }

    public final Bundle zzae(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objZzG = zzG(str2, bundle.get(str2));
                if (objZzG == null) {
                    zzic zzicVar = this.zzu;
                    zzicVar.zzaW().zzh().zzb("Param value can't be null", zzicVar.zzl().zzb(str2));
                } else {
                    zzO(bundle2, str2, objZzG);
                }
            }
        }
        return bundle2;
    }

    public final zzbh zzaf(String str, String str2, Bundle bundle, String str3, long j, long j2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzp(str2) != 0) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzb("Invalid conditional property event name", zzicVar.zzl().zzc(str2));
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return null;
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleZzH = zzH(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
        if (z) {
            bundleZzH = zzae(bundleZzH, str);
        }
        Preconditions.checkNotNull(bundleZzH);
        return new zzbh(str2, new zzbf(bundleZzH), str3, j, j2);
    }

    public final boolean zzag(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaW().zzb().zzb("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            this.zzu.zzaW().zzb().zzb("Error obtaining certificate", e2);
            return true;
        }
    }

    public final byte[] zzah(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public final boolean zzaj(int i, boolean z) {
        Boolean boolZzJ = this.zzu.zzt().zzJ();
        if (zzak() < i / 1000) {
            return (boolZzJ == null || boolZzJ.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int zzak() {
        if (this.zzi == null) {
            this.zzi = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaZ()) / 1000);
        }
        return this.zzi.intValue();
    }

    public final int zzal(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaZ(), 12451000);
    }

    public final long zzam(long j, long j2) {
        return ((j2 * 60000) + j) / TimeChart.DAY;
    }

    public final void zzan(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzu.zzaW().zze().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzao(com.google.android.gms.internal.measurement.zzcs zzcsVar, String str) {
        try {
            zzcsVar.zzb(zzba$$ExternalSyntheticOutline0.m("r", str));
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning string value to wrapper", e);
        }
    }

    public final void zzap(com.google.android.gms.internal.measurement.zzcs zzcsVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzaq(com.google.android.gms.internal.measurement.zzcs zzcsVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzar(com.google.android.gms.internal.measurement.zzcs zzcsVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzas(com.google.android.gms.internal.measurement.zzcs zzcsVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzat(com.google.android.gms.internal.measurement.zzcs zzcsVar, Bundle bundle) {
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzau(com.google.android.gms.internal.measurement.zzcs zzcsVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zzaw(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v161000." + zzak()) + "&rdid=" + str2 + "&bundleid=" + str + "&retry=" + j2;
            if (str.equals(this.zzu.zzc().zzB())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e) {
            e = e;
            this.zzu.zzaW().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e2) {
            e = e2;
            this.zzu.zzaW().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final String zzaz() {
        byte[] bArr = new byte[16];
        zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final void zzbb() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.zzu.zzaW().zze().zza("Utils falling back to Random for random id");
            }
        }
        this.zze.set(jNextLong);
    }

    public final long zzd() {
        long andIncrement;
        long j;
        AtomicLong atomicLong = this.zze;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.zze;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNextLong = new Random(System.nanoTime() ^ this.zzu.zzba().currentTimeMillis()).nextLong();
            int i = this.zzf + 1;
            this.zzf = i;
            j = jNextLong + ((long) i);
        }
        return j;
    }

    public final SecureRandom zzf() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    public final Bundle zzi(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(ShareConstants.FEED_SOURCE_PARAM, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("sfmc_id", queryParameter9);
            }
            for (String str : uri.getQueryParameterNames()) {
                if (str.startsWith("gad_")) {
                    String queryParameter19 = uri.getQueryParameter(str);
                    if (!TextUtils.isEmpty(queryParameter19)) {
                        bundle.putString(str, queryParameter19);
                    }
                }
            }
            zzic zzicVar = this.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzba)) {
                String string = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).build().toString();
                int iZzf = zzicVar.zzc().zzf(null, false);
                if (string.length() > iZzf) {
                    string = zzE(string, iZzf - 3, true);
                }
                if (!TextUtils.isEmpty(string)) {
                    bundle.putString("deep_link_url", string);
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            this.zzu.zzaW().zze().zzb("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final boolean zzj(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) {
            return true;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        try {
            String host = new URL(stringExtra).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            return host.matches("^(www\\.)?google(\\.com?)?(\\.[a-z]{2}t?)?$");
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public final boolean zzk(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.zzu.zzaW().zzd().zzc("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzu.zzaW().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean zzl(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.zzu.zzaW().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzu.zzaW().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean zzm(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzu.zzaW().zzd().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzaD(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzaD(str2, strArr2)) {
            return true;
        }
        this.zzu.zzaW().zzd().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final boolean zzn(String str, int i, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        this.zzu.zzaW().zzd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    public final int zzp(String str) {
        if (!zzl("event", str)) {
            return 2;
        }
        zzic zzicVar = this.zzu;
        if (!zzm("event", zzjm.zza, zzicVar.zzc().zzp(null, zzfy.zzbf) ? zzjm.zzc : zzjm.zzb, str)) {
            return 13;
        }
        zzicVar.zzc();
        return !zzn("event", 40, str) ? 2 : 0;
    }

    public final boolean zzq(String str) {
        return this.zzu.zzc().zzp(null, zzfy.zzbf) ? zzaD(str, zzjm.zze) : zzaD(str, zzjm.zzd);
    }

    public final int zzs(String str) {
        if (!zzl("user property", str)) {
            return 6;
        }
        if (!zzm("user property", zzjo.zza, null, str)) {
            return 15;
        }
        this.zzu.zzc();
        return !zzn("user property", 24, str) ? 6 : 0;
    }

    public final int zzt(String str) {
        if (!zzk("event param", str)) {
            return 3;
        }
        if (!zzm("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzc();
        return !zzn("event param", 40, str) ? 3 : 0;
    }

    public final int zzu(String str) {
        if (!zzl("event param", str)) {
            return 3;
        }
        if (!zzm("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzc();
        return !zzn("event param", 40, str) ? 3 : 0;
    }

    public final boolean zzz(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }
}
