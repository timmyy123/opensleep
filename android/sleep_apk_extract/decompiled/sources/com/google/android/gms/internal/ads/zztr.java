package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zztr implements zzse {
    private static final AtomicInteger zza = new AtomicInteger();
    private long zzA;
    private long zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private long zzF;
    private float zzG;
    private ByteBuffer zzH;
    private int zzI;
    private ByteBuffer zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private boolean zzP;
    private zze zzQ;
    private AudioDeviceInfo zzR;
    private int zzS;
    private long zzT;
    private boolean zzU;
    private boolean zzV;
    private long zzW;
    private long zzX;
    private Handler zzY;
    private final zztm zzZ;
    private final Context zzb;
    private final zztg zzc;
    private final zzud zzd;
    private final zzcv zze;
    private final zzuc zzf;
    private final zzgwm zzg;
    private final ArrayDeque zzh;
    private zzti zzi;
    private final zztq zzj;
    private final zztq zzk;
    private zzqf zzl;
    private zzsb zzm;
    private zztl zzn;
    private zztl zzo;
    private zzck zzp;
    private final zzrf zzq;
    private zzrc zzr;
    private zzqv zzs;
    private zzd zzt;
    private zztp zzu;
    private zztp zzv;
    private zzav zzw;
    private boolean zzx;
    private long zzy;
    private long zzz;

    public /* synthetic */ zztr(zztk zztkVar, byte[] bArr) {
        this.zzb = zztkVar.zzb() == null ? null : zztkVar.zzb().getApplicationContext();
        this.zzt = zzd.zza;
        this.zzZ = zztkVar.zzd();
        this.zzq = zztkVar.zzc();
        zztg zztgVar = new zztg();
        this.zzc = zztgVar;
        zzud zzudVar = new zzud();
        this.zzd = zzudVar;
        this.zze = new zzcv();
        this.zzf = new zzuc();
        this.zzg = zzgwm.zzk(zzudVar, zztgVar);
        this.zzG = 1.0f;
        this.zzO = 0;
        this.zzQ = new zze(0, 0.0f);
        zzav zzavVar = zzav.zza;
        this.zzv = new zztp(zzavVar, 0L, 0L, null);
        this.zzw = zzavVar;
        this.zzx = false;
        this.zzh = new ArrayDeque();
        this.zzj = new zztq();
        this.zzk = new zztq();
        int iZzah = -1;
        if (Build.VERSION.SDK_INT >= 34 && zztkVar.zzb() != null) {
            iZzah = zzah(zztkVar.zzb().getDeviceId());
        }
        this.zzS = iZzah;
    }

    public static int zzE(int i, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        byte b;
        int i4;
        int i5;
        if (i == 20) {
            return zzgv.zzb(byteBuffer);
        }
        if (i != 30) {
            switch (i) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int iZzb = zzagw.zzb(zzfl.zzM(byteBuffer, byteBuffer.position()));
                    if (iZzb != -1) {
                        return iZzb;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3();
                    return 0;
                case 10:
                    return 1024;
                case 11:
                case 12:
                    return 2048;
                default:
                    switch (i) {
                        case 14:
                            int iPosition = byteBuffer.position();
                            int iLimit = byteBuffer.limit() - 10;
                            int i6 = iPosition;
                            while (true) {
                                if (i6 > iLimit) {
                                    i5 = -1;
                                } else if ((zzfl.zzM(byteBuffer, i6 + 4) & (-2)) == -126718022) {
                                    i5 = i6 - iPosition;
                                } else {
                                    i6++;
                                }
                            }
                            if (i5 == -1) {
                                return 0;
                            }
                            return (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            byte[] bArr = new byte[16];
                            int iPosition2 = byteBuffer.position();
                            byteBuffer.get(bArr);
                            byteBuffer.position(iPosition2);
                            return zzafb.zzb(new zzes(bArr, 16)).zzc;
                        case 18:
                            break;
                        default:
                            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(i, "Unexpected audio encoding: ", new StringBuilder(String.valueOf(i).length() + 27)));
                            return 0;
                    }
                    break;
            }
            return zzaey.zze(byteBuffer);
        }
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return 4096;
        }
        int iPosition3 = byteBuffer.position();
        byte b2 = byteBuffer.get(iPosition3);
        if (b2 != -2) {
            if (b2 == -1) {
                i3 = (byteBuffer.get(iPosition3 + 4) & 7) << 4;
                b = byteBuffer.get(iPosition3 + 7);
            } else if (b2 != 31) {
                i3 = (byteBuffer.get(iPosition3 + 4) & 1) << 6;
                i4 = byteBuffer.get(iPosition3 + 5) & 252;
                i2 = (i4 >> 2) | i3;
            } else {
                i3 = (byteBuffer.get(iPosition3 + 5) & 7) << 4;
                b = byteBuffer.get(iPosition3 + 6);
            }
            i4 = b & 60;
            i2 = (i4 >> 2) | i3;
        } else {
            i2 = ((byteBuffer.get(iPosition3 + 5) & 1) << 6) | ((byteBuffer.get(iPosition3 + 4) & 252) >> 2);
        }
        return (i2 + 1) * 32;
    }

    public static /* synthetic */ boolean zzH() {
        return zza.get() > 0;
    }

    private final void zzR() {
        zzck zzckVarZzk = this.zzo.zzk();
        this.zzp = zzckVarZzk;
        zzckVarZzk.zzb(zzcm.zza);
    }

    private final zzqv zzS(zzre zzreVar) throws zzsa {
        try {
            return ((zztd) this.zzq).zzf(zzreVar);
        } catch (zzrb e) {
            zzsa zzsaVar = new zzsa(0, zzreVar.zzb, zzreVar.zzc, zzreVar.zza, zzreVar.zze, this.zzo.zzf(), false, e);
            zzsb zzsbVar = this.zzm;
            if (zzsbVar == null) {
                throw zzsaVar;
            }
            zzsbVar.zza(zzsaVar);
            throw zzsaVar;
        }
    }

    private final void zzT(long j) throws zzsd {
        zzW(j);
        if (this.zzJ != null) {
            return;
        }
        if (!this.zzp.zzc()) {
            ByteBuffer byteBuffer = this.zzH;
            if (byteBuffer != null) {
                zzV(byteBuffer);
                zzW(j);
                return;
            }
            return;
        }
        while (!this.zzp.zzg()) {
            do {
                ByteBuffer byteBufferZze = this.zzp.zze();
                if (byteBufferZze.hasRemaining()) {
                    zzV(byteBufferZze);
                    zzW(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzH;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzp.zzd(this.zzH);
                    }
                }
            } while (this.zzJ == null);
            return;
        }
    }

    private final boolean zzU() throws zzsd {
        if (!this.zzp.zzc()) {
            zzW(Long.MIN_VALUE);
            return this.zzJ == null;
        }
        this.zzp.zzf();
        zzT(Long.MIN_VALUE);
        if (!this.zzp.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzJ;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0239 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzV(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        zzgtj.zzi(this.zzJ == null);
        if (byteBuffer.hasRemaining()) {
            if (this.zzo.zze()) {
                int iZzu = (int) zzfl.zzu(zzfl.zzs(20L), this.zzo.zzj().zzb);
                long jZzae = zzae();
                long j = iZzu;
                if (jZzae < j) {
                    int i9 = this.zzo.zzj().zza;
                    int iZzi = this.zzo.zzi();
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
                    int iPosition = byteBuffer.position();
                    int i10 = (int) jZzae;
                    while (byteBuffer.hasRemaining() && i10 < iZzu) {
                        if (i9 != 2) {
                            if (i9 == 3) {
                                i3 = (byteBuffer.get() & 255) << 24;
                            } else if (i9 != 4) {
                                if (i9 != 21) {
                                    if (i9 == 22) {
                                        int i11 = byteBuffer.get() & 255;
                                        int i12 = (byteBuffer.get() & 255) << 8;
                                        int i13 = (byteBuffer.get() & 255) << 16;
                                        i7 = (byteBuffer.get() & 255) << 24;
                                        i8 = i11 | i12 | i13;
                                    } else if (i9 == 268435456) {
                                        i = (byteBuffer.get() & 255) << 24;
                                        i2 = (byteBuffer.get() & 255) << 16;
                                    } else if (i9 == 1342177280) {
                                        i4 = (byteBuffer.get() & 255) << 24;
                                        i5 = (byteBuffer.get() & 255) << 16;
                                        i6 = (byteBuffer.get() & 255) << 8;
                                    } else if (i9 == 1610612736) {
                                        int i14 = (byteBuffer.get() & 255) << 24;
                                        int i15 = (byteBuffer.get() & 255) << 16;
                                        int i16 = (byteBuffer.get() & 255) << 8;
                                        i7 = byteBuffer.get() & 255;
                                        i8 = i16 | i14 | i15;
                                    } else if (i9 != 1879048192) {
                                        Home$$ExternalSyntheticBUOutline0.m$2();
                                        return;
                                    } else {
                                        double dZzm = zzfl.zzm(byteBuffer.getDouble(), -1.0d, 1.0d);
                                        i3 = (int) (dZzm < 0.0d ? (-dZzm) * (-2.147483648E9d) : dZzm * 2.147483647E9d);
                                    }
                                    i3 = i8 | i7;
                                } else {
                                    i4 = (byteBuffer.get() & 255) << 8;
                                    i5 = (byteBuffer.get() & 255) << 16;
                                    i6 = (byteBuffer.get() & 255) << 24;
                                }
                                i3 = i4 | i5 | i6;
                            } else {
                                float fMax = Math.max(-1.0f, Math.min(byteBuffer.getFloat(), 1.0f));
                                i3 = (int) (fMax < 0.0f ? (-fMax) * (-2.1474836E9f) : fMax * 2.1474836E9f);
                            }
                            int i17 = (int) ((((long) i3) * ((long) i10)) / j);
                            if (i9 != 2) {
                                byteBufferOrder.put((byte) (i17 >> 16));
                                byteBufferOrder.put((byte) (i17 >> 24));
                            } else if (i9 == 3) {
                                byteBufferOrder.put((byte) (i17 >> 24));
                            } else if (i9 != 4) {
                                if (i9 == 21) {
                                    byteBufferOrder.put((byte) (i17 >> 8));
                                    byteBufferOrder.put((byte) (i17 >> 16));
                                    byteBufferOrder.put((byte) (i17 >> 24));
                                } else if (i9 == 22) {
                                    byteBufferOrder.put((byte) i17);
                                    byteBufferOrder.put((byte) (i17 >> 8));
                                    byteBufferOrder.put((byte) (i17 >> 16));
                                    byteBufferOrder.put((byte) (i17 >> 24));
                                } else if (i9 == 268435456) {
                                    byteBufferOrder.put((byte) (i17 >> 24));
                                    byteBufferOrder.put((byte) (i17 >> 16));
                                } else if (i9 == 1342177280) {
                                    byteBufferOrder.put((byte) (i17 >> 24));
                                    byteBufferOrder.put((byte) (i17 >> 16));
                                    byteBufferOrder.put((byte) (i17 >> 8));
                                } else if (i9 == 1610612736) {
                                    byteBufferOrder.put((byte) (i17 >> 24));
                                    byteBufferOrder.put((byte) (i17 >> 16));
                                    byteBufferOrder.put((byte) (i17 >> 8));
                                    byteBufferOrder.put((byte) i17);
                                } else if (i9 != 1879048192) {
                                    Home$$ExternalSyntheticBUOutline0.m$2();
                                    return;
                                } else if (i17 < 0) {
                                    byteBufferOrder.putDouble((-i17) / (-2.147483648E9d));
                                } else {
                                    byteBufferOrder.putDouble(((double) i17) / 2.147483647E9d);
                                }
                            } else if (i17 < 0) {
                                byteBufferOrder.putFloat((-i17) / (-2.1474836E9f));
                            } else {
                                byteBufferOrder.putFloat(i17 / 2.1474836E9f);
                            }
                            if (byteBuffer.position() != iPosition + iZzi) {
                                i10++;
                                iPosition = byteBuffer.position();
                            }
                        } else {
                            i = (byteBuffer.get() & 255) << 16;
                            i2 = (byteBuffer.get() & 255) << 24;
                        }
                        i3 = i2 | i;
                        int i172 = (int) ((((long) i3) * ((long) i10)) / j);
                        if (i9 != 2) {
                        }
                        if (byteBuffer.position() != iPosition + iZzi) {
                        }
                    }
                    byteBufferOrder.put(byteBuffer);
                    byteBufferOrder.flip();
                    byteBuffer2 = byteBufferOrder;
                } else {
                    byteBuffer2 = byteBuffer;
                }
            }
            this.zzJ = byteBuffer2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzW(long j) throws zzsd {
        zzsb zzsbVar;
        if (this.zzJ == null || this.zzk.zzb()) {
            return;
        }
        int iRemaining = this.zzJ.remaining();
        try {
            boolean zZzc = this.zzs.zzc(this.zzJ, this.zzI, j);
            this.zzT = SystemClock.elapsedRealtime();
            this.zzk.zzc();
            if (this.zzs.zzg()) {
                if (this.zzB > 0) {
                    this.zzV = false;
                }
                if (this.zzN && (zzsbVar = this.zzm) != null && !zZzc) {
                }
            }
            if (this.zzo.zze()) {
                this.zzA += (long) (iRemaining - this.zzJ.remaining());
            }
            if (zZzc) {
                if (!this.zzo.zze()) {
                    zzgtj.zzi(this.zzJ == this.zzH);
                    this.zzB = (((long) this.zzC) * ((long) this.zzI)) + this.zzB;
                }
                this.zzJ = null;
            }
        } catch (zzqu e) {
            boolean z = e.zzb;
            if (!z) {
                z = false;
            } else if (zzae() <= 0) {
                if (this.zzs.zzg()) {
                    zzX();
                }
            }
            zzsd zzsdVar = new zzsd(e.zza, this.zzo.zzf(), z);
            zzsb zzsbVar2 = this.zzm;
            if (zzsbVar2 != null) {
                zzsbVar2.zza(zzsdVar);
            }
            if (z) {
                throw zzsdVar;
            }
            this.zzk.zza(zzsdVar);
        }
    }

    private final void zzX() {
        this.zzo.zzj();
    }

    private final void zzY() {
        if (zzad()) {
            this.zzs.zzf(this.zzG);
        }
    }

    private final void zzZ() {
        if (this.zzo != null) {
            zztl zztlVar = this.zzn;
            if (zztlVar != null) {
                this.zzo = zztlVar;
                this.zzn = null;
            }
            try {
                this.zzo = new zztl(this.zzo.zzf(), this.zzo.zzg(), this.zzo.zzh(), this.zzo.zzi(), this.zzq.zzb(zzaf(this.zzo.zzg(), -1)), this.zzo.zzk(), null);
            } catch (zzqw e) {
                Events$$ExternalSyntheticBUOutline0.m(new zzrz(e, this.zzo.zzf()));
                return;
            }
        }
        zzB();
    }

    private final void zzaa(zzav zzavVar) {
        zztp zztpVar = new zztp(zzavVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzad()) {
            this.zzu = zztpVar;
        } else {
            this.zzv = zztpVar;
        }
    }

    private final void zzab(long j) {
        zzav zzavVar;
        boolean z;
        if (zzac()) {
            zztm zztmVar = this.zzZ;
            zzavVar = this.zzw;
            zztmVar.zzb(zzavVar);
        } else {
            zzavVar = zzav.zza;
        }
        zzav zzavVar2 = zzavVar;
        this.zzw = zzavVar2;
        if (zzac()) {
            zztm zztmVar2 = this.zzZ;
            z = this.zzx;
            zztmVar2.zzc(z);
        } else {
            z = false;
        }
        this.zzx = z;
        this.zzh.add(new zztp(zzavVar2, Math.max(0L, j), this.zzo.zzc(zzae()), null));
        zzR();
        zzsb zzsbVar = this.zzm;
        if (zzsbVar != null) {
            ((zztw) zzsbVar).zza.zzaz().zzh(this.zzx);
        }
    }

    private final boolean zzac() {
        if (!this.zzo.zze()) {
            return false;
        }
        int i = this.zzo.zzf().zzJ;
        return true;
    }

    private final boolean zzad() {
        return this.zzs != null;
    }

    private final long zzae() {
        if (!this.zzo.zze()) {
            return this.zzB;
        }
        long j = this.zzA;
        long jZzi = this.zzo.zzi();
        String str = zzfl.zza;
        return ((j + jZzi) - 1) / jZzi;
    }

    private final zzqy zzaf(zzv zzvVar, int i) {
        zzqx zzqxVar = new zzqx(zzvVar);
        zzqxVar.zza(this.zzt);
        zzqxVar.zzb(this.zzR);
        zzqxVar.zzc(this.zzO);
        zzqxVar.zze(-1);
        zzqxVar.zzd(this.zzS);
        return new zzqy(zzqxVar, null);
    }

    private final void zzag() {
        if (this.zzL) {
            return;
        }
        this.zzL = true;
        if (this.zzs.zzg()) {
            this.zzM = false;
        }
        this.zzs.zzd();
    }

    private static int zzah(int i) {
        if (i == 0 || i == -1) {
            return -1;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzA() {
        this.zzN = false;
        if (zzad()) {
            this.zzs.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzB() {
        if (zzad()) {
            this.zzy = 0L;
            this.zzz = 0L;
            this.zzA = 0L;
            this.zzB = 0L;
            this.zzV = false;
            this.zzC = 0;
            this.zzv = new zztp(this.zzw, 0L, 0L, null);
            this.zzF = 0L;
            this.zzu = null;
            this.zzh.clear();
            this.zzH = null;
            this.zzI = 0;
            this.zzJ = null;
            this.zzL = false;
            this.zzK = false;
            this.zzM = false;
            this.zzd.zzr();
            zzR();
            this.zzi = null;
            zztl zztlVar = this.zzn;
            if (zztlVar != null) {
                this.zzo = zztlVar;
                this.zzn = null;
            }
            zza.incrementAndGet();
            this.zzs.zze();
            this.zzs = null;
        }
        this.zzk.zzc();
        this.zzj.zzc();
        this.zzW = 0L;
        this.zzX = 0L;
        Handler handler = this.zzY;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzC() {
        zzB();
        zzgwm zzgwmVar = this.zzg;
        int size = zzgwmVar.size();
        for (int i = 0; i < size; i++) {
            ((zzco) zzgwmVar.get(i)).zzj();
        }
        this.zze.zzj();
        this.zzf.zzj();
        zzck zzckVar = this.zzp;
        if (zzckVar != null) {
            zzckVar.zzh();
        }
        this.zzN = false;
        this.zzU = false;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzD() {
        this.zzq.zze();
    }

    public final /* synthetic */ void zzF() {
        if (this.zzX >= 300000) {
            ((zztw) this.zzm).zza.zzaB(true);
            this.zzX = 0L;
        }
    }

    public final /* synthetic */ void zzG() {
        zzsb zzsbVar = this.zzm;
        if (zzsbVar != null) {
            ((zztw) zzsbVar).zza.zzT();
        }
    }

    public final /* synthetic */ zzti zzJ() {
        return this.zzi;
    }

    public final /* synthetic */ zzsb zzK() {
        return this.zzm;
    }

    public final /* synthetic */ zztl zzL() {
        return this.zzo;
    }

    public final /* synthetic */ zzqv zzM() {
        return this.zzs;
    }

    public final /* synthetic */ boolean zzN() {
        return this.zzL;
    }

    public final /* synthetic */ void zzO(boolean z) {
        this.zzM = true;
    }

    public final /* synthetic */ boolean zzP() {
        return this.zzN;
    }

    public final /* synthetic */ long zzQ() {
        return this.zzT;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zza(zzsb zzsbVar) {
        this.zzm = zzsbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzb(zzqf zzqfVar) {
        this.zzl = zzqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzc(zzdo zzdoVar) {
        this.zzq.zzd(zzdoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzd(zzv zzvVar) {
        return zze(zzvVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final int zze(zzv zzvVar) {
        boolean z;
        int i = zzvVar.zzJ;
        if (!zzfl.zzD(i) || i == 2) {
            z = false;
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzI(2);
            zzvVar = zztVarZza.zzO();
            z = true;
        }
        int i2 = this.zzq.zza(zzaf(zzvVar, -1)).zzd;
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 2) {
            return 0;
        }
        return z ? 1 : 2;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzqs zzf(zzv zzvVar) {
        if (this.zzU) {
            return zzqs.zza;
        }
        zzra zzraVarZza = this.zzq.zza(zzaf(zzvVar, -1));
        zzqr zzqrVar = new zzqr();
        zzqrVar.zza(zzraVarZza.zza);
        zzqrVar.zzb(zzraVarZza.zzb);
        zzqrVar.zzc(zzraVarZza.zzc);
        return zzqrVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final long zzg(boolean z) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzad() || this.zzE) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzs.zzk(), this.zzo.zzc(zzae()));
        while (true) {
            arrayDeque = this.zzh;
            if (arrayDeque.isEmpty() || jMin < ((zztp) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzv = (zztp) arrayDeque.remove();
        }
        zztp zztpVar = this.zzv;
        long j2 = jMin - zztpVar.zzc;
        long jZzx = zzfl.zzx(j2, zztpVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZzd = this.zzZ.zzd(j2);
            zztp zztpVar2 = this.zzv;
            j = zztpVar2.zzb + jZzd;
            zztpVar2.zzd = jZzd - jZzx;
        } else {
            zztp zztpVar3 = this.zzv;
            j = zztpVar3.zzb + jZzx + zztpVar3.zzd;
        }
        long jZze = this.zzZ.zze();
        long jZzc = j + this.zzo.zzc(jZze);
        long j3 = this.zzW;
        if (jZze > j3) {
            long jZzc2 = this.zzo.zzc(jZze - j3);
            this.zzW = jZze;
            this.zzX += jZzc2;
            if (this.zzY == null) {
                this.zzY = new Handler(Looper.myLooper());
            }
            this.zzY.removeCallbacksAndMessages(null);
            this.zzY.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzto
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzF();
                }
            }, 100L);
        }
        return jZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzh(zzrx zzrxVar) throws zzrz {
        int i;
        zzv zzvVarZzO;
        zzck zzckVar;
        int iZzG;
        if (this.zzr == null && this.zzb != null) {
            zzrc zzrcVar = new zzrc() { // from class: com.google.android.gms.internal.ads.zztn
                @Override // com.google.android.gms.internal.ads.zzrc
                public final /* synthetic */ void zza() {
                    this.zza.zzG();
                }
            };
            this.zzr = zzrcVar;
            this.zzq.zzc(zzrcVar);
        }
        zzv zzvVar = zzrxVar.zza;
        if ("audio/raw".equals(zzvVar.zzp)) {
            int i2 = zzvVar.zzJ;
            zzgtj.zza(zzfl.zzD(i2));
            int i3 = zzvVar.zzH;
            int iZzG2 = zzfl.zzG(i2) * i3;
            zzgwj zzgwjVar = new zzgwj();
            zzgwjVar.zzh(this.zzg);
            zzgwjVar.zzf(this.zze);
            zzgwjVar.zzg(this.zzZ.zza());
            zzck zzckVar2 = new zzck(zzgwjVar.zzi());
            if (zzckVar2.equals(this.zzp)) {
                zzckVar2 = this.zzp;
            }
            this.zzd.zzq(zzvVar.zzK, zzvVar.zzL);
            this.zzc.zzq(zzrxVar.zzc);
            try {
                zzcl zzclVarZza = zzckVar2.zza(new zzcl(zzvVar.zzI, i3, i2));
                zzt zztVarZza = zzvVar.zza();
                int i4 = zzclVarZza.zzd;
                zztVarZza.zzI(i4);
                zztVarZza.zzH(zzclVarZza.zzb);
                int i5 = zzclVarZza.zzc;
                zztVarZza.zzG(i5);
                i = iZzG2;
                zzckVar = zzckVar2;
                zzvVarZzO = zztVarZza.zzO();
                iZzG = zzfl.zzG(i4) * i5;
            } catch (zzcn e) {
                throw new zzrz(e, zzvVar);
            }
        } else {
            i = -1;
            zzvVarZzO = zzvVar;
            zzckVar = new zzck(zzgwm.zzi());
            iZzG = -1;
        }
        zzqy zzqyVarZzaf = zzaf(zzvVarZzO, -1);
        try {
            zzre zzreVarZzb = this.zzq.zzb(zzqyVarZzaf);
            if (zzreVarZzb.zza == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(false).length() + 36);
                sb.append("Invalid output encoding (isOffload=false)");
                throw new zzrz(sb.toString(), zzqyVarZzaf.zza);
            }
            if (zzreVarZzb.zzc == 0) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(false).length() + 42);
                sb2.append("Invalid output channel config (isOffload=false)");
                throw new zzrz(sb2.toString(), zzqyVarZzaf.zza);
            }
            this.zzU = false;
            zztl zztlVar = new zztl(zzvVar, zzvVarZzO, i, iZzG, zzreVarZzb, zzckVar, null);
            if (zzad()) {
                this.zzn = zztlVar;
            } else {
                this.zzo = zztlVar;
            }
        } catch (zzqw e2) {
            throw new zzrz(e2, zzvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzi() {
        this.zzN = true;
        if (zzad()) {
            this.zzs.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzj() {
        this.zzD = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    @Override // com.google.android.gms.internal.ads.zzse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzk(ByteBuffer byteBuffer, long j, int i) throws zzsd {
        zzqv zzqvVarZzS;
        long j2;
        long jZzh;
        ByteBuffer byteBuffer2 = this.zzH;
        zzgtj.zza(byteBuffer2 == null || byteBuffer == byteBuffer2);
        byte[] bArr = null;
        if (this.zzn != null) {
            if (!zzU()) {
                return false;
            }
            if (this.zzs != null) {
                zzre zzreVarZzj = this.zzo.zzj();
                zzaf(this.zzn.zzg(), -1);
                if (this.zzn.zzj().equals(zzreVarZzj)) {
                    this.zzo = this.zzn;
                    this.zzn = null;
                    zzqv zzqvVar = this.zzs;
                    if (zzqvVar != null && zzqvVar.zzg()) {
                        this.zzo.zzj();
                    }
                } else {
                    zzag();
                    if (zzn()) {
                        return false;
                    }
                    zzB();
                }
                zzab(j);
            }
        }
        if (!zzad()) {
            try {
                if (this.zzj.zzb()) {
                    return false;
                }
                try {
                    zzqvVarZzS = zzS(this.zzo.zzj());
                } catch (zzsa e) {
                    int i2 = this.zzo.zzj().zze;
                    while (i2 > 1000000) {
                        int i3 = i2 >> 1;
                        int iZzi = this.zzo.zzi() != -1 ? this.zzo.zzi() : 1;
                        int i4 = i3 % iZzi;
                        int i5 = i4 != 0 ? (iZzi - i4) + i3 : i3;
                        zzrd zzrdVar = new zzrd(this.zzo.zzj(), null);
                        zzrdVar.zze(i5);
                        zzre zzreVar = new zzre(zzrdVar, null);
                        try {
                            zzqv zzqvVarZzS2 = zzS(zzreVar);
                            this.zzo = this.zzo.zza(zzreVar);
                            zzqvVarZzS = zzqvVarZzS2;
                        } catch (zzsa e2) {
                            e.addSuppressed(e2);
                            i2 = i5;
                        }
                    }
                    zzX();
                    throw e;
                }
                this.zzs = zzqvVarZzS;
                zzti zztiVar = new zzti(this, this.zzo.zzj(), bArr);
                this.zzi = zztiVar;
                this.zzs.zzm(zztiVar);
                if (this.zzs.zzg()) {
                    this.zzo.zzj();
                }
                zzqf zzqfVar = this.zzl;
                if (zzqfVar != null) {
                    this.zzs.zzn(zzqfVar);
                }
                zzY();
                int i6 = this.zzQ.zza;
                AudioDeviceInfo audioDeviceInfo = this.zzR;
                if (audioDeviceInfo != null) {
                    this.zzs.zzo(audioDeviceInfo);
                }
                this.zzE = true;
                int iZzh = this.zzs.zzh();
                int i7 = this.zzO;
                this.zzO = iZzh;
                zzsb zzsbVar = this.zzm;
                if (zzsbVar != null) {
                    ((zztw) zzsbVar).zza.zzaz().zzk(this.zzo.zzd());
                    if (iZzh != i7) {
                        this.zzP = true;
                        zztl zztlVar = this.zzo;
                        zzrd zzrdVar2 = new zzrd(zztlVar.zzj(), null);
                        zzrdVar2.zzg(this.zzO);
                        this.zzo = zztlVar.zza(new zzre(zzrdVar2, null));
                        zztl zztlVar2 = this.zzn;
                        if (zztlVar2 != null) {
                            zzrd zzrdVar3 = new zzrd(zztlVar2.zzj(), null);
                            zzrdVar3.zzg(this.zzO);
                            this.zzn = zztlVar2.zza(new zzre(zzrdVar3, null));
                        }
                        zzsb zzsbVar2 = this.zzm;
                        int i8 = this.zzO;
                        if (Build.VERSION.SDK_INT >= 35) {
                            zztx zztxVar = ((zztw) zzsbVar2).zza;
                            if (zztxVar.zzaA() != null) {
                                zztxVar.zzaA().zza(i8);
                            }
                        }
                        ((zztw) zzsbVar2).zza.zzaz().zzm(i8);
                    }
                }
            } catch (zzsa e3) {
                this.zzj.zza(e3);
                return false;
            }
        }
        this.zzj.zzc();
        if (this.zzE) {
            this.zzF = Math.max(0L, j);
            this.zzD = false;
            this.zzE = false;
            zzab(j);
            if (this.zzN) {
                zzi();
            }
        }
        if (this.zzH == null) {
            zzgtj.zza(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.zzo.zze() && this.zzC == 0) {
                int iZzE = zzE(this.zzo.zzj().zza, byteBuffer);
                this.zzC = iZzE;
                if (iZzE == 0) {
                    return true;
                }
            }
            if (this.zzu != null) {
                if (!zzU()) {
                    return false;
                }
                zzab(j);
                this.zzu = null;
            }
            long j3 = this.zzF;
            zztl zztlVar3 = this.zzo;
            if (zztlVar3.zze()) {
                j2 = 0;
                jZzh = this.zzy / ((long) this.zzo.zzh());
            } else {
                j2 = 0;
                jZzh = this.zzz;
            }
            long jZzb = j3 + zztlVar3.zzb(jZzh - this.zzd.zzs());
            if (!this.zzD && Math.abs(jZzb - j) > 200000) {
                zzsb zzsbVar3 = this.zzm;
                if (zzsbVar3 != null) {
                    zzsbVar3.zza(new zzsc(j, jZzb));
                }
                this.zzD = true;
            }
            if (this.zzD) {
                if (!zzU()) {
                    return false;
                }
                long j4 = j - jZzb;
                this.zzF += j4;
                this.zzD = false;
                zzab(j);
                zzsb zzsbVar4 = this.zzm;
                if (zzsbVar4 != null && j4 != j2) {
                    ((zztw) zzsbVar4).zza.zzaq();
                }
            }
            if (this.zzo.zze()) {
                this.zzy += (long) byteBuffer.remaining();
            } else {
                this.zzz = (((long) this.zzC) * ((long) i)) + this.zzz;
            }
            this.zzH = byteBuffer;
            this.zzI = i;
        }
        zzT(j);
        if (!this.zzH.hasRemaining()) {
            this.zzH = null;
            this.zzI = 0;
            return true;
        }
        if (!this.zzs.zzl()) {
            return false;
        }
        zzeg.zzc("DefaultAudioSink", "Resetting stalled audio output");
        zzB();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzl() {
        if (!this.zzK && zzad() && zzU()) {
            zzag();
            this.zzK = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzm() {
        if (zzad()) {
            return this.zzK && !zzn();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzn() {
        if (!zzad()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && this.zzs.zzg() && this.zzM) {
            return false;
        }
        long jZzae = zzae();
        long jZzk = this.zzs.zzk();
        zzqv zzqvVar = this.zzs;
        zzqvVar.getClass();
        return jZzae > zzfl.zzu(jZzk, zzqvVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzo(zzav zzavVar) {
        float f = zzavVar.zzb;
        String str = zzfl.zza;
        zzav zzavVar2 = new zzav(Math.max(0.1f, Math.min(f, 8.0f)), Math.max(0.1f, Math.min(zzavVar.zzc, 8.0f)));
        this.zzw = zzavVar2;
        zzaa(zzavVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzav zzp() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzq(boolean z) {
        this.zzx = z;
        zzaa(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzr(zzd zzdVar) {
        if (this.zzt.equals(zzdVar)) {
            return;
        }
        this.zzt = zzdVar;
        zzZ();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzqh zzs() {
        zzrf zzrfVar = this.zzq;
        if (zzrfVar instanceof zztd) {
            return ((zztd) zzrfVar).zzg();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzt(int i) {
        if (this.zzP) {
            if (this.zzO != i) {
                return;
            } else {
                this.zzP = false;
            }
        }
        if (this.zzO != i) {
            this.zzO = i;
            zzZ();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzu(zze zzeVar) {
        if (this.zzQ.equals(zzeVar)) {
            return;
        }
        if (this.zzs != null) {
            int i = this.zzQ.zza;
        }
        this.zzQ = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzv(AudioDeviceInfo audioDeviceInfo) {
        this.zzR = audioDeviceInfo;
        zzqv zzqvVar = this.zzs;
        if (zzqvVar != null) {
            zzqvVar.zzo(audioDeviceInfo);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzw(int i) {
        int i2 = this.zzS;
        int iZzah = zzah(i);
        if (i2 == iZzah) {
            return;
        }
        this.zzS = iZzah;
        zzZ();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final long zzx() {
        if (!zzad()) {
            return -9223372036854775807L;
        }
        if (this.zzo.zze()) {
            return this.zzo.zzc(this.zzs.zzj());
        }
        long jZzj = this.zzs.zzj();
        int iZzf = zzagc.zzf(this.zzo.zzj().zza);
        zzgtj.zzi(iZzf != -2147483647);
        return zzfl.zzv(jZzj, 1000000L, iZzf, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzy(int i, int i2) {
        zzqv zzqvVar = this.zzs;
        if (zzqvVar != null) {
            zzqvVar.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzz(float f) {
        if (this.zzG != f) {
            this.zzG = f;
            zzY();
        }
    }
}
