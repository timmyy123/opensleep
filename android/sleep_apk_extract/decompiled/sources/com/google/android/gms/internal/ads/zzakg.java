package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.facebook.internal.Utility;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class zzakg {
    public byte[] zzN;
    public zzahl zzT;
    public boolean zzV;
    public zzahk zzX;
    public zzv zzY;
    public int zzZ;
    public boolean zza;
    private int zzaa;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzahj zzj;
    public byte[] zzk;
    public zzq zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = 1000;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public boolean zzU = false;
    public boolean zzW = true;
    private String zzab = "eng";

    private static Pair zzf(zzet zzetVar) throws zzat {
        try {
            zzetVar.zzk(16);
            long jZzA = zzetVar.zzA();
            if (jZzA == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzA == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzA != 826496599) {
                zzeg.zzc("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzg = zzetVar.zzg() + 20;
            byte[] bArrZzi = zzetVar.zzi();
            while (true) {
                int length = bArrZzi.length;
                if (iZzg >= length - 4) {
                    throw zzat.zzb("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzg + 1;
                if (bArrZzi[iZzg] == 0 && bArrZzi[i] == 0 && bArrZzi[iZzg + 2] == 1 && bArrZzi[iZzg + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzi, iZzg, length)));
                }
                iZzg = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzat {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & PHIpAddressSearchManager.END_IP_SCAN;
                if (i != 255) {
                    break;
                }
                i3 += PHIpAddressSearchManager.END_IP_SCAN;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & PHIpAddressSearchManager.END_IP_SCAN;
                if (i2 != 255) {
                    break;
                }
                i7 += PHIpAddressSearchManager.END_IP_SCAN;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzet zzetVar) throws zzat {
        try {
            int iZzu = zzetVar.zzu();
            if (iZzu == 1) {
                return true;
            }
            if (iZzu == 65534) {
                zzetVar.zzh(24);
                if (zzetVar.zzD() == zzakh.zzf.getMostSignificantBits()) {
                    if (zzetVar.zzD() == zzakh.zzf.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing MS/ACM codec private", null);
        }
    }

    private final byte[] zzi(String str) throws zzat {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        throw zzat.zzb("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(int i) {
        byte b;
        String str;
        List listZzj;
        String str2;
        String str3;
        int i2;
        String str4;
        int i3;
        int i4;
        int i5;
        int i6;
        int iZzB;
        int i7;
        List list;
        List list2;
        int i8;
        List list3;
        String str5;
        String str6;
        int i9;
        String str7;
        List list4;
        String str8;
        List listSingletonList;
        List list5;
        String str9;
        String str10;
        String str11;
        zzt zztVar;
        int i10;
        int i11;
        int i12;
        byte[] bArr;
        int i13;
        int i14;
        String str12;
        List list6;
        List listZzk;
        String str13 = this.zzc;
        switch (str13.hashCode()) {
            case -2095576542:
                b = !str13.equals("V_MPEG4/ISO/AP") ? (byte) -1 : (byte) 6;
                break;
            case -2095575984:
                if (str13.equals("V_MPEG4/ISO/SP")) {
                    b = 4;
                    break;
                }
                break;
            case -1985379776:
                if (str13.equals("A_MS/ACM")) {
                    b = 23;
                    break;
                }
                break;
            case -1784763192:
                if (str13.equals("A_TRUEHD")) {
                    b = 18;
                    break;
                }
                break;
            case -1730367663:
                if (str13.equals("A_VORBIS")) {
                    b = MqttWireMessage.MESSAGE_TYPE_UNSUBACK;
                    break;
                }
                break;
            case -1482641358:
                if (str13.equals("A_MPEG/L2")) {
                    b = MqttWireMessage.MESSAGE_TYPE_DISCONNECT;
                    break;
                }
                break;
            case -1482641357:
                if (str13.equals("A_MPEG/L3")) {
                    b = 15;
                    break;
                }
                break;
            case -1373388978:
                if (str13.equals("V_MS/VFW/FOURCC")) {
                    b = 9;
                    break;
                }
                break;
            case -933872740:
                if (str13.equals("S_DVBSUB")) {
                    b = 33;
                    break;
                }
                break;
            case -538363189:
                if (str13.equals("V_MPEG4/ISO/ASP")) {
                    b = 5;
                    break;
                }
                break;
            case -538363109:
                if (str13.equals("V_MPEG4/ISO/AVC")) {
                    b = 7;
                    break;
                }
                break;
            case -425012669:
                if (str13.equals("S_VOBSUB")) {
                    b = 31;
                    break;
                }
                break;
            case -356037306:
                if (str13.equals("A_DTS/LOSSLESS")) {
                    b = 21;
                    break;
                }
                break;
            case 62923557:
                if (str13.equals("A_AAC")) {
                    b = MqttWireMessage.MESSAGE_TYPE_PINGRESP;
                    break;
                }
                break;
            case 62923603:
                if (str13.equals("A_AC3")) {
                    b = 16;
                    break;
                }
                break;
            case 62927045:
                if (str13.equals("A_DTS")) {
                    b = 19;
                    break;
                }
                break;
            case 82318131:
                if (str13.equals("V_AV1")) {
                    b = 2;
                    break;
                }
                break;
            case 82338133:
                if (str13.equals("V_VP8")) {
                    b = 0;
                    break;
                }
                break;
            case 82338134:
                if (str13.equals("V_VP9")) {
                    b = 1;
                    break;
                }
                break;
            case 99146302:
                if (str13.equals("S_HDMV/PGS")) {
                    b = 32;
                    break;
                }
                break;
            case 444813526:
                if (str13.equals("V_THEORA")) {
                    b = 10;
                    break;
                }
                break;
            case 542569478:
                if (str13.equals("A_DTS/EXPRESS")) {
                    b = 20;
                    break;
                }
                break;
            case 635596514:
                if (str13.equals("A_PCM/FLOAT/IEEE")) {
                    b = 26;
                    break;
                }
                break;
            case 725948237:
                if (str13.equals("A_PCM/INT/BIG")) {
                    b = 25;
                    break;
                }
                break;
            case 725957860:
                if (str13.equals("A_PCM/INT/LIT")) {
                    b = 24;
                    break;
                }
                break;
            case 738597099:
                if (str13.equals("S_TEXT/ASS")) {
                    b = 28;
                    break;
                }
                break;
            case 738614379:
                if (str13.equals("S_TEXT/SSA")) {
                    b = 29;
                    break;
                }
                break;
            case 855502857:
                if (str13.equals("V_MPEGH/ISO/HEVC")) {
                    b = 8;
                    break;
                }
                break;
            case 1045209816:
                if (str13.equals("S_TEXT/WEBVTT")) {
                    b = 30;
                    break;
                }
                break;
            case 1422270023:
                if (str13.equals("S_TEXT/UTF8")) {
                    b = 27;
                    break;
                }
                break;
            case 1809237540:
                if (str13.equals("V_MPEG2")) {
                    b = 3;
                    break;
                }
                break;
            case 1950749482:
                if (str13.equals("A_EAC3")) {
                    b = 17;
                    break;
                }
                break;
            case 1950789798:
                if (str13.equals("A_FLAC")) {
                    b = 22;
                    break;
                }
                break;
            case 1951062397:
                if (str13.equals("A_OPUS")) {
                    b = MqttWireMessage.MESSAGE_TYPE_PINGREQ;
                    break;
                }
                break;
        }
        List list7 = null;
        list = null;
        list = null;
        list = null;
        List list8 = null;
        List list9 = null;
        List list10 = null;
        switch (b) {
            case 0:
                str = "video/x-vnd.on2.vp8";
                str3 = str;
                iZzB = -1;
                i4 = -1;
                list = null;
                str4 = null;
                list5 = list;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                    str9 = str4;
                    zzfu zzfuVarZza = zzfu.zza(new zzet(this.zzN));
                    if (zzfuVarZza != null) {
                        str10 = "video/dolby-vision";
                        str11 = zzfuVarZza.zza;
                    }
                    List list11 = list7;
                    int i15 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zztVar = new zzt();
                    if (!zzas.zza(str10)) {
                        zztVar.zzG(this.zzO);
                        zztVar.zzH(this.zzQ);
                        zztVar.zzI(iZzB);
                    } else if (zzas.zzb(str10)) {
                        if (this.zzr == 0) {
                            int i16 = this.zzp;
                            i10 = -1;
                            if (i16 == -1) {
                                i16 = this.zzm;
                            }
                            this.zzp = i16;
                            int i17 = this.zzq;
                            if (i17 == -1) {
                                i17 = this.zzn;
                            }
                            this.zzq = i17;
                        } else {
                            i10 = -1;
                        }
                        float f = (this.zzp == i10 || (i14 = this.zzq) == i10) ? -1.0f : (this.zzn * r1) / (this.zzm * i14);
                        if (i6 == i10) {
                            if (i5 != i10) {
                                i6 = i10;
                            } else if (i2 == i10 || this.zzA != i10) {
                                i6 = this.zzy;
                                i5 = this.zzz;
                                i2 = this.zzA;
                            } else {
                                i6 = this.zzy;
                                i5 = this.zzz;
                            }
                        }
                        if (i7 == i10 && (i7 = this.zzo) == i10) {
                            i7 = 8;
                        }
                        if (i4 == i10) {
                            i11 = this.zzo;
                            if (i11 == i10) {
                                i11 = 8;
                            }
                        } else {
                            i11 = i4;
                        }
                        if (this.zzD == -1.0f || this.zzE == -1.0f || this.zzF == -1.0f || this.zzG == -1.0f || this.zzH == -1.0f || this.zzI == -1.0f || this.zzJ == -1.0f || this.zzK == -1.0f || this.zzL == -1.0f) {
                            i12 = 0;
                            bArr = null;
                        } else if (this.zzM == -1.0f) {
                            bArr = null;
                            i12 = 0;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            i12 = 0;
                            byteBufferOrder.put((byte) 0);
                            byteBufferOrder.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzL + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzM + 0.5f));
                            byteBufferOrder.putShort((short) this.zzB);
                            byteBufferOrder.putShort((short) this.zzC);
                        }
                        zzh zzhVar = new zzh();
                        zzhVar.zza(i6);
                        zzhVar.zzb(i2);
                        zzhVar.zzc(i5);
                        zzhVar.zzd(bArr);
                        zzhVar.zze(i7);
                        zzhVar.zzf(i11);
                        zzi zziVarZzg = zzhVar.zzg();
                        String str14 = this.zzb;
                        int iIntValue = (str14 == null || !zzakh.zzg.containsKey(str14)) ? i10 : ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        if (this.zzs == 0 && Float.compare(this.zzt, 0.0f) == 0 && Float.compare(this.zzu, 0.0f) == 0) {
                            if (Float.compare(this.zzv, 0.0f) == 0) {
                                i13 = i12;
                            } else if (Float.compare(this.zzv, 90.0f) == 0) {
                                i13 = 90;
                            } else {
                                i13 = 180;
                                if (Float.compare(this.zzv, -180.0f) != 0 && Float.compare(this.zzv, 180.0f) != 0) {
                                    if (Float.compare(this.zzv, -90.0f) == 0) {
                                        i13 = 270;
                                    }
                                }
                            }
                            zztVar.zzv(this.zzm);
                            zztVar.zzw(this.zzn);
                            zztVar.zzB(f);
                            zztVar.zzA(i13);
                            zztVar.zzC(this.zzw);
                            zztVar.zzD(this.zzx);
                            zztVar.zzE(zziVarZzg);
                        } else {
                            i13 = iIntValue;
                            zztVar.zzv(this.zzm);
                            zztVar.zzw(this.zzn);
                            zztVar.zzB(f);
                            zztVar.zzA(i13);
                            zztVar.zzC(this.zzw);
                            zztVar.zzD(this.zzx);
                            zztVar.zzE(zziVarZzg);
                        }
                    } else if (!"application/x-subrip".equals(str10) && !"text/x-ssa".equals(str10) && !"text/vtt".equals(str10) && !"application/vobsub".equals(str10) && !"application/pgs".equals(str10) && !"application/dvbsubs".equals(str10)) {
                        throw zzat.zzb("Unexpected MIME type.", null);
                    }
                    str12 = this.zzb;
                    if (str12 != null && !zzakh.zzg.containsKey(str12)) {
                        zztVar.zzc(this.zzb);
                    }
                    zztVar.zzb(i);
                    zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                    zztVar.zzo(str10);
                    zztVar.zzp(i3);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i15);
                    zztVar.zzr(list11);
                    zztVar.zzk(str11);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                str9 = str4;
                str10 = str3;
                str11 = str9;
                List list112 = list7;
                int i152 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                    zztVar.zzc(this.zzb);
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152);
                zztVar.zzr(list112);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 1:
                byte[] bArr2 = this.zzk;
                listZzj = bArr2 == null ? null : zzgwm.zzj(bArr2);
                str2 = "video/x-vnd.on2.vp9";
                list = listZzj;
                str3 = str2;
                iZzB = -1;
                i4 = -1;
                str4 = null;
                list5 = list;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122 = list7;
                int i1522 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522);
                zztVar.zzr(list1122);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 2:
                byte[] bArr3 = this.zzk;
                if (bArr3 == null) {
                    str3 = "video/av01";
                    iZzB = -1;
                    i4 = -1;
                    list = null;
                    str4 = null;
                    list5 = list;
                    i7 = -1;
                    i2 = -1;
                    i6 = -1;
                    i5 = -1;
                    i3 = -1;
                    list7 = list5;
                    if (this.zzN != null) {
                    }
                    str10 = str3;
                    str11 = str9;
                    List list11222 = list7;
                    int i15222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zztVar = new zzt();
                    if (!zzas.zza(str10)) {
                    }
                    str12 = this.zzb;
                    if (str12 != null) {
                    }
                    zztVar.zzb(i);
                    zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                    zztVar.zzo(str10);
                    zztVar.zzp(i3);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i15222);
                    zztVar.zzr(list11222);
                    zztVar.zzk(str11);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                zzafc zzafcVarZza = zzafc.zza(bArr3);
                List list12 = zzafcVarZza.zza;
                int i18 = zzafcVarZza.zzc;
                int i19 = zzafcVarZza.zze;
                str3 = "video/av01";
                i2 = zzafcVarZza.zzd;
                str4 = null;
                i3 = -1;
                i4 = zzafcVarZza.zzb;
                i5 = i19;
                i6 = i18;
                iZzB = -1;
                i7 = i4;
                list7 = list12;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222 = list7;
                int i152222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222);
                zztVar.zzr(list112222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 3:
                str = "video/mpeg2";
                str3 = str;
                iZzB = -1;
                i4 = -1;
                list = null;
                str4 = null;
                list5 = list;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222 = list7;
                int i1522222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222);
                zztVar.zzr(list1122222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr4 = this.zzk;
                listZzj = bArr4 == null ? null : Collections.singletonList(bArr4);
                str2 = "video/mp4v-es";
                list = listZzj;
                str3 = str2;
                iZzB = -1;
                i4 = -1;
                str4 = null;
                list5 = list;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222 = list7;
                int i15222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222);
                zztVar.zzr(list11222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 7:
                zzafd zzafdVarZza = zzafd.zza(new zzet(zzi(this.zzc)));
                list2 = zzafdVarZza.zza;
                this.zzZ = zzafdVarZza.zzb;
                String str15 = zzafdVarZza.zzl;
                int i20 = zzafdVarZza.zzg;
                int i21 = zzafdVarZza.zzi;
                int i22 = zzafdVarZza.zzh;
                int i23 = zzafdVarZza.zze;
                i8 = zzafdVarZza.zzf;
                i2 = i22;
                str3 = "video/avc";
                i3 = -1;
                i5 = i21;
                i6 = i20;
                i7 = i23;
                str4 = str15;
                list3 = list2;
                i4 = i8;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222 = list7;
                int i152222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222);
                zztVar.zzr(list112222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 8:
                zzags zzagsVarZza = zzags.zza(new zzet(zzi(this.zzc)));
                list2 = zzagsVarZza.zza;
                this.zzZ = zzagsVarZza.zzb;
                str4 = zzagsVarZza.zzn;
                int i24 = zzagsVarZza.zzh;
                int i25 = zzagsVarZza.zzj;
                int i26 = zzagsVarZza.zzi;
                int i27 = zzagsVarZza.zzf;
                i8 = zzagsVarZza.zzg;
                i2 = i26;
                str3 = "video/hevc";
                i3 = -1;
                i5 = i25;
                i6 = i24;
                i7 = i27;
                list3 = list2;
                i4 = i8;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222 = list7;
                int i1522222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222);
                zztVar.zzr(list1122222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 9:
                Pair pairZzf = zzf(new zzet(zzi(this.zzc)));
                str5 = (String) pairZzf.first;
                listSingletonList = (List) pairZzf.second;
                str4 = null;
                str3 = str5;
                listZzk = listSingletonList;
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list6 = listZzk;
                list3 = list6;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222 = list7;
                int i15222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222);
                zztVar.zzr(list11222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 10:
                str6 = "video/x-unknown";
                str4 = null;
                str3 = str6;
                list8 = list10;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222222 = list7;
                int i152222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222222);
                zztVar.zzr(list112222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 11:
                List listZzg = zzg(zzi(str13));
                i9 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
                str7 = "audio/vorbis";
                list4 = listZzg;
                str4 = null;
                i3 = i9;
                str3 = str7;
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                list6 = list4;
                list3 = list6;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222 = list7;
                int i1522222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222);
                zztVar.zzr(list1122222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 12:
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(zzi(this.zzc));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                arrayList.add(byteBufferAllocate.order(byteOrder).putLong(this.zzR).array());
                arrayList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.zzS).array());
                i9 = 5760;
                str7 = "audio/opus";
                list4 = arrayList;
                str4 = null;
                i3 = i9;
                str3 = str7;
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                list6 = list4;
                list3 = list6;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222222 = list7;
                int i15222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222222);
                zztVar.zzr(list11222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 13:
                List listSingletonList2 = Collections.singletonList(zzi(str13));
                zzaev zzaevVarZza = zzaew.zza(this.zzk);
                this.zzQ = zzaevVarZza.zza;
                this.zzO = zzaevVarZza.zzb;
                str6 = "audio/mp4a-latm";
                list10 = listSingletonList2;
                str4 = zzaevVarZza.zzc;
                str3 = str6;
                list8 = list10;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222222222 = list7;
                int i152222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222222222);
                zztVar.zzr(list112222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 14:
                str8 = "audio/mpeg-L2";
                str4 = null;
                str3 = str8;
                iZzB = -1;
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = 4096;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222222 = list7;
                int i1522222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222222);
                zztVar.zzr(list1122222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 15:
                str8 = "audio/mpeg";
                str4 = null;
                str3 = str8;
                iZzB = -1;
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = 4096;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222222222 = list7;
                int i15222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222222222);
                zztVar.zzr(list11222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 16:
                str6 = "audio/ac3";
                str4 = null;
                str3 = str6;
                list8 = list10;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222222222222 = list7;
                int i152222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222222222222);
                zztVar.zzr(list112222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 17:
                str6 = "audio/eac3";
                str4 = null;
                str3 = str6;
                list8 = list10;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222222222 = list7;
                int i1522222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222222222);
                zztVar.zzr(list1122222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 18:
                this.zzT = new zzahl();
                str6 = "audio/true-hd";
                str4 = null;
                str3 = str6;
                list8 = list10;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222222222222 = list7;
                int i15222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222222222222);
                zztVar.zzr(list11222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 19:
            case 20:
                this.zzU = true;
                str6 = "audio/vnd.dts";
                str4 = null;
                str3 = str6;
                list8 = list10;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222222222222222 = list7;
                int i152222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222222222222222);
                zztVar.zzr(list112222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 21:
                str6 = "audio/vnd.dts.hd";
                str4 = null;
                str3 = str6;
                list8 = list10;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222222222222 = list7;
                int i1522222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222222222222);
                zztVar.zzr(list1122222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 22:
                str5 = "audio/flac";
                listSingletonList = Collections.singletonList(zzi(str13));
                str4 = null;
                str3 = str5;
                listZzk = listSingletonList;
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list6 = listZzk;
                list3 = list6;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222222222222222 = list7;
                int i15222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222222222222222);
                zztVar.zzr(list11222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 23:
                if (zzh(new zzet(zzi(this.zzc)))) {
                    iZzB = zzfl.zzB(this.zzP, ByteOrder.LITTLE_ENDIAN);
                    if (iZzB == 0) {
                        int i28 = this.zzP;
                        StringBuilder sb = new StringBuilder(String.valueOf(i28).length() + 64);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i28);
                        sb.append(". Setting mimeType to audio/x-unknown");
                        zzeg.zzc("MatroskaExtractor", sb.toString());
                    }
                    str4 = null;
                    str3 = "audio/raw";
                    i4 = -1;
                    list5 = list9;
                    i7 = -1;
                    i2 = -1;
                    i6 = -1;
                    i5 = -1;
                    i3 = -1;
                    list7 = list5;
                    if (this.zzN != null) {
                    }
                    str10 = str3;
                    str11 = str9;
                    List list112222222222222222222222 = list7;
                    int i152222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zztVar = new zzt();
                    if (!zzas.zza(str10)) {
                    }
                    str12 = this.zzb;
                    if (str12 != null) {
                    }
                    zztVar.zzb(i);
                    zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                    zztVar.zzo(str10);
                    zztVar.zzp(i3);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i152222222222222222222222);
                    zztVar.zzr(list112222222222222222222222);
                    zztVar.zzk(str11);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                zzeg.zzc("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                str4 = null;
                str3 = "audio/x-unknown";
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222222222222222 = list7;
                int i1522222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222222222222222);
                zztVar.zzr(list1122222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 24:
                iZzB = zzfl.zzB(this.zzP, ByteOrder.LITTLE_ENDIAN);
                if (iZzB == 0) {
                    int i29 = this.zzP;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i29).length() + 78);
                    sb2.append("Unsupported little endian PCM bit depth: ");
                    sb2.append(i29);
                    sb2.append(". Setting mimeType to audio/x-unknown");
                    zzeg.zzc("MatroskaExtractor", sb2.toString());
                    str4 = null;
                    str3 = "audio/x-unknown";
                    iZzB = -1;
                    list9 = list8;
                    i4 = -1;
                    list5 = list9;
                    i7 = -1;
                    i2 = -1;
                    i6 = -1;
                    i5 = -1;
                    i3 = -1;
                    list7 = list5;
                    if (this.zzN != null) {
                    }
                    str10 = str3;
                    str11 = str9;
                    List list11222222222222222222222222 = list7;
                    int i15222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zztVar = new zzt();
                    if (!zzas.zza(str10)) {
                    }
                    str12 = this.zzb;
                    if (str12 != null) {
                    }
                    zztVar.zzb(i);
                    zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                    zztVar.zzo(str10);
                    zztVar.zzp(i3);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i15222222222222222222222222);
                    zztVar.zzr(list11222222222222222222222222);
                    zztVar.zzk(str11);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                str4 = null;
                str3 = "audio/raw";
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222222222222222222222 = list7;
                int i152222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222222222222222222222);
                zztVar.zzr(list112222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 25:
                iZzB = zzfl.zzB(this.zzP, ByteOrder.BIG_ENDIAN);
                if (iZzB == 0) {
                    int i30 = this.zzP;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(i30).length() + 75);
                    sb3.append("Unsupported big endian PCM bit depth: ");
                    sb3.append(i30);
                    sb3.append(". Setting mimeType to audio/x-unknown");
                    zzeg.zzc("MatroskaExtractor", sb3.toString());
                    str4 = null;
                    str3 = "audio/x-unknown";
                    iZzB = -1;
                    list9 = list8;
                    i4 = -1;
                    list5 = list9;
                    i7 = -1;
                    i2 = -1;
                    i6 = -1;
                    i5 = -1;
                    i3 = -1;
                    list7 = list5;
                    if (this.zzN != null) {
                    }
                    str10 = str3;
                    str11 = str9;
                    List list1122222222222222222222222222 = list7;
                    int i1522222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zztVar = new zzt();
                    if (!zzas.zza(str10)) {
                    }
                    str12 = this.zzb;
                    if (str12 != null) {
                    }
                    zztVar.zzb(i);
                    zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                    zztVar.zzo(str10);
                    zztVar.zzp(i3);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i1522222222222222222222222222);
                    zztVar.zzr(list1122222222222222222222222222);
                    zztVar.zzk(str11);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                str4 = null;
                str3 = "audio/raw";
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222222222222222222222 = list7;
                int i15222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222222222222222222222);
                zztVar.zzr(list11222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 26:
                iZzB = zzfl.zzC(this.zzP);
                if (iZzB == 0) {
                    int i31 = this.zzP;
                    StringBuilder sb4 = new StringBuilder(String.valueOf(i31).length() + 79);
                    sb4.append("Unsupported floating point PCM bit depth: ");
                    sb4.append(i31);
                    sb4.append(". Setting mimeType to audio/x-unknown");
                    zzeg.zzc("MatroskaExtractor", sb4.toString());
                    str4 = null;
                    str3 = "audio/x-unknown";
                    iZzB = -1;
                    list9 = list8;
                    i4 = -1;
                    list5 = list9;
                    i7 = -1;
                    i2 = -1;
                    i6 = -1;
                    i5 = -1;
                    i3 = -1;
                    list7 = list5;
                    if (this.zzN != null) {
                    }
                    str10 = str3;
                    str11 = str9;
                    List list112222222222222222222222222222 = list7;
                    int i152222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zztVar = new zzt();
                    if (!zzas.zza(str10)) {
                    }
                    str12 = this.zzb;
                    if (str12 != null) {
                    }
                    zztVar.zzb(i);
                    zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                    zztVar.zzo(str10);
                    zztVar.zzp(i3);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i152222222222222222222222222222);
                    zztVar.zzr(list112222222222222222222222222222);
                    zztVar.zzk(str11);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                str4 = null;
                str3 = "audio/raw";
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222222222222222222222 = list7;
                int i1522222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222222222222222222222);
                zztVar.zzr(list1122222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 27:
                str4 = null;
                str3 = "application/x-subrip";
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222222222222222222222222 = list7;
                int i15222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222222222222222222222222);
                zztVar.zzr(list11222222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 28:
            case 29:
                int i32 = zzakh.$r8$clinit;
                str4 = null;
                str3 = "text/x-ssa";
                listZzk = zzgwm.zzk(zzakh.zzc, zzi(this.zzc));
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list6 = listZzk;
                list3 = list6;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222222222222222222222222222 = list7;
                int i152222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222222222222222222222222222);
                zztVar.zzr(list112222222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 30:
                str4 = null;
                str3 = "text/vtt";
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222222222222222222222222 = list7;
                int i1522222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222222222222222222222222);
                zztVar.zzr(list1122222222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 31:
                str4 = null;
                str3 = "application/vobsub";
                listZzk = zzgwm.zzj(zzi(str13));
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list6 = listZzk;
                list3 = list6;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list11222222222222222222222222222222222 = list7;
                int i15222222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i15222222222222222222222222222222222);
                zztVar.zzr(list11222222222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 32:
                str3 = "application/pgs";
                str4 = null;
                iZzB = -1;
                list9 = list8;
                i4 = -1;
                list5 = list9;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list7 = list5;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list112222222222222222222222222222222222 = list7;
                int i152222222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i152222222222222222222222222222222222);
                zztVar.zzr(list112222222222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 33:
                byte[] bArr5 = new byte[4];
                System.arraycopy(zzi(str13), 0, bArr5, 0, 4);
                str4 = null;
                str3 = "application/dvbsubs";
                listZzk = zzgwm.zzj(bArr5);
                i4 = -1;
                i7 = -1;
                i2 = -1;
                i6 = -1;
                i5 = -1;
                i3 = -1;
                list6 = listZzk;
                list3 = list6;
                iZzB = -1;
                list7 = list3;
                if (this.zzN != null) {
                }
                str10 = str3;
                str11 = str9;
                List list1122222222222222222222222222222222222 = list7;
                int i1522222222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zztVar = new zzt();
                if (!zzas.zza(str10)) {
                }
                str12 = this.zzb;
                if (str12 != null) {
                }
                zztVar.zzb(i);
                zztVar.zzn(true == this.zza ? "video/x-matroska" : "video/webm");
                zztVar.zzo(str10);
                zztVar.zzp(i3);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1522222222222222222222222222222222222);
                zztVar.zzr(list1122222222222222222222222222222222222);
                zztVar.zzk(str11);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            default:
                throw zzat.zzb("Unrecognized codec identifier.", null);
        }
    }

    public final /* synthetic */ void zzb() {
        this.zzX.getClass();
    }

    public final /* synthetic */ int zzc() {
        return this.zzaa;
    }

    public final /* synthetic */ void zzd(int i) {
        this.zzaa = i;
    }

    public final /* synthetic */ void zze(String str) {
        this.zzab = str;
    }
}
