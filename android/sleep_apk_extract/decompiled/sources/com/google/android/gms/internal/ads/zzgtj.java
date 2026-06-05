package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgtj {
    public static void zza(boolean z) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
    }

    public static void zzb(boolean z, Object obj) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((String) obj);
    }

    public static void zzc(boolean z, String str, char c) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzgua.zzd(str, Character.valueOf(c)));
    }

    public static void zzd(boolean z, String str, int i) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzgua.zzd(str, Integer.valueOf(i)));
    }

    public static void zze(boolean z, String str, long j) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzgua.zzd(str, Long.valueOf(j)));
    }

    public static void zzf(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzgua.zzd(str, obj));
    }

    public static void zzg(boolean z, String str, int i, int i2) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzgua.zzd(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static void zzh(boolean z, String str, Object obj, Object obj2) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzgua.zzd(str, obj, obj2));
    }

    public static void zzi(boolean z) {
        if (z) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
    }

    public static void zzj(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static Object zzk(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        Types$$ExternalSyntheticBUOutline0.m$1((String) obj2);
        return null;
    }

    public static Object zzl(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        Types$$ExternalSyntheticBUOutline0.m$1(zzgua.zzd(str, obj2));
        return null;
    }

    public static int zzm(int i, int i2, String str) {
        String strZzd;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZzd = zzgua.zzd("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(i2, "negative size: ", new StringBuilder(String.valueOf(i2).length() + 15)));
                return 0;
            }
            strZzd = zzgua.zzd("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZzd);
    }

    public static int zzn(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        Events$$ExternalSyntheticBUOutline0.m$2(zzp(i, i2, "index"));
        return 0;
    }

    public static void zzo(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? zzp(i, i3, "start index") : (i2 < 0 || i2 > i3) ? zzp(i2, i3, "end index") : zzgua.zzd("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    private static String zzp(int i, int i2, String str) {
        if (i < 0) {
            return zzgua.zzd("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzgua.zzd("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(i2, "negative size: ", new StringBuilder(String.valueOf(i2).length() + 15)));
        return null;
    }
}
