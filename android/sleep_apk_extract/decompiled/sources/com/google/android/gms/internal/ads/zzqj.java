package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzqj extends AudioDeviceCallback {
    final /* synthetic */ zzqn zza;

    public /* synthetic */ zzqj(zzqn zzqnVar, byte[] bArr) {
        Objects.requireNonNull(zzqnVar);
        this.zza = zzqnVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        this.zza.zzi();
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        String str = zzfl.zza;
        int length = audioDeviceInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzqn zzqnVar = this.zza;
            if (Objects.equals(audioDeviceInfoArr[i], zzqnVar.zzj())) {
                zzqnVar.zzk(null);
                break;
            }
            i++;
        }
        this.zza.zzi();
    }
}
