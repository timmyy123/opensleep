package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcij {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzaus zzausVar;
        zzaur zzaurVar;
        long j = this.zza;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator it = new zzaun(new zzcii(byteBufferDuplicate), zzcin.zzb).zzc().iterator();
            while (true) {
                zzausVar = null;
                if (!it.hasNext()) {
                    zzaurVar = null;
                    break;
                }
                zzaup zzaupVar = (zzaup) it.next();
                if (zzaupVar instanceof zzaur) {
                    zzaurVar = (zzaur) zzaupVar;
                    break;
                }
            }
            Iterator it2 = zzaurVar.zzc().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzaup zzaupVar2 = (zzaup) it2.next();
                if (zzaupVar2 instanceof zzaus) {
                    zzausVar = (zzaus) zzaupVar2;
                    break;
                }
            }
            long jZzd = (zzausVar.zzd() * 1000) / zzausVar.zzc();
            this.zza = jZzd;
            return jZzd;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
