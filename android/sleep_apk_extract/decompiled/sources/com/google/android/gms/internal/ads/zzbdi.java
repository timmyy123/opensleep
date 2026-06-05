package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbdi {
    public static String zza(Context context, String str, List list, Executor executor) throws PackageManager.NameNotFoundException, CertificateEncodingException {
        if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
            return null;
        }
        final zzhcp zzhcpVarZze = zzhcp.zze();
        context.getPackageManager().requestChecksums(str, false, 8, list, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzbdh
            public final /* synthetic */ void onChecksumsReady(List list2) {
                zzhcp zzhcpVar = zzhcpVarZze;
                if (list2 == null) {
                    zzhcpVar.zza((Object) null);
                    return;
                }
                try {
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        ApkChecksum apkChecksumM = zzbuy$$ExternalSyntheticBUOutline0.m(list2.get(i));
                        if (apkChecksumM.getType() == 8) {
                            zzhcpVar.zza(zzbbv.zza(apkChecksumM.getValue()));
                            return;
                        }
                    }
                    zzhcpVar.zza((Object) null);
                } catch (Throwable unused) {
                    zzhcpVar.zza((Object) null);
                }
            }
        });
        return (String) zzhcpVarZze.get();
    }
}
