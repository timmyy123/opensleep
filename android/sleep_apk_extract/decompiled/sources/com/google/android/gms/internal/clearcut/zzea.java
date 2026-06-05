package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
final class zzea {
    private static final zzea zznc = new zzea();
    private final zzeg zznd;
    private final ConcurrentMap<Class<?>, zzef<?>> zzne = new ConcurrentHashMap();

    private zzea() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzeg zzegVarZzk = null;
        for (int i = 0; i <= 0; i++) {
            zzegVarZzk = zzk(strArr[0]);
            if (zzegVarZzk != null) {
                break;
            }
        }
        this.zznd = zzegVarZzk == null ? new zzdd() : zzegVarZzk;
    }

    public static zzea zzcm() {
        return zznc;
    }

    private static zzeg zzk(String str) {
        try {
            return (zzeg) Class.forName(str).getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> zzef<T> zze(Class<T> cls) {
        zzci.zza(cls, "messageType");
        zzef<T> zzefVarZzd = (zzef) this.zzne.get(cls);
        if (zzefVarZzd == null) {
            zzefVarZzd = this.zznd.zzd(cls);
            zzci.zza(cls, "messageType");
            zzci.zza(zzefVarZzd, "schema");
            zzef<T> zzefVar = (zzef) this.zzne.putIfAbsent(cls, zzefVarZzd);
            if (zzefVar != null) {
                return zzefVar;
            }
        }
        return zzefVarZzd;
    }

    public final <T> zzef<T> zzp(T t) {
        return zze(t.getClass());
    }
}
