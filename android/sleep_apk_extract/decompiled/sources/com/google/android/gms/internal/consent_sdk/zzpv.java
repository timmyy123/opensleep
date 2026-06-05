package com.google.android.gms.internal.consent_sdk;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzpv extends zzpe {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Logger zza = Logger.getLogger(zzpv.class.getName());
    private static final boolean zzb = zzsw.zzx();
    Object zze;

    public /* synthetic */ zzpv(zzpu zzpuVar) {
    }

    public static int zzA(zzrq zzrqVar) {
        int iZzn = zzrqVar.zzn();
        return zzC(iZzn) + iZzn;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzsy.zzb(str);
        } catch (zzsx unused) {
            length = str.getBytes(zzqs.zza).length;
        }
        return zzC(length) + length;
    }

    public static int zzC(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzD(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void zzE(String str, zzsx zzsxVar) throws zzps {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzsxVar);
        byte[] bytes = str.getBytes(zzqs.zza);
        try {
            int length = bytes.length;
            zzw(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzps(e);
        }
    }

    public abstract void zzJ(byte b);

    public abstract void zzK(int i, boolean z);

    public abstract void zzL(byte[] bArr, int i, int i2);

    @Override // com.google.android.gms.internal.consent_sdk.zzpe
    public abstract void zza(byte[] bArr, int i, int i2);

    public abstract void zzh(int i, zzpm zzpmVar);

    public abstract void zzi(zzpm zzpmVar);

    public abstract void zzj(int i, int i2);

    public abstract void zzk(int i);

    public abstract void zzl(int i, long j);

    public abstract void zzm(long j);

    public abstract void zzn(int i, int i2);

    public abstract void zzo(int i);

    public abstract void zzp(zzrq zzrqVar);

    public abstract void zzs(int i, String str);

    public abstract void zzt(String str);

    public abstract void zzu(int i, int i2);

    public abstract void zzv(int i, int i2);

    public abstract void zzw(int i);

    public abstract void zzx(int i, long j);

    public abstract void zzy(long j);
}
