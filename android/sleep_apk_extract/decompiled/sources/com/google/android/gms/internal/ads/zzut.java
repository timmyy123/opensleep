package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
public final class zzut implements zzvh {
    private final zzgub zza;
    private final zzgub zzb;
    private boolean zzc;

    public zzut(final int i) {
        zzgub zzgubVar = new zzgub() { // from class: com.google.android.gms.internal.ads.zzus
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzuu.zzw(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
            }
        };
        zzgub zzgubVar2 = new zzgub() { // from class: com.google.android.gms.internal.ads.zzur
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzuu.zzw(i, "ExoPlayer:MediaCodecQueueingThread:"));
            }
        };
        this.zza = zzgubVar;
        this.zzb = zzgubVar2;
        this.zzc = true;
    }

    public final void zza(boolean z) {
        this.zzc = true;
    }

    public final zzuu zzb(zzvg zzvgVar) throws Exception {
        Exception exc;
        MediaCodec mediaCodecCreateByCodecName;
        zzvk zzwhVar;
        int i;
        zzvm zzvmVar = zzvgVar.zza;
        String str = zzvmVar.zza;
        zzuu zzuuVar = null;
        try {
            StringBuilder sb = new StringBuilder(str.length() + 12);
            sb.append("createCodec:");
            sb.append(str);
            Trace.beginSection(sb.toString());
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                if (this.zzc && Build.VERSION.SDK_INT >= 36) {
                    zzwhVar = new zzwh(mediaCodecCreateByCodecName);
                    i = 4;
                } else {
                    zzwhVar = new zzux(mediaCodecCreateByCodecName, (HandlerThread) this.zzb.zza());
                    i = 0;
                }
                zzuu zzuuVar2 = new zzuu(mediaCodecCreateByCodecName, (HandlerThread) this.zza.zza(), zzwhVar, zzvgVar.zzf, null);
                try {
                    Trace.endSection();
                    Surface surface = zzvgVar.zzd;
                    if (surface == null && zzvmVar.zzh && Build.VERSION.SDK_INT >= 35) {
                        i |= 8;
                    }
                    zzuuVar2.zzt(zzvgVar.zzb, surface, null, i);
                    return zzuuVar2;
                } catch (Exception e) {
                    exc = e;
                    zzuuVar = zzuuVar2;
                    if (zzuuVar != null) {
                        zzuuVar.zzl();
                        throw exc;
                    }
                    if (mediaCodecCreateByCodecName == null) {
                        throw exc;
                    }
                    mediaCodecCreateByCodecName.release();
                    throw exc;
                }
            } catch (Exception e2) {
                exc = e2;
            }
        } catch (Exception e3) {
            exc = e3;
            mediaCodecCreateByCodecName = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final /* bridge */ /* synthetic */ zzvj zzc(zzvg zzvgVar) {
        throw null;
    }
}
