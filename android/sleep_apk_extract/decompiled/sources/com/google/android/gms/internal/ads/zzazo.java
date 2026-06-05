package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzazo {
    static boolean zza = false;
    private static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();
    static final CountDownLatch zzb = new CountDownLatch(1);

    public static void zza() {
        synchronized (zzf) {
            try {
                if (!zza) {
                    zza = true;
                    new Thread(new zzazn(null)).start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String zzb(byte[] bArr, String str) {
        zzaze zzazeVarZzc = zzc(bArr, str);
        return zzazi.zza(zzazeVarZzc == null ? zzh(zzg(4096).zzaN(), str, true) : ((zzazf) zzazeVarZzc.zzbm()).zzaN(), true);
    }

    public static zzaze zzc(byte[] bArr, String str) {
        Vector vectorZzd = zzd(bArr, PHIpAddressSearchManager.END_IP_SCAN);
        if (vectorZzd == null || vectorZzd.isEmpty()) {
            return null;
        }
        zzaze zzazeVarZza = zzazf.zza();
        int size = vectorZzd.size();
        for (int i = 0; i < size; i++) {
            zzazeVarZza.zza(zzida.zzt(zzh((byte[]) vectorZzd.get(i), str, false), 0, 256));
        }
        byte[] bArrZze = zze(bArr);
        zzida zzidaVar = zzida.zza;
        zzazeVarZza.zzb(zzida.zzt(bArrZze, 0, bArrZze.length));
        return zzazeVarZza;
    }

    public static Vector zzd(byte[] bArr, int i) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i2 = length + 254;
        Vector vector = new Vector();
        for (int i3 = 0; i3 < i2 / PHIpAddressSearchManager.END_IP_SCAN; i3++) {
            int i4 = i3 * PHIpAddressSearchManager.END_IP_SCAN;
            try {
                int length2 = bArr.length;
                if (length2 - i4 > 255) {
                    length2 = i4 + PHIpAddressSearchManager.END_IP_SCAN;
                }
                vector.add(Arrays.copyOfRange(bArr, i4, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static byte[] zze(byte[] bArr) {
        byte[] bArrDigest;
        MessageDigest messageDigest;
        synchronized (zze) {
            try {
                zza();
                MessageDigest messageDigest2 = null;
                try {
                    if (zzb.await(2L, TimeUnit.SECONDS) && (messageDigest = zzd) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                bArrDigest = zzd.digest();
            } finally {
            }
        }
        return bArrDigest;
    }

    public static zzaym zzg(int i) {
        zzaxm zzaxmVarZzj = zzaym.zzj();
        zzaxmVarZzj.zzl(4096L);
        return (zzaym) zzaxmVarZzj.zzbm();
    }

    private static byte[] zzh(byte[] bArr, String str, boolean z) {
        byte[] bArrArray;
        int length = bArr.length;
        int i = true != z ? PHIpAddressSearchManager.END_IP_SCAN : 239;
        if (length > i) {
            bArr = zzg(4096).zzaN();
        }
        int i2 = i + 1;
        int length2 = bArr.length;
        byte b = (byte) length2;
        if (length2 < i) {
            byte[] bArr2 = new byte[i - length2];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i2).put(b).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i2).put(b).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzazp[] zzazpVarArr = new zzbac().zzcK;
        int length3 = zzazpVarArr.length;
        for (int i3 = 0; i3 < 12; i3++) {
            zzazpVarArr[i3].zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzazg(str.getBytes(OAuth.ENCODING)).zza(bArr3);
        }
        return bArr3;
    }
}
