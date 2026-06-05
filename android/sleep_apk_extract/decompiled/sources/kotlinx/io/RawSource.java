package kotlinx.io;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00060\u0002j\u0002`\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lkotlinx/io/RawSource;", "Lkotlin/AutoCloseable;", "Ljava/lang/AutoCloseable;", "readAtMostTo", "", "sink", "Lkotlinx/io/Buffer;", "byteCount", "close", "", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RawSource extends AutoCloseable {
    @Override // java.lang.AutoCloseable, kotlinx.io.RawSink
    void close();

    long readAtMostTo(Buffer sink, long byteCount);
}
