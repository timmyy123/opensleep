package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1846o6 implements B0 {
    public static String[] A03 = {"TBh0kDiSO0F5FU8B8W6", "Wu96YBEbp5", "GXHkztSg0E", "SVf9uR0CS1ZMhrygTfVGTHtgONFy9fbr", "ToJtFxraFZDV0Nhg1oJyUAeavZbRFz0H", "e4ZNDN8Q6QOy3wABZV9fSILWPV6YlB7H", "vAs40s3kLNqKh27SimoH5s3SjKwld5mw", "MzWq8aWYtfnIiGPN6xqzLuzHDFClSOvg"};
    public ByteBuffer[] A00;
    public ByteBuffer[] A01;
    public final MediaCodec A02;

    @MetaExoPlayerCustomization("This constructor is private in Exo r2.18.6 and builder pattern should be used.This can be fixed after MediaCodecPool.Java dependency is removed.Because the Factory calls start before allocating the adapter it can call getInputBuffers here. Butdo not do it while the constructor is public because start hasn't been called yet.See S358180")
    public C1846o6(MediaCodec mediaCodec) {
        this.A02 = mediaCodec;
    }

    public final /* synthetic */ void A00(InterfaceC0372Az interfaceC0372Az, MediaCodec mediaCodec, long j, long j2) {
        interfaceC0372Az.ADz(this, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    @MetaExoPlayerCustomization("Override is customization due to dependency on MediaCodec[Audio/Video]Renderer")
    public final void A58(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, Object obj) {
        this.A02.configure(mediaFormat, surface, mediaCrypto, i);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final int A5s() {
        return this.A02.dequeueInputBuffer(0L);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final int A5u(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.A02.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && C5C.A02 < 21) {
                this.A01 = this.A02.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final ByteBuffer A8J(int i) {
        if (C5C.A02 >= 21) {
            return this.A02.getInputBuffer(i);
        }
        ByteBuffer[] byteBufferArr = this.A00;
        if (A03[0].length() == 9) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[2] = "7Nv94jZvV7";
        strArr[1] = "iAeXpyFDwx";
        return ((ByteBuffer[]) C5C.A0f(byteBufferArr))[i];
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final ByteBuffer A8e(int i) {
        if (C5C.A02 >= 21) {
            return this.A02.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) C5C.A0f(this.A01))[i];
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final MediaFormat A8f() {
        return this.A02.getOutputFormat();
    }

    @Override // com.facebook.ads.redexgen.core.B0
    @MetaExoPlayerCustomization("Added in D39791066")
    public final Pair<Long, Integer> A8j() {
        return new Pair<>(0L, 0);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    @MetaExoPlayerCustomization("Added in D39791066")
    public final int A9K() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AHI(int i, int i2, int i3, long j, int i4) {
        this.A02.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AHK(int i, int i2, C02585z c02585z, long j, int i3) {
        this.A02.queueSecureInputBuffer(i, i2, c02585z.A00(), j, i3);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AHb() {
        this.A00 = null;
        this.A01 = null;
        this.A02.release();
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AHh(int i, long j) {
        this.A02.releaseOutputBuffer(i, j);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AHi(int i, boolean z) {
        this.A02.releaseOutputBuffer(i, z);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AJa(final InterfaceC0372Az interfaceC0372Az, Handler handler) {
        this.A02.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.facebook.ads.redexgen.X.Bb
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.A01.A00(interfaceC0372Az, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AJb(Surface surface) {
        this.A02.setOutputSurface(surface);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void AJs(int i) {
        this.A02.setVideoScalingMode(i);
    }

    @Override // com.facebook.ads.redexgen.core.B0
    public final void flush() {
        this.A02.flush();
    }

    @Override // com.facebook.ads.redexgen.core.B0
    @MetaExoPlayerCustomization
    public final void reset() {
        this.A02.reset();
    }

    @Override // com.facebook.ads.redexgen.core.B0
    @MetaExoPlayerCustomization("Could be revisited after upgrading MediaCodecRenderer")
    public final void start() {
        this.A02.start();
    }

    @Override // com.facebook.ads.redexgen.core.B0
    @MetaExoPlayerCustomization
    public final void stop() {
        this.A02.stop();
    }
}
