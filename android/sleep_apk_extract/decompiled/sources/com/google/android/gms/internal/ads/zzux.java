package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class zzux implements zzvk {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzds zzg;
    private boolean zzh;

    public zzux(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzds zzdsVar = new zzds(zzdo.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdsVar;
        this.zzf = new AtomicReference();
    }

    private static zzuw zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new zzuw();
                }
                return (zzuw) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static int[] zzj(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    private static byte[] zzk(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zza() {
        if (this.zzh) {
            return;
        }
        HandlerThread handlerThread = this.zzd;
        handlerThread.start();
        this.zze = new zzuv(this, handlerThread.getLooper());
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzb(int i, int i2, int i3, long j, int i4) {
        zzg();
        zzuw zzuwVarZzi = zzi();
        zzuwVarZzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        String str = zzfl.zza;
        handler.obtainMessage(1, zzuwVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzc(int i, int i2, zzis zzisVar, long j, int i3) {
        zzg();
        zzuw zzuwVarZzi = zzi();
        zzuwVarZzi.zza(i, 0, 0, j, i3);
        MediaCodec.CryptoInfo cryptoInfo = zzuwVarZzi.zzd;
        cryptoInfo.numSubSamples = zzisVar.zzf;
        cryptoInfo.numBytesOfClearData = zzj(zzisVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzj(zzisVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzk = zzk(zzisVar.zzb, cryptoInfo.key);
        bArrZzk.getClass();
        cryptoInfo.key = bArrZzk;
        byte[] bArrZzk2 = zzk(zzisVar.zza, cryptoInfo.iv);
        bArrZzk2.getClass();
        cryptoInfo.iv = bArrZzk2;
        cryptoInfo.mode = zzisVar.zzc;
        cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzisVar.zzg, zzisVar.zzh));
        Handler handler = this.zze;
        String str = zzfl.zza;
        handler.obtainMessage(2, zzuwVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzd(Bundle bundle) {
        zzg();
        Handler handler = this.zze;
        String str = zzfl.zza;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zze() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler == null) {
                    throw null;
                }
                handler.removeCallbacksAndMessages(null);
                zzds zzdsVar = this.zzg;
                zzdsVar.zzb();
                Handler handler2 = this.zze;
                if (handler2 == null) {
                    throw null;
                }
                handler2.obtainMessage(3).sendToTarget();
                zzdsVar.zzc();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Events$$ExternalSyntheticBUOutline0.m(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzf() {
        if (this.zzh) {
            zze();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzg() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final /* synthetic */ void zzh(Message message) {
        int i = message.what;
        zzuw zzuwVar = null;
        if (i == 1) {
            zzuw zzuwVar2 = (zzuw) message.obj;
            try {
                this.zzc.queueInputBuffer(zzuwVar2.zza, 0, zzuwVar2.zzc, zzuwVar2.zze, zzuwVar2.zzf);
            } catch (RuntimeException e) {
                AtomicReference atomicReference = this.zzf;
                while (!atomicReference.compareAndSet(null, e) && atomicReference.get() == null) {
                }
            }
            zzuwVar = zzuwVar2;
        } else if (i == 2) {
            zzuw zzuwVar3 = (zzuw) message.obj;
            int i2 = zzuwVar3.zza;
            MediaCodec.CryptoInfo cryptoInfo = zzuwVar3.zzd;
            long j = zzuwVar3.zze;
            int i3 = zzuwVar3.zzf;
            try {
                synchronized (zzb) {
                    this.zzc.queueSecureInputBuffer(i2, 0, cryptoInfo, j, i3);
                }
            } catch (RuntimeException e2) {
                AtomicReference atomicReference2 = this.zzf;
                while (!atomicReference2.compareAndSet(null, e2) && atomicReference2.get() == null) {
                }
            }
            zzuwVar = zzuwVar3;
        } else if (i == 3) {
            this.zzg.zza();
        } else if (i != 4) {
            AtomicReference atomicReference3 = this.zzf;
            IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(i));
            while (!atomicReference3.compareAndSet(null, illegalStateException) && atomicReference3.get() == null) {
            }
        } else {
            try {
                this.zzc.setParameters((Bundle) message.obj);
            } catch (RuntimeException e3) {
                AtomicReference atomicReference4 = this.zzf;
                while (!atomicReference4.compareAndSet(null, e3) && atomicReference4.get() == null) {
                }
            }
        }
        if (zzuwVar != null) {
            ArrayDeque arrayDeque = zza;
            synchronized (arrayDeque) {
                arrayDeque.add(zzuwVar);
            }
        }
    }
}
