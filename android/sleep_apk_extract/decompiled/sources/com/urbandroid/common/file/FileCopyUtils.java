package com.urbandroid.common.file;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FileCopyUtils {
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void copyFile(String str, String str2, InputStream inputStream, FileOutputStream fileOutputStream) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        StringBuilder sb;
        ByteCountingInputStream byteCountingInputStream;
        byte[] bArr = new byte[10000];
        long jCurrentTimeMillis = System.currentTimeMillis();
        BufferedOutputStream bufferedOutputStream2 = null;
        ByteCountingInputStream byteCountingInputStream2 = null;
        ByteCountingInputStream byteCountingInputStream3 = null;
        try {
            try {
                byteCountingInputStream = new ByteCountingInputStream(new BufferedInputStream(inputStream));
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (EOFException unused) {
                    bufferedOutputStream = null;
                } catch (IOException e) {
                    throw e;
                }
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
            }
            try {
                for (int i = byteCountingInputStream.read(bArr); i > 0; i = byteCountingInputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, i);
                }
                try {
                    byteCountingInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                sb = new StringBuilder("Copied file ");
                sb.append(inputStream);
                sb.append(" into ");
                sb.append(str2);
                sb.append(" Took: ");
                sb.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
                sb.append(" ms. Bytes: ");
                sb.append(byteCountingInputStream.getBytesRead());
            } catch (EOFException unused2) {
                byteCountingInputStream2 = byteCountingInputStream;
                if (byteCountingInputStream2 != null) {
                    try {
                        byteCountingInputStream2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                sb = new StringBuilder("Copied file ");
                sb.append(inputStream);
                sb.append(" into ");
                sb.append(str2);
                sb.append(" Took: ");
                sb.append(jCurrentTimeMillis3 - jCurrentTimeMillis);
                sb.append(" ms. Bytes: ");
                sb.append(byteCountingInputStream2 != null ? byteCountingInputStream2.getBytesRead() : 0L);
            } catch (IOException e6) {
                bufferedOutputStream2 = bufferedOutputStream;
                throw e6;
            } catch (Throwable th2) {
                th = th2;
                byteCountingInputStream3 = byteCountingInputStream;
                if (byteCountingInputStream3 != null) {
                    try {
                        byteCountingInputStream3.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                long jCurrentTimeMillis4 = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder("Copied file ");
                sb2.append(inputStream);
                sb2.append(" into ");
                sb2.append(str2);
                sb2.append(" Took: ");
                sb2.append(jCurrentTimeMillis4 - jCurrentTimeMillis);
                sb2.append(" ms. Bytes: ");
                sb2.append(byteCountingInputStream3 != null ? byteCountingInputStream3.getBytesRead() : 0L);
                Logger.logDebug(sb2.toString());
                throw th;
            }
        } catch (EOFException unused3) {
            bufferedOutputStream = null;
        } catch (IOException e9) {
            throw e9;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            if (byteCountingInputStream3 != null) {
            }
            if (bufferedOutputStream != null) {
            }
            long jCurrentTimeMillis42 = System.currentTimeMillis();
            StringBuilder sb22 = new StringBuilder("Copied file ");
            sb22.append(inputStream);
            sb22.append(" into ");
            sb22.append(str2);
            sb22.append(" Took: ");
            sb22.append(jCurrentTimeMillis42 - jCurrentTimeMillis);
            sb22.append(" ms. Bytes: ");
            sb22.append(byteCountingInputStream3 != null ? byteCountingInputStream3.getBytesRead() : 0L);
            Logger.logDebug(sb22.toString());
            throw th;
        }
        Logger.logDebug(sb.toString());
    }

    public static void copyPrivateFileToSdCardFile(Context context, String str, String str2) throws Throwable {
        copyFile(str, str2, context.openFileInput(str), new FileOutputStream(str2));
    }
}
