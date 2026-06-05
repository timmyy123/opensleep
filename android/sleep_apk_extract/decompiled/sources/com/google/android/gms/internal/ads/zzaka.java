package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
final class zzaka {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzakj zzc = new zzakj();
    private zzakb zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzafz zzafzVar, int i) {
        byte[] bArr = this.zza;
        zzafzVar.zzc(bArr, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return j;
    }

    public final void zza(zzakb zzakbVar) {
        this.zzd = zzakbVar;
    }

    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8 A[LOOP:0: B:3:0x0005->B:36:0x00a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzc(zzafz zzafzVar) {
        int i;
        String str;
        int iZzd;
        int iZze;
        this.zzd.getClass();
        while (true) {
            ArrayDeque arrayDeque = this.zzb;
            zzajz zzajzVar = (zzajz) arrayDeque.peek();
            if (zzajzVar != null && zzafzVar.zzn() >= zzajzVar.zzb()) {
                ((zzakc) this.zzd).zza.zzi(((zzajz) arrayDeque.pop()).zza());
                return true;
            }
            int i2 = this.zze;
            if (i2 != 0) {
                if (i2 == 1) {
                }
                zzakb zzakbVar = this.zzd;
                i = this.zzf;
                zzakh zzakhVar = ((zzakc) zzakbVar).zza;
                switch (i) {
                    case 131:
                    case 136:
                    case 155:
                    case 159:
                    case 176:
                    case 179:
                    case 186:
                    case 215:
                    case 231:
                    case 238:
                    case 240:
                    case 241:
                    case 247:
                    case 251:
                    case 16871:
                    case 16980:
                    case 17029:
                    case 17143:
                    case 18401:
                    case 18408:
                    case 20529:
                    case 20530:
                    case 21420:
                    case 21432:
                    case 21680:
                    case 21682:
                    case 21690:
                    case 21930:
                    case 21938:
                    case 21945:
                    case 21946:
                    case 21947:
                    case 21948:
                    case 21949:
                    case 21998:
                    case 22186:
                    case 22203:
                    case 25188:
                    case 30114:
                    case 30321:
                    case 2352003:
                    case 2807729:
                        long j = this.zzg;
                        if (j <= 8) {
                            zzakhVar.zzj(i, zzd(zzafzVar, (int) j));
                            this.zze = 0;
                            return true;
                        }
                        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 22);
                        sb.append("Invalid integer size: ");
                        sb.append(j);
                        throw zzat.zzb(sb.toString(), null);
                    case 134:
                    case 17026:
                    case 21358:
                    case 2274716:
                        long j2 = this.zzg;
                        if (j2 > 2147483647L) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(j2).length() + 21);
                            sb2.append("String element size: ");
                            sb2.append(j2);
                            throw zzat.zzb(sb2.toString(), null);
                        }
                        int i3 = (int) j2;
                        if (i3 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i3];
                            zzafzVar.zzc(bArr, 0, i3);
                            while (i3 > 0) {
                                int i4 = i3 - 1;
                                if (bArr[i4] == 0) {
                                    i3 = i4;
                                } else {
                                    str = new String(bArr, 0, i3);
                                }
                            }
                            str = new String(bArr, 0, i3);
                        }
                        zzakhVar.zzl(i, str);
                        this.zze = 0;
                        return true;
                    case 160:
                    case 166:
                    case 174:
                    case 183:
                    case 187:
                    case 224:
                    case 225:
                    case 16868:
                    case 18407:
                    case 19899:
                    case 20532:
                    case 20533:
                    case 21936:
                    case 21968:
                    case 25152:
                    case 28032:
                    case 30113:
                    case 30320:
                    case 290298740:
                    case 357149030:
                    case 374648427:
                    case 408125543:
                    case 440786851:
                    case 475249515:
                    case 524531317:
                        long jZzn = zzafzVar.zzn();
                        arrayDeque.push(new zzajz(i, this.zzg + jZzn, null));
                        ((zzakc) this.zzd).zza.zzh(this.zzf, jZzn, this.zzg);
                        this.zze = 0;
                        return true;
                    case 161:
                    case 163:
                    case 165:
                    case 16877:
                    case 16981:
                    case 18402:
                    case 21419:
                    case 25506:
                    case 30322:
                        zzakhVar.zzm(i, (int) this.zzg, zzafzVar);
                        this.zze = 0;
                        return true;
                    case 181:
                    case 17545:
                    case 21969:
                    case 21970:
                    case 21971:
                    case 21972:
                    case 21973:
                    case 21974:
                    case 21975:
                    case 21976:
                    case 21977:
                    case 21978:
                    case 30323:
                    case 30324:
                    case 30325:
                        long j3 = this.zzg;
                        if (j3 != 4 && j3 != 8) {
                            StringBuilder sb3 = new StringBuilder(String.valueOf(j3).length() + 20);
                            sb3.append("Invalid float size: ");
                            sb3.append(j3);
                            throw zzat.zzb(sb3.toString(), null);
                        }
                        int i5 = (int) j3;
                        zzakhVar.zzk(i, i5 == 4 ? Float.intBitsToFloat((int) r6) : Double.longBitsToDouble(zzd(zzafzVar, i5)));
                        this.zze = 0;
                        return true;
                    default:
                        zzafzVar.zzf((int) this.zzg);
                        this.zze = 0;
                        break;
                }
            } else {
                long jZzb = this.zzc.zzb(zzafzVar, true, false, 4);
                if (jZzb == -2) {
                    zzafzVar.zzl();
                    while (true) {
                        byte[] bArr2 = this.zza;
                        zzafzVar.zzi(bArr2, 0, 4);
                        iZzd = zzakj.zzd(bArr2[0]);
                        if (iZzd != -1 && iZzd <= 4) {
                            iZze = (int) zzakj.zze(bArr2, iZzd, false);
                            zzakh zzakhVar2 = ((zzakc) this.zzd).zza;
                            if (iZze != 357149030 && iZze != 524531317 && iZze != 475249515) {
                                if (iZze == 374648427) {
                                    iZze = 374648427;
                                }
                            }
                        }
                        zzafzVar.zzf(1);
                    }
                    zzafzVar.zzf(iZzd);
                    jZzb = iZze;
                }
                if (jZzb == -1) {
                    return false;
                }
                this.zzf = (int) jZzb;
                this.zze = 1;
            }
            this.zzg = this.zzc.zzb(zzafzVar, false, true, 8);
            this.zze = 2;
            zzakb zzakbVar2 = this.zzd;
            i = this.zzf;
            zzakh zzakhVar3 = ((zzakc) zzakbVar2).zza;
            switch (i) {
                case 131:
                case 136:
                case 155:
                case 159:
                case 176:
                case 179:
                case 186:
                case 215:
                case 231:
                case 238:
                case 240:
                case 241:
                case 247:
                case 251:
                case 16871:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21938:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 21998:
                case 22186:
                case 22203:
                case 25188:
                case 30114:
                case 30321:
                case 2352003:
                case 2807729:
                    break;
                case 134:
                case 17026:
                case 21358:
                case 2274716:
                    break;
                case 160:
                case 166:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case 16868:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30113:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    break;
                case 161:
                case 163:
                case 165:
                case 16877:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    break;
                case 181:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                case 30323:
                case 30324:
                case 30325:
                    break;
            }
        }
    }
}
