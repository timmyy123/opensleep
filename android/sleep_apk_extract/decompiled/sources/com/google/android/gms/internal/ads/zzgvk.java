package com.google.android.gms.internal.ads;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgvk {
    public static boolean zza(Collection collection, Object obj) {
        collection.getClass();
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
