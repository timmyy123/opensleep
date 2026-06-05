package kotlinx.io.unsafe;

import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlinx.io.Segment;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lkotlinx/io/unsafe/SegmentReadContext;", "", "getUnchecked", "", "segment", "Lkotlinx/io/Segment;", SpotifyService.OFFSET, "", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SegmentReadContext {
    byte getUnchecked(Segment segment, int offset);
}
