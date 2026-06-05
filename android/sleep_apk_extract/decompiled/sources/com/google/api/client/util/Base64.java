package com.google.api.client.util;

import com.google.common.io.BaseEncoding;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class Base64 {
    public static byte[] decodeBase64(String str) {
        if (str == null) {
            return null;
        }
        try {
            return BaseEncoding.base64().decode(str);
        } catch (IllegalArgumentException e) {
            if (e.getCause() instanceof BaseEncoding.DecodingException) {
                return BaseEncoding.base64Url().decode(str.trim());
            }
            throw e;
        }
    }
}
