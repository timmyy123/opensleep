package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhyu {
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
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey");
        zzb = zziazVarZza;
        zziaz zziazVarZza2 = zzhnz.zza("type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey");
        zzc = zziazVarZza2;
        zzd = zzhmy.zzd(zzhyt.zza, zzhwy.class, zzhnn.class);
        zze = zzhmv.zzd(zzhyo.zza, zziazVarZza, zzhnn.class);
        zzf = zzhlu.zzd(zzhyp.zza, zzhxc.class, zzhnm.class);
        zzg = zzhlr.zzd(zzhyq.zza, zziazVarZza2, zzhnm.class);
        zzh = zzhlu.zzd(zzhyr.zza, zzhxa.class, zzhnm.class);
        zzi = zzhlr.zzd(zzhys.zza, zziazVarZza, zzhnm.class);
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zzhtm.RAW, zzhwx.zzd);
        zzhlhVarZza.zza(zzhtm.TINK, zzhwx.zza);
        zzhlhVarZza.zza(zzhtm.CRUNCHY, zzhwx.zzb);
        zzhlhVarZza.zza(zzhtm.LEGACY, zzhwx.zzc);
        zzj = zzhlhVarZza.zzb();
        zzhlh zzhlhVarZza2 = zzhli.zza();
        zzhlhVarZza2.zza(zzhsh.SHA256, zzhww.zza);
        zzhlhVarZza2.zza(zzhsh.SHA384, zzhww.zzb);
        zzhlhVarZza2.zza(zzhsh.SHA512, zzhww.zzc);
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

    public static /* synthetic */ zzhnn zzb(zzhwy zzhwyVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey");
        zzhtx zzhtxVarZze = zzhty.zze();
        zzhtxVarZze.zza(zzh(zzhwyVar));
        zzhtxVarZze.zzb(zzhwyVar.zzc());
        byte[] bArrZza = zzhku.zza(zzhwyVar.zzd());
        zzida zzidaVar = zzida.zza;
        zzhtxVarZze.zzc(zzida.zzt(bArrZza, 0, bArrZza.length));
        zzhssVarZze.zzb(((zzhty) zzhtxVarZze.zzbm()).zzaM());
        zzhssVarZze.zzc((zzhtm) zzj.zzb(zzhwyVar.zze()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbm());
    }

    public static /* synthetic */ zzhwy zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to RsaSsaPssProtoSerialization.parseParameters: ".concat(String.valueOf(zzhnnVar.zzc().zza())));
            return null;
        }
        try {
            zzhty zzhtyVarZzd = zzhty.zzd(zzhnnVar.zzc().zzb(), zzido.zza());
            zzhwv zzhwvVarZzb = zzhwy.zzb();
            zzhli zzhliVar = zzk;
            zzhwvVarZzb.zzd((zzhww) zzhliVar.zzc(zzhtyVarZzd.zza().zza()));
            zzhwvVarZzb.zze((zzhww) zzhliVar.zzc(zzhtyVarZzd.zza().zzb()));
            zzhwvVarZzb.zzb(new BigInteger(1, zzhtyVarZzd.zzc().zzA()));
            zzhwvVarZzb.zza(zzhtyVarZzd.zzb());
            zzhwvVarZzb.zzf(zzhtyVarZzd.zza().zzc());
            zzhwvVarZzb.zzc((zzhwx) zzj.zzc(zzhnnVar.zzc().zzc()));
            return zzhwvVarZzb.zzg();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing RsaSsaPssParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhxc zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to RsaSsaPssProtoSerialization.parsePublicKey: ".concat(String.valueOf(zzhnmVar.zzg())));
            return null;
        }
        try {
            zzhue zzhueVarZze = zzhue.zze(zzhnmVar.zzb(), zzido.zza());
            if (zzhueVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhueVarZze.zzc().zzA());
            int iBitLength = bigInteger.bitLength();
            zzhwv zzhwvVarZzb = zzhwy.zzb();
            zzhli zzhliVar = zzk;
            zzhwvVarZzb.zzd((zzhww) zzhliVar.zzc(zzhueVarZze.zzb().zza()));
            zzhwvVarZzb.zze((zzhww) zzhliVar.zzc(zzhueVarZze.zzb().zzb()));
            zzhwvVarZzb.zzb(new BigInteger(1, zzhueVarZze.zzd().zzA()));
            zzhwvVarZzb.zza(iBitLength);
            zzhwvVarZzb.zzf(zzhueVarZze.zzb().zzc());
            zzhwvVarZzb.zzc((zzhwx) zzj.zzc(zzhnmVar.zzd()));
            zzhwy zzhwyVarZzg = zzhwvVarZzb.zzg();
            zzhxb zzhxbVarZzc = zzhxc.zzc();
            zzhxbVarZzc.zza(zzhwyVarZzg);
            zzhxbVarZzc.zzb(bigInteger);
            zzhxbVarZzc.zzc(zzhnmVar.zze());
            return zzhxbVarZzc.zzd();
        } catch (zziet | IllegalArgumentException unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing RsaSsaPssPublicKey failed");
            return null;
        }
    }

    public static /* synthetic */ zzhnm zzf(zzhxa zzhxaVar, zzhel zzhelVar) {
        zzhub zzhubVarZzk = zzhuc.zzk();
        zzhubVarZzk.zza(0);
        zzhubVarZzk.zzb(zzi(zzhxaVar.zze()));
        byte[] bArrZza = zzhku.zza(zzhxaVar.zzi().zzb(zzhelVar));
        zzida zzidaVar = zzida.zza;
        zzhubVarZzk.zzc(zzida.zzt(bArrZza, 0, bArrZza.length));
        byte[] bArrZza2 = zzhku.zza(zzhxaVar.zzf().zzb(zzhelVar));
        zzhubVarZzk.zzd(zzida.zzt(bArrZza2, 0, bArrZza2.length));
        byte[] bArrZza3 = zzhku.zza(zzhxaVar.zzh().zzb(zzhelVar));
        zzhubVarZzk.zze(zzida.zzt(bArrZza3, 0, bArrZza3.length));
        byte[] bArrZza4 = zzhku.zza(zzhxaVar.zzj().zzb(zzhelVar));
        zzhubVarZzk.zzf(zzida.zzt(bArrZza4, 0, bArrZza4.length));
        byte[] bArrZza5 = zzhku.zza(zzhxaVar.zzk().zzb(zzhelVar));
        zzhubVarZzk.zzg(zzida.zzt(bArrZza5, 0, bArrZza5.length));
        byte[] bArrZza6 = zzhku.zza(zzhxaVar.zzl().zzb(zzhelVar));
        zzhubVarZzk.zzh(zzida.zzt(bArrZza6, 0, bArrZza6.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey", ((zzhuc) zzhubVarZzk.zzbm()).zzaM(), zzhsp.ASYMMETRIC_PRIVATE, (zzhtm) zzj.zzb(zzhxaVar.zzd().zze()), zzhxaVar.zze().zzb());
    }

    public static /* synthetic */ zzhxa zzg(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong type URL in call to RsaSsaPssProtoSerialization.parsePrivateKey: ".concat(String.valueOf(zzhnmVar.zzg())));
            return null;
        }
        try {
            zzhuc zzhucVarZzj = zzhuc.zzj(zzhnmVar.zzb(), zzido.zza());
            if (zzhucVarZzj.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhue zzhueVarZzb = zzhucVarZzj.zzb();
            if (zzhueVarZzb.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhueVarZzb.zzc().zzA());
            int iBitLength = bigInteger.bitLength();
            BigInteger bigInteger2 = new BigInteger(1, zzhueVarZzb.zzd().zzA());
            zzhwv zzhwvVarZzb = zzhwy.zzb();
            zzhli zzhliVar = zzk;
            zzhwvVarZzb.zzd((zzhww) zzhliVar.zzc(zzhueVarZzb.zzb().zza()));
            zzhwvVarZzb.zze((zzhww) zzhliVar.zzc(zzhueVarZzb.zzb().zzb()));
            zzhwvVarZzb.zzb(bigInteger2);
            zzhwvVarZzb.zza(iBitLength);
            zzhwvVarZzb.zzf(zzhueVarZzb.zzb().zzc());
            zzhwvVarZzb.zzc((zzhwx) zzj.zzc(zzhnmVar.zzd()));
            zzhwy zzhwyVarZzg = zzhwvVarZzb.zzg();
            zzhxb zzhxbVarZzc = zzhxc.zzc();
            zzhxbVarZzc.zza(zzhwyVarZzg);
            zzhxbVarZzc.zzb(bigInteger);
            zzhxbVarZzc.zzc(zzhnmVar.zze());
            zzhxc zzhxcVarZzd = zzhxbVarZzc.zzd();
            zzhwz zzhwzVarZzc = zzhxa.zzc();
            zzhwzVarZzc.zza(zzhxcVarZzd);
            zzhwzVarZzc.zzb(zzj(zzhucVarZzj.zzd(), zzhelVar), zzj(zzhucVarZzj.zze(), zzhelVar));
            zzhwzVarZzc.zzc(zzj(zzhucVarZzj.zzc(), zzhelVar));
            zzhwzVarZzc.zzd(zzj(zzhucVarZzj.zzg(), zzhelVar), zzj(zzhucVarZzj.zzh(), zzhelVar));
            zzhwzVarZzc.zze(zzj(zzhucVarZzj.zzi(), zzhelVar));
            return zzhwzVarZzc.zzf();
        } catch (zziet | IllegalArgumentException unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Parsing RsaSsaPssPrivateKey failed");
            return null;
        }
    }

    private static zzhua zzh(zzhwy zzhwyVar) {
        zzhtz zzhtzVarZzd = zzhua.zzd();
        zzhli zzhliVar = zzk;
        zzhtzVarZzd.zza((zzhsh) zzhliVar.zzb(zzhwyVar.zzf()));
        zzhtzVarZzd.zzb((zzhsh) zzhliVar.zzb(zzhwyVar.zzg()));
        zzhtzVarZzd.zzc(zzhwyVar.zzh());
        return (zzhua) zzhtzVarZzd.zzbm();
    }

    private static zzhue zzi(zzhxc zzhxcVar) {
        zzhud zzhudVarZzg = zzhue.zzg();
        zzhudVarZzg.zzb(zzh(zzhxcVar.zzf()));
        byte[] bArrZza = zzhku.zza(zzhxcVar.zzd());
        zzida zzidaVar = zzida.zza;
        zzhudVarZzg.zzc(zzida.zzt(bArrZza, 0, bArrZza.length));
        byte[] bArrZza2 = zzhku.zza(zzhxcVar.zzf().zzd());
        zzhudVarZzg.zzd(zzida.zzt(bArrZza2, 0, bArrZza2.length));
        zzhudVarZzg.zza(0);
        return (zzhue) zzhudVarZzg.zzbm();
    }

    private static zziba zzj(zzida zzidaVar, zzhel zzhelVar) {
        return zziba.zza(new BigInteger(1, zzidaVar.zzA()), zzhelVar);
    }
}
