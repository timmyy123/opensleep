package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzacn {
    private final ByteBuffer zza = ByteBuffer.allocateDirect(500);
    private zzgt zzb;

    private final void zzd(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (((zzgs) list.get(i)).zza == 1) {
                this.zzb = zzgt.zza((zzgs) list.get(i));
            }
        }
    }

    private final void zze() {
        ByteBuffer byteBuffer = this.zza;
        byteBuffer.position(byteBuffer.limit());
    }

    public final int zza(ByteBuffer byteBuffer, boolean z) {
        zzgt zzgtVar;
        zzgq zzgqVarZzb;
        ByteBuffer byteBuffer2 = this.zza;
        if (byteBuffer2.hasRemaining()) {
            zzd(zzgu.zza(byteBuffer2));
            zze();
        }
        List listZza = zzgu.zza(byteBuffer);
        zzd(listZza);
        int size = listZza.size() - 1;
        int i = 0;
        while (size >= 0) {
            zzgs zzgsVar = (zzgs) listZza.get(size);
            int i2 = zzgsVar.zza;
            if (i2 != 2 && i2 != 15) {
                if (i2 == 3) {
                    if (!z) {
                        break;
                    }
                    i2 = 3;
                }
                if ((i2 != 6 && i2 != 3) || (zzgtVar = this.zzb) == null || (zzgqVarZzb = zzgq.zzb(zzgtVar, zzgsVar)) == null || zzgqVarZzb.zza()) {
                    break;
                }
            }
            if (((zzgs) listZza.get(size)).zza == 6 || ((zzgs) listZza.get(size)).zza == 3) {
                i++;
            }
            size--;
        }
        return (i > 1 || size + 1 >= 8) ? byteBuffer.limit() : size >= 0 ? ((zzgs) listZza.get(size)).zzb.limit() : byteBuffer.position();
    }

    public final void zzb(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, iPosition + 500));
        ByteBuffer byteBuffer2 = this.zza;
        byteBuffer2.clear();
        byteBuffer2.put(byteBuffer);
        byteBuffer2.flip();
        byteBuffer.position(iPosition);
        byteBuffer.limit(iLimit);
    }

    public final void zzc() {
        this.zzb = null;
        zze();
    }
}
