package com.facebook.ads.redexgen.core;

import android.media.AudioDeviceInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC03328z {
    void A59(C1981qI c1981qI, int i, int[] iArr) throws C03278s;

    void A5z();

    void A6M();

    void A6T();

    long A7f(boolean z);

    C1960px A8m();

    boolean A9e(ByteBuffer byteBuffer, long j, int i) throws C03318y, C03288t;

    void A9h();

    boolean A9o();

    boolean AAP();

    void AH0();

    void AH2() throws C03318y;

    void AJG(C1987qQ c1987qQ);

    void AJH(int i);

    void AJI(AnonymousClass21 anonymousClass21);

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Enable Retry Audio Track")
    void AJQ(boolean z);

    void AJV(InterfaceC03298v interfaceC03298v);

    void AJd(C1960px c1960px);

    void AJg(C8O c8o);

    void AJi(AudioDeviceInfo audioDeviceInfo);

    void AJo(boolean z);

    boolean AKN(C1981qI c1981qI);

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    boolean AKP(int i, int i2);

    void flush();

    void pause();

    void setVolume(float f);
}
