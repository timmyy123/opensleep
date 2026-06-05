package org.eclipse.californium.core;

import org.eclipse.californium.elements.util.StringUtil;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Utils {
    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        return "[" + StringUtil.byteArray2Hex(bArr) + "]";
    }

    public static String toHexText(byte[] bArr, int i) {
        if (bArr == null) {
            return "null";
        }
        if (i > bArr.length) {
            i = bArr.length;
        }
        StringBuilder sb = new StringBuilder();
        if (16 < i) {
            sb.append(StringUtil.lineSeparator());
        }
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(String.format("%02x", Integer.valueOf(bArr[i2] & 255)));
            if (31 == (i2 & 31)) {
                sb.append(StringUtil.lineSeparator());
            } else {
                sb.append(' ');
            }
        }
        if (i < bArr.length) {
            sb.append(" .. ");
            sb.append(bArr.length);
            sb.append(" bytes");
        }
        return sb.toString();
    }
}
