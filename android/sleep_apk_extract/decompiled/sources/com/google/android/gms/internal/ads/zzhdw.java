package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhdw {
    private final List zza = new ArrayList();
    private final Map zzb = new HashMap();
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final void zzc() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzhdu) it.next()).zzd(false);
        }
    }

    public final zzhdw zza(zzhdu zzhduVar) {
        if (zzhduVar.zzh() != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Entry has already been added to a KeysetHandle.Builder");
            return null;
        }
        if (zzhduVar.zzc()) {
            zzc();
        }
        zzhduVar.zzi(this);
        this.zza.add(zzhduVar);
        return this;
    }

    public final zzheb zzb() throws GeneralSecurityException {
        int i;
        byte[] bArr = null;
        if (this.zzc) {
            zzbuy$$ExternalSyntheticBUOutline0.m("KeysetHandle.Builder#build must only be called once");
            return null;
        }
        this.zzc = true;
        List<zzhdu> list = this.zza;
        ArrayList arrayList = new ArrayList(list.size());
        int i2 = 0;
        while (i2 < list.size() - 1) {
            int i3 = i2 + 1;
            if (((zzhdu) list.get(i2)).zzg() == zzhdv.zza && ((zzhdu) list.get(i3)).zzg() != zzhdv.zza) {
                zzbuy$$ExternalSyntheticBUOutline0.m("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                return null;
            }
            i2 = i3;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzhdu zzhduVar : list) {
            zzhduVar.zze();
            if (zzhduVar.zzg() == null) {
                zzbuy$$ExternalSyntheticBUOutline0.m("No ID was set (with withFixedId or withRandomId)");
                return null;
            }
            int i4 = 3;
            if (zzhduVar.zzg() == zzhdv.zza) {
                int i5 = 0;
                while (true) {
                    if (i5 != 0 && !hashSet.contains(Integer.valueOf(i5))) {
                        break;
                    }
                    int i6 = zzhnz.$r8$clinit;
                    i5 = 0;
                    while (i5 == 0) {
                        byte[] bArrZza = zzhnp.zza(4);
                        i5 = (bArrZza[3] & 255) | ((bArrZza[0] & 255) << 24) | ((bArrZza[1] & 255) << 16) | ((bArrZza[2] & 255) << 8);
                    }
                }
                i = i5;
            } else {
                zzhduVar.zzg();
                i = 0;
            }
            Integer numValueOf = Integer.valueOf(i);
            if (hashSet.contains(numValueOf)) {
                int i7 = i;
                throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i7).length() + 31), "Id ", i7, " is used twice in the keyset"));
            }
            hashSet.add(numValueOf);
            zzhdq zzhdqVarZzc = zzhmi.zza().zzc(zzhduVar.zzf(), true != zzhduVar.zzf().zza() ? null : numValueOf);
            zzhds zzhdsVarZze = zzhduVar.zze();
            zzhds zzhdsVar = zzhds.zza;
            if (!zzhdsVar.equals(zzhdsVarZze)) {
                if (zzhds.zzb.equals(zzhdsVarZze)) {
                    i4 = 4;
                } else {
                    if (!zzhds.zzc.equals(zzhdsVarZze)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown key status");
                        return null;
                    }
                    i4 = 5;
                }
            }
            zzhdz zzhdzVar = new zzhdz(zzhdqVarZzc, i4, i, zzhduVar.zzc(), false, zzhdz.zza, null);
            if (zzhduVar.zzc()) {
                if (num != null) {
                    zzbuy$$ExternalSyntheticBUOutline0.m("Two primaries were set");
                    return null;
                }
                if (zzhduVar.zze() != zzhdsVar) {
                    zzbuy$$ExternalSyntheticBUOutline0.m("Primary key is not enabled");
                    return null;
                }
                num = numValueOf;
            }
            arrayList.add(zzhdzVar);
        }
        if (num != null) {
            return zzheb.zzi(new zzheb(arrayList, this.zzb, bArr));
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("No primary was set");
        return null;
    }
}
