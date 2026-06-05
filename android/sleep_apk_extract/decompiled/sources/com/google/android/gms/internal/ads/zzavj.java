package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzavj implements zzawe {
    public static final /* synthetic */ zzavj zza;
    public static final /* synthetic */ zzavj zzb;
    public static final /* synthetic */ zzavj zzc;
    public static final /* synthetic */ zzavj zzd;
    public static final /* synthetic */ zzavj zze;
    public static final /* synthetic */ zzavj zzf;
    public static final /* synthetic */ zzavj zzg;
    public static final /* synthetic */ zzavj zzh;
    public static final /* synthetic */ zzavj zzi;
    public static final /* synthetic */ zzavj zzj;
    public static final /* synthetic */ zzavj zzk;
    public static final /* synthetic */ zzavj zzl;
    public static final /* synthetic */ zzavj zzm;
    public static final /* synthetic */ zzavj zzn;
    public static final /* synthetic */ zzavj zzo;
    public static final /* synthetic */ zzavj zzp;
    public static final /* synthetic */ zzavj zzq;
    public static final /* synthetic */ zzavj zzr;
    public static final /* synthetic */ zzavj zzs;
    public static final /* synthetic */ zzavj zzt;
    public static final /* synthetic */ zzavj zzu;
    private final /* synthetic */ int zzv;

    static {
        int i = (((((~1272469786) & 1097507524) | 723881402) + ((1272469786 & 1078604356) | 746642480)) - (-1830851820)) ^ (1544617505 % 243268139);
        int i2 = (((((~1722060049) & 1087578905) | 70644109) + ((1722060049 & 1625428690) | 673239279)) - 1747544094) ^ (860516127 % 777720504);
        int i3 = (((((~168057522) & 567809569) | 2007585082) + ((168057522 & 1112917761) | 1200484666)) - (-1753249985)) ^ (1761250573 % 1089653714);
        int i4 = (((((~386839851) & 502322088) | 1879579687) + ((386839851 & 1341449096) | 1376723987)) - (-1804183292)) ^ (2118801173 % 1119399015);
        int i5 = (((((~627992393) & 399075139) | 1263590114) + ((627992393 & 1418280193) | 1644468862)) - (-1502362592)) ^ (1449228398 % 989241888);
        int i6 = (((((~1687776787) & 1627592001) | 771768986) + ((1687776787 & 1226806633) | 136094264)) - 1910482017) ^ (992028067 % 180785147);
        int i7 = (((((~1111088131) & 1881672142) | 1222111317) + ((1111088131 & 807995786) | 38123124)) - 1508183881) ^ (1348361729 % 788380902);
        zzu = new zzavj((((((~636453333) & 363983206) | 1075208291) + ((636453333 & 2146013964) | 1783382730)) - (-1139191409)) ^ (1564003050 % 99885196));
        zzt = new zzavj((((((~338346092) & 646267944) | 2030210865) + ((338346092 & 109431182) | 1768591350)) - (-956795148)) ^ (1912163036 % 671068506));
        zzs = new zzavj((((((~1374600938) & 269492393) | 962980710) + ((1374600938 & (-2079309685)) | (-1096234186))) - (-724963331)) ^ (1587992726 % 995234140));
        zzr = new zzavj(i7);
        zzq = new zzavj(i4);
        zzp = new zzavj(i5);
        zzavj zzavjVar = new zzavj(i6);
        int i8 = (((((~406011017) & 1269108768) | 73167649) + ((406011017 & 2074166272) | 872470299)) - 1878158194) ^ (1615935710 % 639806732);
        int i9 = (((((~257675105) & 286888065) | 1680106172) + ((257675105 & 353998857) | 216033710)) - (-2120570644)) ^ (2033505236 % 29777560);
        int i10 = (((((~2137100237) & 243279585) | 1476690352) + ((2137100237 & 1182836297) | 1215531406)) - (-1785612177)) ^ (1251300606 % 959372260);
        int i11 = (((((~1280321648) & 1509448282) | 1074834725) + ((1280321648 & 434689663) | 67544101)) - 1396684682) ^ (1309383303 % 1129033333);
        int i12 = (((((~1635905385) & 436500164) | 1627617040) + ((1635905385 & 1527677388) | 1092341018)) - (-1251599253)) ^ (1253207672 % 570073850);
        int i13 = (((((~2058657199) & 1077280871) | 426331554) + ((2058657199 & 1242960213) | 260153146)) - 1453981149) ^ (711845894 % 404158660);
        int i14 = (((((~2077486715) & 1348527492) | 196553360) + ((2077486715 & 1547749134) | 218380923)) - 1621461405) ^ (1713258270 % 1573363368);
        int i15 = (((((~1194953865) & 541827704) | 1410336387) + ((1194953865 & 676044922) | 221517442)) - 2090845028) ^ (485560280 % 402724286);
        int i16 = (((((~1424268980) & 433259076) | 136627722) + ((1424268980 & 299303110) | 33824130)) - 448747429) ^ (1129566413 % 184803526);
        zzo = zzavjVar;
        zzn = new zzavj(i3);
        zzm = new zzavj(i8);
        zzl = new zzavj(i9);
        zzk = new zzavj(i10);
        zzj = new zzavj(i2);
        zzi = new zzavj(i11);
        zzh = new zzavj(i12);
        zzg = new zzavj(i13);
        zzf = new zzavj(i);
        zze = new zzavj(i14);
        zzd = new zzavj(i15);
        zzc = new zzavj(i16);
        zzb = new zzavj(1);
        zza = new zzavj(0);
    }

    private /* synthetic */ zzavj(int i) {
        this.zzv = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e1 A[Catch: zzawc -> 0x00ee, zzavz | zzawb -> 0x00f1, ClassNotFoundException -> 0x01f1, zzawj -> 0x01f5, TryCatch #10 {zzawc -> 0x00ee, blocks: (B:5:0x0036, B:9:0x0052, B:11:0x005a, B:14:0x0064, B:16:0x006d, B:30:0x00df, B:17:0x0076, B:18:0x007b, B:19:0x007c, B:22:0x00a4, B:23:0x00a9, B:27:0x00b2, B:29:0x00ba, B:33:0x00e7, B:34:0x00ec, B:35:0x00ed, B:42:0x0100, B:43:0x0110, B:45:0x0116, B:51:0x0144, B:48:0x0125, B:49:0x012c, B:53:0x014b, B:60:0x016a, B:65:0x0188, B:98:0x01e5, B:69:0x0193, B:73:0x019e, B:80:0x01b2, B:84:0x01bd, B:88:0x01c8, B:92:0x01d3, B:96:0x01de, B:97:0x01e1, B:104:0x01fd, B:108:0x0214, B:113:0x0237, B:120:0x0265, B:125:0x0286, B:134:0x02ae, B:136:0x02c4, B:137:0x02c6, B:139:0x02cb, B:143:0x02dc, B:145:0x02f4, B:146:0x02f7, B:165:0x0419, B:191:0x04c1, B:193:0x04c9, B:197:0x04d5, B:200:0x04e5, B:198:0x04da, B:199:0x04df, B:212:0x0527, B:216:0x054a, B:220:0x0598, B:224:0x05b4, B:237:0x05fb, B:241:0x0621, B:245:0x0644), top: B:250:0x000f }] */
    @Override // java.util.function.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object apply(Object obj) {
        zzauw zzauwVar;
        Object obj2;
        zzawd zzawdVar;
        zzawm zzawmVarZza;
        zzauw zzauwVar2;
        int i = this.zzv;
        long j = 1;
        Class<?> cls = Void.TYPE;
        Object obj3 = null;
        int i2 = 0;
        try {
            try {
                try {
                    try {
                        switch (i) {
                            case 0:
                                zzawd zzawdVar2 = ((zzawh) obj).zzb;
                                zzawdVar2.zzb(zzawm.zzb(zzawdVar2.zzc().zzm() + zzawdVar2.zzc().zzm()));
                                return Optional.empty();
                            case 1:
                                zzawd zzawdVar3 = ((zzawh) obj).zzb;
                                zzawdVar3.zzb(zzawm.zzc(zzawdVar3.zzc().zzq() + zzawdVar3.zzc().zzq()));
                                return Optional.empty();
                            case 2:
                                zzawd zzawdVar4 = ((zzawh) obj).zzb;
                                zzawdVar4.zzb(zzawm.zzd(zzawdVar4.zzc().zzn().zzd(zzawdVar4.zzc().zzn())));
                                return Optional.empty();
                            case 3:
                                zzawh zzawhVar = (zzawh) obj;
                                try {
                                    long jZze = zzawhVar.zzd.zze();
                                    for (long j2 = 0; j2 < jZze; j2++) {
                                        zzawhVar.zzb.zzb(zzawm.zza(null));
                                    }
                                    return Optional.empty();
                                } catch (zzawc unused) {
                                    zzauwVar = zzauw.zza;
                                    return Optional.of(zzauwVar);
                                }
                            case 4:
                                zzawd zzawdVar5 = ((zzawh) obj).zzb;
                                zzawdVar5.zzb(zzawm.zzb(zzawdVar5.zzc().zzm() & zzawdVar5.zzc().zzm()));
                                return Optional.empty();
                            case 5:
                                long[] jArr = {916768482, 1259538933, 805446160, -15648283, -1266372608, 883303887, 6538657, 384868448, 102194872};
                                long j3 = jArr[0];
                                long j4 = jArr[1];
                                long j5 = jArr[2];
                                long j6 = jArr[3];
                                long j7 = jArr[4];
                                long j8 = jArr[5];
                                long j9 = jArr[6];
                                long j10 = jArr[7];
                                long j11 = (((((~j3) & j4) | j5) + ((j3 & j6) | j7)) - j8) + j9;
                                long j12 = j10 % 102194872;
                                zzawd zzawdVar6 = ((zzawh) obj).zzb;
                                zzawdVar6.zzb(zzawm.zzb((j11 ^ j12) ^ zzawdVar6.zzc().zzm()));
                                return Optional.empty();
                            case 6:
                                zzawd zzawdVar7 = ((zzawh) obj).zzb;
                                zzawdVar7.zzb(zzawm.zzb(zzawdVar7.zzc().zzm() | zzawdVar7.zzc().zzm()));
                                return Optional.empty();
                            case 7:
                                zzawd zzawdVar8 = ((zzawh) obj).zzb;
                                zzawdVar8.zzb(zzawm.zzb(zzawdVar8.zzc().zzm() ^ zzawdVar8.zzc().zzm()));
                                return Optional.empty();
                            case 8:
                                zzawh zzawhVar2 = (zzawh) obj;
                                try {
                                    long jZzm = zzawhVar2.zzb.zzc().zzm();
                                    zzawa zzawaVar = zzawhVar2.zzc;
                                    zzavv zzavvVar = zzawhVar2.zzd;
                                    zzawaVar.zza(zzavvVar.zzb(), 0L, r1.zzb);
                                    zzavvVar.zza(jZzm);
                                    return Optional.empty();
                                } catch (zzavt | zzavu unused2) {
                                    zzauwVar = zzauw.zzr;
                                    return Optional.of(zzauwVar);
                                } catch (zzavy unused3) {
                                    zzauwVar = zzauw.zzB;
                                    return Optional.of(zzauwVar);
                                }
                            case 9:
                                zzawh zzawhVar3 = (zzawh) obj;
                                try {
                                    zzawd zzawdVar9 = zzawhVar3.zzb;
                                    long jZzm2 = zzawdVar9.zzc().zzm();
                                    List listZzo = zzawdVar9.zzc().zzo();
                                    int size = listZzo.size();
                                    Object objZzh = zzawdVar9.zzc().zzh();
                                    Object objZzl = zzawdVar9.zzc().zzl();
                                    if (objZzl instanceof Method) {
                                        Method method = (Method) objZzl;
                                        Class<?>[] parameterTypes = method.getParameterTypes();
                                        if (parameterTypes.length == size) {
                                            Object[] objArr = new Object[size];
                                            if (objZzh instanceof Constructor) {
                                                Class<?>[] parameterTypes2 = ((Constructor) objZzh).getParameterTypes();
                                                int length = parameterTypes2.length;
                                                Object[] objArr2 = new Object[length];
                                                List listZzo2 = ((zzawm) listZzo.get(0)).zzo();
                                                if (listZzo2.size() == length) {
                                                    int i3 = 0;
                                                    while (i3 < listZzo2.size()) {
                                                        objArr2[i3] = ((zzawm) listZzo2.get(i3)).zzi(parameterTypes2[i3]);
                                                        i3++;
                                                        obj3 = obj3;
                                                    }
                                                    obj2 = obj3;
                                                    objArr[0] = objArr2;
                                                }
                                            } else {
                                                obj2 = null;
                                                while (i2 < size) {
                                                    objArr[i2] = ((zzawm) listZzo.get(i2)).zzi(parameterTypes[i2]);
                                                    i2++;
                                                }
                                            }
                                            try {
                                                Object objInvoke = method.invoke(objZzh, objArr);
                                                if (method.getReturnType() == Void.class || method.getReturnType() == cls) {
                                                    zzawdVar = zzawhVar3.zzb;
                                                    zzawmVarZza = zzawm.zza(obj2);
                                                } else {
                                                    zzawdVar = zzawhVar3.zzb;
                                                    zzawmVarZza = jZzm2 != 0 ? zzawm.zzg(objInvoke) : zzawm.zza(objInvoke);
                                                }
                                                zzawdVar.zzb(zzawmVarZza);
                                                return Optional.empty();
                                            } catch (Throwable unused4) {
                                                zzauwVar = zzauw.zzq;
                                                return Optional.of(zzauwVar);
                                            }
                                        }
                                    }
                                    return Optional.of(zzauw.zzp);
                                } catch (zzawj unused5) {
                                    zzauwVar = zzauw.zzp;
                                }
                                break;
                            case 10:
                                int i4 = ((((~2084546560) & 73475461) | 438076064) + ((2084546560 & 611428101) | 2023412224)) - (-1830321789);
                                int i5 = 1073781763 % 1003463633;
                                int i6 = ((((~461273879) & 107429921) | 378966045) + ((461273879 & 283197472) | 1937909388)) - 2133058944;
                                int i7 = 1917305981 % 575705360;
                                zzawh zzawhVar4 = (zzawh) obj;
                                zzawd zzawdVar10 = zzawhVar4.zzb;
                                int intExact = Math.toIntExact(zzawdVar10.zzc().zzm());
                                zzavq zzavqVarZzn = zzawdVar10.zzc().zzn();
                                zzavq zzavqVarZzn2 = zzawdVar10.zzc().zzn();
                                if (zzavqVarZzn.zza.length != (i4 ^ i5)) {
                                    return Optional.of(zzauw.zzH);
                                }
                                int[] iArr = new int[i6 ^ i7];
                                ByteBuffer.wrap(zzavqVarZzn.zza()).asIntBuffer().get(iArr);
                                zzavi zzaviVar = new zzavi(intExact, iArr);
                                int i8 = ((((~1183912267) & 781500673) | 1683555012) + ((1183912267 & 180666625) | 541077750)) - (-1949988574);
                                int i9 = 1527793660 % 245277883;
                                int i10 = ((((~95266356) & 568641509) | 183483904) + ((95266356 & 553669093) | 504469010)) - 874379764;
                                int i11 = 2026478004 % 1659239833;
                                byte[] bArrZza = zzavqVarZzn2.zza();
                                int i12 = (((((~1787189168) & 1360184381) | 611517270) + ((1787189168 & 1426637867) | 612056018)) - 1771476931) ^ (1821115873 % 1010014811);
                                byte[] bArr = new byte[i12];
                                int i13 = 0;
                                while (i13 < bArrZza.length) {
                                    if (i13 % i12 == 0) {
                                        zzaviVar.zza(i13 >>> (i8 ^ i9), bArr);
                                    } else if (i13 == 0) {
                                        i13 = 0;
                                        zzaviVar.zza(i13 >>> (i8 ^ i9), bArr);
                                    }
                                    int i14 = i10 ^ i11;
                                    bArrZza[i13] = (byte) (((bArrZza[i13] ^ bArr[i13 % i12]) << i14) >> i14);
                                    i13++;
                                }
                                zzawhVar4.zzb.zzb(zzawm.zzd(zzavq.zze(bArrZza)));
                                return Optional.empty();
                            case 11:
                                zzawd zzawdVar11 = ((zzawh) obj).zzb;
                                double dZzq = zzawdVar11.zzc().zzq();
                                double dZzq2 = zzawdVar11.zzc().zzq();
                                if (dZzq == 0.0d) {
                                    zzauwVar2 = zzauw.zzF;
                                    return Optional.of(zzauwVar2);
                                }
                                zzawdVar11.zzb(zzawm.zzc(dZzq2 / dZzq));
                                return Optional.empty();
                            case 12:
                                zzawd zzawdVar12 = ((zzawh) obj).zzb;
                                long jZzm3 = zzawdVar12.zzc().zzm();
                                long jZzm4 = zzawdVar12.zzc().zzm();
                                if (jZzm3 == 0) {
                                    zzauwVar2 = zzauw.zzF;
                                    return Optional.of(zzauwVar2);
                                }
                                zzawdVar12.zzb(zzawm.zzb(jZzm4 / jZzm3));
                                return Optional.empty();
                            case 13:
                                try {
                                    ((zzawh) obj).zzb.zzc();
                                    return Optional.empty();
                                } catch (zzawb unused6) {
                                    zzauwVar = zzauw.zzA;
                                    return Optional.of(zzauwVar);
                                }
                            case 14:
                                zzawh zzawhVar5 = (zzawh) obj;
                                long jZzm5 = zzawhVar5.zzb.zzc().zzm();
                                zzawd zzawdVar13 = zzawhVar5.zzb;
                                zzawdVar13.zzb(zzawm.zzj(zzawdVar13.zzd(jZzm5)));
                                return Optional.empty();
                            case 15:
                                zzawh zzawhVar6 = (zzawh) obj;
                                long jZzm6 = zzawhVar6.zzc.zzb().zzb + zzawhVar6.zzb.zzc().zzm();
                                zzawd zzawdVar14 = zzawhVar6.zzb;
                                zzawdVar14.zzb(zzawm.zzj(zzawdVar14.zzd(-jZzm6)));
                                return Optional.empty();
                            case 16:
                                zzawh zzawhVar7 = (zzawh) obj;
                                long jZze2 = zzawhVar7.zzc.zzb().zzb + zzawhVar7.zzd.zze();
                                zzawd zzawdVar15 = zzawhVar7.zzb;
                                zzawdVar15.zzb(zzawm.zzj(zzawdVar15.zzd(-jZze2)));
                                return Optional.empty();
                            case 17:
                                try {
                                    zzawd zzawdVar16 = ((zzawh) obj).zzb;
                                    if (new zzawi(true).compare(zzawdVar16.zzc(), zzawdVar16.zzc()) != 0) {
                                        j = 0;
                                    }
                                    zzawdVar16.zzb(zzawm.zzb(j));
                                    return Optional.empty();
                                } catch (IllegalArgumentException unused7) {
                                    zzauwVar = zzauw.zzd;
                                    return Optional.of(zzauwVar);
                                }
                            case 18:
                                try {
                                    zzawd zzawdVar17 = ((zzawh) obj).zzb;
                                    String strZzc = zzawdVar17.zzc().zzn().zzc();
                                    switch (strZzc.hashCode()) {
                                        case -1325958191:
                                            cls = strZzc.equals("double") ? Double.TYPE : Class.forName(strZzc);
                                            break;
                                        case 104431:
                                            if (strZzc.equals("int")) {
                                                cls = Integer.TYPE;
                                                break;
                                            }
                                            break;
                                        case 3039496:
                                            if (strZzc.equals("byte")) {
                                                cls = Byte.TYPE;
                                                break;
                                            }
                                            break;
                                        case 3052374:
                                            if (strZzc.equals("char")) {
                                                cls = Character.TYPE;
                                                break;
                                            }
                                            break;
                                        case 3327612:
                                            if (strZzc.equals("long")) {
                                                cls = Long.TYPE;
                                                break;
                                            }
                                            break;
                                        case 3625364:
                                            if (!strZzc.equals("void")) {
                                            }
                                            break;
                                        case 64711720:
                                            if (strZzc.equals("boolean")) {
                                                cls = Boolean.TYPE;
                                                break;
                                            }
                                            break;
                                        case 97526364:
                                            if (strZzc.equals("float")) {
                                                cls = Float.TYPE;
                                                break;
                                            }
                                            break;
                                        case 109413500:
                                            if (strZzc.equals("short")) {
                                                cls = Short.TYPE;
                                                break;
                                            }
                                            break;
                                    }
                                    zzawdVar17.zzb(zzawm.zza(cls));
                                    return Optional.empty();
                                } catch (zzawj unused8) {
                                    zzauwVar = zzauw.zzl;
                                    return Optional.of(zzauwVar);
                                } catch (ClassNotFoundException unused9) {
                                    zzauwVar = zzauw.zzm;
                                    return Optional.of(zzauwVar);
                                }
                            case 19:
                                try {
                                    zzawd zzawdVar18 = ((zzawh) obj).zzb;
                                    List listZzo3 = zzawdVar18.zzc().zzo();
                                    Class<?>[] clsArr = new Class[listZzo3.size()];
                                    while (true) {
                                        if (i2 < listZzo3.size()) {
                                            Object objZzl2 = ((zzawm) listZzo3.get(i2)).zzl();
                                            if (objZzl2 instanceof Class) {
                                                clsArr[i2] = (Class) objZzl2;
                                                i2++;
                                            }
                                        } else {
                                            String strZzc2 = zzawdVar18.zzc().zzn().zzc();
                                            Object objZzl3 = zzawdVar18.zzc().zzl();
                                            if (objZzl3 instanceof Class) {
                                                zzawdVar18.zzb(zzawm.zza(((Class) objZzl3).getMethod(strZzc2, clsArr)));
                                                return Optional.empty();
                                            }
                                        }
                                    }
                                    return Optional.of(zzauw.zzn);
                                } catch (zzawj unused10) {
                                    zzauwVar = zzauw.zzn;
                                    return Optional.of(zzauwVar);
                                } catch (NoSuchMethodException unused11) {
                                    zzauwVar = zzauw.zzo;
                                    return Optional.of(zzauwVar);
                                } catch (SecurityException unused12) {
                                    zzauwVar = zzauw.zzC;
                                    return Optional.of(zzauwVar);
                                }
                            default:
                                int i15 = ((((~306851320) & 2040670728) | 1372152390) + ((306851320 & (-1473639347)) | (-2036492681))) - 244167092;
                                int i16 = 1764892438 % 764851988;
                                zzawd zzawdVar19 = ((zzawh) obj).zzb;
                                long jZzm7 = zzawdVar19.zzc().zzm();
                                zzawm zzawmVarZzc = zzawdVar19.zzc();
                                zzawm zzawmVarZzc2 = zzawdVar19.zzc();
                                int i17 = zzawmVarZzc2.zza;
                                int i18 = (i15 ^ i16) + i17;
                                if (i17 == 0) {
                                    throw null;
                                }
                                if (i18 == 3) {
                                    zzavq zzavqVarZzn3 = zzawmVarZzc2.zzn();
                                    int i19 = ((((~284327308) & 44384696) | 1708231444) + ((284327308 & 1647591593) | 1951966997)) - (-1088446899);
                                    int i20 = 2085308422 % 531900034;
                                    if (jZzm7 < 0) {
                                        jZzm7 += (long) zzavqVarZzn3.zza.length;
                                    }
                                    if (zzawmVarZzc.zza != (i19 ^ i20)) {
                                        throw new zzawj();
                                    }
                                    if (jZzm7 >= 0 && jZzm7 < zzavqVarZzn3.zza.length) {
                                        char cCharAt = zzavqVarZzn3.zzc().charAt((int) jZzm7);
                                        StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length());
                                        sb.append(cCharAt);
                                        zzawmVarZzc = zzawm.zzd(zzavq.zzf(sb.toString()));
                                    }
                                } else {
                                    if (i18 != 4) {
                                        throw new zzawj();
                                    }
                                    List listZzo4 = zzawmVarZzc2.zzo();
                                    if (jZzm7 < 0) {
                                        jZzm7 += (long) listZzo4.size();
                                    }
                                    if (jZzm7 >= 0 && jZzm7 < listZzo4.size()) {
                                        zzawmVarZzc = (zzawm) listZzo4.get((int) jZzm7);
                                    }
                                }
                                zzawdVar19.zzb(zzawmVarZzc);
                                return Optional.empty();
                        }
                    } catch (zzavs | zzavu | zzawj unused13) {
                        zzauwVar = zzauw.zzy;
                    }
                } catch (zzawb unused14) {
                    zzauwVar = zzauw.zzf;
                }
            } catch (zzawc e) {
                throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
            }
        } catch (zzavz | zzawb unused15) {
            zzauwVar = zzauw.zzx;
        }
    }
}
