package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhjm {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhjl.zza, zzhgm.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhji.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhjj.zza, zzhgh.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhjk.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    public static /* synthetic */ zzhnn zzb(zzhgm zzhgmVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzhssVarZze.zzb(zzhrq.zzb().zzaM());
        zzhssVarZze.zzc(zzf(zzhgmVar.zzc()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhgm zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            zzhrq.zza(zzhnnVar.zzc().zzb(), zzido.zza());
            return zzhgm.zzb(zzg(zzhnnVar.zzc().zzc()));
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhnm zzd(zzhgh zzhghVar, zzhel zzhelVar) {
        zzhrn zzhrnVarZzd = zzhro.zzd();
        byte[] bArrZzc = zzhghVar.zze().zzc(zzhelVar);
        zzhrnVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzhro) zzhrnVarZzd.zzbm()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhghVar.zzf().zzc()), zzhghVar.zzb());
    }

    public static /* synthetic */ zzhgh zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
            return null;
        }
        try {
            zzhro zzhroVarZzc = zzhro.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhroVarZzc.zza() == 0) {
                return zzhgh.zzd(zzg(zzhnmVar.zzd()), zzibb.zza(zzhroVarZzc.zzb().zzA(), zzhelVar), zzhnmVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing ChaCha20Poly1305Key failed");
            return null;
        }
    }

    private static zzhtm zzf(zzhgl zzhglVar) throws GeneralSecurityException {
        if (zzhgl.zza.equals(zzhglVar)) {
            return zzhtm.TINK;
        }
        if (zzhgl.zzb.equals(zzhglVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhgl.zzc.equals(zzhglVar)) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhglVar.toString()));
    }

    private static zzhgl zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhgl.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhgl.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZza, "Unable to parse OutputPrefixType: ", new StringBuilder(String.valueOf(iZza).length() + 34)));
            }
        }
        return zzhgl.zzb;
    }
}
