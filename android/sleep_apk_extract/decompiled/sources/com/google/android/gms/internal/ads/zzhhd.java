package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhhd {

    @Nullable
    private zzhhf zza;

    @Nullable
    private String zzb;

    @Nullable
    private zzhhe zzc;

    @Nullable
    private zzheu zzd;

    public /* synthetic */ zzhhd(byte[] bArr) {
    }

    public final zzhhd zza(zzhhf zzhhfVar) {
        this.zza = zzhhfVar;
        return this;
    }

    public final zzhhd zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzhhd zzc(zzhhe zzhheVar) {
        this.zzc = zzhheVar;
        return this;
    }

    public final zzhhd zzd(zzheu zzheuVar) {
        this.zzd = zzheuVar;
        return this;
    }

    public final zzhhg zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzhhf.zzb;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("kekUri must be set");
            return null;
        }
        zzhhe zzhheVar = this.zzc;
        if (zzhheVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("dekParsingStrategy must be set");
            return null;
        }
        zzheu zzheuVar = this.zzd;
        if (zzheuVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("dekParametersForNewKeys must be set");
            return null;
        }
        if (zzheuVar.zza()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("dekParametersForNewKeys must not have ID Requirements");
            return null;
        }
        if ((zzhheVar == zzhhe.zza && (zzheuVar instanceof zzhfx)) || ((zzhheVar == zzhhe.zzc && (zzheuVar instanceof zzhgm)) || ((zzhheVar == zzhhe.zzb && (zzheuVar instanceof zzhii)) || ((zzhheVar == zzhhe.zzd && (zzheuVar instanceof zzhfg)) || ((zzhheVar == zzhhe.zze && (zzheuVar instanceof zzhfo)) || (zzhheVar == zzhhe.zzf && (zzheuVar instanceof zzhgg))))))) {
            return new zzhhg(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        String string = this.zzc.toString();
        String strValueOf = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(strValueOf.length() + string.length() + 67 + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Cannot use parsing strategy ", string, " when new keys are picked according to ", strValueOf);
        sb.append(".");
        throw new GeneralSecurityException(sb.toString());
    }
}
