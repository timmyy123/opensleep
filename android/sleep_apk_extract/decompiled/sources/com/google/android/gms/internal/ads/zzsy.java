package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsy implements zzqv {
    private static final Object zza = new Object();
    private static ScheduledExecutorService zzb;
    private static int zzc;
    private final AudioTrack zzd;
    private final zzre zze;
    private final float zzf;
    private zzsp zzg;
    private final zztf zzh;
    private final boolean zzi;
    private final int zzj;
    private final zzsx zzk;
    private final zzef zzl = new zzef(Thread.currentThread());
    private boolean zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private int zzq;
    private final zztc zzs;

    /* JADX WARN: Multi-variable type inference failed */
    public zzsy(AudioTrack audioTrack, zzre zzreVar, zztc zztcVar, float f, zzdo zzdoVar) {
        this.zzd = audioTrack;
        this.zze = zzreVar;
        this.zzf = f;
        this.zzs = zztcVar;
        boolean zZzD = zzfl.zzD(zzreVar.zza);
        this.zzi = zZzD;
        if (zZzD) {
            this.zzj = zzfl.zzG(zzreVar.zza) * Integer.bitCount(zzreVar.zzc);
        } else {
            this.zzj = -1;
        }
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.zzh = new zztf(new zzsr(this, null), zzdoVar, audioTrack, zzreVar.zza, this.zzj, zzreVar.zze);
        if (zztcVar != null) {
            this.zzg = new zzsp(audioTrack, zztcVar, objArr2 == true ? 1 : 0);
        }
        this.zzk = zzg() ? new zzsx(this, objArr == true ? 1 : 0) : null;
    }

    public static /* synthetic */ void zzp(AudioTrack audioTrack, Handler handler, final zzef zzefVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzsj
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzsy.zzw(zzefVar);
                    }
                });
            }
            synchronized (zza) {
                try {
                    int i = zzc - 1;
                    zzc = i;
                    if (i == 0) {
                        ScheduledExecutorService scheduledExecutorService = zzb;
                        if (scheduledExecutorService == null) {
                            throw null;
                        }
                        scheduledExecutorService.shutdown();
                        zzb = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            if (handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzsk
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzsy.zzw(zzefVar);
                    }
                });
            }
            synchronized (zza) {
                try {
                    int i2 = zzc - 1;
                    zzc = i2;
                    if (i2 == 0) {
                        ScheduledExecutorService scheduledExecutorService2 = zzb;
                        if (scheduledExecutorService2 == null) {
                            throw null;
                        }
                        scheduledExecutorService2.shutdown();
                        zzb = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public final long zzs() {
        if (!this.zzi) {
            return this.zzo;
        }
        long j = this.zzn;
        int i = this.zzj;
        String str = zzfl.zza;
        return ((j + r2) - 1) / i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zzw(zzef zzefVar) {
        if (zzefVar.zzb()) {
            zzefVar.zze(-1, zzsh.zza);
            zzefVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zza() {
        this.zzh.zzb();
        if (!this.zzm || zzg()) {
            this.zzd.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zzb() {
        this.zzh.zzf();
        if (!this.zzm || zzg()) {
            this.zzd.pause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final boolean zzc(ByteBuffer byteBuffer, int i, long j) throws zzqu {
        zztc zztcVar;
        boolean z = this.zzi;
        if (!z && this.zzp == 0) {
            this.zzp = zztr.zzE(this.zze.zza, byteBuffer);
        }
        zzef zzefVar = this.zzl;
        if (zzefVar.zzb()) {
            zzs();
            int underrunCount = this.zzd.getUnderrunCount();
            int i2 = this.zzq;
            this.zzq = underrunCount;
            if (underrunCount > i2) {
                zzefVar.zze(-1, zzsi.zza);
                zzefVar.zzf();
            }
        }
        int iRemaining = byteBuffer.remaining();
        int iWrite = this.zzd.write(byteBuffer, byteBuffer.remaining(), 1);
        if (iWrite >= 0) {
            z = iWrite == iRemaining;
            if (z) {
                this.zzn += (long) iWrite;
                return z;
            }
            if (z) {
                this.zzo = (((long) this.zzp) * ((long) i)) + this.zzo;
            }
            return z;
        }
        if (iWrite != -6 && iWrite != -32) {
            z = false;
        }
        if (z && (zztcVar = this.zzs) != null) {
            zztd zztdVar = zztcVar.zza;
            if (zztdVar.zzj() != null) {
                zzqh zzqhVar = zzqh.zza;
                zztdVar.zzi(zzqhVar);
                zztdVar.zzj().zza(zzqhVar);
            }
        }
        throw new zzqu(iWrite, z);
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zzd() {
        if (this.zzm) {
            return;
        }
        this.zzm = true;
        this.zzh.zze(zzs());
        this.zzd.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zze() {
        if (this.zzh.zzc()) {
            this.zzd.pause();
        }
        if (Build.VERSION.SDK_INT >= 29 && zzg()) {
            zzsx zzsxVar = this.zzk;
            zzsxVar.getClass();
            zzsxVar.zza();
        }
        zzsp zzspVar = this.zzg;
        if (zzspVar != null) {
            zzspVar.zzd();
            this.zzg = null;
        }
        final AudioTrack audioTrack = this.zzd;
        final zzef zzefVar = this.zzl;
        final Handler handlerZzd = zzfl.zzd(null);
        synchronized (zza) {
            try {
                if (zzb == null) {
                    zzb = zzfl.zzh("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzsl
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzsy.zzp(audioTrack, handlerZzd, zzefVar);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zzf(float f) {
        this.zzd.setVolume(f);
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final boolean zzg() {
        return Build.VERSION.SDK_INT >= 29 && this.zzd.isOffloadedPlayback();
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final int zzh() {
        return this.zzd.getAudioSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final int zzi() {
        return this.zzd.getSampleRate();
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final long zzj() {
        return this.zzd.getBufferSizeInFrames();
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final long zzk() {
        return this.zzh.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final boolean zzl() {
        return this.zzh.zzd(zzs());
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zzm(zzqt zzqtVar) {
        this.zzl.zzc(zzqtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zzn(zzqf zzqfVar) {
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        LogSessionId logSessionIdZza = zzqfVar.zza();
        if (logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        this.zzd.setLogSessionId(logSessionIdZza);
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zzo(AudioDeviceInfo audioDeviceInfo) {
        this.zzd.setPreferredDevice(audioDeviceInfo);
    }

    public final /* synthetic */ AudioTrack zzt() {
        return this.zzd;
    }

    public final /* synthetic */ zzef zzu() {
        return this.zzl;
    }
}
