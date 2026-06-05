package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.boxes.threegpp.ts26244.AuthorBox;

/* JADX INFO: loaded from: classes3.dex */
public class zzatt implements zzasx {
    protected final zzatv zza;
    private final zzats zzb;

    public zzatt(zzats zzatsVar) {
        zzatv zzatvVar = new zzatv(4096);
        this.zzb = zzatsVar;
        this.zza = zzatvVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d1  */
    @Override // com.google.android.gms.internal.ads.zzasx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzata zza(zzate zzateVar) throws Throwable {
        zzata zzataVar;
        zzauc zzaucVarZza;
        byte[] bArr;
        zzatn zzaszVar;
        String str;
        int iZzo;
        Map map;
        byte[] byteArray;
        byte[] bArrZza;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            try {
                zzasn zzasnVarZzk = zzateVar.zzk();
                if (zzasnVarZzk == null) {
                    map = Collections.EMPTY_MAP;
                } else {
                    HashMap map2 = new HashMap();
                    String str2 = zzasnVarZzk.zzb;
                    if (str2 != null) {
                        map2.put("If-None-Match", str2);
                    }
                    long j = zzasnVarZzk.zzd;
                    if (j > 0) {
                        map2.put("If-Modified-Since", zzaub.zzc(j));
                    }
                    map = map2;
                }
                zzaucVarZza = this.zzb.zza(zzateVar, map);
                try {
                    int iZza = zzaucVarZza.zza();
                    List listZzb = zzaucVarZza.zzb();
                    if (iZza == 304) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        zzasn zzasnVarZzk2 = zzateVar.zzk();
                        if (zzasnVarZzk2 == null) {
                            return new zzata(304, (byte[]) null, true, jElapsedRealtime2, listZzb);
                        }
                        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                        if (!listZzb.isEmpty()) {
                            Iterator it = listZzb.iterator();
                            while (it.hasNext()) {
                                treeSet.add(((zzasw) it.next()).zza());
                            }
                        }
                        ArrayList arrayList = new ArrayList(listZzb);
                        List list = zzasnVarZzk2.zzh;
                        if (list != null) {
                            if (!list.isEmpty()) {
                                for (zzasw zzaswVar : zzasnVarZzk2.zzh) {
                                    if (!treeSet.contains(zzaswVar.zza())) {
                                        arrayList.add(zzaswVar);
                                    }
                                }
                            }
                        } else if (!zzasnVarZzk2.zzg.isEmpty()) {
                            for (Map.Entry entry : zzasnVarZzk2.zzg.entrySet()) {
                                if (!treeSet.contains(entry.getKey())) {
                                    arrayList.add(new zzasw((String) entry.getKey(), (String) entry.getValue()));
                                }
                            }
                        }
                        return new zzata(304, zzasnVarZzk2.zza, true, jElapsedRealtime2, (List) arrayList);
                    }
                    InputStream inputStreamZzd = zzaucVarZza.zzd();
                    if (inputStreamZzd != null) {
                        int iZzc = zzaucVarZza.zzc();
                        zzatv zzatvVar = this.zza;
                        zzaug zzaugVar = new zzaug(zzatvVar, iZzc);
                        try {
                            bArrZza = zzatvVar.zza(1024);
                            while (true) {
                                try {
                                    int i = inputStreamZzd.read(bArrZza);
                                    zzataVar = null;
                                    if (i == -1) {
                                        break;
                                    }
                                    try {
                                        zzaugVar.write(bArrZza, 0, i);
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            inputStreamZzd.close();
                                        } catch (IOException unused) {
                                            zzatq.zza("Error occurred when closing InputStream", new Object[0]);
                                        }
                                        zzatvVar.zzb(bArrZza);
                                        zzaugVar.close();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    zzataVar = null;
                                }
                            }
                            byteArray = zzaugVar.toByteArray();
                            try {
                                try {
                                    inputStreamZzd.close();
                                } catch (IOException unused2) {
                                    zzatq.zza("Error occurred when closing InputStream", new Object[0]);
                                }
                                zzatvVar.zzb(bArrZza);
                                zzaugVar.close();
                            } catch (IOException e) {
                                e = e;
                                bArr = zzataVar;
                                if (!(e instanceof SocketTimeoutException)) {
                                }
                                zzass zzassVarZzy = zzateVar.zzy();
                                iZzo = zzateVar.zzo();
                                try {
                                    zzassVarZzy.zzc(zzaszVar);
                                    zzateVar.zzc(str + "-retry [timeout=" + iZzo + "]");
                                } catch (zzatn e2) {
                                    zzateVar.zzc(str + "-timeout-giveup [timeout=" + iZzo + "]");
                                    throw e2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            zzataVar = null;
                            bArrZza = null;
                        }
                    } else {
                        zzataVar = null;
                        byteArray = new byte[0];
                    }
                    byte[] bArr2 = byteArray;
                    try {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (zzatq.zzb || jElapsedRealtime3 > 3000) {
                            zzatq.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", zzateVar, Long.valueOf(jElapsedRealtime3), bArr2 != null ? Integer.valueOf(bArr2.length) : "null", Integer.valueOf(iZza), Integer.valueOf(zzateVar.zzy().zzb()));
                        }
                        if (iZza < 200 || iZza > 299) {
                            throw new IOException();
                        }
                        return new zzata(iZza, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listZzb);
                    } catch (IOException e3) {
                        e = e3;
                        bArr = bArr2;
                        if (!(e instanceof SocketTimeoutException)) {
                            zzaszVar = new zzatm();
                            str = "socket";
                        } else {
                            if (e instanceof MalformedURLException) {
                                Utf8$$ExternalSyntheticBUOutline0.m("Bad URL ".concat(String.valueOf(zzateVar.zzh())), (Throwable) e);
                                return zzataVar;
                            }
                            if (zzaucVarZza == null) {
                                throw new zzatb(e);
                            }
                            int iZza2 = zzaucVarZza.zza();
                            zzatq.zzc("Unexpected response code %d for %s", Integer.valueOf(iZza2), zzateVar.zzh());
                            if (bArr != 0) {
                                zzata zzataVar2 = new zzata(iZza2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaucVarZza.zzb());
                                if (iZza2 != 401 && iZza2 != 403) {
                                    if (iZza2 < 400 || iZza2 > 499) {
                                        throw new zzatl(zzataVar2);
                                    }
                                    throw new zzasr(zzataVar2);
                                }
                                zzaszVar = new zzasm(zzataVar2);
                                str = AuthorBox.TYPE;
                            } else {
                                zzaszVar = new zzasz();
                                str = "network";
                            }
                        }
                        zzass zzassVarZzy2 = zzateVar.zzy();
                        iZzo = zzateVar.zzo();
                        zzassVarZzy2.zzc(zzaszVar);
                        zzateVar.zzc(str + "-retry [timeout=" + iZzo + "]");
                    }
                } catch (IOException e4) {
                    e = e4;
                    zzataVar = null;
                }
            } catch (IOException e5) {
                e = e5;
                zzataVar = null;
                zzaucVarZza = null;
                bArr = 0;
            }
            zzateVar.zzc(str + "-retry [timeout=" + iZzo + "]");
        }
    }
}
