package com.google.api.client.util;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public class LoggingByteArrayOutputStream extends ByteArrayOutputStream {
    private int bytesWritten;
    private boolean closed;
    private final Logger logger;
    private final Level loggingLevel;
    private final int maximumBytesToLog;

    public LoggingByteArrayOutputStream(Logger logger, Level level, int i) {
        this.logger = (Logger) Preconditions.checkNotNull(logger);
        this.loggingLevel = (Level) Preconditions.checkNotNull(level);
        Preconditions.checkArgument(i >= 0);
        this.maximumBytesToLog = i;
    }

    private static void appendBytes(StringBuilder sb, int i) {
        if (i == 1) {
            sb.append("1 byte");
        } else {
            sb.append(NumberFormat.getInstance().format(i));
            sb.append(" bytes");
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (!this.closed) {
                if (this.bytesWritten != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Total: ");
                    appendBytes(sb, this.bytesWritten);
                    int i = ((ByteArrayOutputStream) this).count;
                    if (i != 0 && i < this.bytesWritten) {
                        sb.append(" (logging first ");
                        appendBytes(sb, ((ByteArrayOutputStream) this).count);
                        sb.append(")");
                    }
                    this.logger.config(sb.toString());
                    if (((ByteArrayOutputStream) this).count != 0) {
                        this.logger.log(this.loggingLevel, toString(OAuth.ENCODING).replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                    }
                }
                this.closed = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        Preconditions.checkArgument(!this.closed);
        this.bytesWritten += i2;
        int i3 = ((ByteArrayOutputStream) this).count;
        int i4 = this.maximumBytesToLog;
        if (i3 < i4) {
            int i5 = i3 + i2;
            if (i5 > i4) {
                i2 += i4 - i5;
            }
            super.write(bArr, i, i2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        Preconditions.checkArgument(!this.closed);
        this.bytesWritten++;
        if (((ByteArrayOutputStream) this).count < this.maximumBytesToLog) {
            super.write(i);
        }
    }
}
