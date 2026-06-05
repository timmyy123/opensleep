package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzheb implements zzhec {
    private final List zza;
    private final Map zzb;

    @Nullable
    private final zzheb zzc;

    private zzheb(List list, Map map) throws GeneralSecurityException {
        this.zza = list;
        this.zzb = map;
        if (zzhkp.zza.zza()) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            boolean zZzd = false;
            while (it.hasNext()) {
                zzhdz zzhdzVar = (zzhdz) it.next();
                if (hashSet.contains(Integer.valueOf(zzhdzVar.zzc()))) {
                    int iZzc = zzhdzVar.zzc();
                    throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzc).length() + 121), "KeyID ", iZzc, " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing."));
                }
                hashSet.add(Integer.valueOf(zzhdzVar.zzc()));
                zZzd |= zzhdzVar.zzd();
            }
            if (!zZzd) {
                zzbuy$$ExternalSyntheticBUOutline0.m("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
                throw null;
            }
        }
        this.zzc = null;
    }

    public static final zzheb zza(zzhsz zzhszVar) throws GeneralSecurityException {
        if (zzhszVar != null && zzhszVar.zzc() > 0) {
            return new zzheb(zzj(zzhszVar), new HashMap());
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("empty keyset");
        return null;
    }

    public static final zzheb zzg(zzheh zzhehVar) {
        zzhdw zzhdwVar = new zzhdw();
        zzhdu zzhduVar = new zzhdu(zzhehVar, null);
        zzhduVar.zzb();
        zzhduVar.zza();
        zzhdwVar.zza(zzhduVar);
        return zzhdwVar.zzb();
    }

    public static /* synthetic */ zzheb zzi(zzheb zzhebVar) {
        zzhebVar.zzf(zzhmc.class);
        return zzhebVar;
    }

    private static List zzj(zzhsz zzhszVar) throws GeneralSecurityException {
        zzhdq zzhlzVar;
        boolean z;
        ArrayList arrayList = new ArrayList(zzhszVar.zzc());
        for (zzhsy zzhsyVar : zzhszVar.zzb()) {
            int iZzc = zzhsyVar.zzc();
            try {
                zzhnm zzhnmVarZzl = zzl(zzhsyVar);
                zzhmr zzhmrVarZza = zzhmr.zza();
                zzhel zzhelVarZza = zzhel.zza();
                zzhlzVar = !zzhmrVarZza.zzf(zzhnmVarZzl) ? new zzhlz(zzhnmVarZzl, zzhelVarZza) : zzhmrVarZza.zzg(zzhnmVarZzl, zzhelVarZza);
                z = false;
            } catch (GeneralSecurityException e) {
                if (zzhkp.zza.zza()) {
                    throw e;
                }
                zzhlzVar = new zzhlz(zzl(zzhsyVar), zzhel.zza());
                z = true;
            }
            if (zzhkp.zza.zza() && !zzm(zzhsyVar.zzk())) {
                zzbuy$$ExternalSyntheticBUOutline0.m("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
                return null;
            }
            boolean z2 = true;
            int iZzk = zzhsyVar.zzk();
            if (iZzc != zzhszVar.zza()) {
                z2 = false;
            }
            arrayList.add(new zzhdz(zzhlzVar, iZzk, iZzc, z2, z, zzhdz.zza, null));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private final zzheb zzk() {
        zzheb zzhebVar = this.zzc;
        return zzhebVar == null ? this : zzhebVar;
    }

    private static zzhnm zzl(zzhsy zzhsyVar) {
        return zzhnm.zza(zzhsyVar.zzb().zza(), zzhsyVar.zzb().zzb(), zzhsyVar.zzb().zzc(), zzhsyVar.zzd(), zzhsyVar.zzd() == zzhtm.RAW ? null : Integer.valueOf(zzhsyVar.zzc()));
    }

    private static boolean zzm(int i) {
        int i2 = i - 2;
        return i2 == 1 || i2 == 2 || i2 == 3;
    }

    public final String toString() {
        zzhsz zzhszVarZzb = zzb();
        int i = zzheo.$r8$clinit;
        zzhta zzhtaVarZza = zzhtd.zza();
        zzhtaVarZza.zza(zzhszVarZzb.zza());
        for (zzhsy zzhsyVar : zzhszVarZzb.zzb()) {
            zzhtb zzhtbVarZza = zzhtc.zza();
            zzhtbVarZza.zza(zzhsyVar.zzb().zza());
            zzhtbVarZza.zzd(zzhsyVar.zzk());
            zzhtbVarZza.zzc(zzhsyVar.zzd());
            zzhtbVarZza.zzb(zzhsyVar.zzc());
            zzhtaVarZza.zzb((zzhtc) zzhtbVarZza.zzbm());
        }
        return ((zzhtd) zzhtaVarZza.zzbm()).toString();
    }

    public final zzhsz zzb() {
        try {
            zzhsw zzhswVarZzh = zzhsz.zzh();
            for (zzhdz zzhdzVar : this.zza) {
                zzhdq zzhdqVarZza = zzhdzVar.zza();
                int iZzj = zzhdzVar.zzj();
                int iZzc = zzhdzVar.zzc();
                zzhnm zzhnmVar = (zzhnm) zzhmr.zza().zzh(zzhdqVarZza, zzhnm.class, zzhel.zza());
                Integer numZzb = zzhdqVarZza.zzb();
                if (numZzb != null && numZzb.intValue() != iZzc) {
                    throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
                }
                zzhsx zzhsxVarZze = zzhsy.zze();
                zzhso zzhsoVarZzd = zzhsq.zzd();
                zzhsoVarZzd.zza(zzhnmVar.zzg());
                zzhsoVarZzd.zzb(zzhnmVar.zzb());
                zzhsoVarZzd.zzc(zzhnmVar.zzc());
                zzhsxVarZze.zzb(zzhsoVarZzd);
                zzhsxVarZze.zze(iZzj);
                zzhsxVarZze.zzc(iZzc);
                zzhsxVarZze.zzd(zzhnmVar.zzd());
                zzhswVarZzh.zzb((zzhsy) zzhsxVarZze.zzbm());
                if (zzhdzVar.zzd()) {
                    zzhswVarZzh.zza(zzhdzVar.zzc());
                }
            }
            return (zzhsz) zzhswVarZzh.zzbm();
        } catch (GeneralSecurityException e) {
            throw new zzhny(e);
        }
    }

    public final zzhdz zzc() {
        for (zzhdz zzhdzVar : this.zza) {
            if (zzhdzVar != null && zzhdzVar.zzd()) {
                if (zzhdzVar.zzb() == zzhds.zza) {
                    return zzhdzVar;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("Keyset has primary which isn't enabled");
                return null;
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Keyset has no valid primary");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhec
    public final int zzd() {
        return this.zza.size();
    }

    public final zzhdz zze(int i) {
        if (i < 0 || i >= zzd()) {
            int iZzd = zzd();
            Events$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 34 + String.valueOf(iZzd).length()), i, "Invalid index ", iZzd, " for keyset of size "));
            return null;
        }
        List list = this.zza;
        zzhdz zzhdzVar = (zzhdz) list.get(i);
        if (!zzm(zzhdzVar.zzj())) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 42), "Keyset-Entry at position ", i, " has wrong status"));
            return null;
        }
        if (!zzhdzVar.zzi()) {
            return (zzhdz) list.get(i);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 48), "Keyset-Entry at position ", i, " didn't parse correctly"));
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhec
    @Nullable
    public final zzhdj zzf(Class cls) {
        if (this.zzb.get(cls) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final Object zzh(zzhdn zzhdnVar, Class cls) throws GeneralSecurityException {
        zzhsz zzhszVarZzb = zzk().zzb();
        int i = zzheo.$r8$clinit;
        int iZza = zzhszVarZzb.zza();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzhsy zzhsyVar : zzhszVarZzb.zzb()) {
            if (zzhsyVar.zzk() == 3) {
                if (!zzhsyVar.zza()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzhsyVar.zzc())));
                }
                if (zzhsyVar.zzd() == zzhtm.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzhsyVar.zzc())));
                }
                if (zzhsyVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzhsyVar.zzc())));
                }
                if (zzhsyVar.zzc() == iZza) {
                    if (z) {
                        zzbuy$$ExternalSyntheticBUOutline0.m("keyset contains multiple primary keys");
                        return null;
                    }
                    z = true;
                }
                z2 &= zzhsyVar.zzb().zzc() == zzhsp.ASYMMETRIC_PUBLIC;
                i2++;
            }
        }
        if (i2 == 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m("keyset must contain at least one ENABLED key");
            return null;
        }
        if (!z && !z2) {
            zzbuy$$ExternalSyntheticBUOutline0.m("keyset doesn't contain a valid primary key");
            return null;
        }
        for (int i3 = 0; i3 < zzd(); i3++) {
            List list = this.zza;
            if (((zzhdz) list.get(i3)).zzi() || !zzm(((zzhdz) list.get(i3)).zzj())) {
                String strZza = zzhszVarZzb.zzd(i3).zzb().zza();
                StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + String.valueOf(i3).length() + 44 + 32);
                zzba$$ExternalSyntheticOutline0.m(sb, "Key parsing of key with index ", i3, " and type_url ", strZza);
                sb.append(" failed, unable to get primitive");
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzhdnVar.zza(zzk(), cls);
    }

    public /* synthetic */ zzheb(List list, Map map, byte[] bArr) {
        this(list, map);
    }
}
