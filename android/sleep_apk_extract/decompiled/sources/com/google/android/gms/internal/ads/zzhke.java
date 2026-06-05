package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhke {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhkd.zza, zzhib.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhka.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhkb.zza, zzhhw.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhkc.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    public static /* synthetic */ zzhnn zzb(zzhib zzhibVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzhuh zzhuhVarZzd = zzhui.zzd();
        zzhuj zzhujVarZzb = zzhuk.zzb();
        zzhujVarZzb.zza(zzhibVar.zzd());
        zzhuhVarZzd.zza((zzhuk) zzhujVarZzb.zzbm());
        zzhssVarZze.zzb(((zzhui) zzhuhVarZzd.zzbm()).zzaM());
        zzhssVarZze.zzc(zzf(zzhibVar.zzc()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhib zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            zzhui zzhuiVarZzc = zzhui.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            if (zzhuiVarZzc.zza() == 0) {
                return zzhib.zzb(zzg(zzhnnVar.zzc().zzc()), zzhuiVarZzc.zzb().zza());
            }
            zzbuy$$ExternalSyntheticBUOutline0.m("Only version 0 parameters are accepted");
            return null;
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhnm zzd(zzhhw zzhhwVar, zzhel zzhelVar) {
        zzhuf zzhufVarZze = zzhug.zze();
        byte[] bArrZzc = zzhhwVar.zze().zzc(zzhelVar);
        zzhufVarZze.zzb(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        zzhuj zzhujVarZzb = zzhuk.zzb();
        zzhujVarZzb.zza(zzhhwVar.zzf().zzd());
        zzhufVarZze.zza((zzhuk) zzhujVarZzb.zzbm());
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzhug) zzhufVarZze.zzbm()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhhwVar.zzf().zzc()), zzhhwVar.zzb());
    }

    public static /* synthetic */ zzhhw zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
            return null;
        }
        try {
            zzhug zzhugVarZzd = zzhug.zzd(zzhnmVar.zzb(), zzido.zza());
            if (zzhugVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzhugVarZzd.zzc().zzb() == 32) {
                return zzhhw.zzd(zzhib.zzb(zzg(zzhnmVar.zzd()), zzhugVarZzd.zzb().zza()), zzibb.zza(zzhugVarZzd.zzc().zzA(), zzhelVar), zzhnmVar.zze());
            }
            throw new GeneralSecurityException("Only 32 byte key size is accepted");
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing XAesGcmKey failed");
            return null;
        }
    }

    private static zzhtm zzf(zzhia zzhiaVar) throws GeneralSecurityException {
        if (zzhiaVar == zzhia.zza) {
            return zzhtm.TINK;
        }
        if (zzhiaVar == zzhia.zzb) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhiaVar.toString()));
    }

    private static zzhia zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhia.zza;
        }
        if (iOrdinal == 3) {
            return zzhia.zzb;
        }
        int iZza = zzhtmVar.zza();
        throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZza, "Unable to parse OutputPrefixType: ", new StringBuilder(String.valueOf(iZza).length() + 34)));
    }
}
