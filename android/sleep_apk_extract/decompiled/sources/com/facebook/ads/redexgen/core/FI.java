package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.FL;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface FI<T extends FL> {
    void AEc(T t, long j, long j2, boolean z);

    void AEe(T t, long j, long j2);

    FJ AEf(T t, long j, long j2, IOException iOException, int i);

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "For Media3 Migration Backward Compatibility")
    void AEi(T t, long j, long j2, int i);
}
