package io.ktor.utils.io;

import com.facebook.share.internal.ShareConstants;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"", "content", "", SpotifyService.OFFSET, "length", "Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "([BII)Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/io/Source;", ShareConstants.FEED_SOURCE_PARAM, "(Lkotlinx/io/Source;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ByteChannelCtorKt {
    public static final ByteReadChannel ByteReadChannel(byte[] bArr, int i, int i2) {
        bArr.getClass();
        Buffer buffer = new Buffer();
        buffer.write(bArr, i, i2 + i);
        return ByteReadChannel(buffer);
    }

    public static /* synthetic */ ByteReadChannel ByteReadChannel$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return ByteReadChannel(bArr, i, i2);
    }

    public static final ByteReadChannel ByteReadChannel(Source source) {
        source.getClass();
        return new SourceByteReadChannel(source);
    }
}
