package org.apache.commons.io;

import com.facebook.internal.Utility;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public abstract class IOUtils {
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Deprecated
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String LINE_SEPARATOR_UNIX = StandardLineSeparator.LF.getString();
    public static final String LINE_SEPARATOR_WINDOWS = StandardLineSeparator.CRLF.getString();
    private static final ThreadLocal<byte[]> SKIP_BYTE_BUFFER;
    private static final ThreadLocal<char[]> SKIP_CHAR_BUFFER;

    static {
        final int i = 0;
        final Supplier supplier = new Supplier() { // from class: org.apache.commons.io.IOUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return IOUtils.byteArray();
                    default:
                        return IOUtils.charArray();
                }
            }
        };
        final int i2 = 0;
        SKIP_BYTE_BUFFER = new ThreadLocal() { // from class: org.apache.commons.io.IOUtils$$ExternalSyntheticThreadLocal2
            @Override // java.lang.ThreadLocal
            public final Object initialValue() {
                int i3 = i2;
                ((IOUtils$$ExternalSyntheticLambda0) supplier).getClass();
                switch (i3) {
                    case 0:
                        return IOUtils.byteArray();
                    default:
                        return IOUtils.charArray();
                }
            }
        };
        final int i3 = 1;
        final Supplier supplier2 = new Supplier() { // from class: org.apache.commons.io.IOUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i3) {
                    case 0:
                        return IOUtils.byteArray();
                    default:
                        return IOUtils.charArray();
                }
            }
        };
        final int i4 = 1;
        SKIP_CHAR_BUFFER = new ThreadLocal() { // from class: org.apache.commons.io.IOUtils$$ExternalSyntheticThreadLocal2
            @Override // java.lang.ThreadLocal
            public final Object initialValue() {
                int i32 = i4;
                ((IOUtils$$ExternalSyntheticLambda0) supplier2).getClass();
                switch (i32) {
                    case 0:
                        return IOUtils.byteArray();
                    default:
                        return IOUtils.charArray();
                }
            }
        };
    }

    public static byte[] byteArray() {
        return byteArray(Utility.DEFAULT_STREAM_BUFFER_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char[] charArray() {
        return charArray(Utility.DEFAULT_STREAM_BUFFER_SIZE);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        long jCopyLarge = copyLarge(inputStream, outputStream);
        if (jCopyLarge > 2147483647L) {
            return -1;
        }
        return (int) jCopyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream");
        Objects.requireNonNull(outputStream, "outputStream");
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static byte[] byteArray(int i) {
        return new byte[i];
    }

    private static char[] charArray(int i) {
        return new char[i];
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i) {
        return copyLarge(inputStream, outputStream, byteArray(i));
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE);
    }
}
