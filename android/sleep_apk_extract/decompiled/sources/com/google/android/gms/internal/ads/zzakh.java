package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes3.dex */
public final class zzakh implements zzafy {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzD;
    private zzakg zzE;
    private boolean zzF;
    private int zzG;
    private long zzH;
    private final SparseArray zzI;
    private boolean zzJ;
    private long zzK;
    private int zzL;
    private long zzM;
    private long zzN;
    private int zzO;
    private boolean zzP;
    private long zzQ;
    private long zzR;
    private long zzS;
    private boolean zzT;
    private int zzU;
    private long zzV;
    private long zzW;
    private int zzX;
    private int zzY;
    private int[] zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private int zzad;
    private boolean zzae;
    private long zzaf;
    private int zzag;
    private int zzah;
    private int zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private int zzam;
    private byte zzan;
    private boolean zzao;
    private zzagb zzap;
    private final zzaka zzaq;
    private final zzakj zzh;
    private final SparseArray zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final zzanj zzl;
    private final zzet zzm;
    private final zzet zzn;
    private final zzet zzo;
    private final zzet zzp;
    private final zzet zzq;
    private final zzet zzr;
    private final zzet zzs;
    private final zzet zzt;
    private final zzet zzu;
    private final zzet zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        String str = zzfl.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(map);
    }

    public zzakh(zzaka zzakaVar, int i, zzanj zzanjVar) {
        this.zzy = -1L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzK = -9223372036854775807L;
        this.zzL = -1;
        this.zzM = -1L;
        this.zzN = -1L;
        this.zzO = -1;
        this.zzQ = -1L;
        this.zzR = -1L;
        this.zzS = -9223372036854775807L;
        this.zzaq = zzakaVar;
        zzakaVar.zza(new zzakc(this, null));
        this.zzl = zzanjVar;
        this.zzI = new SparseArray();
        this.zzj = 1 == ((i & 1) ^ 1);
        this.zzk = (i & 2) == 0;
        this.zzh = new zzakj();
        this.zzi = new SparseArray();
        this.zzo = new zzet(4);
        this.zzp = new zzet(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzet(4);
        this.zzm = new zzet(zzgp.zza);
        this.zzn = new zzet(4);
        this.zzr = new zzet();
        this.zzs = new zzet();
        this.zzt = new zzet(8);
        this.zzu = new zzet();
        this.zzv = new zzet();
        this.zzZ = new int[1];
        this.zzD = true;
    }

    private static int[] zzA(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    private final void zzB() {
        if (!this.zzD) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i >= sparseArray.size()) {
                zzagb zzagbVar = this.zzap;
                zzagbVar.getClass();
                zzagbVar.zzv();
                this.zzD = false;
                return;
            }
            if (((zzakg) sparseArray.valueAt(i)).zzU) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void zzq(int i) throws zzat {
        if (this.zzE != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 32);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a TrackEntry");
        throw zzat.zzb(sb.toString(), null);
    }

    private final void zzr(int i) throws zzat {
        if (this.zzJ) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 26);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a Cues");
        throw zzat.zzb(sb.toString(), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        if (r2.equals("S_TEXT/SSA") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        if (r2.equals("S_TEXT/ASS") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
    
        r2 = zzx(r11, "%01d:%02d:%02d:%02d", 10000);
        r3 = 21;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzs(zzakg zzakgVar, long j, int i, int i2, int i3) {
        byte[] bArrZzx;
        int i4;
        int iZzg;
        int iZze;
        zzahl zzahlVar = zzakgVar.zzT;
        if (zzahlVar != null) {
            zzahlVar.zzc(zzakgVar.zzX, j, i, i2, i3, zzakgVar.zzj);
        } else {
            String str = zzakgVar.zzc;
            if ("S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_TEXT/SSA".equals(str) || "S_TEXT/WEBVTT".equals(str)) {
                if (this.zzY > 1) {
                    zzeg.zzc("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.zzW;
                    if (j2 != -9223372036854775807L) {
                        zzet zzetVar = this.zzs;
                        byte[] bArrZzi = zzetVar.zzi();
                        switch (str.hashCode()) {
                            case 738597099:
                                break;
                            case 738614379:
                                break;
                            case 1045209816:
                                if (str.equals("S_TEXT/WEBVTT")) {
                                    bArrZzx = zzx(j2, "%02d:%02d:%02d.%03d", 1000L);
                                    i4 = 25;
                                    System.arraycopy(bArrZzx, 0, bArrZzi, i4, bArrZzx.length);
                                    iZzg = zzetVar.zzg();
                                    while (true) {
                                        if (iZzg < zzetVar.zze()) {
                                            if (zzetVar.zzi()[iZzg] == 0) {
                                                zzetVar.zzf(iZzg);
                                            } else {
                                                iZzg++;
                                            }
                                        }
                                    }
                                    zzakgVar.zzX.zzc(zzetVar, zzetVar.zze());
                                    iZze = zzetVar.zze() + i2;
                                    if ((i & ClientDefaults.MAX_MSG_SIZE) != 0) {
                                        int i5 = this.zzY;
                                        zzet zzetVar2 = this.zzv;
                                        if (i5 > 1) {
                                            zzetVar2.zza(0);
                                        } else {
                                            int iZze2 = zzetVar2.zze();
                                            zzakgVar.zzX.zzd(zzetVar2, iZze2, 2);
                                            iZze += iZze2;
                                        }
                                    }
                                    zzakgVar.zzX.zze(j, i, iZze, i3, zzakgVar.zzj);
                                }
                                Utf8$$ExternalSyntheticBUOutline0.m$3();
                                break;
                            case 1422270023:
                                if (str.equals("S_TEXT/UTF8")) {
                                    bArrZzx = zzx(j2, "%02d:%02d:%02d,%03d", 1000L);
                                    i4 = 19;
                                    System.arraycopy(bArrZzx, 0, bArrZzi, i4, bArrZzx.length);
                                    iZzg = zzetVar.zzg();
                                    while (true) {
                                        if (iZzg < zzetVar.zze()) {
                                        }
                                        iZzg++;
                                    }
                                    zzakgVar.zzX.zzc(zzetVar, zzetVar.zze());
                                    iZze = zzetVar.zze() + i2;
                                    if ((i & ClientDefaults.MAX_MSG_SIZE) != 0) {
                                    }
                                    zzakgVar.zzX.zze(j, i, iZze, i3, zzakgVar.zzj);
                                }
                                Utf8$$ExternalSyntheticBUOutline0.m$3();
                                break;
                            default:
                                Utf8$$ExternalSyntheticBUOutline0.m$3();
                                break;
                        }
                    }
                    zzeg.zzc("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                }
                iZze = i2;
                if ((i & ClientDefaults.MAX_MSG_SIZE) != 0) {
                }
                zzakgVar.zzX.zze(j, i, iZze, i3, zzakgVar.zzj);
            } else {
                iZze = i2;
                if ((i & ClientDefaults.MAX_MSG_SIZE) != 0) {
                }
                zzakgVar.zzX.zze(j, i, iZze, i3, zzakgVar.zzj);
            }
        }
        this.zzT = true;
    }

    private final void zzt(zzafz zzafzVar, int i) {
        zzet zzetVar = this.zzo;
        if (zzetVar.zze() >= i) {
            return;
        }
        if (zzetVar.zzj() < i) {
            int iZzj = zzetVar.zzj();
            zzetVar.zzc(Math.max(iZzj + iZzj, i));
        }
        zzafzVar.zzc(zzetVar.zzi(), zzetVar.zze(), i - zzetVar.zze());
        zzetVar.zzf(i);
    }

    private final int zzu(zzafz zzafzVar, zzakg zzakgVar, int i, boolean z) throws zzat {
        int i2;
        String str = zzakgVar.zzc;
        if ("S_TEXT/UTF8".equals(str)) {
            zzw(zzafzVar, zzb, i);
            int i3 = this.zzah;
            zzv();
            return i3;
        }
        if ("S_TEXT/ASS".equals(str) || "S_TEXT/SSA".equals(str)) {
            zzw(zzafzVar, zzd, i);
            int i4 = this.zzah;
            zzv();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(str)) {
            zzw(zzafzVar, zze, i);
            int i5 = this.zzah;
            zzv();
            return i5;
        }
        if (zzakgVar.zzU) {
            zzakgVar.zzY.getClass();
            zzet zzetVar = new zzet(i);
            if (zzafzVar.zzh(zzetVar.zzi(), 0, i, true)) {
                zzafzVar.zzl();
                if (zzafx.zza(zzetVar.zzr()) == 1 && zzetVar.zzd() >= 10) {
                    byte[] bArr = new byte[10];
                    zzetVar.zzm(bArr, 0, 10);
                    zzetVar.zzh(0);
                    int iZzc = zzafx.zzc(bArr);
                    if (zzetVar.zzd() >= iZzc + 4) {
                        zzetVar.zzk(iZzc);
                        if (zzafx.zza(zzetVar.zzB()) == 2) {
                            zzt zztVarZza = zzakgVar.zzY.zza();
                            zztVarZza.zzo("audio/vnd.dts.hd");
                            zzakgVar.zzY = zztVarZza.zzO();
                        }
                    }
                }
            }
            zzakgVar.zzX.zzA(zzakgVar.zzY);
            zzakgVar.zzU = false;
            zzB();
        }
        zzahk zzahkVar = zzakgVar.zzX;
        if (!this.zzaj) {
            if (zzakgVar.zzh) {
                this.zzac &= -1073741825;
                if (!this.zzak) {
                    zzet zzetVar2 = this.zzo;
                    zzafzVar.zzc(zzetVar2.zzi(), 0, 1);
                    this.zzag++;
                    if ((zzetVar2.zzi()[0] & 128) == 128) {
                        throw zzat.zzb("Extension bit is set in signal byte", null);
                    }
                    this.zzan = zzetVar2.zzi()[0];
                    this.zzak = true;
                }
                byte b = this.zzan;
                if ((b & 1) == 1) {
                    int i6 = b & 2;
                    this.zzac |= 1073741824;
                    if (!this.zzao) {
                        zzet zzetVar3 = this.zzt;
                        zzafzVar.zzc(zzetVar3.zzi(), 0, 8);
                        this.zzag += 8;
                        this.zzao = true;
                        zzet zzetVar4 = this.zzo;
                        zzetVar4.zzi()[0] = (byte) ((i6 != 2 ? 0 : 128) | 8);
                        zzetVar4.zzh(0);
                        zzahkVar.zzd(zzetVar4, 1, 1);
                        this.zzah++;
                        zzetVar3.zzh(0);
                        zzahkVar.zzd(zzetVar3, 8, 1);
                        this.zzah += 8;
                    }
                    if (i6 == 2) {
                        if (!this.zzal) {
                            zzet zzetVar5 = this.zzo;
                            zzafzVar.zzc(zzetVar5.zzi(), 0, 1);
                            this.zzag++;
                            zzetVar5.zzh(0);
                            this.zzam = zzetVar5.zzs();
                            this.zzal = true;
                        }
                        int i7 = this.zzam * 4;
                        zzet zzetVar6 = this.zzo;
                        zzetVar6.zza(i7);
                        zzafzVar.zzc(zzetVar6.zzi(), 0, i7);
                        this.zzag += i7;
                        int i8 = (this.zzam >> 1) + 1;
                        int i9 = (i8 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzw;
                        if (byteBuffer == null || byteBuffer.capacity() < i9) {
                            this.zzw = ByteBuffer.allocate(i9);
                        }
                        this.zzw.position(0);
                        this.zzw.putShort((short) i8);
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            i2 = this.zzam;
                            if (i10 >= i2) {
                                break;
                            }
                            int iZzH = zzetVar6.zzH();
                            int i12 = iZzH - i11;
                            int i13 = i10 % 2;
                            ByteBuffer byteBuffer2 = this.zzw;
                            if (i13 == 0) {
                                byteBuffer2.putShort((short) i12);
                            } else {
                                byteBuffer2.putInt(i12);
                            }
                            i10++;
                            i11 = iZzH;
                        }
                        int i14 = (i - this.zzag) - i11;
                        int i15 = i2 & 1;
                        ByteBuffer byteBuffer3 = this.zzw;
                        if (i15 == 1) {
                            byteBuffer3.putInt(i14);
                        } else {
                            byteBuffer3.putShort((short) i14);
                            this.zzw.putInt(0);
                        }
                        zzet zzetVar7 = this.zzu;
                        zzetVar7.zzb(this.zzw.array(), i9);
                        zzahkVar.zzd(zzetVar7, i9, 1);
                        this.zzah += i9;
                    }
                }
            } else {
                byte[] bArr2 = zzakgVar.zzi;
                if (bArr2 != null) {
                    this.zzr.zzb(bArr2, bArr2.length);
                }
            }
            if (!"A_OPUS".equals(zzakgVar.zzc) ? zzakgVar.zzg > 0 : z) {
                this.zzac |= ClientDefaults.MAX_MSG_SIZE;
                this.zzv.zza(0);
                int iZze = (this.zzr.zze() + i) - this.zzag;
                zzet zzetVar8 = this.zzo;
                zzetVar8.zza(4);
                zzetVar8.zzi()[0] = (byte) ((iZze >> 24) & PHIpAddressSearchManager.END_IP_SCAN);
                zzetVar8.zzi()[1] = (byte) ((iZze >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
                zzetVar8.zzi()[2] = (byte) ((iZze >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
                zzetVar8.zzi()[3] = (byte) (iZze & PHIpAddressSearchManager.END_IP_SCAN);
                zzahkVar.zzd(zzetVar8, 4, 2);
                this.zzah += 4;
            }
            this.zzaj = true;
        }
        zzet zzetVar9 = this.zzr;
        int iZze2 = zzetVar9.zze() + i;
        String str2 = zzakgVar.zzc;
        if (!"V_MPEG4/ISO/AVC".equals(str2) && !"V_MPEGH/ISO/HEVC".equals(str2)) {
            if (zzakgVar.zzT != null) {
                zzgtj.zzi(zzetVar9.zze() == 0);
                zzakgVar.zzT.zzb(zzafzVar);
            }
            while (true) {
                int i16 = this.zzag;
                if (i16 >= iZze2) {
                    break;
                }
                int iZzy = zzy(zzafzVar, zzahkVar, iZze2 - i16);
                this.zzag += iZzy;
                this.zzah += iZzy;
            }
        } else {
            zzet zzetVar10 = this.zzn;
            byte[] bArrZzi = zzetVar10.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i17 = zzakgVar.zzZ;
            int i18 = 4 - i17;
            while (this.zzag < iZze2) {
                int i19 = this.zzai;
                if (i19 == 0) {
                    int iMin = Math.min(i17, zzetVar9.zzd());
                    zzafzVar.zzc(bArrZzi, i18 + iMin, i17 - iMin);
                    if (iMin > 0) {
                        zzetVar9.zzm(bArrZzi, i18, iMin);
                    }
                    this.zzag += i17;
                    zzetVar10.zzh(0);
                    this.zzai = zzetVar10.zzH();
                    zzet zzetVar11 = this.zzm;
                    zzetVar11.zzh(0);
                    zzahkVar.zzc(zzetVar11, 4);
                    this.zzah += 4;
                } else {
                    int iZzy2 = zzy(zzafzVar, zzahkVar, i19);
                    this.zzag += iZzy2;
                    this.zzah += iZzy2;
                    this.zzai -= iZzy2;
                }
            }
        }
        if ("A_VORBIS".equals(zzakgVar.zzc)) {
            zzet zzetVar12 = this.zzp;
            zzetVar12.zzh(0);
            zzahkVar.zzc(zzetVar12, 4);
            this.zzah += 4;
        }
        int i20 = this.zzah;
        zzv();
        return i20;
    }

    private final void zzv() {
        this.zzag = 0;
        this.zzah = 0;
        this.zzai = 0;
        this.zzaj = false;
        this.zzak = false;
        this.zzal = false;
        this.zzam = 0;
        this.zzan = (byte) 0;
        this.zzao = false;
        this.zzr.zza(0);
    }

    private final void zzw(zzafz zzafzVar, byte[] bArr, int i) {
        int length = bArr.length;
        int i2 = length + i;
        zzet zzetVar = this.zzs;
        if (zzetVar.zzj() < i2) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2 + i);
            zzetVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, zzetVar.zzi(), 0, length);
        }
        zzafzVar.zzc(zzetVar.zzi(), length, i);
        zzetVar.zzh(0);
        zzetVar.zzf(i2);
    }

    private static byte[] zzx(long j, String str, long j2) {
        zzgtj.zza(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer numValueOf = Integer.valueOf(i);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2)));
        String str3 = zzfl.zza;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    private final int zzy(zzafz zzafzVar, zzahk zzahkVar, int i) {
        zzet zzetVar = this.zzr;
        int iZzd = zzetVar.zzd();
        if (iZzd <= 0) {
            return zzahkVar.zza(zzafzVar, i, false);
        }
        int iMin = Math.min(i, iZzd);
        zzahkVar.zzc(zzetVar, iMin);
        return iMin;
    }

    private final long zzz(long j) throws zzat {
        long j2 = this.zzz;
        if (j2 != -9223372036854775807L) {
            return zzfl.zzv(j, j2, 1000L, RoundingMode.DOWN);
        }
        throw zzat.zzb("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) {
        return new zzaki().zza(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        if (this.zzk) {
            zzagbVar = new zzanm(zzagbVar, this.zzl);
        }
        this.zzap = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) {
        int i = 0;
        this.zzT = false;
        while (!this.zzT) {
            boolean zZzc = this.zzaq.zzc(zzafzVar);
            if (zZzc) {
                long jZzn = zzafzVar.zzn();
                if (this.zzP) {
                    this.zzR = jZzn;
                    zzagyVar.zza = this.zzQ;
                    this.zzP = false;
                    return 1;
                }
                if (this.zzF) {
                    long j = this.zzR;
                    if (j != -1) {
                        zzagyVar.zza = j;
                        this.zzR = -1L;
                        return 1;
                    }
                }
            }
            if (!zZzc) {
                while (true) {
                    SparseArray sparseArray = this.zzi;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzakg zzakgVar = (zzakg) sparseArray.valueAt(i);
                    zzakgVar.zzb();
                    zzahl zzahlVar = zzakgVar.zzT;
                    if (zzahlVar != null) {
                        zzahlVar.zzd(zzakgVar.zzX, zzakgVar.zzj);
                    }
                    i++;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        this.zzS = -9223372036854775807L;
        int i = 0;
        this.zzU = 0;
        this.zzaq.zzb();
        this.zzh.zza();
        zzv();
        this.zzJ = false;
        this.zzK = -9223372036854775807L;
        this.zzL = -1;
        this.zzM = -1L;
        this.zzN = -1L;
        if (!this.zzF) {
            this.zzI.clear();
        }
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i >= sparseArray.size()) {
                return;
            }
            zzahl zzahlVar = ((zzakg) sparseArray.valueAt(i)).zzT;
            if (zzahlVar != null) {
                zzahlVar.zza();
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    public final void zzh(int i, long j, long j2) throws zzat {
        zzagb zzagbVar = this.zzap;
        zzagbVar.getClass();
        if (i == 160) {
            this.zzae = false;
            this.zzaf = 0L;
            return;
        }
        if (i == 174) {
            zzakg zzakgVar = new zzakg();
            this.zzE = zzakgVar;
            zzakgVar.zza = this.zzC;
            return;
        }
        if (i == 183) {
            if (this.zzF) {
                return;
            }
            zzr(i);
            this.zzL = -1;
            this.zzM = -1L;
            this.zzN = -1L;
            return;
        }
        if (i == 187) {
            if (this.zzF) {
                return;
            }
            zzr(i);
            this.zzK = -9223372036854775807L;
            return;
        }
        if (i == 19899) {
            this.zzG = -1;
            this.zzH = -1L;
            return;
        }
        if (i == 20533) {
            zzq(i);
            this.zzE.zzh = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzy;
            if (j3 != -1 && j3 != j) {
                throw zzat.zzb("Multiple Segment elements not supported", null);
            }
            this.zzy = j;
            this.zzx = j2;
            return;
        }
        if (i == 475249515) {
            if (this.zzF) {
                return;
            }
            this.zzJ = true;
        } else if (i == 524531317 && !this.zzF) {
            if (this.zzj && this.zzQ != -1) {
                this.zzP = true;
            } else {
                zzagbVar.zzw(new zzaha(this.zzB, 0L));
                this.zzF = true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        r23 = -9223372036854775807L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
    
        r39.zzap.zzw(new com.google.android.gms.internal.ads.zzaha(r39.zzB, 0));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(int i) throws zzat {
        int i2;
        int i3;
        SparseArray sparseArray;
        long j;
        List list;
        int i4;
        long jZza;
        long jZzb;
        long jZzb2;
        long jZza2;
        zzap zzapVarZzg;
        this.zzap.getClass();
        int i5 = 2;
        long j2 = 0;
        int i6 = 0;
        if (i == 160) {
            if (this.zzU == 2) {
                zzakg zzakgVar = (zzakg) this.zzi.get(this.zzaa);
                zzakgVar.zzb();
                if (this.zzaf > 0 && "A_OPUS".equals(zzakgVar.zzc)) {
                    zzet zzetVar = this.zzv;
                    byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzaf).array();
                    zzetVar.zzb(bArrArray, bArrArray.length);
                }
                int i7 = 0;
                for (int i8 = 0; i8 < this.zzY; i8++) {
                    i7 += this.zzZ[i8];
                }
                int i9 = 0;
                while (i9 < this.zzY) {
                    long j3 = this.zzV + ((long) ((zzakgVar.zzf * i9) / 1000));
                    int i10 = this.zzac;
                    if (i9 == 0) {
                        if (!this.zzae) {
                            i10 |= 1;
                        }
                        i2 = 0;
                    } else {
                        i2 = i9;
                    }
                    int i11 = this.zzZ[i2];
                    int i12 = i7 - i11;
                    zzs(zzakgVar, j3, i10, i11, i12);
                    i9 = i2 + 1;
                    i7 = i12;
                }
                this.zzU = 0;
                return;
            }
            return;
        }
        if (i == 174) {
            zzakg zzakgVar2 = this.zzE;
            zzakgVar2.getClass();
            String str = zzakgVar2.zzc;
            if (str == null) {
                throw zzat.zzb("CodecId is missing in TrackEntry element", null);
            }
            switch (str.hashCode()) {
                case -2095576542:
                    if (str.equals("V_MPEG4/ISO/AP")) {
                        zzakgVar2.zza(zzakgVar2.zzd);
                        zzakgVar2.zzX = this.zzap.zzu(zzakgVar2.zzd, zzakgVar2.zze);
                        this.zzi.put(zzakgVar2.zzd, zzakgVar2);
                    }
                    break;
                case -2095575984:
                    if (str.equals("V_MPEG4/ISO/SP")) {
                    }
                    break;
                case -1985379776:
                    if (str.equals("A_MS/ACM")) {
                    }
                    break;
                case -1784763192:
                    if (str.equals("A_TRUEHD")) {
                    }
                    break;
                case -1730367663:
                    if (str.equals("A_VORBIS")) {
                    }
                    break;
                case -1482641358:
                    if (str.equals("A_MPEG/L2")) {
                    }
                    break;
                case -1482641357:
                    if (str.equals("A_MPEG/L3")) {
                    }
                    break;
                case -1373388978:
                    if (str.equals("V_MS/VFW/FOURCC")) {
                    }
                    break;
                case -933872740:
                    if (str.equals("S_DVBSUB")) {
                    }
                    break;
                case -538363189:
                    if (str.equals("V_MPEG4/ISO/ASP")) {
                    }
                    break;
                case -538363109:
                    if (str.equals("V_MPEG4/ISO/AVC")) {
                    }
                    break;
                case -425012669:
                    if (str.equals("S_VOBSUB")) {
                    }
                    break;
                case -356037306:
                    if (str.equals("A_DTS/LOSSLESS")) {
                    }
                    break;
                case 62923557:
                    if (str.equals("A_AAC")) {
                    }
                    break;
                case 62923603:
                    if (str.equals("A_AC3")) {
                    }
                    break;
                case 62927045:
                    if (str.equals("A_DTS")) {
                    }
                    break;
                case 82318131:
                    if (str.equals("V_AV1")) {
                    }
                    break;
                case 82338133:
                    if (str.equals("V_VP8")) {
                    }
                    break;
                case 82338134:
                    if (str.equals("V_VP9")) {
                    }
                    break;
                case 99146302:
                    if (str.equals("S_HDMV/PGS")) {
                    }
                    break;
                case 444813526:
                    if (str.equals("V_THEORA")) {
                    }
                    break;
                case 542569478:
                    if (str.equals("A_DTS/EXPRESS")) {
                    }
                    break;
                case 635596514:
                    if (str.equals("A_PCM/FLOAT/IEEE")) {
                    }
                    break;
                case 725948237:
                    if (str.equals("A_PCM/INT/BIG")) {
                    }
                    break;
                case 725957860:
                    if (str.equals("A_PCM/INT/LIT")) {
                    }
                    break;
                case 738597099:
                    if (str.equals("S_TEXT/ASS")) {
                    }
                    break;
                case 738614379:
                    if (str.equals("S_TEXT/SSA")) {
                    }
                    break;
                case 855502857:
                    if (str.equals("V_MPEGH/ISO/HEVC")) {
                    }
                    break;
                case 1045209816:
                    if (str.equals("S_TEXT/WEBVTT")) {
                    }
                    break;
                case 1422270023:
                    if (str.equals("S_TEXT/UTF8")) {
                    }
                    break;
                case 1809237540:
                    if (str.equals("V_MPEG2")) {
                    }
                    break;
                case 1950749482:
                    if (str.equals("A_EAC3")) {
                    }
                    break;
                case 1950789798:
                    if (str.equals("A_FLAC")) {
                    }
                    break;
                case 1951062397:
                    if (str.equals("A_OPUS")) {
                    }
                    break;
            }
            this.zzE = null;
            return;
        }
        if (i == 183) {
            if (this.zzF) {
                return;
            }
            zzr(i);
            if (this.zzK == -9223372036854775807L || (i3 = this.zzL) == -1 || this.zzM == -1) {
                return;
            }
            SparseArray sparseArray2 = this.zzI;
            List arrayList = (List) sparseArray2.get(i3);
            if (arrayList == null) {
                arrayList = new ArrayList();
                sparseArray2.put(this.zzL, arrayList);
            }
            arrayList.add(new zzake(this.zzK, this.zzy + this.zzM, this.zzN, null));
            return;
        }
        if (i == 19899) {
            int i13 = this.zzG;
            if (i13 != -1) {
                long j4 = this.zzH;
                if (j4 != -1) {
                    if (i13 == 475249515) {
                        this.zzQ = j4;
                        return;
                    }
                    return;
                }
            }
            throw zzat.zzb("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i == 25152) {
            zzq(i);
            zzakg zzakgVar3 = this.zzE;
            if (zzakgVar3.zzh) {
                if (zzakgVar3.zzj == null) {
                    throw zzat.zzb("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                zzakgVar3.zzl = new zzq(null, new zzp(zzg.zza, null, "video/webm", this.zzE.zzj.zzb));
                return;
            }
            return;
        }
        if (i == 28032) {
            zzq(i);
            zzakg zzakgVar4 = this.zzE;
            if (zzakgVar4.zzh && zzakgVar4.zzi != null) {
                throw zzat.zzb("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.zzz == -9223372036854775807L) {
                this.zzz = 1000000L;
            }
            long j5 = this.zzA;
            if (j5 != -9223372036854775807L) {
                this.zzB = zzz(j5);
                return;
            }
            return;
        }
        if (i == 374648427) {
            SparseArray sparseArray3 = this.zzi;
            if (sparseArray3.size() == 0) {
                throw zzat.zzb("No valid tracks were found", null);
            }
            boolean z = !this.zzj || this.zzQ == -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            for (int i18 = 0; i18 < sparseArray3.size(); i18++) {
                zzakg zzakgVar5 = (zzakg) sparseArray3.valueAt(i18);
                int i19 = zzakgVar5.zze;
                if (i19 == 2) {
                    if (zzakgVar5.zzW) {
                        i14 = zzakgVar5.zzd;
                    }
                    if (i15 == -1) {
                        i15 = zzakgVar5.zzd;
                    }
                } else if (i19 == 1) {
                    if (zzakgVar5.zzW) {
                        i16 = zzakgVar5.zzd;
                    }
                    if (i17 == -1) {
                        i17 = zzakgVar5.zzd;
                    }
                }
                if (z) {
                    zzakgVar5.zzb();
                    if (!zzakgVar5.zzU) {
                        zzahk zzahkVar = zzakgVar5.zzX;
                        zzv zzvVar = zzakgVar5.zzY;
                        zzvVar.getClass();
                        zzahkVar.zzA(zzvVar);
                    }
                }
            }
            if (i14 != -1) {
                this.zzO = i14;
            } else if (i15 != -1) {
                this.zzO = i15;
            } else if (i16 != -1) {
                this.zzO = i16;
            } else if (i17 != -1) {
                this.zzO = i17;
            } else {
                this.zzO = sparseArray3.size() > 0 ? ((zzakg) sparseArray3.valueAt(0)).zzd : -1;
            }
            if (z) {
                zzB();
                return;
            }
            return;
        }
        if (i != 475249515 || this.zzF) {
            return;
        }
        int i20 = 0;
        while (true) {
            sparseArray = this.zzI;
            if (i20 >= sparseArray.size()) {
                break;
            }
            if (((List) sparseArray.valueAt(i20)).isEmpty()) {
                i20++;
            } else {
                if (this.zzB == -9223372036854775807L) {
                    break;
                }
                for (int i21 = 0; i21 < sparseArray.size(); i21++) {
                    Collections.sort((List) sparseArray.valueAt(i21));
                }
                j = -9223372036854775807L;
                this.zzap.zzw(new zzakf(sparseArray, this.zzB, this.zzO, this.zzy, this.zzx));
            }
        }
        this.zzF = true;
        this.zzJ = false;
        int i22 = 0;
        while (true) {
            SparseArray sparseArray4 = this.zzi;
            if (i22 >= sparseArray4.size()) {
                zzB();
                return;
            }
            zzakg zzakgVar6 = (zzakg) sparseArray4.valueAt(i22);
            long j6 = this.zzB;
            long j7 = this.zzy;
            long j8 = this.zzx;
            long j9 = j2;
            if (zzakgVar6.zze != i5 || (list = (List) sparseArray.get(zzakgVar6.zzd)) == null || list.isEmpty()) {
                i4 = i6;
            } else {
                if (list.isEmpty()) {
                    i4 = i6;
                } else {
                    i4 = i6;
                    int iMin = Math.min(list.size(), 20);
                    double d = 0.0d;
                    int i23 = i4;
                    int i24 = -1;
                    while (i23 < iMin) {
                        zzake zzakeVar = (zzake) list.get(i23);
                        if (zzakeVar.zza() > 10000000) {
                            break;
                        }
                        int i25 = i23 + 1;
                        if (i23 < list.size() - 1) {
                            zzake zzakeVar2 = (zzake) list.get(i25);
                            jZzb = zzakeVar2.zzb() + zzakeVar2.zzc();
                            jZzb2 = zzakeVar.zzb() + zzakeVar.zzc();
                            jZza2 = zzakeVar2.zza() - zzakeVar.zza();
                        } else {
                            jZzb = j7 + j8;
                            jZzb2 = zzakeVar.zzb() + zzakeVar.zzc();
                            jZza2 = j6 - zzakeVar.zza();
                        }
                        long j10 = jZzb - jZzb2;
                        int i26 = iMin;
                        long j11 = j6;
                        int i27 = i23;
                        long j12 = jZza2;
                        if (j12 > j9) {
                            double d2 = j10 / j12;
                            if (d2 > d) {
                                d = d2;
                                i24 = i27;
                            }
                        }
                        iMin = i26;
                        i23 = i25;
                        j6 = j11;
                    }
                    if (i24 != -1) {
                        jZza = ((zzake) list.get(i24)).zza();
                    }
                    if (jZza != j) {
                        zzv zzvVar2 = zzakgVar6.zzY;
                        zzvVar2.getClass();
                        zzap zzapVar = zzvVar2.zzl;
                        zzaiz zzaizVar = new zzaiz(jZza);
                        if (zzapVar == null) {
                            zzao[] zzaoVarArr = new zzao[1];
                            zzaoVarArr[i4] = zzaizVar;
                            zzapVarZzg = new zzap(j, zzaoVarArr);
                        } else {
                            zzao[] zzaoVarArr2 = new zzao[1];
                            zzaoVarArr2[i4] = zzaizVar;
                            zzapVarZzg = zzapVar.zzg(zzaoVarArr2);
                        }
                        zzt zztVarZza = zzakgVar6.zzY.zza();
                        zztVarZza.zzl(zzapVarZzg);
                        zzakgVar6.zzY = zztVarZza.zzO();
                    }
                }
                jZza = j;
                if (jZza != j) {
                }
            }
            if (!zzakgVar6.zzU) {
                zzakgVar6.zzb();
                zzahk zzahkVar2 = zzakgVar6.zzX;
                zzv zzvVar3 = zzakgVar6.zzY;
                zzvVar3.getClass();
                zzahkVar2.zzA(zzvVar3);
            }
            i22++;
            j2 = j9;
            i6 = i4;
            i5 = 2;
            j = -9223372036854775807L;
        }
    }

    public final void zzj(int i, long j) throws zzat {
        boolean z;
        if (i == 240) {
            if (this.zzF) {
                return;
            }
            zzr(i);
            if (this.zzN == -1) {
                this.zzN = j;
                return;
            }
            return;
        }
        if (i == 241) {
            if (this.zzF) {
                return;
            }
            zzr(i);
            if (this.zzM == -1) {
                this.zzM = j;
                return;
            }
            return;
        }
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 35);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw zzat.zzb(sb.toString(), null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(j).length() + 35);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw zzat.zzb(sb2.toString(), null);
        }
        switch (i) {
            case 131:
                int i2 = (int) j;
                if (i2 == 1) {
                    zzq(i);
                    this.zzE.zze = 2;
                    return;
                }
                if (i2 == 2) {
                    zzq(i);
                    this.zzE.zze = 1;
                    return;
                } else if (i2 == 17) {
                    zzq(i);
                    this.zzE.zze = 3;
                    return;
                } else if (i2 != 33) {
                    zzq(i);
                    this.zzE.zze = -1;
                    return;
                } else {
                    zzq(i);
                    this.zzE.zze = 5;
                    return;
                }
            case 136:
                z = j == 1;
                zzq(i);
                this.zzE.zzW = z;
                return;
            case 155:
                this.zzW = zzz(j);
                return;
            case 159:
                zzq(i);
                this.zzE.zzO = (int) j;
                return;
            case 176:
                zzq(i);
                this.zzE.zzm = (int) j;
                return;
            case 179:
                if (this.zzF) {
                    return;
                }
                zzr(i);
                this.zzK = zzz(j);
                return;
            case 186:
                zzq(i);
                this.zzE.zzn = (int) j;
                return;
            case 215:
                zzq(i);
                this.zzE.zzd = (int) j;
                return;
            case 231:
                this.zzS = zzz(j);
                return;
            case 238:
                this.zzad = (int) j;
                return;
            case 247:
                if (this.zzF) {
                    return;
                }
                zzr(i);
                this.zzL = (int) j;
                return;
            case 251:
                this.zzae = true;
                return;
            case 16871:
                zzq(i);
                this.zzE.zzd((int) j);
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(j).length() + 30);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw zzat.zzb(sb3.toString(), null);
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(j).length() + 33);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw zzat.zzb(sb4.toString(), null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(String.valueOf(j).length() + 30);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw zzat.zzb(sb5.toString(), null);
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(String.valueOf(j).length() + 29);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw zzat.zzb(sb6.toString(), null);
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(String.valueOf(j).length() + 36);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw zzat.zzb(sb7.toString(), null);
            case 21420:
                this.zzH = j + this.zzy;
                return;
            case 21432:
                int i3 = (int) j;
                zzq(i);
                if (i3 == 0) {
                    this.zzE.zzx = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzE.zzx = 2;
                    return;
                } else if (i3 == 3) {
                    this.zzE.zzx = 1;
                    return;
                } else {
                    if (i3 != 15) {
                        return;
                    }
                    this.zzE.zzx = 3;
                    return;
                }
            case 21680:
                zzq(i);
                this.zzE.zzp = (int) j;
                return;
            case 21682:
                zzq(i);
                this.zzE.zzr = (int) j;
                return;
            case 21690:
                zzq(i);
                this.zzE.zzq = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzq(i);
                this.zzE.zzV = z;
                return;
            case 21938:
                zzq(i);
                this.zzE.zzo = (int) j;
                return;
            case 21998:
                zzq(i);
                this.zzE.zzg = (int) j;
                return;
            case 22186:
                zzq(i);
                this.zzE.zzR = j;
                return;
            case 22203:
                zzq(i);
                this.zzE.zzS = j;
                return;
            case 25188:
                zzq(i);
                this.zzE.zzP = (int) j;
                return;
            case 30114:
                this.zzaf = j;
                return;
            case 30321:
                int i4 = (int) j;
                zzq(i);
                if (i4 == 0) {
                    this.zzE.zzs = 0;
                    return;
                }
                if (i4 == 1) {
                    this.zzE.zzs = 1;
                    return;
                } else if (i4 == 2) {
                    this.zzE.zzs = 2;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.zzE.zzs = 3;
                    return;
                }
            case 2352003:
                zzq(i);
                this.zzE.zzf = (int) j;
                return;
            case 2807729:
                this.zzz = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i5 = (int) j;
                        zzq(i);
                        if (i5 == 1) {
                            this.zzE.zzA = 2;
                            return;
                        } else {
                            if (i5 != 2) {
                                return;
                            }
                            this.zzE.zzA = 1;
                            return;
                        }
                    case 21946:
                        zzq(i);
                        int iZzc = zzi.zzc((int) j);
                        if (iZzc != -1) {
                            this.zzE.zzz = iZzc;
                            return;
                        }
                        return;
                    case 21947:
                        zzq(i);
                        int iZzb = zzi.zzb((int) j);
                        if (iZzb != -1) {
                            this.zzE.zzy = iZzb;
                            return;
                        }
                        return;
                    case 21948:
                        zzq(i);
                        this.zzE.zzB = (int) j;
                        return;
                    case 21949:
                        zzq(i);
                        this.zzE.zzC = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    public final void zzk(int i, double d) throws zzat {
        if (i == 181) {
            zzq(i);
            this.zzE.zzQ = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzA = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzq(i);
                this.zzE.zzD = (float) d;
                break;
            case 21970:
                zzq(i);
                this.zzE.zzE = (float) d;
                break;
            case 21971:
                zzq(i);
                this.zzE.zzF = (float) d;
                break;
            case 21972:
                zzq(i);
                this.zzE.zzG = (float) d;
                break;
            case 21973:
                zzq(i);
                this.zzE.zzH = (float) d;
                break;
            case 21974:
                zzq(i);
                this.zzE.zzI = (float) d;
                break;
            case 21975:
                zzq(i);
                this.zzE.zzJ = (float) d;
                break;
            case 21976:
                zzq(i);
                this.zzE.zzK = (float) d;
                break;
            case 21977:
                zzq(i);
                this.zzE.zzL = (float) d;
                break;
            case 21978:
                zzq(i);
                this.zzE.zzM = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        zzq(i);
                        this.zzE.zzt = (float) d;
                        break;
                    case 30324:
                        zzq(i);
                        this.zzE.zzu = (float) d;
                        break;
                    case 30325:
                        zzq(i);
                        this.zzE.zzv = (float) d;
                        break;
                }
                break;
        }
    }

    public final void zzl(int i, String str) throws zzat {
        if (i == 134) {
            zzq(i);
            this.zzE.zzc = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                zzq(i);
                this.zzE.zzb = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                zzq(i);
                this.zzE.zze(str);
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            this.zzC = Objects.equals(str, "webm");
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 22);
        sb.append("DocType ");
        sb.append(str);
        sb.append(" not supported");
        throw zzat.zzb(sb.toString(), null);
    }

    public final void zzm(int i, int i2, zzafz zzafzVar) throws zzat {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j;
        int i10;
        int i11;
        int[] iArr;
        int i12;
        int i13;
        int i14;
        int i15 = i;
        int i16 = 2;
        int i17 = 1;
        int i18 = 0;
        if (i15 != 161 && i15 != 163) {
            if (i15 == 165) {
                if (this.zzU != 2) {
                    return;
                }
                zzakg zzakgVar = (zzakg) this.zzi.get(this.zzaa);
                if (this.zzad != 4 || !"V_VP9".equals(zzakgVar.zzc)) {
                    zzafzVar.zzf(i2);
                    return;
                }
                zzet zzetVar = this.zzv;
                zzetVar.zza(i2);
                zzafzVar.zzc(zzetVar.zzi(), 0, i2);
                return;
            }
            if (i15 == 16877) {
                zzq(i);
                zzakg zzakgVar2 = this.zzE;
                if (zzakgVar2.zzc() != 1685485123 && zzakgVar2.zzc() != 1685480259) {
                    zzafzVar.zzf(i2);
                    return;
                }
                byte[] bArr = new byte[i2];
                zzakgVar2.zzN = bArr;
                zzafzVar.zzc(bArr, 0, i2);
                return;
            }
            if (i15 == 16981) {
                zzq(i);
                byte[] bArr2 = new byte[i2];
                this.zzE.zzi = bArr2;
                zzafzVar.zzc(bArr2, 0, i2);
                return;
            }
            if (i15 == 18402) {
                byte[] bArr3 = new byte[i2];
                zzafzVar.zzc(bArr3, 0, i2);
                zzq(i);
                this.zzE.zzj = new zzahj(1, bArr3, 0, 0);
                return;
            }
            if (i15 == 21419) {
                zzet zzetVar2 = this.zzq;
                Arrays.fill(zzetVar2.zzi(), (byte) 0);
                zzafzVar.zzc(zzetVar2.zzi(), 4 - i2, i2);
                zzetVar2.zzh(0);
                this.zzG = (int) zzetVar2.zzz();
                return;
            }
            if (i15 == 25506) {
                zzq(i);
                byte[] bArr4 = new byte[i2];
                this.zzE.zzk = bArr4;
                zzafzVar.zzc(bArr4, 0, i2);
                return;
            }
            if (i15 != 30322) {
                StringBuilder sb = new StringBuilder(String.valueOf(i15).length() + 15);
                sb.append("Unexpected id: ");
                sb.append(i15);
                throw zzat.zzb(sb.toString(), null);
            }
            zzq(i);
            byte[] bArr5 = new byte[i2];
            this.zzE.zzw = bArr5;
            zzafzVar.zzc(bArr5, 0, i2);
            return;
        }
        int i19 = 8;
        if (this.zzU == 0) {
            zzakj zzakjVar = this.zzh;
            this.zzaa = (int) zzakjVar.zzb(zzafzVar, false, true, 8);
            this.zzab = zzakjVar.zzc();
            this.zzW = -9223372036854775807L;
            this.zzU = 1;
            this.zzo.zza(0);
        }
        zzakg zzakgVar3 = (zzakg) this.zzi.get(this.zzaa);
        if (zzakgVar3 == null) {
            zzafzVar.zzf(i2 - this.zzab);
            this.zzU = 0;
            return;
        }
        zzakgVar3.zzb();
        if (this.zzU == 1) {
            zzt(zzafzVar, 3);
            zzet zzetVar3 = this.zzo;
            int i20 = (zzetVar3.zzi()[2] & 6) >> 1;
            if (i20 == 0) {
                this.zzY = 1;
                int[] iArrZzA = zzA(this.zzZ, 1);
                this.zzZ = iArrZzA;
                iArrZzA[0] = (i2 - this.zzab) - 3;
            } else {
                zzt(zzafzVar, 4);
                int i21 = (zzetVar3.zzi()[3] & 255) + 1;
                this.zzY = i21;
                int[] iArrZzA2 = zzA(this.zzZ, i21);
                this.zzZ = iArrZzA2;
                if (i20 == 2) {
                    int i22 = (i2 - this.zzab) - 4;
                    int i23 = this.zzY;
                    Arrays.fill(iArrZzA2, 0, i23, i22 / i23);
                } else {
                    if (i20 != 1) {
                        if (i20 != 3) {
                            throw zzat.zzb("Unexpected lacing value: 2", null);
                        }
                        int i24 = 0;
                        int i25 = 0;
                        int i26 = 4;
                        while (true) {
                            int i27 = this.zzY - 1;
                            i4 = i18;
                            int[] iArr2 = this.zzZ;
                            if (i24 >= i27) {
                                i5 = i16;
                                i6 = i17;
                                iArr2[i27] = ((i2 - this.zzab) - i26) - i25;
                                break;
                            }
                            iArr2[i24] = i4;
                            int i28 = i26 + 1;
                            zzt(zzafzVar, i28);
                            if (zzetVar3.zzi()[i26] == 0) {
                                throw zzat.zzb("No valid varint length mask found", null);
                            }
                            int i29 = i4;
                            while (true) {
                                if (i29 >= i19) {
                                    i7 = i16;
                                    i8 = i17;
                                    i9 = i19;
                                    j = 0;
                                    i10 = i28;
                                    break;
                                }
                                i9 = i19;
                                int i30 = i17 << (7 - i29);
                                if ((zzetVar3.zzi()[i26] & i30) != 0) {
                                    int i31 = i28 + i29;
                                    zzt(zzafzVar, i31);
                                    int i32 = i26 + 1;
                                    int i33 = zzetVar3.zzi()[i26] & 255 & (~i30);
                                    int i34 = i16;
                                    j = i33;
                                    i7 = i34;
                                    int i35 = i32;
                                    while (i35 < i31) {
                                        j = (j << i9) | ((long) (zzetVar3.zzi()[i35] & 255));
                                        i17 = i17;
                                        i35++;
                                        i31 = i31;
                                    }
                                    i8 = i17;
                                    i10 = i31;
                                    if (i24 > 0) {
                                        j -= (1 << ((i29 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i29++;
                                    i19 = i9;
                                }
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int[] iArr3 = this.zzZ;
                            int i36 = (int) j;
                            if (i24 != 0) {
                                i36 += iArr3[i24 - 1];
                            }
                            iArr3[i24] = i36;
                            i25 += i36;
                            i24++;
                            i18 = i4;
                            i16 = i7;
                            i19 = i9;
                            i17 = i8;
                            i26 = i10;
                        }
                        throw zzat.zzb("EBML lacing sample size out of range.", null);
                    }
                    int i37 = 0;
                    int i38 = 0;
                    int i39 = 4;
                    while (true) {
                        i11 = this.zzY - 1;
                        iArr = this.zzZ;
                        if (i37 >= i11) {
                            break;
                        }
                        iArr[i37] = 0;
                        while (true) {
                            i12 = i39 + 1;
                            zzt(zzafzVar, i12);
                            int i40 = zzetVar3.zzi()[i39] & 255;
                            int[] iArr4 = this.zzZ;
                            i13 = iArr4[i37] + i40;
                            iArr4[i37] = i13;
                            if (i40 != 255) {
                                break;
                            } else {
                                i39 = i12;
                            }
                        }
                        i38 += i13;
                        i37++;
                        i39 = i12;
                    }
                    iArr[i11] = ((i2 - this.zzab) - i39) - i38;
                }
            }
            i5 = 2;
            i6 = 1;
            i4 = 0;
            this.zzV = this.zzS + zzz((zzetVar3.zzi()[i4] << 8) | (zzetVar3.zzi()[i6] & 255));
            if (zzakgVar3.zze == i6) {
                i14 = 1;
                this.zzac = i14;
                this.zzU = i5;
                this.zzX = i4;
                i3 = 163;
            } else {
                if (i15 != 163) {
                    i14 = i4;
                } else if ((zzetVar3.zzi()[i5] & 128) == 128) {
                    i15 = 163;
                    i14 = 1;
                } else {
                    i14 = i4;
                    i15 = 163;
                }
                this.zzac = i14;
                this.zzU = i5;
                this.zzX = i4;
                i3 = 163;
            }
        } else {
            i3 = 163;
        }
        if (i15 == i3) {
            while (true) {
                int i41 = this.zzX;
                if (i41 >= this.zzY) {
                    this.zzU = 0;
                    return;
                }
                int iZzu = zzu(zzafzVar, zzakgVar3, this.zzZ[i41], false);
                zzakg zzakgVar4 = zzakgVar3;
                zzs(zzakgVar4, this.zzV + ((long) ((this.zzX * zzakgVar3.zzf) / 1000)), this.zzac, iZzu, 0);
                this.zzX++;
                zzakgVar3 = zzakgVar4;
            }
        } else {
            while (true) {
                int i42 = this.zzX;
                if (i42 >= this.zzY) {
                    return;
                }
                int[] iArr5 = this.zzZ;
                iArr5[i42] = zzu(zzafzVar, zzakgVar3, iArr5[i42], true);
                this.zzX++;
            }
        }
    }

    @Deprecated
    public zzakh() {
        this(new zzaka(), 2, zzanj.zza);
    }

    public zzakh(zzanj zzanjVar, int i) {
        this(new zzaka(), 0, zzanjVar);
    }
}
