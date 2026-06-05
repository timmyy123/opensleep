package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayDeque;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhlk extends zzibm {
    public static final zzibg zza(zzicd zzicdVar) throws IOException {
        String strZzh;
        int iZzm = zzicdVar.zzm();
        zzibg zzibgVarZzc = zzc(zzicdVar, iZzm);
        if (zzibgVarZzc == null) {
            return zzb(zzicdVar, iZzm);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzicdVar.zzf()) {
                if (zzibgVarZzc instanceof zzibi) {
                    strZzh = zzicdVar.zzh();
                    if (!zzhlm.zza(strZzh)) {
                        OggIO$$ExternalSyntheticBUOutline0.m("illegal characters in string");
                        return null;
                    }
                } else {
                    strZzh = null;
                }
                int iZzm2 = zzicdVar.zzm();
                zzibg zzibgVarZzc2 = zzc(zzicdVar, iZzm2);
                zzibg zzibgVarZzb = zzibgVarZzc2 == null ? zzb(zzicdVar, iZzm2) : zzibgVarZzc2;
                if (zzibgVarZzc instanceof zzibf) {
                    ((zzibf) zzibgVarZzc).zza(zzibgVarZzb);
                } else {
                    zzibi zzibiVar = (zzibi) zzibgVarZzc;
                    if (zzibiVar.zzc(strZzh)) {
                        OggIO$$ExternalSyntheticBUOutline0.m("duplicate key: ".concat(String.valueOf(strZzh)));
                        return null;
                    }
                    zzibiVar.zza(strZzh, zzibgVarZzb);
                }
                if (zzibgVarZzc2 != null) {
                    arrayDeque.addLast(zzibgVarZzc);
                    if (arrayDeque.size() > 100) {
                        OggIO$$ExternalSyntheticBUOutline0.m("too many recursions");
                        return null;
                    }
                    zzibgVarZzc = zzibgVarZzb;
                } else {
                    continue;
                }
            } else {
                if (zzibgVarZzc instanceof zzibf) {
                    zzicdVar.zzc();
                } else {
                    zzicdVar.zze();
                }
                if (arrayDeque.isEmpty()) {
                    return zzibgVarZzc;
                }
                zzibgVarZzc = (zzibg) arrayDeque.removeLast();
            }
        }
    }

    private static final zzibg zzb(zzicd zzicdVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            String strZzi = zzicdVar.zzi();
            if (zzhlm.zza(strZzi)) {
                return new zzibk(strZzi);
            }
            OggIO$$ExternalSyntheticBUOutline0.m("illegal characters in string");
            return null;
        }
        if (i2 == 6) {
            return new zzibk(new zzhll(zzicdVar.zzi()));
        }
        if (i2 == 7) {
            return new zzibk(Boolean.valueOf(zzicdVar.zzj()));
        }
        if (i2 == 8) {
            zzicdVar.zzk();
            return zzibh.zza;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Unexpected token: ".concat(zzice.zza(i)));
        return null;
    }

    @Nullable
    private static final zzibg zzc(zzicd zzicdVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            zzicdVar.zzb();
            return new zzibf();
        }
        if (i2 != 2) {
            return null;
        }
        zzicdVar.zzd();
        return new zzibi();
    }
}
