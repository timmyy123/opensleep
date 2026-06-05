package kotlinx.io;

import com.facebook.share.internal.ShareConstants;
import java.io.Flushable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lkotlinx/io/RawSink;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Ljava/io/Flushable;", "Lkotlinx/io/Buffer;", ShareConstants.FEED_SOURCE_PARAM, "", "byteCount", "", "write", "(Lkotlinx/io/Buffer;J)V", "close", "()V", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RawSink extends AutoCloseable, Flushable {
    void close();

    void write(Buffer source, long byteCount);
}
