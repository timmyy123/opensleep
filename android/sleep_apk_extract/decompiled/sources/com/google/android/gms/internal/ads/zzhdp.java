package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhdp implements zzhed {
    private static final Charset zza = Charset.forName(OAuth.ENCODING);
    private final InputStream zzb;

    private zzhdp(InputStream inputStream) {
        this.zzb = inputStream;
    }

    public static zzhdp zza(String str) {
        return new zzhdp(new ByteArrayInputStream(str.getBytes(zza)));
    }

    private static int zzc(zzibg zzibgVar) throws IOException {
        if (!(zzibgVar instanceof zzibk)) {
            OggIO$$ExternalSyntheticBUOutline0.m("invalid key id: not a JSON primitive");
            return 0;
        }
        if (!zzibgVar.zzg().zzc()) {
            OggIO$$ExternalSyntheticBUOutline0.m("invalid key id: not a JSON number");
            return 0;
        }
        try {
            long jZzc = zzhlm.zzc(zzibgVar.zzg().zzh());
            if (jZzc <= 4294967295L && jZzc >= -2147483648L) {
                return (int) jZzc;
            }
            OggIO$$ExternalSyntheticBUOutline0.m("invalid key id");
            return 0;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01dc A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0144 A[Catch: all -> 0x0033, IllegalStateException -> 0x0036, zzibj -> 0x0039, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:13:0x003c, B:15:0x0053, B:17:0x005b, B:19:0x0065, B:21:0x006f, B:23:0x007b, B:25:0x0081, B:27:0x008f, B:29:0x0095, B:31:0x009b, B:33:0x00a1, B:35:0x00a9, B:51:0x00eb, B:56:0x0114, B:69:0x0137, B:71:0x0144, B:73:0x014a, B:75:0x0150, B:80:0x0191, B:93:0x01b4, B:84:0x019c, B:88:0x01a7, B:92:0x01b2, B:94:0x01d2, B:95:0x01db, B:96:0x01dc, B:97:0x01e3, B:60:0x011f, B:64:0x012a, B:68:0x0135, B:98:0x01e4, B:99:0x01ed, B:100:0x01ee, B:101:0x01f7, B:102:0x01f8, B:103:0x01ff, B:104:0x0200, B:105:0x0207, B:106:0x0208, B:109:0x0214, B:110:0x021b, B:111:0x021c, B:112:0x0223, B:113:0x0224, B:114:0x022b, B:115:0x022c, B:116:0x0231), top: B:119:0x0014 }] */
    @Override // com.google.android.gms.internal.ads.zzhed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzhsz zzb() throws IOException {
        int i;
        String strZzd;
        zzhtm zzhtmVar;
        zzibi zzibiVarZze;
        zzhsp zzhspVar;
        String str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
        String str2 = "keyData";
        try {
            try {
                InputStream inputStream = this.zzb;
                int i2 = zzheo.$r8$clinit;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i3 = inputStream.read(bArr);
                    InputStream inputStream2 = inputStream;
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                    inputStream = inputStream2;
                }
                zzibi zzibiVarZze2 = zzhlm.zzb(new String(byteArrayOutputStream.toByteArray(), zza)).zze();
                if (!zzibiVarZze2.zzc(SDKConstants.PARAM_KEY)) {
                    throw new zzibj("invalid keyset: no key");
                }
                zzibg zzibgVarZzh = zzibiVarZze2.zzh(SDKConstants.PARAM_KEY);
                if (!(zzibgVarZzh instanceof zzibf)) {
                    throw new zzibj("invalid keyset: key must be an array");
                }
                zzibf zzibfVarZzf = zzibgVarZzh.zzf();
                if (zzibfVarZzf.zzb() == 0) {
                    throw new zzibj("invalid keyset: key is empty");
                }
                zzhsw zzhswVarZzh = zzhsz.zzh();
                if (zzibiVarZze2.zzc("primaryKeyId")) {
                    zzhswVarZzh.zza(zzc(zzibiVarZze2.zzh("primaryKeyId")));
                }
                int i4 = 0;
                while (i4 < zzibfVarZzf.zzb()) {
                    zzibi zzibiVarZze3 = zzibfVarZzf.zzc(i4).zze();
                    if (!zzibiVarZze3.zzc(str2) || !zzibiVarZze3.zzc(str) || !zzibiVarZze3.zzc("keyId") || !zzibiVarZze3.zzc("outputPrefixType")) {
                        throw new zzibj("invalid key");
                    }
                    zzibg zzibgVarZzh2 = zzibiVarZze3.zzh(str2);
                    if (!(zzibgVarZzh2 instanceof zzibi)) {
                        throw new zzibj("invalid key: keyData must be an object");
                    }
                    zzhsx zzhsxVarZze = zzhsy.zze();
                    String strZzd2 = zzibiVarZze3.zzh(str).zzd();
                    String str3 = str;
                    int iHashCode = strZzd2.hashCode();
                    String str4 = str2;
                    if (iHashCode == -891611359) {
                        if (!strZzd2.equals("ENABLED")) {
                            throw new zzibj("unknown status: ".concat(strZzd2));
                        }
                        i = 3;
                        zzhsxVarZze.zze(i);
                        zzhsxVarZze.zzc(zzc(zzibiVarZze3.zzh("keyId")));
                        strZzd = zzibiVarZze3.zzh("outputPrefixType").zzd();
                        switch (strZzd.hashCode()) {
                            case -2053249079:
                                break;
                            case 80904:
                                break;
                            case 2575090:
                                break;
                            case 1761684556:
                                break;
                        }
                        throw new zzibj("unknown output prefix type: ".concat(strZzd));
                    }
                    if (iHashCode == 478389753) {
                        if (!strZzd2.equals("DESTROYED")) {
                            throw new zzibj("unknown status: ".concat(strZzd2));
                        }
                        i = 5;
                        zzhsxVarZze.zze(i);
                        zzhsxVarZze.zzc(zzc(zzibiVarZze3.zzh("keyId")));
                        strZzd = zzibiVarZze3.zzh("outputPrefixType").zzd();
                        switch (strZzd.hashCode()) {
                            case -2053249079:
                                break;
                            case 80904:
                                break;
                            case 2575090:
                                break;
                            case 1761684556:
                                break;
                        }
                        throw new zzibj("unknown output prefix type: ".concat(strZzd));
                    }
                    if (iHashCode != 1053567612 || !strZzd2.equals("DISABLED")) {
                        throw new zzibj("unknown status: ".concat(strZzd2));
                    }
                    i = 4;
                    zzhsxVarZze.zze(i);
                    zzhsxVarZze.zzc(zzc(zzibiVarZze3.zzh("keyId")));
                    strZzd = zzibiVarZze3.zzh("outputPrefixType").zzd();
                    switch (strZzd.hashCode()) {
                        case -2053249079:
                            if (strZzd.equals("LEGACY")) {
                                zzhtmVar = zzhtm.LEGACY;
                                zzhsxVarZze.zzd(zzhtmVar);
                                zzibiVarZze = zzibgVarZzh2.zze();
                                if (zzibiVarZze.zzc("typeUrl") || !zzibiVarZze.zzc(SDKConstants.PARAM_VALUE) || !zzibiVarZze.zzc("keyMaterialType")) {
                                    throw new zzibj("invalid keyData");
                                }
                                byte[] bArrZza = zzhzk.zza(zzibiVarZze.zzh(SDKConstants.PARAM_VALUE).zzd(), 2);
                                zzhso zzhsoVarZzd = zzhsq.zzd();
                                zzhsoVarZzd.zza(zzibiVarZze.zzh("typeUrl").zzd());
                                zzida zzidaVar = zzida.zza;
                                zzhsoVarZzd.zzb(zzida.zzt(bArrZza, 0, bArrZza.length));
                                String strZzd3 = zzibiVarZze.zzh("keyMaterialType").zzd();
                                switch (strZzd3.hashCode()) {
                                    case -1881281466:
                                        if (!strZzd3.equals("REMOTE")) {
                                            throw new zzibj("unknown key material type: ".concat(strZzd3));
                                        }
                                        zzhspVar = zzhsp.REMOTE;
                                        break;
                                        break;
                                    case -1609477353:
                                        if (!strZzd3.equals("SYMMETRIC")) {
                                            throw new zzibj("unknown key material type: ".concat(strZzd3));
                                        }
                                        zzhspVar = zzhsp.SYMMETRIC;
                                        break;
                                        break;
                                    case 249237018:
                                        if (!strZzd3.equals("ASYMMETRIC_PRIVATE")) {
                                            throw new zzibj("unknown key material type: ".concat(strZzd3));
                                        }
                                        zzhspVar = zzhsp.ASYMMETRIC_PRIVATE;
                                        break;
                                        break;
                                    case 1534613202:
                                        if (!strZzd3.equals("ASYMMETRIC_PUBLIC")) {
                                            throw new zzibj("unknown key material type: ".concat(strZzd3));
                                        }
                                        zzhspVar = zzhsp.ASYMMETRIC_PUBLIC;
                                        break;
                                        break;
                                    default:
                                        throw new zzibj("unknown key material type: ".concat(strZzd3));
                                }
                                zzhsoVarZzd.zzc(zzhspVar);
                                zzhsxVarZze.zza((zzhsq) zzhsoVarZzd.zzbm());
                                zzhswVarZzh.zzb((zzhsy) zzhsxVarZze.zzbm());
                                i4++;
                                str = str3;
                                str2 = str4;
                            }
                            break;
                        case 80904:
                            if (strZzd.equals("RAW")) {
                                zzhtmVar = zzhtm.RAW;
                                zzhsxVarZze.zzd(zzhtmVar);
                                zzibiVarZze = zzibgVarZzh2.zze();
                                if (zzibiVarZze.zzc("typeUrl")) {
                                }
                                throw new zzibj("invalid keyData");
                            }
                            break;
                        case 2575090:
                            if (strZzd.equals("TINK")) {
                                zzhtmVar = zzhtm.TINK;
                                zzhsxVarZze.zzd(zzhtmVar);
                                zzibiVarZze = zzibgVarZzh2.zze();
                                if (zzibiVarZze.zzc("typeUrl")) {
                                }
                                throw new zzibj("invalid keyData");
                            }
                            break;
                        case 1761684556:
                            if (strZzd.equals("CRUNCHY")) {
                                zzhtmVar = zzhtm.CRUNCHY;
                                zzhsxVarZze.zzd(zzhtmVar);
                                zzibiVarZze = zzibgVarZzh2.zze();
                                if (zzibiVarZze.zzc("typeUrl")) {
                                }
                                throw new zzibj("invalid keyData");
                            }
                            break;
                    }
                    throw new zzibj("unknown output prefix type: ".concat(strZzd));
                }
                zzhsz zzhszVar = (zzhsz) zzhswVarZzh.zzbm();
                this.zzb.close();
                return zzhszVar;
            } catch (Throwable th) {
                this.zzb.close();
                throw th;
            }
        } catch (zzibj e) {
            e = e;
            throw new IOException(e);
        } catch (IllegalStateException e2) {
            e = e2;
            throw new IOException(e);
        }
    }
}
