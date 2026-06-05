package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zztx extends zzvt implements zzmb {
    private final Context zzb;
    private final zzru zzc;
    private final zzse zzd;
    private final zzvf zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzv zzi;
    private zzv zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztx(Context context, zzvh zzvhVar, zzvv zzvvVar, boolean z, Handler handler, zzrv zzrvVar, zzse zzseVar) {
        super(context.getApplicationContext(), 1, zzvhVar, zzvvVar, false, 44100.0f);
        zzvf zzvfVar = Build.VERSION.SDK_INT >= 35 ? new zzvf(zzve.zzb) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzseVar;
        this.zze = zzvfVar;
        this.zzp = -1000;
        this.zzc = new zzru(handler, zzrvVar);
        this.zzr = -9223372036854775807L;
        zzseVar.zza(new zztw(this, null));
    }

    private static List zzbm(zzvv zzvvVar, zzv zzvVar, boolean z, zzse zzseVar) {
        zzvm zzvmVarZza;
        return zzvVar.zzp == null ? zzgwm.zzi() : (!zzseVar.zzd(zzvVar) || (zzvmVarZza = zzwf.zza()) == null) ? zzwf.zzc(zzvvVar, zzvVar, false, false) : zzgwm.zzj(zzvmVarZza);
    }

    private final int zzbn(zzvm zzvmVar, zzv zzvVar) {
        "OMX.google.raw.decoder".equals(zzvmVar.zza);
        return zzvVar.zzq;
    }

    private final void zzbo() {
        long jZzg = this.zzd.zzg(zzab());
        if (jZzg != Long.MIN_VALUE) {
            if (!this.zzl) {
                jZzg = Math.max(this.zzk, jZzg);
            }
            this.zzk = jZzg;
            this.zzl = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzA(long j, boolean z, boolean z2) throws zzjk {
        super.zzA(j, z, z2);
        this.zzd.zzB();
        this.zzk = j;
        this.zzr = -9223372036854775807L;
        this.zzn = false;
        this.zzo = false;
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public final void zzB() {
        this.zzd.zzi();
        this.zzq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public final void zzC() {
        zzbo();
        this.zzq = false;
        this.zzd.zzA();
        this.zzo = false;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzD() {
        this.zzm = true;
        this.zzi = null;
        this.zzr = -9223372036854775807L;
        this.zzo = false;
        try {
            this.zzd.zzB();
            super.zzD();
        } catch (Throwable th) {
            super.zzD();
            throw th;
        } finally {
            this.zzc.zzg(((zzvt) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzE() {
        this.zzn = false;
        this.zzo = false;
        this.zzr = -9223372036854775807L;
        try {
            super.zzE();
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzC();
            }
        } catch (Throwable th) {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzC();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public final void zzF() {
        zzvf zzvfVar;
        this.zzd.zzD();
        if (Build.VERSION.SDK_INT < 35 || (zzvfVar = this.zze) == null) {
            return;
        }
        zzvfVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zznc
    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    public final /* synthetic */ zzvf zzaA() {
        return this.zze;
    }

    public final /* synthetic */ void zzaB(boolean z) {
        this.zzn = true;
    }

    public final /* synthetic */ void zzaC(boolean z) {
        this.zzo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzaa() {
        return this.zzd.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzab() {
        return super.zzab() && this.zzd.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final int zzae(zzvv zzvvVar, zzv zzvVar) {
        int i;
        boolean z;
        String str = zzvVar.zzp;
        if (!zzas.zza(str)) {
            return 128;
        }
        int i2 = zzvVar.zzO;
        boolean zZzbj = zzvt.zzbj(zzvVar);
        int i3 = 1;
        if (!zZzbj || (i2 != 0 && zzwf.zza() == null)) {
            i = 0;
        } else {
            zzse zzseVar = this.zzd;
            zzqs zzqsVarZzf = zzseVar.zzf(zzvVar);
            if (zzqsVarZzf.zzb) {
                i = true != zzqsVarZzf.zzc ? 512 : 1536;
                if (zzqsVarZzf.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (zzseVar.zzd(zzvVar)) {
                return i | 172;
            }
        }
        if (!"audio/raw".equals(str) || this.zzd.zzd(zzvVar)) {
            zzse zzseVar2 = this.zzd;
            if (zzseVar2.zzd(zzfl.zzA(2, zzvVar.zzH, zzvVar.zzI))) {
                List listZzbm = zzbm(zzvvVar, zzvVar, false, zzseVar2);
                if (!listZzbm.isEmpty()) {
                    if (zZzbj) {
                        zzvm zzvmVar = (zzvm) listZzbm.get(0);
                        Context context = this.zzb;
                        boolean zZzc = zzvmVar.zzc(context, zzvVar);
                        if (zZzc) {
                            z = true;
                        } else {
                            for (int i4 = 1; i4 < listZzbm.size(); i4++) {
                                zzvm zzvmVar2 = (zzvm) listZzbm.get(i4);
                                if (zzvmVar2.zzc(context, zzvVar)) {
                                    z = false;
                                    zZzc = true;
                                    zzvmVar = zzvmVar2;
                                    break;
                                }
                            }
                            z = true;
                        }
                        int i5 = true != zZzc ? 3 : 4;
                        int i6 = 8;
                        if (zZzc && zzvmVar.zze(zzvVar)) {
                            i6 = 16;
                        }
                        return i5 | i6 | 32 | (true != zzvmVar.zzg ? 0 : 64) | (true != z ? 0 : 128) | i;
                    }
                    i3 = 2;
                }
            }
        }
        return i3 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z) {
        return zzwf.zze(this.zzb, zzbm(zzvvVar, zzvVar, false, this.zzd), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final boolean zzag(zzv zzvVar) {
        zzK();
        return this.zzd.zzd(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f) {
        zzv[] zzvVarArrZzJ = zzJ();
        int length = zzvVarArrZzJ.length;
        int iZzbn = zzbn(zzvmVar, zzvVar);
        if (length != 1) {
            for (zzv zzvVar2 : zzvVarArrZzJ) {
                if (zzvmVar.zzf(zzvVar, zzvVar2).zzd != 0) {
                    iZzbn = Math.max(iZzbn, zzbn(zzvmVar, zzvVar2));
                }
            }
        }
        this.zzf = iZzbn;
        String str = zzvmVar.zza;
        this.zzg = false;
        this.zzh = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str2 = zzvmVar.zzc;
        int i = this.zzf;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        int i2 = zzvVar.zzH;
        mediaFormat.setInteger("channel-count", i2);
        int i3 = zzvVar.zzI;
        mediaFormat.setInteger("sample-rate", i3);
        zzej.zza(mediaFormat, zzvVar.zzs);
        zzej.zzb(mediaFormat, "max-input-size", i);
        mediaFormat.setInteger("priority", 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        String str3 = zzvVar.zzp;
        if ("audio/ac4".equals(str3)) {
            Pair pairZze = zzdq.zze(zzvVar);
            if (pairZze != null) {
                zzej.zzb(mediaFormat, "profile", ((Integer) pairZze.first).intValue());
                zzej.zzb(mediaFormat, "level", ((Integer) pairZze.second).intValue());
            }
            if (Build.VERSION.SDK_INT <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        if (this.zzd.zze(zzfl.zzA(4, i2, i3)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i4 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzp));
        }
        if (Objects.equals(str3, "audio/iamf")) {
            zzqh zzqhVarZzs = this.zzd.zzs();
            if (zzqhVarZzs == null) {
                zzeg.zzc("MediaCodecAudioRenderer", "AudioCapabilities from the AudioSink are null, using default stereo output layout.");
                mediaFormat.setInteger("channel-mask", 12);
                mediaFormat.setInteger("max-output-channel-count", 2);
            } else {
                int iZza = zztv.zza(zzqhVarZzs);
                int iBitCount = Integer.bitCount(iZza);
                mediaFormat.setInteger("channel-mask", iZza);
                mediaFormat.setInteger("max-output-channel-count", iBitCount);
            }
        }
        zzbi(mediaFormat);
        this.zzj = (!"audio/raw".equals(zzvmVar.zzb) || "audio/raw".equals(str3)) ? null : zzvVar;
        return zzvg.zza(zzvmVar, mediaFormat, zzvVar, null, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2) {
        int i;
        int i2;
        zzjc zzjcVarZzf = zzvmVar.zzf(zzvVar, zzvVar2);
        int i3 = zzjcVarZzf.zze;
        if (zzaF(zzvVar2)) {
            i3 |= 32768;
        }
        if (zzbn(zzvmVar, zzvVar2) > this.zzf) {
            i3 |= 64;
        }
        String str = zzvmVar.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzjcVarZzf.zzd;
        }
        return new zzjc(str, zzvVar, zzvVar2, i2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final long zzaj(long j, long j2, boolean z) {
        zzse zzseVar = this.zzd;
        boolean z2 = false;
        if (zzseVar.zzn() && this.zzr != -9223372036854775807L) {
            z2 = true;
        }
        if (!this.zzq) {
            return (z2 || super.zzab()) ? 1000000L : 10000L;
        }
        long jZzx = zzseVar.zzx();
        if (this.zzo && z2 && jZzx != -9223372036854775807L) {
            return Math.max(10000L, (long) ((Math.min(jZzx, this.zzr - j) / (zzj() != null ? zzj().zzb : 1.0f)) / 2.0f));
        }
        return 10000L;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final float zzak(float f, zzv zzvVar, zzv[] zzvVarArr) {
        int iMax = -1;
        for (zzv zzvVar2 : zzvVarArr) {
            int i = zzvVar2.zzI;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzal(String str, zzvg zzvgVar, long j, long j2) {
        this.zzc.zzb(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzam(String str) {
        this.zzc.zzf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzan(Exception exc) {
        zzeg.zzf("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final zzjc zzao(zzlw zzlwVar) throws zzjk {
        zzv zzvVar = zzlwVar.zzb;
        zzvVar.getClass();
        this.zzi = zzvVar;
        zzjc zzjcVarZzao = super.zzao(zzlwVar);
        this.zzc.zzc(zzvVar, zzjcVarZzao);
        return zzjcVarZzao;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzap(zzv zzvVar, MediaFormat mediaFormat) throws zzjk {
        int i;
        zzv zzvVar2 = this.zzj;
        zzhaf zzhafVarZza = null;
        if (zzvVar2 != null) {
            zzvVar = zzvVar2;
        } else if (zzaI() != null) {
            mediaFormat.getClass();
            int integer = "audio/raw".equals(zzvVar.zzp) ? zzvVar.zzJ : mediaFormat.containsKey("pcm-encoding") ? mediaFormat.getInteger("pcm-encoding") : mediaFormat.containsKey("v-bits-per-sample") ? zzfl.zzB(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2;
            zzt zztVar = new zzt();
            zztVar.zzo("audio/raw");
            zztVar.zzI(integer);
            zztVar.zzJ(zzvVar.zzK);
            zztVar.zzK(zzvVar.zzL);
            zztVar.zzl(zzvVar.zzl);
            zztVar.zza(zzvVar.zza);
            zztVar.zzc(zzvVar.zzb);
            zztVar.zzd(zzvVar.zzc);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzf(zzvVar.zze);
            zztVar.zzg(zzvVar.zzf);
            zztVar.zzG(mediaFormat.getInteger("channel-count"));
            zztVar.zzH(mediaFormat.getInteger("sample-rate"));
            zzv zzvVarZzO = zztVar.zzO();
            if (this.zzg && zzvVarZzO.zzH == 6 && (i = zzvVar.zzH) < 6) {
                zzhae zzhaeVarZzg = zzhaf.zzg(i);
                for (int i2 = 0; i2 < i; i2++) {
                    zzhaeVarZzg.zza(i2);
                }
                zzhafVarZza = zzhaeVarZzg.zzb();
            } else if (this.zzh) {
                zzhafVarZza = zzahm.zza(zzvVarZzO.zzH);
            }
            zzvVar = zzvVarZzO;
        }
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                if (zzaH()) {
                    zzK();
                }
                zzgtj.zzi(i3 >= 29);
            }
            zzse zzseVar = this.zzd;
            zzrw zzrwVar = new zzrw(zzvVar);
            zzrwVar.zza(zzhafVarZza);
            zzseVar.zzh(zzrwVar.zzb());
        } catch (zzrz e) {
            throw zzP(e, e.zza, false, 5001);
        }
    }

    public final void zzaq() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzar() {
        this.zzd.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final boolean zzas(long j, long j2, zzvj zzvjVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar) throws zzjk {
        byteBuffer.getClass();
        this.zzr = -9223372036854775807L;
        if (this.zzj != null && (i2 & 2) != 0) {
            zzvjVar.getClass();
            zzvjVar.zzc(i, false);
            return true;
        }
        if (z) {
            if (zzvjVar != null) {
                zzvjVar.zzc(i, false);
            }
            ((zzvt) this).zza.zzf += i3;
            this.zzd.zzj();
            return true;
        }
        try {
            if (!this.zzd.zzk(byteBuffer, j3, i3)) {
                this.zzr = j3;
                return false;
            }
            if (zzvjVar != null) {
                zzvjVar.zzc(i, false);
            }
            ((zzvt) this).zza.zze += i3;
            return true;
        } catch (zzsa e) {
            zzv zzvVar2 = this.zzi;
            if (zzaH()) {
                zzK();
            }
            throw zzP(e, zzvVar2, false, 5001);
        } catch (zzsd e2) {
            if (zzaH()) {
                zzK();
            }
            throw zzP(e2, zzvVar, e2.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzat(zziz zzizVar) {
        this.zzc.zzn(zzizVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzau() throws zzjk {
        try {
            this.zzd.zzl();
            if (zzbe() != -9223372036854775807L) {
                this.zzr = zzbe();
            }
        } catch (zzsd e) {
            throw zzP(e, e.zzc, e.zzb, true != zzaH() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzav(zziv zzivVar) {
        zzv zzvVar;
        if (Build.VERSION.SDK_INT < 29 || (zzvVar = zzivVar.zza) == null || !Objects.equals(zzvVar.zzp, "audio/opus") || !zzaH()) {
            return;
        }
        ByteBuffer byteBuffer = zzivVar.zzf;
        byteBuffer.getClass();
        zzv zzvVar2 = zzivVar.zza;
        zzvVar2.getClass();
        int i = zzvVar2.zzK;
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzy(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    public final /* synthetic */ zzru zzaz() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzna
    public final zzmb zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final long zzg() {
        if (zze() == 2) {
            zzbo();
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final boolean zzh() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzi(zzav zzavVar) {
        this.zzd.zzo(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final zzav zzj() {
        return this.zzd.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzmv
    public final void zzx(int i, Object obj) {
        zzvf zzvfVar;
        if (i == 2) {
            zzse zzseVar = this.zzd;
            obj.getClass();
            zzseVar.zzz(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zzd zzdVar = (zzd) obj;
            zzse zzseVar2 = this.zzd;
            zzdVar.getClass();
            zzseVar2.zzr(zzdVar);
            return;
        }
        if (i == 6) {
            zze zzeVar = (zze) obj;
            zzse zzseVar3 = this.zzd;
            zzeVar.getClass();
            zzseVar3.zzu(zzeVar);
            return;
        }
        if (i == 12) {
            this.zzd.zzv((AudioDeviceInfo) obj);
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.zzp = ((Integer) obj).intValue();
            zzvj zzvjVarZzaI = zzaI();
            if (zzvjVarZzaI == null || Build.VERSION.SDK_INT < 35) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.zzp));
            zzvjVarZzaI.zzp(bundle);
            return;
        }
        if (i == 19) {
            zzse zzseVar4 = this.zzd;
            obj.getClass();
            zzseVar4.zzw(((Integer) obj).intValue());
            return;
        }
        if (i == 9) {
            zzse zzseVar5 = this.zzd;
            obj.getClass();
            zzseVar5.zzq(((Boolean) obj).booleanValue());
        } else {
            if (i != 10) {
                super.zzx(i, obj);
                return;
            }
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            this.zzd.zzt(iIntValue);
            if (Build.VERSION.SDK_INT < 35 || (zzvfVar = this.zze) == null) {
                return;
            }
            zzvfVar.zza(iIntValue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzy(boolean z, boolean z2) {
        super.zzy(z, z2);
        this.zzc.zza(((zzvt) this).zza);
        zzK();
        zzse zzseVar = this.zzd;
        zzseVar.zzb(zzL());
        zzseVar.zzc(zzM());
    }
}
