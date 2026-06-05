package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhis {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhir.zza, zzhfo.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhio.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhip.zza, zzhfi.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhiq.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    public static /* synthetic */ zzhnn zzb(zzhfo zzhfoVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzhrb zzhrbVarZzd = zzhrc.zzd();
        zzhrbVarZzd.zza(zzh(zzhfoVar));
        zzhrbVarZzd.zzb(zzhfoVar.zzc());
        zzhssVarZze.zzb(((zzhrc) zzhrbVarZzd.zzbm()).zzaM());
        zzhssVarZze.zzc(zzf(zzhfoVar.zze()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhfo zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            zzhrc zzhrcVarZzc = zzhrc.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            zzhfm zzhfmVarZzb = zzhfo.zzb();
            zzhfmVarZzb.zza(zzhrcVarZzc.zzb());
            zzhfmVarZzb.zzb(zzhrcVarZzc.zza().zza());
            zzhfmVarZzb.zzc(16);
            zzhfmVarZzb.zzd(zzg(zzhnnVar.zzc().zzc()));
            return zzhfmVarZzb.zze();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhnm zzd(zzhfi zzhfiVar, zzhel zzhelVar) {
        zzhqz zzhqzVarZze = zzhra.zze();
        zzhqzVarZze.zza(zzh(zzhfiVar.zzf()));
        byte[] bArrZzc = zzhfiVar.zze().zzc(zzhelVar);
        zzhqzVarZze.zzb(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzhra) zzhqzVarZze.zzbm()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhfiVar.zzf().zze()), zzhfiVar.zzb());
    }

    public static /* synthetic */ zzhfi zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
            return null;
        }
        try {
            zzhra zzhraVarZzd = zzhra.zzd(zzhnmVar.zzb(), zzido.zza());
            if (zzhraVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhfm zzhfmVarZzb = zzhfo.zzb();
            zzhfmVarZzb.zza(zzhraVarZzd.zzc().zzb());
            zzhfmVarZzb.zzb(zzhraVarZzd.zzb().zza());
            zzhfmVarZzb.zzc(16);
            zzhfmVarZzb.zzd(zzg(zzhnmVar.zzd()));
            zzhfo zzhfoVarZze = zzhfmVarZzb.zze();
            zzhfh zzhfhVarZzd = zzhfi.zzd();
            zzhfhVarZzd.zza(zzhfoVarZze);
            zzhfhVarZzd.zzb(zzibb.zza(zzhraVarZzd.zzc().zzA(), zzhelVar));
            zzhfhVarZzd.zzc(zzhnmVar.zze());
            return zzhfhVarZzd.zzd();
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing AesEaxKey failed");
            return null;
        }
    }

    private static zzhtm zzf(zzhfn zzhfnVar) throws GeneralSecurityException {
        if (zzhfn.zza.equals(zzhfnVar)) {
            return zzhtm.TINK;
        }
        if (zzhfn.zzb.equals(zzhfnVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhfn.zzc.equals(zzhfnVar)) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhfnVar)));
    }

    private static zzhfn zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhfn.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhfn.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZza, "Unable to parse OutputPrefixType: ", new StringBuilder(String.valueOf(iZza).length() + 34)));
            }
        }
        return zzhfn.zzb;
    }

    private static zzhre zzh(zzhfo zzhfoVar) {
        zzhrd zzhrdVarZzb = zzhre.zzb();
        zzhrdVarZzb.zza(zzhfoVar.zzd());
        return (zzhre) zzhrdVarZzb.zzbm();
    }
}
