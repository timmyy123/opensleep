package io.ktor.utils.io.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0015\u001a\u00020\b*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012*\f\b\u0007\u0010\u0001\"\u00020\u00002\u00020\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/io/Sink;", "BytePacketBuilder", "()Lkotlinx/io/Sink;", "Lkotlinx/io/Source;", InAppPurchaseConstants.METHOD_BUILD, "(Lkotlinx/io/Sink;)Lkotlinx/io/Source;", "", "buffer", "", SpotifyService.OFFSET, "length", "", "writeFully", "(Lkotlinx/io/Sink;[BII)V", "packet", "writePacket", "(Lkotlinx/io/Sink;Lkotlinx/io/Source;)V", "getSize", "(Lkotlinx/io/Sink;)I", "getSize$annotations", "(Lkotlinx/io/Sink;)V", "size", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class BytePacketBuilderKt {
    public static final Sink BytePacketBuilder() {
        return new Buffer();
    }

    public static final Source build(Sink sink) {
        sink.getClass();
        return sink.getBufferField();
    }

    public static final int getSize(Sink sink) {
        sink.getClass();
        return (int) sink.getBufferField().getSizeMut();
    }

    public static final void writeFully(Sink sink, byte[] bArr, int i, int i2) {
        sink.getClass();
        bArr.getClass();
        sink.write(bArr, i, i2 + i);
    }

    public static /* synthetic */ void writeFully$default(Sink sink, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(sink, bArr, i, i2);
    }

    public static final void writePacket(Sink sink, Source source) {
        sink.getClass();
        source.getClass();
        sink.transferFrom(source);
    }
}
