package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.mp4parser.boxes.iso14496.part12.MovieBox;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzimc extends zzimf implements zzaup {
    protected final String zza = MovieBox.TYPE;

    public zzimc(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void zzb(zzimg zzimgVar, ByteBuffer byteBuffer, long j, zzaum zzaumVar) {
        zzimgVar.zzc();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzimgVar;
        this.zze = zzimgVar.zzc();
        zzimgVar.zzd(zzimgVar.zzc() + j);
        this.zzf = zzimgVar.zzc();
        this.zzb = zzaumVar;
    }
}
