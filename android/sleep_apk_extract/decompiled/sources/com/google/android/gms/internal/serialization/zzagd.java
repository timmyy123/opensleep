package com.google.android.gms.internal.serialization;

import com.google.home.platform.traits.Trait;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzagd extends zzzg implements zzaar {
    private static final zzagd zzd;
    private static volatile zzaay zze;
    private zzaak zzc = zzaak.zza();
    private zzzs zza = zzzg.emptyProtobufList();
    private zzzs zzb = zzzg.emptyProtobufList();

    static {
        zzagd zzagdVar = new zzagd();
        zzd = zzagdVar;
        zzzg.registerDefaultInstance(zzagd.class, zzagdVar);
        zzzg.newSingularGeneratedExtension(Trait.getDefaultInstance(), zzagdVar, zzagdVar, null, 22, zzace.zzk, zzagd.class);
    }

    private zzagd() {
    }

    public static zzagd zzd(byte[] bArr) {
        return (zzagd) zzzg.parseFrom(zzd, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzd, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0002\u0000\u0001Ț\u0002Ț\u00032", new Object[]{"zza", "zzb", "zzc", zzagc.zza});
        }
        if (iOrdinal == 3) {
            return new zzagd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzagb(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zze;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzagd.class) {
            try {
                zzyzVar = zze;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzd);
                    zze = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final List zza() {
        return this.zza;
    }

    public final List zzb() {
        return this.zzb;
    }

    public final Map zzc() {
        return Collections.unmodifiableMap(this.zzc);
    }
}
