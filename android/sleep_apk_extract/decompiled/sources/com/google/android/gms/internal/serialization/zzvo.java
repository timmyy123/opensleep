package com.google.android.gms.internal.serialization;

import android.util.Base64;
import com.google.home.HomeException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/base64/Base64;", "", "<init>", "()V", "encode", "", "data", "", "decode", "encodedString", "java.com.google.nest.platform.mesh.serialization.base64_base64-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class zzvo {
    public static final byte[] zza(String str) throws HomeException {
        str.getClass();
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            bArrDecode.getClass();
            return bArrDecode;
        } catch (Exception unused) {
            throw HomeException.INSTANCE.invalidArgument("Failed to decode base64 string: ".concat(String.valueOf(str)));
        }
    }

    public static final String zzb(byte[] bArr) {
        bArr.getClass();
        String strEncodeToString = Base64.encodeToString(bArr, 2);
        strEncodeToString.getClass();
        return strEncodeToString;
    }
}
