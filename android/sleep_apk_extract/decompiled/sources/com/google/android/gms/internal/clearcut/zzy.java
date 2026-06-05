package com.google.android.gms.internal.clearcut;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzy {
    private static HashMap<String, String> zzcu;
    private static Object zzcz;
    private static boolean zzda;
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzcq = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzcr = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzcs = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzct = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzcv = new HashMap<>();
    private static final HashMap<String, Integer> zzcw = new HashMap<>();
    private static final HashMap<String, Long> zzcx = new HashMap<>();
    private static final HashMap<String, Float> zzcy = new HashMap<>();
    private static String[] zzdb = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Object objZzb = zzb(contentResolver);
        long j2 = 0;
        Long lValueOf = (Long) zza((HashMap<String, long>) zzcx, str, 0L);
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        String strZza = zza(contentResolver, str, (String) null);
        if (strZza != null) {
            try {
                long j3 = Long.parseLong(strZza);
                lValueOf = Long.valueOf(j3);
                j2 = j3;
            } catch (NumberFormatException unused) {
            }
        }
        zza(objZzb, zzcx, str, lValueOf);
        return j2;
    }

    /* JADX WARN: Finally extract failed */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3;
        synchronized (zzy.class) {
            try {
                zza(contentResolver);
                Object obj = zzcz;
                if (!zzcu.containsKey(str)) {
                    for (String str4 : zzdb) {
                        if (str.startsWith(str4)) {
                            if (!zzda || zzcu.isEmpty()) {
                                zzcu.putAll(zza(contentResolver, zzdb));
                                zzda = true;
                                if (zzcu.containsKey(str) && (str3 = zzcu.get(str)) != null) {
                                    str = str3;
                                }
                            }
                        }
                    }
                    Cursor cursorQuery = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(1);
                                if (string != null && string.equals(null)) {
                                    string = null;
                                }
                                zza(obj, str, string);
                                str = string != null ? string : null;
                                cursorQuery.close();
                                return str;
                            }
                        } catch (Throwable th) {
                            if (cursorQuery == null) {
                                throw th;
                            }
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    zza(obj, str, (String) null);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                str3 = zzcu.get(str);
                if (str3 != null) {
                    str = str3;
                }
                return str;
            } finally {
            }
        }
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzy.class) {
            zza(contentResolver);
            obj = zzcz;
        }
        return obj;
    }

    private static <T> T zza(HashMap<String, T> map, String str, T t) {
        synchronized (zzy.class) {
            try {
                if (!map.containsKey(str)) {
                    return null;
                }
                T t2 = map.get(str);
                if (t2 != null) {
                    t = t2;
                }
                return t;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(zzcq, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery == null) {
            return treeMap;
        }
        while (cursorQuery.moveToNext()) {
            try {
                treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            } finally {
                cursorQuery.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzcu == null) {
            zzct.set(false);
            zzcu = new HashMap<>();
            zzcz = new Object();
            zzda = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzz(null));
            return;
        }
        if (zzct.getAndSet(false)) {
            zzcu.clear();
            zzcv.clear();
            zzcw.clear();
            zzcx.clear();
            zzcy.clear();
            zzcz = new Object();
            zzda = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzy.class) {
            try {
                if (obj == zzcz) {
                    zzcu.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> map, String str, T t) {
        synchronized (zzy.class) {
            try {
                if (obj == zzcz) {
                    map.put(str, t);
                    zzcu.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object objZzb = zzb(contentResolver);
        HashMap<String, Boolean> map = zzcv;
        Boolean bool = (Boolean) zza(map, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String strZza = zza(contentResolver, str, (String) null);
        if (strZza != null && !strZza.equals("")) {
            if (zzcr.matcher(strZza).matches()) {
                bool = Boolean.TRUE;
                z = true;
            } else if (zzcs.matcher(strZza).matches()) {
                bool = Boolean.FALSE;
                z = false;
            } else {
                Log.w("Gservices", FileInsert$$ExternalSyntheticOutline0.m("attempt to read gservices key ", str, " (value \"", strZza, "\") as boolean"));
            }
        }
        zza(objZzb, map, str, bool);
        return z;
    }
}
