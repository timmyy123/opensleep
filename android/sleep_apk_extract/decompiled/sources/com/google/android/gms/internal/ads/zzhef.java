package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhef {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzhee zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m(it);
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
