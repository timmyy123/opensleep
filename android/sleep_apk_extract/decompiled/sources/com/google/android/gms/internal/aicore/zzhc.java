package com.google.android.gms.internal.aicore;

import com.facebook.appevents.integrity.IntegrityManager;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhc {
    static final boolean zza;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzhb zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        boolean z;
        boolean z2;
        zzhb zzhbVar;
        Unsafe unsafeZzp = zzp();
        zzc = unsafeZzp;
        int i = zzdq.$r8$clinit;
        zzd = Memory.class;
        Class cls = Long.TYPE;
        boolean zZzq = zzq(cls);
        zze = zZzq;
        Class cls2 = Integer.TYPE;
        boolean zZzq2 = zzq(cls2);
        zzhb zzgzVar = null;
        if (unsafeZzp != null) {
            if (zZzq) {
                zzgzVar = new zzha(unsafeZzp);
            } else if (zZzq2) {
                zzgzVar = new zzgz(unsafeZzp);
            }
        }
        zzf = zzgzVar;
        if (zzgzVar == null) {
            z = false;
        } else {
            try {
                Class<?> cls3 = zzgzVar.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (zzy() != null) {
                    z = true;
                }
            } catch (Throwable th) {
                zzv(th);
            }
        }
        zzg = z;
        zzhb zzhbVar2 = zzf;
        if (zzhbVar2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls4 = zzhbVar2.zza.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                zzv(th2);
                z2 = false;
            }
        }
        zzh = z2;
        zzw(byte[].class);
        zzw(boolean[].class);
        zzx(boolean[].class);
        zzw(int[].class);
        zzx(int[].class);
        zzw(long[].class);
        zzx(long[].class);
        zzw(float[].class);
        zzx(float[].class);
        zzw(double[].class);
        zzx(double[].class);
        zzw(Object[].class);
        zzx(Object[].class);
        Field fieldZzy = zzy();
        if (fieldZzy != null && (zzhbVar = zzf) != null) {
            zzhbVar.zza.objectFieldOffset(fieldZzy);
        }
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static boolean zza() {
        return zzh;
    }

    public static boolean zzb() {
        return zzg;
    }

    public static Object zzc(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public static int zzd(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    public static void zze(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    public static long zzf(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    public static void zzg(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    public static boolean zzh(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    public static void zzi(Object obj, long j, boolean z) {
        zzf.zzb(obj, j, z);
    }

    public static float zzj(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    public static void zzk(Object obj, long j, float f) {
        zzf.zzd(obj, j, f);
    }

    public static double zzl(Object obj, long j) {
        return zzf.zze(obj, j);
    }

    public static void zzm(Object obj, long j, double d) {
        zzf.zzf(obj, j, d);
    }

    public static Object zzn(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static void zzo(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static Unsafe zzp() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgy());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzq(Class cls) {
        int i = zzdq.$r8$clinit;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & PHIpAddressSearchManager.END_IP_SCAN)) != 0;
    }

    public static /* synthetic */ boolean zzs(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & PHIpAddressSearchManager.END_IP_SCAN)) != 0;
    }

    public static /* synthetic */ void zzt(Object obj, long j, boolean z) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((z ? 1 : 0) << i2) | ((~(PHIpAddressSearchManager.END_IP_SCAN << i2)) & i));
    }

    public static /* synthetic */ void zzu(Object obj, long j, boolean z) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((z ? 1 : 0) << i) | ((~(PHIpAddressSearchManager.END_IP_SCAN << i)) & unsafe.getInt(obj, j2)));
    }

    public static /* synthetic */ void zzv(Throwable th) {
        Logger.getLogger(zzhc.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzw(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzdq.$r8$clinit;
        Field fieldZzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (fieldZzz != null) {
            return fieldZzz;
        }
        Field fieldZzz2 = zzz(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (fieldZzz2 == null || fieldZzz2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
