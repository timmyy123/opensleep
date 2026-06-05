package okio;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import org.mp4parser.boxes.iso14496.part12.FreeSpaceBox;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001c\u0010\rJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020$H&¢\u0006\u0004\b(\u0010)J\u001f\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b(\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u0017\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020\tH&¢\u0006\u0004\b,\u0010/J\u0017\u00102\u001a\u00020+2\u0006\u00101\u001a\u000200H&¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\u001dH&¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\u001dH&¢\u0006\u0004\b8\u00106J\u000f\u00109\u001a\u00020\u0000H&¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H&¢\u0006\u0004\b<\u0010=R\u0014\u0010\u0004\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0005\u0082\u0001\u0002\u0003?ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006@À\u0006\u0001"}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "", "exhausted", "()Z", "", "byteCount", "", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "", "readInt", "()I", "readLong", "()J", "readHexadecimalUnsignedLong", FreeSpaceBox.TYPE, "Lokio/ByteString;", "readByteString", "(J)Lokio/ByteString;", "Lokio/Options;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "select", "(Lokio/Options;)I", "", "readByteArray", "(J)[B", "sink", "readFully", "([B)V", "(Lokio/Buffer;J)V", "", "readUtf8LineStrict", "()Ljava/lang/String;", SpotifyService.LIMIT, "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "bytes", "indexOf", "(Lokio/ByteString;)J", "targetBytes", "indexOfElement", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "getBuffer", "Lokio/RealBufferedSource;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer buffer();

    boolean exhausted();

    Buffer getBuffer();

    long indexOf(ByteString bytes);

    long indexOfElement(ByteString targetBytes);

    InputStream inputStream();

    BufferedSource peek();

    byte readByte();

    byte[] readByteArray(long byteCount);

    ByteString readByteString(long byteCount);

    void readFully(Buffer sink, long byteCount);

    void readFully(byte[] sink);

    long readHexadecimalUnsignedLong();

    int readInt();

    long readLong();

    short readShort();

    String readString(Charset charset);

    String readUtf8LineStrict();

    String readUtf8LineStrict(long limit);

    boolean request(long byteCount);

    void require(long byteCount);

    int select(Options options);

    void skip(long byteCount);
}
