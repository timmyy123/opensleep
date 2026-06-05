package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Should be package private once we migrate to Factory pattern")
public interface DD {
    void A5y();

    long A7a();

    void AAB(InterfaceC1917pF interfaceC1917pF, Uri uri, Map<String, List<String>> map, long j, long j2, HA ha) throws IOException;

    int AHM(HV hv) throws IOException;

    void AHb();

    void AJ6(long j, long j2);
}
