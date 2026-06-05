package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqb implements zznp, zzqc {
    private boolean zzA;
    private final Context zza;
    private final zzqd zzc;
    private final PlaybackSession zzd;
    private String zzj;
    private PlaybackMetrics.Builder zzk;
    private int zzl;
    private zzau zzo;
    private zzqa zzp;
    private zzqa zzq;
    private zzqa zzr;
    private zzv zzs;
    private zzv zzt;
    private zzv zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;
    private final Executor zzb = zzdh.zza();
    private final zzbe zzf = new zzbe();
    private final zzbd zzg = new zzbd();
    private final HashMap zzi = new HashMap();
    private final HashMap zzh = new HashMap();
    private final long zze = SystemClock.elapsedRealtime();
    private int zzm = 0;
    private int zzn = 0;

    private zzqb(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzd = playbackSession;
        zzpu zzpuVar = new zzpu(zzpu.zza);
        this.zzc = zzpuVar;
        zzpuVar.zza(this);
    }

    private final void zzA(int i, long j, zzv zzvVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zze);
        if (zzvVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzvVar.zzo;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzvVar.zzp;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzvVar.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzvVar.zzj;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzvVar.zzw;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzvVar.zzx;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzvVar.zzH;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzvVar.zzI;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzvVar.zzd;
            if (str4 != null) {
                String str5 = zzfl.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = zzvVar.zzA;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzA = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzu(trackChangeEventBuild);
            }
        });
    }

    private final void zzB(zzbf zzbfVar, zzxk zzxkVar) {
        int iZze;
        PlaybackMetrics.Builder builder = this.zzk;
        if (zzxkVar == null || (iZze = zzbfVar.zze(zzxkVar.zza)) == -1) {
            return;
        }
        zzbd zzbdVar = this.zzg;
        int i = 0;
        zzbfVar.zzd(iZze, zzbdVar, false);
        zzbe zzbeVar = this.zzf;
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzag zzagVar = zzbeVar.zzd.zzb;
        if (zzagVar != null) {
            int iZzI = zzfl.zzI(zzagVar.zza);
            i = iZzI != 0 ? iZzI != 1 ? iZzI != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i);
        long j = zzbeVar.zzm;
        if (j != -9223372036854775807L && !zzbeVar.zzk && !zzbeVar.zzi && !zzbeVar.zzb()) {
            builder.setMediaDurationMillis(zzfl.zzr(j));
        }
        builder.setPlaybackType(true != zzbeVar.zzb() ? 1 : 2);
        this.zzA = true;
    }

    private final void zzC() {
        PlaybackMetrics.Builder builder = this.zzk;
        if (builder != null && this.zzA) {
            builder.setAudioUnderrunCount(this.zzz);
            this.zzk.setVideoFramesDropped(this.zzx);
            this.zzk.setVideoFramesPlayed(this.zzy);
            Long l = (Long) this.zzh.get(this.zzj);
            this.zzk.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.zzi.get(this.zzj);
            this.zzk.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.zzk.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.zzk.build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(playbackMetricsBuild);
                }
            });
        }
        this.zzk = null;
        this.zzj = null;
        this.zzz = 0;
        this.zzx = 0;
        this.zzy = 0;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzA = false;
    }

    private static int zzD(int i) {
        switch (zzfl.zzH(i)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE /* 6002 */:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /* 6003 */:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    public static zzqb zza(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzqb(context, mediaMetricsManager.createPlaybackSession());
    }

    private final boolean zzw(zzqa zzqaVar) {
        if (zzqaVar != null) {
            return zzqaVar.zzc.equals(this.zzc.zzf());
        }
        return false;
    }

    private final void zzx(long j, zzv zzvVar, int i) {
        if (Objects.equals(this.zzs, zzvVar)) {
            return;
        }
        int i2 = this.zzs == null ? 1 : 0;
        this.zzs = zzvVar;
        zzA(1, j, zzvVar, i2);
    }

    private final void zzy(long j, zzv zzvVar, int i) {
        if (Objects.equals(this.zzt, zzvVar)) {
            return;
        }
        int i2 = this.zzt == null ? 1 : 0;
        this.zzt = zzvVar;
        zzA(0, j, zzvVar, i2);
    }

    private final void zzz(long j, zzv zzvVar, int i) {
        if (Objects.equals(this.zzu, zzvVar)) {
            return;
        }
        int i2 = this.zzu == null ? 1 : 0;
        this.zzu = zzvVar;
        zzA(2, j, zzvVar, i2);
    }

    public final LogSessionId zzb() {
        return this.zzd.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzqc
    public final void zzc(zznn zznnVar, String str) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar == null || !zzxkVar.zzb()) {
            zzC();
            this.zzj = str;
            this.zzk = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.10.0-rc02");
            zzB(zznnVar.zzb, zzxkVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqc
    public final void zzd(zznn zznnVar, String str, boolean z) {
        zzxk zzxkVar = zznnVar.zzd;
        if ((zzxkVar == null || !zzxkVar.zzb()) && str.equals(this.zzj)) {
            zzC();
        }
        this.zzh.remove(str);
        this.zzi.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzde(zznn zznnVar, zzba zzbaVar, zzba zzbaVar2, int i) {
        if (i == 1) {
            this.zzv = true;
            i = 1;
        }
        this.zzl = i;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzdf(zznn zznnVar, zzxg zzxgVar) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar == null) {
            return;
        }
        zzv zzvVar = zzxgVar.zzb;
        zzvVar.getClass();
        zzqa zzqaVar = new zzqa(zzvVar, 0, this.zzc.zzb(zznnVar.zzb, zzxkVar));
        int i = zzxgVar.zza;
        if (i != 0) {
            if (i == 1) {
                this.zzq = zzqaVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.zzr = zzqaVar;
                return;
            }
        }
        this.zzp = zzqaVar;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzdg(zznn zznnVar, int i, long j, long j2) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar != null) {
            String strZzb = this.zzc.zzb(zznnVar.zzb, zzxkVar);
            HashMap map = this.zzi;
            Long l = (Long) map.get(strZzb);
            HashMap map2 = this.zzh;
            Long l2 = (Long) map2.get(strZzb);
            map.put(strZzb, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            map2.put(strZzb, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzdh(zznn zznnVar, zzjb zzjbVar) {
        this.zzx += zzjbVar.zzg;
        this.zzy += zzjbVar.zze;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0288  */
    @Override // com.google.android.gms.internal.ads.zznp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzdi(zzbb zzbbVar, zzno zznoVar) {
        int i;
        int i2;
        int iZzD;
        int i3;
        int errorCode;
        int iZzT;
        zzq zzqVar;
        int i4;
        int i5;
        if (zznoVar.zzc() == 0) {
            return;
        }
        for (int i6 = 0; i6 < zznoVar.zzc(); i6++) {
            int iZzd = zznoVar.zzd(i6);
            zznn zznnVarZza = zznoVar.zza(iZzd);
            zzqd zzqdVar = this.zzc;
            if (iZzd == 0) {
                zzqdVar.zzd(zznnVarZza);
            } else if (iZzd == 11) {
                zzqdVar.zze(zznnVarZza, this.zzl);
            } else {
                zzqdVar.zzc(zznnVarZza);
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zznoVar.zzb(0)) {
            zznn zznnVarZza2 = zznoVar.zza(0);
            if (this.zzk != null) {
                zzB(zznnVarZza2.zzb, zznnVarZza2.zzd);
            }
        }
        if (zznoVar.zzb(2) && this.zzk != null) {
            zzgwm zzgwmVarZza = zzbbVar.zzp().zza();
            int size = zzgwmVarZza.size();
            int i7 = 0;
            loop1: while (true) {
                if (i7 >= size) {
                    zzqVar = null;
                    break;
                }
                zzbm zzbmVar = (zzbm) zzgwmVarZza.get(i7);
                int i8 = 0;
                while (true) {
                    i5 = i7 + 1;
                    if (i8 < zzbmVar.zza) {
                        if (zzbmVar.zzc(i8) && (zzqVar = zzbmVar.zza(i8).zzt) != null) {
                            break loop1;
                        } else {
                            i8++;
                        }
                    }
                }
                i7 = i5;
            }
            if (zzqVar != null) {
                PlaybackMetrics.Builder builder = this.zzk;
                String str = zzfl.zza;
                int i9 = 0;
                while (true) {
                    if (i9 >= zzqVar.zzb) {
                        i4 = 1;
                        break;
                    }
                    UUID uuid = zzqVar.zza(i9).zza;
                    if (uuid.equals(zzg.zzd)) {
                        i4 = 3;
                        break;
                    } else if (uuid.equals(zzg.zze)) {
                        i4 = 2;
                        break;
                    } else {
                        if (uuid.equals(zzg.zzc)) {
                            i4 = 6;
                            break;
                        }
                        i9++;
                    }
                }
                builder.setDrmType(i4);
            }
        }
        if (zznoVar.zzb(1011)) {
            this.zzz++;
        }
        zzau zzauVar = this.zzo;
        if (zzauVar != null) {
            Context context = this.zza;
            int i10 = zzauVar.zza;
            if (i10 == 1001) {
                i3 = 20;
            } else {
                zzjk zzjkVar = (zzjk) zzauVar;
                boolean z = zzjkVar.zzc == 1;
                int i11 = zzjkVar.zzg;
                Throwable cause = zzauVar.getCause();
                cause.getClass();
                if (cause instanceof IOException) {
                    if (cause instanceof zzig) {
                        iZzT = ((zzig) cause).zzc;
                        i3 = 5;
                    } else if (cause instanceof zzat) {
                        iZzT = 0;
                        i3 = 11;
                    } else {
                        boolean z2 = cause instanceof zzie;
                        if (z2 || (cause instanceof zzio)) {
                            if (zzer.zza(context).zzc() == 1) {
                                iZzT = 0;
                                i3 = 3;
                            } else {
                                Throwable cause2 = cause.getCause();
                                if (cause2 instanceof UnknownHostException) {
                                    iZzT = 0;
                                    i3 = 6;
                                } else if (cause2 instanceof SocketTimeoutException) {
                                    iZzT = 0;
                                    i3 = 7;
                                } else if (z2 && ((zzie) cause).zzb == 1) {
                                    iZzT = 0;
                                    i3 = 4;
                                } else {
                                    iZzT = 0;
                                    i3 = 8;
                                }
                            }
                        } else if (i10 == 1002) {
                            i3 = 21;
                        } else if (cause instanceof zzuf) {
                            Throwable cause3 = cause.getCause();
                            cause3.getClass();
                            if (cause3 instanceof MediaDrm.MediaDrmStateException) {
                                errorCode = zzfl.zzT(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                iZzD = zzD(errorCode);
                                int i12 = iZzD;
                                iZzT = errorCode;
                                i3 = i12;
                            } else if (cause3 instanceof MediaDrmResetException) {
                                i3 = 27;
                            } else if (cause3 instanceof NotProvisionedException) {
                                i3 = 24;
                            } else if (cause3 instanceof DeniedByServerException) {
                                i3 = 29;
                            } else {
                                if (!(cause3 instanceof zzup)) {
                                    i3 = 30;
                                }
                                iZzT = 0;
                                i3 = 23;
                            }
                        } else if ((cause instanceof zzib) && (cause.getCause() instanceof FileNotFoundException)) {
                            Throwable cause4 = cause.getCause();
                            cause4.getClass();
                            Throwable cause5 = cause4.getCause();
                            if ((cause5 instanceof ErrnoException) && ((ErrnoException) cause5).errno == OsConstants.EACCES) {
                                i3 = 32;
                            } else {
                                iZzT = 0;
                                i3 = 31;
                            }
                        } else {
                            iZzT = 0;
                            i3 = 9;
                        }
                    }
                    final PlaybackErrorEvent playbackErrorEventBuild = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).setErrorCode(i3).setSubErrorCode(iZzT).setException(zzauVar).build();
                    this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzr(playbackErrorEventBuild);
                        }
                    });
                    this.zzA = true;
                    this.zzo = null;
                } else if (z) {
                    i3 = 35;
                    if (i11 != 0 && i11 != 1) {
                        if (z && i11 == 3) {
                            i3 = 15;
                        } else {
                            if (z && i11 == 2) {
                                iZzT = 0;
                                i3 = 23;
                            } else if (cause instanceof zzvp) {
                                iZzT = zzfl.zzT(((zzvp) cause).zzd);
                                i3 = 13;
                            } else {
                                iZzD = 14;
                                if (cause instanceof zzvl) {
                                    errorCode = ((zzvl) cause).zza;
                                } else if (cause instanceof OutOfMemoryError) {
                                    i3 = 14;
                                } else if (cause instanceof zzsa) {
                                    i3 = 17;
                                } else if (cause instanceof zzsd) {
                                    errorCode = ((zzsd) cause).zza;
                                    iZzD = 18;
                                } else if (cause instanceof MediaCodec.CryptoException) {
                                    errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                    iZzD = zzD(errorCode);
                                } else {
                                    i3 = 22;
                                }
                                int i122 = iZzD;
                                iZzT = errorCode;
                                i3 = i122;
                            }
                            final PlaybackErrorEvent playbackErrorEventBuild2 = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).setErrorCode(i3).setSubErrorCode(iZzT).setException(zzauVar).build();
                            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpz
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzr(playbackErrorEventBuild2);
                                }
                            });
                            this.zzA = true;
                            this.zzo = null;
                        }
                    }
                }
            }
            iZzT = 0;
            final PlaybackErrorEvent playbackErrorEventBuild22 = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).setErrorCode(i3).setSubErrorCode(iZzT).setException(zzauVar).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpz
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(playbackErrorEventBuild22);
                }
            });
            this.zzA = true;
            this.zzo = null;
        }
        if (zznoVar.zzb(2)) {
            zzbn zzbnVarZzp = zzbbVar.zzp();
            boolean zZzb = zzbnVarZzp.zzb(2);
            boolean zZzb2 = zzbnVarZzp.zzb(1);
            boolean zZzb3 = zzbnVarZzp.zzb(3);
            if (zZzb || zZzb2) {
                if (!zZzb) {
                    zzx(jElapsedRealtime, null, 0);
                }
                if (!zZzb2) {
                    zzy(jElapsedRealtime, null, 0);
                }
                if (!zZzb3) {
                    zzz(jElapsedRealtime, null, 0);
                }
            } else if (zZzb3) {
                zZzb3 = true;
                if (!zZzb) {
                }
                if (!zZzb2) {
                }
                if (!zZzb3) {
                }
            }
        }
        if (zzw(this.zzp)) {
            zzv zzvVar = this.zzp.zza;
            if (zzvVar.zzx != -1) {
                zzx(jElapsedRealtime, zzvVar, 0);
                this.zzp = null;
            }
        }
        if (zzw(this.zzq)) {
            zzy(jElapsedRealtime, this.zzq.zza, 0);
            this.zzq = null;
        }
        if (zzw(this.zzr)) {
            zzz(jElapsedRealtime, this.zzr.zza, 0);
            this.zzr = null;
        }
        switch (zzer.zza(this.zza).zzc()) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 9;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
            case 8:
            default:
                i = 1;
                break;
            case 7:
                i = 3;
                break;
            case 9:
                i = 8;
                break;
            case 10:
                i = 7;
                break;
        }
        if (i != this.zzn) {
            this.zzn = i;
            final NetworkEvent networkEventBuild = new NetworkEvent.Builder().setNetworkType(i).setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(networkEventBuild);
                }
            });
        }
        if (zzbbVar.zzh() != 2) {
            this.zzv = false;
        }
        if (((zznk) zzbbVar).zzI() == null) {
            this.zzw = false;
        } else if (zznoVar.zzb(10)) {
            this.zzw = true;
        }
        int iZzh = zzbbVar.zzh();
        if (this.zzv) {
            i2 = 5;
        } else if (this.zzw) {
            i2 = 13;
        } else {
            i2 = 4;
            if (iZzh == 4) {
                i2 = 11;
            } else if (iZzh == 2) {
                int i13 = this.zzm;
                i2 = (i13 == 0 || i13 == 2 || i13 == 12) ? 2 : !zzbbVar.zzk() ? 7 : zzbbVar.zzi() != 0 ? 10 : 6;
            } else if (iZzh != 3) {
                i2 = (iZzh != 1 || this.zzm == 0) ? this.zzm : 12;
            } else if (zzbbVar.zzk()) {
                i2 = zzbbVar.zzi() != 0 ? 9 : 3;
            }
        }
        if (this.zzm != i2) {
            this.zzm = i2;
            this.zzA = true;
            final PlaybackStateEvent playbackStateEventBuild = new PlaybackStateEvent.Builder().setState(this.zzm).setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(playbackStateEventBuild);
                }
            });
        }
        if (zznoVar.zzb(1028)) {
            this.zzc.zzg(zznoVar.zza(1028));
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzg(zznn zznnVar, zzau zzauVar) {
        this.zzo = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzh(zznn zznnVar, zzxb zzxbVar, zzxg zzxgVar, IOException iOException, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzp(zznn zznnVar, zzbv zzbvVar) {
        zzqa zzqaVar = this.zzp;
        if (zzqaVar != null) {
            zzv zzvVar = zzqaVar.zza;
            if (zzvVar.zzx == -1) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzv(zzbvVar.zzb);
                zztVarZza.zzw(zzbvVar.zzc);
                this.zzp = new zzqa(zztVarZza.zzO(), 0, zzqaVar.zzc);
            }
        }
    }

    public final /* synthetic */ void zzr(PlaybackErrorEvent playbackErrorEvent) {
        this.zzd.reportPlaybackErrorEvent(playbackErrorEvent);
    }

    public final /* synthetic */ void zzs(NetworkEvent networkEvent) {
        this.zzd.reportNetworkEvent(networkEvent);
    }

    public final /* synthetic */ void zzt(PlaybackStateEvent playbackStateEvent) {
        this.zzd.reportPlaybackStateEvent(playbackStateEvent);
    }

    public final /* synthetic */ void zzu(TrackChangeEvent trackChangeEvent) {
        this.zzd.reportTrackChangeEvent(trackChangeEvent);
    }

    public final /* synthetic */ void zzv(PlaybackMetrics playbackMetrics) {
        this.zzd.reportPlaybackMetrics(playbackMetrics);
    }
}
