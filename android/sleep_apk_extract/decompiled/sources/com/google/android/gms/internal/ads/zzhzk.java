package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhzk {
    private static final Charset zza = Charset.forName(OAuth.ENCODING);

    public static byte[] zza(String str, int i) {
        byte[] bytes = str.getBytes(zza);
        int length = bytes.length;
        zzhzj zzhzjVar = new zzhzj(2, new byte[(length * 3) / 4]);
        if (!zzhzjVar.zza(bytes, 0, length, true)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("bad base-64");
            return null;
        }
        int i2 = zzhzjVar.zzb;
        byte[] bArr = zzhzjVar.zza;
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }
}
