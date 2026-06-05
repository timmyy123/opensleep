package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhiz {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhiy.zza, zzhfx.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhiv.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhiw.zza, zzhfq.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhix.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    public static /* synthetic */ zzhnn zzb(zzhfx zzhfxVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzhrh zzhrhVarZzd = zzhri.zzd();
        zzhrhVarZzd.zza(zzhfxVar.zzc());
        zzhssVarZze.zzb(((zzhri) zzhrhVarZzd.zzbm()).zzaM());
        zzhssVarZze.zzc(zzf(zzhfxVar.zzd()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhfx zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            zzhri zzhriVarZzc = zzhri.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            if (zzhriVarZzc.zzb() != 0) {
                zzbuy$$ExternalSyntheticBUOutline0.m("Only version 0 parameters are accepted");
                return null;
            }
            zzhfv zzhfvVarZzb = zzhfx.zzb();
            zzhfvVarZzb.zza(zzhriVarZzc.zza());
            zzhfvVarZzb.zzb(12);
            zzhfvVarZzb.zzc(16);
            zzhfvVarZzb.zzd(zzg(zzhnnVar.zzc().zzc()));
            return zzhfvVarZzb.zze();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhnm zzd(zzhfq zzhfqVar, zzhel zzhelVar) {
        zzhrf zzhrfVarZzd = zzhrg.zzd();
        byte[] bArrZzc = zzhfqVar.zze().zzc(zzhelVar);
        zzhrfVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzhrg) zzhrfVarZzd.zzbm()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhfqVar.zzf().zzd()), zzhfqVar.zzb());
    }

    public static /* synthetic */ zzhfq zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
            return null;
        }
        try {
            zzhrg zzhrgVarZzc = zzhrg.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhrgVarZzc.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhfv zzhfvVarZzb = zzhfx.zzb();
            zzhfvVarZzb.zza(zzhrgVarZzc.zzb().zzb());
            zzhfvVarZzb.zzb(12);
            zzhfvVarZzb.zzc(16);
            zzhfvVarZzb.zzd(zzg(zzhnmVar.zzd()));
            zzhfx zzhfxVarZze = zzhfvVarZzb.zze();
            zzhfp zzhfpVarZzd = zzhfq.zzd();
            zzhfpVarZzd.zza(zzhfxVarZze);
            zzhfpVarZzd.zzb(zzibb.zza(zzhrgVarZzc.zzb().zzA(), zzhelVar));
            zzhfpVarZzd.zzc(zzhnmVar.zze());
            return zzhfpVarZzd.zzd();
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing AesGcmKey failed");
            return null;
        }
    }

    private static zzhtm zzf(zzhfw zzhfwVar) throws GeneralSecurityException {
        if (zzhfw.zza.equals(zzhfwVar)) {
            return zzhtm.TINK;
        }
        if (zzhfw.zzb.equals(zzhfwVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhfw.zzc.equals(zzhfwVar)) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhfwVar)));
    }

    private static zzhfw zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhfw.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhfw.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZza, "Unable to parse OutputPrefixType: ", new StringBuilder(String.valueOf(iZza).length() + 34)));
            }
        }
        return zzhfw.zzb;
    }
}
