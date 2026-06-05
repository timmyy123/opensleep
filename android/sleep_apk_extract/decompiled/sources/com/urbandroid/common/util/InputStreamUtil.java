package com.urbandroid.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InputStreamUtil {
    public static String read(InputStream inputStream) {
        int i;
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, OAuth.ENCODING);
            do {
                i = inputStreamReader.read(cArr, 0, 1024);
                if (i > 0) {
                    sb.append(cArr, 0, i);
                }
            } while (i >= 0);
            return sb.toString();
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }
}
