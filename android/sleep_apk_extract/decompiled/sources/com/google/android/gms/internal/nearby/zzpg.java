package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzpg implements zzpb {
    private final AtomicBoolean zza = new AtomicBoolean();
    private HashMap zzb = null;
    private final HashMap zzc = new HashMap(16, 1.0f);
    private final HashMap zzd = new HashMap(16, 1.0f);
    private final HashMap zze = new HashMap(16, 1.0f);
    private final HashMap zzf = new HashMap(16, 1.0f);
    private Object zzg = null;
    private boolean zzh = false;
    private final String[] zzi = new String[0];
    private final zzpe zzj = new zzpe();

    private final void zzc(ContentResolver contentResolver) {
        HashMap map = this.zzb;
        AtomicBoolean atomicBoolean = this.zza;
        if (map == null) {
            atomicBoolean.set(false);
            this.zzb = new HashMap(16, 1.0f);
            this.zzg = new Object();
            contentResolver.registerContentObserver(zzpa.zza, true, new zzpd(this, null));
            return;
        }
        if (atomicBoolean.getAndSet(false)) {
            this.zzb.clear();
            this.zzc.clear();
            this.zzd.clear();
            this.zze.clear();
            this.zzf.clear();
            this.zzg = new Object();
            this.zzh = false;
        }
    }

    private static final ContentResolver zzd(ContentResolver contentResolver) {
        if (contentResolver != null) {
            return contentResolver;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("ContentResolver needed with GservicesDelegateSupplier.init()");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.nearby.zzpb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object obj;
        String str2;
        Boolean bool;
        boolean z2;
        Cursor cursorQuery;
        String string;
        zzd(contentResolver);
        synchronized (this) {
            try {
                zzc(contentResolver);
                obj = this.zzg;
                HashMap map = this.zzc;
                Object obj2 = Boolean.TRUE;
                str2 = null;
                if (map.containsKey("gms:nearby:requires_gms_check")) {
                    Object obj3 = map.get("gms:nearby:requires_gms_check");
                    if (obj3 != null) {
                        obj2 = obj3;
                    }
                } else {
                    obj2 = null;
                }
                bool = (Boolean) obj2;
            } finally {
            }
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        zzd(contentResolver);
        synchronized (this) {
            try {
                zzc(contentResolver);
                Object obj4 = this.zzg;
                z2 = true;
                if (this.zzb.containsKey("gms:nearby:requires_gms_check")) {
                    String str3 = (String) this.zzb.get("gms:nearby:requires_gms_check");
                    if (str3 != null) {
                        str2 = str3;
                    }
                } else {
                    try {
                        cursorQuery = contentResolver.query(zzpa.zza, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                    } catch (zzpf unused) {
                    }
                    try {
                        if (cursorQuery == null) {
                            throw new zzpf("Failed to connect to GservicesProvider");
                        }
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(1);
                            cursorQuery.close();
                        } else {
                            cursorQuery.close();
                            string = null;
                        }
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        synchronized (this) {
                            try {
                                if (obj4 == this.zzg) {
                                    this.zzb.put("gms:nearby:requires_gms_check", string);
                                }
                            } finally {
                            }
                        }
                        if (string != null) {
                            str2 = string;
                        }
                    } finally {
                        if (str2 != null) {
                            if (!zzpa.zzc.matcher(str2).matches()) {
                            }
                        }
                        synchronized (this) {
                        }
                    }
                }
            } finally {
            }
        }
        if (str2 != null && !str2.isEmpty()) {
            if (!zzpa.zzc.matcher(str2).matches()) {
                bool = Boolean.TRUE;
            } else if (zzpa.zzd.matcher(str2).matches()) {
                bool = Boolean.FALSE;
                z2 = false;
            } else {
                Log.w("Gservices", "attempt to read Gservices key gms:nearby:requires_gms_check (value \"" + str2 + "\") as boolean");
            }
        }
        synchronized (this) {
            try {
                HashMap map2 = this.zzc;
                if (obj == this.zzg) {
                    map2.put("gms:nearby:requires_gms_check", bool);
                    this.zzb.remove("gms:nearby:requires_gms_check");
                }
            } finally {
            }
        }
        return z2;
    }
}
