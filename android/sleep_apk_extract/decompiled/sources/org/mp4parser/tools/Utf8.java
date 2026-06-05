package org.mp4parser.tools;

import java.io.UnsupportedEncodingException;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Utf8 {
    public static String convert(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, OAuth.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    public static int utf8StringLengthInBytes(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes(OAuth.ENCODING).length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException();
        }
    }

    public static byte[] convert(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(OAuth.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }
}
