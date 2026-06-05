package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadr extends zzzg implements zzaar {
    private static final zzadr zzc;
    private static volatile zzaay zzd;
    private zzzs zza = zzzg.emptyProtobufList();
    private zzzs zzb = zzzg.emptyProtobufList();

    static {
        zzadr zzadrVar = new zzadr();
        zzc = zzadrVar;
        zzzg.registerDefaultInstance(zzadr.class, zzadrVar);
    }

    private zzadr() {
    }

    public static zzadq zzc() {
        return (zzadq) zzc.createBuilder();
    }

    private final void zzh() {
        zzzs zzzsVar = this.zzb;
        if (zzzsVar.zza()) {
            return;
        }
        this.zzb = zzzg.mutableCopy(zzzsVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001Ț\u0002\u001b", new Object[]{"zza", "zzb", zzadn.class});
        }
        if (iOrdinal == 3) {
            return new zzadr();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzadq(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzd;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzadr.class) {
            try {
                zzyzVar = zzd;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzc);
                    zzd = zzyzVar;
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

    public final /* synthetic */ void zzd(Iterable iterable) {
        zzzs zzzsVar = this.zza;
        if (!zzzsVar.zza()) {
            this.zza = zzzg.mutableCopy(zzzsVar);
        }
        zzvy.addAll(iterable, this.zza);
    }

    public final /* synthetic */ void zze(zzadn zzadnVar) {
        zzadnVar.getClass();
        zzh();
        this.zzb.add(zzadnVar);
    }

    public final /* synthetic */ void zzf(Iterable iterable) {
        zzh();
        zzvy.addAll(iterable, this.zzb);
    }
}
