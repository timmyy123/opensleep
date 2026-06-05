package com.google.android.gms.internal.measurement;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.util.Collection;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zznd {
    private static final zznd zza = new zznd(zzmw.zzb(), zzmq.zzi());
    private final zzmw zzb;
    private final zzmq zzc;

    private zznd(zzmw zzmwVar, zzmq zzmqVar) {
        this.zzb = (zzmw) Preconditions.checkNotNull(zzmwVar);
        this.zzc = zzmqVar;
    }

    public static zznd zza() {
        return zza;
    }

    public static zznd zzb(zzacv zzacvVar, boolean z) throws zzaeh {
        zzmw zzmwVar;
        int iZzr = zzacvVar.zzr();
        if (iZzr > 1) {
            Gson$$ExternalSyntheticBUOutline0.m$1(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzr).length() + 44), "Unsupported version: ", iZzr, ". Current version is: 1"));
            return null;
        }
        zzacvVar.zzr();
        int iZzD = zzacvVar.zzD(zzacvVar.zzp());
        zzmq zzmqVarZzh = zzmq.zzh(zzacvVar, zzadf.zza());
        zzacvVar.zzE(iZzD);
        zzmu zzmuVarZza = zzmu.zza();
        try {
            if (z) {
                int iZzD2 = zzacvVar.zzD(zzacvVar.zzp());
                zzmwVar = (zzmw) zzmuVarZza.zzc(zzacvVar, zznb.zza);
                if (zzacvVar.zzF() != 0) {
                    throw new zzaeh("Unexpected bytes remaining after FlagsBlob parsing.");
                }
                zzacvVar.zzE(iZzD2);
            } else {
                zzmwVar = (zzmw) zzmuVarZza.zzb(zzacvVar.zzo(), zznc.zza);
            }
            zzmuVarZza.close();
            return new zznd(zzmwVar, zzmqVarZzh);
        } catch (Throwable th) {
            try {
                zzmuVarZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final zzmw zzc() {
        ImmutableMap immutableMapBuildKeepingLast;
        zzmq zzmqVar = this.zzc;
        int iZze = zzmqVar.zze();
        zzmw zzmwVar = this.zzb;
        if (iZze <= 0) {
            return zzmwVar;
        }
        Collection<zzmi> collectionValues = zzmqVar.zzf().values();
        if (collectionValues == null) {
            immutableMapBuildKeepingLast = ImmutableMap.of();
        } else {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            for (zzmi zzmiVar : collectionValues) {
                int iZzq = zzmiVar.zzq();
                int i = iZzq - 1;
                if (iZzq == 0) {
                    throw null;
                }
                if (i == 0) {
                    builder.put(zzmiVar.zza(), Long.valueOf(zzmiVar.zzb()));
                } else if (i == 1) {
                    builder.put(zzmiVar.zza(), Boolean.valueOf(zzmiVar.zzc()));
                } else if (i == 2) {
                    builder.put(zzmiVar.zza(), Double.valueOf(zzmiVar.zzd()));
                } else if (i == 3) {
                    builder.put(zzmiVar.zza(), zzmiVar.zze());
                } else {
                    if (i != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Could not serialize Flag for override: ".concat(String.valueOf(zzmiVar.zza())));
                        return null;
                    }
                    builder.put(zzmiVar.zza(), zzmiVar.zzf().zzm());
                }
            }
            immutableMapBuildKeepingLast = builder.buildKeepingLast();
        }
        return zzmw.zza(zzmwVar, immutableMapBuildKeepingLast);
    }

    public final String zzd() {
        return this.zzc.zza();
    }

    public final String zze() {
        return this.zzc.zzc();
    }

    public final long zzf() {
        return this.zzc.zzd();
    }

    public final zzacr zzg() {
        return this.zzc.zzb();
    }

    public final Map zzh() {
        zzmq zzmqVar = this.zzc;
        if (zzmqVar.zze() == 0) {
            return null;
        }
        return zzmqVar.zzf();
    }

    public final boolean zzi() {
        if (this.zzb.zze().isEmpty()) {
            return zzmq.zzi().equals(this.zzc);
        }
        return false;
    }
}
