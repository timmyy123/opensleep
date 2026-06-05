package com.google.android.gms.internal.ads;

import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mp4parser.boxes.iso14496.part12.MovieHeaderBox;

/* JADX INFO: loaded from: classes3.dex */
final class zzcin extends zzaul {
    static final zzcin zzb = new zzcin();

    @Override // com.google.android.gms.internal.ads.zzaul
    public final zzaup zza(String str, byte[] bArr, String str2) {
        return MovieBox.TYPE.equals(str) ? new zzaur() : MovieHeaderBox.TYPE.equals(str) ? new zzaus() : new zzaut(str);
    }
}
