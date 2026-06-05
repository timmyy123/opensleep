package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.google.android.gms.common.util.Clock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcjd extends zzcja {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcjd(zzchn zzchnVar) {
        super(zzchnVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfzk.zza().zza(cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String strValueOf = String.valueOf(this.zzg.getAbsolutePath());
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not create preload cache directory at ".concat(strValueOf));
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
            return;
        }
        String strValueOf2 = String.valueOf(this.zzg.getAbsolutePath());
        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not set cache file permissions at ".concat(strValueOf2));
        this.zzg = null;
    }

    private final File zza(File file) {
        return new File(zzfzk.zza().zza(this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x03c6, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03ce, code lost:
    
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(3) == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03d0, code lost:
    
        r0 = r10.format(r4);
        r5 = new java.lang.StringBuilder((java.lang.String.valueOf(r0).length() + 22) + java.lang.String.valueOf(r34).length());
        r5.append(r17);
        r5.append(r0);
        r5.append(" bytes from ");
        r5.append(r34);
        com.google.android.gms.ads.internal.util.client.zzo.zzd(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0402, code lost:
    
        r13.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x040c, code lost:
    
        if (r7.isFile() == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x040e, code lost:
    
        r7.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x041a, code lost:
    
        r7.createNewFile();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.google.android.gms.internal.ads.zzcja, com.google.android.gms.internal.ads.zzcjd] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v38 */
    @Override // com.google.android.gms.internal.ads.zzcja
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zze(final String str) {
        int i;
        String strConcat;
        Object obj;
        File file;
        Object obj2;
        String str2;
        FileOutputStream fileOutputStream;
        ?? r11;
        ?? r4;
        Object obj3;
        HttpURLConnection httpURLConnectionZzh;
        int contentLength;
        FileOutputStream fileOutputStream2;
        ?? r112;
        FileChannel channel;
        ByteBuffer byteBufferAllocate;
        Clock clockZzk;
        long jCurrentTimeMillis;
        com.google.android.gms.ads.internal.util.zzbu zzbuVar;
        long jLongValue;
        int i2;
        int i3;
        ByteBuffer byteBuffer;
        com.google.android.gms.ads.internal.util.zzbu zzbuVar2;
        ReadableByteChannel readableByteChannel;
        int responseCode;
        String string;
        boolean zDelete;
        String str3 = "Preloaded ";
        if (this.zzg == null) {
            zzq(str, null, "noCacheDir", null);
            return false;
        }
        while (true) {
            File file2 = this.zzg;
            if (file2 == null) {
                i = 0;
            } else {
                File[] fileArrListFiles = file2.listFiles();
                int length = fileArrListFiles.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    int i6 = i4;
                    int i7 = length;
                    if (!fileArrListFiles[i4].getName().endsWith(".done")) {
                        i5++;
                    }
                    i4 = i6 + 1;
                    length = i7;
                }
                i = i5;
            }
            String str4 = str3;
            if (i <= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzu)).intValue()) {
                File file3 = new File(zzfzk.zza().zza(this.zzg, com.google.android.gms.ads.internal.util.client.zzf.zzg(str)));
                File fileZza = zza(file3);
                if (file3.isFile() && fileZza.isFile()) {
                    int length2 = (int) file3.length();
                    String strValueOf = String.valueOf(str);
                    int i8 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzd("Stream cache hit at ".concat(strValueOf));
                    zzo(str, file3.getAbsolutePath(), length2);
                    return true;
                }
                String strValueOf2 = String.valueOf(this.zzg.getAbsolutePath());
                String strValueOf3 = String.valueOf(str);
                Set set = zze;
                strConcat = strValueOf2.concat(strValueOf3);
                synchronized (set) {
                    try {
                        if (set.contains(strConcat)) {
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
                            sb.append("Stream cache already in progress at ");
                            sb.append(str);
                            String string2 = sb.toString();
                            int i9 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi(string2);
                            zzq(str, file3.getAbsolutePath(), "inProgress", null);
                            return false;
                        }
                        set.add(strConcat);
                        try {
                            obj = "error";
                            try {
                                try {
                                    httpURLConnectionZzh = zzfzw.zza().zzh(new zzfzy() { // from class: com.google.android.gms.internal.ads.zzcjc
                                        @Override // com.google.android.gms.internal.ads.zzfzy
                                        public final /* synthetic */ URLConnection zza() throws IOException {
                                            int i10 = zzcjd.$r8$clinit;
                                            com.google.android.gms.ads.internal.zzt.zzq();
                                            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzan)).intValue();
                                            URL url = new URL(str);
                                            int i11 = 0;
                                            while (true) {
                                                i11++;
                                                if (i11 > 20) {
                                                    OggIO$$ExternalSyntheticBUOutline0.m("Too many redirects (20)");
                                                    return null;
                                                }
                                                URLConnection uRLConnectionOpenConnection = url.openConnection();
                                                uRLConnectionOpenConnection.setConnectTimeout(iIntValue);
                                                uRLConnectionOpenConnection.setReadTimeout(iIntValue);
                                                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                                                    OggIO$$ExternalSyntheticBUOutline0.m("Invalid protocol.");
                                                    return null;
                                                }
                                                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                                                com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                                                zzlVar.zza(httpURLConnection, null);
                                                httpURLConnection.setInstanceFollowRedirects(false);
                                                int responseCode2 = httpURLConnection.getResponseCode();
                                                zzlVar.zzc(httpURLConnection, responseCode2);
                                                if (responseCode2 / 100 != 3) {
                                                    return httpURLConnection;
                                                }
                                                String headerField = httpURLConnection.getHeaderField("Location");
                                                if (headerField == null) {
                                                    OggIO$$ExternalSyntheticBUOutline0.m("Missing Location header in redirect");
                                                    return null;
                                                }
                                                URL url2 = new URL(url, headerField);
                                                String protocol2 = url2.getProtocol();
                                                if (protocol2 == null) {
                                                    OggIO$$ExternalSyntheticBUOutline0.m("Protocol is null");
                                                    return null;
                                                }
                                                if (!protocol2.equals("http") && !protocol2.equals(TournamentShareDialogURIBuilder.scheme)) {
                                                    OggIO$$ExternalSyntheticBUOutline0.m("Unsupported scheme: ".concat(protocol2));
                                                    return null;
                                                }
                                                String strConcat2 = "Redirecting to ".concat(headerField);
                                                int i12 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzd(strConcat2);
                                                httpURLConnection.disconnect();
                                                url = url2;
                                            }
                                        }
                                    }, 265, -1);
                                    if (httpURLConnectionZzh != null && (responseCode = httpURLConnectionZzh.getResponseCode()) >= 400) {
                                        try {
                                            String string3 = Integer.toString(responseCode);
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(string3).length() + 27);
                                            sb2.append("HTTP request failed. Code: ");
                                            sb2.append(string3);
                                            string = sb2.toString();
                                        } catch (IOException | RuntimeException e) {
                                            e = e;
                                            obj2 = "badUrl";
                                            file = file3;
                                            str2 = null;
                                            obj3 = obj2;
                                            fileOutputStream = null;
                                            r4 = str2;
                                            r11 = obj3;
                                            if (e instanceof RuntimeException) {
                                            }
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException | NullPointerException unused) {
                                            }
                                            if (this.zzh) {
                                            }
                                            if (file.exists()) {
                                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not delete partial cache file at ".concat(String.valueOf(file.getAbsolutePath())));
                                            }
                                            zzq(str, file.getAbsolutePath(), r11, r4);
                                            zze.remove(strConcat);
                                            return false;
                                        }
                                        try {
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(responseCode).length() + 21 + String.valueOf(str).length());
                                            sb3.append("HTTP status code ");
                                            sb3.append(responseCode);
                                            sb3.append(" at ");
                                            sb3.append(str);
                                            throw new IOException(sb3.toString());
                                        } catch (IOException | RuntimeException e2) {
                                            e = e2;
                                            obj3 = "badUrl";
                                            file = file3;
                                            str2 = string;
                                            fileOutputStream = null;
                                            r4 = str2;
                                            r11 = obj3;
                                            if (e instanceof RuntimeException) {
                                            }
                                            fileOutputStream.close();
                                            if (this.zzh) {
                                            }
                                            if (file.exists()) {
                                            }
                                            zzq(str, file.getAbsolutePath(), r11, r4);
                                            zze.remove(strConcat);
                                            return false;
                                        }
                                    }
                                    contentLength = httpURLConnectionZzh.getContentLength();
                                } catch (IOException | RuntimeException e3) {
                                    e = e3;
                                    file = file3;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                file = file3;
                                obj2 = obj;
                                str2 = null;
                                obj3 = obj2;
                                fileOutputStream = null;
                                r4 = str2;
                                r11 = obj3;
                                if (e instanceof RuntimeException) {
                                }
                                fileOutputStream.close();
                                if (this.zzh) {
                                }
                                if (file.exists()) {
                                }
                                zzq(str, file.getAbsolutePath(), r11, r4);
                                zze.remove(strConcat);
                                return false;
                            } catch (RuntimeException e5) {
                                e = e5;
                                file = file3;
                                obj2 = obj;
                                str2 = null;
                                obj3 = obj2;
                                fileOutputStream = null;
                                r4 = str2;
                                r11 = obj3;
                                if (e instanceof RuntimeException) {
                                }
                                fileOutputStream.close();
                                if (this.zzh) {
                                }
                                if (file.exists()) {
                                }
                                zzq(str, file.getAbsolutePath(), r11, r4);
                                zze.remove(strConcat);
                                return false;
                            }
                        } catch (IOException | RuntimeException e6) {
                            e = e6;
                            obj = "error";
                        }
                        if (contentLength < 0) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 55);
                            sb4.append("Stream cache aborted, missing content-length header at ");
                            sb4.append(str);
                            String string4 = sb4.toString();
                            int i10 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi(string4);
                            zzq(str, file3.getAbsolutePath(), "contentLengthMissing", null);
                            set.remove(strConcat);
                            return false;
                        }
                        DecimalFormat decimalFormat = zzf;
                        String str5 = decimalFormat.format(contentLength);
                        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzv)).intValue();
                        if (contentLength > iIntValue) {
                            StringBuilder sb5 = new StringBuilder(String.valueOf(str5).length() + 33 + String.valueOf(str).length());
                            sb5.append("Content length ");
                            sb5.append(str5);
                            sb5.append(" exceeds limit at ");
                            sb5.append(str);
                            String string5 = sb5.toString();
                            int i11 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi(string5);
                            StringBuilder sb6 = new StringBuilder(String.valueOf(str5).length() + 40);
                            sb6.append("File too big for full file cache. Size: ");
                            sb6.append(str5);
                            zzq(str, file3.getAbsolutePath(), "sizeExceeded", sb6.toString());
                            set.remove(strConcat);
                            return false;
                        }
                        StringBuilder sb7 = new StringBuilder(String.valueOf(str5).length() + 20 + String.valueOf(str).length());
                        sb7.append("Caching ");
                        sb7.append(str5);
                        sb7.append(" bytes from ");
                        sb7.append(str);
                        String string6 = sb7.toString();
                        int i12 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzd(string6);
                        ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(httpURLConnectionZzh.getInputStream());
                        file = file3;
                        try {
                            fileOutputStream2 = new FileOutputStream(file);
                            try {
                                try {
                                    channel = fileOutputStream2.getChannel();
                                    byteBufferAllocate = ByteBuffer.allocate(1048576);
                                    clockZzk = com.google.android.gms.ads.internal.zzt.zzk();
                                    jCurrentTimeMillis = clockZzk.currentTimeMillis();
                                    zzbuVar = new com.google.android.gms.ads.internal.util.zzbu(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzam)).longValue());
                                    jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzal)).longValue();
                                    i2 = 0;
                                } catch (IOException e7) {
                                    e = e7;
                                }
                            } catch (RuntimeException e8) {
                                e = e8;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            obj2 = obj;
                            str2 = null;
                            obj3 = obj2;
                            fileOutputStream = null;
                            r4 = str2;
                            r11 = obj3;
                        } catch (RuntimeException e10) {
                            e = e10;
                            obj2 = obj;
                            str2 = null;
                            obj3 = obj2;
                            fileOutputStream = null;
                            r4 = str2;
                            r11 = obj3;
                        }
                        while (true) {
                            int i13 = readableByteChannelNewChannel.read(byteBufferAllocate);
                            if (i13 < 0) {
                                break;
                            }
                            i2 += i13;
                            try {
                                try {
                                    if (i2 > iIntValue) {
                                        String string7 = Integer.toString(i2);
                                        StringBuilder sb8 = new StringBuilder(String.valueOf(string7).length() + 40);
                                        sb8.append("File too big for full file cache. Size: ");
                                        sb8.append(string7);
                                        sb8.toString();
                                        throw new IOException("stream cache file size limit exceeded");
                                    }
                                    byteBufferAllocate.flip();
                                    while (channel.write(byteBufferAllocate) > 0) {
                                    }
                                    byteBufferAllocate.clear();
                                    if (clockZzk.currentTimeMillis() - jCurrentTimeMillis > 1000 * jLongValue) {
                                        String string8 = Long.toString(jLongValue);
                                        StringBuilder sb9 = new StringBuilder(String.valueOf(string8).length() + 29);
                                        sb9.append("Timeout exceeded. Limit: ");
                                        sb9.append(string8);
                                        sb9.append(" sec");
                                        sb9.toString();
                                        throw new IOException("stream cache time limit exceeded");
                                    }
                                    if (this.zzh) {
                                        throw new IOException("abort requested");
                                    }
                                    if (zzbuVar.zza()) {
                                        zzbuVar2 = zzbuVar;
                                        byteBuffer = byteBufferAllocate;
                                        i3 = contentLength;
                                        readableByteChannel = readableByteChannelNewChannel;
                                        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzciu(this, str, file.getAbsolutePath(), i2, i3, false));
                                    } else {
                                        i3 = contentLength;
                                        byteBuffer = byteBufferAllocate;
                                        zzbuVar2 = zzbuVar;
                                        readableByteChannel = readableByteChannelNewChannel;
                                    }
                                    contentLength = i3;
                                    zzbuVar = zzbuVar2;
                                    byteBufferAllocate = byteBuffer;
                                    readableByteChannelNewChannel = readableByteChannel;
                                } catch (IOException | RuntimeException e11) {
                                    e = e11;
                                    r4 = channel;
                                    fileOutputStream = fileOutputStream2;
                                    r11 = iIntValue;
                                }
                            } catch (IOException | RuntimeException e12) {
                                e = e12;
                                fileOutputStream = fileOutputStream2;
                                r112 = iIntValue;
                                r4 = 0;
                                r11 = r112;
                            }
                            fileOutputStream = fileOutputStream2;
                            r112 = obj;
                            r4 = 0;
                            r11 = r112;
                            if (e instanceof RuntimeException) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "VideoStreamFullFileCache.preload");
                            }
                            fileOutputStream.close();
                            if (this.zzh) {
                                String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 26), "Preload aborted for URL \"", str, "\"");
                                int i14 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzh(strM);
                            } else {
                                String strM2 = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 25), "Preload failed for URL \"", str, "\"");
                                int i15 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj(strM2, e);
                            }
                            if (file.exists() && !file.delete()) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not delete partial cache file at ".concat(String.valueOf(file.getAbsolutePath())));
                            }
                            zzq(str, file.getAbsolutePath(), r11, r4);
                            zze.remove(strConcat);
                            return false;
                        }
                    } finally {
                    }
                }
            }
            File file4 = this.zzg;
            if (file4 == null) {
                zDelete = false;
            } else {
                File[] fileArrListFiles2 = file4.listFiles();
                int length3 = fileArrListFiles2.length;
                int i16 = 0;
                long j = Long.MAX_VALUE;
                File file5 = null;
                while (i16 < length3) {
                    File file6 = fileArrListFiles2[i16];
                    int i17 = length3;
                    int i18 = i16;
                    if (!file6.getName().endsWith(".done")) {
                        long jLastModified = file6.lastModified();
                        if (jLastModified < j) {
                            j = jLastModified;
                            file5 = file6;
                        }
                    }
                    i16 = i18 + 1;
                    length3 = i17;
                }
                if (file5 != null) {
                    zDelete = file5.delete();
                    File fileZza2 = zza(file5);
                    if (fileZza2.isFile()) {
                        zDelete = fileZza2.delete() & zDelete;
                    }
                }
            }
            if (!zDelete) {
                int i19 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to expire stream cache");
                zzq(str, null, "expireFailed", null);
                return false;
            }
            str3 = str4;
        }
        zzo(str, file.getAbsolutePath(), i2);
        zze.remove(strConcat);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
        this.zzh = true;
    }
}
