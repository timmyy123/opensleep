package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ms, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC1772ms extends InterfaceC01612c {
    void A47(int i) throws IOException;

    boolean A48(int i, boolean z) throws IOException;

    long A8O();

    long A8i();

    long A8n();

    @MetaExoPlayerCustomization("Added API for MP4 extractor")
    Uri A9P();

    int AGs(byte[] bArr, int i, int i2) throws IOException;

    void AGt(byte[] bArr, int i, int i2) throws IOException;

    boolean AGu(byte[] bArr, int i, int i2, boolean z) throws IOException;

    boolean AHR(byte[] bArr, int i, int i2, boolean z) throws IOException;

    void AIl();

    int AK0(int i) throws IOException;

    void AK3(int i) throws IOException;

    @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
    int read(byte[] bArr, int i, int i2) throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;
}
