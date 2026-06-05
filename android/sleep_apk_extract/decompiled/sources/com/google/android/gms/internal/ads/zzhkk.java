package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhkk {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhkj.zza, zzhii.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhkg.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhkh.zza, zzhic.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhki.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    public static /* synthetic */ zzhnn zzb(zzhii zzhiiVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzhssVarZze.zzb(zzhuo.zzc().zzaM());
        zzhssVarZze.zzc(zzf(zzhiiVar.zzc()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhii zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            if (zzhuo.zzb(zzhnnVar.zzc().zzb(), zzido.zza()).zza() == 0) {
                return zzhii.zzb(zzg(zzhnnVar.zzc().zzc()));
            }
            zzbuy$$ExternalSyntheticBUOutline0.m("Only version 0 parameters are accepted");
            return null;
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhnm zzd(zzhic zzhicVar, zzhel zzhelVar) {
        zzhul zzhulVarZzd = zzhum.zzd();
        byte[] bArrZzc = zzhicVar.zze().zzc(zzhelVar);
        zzhulVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzhum) zzhulVarZzd.zzbm()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhicVar.zzf().zzc()), zzhicVar.zzb());
    }

    public static /* synthetic */ zzhic zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
            return null;
        }
        try {
            zzhum zzhumVarZzc = zzhum.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhumVarZzc.zza() == 0) {
                return zzhic.zzd(zzg(zzhnmVar.zzd()), zzibb.zza(zzhumVarZzc.zzb().zzA(), zzhelVar), zzhnmVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing XChaCha20Poly1305Key failed");
            return null;
        }
    }

    private static zzhtm zzf(zzhih zzhihVar) throws GeneralSecurityException {
        if (zzhih.zza.equals(zzhihVar)) {
            return zzhtm.TINK;
        }
        if (zzhih.zzb.equals(zzhihVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhih.zzc.equals(zzhihVar)) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhihVar.toString()));
    }

    private static zzhih zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhih.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhih.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZza, "Unable to parse OutputPrefixType: ", new StringBuilder(String.valueOf(iZza).length() + 34)));
            }
        }
        return zzhih.zzb;
    }
}
