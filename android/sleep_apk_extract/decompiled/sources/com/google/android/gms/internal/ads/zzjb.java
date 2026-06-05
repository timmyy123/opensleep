package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjb {
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public int zzj;
    public long zzk;
    public int zzl;

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        int i4 = this.zzd;
        int i5 = this.zze;
        int i6 = this.zzf;
        int i7 = this.zzg;
        int i8 = this.zzh;
        int i9 = this.zzi;
        int i10 = this.zzj;
        long j = this.zzk;
        int i11 = this.zzl;
        String str = zzfl.zza;
        Locale locale = Locale.US;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", "\n queuedInputBuffers=");
        Fragment$$ExternalSyntheticOutline1.m(sbM, i3, "\n skippedInputBuffers=", i4, "\n renderedOutputBuffers=");
        Fragment$$ExternalSyntheticOutline1.m(sbM, i5, "\n skippedOutputBuffers=", i6, "\n droppedBuffers=");
        Fragment$$ExternalSyntheticOutline1.m(sbM, i7, "\n droppedInputBuffers=", i8, "\n maxConsecutiveDroppedBuffers=");
        Fragment$$ExternalSyntheticOutline1.m(sbM, i9, "\n droppedToKeyframeEvents=", i10, "\n totalVideoFrameProcessingOffsetUs=");
        sbM.append(j);
        sbM.append("\n videoFrameProcessingOffsetCount=");
        sbM.append(i11);
        sbM.append("\n}");
        return sbM.toString();
    }

    public final synchronized void zza() {
    }
}
