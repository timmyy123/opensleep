package com.facebook.ads.redexgen.core;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/video/framebasedlogging/VideoFrameInfo;", "", "videoId", "", "encodingTimestamp", "", "displayPlayerTimestamp", "displayUnixTimestamp", "<init>", "(Ljava/lang/String;JJJ)V", "getVideoId", "()Ljava/lang/String;", "getEncodingTimestamp", "()J", "setEncodingTimestamp", "(J)V", "getDisplayPlayerTimestamp", "setDisplayPlayerTimestamp", "getDisplayUnixTimestamp", "setDisplayUnixTimestamp", "audioTimestamp", "getAudioTimestamp", "setAudioTimestamp", SDKConstants.PARAM_VALUE, "viewable50Timestamp", "getViewable50Timestamp", "setViewable50Timestamp", "UNIT_CONVERSION_FACTOR", "", "toStringList", "", "fbandroid.java.com.facebook.video.framebasedlogging.framebasedlogging_an"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1526iT {
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public final String A06;
    public final int A05 = 100;
    public long A00 = -1;

    public C1526iT(String str, long j, long j2, long j3) {
        this.A06 = str;
        this.A03 = ((long) this.A05) * j;
        this.A01 = ((long) this.A05) * j2;
        this.A02 = ((long) this.A05) * j3;
        A0A(-1L);
    }

    /* JADX INFO: renamed from: A00, reason: from getter */
    public final long getA00() {
        return this.A00;
    }

    /* JADX INFO: renamed from: A01, reason: from getter */
    public final long getA01() {
        return this.A01;
    }

    /* JADX INFO: renamed from: A02, reason: from getter */
    public final long getA02() {
        return this.A02;
    }

    /* JADX INFO: renamed from: A03, reason: from getter */
    public final long getA03() {
        return this.A03;
    }

    /* JADX INFO: renamed from: A04, reason: from getter */
    public final long getA04() {
        return this.A04;
    }

    public final List<String> A05() {
        return AbstractC0354Af.A07(String.valueOf(this.A03), String.valueOf(this.A01), String.valueOf(this.A02));
    }

    public final void A06(long j) {
        this.A00 = j;
    }

    public final void A07(long j) {
        this.A01 = j;
    }

    public final void A08(long j) {
        this.A02 = j;
    }

    public final void A09(long j) {
        this.A03 = j;
    }

    public final void A0A(long j) {
        this.A04 = ((long) this.A05) * j;
    }
}
