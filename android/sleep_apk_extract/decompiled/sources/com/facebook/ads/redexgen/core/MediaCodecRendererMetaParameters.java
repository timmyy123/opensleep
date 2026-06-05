package com.facebook.ads.redexgen.core;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jN, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/MediaCodecRendererMetaParameters;", "", "mediaCodecPoolTracker", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker;", "appendReconfigurationDataForDrmContentFix", "", "<init>", "(Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker;Z)V", "getMediaCodecPoolTracker", "()Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker;", "getAppendReconfigurationDataForDrmContentFix", "()Z", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaCodecRendererMetaParameters {
    public final MediaCodecPoolTracker A00;
    public final boolean A01;

    public MediaCodecRendererMetaParameters(MediaCodecPoolTracker mediaCodecPoolTracker, boolean z) {
        this.A00 = mediaCodecPoolTracker;
        this.A01 = z;
    }

    /* JADX INFO: renamed from: A00, reason: from getter */
    public final MediaCodecPoolTracker getA00() {
        return this.A00;
    }

    /* JADX INFO: renamed from: A01, reason: from getter */
    public final boolean getA01() {
        return this.A01;
    }
}
