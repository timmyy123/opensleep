package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ContentReference implements Serializable {
    private static final long serialVersionUID = 1;
    protected final boolean _isContentTextual;
    protected final int _length;
    protected final int _maxRawContentLength;
    protected final int _offset;
    protected final transient Object _rawContent;
    protected static final ContentReference UNKNOWN_CONTENT = new ContentReference(false, null);
    protected static final ContentReference REDACTED_CONTENT = new ContentReference(false, null);

    public ContentReference(boolean z, Object obj, int i, int i2, ErrorReportConfiguration errorReportConfiguration) {
        this._isContentTextual = z;
        this._rawContent = obj;
        this._offset = i;
        this._length = i2;
        this._maxRawContentLength = errorReportConfiguration.getMaxRawContentLength();
    }

    public static ContentReference construct(boolean z, Object obj, int i, int i2, ErrorReportConfiguration errorReportConfiguration) {
        return new ContentReference(z, obj, i, i2, errorReportConfiguration);
    }

    public static ContentReference rawReference(boolean z, Object obj) {
        return obj instanceof ContentReference ? (ContentReference) obj : new ContentReference(z, obj);
    }

    private void readObject(ObjectInputStream objectInputStream) {
    }

    public static ContentReference redacted() {
        return REDACTED_CONTENT;
    }

    public static ContentReference unknown() {
        return UNKNOWN_CONTENT;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
    }

    public int _append(StringBuilder sb, String str) {
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isISOControl(cCharAt) || !_appendEscaped(sb, cCharAt)) {
                sb.append(cCharAt);
            }
        }
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        return str.length();
    }

    public boolean _appendEscaped(StringBuilder sb, int i) {
        if (i == 13 || i == 10) {
            return false;
        }
        sb.append('\\');
        sb.append('u');
        sb.append(CharTypes.hexToChar((i >> 12) & 15));
        sb.append(CharTypes.hexToChar((i >> 8) & 15));
        sb.append(CharTypes.hexToChar((i >> 4) & 15));
        sb.append(CharTypes.hexToChar(i & 15));
        return true;
    }

    public String _truncate(CharSequence charSequence, int[] iArr, int i) {
        _truncateOffsets(iArr, charSequence.length());
        int i2 = iArr[0];
        return charSequence.subSequence(i2, Math.min(iArr[1], i) + i2).toString();
    }

    public void _truncateOffsets(int[] iArr, int i) {
        int i2 = iArr[0];
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= i) {
            i2 = i;
        }
        iArr[0] = i2;
        int i3 = iArr[1];
        int i4 = i - i2;
        if (i3 < 0 || i3 > i4) {
            iArr[1] = i4;
        }
    }

    public StringBuilder appendSourceDescription(StringBuilder sb) {
        String str_truncate;
        Object rawContent = getRawContent();
        if (rawContent == null) {
            if (this == REDACTED_CONTENT) {
                sb.append("REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled)");
                return sb;
            }
            sb.append("UNKNOWN");
            return sb;
        }
        Class<?> cls = rawContent instanceof Class ? (Class) rawContent : rawContent.getClass();
        String name = cls.getName();
        if (name.startsWith("java.")) {
            name = cls.getSimpleName();
        } else if (rawContent instanceof byte[]) {
            name = "byte[]";
        } else if (rawContent instanceof char[]) {
            name = "char[]";
        }
        sb.append('(');
        sb.append(name);
        sb.append(')');
        if (hasTextualContent()) {
            int iMaxRawContentLength = maxRawContentLength();
            int[] iArr = {contentOffset(), contentLength()};
            String str = " chars";
            if (rawContent instanceof CharSequence) {
                str_truncate = _truncate((CharSequence) rawContent, iArr, iMaxRawContentLength);
            } else if (rawContent instanceof char[]) {
                str_truncate = _truncate((char[]) rawContent, iArr, iMaxRawContentLength);
            } else if (rawContent instanceof byte[]) {
                str_truncate = _truncate((byte[]) rawContent, iArr, iMaxRawContentLength);
                str = " bytes";
            } else {
                str_truncate = null;
            }
            if (str_truncate != null) {
                _append(sb, str_truncate);
                if (iArr[1] > iMaxRawContentLength) {
                    sb.append("[truncated ");
                    sb.append(iArr[1] - iMaxRawContentLength);
                    sb.append(str);
                    sb.append(']');
                    return sb;
                }
            }
        } else if (rawContent instanceof byte[]) {
            int iContentLength = contentLength();
            if (iContentLength < 0) {
                iContentLength = ((byte[]) rawContent).length;
            }
            sb.append('[');
            sb.append(iContentLength);
            sb.append(" bytes]");
        }
        return sb;
    }

    public String buildSourceDescription() {
        return appendSourceDescription(new StringBuilder(200)).toString();
    }

    public int contentLength() {
        return this._length;
    }

    public int contentOffset() {
        return this._offset;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ContentReference)) {
            return false;
        }
        ContentReference contentReference = (ContentReference) obj;
        if (this._offset != contentReference._offset || this._length != contentReference._length) {
            return false;
        }
        Object obj2 = contentReference._rawContent;
        Object obj3 = this._rawContent;
        if (obj3 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return ((obj3 instanceof File) || (obj3 instanceof URL) || (obj3 instanceof URI)) ? obj3.equals(obj2) : obj3 == obj2;
    }

    public Object getRawContent() {
        return this._rawContent;
    }

    public boolean hasTextualContent() {
        return this._isContentTextual;
    }

    public int hashCode() {
        return Objects.hashCode(this._rawContent);
    }

    public int maxRawContentLength() {
        return this._maxRawContentLength;
    }

    public Object readResolve() {
        return UNKNOWN_CONTENT;
    }

    public static ContentReference construct(boolean z, Object obj, ErrorReportConfiguration errorReportConfiguration) {
        return new ContentReference(z, obj, errorReportConfiguration);
    }

    public static ContentReference rawReference(Object obj) {
        return rawReference(false, obj);
    }

    public ContentReference(boolean z, Object obj, ErrorReportConfiguration errorReportConfiguration) {
        this(z, obj, -1, -1, errorReportConfiguration);
    }

    @Deprecated
    public ContentReference(boolean z, Object obj) {
        this(z, obj, -1, -1, ErrorReportConfiguration.defaults());
    }

    public String _truncate(char[] cArr, int[] iArr, int i) {
        _truncateOffsets(iArr, cArr.length);
        return new String(cArr, iArr[0], Math.min(iArr[1], i));
    }

    public String _truncate(byte[] bArr, int[] iArr, int i) {
        _truncateOffsets(iArr, bArr.length);
        return new String(bArr, iArr[0], Math.min(iArr[1], i), StandardCharsets.UTF_8);
    }
}
