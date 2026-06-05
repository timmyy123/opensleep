package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaej extends zzzg implements zzaar {
    private static final zzaej zzb;
    private static volatile zzaay zzc;
    private zzzs zza = zzzg.emptyProtobufList();

    static {
        zzaej zzaejVar = new zzaej();
        zzb = zzaejVar;
        zzzg.registerDefaultInstance(zzaej.class, zzaejVar);
    }

    private zzaej() {
    }

    public static zzaei zzb() {
        return (zzaei) zzb.createBuilder();
    }

    public static zzaay zzc() {
        return zzb.getParserForType();
    }

    private final void zzg() {
        zzzs zzzsVar = this.zza;
        if (zzzsVar.zza()) {
            return;
        }
        this.zza = zzzg.mutableCopy(zzzsVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzacx.class});
        }
        if (iOrdinal == 3) {
            return new zzaej();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaei(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzc;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzaej.class) {
            try {
                zzyzVar = zzc;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzb);
                    zzc = zzyzVar;
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

    public final /* synthetic */ void zzd(zzacx zzacxVar) {
        zzacxVar.getClass();
        zzg();
        this.zza.add(zzacxVar);
    }

    public final /* synthetic */ void zze(Iterable iterable) {
        zzg();
        zzvy.addAll(iterable, this.zza);
    }
}
