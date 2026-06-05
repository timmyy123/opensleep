package com.google.android.gms.internal.nearby;

import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhc {
    private final ExecutorService zza;
    private final SimpleArrayMap zzb;
    private volatile boolean zzc;
    private final SimpleArrayMap zzd;
    private final SimpleArrayMap zze;

    public zzhc() {
        zzn.zza();
        ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactoryDefaultThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zzb = new SimpleArrayMap();
        this.zzc = false;
        this.zzd = new SimpleArrayMap();
        this.zze = new SimpleArrayMap();
    }

    public static /* bridge */ /* synthetic */ void zza(zzhc zzhcVar, OutputStream outputStream, boolean z, long j) {
        try {
            try {
                outputStream.write(z ? 1 : 0);
            } catch (IOException e) {
                Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", Long.valueOf(j)), e);
            }
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    public final synchronized void zzb(long j) {
        SimpleArrayMap simpleArrayMap = this.zzb;
        Long lValueOf = Long.valueOf(j);
        IOUtils.closeQuietly((Closeable) simpleArrayMap.get(lValueOf));
        this.zzb.remove(lValueOf);
        IOUtils.closeQuietly((Closeable) this.zzd.get(lValueOf));
        this.zzd.remove(lValueOf);
        zzhk zzhkVar = (zzhk) this.zze.remove(lValueOf);
        if (zzhkVar != null) {
            IOUtils.closeQuietly(zzhkVar.zzf());
            IOUtils.closeQuietly(zzhkVar.zzg());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final synchronized void zzc(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2, zzhk zzhkVar, long j) throws Throwable {
        try {
            try {
                SimpleArrayMap simpleArrayMap = this.zzb;
                Long lValueOf = Long.valueOf(j);
                simpleArrayMap.put(lValueOf, inputStream);
                this.zzd.put(lValueOf, outputStream);
                this.zze.put(lValueOf, zzhkVar);
                this.zza.execute(new zzhb(this, inputStream, outputStream, j, outputStream2));
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = this;
            Throwable th22 = th;
            throw th22;
        }
    }

    public final synchronized void zzd() {
        SimpleArrayMap simpleArrayMap;
        SimpleArrayMap simpleArrayMap2;
        try {
            this.zzc = true;
            this.zza.shutdownNow();
            int i = 0;
            int i2 = 0;
            while (true) {
                int size = this.zzb.getSize();
                simpleArrayMap = this.zzb;
                if (i2 >= size) {
                    break;
                }
                IOUtils.closeQuietly((Closeable) simpleArrayMap.valueAt(i2));
                i2++;
            }
            simpleArrayMap.clear();
            int i3 = 0;
            while (true) {
                int size2 = this.zzd.getSize();
                simpleArrayMap2 = this.zzd;
                if (i3 >= size2) {
                    break;
                }
                IOUtils.closeQuietly((Closeable) simpleArrayMap2.valueAt(i3));
                i3++;
            }
            simpleArrayMap2.clear();
            while (true) {
                int size3 = this.zze.getSize();
                SimpleArrayMap simpleArrayMap3 = this.zze;
                if (i < size3) {
                    zzhk zzhkVar = (zzhk) simpleArrayMap3.valueAt(i);
                    IOUtils.closeQuietly(zzhkVar.zzf());
                    IOUtils.closeQuietly(zzhkVar.zzg());
                    i++;
                } else {
                    simpleArrayMap3.clear();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
