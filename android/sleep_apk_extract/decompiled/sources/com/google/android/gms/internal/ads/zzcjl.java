package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.ads.AdError;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
final class zzcjl extends zzhh implements zzii {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc;
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzih zzg;
    private zzht zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private final Set zzr;

    public zzcjl(String str, zzin zzinVar, int i, int i2, int i3) {
        super(true);
        this.zzc = new zzcjk(this);
        this.zzr = new HashSet();
        zzdg.zza(str);
        this.zzf = str;
        this.zzg = new zzih();
        this.zzd = i;
        this.zze = i2;
        this.zzq = i3;
        if (zzinVar != null) {
            zze(zzinVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) throws zzie {
        try {
            if (this.zzo != this.zzm) {
                AtomicReference atomicReference = zzb;
                byte[] bArr2 = (byte[]) atomicReference.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        atomicReference.set(bArr2);
                        break;
                    }
                    int i3 = this.zzj.read(bArr2, 0, (int) Math.min(j2 - j, bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i3 == -1) {
                        throw new EOFException();
                    }
                    this.zzo += (long) i3;
                    zzh(i3);
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j4);
            }
            int i4 = this.zzj.read(bArr, i, i2);
            if (i4 == -1) {
                if (this.zzn == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzp += (long) i4;
            zzh(i4);
            return i4;
        } catch (IOException e) {
            throw new zzie(e, this.zzh, 2000, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x02b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00df A[Catch: IOException -> 0x0044, TryCatch #2 {IOException -> 0x0044, blocks: (B:3:0x000e, B:4:0x0025, B:6:0x002d, B:8:0x003b, B:11:0x0047, B:12:0x005f, B:14:0x0065, B:21:0x0092, B:23:0x00b2, B:24:0x00d1, B:25:0x00d6, B:27:0x00df, B:28:0x00e6, B:41:0x010f, B:94:0x0273, B:96:0x0280, B:98:0x0291, B:101:0x029a, B:102:0x02a7, B:104:0x02b1, B:105:0x02b8, B:106:0x02b9, B:107:0x02d6), top: B:114:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0280 A[Catch: IOException -> 0x0044, TryCatch #2 {IOException -> 0x0044, blocks: (B:3:0x000e, B:4:0x0025, B:6:0x002d, B:8:0x003b, B:11:0x0047, B:12:0x005f, B:14:0x0065, B:21:0x0092, B:23:0x00b2, B:24:0x00d1, B:25:0x00d6, B:27:0x00df, B:28:0x00e6, B:41:0x010f, B:94:0x0273, B:96:0x0280, B:98:0x0291, B:101:0x029a, B:102:0x02a7, B:104:0x02b1, B:105:0x02b8, B:106:0x02b9, B:107:0x02d6), top: B:114:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzb(zzht zzhtVar) throws zzie {
        long j;
        int responseCode;
        String headerField;
        long j2;
        long jMax;
        String headerField2;
        this.zzh = zzhtVar;
        long j3 = 0;
        this.zzp = 0L;
        this.zzo = 0L;
        try {
            URL url = new URL(zzhtVar.zza.toString());
            long j4 = zzhtVar.zze;
            long j5 = zzhtVar.zzf;
            boolean zZza = zzhtVar.zza(1);
            int i = 0;
            while (true) {
                int i2 = i + 1;
                long j6 = j3;
                if (i > 20) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 20);
                    sb.append("Too many redirects: ");
                    sb.append(i2);
                    throw new NoRouteToHostException(sb.toString());
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.zzc);
                }
                httpURLConnection.setConnectTimeout(this.zzd);
                httpURLConnection.setReadTimeout(this.zze);
                for (Map.Entry entry : this.zzg.zza().entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    j4 = j4;
                }
                long j7 = j4;
                if (j7 == j6) {
                    if (j5 != -1) {
                        j = j6;
                    }
                    httpURLConnection.setRequestProperty("User-Agent", this.zzf);
                    if (!zZza) {
                        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                        this.zzi = httpURLConnection;
                        try {
                            int responseCode2 = httpURLConnection.getResponseCode();
                            this.zzl = responseCode2;
                            if (responseCode2 < 200 || responseCode2 > 299) {
                                Map<String, List<String>> headerFields = this.zzi.getHeaderFields();
                                zzn();
                                zzig zzigVar = new zzig(this.zzl, null, null, headerFields, zzhtVar, zzfl.zzb);
                                if (this.zzl != 416) {
                                    throw zzigVar;
                                }
                                zzigVar.initCause(new zzhq(AdError.REMOTE_ADS_SERVICE_ERROR));
                                throw zzigVar;
                            }
                            if (responseCode2 == 200) {
                                j2 = zzhtVar.zze;
                                if (j2 == j6) {
                                    j2 = j6;
                                }
                            }
                            this.zzm = j2;
                            boolean zZza2 = zzhtVar.zza(1);
                            long j8 = zzhtVar.zzf;
                            if (zZza2 || j8 != -1) {
                                this.zzn = j8;
                            } else {
                                HttpURLConnection httpURLConnection2 = this.zzi;
                                String headerField3 = httpURLConnection2.getHeaderField("Content-Length");
                                if (TextUtils.isEmpty(headerField3)) {
                                    jMax = -1;
                                    headerField2 = httpURLConnection2.getHeaderField("Content-Range");
                                    if (!TextUtils.isEmpty(headerField2)) {
                                    }
                                    this.zzn = jMax != -1 ? jMax - this.zzm : -1L;
                                } else {
                                    try {
                                        jMax = Long.parseLong(headerField3);
                                    } catch (NumberFormatException unused) {
                                        String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(headerField3).length() + 28), "Unexpected Content-Length [", headerField3, "]");
                                        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                        com.google.android.gms.ads.internal.util.client.zzo.zzf(strM);
                                        jMax = -1;
                                    }
                                    headerField2 = httpURLConnection2.getHeaderField("Content-Range");
                                    if (!TextUtils.isEmpty(headerField2)) {
                                        Matcher matcher = zza.matcher(headerField2);
                                        if (matcher.find()) {
                                            try {
                                                long j9 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                                if (jMax < j6) {
                                                    jMax = j9;
                                                } else if (jMax != j9) {
                                                    StringBuilder sb2 = new StringBuilder(String.valueOf(headerField3).length() + 25 + String.valueOf(headerField2).length() + 1);
                                                    sb2.append("Inconsistent headers [");
                                                    sb2.append(headerField3);
                                                    sb2.append("] [");
                                                    sb2.append(headerField2);
                                                    sb2.append("]");
                                                    String string = sb2.toString();
                                                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
                                                    jMax = Math.max(jMax, j9);
                                                }
                                            } catch (NumberFormatException unused2) {
                                                String strM2 = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(headerField2).length() + 27), "Unexpected Content-Range [", headerField2, "]");
                                                int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzf(strM2);
                                            }
                                        }
                                    }
                                    this.zzn = jMax != -1 ? jMax - this.zzm : -1L;
                                }
                            }
                            try {
                                this.zzj = this.zzi.getInputStream();
                                this.zzk = true;
                                zzg(zzhtVar);
                                return this.zzn;
                            } catch (IOException e) {
                                zzn();
                                throw new zzie(e, zzhtVar, 2000, 1);
                            }
                        } catch (IOException e2) {
                            zzn();
                            throw new zzie("Unable to connect to ".concat(String.valueOf(zzhtVar.zza.toString())), e2, zzhtVar, 2000, 1);
                        }
                    }
                    headerField = httpURLConnection.getHeaderField("Location");
                    httpURLConnection.disconnect();
                    if (headerField != null) {
                        throw new ProtocolException("Null location redirect");
                    }
                    URL url2 = new URL(url, headerField);
                    String protocol2 = url2.getProtocol();
                    if (!TournamentShareDialogURIBuilder.scheme.equals(protocol2) && !"http".equals(protocol2)) {
                        throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol2)));
                    }
                    url = url2;
                    i = i2;
                    j4 = j7;
                    j3 = j6;
                } else {
                    j = j7;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(j).length() + 7);
                sb3.append("bytes=");
                sb3.append(j);
                sb3.append("-");
                String string2 = sb3.toString();
                if (j5 != -1) {
                    long j10 = (j + j5) - 1;
                    StringBuilder sb4 = new StringBuilder(string2.length() + String.valueOf(j10).length());
                    sb4.append(string2);
                    sb4.append(j10);
                    string2 = sb4.toString();
                }
                httpURLConnection.setRequestProperty("Range", string2);
                httpURLConnection.setRequestProperty("User-Agent", this.zzf);
                if (!zZza) {
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 300) {
                }
                headerField = httpURLConnection.getHeaderField("Location");
                httpURLConnection.disconnect();
                if (headerField != null) {
                }
            }
        } catch (IOException e3) {
            throw new zzie("Unable to connect to ".concat(String.valueOf(zzhtVar.zza.toString())), e3, zzhtVar, 2000, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzie(e, this.zzh, 2000, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzi();
            }
            this.zzr.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final void zzk(int i) {
        this.zzq = i;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    public final /* synthetic */ void zzl(Socket socket) {
        this.zzr.add(socket);
    }

    public final /* synthetic */ int zzm() {
        return this.zzq;
    }
}
