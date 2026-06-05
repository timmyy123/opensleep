package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzvt extends zzix {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private boolean zzA;
    private float zzB;
    private ArrayDeque zzC;
    private zzvp zzD;
    private zzvm zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private long zzL;
    private boolean zzM;
    private long zzN;
    private int zzO;
    private int zzP;
    private ByteBuffer zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private int zzX;
    private int zzY;
    private int zzZ;
    protected zzjb zza;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private long zzad;
    private boolean zzae;
    private boolean zzaf;
    private boolean zzag;
    private zzvs zzah;
    private long zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private long zzam;
    private zziz zzan;
    private zziz zzao;
    private zzgww zzap;
    private final Context zzc;
    private final zzvh zzd;
    private final zzvv zze;
    private final float zzf;
    private final zziv zzg;
    private final zziv zzh;
    private final zziv zzi;
    private final zzva zzj;
    private final MediaCodec.BufferInfo zzk;
    private final ArrayDeque zzl;
    private final zzty zzm;
    private final AtomicInteger zzn;
    private zzv zzo;
    private zzv zzp;
    private zzug zzq;
    private zzug zzr;
    private zzmz zzs;
    private MediaCrypto zzt;
    private long zzu;
    private float zzv;
    private float zzw;
    private zzvj zzx;
    private zzv zzy;
    private MediaFormat zzz;

    public zzvt(Context context, int i, zzvh zzvhVar, zzvv zzvvVar, boolean z, float f) {
        super(i);
        this.zzc = context.getApplicationContext();
        this.zzd = zzvhVar;
        zzvvVar.getClass();
        this.zze = zzvvVar;
        this.zzf = f;
        this.zzn = new AtomicInteger();
        this.zzg = new zziv(0, 0);
        this.zzh = new zziv(0, 0);
        this.zzi = new zziv(2, 0);
        zzva zzvaVar = new zzva();
        this.zzj = zzvaVar;
        this.zzk = new MediaCodec.BufferInfo();
        this.zzv = 1.0f;
        this.zzw = 1.0f;
        this.zzu = -9223372036854775807L;
        this.zzl = new ArrayDeque();
        this.zzah = zzvs.zza;
        zzvaVar.zzj(0);
        zzvaVar.zzc.order(ByteOrder.nativeOrder());
        this.zzm = new zzty();
        this.zzB = -1.0f;
        this.zzF = 0;
        this.zzX = 0;
        this.zzO = -1;
        this.zzP = -1;
        this.zzN = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzai = -9223372036854775807L;
        this.zzL = -9223372036854775807L;
        this.zzY = 0;
        this.zzZ = 0;
        this.zza = new zzjb();
        this.zzal = false;
        this.zzam = 0L;
        this.zzap = zzgww.zzh();
        zziz zzizVar = zziz.zza;
        this.zzan = zzizVar;
        this.zzao = zzizVar;
    }

    private final boolean zzaA(int i) throws zzjk {
        zzlw zzlwVarZzI = zzI();
        zziv zzivVar = this.zzg;
        zzivVar.zza();
        int iZzQ = zzQ(zzlwVarZzI, zzivVar, i | 4);
        if (iZzQ == -5) {
            zzao(zzlwVarZzI);
            return true;
        }
        if (iZzQ != -4 || !zzivVar.zzb()) {
            return false;
        }
        this.zzae = true;
        zzbr();
        return false;
    }

    private final boolean zzaB(long j) {
        return this.zzu == -9223372036854775807L || zzM().zzb() - j < this.zzu;
    }

    private final boolean zzaC() {
        return this.zzP >= 0;
    }

    private final void zzaq() {
        this.zzT = false;
        zzaw();
    }

    private final void zzaw() {
        zzaz();
        this.zzV = false;
        this.zzj.zza();
        this.zzi.zza();
        this.zzU = false;
        this.zzm.zzb();
    }

    private final boolean zzax() {
        if (this.zzx == null) {
            return false;
        }
        if (zzaO()) {
            zzaM();
            return true;
        }
        if (zzaP()) {
            zzay();
            return false;
        }
        this.zzal = true;
        return false;
    }

    private final void zzay() {
        try {
            zzvj zzvjVar = this.zzx;
            if (zzvjVar == null) {
                throw null;
            }
            zzvjVar.zzk();
        } finally {
            zzaR();
        }
    }

    private final void zzaz() {
        this.zzad = -9223372036854775807L;
        zzbt().zzf = -9223372036854775807L;
        this.zzai = -9223372036854775807L;
    }

    public static boolean zzbj(zzv zzvVar) {
        return zzvVar.zzO == 0;
    }

    private final void zzbm() {
        this.zzO = -1;
        this.zzh.zzc = null;
    }

    private final void zzbn() {
        this.zzP = -1;
        this.zzQ = null;
    }

    private final boolean zzbo(zzv zzvVar) throws zzjk {
        if (this.zzx != null && this.zzZ != 3 && zze() != 0) {
            float f = this.zzw;
            zzvVar.getClass();
            float fZzak = zzak(f, zzvVar, zzJ());
            float f2 = this.zzB;
            if (f2 != fZzak) {
                if (fZzak == -1.0f) {
                    zzbq();
                    return false;
                }
                if (f2 != -1.0f || fZzak > this.zzf) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzak);
                    zzvj zzvjVar = this.zzx;
                    zzvjVar.getClass();
                    zzvjVar.zzp(bundle);
                    this.zzB = fZzak;
                }
            }
        }
        return true;
    }

    private final boolean zzbp() {
        if (this.zzaa) {
            this.zzY = 1;
            if (this.zzH) {
                this.zzZ = 3;
                return false;
            }
            this.zzZ = 2;
        } else {
            zzbu();
        }
        return true;
    }

    private final void zzbq() throws zzjk {
        if (this.zzaa) {
            this.zzY = 1;
            this.zzZ = 3;
        } else {
            zzaM();
            zzaE();
        }
    }

    private final void zzbr() throws zzjk {
        int i = this.zzZ;
        if (i == 1) {
            zzay();
            return;
        }
        if (i == 2) {
            zzay();
            zzbu();
        } else if (i != 3) {
            this.zzaf = true;
            zzau();
        } else {
            zzaM();
            zzaE();
        }
    }

    private final void zzbs(zzvs zzvsVar) {
        this.zzah = zzvsVar;
        if (zzvsVar.zzd != -9223372036854775807L) {
            this.zzaj = true;
        }
    }

    private final zzvs zzbt() {
        ArrayDeque arrayDeque = this.zzl;
        return !arrayDeque.isEmpty() ? (zzvs) arrayDeque.getLast() : this.zzah;
    }

    private final void zzbu() {
        zzug zzugVar = this.zzr;
        zzugVar.getClass();
        this.zzq = zzugVar;
        this.zzY = 0;
        this.zzZ = 0;
    }

    private final boolean zzbv(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzv zzvVar = this.zzp;
        return (zzvVar != null && Objects.equals(zzvVar.zzp, "audio/opus") && zzgv.zzf(j, j2)) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public void zzA(long j, boolean z, boolean z2) throws zzjk {
        ArrayDeque arrayDeque = this.zzl;
        if (!arrayDeque.isEmpty()) {
            this.zzah = (zzvs) arrayDeque.getLast();
        }
        arrayDeque.clear();
        if (z2) {
            this.zzae = false;
            this.zzaf = false;
            if (this.zzT) {
                zzaw();
            } else {
                zzaN();
            }
            zzfh zzfhVar = this.zzah.zze;
            if (zzfhVar.zzc() > 0) {
                this.zzag = true;
            }
            zzfhVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public void zzD() {
        this.zzo = null;
        zzbs(zzvs.zza);
        this.zzl.clear();
        if (this.zzT) {
            zzaq();
        } else {
            zzax();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public void zzE() {
        try {
            zzaq();
            zzaM();
        } finally {
            this.zzr = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final long zzV(long j, long j2) {
        return zzaj(j, j2, this.zzM);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public void zzX(float f, float f2) throws zzjk {
        this.zzv = f;
        this.zzw = f2;
        zzbo(this.zzy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:250:0x03df, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0422, code lost:
    
        if (r24.zzK != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0424, code lost:
    
        r24.zzab = true;
        r2.zza(r24.zzO, 0, 0, 0, 4);
        zzbm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0437, code lost:
    
        r24.zzY = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03eb A[LOOP:0: B:128:0x01fd->B:255:0x03eb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x03ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7 A[Catch: IllegalStateException -> 0x009c, CryptoException -> 0x00a1, TryCatch #5 {IllegalStateException -> 0x009c, blocks: (B:121:0x01d9, B:46:0x0099, B:56:0x00ac, B:58:0x00b0, B:61:0x00b9, B:64:0x00c7, B:65:0x00d6, B:69:0x00e3, B:71:0x00e9, B:111:0x01c1, B:113:0x01c7, B:114:0x01ca, B:116:0x01d0, B:118:0x01d4, B:72:0x00f3, B:74:0x00f9, B:75:0x0105, B:77:0x0115, B:80:0x0125, B:83:0x012b, B:85:0x012f, B:87:0x0139, B:89:0x0143, B:90:0x0160, B:91:0x0168, B:92:0x0169, B:94:0x0170, B:96:0x0178, B:98:0x017e, B:99:0x0185, B:101:0x0191, B:102:0x019a, B:107:0x01b5, B:109:0x01bb, B:105:0x01a1, B:79:0x011d, B:110:0x01be, B:125:0x01e8, B:127:0x01ef, B:128:0x01fd, B:130:0x0201, B:137:0x0218, B:139:0x021e, B:141:0x0226, B:143:0x0230, B:145:0x0238, B:147:0x023e, B:149:0x0244, B:152:0x024e, B:153:0x025b, B:155:0x0261, B:157:0x026d, B:166:0x027e, B:167:0x0286, B:168:0x028e, B:169:0x0296, B:170:0x029e, B:171:0x02a6, B:173:0x02b2, B:174:0x02b7, B:175:0x02bd, B:176:0x02be, B:178:0x02c2, B:180:0x02c6, B:182:0x02ca, B:183:0x02cd, B:185:0x02d3, B:187:0x02e2), top: B:408:0x0028 }] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.media.MediaFormat, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // com.google.android.gms.internal.ads.zzna
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zzZ(long j, long j2) throws Throwable {
        boolean z;
        ?? r12;
        ?? r122;
        boolean z2;
        ?? r2;
        boolean z3;
        ?? r22;
        boolean z4;
        byte b;
        Throwable th;
        boolean z5 = true;
        try {
            try {
            } catch (MediaCodec.CryptoException e) {
                e = e;
                r12 = 0;
            }
        } catch (IllegalStateException e2) {
            e = e2;
            z = true;
        }
        if (this.zzaf) {
            zzau();
            return;
        }
        int i = 2;
        if (this.zzo != null || zzaA(2)) {
            zzaE();
            byte b2 = -5;
            ?? r6 = 0;
            try {
                try {
                    try {
                        try {
                        } catch (IllegalStateException e3) {
                            e = e3;
                            z3 = false;
                        }
                    } catch (IllegalStateException e4) {
                        e = e4;
                    }
                } catch (MediaCodec.CryptoException e5) {
                    e = e5;
                }
            } catch (MediaCodec.CryptoException e6) {
                e = e6;
                throw zzP(e, this.zzo, r12, zzfl.zzH(e.getErrorCode()));
            } catch (IllegalStateException e7) {
                e = e7;
            }
            if (this.zzT) {
                try {
                    try {
                        Trace.beginSection("bypassRender");
                        while (true) {
                            zzgtj.zzi(this.zzaf ^ z5);
                            zzva zzvaVar = this.zzj;
                            if (zzvaVar.zzp()) {
                                ByteBuffer byteBuffer = zzvaVar.zzc;
                                int i2 = this.zzP;
                                int iZzo = zzvaVar.zzo();
                                long j3 = zzvaVar.zze;
                                boolean zZzbv = zzbv(zzH(), zzvaVar.zzn());
                                boolean zZzb = zzvaVar.zzb();
                                zzv zzvVar = this.zzp;
                                if (zzvVar == null) {
                                    throw r6;
                                }
                                if (!zzas(j, j2, null, byteBuffer, i2, 0, iZzo, j3, zZzbv, zZzb, zzvVar)) {
                                    z5 = true;
                                    break;
                                } else {
                                    zzaZ(zzvaVar.zzn());
                                    zzvaVar.zza();
                                    r22 = 0;
                                }
                            } else {
                                r22 = r6;
                            }
                            try {
                                if (this.zzae) {
                                    z5 = true;
                                    this.zzaf = true;
                                    break;
                                }
                                z5 = true;
                                if (this.zzU) {
                                    zzgtj.zzi(zzvaVar.zzq(this.zzi));
                                    z4 = false;
                                    this.zzU = false;
                                } else {
                                    z4 = false;
                                }
                                if (this.zzV) {
                                    if (!zzvaVar.zzp()) {
                                        zzaq();
                                        this.zzV = z4;
                                        zzaE();
                                        if (!this.zzT) {
                                            break;
                                        }
                                    } else {
                                        b = -5;
                                        r6 = r22;
                                    }
                                } else {
                                    zzgtj.zzi(!this.zzae);
                                    zzlw zzlwVarZzI = zzI();
                                    zziv zzivVar = this.zzi;
                                    zzivVar.zza();
                                    do {
                                        zzivVar.zza();
                                        int iZzQ = zzQ(zzlwVarZzI, zzivVar, z4 ? 1 : 0);
                                        b = -5;
                                        if (iZzQ == -5) {
                                            zzao(zzlwVarZzI);
                                            break;
                                        }
                                        if (iZzQ == -4) {
                                            if (zzivVar.zzb()) {
                                                this.zzae = true;
                                                zzbt().zzf = this.zzad;
                                                break;
                                            }
                                            this.zzad = Math.max(this.zzad, zzivVar.zze);
                                            if (zzcW() || this.zzh.zzd()) {
                                                zzbt().zzf = this.zzad;
                                            }
                                            if (this.zzag) {
                                                zzv zzvVar2 = this.zzo;
                                                if (zzvVar2 == null) {
                                                    throw r22;
                                                }
                                                this.zzp = zzvVar2;
                                                if (Objects.equals(zzvVar2.zzp, "audio/opus") && !this.zzp.zzs.isEmpty()) {
                                                    int iZze = zzgv.zze((byte[]) this.zzp.zzs.get(z4 ? 1 : 0));
                                                    zzt zztVarZza = this.zzp.zza();
                                                    zztVarZza.zzJ(iZze);
                                                    this.zzp = zztVarZza.zzO();
                                                }
                                                zzap(this.zzp, r22);
                                                this.zzag = z4;
                                            }
                                            zzivVar.zzl();
                                            zzv zzvVar3 = this.zzp;
                                            if (zzvVar3 != null && Objects.equals(zzvVar3.zzp, "audio/opus")) {
                                                if (zzivVar.zze()) {
                                                    zzivVar.zza = this.zzp;
                                                    zzav(zzivVar);
                                                }
                                                if (zzgv.zzf(zzH(), zzivVar.zze)) {
                                                    this.zzm.zza(zzivVar, this.zzp.zzs);
                                                }
                                            }
                                            if (zzvaVar.zzp()) {
                                                long jZzH = zzH();
                                                if (zzbv(jZzH, zzvaVar.zzn()) != zzbv(jZzH, zzivVar.zze)) {
                                                    break;
                                                }
                                            }
                                        } else if (zzcW()) {
                                            zzbt().zzf = this.zzad;
                                        }
                                    } while (zzvaVar.zzq(zzivVar));
                                    this.zzU = true;
                                    if (zzvaVar.zzp()) {
                                        zzvaVar.zzl();
                                    }
                                    if (!zzvaVar.zzp() && !this.zzae && !this.zzV) {
                                        break;
                                    }
                                    r6 = r22;
                                }
                            } catch (IllegalStateException e8) {
                                e = e8;
                                z5 = true;
                                b2 = 0;
                                z = z5;
                                r122 = b2;
                                z2 = e instanceof MediaCodec.CodecException;
                                if (!z2) {
                                }
                                zzan(e);
                                if (z2) {
                                }
                                if (r2 != 0) {
                                }
                                zzvl zzvlVarZzaT = zzaT(e, this.zzE);
                                throw zzP(zzvlVarZzaT, this.zzo, r2, zzvlVarZzaT.zza != 1101 ? 4006 : 4003);
                            }
                        }
                        Trace.endSection();
                    } catch (MediaCodec.CryptoException e9) {
                        e = e9;
                        b2 = 0;
                        r12 = b2;
                        throw zzP(e, this.zzo, r12, zzfl.zzH(e.getErrorCode()));
                    }
                } catch (IllegalStateException e10) {
                    e = e10;
                }
            } else {
                byte b3 = -5;
                Throwable th2 = null;
                boolean z6 = false;
                if (this.zzx != null) {
                    long jZzb = zzM().zzb();
                    Trace.beginSection("drainAndFeed");
                    long j4 = jZzb;
                    while (true) {
                        zzvj zzvjVar = this.zzx;
                        if (zzvjVar == null) {
                            throw th2;
                        }
                        if (!zzaC()) {
                            try {
                                MediaCodec.BufferInfo bufferInfo = this.zzk;
                                int iZzf = zzvjVar.zzf(bufferInfo);
                                if (iZzf >= 0) {
                                    th = th2;
                                    bufferInfo.presentationTimeUs -= this.zzam;
                                    if (!this.zzJ) {
                                        if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                                            zzbr();
                                            break;
                                        }
                                        this.zzP = iZzf;
                                        ByteBuffer byteBufferZzj = zzvjVar.zzj(iZzf);
                                        this.zzQ = byteBufferZzj;
                                        if (byteBufferZzj != null) {
                                            byteBufferZzj.position(bufferInfo.offset);
                                            this.zzQ.limit(bufferInfo.offset + bufferInfo.size);
                                        }
                                        zzv zzvVar4 = (zzv) this.zzah.zze.zze(bufferInfo.presentationTimeUs);
                                        if (zzvVar4 == null && this.zzaj && this.zzz != null) {
                                            zzvVar4 = (zzv) this.zzah.zze.zzd();
                                        }
                                        if (zzvVar4 != null) {
                                            this.zzp = zzvVar4;
                                        } else if (this.zzA && this.zzp != null) {
                                        }
                                        zzv zzvVar5 = this.zzp;
                                        if (zzvVar5 == null) {
                                            throw th;
                                        }
                                        zzap(zzvVar5, this.zzz);
                                        this.zzA = z6;
                                        this.zzaj = z6;
                                    } else {
                                        this.zzJ = z6;
                                        zzvjVar.zzc(iZzf, z6);
                                        if (!zzaB(j4)) {
                                        }
                                    }
                                } else if (iZzf == -2) {
                                    this.zzac = z5;
                                    zzvj zzvjVar2 = this.zzx;
                                    if (zzvjVar2 == null) {
                                        throw th2;
                                    }
                                    MediaFormat mediaFormatZzg = zzvjVar2.zzg();
                                    if (this.zzF != 0 && mediaFormatZzg.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && mediaFormatZzg.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
                                        this.zzJ = z5;
                                    } else {
                                        if (Build.VERSION.SDK_INT >= 29 && !this.zzap.isEmpty()) {
                                            zzgww<String> zzgwwVar = this.zzap;
                                            zziz zzizVar = zziz.zza;
                                            zziy zziyVar = new zziy();
                                            for (String str : zzgwwVar) {
                                                if (mediaFormatZzg.containsKey(str)) {
                                                    int valueTypeForKey = mediaFormatZzg.getValueTypeForKey(str);
                                                    if (valueTypeForKey == z5) {
                                                        zziyVar.zza(str, mediaFormatZzg.getInteger(str));
                                                    } else if (valueTypeForKey == i) {
                                                        zziyVar.zzb(str, mediaFormatZzg.getLong(str));
                                                    } else if (valueTypeForKey == 3) {
                                                        zziyVar.zzc(str, mediaFormatZzg.getFloat(str));
                                                    } else if (valueTypeForKey == 4) {
                                                        zziyVar.zzd(str, mediaFormatZzg.getString(str));
                                                    } else if (valueTypeForKey == 5) {
                                                        zziyVar.zze(str, mediaFormatZzg.getByteBuffer(str));
                                                    }
                                                }
                                            }
                                            zziz zzizVarZzg = zziyVar.zzg();
                                            if (!zzizVarZzg.equals(this.zzao)) {
                                                this.zzao = zzizVarZzg;
                                                zzat(zzizVarZzg);
                                            }
                                        }
                                        this.zzz = mediaFormatZzg;
                                        this.zzA = z5;
                                    }
                                    th = th2;
                                    if (!zzaB(j4)) {
                                        break;
                                    }
                                    th2 = th;
                                    z5 = true;
                                    i = 2;
                                    z6 = false;
                                    b3 = -5;
                                } else {
                                    if (this.zzK && (this.zzae || this.zzY == i)) {
                                        zzbr();
                                    }
                                    long j5 = this.zzL;
                                    if (j5 != -9223372036854775807L && j5 + 100 < zzM().zza()) {
                                        zzbr();
                                    }
                                    th = th2;
                                }
                            } catch (IllegalStateException e11) {
                                e = e11;
                                z3 = z6;
                                z = true;
                                r122 = z3;
                                z2 = e instanceof MediaCodec.CodecException;
                                if (!z2) {
                                }
                                zzan(e);
                                if (z2) {
                                }
                                if (r2 != 0) {
                                }
                                zzvl zzvlVarZzaT2 = zzaT(e, this.zzE);
                                throw zzP(zzvlVarZzaT2, this.zzo, r2, zzvlVarZzaT2.zza != 1101 ? 4006 : 4003);
                            }
                            z2 = e instanceof MediaCodec.CodecException;
                            if (!z2) {
                                StackTraceElement[] stackTrace = e.getStackTrace();
                                if (stackTrace.length <= 0 || !stackTrace[r122].getClassName().equals("android.media.MediaCodec")) {
                                    throw e;
                                }
                            }
                            zzan(e);
                            r2 = (z2 || !((MediaCodec.CodecException) e).isRecoverable()) ? r122 : z;
                            if (r2 != 0) {
                                zzaM();
                            }
                            zzvl zzvlVarZzaT22 = zzaT(e, this.zzE);
                            throw zzP(zzvlVarZzaT22, this.zzo, r2, zzvlVarZzaT22.zza != 1101 ? 4006 : 4003);
                        }
                        th = th2;
                        boolean z7 = (this.zzal || this.zzk.presentationTimeUs < zzH()) ? true : z6;
                        this.zzR = z7;
                        long j6 = this.zzah.zzf;
                        boolean z8 = (j6 == -9223372036854775807L || j6 > this.zzk.presentationTimeUs) ? z6 : true;
                        this.zzS = z8;
                        ByteBuffer byteBuffer2 = this.zzQ;
                        int i3 = this.zzP;
                        MediaCodec.BufferInfo bufferInfo2 = this.zzk;
                        long j7 = j4;
                        int i4 = bufferInfo2.flags;
                        long j8 = bufferInfo2.presentationTimeUs;
                        zzv zzvVar6 = this.zzp;
                        if (zzvVar6 == null) {
                            throw th;
                        }
                        if (!zzas(j, j2, zzvjVar, byteBuffer2, i3, i4, 1, j8, z7, z8, zzvVar6)) {
                            break;
                        }
                        zzaZ(bufferInfo2.presentationTimeUs);
                        boolean z9 = (bufferInfo2.flags & 4) != 0;
                        if (!z9 && this.zzab && this.zzS) {
                            this.zzL = zzM().zza();
                        }
                        zzbn();
                        if (z9) {
                            zzbr();
                            break;
                        } else {
                            j4 = j7;
                            if (!zzaB(j4)) {
                            }
                        }
                    }
                    while (true) {
                        zzvj zzvjVar3 = this.zzx;
                        if (zzvjVar3 == null || this.zzY == 2 || this.zzae) {
                            break;
                        }
                        if (this.zzO < 0) {
                            int iZze2 = zzvjVar3.zze();
                            this.zzO = iZze2;
                            if (iZze2 < 0) {
                                break;
                            }
                            zziv zzivVar2 = this.zzh;
                            zzivVar2.zzc = zzvjVar3.zzh(iZze2);
                            zzivVar2.zza();
                        }
                        z = true;
                        if (this.zzY == 1) {
                            break;
                        }
                        try {
                            if (this.zzI) {
                                this.zzI = false;
                                ByteBuffer byteBuffer3 = this.zzh.zzc;
                                if (byteBuffer3 == null) {
                                    throw th;
                                }
                                byteBuffer3.put(zzb);
                                zzvjVar3.zza(this.zzO, 0, 38, 0L, 0);
                                zzbm();
                                this.zzaa = true;
                            } else {
                                if (this.zzX == 1) {
                                    int i5 = 0;
                                    while (true) {
                                        zzv zzvVar7 = this.zzy;
                                        if (zzvVar7 == null) {
                                            throw th;
                                        }
                                        if (i5 >= zzvVar7.zzs.size()) {
                                            this.zzX = 2;
                                            break;
                                        }
                                        byte[] bArr = (byte[]) this.zzy.zzs.get(i5);
                                        ByteBuffer byteBuffer4 = this.zzh.zzc;
                                        if (byteBuffer4 == null) {
                                            throw th;
                                        }
                                        byteBuffer4.put(bArr);
                                        i5++;
                                    }
                                }
                                ByteBuffer byteBuffer5 = this.zzh.zzc;
                                if (byteBuffer5 == null) {
                                    throw th;
                                }
                                int iPosition = byteBuffer5.position();
                                final zzlw zzlwVarZzI2 = zzI();
                                try {
                                    zzvjVar3.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvq
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzbk(zzlwVarZzI2);
                                        }
                                    });
                                    int i6 = this.zzn.get();
                                    if (i6 == -3) {
                                        if (zzcW()) {
                                            zzbt().zzf = this.zzad;
                                        }
                                    } else if (i6 == -5) {
                                        if (this.zzX == 2) {
                                            this.zzh.zza();
                                            this.zzX = 1;
                                        }
                                        zzao(zzlwVarZzI2);
                                    } else {
                                        zziv zzivVar3 = this.zzh;
                                        if (zzivVar3.zzb()) {
                                            zzbt().zzf = this.zzad;
                                            if (this.zzX == 2) {
                                                zzivVar3.zza();
                                                this.zzX = 1;
                                            }
                                            this.zzae = true;
                                            if (!this.zzaa) {
                                                zzbr();
                                            } else if (!this.zzK) {
                                                this.zzab = true;
                                                zzvjVar3.zza(this.zzO, 0, 0, 0L, 4);
                                                zzbm();
                                            }
                                        } else if (this.zzaa || zzivVar3.zzc()) {
                                            long j9 = zzivVar3.zze;
                                            if (!zzaX(zzivVar3)) {
                                                boolean zZzk = zzivVar3.zzk();
                                                if (zZzk) {
                                                    zzivVar3.zzb.zzc(iPosition);
                                                }
                                                if (this.zzag) {
                                                    zzfh zzfhVar = zzbt().zze;
                                                    zzv zzvVar8 = this.zzo;
                                                    if (zzvVar8 == null) {
                                                        throw th;
                                                    }
                                                    zzfhVar.zza(j9, zzvVar8);
                                                    this.zzag = false;
                                                }
                                                this.zzad = Math.max(this.zzad, j9);
                                                if (zzcW() || zzivVar3.zzd()) {
                                                    zzbt().zzf = this.zzad;
                                                }
                                                zzivVar3.zzl();
                                                if (zzivVar3.zze()) {
                                                    zzav(zzivVar3);
                                                }
                                                if (this.zzal) {
                                                    long j10 = this.zzad;
                                                    if (j9 <= j10) {
                                                        this.zzam = (j10 - j9) + 1 + this.zzam;
                                                    }
                                                    this.zzad = j9;
                                                    this.zzal = false;
                                                }
                                                zzaV(zzivVar3);
                                                int iZzaW = zzaW(zzivVar3);
                                                long j11 = j9 + this.zzam;
                                                if (zZzk) {
                                                    zzvjVar3.zzb(this.zzO, 0, zzivVar3.zzb, j11, iZzaW);
                                                } else {
                                                    int i7 = this.zzO;
                                                    ByteBuffer byteBuffer6 = zzivVar3.zzc;
                                                    if (byteBuffer6 == null) {
                                                        throw th;
                                                    }
                                                    zzvjVar3.zza(i7, 0, byteBuffer6.limit(), j11, iZzaW);
                                                }
                                                zzbm();
                                                this.zzaa = true;
                                                this.zzX = 0;
                                                this.zza.zzc++;
                                            }
                                        } else {
                                            zzivVar3.zza();
                                            if (this.zzX == 2) {
                                                this.zzX = 1;
                                            }
                                        }
                                    }
                                } catch (zziu e12) {
                                    zzan(e12);
                                    zzaA(0);
                                    zzay();
                                }
                            }
                            if (!zzaB(j4)) {
                                break;
                            }
                        } catch (IllegalStateException e13) {
                            e = e13;
                            r122 = 0;
                            z2 = e instanceof MediaCodec.CodecException;
                            if (!z2) {
                            }
                            zzan(e);
                            if (z2) {
                            }
                            if (r2 != 0) {
                            }
                            zzvl zzvlVarZzaT222 = zzaT(e, this.zzE);
                            throw zzP(zzvlVarZzaT222, this.zzo, r2, zzvlVarZzaT222.zza != 1101 ? 4006 : 4003);
                        }
                    }
                    Trace.endSection();
                } else {
                    this.zza.zzd += zzR(j);
                    zzaA(1);
                }
            }
            this.zza.zza();
        }
    }

    public final void zzaD() {
        this.zzak = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0227 A[Catch: Exception -> 0x0105, TryCatch #4 {Exception -> 0x0105, blocks: (B:57:0x00db, B:59:0x00e5, B:61:0x00f9, B:67:0x0137, B:69:0x014a, B:71:0x0178, B:73:0x0181, B:75:0x0189, B:77:0x0193, B:79:0x019b, B:81:0x01a3, B:85:0x01ae, B:87:0x01b4, B:91:0x01c0, B:93:0x01c9, B:118:0x0221, B:120:0x0227, B:122:0x022d, B:123:0x023b, B:125:0x0249, B:127:0x0251, B:129:0x0255, B:132:0x0267, B:98:0x01d7, B:100:0x01df, B:102:0x01e7, B:104:0x01ef, B:106:0x01f7, B:108:0x01ff, B:110:0x0207, B:112:0x0211, B:114:0x021b), top: B:174:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02a1 A[Catch: zzvp -> 0x0082, TryCatch #3 {zzvp -> 0x0082, blocks: (B:25:0x0055, B:27:0x005c, B:29:0x0060, B:31:0x0076, B:36:0x0087, B:40:0x0093, B:42:0x009b, B:44:0x009f, B:46:0x00a3, B:48:0x00ac, B:146:0x0288, B:148:0x02a1, B:150:0x02aa, B:153:0x02b1, B:154:0x02b3, B:149:0x02a4, B:156:0x02b5, B:157:0x02b6, B:159:0x02bb, B:160:0x02bc, B:161:0x02c6, B:38:0x008a, B:39:0x0092, B:163:0x02c9), top: B:173:0x0055, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02a4 A[Catch: zzvp -> 0x0082, TryCatch #3 {zzvp -> 0x0082, blocks: (B:25:0x0055, B:27:0x005c, B:29:0x0060, B:31:0x0076, B:36:0x0087, B:40:0x0093, B:42:0x009b, B:44:0x009f, B:46:0x00a3, B:48:0x00ac, B:146:0x0288, B:148:0x02a1, B:150:0x02aa, B:153:0x02b1, B:154:0x02b3, B:149:0x02a4, B:156:0x02b5, B:157:0x02b6, B:159:0x02bb, B:160:0x02bc, B:161:0x02c6, B:38:0x008a, B:39:0x0092, B:163:0x02c9), top: B:173:0x0055, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0273 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d5  */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.google.android.gms.internal.ads.zzvh] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.google.android.gms.internal.ads.zzvm] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.android.gms.internal.ads.zzvg] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayDeque] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzaE() throws zzjk {
        zzv zzvVar;
        boolean z;
        ?? r10;
        zzvp zzvpVar;
        zzv zzvVar2;
        ?? Zzah;
        int i;
        long j;
        long j2;
        int i2;
        String str;
        if (this.zzx != null || this.zzT || (zzvVar = this.zzo) == null) {
            return;
        }
        boolean z2 = true;
        if (zzaF(zzvVar)) {
            zzaq();
            String str2 = zzvVar.zzp;
            if ("audio/mp4a-latm".equals(str2) || "audio/mpeg".equals(str2) || "audio/opus".equals(str2)) {
                this.zzj.zzm(32);
            } else {
                this.zzj.zzm(1);
            }
            this.zzT = true;
            return;
        }
        zzug zzugVar = this.zzr;
        this.zzq = zzugVar;
        if (zzugVar != null) {
            zzgtj.zzi(true);
            this.zzq.zza();
        }
        try {
            zzv zzvVar3 = this.zzo;
            MediaCrypto mediaCrypto = null;
            if (zzvVar3 == null) {
                throw null;
            }
            if (this.zzC == null) {
                try {
                    List listZzaf = zzaf(this.zze, zzvVar3, false);
                    listZzaf.isEmpty();
                    this.zzC = new ArrayDeque();
                    if (!listZzaf.isEmpty()) {
                        this.zzC.add((zzvm) listZzaf.get(0));
                    }
                    this.zzD = null;
                } catch (zzvx e) {
                    throw new zzvp(zzvVar3, (Throwable) e, false, -49998);
                }
            }
            if (this.zzC.isEmpty()) {
                throw new zzvp(zzvVar3, (Throwable) null, false, -49999);
            }
            ArrayDeque arrayDeque = this.zzC;
            if (arrayDeque == null) {
                throw null;
            }
            while (this.zzx == null) {
                zzvm zzvmVar = (zzvm) arrayDeque.peekFirst();
                if (zzvmVar == null) {
                    throw mediaCrypto;
                }
                zzaU(zzvVar3);
                if (!zzaG(zzvmVar)) {
                    return;
                }
                try {
                    this.zzE = zzvmVar;
                    zzvVar2 = this.zzo;
                } catch (Exception e2) {
                    e = e2;
                    z = z2;
                }
                if (zzvVar2 == null) {
                    throw mediaCrypto;
                }
                String str3 = zzvmVar.zza;
                float fZzak = zzak(this.zzw, zzvVar2, zzJ());
                if (fZzak <= this.zzf) {
                    fZzak = -1.0f;
                }
                long jZzb = zzM().zzb();
                z = z2;
                try {
                    Zzah = zzah(zzvmVar, zzvVar2, mediaCrypto, fZzak);
                    i = Build.VERSION.SDK_INT;
                    if (i >= 31) {
                        LogSessionId logSessionIdZza = zzL().zza();
                        j = jZzb;
                        if (!logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                            Zzah.zzb.setString("log-session-id", logSessionIdZza.getStringId());
                        }
                    } else {
                        j = jZzb;
                    }
                    try {
                        StringBuilder sb = new StringBuilder(str3.length() + 12);
                        sb.append("createCodec:");
                        sb.append(str3);
                        Trace.beginSection(sb.toString());
                        zzvj zzvjVarZzc = this.zzd.zzc(Zzah);
                        this.zzx = zzvjVarZzc;
                        this.zzM = zzvjVarZzc.zzm(new zzvr(this, null));
                        Trace.endSection();
                        long jZzb2 = zzM().zzb();
                        if (zzvmVar.zzc(this.zzc, zzvVar2)) {
                            j2 = jZzb2;
                        } else {
                            String strZze = zzv.zze(zzvVar2);
                            String str4 = zzfl.zza;
                            Locale locale = Locale.US;
                            StringBuilder sb2 = new StringBuilder();
                            j2 = jZzb2;
                            sb2.append("Format exceeds selected codec's capabilities [");
                            sb2.append(strZze);
                            sb2.append(", ");
                            sb2.append(str3);
                            sb2.append("]");
                            zzeg.zzc("MediaCodecRenderer", sb2.toString());
                        }
                        this.zzB = fZzak;
                        this.zzy = zzvVar2;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    r10 = zzvmVar;
                }
                if (i > 25 || !"OMX.Exynos.avc.dec.secure".equals(str3)) {
                    i2 = 0;
                    this.zzF = i2;
                    this.zzG = (i == 29 || !"c2.android.aac.decoder".equals(str3)) ? false : z;
                    this.zzH = false;
                    str = zzvmVar.zza;
                    if (i <= 25 || !"OMX.rk.video_decoder.avc".equals(str)) {
                        boolean z3 = ((i <= 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) && !("Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && zzvmVar.zzf)) ? false : z;
                        this.zzK = z3;
                        if (this.zzx == null) {
                            throw null;
                        }
                        if (zze() == 2) {
                            this.zzN = zzM().zzb() + 1000;
                        }
                        this.zza.zza++;
                        long j3 = j2 - j;
                        if (i >= 31 && !this.zzap.isEmpty()) {
                            zzvj zzvjVar = this.zzx;
                            if (zzvjVar == null) {
                                throw null;
                            }
                            zzvjVar.zzr(new ArrayList(this.zzap));
                        }
                        Zzah = zzvmVar;
                        try {
                            zzal(str3, Zzah, j2, j3);
                        } catch (Exception e4) {
                            e = e4;
                            r10 = Zzah;
                            zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(r10.zza), e);
                            arrayDeque.removeFirst();
                            zzvp zzvpVar2 = new zzvp(zzvVar3, (Throwable) e, false, (zzvm) r10);
                            zzan(zzvpVar2);
                            zzvpVar = this.zzD;
                            if (zzvpVar != null) {
                            }
                            if (!arrayDeque.isEmpty()) {
                            }
                        }
                        zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(r10.zza), e);
                        arrayDeque.removeFirst();
                        zzvp zzvpVar22 = new zzvp(zzvVar3, (Throwable) e, false, (zzvm) r10);
                        zzan(zzvpVar22);
                        zzvpVar = this.zzD;
                        if (zzvpVar != null) {
                            this.zzD = zzvpVar22;
                        } else {
                            this.zzD = zzvpVar.zza(zzvpVar22);
                        }
                        if (!arrayDeque.isEmpty()) {
                            throw this.zzD;
                        }
                    }
                } else {
                    String str5 = Build.MODEL;
                    if (str5.startsWith("SM-T585") || str5.startsWith("SM-A510") || str5.startsWith("SM-A520") || str5.startsWith("SM-J700")) {
                        i2 = 2;
                    }
                    this.zzF = i2;
                    if (i == 29) {
                        this.zzG = (i == 29 || !"c2.android.aac.decoder".equals(str3)) ? false : z;
                        this.zzH = false;
                        str = zzvmVar.zza;
                        if (i <= 25) {
                            if (i <= 29) {
                                this.zzK = z3;
                                if (this.zzx == null) {
                                }
                                zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(r10.zza), e);
                                arrayDeque.removeFirst();
                                zzvp zzvpVar222 = new zzvp(zzvVar3, (Throwable) e, false, (zzvm) r10);
                                zzan(zzvpVar222);
                                zzvpVar = this.zzD;
                                if (zzvpVar != null) {
                                }
                                if (!arrayDeque.isEmpty()) {
                                }
                            } else {
                                this.zzK = z3;
                                if (this.zzx == null) {
                                }
                                zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(r10.zza), e);
                                arrayDeque.removeFirst();
                                zzvp zzvpVar2222 = new zzvp(zzvVar3, (Throwable) e, false, (zzvm) r10);
                                zzan(zzvpVar2222);
                                zzvpVar = this.zzD;
                                if (zzvpVar != null) {
                                }
                                if (!arrayDeque.isEmpty()) {
                                }
                            }
                        }
                    }
                }
                z2 = z;
                mediaCrypto = null;
            }
            this.zzC = mediaCrypto;
        } catch (zzvp e5) {
            throw zzP(e5, zzvVar, false, 4001);
        }
    }

    public final boolean zzaF(zzv zzvVar) {
        return this.zzr == null && zzag(zzvVar);
    }

    public boolean zzaG(zzvm zzvmVar) {
        return true;
    }

    public final boolean zzaH() {
        return this.zzT;
    }

    public final zzvj zzaI() {
        return this.zzx;
    }

    public final zzv zzaJ() {
        return this.zzy;
    }

    public final MediaFormat zzaK() {
        return this.zzz;
    }

    public final zzvm zzaL() {
        return this.zzE;
    }

    public final void zzaM() {
        try {
            zzvj zzvjVar = this.zzx;
            if (zzvjVar != null) {
                zzvjVar.zzl();
                this.zza.zzb++;
                zzvm zzvmVar = this.zzE;
                if (zzvmVar == null) {
                    throw null;
                }
                zzam(zzvmVar.zza);
            }
            this.zzx = null;
            this.zzt = null;
            this.zzq = null;
            zzaS();
        } catch (Throwable th) {
            this.zzx = null;
            this.zzt = null;
            this.zzq = null;
            zzaS();
            throw th;
        }
    }

    public final boolean zzaN() throws zzjk {
        boolean zZzax = zzax();
        if (zZzax) {
            zzaE();
        }
        return zZzax;
    }

    public boolean zzaO() {
        int i = this.zzZ;
        if (i == 3 || ((this.zzG && !this.zzac) || (this.zzH && this.zzab))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            zzbu();
            return false;
        } catch (zzjk e) {
            zzeg.zzd("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
            return true;
        }
    }

    public boolean zzaP() {
        return true;
    }

    public final long zzaQ() {
        return this.zzam;
    }

    public void zzaR() {
        zzbm();
        zzbn();
        zzaz();
        this.zzN = -9223372036854775807L;
        this.zzab = false;
        this.zzL = -9223372036854775807L;
        this.zzaa = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzR = false;
        this.zzS = false;
        this.zzY = 0;
        this.zzZ = 0;
        this.zzX = this.zzW ? 1 : 0;
        this.zzal = false;
        this.zzam = 0L;
    }

    public final void zzaS() {
        zzaR();
        this.zzC = null;
        this.zzE = null;
        this.zzy = null;
        this.zzz = null;
        this.zzA = false;
        this.zzac = false;
        this.zzB = -1.0f;
        this.zzF = 0;
        this.zzG = false;
        this.zzH = false;
        this.zzK = false;
        this.zzM = false;
        this.zzW = false;
        this.zzX = 0;
    }

    public zzvl zzaT(Throwable th, zzvm zzvmVar) {
        return new zzvl(th, zzvmVar);
    }

    public boolean zzaU(zzv zzvVar) {
        return true;
    }

    public void zzaV(zziv zzivVar) {
    }

    public int zzaW(zziv zzivVar) {
        return 0;
    }

    public boolean zzaX(zziv zzivVar) {
        return false;
    }

    public final long zzaY() {
        return this.zzai;
    }

    public void zzaZ(long j) {
        this.zzai = j;
        while (true) {
            ArrayDeque arrayDeque = this.zzl;
            if (arrayDeque.isEmpty() || j < ((zzvs) arrayDeque.peek()).zzb) {
                return;
            }
            zzvs zzvsVar = (zzvs) arrayDeque.poll();
            zzvsVar.getClass();
            zzbs(zzvsVar);
            zzar();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public boolean zzab() {
        return this.zzaf;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final int zzad(zzv zzvVar) throws zzjk {
        try {
            return zzae(this.zze, zzvVar);
        } catch (zzvx e) {
            throw this.zzP(e, zzvVar, false, 4002);
        }
    }

    public abstract int zzae(zzvv zzvvVar, zzv zzvVar);

    public abstract List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z);

    public boolean zzag(zzv zzvVar) {
        return false;
    }

    public abstract zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f);

    public abstract zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2);

    public long zzaj(long j, long j2, boolean z) {
        return super.zzV(j, j2);
    }

    public abstract float zzak(float f, zzv zzvVar, zzv[] zzvVarArr);

    public abstract void zzal(String str, zzvg zzvgVar, long j, long j2);

    public abstract void zzam(String str);

    public abstract void zzan(Exception exc);

    /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzjc zzao(zzlw zzlwVar) throws zzjk {
        int i;
        boolean z = true;
        this.zzag = true;
        zzv zzvVarZzO = zzlwVar.zzb;
        zzvVarZzO.getClass();
        String str = zzvVarZzO.zzp;
        if (str == null) {
            throw zzP(new IllegalArgumentException("Sample MIME type is null."), zzvVarZzO, false, 4005);
        }
        if ((str.equals("video/av01") || str.equals("video/x-vnd.on2.vp9") || (str.equals("video/dolby-vision") && Objects.equals(zzwf.zzg(zzvVarZzO), "video/av01"))) && !zzvVarZzO.zzs.isEmpty()) {
            zzt zztVarZza = zzvVarZzO.zza();
            zztVarZza.zzr(null);
            zzvVarZzO = zztVarZza.zzO();
        }
        zzv zzvVar = zzvVarZzO;
        this.zzr = zzlwVar.zza;
        this.zzo = zzvVar;
        if (this.zzT) {
            this.zzV = true;
            return null;
        }
        zzvj zzvjVar = this.zzx;
        if (zzvjVar == null) {
            this.zzC = null;
            zzaE();
            return null;
        }
        zzvm zzvmVar = this.zzE;
        zzvmVar.getClass();
        zzv zzvVar2 = this.zzy;
        zzvVar2.getClass();
        zzug zzugVar = this.zzq;
        zzug zzugVar2 = this.zzr;
        if (zzugVar != zzugVar2) {
            zzbq();
            return new zzjc(zzvmVar.zza, zzvVar2, zzvVar, 0, 128);
        }
        zzjc zzjcVarZzai = zzai(zzvmVar, zzvVar2, zzvVar);
        int i2 = zzjcVarZzai.zzd;
        if (i2 != 0) {
            if (i2 == 1) {
                if (zzbo(zzvVar)) {
                    this.zzy = zzvVar;
                    if (zzugVar2 != zzugVar) {
                        if (!zzbp()) {
                        }
                    } else if (this.zzaa) {
                        this.zzY = 1;
                        if (this.zzH) {
                            this.zzZ = 3;
                            i = 2;
                        } else {
                            this.zzZ = 1;
                        }
                    }
                }
                i = 16;
            } else if (i2 != 2) {
                if (zzbo(zzvVar)) {
                    this.zzy = zzvVar;
                    if (zzugVar2 != zzugVar && !zzbp()) {
                        i = 2;
                    }
                }
                i = 16;
            } else {
                if (zzbo(zzvVar)) {
                    this.zzW = true;
                    this.zzX = 1;
                    int i3 = this.zzF;
                    if (i3 != 2 && (i3 != 1 || zzvVar.zzw != zzvVar2.zzw || zzvVar.zzx != zzvVar2.zzx)) {
                        z = false;
                    }
                    this.zzI = z;
                    this.zzy = zzvVar;
                    if (zzugVar2 == zzugVar || zzbp()) {
                    }
                }
                i = 16;
            }
            return (i2 != 0 || (this.zzx == zzvjVar && this.zzZ != 3)) ? zzjcVarZzai : new zzjc(zzvmVar.zza, zzvVar2, zzvVar, 0, i);
        }
        zzbq();
        i = 0;
        if (i2 != 0) {
        }
    }

    public abstract void zzap(zzv zzvVar, MediaFormat mediaFormat);

    public abstract void zzar();

    public abstract boolean zzas(long j, long j2, zzvj zzvjVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar);

    public abstract void zzat(zziz zzizVar);

    public abstract void zzau();

    public abstract void zzav(zziv zzivVar);

    public final boolean zzba() {
        if (this.zzo == null) {
            return false;
        }
        if (zzS() || zzaC()) {
            return true;
        }
        return this.zzN != -9223372036854775807L && zzM().zzb() < this.zzN;
    }

    public final float zzbb() {
        return this.zzv;
    }

    public final zzmz zzbc() {
        return this.zzs;
    }

    public final boolean zzbd() {
        return zzbo(this.zzy);
    }

    public final long zzbe() {
        return this.zzah.zzf;
    }

    public final long zzbf() {
        return this.zzad;
    }

    public final long zzbg() {
        return this.zzah.zzd;
    }

    public final long zzbh() {
        return this.zzah.zzc;
    }

    public final void zzbi(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.zzan.zzb(mediaFormat);
        }
    }

    public final /* synthetic */ void zzbk(zzlw zzlwVar) {
        this.zzn.set(zzQ(zzlwVar, this.zzh, 0));
    }

    public final /* synthetic */ zzmz zzbl() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final int zzu() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzmv
    public void zzx(int i, Object obj) {
        if (i != 11) {
            return;
        }
        zzmz zzmzVar = (zzmz) obj;
        zzmzVar.getClass();
        this.zzs = zzmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public void zzy(boolean z, boolean z2) {
        this.zza = new zzjb();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zzz(zzv[] zzvVarArr, long j, long j2, zzxk zzxkVar) {
        if (this.zzah.zzd == -9223372036854775807L) {
            zzbs(new zzvs(-9223372036854775807L, j, j2));
            if (this.zzak) {
                zzar();
                return;
            }
            return;
        }
        ArrayDeque arrayDeque = this.zzl;
        if (arrayDeque.isEmpty()) {
            long j3 = this.zzad;
            if (j3 != -9223372036854775807L) {
                long j4 = this.zzai;
                if (j4 != -9223372036854775807L) {
                }
            }
            zzbs(new zzvs(-9223372036854775807L, j, j2));
            if (this.zzah.zzd != -9223372036854775807L) {
                zzar();
                return;
            }
            return;
        }
        arrayDeque.add(new zzvs(this.zzad, j, j2));
    }
}
