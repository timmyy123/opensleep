package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
final class zzahx implements zzahq {
    public final zzgwm zza;
    private final int zzb;

    private zzahx(int i, zzgwm zzgwmVar) {
        this.zzb = i;
        this.zza = zzgwmVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzahx zzb(int i, zzet zzetVar) {
        zzahq zzahyVar;
        String str;
        zzgwj zzgwjVar = new zzgwj();
        int iZze = zzetVar.zze();
        int iZzc = -2;
        while (zzetVar.zzd() > 8) {
            int iZzC = zzetVar.zzC();
            int iZzg = zzetVar.zzg() + zzetVar.zzC();
            zzetVar.zzf(iZzg);
            if (iZzC != 1414744396) {
                zzahy zzahyVar2 = null;
                switch (iZzC) {
                    case 1718776947:
                        if (iZzc != 2) {
                            if (iZzc == 1) {
                                int iZzu = zzetVar.zzu();
                                String str2 = iZzu != 1 ? iZzu != 85 ? iZzu != 255 ? iZzu != 8192 ? iZzu != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int iZzu2 = zzetVar.zzu();
                                    int iZzC2 = zzetVar.zzC();
                                    zzetVar.zzk(6);
                                    int iZzB = zzfl.zzB(zzetVar.zzu(), ByteOrder.LITTLE_ENDIAN);
                                    int iZzu3 = zzetVar.zzd() > 0 ? zzetVar.zzu() : 0;
                                    zzt zztVar = new zzt();
                                    zztVar.zzo(str2);
                                    zztVar.zzG(iZzu2);
                                    zztVar.zzH(iZzC2);
                                    if (str2.equals("audio/raw") && iZzB != 0) {
                                        zztVar.zzI(iZzB);
                                    }
                                    if (str2.equals("audio/mp4a-latm") && iZzu3 > 0) {
                                        byte[] bArr = new byte[iZzu3];
                                        zzetVar.zzm(bArr, 0, iZzu3);
                                        zztVar.zzr(zzgwm.zzj(bArr));
                                    }
                                    zzahyVar = new zzahy(zztVar.zzO());
                                } else {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzu).length() + 43), "Ignoring track with unsupported format tag ", iZzu, "StreamFormatChunk");
                                }
                            } else {
                                zzeg.zzc("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzfl.zzS(iZzc)));
                            }
                            break;
                        } else {
                            zzetVar.zzk(4);
                            int iZzC3 = zzetVar.zzC();
                            int iZzC4 = zzetVar.zzC();
                            zzetVar.zzk(4);
                            int iZzC5 = zzetVar.zzC();
                            switch (iZzC5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str == null) {
                                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzC5).length() + 44), "Ignoring track with unsupported compression ", iZzC5, "StreamFormatChunk");
                            } else {
                                zzt zztVar2 = new zzt();
                                zztVar2.zzv(iZzC3);
                                zztVar2.zzw(iZzC4);
                                zztVar2.zzo(str);
                                zzahyVar2 = new zzahy(zztVar2.zzO());
                            }
                        }
                        zzahyVar = zzahyVar2;
                        break;
                    case 1751742049:
                        zzahyVar = zzahu.zzb(zzetVar);
                        break;
                    case 1752331379:
                        zzahyVar = zzahv.zzb(zzetVar);
                        break;
                    case 1852994675:
                        zzahyVar = zzahz.zzb(zzetVar);
                        break;
                    default:
                        zzahyVar = zzahyVar2;
                        break;
                }
            } else {
                zzahyVar = zzb(zzetVar.zzC(), zzetVar);
            }
            if (zzahyVar != null) {
                if (zzahyVar.zza() == 1752331379) {
                    iZzc = ((zzahv) zzahyVar).zzc();
                }
                zzgwjVar.zzf(zzahyVar);
            }
            zzetVar.zzh(iZzg);
            zzetVar.zzf(iZze);
        }
        return new zzahx(i, zzgwjVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final int zza() {
        return this.zzb;
    }

    public final zzahq zzc(Class cls) {
        zzgwm zzgwmVar = this.zza;
        int size = zzgwmVar.size();
        int i = 0;
        while (i < size) {
            zzahq zzahqVar = (zzahq) zzgwmVar.get(i);
            i++;
            if (zzahqVar.getClass() == cls) {
                return zzahqVar;
            }
        }
        return null;
    }
}
