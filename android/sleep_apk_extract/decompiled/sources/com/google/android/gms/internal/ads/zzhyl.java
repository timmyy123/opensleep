package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhyl {
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
    private static final zzhli zzk;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey");
        zzb = zziazVarZza;
        zziaz zziazVarZza2 = zzhnz.zza("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey");
        zzc = zziazVarZza2;
        zzd = zzhmy.zzd(zzhyk.zza, zzhwm.class, zzhnn.class);
        zze = zzhmv.zzd(zzhyf.zza, zziazVarZza, zzhnn.class);
        zzf = zzhlu.zzd(zzhyg.zza, zzhwq.class, zzhnm.class);
        zzg = zzhlr.zzd(zzhyh.zza, zziazVarZza2, zzhnm.class);
        zzh = zzhlu.zzd(zzhyi.zza, zzhwo.class, zzhnm.class);
        zzi = zzhlr.zzd(zzhyj.zza, zziazVarZza, zzhnm.class);
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zzhtm.RAW, zzhwl.zzd);
        zzhlhVarZza.zza(zzhtm.TINK, zzhwl.zza);
        zzhlhVarZza.zza(zzhtm.CRUNCHY, zzhwl.zzb);
        zzhlhVarZza.zza(zzhtm.LEGACY, zzhwl.zzc);
        zzj = zzhlhVarZza.zzb();
        zzhlh zzhlhVarZza2 = zzhli.zza();
        zzhlhVarZza2.zza(zzhsh.SHA256, zzhwk.zza);
        zzhlhVarZza2.zza(zzhsh.SHA384, zzhwk.zzb);
        zzhlhVarZza2.zza(zzhsh.SHA512, zzhwk.zzc);
        zzk = zzhlhVarZza2.zzb();
    }

    public static void zza(zzhmr zzhmrVar) {
        zzhmrVar.zzd(zzd);
        zzhmrVar.zze(zze);
        zzhmrVar.zzb(zzf);
        zzhmrVar.zzc(zzg);
        zzhmrVar.zzb(zzh);
        zzhmrVar.zzc(zzi);
    }

    public static /* synthetic */ zzhnn zzb(zzhwm zzhwmVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey");
        zzhtp zzhtpVarZze = zzhtq.zze();
        zzhtpVarZze.zza(zzh(zzhwmVar));
        zzhtpVarZze.zzb(zzhwmVar.zzc());
        byte[] bArrZza = zzhku.zza(zzhwmVar.zzd());
        zzida zzidaVar = zzida.zza;
        zzhtpVarZze.zzc(zzida.zzt(bArrZza, 0, bArrZza.length));
        zzhssVarZze.zzb(((zzhtq) zzhtpVarZze.zzbm()).zzaM());
        zzhssVarZze.zzc((zzhtm) zzj.zzb(zzhwmVar.zze()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhwm zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            zzhtq zzhtqVarZzd = zzhtq.zzd(zzhnnVar.zzc().zzb(), zzido.zza());
            zzhwj zzhwjVarZzb = zzhwm.zzb();
            zzhwjVarZzb.zzd((zzhwk) zzk.zzc(zzhtqVarZzd.zza().zza()));
            zzhwjVarZzb.zzb(new BigInteger(1, zzhtqVarZzd.zzc().zzA()));
            zzhwjVarZzb.zza(zzhtqVarZzd.zzb());
            zzhwjVarZzb.zzc((zzhwl) zzj.zzc(zzhnnVar.zzc().zzc()));
            return zzhwjVarZzb.zze();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhwq zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePublicKey: ".concat(String.valueOf(zzhnmVar.zzg())));
            return null;
        }
        try {
            zzhtw zzhtwVarZze = zzhtw.zze(zzhnmVar.zzb(), zzido.zza());
            if (zzhtwVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhtwVarZze.zzc().zzA());
            int iBitLength = bigInteger.bitLength();
            zzhwj zzhwjVarZzb = zzhwm.zzb();
            zzhwjVarZzb.zzd((zzhwk) zzk.zzc(zzhtwVarZze.zzb().zza()));
            zzhwjVarZzb.zzb(new BigInteger(1, zzhtwVarZze.zzd().zzA()));
            zzhwjVarZzb.zza(iBitLength);
            zzhwjVarZzb.zzc((zzhwl) zzj.zzc(zzhnmVar.zzd()));
            zzhwm zzhwmVarZze = zzhwjVarZzb.zze();
            zzhwp zzhwpVarZzc = zzhwq.zzc();
            zzhwpVarZzc.zza(zzhwmVarZze);
            zzhwpVarZzc.zzb(bigInteger);
            zzhwpVarZzc.zzc(zzhnmVar.zze());
            return zzhwpVarZzc.zzd();
        } catch (zziet | IllegalArgumentException unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing RsaSsaPkcs1PublicKey failed");
            return null;
        }
    }

    public static /* synthetic */ zzhnm zzf(zzhwo zzhwoVar, zzhel zzhelVar) {
        zzhtt zzhttVarZzk = zzhtu.zzk();
        zzhttVarZzk.zza(0);
        zzhttVarZzk.zzb(zzi(zzhwoVar.zze()));
        byte[] bArrZza = zzhku.zza(zzhwoVar.zzi().zzb(zzhelVar));
        zzida zzidaVar = zzida.zza;
        zzhttVarZzk.zzc(zzida.zzt(bArrZza, 0, bArrZza.length));
        byte[] bArrZza2 = zzhku.zza(zzhwoVar.zzf().zzb(zzhelVar));
        zzhttVarZzk.zzd(zzida.zzt(bArrZza2, 0, bArrZza2.length));
        byte[] bArrZza3 = zzhku.zza(zzhwoVar.zzh().zzb(zzhelVar));
        zzhttVarZzk.zze(zzida.zzt(bArrZza3, 0, bArrZza3.length));
        byte[] bArrZza4 = zzhku.zza(zzhwoVar.zzj().zzb(zzhelVar));
        zzhttVarZzk.zzf(zzida.zzt(bArrZza4, 0, bArrZza4.length));
        byte[] bArrZza5 = zzhku.zza(zzhwoVar.zzk().zzb(zzhelVar));
        zzhttVarZzk.zzg(zzida.zzt(bArrZza5, 0, bArrZza5.length));
        byte[] bArrZza6 = zzhku.zza(zzhwoVar.zzl().zzb(zzhelVar));
        zzhttVarZzk.zzh(zzida.zzt(bArrZza6, 0, bArrZza6.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey", ((zzhtu) zzhttVarZzk.zzbm()).zzaM(), zzhsp.ASYMMETRIC_PRIVATE, (zzhtm) zzj.zzb(zzhwoVar.zzd().zze()), zzhwoVar.zze().zzb());
    }

    public static /* synthetic */ zzhwo zzg(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePrivateKey: ".concat(String.valueOf(zzhnmVar.zzg())));
            return null;
        }
        try {
            zzhtu zzhtuVarZzj = zzhtu.zzj(zzhnmVar.zzb(), zzido.zza());
            if (zzhtuVarZzj.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhtw zzhtwVarZzb = zzhtuVarZzj.zzb();
            if (zzhtwVarZzb.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhtwVarZzb.zzc().zzA());
            int iBitLength = bigInteger.bitLength();
            BigInteger bigInteger2 = new BigInteger(1, zzhtwVarZzb.zzd().zzA());
            zzhwj zzhwjVarZzb = zzhwm.zzb();
            zzhwjVarZzb.zzd((zzhwk) zzk.zzc(zzhtwVarZzb.zzb().zza()));
            zzhwjVarZzb.zzb(bigInteger2);
            zzhwjVarZzb.zza(iBitLength);
            zzhwjVarZzb.zzc((zzhwl) zzj.zzc(zzhnmVar.zzd()));
            zzhwm zzhwmVarZze = zzhwjVarZzb.zze();
            zzhwp zzhwpVarZzc = zzhwq.zzc();
            zzhwpVarZzc.zza(zzhwmVarZze);
            zzhwpVarZzc.zzb(bigInteger);
            zzhwpVarZzc.zzc(zzhnmVar.zze());
            zzhwq zzhwqVarZzd = zzhwpVarZzc.zzd();
            zzhwn zzhwnVarZzc = zzhwo.zzc();
            zzhwnVarZzc.zza(zzhwqVarZzd);
            zzhwnVarZzc.zzb(zzj(zzhtuVarZzj.zzd(), zzhelVar), zzj(zzhtuVarZzj.zze(), zzhelVar));
            zzhwnVarZzc.zzc(zzj(zzhtuVarZzj.zzc(), zzhelVar));
            zzhwnVarZzc.zzd(zzj(zzhtuVarZzj.zzg(), zzhelVar), zzj(zzhtuVarZzj.zzh(), zzhelVar));
            zzhwnVarZzc.zze(zzj(zzhtuVarZzj.zzi(), zzhelVar));
            return zzhwnVarZzc.zzf();
        } catch (zziet | IllegalArgumentException unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing RsaSsaPkcs1PrivateKey failed");
            return null;
        }
    }

    private static zzhts zzh(zzhwm zzhwmVar) {
        zzhtr zzhtrVarZzb = zzhts.zzb();
        zzhtrVarZzb.zza((zzhsh) zzk.zzb(zzhwmVar.zzf()));
        return (zzhts) zzhtrVarZzb.zzbm();
    }

    private static zzhtw zzi(zzhwq zzhwqVar) {
        zzhtv zzhtvVarZzg = zzhtw.zzg();
        zzhtvVarZzg.zza(zzh(zzhwqVar.zzf()));
        byte[] bArrZza = zzhku.zza(zzhwqVar.zzd());
        zzida zzidaVar = zzida.zza;
        zzhtvVarZzg.zzb(zzida.zzt(bArrZza, 0, bArrZza.length));
        byte[] bArrZza2 = zzhku.zza(zzhwqVar.zzf().zzd());
        zzhtvVarZzg.zzc(zzida.zzt(bArrZza2, 0, bArrZza2.length));
        return (zzhtw) zzhtvVarZzg.zzbm();
    }

    private static zziba zzj(zzida zzidaVar, zzhel zzhelVar) {
        return zziba.zza(new BigInteger(1, zzidaVar.zzA()), zzhelVar);
    }
}
