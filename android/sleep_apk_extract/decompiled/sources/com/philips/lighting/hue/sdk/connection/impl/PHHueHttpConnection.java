package com.philips.lighting.hue.sdk.connection.impl;

import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueHttpConnection {
    static final String DELETE = "DELETE";
    static final String GET = "GET";
    static final String POST = "POST";
    static final String PUT = "PUT";
    private static final String TAG = "PHHueHttpConnection";
    private HttpURLConnection connection;
    private int timeoutConnection = 8000;

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0071: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:114), block:B:25:0x0071 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #1 {all -> 0x0070, blocks: (B:10:0x0029, B:11:0x0036, B:16:0x0049, B:14:0x003d, B:32:0x0079, B:34:0x007f), top: B:54:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String deleteData(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        StringBuilder sb;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader3 = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
                openConnection(str, DELETE);
                httpURLConnection = this.connection;
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.connection.disconnect();
                    } catch (IOException e) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(TAG, "DeleteData IOException: " + e);
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
            }
            throw th;
        }
        if (httpURLConnection == null) {
            return null;
        }
        httpURLConnection.connect();
        Object content = this.connection.getContent();
        if (content == null) {
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader((InputStream) content, OAuth.ENCODING));
        try {
            StringBuffer stringBuffer = new StringBuffer("");
            String property = System.getProperty("line.separator");
            do {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
                stringBuffer.append(property);
            } while (bufferedReader.ready());
            bufferedReader.close();
            string = stringBuffer.toString();
            try {
                bufferedReader.close();
                this.connection.disconnect();
            } catch (IOException e3) {
                e = e3;
                if (PHLog.isLoggable()) {
                    sb = new StringBuilder("DeleteData IOException: ");
                    sb.append(e);
                    PHLog.e(TAG, sb.toString());
                }
            }
        } catch (Exception e4) {
            e = e4;
            if (PHLog.isLoggable()) {
            }
            if (bufferedReader != null) {
            }
        }
        PHLog.d(TAG, "Bridge Response : " + string);
        return string;
        if (PHLog.isLoggable()) {
            PHLog.e(TAG, "DeleteData Exception: " + e);
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                this.connection.disconnect();
            } catch (IOException e5) {
                e = e5;
                if (PHLog.isLoggable()) {
                    sb = new StringBuilder("DeleteData IOException: ");
                    sb.append(e);
                    PHLog.e(TAG, sb.toString());
                }
            }
        }
        PHLog.d(TAG, "Bridge Response : " + string);
        return string;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0083: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:132), block:B:32:0x0083 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c A[Catch: all -> 0x0082, TRY_LEAVE, TryCatch #0 {all -> 0x0082, blocks: (B:17:0x003b, B:18:0x0048, B:23:0x005b, B:21:0x004f, B:34:0x0086, B:36:0x008c), top: B:54:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getData(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        StringBuilder sb;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader3 = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
                openConnection(str, GET);
                httpURLConnection = this.connection;
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.connection.disconnect();
                    } catch (IOException e) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(TAG, "GetData IOException: " + e);
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
            }
            throw th;
        }
        if (httpURLConnection == null) {
            return null;
        }
        httpURLConnection.connect();
        Object content = this.connection.getResponseCode() == 200 ? this.connection.getContent() : null;
        if (content == null) {
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader((InputStream) content, "UTF8"));
        try {
            StringBuffer stringBuffer = new StringBuffer("");
            String property = System.getProperty("line.separator");
            do {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
                stringBuffer.append(property);
            } while (bufferedReader.ready());
            bufferedReader.close();
            string = stringBuffer.toString();
            try {
                bufferedReader.close();
                this.connection.disconnect();
            } catch (IOException e3) {
                e = e3;
                if (PHLog.isLoggable()) {
                    sb = new StringBuilder("GetData IOException: ");
                    sb.append(e);
                    PHLog.e(TAG, sb.toString());
                }
            }
        } catch (Exception e4) {
            e = e4;
            if (PHLog.isLoggable()) {
            }
            if (bufferedReader != null) {
            }
        }
        PHLog.d(TAG, "Bridge Response : " + string);
        return string;
        if (PHLog.isLoggable()) {
            PHLog.e(TAG, "GetData Exception: " + e);
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                this.connection.disconnect();
            } catch (IOException e5) {
                e = e5;
                if (PHLog.isLoggable()) {
                    sb = new StringBuilder("GetData IOException: ");
                    sb.append(e);
                    PHLog.e(TAG, sb.toString());
                }
            }
        }
        PHLog.d(TAG, "Bridge Response : " + string);
        return string;
    }

    public int getTimeoutConnection() {
        return this.timeoutConnection;
    }

    public void openConnection(String str, String str2) throws ProtocolException {
        PHLog.d(TAG, "openConnection with URL:" + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.connection = httpURLConnection;
        httpURLConnection.setRequestMethod(str2);
        this.connection.setConnectTimeout(this.timeoutConnection);
        this.connection.setReadTimeout(this.timeoutConnection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00af A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #1 {all -> 0x00a0, blocks: (B:13:0x0059, B:14:0x0066, B:19:0x0079, B:17:0x006d, B:35:0x00a9, B:37:0x00af), top: B:57:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String postData(String str, String str2) throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb;
        ?? r3 = 0;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
                openConnection(str2, POST);
            } catch (Throwable th) {
                th = th;
                r3 = str2;
                if (r3 != 0) {
                    try {
                        r3.close();
                        this.connection.disconnect();
                    } catch (IOException e) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(TAG, "PostData IOException: " + e);
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (r3 != 0) {
            }
            throw th;
        }
        if (this.connection == null) {
            return null;
        }
        PHLog.d(TAG, "DATA : " + str);
        this.connection.setDoOutput(true);
        OutputStream outputStream = this.connection.getOutputStream();
        if (outputStream == null) {
            return null;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, OAuth.ENCODING);
        outputStreamWriter.write(str);
        outputStreamWriter.flush();
        outputStreamWriter.close();
        this.connection.connect();
        Object content = this.connection.getContent();
        if (content == null) {
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader((InputStream) content, OAuth.ENCODING));
        try {
            StringBuffer stringBuffer = new StringBuffer("");
            String property = System.getProperty("line.separator");
            do {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
                stringBuffer.append(property);
            } while (bufferedReader.ready());
            bufferedReader.close();
            string = stringBuffer.toString();
            try {
                bufferedReader.close();
                this.connection.disconnect();
            } catch (IOException e3) {
                e = e3;
                if (PHLog.isLoggable()) {
                    sb = new StringBuilder("PostData IOException: ");
                    sb.append(e);
                    PHLog.e(TAG, sb.toString());
                }
            }
        } catch (Exception e4) {
            e = e4;
            if (PHLog.isLoggable()) {
            }
            if (bufferedReader != null) {
            }
        }
        PHLog.d(TAG, "Bridge Response : " + string);
        return string;
        if (PHLog.isLoggable()) {
            PHLog.e(TAG, "PostData Exception: " + e);
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                this.connection.disconnect();
            } catch (IOException e5) {
                e = e5;
                if (PHLog.isLoggable()) {
                    sb = new StringBuilder("PostData IOException: ");
                    sb.append(e);
                    PHLog.e(TAG, sb.toString());
                }
            }
        }
        PHLog.d(TAG, "Bridge Response : " + string);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #6 {all -> 0x009d, blocks: (B:13:0x0056, B:14:0x0063, B:19:0x0076, B:17:0x006a, B:35:0x00a6, B:37:0x00ac), top: B:55:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String putData(String str, String str2) throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb;
        BufferedReader bufferedReader2 = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            openConnection(str2, PUT);
        } catch (Exception e) {
            e = e;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        if (this.connection == null) {
            return null;
        }
        PHLog.d(TAG, "DATA :  " + str);
        this.connection.setDoOutput(true);
        this.connection.connect();
        OutputStream outputStream = this.connection.getOutputStream();
        if (outputStream == null) {
            return null;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, OAuth.ENCODING);
        outputStreamWriter.write(str);
        outputStreamWriter.close();
        Object content = this.connection.getContent();
        if (content == null) {
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader((InputStream) content, OAuth.ENCODING));
        try {
            try {
                StringBuffer stringBuffer = new StringBuffer("");
                String property = System.getProperty("line.separator");
                do {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                    stringBuffer.append(property);
                } while (bufferedReader.ready());
                bufferedReader.close();
                string = stringBuffer.toString();
                try {
                    bufferedReader.close();
                    this.connection.disconnect();
                } catch (IOException e2) {
                    e = e2;
                    if (PHLog.isLoggable()) {
                        sb = new StringBuilder("PutData Exception: ");
                        sb.append(e);
                        PHLog.e(TAG, sb.toString());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                if (PHLog.isLoggable()) {
                }
                if (bufferedReader != null) {
                }
            }
            PHLog.d(TAG, "Bridge Response : " + string);
            return string;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                    this.connection.disconnect();
                } catch (IOException e4) {
                    if (PHLog.isLoggable()) {
                        PHLog.e(TAG, "PutData Exception: " + e4);
                    }
                }
            }
            throw th;
        }
        if (PHLog.isLoggable()) {
            PHLog.e(TAG, "PutData Exception: " + e);
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                this.connection.disconnect();
            } catch (IOException e5) {
                e = e5;
                if (PHLog.isLoggable()) {
                    sb = new StringBuilder("PutData Exception: ");
                    sb.append(e);
                    PHLog.e(TAG, sb.toString());
                }
            }
        }
        PHLog.d(TAG, "Bridge Response : " + string);
        return string;
    }

    public void setTimeoutConnection(int i) {
        this.timeoutConnection = i;
    }
}
