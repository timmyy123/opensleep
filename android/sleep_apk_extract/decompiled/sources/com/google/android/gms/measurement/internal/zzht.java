package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzaeh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class zzht extends zzos implements zzak {
    final Map zza;
    final Map zzb;
    final Map zzc;
    final Map zzd;
    final LruCache zze;
    final com.google.android.gms.internal.measurement.zzr zzf;
    private final Map zzh;
    private final Map zzi;
    private final Map zzj;
    private final Map zzk;
    private final Map zzl;
    private final Map zzm;

    public zzht(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzh = new ArrayMap();
        this.zza = new ArrayMap();
        this.zzb = new ArrayMap();
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzm = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zze = new zzhm(this, 20);
        this.zzf = new zzhn(this);
    }

    private final void zzF(String str) throws Throwable {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzi;
        if (map.get(str) == null) {
            zzaq zzaqVarZzy = this.zzg.zzj().zzy(str);
            if (zzaqVarZzy != null) {
                com.google.android.gms.internal.measurement.zzgk zzgkVar = (com.google.android.gms.internal.measurement.zzgk) zzI(str, zzaqVarZzy.zza).zzco();
                zzG(str, zzgkVar);
                this.zzh.put(str, zzJ((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd()));
                map.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd());
                zzH(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd());
                this.zzk.put(str, zzgkVar.zzh());
                this.zzl.put(str, zzaqVarZzy.zzb);
                this.zzm.put(str, zzaqVarZzy.zzc);
                return;
            }
            this.zzh.put(str, null);
            this.zzb.put(str, null);
            this.zza.put(str, null);
            this.zzc.put(str, null);
            this.zzd.put(str, null);
            map.put(str, null);
            this.zzk.put(str, null);
            this.zzl.put(str, null);
            this.zzm.put(str, null);
            this.zzj.put(str, null);
        }
    }

    private final void zzG(String str, com.google.android.gms.internal.measurement.zzgk zzgkVar) {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = zzgkVar.zzg().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzgh) it.next()).zza());
        }
        zzic zzicVar = this.zzu;
        zzal zzalVarZzc = zzicVar.zzc();
        zzfx zzfxVar = zzfy.zzaV;
        if (zzalVarZzc.zzp(null, zzfxVar)) {
            arrayList.addAll(zzgkVar.zzi());
        }
        for (int i = 0; i < zzgkVar.zza(); i++) {
            com.google.android.gms.internal.measurement.zzgi zzgiVar = (com.google.android.gms.internal.measurement.zzgi) zzgkVar.zzb(i).zzco();
            if (zzgiVar.zza().isEmpty()) {
                zzicVar.zzaW().zze().zza("EventConfig contained null event name");
            } else {
                String strZza = zzgiVar.zza();
                String strZzb = zzjm.zzb(zzgiVar.zza());
                if (!TextUtils.isEmpty(strZzb)) {
                    zzgiVar.zzb(strZzb);
                    zzgkVar.zzc(i, zzgiVar);
                }
                if (zzgiVar.zzc() && zzgiVar.zzd()) {
                    arrayMap.put(strZza, Boolean.TRUE);
                }
                if (zzgiVar.zze() && zzgiVar.zzf()) {
                    arrayMap2.put(zzgiVar.zza(), Boolean.TRUE);
                }
                if (zzgiVar.zzg()) {
                    if (zzgiVar.zzh() < 2 || zzgiVar.zzh() > 65535) {
                        zzicVar.zzaW().zze().zzc("Invalid sampling rate. Event name, sample rate", zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    } else {
                        arrayMap3.put(zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        if (zzicVar.zzc().zzp(null, zzfxVar)) {
            this.zzd.put(str, arrayList);
        }
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zzj.put(str, arrayMap3);
    }

    private final void zzH(final String str, com.google.android.gms.internal.measurement.zzgl zzglVar) {
        if (zzglVar.zzk() == 0) {
            this.zze.remove(str);
            return;
        }
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzk().zzb("EES programs found", Integer.valueOf(zzglVar.zzk()));
        com.google.android.gms.internal.measurement.zzja zzjaVar = (com.google.android.gms.internal.measurement.zzja) zzglVar.zzj().get(0);
        try {
            com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
            zzcVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhs
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new com.google.android.gms.internal.measurement.zzn("internal.remoteConfig", new zzho(this.zza, str));
                }
            });
            zzcVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhp
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    final zzht zzhtVar = this.zza;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhr
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            zzht zzhtVar2 = zzhtVar;
                            zzaw zzawVarZzj = zzhtVar2.zzg.zzj();
                            String str3 = str2;
                            zzh zzhVarZzu = zzawVarZzj.zzu(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            zzhtVar2.zzu.zzc().zzi();
                            map.put("gmp_version", 161000L);
                            if (zzhVarZzu != null) {
                                String strZzr = zzhVarZzu.zzr();
                                if (strZzr != null) {
                                    map.put("app_version", strZzr);
                                }
                                map.put("app_version_int", Long.valueOf(zzhVarZzu.zzt()));
                                map.put("dynamite_version", Long.valueOf(zzhVarZzu.zzB()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzcVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhq
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new com.google.android.gms.internal.measurement.zzt(this.zza.zzf);
                }
            });
            zzcVar.zzf(zzjaVar);
            this.zze.put(str, zzcVar);
            zzicVar.zzaW().zzk().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzjaVar.zzb().zzb()));
            Iterator it = zzjaVar.zzb().zza().iterator();
            while (it.hasNext()) {
                zzicVar.zzaW().zzk().zzb("EES program activity", ((com.google.android.gms.internal.measurement.zziy) it.next()).zza());
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            this.zzu.zzaW().zzb().zzb("Failed to load EES program. appId", str);
        }
    }

    private final com.google.android.gms.internal.measurement.zzgl zzI(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzgl.zzt();
        }
        try {
            com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) ((com.google.android.gms.internal.measurement.zzgk) zzpk.zzw(com.google.android.gms.internal.measurement.zzgl.zzs(), bArr)).zzbd();
            this.zzu.zzaW().zzk().zzc("Parsed config. version, gmp_app_id", zzglVar.zza() ? Long.valueOf(zzglVar.zzb()) : null, zzglVar.zzc() ? zzglVar.zzd() : null);
            return zzglVar;
        } catch (zzaeh e) {
            this.zzu.zzaW().zze().zzc("Unable to merge remote config. appId", zzgu.zzl(str), e);
            return com.google.android.gms.internal.measurement.zzgl.zzt();
        } catch (RuntimeException e2) {
            this.zzu.zzaW().zze().zzc("Unable to merge remote config. appId", zzgu.zzl(str), e2);
            return com.google.android.gms.internal.measurement.zzgl.zzt();
        }
    }

    private static final Map zzJ(com.google.android.gms.internal.measurement.zzgl zzglVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzglVar != null) {
            for (com.google.android.gms.internal.measurement.zzgt zzgtVar : zzglVar.zze()) {
                arrayMap.put(zzgtVar.zza(), zzgtVar.zzb());
            }
        }
        return arrayMap;
    }

    private static final zzjk zzK(int i) {
        int i2 = i - 1;
        if (i2 == 1) {
            return zzjk.AD_STORAGE;
        }
        if (i2 == 2) {
            return zzjk.ANALYTICS_STORAGE;
        }
        if (i2 == 3) {
            return zzjk.AD_USER_DATA;
        }
        if (i2 != 4) {
            return null;
        }
        return zzjk.AD_PERSONALIZATION;
    }

    public final SortedSet zzA(String str) {
        zzg();
        zzF(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzy(str);
        if (zzgfVarZzy != null) {
            Iterator it = zzgfVarZzy.zzc().iterator();
            while (it.hasNext()) {
                treeSet.add(((com.google.android.gms.internal.measurement.zzgc) it.next()).zza());
            }
        }
        return treeSet;
    }

    public final zzji zzB(String str, zzjk zzjkVar) {
        zzg();
        zzF(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzy(str);
        if (zzgfVarZzy == null) {
            return zzji.UNINITIALIZED;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarZzy.zzf()) {
            if (zzK(zzfuVar.zzb()) == zzjkVar) {
                int iZzc = zzfuVar.zzc() - 1;
                return iZzc != 1 ? iZzc != 2 ? zzji.UNINITIALIZED : zzji.DENIED : zzji.GRANTED;
            }
        }
        return zzji.UNINITIALIZED;
    }

    public final boolean zzC(String str) throws Throwable {
        zzg();
        zzF(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzy(str);
        if (zzgfVarZzy == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarZzy.zza()) {
            if (zzfuVar.zzb() == 3 && zzfuVar.zzd() == 3) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ com.google.android.gms.internal.measurement.zzc zzD(String str) throws Throwable {
        zzay();
        Preconditions.checkNotEmpty(str);
        zzaq zzaqVarZzy = this.zzg.zzj().zzy(str);
        if (zzaqVarZzy == null) {
            return null;
        }
        this.zzu.zzaW().zzk().zzb("Populate EES config from database on cache miss. appId", str);
        zzH(str, zzI(str, zzaqVarZzy.zza));
        return (com.google.android.gms.internal.measurement.zzc) this.zze.snapshot().get(str);
    }

    public final /* synthetic */ Map zzE() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzak
    public final String zza(String str, String str2) throws Throwable {
        zzg();
        zzF(str);
        Map map = (Map) this.zzh.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final com.google.android.gms.internal.measurement.zzgl zzb(String str) {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzF(str);
        return (com.google.android.gms.internal.measurement.zzgl) this.zzi.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    public final boolean zzbc() {
        return false;
    }

    public final String zzc(String str) {
        zzg();
        zzF(str);
        return (String) this.zzk.get(str);
    }

    public final String zzd(String str) {
        zzg();
        return (String) this.zzl.get(str);
    }

    public final String zze(String str) {
        zzg();
        return (String) this.zzm.get(str);
    }

    public final void zzf(String str) {
        zzg();
        this.zzl.put(str, null);
    }

    public final void zzh(String str) {
        zzg();
        this.zzi.remove(str);
    }

    public final boolean zzi(String str, byte[] bArr, String str2, String str3) throws Throwable {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzgk zzgkVar = (com.google.android.gms.internal.measurement.zzgk) zzI(str, bArr).zzco();
        zzG(str, zzgkVar);
        zzH(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd());
        this.zzi.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd());
        this.zzk.put(str, zzgkVar.zzh());
        this.zzl.put(str, str2);
        this.zzm.put(str, str3);
        this.zzh.put(str, zzJ((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd()));
        this.zzg.zzj().zzag(str, new ArrayList(zzgkVar.zzd()));
        try {
            zzgkVar.zze();
            bArr = ((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd()).zzcd();
        } catch (RuntimeException e) {
            this.zzu.zzaW().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzgu.zzl(str), e);
        }
        zzaw zzawVarZzj = this.zzg.zzj();
        Preconditions.checkNotEmpty(str);
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzawVarZzj.zze().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzawVarZzj.zzu.zzaW().zzb().zzb("Failed to update remote config (got 0). appId", zzgu.zzl(str));
            }
        } catch (SQLiteException e2) {
            zzawVarZzj.zzu.zzaW().zzb().zzc("Error storing remote config. appId", zzgu.zzl(str), e2);
        }
        zzgkVar.zzf();
        this.zzi.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbd());
        return true;
    }

    public final boolean zzj(String str, String str2) throws Throwable {
        Boolean bool;
        zzg();
        zzF(str);
        if (zzo(str) && zzpp.zzac(str2)) {
            return true;
        }
        if (zzp(str) && zzpp.zzh(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean zzk(String str, String str2) throws Throwable {
        Boolean bool;
        zzg();
        zzF(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final Set zzl(String str) {
        zzg();
        zzF(str);
        return (Set) this.zza.get(str);
    }

    public final List zzm(String str) throws Throwable {
        zzg();
        zzF(str);
        return (List) this.zzd.get(str);
    }

    public final int zzn(String str, String str2) throws Throwable {
        Integer num;
        zzg();
        zzF(str);
        Map map = (Map) this.zzj.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean zzo(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean zzp(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    public final boolean zzq(String str) throws Throwable {
        zzg();
        zzF(str);
        Map map = this.zza;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("device_model") || ((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    public final boolean zzr(String str) throws Throwable {
        zzg();
        zzF(str);
        Map map = this.zza;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("os_version") || ((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    public final boolean zzs(String str) throws Throwable {
        zzg();
        zzF(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("user_id");
    }

    public final boolean zzt(String str) throws Throwable {
        zzg();
        zzF(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("google_signals");
    }

    public final boolean zzu(String str) throws Throwable {
        zzg();
        zzF(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("app_instance_id");
    }

    public final boolean zzv(String str) throws Throwable {
        zzg();
        zzF(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("enhanced_user_id");
    }

    public final boolean zzw(String str, zzjk zzjkVar) throws Throwable {
        zzg();
        zzF(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzy(str);
        if (zzgfVarZzy == null) {
            return false;
        }
        Iterator it = zzgfVarZzy.zza().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.zzfu zzfuVar = (com.google.android.gms.internal.measurement.zzfu) it.next();
            if (zzjkVar == zzK(zzfuVar.zzb())) {
                if (zzfuVar.zzc() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final zzjk zzx(String str, zzjk zzjkVar) {
        zzg();
        zzF(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzy(str);
        if (zzgfVarZzy == null) {
            return null;
        }
        for (com.google.android.gms.internal.measurement.zzfw zzfwVar : zzgfVarZzy.zzb()) {
            if (zzjkVar == zzK(zzfwVar.zzb())) {
                return zzK(zzfwVar.zzc());
            }
        }
        return null;
    }

    public final com.google.android.gms.internal.measurement.zzgf zzy(String str) {
        zzg();
        zzF(str);
        com.google.android.gms.internal.measurement.zzgl zzglVarZzb = zzb(str);
        if (zzglVarZzb == null || !zzglVarZzb.zzn()) {
            return null;
        }
        return zzglVarZzb.zzo();
    }

    public final boolean zzz(String str) {
        zzg();
        zzF(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzy(str);
        return zzgfVarZzy == null || !zzgfVarZzy.zzd() || zzgfVarZzy.zze();
    }
}
