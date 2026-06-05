package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.home.platform.traits.ValidationIssue;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgha {
    private MessageDigest zza;
    private final zzgqh zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private SecureRandom zze;

    public zzgha(zzgqh zzgqhVar) {
        this.zzb = zzgqhVar;
    }

    public final void zza() {
        if (zzc()) {
            return;
        }
        zzb(new SecureRandom());
    }

    public final synchronized void zzb(SecureRandom secureRandom) {
        zzgqf zzgqfVarZza = this.zzb.zza(ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER);
        try {
            try {
                try {
                    zzgqfVarZza.zza();
                    this.zze = secureRandom;
                    this.zza = MessageDigest.getInstance("MD5");
                    this.zzd = true;
                } catch (Throwable th) {
                    zzgqfVarZza.zzb(th);
                    throw th;
                }
            } catch (NoSuchAlgorithmException e) {
                zzgqfVarZza.zzb(e);
            }
            zzgqfVarZza.zzc();
        } catch (Throwable th2) {
            zzgqfVarZza.zzc();
            throw th2;
        }
    }

    public final synchronized boolean zzc() {
        return this.zzd;
    }

    public final byte[] zzd(byte[] bArr, String str, boolean z) {
        int length = bArr.length;
        int i = true != z ? PHIpAddressSearchManager.END_IP_SCAN : 239;
        zzgtj.zza(length <= i);
        ByteBuffer byteBufferPut = ByteBuffer.allocate(i + 1).put((byte) length);
        if (length < i) {
            int i2 = i - length;
            byte[] bArr2 = new byte[i2];
            this.zze.nextBytes(bArr2);
            bArr = Arrays.copyOf(bArr, length + i2);
            System.arraycopy(bArr2, 0, bArr, length, i2);
        }
        byte[] bArrArray = byteBufferPut.put(bArr).array();
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzghd[] zzghdVarArr = new zzghq().zzcK;
        int length2 = zzghdVarArr.length;
        for (int i3 = 0; i3 < 12; i3++) {
            zzghdVarArr[i3].zza(bArrArray, bArr3);
        }
        if (!zzgua.zzc(str)) {
            new zzghc(str.length() > 32 ? str.substring(0, 32).getBytes(StandardCharsets.UTF_8) : str.getBytes(StandardCharsets.UTF_8)).zza(bArr3);
        }
        return bArr3;
    }

    public final byte[] zze(byte[] bArr) {
        byte[] bArrDigest;
        synchronized (this.zzc) {
            this.zza.reset();
            this.zza.update(bArr);
            bArrDigest = this.zza.digest();
        }
        return bArrDigest;
    }

    public final zzaze zzf(byte[] bArr, String str) {
        zzaze zzazeVarZza = zzazf.zza();
        byte[] bArrZze = zze(bArr);
        zzida zzidaVar = zzida.zza;
        zzazeVarZza.zzb(zzida.zzt(bArrZze, 0, bArrZze.length));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int length = bArr.length;
            if (i >= ((length - 1) / PHIpAddressSearchManager.END_IP_SCAN) + 1) {
                break;
            }
            int i2 = i * PHIpAddressSearchManager.END_IP_SCAN;
            int i3 = i2 + PHIpAddressSearchManager.END_IP_SCAN;
            if (length > i3) {
                length = i3;
            }
            arrayList.add(Arrays.copyOfRange(bArr, i2, length));
            i++;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzazeVarZza.zza(zzida.zzt(zzd((byte[]) it.next(), str, false), 0, 256));
        }
        return zzazeVarZza;
    }

    public final String zzg(int i, String str) {
        zzaxm zzaxmVarZzj = zzaym.zzj();
        zzaxmVarZzj.zzl(i);
        return Base64.encodeToString(zzd(((zzaym) zzaxmVarZzj.zzbm()).zzaN(), str, true), 11);
    }
}
