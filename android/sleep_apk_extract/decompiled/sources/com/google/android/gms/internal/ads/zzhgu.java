package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhgu extends zzhet {
    private final zzhgw zza;
    private final zziaz zzb;

    @Nullable
    private final Integer zzc;

    private zzhgu(zzhgw zzhgwVar, zziaz zziazVar, @Nullable Integer num) {
        this.zza = zzhgwVar;
        this.zzb = zziazVar;
        this.zzc = num;
    }

    public static zzhgu zzd(zzhgw zzhgwVar, @Nullable Integer num) throws GeneralSecurityException {
        zziaz zziazVarZza;
        if (zzhgwVar.zzd() == zzhgv.zza) {
            if (num == null) {
                zzbuy$$ExternalSyntheticBUOutline0.m("For given Variant TINK the value of idRequirement must be non-null");
                return null;
            }
            zziazVarZza = zziaz.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzhgwVar.zzd() != zzhgv.zzb) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(zzhgwVar.zzd().toString()));
            }
            if (num != null) {
                zzbuy$$ExternalSyntheticBUOutline0.m("For given Variant NO_PREFIX the value of idRequirement must be null");
                return null;
            }
            zziazVarZza = zziaz.zza(new byte[0]);
        }
        return new zzhgu(zzhgwVar, zziazVarZza, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    public final Integer zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhet
    public final zziaz zzc() {
        return this.zzb;
    }

    public final zzhgw zze() {
        return this.zza;
    }
}
