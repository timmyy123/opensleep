package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzauh extends zzate {
    private final Object zza;
    private final zzatj zzb;

    public zzauh(int i, String str, zzatj zzatjVar, zzati zzatiVar) {
        super(i, str, zzatiVar);
        this.zza = new Object();
        this.zzb = zzatjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzate
    public final zzatk zzr(zzata zzataVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzataVar.zzb;
            Map map = zzataVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzataVar.zzb);
        }
        return zzatk.zza(str, zzaub.zza(zzataVar));
    }

    public void zzz(String str) {
        zzatj zzatjVar;
        synchronized (this.zza) {
            zzatjVar = this.zzb;
        }
        zzatjVar.zza(str);
    }
}
