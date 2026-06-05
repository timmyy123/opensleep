package com.fasterxml.jackson.core.io;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class UTF32Reader extends Reader {
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._length = i2;
        this._bigEndian = z;
        this._managedBuffers = inputStream != null;
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            IOContext iOContext = this._context;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    private boolean loadMore(int i) throws IOException {
        byte[] bArr;
        InputStream inputStream = this._in;
        if (inputStream == null || (bArr = this._buffer) == null) {
            return false;
        }
        this._byteCount = (this._length - i) + this._byteCount;
        if (i > 0) {
            int i2 = this._ptr;
            if (i2 > 0) {
                System.arraycopy(bArr, i2, bArr, 0, i);
                this._ptr = 0;
            }
            this._length = i;
        } else {
            this._ptr = 0;
            int i3 = inputStream.read(bArr);
            if (i3 < 1) {
                this._length = 0;
                if (i3 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = i3;
        }
        while (true) {
            int i4 = this._length;
            if (i4 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            byte[] bArr2 = this._buffer;
            int i5 = inputStream2.read(bArr2, i4, bArr2.length - i4);
            if (i5 < 1) {
                if (i5 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += i5;
        }
    }

    private void reportBounds(char[] cArr, int i, int i2) {
        throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(cArr.length)));
    }

    private void reportInvalid(int i, int i2, String str) throws CharConversionException {
        int i3 = (this._byteCount + this._ptr) - 1;
        int i4 = this._charCount + i2;
        StringBuilder sb = new StringBuilder("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i));
        sb.append(str);
        sb.append(" at char #");
        sb.append(i4);
        throw new CharConversionException(zzba$$ExternalSyntheticOutline0.m(sb, ", byte #", i3, ")"));
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void reportUnexpectedEOF(int i, int i2) throws CharConversionException {
        int i3 = this._byteCount + i;
        int i4 = this._charCount;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "Unexpected EOF in the middle of a 4-byte UTF-32 char: got ", ", needed ", ", at char #");
        sbM.append(i4);
        sbM.append(", byte #");
        sbM.append(i3);
        sbM.append(")");
        throw new CharConversionException(sbM.toString());
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws CharConversionException {
        int i3;
        int i4;
        int i5;
        if (this._buffer == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i < 0 || i2 < 0 || i > cArr.length - i2) {
            reportBounds(cArr, i, i2);
        }
        int i6 = i2 + i;
        char c = this._surrogate;
        if (c != 0) {
            i3 = i + 1;
            cArr[i] = c;
            this._surrogate = (char) 0;
        } else {
            int i7 = this._length - this._ptr;
            if (i7 < 4 && !loadMore(i7)) {
                if (i7 == 0) {
                    return -1;
                }
                reportUnexpectedEOF(this._length - this._ptr, 4);
            }
            i3 = i;
        }
        int i8 = this._length - 4;
        while (true) {
            if (i3 < i6) {
                int i9 = this._ptr;
                if (i9 > i8) {
                    break;
                }
                boolean z = this._bigEndian;
                byte[] bArr = this._buffer;
                if (z) {
                    i5 = (bArr[i9] << 8) | (bArr[i9 + 1] & 255);
                    i4 = (bArr[i9 + 3] & 255) | ((bArr[i9 + 2] & 255) << 8);
                } else {
                    int i10 = (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8);
                    int i11 = (bArr[i9 + 3] << 8) | (bArr[i9 + 2] & 255);
                    i4 = i10;
                    i5 = i11;
                }
                this._ptr = i9 + 4;
                if (i5 != 0) {
                    int i12 = 65535 & i5;
                    int i13 = ((i12 - 1) << 16) | i4;
                    if (i12 > 16) {
                        reportInvalid(i13, i3 - i, String.format(" (above 0x%08x)", 1114111));
                    }
                    int i14 = i3 + 1;
                    cArr[i3] = (char) ((i13 >> 10) + 55296);
                    i4 = 56320 | (i13 & 1023);
                    if (i14 >= i6) {
                        this._surrogate = (char) i13;
                        i3 = i14;
                        break;
                    }
                    i3 = i14;
                }
                cArr[i3] = (char) i4;
                i3++;
            } else {
                break;
            }
        }
        int i15 = i3 - i;
        this._charCount += i15;
        return i15;
    }

    @Override // java.io.Reader
    public int read() {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }
}
