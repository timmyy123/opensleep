package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zztd implements zzrf {
    private final Context zza;
    private final zztc zzb;
    private final float zzc;
    private zzef zzd;
    private zzdo zze;
    private zzqh zzf;
    private zzqn zzg;
    private Looper zzh;
    private Context zzi;
    private final zzth zzj;

    public /* synthetic */ zztd(zztb zztbVar, byte[] bArr) {
        this.zza = zztbVar.zzd();
        zzth zzthVarZzg = zztbVar.zzg();
        zzthVarZzg.getClass();
        this.zzj = zzthVarZzg;
        this.zzf = zztbVar.zze();
        this.zzb = zztbVar.zzd() != null ? new zztc(this, null) : null;
        this.zzc = 8.0f;
        this.zze = zzdo.zza;
    }

    private final void zzk(zzqy zzqyVar) {
        Context context;
        zzl();
        zzqn zzqnVar = this.zzg;
        if (zzqnVar == null && (context = this.zza) != null) {
            zzqn zzqnVar2 = new zzqn(context, new zzqm() { // from class: com.google.android.gms.internal.ads.zzta
                @Override // com.google.android.gms.internal.ads.zzqm
                public final /* synthetic */ void zza(zzqh zzqhVar) {
                    this.zza.zzh(zzqhVar);
                }
            }, zzqyVar.zzb, zzqyVar.zzc);
            this.zzg = zzqnVar2;
            this.zzf = zzqnVar2.zzd();
        } else if (zzqnVar != null) {
            AudioDeviceInfo audioDeviceInfo = zzqyVar.zzc;
            if (audioDeviceInfo != null) {
                zzqnVar.zzc(audioDeviceInfo);
            }
            this.zzg.zzb(zzqyVar.zzb);
        }
        this.zzf.getClass();
    }

    private final void zzl() {
        if (this.zza == null) {
            return;
        }
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zzh;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        String strZzm = zzm(looper);
        String strZzm2 = zzm(looperMyLooper);
        if (z) {
            this.zzh = looperMyLooper;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzgua.zzd("AudioTrackAudioOutputProvider accessed on multiple threads: %s and %s", strZzm, strZzm2));
        }
    }

    private static String zzm(Looper looper) {
        return looper == null ? "null" : looper.getThread().getName();
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final zzra zza(zzqy zzqyVar) {
        zzk(zzqyVar);
        zzth zzthVar = this.zzj;
        zzv zzvVar = zzqyVar.zza;
        zzd zzdVar = zzqyVar.zzb;
        zzqs zzqsVarZza = zzthVar.zza(zzvVar, zzdVar);
        zzqz zzqzVar = new zzqz();
        int i = 0;
        if (!Objects.equals(zzvVar.zzp, "audio/raw") ? this.zzf.zzf(zzvVar, zzdVar) != null : zzvVar.zzJ == 2) {
            i = 2;
        }
        zzqzVar.zzd(i);
        zzqzVar.zza(zzqsVarZza.zzb);
        zzqzVar.zzb(zzqsVarZza.zzc);
        zzqzVar.zzc(zzqsVarZza.zzd);
        return zzqzVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final zzre zzb(zzqy zzqyVar) throws zzqw {
        int i;
        int iIntValue;
        int i2;
        int iZzG;
        int i3;
        zzk(zzqyVar);
        zzv zzvVar = zzqyVar.zza;
        String str = zzvVar.zzp;
        if (Objects.equals(str, "audio/raw")) {
            int i4 = zzvVar.zzJ;
            zzgtj.zza(zzfl.zzD(i4));
            i = zzvVar.zzI;
            int i5 = zzvVar.zzH;
            iIntValue = zzfl.zzE(i5);
            iZzG = zzfl.zzG(i4) * i5;
            i3 = i4;
            i2 = 0;
        } else {
            i = zzvVar.zzI;
            zzqs zzqsVar = zzqs.zza;
            Pair pairZzf = this.zzf.zzf(zzvVar, zzqyVar.zzb);
            if (pairZzf == null) {
                throw new zzqw("Unable to configure passthrough for: ".concat(String.valueOf(zzvVar)));
            }
            int iIntValue2 = ((Integer) pairZzf.first).intValue();
            iIntValue = ((Integer) pairZzf.second).intValue();
            i2 = 2;
            iZzG = -1;
            i3 = iIntValue2;
        }
        int i6 = i;
        int i7 = zzvVar.zzj;
        if (Objects.equals(str, "audio/vnd.dts.hd;profile=lbr") && i7 == -1) {
            i7 = 768000;
        }
        int i8 = i7;
        int iMax = zzqyVar.zzf;
        if (iMax == -1) {
            int i9 = iZzG;
            zzgtj.zzi(AudioTrack.getMinBufferSize(i6, iIntValue, i3) != -2);
            int i10 = i9 == -1 ? 1 : i9;
            iMax = (((Math.max(r7, zztt.zzb(r7, i3, i2, r10, i6, i8)) + i10) - 1) / i10) * i10;
        }
        zzrd zzrdVar = new zzrd();
        zzrdVar.zzb(i6);
        zzrdVar.zzc(iIntValue);
        zzrdVar.zza(i3);
        zzrdVar.zze(iMax);
        zzrdVar.zzg(zzqyVar.zzd);
        zzrdVar.zzf(zzqyVar.zzb);
        zzrdVar.zzd(false);
        zzrdVar.zzh(zzqyVar.zze);
        return new zzre(zzrdVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final void zzc(zzrc zzrcVar) {
        zzl();
        if (this.zzd == null) {
            this.zzd = new zzef(Thread.currentThread());
        }
        this.zzd.zzc(zzrcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final void zzd(zzdo zzdoVar) {
        this.zze = zzdoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final void zze() {
        zzef zzefVar = this.zzd;
        if (zzefVar != null) {
            zzefVar.zzg();
        }
        zzqn zzqnVar = this.zzg;
        if (zzqnVar != null) {
            zzqnVar.zze();
        }
    }

    public final zzsy zzf(zzre zzreVar) throws zzrb {
        Context context;
        try {
            int i = zzreVar.zzg;
            int i2 = zzreVar.zzh;
            Context context2 = null;
            if (i2 != -1 && (context = this.zza) != null && Build.VERSION.SDK_INT >= 34) {
                Context context3 = this.zzi;
                if (context3 == null || context3.getDeviceId() != i2) {
                    this.zzi = context.createDeviceContext(i2);
                }
                context2 = this.zzi;
                i = 0;
            }
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzreVar.zzf.zza()).setAudioFormat(new AudioFormat.Builder().setSampleRate(zzreVar.zzb).setChannelMask(zzreVar.zzc).setEncoding(zzreVar.zza).build()).setTransferMode(1).setBufferSizeInBytes(zzreVar.zze).setSessionId(i);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                sessionId.setOffloadedPlayback(false);
            }
            if (i3 >= 34 && context2 != null) {
                sessionId.setContext(context2);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            if (audioTrackBuild.getState() == 1) {
                return new zzsy(audioTrackBuild, zzreVar, this.zzb, this.zzc, this.zze);
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new zzrb();
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzrb(e);
        }
    }

    public final zzqh zzg() {
        return this.zzf;
    }

    public final void zzh(zzqh zzqhVar) {
        zzl();
        zzqh zzqhVar2 = this.zzf;
        if (zzqhVar2 == null || zzqhVar.equals(zzqhVar2)) {
            return;
        }
        this.zzf = zzqhVar;
        zzef zzefVar = this.zzd;
        if (zzefVar != null) {
            zzefVar.zze(-1, zzsz.zza);
            zzefVar.zzf();
        }
    }

    public final /* synthetic */ void zzi(zzqh zzqhVar) {
        this.zzf = zzqhVar;
    }

    public final /* synthetic */ zzqn zzj() {
        return this.zzg;
    }
}
