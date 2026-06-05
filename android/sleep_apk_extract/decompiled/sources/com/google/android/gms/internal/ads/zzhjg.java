package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhjg {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhjf.zza, zzhgg.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhjc.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhjd.zza, zzhfz.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhje.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    public static /* synthetic */ zzhnn zzb(zzhgg zzhggVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzhrl zzhrlVarZzd = zzhrm.zzd();
        zzhrlVarZzd.zza(zzhggVar.zzc());
        zzhssVarZze.zzb(((zzhrm) zzhrlVarZzd.zzbm()).zzaM());
        zzhssVarZze.zzc(zzf(zzhggVar.zzd()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhgg zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            zzhrm zzhrmVarZzc = zzhrm.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            if (zzhrmVarZzc.zzb() != 0) {
                zzbuy$$ExternalSyntheticBUOutline0.m("Only version 0 parameters are accepted");
                return null;
            }
            zzhge zzhgeVarZzb = zzhgg.zzb();
            zzhgeVarZzb.zza(zzhrmVarZzc.zza());
            zzhgeVarZzb.zzb(zzg(zzhnnVar.zzc().zzc()));
            return zzhgeVarZzb.zzc();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhnm zzd(zzhfz zzhfzVar, zzhel zzhelVar) {
        zzhrj zzhrjVarZzd = zzhrk.zzd();
        byte[] bArrZzc = zzhfzVar.zze().zzc(zzhelVar);
        zzhrjVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzhrk) zzhrjVarZzd.zzbm()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhfzVar.zzf().zzd()), zzhfzVar.zzb());
    }

    public static /* synthetic */ zzhfz zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
            return null;
        }
        try {
            zzhrk zzhrkVarZzc = zzhrk.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhrkVarZzc.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhge zzhgeVarZzb = zzhgg.zzb();
            zzhgeVarZzb.zza(zzhrkVarZzc.zzb().zzb());
            zzhgeVarZzb.zzb(zzg(zzhnmVar.zzd()));
            zzhgg zzhggVarZzc = zzhgeVarZzb.zzc();
            zzhfy zzhfyVarZzd = zzhfz.zzd();
            zzhfyVarZzd.zza(zzhggVarZzc);
            zzhfyVarZzd.zzb(zzibb.zza(zzhrkVarZzc.zzb().zzA(), zzhelVar));
            zzhfyVarZzd.zzc(zzhnmVar.zze());
            return zzhfyVarZzd.zzd();
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing AesGcmSivKey failed");
            return null;
        }
    }

    private static zzhtm zzf(zzhgf zzhgfVar) throws GeneralSecurityException {
        if (zzhgf.zza.equals(zzhgfVar)) {
            return zzhtm.TINK;
        }
        if (zzhgf.zzb.equals(zzhgfVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhgf.zzc.equals(zzhgfVar)) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhgfVar)));
    }

    private static zzhgf zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhgf.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhgf.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZza, "Unable to parse OutputPrefixType: ", new StringBuilder(String.valueOf(iZza).length() + 34)));
            }
        }
        return zzhgf.zzb;
    }
}
