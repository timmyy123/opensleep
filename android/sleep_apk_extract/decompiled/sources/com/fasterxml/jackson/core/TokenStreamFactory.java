package com.fasterxml.jackson.core;

import com.facebook.share.internal.ShareInternalUtility;
import com.fasterxml.jackson.core.io.DataOutputAsStream;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public abstract class TokenStreamFactory implements Serializable {
    private static final long serialVersionUID = 2;

    public void _checkRangeBoundsForByteArray(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            _reportRangeError("Invalid `byte[]` argument: `null`");
        }
        int length = bArr.length;
        int i3 = i + i2;
        if (((length - i3) | i | i2 | i3) < 0) {
            _reportRangeError(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `byte[]` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
        }
    }

    public void _checkRangeBoundsForCharArray(char[] cArr, int i, int i2) {
        if (cArr == null) {
            _reportRangeError("Invalid `char[]` argument: `null`");
        }
        int length = cArr.length;
        int i3 = i + i2;
        if (((length - i3) | i | i2 | i3) < 0) {
            _reportRangeError(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `char[]` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
        }
    }

    public OutputStream _createDataOutputWrapper(DataOutput dataOutput) {
        return new DataOutputAsStream(dataOutput);
    }

    public InputStream _fileInputStream(File file) {
        return new FileInputStream(file);
    }

    public OutputStream _fileOutputStream(File file) {
        return new FileOutputStream(file);
    }

    public InputStream _optimizedStreamFromURL(URL url) {
        String host;
        return (!ShareInternalUtility.STAGING_PARAM.equals(url.getProtocol()) || !((host = url.getHost()) == null || host.length() == 0) || url.getPath().indexOf(37) >= 0) ? url.openStream() : new FileInputStream(url.getPath());
    }

    public <T> T _reportRangeError(String str) {
        throw new IllegalArgumentException(str);
    }

    public abstract int getFactoryFeatures();

    public abstract StreamReadConstraints streamReadConstraints();
}
