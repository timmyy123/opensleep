package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes3.dex */
final class zzaby extends Handler implements Runnable {
    final /* synthetic */ zzacd zza;
    private final zzabz zzb;
    private final long zzc;
    private zzabv zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaby(zzacd zzacdVar, Looper looper, zzabz zzabzVar, zzabv zzabvVar, int i, long j) {
        super(looper);
        Objects.requireNonNull(zzacdVar);
        this.zza = zzacdVar;
        this.zzb = zzabzVar;
        this.zzd = zzabvVar;
        this.zzc = j;
    }

    private final void zzd() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.zzc;
        zzabv zzabvVar = this.zzd;
        zzabvVar.getClass();
        zzabvVar.zzC(this.zzb, jElapsedRealtime, j, this.zzf);
        this.zze = null;
        zzacd zzacdVar = this.zza;
        zzaby zzabyVarZzj = zzacdVar.zzj();
        zzabyVarZzj.getClass();
        zzacdVar.zzi().execute(zzabyVarZzj);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        int i = message.what;
        if (i == 1) {
            zzd();
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        zzacd zzacdVar = this.zza;
        zzacdVar.zzk(null);
        long j = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - j;
        zzabv zzabvVar = this.zzd;
        zzabvVar.getClass();
        if (this.zzh) {
            zzabvVar.zzA(this.zzb, jElapsedRealtime, j2, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 2) {
            try {
                zzabvVar.zzB(this.zzb, jElapsedRealtime, j2);
                return;
            } catch (RuntimeException e) {
                zzeg.zzf("LoadTask", "Unexpected exception handling load completed", e);
                this.zza.zzl(new zzacc(e));
                return;
            }
        }
        if (i2 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i3 = this.zzf + 1;
        this.zzf = i3;
        zzabx zzabxVarZzz = zzabvVar.zzz(this.zzb, jElapsedRealtime, j2, iOException, i3);
        if (zzabxVarZzz.zzb() == 3) {
            zzacdVar.zzl(this.zze);
        } else if (zzabxVarZzz.zzb() != 2) {
            if (zzabxVarZzz.zzb() == 1) {
                this.zzf = 1;
            }
            zzb(zzabxVarZzz.zzc() != -9223372036854775807L ? zzabxVarZzz.zzc() : Math.min((this.zzf - 1) * 1000, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (!z) {
                zzabz zzabzVar = this.zzb;
                String simpleName = zzabzVar.getClass().getSimpleName();
                StringBuilder sb = new StringBuilder(simpleName.length() + 5);
                sb.append("load:");
                sb.append(simpleName);
                Trace.beginSection(sb.toString());
                try {
                    zzabzVar.zzc();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.zzi) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Exception e2) {
            if (this.zzi) {
                return;
            }
            zzeg.zzf("LoadTask", "Unexpected exception loading stream", e2);
            obtainMessage(3, new zzacc(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            if (this.zzi) {
                return;
            }
            zzeg.zzf("LoadTask", "OutOfMemory error loading stream", e3);
            obtainMessage(3, new zzacc(e3)).sendToTarget();
        } catch (Error e4) {
            if (!this.zzi) {
                zzeg.zzf("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        }
    }

    public final void zza(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzb(long j) {
        zzacd zzacdVar = this.zza;
        zzgtj.zzi(zzacdVar.zzj() == null);
        zzacdVar.zzk(this);
        if (j > 0) {
            sendEmptyMessageDelayed(1, j);
        } else {
            zzd();
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(1)) {
            this.zzh = true;
            removeMessages(1);
            if (!z) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.zzh = true;
                    this.zzb.zzb();
                    Thread thread = this.zzg;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            this.zza.zzk(null);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzabv zzabvVar = this.zzd;
            zzabvVar.getClass();
            zzabvVar.zzA(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }
}
