package com.google.android.gms.measurement.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes4.dex */
final class zzan {
    private final EnumMap zza;

    private zzan(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public static zzan zzd(String str) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        if (str.length() >= zzjk.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzjk[] zzjkVarArrValues = zzjk.values();
                int length = zzjkVarArrValues.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put(zzjkVarArrValues[i], zzam.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzan(enumMap);
            }
        }
        return new zzan();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (zzjk zzjkVar : zzjk.values()) {
            zzam zzamVar = (zzam) this.zza.get(zzjkVar);
            if (zzamVar == null) {
                zzamVar = zzam.UNSET;
            }
            sb.append(zzamVar.zzb());
        }
        return sb.toString();
    }

    public final zzam zza(zzjk zzjkVar) {
        zzam zzamVar = (zzam) this.zza.get(zzjkVar);
        return zzamVar == null ? zzam.UNSET : zzamVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzb(zzjk zzjkVar, int i) {
        zzam zzamVar = zzam.UNSET;
        if (i == -30) {
            zzamVar = zzam.TCF;
        } else if (i == -20) {
            zzamVar = zzam.API;
        } else if (i == -10) {
            zzamVar = zzam.MANIFEST;
        } else if (i != 0) {
            if (i == 30) {
                zzamVar = zzam.INITIALIZATION;
            }
        }
        this.zza.put(zzjkVar, zzamVar);
    }

    public final void zzc(zzjk zzjkVar, zzam zzamVar) {
        this.zza.put(zzjkVar, zzamVar);
    }

    public zzan() {
        this.zza = new EnumMap(zzjk.class);
    }
}
