package com.google.android.gms.measurement.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzadf;
import com.google.android.gms.internal.measurement.zzafb;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.internal.measurement.zzair;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeParseException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpk extends zzos {
    private long zza;
    private long zzb;

    public zzpk(zzpg zzpgVar) {
        super(zzpgVar);
    }

    public static final void zzF(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, Object obj) {
        List listZza = zzhrVar.zza();
        int i = 0;
        while (true) {
            if (i >= listZza.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb(str);
        zzhvVarZzn.zzf(((Long) obj).longValue());
        if (i >= 0) {
            zzhrVar.zze(i, zzhvVarZzn);
        } else {
            zzhrVar.zzg(zzhvVarZzn);
        }
    }

    public static final boolean zzG(zzbh zzbhVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzbhVar);
        Preconditions.checkNotNull(zzrVar);
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    public static final Bundle zzH(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzj()) {
                bundle.putDouble(strZzb, zzhwVar.zzk());
            } else if (zzhwVar.zzh()) {
                bundle.putFloat(strZzb, zzhwVar.zzi());
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putLong(strZzb, zzhwVar.zzf());
            }
        }
        return bundle;
    }

    public static final com.google.android.gms.internal.measurement.zzhw zzI(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().equals(str)) {
                return zzhwVar;
            }
        }
        return null;
    }

    public static final String zzJ(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (entry.getValue() == null || ((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    public static final Map zzK(com.google.android.gms.internal.measurement.zzhs zzhsVar, String... strArr) {
        Object objZzT;
        HashMap map = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (Arrays.asList(strArr).contains(zzhwVar.zzb()) && (objZzT = zzT(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objZzT);
            }
        }
        return map;
    }

    public static final Map zzL(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        Object objZzT;
        HashMap map = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().startsWith("gad_") && (objZzT = zzT(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objZzT);
            }
        }
        return map;
    }

    public static final Object zzM(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzI(zzhsVar, str);
        if (zzhwVarZzI == null) {
            return null;
        }
        return zzT(zzhwVarZzI);
    }

    public static final Object zzN(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str, Object obj) {
        Object objZzM = zzM(zzhsVar, str);
        return objZzM == null ? obj : objZzM;
    }

    private final void zzO(StringBuilder sb, int i, List list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                zzQ(sb, i2);
                sb.append("param {\n");
                zzW(sb, i2, "name", zzhwVar.zza() ? this.zzu.zzl().zzb(zzhwVar.zzb()) : null);
                zzW(sb, i2, "string_value", zzhwVar.zzc() ? zzhwVar.zzd() : null);
                zzW(sb, i2, "int_value", zzhwVar.zze() ? Long.valueOf(zzhwVar.zzf()) : null);
                zzW(sb, i2, "double_value", zzhwVar.zzj() ? Double.valueOf(zzhwVar.zzk()) : null);
                if (zzhwVar.zzm() > 0) {
                    zzO(sb, i2, zzhwVar.zzl());
                }
                zzQ(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private final void zzP(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzfh zzfhVar) {
        String str;
        if (zzfhVar == null) {
            return;
        }
        zzQ(sb, i);
        sb.append("filter {\n");
        if (zzfhVar.zze()) {
            zzW(sb, i, "complement", Boolean.valueOf(zzfhVar.zzf()));
        }
        if (zzfhVar.zzh()) {
            zzW(sb, i, "param_name", this.zzu.zzl().zzb(zzfhVar.zzi()));
        }
        if (zzfhVar.zza()) {
            int i2 = i + 1;
            com.google.android.gms.internal.measurement.zzfr zzfrVarZzb = zzfhVar.zzb();
            if (zzfrVarZzb != null) {
                zzQ(sb, i2);
                sb.append("string_filter {\n");
                if (zzfrVarZzb.zza()) {
                    switch (zzfrVarZzb.zzk()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzW(sb, i2, "match_type", str);
                }
                if (zzfrVarZzb.zzb()) {
                    zzW(sb, i2, "expression", zzfrVarZzb.zzc());
                }
                if (zzfrVarZzb.zzd()) {
                    zzW(sb, i2, "case_sensitive", Boolean.valueOf(zzfrVarZzb.zze()));
                }
                if (zzfrVarZzb.zzh() > 0) {
                    zzQ(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzfrVarZzb.zzf()) {
                        zzQ(sb, i + 3);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zzQ(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzfhVar.zzc()) {
            zzX(sb, i + 1, "number_filter", zzfhVar.zzd());
        }
        zzQ(sb, i);
        sb.append("}\n");
    }

    private static final void zzQ(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final void zzR(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static final String zzS(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final Object zzT(com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        if (zzhwVar.zzc()) {
            return zzhwVar.zzd();
        }
        if (zzhwVar.zze()) {
            return Long.valueOf(zzhwVar.zzf());
        }
        if (zzhwVar.zzj()) {
            return Double.valueOf(zzhwVar.zzk());
        }
        if (zzhwVar.zzm() > 0) {
            return zzy(zzhwVar.zzl());
        }
        return null;
    }

    private static final void zzU(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zzR(builder, str3, string, set);
            }
        }
    }

    private static final void zzV(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzii zziiVar) {
        if (zziiVar == null) {
            return;
        }
        zzQ(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zziiVar.zzd() != 0) {
            zzQ(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : zziiVar.zzc()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zziiVar.zzb() != 0) {
            zzQ(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : zziiVar.zza()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zziiVar.zzf() != 0) {
            zzQ(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.zze()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(zzhqVar.zza() ? Integer.valueOf(zzhqVar.zzb()) : null);
                sb.append(":");
                sb.append(zzhqVar.zzc() ? Long.valueOf(zzhqVar.zzd()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (zziiVar.zzi() != 0) {
            zzQ(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzh()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zzikVar.zza() ? Integer.valueOf(zzikVar.zzb()) : null);
                sb.append(": [");
                Iterator it = zzikVar.zzc().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        zzQ(sb, 3);
        sb.append("}\n");
    }

    private static final void zzW(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzQ(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void zzX(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (zzflVar == null) {
            return;
        }
        zzQ(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzflVar.zza()) {
            int iZzm = zzflVar.zzm();
            zzW(sb, i, "comparison_type", iZzm != 1 ? iZzm != 2 ? iZzm != 3 ? iZzm != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (zzflVar.zzb()) {
            zzW(sb, i, "match_as_float", Boolean.valueOf(zzflVar.zzc()));
        }
        if (zzflVar.zzd()) {
            zzW(sb, i, "comparison_value", zzflVar.zze());
        }
        if (zzflVar.zzf()) {
            zzW(sb, i, "min_comparison_value", zzflVar.zzh());
        }
        if (zzflVar.zzi()) {
            zzW(sb, i, "max_comparison_value", zzflVar.zzj());
        }
        zzQ(sb, i);
        sb.append("}\n");
    }

    public static boolean zzm(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean zzn(List list, int i) {
        if (i < list.size() * 64) {
            return ((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static List zzp(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static zzafb zzw(zzafb zzafbVar, byte[] bArr) {
        zzadf zzadfVarZzb = zzadf.zzb();
        return zzadfVarZzb != null ? zzafbVar.zzaW(bArr, zzadfVarZzb) : zzafbVar.zzaX(bArr);
    }

    public static int zzx(com.google.android.gms.internal.measurement.zzic zzicVar, String str) {
        for (int i = 0; i < zzicVar.zzl(); i++) {
            if (str.equals(zzicVar.zzm(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    public static Bundle[] zzy(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : zzhwVar.zzl()) {
                    if (zzhwVar2.zzc()) {
                        bundle.putString(zzhwVar2.zzb(), zzhwVar2.zzd());
                    } else if (zzhwVar2.zze()) {
                        bundle.putLong(zzhwVar2.zzb(), zzhwVar2.zzf());
                    } else if (zzhwVar2.zzj()) {
                        bundle.putDouble(zzhwVar2.zzb(), zzhwVar2.zzk());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final zzbh zzA(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        Object obj;
        Bundle bundleZzB = zzB(zzaaVar.zzf(), true);
        String string = (!bundleZzB.containsKey("_o") || (obj = bundleZzB.get("_o")) == null) ? "app" : obj.toString();
        String strZzb = zzjm.zzb(zzaaVar.zzb());
        if (strZzb == null) {
            strZzb = zzaaVar.zzb();
        }
        return new zzbh(strZzb, new zzbf(bundleZzB), string, zzaaVar.zza(), 0L);
    }

    public final Bundle zzB(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(zzB((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public final long zzC(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return ZonedDateTime.parse(str, DateTimeFormatter.RFC_1123_DATE_TIME).toInstant().toEpochMilli();
            } catch (DateTimeParseException unused) {
                this.zzu.zzaW().zze().zzb("Unable to parse header time, time", str);
            }
        }
        return 0L;
    }

    public final void zzD(Map map) {
        if (Build.VERSION.SDK_INT >= 26) {
            String strZzJ = zzJ(map, "Date");
            if (TextUtils.isEmpty(strZzJ)) {
                return;
            }
            long jZzC = zzC(strZzJ);
            if (jZzC > 0) {
                long jElapsedRealtime = this.zzu.zzba().elapsedRealtime();
                zzg();
                if (this.zzb == 0) {
                    this.zza = jElapsedRealtime;
                    this.zzb = jZzC;
                }
            }
        }
    }

    public final long zzE(long j) {
        zzg();
        long j2 = this.zzb;
        if (j2 == 0 || j == 0) {
            return 0L;
        }
        return (j2 - this.zza) + j;
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    public final boolean zzbc() {
        return false;
    }

    public final void zzc(com.google.android.gms.internal.measurement.zzit zzitVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzitVar.zzd();
        zzitVar.zzf();
        zzitVar.zzh();
        if (obj instanceof String) {
            zzitVar.zzc((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzitVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzitVar.zzg(((Double) obj).doubleValue());
        } else {
            this.zzu.zzaW().zzb().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zzd(zzhv zzhvVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzhvVar.zze();
        zzhvVar.zzg();
        zzhvVar.zzi();
        zzhvVar.zzm();
        if (obj instanceof String) {
            zzhvVar.zzd((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzhvVar.zzf(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzhvVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.zzu.zzaW().zzb().zzb("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                for (String str : bundle.keySet()) {
                    zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                    zzhvVarZzn2.zzb(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzhvVarZzn2.zzf(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzhvVarZzn2.zzd((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzhvVarZzn2.zzh(((Double) obj2).doubleValue());
                    }
                    zzhvVarZzn.zzk(zzhvVarZzn2);
                }
                if (zzhvVarZzn.zzj() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
                }
            }
        }
        zzhvVar.zzl(arrayList);
    }

    public final zzoh zzf(String str, com.google.android.gms.internal.measurement.zzic zzicVar, com.google.android.gms.internal.measurement.zzhr zzhrVar, String str2) {
        int iIndexOf;
        zzaif.zza();
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzc().zzp(str, zzfy.zzaO)) {
            return null;
        }
        long jCurrentTimeMillis = zzicVar2.zzba().currentTimeMillis();
        HashSet hashSet = new HashSet(Arrays.asList(zzicVar2.zzc().zzk(str, zzfy.zzat).split(",")));
        zzpg zzpgVar = this.zzg;
        zzou zzouVarZzf = zzpgVar.zzf();
        String strZzc = zzouVarZzf.zzg.zzh().zzc(str);
        Uri.Builder builder = new Uri.Builder();
        zzic zzicVar3 = zzouVarZzf.zzu;
        builder.scheme(zzicVar3.zzc().zzk(str, zzfy.zzam));
        if (TextUtils.isEmpty(strZzc)) {
            builder.authority(zzicVar3.zzc().zzk(str, zzfy.zzan));
        } else {
            String strZzk = zzicVar3.zzc().zzk(str, zzfy.zzan);
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(1, strZzc) + String.valueOf(strZzk).length());
            sb.append(strZzc);
            sb.append(".");
            sb.append(strZzk);
            builder.authority(sb.toString());
        }
        builder.path(zzicVar3.zzc().zzk(str, zzfy.zzao));
        zzR(builder, "gmp_app_id", zzicVar.zzac(), hashSet);
        zzicVar2.zzc().zzi();
        zzR(builder, "gmp_version", String.valueOf(161000L), hashSet);
        String strZzV = zzicVar.zzV();
        zzal zzalVarZzc = zzicVar2.zzc();
        zzfx zzfxVar = zzfy.zzaR;
        if (zzalVarZzc.zzp(str, zzfxVar) && zzpgVar.zzh().zzu(str)) {
            strZzV = "";
        }
        zzR(builder, "app_instance_id", strZzV, hashSet);
        zzR(builder, "rdid", zzicVar.zzP(), hashSet);
        zzR(builder, "bundle_id", zzicVar.zzK(), hashSet);
        String strZzk2 = zzhrVar.zzk();
        String strZza = zzjm.zza(strZzk2);
        if (true != TextUtils.isEmpty(strZza)) {
            strZzk2 = strZza;
        }
        zzR(builder, "app_event_name", strZzk2, hashSet);
        zzR(builder, "app_version", String.valueOf(zzicVar.zzai()), hashSet);
        String strZzD = zzicVar.zzD();
        if (zzicVar2.zzc().zzp(str, zzfxVar) && zzpgVar.zzh().zzr(str) && !TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
            strZzD = strZzD.substring(0, iIndexOf);
        }
        zzR(builder, "os_version", strZzD, hashSet);
        zzR(builder, "timestamp", String.valueOf(zzhrVar.zzn()), hashSet);
        boolean zZzS = zzicVar.zzS();
        String str3 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        if (zZzS) {
            zzR(builder, "lat", AppEventsConstants.EVENT_PARAM_VALUE_YES, hashSet);
        }
        zzR(builder, "privacy_sandbox_version", String.valueOf(zzicVar.zzaG()), hashSet);
        zzR(builder, "trigger_uri_source", AppEventsConstants.EVENT_PARAM_VALUE_YES, hashSet);
        zzR(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), hashSet);
        zzR(builder, "request_uuid", str2, hashSet);
        List<com.google.android.gms.internal.measurement.zzhw> listZza = zzhrVar.zza();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : listZza) {
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzj()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzk()));
            } else if (zzhwVar.zzh()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzi()));
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzf()));
            }
        }
        zzU(builder, zzicVar2.zzc().zzk(str, zzfy.zzas).split("\\|"), bundle, hashSet);
        List<com.google.android.gms.internal.measurement.zziu> listZzk = zzicVar.zzk();
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.zziu zziuVar : listZzk) {
            String strZzc2 = zziuVar.zzc();
            if (zziuVar.zzk()) {
                bundle2.putString(strZzc2, String.valueOf(zziuVar.zzl()));
            } else if (zziuVar.zzi()) {
                bundle2.putString(strZzc2, String.valueOf(zziuVar.zzj()));
            } else if (zziuVar.zzd()) {
                bundle2.putString(strZzc2, zziuVar.zze());
            } else if (zziuVar.zzf()) {
                bundle2.putString(strZzc2, String.valueOf(zziuVar.zzh()));
            }
        }
        zzU(builder, zzicVar2.zzc().zzk(str, zzfy.zzar).split("\\|"), bundle2, hashSet);
        if (true != zzicVar.zzaC()) {
            str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        zzR(builder, "dma", str3, hashSet);
        if (!zzicVar.zzaE().isEmpty()) {
            zzR(builder, "dma_cps", zzicVar.zzaE(), hashSet);
        }
        if (zzicVar.zzaK()) {
            com.google.android.gms.internal.measurement.zzha zzhaVarZzaL = zzicVar.zzaL();
            if (!zzhaVarZzaL.zzb().isEmpty()) {
                zzR(builder, "dl_gclid", zzhaVarZzaL.zzb(), hashSet);
            }
            if (!zzhaVarZzaL.zzd().isEmpty()) {
                zzR(builder, "dl_gbraid", zzhaVarZzaL.zzd(), hashSet);
            }
            if (!zzhaVarZzaL.zzf().isEmpty()) {
                zzR(builder, "dl_gs", zzhaVarZzaL.zzf(), hashSet);
            }
            if (zzhaVarZzaL.zzi() > 0) {
                zzR(builder, "dl_ss_ts", String.valueOf(zzhaVarZzaL.zzi()), hashSet);
            }
            if (!zzhaVarZzaL.zzk().isEmpty()) {
                zzR(builder, "mr_gclid", zzhaVarZzaL.zzk(), hashSet);
            }
            if (!zzhaVarZzaL.zzm().isEmpty()) {
                zzR(builder, "mr_gbraid", zzhaVarZzaL.zzm(), hashSet);
            }
            if (!zzhaVarZzaL.zzo().isEmpty()) {
                zzR(builder, "mr_gs", zzhaVarZzaL.zzo(), hashSet);
            }
            if (zzhaVarZzaL.zzq() > 0) {
                zzR(builder, "mr_click_ts", String.valueOf(zzhaVarZzaL.zzq()), hashSet);
            }
        }
        return new zzoh(builder.build().toString(), jCurrentTimeMillis, 1);
    }

    public final com.google.android.gms.internal.measurement.zzhs zzh(zzbc zzbcVar) {
        com.google.android.gms.internal.measurement.zzhr zzhrVarZzp = com.google.android.gms.internal.measurement.zzhs.zzp();
        zzhrVarZzp.zzq(zzbcVar.zzf);
        zzhrVarZzp.zzw(zzbcVar.zze);
        zzbf zzbfVar = zzbcVar.zzg;
        zzbe zzbeVar = new zzbe(zzbfVar);
        while (zzbeVar.hasNext()) {
            String next = zzbeVar.next();
            zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzhvVarZzn.zzb(next);
            Object objZza = zzbfVar.zza(next);
            Preconditions.checkNotNull(objZza);
            zzd(zzhvVarZzn, objZza);
            zzhrVarZzp.zzg(zzhvVarZzn);
        }
        String str = zzbcVar.zzc;
        if (!TextUtils.isEmpty(str) && zzbfVar.zza("_o") == null) {
            zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzhvVarZzn2.zzb("_o");
            zzhvVarZzn2.zzd(str);
            zzhrVarZzp.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbd());
        }
        return (com.google.android.gms.internal.measurement.zzhs) zzhrVarZzp.zzbd();
    }

    public final String zzi(com.google.android.gms.internal.measurement.zzib zzibVar) {
        com.google.android.gms.internal.measurement.zzhe zzheVarZzat;
        if (zzibVar == null) {
            return "";
        }
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("\nbatch {\n");
        if (zzibVar.zzf()) {
            zzW(sbM, 0, "upload_subdomain", zzibVar.zzh());
        }
        if (zzibVar.zzd()) {
            zzW(sbM, 0, "sgtm_join_id", zzibVar.zze());
        }
        for (com.google.android.gms.internal.measurement.zzid zzidVar : zzibVar.zza()) {
            if (zzidVar != null) {
                zzQ(sbM, 1);
                sbM.append("bundle {\n");
                if (zzidVar.zza()) {
                    zzW(sbM, 1, "protocol_version", Integer.valueOf(zzidVar.zzb()));
                }
                zzair.zza();
                zzic zzicVar = this.zzu;
                if (zzicVar.zzc().zzp(zzidVar.zzA(), zzfy.zzaM) && zzidVar.zzag()) {
                    zzW(sbM, 1, "session_stitching_token", zzidVar.zzah());
                }
                zzW(sbM, 1, "platform", zzidVar.zzt());
                if (zzidVar.zzC()) {
                    zzW(sbM, 1, "gmp_version", Long.valueOf(zzidVar.zzD()));
                }
                if (zzidVar.zzE()) {
                    zzW(sbM, 1, "uploading_gmp_version", Long.valueOf(zzidVar.zzF()));
                }
                if (zzidVar.zzac()) {
                    zzW(sbM, 1, "dynamite_version", Long.valueOf(zzidVar.zzad()));
                }
                if (zzidVar.zzW()) {
                    zzW(sbM, 1, "config_version", Long.valueOf(zzidVar.zzX()));
                }
                zzW(sbM, 1, "gmp_app_id", zzidVar.zzP());
                zzW(sbM, 1, "app_id", zzidVar.zzA());
                zzW(sbM, 1, "app_version", zzidVar.zzB());
                if (zzidVar.zzU()) {
                    zzW(sbM, 1, "app_version_major", Integer.valueOf(zzidVar.zzV()));
                }
                zzW(sbM, 1, "firebase_instance_id", zzidVar.zzT());
                if (zzidVar.zzK()) {
                    zzW(sbM, 1, "dev_cert_hash", Long.valueOf(zzidVar.zzL()));
                }
                zzW(sbM, 1, "app_store", zzidVar.zzz());
                if (zzidVar.zzj()) {
                    zzW(sbM, 1, "upload_timestamp_millis", Long.valueOf(zzidVar.zzk()));
                }
                if (zzidVar.zzl()) {
                    zzW(sbM, 1, "start_timestamp_millis", Long.valueOf(zzidVar.zzm()));
                }
                if (zzidVar.zzn()) {
                    zzW(sbM, 1, "end_timestamp_millis", Long.valueOf(zzidVar.zzo()));
                }
                if (zzidVar.zzp()) {
                    zzW(sbM, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzidVar.zzq()));
                }
                if (zzidVar.zzr()) {
                    zzW(sbM, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzidVar.zzs()));
                }
                zzW(sbM, 1, "app_instance_id", zzidVar.zzJ());
                zzW(sbM, 1, "resettable_device_id", zzidVar.zzG());
                zzW(sbM, 1, "ds_id", zzidVar.zzZ());
                if (zzidVar.zzH()) {
                    zzW(sbM, 1, "limited_ad_tracking", Boolean.valueOf(zzidVar.zzI()));
                }
                zzW(sbM, 1, "os_version", zzidVar.zzu());
                zzW(sbM, 1, "device_model", zzidVar.zzv());
                zzW(sbM, 1, "user_default_language", zzidVar.zzw());
                if (zzidVar.zzx()) {
                    zzW(sbM, 1, "time_zone_offset_minutes", Integer.valueOf(zzidVar.zzy()));
                }
                if (zzidVar.zzM()) {
                    zzW(sbM, 1, "bundle_sequential_index", Integer.valueOf(zzidVar.zzN()));
                }
                if (zzidVar.zzau()) {
                    zzW(sbM, 1, "delivery_index", Integer.valueOf(zzidVar.zzav()));
                }
                if (zzidVar.zzQ()) {
                    zzW(sbM, 1, "service_upload", Boolean.valueOf(zzidVar.zzR()));
                }
                zzW(sbM, 1, "health_monitor", zzidVar.zzO());
                if (zzidVar.zzaa()) {
                    zzW(sbM, 1, "retry_counter", Integer.valueOf(zzidVar.zzab()));
                }
                if (zzidVar.zzae()) {
                    zzW(sbM, 1, "consent_signals", zzidVar.zzaf());
                }
                if (zzidVar.zzan()) {
                    zzW(sbM, 1, "is_dma_region", Boolean.valueOf(zzidVar.zzao()));
                }
                if (zzidVar.zzap()) {
                    zzW(sbM, 1, "core_platform_services", zzidVar.zzaq());
                }
                if (zzidVar.zzal()) {
                    zzW(sbM, 1, "consent_diagnostics", zzidVar.zzam());
                }
                if (zzidVar.zzai()) {
                    zzW(sbM, 1, "target_os_version", Long.valueOf(zzidVar.zzaj()));
                }
                zzaif.zza();
                if (zzicVar.zzc().zzp(zzidVar.zzA(), zzfy.zzaO)) {
                    zzW(sbM, 1, "ad_services_version", Integer.valueOf(zzidVar.zzar()));
                    if (zzidVar.zzas() && (zzheVarZzat = zzidVar.zzat()) != null) {
                        zzQ(sbM, 2);
                        sbM.append("attribution_eligibility_status {\n");
                        zzW(sbM, 2, "eligible", Boolean.valueOf(zzheVarZzat.zza()));
                        zzW(sbM, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzheVarZzat.zzb()));
                        zzW(sbM, 2, "pre_r", Boolean.valueOf(zzheVarZzat.zzc()));
                        zzW(sbM, 2, "r_extensions_too_old", Boolean.valueOf(zzheVarZzat.zzd()));
                        zzW(sbM, 2, "adservices_extension_too_old", Boolean.valueOf(zzheVarZzat.zze()));
                        zzW(sbM, 2, "ad_storage_not_allowed", Boolean.valueOf(zzheVarZzat.zzf()));
                        zzW(sbM, 2, "measurement_manager_disabled", Boolean.valueOf(zzheVarZzat.zzh()));
                        zzQ(sbM, 2);
                        sbM.append("}\n");
                    }
                }
                if (zzidVar.zzaw()) {
                    com.google.android.gms.internal.measurement.zzha zzhaVarZzax = zzidVar.zzax();
                    zzQ(sbM, 2);
                    sbM.append("ad_campaign_info {\n");
                    if (zzhaVarZzax.zza()) {
                        zzW(sbM, 2, "deep_link_gclid", zzhaVarZzax.zzb());
                    }
                    if (zzhaVarZzax.zzc()) {
                        zzW(sbM, 2, "deep_link_gbraid", zzhaVarZzax.zzd());
                    }
                    if (zzhaVarZzax.zze()) {
                        zzW(sbM, 2, "deep_link_gad_source", zzhaVarZzax.zzf());
                    }
                    if (zzhaVarZzax.zzr()) {
                        zzW(sbM, 2, "deep_link_url", zzhaVarZzax.zzs());
                    }
                    if (zzhaVarZzax.zzh()) {
                        zzW(sbM, 2, "deep_link_session_millis", Long.valueOf(zzhaVarZzax.zzi()));
                    }
                    if (zzhaVarZzax.zzj()) {
                        zzW(sbM, 2, "market_referrer_gclid", zzhaVarZzax.zzk());
                    }
                    if (zzhaVarZzax.zzl()) {
                        zzW(sbM, 2, "market_referrer_gbraid", zzhaVarZzax.zzm());
                    }
                    if (zzhaVarZzax.zzn()) {
                        zzW(sbM, 2, "market_referrer_gad_source", zzhaVarZzax.zzo());
                    }
                    if (zzhaVarZzax.zzp()) {
                        zzW(sbM, 2, "market_referrer_click_millis", Long.valueOf(zzhaVarZzax.zzq()));
                    }
                    zzQ(sbM, 2);
                    sbM.append("}\n");
                }
                if (zzidVar.zzaA()) {
                    zzW(sbM, 1, "batching_timestamp_millis", Long.valueOf(zzidVar.zzaB()));
                }
                if (zzidVar.zzay()) {
                    com.google.android.gms.internal.measurement.zzis zzisVarZzaz = zzidVar.zzaz();
                    zzQ(sbM, 2);
                    sbM.append("sgtm_diagnostics {\n");
                    int iZzf = zzisVarZzaz.zzf();
                    zzW(sbM, 2, "upload_type", iZzf != 1 ? iZzf != 2 ? iZzf != 3 ? iZzf != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    zzW(sbM, 2, "client_upload_eligibility", zzisVarZzaz.zza().name());
                    int iZzh = zzisVarZzaz.zzh();
                    zzW(sbM, 2, "service_upload_eligibility", iZzh != 1 ? iZzh != 2 ? iZzh != 3 ? iZzh != 4 ? iZzh != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    zzQ(sbM, 2);
                    sbM.append("}\n");
                }
                if (zzidVar.zzaC()) {
                    com.google.android.gms.internal.measurement.zzho zzhoVarZzaD = zzidVar.zzaD();
                    zzQ(sbM, 2);
                    sbM.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.zzhl zzhlVar : zzhoVarZzaD.zza()) {
                        zzQ(sbM, 3);
                        sbM.append("limited_data_modes {\n");
                        int iZzc = zzhlVar.zzc();
                        zzW(sbM, 3, "type", iZzc != 1 ? iZzc != 2 ? iZzc != 3 ? iZzc != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iZzd = zzhlVar.zzd();
                        zzW(sbM, 3, "mode", iZzd != 1 ? iZzd != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        zzQ(sbM, 3);
                        sbM.append("}\n");
                    }
                    zzQ(sbM, 2);
                    sbM.append("}\n");
                }
                List<com.google.android.gms.internal.measurement.zziu> listZzf = zzidVar.zzf();
                if (listZzf != null) {
                    for (com.google.android.gms.internal.measurement.zziu zziuVar : listZzf) {
                        if (zziuVar != null) {
                            zzQ(sbM, 2);
                            sbM.append("user_property {\n");
                            zzW(sbM, 2, "set_timestamp_millis", zziuVar.zza() ? Long.valueOf(zziuVar.zzb()) : null);
                            zzW(sbM, 2, "name", zzicVar.zzl().zzc(zziuVar.zzc()));
                            zzW(sbM, 2, "string_value", zziuVar.zze());
                            zzW(sbM, 2, "int_value", zziuVar.zzf() ? Long.valueOf(zziuVar.zzh()) : null);
                            zzW(sbM, 2, "double_value", zziuVar.zzk() ? Double.valueOf(zziuVar.zzl()) : null);
                            zzQ(sbM, 2);
                            sbM.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhg> listZzS = zzidVar.zzS();
                if (listZzS != null) {
                    for (com.google.android.gms.internal.measurement.zzhg zzhgVar : listZzS) {
                        if (zzhgVar != null) {
                            zzQ(sbM, 2);
                            sbM.append("audience_membership {\n");
                            if (zzhgVar.zza()) {
                                zzW(sbM, 2, "audience_id", Integer.valueOf(zzhgVar.zzb()));
                            }
                            if (zzhgVar.zzf()) {
                                zzW(sbM, 2, "new_audience", Boolean.valueOf(zzhgVar.zzh()));
                            }
                            zzV(sbM, 2, "current_data", zzhgVar.zzc());
                            if (zzhgVar.zzd()) {
                                zzV(sbM, 2, "previous_data", zzhgVar.zze());
                            }
                            zzQ(sbM, 2);
                            sbM.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhs> listZzc = zzidVar.zzc();
                if (listZzc != null) {
                    for (com.google.android.gms.internal.measurement.zzhs zzhsVar : listZzc) {
                        if (zzhsVar != null) {
                            zzQ(sbM, 2);
                            sbM.append("event {\n");
                            zzW(sbM, 2, "name", zzicVar.zzl().zza(zzhsVar.zzd()));
                            if (zzhsVar.zze()) {
                                zzW(sbM, 2, "timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                            }
                            if (zzicVar.zzc().zzp(null, zzfy.zzbe) && zzhsVar.zzl()) {
                                zzW(sbM, 2, "corrected_timestamp_millis", Long.valueOf(zzhsVar.zzm()));
                            }
                            if (zzhsVar.zzh()) {
                                zzW(sbM, 2, "previous_timestamp_millis", Long.valueOf(zzhsVar.zzi()));
                            }
                            if (zzhsVar.zzj()) {
                                zzW(sbM, 2, "count", Integer.valueOf(zzhsVar.zzk()));
                            }
                            if (zzhsVar.zzb() != 0) {
                                zzO(sbM, 2, zzhsVar.zza());
                            }
                            zzQ(sbM, 2);
                            sbM.append("}\n");
                        }
                    }
                }
                zzQ(sbM, 1);
                sbM.append("}\n");
            }
        }
        sbM.append("} // End-of-batch\n");
        return sbM.toString();
    }

    public final String zzj(com.google.android.gms.internal.measurement.zzff zzffVar) {
        if (zzffVar == null) {
            return "null";
        }
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("\nevent_filter {\n");
        if (zzffVar.zza()) {
            zzW(sbM, 0, "filter_id", Integer.valueOf(zzffVar.zzb()));
        }
        zzW(sbM, 0, "event_name", this.zzu.zzl().zza(zzffVar.zzc()));
        String strZzS = zzS(zzffVar.zzj(), zzffVar.zzk(), zzffVar.zzm());
        if (!strZzS.isEmpty()) {
            zzW(sbM, 0, "filter_type", strZzS);
        }
        if (zzffVar.zzh()) {
            zzX(sbM, 1, "event_count_filter", zzffVar.zzi());
        }
        if (zzffVar.zze() > 0) {
            sbM.append("  filters {\n");
            Iterator it = zzffVar.zzd().iterator();
            while (it.hasNext()) {
                zzP(sbM, 2, (com.google.android.gms.internal.measurement.zzfh) it.next());
            }
        }
        zzQ(sbM, 1);
        sbM.append("}\n}\n");
        return sbM.toString();
    }

    public final String zzk(com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        if (zzfnVar == null) {
            return "null";
        }
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("\nproperty_filter {\n");
        if (zzfnVar.zza()) {
            zzW(sbM, 0, "filter_id", Integer.valueOf(zzfnVar.zzb()));
        }
        zzW(sbM, 0, "property_name", this.zzu.zzl().zzc(zzfnVar.zzc()));
        String strZzS = zzS(zzfnVar.zze(), zzfnVar.zzf(), zzfnVar.zzi());
        if (!strZzS.isEmpty()) {
            zzW(sbM, 0, "filter_type", strZzS);
        }
        zzP(sbM, 1, zzfnVar.zzd());
        sbM.append("}\n");
        return sbM.toString();
    }

    public final Parcelable zzl(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (SafeParcelReader.ParseException unused) {
                this.zzu.zzaW().zzb().zza("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final List zzq(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzu.zzaW().zze().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.zzu.zzaW().zze().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public final boolean zzs(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.zzu.zzba().currentTimeMillis() - j) > j2;
    }

    public final long zzt(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzic zzicVar = this.zzu;
        zzicVar.zzk().zzg();
        MessageDigest messageDigestZzQ = zzpp.zzQ();
        if (messageDigestZzQ != null) {
            return zzpp.zzR(messageDigestZzQ.digest(bArr));
        }
        zza$$ExternalSyntheticOutline0.m(zzicVar, "Failed to get MD5");
        return 0L;
    }

    public final long zzu(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zzt(str.getBytes(StandardCharsets.UTF_8));
    }

    public final byte[] zzv(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzu.zzaW().zzb().zzb("Failed to gzip content", e);
            throw e;
        }
    }

    public final Map zzz(Bundle bundle, boolean z) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zzz((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = arrayList2.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zzz((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zzz((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }
}
