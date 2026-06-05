package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes3.dex */
public class zzvl extends zzit {
    public final int zza;

    public zzvl(Throwable th, zzvm zzvmVar) {
        super("Decoder failed: ".concat(String.valueOf(zzvmVar == null ? null : zzvmVar.zza)), th);
        boolean z = th instanceof MediaCodec.CodecException;
        if (z) {
            ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.zza = z ? ((MediaCodec.CodecException) th).getErrorCode() : 0;
    }
}
