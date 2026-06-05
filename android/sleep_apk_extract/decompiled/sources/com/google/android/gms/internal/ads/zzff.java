package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
final class zzff implements zzdy {
    private Message zza;

    public /* synthetic */ zzff(byte[] bArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        this.zza = null;
        zzfg.zzo(this);
    }

    public final zzff zzb(Message message, zzfg zzfgVar) {
        this.zza = message;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        this.zza = null;
        zzfg.zzo(this);
        return zSendMessageAtFrontOfQueue;
    }
}
