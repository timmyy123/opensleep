package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.StreamKey;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8 {
    public String A00;
    public String A01;
    public List<StreamKey> A02;
    public byte[] A03;
    public byte[] A04;
    public final Uri A05;
    public final String A06;

    public C8(String str, Uri uri) {
        this.A06 = str;
        this.A05 = uri;
    }

    public final C8 A00(String str) {
        this.A00 = str;
        return this;
    }

    public final C8 A01(String str) {
        this.A01 = str;
        return this;
    }

    public final C8 A02(List<StreamKey> streamKeys) {
        this.A02 = streamKeys;
        return this;
    }

    public final C8 A03(byte[] bArr) {
        this.A03 = bArr;
        return this;
    }

    public final C8 A04(byte[] bArr) {
        this.A04 = bArr;
        return this;
    }

    public final DownloadRequest A05() {
        return new DownloadRequest(this.A06, this.A05, this.A01, this.A02 != null ? this.A02 : BP.A03(), this.A04, this.A00, this.A03, null);
    }
}
