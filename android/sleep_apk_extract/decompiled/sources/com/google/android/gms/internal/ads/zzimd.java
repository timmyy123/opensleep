package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.mp4parser.boxes.iso14496.part12.MovieHeaderBox;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzimd extends zzimb implements zzaup {
    private int zzg;

    public zzimd(String str) {
        super(MovieHeaderBox.TYPE);
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    public final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzauo.zzc(byteBuffer.get());
        zzauo.zzb(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
