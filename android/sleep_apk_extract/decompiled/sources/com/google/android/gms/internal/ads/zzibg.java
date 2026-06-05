package com.google.android.gms.internal.ads;

import java.io.IOException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzibg {
    @Deprecated
    public zzibg() {
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            zzicf zzicfVar = new zzicf(zzica.zza(sb));
            zzicfVar.zza(zzibl.LENIENT);
            zzicb.zza.zza(zzicfVar, this);
            return sb.toString();
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
            return null;
        }
    }

    public String zzd() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final zzibi zze() {
        if (this instanceof zzibi) {
            return (zzibi) this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Not a JSON Object: ".concat(toString()));
        return null;
    }

    public final zzibf zzf() {
        if (this instanceof zzibf) {
            return (zzibf) this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Not a JSON Array: ".concat(toString()));
        return null;
    }

    public final zzibk zzg() {
        if (this instanceof zzibk) {
            return (zzibk) this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Not a JSON Primitive: ".concat(toString()));
        return null;
    }
}
