package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzavn implements zzawe {
    public static final /* synthetic */ zzavn zza;
    public static final /* synthetic */ zzavn zzb;
    public static final /* synthetic */ zzavn zzc;
    public static final /* synthetic */ zzavn zzd;
    public static final /* synthetic */ zzavn zze;
    public static final /* synthetic */ zzavn zzf;
    public static final /* synthetic */ zzavn zzg;
    public static final /* synthetic */ zzavn zzh;
    public static final /* synthetic */ zzavn zzi;
    public static final /* synthetic */ zzavn zzj;
    public static final /* synthetic */ zzavn zzk;
    public static final /* synthetic */ zzavn zzl;
    public static final /* synthetic */ zzavn zzm;
    public static final /* synthetic */ zzavn zzn;
    public static final /* synthetic */ zzavn zzo;
    public static final /* synthetic */ zzavn zzp;
    private final /* synthetic */ int zzq;

    static {
        int i = (((((~358984857) & 11257432) | 369424399) + ((358984857 & 615188052) | 873771151)) - 1245366369) ^ (1985433483 % 395279207);
        int i2 = (((((~1402492972) & 1009329808) | 1643537068) + ((1402492972 & 503911450) | 580170602)) - (-2136216298)) ^ (1489001354 % 953691761);
        int i3 = (((((~1389079342) & 405954790) | 5768193) + ((1389079342 & 967468022) | 1640566552)) - 1618010502) ^ (1588695568 % 1155465115);
        int i4 = (((((~1666231349) & 289538432) | 621649449) + ((1666231349 & 406985104) | 264059443)) - 1093855303) ^ (1698487330 % 272312086);
        int i5 = (((((~1953161956) & 2021553924) | 1308628610) + ((1953161956 & 813590916) | 134225131)) - 2074905685) ^ (1172063133 % 990526343);
        int i6 = (((((~1889804310) & 69748745) | 707083896) + ((1889804310 & 604795185) | 951435262)) - 1284100923) ^ (1663080928 % 610506582);
        int i7 = (((((~279121308) & 136482862) | 293951273) + ((279121308 & 1302561302) | 1440046744)) - 1857458389) ^ (1404515797 % 695748720);
        int i8 = (((((~1460082195) & 849562858) | 543970048) + ((1460082195 & 381881578) | 1279262981)) - 1872584419) ^ (1122336503 % 861109485);
        int i9 = (((((~70788355) & 1377181904) | 713084892) + ((70788355 & 1410740224) | 99160279)) - 1955016785) ^ (1156541312 % 318561886);
        int i10 = (((((~12895151) & 1277237303) | 185162640) + ((12895151 & 1411547303) | 306429832)) - 1475739783) ^ (1498617647 % 669908538);
        int i11 = (((((~1566288819) & 1018167620) | 793479703) + ((1566288819 & 284165456) | 1648575546)) - (-1895196318)) ^ (846942590 % 524688209);
        int i12 = (((((~1540846267) & 571107379) | 1484708373) + ((1540846267 & 709108258) | 1568035525)) - (-834164565)) ^ (2037335344 % 1874960596);
        zzp = new zzavn((((((~1245644428) & 268473430) | 2019232319) + ((1245644428 & 2266696) | 1693582250)) - (-827594116)) ^ (1308581515 % 354367395));
        zzo = new zzavn((((((~464837581) & 1181588952) | 603091067) + ((464837581 & 1544523140) | 967967255)) - (-2124025763)) ^ (1295815494 % 753959819));
        zzn = new zzavn(i12);
        zzm = new zzavn(i3);
        zzl = new zzavn(i4);
        zzk = new zzavn(i5);
        zzj = new zzavn(i2);
        zzi = new zzavn(i6);
        zzh = new zzavn(i7);
        zzg = new zzavn(i8);
        zzf = new zzavn(i);
        zze = new zzavn(i9);
        zzd = new zzavn(i10);
        zzc = new zzavn(i11);
        zzb = new zzavn(1);
        zza = new zzavn(0);
    }

    private /* synthetic */ zzavn(int i) {
        this.zzq = i;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzauw zzauwVar;
        zzawm zzawmVarZzc;
        int i = ((((~603123090) & 1079339320) | 204100681) + ((603123090 & 1131784560) | 52466888)) - 1316176740;
        int i2 = 1216803069 % 33252481;
        try {
            try {
                try {
                    try {
                        try {
                            switch (this.zzq) {
                                case 0:
                                    return ((zzawh) obj).zza();
                                case 1:
                                    try {
                                        zzawd zzawdVar = ((zzawh) obj).zzb;
                                        long jZzm = zzawdVar.zzc().zzm();
                                        zzawm zzawmVarZzc2 = zzawdVar.zzc();
                                        List listZzo = zzawmVarZzc2.zzo();
                                        if (jZzm < 0) {
                                            jZzm += (long) listZzo.size();
                                        }
                                        if (jZzm < 0 || jZzm >= listZzo.size()) {
                                            throw new zzawk();
                                        }
                                        listZzo.remove((int) jZzm);
                                        zzawdVar.zzb(zzawmVarZzc2);
                                        return Optional.empty();
                                    } catch (zzawk unused) {
                                        zzauwVar = zzauw.zzI;
                                    }
                                    break;
                                case 2:
                                    zzawh zzawhVar = (zzawh) obj;
                                    zzawd zzawdVar2 = zzawhVar.zzb;
                                    zzawm zzawmVarZzc3 = zzawdVar2.zzc();
                                    zzavq zzavqVarZzn = zzawdVar2.zzc().zzn();
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    zzawmVarZzc3.zzk(byteArrayOutputStream);
                                    zzawhVar.zzb.zzb(zzawm.zzd(zzavqVarZzn.zzd(zzavq.zze(byteArrayOutputStream.toByteArray()))));
                                    return Optional.empty();
                                case 3:
                                    zzawh zzawhVar2 = (zzawh) obj;
                                    zzawd zzawdVar3 = zzawhVar2.zzb;
                                    zzawm zzawmVarZzc4 = zzawdVar3.zzc();
                                    zzavq zzavqVarZzn2 = zzawdVar3.zzc().zzn();
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    zzavm.zzb(zzawmVarZzc4.zzm(), new zzawl(byteArrayOutputStream2, i ^ i2), false);
                                    zzawhVar2.zzb.zzb(zzawm.zzd(zzavqVarZzn2.zzd(zzavq.zze(byteArrayOutputStream2.toByteArray()))));
                                    return Optional.empty();
                                case 4:
                                    zzawh zzawhVar3 = (zzawh) obj;
                                    zzawhVar3.zzb.zze(-(zzawhVar3.zzc.zzb().zzb + zzawhVar3.zzd.zze()), zzawhVar3.zzb.zzc());
                                    return Optional.empty();
                                case 5:
                                    zzawd zzawdVar4 = ((zzawh) obj).zzb;
                                    zzawdVar4.zzb(zzawm.zzb(zzawdVar4.zzc().zzm() << ((int) zzawdVar4.zzc().zzm())));
                                    return Optional.empty();
                                case 6:
                                    zzawd zzawdVar5 = ((zzawh) obj).zzb;
                                    zzawdVar5.zzb(zzawm.zzb(zzawdVar5.zzc().zzm() >>> ((int) zzawdVar5.zzc().zzm())));
                                    return Optional.empty();
                                case 7:
                                    zzawd zzawdVar6 = ((zzawh) obj).zzb;
                                    zzawdVar6.zzb(zzawm.zzc(zzawdVar6.zzc().zzq() - zzawdVar6.zzc().zzq()));
                                    return Optional.empty();
                                case 8:
                                    zzawd zzawdVar7 = ((zzawh) obj).zzb;
                                    zzawdVar7.zzb(zzawm.zzb(zzawdVar7.zzc().zzm() - zzawdVar7.zzc().zzm()));
                                    return Optional.empty();
                                case 9:
                                    zzawh zzawhVar4 = (zzawh) obj;
                                    zzawd zzawdVar8 = zzawhVar4.zzb;
                                    long jZzm2 = zzawdVar8.zzc().zzm();
                                    zzawm zzawmVarZzc5 = zzawdVar8.zzc();
                                    zzawd zzawdVar9 = zzawhVar4.zzb;
                                    zzawm zzawmVarZzd = zzawdVar9.zzd(jZzm2);
                                    zzawdVar9.zze(jZzm2, zzawmVarZzc5);
                                    zzawdVar9.zzb(zzawmVarZzd);
                                    return Optional.empty();
                                case 10:
                                    zzawh zzawhVar5 = (zzawh) obj;
                                    zzawd zzawdVar10 = zzawhVar5.zzb;
                                    long jZzm3 = zzawhVar5.zzc.zzb().zzb + zzawdVar10.zzc().zzm();
                                    zzawm zzawmVarZzc6 = zzawdVar10.zzc();
                                    zzawd zzawdVar11 = zzawhVar5.zzb;
                                    long j = -jZzm3;
                                    zzawm zzawmVarZzd2 = zzawdVar11.zzd(j);
                                    zzawdVar11.zze(j, zzawmVarZzc6);
                                    zzawdVar11.zzb(zzawmVarZzd2);
                                    return Optional.empty();
                                case 11:
                                    zzawh zzawhVar6 = (zzawh) obj;
                                    long jZze = zzawhVar6.zzc.zzb().zzb + zzawhVar6.zzd.zze();
                                    zzawm zzawmVarZzc7 = zzawhVar6.zzb.zzc();
                                    zzawd zzawdVar12 = zzawhVar6.zzb;
                                    long j2 = -jZze;
                                    zzawm zzawmVarZzd3 = zzawdVar12.zzd(j2);
                                    zzawdVar12.zze(j2, zzawmVarZzc7);
                                    zzawdVar12.zzb(zzawmVarZzd3);
                                    return Optional.empty();
                                case 12:
                                    zzawh zzawhVar7 = (zzawh) obj;
                                    long jZzm4 = zzawhVar7.zzb.zzc().zzm();
                                    try {
                                        zzawd zzawdVar13 = zzawhVar7.zzb;
                                        int i3 = ((((~1349029729) & 1683806466) | 298308136) + ((1349029729 & (-199751405)) | (-1830723495))) - 438321650;
                                        int i4 = 1478326644 % 593443203;
                                        if (jZzm4 == 0) {
                                            zzawmVarZzc = zzawdVar13.zzc();
                                        } else {
                                            int iZza = zzawdVar13.zza(jZzm4);
                                            zzawdVar13.zzb += i3 ^ i4;
                                            zzawmVarZzc = (zzawm) zzawdVar13.zza.remove(iZza);
                                        }
                                        zzawdVar13.zzb(zzawmVarZzc);
                                        return Optional.empty();
                                    } catch (zzawb unused2) {
                                        zzauwVar = zzauw.zzg;
                                    }
                                    break;
                                case 13:
                                    zzawh zzawhVar8 = (zzawh) obj;
                                    try {
                                        zzawd zzawdVar14 = zzawhVar8.zzb;
                                        long jZzm5 = zzawdVar14.zzc().zzm();
                                        long jZzm6 = zzawdVar14.zzc().zzm();
                                        zzawa zzawaVar = zzawhVar8.zzc;
                                        zzavv zzavvVar = zzawhVar8.zzd;
                                        zzawaVar.zza(zzavvVar.zzb(), jZzm6, zzawaVar.zzb().zzb);
                                        zzavvVar.zza(jZzm5);
                                        return Optional.empty();
                                    } catch (zzavt | zzavu unused3) {
                                        zzauwVar = zzauw.zzr;
                                    } catch (zzavy unused4) {
                                        zzauwVar = zzauw.zzB;
                                    } catch (zzavz unused5) {
                                        zzauwVar = zzauw.zzw;
                                    }
                                    break;
                                case 14:
                                    zzawh zzawhVar9 = (zzawh) obj;
                                    try {
                                        zzawhVar9.zzb.zzb(zzawm.zzg(zzawhVar9.zzb.zzc().zzl()));
                                        return Optional.empty();
                                    } catch (zzawj unused6) {
                                        zzauwVar = zzauw.zzp;
                                    }
                                    break;
                                default:
                                    try {
                                        zzawd zzawdVar15 = ((zzawh) obj).zzb;
                                        Iterator it = zzawdVar15.zzc().zzo().iterator();
                                        while (it.hasNext()) {
                                            zzawdVar15.zzb((zzawm) it.next());
                                            break;
                                        }
                                        return Optional.empty();
                                    } catch (zzawc unused7) {
                                        zzauwVar = zzauw.zza;
                                    }
                                    break;
                            }
                        } catch (zzawc e) {
                            e = e;
                            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
                        }
                    } catch (zzawb unused8) {
                        zzauwVar = zzauw.zzh;
                    }
                } catch (zzavs | zzavu | zzawj unused9) {
                    zzauwVar = zzauw.zzy;
                }
            } catch (zzavz | zzawb unused10) {
                zzauwVar = zzauw.zzx;
            }
        } catch (zzawj unused11) {
            zzauwVar = zzauw.zzk;
        } catch (IOException e2) {
            e = e2;
            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
        }
        return Optional.of(zzauwVar);
    }
}
