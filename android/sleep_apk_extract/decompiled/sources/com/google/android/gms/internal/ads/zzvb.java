package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzvb implements zzvh {
    private final Context zza;

    public zzvb(Context context, zzgub zzgubVar, zzgub zzgubVar2) {
        this.zza = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    @Override // com.google.android.gms.internal.ads.zzvh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzvj zzc(zzvg zzvgVar) throws Throwable {
        Context context;
        zzvm zzvmVar;
        MediaCodec mediaCodecCreateByCodecName;
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 || ((context = this.zza) != null && i >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            int iZzf = zzas.zzf(zzvgVar.zzc.zzp);
            zzeg.zzb("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzfl.zzS(iZzf)));
            zzut zzutVar = new zzut(iZzf);
            zzutVar.zza(true);
            return zzutVar.zzb(zzvgVar);
        }
        MediaCodec mediaCodec = null;
        try {
            zzvmVar = zzvgVar.zza;
            String str = zzvmVar.zza;
            Trace.beginSection("createCodec:".concat(str));
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        }
        try {
            Trace.beginSection("configureCodec");
            Surface surface = zzvgVar.zzd;
            int i2 = 0;
            if (surface == null && zzvmVar.zzh && i >= 35) {
                i2 = 8;
            }
            mediaCodecCreateByCodecName.configure(zzvgVar.zzb, surface, (MediaCrypto) null, i2);
            Trace.endSection();
            Trace.beginSection("startCodec");
            mediaCodecCreateByCodecName.start();
            Trace.endSection();
            return new zzwg(mediaCodecCreateByCodecName, zzvgVar.zzf, null);
        } catch (IOException e3) {
            e = e3;
            e = e;
            mediaCodec = mediaCodecCreateByCodecName;
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            e = e;
            mediaCodec = mediaCodecCreateByCodecName;
            if (mediaCodec != null) {
            }
            throw e;
        }
    }
}
