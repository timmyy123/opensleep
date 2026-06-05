package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes3.dex */
final class zzva extends zziv {
    private long zzg;
    private int zzh;
    private int zzi;

    public zzva() {
        super(2, 0);
        this.zzi = 32;
    }

    @Override // com.google.android.gms.internal.ads.zziv, com.google.android.gms.internal.ads.zziq
    public final void zza() {
        super.zza();
        this.zzh = 0;
    }

    public final void zzm(int i) {
        this.zzi = i;
    }

    public final long zzn() {
        return this.zzg;
    }

    public final int zzo() {
        return this.zzh;
    }

    public final boolean zzp() {
        return this.zzh > 0;
    }

    public final boolean zzq(zziv zzivVar) {
        ByteBuffer byteBuffer;
        zzgtj.zza(!zzivVar.zzi(1073741824));
        zzgtj.zza(!zzivVar.zzi(ClientDefaults.MAX_MSG_SIZE));
        zzgtj.zza(!zzivVar.zzi(4));
        if (zzp()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzivVar.zzc;
            if (byteBuffer2 != null && (byteBuffer = this.zzc) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i = this.zzh;
        this.zzh = i + 1;
        if (i == 0) {
            this.zze = zzivVar.zze;
            if (zzivVar.zzi(1)) {
                zzg(1);
            }
        }
        ByteBuffer byteBuffer3 = zzivVar.zzc;
        if (byteBuffer3 != null) {
            zzj(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzivVar.zze;
        return true;
    }
}
