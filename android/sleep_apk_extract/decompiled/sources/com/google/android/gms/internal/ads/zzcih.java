package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcih implements zzhp {
    private final Context zza;
    private final zzhp zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbhb zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private zzht zzl;

    public zzcih(Context context, zzhp zzhpVar, String str, int i, zzin zzinVar, zzcig zzcigVar) {
        this.zza = context;
        this.zzb = zzhpVar;
        this.zzc = str;
        this.zzd = i;
        new AtomicLong(-1L);
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue();
    }

    private final boolean zzf() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfn)).booleanValue() || this.zzj) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfo)).booleanValue() && !this.zzk;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzg) {
            InputStream inputStream = this.zzf;
            return inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
        }
        OggIO$$ExternalSyntheticBUOutline0.m("Attempt to read closed CacheDataSource.");
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws IOException {
        Long l;
        if (this.zzg) {
            OggIO$$ExternalSyntheticBUOutline0.m("Attempt to open an already open CacheDataSource.");
            return 0L;
        }
        this.zzg = true;
        Uri uri = zzhtVar.zza;
        this.zzh = uri;
        this.zzl = zzhtVar;
        this.zzi = zzbhb.zza(uri);
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfk)).booleanValue();
        zzbhb zzbhbVar = this.zzi;
        zzbgy zzbgyVarZzc = null;
        if (!zBooleanValue) {
            if (zzbhbVar != null) {
                this.zzi.zzh = zzhtVar.zze;
                this.zzi.zzi = zzgua.zza(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbgyVarZzc = com.google.android.gms.ads.internal.zzt.zzj().zzc(this.zzi);
            }
            if (zzbgyVarZzc != null && zzbgyVarZzc.zza()) {
                this.zzj = zzbgyVarZzc.zzg();
                this.zzk = zzbgyVarZzc.zze();
                if (!zzf()) {
                    this.zzf = zzbgyVarZzc.zzb();
                    return -1L;
                }
            }
        } else if (zzbhbVar != null) {
            this.zzi.zzh = zzhtVar.zze;
            this.zzi.zzi = zzgua.zza(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfm);
            } else {
                l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfl);
            }
            long jLongValue = l.longValue();
            com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
            com.google.android.gms.ads.internal.zzt.zzz();
            Future futureZza = zzbhm.zza(this.zza, this.zzi);
            try {
                try {
                    zzbhn zzbhnVar = (zzbhn) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                    zzbhnVar.zzc();
                    this.zzj = zzbhnVar.zzd();
                    this.zzk = zzbhnVar.zzf();
                    zzbhnVar.zze();
                    if (!zzf()) {
                        this.zzf = zzbhnVar.zzb();
                    }
                } catch (InterruptedException unused) {
                    futureZza.cancel(false);
                    Thread.currentThread().interrupt();
                } catch (ExecutionException | TimeoutException unused2) {
                    futureZza.cancel(false);
                }
            } catch (Throwable unused3) {
            }
            com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
            throw null;
        }
        if (this.zzi != null) {
            zzhs zzhsVarZzb = zzhtVar.zzb();
            zzhsVarZzb.zza(Uri.parse(this.zzi.zza));
            this.zzl = zzhsVarZzb.zze();
        }
        return this.zzb.zzb(this.zzl);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws IOException {
        if (!this.zzg) {
            OggIO$$ExternalSyntheticBUOutline0.m("Attempt to close an already closed CacheDataSource.");
            return;
        }
        this.zzg = false;
        this.zzh = null;
        InputStream inputStream = this.zzf;
        if (inputStream == null) {
            this.zzb.zzd();
        } else {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
    }
}
