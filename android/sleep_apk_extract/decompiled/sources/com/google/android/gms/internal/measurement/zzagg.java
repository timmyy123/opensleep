package com.google.android.gms.internal.measurement;

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
abstract class zzagg {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzagf zzf;
    private static final boolean zzg;

    static {
        boolean z;
        zzagf zzagfVar;
        Unsafe unsafeZzp = zzp();
        zzc = unsafeZzp;
        int i = zzacf.$r8$clinit;
        zzd = Memory.class;
        Class cls = Long.TYPE;
        boolean zZzq = zzq(cls);
        zze = zZzq;
        Class cls2 = Integer.TYPE;
        boolean zZzq2 = zzq(cls2);
        zzagf zzagdVar = null;
        if (unsafeZzp != null) {
            if (zZzq) {
                zzagdVar = new zzage(unsafeZzp);
            } else if (zZzq2) {
                zzagdVar = new zzagd(unsafeZzp);
            }
        }
        zzf = zzagdVar;
        if (zzagdVar != null) {
            try {
                Class<?> cls3 = zzagdVar.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                zzA();
            } catch (Throwable th) {
                zzx(th);
            }
        }
        zzagf zzagfVar2 = zzf;
        if (zzagfVar2 == null) {
            z = false;
        } else {
            try {
                Class<?> cls4 = zzagfVar2.zza.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z = true;
            } catch (Throwable th2) {
                zzx(th2);
                z = false;
            }
        }
        zzg = z;
        zza = zzy(byte[].class);
        zzy(boolean[].class);
        zzz(boolean[].class);
        zzy(int[].class);
        zzz(int[].class);
        zzy(long[].class);
        zzz(long[].class);
        zzy(float[].class);
        zzz(float[].class);
        zzy(double[].class);
        zzz(double[].class);
        zzy(Object[].class);
        zzz(Object[].class);
        Field fieldZzA = zzA();
        if (fieldZzA != null && (zzagfVar = zzf) != null) {
            zzagfVar.zza.objectFieldOffset(fieldZzA);
        }
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private static Field zzA() {
        int i = zzacf.$r8$clinit;
        Field fieldZzB = zzB(Buffer.class, "effectiveDirectAddress");
        if (fieldZzB != null) {
            return fieldZzB;
        }
        Field fieldZzB2 = zzB(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (fieldZzB2 == null || fieldZzB2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzB2;
    }

    private static Field zzB(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzC(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i2) | (i & (~(PHIpAddressSearchManager.END_IP_SCAN << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i) | (unsafe.getInt(obj, j2) & (~(PHIpAddressSearchManager.END_IP_SCAN << i))));
    }

    public static boolean zza() {
        return zzg;
    }

    public static Object zzb(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public static int zzc(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    public static void zzd(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    public static long zze(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    public static void zzf(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    public static boolean zzg(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static void zzh(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static float zzi(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    public static void zzj(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    public static double zzk(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    public static void zzl(Object obj, long j, double d) {
        zzf.zzg(obj, j, d);
    }

    public static Object zzm(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static void zzn(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static void zzo(byte[] bArr, long j, byte b) {
        zzf.zza(bArr, zza + j, b);
    }

    public static Unsafe zzp() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzagc());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(zzagg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "getUnsafe", "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    public static boolean zzq(Class cls) {
        int i = zzacf.$r8$clinit;
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

    public static /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & PHIpAddressSearchManager.END_IP_SCAN)) != 0;
    }

    public static /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & PHIpAddressSearchManager.END_IP_SCAN)) != 0;
    }

    public static /* synthetic */ void zzx(Throwable th) {
        Logger.getLogger(zzagg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzy(Class cls) {
        if (zzg) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzz(Class cls) {
        if (zzg) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }
}
