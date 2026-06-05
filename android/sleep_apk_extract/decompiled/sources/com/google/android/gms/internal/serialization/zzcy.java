package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcy {
    public static zzcy zzb(char c) {
        return new zzcx(c);
    }

    public abstract boolean zza(char c);

    public final int zzc(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (zza(charSequence.charAt(i2))) {
                i++;
            }
        }
        return i;
    }
}
