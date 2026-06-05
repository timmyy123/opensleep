package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhya {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zziaz zzb;
    private static final zziaz zzc;
    private static final zzhmy zzd;
    private static final zzhmv zze;
    private static final zzhlu zzf;
    private static final zzhlr zzg;
    private static final zzhlu zzh;
    private static final zzhlr zzi;
    private static final zzhli zzj;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey");
        zzb = zziazVarZza;
        zziaz zziazVarZza2 = zzhnz.zza("type.googleapis.com/google.crypto.tink.Ed25519PublicKey");
        zzc = zziazVarZza2;
        zzd = zzhmy.zzd(zzhxz.zza, zzhve.class, zzhnn.class);
        zze = zzhmv.zzd(zzhxu.zza, zziazVarZza, zzhnn.class);
        zzf = zzhlu.zzd(zzhxv.zza, zzhvl.class, zzhnm.class);
        zzg = zzhlr.zzd(zzhxw.zza, zziazVarZza2, zzhnm.class);
        zzh = zzhlu.zzd(zzhxx.zza, zzhvf.class, zzhnm.class);
        zzi = zzhlr.zzd(zzhxy.zza, zziazVarZza, zzhnm.class);
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zzhtm.RAW, zzhvd.zzd);
        zzhlhVarZza.zza(zzhtm.TINK, zzhvd.zza);
        zzhlhVarZza.zza(zzhtm.CRUNCHY, zzhvd.zzb);
        zzhlhVarZza.zza(zzhtm.LEGACY, zzhvd.zzc);
        zzj = zzhlhVarZza.zzb();
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzd);
        zzhmrVar.zze(zze);
        zzhmrVar.zzb(zzf);
        zzhmrVar.zzc(zzg);
        zzhmrVar.zzb(zzh);
        zzhmrVar.zzc(zzi);
    }

    public static /* synthetic */ zzhnn zzb(zzhve zzhveVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey");
        zzhssVarZze.zzb(zzhsb.zzc().zzaM());
        zzhssVarZze.zzc((zzhtm) zzj.zzb(zzhveVar.zzc()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhve zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to Ed25519ProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            if (zzhsb.zzb(zzhnnVar.zzc().zzb(), zzido.zza()).zza() == 0) {
                return zzhve.zzb((zzhvd) zzj.zzc(zzhnnVar.zzc().zzc()));
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing Ed25519Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhvl zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.Ed25519PublicKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to Ed25519ProtoSerialization.parsePublicKey: ".concat(String.valueOf(zzhnmVar.zzg())));
            return null;
        }
        try {
            zzhsf zzhsfVarZzc = zzhsf.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhsfVarZzc.zza() == 0) {
                return zzhvl.zzc((zzhvd) zzj.zzc(zzhnmVar.zzd()), zziaz.zza(zzhsfVarZzc.zzb().zzA()), zzhnmVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing Ed25519PublicKey failed");
            return null;
        }
    }

    public static /* synthetic */ zzhnm zzf(zzhvf zzhvfVar, zzhel zzhelVar) {
        zzhsc zzhscVarZze = zzhsd.zze();
        zzhscVarZze.zzb(zzh(zzhvfVar.zze()));
        byte[] bArrZzc = zzhvfVar.zzf().zzc(zzhelVar);
        zzhscVarZze.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey", ((zzhsd) zzhscVarZze.zzbm()).zzaM(), zzhsp.ASYMMETRIC_PRIVATE, (zzhtm) zzj.zzb(zzhvfVar.zzd().zzc()), zzhvfVar.zze().zzb());
    }

    public static /* synthetic */ zzhvf zzg(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to Ed25519ProtoSerialization.parsePrivateKey: ".concat(String.valueOf(zzhnmVar.zzg())));
            return null;
        }
        try {
            zzhsd zzhsdVarZzd = zzhsd.zzd(zzhnmVar.zzb(), zzido.zza());
            if (zzhsdVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhsf zzhsfVarZzc = zzhsdVarZzd.zzc();
            if (zzhsfVarZzc.zza() == 0) {
                return zzhvf.zzc(zzhvl.zzc((zzhvd) zzj.zzc(zzhnmVar.zzd()), zziaz.zza(zzhsfVarZzc.zzb().zzA()), zzhnmVar.zze()), zzibb.zza(zzhsdVarZzd.zzb().zzA(), zzhelVar));
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zziet unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing Ed25519PrivateKey failed");
            return null;
        }
    }

    private static zzhsf zzh(zzhvl zzhvlVar) {
        zzhse zzhseVarZzd = zzhsf.zzd();
        byte[] bArrZzc = zzhvlVar.zzd().zzc();
        zzhseVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return (zzhsf) zzhseVarZzd.zzbm();
    }
}
