package com.google.android.gms.internal.play_billing;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzbw {
    public static int zza(int i, String str) {
        if (i >= 0) {
            return i;
        }
        Gson$$ExternalSyntheticBUOutline0.m(str, " cannot be negative but was: ", i);
        return 0;
    }

    public static void zzb(Object obj, Object obj2) {
        if (obj == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("null key in entry: null=".concat(String.valueOf(obj2)));
        } else {
            if (obj2 != null) {
                return;
            }
            Types$$ExternalSyntheticBUOutline0.m$1(FileInsert$$ExternalSyntheticOutline0.m("null value in entry: ", obj.toString(), "=null"));
        }
    }
}
