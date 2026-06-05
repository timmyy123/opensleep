package okhttp3.internal.sse;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/sse/ServerSentEventReader;", "", ShareConstants.FEED_SOURCE_PARAM, "Lokio/BufferedSource;", "callback", "Lokhttp3/internal/sse/ServerSentEventReader$Callback;", "(Lokio/BufferedSource;Lokhttp3/internal/sse/ServerSentEventReader$Callback;)V", "lastId", "", "completeEvent", "", "id", "type", "data", "Lokio/Buffer;", "processNextEvent", "", "Callback", "Companion", "okhttp-sse"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ServerSentEventReader {
    private static final ByteString CRLF;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Options options;
    private final Callback callback;
    private String lastId;
    private final BufferedSource source;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/sse/ServerSentEventReader$Callback;", "", "onEvent", "", "id", "", "type", "data", "onRetryChange", "timeMs", "", "okhttp-sse"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Callback {
        void onEvent(String id, String type, String data2);

        void onRetryChange(long timeMs);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/sse/ServerSentEventReader$Companion;", "", "()V", "CRLF", "Lokio/ByteString;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lokio/Options;", "getOptions", "()Lokio/Options;", "readData", "", "Lokio/BufferedSource;", "data", "Lokio/Buffer;", "readRetryMs", "", "okhttp-sse"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void readData(BufferedSource bufferedSource, Buffer buffer) {
            buffer.writeByte(10);
            bufferedSource.readFully(buffer, bufferedSource.indexOfElement(ServerSentEventReader.CRLF));
            bufferedSource.select(getOptions());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long readRetryMs(BufferedSource bufferedSource) {
            return Util.toLongOrDefault(bufferedSource.readUtf8LineStrict(), -1L);
        }

        public final Options getOptions() {
            return ServerSentEventReader.options;
        }

        private Companion() {
        }
    }

    static {
        Options.Companion companion = Options.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        options = companion.of(companion2.encodeUtf8("\r\n"), companion2.encodeUtf8("\r"), companion2.encodeUtf8("\n"), companion2.encodeUtf8("data: "), companion2.encodeUtf8("data:"), companion2.encodeUtf8("data\r\n"), companion2.encodeUtf8("data\r"), companion2.encodeUtf8("data\n"), companion2.encodeUtf8("id: "), companion2.encodeUtf8("id:"), companion2.encodeUtf8("id\r\n"), companion2.encodeUtf8("id\r"), companion2.encodeUtf8("id\n"), companion2.encodeUtf8("event: "), companion2.encodeUtf8("event:"), companion2.encodeUtf8("event\r\n"), companion2.encodeUtf8("event\r"), companion2.encodeUtf8("event\n"), companion2.encodeUtf8("retry: "), companion2.encodeUtf8("retry:"));
        CRLF = companion2.encodeUtf8("\r\n");
    }

    public ServerSentEventReader(BufferedSource bufferedSource, Callback callback) {
        bufferedSource.getClass();
        callback.getClass();
        this.source = bufferedSource;
        this.callback = callback;
    }

    private final void completeEvent(String id, String type, Buffer data2) throws EOFException {
        if (data2.getSize() != 0) {
            this.lastId = id;
            data2.skip(1L);
            this.callback.onEvent(id, type, data2.readUtf8());
        }
    }

    public final boolean processNextEvent() throws EOFException {
        String utf8LineStrict = this.lastId;
        Buffer buffer = new Buffer();
        while (true) {
            String utf8LineStrict2 = null;
            while (true) {
                BufferedSource bufferedSource = this.source;
                Options options2 = options;
                int iSelect = bufferedSource.select(options2);
                if (iSelect >= 0 && iSelect < 3) {
                    completeEvent(utf8LineStrict, utf8LineStrict2, buffer);
                    return true;
                }
                if (3 <= iSelect && iSelect < 5) {
                    INSTANCE.readData(this.source, buffer);
                } else if (5 <= iSelect && iSelect < 8) {
                    buffer.writeByte(10);
                } else if (8 <= iSelect && iSelect < 10) {
                    utf8LineStrict = this.source.readUtf8LineStrict();
                    if (utf8LineStrict.length() <= 0) {
                        utf8LineStrict = null;
                    }
                } else if (10 <= iSelect && iSelect < 13) {
                    utf8LineStrict = null;
                } else if (13 <= iSelect && iSelect < 15) {
                    utf8LineStrict2 = this.source.readUtf8LineStrict();
                    if (utf8LineStrict2.length() > 0) {
                    }
                } else if (15 > iSelect || iSelect >= 18) {
                    if (18 <= iSelect && iSelect < 20) {
                        long retryMs = INSTANCE.readRetryMs(this.source);
                        if (retryMs != -1) {
                            this.callback.onRetryChange(retryMs);
                        }
                    } else {
                        if (iSelect != -1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$1();
                            return false;
                        }
                        long jIndexOfElement = this.source.indexOfElement(CRLF);
                        if (jIndexOfElement == -1) {
                            return false;
                        }
                        this.source.skip(jIndexOfElement);
                        this.source.select(options2);
                    }
                }
            }
        }
    }
}
