package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.Utility;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcjg extends zzcja implements zzin {
    private static final AtomicInteger zzo = new AtomicInteger(0);
    private String zzd;
    private final zzchm zze;
    private boolean zzf;
    private final zzcjf zzg;
    private final zzcij zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcjg(zzchn zzchnVar, zzchm zzchmVar) {
        super(zzchnVar);
        this.zze = zzchmVar;
        this.zzg = new zzcjf();
        this.zzh = new zzcij();
        this.zzk = new Object();
        this.zzl = (String) zzgth.zzd(zzchnVar != null ? zzchnVar.zzn() : null).zza("");
        this.zzm = zzchnVar != null ? zzchnVar.zzp() : 0;
        zzo.incrementAndGet();
    }

    public static int zzr() {
        return zzo.get();
    }

    public static final String zzv(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzg(str)));
    }

    private final void zzx() {
        int iZza = (int) this.zzg.zza();
        int iZza2 = (int) this.zzh.zza(this.zzi);
        int iPosition = this.zzi.position();
        int iRound = Math.round((iPosition / iZza) * iZza2);
        int iZzP = zzche.zzP();
        int iZzQ = zzche.zzQ();
        String str = this.zzd;
        zzn(str, zzv(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzP, iZzQ);
    }

    @Override // com.google.android.gms.internal.ads.zzcja, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzo.decrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zza(zzhp zzhpVar, zzht zzhtVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzb(zzhp zzhpVar, zzht zzhtVar, boolean z) {
        if (zzhpVar instanceof zzia) {
            this.zzg.zzb((zzia) zzhpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzc(zzhp zzhpVar, zzht zzhtVar, boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzd(zzhp zzhpVar, zzht zzhtVar, boolean z) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fa, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    @Override // com.google.android.gms.internal.ads.zzcja
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zze(String str) {
        String str2;
        String str3;
        Clock clock;
        long j;
        this.zzd = str;
        String str4 = "error";
        String strZzv = zzv(str);
        try {
            zzhw zzhwVar = new zzhw();
            zzhwVar.zzb(this.zzb);
            zzchm zzchmVar = this.zze;
            zzhwVar.zzc(zzchmVar.zzd);
            zzhwVar.zzd(zzchmVar.zze);
            zzhwVar.zze(true);
            zzhwVar.zzf(this);
            zzhp zzhpVarZza = zzhwVar.zza();
            if (zzchmVar.zzi) {
                zzhpVarZza = new zzcih(this.zza, zzhpVarZza, this.zzl, this.zzm, null, null);
            }
            zzhpVarZza.zzb(new zzht(Uri.parse(str), 0L, -1L, null));
            zzchn zzchnVar = (zzchn) this.zzc.get();
            if (zzchnVar != null) {
                zzchnVar.zzt(strZzv, this);
            }
            Clock clockZzk = com.google.android.gms.ads.internal.zzt.zzk();
            long jCurrentTimeMillis = clockZzk.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzam)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzal)).longValue();
            this.zzi = ByteBuffer.allocate(zzchmVar.zzc);
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            long j2 = jCurrentTimeMillis;
            while (true) {
                str2 = str4;
                try {
                    int iZza = zzhpVarZza.zza(bArr, 0, Math.min(this.zzi.remaining(), Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    if (iZza == -1) {
                        this.zzn = true;
                        zzp(str, strZzv, (int) this.zzh.zza(this.zzi));
                        break;
                    }
                    synchronized (this.zzk) {
                        clock = clockZzk;
                        try {
                            if (this.zzf) {
                                j = jCurrentTimeMillis;
                            } else {
                                j = jCurrentTimeMillis;
                                this.zzi.put(bArr, 0, iZza);
                            }
                        } finally {
                        }
                    }
                    if (this.zzi.remaining() <= 0) {
                        zzx();
                        break;
                    }
                    str3 = this.zzf;
                    try {
                        if (str3 != 0) {
                            int iLimit = this.zzi.limit();
                            StringBuilder sb = new StringBuilder(String.valueOf(iLimit).length() + 24);
                            sb.append("Precache abort at ");
                            sb.append(iLimit);
                            sb.append(" bytes");
                            throw new IOException(sb.toString());
                        }
                        long jCurrentTimeMillis2 = clock.currentTimeMillis();
                        if (jCurrentTimeMillis2 - j2 >= jLongValue) {
                            zzx();
                            j2 = jCurrentTimeMillis2;
                        }
                        if (jCurrentTimeMillis2 - j > 1000 * jLongValue2) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(jLongValue2).length() + 29);
                            sb2.append("Timeout exceeded. Limit: ");
                            sb2.append(jLongValue2);
                            sb2.append(" sec");
                            throw new IOException(sb2.toString());
                        }
                        str4 = str2;
                        clockZzk = clock;
                        jCurrentTimeMillis = j;
                    } catch (Exception e) {
                        e = e;
                        String canonicalName = e.getClass().getCanonicalName();
                        String message = e.getMessage();
                        String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length()), canonicalName, ":", message);
                        String strM2 = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strM.length() + String.valueOf(str).length() + 34), "Failed to preload url ", str, " Exception: ", strM);
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi(strM2);
                        zzq(str, strZzv, str3, strM);
                        return false;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str3 = str2;
                    String canonicalName2 = e.getClass().getCanonicalName();
                    String message2 = e.getMessage();
                    String strM3 = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length()), canonicalName2, ":", message2);
                    String strM22 = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strM3.length() + String.valueOf(str).length() + 34), "Failed to preload url ", str, " Exception: ", strM3);
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi(strM22);
                    zzq(str, strZzv, str3, strM3);
                    return false;
                }
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
        this.zzf = true;
    }

    public final String zzs() {
        return this.zzd;
    }

    public final boolean zzt() {
        return this.zzn;
    }

    public final ByteBuffer zzu() {
        synchronized (this.zzk) {
            try {
                ByteBuffer byteBuffer = this.zzi;
                if (byteBuffer != null && !this.zzj) {
                    byteBuffer.flip();
                    this.zzj = true;
                }
                this.zzf = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.zzi;
    }
}
